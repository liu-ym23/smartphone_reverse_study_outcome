package com.ss.android.i.n.a.e;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.Gson;
import kotlin.b0;
import kotlin.h;
import kotlin.i;
import kotlin.i0.r;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"StaticFieldLeak"})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ l[] f11934a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f11935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f11936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Context f11937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final h f11938e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f11939f = null;

    static final class a extends q implements kotlin.n0.c.a<Gson> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f11940f = null;

        static {
            f11940f = new a();
        }

        a() {
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

    /* JADX INFO: renamed from: com.ss.android.i.n.a.e.b$b, reason: collision with other inner class name */
    static final class RunnableC0309b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f11941f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f11942g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f11943h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f11944i;

        RunnableC0309b(Context r1, String r2, String r3, String r4) {
            this.f11941f = r1;
            this.f11942g = r2;
            this.f11943h = r3;
            this.f11944i = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AccountManager r0 = AccountManager.get(this.f11941f);     // Catch: Exception -> L15
            String r1 = this.f11942g;     // Catch: Exception -> L15
            if (r1 != null) goto L7;
            r1 = "";
        L7:
            if (TextUtils.isEmpty(r1) == false) goto L9;
            r1 = this.f11941f.getPackageName();     // Catch: Exception -> L15
            o.b(r1, "context.packageName");     // Catch: Exception -> L15
        L9:
            Account[] r2 = r0.getAccountsByType(r1);     // Catch: Exception -> L15
            o.b(r2, "accountManager.getAccountsByType(realAccountType)");     // Catch: Exception -> L15
            if (r2 == null) goto L21;
            int r3 = r2.length;     // Catch: Exception -> L15
            int r4 = 0;
        L12:
            if (r4 >= r3) goto L22;
            Account r5 = r2[r4];     // Catch: Exception -> L15
            AccountManager.get(this.f11941f).setUserData(r5, this.f11943h, this.f11944i);     // Catch: Exception -> L15
            r4 = r4 + 1;
            goto L12
        L22:
            return;
        L21:
            return;
        L15:
            e = move-exception;
            com.ss.android.i.n.a.c r6 = com.ss.android.i.n.a.c.d();
            r6.b("share_sdk_save_account_info_failed");
            r6.a(LocationMonitorConst.ERR_MSG, e.getMessage());
            r6.a("err_msg_stack", Log.getStackTraceString(e));
            r6.c();
        }
    }

    static {
        f11934a = new l[]{e0.g(new y(e0.b(b.class), "gson", "getGson()Lcom/google/gson/Gson;"))};
        f11939f = new b();
        f11935b = new d();
        f11938e = i.b(a.f11940f);
    }

    private b() {
    }

    private final boolean a() {
        if (f11936c == true) goto L6;
        com.ss.android.i.n.a.c r1 = com.ss.android.i.n.a.c.d();
        r1.b("share_sdk_no_init");
        r1.c();
        return false;
    L6:
        return true;
    }

    private final Gson c() {
        h r2 = f11938e;
        l r0 = f11934a[0];
        return (Gson) r2.getValue();
    }

    private final void e(Context r1, String r2, String r3, String r4) {
        com.bytedance.common.utility.m.c.c(new RunnableC0309b(r1, r4, r2, r3));
    }

    static /* synthetic */ void f(b r0, Context r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.e(r1, r2, r3, r4);
    }

    private final void g(Context r1, String r2, String r3) {
        com.ss.android.i.n.a.e.a.f11931d.a(r1).g(r2, r3);
    }

    public static /* synthetic */ void i(b r0, Context r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.h(r1, r2, r3, r4);
    }

    public final boolean b(String r7) {
        if (a() == true) goto L5;
        return false;
    L5:
        String r1 = "";
        if (TextUtils.isEmpty(r7) == false) goto L8;
    L39:
        com.ss.android.i.n.a.c r6 = com.ss.android.i.n.a.c.d();
        r6.b("share_sdk_check_pkg_sign_failed");
        r6.a("pkg_name", r7);
        r6.a("pkg_sign", r1);
        r6.c();
        return false;
    L8:
        if (f11936c == false) goto L39;
        if (r.J(f11935b.a().keySet(), r7) == false) goto L39;
        c r8 = c.f11945a;
        Context r2 = f11937d;
        String r3 = null;
        if (r2 == null) goto L37;
        if (r7 == null) goto L35;
        String r9 = r8.a(r2, r7);
        if (r9 == null) goto L18;
        r1 = r9;
    L18:
        if (TextUtils.isEmpty(r1) == true) goto L39;
        if (TextUtils.isEmpty(f11935b.a().get(r7)) == true) goto L39;
        if (r1 == null) goto L34;
        String r4 = r1.toLowerCase();
        o.b(r4, "(this as java.lang.String).toLowerCase()");
        String r5 = f11935b.a().get(r7);
        if (r5 == null) goto L30;
        if (r5 == null) goto L28;
        r3 = r5.toLowerCase();
        o.b(r3, "(this as java.lang.String).toLowerCase()");
        goto L30
    L28:
        throw new b0("null cannot be cast to non-null type java.lang.String");
    L30:
        if (o.a(r4, r3) == false) goto L39;
        return true;
    L34:
        throw new b0("null cannot be cast to non-null type java.lang.String");
    L35:
        o.p();
        throw null;
    L37:
        o.v("mContext");
        throw null;
    }

    public final void d(Context r1, d r2) {
        o.g(r1, "context");
        o.g(r2, "cfg");
        Context r0 = r1.getApplicationContext();
        o.b(r0, "context.applicationContext");
        f11937d = r0;
        f11935b = r2;
        f11936c = true;
    }

    public final void h(Context r8, String r9, String r10, String r11) {
        o.g(r8, "context");
        o.g(r9, "key");
        o.g(r10, "value");
        f(this, r8, r9, r10, null, 8, null);
        g(r8, r9, r10);
    }

    public final void j(Context r9, com.ss.android.i.n.a.d.a r10) {
        o.g(r9, "context");
        o.g(r10, "accountShareInfo");
        String r4 = c().v(r10);     // Catch: Throwable -> L5
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L12;
        if (r4 == null) goto L10;
        i(this, r9, "key_account_info", r4, null, 8, null);
        return;
    L10:
        o.p();
        throw null;
    L12:
        return;
    L5:
        r4 = null;
        goto L7
    }
}
