import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class WebDriverWorker extends Thread {

    WebDriver driver = new FirefoxDriver();

    public void run () {

        driver.get("https://service.nalog.ru/inn.do");
        WebElement searchField = driver.findElement(By.id("personalData"));
        searchField.submit();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            for (int i=0; i<ReaderFile.listOfPeople.size(); i++){
                String [] str = ReaderFile.listOfPeople.get(i).split("\t");
                sendChar(driver.findElement(By.id("fam")), str[0]);
                sendChar(driver.findElement(By.id("nam")), str[1]);
                sendChar(driver.findElement(By.id("otch")), str[2]);
                sendChar(driver.findElement(By.id("bdate")), str[3]);
                sendChar(driver.findElement(By.id("docno")), str[4]);
                driver.findElement(By.id("btn_send")).submit();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

try{
    new Actions(driver).moveToElement(driver.findElement(By.id("resultInn"))).doubleClick().build().perform();
    Robot robot = null;
    try {
        robot = new Robot();
    } catch (AWTException e) {
        e.printStackTrace();
    }
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_C);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_C);
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    String data = null;
    try {
        data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    } catch (UnsupportedFlavorException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println(data);
    WriterFile.listOfInn.add(data);
}catch (Exception e){
System.out.println("null");
WriterFile.listOfInn.add("null");}
            }

            driver.quit();

            WriterFile.start();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sendChar (WebElement element, String value) throws InterruptedException {
        element.clear();

        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
            Thread.sleep(40);
        }
    }
}


