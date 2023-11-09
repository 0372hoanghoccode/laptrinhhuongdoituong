import java.io.*;
public class File {
    String filePath = "src/";
    void ReadFile(String filename)
    {
        filePath+=filename;
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
    void WriteFile(String[] content,String filename)
    {
        filePath+=filename;

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
