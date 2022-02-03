package de.z1up.blockchain;

import com.google.common.hash.Hashing;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;

/**
 * A Block is an Object, which will be stored in
 * a {@code Blockchain}. Blocks should always be final,
 * since their values aren't supposed to change anymore
 * after the block is generated.
 *
 * @author Christoph Langer
 * @see Blockchain
 * @version 1.0
 */
public class Block
        extends Object {

    // Class variables
    private String      hash;

    private String[]    content;
    private long        timestamp;
    private String      prevHash;
    private int         nonce;


    // Constructors
    public Block(String hash,
                 String[] content,
                 String prevHash) {

        this.hash       = hash;
        this.content    = content;
        this.timestamp  = System.currentTimeMillis();
        this.prevHash   = prevHash;
    }

    public Block(String[] content,
                 String prevHash) {

        this.content = content;
        this.prevHash = prevHash;
        this.timestamp  = System.currentTimeMillis();
    }

    // Methods

    /**
     * The {@code mine()} method mines a Block. Mining
     * a Block means, that a hash value is generated
     * from the content, timestamp, previous hash and
     * the nonce using the SHA256.
     *
     * The method returns the current Block, but with
     * a set hash value.
     *
     * @return The final, mined Block
     */
    public Block mine() {

        String hashableValues = "" + this.getContent() + this.getTimestamp() + this.getPrevHash() + this.getNonce();

        this.hash = Hashing.sha256().hashString(hashableValues, StandardCharsets.UTF_8).toString();

        return this;
    }

    // Getters and Setters

    /**
     * Returns the generated Hash for the given Block.
     * Returns an empty String if the hash is null.
     *
     * @return the current Hash
     */
    public String getHash() {
        return (StringUtils.isEmpty(this.hash) ? "" : this.hash);
    }

    /**
     * Sets the current Hash value.
     *
     * @param hash
     *        The new hash value
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * Returns the current content stored in
     * the given block.
     *
     * @return The content
     */
    public String[] getContent() {
        return content;
    }

    /**
     * Returns the timestamp which indicates when the
     * block was created.
     *
     * @return The timestamp of the block
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Returns the Hash value of the previous Block in
     * the Blockchain.
     *
     * Important: Value might not match with the actual
     * previous Hash from the Blockchain, since the value
     * is set manually.
     *
     * @return The previous Hash
     */
    public String getPrevHash() {
        return prevHash;
    }

    /**
     * Stores the hash value of the previous Block in
     * the Blockchain.
     *
     * @param prevHash
     *        The previous hash value
     */
    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }

    /**
     * Returns the current nonce value.
     *
     * @return Current nonce.
     */
    public int getNonce() {
        return nonce;
    }

    /**
     * Assigns a new value to the nonce variable.
     *
     * @param nonce
     *        The new nonce value.
     */
    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

}
