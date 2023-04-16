package org.example;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Block1 {
    private long index;
    private String previousHash , hash;
    private List<Transaction> transactions = new ArrayList<>();
    private long time;


    public Block1(long index,List<Transaction> transactions, String previousHash) {
        this.index = index;
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.time = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash()
    {
     String blockData = Arrays.toString(transactions.toArray()) + time + previousHash;
     String hashCode = Hashing.sha256().hashString(blockData,  StandardCharsets.UTF_8).toString();
     return hashCode ;
    }


    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Block{" +
                "data='" + Arrays.toString(transactions.toArray())  + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", hash='" + hash + '\'' +
                ", time=" + time +
                '}';
    }
}
