package d.c.c.h;

import d.c.c.d.i;
import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<Object, Integer> f15421d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private T f15422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c<T> f15424c;

    public static class a extends RuntimeException {
        public a() {
            super("Null shared reference");
        }
    }

    static {
        f15421d = new IdentityHashMap();
    }

    public d(T r1, c<T> r2) {
        i.g(r1);
        this.f15422a = r1;
        i.g(r2);
        this.f15424c = r2;
        this.f15423b = 1;
        a(r1);
    }

    private static void a(Object r3) {
        Map<Object, Integer> r0 = f15421d;
        monitor-enter(r0);
        Integer r1 = r0.get(r3);     // Catch: Throwable -> L11
        if (r1 != null) goto L8;
        int r2 = 1;     // Catch: Throwable -> L11
    L7:
        r0.put(r3, r2);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        r2 = Integer.valueOf(r1.intValue() + 1);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private void e() {
        if (h(this) == false) goto L6;
        return;
    L6:
        throw new a();
    }

    public static boolean h(d<?> r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.g() == false) goto L6;
        return true;
    }

    private static void i(Object r5) {
        Map<Object, Integer> r0 = f15421d;
        monitor-enter(r0);
        Integer r1 = r0.get(r5);     // Catch: Throwable -> L13
        if (r1 != null) goto L8;
        d.c.c.e.a.G("SharedReference", "No entry in sLiveObjects for value of type %s", new Object[]{r5.getClass()});     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L8:
        if (r1.intValue() != 1) goto L10;
        r0.remove(r5);     // Catch: Throwable -> L13
        goto L11
    L10:
        r0.put(r5, Integer.valueOf(r1.intValue() - 1));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized void b() {
        monitor-enter(this);
        e();     // Catch: Throwable -> L6
        this.f15423b++;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int c() {
        monitor-enter(this);
        e();     // Catch: Throwable -> L10
        if (this.f15423b <= 0) goto L6;
        boolean r0 = true;
    L7:
        i.b(r0);     // Catch: Throwable -> L10
        int r1 = this.f15423b - 1;     // Catch: Throwable -> L10
        this.f15423b = r1;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r1;
    L6:
        r0 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public void d() {
        if (c() != 0) goto L11;
        monitor-enter(this);
        T r0 = this.f15422a;     // Catch: Throwable -> L8
        this.f15422a = null;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        this.f15424c.release(r0);
        i(r0);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized T f() {
        monitor-enter(this);
        T r0 = this.f15422a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean g() {
        monitor-enter(this);
        if (this.f15423b <= 0) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }
}
