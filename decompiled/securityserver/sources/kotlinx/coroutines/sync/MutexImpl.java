package kotlinx.coroutines.sync;

import d.b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.selects.SelectClause2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MutexImpl implements Mutex, SelectClause2<Object, Mutex> {
    public static final AtomicReferenceFieldUpdater b = null;
    volatile Object _state;

    @Metadata
    public final class LockCont extends LockWaiter {
        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public final Object K() {
            throw null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public final String toString() {
            throw null;
        }
    }

    @Metadata
    public final class LockSelect<R> extends LockWaiter {
        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public final Object K() {
            throw null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public final String toString() {
            throw null;
        }
    }

    @Metadata
    public abstract class LockWaiter extends LockFreeLinkedListNode implements DisposableHandle {
        public abstract Object K();
    }

    @Metadata
    public static final class LockedQueue extends LockFreeLinkedListHead {
        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public final String toString() {
            return "LockedQueue[null]";
        }
    }

    @Metadata
    public static final class TryLockDesc extends AtomicDesc {

        @Metadata
        public final class PrepareOp extends OpDescriptor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final AtomicOp f443a;

            public PrepareOp(AtomicOp r1) {
                this.f443a = r1;
            }

            @Override // kotlinx.coroutines.internal.OpDescriptor
            public final AtomicOp a() {
                return this.f443a;
            }

            @Override // kotlinx.coroutines.internal.OpDescriptor
            public final Object c(Object r3) {
                AtomicOp r0 = this.f443a;
                boolean r1 = r0.h();
                Object r2 = r0;
                if (r1 == false) goto L5;
                r2 = MutexKt.f445d;
            L5:
                if (r3 == null) goto L9;
                AtomicReferenceFieldUpdater r4 = MutexImpl.b;
                r4.compareAndSet((MutexImpl) r3, this, r2);
                return null;
            L9:
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
            }
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final void a(AtomicOp r2, Object r3) {
            r3.getClass();
            Empty r1 = MutexKt.f445d;
            MutexImpl.b.compareAndSet(null, r2, r1);
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final Object b(AtomicOp r3) {
            PrepareOp r2 = new PrepareOp(r3);
            if (MutexImpl.b.compareAndSet(null, MutexKt.f445d, r2) == false) goto L5;
            r2.c(null);
            return null;
        L5:
            return MutexKt.f444a;
        }
    }

    @Metadata
    public static final class UnlockOp extends AtomicOp<MutexImpl> {
        public final LockedQueue b;

        public UnlockOp(LockedQueue r1) {
            this.b = r1;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public final void d(Object r2, Object r3) {
            MutexImpl r4 = (MutexImpl) r2;
            if (r3 != null) goto L5;
            Object r5 = MutexKt.f445d;
        L6:
            MutexImpl.b.compareAndSet(r4, this, r5);
            return;
        L5:
            r5 = this.b;
            goto L6
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public final Object i(Object r1) {
            MutexImpl r2 = (MutexImpl) r1;
            LockedQueue r0 = this.b;
            if (r0.z() != r0) goto L6;
            return null;
        L6:
            return MutexKt.b;
        }
    }

    static {
        b = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public final void a(Object r8) {
    L2:
        Object r0 = this._state;
        boolean r4 = false;
        if ((r0 instanceof Empty) == true) goto L4;
        if ((r0 instanceof OpDescriptor) == true) goto L23;
        if ((r0 instanceof LockedQueue) == false) goto L57;
        if (r8 == null) goto L34;
        LockedQueue r1 = (LockedQueue) r0;
        r1.getClass();
        if (r8 != null) goto L30;
        r4 = true;
    L30:
        if (r4 == true) goto L34;
        StringBuilder r7 = new StringBuilder("Mutex is locked by ");
        r1.getClass();
        r7.append(null);
        r7.append(" but expected ");
        r7.append(r8);
        throw new IllegalStateException(r7.toString().toString());
    L34:
        LockedQueue r2 = (LockedQueue) r0;
    L35:
        Object r3 = r2.z();
        if (r3 == null) goto L55;
        LockFreeLinkedListNode r5 = (LockFreeLinkedListNode) r3;
        if (r5 == r2) goto L39;
        if (r5.G() == true) goto L42;
        r5.D();
    L42:
        if (r5 == null) goto L43;
        if (((LockWaiter) r5).K() == null) goto L2;
        throw null;
    L43:
        UnlockOp r6 = new UnlockOp(r2);
        if (b.compareAndSet(this, r0, r6) == false) goto L2;
        if (r6.c(this) != null) goto L2;
        return;
    L39:
        r5 = null;
        goto L42
    L55:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    L57:
        throw new IllegalStateException(b.a(r0, "Illegal state ").toString());
    L23:
        ((OpDescriptor) r0).c(this);
        goto L2
    L4:
        if (r8 == null) goto L6;
        Empty r9 = (Empty) r0;
        if (r9.f442a != r8) goto L15;
        r4 = true;
    L15:
        if (r4 == false) goto L20;
    L17:
        if (b.compareAndSet(this, r0, MutexKt.f445d) == false) goto L2;
        return;
    L20:
        throw new IllegalStateException(("Mutex is locked by " + r9.f442a + " but expected " + r8).toString());
    L6:
        if (((Empty) r0).f442a == MutexKt.c) goto L8;
        r4 = true;
    L8:
        if (r4 == true) goto L17;
        throw new IllegalStateException("Mutex is not locked".toString());
    }

    public final String toString() {
    L2:
        Object r0 = this._state;
        if ((r0 instanceof Empty) == true) goto L5;
        if ((r0 instanceof OpDescriptor) == false) goto L10;
        ((OpDescriptor) r0).c(this);
        goto L2
    L10:
        if ((r0 instanceof LockedQueue) == false) goto L14;
        StringBuilder r4 = new StringBuilder("Mutex[");
        ((LockedQueue) r0).getClass();
        r4.append(null);
        r4.append(']');
        return r4.toString();
    L14:
        throw new IllegalStateException(b.a(r0, "Illegal state ").toString());
    L5:
        return "Mutex[" + ((Empty) r0).f442a + ']';
    }
}
