package module4.lesson6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class NewNIOExample {
    public static void main(String[] args) throws IOException {
        File file = new File("files/no_existing_file.txt");
        boolean result = file.delete();
        System.out.println(result);

        Path path = Paths.get("files/no_existing_file.txt");
        Files.delete(path);
        Files.copy(
                new FileInputStream(""),
                Paths.get("asdasd.png"),
                StandardCopyOption.REPLACE_EXISTING
        );
        try {
            File file2 = new File("files/readme.txt");
            FileReader fileReader = new FileReader(file2);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> strings = bufferedReader.lines().toList();
            String fileData = "";
            for ( String string : strings ) {
                fileData = fileData + "\n" + string;
            }
            System.out.println(fileData);

            // Files.readString(Paths.get("sdf"));

        } catch (IOException e) {
        }

    }
}
