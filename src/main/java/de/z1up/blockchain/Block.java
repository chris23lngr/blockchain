package de.z1up.blockchain;

import de.z1up.blockchain.crypt.SHA256;

public class Block<T> {

    private String hash;
    private T[] content;

    private String previousHash;
    private long timestamp;
    private int nonce = 0;

    public Block(T[] content, String previousHash, long timestamp) {
        this.content = content;
        this.previousHash = previousHash;
        this.timestamp = timestamp;
    }

    // Getters and Setter
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public T[] getContent() {
        return content;
    }

    public void setContent(T[] content) {
        this.content = content;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }


    public String getHashableValues() {
        return (this.content + this.previousHash + this.timestamp + this.nonce);
    }

    public Block mine(final int dif) {

        final String difS = this.difToString(dif);
        this.hash = SHA256.of(this.getHashableValues());

        while (!(this.hash.substring(0, dif).equals(difS))) {
            this.nonce = this.nonce + 1;
            this.hash = SHA256.of(this.getHashableValues());
            //System.out.println(this.hash);
        }

        System.out.println("Block mined: " + this.hash);

        return this;

    }

    private String difToString(final int dif) {
        String s = "";
        int i = 0;
        while (i < dif) {
            i++;
            s = s + "0";
        }
        return s;
    }

}
