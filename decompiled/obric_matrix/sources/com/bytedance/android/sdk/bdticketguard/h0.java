package com.bytedance.android.sdk.bdticketguard;

/* JADX INFO: loaded from: classes.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f779c;

    public h0(String r2, String r3, long r4) {
        kotlin.n0.d.o.g(r2, "host");
        kotlin.n0.d.o.g(r3, "path");
        this.f777a = r2;
        this.f778b = r3;
        this.f779c = r4;
    }

    public /* synthetic */ h0(String r1, String r2, long r3, int r5, kotlin.n0.d.g r6) {
        if ((r5 & 4) == 0) goto L5;
        r3 = System.currentTimeMillis();
    L5:
        this(r1, r2, r3);
    }

    public final String a() {
        return this.f777a;
    }

    public final String b() {
        return this.f778b;
    }

    public final long c() {
        return this.f779c;
    }
}
