package com.myselfsathya;

import java.util.*;

public class CharacterFinder {
    public char findFirstNonRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        var chars = str.toCharArray();
        for(char ch : chars) {
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for(char ch : chars)
            if(map.get(ch) == 1)
                return ch;
        return Character.MIN_VALUE;
    }

    public char findFirstRepeatingChar(String str) {
        Set<Character> set = new HashSet<>();
        var chars = str.toCharArray();
        for(char ch : chars) {
            if(set.contains(ch))
                return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
