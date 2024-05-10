import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Activity14 {
    public static void main(String[] args) {
        try {
            // Create a new text file using the default File Class
            File file = new File("example.txt");

            // Use the createNewFile() method to create a file
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            // Write some text into the text file
            FileWriter writer = new FileWriter(file);
            writer.write("Better to fight and fall than to live without hope.");
            writer.close();

            // Use FileUtils.getFile() method to get the file object
            File inputFile = FileUtils.getFile("example.txt");

            // To read the file, use the readFileToString() method
            String fileContent = FileUtils.readFileToString(inputFile);
            System.out.println("File content:\n" + fileContent);

            // Create a new directory named resources
            File directory = new File("resources");
            if (!directory.exists()) {
                directory.mkdir();
                System.out.println("Directory created: " + directory.getName());
            } else {
                System.out.println("Directory already exists.");
            }

            // Copy the text file into the resources directory using the copyFileToDirectory() method
            FileUtils.copyFileToDirectory(inputFile, directory);
            System.out.println("File copied to directory: " + directory.getName());

            // To read data from this new file using FileUtils class
            File copiedFile = FileUtils.getFile(directory, "example.txt");
            String copiedFileContent = FileUtils.readFileToString(copiedFile);
            System.out.println("Copied file content:\n" + copiedFileContent);

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
