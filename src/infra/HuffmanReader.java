package infra;

import java.io.*;

public class HuffmanReader
{
    private static HuffmanReader instance = null;
    private BufferedReader reader;

    public static HuffmanReader getInstance(String filePath) {

        if(instance == null) instance = new HuffmanReader(filePath);
        return instance;
    }

    private HuffmanReader(String filePath)
    {
        try {
            reader = new BufferedReader( new InputStreamReader( new FileInputStream( filePath ), "UTF-8" ) );
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
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

            int current = reader.read();
            while (current != 10) {
                header += (char) current;
                current = reader.read();
            }
        } catch (IOException e) {
            close();
            throw new Exception("Falha na leitura de arquivo");
        }

        return header;
    }

    public int nextByte() throws Exception
    {
        int current = -1;
        try {

            current = reader.read();
            return current;

        } catch (IOException e) {
            close();
            throw new Exception("Falha na leitura de arquivo");
        }

    }

    public void close()
    {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
