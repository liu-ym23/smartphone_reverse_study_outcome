package com.bytedance.feedbackerlib.m;

import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class a {
    @Nullable
    public static String a(@NonNull String r5, @NonNull String r6) {
        Cipher r1 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: IllegalBlockSizeException -> L5 BadPaddingException -> L7 InvalidKeyException -> L9 InvalidAlgorithmParameterException -> L11 NoSuchPaddingException -> L13 NoSuchAlgorithmException -> L15
        r1.init(1, new SecretKeySpec(r5.getBytes(), "AES"), new IvParameterSpec(new byte[r1.getBlockSize()]));     // Catch: IllegalBlockSizeException -> L5 BadPaddingException -> L7 InvalidKeyException -> L9 InvalidAlgorithmParameterException -> L11 NoSuchPaddingException -> L13 NoSuchAlgorithmException -> L15
        return Base64.encodeToString(r1.doFinal(r6.getBytes()), 0).replace("\n", "");
    L11:
        e = move-exception;
        String r7 = e.getMessage();
        Throwable r8 = e;
    L17:
        c.a("AESUtils", r7, r8);
        return null;
    L9:
        e = move-exception;
        r7 = e.getMessage();
        r8 = e;
    L15:
        e = move-exception;
        r7 = e.getMessage();
        r8 = e;
    L7:
        e = move-exception;
        r7 = e.getMessage();
        r8 = e;
    L5:
        e = move-exception;
        r7 = e.getMessage();
        r8 = e;
    L13:
        e = move-exception;
        r7 = e.getMessage();
        r8 = e;
        goto L17
    }
}
