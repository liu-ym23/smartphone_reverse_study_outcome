package l.b.a;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class g0 implements q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private y f21573f;

    g0(y r1) {
        this.f21573f = r1;
    }

    @Override // l.b.a.q
    public InputStream a() {
        return new n0(this.f21573f);
    }

    @Override // l.b.a.e
    public t b() {
        return d();
    L4:
        e = move-exception;
        throw new s("IOException converting stream to byte array: " + e.getMessage(), e);
    }

    @Override // l.b.a.w1
    public t d() {
        return new f0(l.b.h.i.a.b(a()));
    }
}
