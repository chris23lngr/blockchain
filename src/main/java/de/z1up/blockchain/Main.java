package de.z1up.blockchain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = "";

        Blockchain<String> blockchain = new Blockchain<>(4);

        /*

        System.out.println(blockchain.lastHash());

        System.out.println(gson.toJson(blockchain.lastBlock()));

        Block b = new Block(new String[]{"Hello", "World"}, blockchain.lastHash(), System.currentTimeMillis());
        //b.mine(blockchain.getDif());

        blockchain.append(b.mine(blockchain.getDif()));

        Block b2 = new Block(new String[]{"This", "is", "Christoph"}, blockchain.lastHash(), System.currentTimeMillis());

        blockchain.append(b2.mine(blockchain.getDif()));


         */
        for(int i = 0; i < 20; i ++) {

            String[] content = new String[]{"Content " + i};
            Block b = new Block(content, blockchain.lastHash(), System.currentTimeMillis());
            blockchain.append(b.mine(blockchain.getDif()));

        }

        /*
        json = gson.toJson(blockchain);
        System.out.println(json);
         */

        json = gson.toJson(blockchain.getChain());
        System.out.println(json);

        /*
        json = gson.toJson(b);
        System.out.println(json);
        */

        System.out.println("Is chain valid ? " + blockchain.isValid());

        try {
            whenWriteStringUsingBufferedWritter_thenCorrect(json);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public static void whenWriteStringUsingBufferedWritter_thenCorrect(String str)
            throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("chain.txt"));
        writer.write(str);

        writer.close();
    }

}
