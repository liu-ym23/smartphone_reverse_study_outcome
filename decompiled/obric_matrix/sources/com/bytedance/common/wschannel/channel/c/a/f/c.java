package com.bytedance.common.wschannel.channel.c.a.f;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3441d;

    public c(Context r2) {
        this(r2, 4);
    }

    c(Context r1, int r2) {
        super(r1);
        if (r2 >= 0) goto L5;
        r2 = 4;
    L5:
        this.f3440c = r2;
    }

    @Override // com.bytedance.common.wschannel.channel.c.a.f.a
    public long c() {
        if (this.f3441d >= this.f3440c) goto L5;
        long r0 = super.c();
    L7:
        if (r0 == (-1)) goto L9;
        this.f3441d++;
    L9:
        return r0;
    L5:
        r0 = -1;
        goto L7
    }

    @Override // com.bytedance.common.wschannel.channel.c.a.f.a, com.bytedance.common.wschannel.channel.c.a.f.b
    public void reset() {
        super.reset();
        this.f3441d = 0;
    }

    public String toString() {
        return "RetryTimesPolicy{mMaxRetryTime=" + this.f3440c + ", mCurrRetryTime=" + this.f3441d + '}';
    }
}
