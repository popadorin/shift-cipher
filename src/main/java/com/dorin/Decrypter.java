package com.dorin;

import org.apache.log4j.Logger;

public class Decrypter {
    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    private Letters letters = Letters.getInstance();
    private StringHelper helper = new StringHelper();

    public String decrypt(String incomeText, Language language) {
        String text = incomeText.toLowerCase();
        String languageMostFrequentLetter = getLanguageMostFrequentLetter(language);
        String mostFrequentLetter = helper.getMostFrequentLetter(text);
        LOGGER.info("Most frequent letter in text: " + mostFrequentLetter);

        int shift = letters.getShift(languageMostFrequentLetter, mostFrequentLetter);
        LOGGER.info("Letters are shifted with: " + shift + " positions");
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

    private String getLanguageMostFrequentLetter(Language language) {
        switch (language) {
            case EN:
                return "e";
            case ROM:
                return "e";
            case TURK:
                return "a";
            case FR:
                return "e";
            case DE:
                return "e";
            case ISLAND:
                return "a";
            default:
                LOGGER.error("No such language");
                return "a";
        }
    }
}
