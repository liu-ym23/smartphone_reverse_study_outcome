package com.google.crypto.tink.internal;

import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class Util {
    public static final Charset UTF_8 = null;

    static {
        UTF_8 = Charset.forName("UTF-8");
    }

    public static int randKeyId() {
        SecureRandom r0 = new SecureRandom();
        byte[] r1 = new byte[4];
        int r3 = 0;
    L3:
        if (r3 != 0) goto L5;
        r0.nextBytes(r1);
        r3 = ((((r1[0] & 255) << 24) | ((r1[1] & 255) << 16)) | ((r1[2] & 255) << 8)) | (r1[3] & 255);
        goto L3
    L5:
        return r3;
    }

    private static final byte toByteFromPrintableAscii(char c) {
        if (c < '!') goto L9;
        if (c > '~') goto L9;
        return (byte) c;
    L9:
        throw new TinkBugException("Not a printable ASCII character: " + c);
    }

    private static final byte checkedToByteFromPrintableAscii(char c) throws GeneralSecurityException {
        if (c < '!') goto L9;
        if (c > '~') goto L9;
        return (byte) c;
    L9:
        throw new GeneralSecurityException("Not a printable ASCII character: " + c);
    }

    public static final Bytes toBytesFromPrintableAscii(String s) {
        byte[] r0 = new byte[s.length()];
        int r1 = 0;
    L4:
        if (r1 >= s.length()) goto L7;
        r0[r1] = toByteFromPrintableAscii(s.charAt(r1));
        r1 = r1 + 1;
        goto L4
    L7:
        return Bytes.copyFrom(r0);
    }

    public static final Bytes checkedToBytesFromPrintableAscii(String s) throws GeneralSecurityException {
        byte[] r0 = new byte[s.length()];
        int r1 = 0;
    L4:
        if (r1 >= s.length()) goto L7;
        r0[r1] = checkedToByteFromPrintableAscii(s.charAt(r1));
        r1 = r1 + 1;
        goto L4
    L7:
        return Bytes.copyFrom(r0);
    }

    public static boolean isAndroid() {
        return Objects.equals(System.getProperty("java.vendor"), "The Android Project");
    }

    @Nullable
    public static Integer getAndroidApiLevel() {
        if (isAndroid() == true) goto L7;
        return null;
    L7:
        return BuildDispatchedCode.getApiLevel();
    }

    public static boolean isPrefix(byte[] prefix, byte[] complete) {
        if (complete.length >= prefix.length) goto L5;
        return false;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= prefix.length) goto L12;
        if (complete[r0] != prefix[r0]) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static SecretBytes readIntoSecretBytes(InputStream input, int length, SecretKeyAccess access) throws GeneralSecurityException {
        byte[] r0 = new byte[length];
        int r1 = 0;
    L3:
        if (r1 >= length) goto L13;
        int r2 = input.read(r0, r1, length - r1);     // Catch: IOException -> L10
        if (r2 == (-1)) goto L9;
        r1 = r1 + r2;     // Catch: IOException -> L10
        goto L3
    L9:
        throw new GeneralSecurityException("Not enough pseudorandomness provided");     // Catch: IOException -> L10
    L11:
        throw new GeneralSecurityException("Reading pseudorandomness failed");
    L13:
        return SecretBytes.copyFrom(r0, access);
    }

    private Util() {
    }
}
