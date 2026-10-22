package com.bytedance.privacy.pcc;

import android.util.Base64;
import com.bytedance.privacy.utils.PrivacyConst;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public final class CryptoUtils {
    static final int AES_GCM_NONCE_LEN = 12;
    private static final int AES_GCM_TAG_BITS = 128;
    private static final String TAG = "CryptoUtils";

    static {
    }

    private CryptoUtils() {
    }

    public static KeyPair generateEphemeralEcKeyPair() throws Exception {
        KeyPairGenerator r0 = KeyPairGenerator.getInstance(PrivacyConst.ALGORITHM_EC);
        r0.initialize(new ECGenParameterSpec("secp256r1"));
        return r0.generateKeyPair();
    }

    public static byte[] ecPubKeyToUncompressed(PublicKey r5) {
        ECPoint r6 = ((ECPublicKey) r5).getW();
        byte[] r0 = new byte[65];
        r0[0] = 4;
        System.arraycopy(toFixed32Bytes(r6.getAffineX()), 0, r0, 1, 32);
        System.arraycopy(toFixed32Bytes(r6.getAffineY()), 0, r0, 33, 32);
        return r0;
    }

    public static byte[] eciesWrapKey(PrivateKey r3, byte[] r4, String r5, byte[] r6, byte[] r7) throws Exception {
        byte[] r8 = Base64.decode(r5, 8);
        PublicKey r9 = KeyFactory.getInstance(PrivacyConst.ALGORITHM_EC).generatePublic(new X509EncodedKeySpec(r8));
        KeyAgreement r0 = KeyAgreement.getInstance("ECDH");
        r0.init(r3);
        r0.doPhase(r9, true);
        byte[] r10 = r0.generateSecret();
        byte[] r11 = ecPubKeyToUncompressed(r9);
        MessageDigest r1 = MessageDigest.getInstance("SHA-1");
        r1.update(r4);
        byte[] r12 = r1.digest();
        r1.reset();
        r1.update(r11);
        byte[] r13 = r1.digest();
        byte[] r2 = new byte[r12.length + r13.length];
        System.arraycopy(r12, 0, r2, 0, r12.length);
        System.arraycopy(r13, 0, r2, r12.length, r13.length);
        byte[] r14 = hkdf(r10, r6, r2, 44);
        return aesGcmEncrypt(Arrays.copyOf(r14, 32), Arrays.copyOfRange(r14, 32, 44), r7);
    }

    private static byte[] hkdf(byte[] r9, byte[] r10, byte[] r11, int r12) throws Exception {
        Mac r1 = Mac.getInstance("HmacSHA512");
        if (r10 != null) goto L5;
    L7:
        r10 = new byte[64];
    L8:
        r1.init(new SecretKeySpec(r10, "HmacSHA512"));
        byte[] r13 = r1.doFinal(r9);
        byte[] r14 = new byte[r12];
        byte[] r3 = new byte[0];
        int r5 = 0;
        int r6 = 1;
    L9:
        if (r5 >= r12) goto L14;
        r1.init(new SecretKeySpec(r13, "HmacSHA512"));
        r1.update(r3);
        if (r11 == null) goto L13;
        r1.update(r11);
    L13:
        r1.update((byte) r6);
        r3 = r1.doFinal();
        int r7 = Math.min(r3.length, r12 - r5);
        System.arraycopy(r3, 0, r14, r5, r7);
        r5 = r5 + r7;
        r6 = r6 + 1;
        goto L9
    L14:
        return r14;
    L5:
        if (r10.length <= 0) goto L7;
        goto L7
    }

    public static byte[] aesGcmEncrypt(byte[] r3, byte[] r4, byte[] r5) throws Exception {
        Cipher r0 = Cipher.getInstance("AES/GCM/NoPadding");
        r0.init(1, new SecretKeySpec(r3, "AES"), new GCMParameterSpec(128, r4));
        return r0.doFinal(r5);
    }

    public static byte[] aesGcmDecrypt(byte[] r3, byte[] r4, byte[] r5) throws Exception {
        Cipher r0 = Cipher.getInstance("AES/GCM/NoPadding");
        r0.init(2, new SecretKeySpec(r3, "AES"), new GCMParameterSpec(128, r4));
        return r0.doFinal(r5);
    }

    public static boolean verifyEcdsaSignature(String r2, byte[] r3, byte[] r4) throws Exception {
        byte[] r5 = r2.getBytes(StandardCharsets.UTF_8);
        X509Certificate r6 = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(r5));
        Signature r0 = Signature.getInstance("SHA256withECDSA");
        r0.initVerify(r6.getPublicKey());
        r0.update(r3);
        return r0.verify(r4);
    }

    public static String toHex(byte[] r6) {
        if (r6 != null) goto L5;
        return "null";
    L5:
        StringBuilder r0 = new StringBuilder(r6.length * 2);
        int r1 = r6.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L9;
        r0.append(String.format("%02x", new Object[]{Integer.valueOf(r6[r3] & 255)}));
        r3 = r3 + 1;
        goto L6
    L9:
        return r0.toString();
    }

    private static byte[] toFixed32Bytes(BigInteger r4) {
        byte[] r5 = r4.toByteArray();
        if (r5.length != 32) goto L5;
        return r5;
    L5:
        byte[] r0 = new byte[32];
        if (r5.length <= 32) goto L8;
        System.arraycopy(r5, r5.length - 32, r0, 0, 32);
    L9:
        return r0;
    L8:
        System.arraycopy(r5, 0, r0, 32 - r5.length, r5.length);
        goto L9
    }
}
