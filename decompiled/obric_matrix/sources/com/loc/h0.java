package com.loc;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    h0 f7349a;

    h0() {
    }

    h0(h0 r1) {
        this.f7349a = r1;
    }

    protected abstract byte[] a(byte[] r1);

    public final byte[] b(byte[] r2) {
        h0 r0 = this.f7349a;
        if (r0 == null) goto L6;
        r2 = r0.b(r2);
    L6:
        return a(r2);
    }
}
