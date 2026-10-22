package com.bytedance.securityserver.trustcircle;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class TrustCircleManager {
    public static volatile TrustCircleManager c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f67a;
    public final Handler b;

    public interface Callback {
        void b(int r1);
    }

    public interface GetEscrowDevListCallback {
    }

    public TrustCircleManager() {
        this.f67a = Executors.newSingleThreadExecutor();
        this.b = new Handler(Looper.getMainLooper());
    }

    public static TrustCircleManager b() {
        if (c != null) goto L16;
        monitor-enter(TrustCircleManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L11;
        c = new TrustCircleManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(TrustCircleManager.class);     // Catch: Throwable -> L9
    L16:
        return c;
    }

    public final void a(final com.bytedance.securityserver.a r2) {
        Runnable r0 = new b(this, r2);
        this.f67a.execute(r0);
    }

    public final void c(com.bytedance.securityserver.a r3) {
        androidx.constraintlayout.motion.widget.a r0 = new androidx.constraintlayout.motion.widget.a(6, this, r3);
        this.f67a.execute(r0);
    }
}
