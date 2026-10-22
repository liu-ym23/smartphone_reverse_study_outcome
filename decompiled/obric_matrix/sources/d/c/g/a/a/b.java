package d.c.g.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import d.c.g.a.a.a;

/* JADX WARN: Unexpected interfaces in signature: [java.lang.Object] */
/* JADX INFO: loaded from: classes.dex */
public class b<T extends a> implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private T f15742a;

    public b(T r1) {
        this.f15742a = r1;
    }

    public b(T r1, d.c.h.d r2) {
        this.f15742a = r1;
    }

    @Override // d.c.g.a.a.d
    public int a() {
        T r0 = this.f15742a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.a();
    }

    @Override // d.c.g.a.a.d
    public int b() {
        T r0 = this.f15742a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.b();
    }

    @Override // d.c.g.a.a.a
    public int c() {
        T r0 = this.f15742a;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.c();
    }

    @Override // d.c.g.a.a.a
    public void clear() {
        T r0 = this.f15742a;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    @Override // d.c.g.a.a.a
    public void d(Rect r1) {
        T r0 = this.f15742a;
        if (r0 == null) goto L6;
        r0.d(r1);
        return;
    }

    @Override // d.c.g.a.a.a
    public int e() {
        T r0 = this.f15742a;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.e();
    }

    @Override // d.c.g.a.a.a
    public boolean f(int r1) {
        T r0 = this.f15742a;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.f(r1);
    }

    public T g() {
        return this.f15742a;
    }

    @Override // d.c.g.a.a.a
    public void h(ColorFilter r1) {
        T r0 = this.f15742a;
        if (r0 == null) goto L6;
        r0.h(r1);
        return;
    }

    @Override // d.c.g.a.a.d
    public int i(int r1) {
        T r0 = this.f15742a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.i(r1);
    }

    @Override // d.c.g.a.a.a
    public void j(@IntRange(from = 0, to = 255) int r1) {
        T r0 = this.f15742a;
        if (r0 == null) goto L6;
        r0.j(r1);
        return;
    }

    @Override // d.c.g.a.a.a
    public boolean k(Drawable r1, Canvas r2, int r3) {
        T r0 = this.f15742a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.k(r1, r2, r3) == false) goto L7;
        return true;
    }
}
