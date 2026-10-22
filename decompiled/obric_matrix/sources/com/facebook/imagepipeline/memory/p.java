package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.c.h.c<byte[]> f6734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final b f6735b;

    class a implements d.c.c.h.c<byte[]> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ p f6736f;

        a(p r1) {
            this.f6736f = r1;
        }

        public void a(byte[] r1) {
            this.f6736f.b(r1);
        }

        @Override // d.c.c.h.c
        public /* bridge */ /* synthetic */ void release(byte[] r1) {
            a(r1);
        }
    }

    static class b extends q {
        public b(d.c.c.g.d r1, f0 r2, g0 r3) {
            super(r1, r2, r3);
        }

        @Override // com.facebook.imagepipeline.memory.a
        f<byte[]> s(int r3) {
            k(r3);
            return new b0(r3, this.f6664h.f6721e, 0);
        }
    }

    public p(d.c.c.g.d r3, f0 r4) {
        if (r4.f6721e <= 0) goto L5;
        boolean r0 = true;
    L6:
        d.c.c.d.i.b(r0);
        this.f6735b = new b(r3, r4, a0.h());
        this.f6734a = new a(this);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public d.c.c.h.a<byte[]> a(int r2) {
        return d.c.c.h.a.X(this.f6735b.get(r2), this.f6734a);
    }

    public void b(byte[] r1) {
        this.f6735b.release(r1);
    }
}
