package de.z1up.blockchain.crypt;

import com.google.common.base.Strings;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class SHA256 {

    public static String of(String s) {
        if(Strings.isNullOrEmpty(s)) return "null";

        final String sha256hex = Hashing.sha256()
                .hashString(s, StandardCharsets.UTF_8)
                .toString();

        return sha256hex;
    }

    public static String of(Object... objects) {
        String s = "";
        for(Object o : objects) {
            s = s + o;
        }
        return of(s);
    }


}
