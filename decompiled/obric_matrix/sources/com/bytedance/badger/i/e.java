package com.bytedance.badger.i;

import android.os.SystemClock;
import com.bytedance.badger.monitor.TriggerStage;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.badger.data.b f2598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TriggerStage f2601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f2602e;

    public e(com.bytedance.badger.data.b r2, String r3, int r4, TriggerStage r5, long r6) {
        o.g(r2, "request");
        o.g(r3, "path");
        o.g(r5, "triggerStage");
        this.f2598a = r2;
        this.f2599b = r3;
        this.f2600c = r4;
        this.f2601d = r5;
        this.f2602e = r6;
    }

    public final long a() {
        return SystemClock.elapsedRealtime() - this.f2602e;
    }

    public final String b() {
        return this.f2599b;
    }

    public final com.bytedance.badger.data.b c() {
        return this.f2598a;
    }

    public final int d() {
        return this.f2600c;
    }

    public final TriggerStage e() {
        return this.f2601d;
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L5;
    L24:
        return true;
    L5:
        if ((r6 instanceof e) == false) goto L23;
        e r7 = (e) r6;
        if (o.a(this.f2598a, r7.f2598a) == false) goto L23;
        if (o.a(this.f2599b, r7.f2599b) == false) goto L23;
        if (this.f2600c != r7.f2600c) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L23;
        if (o.a(this.f2601d, r7.f2601d) == false) goto L23;
        if (this.f2602e != r7.f2602e) goto L20;
        boolean r5 = true;
    L21:
        if (r5 == false) goto L23;
    L20:
        r5 = false;
        goto L21
    L13:
        r1 = false;
    L23:
        return false;
    }

    public int hashCode() {
        com.bytedance.badger.data.b r0 = this.f2598a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.f2599b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((r3 + r5) * 31) + Integer.hashCode(this.f2600c)) * 31;
        TriggerStage r7 = this.f2601d;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return ((r6 + r1) * 31) + Long.hashCode(this.f2602e);
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ReportContext(request=" + this.f2598a + ", path=" + this.f2599b + ", timeout=" + this.f2600c + ", triggerStage=" + this.f2601d + ", startTime=" + this.f2602e + ")";
    }
}
