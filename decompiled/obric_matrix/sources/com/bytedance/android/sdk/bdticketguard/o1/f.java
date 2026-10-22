package com.bytedance.android.sdk.bdticketguard.o1;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bytedance.android.sdk.bdticketguard.s0;
import com.bytedance.android.sdk.bdticketguard.z0;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import kotlin.b0;
import kotlin.n0.d.o;
import net.bytedance.zdplib.Delta;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f959b = null;

    static {
        f959b = new f();
    }

    private f() {
    }

    public static final String a(Certificate r2) {
        o.g(r2, "cert");
        l.b.h.i.c.b r0 = new l.b.h.i.c.b("CERTIFICATE", r2.getEncoded());
        StringWriter r3 = new StringWriter();
        l.b.h.i.c.d r1 = new l.b.h.i.c.d(r3);
        r1.b(r0);
        r1.close();
        r3.close();
        String r4 = r3.toString();
        o.b(r4, "stringWriter.toString()");
        return r4;
    }

    public static final boolean b(String r2, SharedPreferences r3, String r4, String r5) {
        o.g(r3, "sp");
        if (Build.VERSION.SDK_INT >= 23) goto L12;
        String r6 = r3.getString(r4, null);
        String r7 = r3.getString(r5, null);
        if (TextUtils.isEmpty(r6) == false) goto L8;
    L10:
        return false;
    L8:
        if (TextUtils.isEmpty(r7) == true) goto L10;
        return true;
    L12:
        return f959b.i().containsAlias(r2);
    }

    @RequiresApi(24)
    @SuppressLint({"UseSdkSuppress"})
    private final KeyPair e(com.bytedance.android.sdk.bdticketguard.i r4, com.bytedance.android.sdk.bdticketguard.o1.j.f r5) {
        String r3 = r5.e();
        String r0 = r5.c();
        com.bytedance.android.sdk.bdticketguard.o1.j.g r6 = r5.a();
        String r7 = r3 + '#' + r0;
        MessageDigest r1 = MessageDigest.getInstance("SHA-256");
        Charset r2 = kotlin.u0.d.f21429a;
        if (r7 == null) goto L7;
        byte[] r8 = r7.getBytes(r2);
        o.b(r8, "(this as java.lang.String).getBytes(charset)");
        byte[] r9 = r1.digest(r8);
        r4.l(Base64.encodeToString(r9, 2));
        KeyGenParameterSpec r10 = new KeyGenParameterSpec.Builder("bd_ticket_guard_key_attestation", 4).setDigests(new String[]{"SHA-256"}).setAttestationChallenge(r9).build();
        o.b(r10, "KeyGenParameterSpec.Buil…nge)\n            .build()");
        KeyPair r11 = r6.e(r10).generateKeyPair();
        o.b(r11, "keyGen.generateKeyPair()");
        return r11;
    L7:
        throw new b0("null cannot be cast to non-null type java.lang.String");
    }

    public static final String f(KeyPair r4, String r5) {
        o.g(r4, "keyPair");
        l.b.e.a r0 = new l.b.e.f.a("SHA256withECDSA").b(r4.getPrivate());
        l.b.f.c.a r6 = f959b.c(r5, r4);
        l.b.a.v2.e r7 = new l.b.a.v2.e();
        r7.a(l.b.a.v2.c.f21773i, true, new l.b.a.v2.b(true));
        r6.a(l.b.a.r2.d.A, r7.c());
        l.b.f.a r8 = r6.b(r0);
        o.b(r8, "csr");
        l.b.h.i.c.b r9 = new l.b.h.i.c.b("CERTIFICATE REQUEST", r8.a());
        StringWriter r10 = new StringWriter();
        l.b.h.i.c.d r1 = new l.b.h.i.c.d(r10);
        r1.b(r9);
        r1.close();
        r10.close();
        String r11 = r10.toString();
        o.b(r11, "stringWriter.toString()");
        return r11;
    }

    public static final KeyPair g(String r4, SharedPreferences.Editor r5, String r6, String r7) {
        o.g(r5, "editor");
        if (Build.VERSION.SDK_INT < 23) goto L5;
        KeyPairGenerator r8 = KeyPairGenerator.getInstance("EC", "AndroidKeyStore");
        o.b(r8, "KeyPairGenerator.getInst…Y_STORE_PROVIDER_ANDROID)");
        r8.initialize(f959b.j(r4));
        KeyPair r9 = r8.generateKeyPair();
        o.b(r9, "keyGen.generateKeyPair()");
        return r9;
    L5:
        KeyPairGenerator r10 = KeyPairGenerator.getInstance("EC", "BC");
        o.b(r10, "KeyPairGenerator.getInst…M, KEY_STORE_PROVIDER_BC)");
        r10.initialize(256, new SecureRandom());
        KeyPair r11 = r10.generateKeyPair();
        o.b(r11, "keyGen.generateKeyPair()");
        PublicKey r0 = r11.getPublic();
        o.b(r0, "keyPair.public");
        r5.putString(r6, h.a(r0));
        PrivateKey r12 = r11.getPrivate();
        o.b(r12, "keyPair.private");
        r5.putString(r7, h.a(r12));
        r5.apply();
        return r11;
    }

    @RequiresApi(24)
    @SuppressLint({"UseSdkSuppress"})
    public static final Certificate[] h(com.bytedance.android.sdk.bdticketguard.i r12, com.bytedance.android.sdk.bdticketguard.o1.j.f r13) {
        o.g(r12, "snapshot");
        o.g(r13, "attestationInfo");
        KeyStore r0 = r13.a().b();
        boolean r2 = r0.containsAlias("bd_ticket_guard_key_attestation");
        r12.s(true);
        if (r2 == true) goto L5;
    L8:
        s0.f1065a.e("TeeKeyHelper", "Key attestation, genAttestationKey");
        f959b.e(r12, r13);     // Catch: Throwable -> L25
        r12.p(true);     // Catch: Throwable -> L25
        f958a = true;     // Catch: Throwable -> L25
    L30:
        Certificate[] r14 = r0.getCertificateChain("bd_ticket_guard_key_attestation");     // Catch: Throwable -> L22
        if (r14 == null) goto L21;
        if (r14.length != 0) goto L15;
        boolean r1 = true;
    L17:
        if ((!r1) == false) goto L21;
        s0.f1065a.e("TeeKeyHelper", "Key attestation success, certChain size=" + r14.length);
        return r14;
    L15:
        r1 = false;
    L21:
        throw new com.bytedance.android.sdk.bdticketguard.c(r12, -1102, "getCertificateChain fail, certChain is empty", null, 8, null);
    L22:
        th = move-exception;
        throw new com.bytedance.android.sdk.bdticketguard.c(r12, -1102, "getCertificateChain fail", th);
    L25:
        th = move-exception;
        throw new com.bytedance.android.sdk.bdticketguard.c(r12, -1101, "genAttestationKeyPair fail", th);
    L5:
        if (r13.d() == true) goto L8;
        s0.f1065a.e("TeeKeyHelper", "Key attestation, key already exists");
        goto L30
    }

    private final KeyStore i() {
        KeyStore r1 = KeyStore.getInstance("AndroidKeyStore");
        r1.load(null);
        o.b(r1, "keyStore");
        return r1;
    }

    public static final boolean l(byte[] r2, PrivateKey r3) {
        o.g(r2, "cert");
        o.g(r3, "privateKey");
        byte[] r0 = "test".getBytes(kotlin.u0.d.f21429a);
        o.b(r0, "(this as java.lang.String).getBytes(charset)");
        byte[] r4 = p(r3, r0);
        X509Certificate r5 = o(r2);
        if (r5 == null) goto L8;
        boolean r6 = q(r5, r0, r4);
        if (r6 == true) goto L7;
        z0.A();
    L7:
        return r6;
    L8:
        return false;
    }

    public static final KeyPair m(String r3, SharedPreferences r4, String r5, String r6) {
        o.g(r4, "sp");
        if (Build.VERSION.SDK_INT < 23) goto L8;
        KeyStore.Entry r7 = f959b.i().getEntry(r3, null);
        if ((r7 instanceof KeyStore.PrivateKeyEntry) == false) goto L7;
        KeyStore.PrivateKeyEntry r8 = (KeyStore.PrivateKeyEntry) r7;
        Certificate r9 = r8.getCertificate();
        o.b(r9, "entry.certificate");
        PublicKey r10 = r9.getPublicKey();
        PrivateKey r11 = r8.getPrivateKey();
    L9:
        if (r10 == null) goto L13;
        if (r11 != null) goto L12;
        return null;
    L12:
        return new KeyPair(r10, r11);
    L13:
        return null;
    L7:
        r11 = null;
        r10 = null;
        goto L9
    L8:
        PublicKey r12 = KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(Base64.decode(r4.getString(r5, null), 0)));
        r11 = KeyFactory.getInstance("EC").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(r4.getString(r6, null), 0)));
        r10 = r12;
        goto L9
    }

    public static final String n(ECPublicKey r4) {
        o.g(r4, "ecPublicKey");
        ECPoint r5 = r4.getW();
        o.b(r5, "point");
        byte[] r0 = r5.getAffineX().toByteArray();
        byte[] r6 = r5.getAffineY().toByteArray();
        if (r0[0] != 0) goto L6;
        r0 = Arrays.copyOfRange(r0, 1, r0.length);
    L6:
        if (r6[0] != 0) goto L9;
        r6 = Arrays.copyOfRange(r6, 1, r6.length);
    L9:
        return "04" + Delta.d(r0) + Delta.d(r6);
    }

    public static final X509Certificate o(byte[] r1) {
        o.g(r1, "cert");
        ByteArrayInputStream r0 = new ByteArrayInputStream(r1);
        Certificate r2 = CertificateFactory.getInstance("X.509").generateCertificate(r0);
        r0.close();
        if ((r2 instanceof X509Certificate) == true) goto L7;
        return null;
    L7:
        return (X509Certificate) r2;
    }

    public static final byte[] p(PrivateKey r1, byte[] r2) {
        o.g(r1, "privateKey");
        o.g(r2, "data");
        Signature r0 = Signature.getInstance("SHA256withECDSA");
        r0.initSign(r1);
        r0.update(r2);
        byte[] r3 = r0.sign();
        o.b(r3, "s.sign()");
        return r3;
    }

    public static final boolean q(Certificate r1, byte[] r2, byte[] r3) {
        o.g(r1, "certificate");
        o.g(r2, "data");
        o.g(r3, "signature");
        Signature r0 = Signature.getInstance("SHA256withECDSA");
        r0.initVerify(r1);
        r0.update(r2);
        return r0.verify(r3);
    }

    @VisibleForTesting
    public final l.b.f.c.a c(String r2, KeyPair r3) {
        o.g(r3, "keyPair");
        return new l.b.f.c.a(new l.b.a.u2.c(r2), r3.getPublic());
    }

    public final void d(KeyStore r3, String r4) {
        o.g(r3, "keyStore");
        o.g(r4, "keystoreAlias");
        if (r3.containsAlias(r4) == false) goto L6;
        s0.f1065a.e("TeeKeyHelper", "Key attestation, need regenerate, delete old key");
        r3.deleteEntry(r4);
        return;
    }

    @SuppressLint({"NewApi"})
    @VisibleForTesting
    public final KeyGenParameterSpec j(String r2) {
        if (r2 == null) goto L6;
        KeyGenParameterSpec r1 = new KeyGenParameterSpec.Builder(r2, 4).setDigests(new String[]{"SHA-256"}).build();
        o.b(r1, "KeyGenParameterSpec.Buil…256)\n            .build()");
        return r1;
    L6:
        o.p();
        throw null;
    }

    public final boolean k() {
        return f958a;
    }
}
