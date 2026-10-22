package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequenceScope;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/Job;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {952, 954}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Job>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ JobSupport this$0;

    JobSupport$children$1(JobSupport r1, Continuation<? super JobSupport$children$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        JobSupport$children$1 r0 = new JobSupport$children$1(this.this$0, r3);
        r0.L$0 = r2;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super Job> r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super Job> r1, Continuation<? super Unit> r2) {
        return ((JobSupport$children$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006b -> B:27:0x0081). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007e -> B:27:0x0081). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        LockFreeLinkedListNode r2 = (LockFreeLinkedListNode) this.L$2;
        LockFreeLinkedListHead r3 = (LockFreeLinkedListHead) this.L$1;
        SequenceScope r4 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r7);
    L27:
        r2 = r2.getNextNode();
    L21:
        if (Intrinsics.areEqual(r2, r3) == true) goto L29;
        if ((r2 instanceof ChildHandleNode) == false) goto L27;
        ChildJob r8 = ((ChildHandleNode) r2).childJob;
        this.L$0 = r4;
        this.L$1 = r3;
        this.L$2 = r2;
        this.label = 2;
        if (r4.yield(r8, this) != r0) goto L27;
        return r0;
    L29:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        goto L29
    L10:
        ResultKt.throwOnFailure(r7);
        SequenceScope r9 = (SequenceScope) this.L$0;
        Object r5 = this.this$0.getState$kotlinx_coroutines_core();
        if ((r5 instanceof ChildHandleNode) == false) goto L16;
        this.label = 1;
        if (r9.yield(((ChildHandleNode) r5).childJob, this) != r0) goto L29;
        return r0;
    L16:
        if ((r5 instanceof Incomplete) == false) goto L29;
        NodeList r6 = ((Incomplete) r5).getList();
        if (r6 == null) goto L29;
        NodeList r10 = r6;
        LockFreeLinkedListNode r11 = (LockFreeLinkedListNode) r10.getNext();
        r4 = r9;
        r3 = r10;
        r2 = r11;
        goto L21
    }
}
