package com.facebook.imagepipeline.memory;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class x implements d.c.c.g.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.c.g.l f6746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u f6747b;

    public x(u r1, d.c.c.g.l r2) {
        this.f6747b = r1;
        this.f6746a = r2;
    }

    @Override // d.c.c.g.i
    public /* bridge */ /* synthetic */ d.c.c.g.k a() {
        return l();
    }

    @Override // d.c.c.g.i
    public /* bridge */ /* synthetic */ d.c.c.g.h b(byte[] r1) {
        return k(r1);
    }

    @Override // d.c.c.g.i
    public /* bridge */ /* synthetic */ d.c.c.g.h c(InputStream r1, int r2, String r3) {
        return j(r1, r2, r3);
    }

    @Override // d.c.c.g.i
    public /* bridge */ /* synthetic */ d.c.c.g.h d(InputStream r1) {
        return h(r1);
    }

    @Override // d.c.c.g.i
    public /* bridge */ /* synthetic */ d.c.c.g.h e(InputStream r1, int r2) {
        return i(r1, r2);
    }

    @Override // d.c.c.g.i
    public /* bridge */ /* synthetic */ d.c.c.g.k f(int r1) {
        return m(r1);
    }

    w g(InputStream r1, y r2) {
        this.f6746a.b(r1, r2);
        return r2.l();
    }

    public w h(InputStream r3) {
        y r0 = new y(this.f6747b);
        w r2 = g(r3, r0);     // Catch: Throwable -> L6
        r0.close();
        return r2;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public w i(InputStream r3, int r4) {
        y r0 = new y(this.f6747b, r4);
        w r2 = g(r3, r0);     // Catch: Throwable -> L6
        r0.close();
        return r2;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public w j(InputStream r3, int r4, String r5) {
        y r0 = new y(this.f6747b, r4);
    L9:
        th = move-exception;
        r0.close();
        throw th;
    L4:
        if (this.f6746a.c(r3, r0, r5) != (-1)) goto L6;
        w r2 = null;
    L7:
        r0.close();
        return r2;
    L6:
        r2 = r0.l();     // Catch: Throwable -> L9
        goto L7
    }

    public w k(byte[] r3) {
        y r0 = new y(this.f6747b, r3.length);
        r0.write(r3, 0, r3.length);     // Catch: Throwable -> L6 IOException -> L8
        w r2 = r0.l();     // Catch: Throwable -> L6 IOException -> L8
        r0.close();
        return r2;
    L8:
        e = move-exception;
        d.c.c.d.n.a(e);     // Catch: Throwable -> L6
        throw null;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public y l() {
        return new y(this.f6747b);
    }

    public y m(int r2) {
        return new y(this.f6747b, r2);
    }
}
