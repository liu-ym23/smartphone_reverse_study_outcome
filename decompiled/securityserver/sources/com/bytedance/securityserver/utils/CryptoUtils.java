package com.bytedance.securityserver.utils;

import android.util.Log;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.ECPublicKey;

/* JADX INFO: loaded from: classes.dex */
public class CryptoUtils {
    public static boolean a(PublicKey r3, byte[] r4, byte[] r5, String r6) {
        if (r3 == null) goto L17;
        if (r4 == null) goto L17;
        if (r5 == null) goto L17;
        if (r6 == null) goto L17;
        if ((r3 instanceof ECPublicKey) == true) goto L19;
        Log.e("SecurityServer-CryptoUtils", "Provided publicKey is not an EC public key");
        return false;
    L19:
        Signature r7 = Signature.getInstance(r6);     // Catch: Throwable -> L14
        r7.initVerify(r3);     // Catch: Throwable -> L14
        r7.update(r4);     // Catch: Throwable -> L14
        return r7.verify(r5);
    L14:
        e = move-exception;
        Log.e("SecurityServer-CryptoUtils", "verifyECDSASignature failed, exception: " + e.getMessage());
        return false;
    L17:
        Log.e("SecurityServer-CryptoUtils", "Input params is invalid(null)");
        return false;
    }
}
