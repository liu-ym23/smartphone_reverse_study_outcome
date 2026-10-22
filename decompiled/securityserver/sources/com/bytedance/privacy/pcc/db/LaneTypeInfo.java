package com.bytedance.privacy.pcc.db;

import a.a;

/* JADX INFO: loaded from: classes.dex */
public class LaneTypeInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14a;
    public final int b;
    public final int c;

    public LaneTypeInfo(int r1, int r2, int r3) {
        this.f14a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("LaneTypeInfo{client=");
        r0.append(this.f14a);
        r0.append(", server=");
        r0.append(this.b);
        r0.append(", final=");
        return a.n(r0, "}", this.c);
    }
}
