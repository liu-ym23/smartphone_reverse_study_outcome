package com.bytedance.framwork.core.sdkmonitor;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedList<l> f4769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedList<c> f4770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedList<com.bytedance.framwork.core.sdkmonitor.a> f4771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4773e;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ k f4774f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f4775g;

        a(b r1, k r2) {
            this.f4775g = r1;
            this.f4774f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            LinkedList r0 = b.a(this.f4775g);     // Catch: Throwable -> L37
            monitor-enter(r0);     // Catch: Throwable -> L37
            LinkedList r1 = new LinkedList(b.a(this.f4775g));     // Catch: Throwable -> L33
            b.a(this.f4775g).clear();     // Catch: Throwable -> L33
            monitor-exit(r0);     // Catch: Throwable -> L33
            Iterator r2 = r1.iterator();     // Catch: Throwable -> L37
        L8:
            if (r2.hasNext() == false) goto L10;
            l r3 = (l) r2.next();     // Catch: Throwable -> L37
            b.b(this.f4775g, this.f4774f, r3);     // Catch: Throwable -> L37
            goto L8
        L10:
            LinkedList r4 = b.c(this.f4775g);     // Catch: Throwable -> L37
            monitor-enter(r4);     // Catch: Throwable -> L37
            LinkedList r5 = new LinkedList(b.c(this.f4775g));     // Catch: Throwable -> L30
            b.c(this.f4775g).clear();     // Catch: Throwable -> L30
            monitor-exit(r4);     // Catch: Throwable -> L30
            Iterator r6 = r5.iterator();     // Catch: Throwable -> L37
        L16:
            if (r6.hasNext() == false) goto L18;
            c r7 = (c) r6.next();     // Catch: Throwable -> L37
            b.d(this.f4775g, this.f4774f, r7);     // Catch: Throwable -> L37
            goto L16
        L18:
            LinkedList r8 = b.e(this.f4775g);     // Catch: Throwable -> L37
            monitor-enter(r8);     // Catch: Throwable -> L37
            LinkedList r9 = new LinkedList(b.e(this.f4775g));     // Catch: Throwable -> L27
            b.e(this.f4775g).clear();     // Catch: Throwable -> L27
            monitor-exit(r8);     // Catch: Throwable -> L27
            Iterator r10 = r9.iterator();     // Catch: Throwable -> L37
        L24:
            if (r10.hasNext() == false) goto L48;
            com.bytedance.framwork.core.sdkmonitor.a r11 = (com.bytedance.framwork.core.sdkmonitor.a) r10.next();     // Catch: Throwable -> L37
            b.f(this.f4775g, this.f4774f, r11);     // Catch: Throwable -> L37
            goto L24
        L48:
            return;
        L27:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        L30:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        L33:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        }
    }

    public b() {
        this.f4769a = new LinkedList();
        this.f4770b = new LinkedList();
        this.f4771c = new LinkedList();
        this.f4772d = 200;
    }

    static /* synthetic */ LinkedList a(b r0) {
        return r0.f4769a;
    }

    static /* synthetic */ void b(b r0, k r1, l r2) {
        r0.j(r1, r2);
    }

    static /* synthetic */ LinkedList c(b r0) {
        return r0.f4770b;
    }

    static /* synthetic */ void d(b r0, k r1, c r2) {
        r0.i(r1, r2);
    }

    static /* synthetic */ LinkedList e(b r0) {
        return r0.f4771c;
    }

    static /* synthetic */ void f(b r0, k r1, com.bytedance.framwork.core.sdkmonitor.a r2) {
        r0.g(r1, r2);
    }

    private void g(k r11, com.bytedance.framwork.core.sdkmonitor.a r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r12.f4761a) == false) goto L7;
        return;
    L7:
        if (r12.f4761a.equals("api_error") == false) goto L10;
        r11.V(r12.f4762b, r12.f4763c, r12.f4764d, r12.f4765e, r12.f4766f, r12.f4767g, r12.f4768h);
        return;
    L10:
        if (r12.f4761a.equals("api_all") == false) goto L15;
        r11.Y(r12.f4762b, r12.f4763c, r12.f4764d, r12.f4765e, r12.f4766f, r12.f4767g, r12.f4768h);
        return;
    }

    private void i(k r4, c r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        r4.W(r5.f4776a, r5.f4777b, r5.f4778c);
    }

    private void j(k r10, l r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r11.f4845a) == true) goto L9;
        r10.Z(r11.f4845a, r11.f4846b, r11.f4847c, r11.f4848d, r11.f4849e, r11.f4850f, r11.f4851g);
        return;
    }

    public void h(k r3) {
        if (this.f4773e == false) goto L5;
        return;
    L5:
        this.f4773e = true;
        d.b.i.a.b.h.a.e().f(new a(this, r3));
    }

    public void k(com.bytedance.framwork.core.sdkmonitor.a r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        LinkedList<com.bytedance.framwork.core.sdkmonitor.a> r0 = this.f4771c;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f4771c.size() <= this.f4772d) goto L9;
        this.f4771c.poll();     // Catch: Throwable -> L12
    L9:
        this.f4771c.add(r4);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public void l(l r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        LinkedList<l> r0 = this.f4769a;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.f4769a.size() <= this.f4772d) goto L9;
        this.f4769a.poll();     // Catch: Throwable -> L12
    L9:
        this.f4769a.add(r4);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
    }
}
