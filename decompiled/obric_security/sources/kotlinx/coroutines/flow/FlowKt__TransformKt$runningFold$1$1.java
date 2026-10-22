package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: Transform.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class FlowKt__TransformKt$runningFold$1$1<T> implements FlowCollector {
    final /* synthetic */ Ref.ObjectRef<R> $accumulator;
    final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;
    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__TransformKt$runningFold$1$1(Ref.ObjectRef<R> r1, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r2, FlowCollector<? super R> r3) {
        this.$accumulator = r1;
        this.$operation = r2;
        this.$this_unsafeFlow = r3;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof FlowKt__TransformKt$runningFold$1$1$emit$1) == false) goto L7;
        FlowKt__TransformKt$runningFold$1$1$emit$1 r0 = (FlowKt__TransformKt$runningFold$1$1$emit$1) r9;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r10);
    L24:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Ref.ObjectRef r7 = (Ref.ObjectRef) r0.L$1;
        FlowKt__TransformKt$runningFold$1$1<T> r11 = (FlowKt__TransformKt$runningFold$1$1) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L20:
        r7.element = (T) r10;
        FlowCollector<R> r12 = r11.$this_unsafeFlow;
        T r13 = r11.$accumulator.element;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        if (r12.emit((R) r13, r0) != r1) goto L24;
        return r1;
    L16:
        ResultKt.throwOnFailure(r10);
        Ref.ObjectRef r14 = this.$accumulator;
        Function3<R, T, Continuation<? super R>, Object> r3 = this.$operation;
        T r5 = r14.element;
        r0.L$0 = this;
        r0.L$1 = r14;
        r0.label = 1;
        Object r15 = r3.invoke((R) r5, r8, r0);
        if (r15 != r1) goto L19;
        return r1;
    L19:
        r11 = this;
        r7 = r14;
        r10 = (T) r15;
    L7:
        r0 = new FlowKt__TransformKt$runningFold$1$1$emit$1(this, r9);
        goto L8
    }
}
