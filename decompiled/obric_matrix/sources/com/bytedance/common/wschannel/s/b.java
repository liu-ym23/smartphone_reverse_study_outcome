package com.bytedance.common.wschannel.s;

import android.os.Handler;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.common.wschannel.s.e.a f3682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f3683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.common.wschannel.channel.c.a.g.b f3684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterfaceC0101b f3685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f3686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f3687f;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f3688f;

        a(b r1) {
            this.f3688f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.a(this.f3688f).getAndSet(false) == false) goto L8;
            Logger.d("WsChannelSdk_ok", "Compensate for ping timeout, prepare to reconnect");
            if (b.b(this.f3688f) == null) goto L9;
            b.b(this.f3688f).a();
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.s.b$b, reason: collision with other inner class name */
    public interface InterfaceC0101b {
        void a();
    }

    public b(InterfaceC0101b r3, Handler r4) {
        this.f3683b = new AtomicBoolean(false);
        this.f3687f = new a(this);
        this.f3685d = r3;
        this.f3686e = r4;
    }

    static /* synthetic */ AtomicBoolean a(b r0) {
        return r0.f3683b;
    }

    static /* synthetic */ InterfaceC0101b b(b r0) {
        return r0.f3685d;
    }

    private boolean c(com.bytedance.common.wschannel.s.e.a r2) {
        if (this.f3682a == com.bytedance.common.wschannel.s.e.a.f3690g) goto L5;
    L7:
        return false;
    L5:
        if (r2 != com.bytedance.common.wschannel.s.e.a.f3689f) goto L7;
        return true;
    }

    private void h() {
        this.f3683b.set(true);
        this.f3686e.removeCallbacks(this.f3687f);
        this.f3686e.postDelayed(this.f3687f, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
    }

    public boolean d() {
        return this.f3683b.get();
    }

    public void e() {
        Logger.d("WsChannelSdk_ok", "After compensating for ping, received pong");
        this.f3683b.set(false);
        this.f3686e.removeCallbacks(this.f3687f);
    }

    public void f(com.bytedance.common.wschannel.channel.c.a.g.b r1) {
        this.f3684c = r1;
    }

    public void g(com.bytedance.common.wschannel.s.e.a r3) {
        if (this.f3683b.get() == true) goto L14;
        boolean r0 = false;
        if (c(r3) == false) goto L7;
        Logger.d("WsChannelSdk_ok", "Switch the foreground in the background, send compensation ping");
        r0 = true;
    L7:
        if (r0 == false) goto L14;
        com.bytedance.common.wschannel.channel.c.a.g.b r1 = this.f3684c;     // Catch: Exception -> L12
        if (r1 == null) goto L14;
        r1.e();     // Catch: Exception -> L12
        h();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        this.f3682a = r3;
    }
}
