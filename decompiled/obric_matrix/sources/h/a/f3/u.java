package h.a.f3;

import com.bytedance.common.wschannel.WsConstants;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0016\b\u0000\u0018\u0000 /*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002/0B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0013J-\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b\"\u0004\b\u0001\u0010\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\"\u0010#J3\u0010&\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010(R\u0011\u0010)\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b)\u0010\u0013R\u0014\u0010*\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010(R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010+R\u0011\u0010.\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "E", "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", "element", "addLast", "(Ljava/lang/Object;)I", "", WsConstants.KEY_CONNECTION_STATE, "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "close", "()Z", "index", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "isEmpty", "mask", "Z", "getSize", "()I", "size", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class u<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f17418e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f17419f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f17420g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f0 f17421h = null;
    private volatile /* synthetic */ Object _next;
    private volatile /* synthetic */ long _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f17422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f17423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f17424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private /* synthetic */ AtomicReferenceArray f17425d;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0016\u001a\u00020\u0004*\u00020\tJ\u0012\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004JP\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0001\u0010\u001c*\u00020\t26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0086\b¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0086\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final int a(long r3) {
            if ((r3 & 2305843009213693952L) == 0) goto L5;
            return 2;
        L5:
            return 1;
        }

        public final long b(long r3, int r5) {
            return d(r3, 1073741823) | (((long) r5) << 0);
        }

        public final long c(long r3, int r5) {
            return d(r3, 1152921503533105152L) | (((long) r5) << 30);
        }

        public final long d(long r1, long r3) {
            return r1 & (~r3);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17426a;

        public b(int r1) {
            this.f17426a = r1;
        }
    }

    static {
        f17418e = new a(null);
        f17421h = new f0("REMOVE_FROZEN");
        f17419f = AtomicReferenceFieldUpdater.newUpdater(u.class, Object.class, "_next");
        f17420g = AtomicLongFieldUpdater.newUpdater(u.class, "_state");
    }

    public u(int r4, boolean r5) {
        this.f17422a = r4;
        this.f17423b = r5;
        int r6 = r4 - 1;
        this.f17424c = r6;
        this._next = null;
        this._state = 0;
        this.f17425d = new AtomicReferenceArray(r4);
        boolean r3 = false;
        if (r6 > 1073741823) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L16;
        if ((r4 & r6) != 0) goto L11;
        r3 = true;
    L11:
        if (r3 == false) goto L14;
        return;
    L14:
        throw new IllegalStateException("Check failed.".toString());
    L16:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r1 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final u<E> b(long r7) {
        u<E> r0 = new u(this.f17422a * 2, this.f17423b);
        int r1 = (int) ((1073741823 & r7) >> 0);
        int r2 = (int) ((1152921503533105152L & r7) >> 30);
    L3:
        int r3 = this.f17424c;
        if ((r1 & r3) == (r2 & r3)) goto L9;
        Object r4 = this.f17425d.get(r3 & r1);
        if (r4 != null) goto L8;
        r4 = new b(r1);
    L8:
        r0.f17425d.set(r0.f17424c & r1, r4);
        r1 = r1 + 1;
        goto L3
    L9:
        r0._state = f17418e.d(r7, 1152921504606846976L);
        return r0;
    }

    private final u<E> c(long r4) {
    L2:
        u<E> r0 = (u) this._next;
        if (r0 != null) goto L4;
        f17419f.compareAndSet(this, null, b(r4));
        goto L2
    L4:
        return r0;
    }

    private final u<E> e(int r3, E r4) {
        Object r0 = this.f17425d.get(this.f17424c & r3);
        if ((r0 instanceof b) == true) goto L5;
        return null;
    L5:
        if (((b) r0).f17426a != r3) goto L10;
        this.f17425d.set(r3 & this.f17424c, r4);
        return this;
    L10:
        return null;
    }

    private final long h() {
    L2:
        long r2 = this._state;
        if ((r2 & 1152921504606846976L) != 0) goto L4;
        long r6 = r2 | 1152921504606846976L;
        if (f17420g.compareAndSet(this, r2, r6) == false) goto L2;
        return r6;
    L4:
        return r2;
    }

    private final u<E> k(int r10, int r11) {
    L2:
        long r2 = this._state;
        a r0 = f17418e;
        boolean r1 = false;
        int r6 = (int) ((1073741823 & r2) >> 0);
        if (h.a.q0.a() == false) goto L11;
        if (r6 != r10) goto L6;
        r1 = true;
    L6:
        if (r1 == true) goto L11;
        throw new AssertionError();
    L11:
        if ((1152921504606846976L & r2) != 0) goto L13;
        if (f17420g.compareAndSet(this, r2, r0.b(r2, r11)) == false) goto L2;
        this.f17425d.set(this.f17424c & r6, null);
        return null;
    L13:
        return i();
    }

    public final int a(E r14) {
    L2:
        long r2 = this._state;
        if ((3458764513820540928L & r2) != 0) goto L5;
        a r0 = f17418e;
        int r1 = (int) ((1073741823 & r2) >> 0);
        int r9 = (int) ((1152921503533105152L & r2) >> 30);
        int r10 = this.f17424c;
        if (((r9 + 2) & r10) == (r1 & r10)) goto L8;
        if (this.f17423b == true) goto L19;
        if (this.f17425d.get(r9 & r10) == null) goto L19;
        int r3 = this.f17422a;
        if (r3 < 1024) goto L17;
        if (((r9 - r1) & 1073741823) <= (r3 >> 1)) goto L2;
    L17:
        return 1;
    L19:
        if (f17420g.compareAndSet(this, r2, r0.c(r2, (r9 + 1) & 1073741823)) == false) goto L2;
        this.f17425d.set(r9 & r10, r14);
    L22:
        if ((this._state & 1152921504606846976L) == 0) goto L26;
        u<E> this = this.i().e(r9, r14);
        if (this != null) goto L22;
    L26:
        return 0;
    L8:
        return 1;
    L5:
        return f17418e.a(r2);
    }

    public final boolean d() {
    L2:
        long r2 = this._state;
        if ((r2 & 2305843009213693952L) != 0) goto L4;
        if ((1152921504606846976L & r2) != 0) goto L7;
        AtomicLongFieldUpdater r0 = f17420g;
        if (r0.compareAndSet(this, r2, r2 | 2305843009213693952L) == false) goto L2;
        return true;
    L7:
        return false;
    L4:
        return true;
    }

    public final int f() {
        long r0 = this._state;
        int r4 = (int) ((1073741823 & r0) >> 0);
        return 1073741823 & (((int) ((r0 & 1152921503533105152L) >> 30)) - r4);
    }

    public final boolean g() {
        long r0 = this._state;
        if (((int) ((1073741823 & r0) >> 0)) != ((int) ((r0 & 1152921503533105152L) >> 30))) goto L6;
        return true;
    L6:
        return false;
    }

    public final u<E> i() {
        return c(h());
    }

    public final Object j() {
    L2:
        long r2 = this._state;
        if ((1152921504606846976L & r2) != 0) goto L5;
        a r0 = f17418e;
        int r6 = (int) ((1073741823 & r2) >> 0);
        int r1 = (int) ((1152921503533105152L & r2) >> 30);
        int r4 = this.f17424c;
        if ((r1 & r4) == (r6 & r4)) goto L8;
        Object r8 = this.f17425d.get(r4 & r6);
        if (r8 == null) goto L12;
        if ((r8 instanceof b) == true) goto L16;
        int r9 = (r6 + 1) & 1073741823;
        if (f17420g.compareAndSet(this, r2, r0.b(r2, r9)) == true) goto L19;
        if (this.f17423b == false) goto L2;
    L24:
        u<E> this = this.k(r6, r9);
        if (this != null) goto L24;
        return r8;
    L19:
        this.f17425d.set(this.f17424c & r6, null);
        return r8;
    L16:
        return null;
    L12:
        if (this.f17423b == false) goto L2;
        return null;
    L8:
        return null;
    L5:
        return f17421h;
    }
}
