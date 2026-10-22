package com.android.settings;

import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes2.dex */
public class RSAUtil {
    public static final String PUBLIC_KEY_IN = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAMeJ3XDpt/K3YRR93Z1hSkGpVKt16laMdQes3fePGpF6\rB1bNEYG0Kps3sfAjHrTv4wkbq7xyXRq6r93CbQuLnzsCAwEAAQ==\r";

    public RSAUtil() {
    }

    public static PublicKey getPublicKey(String r1) throws Exception {
        X509EncodedKeySpec r0 = new X509EncodedKeySpec(base64Dec(r1));
        return KeyFactory.getInstance("RSA").generatePublic(r0);
    }

    public static String encryptData(String r2, PublicKey r3) {
        Cipher r0 = Cipher.getInstance("RSA");     // Catch: NoSuchPaddingException -> L4 NoSuchAlgorithmException -> L6 BadPaddingException -> L8 InvalidKeyException -> L10 IllegalBlockSizeException -> L12
        byte[] r4 = r2.getBytes();     // Catch: NoSuchPaddingException -> L4 NoSuchAlgorithmException -> L6 BadPaddingException -> L8 InvalidKeyException -> L10 IllegalBlockSizeException -> L12
        r0.init(1, (RSAPublicKey) r3);     // Catch: NoSuchPaddingException -> L4 NoSuchAlgorithmException -> L6 BadPaddingException -> L8 InvalidKeyException -> L10 IllegalBlockSizeException -> L12
    L18:
        return base64Enc(r0.doFinal(r4));
    L10:
        e = move-exception;
        e.printStackTrace();
    L14:
        return null;
    L6:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = move-exception;
        e.printStackTrace();
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static String base64Enc(byte[] r1) {
        return Base64.encodeToString(r1, 0);
    }

    public static byte[] base64Dec(String r1) {
        return Base64.decode(r1, 0);
    }
}
