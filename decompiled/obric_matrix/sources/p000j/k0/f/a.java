package p000j.k0.f;

import p000j.a0;
import p000j.d0;
import p000j.f0;
import p000j.k0.g.g;
import p000j.x;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f17825a;

    public a(a0 r1) {
        this.f17825a = r1;
    }

    @Override // p000j.x
    public f0 a(x.a r6) {
        g r0 = (g) r6;
        d0 r1 = r0.b();
        g r2 = r0.k();
        return r0.j(r1, r2, r2.i(this.f17825a, r6, !r1.f().equals("GET")), r2.d());
    }
}
