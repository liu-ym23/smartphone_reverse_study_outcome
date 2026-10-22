package com.bytedance.common.utility.m;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static ExecutorService f3313h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static ExecutorService f3314i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected static final AtomicInteger f3315j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f3316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f3317g;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f3318f;

        a(c r1) {
            this.f3318f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.d("ThreadPlus", "thread count: " + c.f3315j.incrementAndGet());
            this.f3318f.run();     // Catch: Exception -> L5
        L7:
            Logger.d("ThreadPlus", "thread count: " + c.f3315j.decrementAndGet());
            return;
        L5:
            e = move-exception;
            Logger.w("ThreadPlus", "Thread crashed!", e);
            goto L7
        }
    }

    static {
        f3313h = com.bytedance.common.utility.m.a.c();
        f3314i = com.bytedance.common.utility.m.a.c();
        f3315j = new AtomicInteger();
    }

    public c() {
        this(false);
    }

    public c(String r1) {
        this(false);
    }

    public c(boolean r1) {
        this.f3317g = r1;
    }

    public static void c(Runnable r1) {
        if (r1 == null) goto L5;
        f3313h.submit(r1);
        return;
    }

    public void b() {
        if (Logger.debug() == false) goto L5;
        Runnable r0 = new a(this);
    L7:
        if (this.f3317g == false) goto L9;
        ExecutorService r1 = f3314i;
    L10:
        r1.submit(r0);
        return;
    L9:
        r1 = f3313h;
        goto L10
    L5:
        r0 = this;
        goto L7
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable r0 = this.f3316f;
        if (r0 == null) goto L6;
        r0.run();
        return;
    }
}
