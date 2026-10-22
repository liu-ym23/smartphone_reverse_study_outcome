package com.google.common.base;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Utf8 {
    public static int encodedLength(CharSequence r5) {
        int r0 = r5.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L7;
        if (r5.charAt(r1) >= 128) goto L7;
        r1 = r1 + 1;
    L7:
        int r2 = r0;
    L8:
        if (r1 >= r0) goto L13;
        char r3 = r5.charAt(r1);
        if (r3 >= 2048) goto L12;
        r2 = r2 + ((127 - r3) >>> 31);
        r1 = r1 + 1;
        goto L8
    L12:
        r2 = r2 + encodedLengthGeneral(r5, r1);
    L13:
        if (r2 < r0) goto L15;
        return r2;
    L15:
        long r4 = ((long) r2) + 4294967296L;
        throw new IllegalArgumentException(new StringBuilder(54).append("UTF-8 length does not fit in int: ").append(r4).toString());
    }

    private static int encodedLengthGeneral(CharSequence r4, int r5) {
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r5 >= r0) goto L17;
        char r2 = r4.charAt(r5);
        if (r2 >= 2048) goto L7;
        r1 = r1 + ((127 - r2) >>> 31);
    L16:
        r5 = r5 + 1;
        goto L3
    L7:
        r1 = r1 + 2;
        if (55296 > r2) goto L16;
        if (r2 > 57343) goto L16;
        if (Character.codePointAt(r4, r5) == r2) goto L15;
        r5 = r5 + 1;
        goto L16
    L15:
        throw new IllegalArgumentException(unpairedSurrogateMsg(r5));
    L17:
        return r1;
    }

    public static boolean isWellFormed(byte[] r2) {
        return isWellFormed(r2, 0, r2.length);
    }

    public static boolean isWellFormed(byte[] r1, int r2, int r3) {
        int r4 = r3 + r2;
        Preconditions.checkPositionIndexes(r2, r4, r1.length);
    L3:
        if (r2 >= r4) goto L9;
        if (r1[r2] < 0) goto L7;
        r2 = r2 + 1;
        goto L3
    L7:
        return isWellFormedSlowPath(r1, r2, r4);
    L9:
        return true;
    }

    private static boolean isWellFormedSlowPath(byte[] r6, int r7, int r8) {
    L2:
        if (r7 >= r8) goto L3;
        int r0 = r7 + 1;
        byte r9 = r6[r7];
        if (r9 >= 0) goto L44;
        if (r9 < (-32)) goto L9;
        if (r9 < (-16)) goto L18;
        if ((r0 + 2) >= r8) goto L34;
        int r1 = r0 + 1;
        byte r2 = r6[r0];
        if (r2 > (-65)) goto L43;
        if ((((r9 << 28) + (r2 + 112)) >> 30) != 0) goto L43;
        int r10 = r1 + 1;
        if (r6[r1] > (-65)) goto L43;
        r0 = r10 + 1;
        if (r6[r10] <= (-65)) goto L44;
    L43:
        return false;
    L34:
        return false;
    L18:
        int r4 = r0 + 1;
        if (r4 >= r8) goto L20;
        byte r3 = r6[r0];
        if (r3 > (-65)) goto L31;
        if (r9 != (-32)) goto L27;
        if (r3 < (-96)) goto L31;
    L27:
        if (r9 != (-19)) goto L29;
        if ((-96) <= r3) goto L31;
    L29:
        r7 = r4 + 1;
        if (r6[r4] <= (-65)) goto L2;
    L31:
        return false;
    L20:
        return false;
    L9:
        if (r0 == r8) goto L10;
        if (r9 < (-62)) goto L15;
        r7 = r0 + 1;
        if (r6[r0] <= (-65)) goto L2;
    L15:
        return false;
    L10:
        return false;
    L44:
        r7 = r0;
        goto L2
    L3:
        return true;
    }

    private static String unpairedSurrogateMsg(int r2) {
        return new StringBuilder(39).append("Unpaired surrogate at index ").append(r2).toString();
    }

    private Utf8() {
    }
}
