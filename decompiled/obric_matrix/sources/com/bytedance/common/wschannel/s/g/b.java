package com.bytedance.common.wschannel.s.g;

import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.s.c;
import java.util.concurrent.atomic.AtomicBoolean;
import p000j.f0;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.bytedance.common.wschannel.s.a<com.bytedance.common.wschannel.s.g.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f3698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f3699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f3700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f3701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f3702f;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f3703f;

        a(b r1) {
            this.f3703f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.g(this.f3703f).getAndSet(false) == false) goto L8;
            b.h(this.f3703f);
            if (b.i(this.f3703f) == null) goto L9;
            Logger.d("WsChannelSdk_ok", "heartbeat timeout，ready to close connection");
            b.i(this.f3703f).a();
            com.bytedance.common.wschannel.s.f.a.d().a();
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.s.g.b$b, reason: collision with other inner class name */
    class RunnableC0104b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f3704f;

        RunnableC0104b(b r1) {
            this.f3704f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.i(this.f3704f) == null) goto L6;
            b.j(this.f3704f);
            b.i(this.f3704f).b();
            return;
        }
    }

    public b(com.bytedance.common.wschannel.s.g.a r2) {
        super(r2);
        this.f3700d = new AtomicBoolean(false);
        this.f3701e = new a(this);
        this.f3702f = new RunnableC0104b(this);
    }

    static /* synthetic */ AtomicBoolean g(b r0) {
        return r0.f3700d;
    }

    static /* synthetic */ void h(b r0) {
        r0.k();
    }

    static /* synthetic */ c i(b r0) {
        return r0.f3698b;
    }

    static /* synthetic */ void j(b r0) {
        r0.l();
    }

    private void k() {
        this.f3699c.removeCallbacks(this.f3701e);
        this.f3699c.removeCallbacks(this.f3702f);
        this.f3700d.set(false);
    }

    private void l() {
        long r0 = ((com.bytedance.common.wschannel.s.g.a) this.f3681a).a();
        Logger.d("WsChannelSdk_ok", "interval :" + r0 + " ms,the next time to send heartbeat is " + com.bytedance.common.wschannel.u.c.h(System.currentTimeMillis() + r0));
        this.f3699c.removeCallbacks(this.f3702f);
        this.f3699c.postDelayed(this.f3702f, r0);
    }

    private void m(f0 r13) {
        if (((com.bytedance.common.wschannel.s.g.a) this.f3681a).a() == (-1)) goto L6;
        return;
    L6:
        if (r13 != null) goto L9;
        ((com.bytedance.common.wschannel.s.g.a) this.f3681a).d(270000);
        return;
    L9:
        String r14 = r13.A("Handshake-Options");
        if (r14 == null) goto L22;
        String[] r15 = r14.split(";");
        int r4 = r15.length;
        long r7 = -1;
        int r6 = 0;
    L12:
        if (r6 >= r4) goto L23;
        String r9 = r15[r6];
        if (TextUtils.isEmpty(r9) == true) goto L21;
        String[] r10 = r9.split("=");
        if ("ping-interval".equals(r10[0]) == false) goto L21;
        r7 = Long.parseLong(r10[1]) * 1000;
    L20:
        r7 = 270000;
    L21:
        r6 = r6 + 1;
    L23:
        com.bytedance.common.wschannel.s.g.a r12 = (com.bytedance.common.wschannel.s.g.a) this.f3681a;
        if (r7 != (-1)) goto L26;
        r12.d(270000);
        return;
    L26:
        r12.d(r7);
        return;
    L22:
        r7 = -1;
        goto L23
    }

    private void n() {
        this.f3700d.set(true);
        this.f3699c.removeCallbacks(this.f3701e);
        this.f3699c.postDelayed(this.f3701e, ((com.bytedance.common.wschannel.s.g.a) this.f3681a).b());
    }

    @Override // com.bytedance.common.wschannel.s.d
    public void a(f0 r3) {
        Logger.d("WsChannelSdk_ok", "connect success，ready to send ping");
        m(r3);
        l();
    }

    @Override // com.bytedance.common.wschannel.s.d
    public void b(com.bytedance.common.wschannel.s.e.a r1) {
    }

    @Override // com.bytedance.common.wschannel.s.d
    public void c() {
        Logger.d("WsChannelSdk_ok", "ping sent，waiting for pong");
        n();
    }

    @Override // com.bytedance.common.wschannel.s.d
    public void d() {
        Logger.d("WsChannelSdk_ok", "disconnected，stop to send ping");
        k();
    }

    @Override // com.bytedance.common.wschannel.s.d
    public void e() {
        Logger.d("WsChannelSdk_ok", "receive pong");
        this.f3700d.set(false);
        this.f3699c.removeCallbacks(this.f3701e);
        com.bytedance.common.wschannel.s.f.a.d().c();
    }

    @Override // com.bytedance.common.wschannel.s.a
    public void f(c r1, Handler r2) {
        this.f3698b = r1;
        this.f3699c = r2;
    }
}
