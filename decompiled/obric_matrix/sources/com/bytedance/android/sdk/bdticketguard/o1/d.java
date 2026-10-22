package com.bytedance.android.sdk.bdticketguard.o1;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.sdk.bdticketguard.l0;
import com.bytedance.android.sdk.bdticketguard.p1.k;
import com.bytedance.android.sdk.bdticketguard.s0;
import com.bytedance.android.sdk.bdticketguard.z0;
import com.google.gson.Gson;
import java.nio.charset.Charset;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import kotlin.b0;
import kotlin.f0;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import net.bytedance.zdplib.Delta;
import net.bytedance.zdplib.DeltaSignerVerifier;

/* JADX INFO: loaded from: classes.dex */
public final class d extends com.bytedance.android.sdk.bdticketguard.o1.a<com.bytedance.android.sdk.bdticketguard.o1.e, String> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final /* synthetic */ l[] f939k = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Delta f940g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private l0 f941h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.h f942i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final kotlin.h f943j;

    static final class a extends q implements kotlin.n0.c.a<SharedPreferences> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f944f;

        a(Context r1) {
            this.f944f = r1;
            super(0);
        }

        @Proxy("getSharedPreferences")
        @TargetClass(scope = Scope.SELF, value = "android.content.Context")
        public static SharedPreferences a(Context r0, String r1, int r2) {
            return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
        }

        public final SharedPreferences b() {
            return a(this.f944f, "sp_TicketGuardManager", 0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ SharedPreferences invoke() {
            return b();
        }
    }

    static final class b extends q implements kotlin.n0.c.a<Gson> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f945f = null;

        static {
            f945f = new b();
        }

        b() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final Gson invoke() {
            return new Gson();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Gson invoke() {
            return invoke();
        }
    }

    static final class c extends q implements kotlin.n0.c.l<Long, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f946f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f947g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f948h;

        c(String r1, boolean r2, boolean r3) {
            this.f946f = r1;
            this.f947g = r2;
            this.f948h = r3;
            super(1);
        }

        public final void a(long r12) {
            z0.L(true, null, r12 / ((long) 1000000), r12, this.f946f, this.f947g, this.f948h);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Long r3) {
            a(r3.longValue());
            return f0.f18324a;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.sdk.bdticketguard.o1.d$d, reason: collision with other inner class name */
    static final class C0033d extends q implements kotlin.n0.c.l<String, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f949f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f950g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f951h;

        C0033d(boolean r1, String r2, boolean r3) {
            this.f949f = r1;
            this.f950g = r2;
            this.f951h = r3;
            super(1);
        }

        public final void a(String r13) {
            o.g(r13, "errorDesc");
            s0.f1065a.a("ReeKeyHelper", "ree hmac 失败, isStandardizedHmac=" + this.f949f + ", " + r13);
            z0.L(false, r13, 0, 0, this.f950g, this.f949f, this.f951h);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(String r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    static final class e extends q implements kotlin.n0.c.q<Long, Long, Long, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f952f;

        e(String r1) {
            this.f952f = r1;
            super(3);
        }

        public final void a(long r13, long r15, long r17) {
            s0.f1065a.a("ReeKeyHelper", "ree 加载 Key pair 成功");
            z0.u(0, null, System.currentTimeMillis() - r13, r17, r15, false, this.f952f);
        }

        @Override // kotlin.n0.c.q
        public /* bridge */ /* synthetic */ f0 f(Long r8, Long r9, Long r10) {
            a(r8.longValue(), r9.longValue(), r10.longValue());
            return f0.f18324a;
        }
    }

    static final class f extends q implements kotlin.n0.c.l<String, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f953f;

        f(String r1) {
            this.f953f = r1;
            super(1);
        }

        public final void a(String r14) {
            o.g(r14, "errorDesc");
            s0.f1065a.a("ReeKeyHelper", "ree 加载 Key pair 失败, " + r14);
            z0.u(-1, r14, 0, 0, 0, false, this.f953f);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(String r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    static final class g extends q implements kotlin.n0.c.l<Long, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f954f;

        g(String r1) {
            this.f954f = r1;
            super(1);
        }

        public final void a(long r4) {
            s0.f1065a.a("ReeKeyHelper", "ree 签名成功");
            z0.M(true, null, r4, this.f954f);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Long r3) {
            a(r3.longValue());
            return f0.f18324a;
        }
    }

    static final class h extends q implements kotlin.n0.c.l<String, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f955f;

        h(String r1) {
            this.f955f = r1;
            super(1);
        }

        public final void a(String r4) {
            o.g(r4, "errorDesc");
            s0.f1065a.a("ReeKeyHelper", "ree 签名失败, " + r4);
            z0.M(false, r4, 0, this.f955f);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(String r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    static {
        f939k = new l[]{e0.g(new y(e0.b(d.class), "encryptionSp", "getEncryptionSp()Landroid/content/SharedPreferences;")), e0.g(new y(e0.b(d.class), "gson", "getGson()Lcom/google/gson/Gson;"))};
    }

    public d(Context r2, String r3) {
        o.g(r2, "context");
        o.g(r3, "keystoreAlias");
        super(r2, r3);
        this.f942i = kotlin.i.b(new a(r2));
        this.f943j = kotlin.i.b(b.f945f);
    }

    private final l0 D(String r9) {
        if (r9.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L29;
        return null;
    L29:
        Charset r1 = kotlin.u0.d.f21429a;     // Catch: Throwable -> L25
        if (r9 == null) goto L24;
        byte[] r2 = r9.getBytes(r1);     // Catch: Throwable -> L25
        o.b(r2, "(this as java.lang.String).getBytes(charset)");     // Catch: Throwable -> L25
        X509Certificate r3 = com.bytedance.android.sdk.bdticketguard.o1.f.o(r2);     // Catch: Throwable -> L25
        if (r3 != null) goto L15;
        String r8 = "parse certificate failed without exception";
    L27:
        z0.J(false, r8);
        return null;
    L15:
        if ((r3.getPublicKey() instanceof ECPublicKey) == true) goto L17;
        r8 = "certificate's public key is not ECPublicKey";
        goto L27
    L17:
        String r4 = r3.getSerialNumber().toString();     // Catch: Throwable -> L25
        o.b(r4, "certificate.serialNumber.toString()");     // Catch: Throwable -> L25
        PublicKey r5 = r3.getPublicKey();     // Catch: Throwable -> L25
        if (r5 == null) goto L22;
        String r6 = com.bytedance.android.sdk.bdticketguard.o1.f.n((ECPublicKey) r5);     // Catch: Throwable -> L25
        s0.f1065a.a("ReeKeyHelper", "snNumber=" + r4 + ", serverPubKey=" + r6);     // Catch: Throwable -> L25
        z0.J(true, null);     // Catch: Throwable -> L25
        return new l0(r9, r4, r6);
    L22:
        throw new b0("null cannot be cast to non-null type java.security.interfaces.ECPublicKey");     // Catch: Throwable -> L25
    L24:
        throw new b0("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        String r7 = Log.getStackTraceString(th);
        s0 r10 = s0.f1065a;
        String r11 = Log.getStackTraceString(th);
        o.b(r11, "Log.getStackTraceString(e)");
        r10.a("ReeKeyHelper", r11);
        r8 = r7;
        goto L27
    L5:
        r0 = false;
        goto L7
    }

    private final byte[] E(Delta r1, byte[] r2, boolean r3, boolean r4) {
        if (r3 == false) goto L7;
        byte[] r0 = r1.g();
        com.bytedance.android.sdk.bdticketguard.o1.b r5 = com.bytedance.android.sdk.bdticketguard.o1.b.f935c;
        o.b(r0, "key");
        if (r4 == false) goto L10;
        return r5.a(r0, r2);
    L10:
        return r5.b(r0, r2);
    L7:
        byte[] r6 = r1.f(r2);
        o.b(r6, "delta.hmac(data)");
        return r6;
    }

    private final boolean H(l0 r3, boolean r4) {
        if (r3 != null) goto L28;
        z0.f1102e.m("server cert empty");
        return false;
    L28:
    L24:
        th = move-exception;
        z0.n(th);
    L27:
        return z();
    L6:
        if (h() != null) goto L9;
        z0 r0 = z0.f1102e;     // Catch: Throwable -> L24
        String r1 = "keyobject empty";
    L8:
        r0.m(r1);     // Catch: Throwable -> L24
    L21:
        if (r4 == false) goto L27;
        w().edit().putString("sp_key_server_cert", x().v(r3)).apply();     // Catch: Throwable -> L24
        goto L27
    L9:
        com.bytedance.android.sdk.bdticketguard.o1.e r2 = h();     // Catch: Throwable -> L24
        Delta r5 = null;
        if (r2 == null) goto L12;
        DeltaSignerVerifier r6 = r2.c();     // Catch: Throwable -> L24
    L13:
        if (r6 != null) goto L15;
        r0 = z0.f1102e;     // Catch: Throwable -> L24
        r1 = "deltaSigner empty";
        goto L8
    L15:
        com.bytedance.android.sdk.bdticketguard.o1.e r7 = h();     // Catch: Throwable -> L24
        if (r7 == null) goto L20;
        DeltaSignerVerifier r8 = r7.c();     // Catch: Throwable -> L24
        if (r8 == null) goto L20;
        r5 = r8.c(r3.b());     // Catch: Throwable -> L24
    L20:
        this.f940g = r5;     // Catch: Throwable -> L24
        goto L21
    L12:
        r6 = null;
        goto L13
    }

    private final SharedPreferences w() {
        kotlin.h r2 = this.f942i;
        l r0 = f939k[0];
        return (SharedPreferences) r2.getValue();
    }

    private final Gson x() {
        kotlin.h r2 = this.f943j;
        l r0 = f939k[1];
        return (Gson) r2.getValue();
    }

    public byte[] A(byte[] r8, String r9) {
        o.g(r8, "data");
        o.g(r9, "path");
        k r0 = k.f1023J;
        boolean r1 = r0.P().b().booleanValue();
        boolean r2 = r0.s().b().booleanValue();
        c r3 = new c(r9, r1, r2);
        C0033d r4 = new C0033d(r1, r9, r2);
        Delta r10 = this.f940g;
        if (r10 != null) goto L11;
        String r7 = "delta 为空";
    L5:
        r4.a(r7);
        return null;
    L11:
        long r5 = System.nanoTime();     // Catch: Throwable -> L8
        byte[] r11 = E(r10, r8, r1, r2);     // Catch: Throwable -> L8
        r3.a(System.nanoTime() - r5);     // Catch: Throwable -> L8
        return r11;
    L8:
        th = move-exception;
        r7 = Log.getStackTraceString(th);
        o.b(r7, "Log.getStackTraceString(e)");
        goto L5
    }

    public final void B() {
        this.f941h = null;
        w().edit().putString("sp_key_server_cert", null).apply();
        this.f940g = null;
        z0.f1102e.y();
    }

    public com.bytedance.android.sdk.bdticketguard.o1.e C(String r14) {
        o.g(r14, "scene");
        e r1 = new e(r14);
        f r0 = new f(r14);
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L25
        String r8 = j().getString(m(), null);     // Catch: Throwable -> L25
        String r9 = j().getString(k(), null);     // Catch: Throwable -> L25
        boolean r4 = true;
        if (r8 != null) goto L6;
    L9:
        boolean r5 = true;
    L10:
        if (r5 == true) goto L23;
        if (r9 != null) goto L13;
    L16:
        if (r4 == true) goto L23;
        long r6 = System.currentTimeMillis();     // Catch: Throwable -> L25
        DeltaSignerVerifier r13 = r(r9);     // Catch: Throwable -> L25
        long r7 = System.currentTimeMillis();     // Catch: Throwable -> L25
        if (o.a(r8, r13.d()) == false) goto L22;
        r1.a(r2, r6 - r2, r7 - r6);     // Catch: Throwable -> L25
        return new com.bytedance.android.sdk.bdticketguard.o1.e(false, r8, r9, r13);
    L22:
        r0.a("sp内容与deltaSignerVerifier恢复的不一致");     // Catch: Throwable -> L25
    L27:
        return null;
    L13:
        if (r9.length() == 0) goto L16;
        r4 = false;
    L23:
        r0.a("sp内容为空");     // Catch: Throwable -> L25
        return null;
    L6:
        if (r8.length() == 0) goto L9;
        r5 = false;
    L25:
        th = move-exception;
        r0.a("exception=" + Log.getStackTraceString(th));
        goto L27
    }

    public byte[] F(byte[] r7, String r8) {
        o.g(r7, "data");
        o.g(r8, "path");
        g r0 = new g(r8);
        h r1 = new h(r8);
        com.bytedance.android.sdk.bdticketguard.o1.e r6 = h();
        if (r6 != null) goto L11;
        String r9 = "获取私钥失败";
    L5:
        r1.a(r9);
        return null;
    L11:
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L8
        byte[] r10 = r6.c().b(r7);     // Catch: Throwable -> L8
        r0.a(System.currentTimeMillis() - r2);     // Catch: Throwable -> L8
        return r10;
    L8:
        th = move-exception;
        r9 = Log.getStackTraceString(th);
        o.b(r9, "Log.getStackTraceString(e)");
        goto L5
    }

    public final boolean G() {
        boolean r1 = true;
        if (z() == false) goto L5;
        return true;
    L5:
        z0.F();
        String r0 = w().getString("sp_key_server_cert", null);
        if (r0 != null) goto L8;
    L11:
        if (r1 == false) goto L24;
        String r2 = "empty in sp";
    L20:
        z0.E(r2);
    L22:
        return H(this.f941h, false);
    L24:
        l0 r3 = (l0) x().m(r0, l0.class);     // Catch: Throwable -> L17
        this.f941h = r3;     // Catch: Throwable -> L17
        if (r3 == null) goto L15;
        z0.G(r3.c());     // Catch: Throwable -> L17
    L23:
        goto L22
    L15:
        z0.E("not empty in sp, gson parsing success, but empty result");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        w().edit().remove("sp_key_server_cert").apply();
        String r4 = Log.getStackTraceString(th);
        o.b(r4, "Log.getStackTraceString(ignore)");
        z0.I("load_server_cert", r0, r4);
        r2 = "gson parsing error, e=" + th.getMessage() + ", originText=" + r0;
        goto L20
    L8:
        if (r0.length() == 0) goto L11;
        r1 = false;
        goto L11
    }

    public final void I(String r2) {
        o.g(r2, "serverCertString");
        l0 r3 = D(r2);
        this.f941h = r3;
        H(r3, true);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.a
    public boolean b() {
        return true;
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.a
    public boolean c() {
        String r0 = j().getString(m(), null);
        String r3 = j().getString(k(), null);
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L19;
        if (r3 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == false) goto L18;
        return false;
    L18:
        return true;
    L12:
        if (r3.length() == 0) goto L15;
        r4 = false;
        goto L16
    L19:
        return false;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.a
    public /* bridge */ /* synthetic */ com.bytedance.android.sdk.bdticketguard.o1.c d(String r1) {
        return u(r1);
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.a
    protected String g() {
        return "ree_create_key_log";
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.a
    public String l() {
        return "sp_key_private_key_ree";
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.a
    public String n() {
        return "sp_key_public_key_ree";
    }

    @Override // com.bytedance.android.sdk.bdticketguard.o1.a
    public /* bridge */ /* synthetic */ com.bytedance.android.sdk.bdticketguard.o1.c o(String r1) {
        return C(r1);
    }

    @VisibleForTesting
    public final DeltaSignerVerifier r(String r1) {
        return new DeltaSignerVerifier(r1);
    }

    public final byte[] s(byte[] r2) {
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
        Delta r1 = this.f940g;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.a(r2);
    }

    public final byte[] t(byte[] r2) {
        o.g(r2, NotificationCompat.CATEGORY_MESSAGE);
        Delta r1 = this.f940g;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.b(r2);
    }

    public com.bytedance.android.sdk.bdticketguard.o1.e u(String r21) {
        o.g(r21, "scene");
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L5
        String r0 = DeltaSignerVerifier.a();     // Catch: Throwable -> L5
        DeltaSignerVerifier r13 = r(r0);     // Catch: Throwable -> L5
        String r14 = r13.d();     // Catch: Throwable -> L5
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L5
        SharedPreferences.Editor r7 = j().edit();     // Catch: Throwable -> L5
        r7.putString(m(), r14);     // Catch: Throwable -> L5
        r7.putString(k(), r0);     // Catch: Throwable -> L5
        r7.apply();     // Catch: Throwable -> L5
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L5
        s0.f1065a.a("ReeKeyHelper", "ree 生成 Key pair 成功");     // Catch: Throwable -> L5
        z0.u(0, null, System.currentTimeMillis() - r2, r5 - r2, r8 - r5, true, r21);     // Catch: Throwable -> L5
        o.b(r14, "pub");     // Catch: Throwable -> L5
        o.b(r0, "pri");     // Catch: Throwable -> L5
        return new com.bytedance.android.sdk.bdticketguard.o1.e(true, r14, r0, r13);
    L5:
        th = move-exception;
        String r3 = Log.getStackTraceString(th);
        o.b(r3, "Log.getStackTraceString(e)");
        s0.f1065a.a("ReeKeyHelper", "ree 生成 Key pair 失败, exception=" + r3);
        z0.u(-1, r3, 0, 0, 0, true, r21);
        return null;
    }

    public final String v() {
        Delta r0 = this.f940g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c();
    }

    public final l0 y() {
        return this.f941h;
    }

    public final boolean z() {
        if (this.f940g == null) goto L5;
        return true;
    L5:
        return false;
    }
}
