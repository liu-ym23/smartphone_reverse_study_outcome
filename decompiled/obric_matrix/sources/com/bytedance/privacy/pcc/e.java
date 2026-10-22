package com.bytedance.privacy.pcc;

import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.g;
import com.google.gson.m;
import com.google.gson.o;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5420a = "e";

    static {
    }

    private static byte[] a(String r2, String r3, String r4, String r5, List<com.bytedance.privacy.pcc.h.b.c.d> r6) {
        MessageDigest r0 = MessageDigest.getInstance("SHA-256");
        r0.update(r2.getBytes(StandardCharsets.UTF_8));
        r0.update(r3.getBytes(StandardCharsets.UTF_8));
        r0.update(r4.getBytes(StandardCharsets.UTF_8));
        r0.update(r5.getBytes(StandardCharsets.UTF_8));
        if (r6 == null) goto L18;
        ArrayList r7 = new ArrayList(r6);
        r7.sort(Comparator.comparingInt(a.f5412a));
        int r8 = 0;
    L6:
        if (r8 >= r7.size()) goto L18;
        com.bytedance.privacy.pcc.h.b.c.d r9 = (com.bytedance.privacy.pcc.h.b.c.d) r7.get(r8);
        if (r9.a() == null) goto L11;
        r0.update(r9.a().getBytes(StandardCharsets.UTF_8));
    L11:
        if (r9.d() == null) goto L14;
        r0.update(r9.d().getBytes(StandardCharsets.UTF_8));
    L14:
        if (r9.e() == null) goto L16;
        r0.update(r9.e().getBytes(StandardCharsets.UTF_8));
    L16:
        r8 = r8 + 1;
    L18:
        return r0.digest();
    }

    private static byte[] b(byte[] r4) {
        int r0 = 0;
    L4:
        if (r0 >= (r4.length - 1)) goto L9;
        if (r4[r0] != 0) goto L9;
        r0 = r0 + 1;
    L9:
        if ((r4[r0] & 128) == 0) goto L13;
        byte[] r1 = new byte[(r4.length - r0) + 1];
        System.arraycopy(r4, r0, r1, 1, r4.length - r0);
        return r1;
    L13:
        return Arrays.copyOfRange(r4, r0, r4.length);
    }

    private static byte[] c(byte[] r6) {
        int r0 = r6.length / 2;
        byte[] r3 = b(Arrays.copyOfRange(r6, 0, r0));
        byte[] r7 = b(Arrays.copyOfRange(r6, r0, r6.length));
        int r1 = ((r3.length + 2) + 2) + r7.length;
        byte[] r4 = new byte[r1 + 2];
        r4[0] = 48;
        r4[1] = (byte) r1;
        r4[2] = 2;
        r4[3] = (byte) r3.length;
        System.arraycopy(r3, 0, r4, 4, r3.length);
        int r5 = 4 + r3.length;
        int r2 = r5 + 1;
        r4[r5] = 2;
        r4[r2] = (byte) r7.length;
        System.arraycopy(r7, 0, r4, r2 + 1, r7.length);
        return r4;
    }

    public static boolean d(String r16, String r17, String r18, String r19, String r20, List<com.bytedance.privacy.pcc.h.b.c.d> r21, String r22) {
        String r2 = f5420a;
        com.bytedance.privacy.f.b.a(r2, "verify: start JWT evidence token verification");
        String[] r3 = r16.split("\\.");
        if (r3.length != 3) goto L106;
        String r5 = r3[0];
        String r7 = r3[1];
        String r4 = r3[2];
        String r11 = new String(Base64.decode(r5, 9), StandardCharsets.UTF_8);
        com.bytedance.privacy.f.b.a(r2, "header: " + r11);
        m r10 = o.c(r11).c();
        String r13 = "";
        if (r10.z("alg") == false) goto L7;
        String r12 = r10.v("alg").l();
    L9:
        if ("ES256".equals(r12) == false) goto L104;
        com.bytedance.privacy.f.b.a(r2, "verify: header alg=ES256 OK");
        String r14 = new String(Base64.decode(r7, 9), StandardCharsets.UTF_8);
        com.bytedance.privacy.f.b.a(r2, "payload: " + r14);
        m r15 = o.c(r14).c();
        com.bytedance.privacy.f.b.a(r2, "verify: payload parsed successfully");
        if (r15.z("jwk") == false) goto L102;
        PublicKey r110 = e(r15.x("jwk"), r22);
        com.bytedance.privacy.f.b.a(r2, "verify: JWK cert chain verified, leaf public key obtained");
        byte[] r6 = c(Base64.decode(r4, 9));
        byte[] r8 = (r5 + "." + r7).getBytes(StandardCharsets.UTF_8);
        Signature r9 = Signature.getInstance("SHA256withECDSA");
        r9.initVerify(r110);
        r9.update(r8);
        if (r9.verify(r6) == false) goto L100;
        com.bytedance.privacy.f.b.a(r2, "verify: JWT signature valid");
        long r111 = System.currentTimeMillis() / 1000;
        if (r15.z("nbf") == false) goto L22;
        long r112 = r15.v("nbf").g();
        if (r111 >= r112) goto L22;
        throw new Exception("JWT not yet valid: nbf=" + r112 + " now=" + r111);
    L22:
        if (r15.z("exp") == false) goto L28;
        long r113 = r15.v("exp").g();
        if (r111 <= r113) goto L28;
        throw new Exception("JWT expired: exp=" + r113 + " now=" + r111);
    L28:
        com.bytedance.privacy.f.b.a(r2, "verify: time validation OK (now=" + r111 + ")");
        if (r15.z("opcc") == false) goto L98;
        m r23 = r15.x("opcc");
        if (r23.z(IBdInstall.PARAM_APP_ID) == false) goto L33;
        String r24 = r23.v(IBdInstall.PARAM_APP_ID).l();
    L35:
        if (r23.z("svc_id") == false) goto L38;
        r13 = r23.v("svc_id").l();
    L38:
        if (r17.equals(r24) == false) goto L96;
        if (r18.equals(r13) == false) goto L94;
        com.bytedance.privacy.f.b.d(r2, "verify: business fields OK (app_id=" + r17 + " svc_id=" + r18 + ")");
        if (r23.z("token_security_level") == false) goto L44;
        int r25 = r23.v("token_security_level").a();
    L45:
        String r0 = c.h(c.h(a(r17, r18, r19, r20, r21)).getBytes(StandardCharsets.UTF_8));
        if (r25 == 1) goto L48;
        if (r25 != 2) goto L91;
        String r26 = null;
        if (r15.z("tdx") == false) goto L60;
        m r1 = r15.x("tdx");
    L61:
        if (r1 == null) goto L90;
        if (r1.z("quote") == false) goto L65;
        m r27 = r1.x("quote");
    L66:
        if (r27 == null) goto L88;
        if (r27.z("body") == false) goto L70;
        m r28 = r27.x("body");
    L71:
        if (r28 == null) goto L86;
        if (r28.z("report_data") == false) goto L75;
        r26 = r28.v("report_data").l();
    L75:
        if (r26 == null) goto L84;
        if (TextUtils.equals(r0, r26) == false) goto L82;
        com.bytedance.privacy.f.b.d(r2, "verify: token_security_level=2 tdx.report_data match OK");
    L79:
        com.bytedance.privacy.f.b.d(r2, "verify: JWT evidence token verification completed successfully");
        return true;
    L82:
        throw new Exception("token_security_level=2 tdx.report_data mismatch");
    L84:
        throw new Exception("token_security_level=2 but tdx.quote.body.report_data is missing");
    L86:
        throw new Exception("token_security_level=2 but tdx.quote.body is missing");
    L70:
        r28 = null;
        goto L71
    L88:
        throw new Exception("token_security_level=2 but tdx.quote is missing");
    L65:
        r27 = null;
        goto L66
    L90:
        throw new Exception("token_security_level=2 but tdx is missing");
    L60:
        r1 = null;
        goto L61
    L91:
        com.bytedance.privacy.f.b.b(r2, "verify: unknown token_security_level=" + r25);
        return false;
    L48:
        if (r23.z("user_data") == false) goto L55;
        if (TextUtils.equals(r0, r23.v("user_data").l()) == false) goto L53;
        com.bytedance.privacy.f.b.a(r2, "verify: token_security_level=1 user_data match OK");
        goto L79
    L53:
        throw new Exception("token_security_level=1 opcc.user_data mismatch");
    L55:
        throw new Exception("token_security_level=1 but opcc.user_data is missing");
    L44:
        r25 = 0;
        goto L45
    L94:
        throw new Exception("opcc.svc_id mismatch: expected=" + r18 + " got=" + r13);
    L96:
        throw new Exception("opcc.app_id mismatch: expected=" + r17 + " got=" + r24);
    L33:
        r24 = "";
        goto L35
    L98:
        throw new Exception("JWT payload missing 'opcc' field");
    L100:
        throw new Exception("JWT ECDSA signature verification failed");
    L102:
        throw new Exception("JWT payload missing 'jwk' field");
    L104:
        throw new Exception("unsupported JWT alg: '" + r12 + "', expected ES256");
    L7:
        r12 = "";
        goto L9
    L106:
        throw new Exception("invalid JWT format: expected 3 parts, got " + r3.length);
    }

    private static PublicKey e(m r8, String r9) {
        if (r8.z("x5c") == false) goto L24;
        g r10 = r8.w("x5c");
        if (r10.size() == 0) goto L22;
        CertificateFactory r0 = CertificateFactory.getInstance("X.509");
        int r1 = r10.size();
        X509Certificate[] r2 = new X509Certificate[r1];
        int r4 = 0;
    L8:
        if (r4 >= r10.size()) goto L10;
        r2[r4] = (X509Certificate) r0.generateCertificate(new ByteArrayInputStream(Base64.decode(r10.r(r4).l(), 0)));
        r4 = r4 + 1;
        goto L8
    L10:
        int r11 = 0;
    L11:
        int r5 = r1 - 1;
        if (r11 >= r5) goto L14;
        int r6 = r11 + 1;
        r2[r11].verify(r2[r6].getPublicKey());
        com.bytedance.privacy.f.b.a(f5420a, "verifyJwkCertChain: cert[" + r11 + "] verified by cert[" + r6 + "]");
        r11 = r6;
        goto L11
    L14:
        if (r9 != null) goto L16;
    L18:
        com.bytedance.privacy.f.b.e(f5420a, "verifyJwkCertChain: attestation root cert not configured (TODO), skipping root trust anchor check");
    L20:
        return r2[0].getPublicKey();
    L16:
        if (r9.isEmpty() == true) goto L18;
        r2[r5].verify(((X509Certificate) r0.generateCertificate(new ByteArrayInputStream(r9.getBytes(StandardCharsets.UTF_8)))).getPublicKey());
        com.bytedance.privacy.f.b.a(f5420a, "verifyJwkCertChain: top cert verified against attestation root");
        goto L20
    L22:
        throw new Exception("JWK x5c array is empty");
    L24:
        throw new Exception("JWK missing 'x5c' field");
    }
}
