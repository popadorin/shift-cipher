package com.dorin;

public class Decrypter {
    private Letters letters = Letters.getInstance();
    private StringHelper helper = new StringHelper();

    public String decrypt(String incomeText) {
        String text = incomeText.toLowerCase();
        String mostFrequentLetterInEnglish = "e";
        String mostFrequentLetter = helper.getMostFrequentLetter(text);
        System.out.println("Most freq letter in text: " + mostFrequentLetter);

        int shift = letters.getShift(mostFrequentLetterInEnglish, mostFrequentLetter);
        System.out.println("shift = " + shift);
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
