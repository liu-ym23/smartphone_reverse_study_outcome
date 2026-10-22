package com.bytedance.apm.a0.k;

/* JADX INFO: loaded from: classes.dex */
public class i implements Comparable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f1252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f1253h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1254i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f1255j;

    public i(String r1, long r2, String r4) {
        this.f1251f = r1;
        this.f1253h = r2;
        this.f1255j = System.currentTimeMillis();
        this.f1254i = 1;
        this.f1252g = r4;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object r4) {
        long r0 = this.f1253h;
        long r3 = ((i) r4).f1253h;
        if (r0 != r3) goto L7;
        return 0;
    L7:
        if (r0 <= r3) goto L10;
        return 1;
    L10:
        return -1;
    }
}
