package de.z1up.blockchain;

import org.apache.commons.lang3.ArrayUtils;

/**
 * A Blockchain is a collection of Blocks ordered by time.
 * Blocks can only by appended to the end of the chain.
 *
 * @author Christoph Langer
 * @see Block
 * @version 1.0
 */
public class Blockchain {

    /** A Genesis Block is the first Block to be stored in a Blockchain. */
    private Block       genesis;
    private Block[]     chain;


    public Blockchain() {

        this.chain = new Block[]{};
        this.genesis = this.getGenesisBlock();
        this.addBlock(this.getGenesisBlock());

    }

    /**
     * Generates the genesis {@code Block}, the first
     * Block in the Blockchain.
     *
     * @return The generated Block
     */
    private Block getGenesisBlock() {
        final Block genesis = new Block("genesis", new String[]{"genesis block"}, "0");
        return genesis;
    }

    /**
     * Appends a new Block to the Blockchain using
     * Appachees Array Utils.
     *
     * @param block
     *        The Block that will be appended.
     */
    public void addBlock(Block block) {
        this.chain = ArrayUtils.add(this.chain, block);
    }

    public Block getLatestBlock() {
        return this.chain[chain.length - 1];
    }

    public Block[] getChain() {
        return chain;
    }

}
