package p000j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Comparator<String> f17763b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, i> f17764c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f17765d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i f17766e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i f17767f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i f17768g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i f17769h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final i f17770i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final i f17771j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final i f17772k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final i f17773l = null;
    public static final i m = null;
    public static final i n = null;
    public static final i o = null;
    public static final i p = null;
    public static final i q = null;
    public static final i r = null;
    public static final i s = null;
    public static final i t = null;
    public static final i u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f17774a;

    static class a implements Comparator<String> {
        a() {
        }

        public int a(String r6, String r7) {
            int r5 = Math.min(r6.length(), r7.length());
            int r0 = 4;
        L4:
            if (r0 >= r5) goto L12;
            char r3 = r6.charAt(r0);
            char r4 = r7.charAt(r0);
            if (r3 != r4) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            if (r3 >= r4) goto L10;
            return -1;
        L10:
            return 1;
        L12:
            int r8 = r6.length();
            int r9 = r7.length();
            if (r8 == r9) goto L18;
            if (r8 >= r9) goto L17;
            return -1;
        L17:
            return 1;
        L18:
            return 0;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(String r1, String r2) {
            return a(r1, r2);
        }
    }

    static {
        f17763b = new a();
        f17764c = new LinkedHashMap();
        c("SSL_RSA_WITH_NULL_MD5", 1);
        c("SSL_RSA_WITH_NULL_SHA", 2);
        c("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        c("SSL_RSA_WITH_RC4_128_MD5", 4);
        c("SSL_RSA_WITH_RC4_128_SHA", 5);
        c("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        c("SSL_RSA_WITH_DES_CBC_SHA", 9);
        f17765d = c("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        c("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        c("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        c("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        c("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        c("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        c("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        c("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        c("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        c("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        c("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        c("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        c("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        c("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        c("TLS_KRB5_WITH_RC4_128_SHA", 32);
        c("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        c("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        c("TLS_KRB5_WITH_RC4_128_MD5", 36);
        c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        c("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        c("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        c("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        f17766e = c("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        c("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        f17767f = c("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        c("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        c("TLS_RSA_WITH_NULL_SHA256", 59);
        c("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        c("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        c("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        c("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        c("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        c("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        c("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        c("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        c("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        c("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        c("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        c("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        c("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        c("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        c("TLS_PSK_WITH_RC4_128_SHA", 138);
        c("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        c("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        c("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        c("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        f17768g = c("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        f17769h = c("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        c("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        c("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        c("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        c("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        c("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        c("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        c("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        c("TLS_FALLBACK_SCSV", 22016);
        c("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        c("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        c("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        c("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        c("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        c("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        c("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        c("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        c("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        c("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        c("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        c("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        f17770i = c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        f17771j = c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        c("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        c("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        c("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        c("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        c("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        c("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        c("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        c("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        c("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        c("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        c("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        c("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        c("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        f17772k = c("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        f17773l = c("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        c("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        c("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        m = c("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        n = c("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        c("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        c("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        c("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        c("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        o = c("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        p = c("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        c("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        c("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        q = c("TLS_AES_128_GCM_SHA256", 4865);
        r = c("TLS_AES_256_GCM_SHA384", 4866);
        s = c("TLS_CHACHA20_POLY1305_SHA256", 4867);
        t = c("TLS_AES_128_CCM_SHA256", 4868);
        u = c("TLS_AES_256_CCM_8_SHA256", 4869);
    }

    private i(String r1) {
        Objects.requireNonNull(r1);
        this.f17774a = r1;
    }

    public static synchronized i a(String r3) {
        monitor-enter(i.class);
        Map<String, i> r1 = f17764c;     // Catch: Throwable -> L12
        i r2 = r1.get(r3);     // Catch: Throwable -> L12
        if (r2 != null) goto L10;
        r2 = r1.get(d(r3));     // Catch: Throwable -> L12
        if (r2 != null) goto L9;
        r2 = new i(r3);     // Catch: Throwable -> L12
    L9:
        r1.put(r3, r2);     // Catch: Throwable -> L12
    L10:
        monitor-exit(i.class);
        return r2;
    L12:
        th = move-exception;
        throw th;
    }

    static List<i> b(String... r4) {
        ArrayList r0 = new ArrayList(r4.length);
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(a(r4[r2]));
        r2 = r2 + 1;
        goto L3
    L6:
        return Collections.unmodifiableList(r0);
    }

    private static i c(String r1, int r2) {
        i r3 = new i(r1);
        f17764c.put(r1, r3);
        return r3;
    }

    private static String d(String r4) {
        if (r4.startsWith("TLS_") == false) goto L7;
        return "SSL_" + r4.substring(4);
    L7:
        if (r4.startsWith("SSL_") == true) goto L9;
        return r4;
    L9:
        return "TLS_" + r4.substring(4);
    }

    public String toString() {
        return this.f17774a;
    }
}
