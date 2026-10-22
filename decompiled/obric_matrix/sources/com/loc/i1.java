package com.loc;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    i1 f7371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    byte[] f7372b;

    i1() {
        this.f7372b = null;
    }

    i1(i1 r2) {
        this.f7372b = null;
        this.f7371a = r2;
    }

    public final byte[] a() {
        byte[] r0 = b(this.f7372b);
        i1 r1 = this.f7371a;
        if (r1 == null) goto L6;
        r1.f7372b = r0;
        return r1.a();
    L6:
        return r0;
    }

    protected abstract byte[] b(byte[] r1);

    public void c(byte[] r1) {
    }
}
