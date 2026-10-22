package com.bytedance.bdinstall.a1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.bdinstall.e0;
import com.bytedance.bdinstall.q;
import com.bytedance.bdinstall.t;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SuppressLint({"CI_StaticFieldLeak", "StaticFieldLeak"})
    private static volatile b f2639i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f2640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f2641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f2642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f2643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f2644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f2645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Future<e> f2646g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e f2647h;

    class a implements Callable<e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f2648f;

        a(b r1) {
            this.f2648f = r1;
        }

        public e a() {
            return b.a(this.f2648f);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ e call() {
            return a();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdinstall.a1.b$b, reason: collision with other inner class name */
    class RunnableC0078b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f2649f;

        RunnableC0078b(b r1) {
            this.f2649f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.bytedance.bdinstall.d1.h.a(b.b(this.f2649f)).getBoolean("_install_started_v2", false) == true) goto L5;
            return;
        L5:
            if (b.c(this.f2649f) == null) goto L7;
            String r0 = b.c(this.f2649f).f2652a;
        L8:
            com.bytedance.bdinstall.x0.b.b(new com.bytedance.bdinstall.x0.g.c(new e0(r0, b.d(this.f2649f))));
            b.e(this.f2649f, null);
            return;
        L7:
            r0 = null;
            goto L8
        }
    }

    @WorkerThread
    private b(Context r4) {
        this.f2644e = new AtomicBoolean(false);
        Context r0 = r4.getApplicationContext();
        this.f2643d = r0;
        c r2 = d.a(r4);
        this.f2640a = r2;
        if (r2 == null) goto L5;
        this.f2642c = r2.b(r4);
    L6:
        this.f2641b = new g(r0);
        return;
    L5:
        this.f2642c = false;
        goto L6
    }

    static /* synthetic */ e a(b r0) {
        return r0.n();
    }

    static /* synthetic */ Context b(b r0) {
        return r0.f2643d;
    }

    static /* synthetic */ e c(b r0) {
        return r0.f2647h;
    }

    static /* synthetic */ boolean d(b r0) {
        return r0.f2642c;
    }

    static /* synthetic */ Runnable e(b r0, Runnable r1) {
        r0.f2645f = r1;
        return r1;
    }

    @WorkerThread
    private e f(Context r13, e r14) {
        long r0 = SystemClock.elapsedRealtime();
        c r12 = this.f2640a;
        String r2 = null;
        if (r12 == null) goto L21;
        c.a r15 = r12.a(r13);
        if (r15 == null) goto L22;
        int r16 = -1;
        int r3 = 1;
        if (r14 == null) goto L10;
        r2 = r14.f2653b;
        r16 = r14.f2657f.intValue() + 1;
    L10:
        if (TextUtils.isEmpty(r2) == false) goto L12;
        r2 = UUID.randomUUID().toString();
    L12:
        String r6 = r2;
        if (r16 <= 0) goto L16;
        r3 = r16;
    L16:
        long r17 = SystemClock.elapsedRealtime() - r0;
        long r1 = 0;
        if ((r15 instanceof com.bytedance.bdinstall.a1.a) == false) goto L20;
        r1 = ((com.bytedance.bdinstall.a1.a) r15).f2638c;
    L20:
        return new e(r15.f2650a, r6, Boolean.valueOf(r15.f2651b), Long.valueOf(r17), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(r3), Long.valueOf(r1));
    L22:
        return null;
    L21:
        return null;
    }

    @NonNull
    @WorkerThread
    public static b l(Context r2) {
        if (f2639i != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2639i != null) goto L9;
        f2639i = new b(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f2639i;
    }

    private e n() {
        q.a("Oaid#initOaid");
        f.j();
        q.a("Oaid#initOaid exec");     // Catch: Throwable -> L14
        e r0 = this.f2641b.c();     // Catch: Throwable -> L14
        q.a("Oaid#initOaid fetch=" + r0);     // Catch: Throwable -> L14
        if (r0 == null) goto L6;
        this.f2647h = r0;     // Catch: Throwable -> L14
    L6:
        f.k();     // Catch: Throwable -> L14
        e r1 = f(this.f2643d, r0);     // Catch: Throwable -> L14
        f.l();     // Catch: Throwable -> L14
        if (r1 == null) goto L9;
        this.f2641b.d(r1);     // Catch: Throwable -> L14
    L9:
        if (r1 == null) goto L11;
        this.f2647h = r1;     // Catch: Throwable -> L14
    L11:
        q.a("Oaid#initOaid oaidModel=" + r1);     // Catch: Throwable -> L14
        f.i();
        this.f2645f = new RunnableC0078b(this);
        r();
        return r1;
    L14:
        th = move-exception;
        f.i();
        this.f2645f = new RunnableC0078b(this);
        r();
        throw th;
    }

    static void o(JSONObject r1, String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == true) goto L12;
        if (r3 == null) goto L13;
        r1.put(r2, r3);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L13:
        return;
    }

    static <K, V> void p(Map<K, V> r0, K r1, V r2) {
        if (r1 == null) goto L6;
        if (r2 == null) goto L7;
        r0.put(r1, r2);
        return;
    L7:
        return;
    }

    private synchronized void r() {
        monitor-enter(this);
        Runnable r0 = this.f2645f;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.run();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void g() {
        this.f2641b.b();
    }

    public String h() {
        c r0 = this.f2640a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getName();
    }

    @Nullable
    @WorkerThread
    public Map<String, String> i(long r9) {
        Map<String, String> r3 = null;
        if (this.f2642c == true) goto L5;
        return null;
    L5:
        k();
        q.g("Oaid#getOaid timeoutMills=" + r9);
        e r2 = this.f2647h;
        if (r2 != null) goto L11;
        long r4 = SystemClock.elapsedRealtime();
        e r10 = this.f2646g.get(r9, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L10
        q.a("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r4) + " ms");
        r2 = r10;
    L10:
        q.a("Oaid#getOaid  took " + (SystemClock.elapsedRealtime() - r4) + " ms");
    L11:
        if (r2 != null) goto L13;
        r2 = this.f2647h;
    L13:
        if (r2 == null) goto L15;
        r3 = r2.b();
    L15:
        q.g("Oaid#getOaid return apiMap=" + r3);
        return r3;
    }

    @Nullable
    @AnyThread
    public String j() {
        k();
        e r2 = this.f2647h;
        if (r2 == null) goto L5;
        String r3 = r2.f2652a;
    L6:
        q.g("Oaid#getOaidId sOaidId=" + r3);
        return r3;
    L5:
        r3 = null;
        goto L6
    }

    public void k() {
        if (this.f2644e.compareAndSet(false, true) == false) goto L6;
        f.h();
        this.f2646g = t.i(new a(this));
        return;
    }

    @WorkerThread
    public boolean m() {
        k();
        return this.f2642c;
    }

    public void q() {
        r();
    }
}
