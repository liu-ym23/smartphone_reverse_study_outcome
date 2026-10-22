package l.b.d.a;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import l.b.a.o;
import l.b.a.r2.d;
import l.b.g.a.e;
import l.b.g.c.a.g.c;
import l.b.g.c.a.i.f;
import l.b.g.c.a.i.g;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Provider implements l.b.c.c.a.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f21873f = "BouncyCastle Security Provider v1.68";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map f21874g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Class f21875h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String[] f21876i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String[] f21877j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f21878k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String[] f21879l = null;
    private static final String[] m = null;
    private static final String[] n = null;
    private static final String[] o = null;
    private static final String[] p = null;

    /* JADX INFO: renamed from: l.b.d.a.a$a, reason: collision with other inner class name */
    class C0594a implements PrivilegedAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f21880a;

        C0594a(a r1) {
            this.f21880a = r1;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            a.a(this.f21880a);
            return null;
        }
    }

    static {
        new b();
        f21874g = new HashMap();
        f21875h = l.b.c.c.b.a.a.a(a.class, "java.security.cert.PKIXRevocationChecker");
        f21876i = new String[]{"PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF", "SCRYPT"};
        f21877j = new String[]{"SipHash", "SipHash128", "Poly1305"};
        f21878k = new String[]{"AES", "ARC4", "ARIA", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "SM4", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", "XTEA", "XSalsa20", "OpenSSLPBKDF", "DSTU7624", "GOST3412_2015", "Zuc"};
        f21879l = new String[]{"X509", "IES", "COMPOSITE"};
        m = new String[]{"DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM", "EdEC"};
        n = new String[]{"GOST3411", "Keccak", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "Blake2s", "DSTU7564", "Haraka"};
        o = new String[]{"BC", "BCFKS", "PKCS12"};
        p = new String[]{"DRBG"};
    }

    public a() {
        super("BC", 1.68d, f21873f);
        AccessController.doPrivileged(new C0594a(this));
    }

    static /* synthetic */ void a(a r0) {
        r0.h();
    }

    private void e(String r5, String[] r6) {
        int r0 = 0;
    L4:
        if (r0 == r6.length) goto L13;
        Class r1 = l.b.c.c.b.a.a.a(a.class, r5 + r6[r0] + "$Mappings");
        if (r1 == null) goto L12;
        ((l.b.c.c.c.a) r1.newInstance()).a(this);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        throw new InternalError("cannot create instance of " + r5 + r6[r0] + "$Mappings : " + e);
    L12:
        r0 = r0 + 1;
        goto L4
    }

    private void f() {
        c(e.f21933e, new c());
        c(e.f21934f, new l.b.g.c.a.d.c());
        c(e.f21935g, new f());
        c(l.b.a.k2.a.f21613a, new f());
        c(e.f21940l, new g());
        c(l.b.a.k2.a.f21614b, new g());
        c(e.f21931c, new l.b.g.c.a.c.f());
        c(e.f21932d, new l.b.g.c.a.c.e());
        c(e.f21929a, new l.b.g.c.a.f.c());
        c(e.q, new l.b.g.c.a.e.c());
        c(e.r, new l.b.g.c.a.e.c());
        c(d.G, new l.b.g.c.a.b.c());
    }

    private void h() {
        e("org.bouncycastle.jcajce.provider.digest.", n);
        e("org.bouncycastle.jcajce.provider.symmetric.", f21876i);
        e("org.bouncycastle.jcajce.provider.symmetric.", f21877j);
        e("org.bouncycastle.jcajce.provider.symmetric.", f21878k);
        e("org.bouncycastle.jcajce.provider.asymmetric.", f21879l);
        e("org.bouncycastle.jcajce.provider.asymmetric.", m);
        e("org.bouncycastle.jcajce.provider.keystore.", o);
        e("org.bouncycastle.jcajce.provider.drbg.", p);
        f();
        put("X509Store.CERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertCollection");
        put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreAttrCertCollection");
        put("X509Store.CRL/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCRLCollection");
        put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertPairCollection");
        put("X509Store.CERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCerts");
        put("X509Store.CRL/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCRLs");
        put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPAttrCerts");
        put("X509Store.CERTIFICATEPAIR/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCertPairs");
        put("X509StreamParser.CERTIFICATE", "org.bouncycastle.jce.provider.X509CertParser");
        put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.bouncycastle.jce.provider.X509AttrCertParser");
        put("X509StreamParser.CRL", "org.bouncycastle.jce.provider.X509CRLParser");
        put("X509StreamParser.CERTIFICATEPAIR", "org.bouncycastle.jce.provider.X509CertPairParser");
        put("Cipher.BROKENPBEWITHMD5ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
        put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
        put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
        Class r0 = f21875h;
        put("CertPathValidator.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
        put("CertPathBuilder.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
        if (r0 == null) goto L5;
        String r1 = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8";
        put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8");
        String r4 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi_8";
    L6:
        put("CertPathBuilder.RFC3280", r4);
        put("CertPathValidator.PKIX", r1);
        put("CertPathBuilder.PKIX", r4);
        put("CertStore.Collection", "org.bouncycastle.jce.provider.CertStoreCollectionSpi");
        put("CertStore.LDAP", "org.bouncycastle.jce.provider.X509LDAPCertStoreSpi");
        put("CertStore.Multi", "org.bouncycastle.jce.provider.MultiCertStoreSpi");
        put("Alg.Alias.CertStore.X509LDAP", "LDAP");
        return;
    L5:
        r1 = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi";
        put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
        r4 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi";
        goto L6
    }

    public void c(o r1, l.b.c.c.c.b r2) {
        Map r0 = f21874g;
        monitor-enter(r0);
        r0.put(r1, r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
