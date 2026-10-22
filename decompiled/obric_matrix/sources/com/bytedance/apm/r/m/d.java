package com.bytedance.apm.r.m;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long[] f1889a;

    public d() {
        this.f1889a = new long[4];
    }

    public void a(long r7) {
        long[] r0 = this.f1889a;
        if (r0[0] != 0) goto L5;
        r0[0] = SystemClock.uptimeMillis();
    L5:
        long[] r6 = this.f1889a;
        r6[1] = r6[1] + 1;
        if (r7 >= r6[2]) goto L9;
        r6[2] = r7;
    L9:
        if (r7 <= r6[3]) goto L12;
        r6[3] = r7;
        return;
    }

    public boolean b() {
        long[] r5 = this.f1889a;
        if ((r5[0] - r5[2]) <= 100) goto L6;
        return true;
    L6:
        return false;
    }

    public void c() {
        long[] r5 = this.f1889a;
        r5[0] = 0;
        r5[1] = 0;
        r5[2] = Long.MAX_VALUE;
        r5[3] = 0;
    }
}
