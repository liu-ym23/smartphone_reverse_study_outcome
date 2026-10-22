package d.c.c.h;

import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes.dex */
public class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    SoftReference<T> f15418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    SoftReference<T> f15419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    SoftReference<T> f15420c;

    public b() {
        this.f15418a = null;
        this.f15419b = null;
        this.f15420c = null;
    }

    public void a() {
        SoftReference<T> r0 = this.f15418a;
        if (r0 == null) goto L5;
        r0.clear();
        this.f15418a = null;
    L5:
        SoftReference<T> r1 = this.f15419b;
        if (r1 == null) goto L8;
        r1.clear();
        this.f15419b = null;
    L8:
        SoftReference<T> r2 = this.f15420c;
        if (r2 == null) goto L12;
        r2.clear();
        this.f15420c = null;
        return;
    }

    public T b() {
        SoftReference<T> r0 = this.f15418a;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get();
    }

    public void c(T r2) {
        this.f15418a = new SoftReference(r2);
        this.f15419b = new SoftReference(r2);
        this.f15420c = new SoftReference(r2);
    }
}
