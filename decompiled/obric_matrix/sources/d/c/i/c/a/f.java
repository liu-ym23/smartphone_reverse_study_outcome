package d.c.i.c.a;

import android.graphics.Bitmap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f15859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d.c.c.h.a<Bitmap> f15860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<d.c.c.h.a<Bitmap>> f15861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f15862d;

    f(c r1) {
        this.f15859a = r1;
    }

    public e a() {
        e r1 = new e(this);     // Catch: Throwable -> L6
        d.c.c.h.a.L(this.f15860b);
        this.f15860b = null;
        d.c.c.h.a.M(this.f15861c);
        this.f15861c = null;
        return r1;
    L6:
        th = move-exception;
        d.c.c.h.a.L(this.f15860b);
        this.f15860b = null;
        d.c.c.h.a.M(this.f15861c);
        this.f15861c = null;
        throw th;
    }

    public List<d.c.c.h.a<Bitmap>> b() {
        return d.c.c.h.a.F(this.f15861c);
    }

    public int c() {
        return this.f15862d;
    }

    public c d() {
        return this.f15859a;
    }

    public d.c.c.h.a<Bitmap> e() {
        return d.c.c.h.a.E(this.f15860b);
    }

    public f f(List<d.c.c.h.a<Bitmap>> r1) {
        this.f15861c = d.c.c.h.a.F(r1);
        return this;
    }

    public f g(int r1) {
        this.f15862d = r1;
        return this;
    }

    public f h(d.c.c.h.a<Bitmap> r1) {
        this.f15860b = d.c.c.h.a.E(r1);
        return this;
    }
}
