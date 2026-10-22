package tmsdkobf;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class k8 {
    public static String a(byte[] r1) {
        MessageDigest r0 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L4
        r0.update(r1);     // Catch: NoSuchAlgorithmException -> L4
        byte[] r2 = r0.digest();     // Catch: NoSuchAlgorithmException -> L4
    L6:
        return z1.a(r2);
    L4:
        r2 = null;
        goto L6
    }
}
