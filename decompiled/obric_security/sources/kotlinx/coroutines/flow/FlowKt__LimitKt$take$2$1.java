package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: Limit.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class FlowKt__LimitKt$take$2$1<T> implements FlowCollector {
    final /* synthetic */ Ref.IntRef $consumed;
    final /* synthetic */ int $count;
    final /* synthetic */ FlowCollector<T> $this_unsafeFlow;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__LimitKt$take$2$1(Ref.IntRef r1, int r2, FlowCollector<? super T> r3) {
        this.$consumed = r1;
        this.$count = r2;
        this.$this_unsafeFlow = r3;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof FlowKt__LimitKt$take$2$1$emit$1) == false) goto L7;
        FlowKt__LimitKt$take$2$1$emit$1 r0 = (FlowKt__LimitKt$take$2$1$emit$1) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r8);
    L27:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r8);
    L22:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r8);
        this.$consumed.element++;
        if (this.$consumed.element >= this.$count) goto L23;
        FlowCollector<T> r5 = this.$this_unsafeFlow;
        r0.label = 1;
        if (r5.emit(r6, r0) != r1) goto L22;
        return r1;
    L23:
        FlowCollector<T> r9 = this.$this_unsafeFlow;
        r0.label = 2;
        if (FlowKt__LimitKt.access$emitAbort$FlowKt__LimitKt(r9, r6, r0) != r1) goto L27;
        return r1;
    L7:
        r0 = new FlowKt__LimitKt$take$2$1$emit$1(this, r7);
        goto L8
    }
}
