package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d3 {
    public static byte[] a(String r5) {
        int r0 = 0;
        if (r5 == null) goto L12;
        if (r5.trim().length() <= 0) goto L12;
        int r1 = r5.length() / 2;
        byte[] r2 = new byte[r1];
        char[] r6 = r5.toCharArray();
    L8:
        if (r0 >= r1) goto L10;
        int r3 = r0 * 2;
        int r4 = a(r6[r3]) << 4;
        r2[r0] = (byte) (a(r6[r3 + 1]) | r4);
        r0 = r0 + 1;
        goto L8
    L10:
        return r2;
    L12:
        return new byte[0];
    }

    public static byte b(String r2) {
        if (r2 != null) goto L10;
    L8:
        return -1;
    L10:
        if (r2.trim().length() <= 0) goto L8;
        return Byte.valueOf(r2).byteValue();
    }

    public static int c(String r2) {
        if (r2 != null) goto L10;
    L8:
        return -1;
    L10:
        if (r2.trim().length() <= 0) goto L8;
        return Integer.valueOf(r2).intValue();
    }

    private static byte a(char r1) {
        return (byte) "0123456789ABCDEF".indexOf(r1);
    }
}
