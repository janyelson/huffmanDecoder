import huffman.HuffmanCounter;
import huffman.HuffmanDecoder;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main
{
    public static void main (String args[])
    {
        String fileInputPath = "src\\examples\\resultEncoder";//JOptionPane.showInputDialog("File Input Path:");
        String fileOutputPath = "src\\examples\\resultDecoder";

        HuffmanCounter huffmanCounter = new HuffmanCounter(fileInputPath);
        huffmanCounter.readAllFile();

        HuffmanDecoder huffmanDrecrement = new HuffmanDecoder(huffmanCounter.getFrenquency(), fileInputPath, fileOutputPath);
        huffmanDrecrement.run();

    }
}
