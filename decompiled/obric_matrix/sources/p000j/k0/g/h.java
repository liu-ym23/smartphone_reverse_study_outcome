package p000j.k0.g;

import k.g;
import p000j.g0;
import p000j.y;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends g0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f17891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f17892g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final g f17893h;

    public h(String r1, long r2, g r4) {
        this.f17891f = r1;
        this.f17892g = r2;
        this.f17893h = r4;
    }

    @Override // p000j.g0
    public g A() {
        return this.f17893h;
    }

    @Override // p000j.g0
    public long g() {
        return this.f17892g;
    }

    @Override // p000j.g0
    public y l() {
        String r0 = this.f17891f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return y.d(r0);
    }
}
