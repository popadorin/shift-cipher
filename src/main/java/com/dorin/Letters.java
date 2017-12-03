package com.dorin;

import java.util.HashMap;
import java.util.Map;

public class Letters {
    private Map<Integer, String> letters = new HashMap<>();

    private static Letters INSTANCE = null;

    private Letters() {
        letters.put(1,"a");
        letters.put(2, "b");
        letters.put(3, "c");
        letters.put(4, "d");
        letters.put(5, "e");
        letters.put(6, "f");
        letters.put(7 ,"g");
        letters.put(8 ,"h");
        letters.put(9, "i");
        letters.put(10, "j");
        letters.put(11 ,"k");
        letters.put(12 ,"l");
        letters.put(13 ,"m");
        letters.put(14 ,"n");
        letters.put(15 ,"o");
        letters.put(16 ,"p");
        letters.put(17 ,"q");
        letters.put(18 ,"r");
        letters.put(19 ,"s");
        letters.put(20 ,"t");
        letters.put(21 ,"u");
        letters.put(22 ,"v");
        letters.put(23 ,"w");
        letters.put(24 ,"x");
        letters.put(25 ,"y");
        letters.put(26 ,"z");
    }

    public static Letters getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Letters();
            return INSTANCE;
        }

        return INSTANCE;
    }

    public String getLetter(Integer index) {
        return letters.get(index);
    }

    public Integer getLetterIndex(String letter) {
        Integer result = 0;
        for (Integer key : letters.keySet()) {
            if (letters.get(key).equals(letter)) {
                result = key;
            }
        }

        return result;
    }

    public Integer getShift(String letter1, String letter2) {
        Integer key1 = getLetterIndex(letter1);
        Integer key2 = getLetterIndex(letter2);

        return key2 - key1;
    }

    public String getLetterShiftedWith(String letter, Integer shift) {
        Integer index = getLetterIndex(letter);

        Integer result = index - shift;
        if (result < 0) {
            result = 26 + result;
        }

        if (result > 26)  {
            result = result - 25;
        }

        return getLetter(result);
    }

}
