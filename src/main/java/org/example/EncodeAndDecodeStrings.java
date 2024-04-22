package org.example;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length())
                    .append("#")
                    .append(str);
        }
        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int index = str.indexOf("#");
        int indexBegin = 0;
        while (index != -1) {
            int wordSize = Integer.parseInt(str.substring(indexBegin, index));
            String word = str.substring(index + 1, index + wordSize + 1);
            result.add(word);
            indexBegin = index + wordSize + 1;
            index = str.indexOf("#", index + wordSize + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>(List.of("we", "say", ":", "yes", "!@#$%^&*()"));
        System.out.println(encode(input));
        System.out.println(decode(encode(input)));
    }
}
