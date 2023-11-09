import java.io.*;
public class File {
    String filePath = "src/input2.txt";
    void ReadFile()
    {
        try {
            // Read file line by line
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void WriteFile(String[] content)
    {

        try {
            BufferedWriter  writer= new BufferedWriter(new FileWriter(filePath));
            for (String line : content) {
                writer.write(line);
                writer.newLine();  // This writes a newline
            }
            writer.close();
        } catch (IOException e) {
          System.err.println(e);
        }
    }
}
