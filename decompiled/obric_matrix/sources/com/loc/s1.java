package com.loc;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s1 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    a f7752f;

    interface a {
        void a(s1 r1);
    }

    public s1() {
    }

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
    L12:
        th = move-exception;
        v.m(th, "ThreadTask", "run");
        th.printStackTrace();
        return;
    L3:
        if (Thread.interrupted() == false) goto L5;
        return;
    L5:
        b();     // Catch: Throwable -> L12
        if (Thread.interrupted() == false) goto L8;
        return;
    L8:
        a r0 = this.f7752f;     // Catch: Throwable -> L12
        if (r0 == null) goto L17;
        r0.a(this);     // Catch: Throwable -> L12
        return;
    }
}
