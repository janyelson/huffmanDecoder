import huffman.HuffmanCounter;
import huffman.HuffmanDecoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main
{
    public static void main (String args[])
    {
        String fileInputPath = "src\\examples\\file.txt";
        String fileOutputPath = "src\\examples\\file1.txt";

        /*
        for(char letter= ' ';letter<274;letter++) {
            System.out.printf("%d = %c\n", (int)letter, letter);
        }
        */


        /*

        String message = "97 5 98 2 114 2 99 1 100 1\n";
        byte[] bs = message.getBytes();
        byte[] b1 = new byte[bs.length+3];
        for(int i = 0; i < bs.length; i++)
        {
            b1[i] = bs[i];
        }

        b1[b1.length-3] = (byte) 168;
        b1[b1.length-2] = (byte) 8;
        b1[b1.length-1] = (byte) 128;
        byte ia = (byte) 77;
        System.out.println("sss: " + (char )ia);
        try {
            Files.write(Paths.get(fileInputPath), b1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        */


        HuffmanCounter huffmanCounter = new HuffmanCounter(fileInputPath);
        huffmanCounter.readAllFile();

        HuffmanDecoder huffmanDrecrement = new HuffmanDecoder(huffmanCounter.getFrenquency(), fileInputPath, fileOutputPath);

        huffmanDrecrement.run();


    }
}
