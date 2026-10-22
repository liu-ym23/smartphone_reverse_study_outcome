package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: Transform.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class FlowKt__TransformKt$withIndex$1$1<T> implements FlowCollector {
    final /* synthetic */ Ref.IntRef $index;
    final /* synthetic */ FlowCollector<IndexedValue<? extends T>> $this_unsafeFlow;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__TransformKt$withIndex$1$1(FlowCollector<? super IndexedValue<? extends T>> r1, Ref.IntRef r2) {
        this.$this_unsafeFlow = r1;
        this.$index = r2;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r7, Continuation<? super Unit> r8) {
        if ((r8 instanceof FlowKt__TransformKt$withIndex$1$1$emit$1) == false) goto L7;
        FlowKt__TransformKt$withIndex$1$1$emit$1 r0 = (FlowKt__TransformKt$withIndex$1$1$emit$1) r8;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L20:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        FlowCollector<IndexedValue<? extends T>> r10 = this.$this_unsafeFlow;
        int r4 = this.$index.element;
        this.$index.element = r4 + 1;
        if (r4 < 0) goto L22;
        IndexedValue<? extends T> r3 = new IndexedValue(r4, r7);
        r0.label = 1;
        if (r10.emit(r3, r0) != r1) goto L20;
        return r1;
    L22:
        throw new ArithmeticException("Index overflow has happened");
    L7:
        r0 = new FlowKt__TransformKt$withIndex$1$1$emit$1(this, r8);
        goto L8
    }
}
