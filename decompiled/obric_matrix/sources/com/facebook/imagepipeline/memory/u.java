package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u extends a<t> {
    private final int[] o;

    u(d.c.c.g.d r2, f0 r3, g0 r4) {
        super(r2, r3, r4);
        SparseIntArray r5 = r3.f6719c;
        this.o = new int[r5.size()];
        int r6 = 0;
    L3:
        int[] r7 = this.o;
        if (r6 >= r7.length) goto L6;
        r7[r6] = r5.keyAt(r6);
        r6 = r6 + 1;
        goto L3
    L6:
        n();
    }

    protected int A(t r1) {
        d.c.c.d.i.g(r1);
        return r1.a();
    }

    int B() {
        return this.o[0];
    }

    protected boolean C(t r1) {
        d.c.c.d.i.g(r1);
        return !r1.isClosed();
    }

    @Override // com.facebook.imagepipeline.memory.a
    protected /* bridge */ /* synthetic */ t b(int r1) {
        return y(r1);
    }

    @Override // com.facebook.imagepipeline.memory.a
    protected /* bridge */ /* synthetic */ void f(t r1) {
        z(r1);
    }

    @Override // com.facebook.imagepipeline.memory.a
    protected int i(int r4) {
        if (r4 <= 0) goto L11;
        int[] r3 = this.o;
        int r0 = r3.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        int r2 = r3[r1];
        if (r2 >= r4) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return r2;
    L9:
        return r4;
    L11:
        throw new a.b(Integer.valueOf(r4));
    }

    @Override // com.facebook.imagepipeline.memory.a
    protected /* bridge */ /* synthetic */ int j(t r1) {
        return A(r1);
    }

    @Override // com.facebook.imagepipeline.memory.a
    protected int k(int r1) {
        return r1;
    }

    @Override // com.facebook.imagepipeline.memory.a
    protected /* bridge */ /* synthetic */ boolean p(t r1) {
        return C(r1);
    }

    protected abstract t y(int r1);

    protected void z(t r1) {
        d.c.c.d.i.g(r1);
        r1.close();
    }
}
