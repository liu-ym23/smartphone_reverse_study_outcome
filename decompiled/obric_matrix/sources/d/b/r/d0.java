package d.b.r;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class d0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.b.r.h0.d f14349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f14350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.b.r.k0.i f14351c;

    private d0(d.b.r.h0.d r1, T r2, d.b.r.k0.i r3) {
        this.f14349a = r1;
        this.f14350b = r2;
        this.f14351c = r3;
    }

    public static <T> d0<T> c(d.b.r.k0.i r2, d.b.r.h0.d r3) {
        Objects.requireNonNull(r2, "body == null");
        Objects.requireNonNull(r3, "rawResponse == null");
        if (r3.i() == true) goto L7;
        return new d0(r3, null, r2);
    L7:
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> d0<T> i(T r2, d.b.r.h0.d r3) {
        Objects.requireNonNull(r3, "rawResponse == null");
        if (r3.i() == false) goto L7;
        return new d0(r3, r2, null);
    L7:
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public T a() {
        return this.f14350b;
    }

    public int b() {
        return this.f14349a.e();
    }

    public List<d.b.r.h0.b> d() {
        return this.f14349a.d();
    }

    public boolean e() {
        return this.f14349a.i();
    }

    public String f() {
        return this.f14349a.j();
    }

    public d.b.r.h0.d g() {
        return this.f14349a;
    }

    public void h(y r1) {
    }
}
