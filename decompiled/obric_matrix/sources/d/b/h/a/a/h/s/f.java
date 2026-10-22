package d.b.h.a.a.h.s;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<K, V> f13753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f13759g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f13760h;

    public f(int r4) {
        if (r4 <= 0) goto L7;
        this.f13755c = r4;
        this.f13753a = Collections.synchronizedMap(new LinkedHashMap(0, 0.75f, true));
        return;
    L7:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int h(K r3, V r4) {
        int r2 = j(r3, r4);
        if (r2 < 0) goto L6;
        return r2;
    L6:
        throw new IllegalStateException("Negative size: " + r3 + "=" + r4);
    }

    private void k(int r5) {
    L3:
        if (this.f13754b <= r5) goto L11;
        if (this.f13753a.isEmpty() == true) goto L11;
        Map.Entry<K, V> r0 = this.f13753a.entrySet().iterator().next();
        if (r0 == null) goto L11;
        K r1 = r0.getKey();
        V r2 = r0.getValue();
        this.f13753a.remove(r1);
        this.f13754b -= h(r1, r2);
        this.f13758f++;
        b(r1, r2);
    L11:
        if (this.f13754b < 0) goto L18;
        if (this.f13753a.isEmpty() == true) goto L15;
        return;
    L15:
        if (this.f13754b != 0) goto L18;
        return;
    L18:
        throw new IllegalStateException(f.class.getName() + ".sizeOf() is reporting inconsistent results!");
    }

    protected V a(K r1) {
        return null;
    }

    protected void b(K r1, V r2) {
    }

    public final synchronized void c() {
        monitor-enter(this);
        k(-1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized V d(K r4) {
        monitor-enter(this);
        if (r4 == null) goto L17;
        V r0 = this.f13753a.get(r4);     // Catch: Throwable -> L14
        if (r0 == null) goto L9;
        this.f13759g++;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r0;
    L9:
        this.f13760h++;     // Catch: Throwable -> L14
        V r1 = a(r4);     // Catch: Throwable -> L14
        if (r1 == null) goto L12;
        this.f13757e++;     // Catch: Throwable -> L14
        this.f13754b += h(r4, r1);     // Catch: Throwable -> L14
        this.f13753a.put(r4, r1);     // Catch: Throwable -> L14
        k(this.f13755c);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return r1;
    L17:
        throw new NullPointerException("key == null");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized Map<K, V> e() {
        monitor-enter(this);
        Map<K, V> r0 = this.f13753a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized V f(K r3, V r4) {
        monitor-enter(this);
        if (r3 == null) goto L12;
        if (r4 == null) goto L12;
        this.f13756d++;     // Catch: Throwable -> L13
        this.f13754b += h(r3, r4);     // Catch: Throwable -> L13
        V r5 = this.f13753a.put(r3, r4);     // Catch: Throwable -> L13
        if (r5 == null) goto L8;
        this.f13754b -= h(r3, r5);     // Catch: Throwable -> L13
    L8:
        k(this.f13755c);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r5;
    L12:
        throw new NullPointerException("key == null || value == null");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized V g(K r3) {
        monitor-enter(this);
        if (r3 == null) goto L12;
        V r0 = this.f13753a.remove(r3);     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        this.f13754b -= h(r3, r0);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return r0;
    L12:
        throw new NullPointerException("key == null");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized int i() {
        monitor-enter(this);
        int r0 = this.f13754b;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    protected int j(K r1, V r2) {
        return 1;
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r0 = this.f13759g;     // Catch: Throwable -> L10
        int r1 = this.f13760h + r0;     // Catch: Throwable -> L10
        if (r1 == 0) goto L6;
        int r2 = (r0 * 100) / r1;     // Catch: Throwable -> L10
    L7:
        String r3 = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f13755c), Integer.valueOf(this.f13759g), Integer.valueOf(this.f13760h), Integer.valueOf(r2)});     // Catch: Throwable -> L10
        monitor-exit(this);
        return r3;
    L6:
        r2 = 0;
    L10:
        th = move-exception;
        throw th;
    }
}
