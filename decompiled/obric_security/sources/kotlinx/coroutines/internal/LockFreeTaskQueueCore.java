package kotlinx.coroutines.internal;

import a.a.a.a.a.b.b;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.security.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\b\u0000\u0018\u0000 /*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002/0B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0013J-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\"\u0010#J3\u0010&\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010(R\u0011\u0010)\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b)\u0010\u0013R\u0014\u0010*\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010+R\u0011\u0010.\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", ExifInterface.LONGITUDE_EAST, "", PerfConsts.KEY_CURRENT_CAPACITY, "", "singleConsumer", "<init>", "(IZ)V", "element", "addLast", "(Ljava/lang/Object;)I", "", "state", "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "close", "()Z", Utils.INTENT_KEY_INDEX, "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "isEmpty", "mask", "Z", "getSize", "()I", PerfConsts.PERF_DISK_FILE_SIZE, "Companion", "Placeholder", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    private static final /* synthetic */ AtomicReferenceFieldUpdater _next$FU = null;
    private static final /* synthetic */ AtomicLongFieldUpdater _state$FU = null;
    private volatile /* synthetic */ Object _next;
    private volatile /* synthetic */ long _state;
    private /* synthetic */ AtomicReferenceArray array;
    private final int capacity;
    private final int mask;
    private final boolean singleConsumer;

    /* JADX INFO: compiled from: LockFreeTaskQueue.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0016\u001a\u00020\u0004*\u00020\tJ\u0012\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004JP\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0001\u0010\u001c*\u00020\t26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0086\b¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0086\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final int addFailReason(long r3) {
            if ((r3 & 2305843009213693952L) == 0) goto L5;
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
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", Utils.INTENT_KEY_INDEX, "", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Placeholder {
        public final int index;

        public Placeholder(int r1) {
            this.index = r1;
        }
    }

    public LockFreeTaskQueueCore(int r4, boolean r5) {
        this.capacity = r4;
        this.singleConsumer = r5;
        int r6 = r4 - 1;
        this.mask = r6;
        this._next = null;
        this._state = 0;
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
        long r0 = this._state;
        if (((int) ((HEAD_MASK & r0) >> 0)) != ((int) ((r0 & TAIL_MASK) >> 30))) goto L6;
        return true;
    L6:
        return false;
    }

    public final int getSize() {
        long r0 = this._state;
        int r4 = (int) ((HEAD_MASK & r0) >> 0);
        return 1073741823 & (((int) ((r0 & TAIL_MASK) >> 30)) - r4);
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

    public final LockFreeTaskQueueCore<E> next() {
        return allocateOrGetNextCopy(markFrozen());
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
        r0._state = Companion.wo(r7, 1152921504606846976L);
        return r0;
    }

    public final <R> List<R> map(Function1<? super E, ? extends R> r7) {
        ArrayList r0 = new ArrayList(this.capacity);
        long r1 = this._state;
        int r3 = (int) ((HEAD_MASK & r1) >> 0);
        int r2 = (int) ((r1 & TAIL_MASK) >> 30);
    L3:
        int r4 = this.mask;
        if ((r3 & r4) == (r2 & r4)) goto L12;
        b.a r5 = (Object) this.array.get(r4 & r3);
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
        if ((this._state & 2305843009213693952L) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        Companion = new Companion(null);
        REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");
        _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");
        _state$FU = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");
    }

    public final boolean close() {
    L2:
        long r2 = this._state;
        if ((r2 & 2305843009213693952L) != 0) goto L4;
        if ((1152921504606846976L & r2) != 0) goto L7;
        AtomicLongFieldUpdater r0 = _state$FU;
        if (r0.compareAndSet(this, r2, r2 | 2305843009213693952L) == false) goto L2;
        return true;
    L7:
        return false;
    L4:
        return true;
    }

    public final int addLast(E r14) {
    L2:
        long r2 = this._state;
        if ((3458764513820540928L & r2) != 0) goto L5;
        Companion r0 = Companion;
        int r1 = (int) ((HEAD_MASK & r2) >> 0);
        int r9 = (int) ((TAIL_MASK & r2) >> 30);
        int r10 = this.mask;
        if (((r9 + 2) & r10) == (r1 & r10)) goto L8;
        if (this.singleConsumer == true) goto L18;
        if (this.array.get(r9 & r10) == null) goto L18;
        int r3 = this.capacity;
        if (r3 < 1024) goto L17;
        if (((r9 - r1) & MAX_CAPACITY_MASK) <= (r3 >> 1)) goto L2;
    L17:
        return 1;
    L18:
        int r4 = (r9 + 1) & MAX_CAPACITY_MASK;
        if (_state$FU.compareAndSet(this, r2, r0.updateTail(r2, r4)) == false) goto L2;
        this.array.set(r9 & r10, r14);
    L22:
        if ((this._state & 1152921504606846976L) == 0) goto L25;
        LockFreeTaskQueueCore<E> this = this.next().fillPlaceholder(r9, r14);
        if (this != null) goto L22;
    L25:
        return 0;
    L8:
        return 1;
    L5:
        return Companion.addFailReason(r2);
    }

    public final Object removeFirstOrNull() {
    L2:
        long r2 = this._state;
        if ((1152921504606846976L & r2) != 0) goto L5;
        Companion r0 = Companion;
        int r6 = (int) ((HEAD_MASK & r2) >> 0);
        int r1 = (int) ((TAIL_MASK & r2) >> 30);
        int r4 = this.mask;
        if ((r1 & r4) == (r6 & r4)) goto L8;
        Object r8 = this.array.get(r4 & r6);
        if (r8 == null) goto L12;
        if ((r8 instanceof Placeholder) == true) goto L16;
        int r9 = (r6 + 1) & MAX_CAPACITY_MASK;
        if (_state$FU.compareAndSet(this, r2, r0.updateHead(r2, r9)) == true) goto L19;
        if (this.singleConsumer == false) goto L2;
    L23:
        LockFreeTaskQueueCore<E> this = this.removeSlowPath(r6, r9);
        if (this != null) goto L23;
        return r8;
    L19:
        this.array.set(this.mask & r6, null);
        return r8;
    L16:
        return null;
    L12:
        if (this.singleConsumer == false) goto L2;
        return null;
    L8:
        return null;
    L5:
        return REMOVE_FROZEN;
    }

    private final LockFreeTaskQueueCore<E> removeSlowPath(int r10, int r11) {
    L2:
        long r2 = this._state;
        Companion r0 = Companion;
        boolean r1 = false;
        int r6 = (int) ((HEAD_MASK & r2) >> 0);
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L11;
        if (r6 != r10) goto L6;
        r1 = true;
    L6:
        if (r1 == true) goto L11;
        throw new AssertionError();
    L11:
        if ((1152921504606846976L & r2) != 0) goto L13;
        if (_state$FU.compareAndSet(this, r2, r0.updateHead(r2, r11)) == false) goto L2;
        this.array.set(this.mask & r6, null);
        return null;
    L13:
        return next();
    }

    private final long markFrozen() {
    L2:
        long r2 = this._state;
        if ((r2 & 1152921504606846976L) != 0) goto L4;
        long r6 = r2 | 1152921504606846976L;
        if (_state$FU.compareAndSet(this, r2, r6) == false) goto L2;
        return r6;
    L4:
        return r2;
    }

    private final LockFreeTaskQueueCore<E> allocateOrGetNextCopy(long r4) {
    L2:
        LockFreeTaskQueueCore<E> r0 = (LockFreeTaskQueueCore) this._next;
        if (r0 != null) goto L4;
        b0$$ExternalSyntheticBackport0.m(_next$FU, this, null, allocateNextCopy(r4));
        goto L2
    L4:
        return r0;
    }
}
