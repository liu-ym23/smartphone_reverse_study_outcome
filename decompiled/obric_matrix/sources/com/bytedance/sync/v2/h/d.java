package com.bytedance.sync.v2.h;

import android.content.Context;
import com.bytedance.sync.v2.j.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class d implements com.bytedance.sync.v2.f.g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f5956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LinkedBlockingQueue<com.bytedance.sync.v2.g.a> f5957g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.bytedance.sync.v2.f.g f5958h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final h f5959i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Context f5960j;

    class a implements com.bytedance.sync.v2.f.g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f5961f;

        a(d r1) {
            this.f5961f = r1;
        }

        @Override // com.bytedance.sync.v2.f.g
        public void W(com.bytedance.sync.v2.g.a r2) {
            if (d.F(this.f5961f) == null) goto L6;
            d.F(this.f5961f).W(r2);
            return;
        }

        @Override // com.bytedance.sync.v2.f.g
        public boolean c() {
            if (d.F(this.f5961f) == null) goto L7;
            d.F(this.f5961f).c();
            return false;
        L7:
            return false;
        }
    }

    class b implements com.bytedance.sync.v2.f.g {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f5962f;

        b(d r1) {
            this.f5962f = r1;
        }

        @Override // com.bytedance.sync.v2.f.g
        public void W(com.bytedance.sync.v2.g.a r1) {
            d.M(this.f5962f).W(r1);
        }

        @Override // com.bytedance.sync.v2.f.g
        public boolean c() {
            return d.M(this.f5962f).c();
        }
    }

    private class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f5963f;

        private c(d r1) {
            this.f5963f = r1;
        }

        /* synthetic */ c(d r1, a r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.u.b0.a r0 = d.b.u.b0.b.g(d.o0(this.f5963f)).f();
            d.b.u.x.b.e("[SendMsg] start send msg to server....");
        L3:
            com.bytedance.sync.v2.g.a r1 = (com.bytedance.sync.v2.g.a) d.p0(this.f5963f).poll();
            if (r1 == null) goto L5;
            if (r1.f5947c == true) goto L26;
            if (r1.f5948d != null) goto L26;
            r1.f5948d = new com.bytedance.sync.v2.h.a();
        L26:
            if (r0.o() == false) goto L31;
            if (r1.f5947c == true) goto L31;
            d.M(this.f5963f).W(r1);
        L31:
            d.F(this.f5963f).W(r1);
            goto L3
        L5:
            d r2 = this.f5963f;
            monitor-enter(r2);
            boolean r3 = d.p0(this.f5963f).isEmpty();     // Catch: Throwable -> L17
            AtomicBoolean r4 = d.q0(this.f5963f);     // Catch: Throwable -> L17
            if (r3 == true) goto L10;
            boolean r5 = true;
        L11:
            r4.set(r5);     // Catch: Throwable -> L17
            if (r3 == true) goto L14;
            e.a(new c(this.f5963f));     // Catch: Throwable -> L17
        L14:
            monitor-exit(r2);     // Catch: Throwable -> L17
            d.b.u.x.b.e("[SendMsg] send msg to server finish");
            return;
        L10:
            r5 = false;
        L17:
            th = move-exception;
            throw th;
        }
    }

    public d(Context r3, d.b.u.e r4, com.bytedance.sync.v2.f.i r5) {
        this.f5956f = new AtomicBoolean(false);
        this.f5957g = new LinkedBlockingQueue();
        this.f5960j = r3;
        this.f5959i = new h(r3, r4, new a(this));
        this.f5958h = new com.bytedance.sync.v2.h.c(r3, r4, r5, new b(this));
    }

    static /* synthetic */ com.bytedance.sync.v2.f.g F(d r0) {
        return r0.f5958h;
    }

    static /* synthetic */ h M(d r0) {
        return r0.f5959i;
    }

    static /* synthetic */ Context o0(d r0) {
        return r0.f5960j;
    }

    static /* synthetic */ LinkedBlockingQueue p0(d r0) {
        return r0.f5957g;
    }

    static /* synthetic */ AtomicBoolean q0(d r0) {
        return r0.f5956f;
    }

    public static String r0(com.bytedance.sync.v2.j.e r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.toString();
    }

    @Override // com.bytedance.sync.v2.f.g
    public void W(com.bytedance.sync.v2.g.a r3) {
        d.b.u.x.b.a("[SendMsg] offer msg to dequeue : " + r0(r3.f5945a) + ", can fallback: " + r3.f5946b);
        this.f5957g.offer(r3);
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f5956f.compareAndSet(false, true) == false) goto L7;
        e.a(new c(this, null));     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
    }

    @Override // com.bytedance.sync.v2.f.g
    public boolean c() {
        monitor-enter(d.class);
        Iterator r4 = new ArrayList(this.f5957g).iterator();     // Catch: Throwable -> L20
    L6:
        if (r4.hasNext() == false) goto L17;
        com.bytedance.sync.v2.j.e r1 = ((com.bytedance.sync.v2.g.a) r4.next()).f5945a;     // Catch: Throwable -> L20
        if (r1 == null) goto L6;
        Iterator<com.bytedance.sync.v2.j.f> r2 = r1.f6071g.iterator();     // Catch: Throwable -> L20
    L11:
        if (r2.hasNext() == false) goto L6;
        if (r2.next().f6074f != j.f6109i) goto L11;
        monitor-exit(d.class);     // Catch: Throwable -> L20
        return true;
    L17:
        monitor-exit(d.class);     // Catch: Throwable -> L20
        return false;
    L20:
        th = move-exception;
        throw th;
    }
}
