package infra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class HuffmanWriter
{
    private static HuffmanWriter instance = null;
    private String filePath;

    public static HuffmanWriter getInstance(String filePath) {

        if(instance == null) instance = new HuffmanWriter(filePath);
        return instance;
    }

    private HuffmanWriter(String filePath)
    {

        this.filePath = filePath;

        try {
            Files.deleteIfExists(Paths.get(filePath));
            Files.createFile(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HuffmanWriter()
    {
        this("file");
    }

    public void write(String message)
    {
        try {
            Files.write(Paths.get(filePath), message.getBytes(), StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
