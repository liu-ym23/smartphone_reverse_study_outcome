package com.bytedance.apm.q.j.m;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f1807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public StackTraceElement[] f1808d;

    public b() {
    }

    String a() {
        StringBuilder r0 = new StringBuilder();
        int r1 = 9;
    L4:
        if (r1 >= this.f1808d.length) goto L7;
        r0.append("\tat ");
        r0.append(this.f1808d[r1].toString());
        r0.append("\n");
        r1 = r1 + 1;
        goto L4
    L7:
        return r0.toString();
    }
}
