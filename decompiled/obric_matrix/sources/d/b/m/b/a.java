package d.b.m.b;

import a.b.a.a.d;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.b0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedList<T> f14138a;

    public a() {
        this.f14138a = new LinkedList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void a(l<? super T, Boolean> r4) {
        monitor-enter(this);
        o.g(r4, "action");     // Catch: Throwable -> L16
        Object r0 = this.f14138a.clone();     // Catch: Throwable -> L16
        if (r0 == null) goto L15;
        Iterator r1 = ((LinkedList) r0).iterator();     // Catch: Throwable -> L16
    L7:
        if (r1.hasNext() == false) goto L12;
        d.b r2 = (Object) r1.next();
        if (r4.invoke(r2).booleanValue() == false) goto L7;
        c(r2);     // Catch: Throwable -> L16
        goto L7
    L12:
        monitor-exit(this);
        return;
    L15:
        throw new b0("null cannot be cast to non-null type java.util.LinkedList<T>");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(T r2) {
        monitor-enter(this);
        this.f14138a.addFirst(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void c(T r2) {
        monitor-enter(this);
        this.f14138a.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
