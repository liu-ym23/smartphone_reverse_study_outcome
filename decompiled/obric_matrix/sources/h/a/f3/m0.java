package h.a.f3;

import h.a.f3.n0;
import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\u0018\u0002\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u000602j\u0002`3B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\tJ.\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u00002\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\f0\u000bH\u0086\b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0005J\u0011\u0010\u0011\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f0\u000bH\u0086\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b \u0010\u0012J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0019H\u0082\u0010¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0019H\u0082\u0010¢\u0006\u0004\b$\u0010#J\u001f\u0010&\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019H\u0002¢\u0006\u0004\b&\u0010'R \u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b*\u0010+R$\u00100\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00198F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u0010#¨\u00061"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "<init>", "()V", "node", "", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "Lkotlin/Function1;", "", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "predicate", "removeFirstIf", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "i", "siftDownFrom", "(I)V", "siftUpFrom", "j", "swap", "(II)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "value", "getSize", "()I", "setSize", "size", "kotlinx-coroutines-core", "", "Lkotlinx/coroutines/internal/SynchronizedObject;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class m0<T extends n0 & Comparable<? super T>> {
    private volatile /* synthetic */ int _size;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private T[] f17397a;

    public m0() {
        this._size = 0;
    }

    private final T[] f() {
        T[] r0 = this.f17397a;
        if (r0 != null) goto L6;
        T[] r1 = (T[]) new n0[4];
        this.f17397a = r1;
        return r1;
    L6:
        if (c() < r0.length) goto L10;
        Object[] r2 = Arrays.copyOf(r0, c() * 2);
        kotlin.n0.d.o.e(r2, "copyOf(this, newSize)");
        T[] r3 = (T[]) ((n0[]) r2);
        this.f17397a = r3;
        return r3;
    L10:
        return r0;
    }

    private final void j(int r1) {
        this._size = r1;
    }

    private final void k(int r6) {
    L2:
        int r0 = (r6 * 2) + 1;
        if (r0 >= c()) goto L4;
        T[] r1 = this.f17397a;
        kotlin.n0.d.o.c(r1);
        int r2 = r0 + 1;
        if (r2 >= c()) goto L10;
        T r3 = r1[r2];
        kotlin.n0.d.o.c(r3);
        T r4 = r1[r0];
        kotlin.n0.d.o.c(r4);
        if (((Comparable) r3).compareTo(r4) >= 0) goto L10;
        r0 = r2;
    L10:
        T r5 = r1[r6];
        kotlin.n0.d.o.c(r5);
        T r7 = r1[r0];
        kotlin.n0.d.o.c(r7);
        if (((Comparable) r5).compareTo(r7) <= 0) goto L12;
        m(r6, r0);
        r6 = r0;
        goto L2
    L12:
        return;
    }

    private final void l(int r4) {
    L2:
        if (r4 <= 0) goto L3;
        T[] r0 = this.f17397a;
        kotlin.n0.d.o.c(r0);
        int r1 = (r4 - 1) / 2;
        T r2 = r0[r1];
        kotlin.n0.d.o.c(r2);
        T r3 = r0[r4];
        kotlin.n0.d.o.c(r3);
        if (((Comparable) r2).compareTo(r3) <= 0) goto L6;
        m(r4, r1);
        r4 = r1;
        goto L2
    L6:
        return;
    }

    private final void m(int r3, int r4) {
        T[] r2 = this.f17397a;
        kotlin.n0.d.o.c(r2);
        T r0 = r2[r4];
        kotlin.n0.d.o.c(r0);
        T r1 = r2[r3];
        kotlin.n0.d.o.c(r1);
        r2[r3] = r0;
        r2[r4] = r1;
        r0.g(r3);
        r1.g(r4);
    }

    public final void a(T r4) {
        if (h.a.q0.a() == true) goto L5;
    L12:
        r4.a(this);
        n0[] r0 = f();
        int r1 = c();
        j(r1 + 1);
        r0[r1] = r4;
        r4.g(r1);
        l(r1);
        return;
    L5:
        if (r4.b() != null) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L12;
        throw new AssertionError();
    L7:
        r2 = false;
        goto L8
    }

    public final T b() {
        T[] r1 = this.f17397a;
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1[0];
    }

    public final int c() {
        return this._size;
    }

    public final boolean d() {
        if (c() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final T e() {
        monitor-enter(this);
        T r0 = (T) b();
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean g(T r4) {
        monitor-enter(this);
        boolean r1 = true;
        boolean r2 = false;
        if (r4.b() != null) goto L6;
        r1 = false;
    L15:
        monitor-exit(this);
        return r1;
    L6:
        int r5 = r4.j();     // Catch: Throwable -> L17
        if (h.a.q0.a() == false) goto L14;
        if (r5 < 0) goto L10;
        r2 = true;
    L10:
        if (r2 == true) goto L14;
        throw new AssertionError();     // Catch: Throwable -> L17
    L14:
        h(r5);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public final T h(int r8) {
        boolean r1 = false;
        if (h.a.q0.a() == true) goto L5;
    L12:
        T[] r0 = this.f17397a;
        kotlin.n0.d.o.c(r0);
        j(c() - 1);
        if (r8 >= c()) goto L20;
        m(r8, c());
        int r3 = (r8 - 1) / 2;
        if (r8 <= 0) goto L19;
        T r5 = r0[r8];
        kotlin.n0.d.o.c(r5);
        T r6 = r0[r3];
        kotlin.n0.d.o.c(r6);
        if (((Comparable) r5).compareTo(r6) >= 0) goto L19;
        m(r8, r3);
        l(r3);
    L19:
        k(r8);
    L20:
        T r9 = r0[c()];
        kotlin.n0.d.o.c(r9);
        if (h.a.q0.a() == true) goto L23;
    L29:
        r9.a(null);
        r9.g(-1);
        r0[c()] = null;
        return r9;
    L23:
        if (r9.b() != this) goto L25;
        r1 = true;
    L25:
        if (r1 == true) goto L29;
        throw new AssertionError();
    L5:
        if (c() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L12;
        throw new AssertionError();
    L7:
        r2 = false;
        goto L8
    }

    public final T i() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (c() <= 0) goto L7;
        T r0 = (T) h(0);
    L8:
        monitor-exit(this);
        return r0;
    L7:
        r0 = null;
        goto L8
    }
}
