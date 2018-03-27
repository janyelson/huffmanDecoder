package huffman;

import infra.HuffmanReader;

import java.util.ArrayList;
import java.util.HashMap;

public class HuffmanCounter
{
    private HuffmanReader huffmanReader;
    private HashMap <Integer, Integer> frequency = new HashMap<Integer,Integer>();
    public HuffmanCounter(String filePath)
    {
        huffmanReader = HuffmanReader.getInstance(filePath);
    }

    public void readAllFile()
    {
        try{
            String[] header = huffmanReader.getHeader().split("\\s+");
            for(int i = 1; i < header.length; i = i+2)
            {
                //System.out.println("Char: " + Integer.parseInt(header[i-1]) + " - F: " + Integer.parseInt(header[i]));
                frequency.put(Integer.parseInt(header[i-1]), Integer.parseInt(header[i]));
            }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public void showFrequency(){
        System.out.println(frequency);
    }

    public HashMap<Integer, Integer> getFrenquency() {
        return frequency;
    }
}
