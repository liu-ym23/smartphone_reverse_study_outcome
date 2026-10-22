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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class FlowKt__LimitKt$drop$2$1<T> implements FlowCollector {
    final /* synthetic */ int $count;
    final /* synthetic */ Ref.IntRef $skipped;
    final /* synthetic */ FlowCollector<T> $this_unsafeFlow;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__LimitKt$drop$2$1(Ref.IntRef r1, int r2, FlowCollector<? super T> r3) {
        this.$skipped = r1;
        this.$count = r2;
        this.$this_unsafeFlow = r3;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof FlowKt__LimitKt$drop$2$1$emit$1) == false) goto L7;
        FlowKt__LimitKt$drop$2$1$emit$1 r0 = (FlowKt__LimitKt$drop$2$1$emit$1) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L20:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        if (this.$skipped.element < this.$count) goto L21;
        FlowCollector<T> r4 = this.$this_unsafeFlow;
        r0.label = 1;
        if (r4.emit(r5, r0) != r1) goto L20;
        return r1;
    L21:
        this.$skipped.element++;
        int r8 = this.$skipped.element;
        return Unit.INSTANCE;
    L7:
        r0 = new FlowKt__LimitKt$drop$2$1$emit$1(this, r6);
        goto L8
    }
}
