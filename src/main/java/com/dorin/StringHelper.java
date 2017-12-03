package com.dorin;

import java.util.HashMap;
import java.util.Map;

public class StringHelper {

    public String getMostFrequentLetter(String text) {
        String[] tokens = text.split("");

        // dict with letter key and frequency value
        Map<String, Integer> lettersInfo = getLettersInfo(tokens);

        return getMostOccurredLetter(lettersInfo);
    }

    private Map<String, Integer> getLettersInfo(String[] tokens) {
        Map<String, Integer> lettersInfo = new HashMap<>();
        for (String token : tokens) {
            if (!Character.isLetter(token.charAt(0))) {
                continue;
            }

            if (lettersInfo.containsKey(token)) {
                lettersInfo.put(token, lettersInfo.get(token) + 1);
            } else {
                lettersInfo.put(token, 1);
            }
        }

        return lettersInfo;
    }

    private String getMostOccurredLetter(Map<String, Integer> lettersInfo) {
        int mostOccurrences = 0;
        String mostOccurredLetter = null;
        for (String letter : lettersInfo.keySet()) {
            if (lettersInfo.get(letter) > mostOccurrences) {
                mostOccurrences = lettersInfo.get(letter);
                mostOccurredLetter = letter;
            }
        }

        return mostOccurredLetter;
    }

    private void printLettersInfo(Map<String, Integer> lettersInfo) {
        System.out.println("Letters info:");
        for (String key : lettersInfo.keySet()) {
            System.out.println("key = " + key + ", value = " + lettersInfo.get(key));
        }
    }

}
