package com.bytedance.android.sdk.bdticketguard;

import android.util.Pair;
import com.bytedance.android.sdk.bdticketguard.h0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g0<P extends h0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final P f773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Pair<String, String>> f774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f775c;

    /* JADX WARN: Multi-variable type inference failed */
    public g0(P r2, List<? extends Pair<String, String>> r3, long r4) {
        kotlin.n0.d.o.g(r2, "requestParam");
        this.f773a = r2;
        this.f774b = r3;
        this.f775c = r4;
    }

    public /* synthetic */ g0(h0 r1, List r2, long r3, int r5, kotlin.n0.d.g r6) {
        if ((r5 & 4) == 0) goto L5;
        r3 = System.currentTimeMillis();
    L5:
        this(r1, r2, r3);
    }

    public final List<Pair<String, String>> a() {
        return this.f774b;
    }

    public final P b() {
        return this.f773a;
    }

    public final long c() {
        return this.f775c;
    }
}
