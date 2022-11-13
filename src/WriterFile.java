import java.io.*;
import java.util.ArrayList;

public class WriterFile {
    static ArrayList<String> listOfInn = new ArrayList<>();
    public static void start() {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("C:\\Users\\Vika\\Desktop\\Новая папка\\ИНН.txt"))));
            for (int i = 0; i < listOfInn.size(); i++) {
                writer.write(listOfInn.get(i)+"\n");
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
