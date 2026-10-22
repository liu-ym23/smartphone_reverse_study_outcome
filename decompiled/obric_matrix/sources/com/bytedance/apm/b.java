package com.bytedance.apm;

import android.content.Context;
import com.bytedance.apm.internal.ApmDelegate;

/* JADX INFO: loaded from: classes.dex */
public class b {

    class a implements Runnable {
        a(b r1) {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.apm.c.v("Apm#init", "Apm init");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.b$b, reason: collision with other inner class name */
    class RunnableC0039b implements Runnable {
        RunnableC0039b(b r1) {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.apm.c.v("Apm#start", "Apm start");
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f1300a = null;

        static {
            f1300a = new b(null);
        }

        static /* synthetic */ b a() {
            return f1300a;
        }
    }

    private b() {
    }

    /* synthetic */ b(com.bytedance.apm.a r1) {
        this();
    }

    public static b a() {
        return c.a();
    }

    public void b(Context r2, com.bytedance.apm.config.b r3) {
        ApmDelegate.k().o(r2, r3);
        if (d.E() == false) goto L6;
        com.bytedance.apm.f0.c.a().b(new a(this));
        return;
    }

    public void c() {
        ApmDelegate.k().w();
    }

    public void d() {
        ApmDelegate.k().A();
    }

    public void e(com.bytedance.apm.config.c r2) {
        ApmDelegate.k().B(r2);
        if (d.E() == false) goto L6;
        com.bytedance.apm.f0.c.a().b(new RunnableC0039b(this));
        return;
    }
}
