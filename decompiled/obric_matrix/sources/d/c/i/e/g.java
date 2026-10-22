package d.c.i.e;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x<V> f15946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashMap<K, V> f15947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15948c;

    public g(x<V> r2) {
        this.f15947b = new LinkedHashMap();
        this.f15948c = 0;
        this.f15946a = r2;
    }

    private int g(V r1) {
        if (r1 != null) goto L5;
        return 0;
    L5:
        return this.f15946a.a(r1);
    }

    public synchronized ArrayList<V> a() {
        monitor-enter(this);
        ArrayList<V> r0 = new ArrayList(this.f15947b.values());     // Catch: Throwable -> L6
        this.f15947b.clear();     // Catch: Throwable -> L6
        this.f15948c = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean b(K r2) {
        monitor-enter(this);
        boolean r3 = this.f15947b.containsKey(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized V c(K r2) {
        monitor-enter(this);
        V r3 = this.f15947b.get(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int d() {
        monitor-enter(this);
        int r0 = this.f15947b.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized K e() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f15947b.isEmpty() == false) goto L6;
        K r0 = null;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = this.f15947b.keySet().iterator().next();     // Catch: Throwable -> L9
        goto L7
    }

    public synchronized int f() {
        monitor-enter(this);
        int r0 = this.f15948c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized V h(K r4, V r5) {
        monitor-enter(this);
        V r0 = this.f15947b.remove(r4);     // Catch: Throwable -> L6
        this.f15948c -= g(r0);     // Catch: Throwable -> L6
        this.f15947b.put(r4, r5);     // Catch: Throwable -> L6
        this.f15948c += g(r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized V i(K r3) {
        monitor-enter(this);
        V r4 = this.f15947b.remove(r3);     // Catch: Throwable -> L6
        this.f15948c -= g(r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized ArrayList<V> j(d.c.c.d.j<K> r5) {
        monitor-enter(this);
        ArrayList<V> r0 = new ArrayList();     // Catch: Throwable -> L14
        Iterator<Map.Entry<K, V>> r1 = this.f15947b.entrySet().iterator();     // Catch: Throwable -> L14
    L4:
        if (r1.hasNext() == false) goto L12;
        Map.Entry<K, V> r2 = r1.next();     // Catch: Throwable -> L14
        if (r5 == null) goto L10;
        if (r5.apply(r2.getKey()) == false) goto L4;
    L10:
        r0.add(r2.getValue());     // Catch: Throwable -> L14
        this.f15948c -= g(r2.getValue());     // Catch: Throwable -> L14
        r1.remove();     // Catch: Throwable -> L14
        goto L4
    L12:
        monitor-exit(this);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }
}
