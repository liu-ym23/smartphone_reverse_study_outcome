package com.bytedance.sync.v2.h;

import d.b.u.l;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final l<ExecutorService> f5964a = null;

    static class a extends l<ExecutorService> {
        a() {
        }

        @Override // d.b.u.l
        protected /* bridge */ /* synthetic */ ExecutorService a(Object[] r1) {
            return c(r1);
        }

        protected ExecutorService c(Object... r1) {
            return Executors.newSingleThreadExecutor();
        }
    }

    static {
        f5964a = new a();
    }

    public static void a(Runnable r2) {
        f5964a.b(new Object[0]).submit(r2);
    }
}
