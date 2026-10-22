package com.bytedance.apm.agent.tracing;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f1277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f1280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f1281g;

    public b(String r1, long r2) {
        this.f1275a = r1;
        this.f1276b = r2;
    }

    public boolean a() {
        if (this.f1276b > 0) goto L5;
    L11:
        return false;
    L5:
        if (this.f1277c <= 0) goto L11;
        if (this.f1278d <= 0) goto L11;
        if (this.f1279e <= 0) goto L11;
        return true;
    }
}
