package de.z1up.blockchain;

import de.z1up.blockchain.crypt.SHA256;
import org.apache.commons.lang3.ArrayUtils;

public class Blockchain<T> {

    private Block[] chain;
    private int dif;

    private Block current;

    public Blockchain(int dif) {
        this.dif = dif;
        this.chain = new Block[]{this.buildGenesisBlock()};
    }

    private Block<T> buildGenesisBlock() {
        Block genesis = new Block(new String[]{"GENESIS"}, "null", System.currentTimeMillis());
        genesis.setHash(SHA256.of(genesis.getHashableValues()));
        return (genesis);
    }

    public Block lastBlock() {
        return (this.chain[this.chain.length - 1]);
    }

    public String lastHash() {
        return (this.lastBlock().getHash());
    }

    public void append(Block<T> block) {
        this.chain = ArrayUtils.add(this.chain, block);
    }

    public int getDif() {
        return this.dif;
    }

    public Block[] getChain() {
        return chain;
    }

    public boolean isValid() {

        int length = this.chain.length;
        int i = 1;

        while (i < (length - 1)) {

            Block current = this.chain[i];
            Block prev = this.chain[i-1];

            if(!current.getPreviousHash().equals(prev.getHash())) {
                // System.out.println("PREV : " + current.getPreviousHash() + " != " + prev.getHash());
                return false;
            }

            if(!current.getHash().equals(SHA256.of(current.getHashableValues()))) {
                // System.out.println("CURRENT : " + current.getHash() + " != " + SHA256.of(current.getHashableValues()));
                return false;
            }

            i++;
        }

        return true;
    }
}
