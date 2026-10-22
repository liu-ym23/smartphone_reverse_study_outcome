package com.bytedance.badger.i;

import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes.dex */
final class a implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ kotlin.n0.c.a f2588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ l f2589g;

    a(kotlin.n0.c.a r1, l r2) {
        this.f2588f = r1;
        this.f2589g = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r0 = this.f2588f.invoke();     // Catch: Throwable -> L4
        v.b(r0);     // Catch: Throwable -> L4
    L6:
        Throwable r1 = v.d(r0);
        if (r1 == null) goto L14;
        l r2 = this.f2589g;
        if (r2 == null) goto L15;
        f0 r3 = (f0) r2.invoke(r1);
        return;
    L15:
        return;
    L14:
        return;
    L4:
        th = move-exception;
        r0 = w.a(th);
        v.b(r0);
        goto L6
    }
}
