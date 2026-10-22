package com.bytedance.badger.data;

import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f2537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f2538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f2539d;

    public c(String r2, int r3, String r4, long r5) {
        o.g(r2, "challengeKey");
        o.g(r4, "deviceId");
        this.f2536a = r2;
        this.f2537b = r3;
        this.f2538c = r4;
        this.f2539d = r5;
    }

    public /* synthetic */ c(String r7, int r8, String r9, long r10, int r12, g r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = System.currentTimeMillis();
    L5:
        this(r7, r8, r9, r10);
    }

    @Override // com.bytedance.badger.data.b
    public long b() {
        return this.f2539d;
    }

    @Override // com.bytedance.badger.data.b
    public String c() {
        return this.f2536a;
    }

    @Override // com.bytedance.badger.data.b
    public int d() {
        return this.f2537b;
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L5;
    L22:
        return true;
    L5:
        if ((r6 instanceof c) == false) goto L21;
        c r7 = (c) r6;
        if (o.a(c(), r7.c()) == false) goto L21;
        if (d() != r7.d()) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L21;
        if (o.a(getDeviceId(), r7.getDeviceId()) == false) goto L21;
        if (b() != r7.b()) goto L18;
        boolean r5 = true;
    L19:
        if (r5 == false) goto L21;
    L18:
        r5 = false;
        goto L19
    L11:
        r1 = false;
    L21:
        return false;
    }

    @Override // com.bytedance.badger.data.b
    public String getDeviceId() {
        return this.f2538c;
    }

    public int hashCode() {
        String r0 = c();
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + Integer.hashCode(d())) * 31;
        String r4 = getDeviceId();
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return ((r3 + r1) * 31) + Long.hashCode(b());
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "BadgerRequestImpl(challengeKey=" + c() + ", bbid=" + d() + ", deviceId=" + getDeviceId() + ", timestamp=" + b() + ")";
    }
}
