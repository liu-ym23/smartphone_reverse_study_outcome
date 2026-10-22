package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* JADX INFO: loaded from: classes2.dex */
@InternalCoroutinesApi
@Metadata
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private volatile int _size;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadSafeHeapNode[] f430a;

    public ThreadSafeHeap() {
        this._size = 0;
    }

    public final void a(ThreadSafeHeapNode r4) {
        boolean r0 = DebugKt.f370a;
        r4.a(this);
        ThreadSafeHeapNode[] r1 = this.f430a;
        if (r1 != null) goto L6;
        r1 = new ThreadSafeHeapNode[4];
        this.f430a = r1;
    L8:
        int r2 = this._size;
        this._size = r2 + 1;
        r1[r2] = r4;
        r4.b(r2);
        e(r2);
        return;
    L6:
        if (this._size < r1.length) goto L8;
        Object[] r3 = Arrays.copyOf(r1, this._size * 2);
        Intrinsics.e(r3, "java.util.Arrays.copyOf(this, newSize)");
        r1 = (ThreadSafeHeapNode[]) r3;
        this.f430a = r1;
        goto L8
    }

    public final boolean b() {
        if (this._size != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final ThreadSafeHeapNode c(int r8) {
        boolean r0 = DebugKt.f370a;
        ThreadSafeHeapNode[] r1 = this.f430a;
        Intrinsics.c(r1);
        this._size--;
        if (r8 >= this._size) goto L22;
        f(r8, this._size);
        int r2 = (r8 - 1) / 2;
        if (r8 <= 0) goto L9;
        ThreadSafeHeapNode r3 = r1[r8];
        Intrinsics.c(r3);
        ThreadSafeHeapNode r4 = r1[r2];
        Intrinsics.c(r4);
        if (((Comparable) r3).compareTo(r4) >= 0) goto L9;
        f(r8, r2);
        e(r2);
    L9:
        int r5 = r8 * 2;
        int r6 = r5 + 1;
        if (r6 >= this._size) goto L22;
        ThreadSafeHeapNode[] r7 = this.f430a;
        Intrinsics.c(r7);
        int r9 = r5 + 2;
        if (r9 >= this._size) goto L17;
        ThreadSafeHeapNode r10 = r7[r9];
        Intrinsics.c(r10);
        ThreadSafeHeapNode r11 = r7[r6];
        Intrinsics.c(r11);
        if (((Comparable) r10).compareTo(r11) >= 0) goto L17;
    L18:
        ThreadSafeHeapNode r12 = r7[r8];
        Intrinsics.c(r12);
        ThreadSafeHeapNode r13 = r7[r9];
        Intrinsics.c(r13);
        if (((Comparable) r12).compareTo(r13) <= 0) goto L22;
        f(r8, r9);
        r8 = r9;
    L17:
        r9 = r6;
    L22:
        ThreadSafeHeapNode r14 = r1[this._size];
        Intrinsics.c(r14);
        boolean r15 = DebugKt.f370a;
        r14.a(null);
        r14.b(-1);
        r1[this._size] = null;
        return r14;
    }

    public final ThreadSafeHeapNode d() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this._size <= 0) goto L9;
        ThreadSafeHeapNode r0 = c(0);     // Catch: Throwable -> L7
    L10:
        monitor-exit(this);
        return r0;
    L9:
        r0 = null;
        goto L10
    }

    public final void e(int r4) {
    L2:
        if (r4 <= 0) goto L3;
        ThreadSafeHeapNode[] r0 = this.f430a;
        Intrinsics.c(r0);
        int r1 = (r4 - 1) / 2;
        ThreadSafeHeapNode r2 = r0[r1];
        Intrinsics.c(r2);
        ThreadSafeHeapNode r3 = r0[r4];
        Intrinsics.c(r3);
        if (((Comparable) r2).compareTo(r3) <= 0) goto L6;
        f(r4, r1);
        r4 = r1;
        goto L2
    L6:
        return;
    }

    public final void f(int r3, int r4) {
        ThreadSafeHeapNode[] r2 = this.f430a;
        Intrinsics.c(r2);
        ThreadSafeHeapNode r0 = r2[r4];
        Intrinsics.c(r0);
        ThreadSafeHeapNode r1 = r2[r3];
        Intrinsics.c(r1);
        r2[r3] = r0;
        r2[r4] = r1;
        r0.b(r3);
        r1.b(r4);
    }
}
