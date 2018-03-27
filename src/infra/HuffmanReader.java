package infra;

import java.io.*;

public class HuffmanReader
{
    private static HuffmanReader instance = null;
    private DataInputStream reader;
    public static HuffmanReader getInstance(String filePath) {

        if(instance == null) instance = new HuffmanReader(filePath);
        return instance;
    }

    private HuffmanReader(String filePath)
    {
        try {
            reader = new DataInputStream(new FileInputStream(filePath));
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

            int current = reader.readByte();
            while (current != 10) {
                header += (char) current;
                current = reader.readByte();
            }

            System.out.println(header);
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

            current = reader.readByte();
            return current;

        } catch (EOFException eof){
            close();
            return 300;
        }
        catch (IOException e) {
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
