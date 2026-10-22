package tmsdkobf;

import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: loaded from: classes5.dex */
public abstract class y5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f635a = null;
    public static final byte[] b = null;

    static {
        f635a = new char[]{DeepCleanSAFEngine.DetailPath.KEY, DeepCleanSAFEngine.DetailPath.DETAIL_PATH, DeepCleanSAFEngine.DetailPath.FILENAME, DeepCleanSAFEngine.DetailPath.FILESIZE, DeepCleanSAFEngine.DetailPath.CTIME, DeepCleanSAFEngine.DetailPath.MTIME, DeepCleanSAFEngine.DetailPath.ATIME, DeepCleanSAFEngine.DetailPath.IMPORTANT, '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        b = new byte[0];
    }

    public static byte a(char r2) {
        if (r2 < '0') goto L10;
        if (r2 > '9') goto L10;
        int r3 = r2 - DeepCleanSAFEngine.DetailPath.KEY;
    L8:
        return (byte) r3;
    L10:
        if (r2 < 'a') goto L15;
        if (r2 > 'f') goto L15;
        r3 = r2 - 'W';
    L15:
        if (r2 >= 'A') goto L17;
        return 0;
    L17:
        if (r2 > 'F') goto L21;
        r3 = r2 - '7';
        goto L8
    L21:
        return 0;
    }

    public static String a(byte[] r7) {
        if (r7 != null) goto L4;
        return null;
    L4:
        if (r7.length == 0) goto L15;
        char[] r0 = new char[r7.length * 2];
        int r1 = 0;
    L8:
        if (r1 >= r7.length) goto L10;
        byte r2 = r7[r1];
        int r3 = r1 * 2;
        char[] r5 = f635a;
        r0[r3 + 1] = r5[r2 & 15];
        r0[r3] = r5[((byte) (r2 >>> 4)) & 15];
        r1 = r1 + 1;
        goto L8
    L10:
        return new String(r0);
    L15:
        return null;
    }

    public static byte[] a(String r5) {
        if (r5 == null) goto L11;
        if (r5.equals("") == true) goto L11;
        int r0 = r5.length() / 2;
        byte[] r1 = new byte[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L8;
        int r3 = r2 * 2;
        char r4 = r5.charAt(r3);
        char r6 = r5.charAt(r3 + 1);
        r1[r2] = (byte) ((a(r4) * 16) + a(r6));
        r2 = r2 + 1;
        goto L7
    L8:
        return r1;
    L11:
        return b;
    }
}
