package com.loc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ThreadPoolExecutor f7817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<s1, Future<?>> f7818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected s1.a f7819c;

    final class a implements s1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ t1 f7820a;

        a(t1 r1) {
            this.f7820a = r1;
        }

        @Override // com.loc.s1.a
        public final void a(s1 r1) {
            this.f7820a.a(r1);
        }
    }

    public t1() {
        this.f7818b = new ConcurrentHashMap();
        this.f7819c = new a(this);
    }

    private synchronized void b(s1 r2, Future<?> r3) {
        monitor-enter(this);
        this.f7818b.put(r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        v.m(th, "TPool", "addQueue");     // Catch: Throwable -> L10
        th.printStackTrace();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private synchronized boolean e(s1 r3) {
        monitor-enter(this);
        boolean r4 = this.f7818b.containsKey(r3);     // Catch: Throwable -> L5
    L8:
        monitor-exit(this);
        return r4;
    L5:
        th = move-exception;
        v.m(th, "TPool", "contain");     // Catch: Throwable -> L10
        th.printStackTrace();     // Catch: Throwable -> L10
        r4 = false;
    L10:
        th = move-exception;
        throw th;
    }

    protected final synchronized void a(s1 r3) {
        monitor-enter(this);
        this.f7818b.remove(r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        v.m(th, "TPool", "removeQueue");     // Catch: Throwable -> L10
        th.printStackTrace();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final Executor c() {
        return this.f7817a;
    }

    public final void d(s1 r2) {
        if (e(r2) == false) goto L5;
        return;
    L5:
        ThreadPoolExecutor r0 = this.f7817a;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.isShutdown() == true) goto L22;
        r2.f7752f = this.f7819c;
        Future<?> r1 = this.f7817a.submit(r2);     // Catch: RejectedExecutionException -> L16
        if (r1 != null) goto L14;
        return;
    L14:
        b(r2, r1);
        return;
    L16:
        e = move-exception;
        v.m(e, "TPool", "addTask");
        return;
    }
}
