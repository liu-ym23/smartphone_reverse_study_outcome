package d.e.b.a.l.c;

import d.e.b.a.l.c.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
final class a<T extends f> implements e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.e.b.a.b f16641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.e.b.a.l.b.b f16642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final T f16643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, String> f16644d;

    a(d.e.b.a.b r1, d.e.b.a.l.b.b r2, T r3) {
        this.f16641a = r1;
        this.f16642b = r2;
        this.f16643c = r3;
        this.f16644d = new ConcurrentHashMap();
    }

    private synchronized void b(String r4) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f16644d.containsKey(r4) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator<d.e.b.a.g> r0 = c(r4).iterator();     // Catch: Throwable -> L14
    L9:
        if (r0.hasNext() == false) goto L11;
        d.e.b.a.g r1 = r0.next();     // Catch: Throwable -> L14
        this.f16643c.a(r1);     // Catch: Throwable -> L14
        goto L9
    L11:
        this.f16644d.put(r4, r4);     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    private Collection<d.e.b.a.g> c(String r4) {
        return this.f16642b.d(this.f16641a.a(r4));
    L4:
        e = move-exception;
        throw new IllegalStateException("Failed to read file " + r4, e);
    }

    @Override // d.e.b.a.l.c.e
    public T a(String r2) {
        if (this.f16644d.containsKey(r2) == true) goto L6;
        b(r2);
    L6:
        return this.f16643c;
    }
}
