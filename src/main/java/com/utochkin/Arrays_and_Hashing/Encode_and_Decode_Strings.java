package com.utochkin.Arrays_and_Hashing;

import java.util.*;

public class Encode_and_Decode_Strings {

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>(Arrays.asList("we", "say", ":", "yes", "!@#$%^&*()"));  // 2#we3#say1#:3#yes10#!@#$%^&*()
        System.out.println(strs + "\n");
        System.out.println(encode(strs) + "\n");
        System.out.println(decode(encode(strs)));
    }

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {

            int hashIndex = str.indexOf('#', i); // 2#we3#say1#:3#yes10#!@#$%^&*()
            if (hashIndex == -1) break;

            int length = Integer.parseInt(str.substring(i, hashIndex));

            String decodedString = str.substring(hashIndex + 1, hashIndex + 1 + length);
            strs.add(decodedString);

            i = hashIndex + 1 + length;
        }
        return strs;
    }
}
