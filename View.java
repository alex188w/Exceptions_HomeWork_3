import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class View {
    public static String inputData(String message) {
        System.out.print(message);
        String data = " ";
        Scanner in = new Scanner(System.in, "cp866");
        try {
            data = in.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            in.close();
        }
        return data;
    }
    // public static String inputUser(String message) {
    //     System.out.print(message);
    //     String user = " ";
    //     Scanner in = new Scanner(System.in, "cp866");
    //     try {
    //         user = in.nextLine();
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //         in.close();
    //     }
    //     return user;
    // }

    public static void saveFromFile(UserModel user) {        
        String fileName = user.getFirstName();

        try (FileWriter writer = new FileWriter(String.format("%s.db", fileName), true)) {
            writer.write(user.toString() + '\n');            
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
            e.printStackTrace();
        }
    }

    public static void loadFromFile(String fileName) {
        try (FileReader fr = new FileReader(String.format("%s.db", fileName))) {
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
