package com.bytedance.apm.r.m;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1950e;

    public g(int r2, int r3, long r4, int r6) {
        this.f1950e = 1;
        this.f1946a = r2;
        this.f1947b = r3;
        this.f1949d = r6;
        this.f1948c = r4;
    }

    public void a(long r3) {
        this.f1950e++;
        this.f1947b = (int) (((long) this.f1947b) + r3);
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof g) == false) goto L10;
        g r4 = (g) r3;
        if (r4.f1946a == this.f1946a) goto L7;
        return false;
    L7:
        if (r4.f1949d != this.f1949d) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return this.f1949d + "," + this.f1946a + "," + this.f1950e + "," + this.f1947b + "," + this.f1948c;
    }
}
