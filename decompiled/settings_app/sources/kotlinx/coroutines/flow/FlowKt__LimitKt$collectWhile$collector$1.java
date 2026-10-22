package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Limit.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 176)
public final class FlowKt__LimitKt$collectWhile$collector$1<T> implements FlowCollector<T> {
    final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> $predicate;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__LimitKt$collectWhile$collector$1(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r1) {
        this.$predicate = r1;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object emit(T r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof FlowKt__LimitKt$collectWhile$collector$1$emit$1) == false) goto L7;
        FlowKt__LimitKt$collectWhile$collector$1$emit$1 r0 = (FlowKt__LimitKt$collectWhile$collector$1$emit$1) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        FlowKt__LimitKt$collectWhile$collector$1<T> this = (FlowKt__LimitKt$collectWhile$collector$1) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L18:
        if (((Boolean) r7).booleanValue() == false) goto L22;
        return Unit.INSTANCE;
    L22:
        throw new AbortFlowException(this);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        Function2<T, Continuation<? super Boolean>, Object> r8 = this.$predicate;
        r0.L$0 = this;
        r0.label = 1;
        r7 = r8.invoke(r5, r0);
        if (r7 != r1) goto L18;
        return r1;
    L7:
        r0 = new FlowKt__LimitKt$collectWhile$collector$1$emit$1(this, r6);
        goto L8
    }

    public Object emit$$forInline(T r2, Continuation<? super Unit> r3) {
        InlineMarker.mark(4);
        new FlowKt__LimitKt$collectWhile$collector$1$emit$1(this, r3);
        InlineMarker.mark(5);
        if (((Boolean) this.$predicate.invoke(r2, r3)).booleanValue() == false) goto L7;
        return Unit.INSTANCE;
    L7:
        throw new AbortFlowException(this);
    }
}
