package com.bytedance.bdlocation.utils;

import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class RandomStringUtil {
    private static final Random RANDOM = null;

    static {
        RANDOM = new Random();
    }

    private RandomStringUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int nextInt(int r1, int r2) {
        if (r2 < r1) goto L11;
        if (r1 < 0) goto L9;
        if (r1 != r2) goto L7;
        return r1;
    L7:
        return r1 + RANDOM.nextInt(r2 - r1);
    L9:
        throw new IllegalArgumentException("Both range values must be non-negative.");
    L11:
        throw new IllegalArgumentException("Start value must be smaller or equal to end value.");
    }

    public static String random(int r1) {
        return random(r1, false, false);
    }

    public static String random(int r7, int r8, int r9, boolean r10, boolean r11) {
        return random(r7, r8, r9, r10, r11, null, RANDOM);
    }

    public static String random(int r7, int r8, int r9, boolean r10, boolean r11, char... r12) {
        return random(r7, r8, r9, r10, r11, r12, RANDOM);
    }

    public static String random(int r4, int r5, int r6, boolean r7, boolean r8, char[] r9, Random r10) {
        if (r4 != 0) goto L5;
        return "";
    L5:
        if (r4 < 0) goto L68;
        if (r9 == null) goto L13;
        if (r9.length != 0) goto L13;
        throw new IllegalArgumentException("The chars array must not be empty");
    L13:
        if (r5 != 0) goto L21;
        if (r6 != 0) goto L21;
        if (r9 == null) goto L17;
        r6 = r9.length;
    L22:
        if (r9 == null) goto L24;
    L31:
        StringBuilder r0 = new StringBuilder(r4);
        int r11 = r6 - r5;
    L32:
        int r1 = r4 - 1;
        if (r4 == 0) goto L64;
        int r12 = r10.nextInt(r11) + r5;
        if (r9 != null) goto L44;
        int r2 = Character.getType(r12);
        if (r2 == 0) goto L43;
        if (r2 == 18) goto L43;
        int r13 = r12;
        if (r2 == 19) goto L43;
    L45:
        int r3 = Character.charCount(r13);
        if (r1 != 0) goto L50;
        if (r3 > 1) goto L43;
    L50:
        if (r7 == true) goto L52;
    L53:
        if (r8 == true) goto L55;
    L56:
        if (r7 == true) goto L62;
        if (r8 == true) goto L62;
    L58:
        r0.appendCodePoint(r13);
        if (r3 != 2) goto L61;
        r1 = r1 - 1;
    L61:
        r4 = r1;
    L62:
        r1 = r1 + 1;
        goto L61
    L55:
        if (Character.isDigit(r13) == true) goto L58;
    L52:
        if (Character.isLetter(r13) == true) goto L58;
    L43:
        r4 = r1 + 1;
        goto L32
    L44:
        r13 = r9[r12];
        goto L45
    L64:
        return r0.toString();
    L24:
        if (r8 == false) goto L26;
        if (r6 > 48) goto L26;
    L30:
        throw new IllegalArgumentException("Parameter end (" + r6 + ") must be greater then (48) for generating digits or greater then (65) for generating letters.");
    L26:
        if (r7 == false) goto L31;
        if (r6 <= 65) goto L30;
    L17:
        if (r7 == true) goto L20;
        if (r8 == true) goto L20;
        r6 = 1114111;
    L20:
        r6 = 123;
        r5 = 32;
    L21:
        if (r6 > r5) goto L22;
        throw new IllegalArgumentException("Parameter end (" + r6 + ") must be greater than start (" + r5 + ")");
    L68:
        throw new IllegalArgumentException("Requested random string length " + r4 + " is less than 0.");
    }

    public static String random(int r7, String r8) {
        if (r8 != null) goto L6;
        return random(r7, 0, 0, false, false, null, RANDOM);
    L6:
        return random(r7, r8.toCharArray());
    }

    public static String random(int r1, boolean r2, boolean r3) {
        return random(r1, 0, 0, r2, r3);
    }

    public static String random(int r7, char... r8) {
        if (r8 != null) goto L7;
        int r2 = 0;
        boolean r3 = false;
        boolean r4 = false;
        char[] r5 = null;
        Random r6 = RANDOM;
    L6:
        return random(r7, 0, r2, r3, r4, r5, r6);
    L7:
        r2 = r8.length;
        r3 = false;
        r4 = false;
        r6 = RANDOM;
        r5 = r8;
        goto L6
    }

    public static String randomAlphabetic(int r2) {
        return random(r2, true, false);
    }

    public static String randomAlphabetic(int r0, int r1) {
        return randomAlphabetic(nextInt(r0, r1));
    }

    public static String randomAlphanumeric(int r1) {
        return random(r1, true, true);
    }

    public static String randomAlphanumeric(int r0, int r1) {
        return randomAlphanumeric(nextInt(r0, r1));
    }

    public static String randomAscii(int r3) {
        return random(r3, 32, 127, false, false);
    }

    public static String randomAscii(int r0, int r1) {
        return randomAscii(nextInt(r0, r1));
    }

    public static String randomGraph(int r3) {
        return random(r3, 33, 126, false, false);
    }

    public static String randomGraph(int r0, int r1) {
        return randomGraph(nextInt(r0, r1));
    }

    public static String randomNumeric(int r2) {
        return random(r2, false, true);
    }

    public static String randomNumeric(int r0, int r1) {
        return randomNumeric(nextInt(r0, r1));
    }

    public static String randomPrint(int r3) {
        return random(r3, 32, 126, false, false);
    }

    public static String randomPrint(int r0, int r1) {
        return randomPrint(nextInt(r0, r1));
    }
}
