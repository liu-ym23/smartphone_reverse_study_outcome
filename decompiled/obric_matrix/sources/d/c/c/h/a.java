package d.c.c.h;

import com.facebook.infer.annotation.PropagatesNullable;
import d.c.c.d.i;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a<T> implements Cloneable, Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Class<a> f15414h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final c<Closeable> f15415i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f15416f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d<T> f15417g;

    /* JADX INFO: renamed from: d.c.c.h.a$a, reason: collision with other inner class name */
    static class C0414a implements c<Closeable> {
        C0414a() {
        }

        public void a(Closeable r1) {
            d.c.c.d.b.a(r1, true);     // Catch: IOException -> L5
            return;
        }

        @Override // d.c.c.h.c
        public /* bridge */ /* synthetic */ void release(Closeable r1) {
            a(r1);
        }
    }

    static {
        f15414h = a.class;
        f15415i = new C0414a();
    }

    private a(d<T> r2) {
        this.f15416f = false;
        i.g(r2);
        this.f15417g = r2;
        r2.b();
    }

    private a(T r2, c<T> r3) {
        this.f15416f = false;
        this.f15417g = new d(r2, r3);
    }

    public static <T> a<T> E(a<T> r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.C();
    }

    public static <T> List<a<T>> F(@PropagatesNullable Collection<a<T>> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList(r2.size());
        Iterator<a<T>> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        r0.add(E(r3.next()));
        goto L7
    L9:
        return r0;
    }

    public static void L(a<?> r0) {
        if (r0 == null) goto L5;
        r0.close();
        return;
    }

    public static void M(Iterable<? extends a<?>> r1) {
        if (r1 == null) goto L7;
        Iterator<? extends a<?>> r2 = r1.iterator();
    L5:
        if (r2.hasNext() == false) goto L9;
        L(r2.next());
        goto L5
    L9:
        return;
    }

    public static boolean S(a<?> r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.Q() == false) goto L6;
        return true;
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/io/Closeable;>(TT;)Ld/c/c/h/a<TT;>; */
    public static a V(@PropagatesNullable Closeable r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new a(r2, f15415i);
    }

    public static <T> a<T> X(@PropagatesNullable T r1, c<T> r2) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return new a(r1, r2);
    }

    public synchronized a<T> C() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (Q() == false) goto L9;
        a<T> r0 = a();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L9:
        monitor-exit(this);
        return null;
    }

    public synchronized T N() {
        monitor-enter(this);
        T r0 = this.f15417g.f();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public int O() {
        if (Q() == true) goto L7;
        return 0;
    L7:
        return System.identityHashCode(this.f15417g.f());
    }

    public synchronized boolean Q() {
        monitor-enter(this);
        boolean r0 = !this.f15416f;
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized a<T> a() {
        monitor-enter(this);
        i.i(Q());     // Catch: Throwable -> L6
        a<T> r0 = new a(this.f15417g);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f15416f == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L7:
        this.f15416f = true;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        this.f15417g.d();
    }

    protected void finalize() {
        monitor-enter(this);     // Catch: Throwable -> L15
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L4:
        if (this.f15416f == false) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L12
        super.finalize();
        return;
    L8:
        monitor-exit(this);     // Catch: Throwable -> L12
        d.c.c.e.a.b(f15414h, "Finalized without closing: %x %x (type = %s)", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f15417g)), this.f15417g.f().getClass().getName());     // Catch: Throwable -> L15
        close();     // Catch: Throwable -> L15
        super.finalize();
        return;
    L15:
        th = move-exception;
        super.finalize();
        throw th;
    }
}
