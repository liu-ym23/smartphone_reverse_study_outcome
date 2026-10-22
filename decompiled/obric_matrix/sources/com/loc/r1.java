package com.loc;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class r1 extends t1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static r1 f7729d;

    static {
        q1.a r1 = new q1.a();
        r1.a("amap-global-threadPool");
        f7729d = new r1(r1.b());
    }

    private r1(q1 r10) {
        ThreadPoolExecutor r8 = new ThreadPoolExecutor(r10.a(), r10.b(), r10.d(), TimeUnit.SECONDS, r10.c(), r10);     // Catch: Throwable -> L5
        this.f7817a = r8;     // Catch: Throwable -> L5
        r8.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        v.m(th, "TPool", "ThreadPool");
        th.printStackTrace();
    }

    public static r1 f() {
        return f7729d;
    }
}
