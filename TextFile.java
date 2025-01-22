import java.io.*;

public class TextFile{
    
    public static void readFileLineByLine(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    
    public static void readFileAsString(String filePath) {
        try {
            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append(System.lineSeparator());
                }
            }
            System.out.println(content.toString());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a file path.");
            return;
        }
        String filePath = args[0];
        System.out.println("Reading file line by line:");
        readFileLineByLine(filePath);

        System.out.println("\nReading entire file as a string:");
        readFileAsString(filePath);
    }
}
