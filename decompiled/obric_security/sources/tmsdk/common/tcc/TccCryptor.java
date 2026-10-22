package tmsdk.common.tcc;

import android.content.Context;
import tmsdkobf.d;

/* JADX INFO: loaded from: classes5.dex */
public class TccCryptor {
    public TccCryptor() {
    }

    public static int EndianSwap(int r2) {
        int r0 = ((r2 << 24) | ((65280 & r2) << 8)) | ((16711680 & r2) >>> 8);
        return (r2 >>> 24) | r0;
    }

    public static void c_c(int r0) {
        d.a(true);
    }

    @Deprecated
    public static byte[] decrypt(Context r0, byte[] r1, byte[] r2) {
        return decrypt(r1, r2);
    }

    public static native byte[] decrypt(byte[] r0, byte[] r1);

    @Deprecated
    public static boolean decryptBoolean(Context r0, boolean r1) {
        return decryptBoolean(r1);
    }

    public static boolean decryptBoolean(boolean r0) {
        return !r0;
    }

    public static int decryptInt(int r0) {
        return ~r0;
    }

    public static long decryptLong(long r0) {
        return ~r0;
    }

    @Deprecated
    public static String encrypt(Context r0, String r1, String r2) {
        return encrypt(r1, r2);
    }

    public static native byte[] encrypt(byte[] r0, byte[] r1);

    @Deprecated
    public static boolean encryptBoolean(Context r0, boolean r1) {
        return encryptBoolean(r1);
    }

    public static boolean encryptBoolean(boolean r0) {
        return !r0;
    }

    public static int encryptInt(int r0) {
        return ~r0;
    }

    public static long encryptLong(long r0) {
        return ~r0;
    }

    @Deprecated
    public static byte[] makePassword(Context r0, byte[] r1) {
        return makePassword(r1);
    }

    public static native byte[] makePassword(byte[] r0);

    @Deprecated
    public static int decryptInt(Context r0, int r1) {
        return decryptInt(r1);
    }

    @Deprecated
    public static long decryptLong(Context r0, long r1) {
        return decryptLong(r1);
    }

    public static String encrypt(String r1, String r2) {
        byte[] r3 = r1.getBytes();
        if (r2 != null) goto L5;
        byte[] r4 = null;
    L7:
        return new String(encrypt(r3, r4));
    L5:
        r4 = r2.getBytes();
        goto L7
    }

    @Deprecated
    public static int encryptInt(Context r0, int r1) {
        return encryptInt(r1);
    }

    @Deprecated
    public static long encryptLong(Context r0, long r1) {
        return encryptLong(r1);
    }

    @Deprecated
    public static byte[] encrypt(Context r0, byte[] r1, byte[] r2) {
        return encrypt(r1, r2);
    }
}
