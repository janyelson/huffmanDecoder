package infra;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HuffmanWriter
{
    private static HuffmanWriter instance = null;
    private DataOutputStream writer;
    public static HuffmanWriter getInstance(String filePath) {

        if(instance == null) instance = new HuffmanWriter(filePath);
        return instance;
    }

    private HuffmanWriter(String filePath)
    {

        try {
            writer = new DataOutputStream(new FileOutputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HuffmanWriter()
    {
        this("file");
    }

    public void writeOnFile(int message)
    {
        try {
            writer.writeByte(message);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close()
    {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
