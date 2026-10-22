package d.c.i.s;

/* JADX INFO: loaded from: classes2.dex */
public class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f16529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f16530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f16531d;

    public e(int r1, boolean r2, c r3, Integer r4) {
        this.f16528a = r1;
        this.f16529b = r2;
        this.f16530c = r3;
        this.f16531d = r4;
    }

    private b b(d.c.h.d r1, boolean r2) {
        c r0 = this.f16530c;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a(r1, r2);
    }

    private b c(d.c.h.d r3, boolean r4) {
        Integer r0 = this.f16531d;
        if (r0 != null) goto L6;
        return null;
    L6:
        int r1 = r0.intValue();
        if (r1 == 0) goto L15;
        if (r1 != 1) goto L13;
        return e(r3, r4);
    L13:
        throw new IllegalArgumentException("Invalid ImageTranscoderType");
    L15:
        return d(r3, r4);
    }

    private b d(d.c.h.d r3, boolean r4) {
        return new com.facebook.imagepipeline.nativecode.c(this.f16528a, this.f16529b).a(r3, r4);
    }

    private b e(d.c.h.d r2, boolean r3) {
        return new g(this.f16528a).a(r2, r3);
    }

    @Override // d.c.i.s.c
    public b a(d.c.h.d r2, boolean r3) {
        b r0 = b(r2, r3);
        if (r0 != null) goto L5;
        r0 = c(r2, r3);
    L5:
        if (r0 != null) goto L7;
        r0 = d(r2, r3);
    L7:
        if (r0 == null) goto L9;
        return r0;
    L9:
        return e(r2, r3);
    }
}
