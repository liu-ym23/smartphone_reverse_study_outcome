package com.google.common.cache;

import com.bytedance.apm.constant.TraceStatsConsts;
import java.security.AccessController;
import java.util.Random;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class Striped64 extends Number {
    static final int NCPU = 0;
    private static final Unsafe UNSAFE = null;
    private static final long baseOffset = 0;
    private static final long busyOffset = 0;
    static final Random rng = null;
    static final ThreadLocal<int[]> threadHashCode = null;
    volatile transient long base;
    volatile transient int busy;

    @CheckForNull
    volatile transient Cell[] cells;

    static final class Cell {
        private static final Unsafe UNSAFE = null;
        private static final long valueOffset = 0;
        volatile long p0;
        volatile long p1;
        volatile long p2;
        volatile long p3;
        volatile long p4;
        volatile long p5;
        volatile long p6;
        volatile long q0;
        volatile long q1;
        volatile long q2;
        volatile long q3;
        volatile long q4;
        volatile long q5;
        volatile long q6;
        volatile long value;

        Cell(long r1) {
            this.value = r1;
        }

        final boolean cas(long r9, long r11) {
            return UNSAFE.compareAndSwapLong(this, valueOffset, r9, r11);
        }

        static {
            Unsafe r0 = Striped64.access$000();     // Catch: Exception -> L4
            UNSAFE = r0;     // Catch: Exception -> L4
            valueOffset = r0.objectFieldOffset(Cell.class.getDeclaredField("value"));     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            throw new Error(e);
        }
    }

    abstract long fn(long r1, long r3);

    static /* synthetic */ Unsafe access$000() {
        return getUnsafe();
    }

    static {
        threadHashCode = new ThreadLocal();
        rng = new Random();
        NCPU = Runtime.getRuntime().availableProcessors();
        Unsafe r0 = getUnsafe();     // Catch: Exception -> L5
        UNSAFE = r0;     // Catch: Exception -> L5
        baseOffset = r0.objectFieldOffset(Striped64.class.getDeclaredField(TraceStatsConsts.STATS_BASE_MODULE));     // Catch: Exception -> L5
        busyOffset = r0.objectFieldOffset(Striped64.class.getDeclaredField("busy"));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new Error(e);
    }

    Striped64() {
    }

    final boolean casBase(long r9, long r11) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, r9, r11);
    }

    final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    final void retryUpdate(long r17, @CheckForNull int[] r19, boolean r20) {
        if (r19 != null) goto L8;
        int[] r6 = new int[1];
        threadHashCode.set(r6);
        int r5 = rng.nextInt();
        if (r5 != 0) goto L7;
        r5 = 1;
    L7:
        r6[0] = r5;
    L9:
        boolean r8 = false;
        int r7 = r5;
        boolean r9 = r20;
    L10:
        Cell[] r10 = this.cells;
        if (r10 == null) goto L66;
        int r11 = r10.length;
        if (r11 <= 0) goto L66;
        Cell r12 = r10[(r11 - 1) & r7];
        if (r12 == null) goto L17;
        if (r9 == false) goto L39;
        long r13 = r12.value;
        if (r12.cas(r13, fn(r13, r17)) == true) goto L119;
        if (r11 >= NCPU) goto L37;
        if (this.cells != r10) goto L37;
        if (r8 == false) goto L49;
        if (this.busy != 0) goto L64;
        if (casBusy() == false) goto L64;
        if (this.cells != r10) goto L60;
        Cell[] r14 = new Cell[r11 << 1];     // Catch: Throwable -> L61
        int r15 = 0;
    L57:
        if (r15 >= r11) goto L59;
        r14[r15] = r10[r15];     // Catch: Throwable -> L61
        r15 = r15 + 1;     // Catch: Throwable -> L61
        goto L57
    L59:
        this.cells = r14;     // Catch: Throwable -> L61
    L60:
        this.busy = 0;
        r8 = false;
    L61:
        th = move-exception;
        this.busy = 0;
        throw th;
    L64:
        int r16 = r7 ^ (r7 << 13);
        int r18 = r16 ^ (r16 >>> 17);
        r7 = r18 ^ (r18 << 5);
        r6[0] = r7;
        goto L10
    L49:
        r8 = true;
    L37:
        r8 = false;
        goto L64
    L119:
        return;
    L39:
        r9 = true;
        goto L64
    L17:
        if (this.busy != 0) goto L37;
        Cell r21 = new Cell(r17);
        if (this.busy != 0) goto L37;
        if (casBusy() == false) goto L37;
        Cell[] r110 = this.cells;     // Catch: Throwable -> L34
        if (r110 == null) goto L30;
        int r111 = r110.length;     // Catch: Throwable -> L34
        if (r111 <= 0) goto L30;
        int r112 = (r111 - 1) & r7;     // Catch: Throwable -> L34
        if (r110[r112] != null) goto L30;
        r110[r112] = r21;     // Catch: Throwable -> L34
        boolean r22 = true;
    L31:
        this.busy = 0;
        if (r22 == false) goto L10;
        return;
    L30:
        r22 = false;
    L34:
        th = move-exception;
        this.busy = 0;
        throw th;
    L66:
        if (this.busy != 0) goto L82;
        if (this.cells != r10) goto L82;
        if (casBusy() == false) goto L82;
    L79:
        th = move-exception;
        this.busy = 0;
        throw th;
    L72:
        if (this.cells != r10) goto L75;
        Cell[] r23 = new Cell[2];     // Catch: Throwable -> L79
        r23[r7 & 1] = new Cell(r17);     // Catch: Throwable -> L79
        this.cells = r23;     // Catch: Throwable -> L79
        boolean r24 = true;
    L76:
        this.busy = 0;
        if (r24 == false) goto L10;
        return;
    L75:
        r24 = false;
    L82:
        long r25 = this.base;
        if (casBase(r25, fn(r25, r17)) == false) goto L10;
        return;
    L8:
        r5 = r19[0];
        r6 = r19;
        goto L9
    }

    final void internalReset(long r4) {
        Cell[] r0 = this.cells;
        this.base = r4;
        if (r0 == null) goto L10;
        int r3 = r0.length;
        int r1 = 0;
    L5:
        if (r1 >= r3) goto L14;
        Cell r2 = r0[r1];
        if (r2 == null) goto L9;
        r2.value = r4;
    L9:
        r1 = r1 + 1;
        goto L5
    L14:
        return;
    }

    private static Unsafe getUnsafe() {
        return Unsafe.getUnsafe();
    L4:
        return (Unsafe) AccessController.doPrivileged(new AnonymousClass1());
    L6:
        e = move-exception;
        throw new RuntimeException("Could not initialize intrinsics", e.getCause());
    }
}
