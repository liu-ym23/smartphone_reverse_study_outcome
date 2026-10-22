package com.loc;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public static PublicKey a(String r2) {
        byte[] r3 = j.c(r2);     // Catch: NullPointerException -> L4 InvalidKeySpecException -> L6 NoSuchAlgorithmException -> L8
        return KeyFactory.getInstance(u5.u("EUlNB")).generatePublic(new X509EncodedKeySpec(r3));
    L5:
        throw new Exception("公钥数据为空");
    L9:
        throw new Exception("无此算法");
    L7:
        throw new Exception("公钥非法");
    }

    public static byte[] b(byte[] r2, PublicKey r3) {
        Cipher r0 = Cipher.getInstance(u5.u("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));     // Catch: Throwable -> L4
        r0.init(1, r3);     // Catch: Throwable -> L4
        return r0.doFinal(r2);
    L4:
        return null;
    }
}
