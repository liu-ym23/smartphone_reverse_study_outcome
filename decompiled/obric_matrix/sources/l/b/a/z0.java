package l.b.a;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class z0 implements q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private v1 f21818f;

    z0(v1 r1) {
        this.f21818f = r1;
    }

    @Override // l.b.a.q
    public InputStream a() {
        return this.f21818f;
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
        return new y0(this.f21818f.s());
    }
}
