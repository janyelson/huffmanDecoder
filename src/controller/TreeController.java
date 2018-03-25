package controller;

import model.HuffmanNode;
import model.HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class TreeController {

    private ArrayList<HuffmanNode> sheets = new ArrayList<HuffmanNode>();

    public HuffmanTree buildTree(HashMap<Integer, Integer> symbolFrequency){

        createSheets(symbolFrequency);

        while(sheets.size() > 1)
        {
            HuffmanNode leftSon = sheets.remove(sheets.size()-1);
            HuffmanNode rightSon = sheets.remove(sheets.size()-1);

            HuffmanNode parentNode = new HuffmanNode(rightSon, leftSon);
            sheets.add(parentNode);

            Collections.sort(sheets, Collections.reverseOrder());
        }

        return new HuffmanTree(sheets.get(0));

    }

    private void createSheets(HashMap<Integer, Integer> symbolFrequency){

        sheets.clear();

        for(Integer symbol : symbolFrequency.keySet()){
            int frequency = symbolFrequency.get(symbol);
            sheets.add(new HuffmanNode(symbol, frequency));
        }

        Collections.sort(sheets, Collections.reverseOrder());


        for(HuffmanNode hn : sheets)
        {
            System.out.println("Symbol: " + hn.getSymbols() + " - Frequency: " + hn.getFrequency());
        }


    }

    /*
    private int[] getLastFrequencies()
    {

        int index[] = new int[2];
        int i = 0;

        int min = Integer.MAX_VALUE;
        for(i = 0; i < sheets.size(); i++)
        {
            if(min >= sheets.get(i).getFrequency())
            {
                min = sheets.get(i).getFrequency();
                index[0] = i;
            }
        }

        min = Integer.MAX_VALUE;
        for(i = 0; i < sheets.size(); i++)
        {
            if(index[0] != i && (min >= sheets.get(i).getFrequency()))
            {
                min = sheets.get(i).getFrequency();
                index[1] = i;
            }

        }

        return index;
    }

    */

}
