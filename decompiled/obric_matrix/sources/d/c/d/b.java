package d.c.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class b<T> implements e<T> {
    public b() {
    }

    @Override // d.c.d.e
    public void a(c<T> r1) {
    }

    @Override // d.c.d.e
    public void b(c<T> r1) {
        e(r1);     // Catch: Throwable -> L5
        r1.close();
        return;
    L5:
        th = move-exception;
        r1.close();
        throw th;
    }

    @Override // d.c.d.e
    public void c(c<T> r2) {
        boolean r0 = r2.b();
        f(r2);     // Catch: Throwable -> L7
        if (r0 == false) goto L13;
        r2.close();
        return;
    L13:
        return;
    L7:
        th = move-exception;
        if (r0 == false) goto L10;
        r2.close();
    L10:
        throw th;
    }

    @Override // d.c.d.e
    public void d(c<T> r1) {
    }

    protected abstract void e(c<T> r1);

    protected abstract void f(c<T> r1);
}
