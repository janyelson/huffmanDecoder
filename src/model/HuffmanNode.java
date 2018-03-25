package model;

import java.util.ArrayList;

public class HuffmanNode implements Comparable<HuffmanNode> {

    private HuffmanNode leftSon, rightSon;
    private int frequencySum = 0;
    private ArrayList<Integer> symbols = new ArrayList<>();


    public HuffmanNode(HuffmanNode leftSon, HuffmanNode rightSon){
        this.leftSon = leftSon;
        this.rightSon = rightSon;
        frequencySum = leftSon.getFrequency() + rightSon.getFrequency();
        symbols.addAll(leftSon.getSymbols());
        symbols.addAll(rightSon.getSymbols());
    }

    public HuffmanNode(Integer symbol, int frequency) {
        symbols.add(symbol);
        frequencySum = frequency;
    }

    public int getFrequency(){
        return this.frequencySum;
    }

    public ArrayList<Integer> getSymbols() {
        return symbols;
    }

    public HuffmanNode getLeftSon() {
        return leftSon;
    }

    public HuffmanNode getRightSon() {
        return rightSon;
    }

    @Override
    public String toString() {
        return "" + symbols + " : " + frequencySum;
    }

    @Override
    public int compareTo(HuffmanNode node) {
        if(this.getFrequency() > node.getFrequency())
            return 1;
        else if(this.getFrequency() < node.getFrequency())
            return -1;
        else
            return 0;
    }
}
