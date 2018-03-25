package infra;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class HuffmanWriter
{
    private static HuffmanWriter instance = null;
    private BufferedWriter writer;

    public static HuffmanWriter getInstance(String filePath) {

        if(instance == null) instance = new HuffmanWriter(filePath);
        return instance;
    }

    private HuffmanWriter(String filePath)
    {

        try {
            writer = Files.newBufferedWriter(Paths.get(filePath), StandardCharsets.UTF_8);
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
            writer.write(message);
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
