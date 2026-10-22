package com.ss.android.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.wschannel.WsConstants;
import com.ss.android.token.AuthTokenMultiProcessSharedProvider;
import d.b.s.a.l0.m;
import d.b.s.a.l0.n;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.f0;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import kotlin.u0.k;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ l[] f11879h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static h f11880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f11881j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f11882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f11884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.h f11885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f11886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AuthTokenMultiProcessSharedProvider.c f11887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f11888g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final h a(Context r3, AuthTokenMultiProcessSharedProvider.c r4, boolean r5) {
            o.g(r3, "applicationContext");
            o.g(r4, "sp");
            kotlin.n0.d.g r0 = null;
            if (h.c() == null) goto L5;
        L15:
            h r2 = h.c();
            if (r2 == null) goto L18;
            return r2;
        L18:
            o.p();
            throw null;
        L5:
            monitor-enter(h.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (h.c() != null) goto L9;
            h.e(new h(r3, r4, r5, r0));     // Catch: Throwable -> L12
        L9:
            f0 r6 = f0.f18324a;     // Catch: Throwable -> L12
            monitor-exit(h.class);
            goto L15
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ConcurrentHashMap<String, AtomicBoolean> f11889a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f11890b = null;

        static {
            f11890b = new b();
            f11889a = new ConcurrentHashMap();
        }

        private b() {
        }

        public final boolean a(String r3) {
            o.g(r3, "scene");
            AtomicBoolean r2 = new AtomicBoolean(false);
            AtomicBoolean r4 = f11889a.putIfAbsent(r3, r2);
            if (r4 == null) goto L5;
            r2 = r4;
        L5:
            o.b(r2, "doneScenes.putIfAbsent(scene, newFlag) ?: newFlag");
            return r2.compareAndSet(false, true);
        }
    }

    static final class c extends q implements kotlin.n0.c.a<SharedPreferences> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f11891f;

        c(h r1) {
            this.f11891f = r1;
            super(0);
        }

        @Proxy("getSharedPreferences")
        @TargetClass(scope = Scope.SELF, value = "android.content.Context")
        public static SharedPreferences a(Context r0, String r1, int r2) {
            return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
        }

        public final SharedPreferences b() {
            return a(h.a(this.f11891f), "passport_extra_header", 0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ SharedPreferences invoke() {
            return b();
        }
    }

    public static final class d extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f11892a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Uri f11893b;

        d(h r1, Uri r2, Handler r3) {
            this.f11892a = r1;
            this.f11893b = r2;
            super(r3);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r3, Uri r4) {
            super.onChange(r3, r4);
            d.b.s.a.a0.a.a("PassportExtraHeaderManager", "PassportExtraHeaderManager.onChange: uri=" + r4);
            if (r3 == false) goto L5;
            return;
        L5:
            if ((!o.a(String.valueOf(r4), this.f11893b.toString())) == true) goto L10;
            h.b(this.f11892a).clear();
            h.d(this.f11892a);
            return;
        }
    }

    static {
        f11879h = new l[]{e0.g(new y(e0.b(h.class), "backupSp", "getBackupSp()Landroid/content/SharedPreferences;"))};
        f11881j = new a(null);
    }

    private h(Context r1, AuthTokenMultiProcessSharedProvider.c r2, boolean r3) {
        this.f11886e = r1;
        this.f11887f = r2;
        this.f11888g = r3;
        this.f11882a = new ConcurrentHashMap();
        this.f11884c = new AtomicBoolean(false);
        this.f11885d = kotlin.i.a(kotlin.l.f18417f, new c(this));
    }

    public /* synthetic */ h(Context r1, AuthTokenMultiProcessSharedProvider.c r2, boolean r3, kotlin.n0.d.g r4) {
        this(r1, r2, r3);
    }

    public static final /* synthetic */ Context a(h r0) {
        return r0.f11886e;
    }

    public static final /* synthetic */ ConcurrentHashMap b(h r0) {
        return r0.f11882a;
    }

    public static final /* synthetic */ h c() {
        return f11880i;
    }

    public static final /* synthetic */ void d(h r0) {
        r0.n();
    }

    public static final /* synthetic */ void e(h r0) {
        f11880i = r0;
    }

    private final void h() {
        if (this.f11888g == true) goto L5;
        return;
    L5:
        boolean r0 = false;
        AuthTokenMultiProcessSharedProvider.b r1 = this.f11887f.b();
        Iterator<String> r2 = com.bytedance.sdk.account.settings.f.c.f5756f.c().b().iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        String r3 = r2.next();
        if (this.f11882a.containsKey(r3) == false) goto L7;
        this.f11882a.remove(r3);
        r1.e(r3);
        d.b.s.a.a0.a.a("PassportExtraHeaderManager", "clear deprecate header " + r3);
        r0 = true;
        goto L7
    L11:
        if (r0 == false) goto L19;
        int r4 = this.f11883b + 1;
        this.f11883b = r4;
        r1.c("passport_extra_header_modify_flag", r4);
        r1.a();
        return;
    }

    private final boolean i(String r14, String r15) {
        String r0 = com.bytedance.sdk.account.settings.f.a.e();
        boolean r3 = false;
        if (r0 == null) goto L37;
        o.b(r0, "it");
        if ((!k.q(r0)) == false) goto L7;
        String r7 = r0;
    L8:
        if (r7 == null) goto L37;
        List r1 = k.n0(r7, new String[]{","}, false, 0, 6, null);
        if (r1 == null) goto L37;
        if ((r1 instanceof Collection) == true) goto L14;
    L16:
        Iterator r2 = r1.iterator();
    L18:
        if (r2.hasNext() == false) goto L27;
        String r4 = (String) r2.next();
        if (r14 != null) goto L22;
    L24:
        boolean r5 = false;
    L25:
        if (r5 == false) goto L18;
        r3 = true;
        goto L27
    L22:
        if (k.F(r14, r4, false, 2, null) != true) goto L24;
        r5 = true;
    L27:
        StringBuilder r6 = new StringBuilder();
        r6.append("x-tt-token-supplement value ");
        if (r3 == false) goto L30;
        String r8 = WsConstants.KEY_CONNECTION_ERROR;
    L31:
        r6.append(r8);
        r6.append(", ");
        r6.append("template=");
        r6.append(com.bytedance.sdk.account.settings.f.a.e());
        r6.append(", ");
        r6.append("supplement=");
        r6.append(r14);
        r6.append(", scene=");
        r6.append(r15);
        String r9 = r6.toString();
        if (r3 == false) goto L36;
        d.b.s.a.a0.a.b("PassportExtraHeaderManager", r9);
        if (b.f11890b.a(r15) == false) goto L38;
        com.bytedance.sdk.account.monitor.c.m(r14, com.bytedance.sdk.account.settings.f.a.e(), this.f11882a.toString(), r15);
    L38:
        return r3;
    L36:
        d.b.s.a.a0.a.d("PassportExtraHeaderManager", r9);
        goto L38
    L30:
        r8 = "ok";
        goto L31
    L14:
        if (r1.isEmpty() == false) goto L16;
    L7:
        r7 = null;
    L37:
        d.b.s.a.a0.a.d("PassportExtraHeaderManager", "x-tt-token-supplement value ok, template=null/empty, supplement=" + r14 + ", scene=" + r15);
        goto L38
    }

    private final SharedPreferences j() {
        kotlin.h r2 = this.f11885d;
        l r0 = f11879h[0];
        return (SharedPreferences) r2.getValue();
    }

    public static final h k(Context r1, AuthTokenMultiProcessSharedProvider.c r2, boolean r3) {
        return f11881j.a(r1, r2, r3);
    }

    private final boolean l(String r4, String r5, String r6) {
        String r1 = null;
        if (com.bytedance.sdk.account.settings.f.a.n() == true) goto L6;
        r4 = null;
    L6:
        if (r4 != null) goto L8;
    L12:
        return false;
    L8:
        if (k.o("x-tt-token-supplement", r4, true) == false) goto L10;
        r1 = r4;
    L10:
        if (r1 == null) goto L12;
        return i(r5, r6);
    }

    private final void m() {
        this.f11883b = this.f11887f.d("passport_extra_header_modify_flag", 0);
    }

    private final void n() {
        Iterator<String> r0 = com.bytedance.sdk.account.settings.f.c.f5756f.f().b().iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        String r1 = r0.next();
        String r2 = this.f11887f.e(r1, "");
        o.b(r2, "value");
        if (r2.length() <= 0) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L4;
        o.b(r1, "name");
        if (l(r1, r2, "load") == true) goto L13;
    L15:
        this.f11882a.put(r1, r2);
        goto L4
    L13:
        if (com.bytedance.sdk.account.settings.f.a.t() == false) goto L15;
        r2 = j().getString(r1, "");
        o.b(r2, "value");
        l(r1, r2, "load-backup");
        goto L15
    L8:
        r5 = false;
        goto L9
    }

    private final void o() {
        m();
        n();
        h();
    }

    private final void p() {
        Uri r0 = Uri.parse("content://" + AuthTokenMultiProcessSharedProvider.o(this.f11886e, AuthTokenMultiProcessSharedProvider.class.getName()) + "/passport_extra_header_modify_flag/integer");
        StringBuilder r1 = new StringBuilder();
        r1.append("PassportExtraHeaderManager.registerContentResolver: uri=");
        r1.append(r0);
        d.b.s.a.a0.a.a("PassportExtraHeaderManager", r1.toString());
        this.f11886e.getContentResolver().registerContentObserver(r0, false, new d(this, r0, new Handler(Looper.getMainLooper())));
    }

    private final void r() {
        p();
        n();
    }

    private final void s() {
        if (this.f11884c.get() == false) goto L5;
        return;
    L5:
        AtomicBoolean r0 = this.f11884c;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (this.f11884c.get() == false) goto L11;
        monitor-exit(r0);
        return;
    L11:
        com.bytedance.sdk.account.settings.f.c r1 = com.bytedance.sdk.account.settings.f.c.f5756f;     // Catch: Throwable -> L18
        m r2 = r1.f();     // Catch: Throwable -> L18
        HashSet r3 = new HashSet();     // Catch: Throwable -> L18
        r3.add("x-tt-token-supplement");     // Catch: Throwable -> L18
        r2.a(r3);     // Catch: Throwable -> L18
        m r4 = r1.e();     // Catch: Throwable -> L18
        HashSet r5 = new HashSet();     // Catch: Throwable -> L18
        r5.add("x-tt-token-supplement");     // Catch: Throwable -> L18
        r4.a(r5);     // Catch: Throwable -> L18
        if (this.f11888g == false) goto L14;
        o();     // Catch: Throwable -> L18
    L15:
        this.f11884c.set(true);     // Catch: Throwable -> L18
        f0 r6 = f0.f18324a;     // Catch: Throwable -> L18
        monitor-exit(r0);
        return;
    L14:
        r();     // Catch: Throwable -> L18
        goto L15
    }

    public final void f(Map<String, String> r4) {
        o.g(r4, "requestHeaders");
        if (com.bytedance.sdk.account.settings.f.c.f5756f.d() == true) goto L5;
        return;
    L5:
        s();
        if (com.bytedance.sdk.account.settings.f.a.n() == false) goto L18;
        d.b.s.a.a0.a.d("PassportExtraHeaderManager", "header_mix_monitor is enable, check supplement value");
        String r0 = this.f11882a.get("x-tt-token-supplement");
        if (n.a(r0) == false) goto L18;
        if (l("x-tt-token-supplement", r0, "append") == false) goto L18;
        if (com.bytedance.sdk.account.settings.f.a.t() == false) goto L18;
        String r1 = j().getString("x-tt-token-supplement", null);
        if (r1 == null) goto L18;
        if (l("x-tt-token-supplement", r1, "append-backup") == false) goto L18;
        this.f11882a.put("x-tt-token-supplement", r1);
    L18:
        r4.putAll(this.f11882a);
    }

    public final String g() {
        com.bytedance.sdk.account.settings.f.c r0 = com.bytedance.sdk.account.settings.f.c.f5756f;
        if (r0.d() == true) goto L6;
        return "";
    L6:
        s();
        StringBuffer r1 = new StringBuffer();
        Iterator<String> r2 = r0.f().b().iterator();
    L8:
        if (r2.hasNext() == false) goto L17;
        String r3 = r2.next();
        if (r1.length() <= 0) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == false) goto L15;
        r1.append(",");
    L15:
        r1.append(r3);
        r1.append("=");
        r1.append(this.f11882a.containsKey(r3) ? 1 : 0);
        goto L8
    L12:
        r4 = false;
        goto L13
    L17:
        return r1.toString();
    }

    public final void q(String r10, Map<String, String> r11) {
        o.g(r10, "path");
        o.g(r11, "headerMap");
        com.bytedance.sdk.account.settings.f.c r0 = com.bytedance.sdk.account.settings.f.c.f5756f;
        if (r0.d() == true) goto L6;
        return;
    L6:
        if (this.f11888g == true) goto L8;
        return;
    L8:
        if (r11.isEmpty() == true) goto L50;
        s();
        AuthTokenMultiProcessSharedProvider.b r1 = this.f11887f.b();
        Iterator<String> r2 = r0.f().b().iterator();
        boolean r3 = false;
    L12:
        if (r2.hasNext() == false) goto L34;
        String r4 = r2.next();
        if (r11.containsKey(r4) == false) goto L12;
        String r5 = r11.get(r4);
        if (r5 != null) goto L18;
    L21:
        boolean r6 = true;
    L23:
        if (r6 == false) goto L25;
        this.f11882a.remove(r4);
        r1.e(r4);
        d.b.s.a.a0.a.a("PassportExtraHeaderManager", "save header exist, response header null, remove key " + r4);
    L32:
        r3 = true;
        goto L12
    L25:
        ConcurrentHashMap<String, String> r7 = this.f11882a;
        o.b(r4, "name");
        r7.put(r4, r5);
        r1.d(r4, r5);
        d.b.s.a.a0.a.a("PassportExtraHeaderManager", "save header name=" + r4 + ", value=" + r5);
        l(r4, r5, "save");
        if (com.bytedance.sdk.account.settings.f.a.t() == false) goto L32;
        SharedPreferences.Editor r8 = j().edit();
        if (r8 == null) goto L32;
        SharedPreferences.Editor r9 = r8.putString(r4, r5);
        if (r9 == null) goto L32;
        r9.apply();
        goto L32
    L18:
        if (r5.length() == 0) goto L21;
        r6 = false;
        goto L23
    L34:
        if (o.a("/passport/user/logout/", r10) == false) goto L39;
        Iterator<String> r12 = com.bytedance.sdk.account.settings.f.c.f5756f.e().b().iterator();
    L37:
        if (r12.hasNext() == false) goto L39;
        String r13 = r12.next();
        this.f11882a.remove(r13);
        r1.e(r13);
        r3 = true;
    L39:
        if (r3 == false) goto L49;
        int r14 = this.f11883b + 1;
        this.f11883b = r14;
        r1.c("passport_extra_header_modify_flag", r14);
        r1.a();
        return;
    L49:
        return;
    }
}
