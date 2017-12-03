package com.dorin;

import org.apache.log4j.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
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
    }

}
