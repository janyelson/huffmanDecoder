package infra;

import java.io.*;

public class HuffmanReader
{
    private static HuffmanReader instance = null;
    private FileInputStream fileInputStream;

    public static HuffmanReader getInstance(String filePath) {

        if(instance == null) instance = new HuffmanReader(filePath);
        return instance;
    }

    private HuffmanReader(String filePath)
    {
        File file = new File(filePath);

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public HuffmanReader()
    {
        this("file");
    }

    public String getHeader() throws Exception
    {
        String header = "";
        try {

            int current = fileInputStream.read();
            while (current != 10) {
                header += (char) current;
                current = fileInputStream.read();
            }
        } catch (IOException e) {
            throw new Exception("Falha na leitura de arquivo");
        }

        return header;
    }

    public int nextByte() throws Exception
    {
        int current = -1;
        try {

            current = fileInputStream.read();
            return current;

        } catch (IOException e) {
            throw new Exception("Falha na leitura de arquivo");
        }

    }


}
