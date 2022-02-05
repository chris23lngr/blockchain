package de.z1up.blockchain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The Main class is where the {@code main()} method
 * is run. As the name says, this is the hero class of
 * the project.
 *
 * @author Christoph Langer
 * @version 1.0
 */
public class Main {

    /**
     * The main method runs the program.
     *
     * First it creates a new Blockchain instance, than it
     * adds four new blocks to the chain. After that it
     * prints the blockchain in JSON format.
     *
     * @param args
     */
    public static void main(String[] args) {


        // Create an new Blockchain instance
        final Blockchain blockchain = new Blockchain();

        // Generate a new Block b1
        Block b1 = new Block(new String[]{"This is Block 1", "Hello Block 1"},
                blockchain.getLatestBlock().getHash());
        // Mine the block, so that it gets its hash value
        b1 = b1.mine();
        // Add the Block to the Blockchain
        blockchain.addBlock(b1);


        // Repeat the process to generate 4 Blocks, mine them and add them to the Blockchain
        Block b2 = new Block(new String[]{"This is Block 2", "Hello Block 2"},
                blockchain.getLatestBlock().getHash());
        blockchain.addBlock(b2.mine());
        Block b3 = new Block(new String[]{"This is Block 3", "Hello Block 3"},
                blockchain.getLatestBlock().getHash());
        blockchain.addBlock(b3.mine());
        Block b4 = new Block(new String[]{"This is Block 4", "Hello Block 4"},
                blockchain.getLatestBlock().getHash());
        blockchain.addBlock(b4.mine());

        // Create a new GsonBuilder and enable Pretty Printing
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // Get JSON from the Blockchain
        String json = gson.toJson(blockchain.getChain());

        // Print the JSON output of the chain
        System.out.println(json);
    }

}
