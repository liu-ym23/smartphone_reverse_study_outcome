package com.bytedance.applog.x;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class e extends HandlerThread {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile e f2499j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler f2500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f2501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f2502h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LinkedList<Runnable> f2503i;

    private e() {
        super("TeaThread");
        this.f2501g = new Object();
        this.f2502h = false;
        this.f2503i = new LinkedList();
    }

    public static e d() {
        if (f2499j != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2499j != null) goto L9;
        f2499j = new e();     // Catch: Throwable -> L11
        f2499j.start();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f2499j;
    }

    public void a(Runnable r1) {
        b(r1);
    }

    public void b(Runnable r3) {
        c(r3, 0);
    }

    public void c(Runnable r3, long r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.f2502h == false) goto L7;
        g(r3, r4);
        return;
    L7:
        Object r0 = this.f2501g;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L10:
        if (this.f2502h == false) goto L13;
        g(r3, r4);     // Catch: Throwable -> L18
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L13:
        if (this.f2503i.size() <= 1000) goto L15;
        this.f2503i.poll();     // Catch: Throwable -> L18
    L15:
        this.f2503i.add(r3);     // Catch: Throwable -> L18
        goto L16
    }

    @NonNull
    public Handler e() {
        if (this.f2500f != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f2500f != null) goto L8;
        this.f2500f = new Handler(getLooper());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f2500f;
    }

    public void f(Runnable r1) {
        if (r1 == null) goto L5;
        e().post(r1);
        return;
    }

    public void g(Runnable r1, long r2) {
        if (r1 == null) goto L5;
        e().postDelayed(r1, r2);
        return;
    }

    public void h(Runnable r1) {
        e().removeCallbacks(r1);
    }

    public void i(Runnable r1, long r2) {
        if (r1 == null) goto L5;
        h(r1);
        g(r1, r2);
        return;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        Object r0 = this.f2501g;
        monitor-enter(r0);
        this.f2502h = true;     // Catch: Throwable -> L13
        ArrayList r1 = new ArrayList(this.f2503i);     // Catch: Throwable -> L13
        this.f2503i.clear();     // Catch: Throwable -> L13
        if (r1.isEmpty() == true) goto L11;
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L13
    L9:
        if (r2.hasNext() == false) goto L11;
        f((Runnable) r2.next());     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
