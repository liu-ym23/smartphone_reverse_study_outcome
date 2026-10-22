package tmsdkobf;

import kotlin.UByte;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c3 {
    public static final String a(byte[] r6) {
        if (r6 != null) goto L5;
        return "";
    L5:
        StringBuffer r0 = new StringBuffer(r6.length);
        int r2 = 0;
    L7:
        if (r2 >= r6.length) goto L13;
        String r3 = Integer.toHexString(r6[r2] & UByte.MAX_VALUE);
        if (r3.length() >= 2) goto L11;
        r0.append(0);
    L11:
        r0.append(r3.toUpperCase());
        r2 = r2 + 1;
        goto L7
    L13:
        return r0.toString();
    }

    public static int b(byte[] r3) {
        if (r3.length == 4) goto L5;
        return 0;
    L5:
        int r0 = ((r3[0] & UByte.MAX_VALUE) | ((r3[1] & UByte.MAX_VALUE) << 8)) | ((r3[2] & UByte.MAX_VALUE) << 16);
        return ((r3[3] & UByte.MAX_VALUE) << 24) | r0;
    }

    public static final String c(byte[] r3) {
        if (r3 != null) goto L5;
        return "";
    L5:
        StringBuffer r0 = new StringBuffer(r3.length);
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L10;
        r0.append((char) r3[r1]);
        r1 = r1 + 1;
        goto L7
    L10:
        return r0.toString().toUpperCase();
    }

    public static byte[] a(String r5) {
        int r0 = r5.length() / 2;
        byte[] r1 = new byte[r0];
        char[] r6 = r5.toCharArray();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        int r3 = r2 * 2;
        int r4 = a(r6[r3]) << 4;
        r1[r2] = (byte) (a(r6[r3 + 1]) | r4);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    private static byte a(char r1) {
        return (byte) "0123456789ABCDEF".indexOf(r1);
    }
}
