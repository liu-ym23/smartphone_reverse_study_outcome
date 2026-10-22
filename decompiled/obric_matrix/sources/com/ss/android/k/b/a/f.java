package com.ss.android.k.b.a;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f11981c = "f";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f11982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Looper f11983b;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f11984f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f11985g;

        a(f r1, String r2) {
            this.f11985g = r1;
            this.f11984f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.b().k(this.f11984f, 0);
            this.f11985g.b();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f11986f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f11987g;

        b(f r1, String r2) {
            this.f11987g = r1;
            this.f11986f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.b().k(this.f11986f, 1);
            this.f11987g.a(this.f11986f);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f11988f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f11989g;

        c(f r1, String r2) {
            this.f11989g = r1;
            this.f11988f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.b().k(this.f11988f, 2);
            this.f11989g.b();
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f11990f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f11991g;

        d(f r1, String r2) {
            this.f11991g = r1;
            this.f11990f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.b().k(this.f11990f, 1);
            this.f11991g.a(this.f11990f);
        }
    }

    static {
    }

    public f() {
        this.f11982a = new HashSet(1);
        this.f11983b = Looper.getMainLooper();
    }

    public abstract void a(String r1);

    public abstract void b();

    protected final synchronized boolean c(@NonNull String r1, int r2) {
        monitor-enter(this);
        if (r2 != 0) goto L7;
        boolean r3 = d(r1, com.ss.android.k.b.a.d.f11959f);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r3;
    L7:
        boolean r4 = d(r1, com.ss.android.k.b.a.d.f11960g);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r4;
    L10:
        th = move-exception;
        throw th;
    }

    protected final synchronized boolean d(@NonNull String r4, com.ss.android.k.b.a.d r5) {
        monitor-enter(this);
        Log.d(f11981c, r4 + ":" + r5);     // Catch: Throwable -> L30
        this.f11982a.remove(r4);     // Catch: Throwable -> L30
        if (r5 != com.ss.android.k.b.a.d.f11959f) goto L11;
        if (this.f11982a.isEmpty() == false) goto L28;
        new Handler(this.f11983b).post(new a(this, r4));     // Catch: Throwable -> L30
        monitor-exit(this);
        return true;
    L28:
        monitor-exit(this);
        return false;
    L11:
        if (r5 != com.ss.android.k.b.a.d.f11960g) goto L16;
        new Handler(this.f11983b).post(new b(this, r4));     // Catch: Throwable -> L30
        monitor-exit(this);
        return true;
    L16:
        if (r5 != com.ss.android.k.b.a.d.f11961h) goto L28;
        if (e(r4) == true) goto L20;
        new Handler(this.f11983b).post(new d(this, r4));     // Catch: Throwable -> L30
        monitor-exit(this);
        return true;
    L20:
        if (this.f11982a.isEmpty() == false) goto L28;
        new Handler(this.f11983b).post(new c(this, r4));     // Catch: Throwable -> L30
        monitor-exit(this);
        return true;
    L30:
        th = move-exception;
        throw th;
    }

    public synchronized boolean e(String r4) {
        monitor-enter(this);
        Log.d(f11981c, "Permission not found: " + r4);     // Catch: Throwable -> L7
        monitor-exit(this);
        return true;
    L7:
        th = move-exception;
        throw th;
    }
}
