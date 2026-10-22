package cz.msebera.android.httpclient.util;

import cz.msebera.android.httpclient.Consts;

/* JADX INFO: loaded from: classes5.dex */
public final class EncodingUtils {
    public static String getString(byte[] r1, int r2, int r3, String r4) {
        Args.notNull(r1, "Input");
        Args.notEmpty(r4, "Charset");
        return new String(r1, r2, r3, r4);
    L6:
        return new String(r1, r2, r3);
    }

    public static String getString(byte[] r2, String r3) {
        Args.notNull(r2, "Input");
        return getString(r2, 0, r2.length, r3);
    }

    public static byte[] getBytes(String r1, String r2) {
        Args.notNull(r1, "Input");
        Args.notEmpty(r2, "Charset");
        return r1.getBytes(r2);
    L6:
        return r1.getBytes();
    }

    public static byte[] getAsciiBytes(String r1) {
        Args.notNull(r1, "Input");
        return r1.getBytes(Consts.ASCII);
    }

    public static String getAsciiString(byte[] r2, int r3, int r4) {
        Args.notNull(r2, "Input");
        return new String(r2, r3, r4, Consts.ASCII);
    }

    public static String getAsciiString(byte[] r2) {
        Args.notNull(r2, "Input");
        return getAsciiString(r2, 0, r2.length);
    }

    private EncodingUtils() {
    }
}
