public class Request {
    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Vika\\Desktop\\библиотеки\\geckodriver.exe");
        ReaderFile.start();
        WebDriverWorker webDriverWorker = new WebDriverWorker();
Thread thread = new Thread(webDriverWorker);
thread.start();
        //view-source://view-source:
    }
}

