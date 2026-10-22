package com.bytedance.badger.data;

import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f2534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f2535d;

    public a(String r1, int r2, boolean r3, long r4) {
        this.f2532a = r1;
        this.f2533b = r2;
        this.f2534c = r3;
        this.f2535d = r4;
    }

    public final int a() {
        return this.f2533b;
    }

    public final String b() {
        return this.f2532a;
    }

    public final boolean c() {
        return this.f2534c;
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L5;
    L25:
        return true;
    L5:
        if ((r6 instanceof a) == false) goto L24;
        a r7 = (a) r6;
        if (o.a(this.f2532a, r7.f2532a) == false) goto L24;
        if (this.f2533b != r7.f2533b) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L24;
        if (this.f2534c != r7.f2534c) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L24;
        if (this.f2535d != r7.f2535d) goto L21;
        boolean r5 = true;
    L22:
        if (r5 == false) goto L24;
    L21:
        r5 = false;
        goto L22
    L16:
        r2 = false;
        goto L17
    L11:
        r1 = false;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r0 = this.f2532a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r2 = ((r1 * 31) + Integer.hashCode(this.f2533b)) * 31;
        boolean r3 = this.f2534c;
        ?? r4 = r3;
        if (r3 == false) goto L10;
        r4 = 1;
    L10:
        return ((r2 + r4) * 31) + Long.hashCode(this.f2535d);
    L5:
        r1 = 0;
        goto L6
    }

    public String toString() {
        return "BadgerReport(payload=" + this.f2532a + ", errorCode=" + this.f2533b + ", isFull=" + this.f2534c + ", durationNs=" + this.f2535d + ")";
    }
}
