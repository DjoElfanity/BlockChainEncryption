package org.example;

import java.util.ArrayList;
import java.util.List;

public class BlockChainApp1 {
static List<Block1> blockchain = new ArrayList<>();
static List<Transaction> transactions = new ArrayList<>();
    public static void main(String[] args) {

       Wallet wallet1 = new Wallet(50,blockchain);
        System.out.println("Wallet 1  : " +wallet1.getBalance());
        Wallet wallet2 = new Wallet(70,blockchain);
        System.out.println("Wallet 2 : " +wallet2.getBalance());

        Transaction transaction1 =wallet1.send(wallet2.getPublicKey(),10);
        transactions.add(transaction1);
        Block1 block1 = new Block1(1 , transactions,null);
        blockchain.add(block1);


        System.out.println("Apres la transaction : \nWallet 1 : " + wallet1.getBalance() +"\nWallet 2 : " + wallet2.getBalance() );


    }
    private static boolean validateBlock()
    {
        for(Block1 block : blockchain){
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
