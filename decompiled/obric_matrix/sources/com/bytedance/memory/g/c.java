package com.bytedance.memory.g;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f5033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5034c;

    public c(int r1, e r2, Object r3) {
        this.f5032a = r1;
        this.f5033b = r2;
        this.f5034c = r3;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.f5032a == r6.f5032a) goto L12;
        return false;
    L12:
        if (this.f5033b.equals(r6.f5033b) == true) goto L14;
        return false;
    L14:
        Object r1 = this.f5034c;
        if (r1 != null) goto L17;
    L18:
        Object r7 = r6.f5034c;
        if (r7 != null) goto L21;
        return true;
    L21:
        if (r7.equals(this.f5034c) == false) goto L24;
        return true;
    L24:
        return false;
    L17:
        if (r1.equals(r6.f5034c) == false) goto L24;
        goto L18
    }

    public int hashCode() {
        return (this.f5033b.hashCode() << 31) + this.f5032a;
    }
}
