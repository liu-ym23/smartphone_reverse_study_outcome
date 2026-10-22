package tmsdkobf;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes5.dex */
public abstract class v5 {
    public static String a(Signature r6, String r7) {
        byte[] r8 = r6.toByteArray();
        MessageDigest r9 = MessageDigest.getInstance(r7);     // Catch: NoSuchAlgorithmException -> L11
        if (r9 != null) goto L6;
        return null;
    L6:
        byte[] r10 = r9.digest(r8);     // Catch: NoSuchAlgorithmException -> L11
        StringBuilder r11 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L11
        int r1 = r10.length;     // Catch: NoSuchAlgorithmException -> L11
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        r11.append(Integer.toHexString((r10[r2] & UByte.MAX_VALUE) | 256).substring(1, 3));     // Catch: NoSuchAlgorithmException -> L11
        r2 = r2 + 1;     // Catch: NoSuchAlgorithmException -> L11
        goto L7
    L9:
        return r11.toString();
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Signature[] a(Context r1, String r2) {
        return r1.getPackageManager().getPackageInfo(r2, 64).signatures;
    L4:
        return null;
    }

    public static String a(Context r4, String r5, String r6) {
        Signature[] r7 = a(r4, r5);
        if (r7 == null) goto L11;
        int r8 = r7.length;
        int r0 = 0;
    L5:
        if (r0 >= r8) goto L15;
        Signature r1 = r7[r0];
        if ("SHA1".equals(r6) == true) goto L9;
        r0 = r0 + 1;
        goto L5
    L9:
        return a(r1, "SHA1");
    L15:
        return null;
    L11:
        return null;
    }
}
