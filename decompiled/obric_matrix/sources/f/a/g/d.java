package f.a.g;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
abstract class d<T> extends AtomicReference<T> implements b {
    d(T r2) {
        f.a.j.b.b.c(r2, "value is null");
        super(r2);
    }

    public final boolean a() {
        if (get() != null) goto L5;
        return true;
    L5:
        return false;
    }

    protected abstract void b(T r1);

    @Override // f.a.g.b
    public final void dispose() {
        if (get() == null) goto L8;
        T r0 = getAndSet(null);
        if (r0 == null) goto L9;
        b(r0);
        return;
    L9:
        return;
    }
}
