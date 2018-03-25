package model;

public class HuffmanTree {

    private HuffmanNode root;

    public HuffmanTree( HuffmanNode node)
    {
        root = node;
    }

    public HuffmanNode getLeaf(String message)
    {
        int i = 0;
        HuffmanNode node = root;

        System.out.println(root.getSymbols());

        for(; i < message.length(); i++)
        {
            if(message.charAt(i) == '0') node = node.getRightSon();
            else node = node.getLeftSon();
        }

        if(node.getSymbols().size() != 1) return null;
        //System.out.println(node.getSymbols());

        return node;
    }


}
