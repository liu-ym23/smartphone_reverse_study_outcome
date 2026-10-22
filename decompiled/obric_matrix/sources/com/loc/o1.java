package com.loc;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    o1 f7587a;

    public o1() {
    }

    public o1(o1 r1) {
        this.f7587a = r1;
    }

    public void a(int r1) {
        o1 r0 = this.f7587a;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public void b(boolean r1) {
        o1 r0 = this.f7587a;
        if (r0 == null) goto L6;
        r0.b(r1);
        return;
    }

    protected abstract boolean c();

    public int d() {
        o1 r1 = this.f7587a;
        if (r1 == null) goto L5;
        int r2 = r1.d();
    L7:
        return Math.min(Integer.MAX_VALUE, r2);
    L5:
        r2 = Integer.MAX_VALUE;
        goto L7
    }

    public final boolean e() {
        o1 r0 = this.f7587a;
        if (r0 == null) goto L5;
        boolean r1 = r0.e();
    L6:
        if (r1 == true) goto L10;
        return false;
    L10:
        return c();
    L5:
        r1 = true;
        goto L6
    }
}
