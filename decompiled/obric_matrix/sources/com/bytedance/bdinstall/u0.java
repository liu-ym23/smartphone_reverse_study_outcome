package com.bytedance.bdinstall;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
final class u0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f2880c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<String, List<d>> f2881d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final com.bytedance.bdinstall.d1.n<u0> f2882e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f2884b;

    class a extends com.bytedance.bdinstall.d1.n<u0> {
        a() {
        }

        @Override // com.bytedance.bdinstall.d1.n
        protected /* bridge */ /* synthetic */ u0 a(Object[] r1) {
            return c(r1);
        }

        protected u0 c(Object... r2) {
            return new u0((Context) r2[0], null);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Uri f2885f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int[] f2886g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ u0 f2887h;

        b(u0 r1, Uri r2, int[] r3) {
            this.f2887h = r1;
            this.f2885f = r2;
            this.f2886g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            u0.b(this.f2887h).getContentResolver().notifyChange(this.f2885f, null);     // Catch: Exception -> L4
            return;
        L4:
            int[] r0 = this.f2886g;
            r0[0] = r0[0] + 1;
            if (r0[0] > 4) goto L10;
            q.a(this + "retry " + this.f2886g[0] + " times after 1 second");
            new Handler(t.c()).postDelayed(this, 1000);
            return;
        }
    }

    class c extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u0 f2888a;

        c(u0 r1, Handler r2) {
            this.f2888a = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1, Uri r2) {
            super.onChange(r1);
            u0.c(this.f2888a, r2);
        }
    }

    public interface d {
        void b(String r1);
    }

    static {
        f2880c = new ConcurrentHashMap();
        f2881d = new ConcurrentHashMap();
        f2882e = new a();
    }

    private u0(Context r3) {
        this.f2884b = new AtomicBoolean(false);
        this.f2883a = r3;
    }

    /* synthetic */ u0(Context r1, a r2) {
        this(r1);
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    static /* synthetic */ Context b(u0 r0) {
        return r0.f2883a;
    }

    static /* synthetic */ void c(u0 r0, Uri r1) {
        r0.e(r1);
    }

    static u0 d(Context r3) {
        return f2882e.b(new Object[]{r3});
    }

    private void e(Uri r3) {
        monitor-enter(this);
        String r0 = r3.getQueryParameter("key");     // Catch: Throwable -> L17
        String r4 = r3.getQueryParameter("value");     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r0) == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L7:
        f2880c.put(r0, r4);     // Catch: Throwable -> L17
        List<d> r1 = f2881d.get(r0);     // Catch: Throwable -> L17
        if (r1 == null) goto L15;
        Iterator<d> r2 = r1.iterator();     // Catch: Throwable -> L17
    L11:
        if (r2.hasNext() == false) goto L15;
        d r5 = r2.next();     // Catch: Throwable -> L17
        if (r5 == null) goto L11;
        r5.b(r4);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private void f() {
        if (this.f2884b.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Uri r0 = BDInstallProvider.a(this.f2883a, "install_info_change");
        if (r0 != null) goto L8;
        return;
    L8:
        this.f2883a.getContentResolver().registerContentObserver(r0, true, new c(this, t.a()));
    }

    private void h(String r2, d r3) {
        Map<String, List<d>> r1 = f2881d;
        List<d> r0 = r1.get(r2);
        if (r0 != null) goto L5;
        r0 = new ArrayList();
        r1.put(r2, r0);
    L5:
        r0.add(r3);
    }

    private void j(String r1, d r2) {
        if (r2 == null) goto L5;
        r2.b(r1);
        return;
    }

    void g(String r4, d r5) {
        f();
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        monitor-enter(this);
        h(r4, r5);     // Catch: Throwable -> L16
        Map<String, String> r0 = f2880c;     // Catch: Throwable -> L16
        if (r0.containsKey(r4) == false) goto L11;
        j(r0.get(r4), r5);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L11:
        String r6 = a(this.f2883a, "ug_install_op_pref", 0).getString(r4, null);     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r6) == true) goto L14;
        j(r6, r5);     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"ApplySharedPref"})
    void i(String r4, String r5) {
        a(this.f2883a, "ug_install_op_pref", 0).edit().putString(r4, r5).commit();     // Catch: Exception -> L7
        Uri r0 = BDInstallProvider.a(this.f2883a, "install_info_change");     // Catch: Exception -> L7
        if (r0 != null) goto L5;
        return;
    L5:
        new b(this, r0.buildUpon().appendQueryParameter("key", r4).appendQueryParameter("value", r5).build(), new int[1]).run();     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        q.d("sendSubpEvent error", e);
    }
}
