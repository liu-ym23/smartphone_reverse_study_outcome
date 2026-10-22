package kotlinx.coroutines.internal;

import adcpeJava.adcpe.Ciphertext;
import android.icu.text.PluralRules;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 ,*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002,-B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001c\u001a\u00020\u0006J1\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0006J&\u0010!\u001a\b\u0012\u0004\u0012\u0002H#0\"\"\u0004\b\u0001\u0010#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H#0%J\b\u0010&\u001a\u00020\u001aH\u0002J\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\b\u0010(\u001a\u0004\u0018\u00010\u0002J,\u0010)\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0002R#\u0010\b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n0\tX\u0082\u0004R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\u0011\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000eX\u0082\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006."}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "E", "", PerfConsts.KEY_CURRENT_CAPACITY, "", "singleConsumer", "", "(IZ)V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/Core;", "_state", "Lkotlinx/atomicfu/AtomicLong;", "array", "Lkotlinx/atomicfu/AtomicArray;", "isEmpty", "()Z", "mask", PerfConsts.PERF_DISK_FILE_SIZE, "getSize", "()I", "addLast", "element", "(Ljava/lang/Object;)I", "allocateNextCopy", "state", "", "allocateOrGetNextCopy", "close", "fillPlaceholder", "index", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "map", "", "R", "transform", "Lkotlin/Function1;", "markFrozen", "next", "removeFirstOrNull", "removeSlowPath", "oldHead", "newHead", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LockFreeTaskQueueCore<E> {
    public static final int ADD_CLOSED = 2;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_SUCCESS = 0;
    public static final int CAPACITY_BITS = 30;
    public static final long CLOSED_MASK = 2305843009213693952L;
    public static final int CLOSED_SHIFT = 61;
    public static final Companion Companion = null;
    public static final long FROZEN_MASK = 1152921504606846976L;
    public static final int FROZEN_SHIFT = 60;
    public static final long HEAD_MASK = 1073741823;
    public static final int HEAD_SHIFT = 0;
    public static final int INITIAL_CAPACITY = 8;
    public static final int MAX_CAPACITY_MASK = 1073741823;
    public static final int MIN_ADD_SPIN_CAPACITY = 1024;
    public static final Symbol REMOVE_FROZEN = null;
    public static final long TAIL_MASK = 1152921503533105152L;
    public static final int TAIL_SHIFT = 30;
    private static final AtomicReferenceFieldUpdater _next$FU = null;
    private static final AtomicLongFieldUpdater _state$FU = null;

    @Volatile
    private volatile Object _next;

    @Volatile
    private volatile long _state;
    private final AtomicReferenceArray array;
    private final int capacity;
    private final int mask;
    private final boolean singleConsumer;

    /* JADX INFO: compiled from: LockFreeTaskQueue.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0016\u001a\u00020\u0004*\u00020\tJ\u0012\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004JP\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0001\u0010\u001c*\u00020\t26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0086\b¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0086\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", PluralRules.KEYWORD_OTHER, "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final int addFailReason(long r3) {
            if ((r3 & LockFreeTaskQueueCore.CLOSED_MASK) == 0) goto L5;
            return 2;
        L5:
            return 1;
        }

        public final long wo(long r1, long r3) {
            return r1 & (~r3);
        }

        private Companion() {
        }

        public final long updateHead(long r3, int r5) {
            return wo(r3, LockFreeTaskQueueCore.HEAD_MASK) | (((long) r5) << 0);
        }

        public final long updateTail(long r3, int r5) {
            return wo(r3, LockFreeTaskQueueCore.TAIL_MASK) | (((long) r5) << 30);
        }

        public final <T> T withState(long r3, Function2<? super Integer, ? super Integer, ? extends T> r5) {
            int r2 = (int) ((LockFreeTaskQueueCore.HEAD_MASK & r3) >> 0);
            int r4 = (int) ((r3 & LockFreeTaskQueueCore.TAIL_MASK) >> 30);
            return r5.invoke(Integer.valueOf(r2), Integer.valueOf(r4));
        }
    }

    /* JADX INFO: compiled from: LockFreeTaskQueue.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Placeholder {
        public final int index;

        public Placeholder(int r1) {
            this.index = r1;
        }
    }

    private final void loop$atomicfu(AtomicLongFieldUpdater r3, Function1<? super Long, Unit> r4, Object r5) {
    L2:
        r4.invoke(Long.valueOf(r3.get(r5)));
        goto L2
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater r1, Function1<Object, Unit> r2, Object r3) {
    L2:
        r2.invoke(r1.get(r3));
        goto L2
    }

    private final void update$atomicfu(AtomicLongFieldUpdater r7, Function1<? super Long, Long> r8, Object r9) {
    L2:
        long r2 = r7.get(r9);
        if (r7.compareAndSet(r9, r2, r8.invoke(Long.valueOf(r2)).longValue()) == false) goto L2;
    }

    private final long updateAndGet$atomicfu(AtomicLongFieldUpdater r7, Function1<? super Long, Long> r8, Object r9) {
    L2:
        long r2 = r7.get(r9);
        Long r6 = r8.invoke(Long.valueOf(r2));
        if (r7.compareAndSet(r9, r2, r6.longValue()) == false) goto L2;
        return r6.longValue();
    }

    public LockFreeTaskQueueCore(int r4, boolean r5) {
        this.capacity = r4;
        this.singleConsumer = r5;
        int r6 = r4 - 1;
        this.mask = r6;
        this.array = new AtomicReferenceArray(r4);
        boolean r0 = false;
        if (r6 > 1073741823) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L16;
        if ((r4 & r6) != 0) goto L11;
        r0 = true;
    L11:
        if (r0 == false) goto L14;
        return;
    L14:
        throw new IllegalStateException("Check failed.".toString());
    L16:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r3 = false;
        goto L7
    }

    public final boolean isEmpty() {
        long r0 = _state$FU.get(this);
        if (((int) ((HEAD_MASK & r0) >> 0)) != ((int) ((r0 & TAIL_MASK) >> 30))) goto L6;
        return true;
    L6:
        return false;
    }

    public final int getSize() {
        long r0 = _state$FU.get(this);
        int r4 = (int) ((HEAD_MASK & r0) >> 0);
        return 1073741823 & (((int) ((r0 & TAIL_MASK) >> 30)) - r4);
    }

    public final boolean close() {
        AtomicLongFieldUpdater r6 = _state$FU;
    L3:
        long r2 = r6.get(this);
        if ((r2 & CLOSED_MASK) != 0) goto L5;
        if ((FROZEN_MASK & r2) != 0) goto L8;
        if (r6.compareAndSet(this, r2, r2 | CLOSED_MASK) == false) goto L3;
        return true;
    L8:
        return false;
    L5:
        return true;
    }

    public final int addLast(E r15) {
        AtomicLongFieldUpdater r0 = _state$FU;
    L3:
        long r3 = r0.get(this);
        if ((3458764513820540928L & r3) != 0) goto L6;
        Companion r1 = Companion;
        int r2 = (int) ((HEAD_MASK & r3) >> 0);
        int r10 = (int) ((TAIL_MASK & r3) >> 30);
        int r11 = this.mask;
        if (((r10 + 2) & r11) == (r2 & r11)) goto L9;
        if (this.singleConsumer == true) goto L19;
        if (this.array.get(r10 & r11) == null) goto L19;
        int r4 = this.capacity;
        if (r4 < 1024) goto L18;
        if (((r10 - r2) & MAX_CAPACITY_MASK) <= (r4 >> 1)) goto L3;
    L18:
        return 1;
    L19:
        int r5 = (r10 + 1) & MAX_CAPACITY_MASK;
        if (_state$FU.compareAndSet(this, r3, r1.updateTail(r3, r5)) == false) goto L3;
        this.array.set(r10 & r11, r15);
    L23:
        if ((_state$FU.get(this) & FROZEN_MASK) == 0) goto L26;
        LockFreeTaskQueueCore<E> this = this.next().fillPlaceholder(r10, r15);
        if (this != null) goto L23;
    L26:
        return 0;
    L9:
        return 1;
    L6:
        return Companion.addFailReason(r3);
    }

    private final LockFreeTaskQueueCore<E> fillPlaceholder(int r3, E r4) {
        Object r0 = this.array.get(this.mask & r3);
        if ((r0 instanceof Placeholder) == true) goto L5;
        return null;
    L5:
        if (((Placeholder) r0).index != r3) goto L10;
        this.array.set(r3 & this.mask, r4);
        return this;
    L10:
        return null;
    }

    public final Object removeFirstOrNull() {
        AtomicLongFieldUpdater r0 = _state$FU;
    L3:
        long r3 = r0.get(this);
        if ((FROZEN_MASK & r3) != 0) goto L6;
        Companion r1 = Companion;
        int r7 = (int) ((HEAD_MASK & r3) >> 0);
        int r2 = (int) ((TAIL_MASK & r3) >> 30);
        int r5 = this.mask;
        if ((r2 & r5) == (r7 & r5)) goto L9;
        Object r9 = this.array.get(r5 & r7);
        if (r9 == null) goto L13;
        if ((r9 instanceof Placeholder) == true) goto L17;
        int r10 = (r7 + 1) & MAX_CAPACITY_MASK;
        if (_state$FU.compareAndSet(this, r3, r1.updateHead(r3, r10)) == true) goto L20;
        if (this.singleConsumer == false) goto L3;
    L24:
        LockFreeTaskQueueCore<E> this = this.removeSlowPath(r7, r10);
        if (this != null) goto L24;
        return r9;
    L20:
        this.array.set(this.mask & r7, null);
        return r9;
    L17:
        return null;
    L13:
        if (this.singleConsumer == false) goto L3;
        return null;
    L9:
        return null;
    L6:
        return REMOVE_FROZEN;
    }

    private final LockFreeTaskQueueCore<E> removeSlowPath(int r11, int r12) {
        AtomicLongFieldUpdater r0 = _state$FU;
    L3:
        long r3 = r0.get(this);
        Companion r1 = Companion;
        boolean r2 = false;
        int r7 = (int) ((HEAD_MASK & r3) >> 0);
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L12;
        if (r7 != r11) goto L7;
        r2 = true;
    L7:
        if (r2 == true) goto L12;
        throw new AssertionError();
    L12:
        if ((FROZEN_MASK & r3) != 0) goto L14;
        if (_state$FU.compareAndSet(this, r3, r1.updateHead(r3, r12)) == false) goto L3;
        this.array.set(this.mask & r7, null);
        return null;
    L14:
        return next();
    }

    public final LockFreeTaskQueueCore<E> next() {
        return allocateOrGetNextCopy(markFrozen());
    }

    private final long markFrozen() {
        AtomicLongFieldUpdater r6 = _state$FU;
    L3:
        long r2 = r6.get(this);
        if ((r2 & FROZEN_MASK) != 0) goto L5;
        long r7 = r2 | FROZEN_MASK;
        if (r6.compareAndSet(this, r2, r7) == false) goto L3;
        return r7;
    L5:
        return r2;
    }

    private final LockFreeTaskQueueCore<E> allocateOrGetNextCopy(long r5) {
        AtomicReferenceFieldUpdater r0 = _next$FU;
    L3:
        LockFreeTaskQueueCore<E> r1 = (LockFreeTaskQueueCore) r0.get(this);
        if (r1 != null) goto L5;
        _next$FU.compareAndSet(this, null, allocateNextCopy(r5));
        goto L3
    L5:
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LockFreeTaskQueueCore<E> allocateNextCopy(long r7) {
        LockFreeTaskQueueCore<E> r0 = new LockFreeTaskQueueCore(this.capacity * 2, this.singleConsumer);
        int r1 = (int) ((HEAD_MASK & r7) >> 0);
        int r2 = (int) ((TAIL_MASK & r7) >> 30);
    L3:
        int r3 = this.mask;
        if ((r1 & r3) == (r2 & r3)) goto L9;
        Object r4 = this.array.get(r3 & r1);
        if (r4 != null) goto L8;
        r4 = new Placeholder(r1);
    L8:
        r0.array.set(r0.mask & r1, r4);
        r1 = r1 + 1;
        goto L3
    L9:
        _state$FU.set(r0, Companion.wo(r7, FROZEN_MASK));
        return r0;
    }

    public final <R> List<R> map(Function1<? super E, ? extends R> r7) {
        ArrayList r0 = new ArrayList(this.capacity);
        long r1 = _state$FU.get(this);
        int r3 = (int) ((HEAD_MASK & r1) >> 0);
        int r2 = (int) ((r1 & TAIL_MASK) >> 30);
    L3:
        int r4 = this.mask;
        if ((r3 & r4) == (r2 & r4)) goto L12;
        Ciphertext r5 = (Object) this.array.get(r4 & r3);
        if (r5 == null) goto L10;
        if ((r5 instanceof Placeholder) == true) goto L10;
        r0.add(r7.invoke(r5));
    L10:
        r3 = r3 + 1;
        goto L3
    L12:
        return r0;
    }

    public final boolean isClosed() {
        if ((_state$FU.get(this) & CLOSED_MASK) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        Companion = new Companion(null);
        _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");
        _state$FU = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");
        REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");
    }
}
