package com.bytedance.ttnet.utils;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class RsaDecoder {
    private static final String PUB_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQwuhlG2hSvAH1pxaCawFQTHQPEa+MLm0muwhkPd6hCTxmodQOCTbwWzaZazk8GDtV4AwBAM8jIeHP7z9bYxmZeT/lKjgvbplEWURevOQ4O6rYahjL8i4vyf431ocW+POx+kQbJ8Tr4EAuqjEUmP2nw6WUQ6/hMjQv/CS6SfqpEQIDAQAB";

    public RsaDecoder() {
    }

    public static String decodeSign(String r4) throws Throwable {
        X509EncodedKeySpec r2 = new X509EncodedKeySpec(Base64.decode(PUB_KEY, 0));
        PublicKey r0 = KeyFactory.getInstance("RSA").generatePublic(r2);
        Cipher r3 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r3.init(2, r0);
        return new String(r3.doFinal(Base64.decode(r4, 0)));
    }

    public static byte[] encode(byte[] r3) throws Throwable {
        X509EncodedKeySpec r1 = new X509EncodedKeySpec(Base64.decode(PUB_KEY, 0));
        PublicKey r0 = KeyFactory.getInstance("RSA").generatePublic(r1);
        Cipher r2 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        r2.init(1, r0);
        return r2.doFinal(r3);
    }

    public static byte[] aesEncrpt(byte[] r3, String r4) throws Exception {
        SecretKeySpec r0 = new SecretKeySpec(r3, "AES");
        Cipher r5 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        r5.init(1, r0);
        byte[] r6 = r5.doFinal(r4.getBytes("UTF-8"));
        byte[] r1 = new byte[r6.length + 16];
        System.arraycopy(r5.getIV(), 0, r1, 0, 16);
        System.arraycopy(r6, 0, r1, 16, r6.length);
        return r1;
    }
}
