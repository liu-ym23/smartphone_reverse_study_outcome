package com.bytedance.android.sdk.bdticketguard;

import android.util.Pair;
import com.bytedance.android.sdk.bdticketguard.g0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k0<C extends g0<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C f833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Pair<String, String>> f834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f835c;

    /* JADX WARN: Multi-variable type inference failed */
    public k0(C r2, List<? extends Pair<String, String>> r3, long r4) {
        kotlin.n0.d.o.g(r2, "requestContent");
        kotlin.n0.d.o.g(r3, "responseHeaders");
        this.f833a = r2;
        this.f834b = r3;
        this.f835c = r4;
    }

    public /* synthetic */ k0(g0 r1, List r2, long r3, int r5, kotlin.n0.d.g r6) {
        if ((r5 & 4) == 0) goto L5;
        r3 = System.currentTimeMillis();
    L5:
        this(r1, r2, r3);
    }

    public final C a() {
        return this.f833a;
    }

    public final List<Pair<String, String>> b() {
        return this.f834b;
    }

    public final long c() {
        return this.f835c;
    }
}
