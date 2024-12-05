
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;



// Remove text Write a program that removes all the occurrences of a specified
// string from a text file. For example, invoking
// java Exercise12_11 John filename
// removes the string John from the specified file. Your program should get the
// arguments from the command line









class Assignment11 {
    public static void main(String[] args) throws IOException {
        // Null writer
        Writer writer = null;
        // Null scanner
        Scanner scanner = null;
        // Initialize empty content string 
        String content = "";

        try {
            // Create a file object 
            File filePath = new File(args[args.length - 1]);
            
            // Create scanner object 
            scanner = new Scanner(filePath);
            // Get the content of the file
            while (scanner.hasNextLine()){

                String data = String.format("%s %s", content.trim(), scanner.nextLine());

                content = data;
            }
            // Remove the keyword from the content of the file
            String replacedContent = content.replaceAll(args[0], "");

            // Write the new contents to the file 
            writer = new FileWriter(filePath);
            writer.write(replacedContent);

        } catch (FileNotFoundException e) {
            
        } finally {
            if (scanner != null){
                scanner.close();
            }
            if (writer != null){
                writer.close();
            }
        }
    }
}