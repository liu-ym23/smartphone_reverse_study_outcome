package d.c.i.e;

import com.facebook.common.time.RealtimeSinceBootClock;

/* JADX INFO: loaded from: classes2.dex */
public class c implements d.c.b.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.i.f.f f15918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.c.i.f.g f15919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.c.i.f.c f15920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.c.b.a.d f15921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f15922f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f15923g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f15924h;

    public c(String r7, d.c.i.f.f r8, d.c.i.f.g r9, d.c.i.f.c r10, d.c.b.a.d r11, String r12, Object r13) {
        d.c.c.d.i.g(r7);
        this.f15917a = r7;
        this.f15918b = r8;
        this.f15919c = r9;
        this.f15920d = r10;
        this.f15921e = r11;
        this.f15922f = r12;
        Integer r0 = Integer.valueOf(r7.hashCode());
        if (r8 == null) goto L5;
        int r14 = r8.hashCode();
    L6:
        this.f15923g = d.c.c.k.b.e(r0, Integer.valueOf(r14), Integer.valueOf(r9.hashCode()), r10, r11, r12);
        this.f15924h = r13;
        RealtimeSinceBootClock.get().now();
        return;
    L5:
        r14 = 0;
        goto L6
    }

    @Override // d.c.b.a.d
    public String a() {
        return this.f15917a;
    }

    @Override // d.c.b.a.d
    public boolean equals(Object r4) {
        if ((r4 instanceof c) == true) goto L5;
        return false;
    L5:
        c r5 = (c) r4;
        if (this.f15923g == r5.f15923g) goto L8;
        return false;
    L8:
        if (this.f15917a.equals(r5.f15917a) == true) goto L10;
        return false;
    L10:
        if (d.c.c.d.h.a(this.f15918b, r5.f15918b) == true) goto L12;
        return false;
    L12:
        if (d.c.c.d.h.a(this.f15919c, r5.f15919c) == true) goto L14;
        return false;
    L14:
        if (d.c.c.d.h.a(this.f15920d, r5.f15920d) == true) goto L16;
        return false;
    L16:
        if (d.c.c.d.h.a(this.f15921e, r5.f15921e) == true) goto L18;
        return false;
    L18:
        if (d.c.c.d.h.a(this.f15922f, r5.f15922f) == false) goto L27;
        return true;
    L27:
        return false;
    }

    @Override // d.c.b.a.d
    public int hashCode() {
        return this.f15923g;
    }

    @Override // d.c.b.a.d
    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", new Object[]{this.f15917a, this.f15918b, this.f15919c, this.f15920d, this.f15921e, this.f15922f, Integer.valueOf(this.f15923g)});
    }
}
