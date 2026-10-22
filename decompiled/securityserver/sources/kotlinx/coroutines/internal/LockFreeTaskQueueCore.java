package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class LockFreeTaskQueueCore<E> {
    public static final AtomicReferenceFieldUpdater e = null;
    public static final AtomicLongFieldUpdater f = null;
    public static final Symbol g = null;
    private volatile Object _next;
    private volatile long _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f419a;
    public final AtomicReferenceArray b;
    public final int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f420d;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class Placeholder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f421a;

        public Placeholder(int r1) {
            this.f421a = r1;
        }
    }

    static {
        g = new Symbol("REMOVE_FROZEN");
        e = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");
        f = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");
    }

    public LockFreeTaskQueueCore(int r4, boolean r5) {
        this.c = r4;
        this.f420d = r5;
        int r6 = r4 - 1;
        this.f419a = r6;
        this._next = null;
        this._state = 0;
        this.b = new AtomicReferenceArray(r4);
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

    public final int a(Object r14) {
    L2:
        long r2 = this._state;
        if ((3458764513820540928L & r2) != 0) goto L5;
        int r0 = (int) (1073741823 & r2);
        int r9 = (int) ((1152921503533105152L & r2) >> 30);
        int r10 = this.f419a;
        if (((r9 + 2) & r10) == (r0 & r10)) goto L10;
        if (this.f420d == true) goto L21;
        if (this.b.get(r9 & r10) == null) goto L21;
        int r3 = this.c;
        if (r3 < 1024) goto L19;
        if (((r9 - r0) & 1073741823) <= (r3 >> 1)) goto L2;
    L19:
        return 1;
    L21:
        if (f.compareAndSet(this, r2, ((-1152921503533105153L) & r2) | (((long) ((r9 + 1) & 1073741823)) << 30)) == false) goto L2;
        this.b.set(r9 & r10, r14);
    L24:
        if ((this._state & 1152921504606846976L) == 0) goto L53;
        LockFreeTaskQueueCore<E> this = this.e();
        AtomicReferenceArray r1 = this.b;
        int r4 = this.f419a & r9;
        Object r5 = r1.get(r4);
        if ((r5 instanceof Placeholder) == true) goto L29;
    L31:
        this = null;
    L32:
        if (this != null) goto L24;
        return 0;
    L29:
        if (((Placeholder) r5).f421a != r9) goto L31;
        r1.set(r4, r14);
        goto L32
    L53:
        return 0;
    L10:
        return 1;
    L5:
        if ((2305843009213693952L & r2) == 0) goto L52;
        return 2;
    L52:
        return 1;
    }

    public final boolean b() {
    L2:
        long r2 = this._state;
        if ((r2 & 2305843009213693952L) != 0) goto L4;
        if ((1152921504606846976L & r2) != 0) goto L7;
        AtomicLongFieldUpdater r0 = f;
        if (r0.compareAndSet(this, r2, r2 | 2305843009213693952L) == false) goto L2;
        return true;
    L7:
        return false;
    L4:
        return true;
    }

    public final int c() {
        long r0 = this._state;
        int r4 = (int) (1073741823 & r0);
        return 1073741823 & (((int) ((r0 & 1152921503533105152L) >> 30)) - r4);
    }

    public final boolean d() {
        long r0 = this._state;
        if (((int) (1073741823 & r0)) != ((int) ((r0 & 1152921503533105152L) >> 30))) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LockFreeTaskQueueCore e() {
    L2:
        long r2 = this._state;
        if ((r2 & 1152921504606846976L) != 0) goto L8;
        long r6 = r2 | 1152921504606846976L;
        if (f.compareAndSet(this, r2, r6) == false) goto L2;
        r2 = r6;
    L8:
        LockFreeTaskQueueCore r0 = (LockFreeTaskQueueCore) this._next;
        if (r0 != null) goto L10;
        AtomicReferenceFieldUpdater r1 = e;
        LockFreeTaskQueueCore r3 = new LockFreeTaskQueueCore(this.c * 2, this.f420d);
        int r4 = (int) (1073741823 & r2);
        int r5 = (int) ((1152921503533105152L & r2) >> 30);
    L12:
        int r7 = this.f419a;
        int r8 = r4 & r7;
        if (r8 == (r7 & r5)) goto L19;
        Object r9 = this.b.get(r8);
        if (r9 != null) goto L18;
        r9 = new Placeholder(r4);
    L18:
        r3.b.set(r3.f419a & r4, r9);
        r4 = r4 + 1;
        goto L12
    L19:
        r3._state = (-1152921504606846977L) & r2;
        r1.compareAndSet(this, null, r3);
        goto L8
    L10:
        return r0;
    }

    public final Object f() {
    L3:
        long r2 = this._state;
        if ((r2 & 1152921504606846976L) != 0) goto L6;
        int r13 = (int) (r2 & 1073741823);
        int r1 = this.f419a;
        int r0 = ((int) ((1152921503533105152L & r2) >> 30)) & r1;
        int r3 = r1 & r13;
        if (r0 == r3) goto L9;
        Object r15 = this.b.get(r3);
        if (r15 == null) goto L13;
        if ((r15 instanceof Placeholder) == true) goto L17;
        long r9 = (r13 + 1) & 1073741823;
        if (f.compareAndSet(this, r2, (r2 & (-1073741824)) | r9) == true) goto L20;
        if (this.f420d == false) goto L3;
        LockFreeTaskQueueCore<E> r4 = this;
    L26:
        long r5 = r4._state;
        int r14 = (int) (r5 & 1073741823);
        boolean r6 = DebugKt.f370a;
        if ((r5 & 1152921504606846976L) != 0) goto L28;
        if (f.compareAndSet(r4, r5, (r5 & (-1073741824)) | r9) == false) goto L26;
        r4.b.set(r4.f419a & r14, null);
        r4 = null;
    L32:
        if (r4 != null) goto L26;
        return r15;
    L28:
        r4 = r4.e();
        goto L32
    L20:
        this.b.set(this.f419a & r13, null);
        return r15;
    L17:
        return null;
    L13:
        if (this.f420d == false) goto L3;
        return null;
    L9:
        return null;
    L6:
        return g;
    }
}
