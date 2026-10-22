package d.c.c.k;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class c {
    static {
    }

    public static String a(byte[] r3) {
        MessageDigest r0 = MessageDigest.getInstance("SHA-1");     // Catch: NoSuchAlgorithmException -> L4
        r0.update(r3, 0, r3.length);     // Catch: NoSuchAlgorithmException -> L4
        return Base64.encodeToString(r0.digest(), 11);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
