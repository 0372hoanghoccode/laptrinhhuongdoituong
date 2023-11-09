import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File {
    String filePath = "src/";
    List<String> ReadFile(String filename)
    {
        List<String> data=new ArrayList<>();
        filePath+=filename;
        try {
            // Read file line by line
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {

                data.add(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
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
