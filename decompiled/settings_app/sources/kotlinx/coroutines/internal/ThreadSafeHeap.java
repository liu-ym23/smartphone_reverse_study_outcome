package kotlinx.coroutines.internal;

import android.icu.text.DateFormat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

/* JADX INFO: compiled from: ThreadSafeHeap.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J,\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u00002\u0014\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\r0\u001dH\u0086\b¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0017J0\u0010 \u001a\u0004\u0018\u00018\u00002!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\r0\u001d¢\u0006\u0002\u0010$J\u000f\u0010%\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0002\u0010&J\r\u0010'\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010&J\u0015\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\nH\u0002¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010+J\u0015\u0010,\u001a\u00028\u00002\u0006\u0010-\u001a\u00020\u0010H\u0001¢\u0006\u0002\u0010.J$\u0010/\u001a\u0004\u0018\u00018\u00002\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u001dH\u0086\b¢\u0006\u0002\u0010$J\r\u00100\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010&J\u0011\u00101\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0010H\u0082\u0010J\u0011\u00103\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u0010H\u0082\u0010J\u0018\u00104\u001a\u00020\u00172\u0006\u00102\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u0010H\u0002R\t\u0010\u0007\u001a\u00020\bX\u0082\u0004R\u001a\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u00066"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "()V", "_size", "Lkotlinx/atomicfu/AtomicInt;", "a", "", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "", "()Z", "value", "", PerfConsts.PERF_DISK_FILE_SIZE, "getSize", "()I", "setSize", "(I)V", "addImpl", "", "node", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "addLastIf", "cond", "Lkotlin/Function1;", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "find", "predicate", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "removeAtImpl", "index", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstIf", "removeFirstOrNull", "siftDownFrom", "i", "siftUpFrom", "swap", DateFormat.HOUR, "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ThreadSafeHeap<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private static final AtomicIntegerFieldUpdater _size$FU = null;

    @Volatile
    private volatile int _size;
    private T[] a;

    static {
        _size$FU = AtomicIntegerFieldUpdater.newUpdater(ThreadSafeHeap.class, "_size");
    }

    public ThreadSafeHeap() {
    }

    public final int getSize() {
        return _size$FU.get(this);
    }

    private final void setSize(int r2) {
        _size$FU.set(this, r2);
    }

    public final boolean isEmpty() {
        if (getSize() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final T firstImpl() {
        T[] r1 = this.a;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1[0];
    }

    public final T removeAtImpl(int r8) {
        boolean r1 = false;
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L12:
        T[] r0 = this.a;
        Intrinsics.checkNotNull(r0);
        setSize(getSize() - 1);
        if (r8 >= getSize()) goto L20;
        swap(r8, getSize());
        int r3 = (r8 - 1) / 2;
        if (r8 <= 0) goto L19;
        T r5 = r0[r8];
        Intrinsics.checkNotNull(r5);
        T r6 = r0[r3];
        Intrinsics.checkNotNull(r6);
        if (((Comparable) r5).compareTo(r6) >= 0) goto L19;
        swap(r8, r3);
        siftUpFrom(r3);
    L19:
        siftDownFrom(r8);
    L20:
        T r9 = r0[getSize()];
        Intrinsics.checkNotNull(r9);
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L23;
    L29:
        r9.setHeap(null);
        r9.setIndex(-1);
        r0[getSize()] = null;
        return r9;
    L23:
        if (r9.getHeap() != this) goto L25;
        r1 = true;
    L25:
        if (r1 == true) goto L29;
        throw new AssertionError();
    L5:
        if (getSize() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L12;
        throw new AssertionError();
    L7:
        r2 = false;
        goto L8
    }

    public final void addImpl(T r4) {
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
    L12:
        r4.setHeap(this);
        ThreadSafeHeapNode[] r0 = realloc();
        int r1 = getSize();
        setSize(r1 + 1);
        r0[r1] = r4;
        r4.setIndex(r1);
        siftUpFrom(r1);
        return;
    L5:
        if (r4.getHeap() != null) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L12;
        throw new AssertionError();
    L7:
        r2 = false;
        goto L8
    }

    private final void siftUpFrom(int r4) {
    L2:
        if (r4 <= 0) goto L3;
        T[] r0 = this.a;
        Intrinsics.checkNotNull(r0);
        int r1 = (r4 - 1) / 2;
        T r2 = r0[r1];
        Intrinsics.checkNotNull(r2);
        T r3 = r0[r4];
        Intrinsics.checkNotNull(r3);
        if (((Comparable) r2).compareTo(r3) <= 0) goto L6;
        swap(r4, r1);
        r4 = r1;
        goto L2
    L6:
        return;
    }

    private final void siftDownFrom(int r6) {
    L2:
        int r0 = (r6 * 2) + 1;
        if (r0 >= getSize()) goto L4;
        T[] r1 = this.a;
        Intrinsics.checkNotNull(r1);
        int r2 = r0 + 1;
        if (r2 >= getSize()) goto L10;
        T r3 = r1[r2];
        Intrinsics.checkNotNull(r3);
        T r4 = r1[r0];
        Intrinsics.checkNotNull(r4);
        if (((Comparable) r3).compareTo(r4) >= 0) goto L10;
        r0 = r2;
    L10:
        T r5 = r1[r6];
        Intrinsics.checkNotNull(r5);
        T r7 = r1[r0];
        Intrinsics.checkNotNull(r7);
        if (((Comparable) r5).compareTo(r7) <= 0) goto L12;
        swap(r6, r0);
        r6 = r0;
        goto L2
    L12:
        return;
    }

    private final T[] realloc() {
        T[] r0 = this.a;
        if (r0 != null) goto L6;
        T[] r1 = (T[]) new ThreadSafeHeapNode[4];
        this.a = r1;
        return r1;
    L6:
        if (getSize() < r0.length) goto L10;
        Object[] r2 = Arrays.copyOf(r0, getSize() * 2);
        Intrinsics.checkNotNullExpressionValue(r2, "copyOf(this, newSize)");
        T[] r3 = (T[]) ((ThreadSafeHeapNode[]) r2);
        this.a = r3;
        return r3;
    L10:
        return r0;
    }

    private final void swap(int r3, int r4) {
        T[] r2 = this.a;
        Intrinsics.checkNotNull(r2);
        T r0 = r2[r4];
        Intrinsics.checkNotNull(r0);
        T r1 = r2[r3];
        Intrinsics.checkNotNull(r1);
        r2[r3] = r0;
        r2[r4] = r1;
        r0.setIndex(r3);
        r1.setIndex(r4);
    }

    public final void clear() {
        monitor-enter(this);
        T[] r0 = this.a;     // Catch: Throwable -> L9
        if (r0 == null) goto L6;
        ArraysKt.fill$default(r0, null, 0, 0, 6, null);     // Catch: Throwable -> L9
    L6:
        _size$FU.set(this, 0);     // Catch: Throwable -> L9
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final T find(Function1<? super T, Boolean> r5) {
        monitor-enter(this);
        int r0 = getSize();     // Catch: Throwable -> L15
        int r1 = 0;
    L4:
        T r2 = null;
        if (r1 >= r0) goto L13;
        T[] r3 = this.a;     // Catch: Throwable -> L15
        if (r3 == null) goto L9;
        r2 = (Object) r3[r1];
    L9:
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L15
        if (r5.invoke(r2).booleanValue() == true) goto L13;
        r1 = r1 + 1;
    L13:
        monitor-exit(this);
        return r2;
    L15:
        th = move-exception;
        throw th;
    }

    public final T peek() {
        monitor-enter(this);
        T r0 = (T) firstImpl();
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final T removeFirstOrNull() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (getSize() <= 0) goto L7;
        T r0 = (T) removeAtImpl(0);
    L8:
        monitor-exit(this);
        return r0;
    L7:
        r0 = null;
        goto L8
    }

    public final T removeFirstIf(Function1<? super T, Boolean> r4) {
        monitor-enter(this);
        ThreadSafeHeapNode r1 = firstImpl();     // Catch: Throwable -> L18
        T r2 = null;
        if (r1 != null) goto L12;
        InlineMarker.finallyStart(2);
        monitor-exit(this);
        InlineMarker.finallyEnd(2);
        return null;
    L12:
        if (r4.invoke(r1).booleanValue() == false) goto L14;
        r2 = (T) removeAtImpl(0);
    L14:
        InlineMarker.finallyStart(1);
        monitor-exit(this);
        InlineMarker.finallyEnd(1);
        return r2;
    L18:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public final void addLast(T r1) {
        monitor-enter(this);
        addImpl(r1);     // Catch: Throwable -> L6
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean addLastIf(T r3, Function1<? super T, Boolean> r4) {
        monitor-enter(this);
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    L5:
        if (r4.invoke(firstImpl()).booleanValue() == false) goto L8;
        addImpl(r3);     // Catch: Throwable -> L13
        boolean r5 = true;
    L9:
        InlineMarker.finallyStart(1);
        monitor-exit(this);
        InlineMarker.finallyEnd(1);
        return r5;
    L8:
        r5 = false;
        goto L9
    }

    public final boolean remove(T r4) {
        monitor-enter(this);
        boolean r1 = false;
        if (r4.getHeap() == null) goto L16;
        int r5 = r4.getIndex();     // Catch: Throwable -> L18
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L14;
        if (r5 < 0) goto L10;
        r1 = true;
    L10:
        if (r1 == true) goto L14;
        throw new AssertionError();     // Catch: Throwable -> L18
    L14:
        removeAtImpl(r5);     // Catch: Throwable -> L18
        r1 = true;
    L16:
        monitor-exit(this);
        return r1;
    L18:
        th = move-exception;
        throw th;
    }
}
