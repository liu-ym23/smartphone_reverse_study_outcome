package l.b.e.f;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.spec.PSSParameterSpec;
import java.util.HashMap;
import java.util.Map;
import l.b.a.e;
import l.b.a.l;
import l.b.a.o;
import l.b.a.r2.d;
import l.b.a.r2.f;
import l.b.a.u;
import l.b.a.w0;
import l.b.c.d.c;

/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f21898b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f21899c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map f21900d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map f21901e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map f21902f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l.b.c.d.b f21903a;

    static {
        HashMap r0 = new HashMap();
        f21898b = r0;
        HashMap r1 = new HashMap();
        f21899c = r1;
        HashMap r2 = new HashMap();
        f21900d = r2;
        f21901e = new HashMap();
        f21902f = new HashMap();
        r0.put(l.b.a.h2.a.f21591b, "Ed25519");
        r0.put(l.b.a.h2.a.f21592c, "Ed448");
        r0.put(new o("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        r0.put(d.f21692l, "SHA224WITHRSA");
        r0.put(d.f21689i, "SHA256WITHRSA");
        r0.put(d.f21690j, "SHA384WITHRSA");
        r0.put(d.f21691k, "SHA512WITHRSA");
        r0.put(l.b.a.f2.a.f21569e, "GOST3411WITHGOST3410");
        r0.put(l.b.a.f2.a.f21570f, "GOST3411WITHECGOST3410");
        r0.put(l.b.a.s2.a.f21714g, "GOST3411-2012-256WITHECGOST3410-2012-256");
        r0.put(l.b.a.s2.a.f21715h, "GOST3411-2012-512WITHECGOST3410-2012-512");
        r0.put(l.b.a.e2.a.f21546d, "SHA1WITHPLAIN-ECDSA");
        r0.put(l.b.a.e2.a.f21547e, "SHA224WITHPLAIN-ECDSA");
        r0.put(l.b.a.e2.a.f21548f, "SHA256WITHPLAIN-ECDSA");
        r0.put(l.b.a.e2.a.f21549g, "SHA384WITHPLAIN-ECDSA");
        r0.put(l.b.a.e2.a.f21550h, "SHA512WITHPLAIN-ECDSA");
        r0.put(l.b.a.e2.a.f21551i, "RIPEMD160WITHPLAIN-ECDSA");
        r0.put(l.b.a.g2.a.f21583i, "SHA1WITHCVC-ECDSA");
        r0.put(l.b.a.g2.a.f21584j, "SHA224WITHCVC-ECDSA");
        r0.put(l.b.a.g2.a.f21585k, "SHA256WITHCVC-ECDSA");
        r0.put(l.b.a.g2.a.f21586l, "SHA384WITHCVC-ECDSA");
        r0.put(l.b.a.g2.a.m, "SHA512WITHCVC-ECDSA");
        r0.put(l.b.a.k2.a.f21613a, "XMSS");
        r0.put(l.b.a.k2.a.f21614b, "XMSSMT");
        r0.put(new o("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        r0.put(new o("1.2.840.113549.1.1.2"), "MD2WITHRSA");
        r0.put(new o("1.2.840.10040.4.3"), "SHA1WITHDSA");
        r0.put(l.b.a.w2.a.f21800e, "SHA1WITHECDSA");
        r0.put(l.b.a.w2.a.f21803h, "SHA224WITHECDSA");
        r0.put(l.b.a.w2.a.f21804i, "SHA256WITHECDSA");
        r0.put(l.b.a.w2.a.f21805j, "SHA384WITHECDSA");
        r0.put(l.b.a.w2.a.f21806k, "SHA512WITHECDSA");
        r0.put(l.b.a.q2.a.f21667c, "SHA1WITHRSA");
        r0.put(l.b.a.q2.a.f21666b, "SHA1WITHDSA");
        r0.put(l.b.a.o2.a.w, "SHA224WITHDSA");
        r0.put(l.b.a.o2.a.x, "SHA256WITHDSA");
        r0.put(l.b.a.q2.a.f21665a, "SHA1");
        r0.put(l.b.a.o2.a.f21652f, "SHA224");
        r0.put(l.b.a.o2.a.f21649c, "SHA256");
        r0.put(l.b.a.o2.a.f21650d, "SHA384");
        r0.put(l.b.a.o2.a.f21651e, "SHA512");
        r0.put(l.b.a.t2.a.f21721c, "RIPEMD128");
        r0.put(l.b.a.t2.a.f21720b, "RIPEMD160");
        r0.put(l.b.a.t2.a.f21722d, "RIPEMD256");
        r1.put(d.f21682b, "RSA/ECB/PKCS1Padding");
        r1.put(l.b.a.f2.a.f21568d, "ECGOST3410");
        o r3 = d.Q;
        r2.put(r3, "DESEDEWrap");
        r2.put(d.R, "RC2Wrap");
        o r4 = l.b.a.o2.a.q;
        r2.put(r4, "AESWrap");
        o r5 = l.b.a.o2.a.s;
        r2.put(r5, "AESWrap");
        o r6 = l.b.a.o2.a.u;
        r2.put(r6, "AESWrap");
        o r7 = l.b.a.p2.a.f21661a;
        r2.put(r7, "CamelliaWrap");
        Map r8 = f21900d;
        o r9 = l.b.a.p2.a.f21662b;
        r8.put(r9, "CamelliaWrap");
        o r10 = l.b.a.p2.a.f21663c;
        r8.put(r10, "CamelliaWrap");
        o r11 = l.b.a.m2.a.f21626a;
        r8.put(r11, "SEEDWrap");
        o r12 = d.p;
        r8.put(r12, "DESede");
        Map r13 = f21902f;
        r13.put(r3, l.b.h.d.a(192));
        r13.put(r4, l.b.h.d.a(128));
        r13.put(r5, l.b.h.d.a(192));
        r13.put(r6, l.b.h.d.a(256));
        r13.put(r7, l.b.h.d.a(128));
        r13.put(r9, l.b.h.d.a(192));
        r13.put(r10, l.b.h.d.a(256));
        r13.put(r11, l.b.h.d.a(128));
        r13.put(r12, l.b.h.d.a(192));
        Map r14 = f21901e;
        r14.put(l.b.a.o2.a.o, "AES");
        r14.put(l.b.a.o2.a.p, "AES");
        r14.put(l.b.a.o2.a.r, "AES");
        r14.put(l.b.a.o2.a.t, "AES");
        r14.put(r12, "DESede");
        r14.put(d.q, "RC2");
    }

    b(l.b.c.d.b r1) {
        this.f21903a = r1;
    }

    private static String c(o r3) {
        String r4 = c.a(r3);
        int r0 = r4.indexOf(45);
        if (r0 > 0) goto L5;
        return r4;
    L5:
        if (r4.startsWith("SHA3") == false) goto L7;
        return r4;
    L7:
        return r4.substring(0, r0) + r4.substring(r0 + 1);
    }

    private static String d(l.b.a.v2.a r3) {
        e r0 = r3.q();
        if (r0 != null) goto L5;
    L10:
        Map r1 = f21898b;
        boolean r2 = r1.containsKey(r3.n());
        o r4 = r3.n();
        if (r2 == false) goto L15;
        return (String) r1.get(r4);
    L15:
        return r4.A();
    L5:
        if (w0.f21794f.q(r0) == true) goto L10;
        if (r3.n().r(d.f21688h) == false) goto L10;
        return c(f.o(r0).n().n()) + "WITHRSAANDMGF1";
    }

    private boolean e(u r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.size() == 0) goto L19;
        f r6 = f.o(r5);
        if (r6.p().n().r(d.f21687g) == true) goto L11;
        return true;
    L11:
        if (r6.n().equals(l.b.a.v2.a.o(r6.p().q())) == true) goto L13;
        return true;
    L13:
        MessageDigest r4 = a(r6.n());
        if (r6.q().intValue() != r4.getDigestLength()) goto L16;
        return false;
    L16:
        return true;
    L19:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.security.MessageDigest] */
    MessageDigest a(l.b.a.v2.a r4) {
    L8:
        e = move-exception;
        Map r1 = f21898b;
        if (r1.get(r4.n()) != null) goto L12;
        throw e;
    L12:
        return this.f21903a.a((String) r1.get(r4.n()));
    L3:
        if (r4.n().r(l.b.a.o2.a.n) == false) goto L6;
        l.b.c.d.b r0 = this.f21903a;     // Catch: NoSuchAlgorithmException -> L8
        String r2 = "SHAKE256-" + l.w(r4.q()).y();     // Catch: NoSuchAlgorithmException -> L8
    L5:
        b this = r0.a(r2);     // Catch: NoSuchAlgorithmException -> L8
        return this;
    L6:
        r0 = this.f21903a;     // Catch: NoSuchAlgorithmException -> L8
        r2 = c.a(r4.n());     // Catch: NoSuchAlgorithmException -> L8
        goto L5
    }

    Signature b(l.b.a.v2.a r5) {
        String r0 = d(r5);
        Signature r1 = this.f21903a.c(r0);     // Catch: NoSuchAlgorithmException -> L5
    L14:
        if (r5.n().r(d.f21688h) == false) goto L22;
        u r6 = u.w(r5.q());
        if (e(r6) == false) goto L22;
        AlgorithmParameters r4 = this.f21903a.b("PSS");     // Catch: IOException -> L19
        r4.init(r6.getEncoded());     // Catch: IOException -> L19
        r1.setParameter(r4.getParameterSpec(PSSParameterSpec.class));     // Catch: IOException -> L19
    L19:
        e = move-exception;
        throw new GeneralSecurityException("unable to process PSS parameters: " + e.getMessage());
    L22:
        return r1;
    L5:
        e = move-exception;
        if (r0.endsWith("WITHRSAANDMGF1") == false) goto L10;
        String r2 = r0.substring(0, r0.indexOf(87)) + "WITHRSASSA-PSS";
    L9:
        r1 = this.f21903a.c(r2);
        goto L14
    L10:
        Map r3 = f21898b;
        if (r3.get(r5.n()) == null) goto L23;
        r2 = (String) r3.get(r5.n());
        goto L9
    L23:
        throw e;
    }
}
