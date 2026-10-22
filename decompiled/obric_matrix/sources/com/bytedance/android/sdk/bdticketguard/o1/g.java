package com.bytedance.android.sdk.bdticketguard.o1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.bytedance.android.sdk.bdticketguard.s0;
import com.bytedance.android.sdk.bdticketguard.z0;
import java.nio.charset.Charset;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import kotlin.a0;
import kotlin.b0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.u;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public final class g extends com.bytedance.android.sdk.bdticketguard.o1.a<i, Certificate> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f960g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f961h;

    static final class a extends q implements kotlin.n0.c.a<u<? extends Integer, ? extends String>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f962f = null;

        static {
            f962f = new a();
        }

        a() {
            super(0);
        }

        public final u<Integer, String> a() {
            return a0.a(-1004, "teePublicKey is empty");
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ u<? extends Integer, ? extends String> invoke() {
            return a();
        }
    }

    static final class b extends q implements kotlin.n0.c.a<u<? extends Integer, ? extends String>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f963f = null;

        static {
            f963f = new b();
        }

        b() {
            super(0);
        }

        public final u<Integer, String> a() {
            return a0.a(-1004, "reePublicKey is empty");
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ u<? extends Integer, ? extends String> invoke() {
            return a();
        }
    }

    static final class c extends q implements l<Certificate, String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f964f = null;

        static {
            f964f = new c();
        }

        c() {
            super(1);
        }

        public final String a(Certificate r1) {
            o.g(r1, "it");
            return f.a(r1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ String invoke(Certificate r1) {
            return a(r1);
        }
    }

    public g(Context r2, String r3, String r4) {
        o.g(r2, "context");
        o.g(r3, "keystoreAlias");
        o.g(r4, "principal");
        super(r2, r3);
        this.f961h = r4;
        this.f960g = j().getBoolean("has_ever_fail", false);
    }

    private final Boolean A(byte[] r3) {
        i r2 = h();
        if (r2 == null) goto L9;
        PrivateKey r4 = r2.e().getPrivate();     // Catch: Throwable -> L6
        o.b(r4, "it.keyPair.private");     // Catch: Throwable -> L6
        return Boolean.valueOf(f.l(r3, r4));
    L10:
        return null;
    L9:
        return null;
    }

    private final String B(KeyPair r10) {
        z0 r0 = z0.f1102e;
        r0.C();
        boolean r5 = true;
        if (j().getBoolean("sp_key_has_load_from_origin_sp", false) == true) goto L17;
        SharedPreferences r1 = r(e(), "sp_TicketGuardManager", 0);
        String r8 = r1.getString("sp_key_cert", null);
        r1.edit().remove("sp_key_cert").apply();
        SharedPreferences.Editor r2 = j().edit();
        r2.putBoolean("sp_key_has_load_from_origin_sp", true);
        if (r8 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L15;
        byte[] r4 = Base64.decode(r8, 0);
        o.b(r4, "Base64.decode(originCert, Base64.DEFAULT)");
        PrivateKey r7 = r10.getPrivate();
        o.b(r7, "keyPair.private");
        if (f.l(r4, r7) == false) goto L15;
        r2.putString(y(), r8);
    L16:
        r2.apply();
    L18:
        if (r8 != null) goto L20;
    L23:
        boolean r6 = true;
    L24:
        if (r6 == false) goto L39;
        String r9 = j().getString(y(), null);
        if (r9 != null) goto L28;
    L31:
        if (r5 == false) goto L33;
        r0.B("sp empty");
    L40:
        return r9;
    L33:
        byte[] r11 = Base64.decode(r9, 0);
        o.b(r11, "Base64.decode(cert, Base64.DEFAULT)");
        PrivateKey r12 = r10.getPrivate();
        o.b(r12, "keyPair.private");
        if (f.l(r11, r12) == false) goto L37;
        r0.D(r9);
        goto L40
    L37:
        r0.B("not match private key");
        j().edit().remove(y()).apply();
        return null;
    L28:
        if (r9.length() == 0) goto L31;
        r5 = false;
        goto L31
    L39:
        return r8;
    L20:
        if (r8.length() == 0) goto L23;
        r6 = false;
    L15:
        r8 = null;
        goto L16
    L7:
        if (r8.length() == 0) goto L10;
        r3 = false;
        goto L11
    L17:
        r8 = null;
        goto L18
    }

    private final String D(KeyPair r5, int r6) {
        String r7 = f.f(r5, this.f961h);     // Catch: Throwable -> L5
        s0.f1065a.a("TeeKeyHelper", "生成 csr 成功");     // Catch: Throwable -> L5
        z0.r(0, null, r6);     // Catch: Throwable -> L5
        return r7;
    L5:
        th = move-exception;
        s("generate csr", th);
        s0.f1065a.c("TeeKeyHelper", "生成 csr 失败", th);
        z0.r(3001, th, r6);
        return null;
    }

    private final KeyPair E(String r16, int r17) {
        long r3 = System.currentTimeMillis();
        KeyPair r5 = null;
        String r0 = i();     // Catch: Throwable -> L8
        SharedPreferences.Editor r6 = j().edit();     // Catch: Throwable -> L8
        o.b(r6, "sp.edit()");     // Catch: Throwable -> L8
        KeyPair r1 = f.g(r0, r6, m(), k());     // Catch: Throwable -> L8
        if (r1 == null) goto L6;
        s0.f1065a.a("TeeKeyHelper", "生成 Key pair 成功");     // Catch: Throwable -> L8
        z0.s(0, null, System.currentTimeMillis() - r3, true, r17, r16);     // Catch: Throwable -> L8
        r5 = r1;
    L11:
    L10:
        return r5;
    L6:
        s0.f1065a.a("TeeKeyHelper", "生成 Key pair 失败");     // Catch: Throwable -> L8
        z0.s(-1, null, System.currentTimeMillis() - r3, true, r17, r16);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        s("generate key", th);
        s0.f1065a.c("TeeKeyHelper", "生成 Key pair 失败", th);
        z0.s(-1, th, System.currentTimeMillis() - r3, true, r17, r16);
        goto L10
    }

    private final KeyPair F(String r16, int r17) {
        long r3 = System.currentTimeMillis();
        KeyPair r5 = null;
        KeyPair r0 = f.m(i(), j(), m(), k());     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        s0.f1065a.a("TeeKeyHelper", "加载 Key pair 成功");     // Catch: Throwable -> L8
        z0.s(0, null, System.currentTimeMillis() - r3, false, r17, r16);     // Catch: Throwable -> L8
        r5 = r0;
    L11:
    L10:
        return r5;
    L6:
        s0.f1065a.a("TeeKeyHelper", "加载 Key pair 失败");     // Catch: Throwable -> L8
        z0.s(0, null, System.currentTimeMillis() - r3, false, r17, r16);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        s("load key pair", th);
        s0.f1065a.c("TeeKeyHelper", "加载 Key pair 失败", th);
        z0.s(-1, th, System.currentTimeMillis() - r3, false, r17, r16);
        goto L10
    }

    private final byte[] G(PrivateKey r17, byte[] r18, int r19, String r20) {
        byte[] r2 = null;
        long r3 = System.currentTimeMillis();     // Catch: Throwable -> L5
        r2 = f.p(r17, r18);     // Catch: Throwable -> L5
        s0.f1065a.a("TeeKeyHelper", "签名成功");     // Catch: Throwable -> L5
        z0.Q(0, null, System.currentTimeMillis() - r3, r19, r20);     // Catch: Throwable -> L5
        z0.K(true, null, r19, System.currentTimeMillis() - r3, r20);     // Catch: Throwable -> L5
        return r2;
    L5:
        th = move-exception;
        s("sign", th);
        s0.f1065a.c("TeeKeyHelper", "签名失败", th);
        z0.Q(-1, "sign error, see bd_ticket_guard_create_signature", 0, 3, r20);
        z0.K(false, th, r19, 0, r20);
        return r2;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences r(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private final String u(KeyPair r3) {
        int r0 = 1;
    L4:
        if (r0 > 3) goto L9;
        String r1 = D(r3, r0);
        if (r1 != null) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return null;
    }

    private final String y() {
        return "client_cert_" + i();
    }

    public i C(String r5) {
        o.g(r5, "scene");
        int r0 = 1;
    L4:
        if (r0 > 3) goto L12;
        KeyPair r2 = F(r5, r0);
        if (r2 != null) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        i r6 = new i(false, r2, null, B(r2));
        if (r6.b() == true) goto L10;
        b();
    L10:
        return r6;
    L12:
        return null;
    }

    public byte[] H(byte[] r9, String r10) {
        o.g(r9, "data");
        o.g(r10, "path");
        i r0 = h();
        if (r0 != null) goto L6;
        s0.f1065a.a("TeeKeyHelper", "签名失败, 获取私钥失败");
        z0.Q(4002, "empty private key", 0, 0, r10);
        return null;
    L6:
        int r3 = 1;
    L7:
        if (r3 > 3) goto L12;
        PrivateKey r4 = r0.e().getPrivate();
        o.b(r4, "it.keyPair.private");
        byte[] r5 = G(r4, r9, r3, r10);
        if (r5 != null) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        return r5;
    L12:
        return null;
    }

    public final void I(String r5) {
        o.g(r5, "cert");
        Charset r0 = kotlin.u0.d.f21429a;
        byte[] r1 = r5.getBytes(r0);
        o.b(r1, "(this as java.lang.String).getBytes(charset)");
        if (o.a(A(r1), Boolean.TRUE) == false) goto L9;
        byte[] r6 = r5.getBytes(r0);
        o.b(r6, "(this as java.lang.String).getBytes(charset)");
        String r7 = Base64.encodeToString(r6, 2);
        i r2 = h();
        if (r2 == null) goto L7;
        r2.g(r7);
    L7:
        j().edit().putString(y(), r7).apply();
        z0 r4 = z0.f1102e;
        o.b(r7, "base64Cert");
        r4.R(r7);
        return;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.a
    public boolean b() {
        i r0 = h();
        if (r0 != null) goto L6;
        return false;
    L6:
        r0.h(u(r0.e()));
        return r0.b();
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.a
    public boolean c() {
        return f.b(i(), j(), m(), k());
    L4:
        th = move-exception;
        s("contains alias", th);
        throw th;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.a
    public /* bridge */ /* synthetic */ com.bytedance.android.sdk.bdticketguard.o1.c d(String r1) {
        return v(r1);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.a
    protected String g() {
        return "tee_create_key_log";
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.a
    public String l() {
        return "sp_key_private_key";
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.a
    public String n() {
        return "sp_key_public_key";
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.a
    public /* bridge */ /* synthetic */ com.bytedance.android.sdk.bdticketguard.o1.c o(String r1) {
        return C(r1);
    }

    public final void s(String r3, Throwable r4) {
        o.g(r3, "reason");
        s0.f1065a.a("TeeKeyHelper", r3 + " fail, error=" + Log.getStackTraceString(r4));
        if (this.f960g == true) goto L6;
        this.f960g = true;
        j().edit().putBoolean("has_ever_fail", true).apply();
        return;
    }

    public final void t(com.bytedance.android.sdk.bdticketguard.o1.j.g r3, com.bytedance.android.sdk.bdticketguard.o1.j.g r4) {
        o.g(r3, "oldAdapter");
        o.g(r4, "newAdapter");
        s0.f1065a.h("TeeKeyHelper", "deleteAttestationKey");
        f r2 = f.f959b;
        r2.d(r3.b(), "bd_ticket_guard_key_attestation");
        if ((!o.a(r4.f(), r3.f())) == false) goto L6;
        r2.d(r4.b(), "bd_ticket_guard_key_attestation");
        return;
    }

    public i v(String r5) {
        o.g(r5, "scene");
        int r1 = 1;
    L4:
        if (r1 > 3) goto L10;
        KeyPair r3 = E(r5, r1);
        if (r3 != null) goto L8;
        r1 = r1 + 1;
        goto L4
    L8:
        return new i(true, r3, u(r3), null);
    L10:
        return null;
    }

    @RequiresApi(24)
    @SuppressLint({"UseSdkSuppress"})
    public final String w(com.bytedance.android.sdk.bdticketguard.i r11, com.bytedance.android.sdk.bdticketguard.o1.j.f r12) {
        o.g(r11, "snapshot");
        o.g(r12, "attestationInfo");
        boolean r0 = true;
        if (r12.e().length() <= 0) goto L5;
        boolean r10 = true;
    L6:
        com.bytedance.android.sdk.bdticketguard.h.a(r10, a.f962f);
        if (r12.c().length() > 0) goto L10;
        r0 = false;
    L10:
        com.bytedance.android.sdk.bdticketguard.h.a(r0, b.f963f);
        Certificate[] r1 = f.h(r11, r12);
        r11.k(r1.length);
        String r13 = kotlin.i0.i.N(r1, ",", null, null, 0, null, c.f964f, 30, null);     // Catch: Throwable -> L18
        Charset r14 = kotlin.u0.d.f21429a;
        if (r13 == null) goto L17;
        byte[] r15 = r13.getBytes(r14);
        o.b(r15, "(this as java.lang.String).getBytes(charset)");
        String r16 = Base64.encodeToString(r15, 2);
        o.b(r16, "encoded");
        return r16;
    L17:
        throw new b0("null cannot be cast to non-null type java.lang.String");
    L18:
        th = move-exception;
        s0.f1065a.e("TeeKeyHelper", "getAttestationCertChainEncoded fail, " + Log.getStackTraceString(th));
        throw new com.bytedance.android.sdk.bdticketguard.c(r11, -1103, "encode cert chain failed", th);
    L5:
        r10 = false;
        goto L6
    }

    public final boolean x() {
        return this.f960g;
    }

    public final Boolean z(String r2) {
        o.g(r2, "base64Cert");
        byte[] r3 = Base64.decode(r2, 0);
        o.b(r3, "Base64.decode(base64Cert, Base64.DEFAULT)");
        return A(r3);
    }
}
