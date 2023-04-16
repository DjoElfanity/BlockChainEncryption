package org.example;

import java.util.ArrayList;
import java.util.List;

public class BlockChainApp {
static List<Block> blockchain = new ArrayList<>();
    public static void main(String[] args) {

        blockchain.add(new Block("Data block 1" , "0"));

        for (int i  = 1 ; i<3 ; i++)
        {
            blockchain.add(new Block("Data block"+ (i+1) , blockchain.get(blockchain.size()-1).getHash()));
        }

        for (Block block : blockchain)
        {
            System.out.println(block.toString());
        }

        System.out.println(validateBlock() ? "Block est non modifié " : "Block modifié");

    }
    private static boolean validateBlock()
    {
        for(Block block : blockchain){
            if (!block.getHash().equals(block.calculateHash()))
                return false;
        }

        for (int  i = 1 ; i < blockchain.size() ; i++){

            if (!blockchain.get(i-1).getHash().equals(blockchain.get(i).getPreviousHash()))
                return false;
        }


            return true;
    }
}
