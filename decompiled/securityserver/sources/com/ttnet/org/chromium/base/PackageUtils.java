package com.ttnet.org.chromium.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PackageUtils {
    private static final char[] HEX_CHAR_LOOKUP = null;
    private static final String TAG = "PackageUtils";

    static {
        HEX_CHAR_LOOKUP = "0123456789ABCDEF".toCharArray();
    }

    private PackageUtils() {
    }

    public static String byteArrayToHexString(byte[] r4) {
        StringBuilder r0 = new StringBuilder((r4.length * 3) - 1);
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L10;
        char[] r2 = HEX_CHAR_LOOKUP;
        r0.append(r2[(r4[r1] & 240) >>> 4]);
        r0.append(r2[r4[r1] & 15]);
        if (r1 >= (r4.length - 1)) goto L8;
        r0.append(':');
    L8:
        r1 = r1 + 1;
        goto L4
    L10:
        return r0.toString();
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static List<String> getCertificateSHA256FingerprintForPackage(PackageManager r6, String r7) {
        PackageInfo r8 = r6.getPackageInfo(r7, 64);     // Catch: PackageManager.NameNotFoundException -> L16
        if (r8 != null) goto L6;
        return null;
    L6:
        ArrayList r9 = new ArrayList(r8.signatures.length);
        Signature[] r10 = r8.signatures;
        int r0 = r10.length;
        int r3 = 0;
    L7:
        if (r3 >= r0) goto L15;
        String r4 = byteArrayToHexString(MessageDigest.getInstance("SHA256").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(r10[r3].toByteArray()))).getEncoded()));     // Catch: Throwable -> L11 CertificateEncodingException -> L13
    L12:
        r9.add(r4);
        r3 = r3 + 1;
    L11:
        r4 = null;
    L13:
        Log.w(TAG, "Certificate type X509 encoding failed", new Object[0]);
        return null;
    L15:
        return r9;
    L16:
        return null;
    }

    public static int getPackageVersion(Context r2, String r3) {
        PackageInfo r4 = r2.getPackageManager().getPackageInfo(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L7
        if (r4 == null) goto L10;
        return r4.versionCode;
    L10:
        return -1;
    L11:
        return -1;
    }

    public static boolean isPackageInstalled(Context r1, String r2) {
        r1.getPackageManager().getPackageInfo(r2, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        return true;
    L6:
        return false;
    }
}
