import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReaderFile {
    static String path = "C:\\Users\\Vika\\Desktop\\Новая папка\\проверка ИНН.txt";
    static ArrayList<String> listOfPeople = new ArrayList<>();

    public static void start(){
        try {
            Scanner scanner = new Scanner(new FileReader(path));
            while (scanner.hasNext()) {
                listOfPeople.add(scanner.nextLine());
            }
            new FileReader(path).close();
            scanner.close();
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла");
        }
    }
}
