package com.dorin;

public class Main {

    public static void main(String[] args) {
        Decrypter decrypter = new Decrypter();

	    String deadlineText = "AB ZNRL MAX WXTWEBGX YHK MABL ETUHKTMHKR BL" +
                " MAX MPXGMBXMA HY WXVXFUXK B PHNEW EBDX MH PBLA RHN ZHHW ENVD PBMA BM TGW ATOX T GBVX EBYX.";

        String message1 = "WKHSWEC: WI XKWO SC WKHSWEC NOMSWEC WOBSNSEC," +
                " MYWWKXNOB YP DRO KBWSOC YP DRO XYBDR, QOXOBKV YP DRO POVSH VOQSYXC," +
                " VYIKV COBFKXD DY DRO DBEO OWZOBYB, WKBMEC KEBOVSEC. PKDROB DY K WEBNOBON CYX," +
                " RECLKXN DY K WEBNOBON GSPO. KXN S GSVV RKFO WI FOXQOKXMO, SX DRSC VSPO YB DRO XOHD";

        String message2 = "XOXKR IETG BL MH UX VHGLBWXKXW," +
                " XOXKR XQIXWBXGM MKBXW TGW XOXKR FXMAHW MTDXG UXYHKX FTMMXKL TKX UKHNZAM MH MABL ETLM XQMKXFBMR." +
                " ZHHW HYYBVXKL WXVEBGX ZXGXKTE XGZTZXFXGML PAXKX MAX HWWL TKX MHH ZKXTM," +
                " TGW IKXYXK MAX XFIEHRFXGM HY LMKTMTZXF TGW YBGXLLX MH WXLMKHR MAX XGXFR" +
                " TL FNVA TL IHLLBUEX PBMAHNM XQIHLBGZ MAXBK HPG YHKVXL.";

        String message3 = "RD QTAJ KTW YMJ WTRFS JRUNWJ NX ZSIJSNFGQD LWJFYJW YMFS KTW RDXJQK. " +
                "YMJ LWJFYJXY JRUNWJ JAJW YT MFAJ JCNXYJI. N UQJILJ RD JYJWSFQ XJWANYZIJ FSI N FR" +
                " KTWJAJW GTZSI YT XJWAJ NY, NS QNKJ FSI NS IJFYM. YMJD MFAJ RJWJQD LNAJS ZX: WTFIX," +
                " HJSYWFQ MJFYNSL, HTSHWJYJ, YMJ HFQJSIFW, FSI KQZXMNSL YTNQJYX FSI XJBJWX.";


        String decryptedDeadlineText = decrypter.decrypt(deadlineText);
        String decryptedMessage1 = decrypter.decrypt(message1);
        String decryptedMessage2 = decrypter.decrypt(message2);
        String decryptedMessage3 = decrypter.decrypt(message3);


        System.out.println("Deadline message: " + decryptedDeadlineText);
        System.out.println("Message1: " + decryptedMessage1);
        System.out.println("Message2: " + decryptedMessage2);
        System.out.println("Message3: " + decryptedMessage3);
    }

}
