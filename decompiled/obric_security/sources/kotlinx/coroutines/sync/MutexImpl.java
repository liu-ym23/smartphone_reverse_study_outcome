package kotlinx.coroutines.sync;

import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: Mutex.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00112\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 :\u0006$%&'()B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000bJT\u0010\u0014\u001a\u00020\t\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u0019\u0010\u001a\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\"\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", "", "locked", "<init>", "(Z)V", "", "owner", "holdsLock", "(Ljava/lang/Object;)Z", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "toString", "()Ljava/lang/String;", "tryLock", "unlock", "(Ljava/lang/Object;)V", "isLocked", "()Z", "isLockedEmptyQueueState$kotlinx_coroutines_core", "isLockedEmptyQueueState", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLock", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "TryLockDesc", "UnlockOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MutexImpl implements Mutex, SelectClause2<Object, Mutex> {
    static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = null;
    volatile /* synthetic */ Object _state;

    /* JADX INFO: compiled from: Mutex.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeLockWaiter", "toString", "", "tryResumeLockWaiter", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class LockCont extends LockWaiter {
        private final CancellableContinuation<Unit> cont;
        final /* synthetic */ MutexImpl this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public LockCont(MutexImpl r1, Object r2, CancellableContinuation<? super Unit> r3) {
            this.this$0 = r1;
            super(r1, r2);
            this.cont = r3;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public boolean tryResumeLockWaiter() {
            if (take() == true) goto L5;
            return false;
        L5:
            CancellableContinuation<Unit> r0 = this.cont;
            Unit r2 = Unit.INSTANCE;
            final MutexImpl r4 = this.this$0;
            if (r0.tryResume(r2, null, new MutexImpl$LockCont$tryResumeLockWaiter$1(r4, this)) == null) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public void completeResumeLockWaiter() {
            this.cont.completeResume(CancellableContinuationImplKt.RESUME_TOKEN);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockCont[" + this.owner + ", " + this.cont + "] for " + this.this$0;
        }
    }

    /* JADX INFO: compiled from: Mutex.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002R\u00020\u0003BD\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tø\u0001\u0000¢\u0006\u0002\u0010\fJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R1\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00050\t8\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockSelect;", "R", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "completeResumeLockWaiter", "", "toString", "", "tryResumeLockWaiter", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class LockSelect<R> extends LockWaiter {
        public final Function2<Mutex, Continuation<? super R>, Object> block;
        public final SelectInstance<R> select;
        final /* synthetic */ MutexImpl this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public LockSelect(MutexImpl r1, Object r2, SelectInstance<? super R> r3, Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> r4) {
            this.this$0 = r1;
            super(r1, r2);
            this.select = r3;
            this.block = r4;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public boolean tryResumeLockWaiter() {
            if (take() == true) goto L5;
        L7:
            return false;
        L5:
            if (this.select.trySelect() == false) goto L7;
            return true;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.LockWaiter
        public void completeResumeLockWaiter() {
            Function2<Mutex, Continuation<? super R>, Object> r0 = this.block;
            MutexImpl r1 = this.this$0;
            Continuation<R> r2 = this.select.getCompletion();
            final MutexImpl r4 = this.this$0;
            CancellableKt.startCoroutineCancellable(r0, r1, r2, new MutexImpl$LockSelect$completeResumeLockWaiter$1(r4, this));
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockSelect[" + this.owner + ", " + this.select + "] for " + this.this$0;
        }
    }

    /* JADX INFO: compiled from: Mutex.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b¢\u0004\u0018\u00002\u00020\u000f2\u00020\u0010B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "", "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "", "completeResumeLockWaiter", "()V", "dispose", "", "take", "()Z", "tryResumeLockWaiter", "Ljava/lang/Object;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private abstract class LockWaiter extends LockFreeLinkedListNode implements DisposableHandle {
        private static final /* synthetic */ AtomicIntegerFieldUpdater isTaken$FU = null;
        private volatile /* synthetic */ int isTaken;
        public final Object owner;
        final /* synthetic */ MutexImpl this$0;

        static {
            isTaken$FU = AtomicIntegerFieldUpdater.newUpdater(LockWaiter.class, "isTaken");
        }

        public abstract void completeResumeLockWaiter();

        public abstract boolean tryResumeLockWaiter();

        public LockWaiter(MutexImpl r1, Object r2) {
            this.this$0 = r1;
            this.owner = r2;
            this.isTaken = 0;
        }

        public final boolean take() {
            return isTaken$FU.compareAndSet(this, 0, 1);
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final void dispose() {
            mo2325remove();
        }
    }

    /* JADX INFO: compiled from: Mutex.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "owner", "", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class LockedQueue extends LockFreeLinkedListHead {
        public volatile Object owner;

        public LockedQueue(Object r1) {
            this.owner = r1;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockedQueue[" + this.owner + ']';
        }
    }

    /* JADX INFO: compiled from: Mutex.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0016\u0010\f\u001a\u0004\u0018\u00010\u00052\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "mutex", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", "", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", "complete", "", "op", "Lkotlinx/coroutines/internal/AtomicOp;", "failure", "prepare", "PrepareOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class TryLockDesc extends AtomicDesc {
        public final MutexImpl mutex;
        public final Object owner;

        /* JADX INFO: compiled from: Mutex.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "(Lkotlinx/coroutines/sync/MutexImpl$TryLockDesc;Lkotlinx/coroutines/internal/AtomicOp;)V", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
        private final class PrepareOp extends OpDescriptor {
            private final AtomicOp<?> atomicOp;
            final /* synthetic */ TryLockDesc this$0;

            public PrepareOp(TryLockDesc r1, AtomicOp<?> r2) {
                this.this$0 = r1;
                this.atomicOp = r2;
            }

            @Override // kotlinx.coroutines.internal.OpDescriptor
            public AtomicOp<?> getAtomicOp() {
                return this.atomicOp;
            }

            @Override // kotlinx.coroutines.internal.OpDescriptor
            public Object perform(Object r3) {
                if (getAtomicOp().isDecided() == false) goto L5;
                Object r0 = MutexKt.access$getEMPTY_UNLOCKED$p();
            L6:
                if (r3 == null) goto L10;
                AtomicReferenceFieldUpdater r1 = MutexImpl._state$FU;
                b0$$ExternalSyntheticBackport0.m(r1, (MutexImpl) r3, this, r0);
                return null;
            L10:
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.sync.MutexImpl");
            L5:
                r0 = getAtomicOp();
                goto L6
            }
        }

        public TryLockDesc(MutexImpl r1, Object r2) {
            this.mutex = r1;
            this.owner = r2;
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public Object prepare(AtomicOp<?> r4) {
            PrepareOp r0 = new PrepareOp(this, r4);
            MutexImpl r5 = this.mutex;
            if (b0$$ExternalSyntheticBackport0.m(MutexImpl._state$FU, r5, MutexKt.access$getEMPTY_UNLOCKED$p(), r0) == true) goto L7;
            return MutexKt.access$getLOCK_FAIL$p();
        L7:
            return r0.perform(this.mutex);
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public void complete(AtomicOp<?> r2, Object r3) {
            if (r3 == null) goto L5;
            Empty r4 = MutexKt.access$getEMPTY_UNLOCKED$p();
        L8:
            MutexImpl r1 = this.mutex;
            b0$$ExternalSyntheticBackport0.m(MutexImpl._state$FU, r1, r2, r4);
            return;
        L5:
            if (this.owner != null) goto L7;
            r4 = MutexKt.access$getEMPTY_LOCKED$p();
            goto L8
        L7:
            r4 = new Empty(this.owner);
            goto L8
        }
    }

    /* JADX INFO: compiled from: Mutex.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$UnlockOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/sync/MutexImpl;", DBHelper.TABLE_QUEUE, "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "(Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;)V", "complete", "", "affected", "failure", "", "prepare", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class UnlockOp extends AtomicOp<MutexImpl> {
        public final LockedQueue queue;

        @Override // kotlinx.coroutines.internal.AtomicOp
        public /* bridge */ /* synthetic */ void complete(MutexImpl r1, Object r2) {
            complete2(r1, r2);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public /* bridge */ /* synthetic */ Object prepare(MutexImpl r1) {
            return prepare2(r1);
        }

        public UnlockOp(LockedQueue r1) {
            this.queue = r1;
        }

        /* JADX INFO: renamed from: prepare, reason: avoid collision after fix types in other method */
        public Object prepare2(MutexImpl r1) {
            if (this.queue.isEmpty() == false) goto L6;
            return null;
        L6:
            return MutexKt.access$getUNLOCK_FAIL$p();
        }

        /* JADX INFO: renamed from: complete, reason: avoid collision after fix types in other method */
        public void complete2(MutexImpl r2, Object r3) {
            if (r3 != null) goto L4;
            Object r4 = MutexKt.access$getEMPTY_UNLOCKED$p();
        L5:
            b0$$ExternalSyntheticBackport0.m(MutexImpl._state$FU, r2, this, r4);
            return;
        L4:
            r4 = this.queue;
            goto L5
        }
    }

    static {
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    }

    public MutexImpl(boolean r1) {
        if (r1 == false) goto L5;
        Empty r2 = MutexKt.access$getEMPTY_LOCKED$p();
    L6:
        this._state = r2;
        return;
    L5:
        r2 = MutexKt.access$getEMPTY_UNLOCKED$p();
        goto L6
    }

    public static final /* synthetic */ Object access$lockSuspend(MutexImpl r0, Object r1, Continuation r2) {
        return r0.lockSuspend(r1, r2);
    }

    public final boolean isLockedEmptyQueueState$kotlinx_coroutines_core() {
        Object r1 = this._state;
        if ((r1 instanceof LockedQueue) == true) goto L5;
    L7:
        return false;
    L5:
        if (((LockedQueue) r1).isEmpty() == false) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public Object lock(Object r2, Continuation<? super Unit> r3) {
        if (tryLock(r2) == true) goto L5;
        Object r1 = lockSuspend(r2, r3);
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r1;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public SelectClause2<Object, Mutex> getOnLock() {
        return this;
    }

    @Override // kotlinx.coroutines.selects.SelectClause2
    public <R> void registerSelectClause2(SelectInstance<? super R> r5, Object r6, Function2<? super Mutex, ? super Continuation<? super R>, ? extends Object> r7) {
    L3:
        if (r5.isSelected() == true) goto L4;
        Object r0 = this._state;
        if ((r0 instanceof Empty) == true) goto L7;
        if ((r0 instanceof LockedQueue) == true) goto L26;
        if ((r0 instanceof OpDescriptor) == false) goto L43;
        ((OpDescriptor) r0).perform(this);
        goto L3
    L43:
        throw new IllegalStateException(("Illegal state " + r0).toString());
    L26:
        LockedQueue r1 = (LockedQueue) r0;
        if (r1.owner == r6) goto L29;
        boolean r2 = true;
    L30:
        if (r2 == false) goto L38;
        LockSelect r3 = new LockSelect(this, r6, r5, r7);
        r1.addLast(r3);
        if (this._state == r0) goto L35;
        if (r3.take() == true) goto L3;
    L35:
        r5.disposeOnSelect(r3);
        return;
    L38:
        throw new IllegalStateException(("Already locked by " + r6).toString());
    L29:
        r2 = false;
        goto L30
    L7:
        Empty r4 = (Empty) r0;
        if (r4.locked != MutexKt.access$getUNLOCKED$p()) goto L9;
        Object r8 = r5.performAtomicTrySelect(new TryLockDesc(this, r6));
        if (r8 == null) goto L12;
        if (r8 == SelectKt.getALREADY_SELECTED()) goto L16;
        if (r8 == MutexKt.access$getLOCK_FAIL$p()) goto L3;
        if (r8 == AtomicKt.RETRY_ATOMIC) goto L3;
        throw new IllegalStateException(("performAtomicTrySelect(TryLockDesc) returned " + r8).toString());
    L16:
        return;
    L12:
        UndispatchedKt.startCoroutineUnintercepted(r7, this, r5.getCompletion());
        return;
    L9:
        b0$$ExternalSyntheticBackport0.m(_state$FU, this, r0, new LockedQueue(r4.locked));
        goto L3
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean holdsLock(Object r4) {
        Object r3 = this._state;
        if ((r3 instanceof Empty) == false) goto L8;
        if (((Empty) r3).locked != r4) goto L13;
        return true;
    L13:
        return false;
    L8:
        if ((r3 instanceof LockedQueue) == false) goto L13;
        if (((LockedQueue) r3).owner != r4) goto L13;
        return true;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean isLocked() {
    L2:
        Object r0 = this._state;
        if ((r0 instanceof Empty) == true) goto L5;
        if ((r0 instanceof LockedQueue) == true) goto L11;
        if ((r0 instanceof OpDescriptor) == false) goto L16;
        ((OpDescriptor) r0).perform(this);
        goto L2
    L16:
        throw new IllegalStateException(("Illegal state " + r0).toString());
    L11:
        return true;
    L5:
        if (((Empty) r0).locked != MutexKt.access$getUNLOCKED$p()) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean tryLock(Object r6) {
    L2:
        Object r0 = this._state;
        boolean r2 = true;
        if ((r0 instanceof Empty) == true) goto L5;
        if ((r0 instanceof LockedQueue) == true) goto L16;
        if ((r0 instanceof OpDescriptor) == false) goto L27;
        ((OpDescriptor) r0).perform(this);
        goto L2
    L27:
        throw new IllegalStateException(("Illegal state " + r0).toString());
    L16:
        if (((LockedQueue) r0).owner != r6) goto L19;
        r2 = false;
    L19:
        if (r2 == false) goto L22;
        return false;
    L22:
        throw new IllegalStateException(("Already locked by " + r6).toString());
    L5:
        if (((Empty) r0).locked != MutexKt.access$getUNLOCKED$p()) goto L6;
        if (r6 != null) goto L9;
        Empty r1 = MutexKt.access$getEMPTY_LOCKED$p();
    L11:
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r0, r1) == false) goto L2;
        return true;
    L9:
        r1 = new Empty(r6);
        goto L11
    L6:
        return false;
    }

    private final Object lockSuspend(final Object r8, Continuation<? super Unit> r9) {
        CancellableContinuationImpl r0 = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(r9));
        CancellableContinuationImpl r1 = r0;
        LockCont r2 = new LockCont(this, r8, r1);
    L3:
        Object r3 = this._state;
        if ((r3 instanceof Empty) == true) goto L5;
        if ((r3 instanceof LockedQueue) == true) goto L16;
        if ((r3 instanceof OpDescriptor) == false) goto L42;
        ((OpDescriptor) r3).perform(this);
        goto L3
    L42:
        throw new IllegalStateException(("Illegal state " + r3).toString());
    L16:
        LockedQueue r4 = (LockedQueue) r3;
        if (r4.owner == r8) goto L19;
        boolean r5 = true;
    L20:
        if (r5 == false) goto L37;
        LockCont r6 = r2;
        r4.addLast(r6);
        if (this._state == r3) goto L27;
        if (r2.take() == false) goto L27;
        r2 = new LockCont(this, r8, r1);
    L27:
        CancellableContinuationKt.removeOnCancellation(r1, r6);
    L28:
        Object r7 = r0.getResult();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L32;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L32:
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L35;
        return r7;
    L35:
        return Unit.INSTANCE;
    L37:
        throw new IllegalStateException(("Already locked by " + r8).toString());
    L19:
        r5 = false;
        goto L20
    L5:
        Empty r10 = (Empty) r3;
        if (r10.locked != MutexKt.access$getUNLOCKED$p()) goto L7;
        if (r8 != null) goto L10;
        Empty r11 = MutexKt.access$getEMPTY_LOCKED$p();
    L12:
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r3, r11) == false) goto L3;
        r1.resume(Unit.INSTANCE, new MutexImpl$lockSuspend$2$1$1(this, r8));
        goto L28
    L10:
        r11 = new Empty(r8);
        goto L12
    L7:
        b0$$ExternalSyntheticBackport0.m(_state$FU, this, r3, new LockedQueue(r10.locked));
        goto L3
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void unlock(Object r8) {
    L2:
        Object r0 = this._state;
        boolean r4 = true;
        if ((r0 instanceof Empty) == true) goto L4;
        if ((r0 instanceof OpDescriptor) == true) goto L25;
        if ((r0 instanceof LockedQueue) == false) goto L52;
        if (r8 == null) goto L37;
        LockedQueue r1 = (LockedQueue) r0;
        if (r1.owner == r8) goto L33;
        r4 = false;
    L33:
        if (r4 == true) goto L37;
        throw new IllegalStateException(("Mutex is locked by " + r1.owner + " but expected " + r8).toString());
    L37:
        LockedQueue r2 = (LockedQueue) r0;
        LockFreeLinkedListNode r3 = r2.removeFirstOrNull();
        if (r3 == null) goto L39;
        LockWaiter r5 = (LockWaiter) r3;
        if (r5.tryResumeLockWaiter() == false) goto L2;
        Object r7 = r5.owner;
        if (r7 != null) goto L49;
        r7 = MutexKt.access$getLOCKED$p();
    L49:
        r2.owner = r7;
        r5.completeResumeLockWaiter();
        return;
    L39:
        UnlockOp r6 = new UnlockOp(r2);
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r0, r6) == false) goto L2;
        if (r6.perform(this) != null) goto L2;
        return;
    L52:
        throw new IllegalStateException(("Illegal state " + r0).toString());
    L25:
        ((OpDescriptor) r0).perform(this);
        goto L2
    L4:
        if (r8 == null) goto L6;
        Empty r9 = (Empty) r0;
        if (r9.locked == r8) goto L17;
        r4 = false;
    L17:
        if (r4 == false) goto L22;
    L19:
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, r0, MutexKt.access$getEMPTY_UNLOCKED$p()) == false) goto L2;
        return;
    L22:
        throw new IllegalStateException(("Mutex is locked by " + r9.locked + " but expected " + r8).toString());
    L6:
        if (((Empty) r0).locked != MutexKt.access$getUNLOCKED$p()) goto L9;
        r4 = false;
    L9:
        if (r4 == true) goto L19;
        throw new IllegalStateException("Mutex is not locked".toString());
    }

    public String toString() {
    L2:
        Object r0 = this._state;
        if ((r0 instanceof Empty) == true) goto L5;
        if ((r0 instanceof OpDescriptor) == false) goto L10;
        ((OpDescriptor) r0).perform(this);
        goto L2
    L10:
        if ((r0 instanceof LockedQueue) == false) goto L14;
        return "Mutex[" + ((LockedQueue) r0).owner + ']';
    L14:
        throw new IllegalStateException(("Illegal state " + r0).toString());
    L5:
        return "Mutex[" + ((Empty) r0).locked + ']';
    }
}
