package cz.msebera.android.httpclient;

/* JADX INFO: loaded from: classes5.dex */
public class HttpException extends Exception {
    private static final int FIRST_VALID_CHAR = 32;
    private static final long serialVersionUID = -5437299376222011036L;

    static String clean(String r6) {
        char[] r0 = r6.toCharArray();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L10;
        if (r0[r2] < ' ') goto L10;
        r2 = r2 + 1;
    L10:
        if (r2 != r0.length) goto L12;
        return r6;
    L12:
        StringBuilder r7 = new StringBuilder(r0.length * 2);
    L14:
        if (r1 >= r0.length) goto L24;
        char r3 = r0[r1];
        if (r3 >= ' ') goto L21;
        r7.append("[0x");
        String r4 = Integer.toHexString(r1);
        if (r4.length() != 1) goto L20;
        r7.append("0");
    L20:
        r7.append(r4);
        r7.append("]");
    L22:
        r1 = r1 + 1;
        goto L14
    L21:
        r7.append(r3);
        goto L22
    L24:
        return r7.toString();
    }

    public HttpException() {
    }

    public HttpException(String r1) {
        super(clean(r1));
    }

    public HttpException(String r1, Throwable r2) {
        super(clean(r1));
        initCause(r2);
    }
}
