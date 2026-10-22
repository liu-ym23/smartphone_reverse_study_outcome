package com.bytedance.memory.e;

import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.crash.IOOMCallback;
import com.bytedance.crash.Npth;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f5015a;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f5016f;

        a(b r1) {
            this.f5016f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a(this.f5016f);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.memory.e.b$b, reason: collision with other inner class name */
    class C0156b implements IOOMCallback {
        C0156b(b r1) {
        }
    }

    class c implements Runnable {
        c(b r1) {
        }

        @Override // java.lang.Runnable
        public void run() {
            File r1 = com.bytedance.memory.c.b.d().e();     // Catch: Throwable -> L10
            if (r1 != null) goto L5;
            return;
        L5:
            if (r1.exists() == true) goto L7;
            return;
        L7:
            if (r1.isDirectory() == false) goto L17;
            com.bytedance.memory.c.a.d().c(r1);     // Catch: Throwable -> L10
            return;
        L17:
            return;
        L10:
            th = move-exception;
            th.printStackTrace();
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f5017a = null;

        static {
            f5017a = new b(null);
        }

        static /* synthetic */ b a() {
            return f5017a;
        }
    }

    private b() {
    }

    /* synthetic */ b(a r1) {
        this();
    }

    static /* synthetic */ void a(b r0) {
        r0.b();
    }

    private void b() {
        if (com.bytedance.memory.d.a.c("npth_hprof_close_expired") == false) goto L5;
        return;
    L5:
        com.bytedance.memory.b.b.f4995a.a(new c(this), "checkFileExpired");
    }

    public static b c() {
        return d.a();
    }

    private void e() {
        Npth.registerHprofCallback(new C0156b(this));
    }

    public void d() {
    L6:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (this.f5015a == true) goto L11;
        this.f5015a = true;     // Catch: Throwable -> L6
        e();     // Catch: Throwable -> L6
        com.bytedance.apm.f0.b.f().k(new a(this), BDLocationConfig.sScanBleMaxInterval);     // Catch: Throwable -> L6
        return;
    }
}
