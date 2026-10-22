package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net::android")
public class AndroidKeyStore {
    private static final String TAG = "AndroidKeyStore";

    public AndroidKeyStore() {
    }

    @CalledByNative
    private static byte[] encryptWithPrivateKey(PrivateKey r5, String r6, byte[] r7) {
        Cipher r3 = Cipher.getInstance(r6);     // Catch: Throwable -> L10
        r3.init(1, r5);     // Catch: Exception -> L7
        return r3.doFinal(r7);
    L7:
        e = move-exception;
        Log.e(TAG, "Exception while encrypting input with " + r6 + " and " + r5.getAlgorithm() + " private key (" + r5.getClass().getName() + "): " + e, new Object[0]);
        return null;
    L10:
        e = move-exception;
        Log.e(TAG, "Cipher " + r6 + " not supported: " + e, new Object[0]);
        return null;
    }

    @CalledByNative
    private static String getPrivateKeyClassName(PrivateKey r0) {
        return r0.getClass().getName();
    }

    @CalledByNative
    private static boolean privateKeySupportsCipher(PrivateKey r3, String r4) {
        Cipher.getInstance(r4).init(1, r3);     // Catch: Exception -> L5 Throwable -> L8
        return true;
    L5:
        e = move-exception;
        Log.e(TAG, "Exception while checking support for " + r4 + ": " + e, new Object[0]);
    L7:
        return false;
    }

    @CalledByNative
    private static boolean privateKeySupportsSignature(PrivateKey r3, String r4) {
        Signature.getInstance(r4).initSign(r3);     // Catch: Exception -> L6 Throwable -> L9
        return true;
    L6:
        e = move-exception;
        Log.e(TAG, "Exception while checking support for " + r4 + ": " + e, new Object[0]);
    L8:
        return false;
    }

    @CalledByNative
    private static byte[] signWithPrivateKey(PrivateKey r5, String r6, byte[] r7) {
        Signature r3 = Signature.getInstance(r6);     // Catch: NoSuchAlgorithmException -> L9
        r3.initSign(r5);     // Catch: Exception -> L6
        r3.update(r7);     // Catch: Exception -> L6
        return r3.sign();
    L6:
        e = move-exception;
        Log.e(TAG, "Exception while signing message with " + r6 + " and " + r5.getAlgorithm() + " private key (" + r5.getClass().getName() + "): " + e, new Object[0]);
        return null;
    L9:
        e = move-exception;
        Log.e(TAG, "Signature algorithm " + r6 + " not supported: " + e, new Object[0]);
        return null;
    }
}
