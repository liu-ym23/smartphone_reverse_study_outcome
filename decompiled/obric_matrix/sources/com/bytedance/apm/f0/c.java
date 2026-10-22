package com.bytedance.apm.f0;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile ExecutorService f1516a;

    class a implements ThreadFactory {
        a(c r1) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r2) {
            return new Thread(r2, "Apm_Log_Bypass_Store");
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f1517a = null;

        static {
            f1517a = new c(null);
        }
    }

    private c() {
        this.f1516a = Executors.newFixedThreadPool(1, new a(this));
    }

    /* synthetic */ c(a r1) {
        this();
    }

    public static c a() {
        if (com.bytedance.apm.d.E() == true) goto L5;
        return null;
    L5:
        return b.f1517a;
    }

    public void b(Runnable r1) {
        this.f1516a.submit(r1);
    }
}
