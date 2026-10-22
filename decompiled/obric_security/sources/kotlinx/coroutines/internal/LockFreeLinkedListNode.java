package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.framwork.core.sdklib.DBHelper;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\f\b\u0017\u0018\u00002\u00020C:\u0005JKLMNB\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u0019\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u0003¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\u000b\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b¢\u0006\u0004\b\u000b\u0010\fJ4\u0010\u000f\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\rH\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010JD\u0010\u0011\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u0016\u0010\u000e\u001a\u0012\u0012\b\u0012\u00060\u0000j\u0002`\u0003\u0012\u0004\u0012\u00020\t0\r2\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u001a\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0082\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d\"\f\b\u0000\u0010\u001c*\u00060\u0000j\u0002`\u00032\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\f\u0012\b\u0012\u00060\u0000j\u0002`\u00030 ¢\u0006\u0004\b!\u0010\"J \u0010$\u001a\u00060\u0000j\u0002`\u00032\n\u0010#\u001a\u00060\u0000j\u0002`\u0003H\u0082\u0010¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00052\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0002¢\u0006\u0004\b&\u0010\u0007J\r\u0010'\u001a\u00020\u0005¢\u0006\u0004\b'\u0010\u0002J\u000f\u0010(\u001a\u00020\u0005H\u0001¢\u0006\u0004\b(\u0010\u0002J,\u0010*\u001a\u00020)2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\u000e\b\u0004\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0081\b¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003H\u0014¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\tH\u0016¢\u0006\u0004\b.\u0010/J.\u00100\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u001c\u0018\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\rH\u0086\b¢\u0006\u0004\b0\u00101J\u0015\u00102\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b2\u0010-J\u0017\u00103\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0003H\u0001¢\u0006\u0004\b3\u0010-J\u000f\u00105\u001a\u000204H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00108\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109J/\u0010<\u001a\u00020;2\n\u0010\u0004\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u00032\u0006\u0010:\u001a\u00020)H\u0001¢\u0006\u0004\b<\u0010=J'\u0010A\u001a\u00020\u00052\n\u0010>\u001a\u00060\u0000j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0000j\u0002`\u0003H\u0000¢\u0006\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010/R\u0011\u0010\u0013\u001a\u00020C8F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0015\u0010G\u001a\u00060\u0000j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\bF\u0010-R\u0015\u0010I\u001a\u00060\u0000j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\bH\u0010-¨\u0006O"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "<init>", "()V", "Lkotlinx/coroutines/internal/Node;", "node", "", "addLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlin/Function0;", "", "condition", "addLastIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Z", "Lkotlin/Function1;", "predicate", "addLastIfPrev", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;)Z", "addLastIfPrevAndIf", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Z", "next", "addNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "addOneIfEmpty", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "correctPrev", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "describeAddLast", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "describeRemoveFirst", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", PerfConsts.KEY_CURRENT_GALVANIC, "findPrevNonRemoved", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "finishAdd", "helpRemove", "helpRemovePrev", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "makeCondAddOp", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "nextIfRemoved", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "remove", "()Z", "removeFirstIfIsInstanceOfOrPeekIf", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeFirstOrNull", "removeOrNext", "Lkotlinx/coroutines/internal/Removed;", "removed", "()Lkotlinx/coroutines/internal/Removed;", "", "toString", "()Ljava/lang/String;", "condAdd", "", "tryCondAddNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;)I", "prev", "validateNode$kotlinx_coroutines_core", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "validateNode", "isRemoved", "", "getNext", "()Ljava/lang/Object;", "getNextNode", "nextNode", "getPrevNode", "prevNode", "AbstractAtomicDesc", "AddLastDesc", "CondAddOp", "PrepareOp", "RemoveFirstDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class LockFreeLinkedListNode {
    static final /* synthetic */ AtomicReferenceFieldUpdater _next$FU = null;
    static final /* synthetic */ AtomicReferenceFieldUpdater _prev$FU = null;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _removedRef$FU = null;
    volatile /* synthetic */ Object _next;
    volatile /* synthetic */ Object _prev;
    private volatile /* synthetic */ Object _removedRef;

    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u0005H\u0014J \u0010\u0011\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0012\u001a\u00060\u0004j\u0002`\u0005H$J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0014\u0010\u0017\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u0005H\u0016J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rJ\u001c\u0010\u0019\u001a\u00020\u001a2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0012\u001a\u00020\u000fH\u0014J\u0018\u0010\u001b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00052\u0006\u0010\f\u001a\u00020\u001cH\u0014J \u0010\u001d\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0012\u001a\u00060\u0004j\u0002`\u0005H&R\u001a\u0010\u0003\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "Lkotlinx/coroutines/internal/AtomicDesc;", "()V", "affectedNode", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "originalNext", "getOriginalNext", "complete", "", "op", "Lkotlinx/coroutines/internal/AtomicOp;", "failure", "", "affected", "finishOnSuccess", "next", "finishPrepare", "prepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "onPrepare", "onRemoved", "prepare", "retry", "", "takeAffectedNode", "Lkotlinx/coroutines/internal/OpDescriptor;", "updatedNext", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class AbstractAtomicDesc extends AtomicDesc {
        protected Object failure(LockFreeLinkedListNode r1) {
            return null;
        }

        protected abstract void finishOnSuccess(LockFreeLinkedListNode r1, LockFreeLinkedListNode r2);

        public abstract void finishPrepare(PrepareOp r1);

        protected abstract LockFreeLinkedListNode getAffectedNode();

        protected abstract LockFreeLinkedListNode getOriginalNext();

        public void onRemoved(LockFreeLinkedListNode r1) {
        }

        protected boolean retry(LockFreeLinkedListNode r1, Object r2) {
            return false;
        }

        public abstract Object updatedNext(LockFreeLinkedListNode r1, LockFreeLinkedListNode r2);

        public AbstractAtomicDesc() {
        }

        protected LockFreeLinkedListNode takeAffectedNode(OpDescriptor r1) {
            LockFreeLinkedListNode r0 = getAffectedNode();
            Intrinsics.checkNotNull(r0);
            return r0;
        }

        public Object onPrepare(PrepareOp r1) {
            finishPrepare(r1);
            return null;
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final Object prepare(AtomicOp<?> r7) {
        L2:
            LockFreeLinkedListNode r0 = takeAffectedNode(r7);
            if (r0 == null) goto L5;
            Object r1 = r0._next;
            if (r1 == r7) goto L8;
            if (r7.isDecided() == true) goto L11;
            if ((r1 instanceof OpDescriptor) == true) goto L14;
            Object r3 = failure(r0);
            if (r3 != null) goto L21;
            if (retry(r0, r1) == true) goto L2;
            PrepareOp r4 = new PrepareOp(r0, (LockFreeLinkedListNode) r1, this);
            if (b0$$ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, r0, r1, r4) == false) goto L2;
            Object r5 = r4.perform(r0);     // Catch: Throwable -> L38
            if (r5 == LockFreeLinkedList_commonKt.REMOVE_PREPARED) goto L2;
            if (DebugKt.getASSERTIONS_ENABLED() == false) goto L37;
            if (r5 != null) goto L32;
            boolean r6 = true;
        L33:
            if (r6 == true) goto L37;
            throw new AssertionError();     // Catch: Throwable -> L38
        L32:
            r6 = false;
        L37:
            return null;
        L38:
            th = move-exception;
            b0$$ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, r0, r4, r1);
            throw th;
        L21:
            return r3;
        L14:
            OpDescriptor r2 = (OpDescriptor) r1;
            if (r7.isEarlierThan(r2) == true) goto L17;
            r2.perform(r0);
            goto L2
        L17:
            return AtomicKt.RETRY_ATOMIC;
        L11:
            return null;
        L8:
            return null;
        L5:
            return AtomicKt.RETRY_ATOMIC;
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final void complete(AtomicOp<?> r5, Object r6) {
            if (r6 != null) goto L5;
            boolean r7 = true;
        L6:
            LockFreeLinkedListNode r1 = getAffectedNode();
            if (r1 == null) goto L9;
            LockFreeLinkedListNode r2 = getOriginalNext();
            if (r2 == null) goto L19;
            if (r7 == false) goto L28;
            Object r0 = updatedNext(r1, r2);
        L30:
            if (b0$$ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, r1, r5, r0) == false) goto L36;
            if (r7 == false) goto L37;
            finishOnSuccess(r1, r2);
            return;
        L37:
            return;
        L36:
            return;
        L28:
            r0 = r2;
            goto L30
        L19:
            if (DebugKt.getASSERTIONS_ENABLED() == true) goto L21;
            return;
        L21:
            if ((!r7) == false) goto L24;
            return;
        L24:
            throw new AssertionError();
        L9:
            if (DebugKt.getASSERTIONS_ENABLED() == true) goto L11;
            return;
        L11:
            if ((!r7) == false) goto L14;
            return;
        L14:
            throw new AssertionError();
        L5:
            r7 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0003*\u00060\u0001j\u0002`\u00022\u00020!B\u001b\u0012\n\u0010\u0004\u001a\u00060\u0001j\u0002`\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000b\u001a\u00020\n2\n\u0010\b\u001a\u00060\u0001j\u0002`\u00022\n\u0010\t\u001a\u00060\u0001j\u0002`\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0012\u001a\u00020\u00112\n\u0010\b\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\t\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0004¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u00020\u00102\n\u0010\b\u001a\u00060\u0001j\u0002`\u00022\n\u0010\t\u001a\u00060\u0001j\u0002`\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001c\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00028DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u00028\u00008\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0018\u0010\u001f\u001a\u00060\u0001j\u0002`\u00028DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001bR\u0018\u0010\u0004\u001a\u00060\u0001j\u0002`\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001d¨\u0006 "}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", ExifInterface.GPS_DIRECTION_TRUE, DBHelper.TABLE_QUEUE, "node", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "affected", "next", "", "finishOnSuccess", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "", "", "retry", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "getOriginalNext", "originalNext", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class AddLastDesc<T extends LockFreeLinkedListNode> extends AbstractAtomicDesc {
        private static final /* synthetic */ AtomicReferenceFieldUpdater _affectedNode$FU = null;
        private volatile /* synthetic */ Object _affectedNode;
        public final T node;
        public final LockFreeLinkedListNode queue;

        static {
            _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(AddLastDesc.class, Object.class, "_affectedNode");
        }

        public AddLastDesc(LockFreeLinkedListNode r1, T r2) {
            this.queue = r1;
            this.node = r2;
            if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
        L14:
            this._affectedNode = null;
            return;
        L5:
            if (r2._next == r2) goto L7;
        L9:
            boolean r3 = false;
        L10:
            if (r3 == true) goto L14;
            throw new AssertionError();
        L7:
            if (r2._prev != r2) goto L9;
            r3 = true;
            goto L10
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode takeAffectedNode(OpDescriptor r1) {
            return LockFreeLinkedListNode.access$correctPrev(this.queue, r1);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode getOriginalNext() {
            return this.queue;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected boolean retry(LockFreeLinkedListNode r1, Object r2) {
            if (r2 == this.queue) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishPrepare(PrepareOp r3) {
            b0$$ExternalSyntheticBackport0.m(_affectedNode$FU, this, null, r3.affected);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object updatedNext(LockFreeLinkedListNode r3, LockFreeLinkedListNode r4) {
            T r5 = this.node;
            b0$$ExternalSyntheticBackport0.m(LockFreeLinkedListNode._prev$FU, r5, this.node, r3);
            T r6 = this.node;
            b0$$ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, r6, this.node, this.queue);
            return this.node;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected void finishOnSuccess(LockFreeLinkedListNode r1, LockFreeLinkedListNode r2) {
            LockFreeLinkedListNode.access$finishAdd(this.node, this.queue);
        }
    }

    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0011\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0002j\u0002`\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "newNode", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "oldNext", "complete", "", "affected", "failure", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {
        public final LockFreeLinkedListNode newNode;
        public LockFreeLinkedListNode oldNext;

        @Override // kotlinx.coroutines.internal.AtomicOp
        public /* bridge */ /* synthetic */ void complete(LockFreeLinkedListNode r1, Object r2) {
            complete2(r1, r2);
        }

        public CondAddOp(LockFreeLinkedListNode r1) {
            this.newNode = r1;
        }

        /* JADX INFO: renamed from: complete, reason: avoid collision after fix types in other method */
        public void complete2(LockFreeLinkedListNode r3, Object r4) {
            if (r4 != null) goto L4;
            boolean r5 = true;
        L5:
            if (r5 == false) goto L7;
            LockFreeLinkedListNode r0 = this.newNode;
        L8:
            if (r0 != null) goto L10;
            return;
        L10:
            if (b0$$ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, r3, this, r0) == false) goto L15;
            if (r5 == false) goto L16;
            LockFreeLinkedListNode r6 = this.newNode;
            LockFreeLinkedListNode r2 = this.oldNext;
            Intrinsics.checkNotNull(r2);
            LockFreeLinkedListNode.access$finishAdd(r6, r2);
            return;
        L16:
            return;
        L15:
            return;
        L7:
            r0 = this.oldNext;
            goto L8
        L4:
            r5 = false;
            goto L5
        }
    }

    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0002\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00060\u0003j\u0002`\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "next", "desc", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;)V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "finishPrepare", "", "perform", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PrepareOp extends OpDescriptor {
        public final LockFreeLinkedListNode affected;
        public final AbstractAtomicDesc desc;
        public final LockFreeLinkedListNode next;

        public PrepareOp(LockFreeLinkedListNode r1, LockFreeLinkedListNode r2, AbstractAtomicDesc r3) {
            this.affected = r1;
            this.next = r2;
            this.desc = r3;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public AtomicOp<?> getAtomicOp() {
            return this.desc.getAtomicOp();
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public Object perform(Object r5) {
            if (DebugKt.getASSERTIONS_ENABLED() == true) goto L5;
        L12:
            if (r5 == null) goto L32;
            LockFreeLinkedListNode r6 = (LockFreeLinkedListNode) r5;
            Object r0 = this.desc.onPrepare(this);
            if (r0 != LockFreeLinkedList_commonKt.REMOVE_PREPARED) goto L20;
            LockFreeLinkedListNode r1 = this.next;
            Removed r2 = LockFreeLinkedListNode.access$removed(r1);
            if (b0$$ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, r6, this, r2) == false) goto L19;
            this.desc.onRemoved(r6);
            LockFreeLinkedListNode.access$correctPrev(r1, null);
        L19:
            return LockFreeLinkedList_commonKt.REMOVE_PREPARED;
        L20:
            if (r0 == null) goto L22;
            Object r3 = getAtomicOp().decide(r0);
        L24:
            if (r3 != AtomicKt.NO_DECISION) goto L26;
            Object r4 = getAtomicOp();
        L29:
            b0$$ExternalSyntheticBackport0.m(LockFreeLinkedListNode._next$FU, r6, this, r4);
            return null;
        L26:
            if (r3 != null) goto L28;
            r4 = this.desc.updatedNext(r6, this.next);
            goto L29
        L28:
            r4 = this.next;
            goto L29
        L22:
            r3 = getAtomicOp().getConsensus();
            goto L24
        L32:
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        L5:
            if (r5 != this.affected) goto L7;
            boolean r7 = true;
        L8:
            if (r7 == true) goto L12;
            throw new AssertionError();
        L7:
            r7 = false;
            goto L8
        }

        public final void finishPrepare() {
            this.desc.finishPrepare(this);
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public String toString() {
            return "PrepareOp(op=" + getAtomicOp() + ')';
        }
    }

    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020(B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u0003H\u0014¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\f2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0014\u001a\u00020\u00132\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000b\u001a\u00020\bH\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0004¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001a\u001a\u00020\b2\n\u0010\u0007\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001e\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010 \u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0018\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010!R\u0017\u0010&\u001a\u00028\u00008F¢\u0006\f\u0012\u0004\b$\u0010%\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", DBHelper.TABLE_QUEUE, "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "affected", "", "failure", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "next", "", "finishOnSuccess", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "prepareOp", "finishPrepare", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "", "retry", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/OpDescriptor;", "op", "takeAffectedNode", "(Lkotlinx/coroutines/internal/OpDescriptor;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "updatedNext", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "getAffectedNode", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affectedNode", "getOriginalNext", "originalNext", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "getResult", "()Ljava/lang/Object;", "getResult$annotations", "()V", "result", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class RemoveFirstDesc<T> extends AbstractAtomicDesc {
        private static final /* synthetic */ AtomicReferenceFieldUpdater _affectedNode$FU = null;
        private static final /* synthetic */ AtomicReferenceFieldUpdater _originalNext$FU = null;
        private volatile /* synthetic */ Object _affectedNode;
        private volatile /* synthetic */ Object _originalNext;
        public final LockFreeLinkedListNode queue;

        static {
            _affectedNode$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_affectedNode");
            _originalNext$FU = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_originalNext");
        }

        public static /* synthetic */ void getResult$annotations() {
        }

        public RemoveFirstDesc(LockFreeLinkedListNode r1) {
            this.queue = r1;
            this._affectedNode = null;
            this._originalNext = null;
        }

        public final T getResult() {
            Object r0 = getAffectedNode();
            Intrinsics.checkNotNull(r0);
            return (T) r0;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode takeAffectedNode(OpDescriptor r4) {
            LockFreeLinkedListNode r0 = this.queue;
        L3:
            Object r1 = r0._next;
            if ((r1 instanceof OpDescriptor) == false) goto L11;
            OpDescriptor r2 = (OpDescriptor) r1;
            if (r4.isEarlierThan(r2) == true) goto L7;
            r2.perform(this.queue);
            goto L3
        L7:
            return null;
        L11:
            return (LockFreeLinkedListNode) r1;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode getAffectedNode() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final LockFreeLinkedListNode getOriginalNext() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object failure(LockFreeLinkedListNode r1) {
            if (r1 == this.queue) goto L7;
            return null;
        L7:
            return LockFreeLinkedListKt.getLIST_EMPTY();
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final boolean retry(LockFreeLinkedListNode r1, Object r2) {
            if ((r2 instanceof Removed) == true) goto L6;
            return false;
        L6:
            ((Removed) r2).ref.helpRemovePrev();
            return true;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public void finishPrepare(PrepareOp r4) {
            b0$$ExternalSyntheticBackport0.m(_affectedNode$FU, this, null, r4.affected);
            b0$$ExternalSyntheticBackport0.m(_originalNext$FU, this, null, r4.next);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object updatedNext(LockFreeLinkedListNode r1, LockFreeLinkedListNode r2) {
            return LockFreeLinkedListNode.access$removed(r2);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected final void finishOnSuccess(LockFreeLinkedListNode r1, LockFreeLinkedListNode r2) {
            LockFreeLinkedListNode.access$correctPrev(r2, null);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.internal.LockFreeLinkedListNode$makeCondAddOp$1, reason: invalid class name */
    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass1 extends CondAddOp {
        final /* synthetic */ Function0<Boolean> $condition;

        public AnonymousClass1(LockFreeLinkedListNode r1, Function0<Boolean> r2) {
            this.$condition = r2;
            super(r1);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public /* bridge */ /* synthetic */ Object prepare(LockFreeLinkedListNode r1) {
            return prepare2(r1);
        }

        /* JADX INFO: renamed from: prepare, reason: avoid collision after fix types in other method */
        public Object prepare2(LockFreeLinkedListNode r1) {
            if (this.$condition.invoke().booleanValue() == false) goto L6;
            return null;
        L6:
            return LockFreeLinkedListKt.getCONDITION_FALSE();
        }
    }

    static {
        _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
        _prev$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
        _removedRef$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
    }

    public LockFreeLinkedListNode() {
        this._next = this;
        this._prev = this;
        this._removedRef = null;
    }

    public static final /* synthetic */ LockFreeLinkedListNode access$correctPrev(LockFreeLinkedListNode r0, OpDescriptor r1) {
        return r0.correctPrev(r1);
    }

    public static final /* synthetic */ void access$finishAdd(LockFreeLinkedListNode r0, LockFreeLinkedListNode r1) {
        r0.finishAdd(r1);
    }

    public static final /* synthetic */ Removed access$removed(LockFreeLinkedListNode r0) {
        return r0.removed();
    }

    private final Removed removed() {
        Removed r0 = (Removed) this._removedRef;
        if (r0 != null) goto L6;
        Removed r1 = new Removed(this);
        _removedRef$FU.lazySet(this, r1);
        return r1;
    L6:
        return r0;
    }

    public final CondAddOp makeCondAddOp(LockFreeLinkedListNode r1, Function0<Boolean> r2) {
        return new AnonymousClass1(r1, r2);
    }

    public boolean isRemoved() {
        return getNext() instanceof Removed;
    }

    public final LockFreeLinkedListNode getNextNode() {
        return LockFreeLinkedListKt.unwrap(getNext());
    }

    public final LockFreeLinkedListNode getPrevNode() {
        LockFreeLinkedListNode r0 = correctPrev(null);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return findPrevNonRemoved((LockFreeLinkedListNode) this._prev);
    }

    private final LockFreeLinkedListNode findPrevNonRemoved(LockFreeLinkedListNode r1) {
    L3:
        if (r1.isRemoved() == false) goto L4;
        r1 = (LockFreeLinkedListNode) r1._prev;
        goto L3
    L4:
        return r1;
    }

    public final boolean addOneIfEmpty(LockFreeLinkedListNode r2) {
        _prev$FU.lazySet(r2, this);
        _next$FU.lazySet(r2, this);
    L4:
        if (getNext() != this) goto L5;
        if (b0$$ExternalSyntheticBackport0.m(_next$FU, this, this, r2) == false) goto L4;
        r2.finishAdd(this);
        return true;
    L5:
        return false;
    }

    public final void addLast(LockFreeLinkedListNode r2) {
    L3:
        if (getPrevNode().addNext(r2, this) == false) goto L3;
    }

    public final <T extends LockFreeLinkedListNode> AddLastDesc<T> describeAddLast(T r2) {
        return new AddLastDesc(this, r2);
    }

    public final boolean addLastIfPrev(LockFreeLinkedListNode r3, Function1<? super LockFreeLinkedListNode, Boolean> r4) {
    L2:
        LockFreeLinkedListNode r0 = getPrevNode();
        if (r4.invoke(r0).booleanValue() == false) goto L4;
        if (r0.addNext(r3, this) == false) goto L2;
        return true;
    L4:
        return false;
    }

    public final boolean addNext(LockFreeLinkedListNode r2, LockFreeLinkedListNode r3) {
        _prev$FU.lazySet(r2, this);
        AtomicReferenceFieldUpdater r0 = _next$FU;
        r0.lazySet(r2, r3);
        if (b0$$ExternalSyntheticBackport0.m(r0, this, r3, r2) == true) goto L6;
        return false;
    L6:
        r2.finishAdd(r3);
        return true;
    }

    public final int tryCondAddNext(LockFreeLinkedListNode r2, LockFreeLinkedListNode r3, CondAddOp r4) {
        _prev$FU.lazySet(r2, this);
        AtomicReferenceFieldUpdater r0 = _next$FU;
        r0.lazySet(r2, r3);
        r4.oldNext = r3;
        if (b0$$ExternalSyntheticBackport0.m(r0, this, r3, r4) == true) goto L7;
        return 0;
    L7:
        if (r4.perform(this) != null) goto L9;
        return 1;
    L9:
        return 2;
    }

    /* JADX INFO: renamed from: remove */
    public boolean mo2325remove() {
        if (removeOrNext() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final LockFreeLinkedListNode removeOrNext() {
    L2:
        Object r0 = getNext();
        if ((r0 instanceof Removed) == true) goto L5;
        if (r0 == this) goto L8;
        LockFreeLinkedListNode r1 = (LockFreeLinkedListNode) r0;
        Removed r2 = r1.removed();
        if (b0$$ExternalSyntheticBackport0.m(_next$FU, this, r0, r2) == false) goto L2;
        r1.correctPrev(null);
        return null;
    L8:
        return (LockFreeLinkedListNode) r0;
    L5:
        return ((Removed) r0).ref;
    }

    public final void helpRemove() {
        ((Removed) getNext()).ref.helpRemovePrev();
    }

    public final void helpRemovePrev() {
    L2:
        Object r0 = this.getNext();
        if ((r0 instanceof Removed) == false) goto L5;
        LockFreeLinkedListNode this = ((Removed) r0).ref;
        goto L2
    L5:
        this.correctPrev(null);
    }

    public final LockFreeLinkedListNode removeFirstOrNull() {
    L2:
        LockFreeLinkedListNode r0 = (LockFreeLinkedListNode) getNext();
        if (r0 == this) goto L4;
        if (r0.mo2325remove() == true) goto L8;
        r0.helpRemove();
        goto L2
    L8:
        return r0;
    L4:
        return null;
    }

    public final RemoveFirstDesc<LockFreeLinkedListNode> describeRemoveFirst() {
        return new RemoveFirstDesc(this);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object, kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    public final /* synthetic */ <T> T removeFirstIfIsInstanceOfOrPeekIf(Function1<? super T, Boolean> r5) {
    L2:
        LockFreeLinkedListNode r0 = (LockFreeLinkedListNode) getNext();
        if (r0 == this) goto L4;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if ((r0 instanceof Object) == false) goto L7;
        if (r5.invoke(r0).booleanValue() == true) goto L11;
    L13:
        LockFreeLinkedListNode r1 = r0.removeOrNext();
        if (r1 == null) goto L15;
        r1.helpRemovePrev();
        goto L2
    L15:
        return r0;
    L11:
        if (r0.isRemoved() == true) goto L13;
        return r0;
    L7:
        return null;
    L4:
        return null;
    }

    protected LockFreeLinkedListNode nextIfRemoved() {
        Object r2 = getNext();
        if ((r2 instanceof Removed) == false) goto L5;
        Removed r3 = (Removed) r2;
    L6:
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.ref;
    L5:
        r3 = null;
        goto L6
    }

    private final LockFreeLinkedListNode correctPrev(OpDescriptor r8) {
    L2:
        LockFreeLinkedListNode r0 = (LockFreeLinkedListNode) this._prev;
        LockFreeLinkedListNode r2 = r0;
    L3:
        LockFreeLinkedListNode r3 = null;
    L4:
        Object r4 = r2._next;
        if (r4 == this) goto L6;
        if (isRemoved() == true) goto L14;
        if (r4 == r8) goto L16;
        if ((r4 instanceof OpDescriptor) == true) goto L19;
        if ((r4 instanceof Removed) == true) goto L26;
        r3 = r2;
        r2 = (LockFreeLinkedListNode) r4;
        goto L4
    L26:
        if (r3 != null) goto L28;
        r2 = (LockFreeLinkedListNode) r2._prev;
        goto L4
    L28:
        if (b0$$ExternalSyntheticBackport0.m(_next$FU, r3, r2, ((Removed) r4).ref) == false) goto L2;
        r2 = r3;
        goto L3
    L19:
        if (r8 != null) goto L21;
    L23:
        ((OpDescriptor) r4).perform(r2);
        goto L2
    L21:
        if (r8.isEarlierThan((OpDescriptor) r4) == false) goto L23;
        return null;
    L16:
        return r2;
    L14:
        return null;
    L6:
        if (r0 == r2) goto L7;
        if (b0$$ExternalSyntheticBackport0.m(_prev$FU, this, r0, r2) == false) goto L2;
        return r2;
    L7:
        return r2;
    }

    public final void validateNode$kotlinx_coroutines_core(LockFreeLinkedListNode r4, LockFreeLinkedListNode r5) {
        boolean r1 = true;
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L13;
        if (r4 != this._prev) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L13;
        throw new AssertionError();
    L7:
        r6 = false;
    L13:
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L15;
        return;
    L15:
        if (r5 == this._next) goto L18;
        r1 = false;
    L18:
        if (r1 == false) goto L21;
        return;
    L21:
        throw new AssertionError();
    }

    public String toString() {
        return new C05021(this) + '@' + DebugStringsKt.getHexAddress(this);
    }

    public final Object getNext() {
    L2:
        Object r0 = this._next;
        if ((r0 instanceof OpDescriptor) == false) goto L4;
        ((OpDescriptor) r0).perform(this);
        goto L2
    L4:
        return r0;
    }

    public final boolean addLastIf(LockFreeLinkedListNode r3, Function0<Boolean> r4) {
        AnonymousClass1 r0 = new AnonymousClass1(r3, r4);
    L3:
        int r5 = getPrevNode().tryCondAddNext(r3, this, r0);
        if (r5 == 1) goto L10;
        if (r5 != 2) goto L3;
        return false;
    L10:
        return true;
    }

    public final boolean addLastIfPrevAndIf(LockFreeLinkedListNode r4, Function1<? super LockFreeLinkedListNode, Boolean> r5, Function0<Boolean> r6) {
        AnonymousClass1 r0 = new AnonymousClass1(r4, r6);
    L3:
        LockFreeLinkedListNode r7 = getPrevNode();
        if (r5.invoke(r7).booleanValue() == false) goto L5;
        int r8 = r7.tryCondAddNext(r4, this, r0);
        if (r8 == 1) goto L12;
        if (r8 != 2) goto L3;
        return false;
    L12:
        return true;
    L5:
        return false;
    }

    private final void finishAdd(LockFreeLinkedListNode r3) {
    L2:
        LockFreeLinkedListNode r0 = (LockFreeLinkedListNode) r3._prev;
        if (getNext() != r3) goto L4;
        if (b0$$ExternalSyntheticBackport0.m(_prev$FU, r3, r0, this) == false) goto L2;
        if (isRemoved() == false) goto L14;
        r3.correctPrev(null);
        return;
    L14:
        return;
    }
}
