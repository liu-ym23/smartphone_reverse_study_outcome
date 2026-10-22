package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.android.sdk.bdticketguard.k0;

/* JADX INFO: loaded from: classes.dex */
public class j0<P extends k0<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final P f824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f825b;

    public j0(P r1, String r2, long r3) {
        kotlin.n0.d.o.g(r1, "responseParam");
        kotlin.n0.d.o.g(r2, "logid");
        this.f824a = r1;
        this.f825b = r2;
    }

    public /* synthetic */ j0(k0 r1, String r2, long r3, int r5, kotlin.n0.d.g r6) {
        if ((r5 & 4) == 0) goto L5;
        r3 = System.currentTimeMillis();
    L5:
        this(r1, r2, r3);
    }

    public final String a() {
        return this.f825b;
    }

    public final P b() {
        return this.f824a;
    }
}
