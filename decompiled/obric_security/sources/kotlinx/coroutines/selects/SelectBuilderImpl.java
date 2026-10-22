package kotlinx.coroutines.selects;

import com.bytedanceos.securitycenter.appBgBatteryControl.AppBgBatteryControlDataHelper;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.CompletionStateKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellingNode;
import kotlinx.coroutines.internal.AtomicDesc;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import tmsdkobf.b0$$ExternalSyntheticBackport0;

/* JADX INFO: compiled from: Select.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020Y2\b\u0012\u0004\u0012\u00028\u00000Z2\b\u0012\u0004\u0012\u00028\u00000[2\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060Bj\u0002`C:\u0004TUVWB\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ.\u0010\u0011\u001a\u00020\b2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0082\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\fJ8\u0010!\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0 H\u0016ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001a\u0004\u0018\u00010\u000e2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u0019H\u0016¢\u0006\u0004\b(\u0010\u001cJ \u0010+\u001a\u00020\b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000)H\u0016ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\u001b\u00105\u001a\u0004\u0018\u00010\u000e2\b\u00104\u001a\u0004\u0018\u000103H\u0016¢\u0006\u0004\b5\u00106J5\u00108\u001a\u00020\b*\u0002072\u001c\u0010\u0010\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0 H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b8\u00109JG\u00108\u001a\u00020\b\"\u0004\b\u0001\u0010:*\b\u0012\u0004\u0012\u00028\u00010;2\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0<H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b8\u0010=J[\u00108\u001a\u00020\b\"\u0004\b\u0001\u0010>\"\u0004\b\u0002\u0010:*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020?2\u0006\u0010@\u001a\u00028\u00012\"\u0010\u0010\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u000e0<H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b8\u0010AR\u001c\u0010F\u001a\n\u0018\u00010Bj\u0004\u0018\u0001`C8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0014\u0010N\u001a\u0002008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u00102R(\u0010R\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u000e¢\u0006\f\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010\nR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010S\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006X"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl;", "R", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/Continuation;)V", "Lkotlinx/coroutines/DisposableHandle;", "handle", "", "disposeOnSelect", "(Lkotlinx/coroutines/DisposableHandle;)V", "doAfterSelect", "()V", "Lkotlin/Function0;", "", "value", "block", "doResume", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "e", "handleBuilderException", "(Ljava/lang/Throwable;)V", "initCancellability", "", "timeMillis", "Lkotlin/Function1;", "onTimeout", "(JLkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/internal/AtomicDesc;", "desc", "performAtomicTrySelect", "(Lkotlinx/coroutines/internal/AtomicDesc;)Ljava/lang/Object;", "exception", "resumeSelectWithException", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "", "trySelect", "()Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "trySelectOther", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectClause0;", "invoke", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", AppBgBatteryControlDataHelper.ItemColumns.PARAM, "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getCompletion", "()Lkotlin/coroutines/Continuation;", "completion", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "isSelected", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "parentHandle", "Lkotlin/coroutines/Continuation;", "AtomicSelectOp", "DisposeNode", "PairSelectOp", "SelectOnCancelling", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlinx/coroutines/selects/SelectInstance;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SelectBuilderImpl<R> extends LockFreeLinkedListHead implements SelectBuilder<R>, SelectInstance<R>, Continuation<R>, CoroutineStackFrame {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _result$FU = null;
    static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU = null;
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _result;
    volatile /* synthetic */ Object _state;
    private final Continuation<R> uCont;

    /* JADX INFO: compiled from: Select.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0019\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0002R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$AtomicSelectOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "", "impl", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "desc", "Lkotlinx/coroutines/internal/AtomicDesc;", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;Lkotlinx/coroutines/internal/AtomicDesc;)V", "opSequence", "", "getOpSequence", "()J", "complete", "", "affected", "failure", "completeSelect", "prepare", "prepareSelectOp", "toString", "", "undoPrepare", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class AtomicSelectOp extends AtomicOp<Object> {
        public final AtomicDesc desc;
        public final SelectBuilderImpl<?> impl;
        private final long opSequence;

        public AtomicSelectOp(SelectBuilderImpl<?> r3, AtomicDesc r4) {
            this.impl = r3;
            this.desc = r4;
            this.opSequence = SelectKt.access$getSelectOpSequenceNumber$p().next();
            r4.setAtomicOp(this);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public long getOpSequence() {
            return this.opSequence;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public Object prepare(Object r3) {
            if (r3 != null) goto L12;
            Object r0 = prepareSelectOp();
            if (r0 == null) goto L12;
            return r0;
        L12:
            return this.desc.prepare(this);
        L8:
            th = move-exception;
            if (r3 != null) goto L11;
            undoPrepare();
        L11:
            throw th;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public void complete(Object r1, Object r2) {
            completeSelect(r2);
            this.desc.complete(this, r2);
        }

        private final Object prepareSelectOp() {
            SelectBuilderImpl<?> r0 = this.impl;
        L3:
            Object r1 = r0._state;
            if (r1 == this) goto L5;
            if ((r1 instanceof OpDescriptor) == true) goto L8;
            if (r1 != SelectKt.getNOT_SELECTED()) goto L15;
            SelectBuilderImpl<?> r2 = this.impl;
            if (b0$$ExternalSyntheticBackport0.m(SelectBuilderImpl._state$FU, r2, SelectKt.getNOT_SELECTED(), this) == false) goto L3;
            return null;
        L15:
            return SelectKt.getALREADY_SELECTED();
        L8:
            ((OpDescriptor) r1).perform(this.impl);
            goto L3
        L5:
            return null;
        }

        private final void undoPrepare() {
            SelectBuilderImpl<?> r0 = this.impl;
            b0$$ExternalSyntheticBackport0.m(SelectBuilderImpl._state$FU, r0, this, SelectKt.getNOT_SELECTED());
        }

        private final void completeSelect(Object r4) {
            if (r4 != null) goto L4;
            boolean r5 = true;
        L5:
            if (r5 == false) goto L7;
            Object r0 = null;
        L8:
            SelectBuilderImpl<?> r1 = this.impl;
            if (b0$$ExternalSyntheticBackport0.m(SelectBuilderImpl._state$FU, r1, this, r0) == false) goto L13;
            if (r5 == false) goto L14;
            SelectBuilderImpl.access$doAfterSelect(this.impl);
            return;
        L14:
            return;
        L13:
            return;
        L7:
            r0 = SelectKt.getNOT_SELECTED();
            goto L8
        L4:
            r5 = false;
            goto L5
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public String toString() {
            return "AtomicSelectOp(sequence=" + getOpSequence() + ')';
        }
    }

    /* JADX INFO: compiled from: Select.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$DisposeNode;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "handle", "Lkotlinx/coroutines/DisposableHandle;", "(Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class DisposeNode extends LockFreeLinkedListNode {
        public final DisposableHandle handle;

        public DisposeNode(DisposableHandle r1) {
            this.handle = r1;
        }
    }

    /* JADX INFO: compiled from: Select.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$PairSelectOp;", "Lkotlinx/coroutines/internal/OpDescriptor;", "otherOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)V", "atomicOp", "Lkotlinx/coroutines/internal/AtomicOp;", "getAtomicOp", "()Lkotlinx/coroutines/internal/AtomicOp;", "perform", "", "affected", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private static final class PairSelectOp extends OpDescriptor {
        public final LockFreeLinkedListNode.PrepareOp otherOp;

        public PairSelectOp(LockFreeLinkedListNode.PrepareOp r1) {
            this.otherOp = r1;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public Object perform(Object r4) {
            if (r4 == null) goto L10;
            SelectBuilderImpl r5 = (SelectBuilderImpl) r4;
            this.otherOp.finishPrepare();
            Object r0 = this.otherOp.getAtomicOp().decide(null);
            if (r0 != null) goto L6;
            Object r1 = this.otherOp.desc;
        L7:
            b0$$ExternalSyntheticBackport0.m(SelectBuilderImpl._state$FU, r5, this, r1);
            return r0;
        L6:
            r1 = SelectKt.getNOT_SELECTED();
            goto L7
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public AtomicOp<?> getAtomicOp() {
            return this.otherOp.getAtomicOp();
        }
    }

    /* JADX INFO: compiled from: Select.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/selects/SelectBuilderImpl$SelectOnCancelling;", "Lkotlinx/coroutines/JobCancellingNode;", "(Lkotlinx/coroutines/selects/SelectBuilderImpl;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    private final class SelectOnCancelling extends JobCancellingNode {
        final /* synthetic */ SelectBuilderImpl<R> this$0;

        public SelectOnCancelling(SelectBuilderImpl r1) {
            this.this$0 = r1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable r1) {
            invoke2(r1);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(Throwable r1) {
            if (this.this$0.trySelect() == false) goto L6;
            this.this$0.resumeSelectWithException(getJob().getCancellationException());
            return;
        }
    }

    static {
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_state");
        _result$FU = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_result");
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public static final /* synthetic */ void access$doAfterSelect(SelectBuilderImpl r0) {
        r0.doAfterSelect();
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> r1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> r2) {
        SelectBuilder.DefaultImpls.invoke(this, r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectBuilderImpl(Continuation<? super R> r1) {
        this.uCont = r1;
        this._state = SelectKt.getNOT_SELECTED();
        this._result = SelectKt.access$getUNDECIDED$p();
        this._parentHandle = null;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<R> r1 = this.uCont;
        if ((r1 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r1;
    }

    private final DisposableHandle getParentHandle() {
        return (DisposableHandle) this._parentHandle;
    }

    private final void setParentHandle(DisposableHandle r1) {
        this._parentHandle = r1;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.uCont.getContext();
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public Continuation<R> getCompletion() {
        return this;
    }

    private final void doResume(Function0<? extends Object> r4, Function0<Unit> r5) {
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L9;
        if (isSelected() == true) goto L9;
        throw new AssertionError();
    L9:
        Object r0 = this._result;
        if (r0 == SelectKt.access$getUNDECIDED$p()) goto L11;
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        if (b0$$ExternalSyntheticBackport0.m(_result$FU, this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), SelectKt.access$getRESUMED$p()) == false) goto L9;
        r5.invoke();
        return;
    L21:
        throw new IllegalStateException("Already resumed");
    L11:
        Object r1 = r4.invoke();
        if (b0$$ExternalSyntheticBackport0.m(_result$FU, this, SelectKt.access$getUNDECIDED$p(), r1) == false) goto L9;
    }

    public final Object getResult() {
        if (isSelected() == true) goto L5;
        initCancellability();
    L5:
        Object r0 = this._result;
        if (r0 != SelectKt.access$getUNDECIDED$p()) goto L13;
        if (b0$$ExternalSyntheticBackport0.m(_result$FU, this, SelectKt.access$getUNDECIDED$p(), IntrinsicsKt.getCOROUTINE_SUSPENDED()) == true) goto L10;
        r0 = this._result;
        goto L13
    L10:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L13:
        if (r0 == SelectKt.access$getRESUMED$p()) goto L20;
        if ((r0 instanceof CompletedExceptionally) == true) goto L18;
        return r0;
    L18:
        throw ((CompletedExceptionally) r0).cause;
    L20:
        throw new IllegalStateException("Already resumed");
    }

    private final void initCancellability() {
        Job r1 = (Job) getContext().get(Job.Key);
        if (r1 != null) goto L5;
        return;
    L5:
        DisposableHandle r0 = Job.DefaultImpls.invokeOnCompletion$default(r1, true, false, new SelectOnCancelling(this), 2, null);
        setParentHandle(r0);
        if (isSelected() == false) goto L9;
        r0.dispose();
        return;
    }

    public final void handleBuilderException(Throwable r3) {
        if (trySelect() == false) goto L6;
        Result.Companion r0 = Result.Companion;
        resumeWith(Result.m774constructorimpl(ResultKt.createFailure(r3)));
        return;
    L6:
        if ((r3 instanceof CancellationException) == true) goto L21;
        Object r1 = getResult();
        if ((r1 instanceof CompletedExceptionally) == false) goto L18;
        Throwable r2 = ((CompletedExceptionally) r1).cause;
        if (DebugKt.getRECOVER_STACK_TRACES() == false) goto L14;
        r2 = StackTraceRecoveryKt.unwrapImpl(r2);
    L14:
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L16;
        Throwable r4 = r3;
    L17:
        if (r2 != r4) goto L18;
        return;
    L16:
        r4 = StackTraceRecoveryKt.unwrapImpl(r3);
    L18:
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), r3);
        return;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void disposeOnSelect(DisposableHandle r3) {
        DisposeNode r0 = new DisposeNode(r3);
        if (isSelected() == true) goto L7;
        addLast(r0);
        if (isSelected() == true) goto L7;
        return;
    L7:
        r3.dispose();
    }

    private final void doAfterSelect() {
        DisposableHandle r0 = getParentHandle();
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        SelectBuilderImpl<R> r2 = this;
        LockFreeLinkedListNode r1 = (LockFreeLinkedListNode) r2.getNext();
    L7:
        if (Intrinsics.areEqual(r1, r2) == true) goto L12;
        if ((r1 instanceof DisposeNode) == false) goto L11;
        ((DisposeNode) r1).handle.dispose();
    L11:
        r1 = r1.getNextNode();
        goto L7
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect() {
        Object r3 = trySelectOther(null);
        if (r3 != CancellableContinuationImplKt.RESUME_TOKEN) goto L5;
        return true;
    L5:
        if (r3 != null) goto L9;
        return false;
    L9:
        throw new IllegalStateException(("Unexpected trySelectIdempotent result " + r3).toString());
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public Object performAtomicTrySelect(AtomicDesc r2) {
        return new AtomicSelectOp(this, r2).perform(null);
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return "SelectInstance(state=" + this._state + ", result=" + this._result + ')';
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(SelectClause0 r1, Function1<? super Continuation<? super R>, ? extends Object> r2) {
        r1.registerSelectClause0(this, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(SelectClause1<? extends Q> r1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> r2) {
        r1.registerSelectClause1(this, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(SelectClause2<? super P, ? extends Q> r1, P r2, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> r3) {
        r1.registerSelectClause2(this, r2, r3);
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void onTimeout(long r3, final Function1<? super Continuation<? super R>, ? extends Object> r5) {
        if (r3 <= 0) goto L5;
        Runnable r0 = new SelectBuilderImpl$onTimeout$$inlined$Runnable$1(this, r5);
        disposeOnSelect(DelayKt.getDelay(getContext()).invokeOnTimeout(r3, r0, getContext()));
        return;
    L5:
        if (trySelect() == false) goto L10;
        UndispatchedKt.startCoroutineUnintercepted(r5, getCompletion());
        return;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r4) {
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L9;
        if (isSelected() == true) goto L9;
        throw new AssertionError();
    L9:
        Object r0 = this._result;
        if (r0 == SelectKt.access$getUNDECIDED$p()) goto L11;
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
        if (b0$$ExternalSyntheticBackport0.m(_result$FU, this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), SelectKt.access$getRESUMED$p()) == false) goto L9;
        if (Result.m780isFailureimpl(r4) == false) goto L27;
        Continuation<R> r3 = this.uCont;
        Throwable r5 = Result.m777exceptionOrNullimpl(r4);
        Intrinsics.checkNotNull(r5);
        Result.Companion r1 = Result.Companion;
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L23;
    L26:
        r3.resumeWith(Result.m774constructorimpl(ResultKt.createFailure(r5)));
        return;
    L23:
        if ((r3 instanceof CoroutineStackFrame) == false) goto L26;
        r5 = StackTraceRecoveryKt.access$recoverFromStackFrame(r5, (CoroutineStackFrame) r3);
        goto L26
    L27:
        this.uCont.resumeWith(r4);
        return;
    L30:
        throw new IllegalStateException("Already resumed");
    L11:
        Object r2 = CompletionStateKt.toState$default(r4, null, 1, null);
        if (b0$$ExternalSyntheticBackport0.m(_result$FU, this, SelectKt.access$getUNDECIDED$p(), r2) == false) goto L9;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void resumeSelectWithException(Throwable r6) {
        if (DebugKt.getASSERTIONS_ENABLED() == false) goto L9;
        if (isSelected() == true) goto L9;
        throw new AssertionError();
    L9:
        Object r0 = this._result;
        if (r0 == SelectKt.access$getUNDECIDED$p()) goto L11;
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
        if (b0$$ExternalSyntheticBackport0.m(_result$FU, this, IntrinsicsKt.getCOROUTINE_SUSPENDED(), SelectKt.access$getRESUMED$p()) == false) goto L9;
        Continuation r5 = IntrinsicsKt.intercepted(this.uCont);
        Result.Companion r1 = Result.Companion;
        r5.resumeWith(Result.m774constructorimpl(ResultKt.createFailure(r6)));
        return;
    L28:
        throw new IllegalStateException("Already resumed");
    L11:
        Continuation<R> r2 = this.uCont;
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L14;
    L17:
        Throwable r3 = r6;
    L18:
        CompletedExceptionally r4 = new CompletedExceptionally(r3, false, 2, null);
        if (b0$$ExternalSyntheticBackport0.m(_result$FU, this, SelectKt.access$getUNDECIDED$p(), r4) == false) goto L9;
        return;
    L14:
        if ((r2 instanceof CoroutineStackFrame) == false) goto L17;
        r3 = StackTraceRecoveryKt.access$recoverFromStackFrame(r6, (CoroutineStackFrame) r2);
        goto L18
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean isSelected() {
    L2:
        Object r0 = this._state;
        if (r0 == SelectKt.getNOT_SELECTED()) goto L4;
        if ((r0 instanceof OpDescriptor) == false) goto L9;
        ((OpDescriptor) r0).perform(this);
        goto L2
    L9:
        return true;
    L4:
        return false;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public Object trySelectOther(LockFreeLinkedListNode.PrepareOp r4) {
    L2:
        Object r0 = this._state;
        if (r0 == SelectKt.getNOT_SELECTED()) goto L4;
        if ((r0 instanceof OpDescriptor) == false) goto L30;
        if (r4 == null) goto L29;
        AtomicOp<?> r1 = r4.getAtomicOp();
        if ((r1 instanceof AtomicSelectOp) == false) goto L26;
        if (((AtomicSelectOp) r1).impl != this) goto L26;
        throw new IllegalStateException("Cannot use matching select clauses on the same object".toString());
    L26:
        if (r1.isEarlierThan((OpDescriptor) r0) == false) goto L29;
        return AtomicKt.RETRY_ATOMIC;
    L29:
        ((OpDescriptor) r0).perform(this);
        goto L2
    L30:
        if (r4 != null) goto L33;
        return null;
    L33:
        if (r0 == r4.desc) goto L35;
        return null;
    L35:
        return CancellableContinuationImplKt.RESUME_TOKEN;
    L4:
        if (r4 == null) goto L6;
        PairSelectOp r2 = new PairSelectOp(r4);
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, SelectKt.getNOT_SELECTED(), r2) == false) goto L2;
        Object r5 = r2.perform(this);
        if (r5 == null) goto L13;
        return r5;
    L13:
        doAfterSelect();
        return CancellableContinuationImplKt.RESUME_TOKEN;
    L6:
        if (b0$$ExternalSyntheticBackport0.m(_state$FU, this, SelectKt.getNOT_SELECTED(), null) == true) goto L13;
        goto L13
    }
}
