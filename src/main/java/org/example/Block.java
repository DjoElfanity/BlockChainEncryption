package org.example;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Block {
    private String data , previousHash , hash;
    private long time;


    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.time = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash()
    {
     String blockData = data + time + previousHash;
     String hashCode = Hashing.sha256().hashString(blockData,  StandardCharsets.UTF_8).toString();
     return hashCode ;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
                "data='" + data + '\'' +
                ", previousHash='" + previousHash + '\'' +
                ", hash='" + hash + '\'' +
                ", time=" + time +
                '}';
    }
}
