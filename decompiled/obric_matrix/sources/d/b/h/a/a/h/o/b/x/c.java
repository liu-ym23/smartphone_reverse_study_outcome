package d.b.h.a.a.h.o.b.x;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class c implements Serializable, Comparable<c> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f13586f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f13587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f13588h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f13589i;

    public int a(c r4) {
        long r0 = r4.f13589i;
        long r3 = this.f13589i;
        if (r0 != r3) goto L7;
        return 0;
    L7:
        if (r0 >= r3) goto L9;
        return -1;
    L9:
        return 1;
    }

    public String b() {
        return this.f13587g;
    }

    public boolean c() {
        return this.f13588h;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(c r1) {
        return a(r1);
    }
}
