import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File {
    String filePath = "src/textdata/";
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
    void WriteFile(List<String> content,String filename)
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
    void WriteNewLine( String data,String filename)
    {
        filePath+=filename;

        try {
            // Create a FileWriter object with the file path
            FileWriter fileWriter = new FileWriter(filePath, true);

            // Create a BufferedWriter object with the FileWriter
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write the new row to the file
            bufferedWriter.newLine();
            bufferedWriter.write(data);

            // Close the BufferedWriter
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    void UpdateRow(String updatedata , String filename,int id)
    {
        List<String> data=new ArrayList<>();
        String content =new String();
        filePath+=filename;
        try {
            // Read file line by line
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
               String arr[]=   line.split(",");
               if( Integer.parseInt(arr[0])==id)
               {
                   data.add(updatedata);
               }else {
                   data.add(line);
               }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       WriteFile(data ,filename);
    }
   public void  deleteRow()
    {


    }
    public int getMaxId(String filename)
    { filePath+=filename;
        int max=-1;
        try {
            // Read file line by line
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {

               String arr[]=line.split(",");
               if(Integer.parseInt(arr[0])>max)
                   max=Integer.parseInt(arr[0]);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return max;

    }

}
