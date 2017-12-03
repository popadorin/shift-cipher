package com.dorin;

import org.apache.log4j.Logger;

public class Decrypter {
    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    private Letters letters = Letters.getInstance();
    private StringHelper helper = new StringHelper();

    public String decrypt(String incomeText) {
        String text = incomeText.toLowerCase();
        String mostFrequentLetterInEnglish = "e";
        String mostFrequentLetter = helper.getMostFrequentLetter(text);
        LOGGER.info("Most freq letter in text: " + mostFrequentLetter);

        int shift = letters.getShift(mostFrequentLetterInEnglish, mostFrequentLetter);
        LOGGER.info("shift = " + shift);
        if (shift == 0) {
            return text;
        }

        String[] letters = text.split("");

        for (int i = 0; i < letters.length; i++) {
            if (!Character.isLetter(letters[i].charAt(0))) {
                continue;
            }

            letters[i] = this.letters.getLetterShiftedWith(letters[i], shift);
        }

        return String.join("", letters);
    }
}
