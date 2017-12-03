# Shift cipher cracking

### Laboratory 3 at SI

Performer: **Dorin Popa**

Verifier: **Mihai Coslet**

### Work objectives
* Crack some given shift ciphers, plain and simple.
* Implement language choicement for decryption algorithm.

### Implementation


##### Frequency analysis
First of all the program needs to make `frequency` analysis so it needs the most frequent letter in the given text and the most frequent letter of the text's language we are decrypting.

```java
    public String getMostFrequentLetter(String text) {
        String[] tokens = text.split("");

        // dict with letter key and frequency value
        Map<String, Integer> lettersInfo = getLettersInfo(tokens);

        return getMostOccurredLetter(lettersInfo);
    }
```
Fig. 1 - getting most occurred letter in a String text

The algorithm is mainly using a dictionary in order to store the letters and their frequency in the given text, after which there occurs another function to find out which letter has the most repetitions in that dictionary store. 

##### Decrypting function 
```java
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
```
Fig. 2 - Decrypting function based on the `text` and its `language`

As it can be seen the text is converted to lowercase and right after that we call the above mentioned function to find out the most frequent letter.
We also have a function which returns the most occurred letter in the given language.

```java
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
```
Fig. 3 - The letters are set requiring some information on wikipedia, which are not 100% sure.

Next step is just calculating the shift based on the most occurred letter in that text and the given language.

```java
    public Integer getShift(String letter1, String letter2) {
        Integer key1 = getLetterIndex(letter1);
        Integer key2 = getLetterIndex(letter2);
    
        return key2 - key1;
    }
```
Fig. 4 - The shifting formula

After we find out the shift all we need is to modify each letter with this shift, each letter having some index. 
The shifting is done circularly so the maximum index of the letter is z - 26. 

> If the letter is `x - 24` index and the `shift is +4` => according to circular shift the 28 numbers converts to index 1 + 28-26 = `3 (letter c)`. The same with the negative shifting at indexes less than 1.

```java
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
``` 
Fig. 5 - Getting the letter after shifting.

The letters are hold in an array of Strings and after the modification of the letters the function returns a join of all those letters with the other unprocessed characters as well.

##### Main Program

```java
    Decrypter decrypter = new Decrypter();

    Language language = Language.EN;

    String deadlineText = "AB ZNRL MAX WXTWEBGX YHK MABL ETUHKTMHKR BL" +
            " MAX MPXGMBXMA HY WXVXFUXK B PHNEW EBDX MH PBLA RHN ZHHW ENVD PBMA BM TGW ATOX T GBVX EBYX.";

    String message1 = "WKHSWEC: WI XKWO SC WKHSWEC NOMSWEC WOBSNSEC," +
            " MYWWKXNOB YP DRO KBWSOC YP DRO XYBDR, QOXOBKV YP DRO POVSH VOQSYXC," +
            " VYIKV COBFKXD DY DRO DBEO OWZOBYB, WKBMEC KEBOVSEC. PKDROB DY K WEBNOBON CYX," +
            " RECLKXN DY K WEBNOBON GSPO. KXN S GSVV RKFO WI FOXQOKXMO, SX DRSC VSPO YB DRO XOHD.";

    String message2 = "XOXKR IETG BL MH UX VHGLBWXKXW," +
            " XOXKR XQIXWBXGM MKBXW TGW XOXKR FXMAHW MTDXG UXYHKX FTMMXKL TKX UKHNZAM MH MABL ETLM XQMKXFBMR." +
            " ZHHW HYYBVXKL WXVEBGX ZXGXKTE XGZTZXFXGML PAXKX MAX HWWL TKX MHH ZKXTM," +
            " TGW IKXYXK MAX XFIEHRFXGM HY LMKTMTZXF TGW YBGXLLX MH WXLMKHR MAX XGXFR" +
            " TL FNVA TL IHLLBUEX PBMAHNM XQIHLBGZ MAXBK HPG YHKVXL.";

    String message3 = "RD QTAJ KTW YMJ WTRFS JRUNWJ NX ZSIJSNFGQD LWJFYJW YMFS KTW RDXJQK. " +
            "YMJ LWJFYJXY JRUNWJ JAJW YT MFAJ JCNXYJI. N UQJILJ RD JYJWSFQ XJWANYZIJ FSI N FR" +
            " KTWJAJW GTZSI YT XJWAJ NY, NS QNKJ FSI NS IJFYM. YMJD MFAJ RJWJQD LNAJS ZX: WTFIX," +
            " HJSYWFQ MJFYNSL, HTSHWJYJ, YMJ HFQJSIFW, FSI KQZXMNSL YTNQJYX FSI XJBJWX.";


    String decryptedDeadlineText = decrypter.decrypt(deadlineText, language);
    String decryptedMessage1 = decrypter.decrypt(message1, language);
    String decryptedMessage2 = decrypter.decrypt(message2, language);
    String decryptedMessage3 = decrypter.decrypt(message3, language);


    LOGGER.info("Deadline message: " + decryptedDeadlineText);
    LOGGER.info("Message1: " + decryptedMessage1);
    LOGGER.info("Message2: " + decryptedMessage2);
    LOGGER.info("Message3: " + decryptedMessage3);
```

Fig. 6 - Starting point of the application

It is important to choose the language in order to have the expected result after the decrypting of the message.

## Conclusion

Message based communication has been used from the age of Caesar as nowadays.
Having an encryption mechanism is pretty crucial when we are speaking about secure level of our messages and good thing to know is that a shifting of the letters index algorithm is not so secure, it is more interesting for testing, because such an algorithm is easy to determine even though we don't know the language. 
There are already so many information on internet that we can find out any particularity of any human language being involved in a such kind of cryptography.
As a final idea it is a fast solution for simple to cipher message for some not very important reason.