package f.a.j.a;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends AtomicReference<f.a.i.c> implements f.a.g.b {
    public a(f.a.i.c r1) {
        super(r1);
    }

    @Override // f.a.g.b
    public void dispose() {
        if (get() == null) goto L13;
        f.a.i.c r1 = getAndSet(null);
        if (r1 == null) goto L14;
        r1.cancel();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        f.a.h.b.a(e);
        f.a.k.a.m(e);
        return;
    L14:
        return;
    }
}
