package org.example;

import javax.crypto.KeyGenerator;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.List;

public class Wallet {
    private String privateKey;
    private String publicKey;
    private double balance ;

    private List<Block1> blockchain;

    public Wallet(double balance , List<Block1> blockchain)
    {
        this.blockchain = blockchain;
        this.balance = balance;
        generateRSAKeys();

    }

    private void generateRSAKeys()
    {
        try
        {
            KeyPairGenerator keyPairGenerator= KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(512);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            this.privateKey = keyPair.getPrivate().toString();
            this.publicKey = keyPair.getPublic().toString();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public Transaction send(String receiver , double value)
    {
        if (balance < value)
        {
            System.out.println("Solde est insufisant");
            return null;
        }

        Transaction transaction = new Transaction(publicKey , receiver , value);
        return transaction;
    }

    public double getBalance()
    {
    double total = balance;
    for(Block1 block :blockchain)
    {
        for (Transaction transaction:block.getTransactions())
        {
            if(transaction.getSender().equals(publicKey)) total -= transaction.getValue();

            if(transaction.getReceiver().equals(publicKey)) total -= transaction.getValue();

        }
    }


            return total;
    }

    public String getPublicKey() {
        return publicKey;
    }
}
