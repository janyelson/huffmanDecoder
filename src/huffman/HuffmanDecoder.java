package huffman;

import controller.TreeController;
import infra.HuffmanReader;
import infra.HuffmanWriter;
import model.HuffmanNode;
import model.HuffmanTree;
import java.util.HashMap;

public class HuffmanDecoder
{

    private HashMap<Integer, Integer> currentFrequency;
    private TreeController treeController;
    private HuffmanReader huffmanReader;
    private HuffmanWriter huffmanWriter;

    public HuffmanDecoder(HashMap<Integer, Integer> frequency, String inputFilePath, String outputFilePath)
    {
        this.currentFrequency = frequency;
        treeController = new TreeController();
        huffmanReader = HuffmanReader.getInstance(inputFilePath);
        huffmanWriter = HuffmanWriter.getInstance(outputFilePath);
    }

    public void run()
    {
        int value = -1, i = 7, bit;
        String message = "";
        HuffmanNode node;

        HuffmanTree huffmanTree = treeController.buildTree(currentFrequency);

        try {
            value = huffmanReader.nextByte();

            while (value != -1) {

                bit = getBit(value, i);
                message += "" + bit;

                if(currentFrequency.size() == 1)
                {
                    for(Integer symbol : currentFrequency.keySet()) writeLastChars(symbol, currentFrequency.get(symbol));
                    huffmanReader.close();
                    break;
                }

                node = huffmanTree.getLeaf(message);

                if (node != null)
                {
                    writeInFile(node.getSymbols().get(0));
                    message = "";
                    huffmanTree = treeController.buildTree(currentFrequency);
                }

                i--;
                if (i < 0) {
                    value = huffmanReader.nextByte();
                    i = 7;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeInFile(int messageDecode)
    {

        int count = currentFrequency.get(messageDecode) - 1;

        if(count == 0) currentFrequency.remove(messageDecode);
        else currentFrequency.put(messageDecode, count);

        huffmanWriter.write(String.valueOf((char) messageDecode));

    }

    private void writeLastChars(int messageDecode, int frequency)
    {
        for(int i = 0; i < frequency; i++)
        {
            writeInFile(messageDecode);
        }
    }

    private int getBit(int n, int k) {
        return (n >> k) & 1;
    }
}
