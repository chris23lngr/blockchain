package de.z1up.blockchain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

    public static void main(String[] args) {


        final Blockchain blockchain = new Blockchain();


        Block b = new Block(new String[]{"This is Block 1", "Hello Block 1"}, blockchain.getLatestBlock().getHash());
        blockchain.addBlock(b.mine());


        Block b2 = new Block(new String[]{"This is Block 2", "Hello Block 2"}, blockchain.getLatestBlock().getHash());
        blockchain.addBlock(b2.mine());


        Block b3 = new Block(new String[]{"This is Block 3", "Hello Block 3"}, blockchain.getLatestBlock().getHash());
        blockchain.addBlock(b3.mine());


        Block b4 = new Block(new String[]{"This is Block 4", "Hello Block 4"}, blockchain.getLatestBlock().getHash());
        blockchain.addBlock(b4.mine());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = "";

        json = gson.toJson(blockchain.getChain());

        System.out.println(json);


    }

}
