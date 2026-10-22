package com.bytedance.badger.h;

import java.util.concurrent.TimeUnit;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f2586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TimeUnit f2587b;

    public h(long r2, TimeUnit r4) {
        o.g(r4, "unit");
        this.f2586a = r2;
        this.f2587b = r4;
    }

    public final TimeUnit a() {
        return this.f2587b;
    }

    public final long b() {
        return this.f2586a;
    }

    public final long c() {
        return this.f2587b.toMillis(this.f2586a);
    }

    public final long d() {
        return this.f2587b.toSeconds(this.f2586a);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L5;
    L15:
        return true;
    L5:
        if ((r8 instanceof h) == false) goto L14;
        h r9 = (h) r8;
        if (this.f2586a != r9.f2586a) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L14;
        if (o.a(this.f2587b, r9.f2587b) == false) goto L14;
    L9:
        r1 = false;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.f2586a) * 31;
        TimeUnit r2 = this.f2587b;
        if (r2 == null) goto L5;
        int r3 = r2.hashCode();
    L7:
        return r0 + r3;
    L5:
        r3 = 0;
        goto L7
    }

    public String toString() {
        return "SimpleDuration(value=" + this.f2586a + ", unit=" + this.f2587b + ")";
    }
}
