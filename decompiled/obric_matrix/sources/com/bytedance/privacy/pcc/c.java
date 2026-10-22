package com.bytedance.privacy.pcc;

import android.util.Base64;
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

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5417a = "c";

    static {
    }

    public static byte[] a(byte[] r3, byte[] r4, byte[] r5) {
        Cipher r0 = Cipher.getInstance("AES/GCM/NoPadding");
        r0.init(2, new SecretKeySpec(r3, "AES"), new GCMParameterSpec(128, r4));
        return r0.doFinal(r5);
    }

    public static byte[] b(byte[] r3, byte[] r4, byte[] r5) {
        Cipher r0 = Cipher.getInstance("AES/GCM/NoPadding");
        r0.init(1, new SecretKeySpec(r3, "AES"), new GCMParameterSpec(128, r4));
        return r0.doFinal(r5);
    }

    public static byte[] c(PublicKey r5) {
        ECPoint r6 = ((ECPublicKey) r5).getW();
        byte[] r0 = new byte[65];
        r0[0] = 4;
        System.arraycopy(g(r6.getAffineX()), 0, r0, 1, 32);
        System.arraycopy(g(r6.getAffineY()), 0, r0, 33, 32);
        return r0;
    }

    public static byte[] d(PrivateKey r5, byte[] r6, String r7, byte[] r8, byte[] r9) {
        PublicKey r10 = KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(Base64.decode(r7, 8)));
        KeyAgreement r0 = KeyAgreement.getInstance("ECDH");
        r0.init(r5);
        r0.doPhase(r10, true);
        byte[] r11 = r0.generateSecret();
        String r1 = f5417a;
        com.bytedance.privacy.f.b.a(r1, "eciesWrapKey sharedSecret=" + h(r11));
        byte[] r12 = c(r10);
        MessageDigest r2 = MessageDigest.getInstance("SHA-1");
        r2.update(r6);
        byte[] r13 = r2.digest();
        r2.reset();
        r2.update(r12);
        byte[] r14 = r2.digest();
        byte[] r3 = new byte[r13.length + r14.length];
        System.arraycopy(r13, 0, r3, 0, r13.length);
        System.arraycopy(r14, 0, r3, r13.length, r14.length);
        com.bytedance.privacy.f.b.a(r1, "eciesWrapKey SHA1(clientPK)=" + h(r13) + " SHA1(serverPK)=" + h(r14));
        StringBuilder r15 = new StringBuilder();
        r15.append("eciesWrapKey salt=");
        r15.append(h(r8));
        com.bytedance.privacy.f.b.a(r1, r15.toString());
        byte[] r16 = f(r11, r8, r3, 44);
        byte[] r17 = Arrays.copyOf(r16, 32);
        byte[] r18 = Arrays.copyOfRange(r16, 32, 44);
        com.bytedance.privacy.f.b.a(r1, "eciesWrapKey KEK=" + h(r17) + " IV=" + h(r18));
        return b(r17, r18, r9);
    }

    public static KeyPair e() {
        KeyPairGenerator r0 = KeyPairGenerator.getInstance("EC");
        r0.initialize(new ECGenParameterSpec("secp256r1"));
        return r0.generateKeyPair();
    }

    private static byte[] f(byte[] r9, byte[] r10, byte[] r11, int r12) {
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

    private static byte[] g(BigInteger r4) {
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

    public static String h(byte[] r6) {
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

    public static boolean i(String r2, byte[] r3, byte[] r4) {
        byte[] r5 = r2.getBytes(StandardCharsets.UTF_8);
        X509Certificate r6 = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(r5));
        Signature r0 = Signature.getInstance("SHA256withECDSA");
        r0.initVerify(r6.getPublicKey());
        r0.update(r3);
        return r0.verify(r4);
    }
}
