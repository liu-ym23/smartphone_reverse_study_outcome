package kotlin.s0.w.d.l0.e.a;

import java.util.EnumMap;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EnumMap<b, q> f19655a;

    public x(EnumMap<b, q> r2) {
        kotlin.n0.d.o.f(r2, "defaultQualifiers");
        this.f19655a = r2;
    }

    public final q a(b r1) {
        return this.f19655a.get(r1);
    }

    public final EnumMap<b, q> b() {
        return this.f19655a;
    }
}
