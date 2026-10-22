package com.bytedance.lego.init.e;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l implements Comparable<l> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4900g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4901h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h f4902i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f4903j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f4904k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<String> f4905l;
    public float m;
    public List<String> n;
    public List<String> o;
    public List<String> p;
    public volatile k q;
    public volatile long r;
    public volatile long s;
    public volatile boolean t;

    public l() {
        this.m = 0.0f;
    }

    public l(String r2, boolean r3, boolean r4, float r5, List<String> r6, List<String> r7, List<String> r8, List<String> r9, String r10, k r11) {
        this.m = 0.0f;
        this.f4899f = r2;
        this.f4903j = r3;
        this.f4905l = r6;
        this.m = r5;
        this.n = r7;
        this.o = r8;
        this.p = r9;
        this.f4901h = r10;
        this.q = r11;
        this.f4904k = r4;
    }

    public int a(l r4) {
        float r0 = r4.m - this.m;
        if (r0 <= 0.0f) goto L7;
        return 1;
    L7:
        if (r0 >= 0.0f) goto L11;
        return -1;
    L11:
        return this.f4901h.compareTo(r4.f4901h);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(l r1) {
        return a(r1);
    }

    public String toString() {
        return this.m + "," + this.f4899f + "," + this.f4903j;
    }
}
