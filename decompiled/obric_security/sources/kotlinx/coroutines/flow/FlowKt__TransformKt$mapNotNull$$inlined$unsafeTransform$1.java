package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: SafeCollector.common.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1"}, k = 1, mv = {1, 6, 0}, xi = 176)
public final class FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1<R> implements Flow<R> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ Function2 $transform$inlined$1;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: Emitters.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ FlowCollector $this_unsafeFlow;
        final /* synthetic */ Function2 $transform$inlined;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Emitters.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0}, l = {223, 224}, m = "emit", n = {"$this$mapNotNull_u24lambda_u2d5"}, s = {"L$0"})
        public static final class AnonymousClass1 extends ContinuationImpl {
            Object L$0;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ AnonymousClass2 this$0;

            public AnonymousClass1(AnonymousClass2 r1, Continuation r2) {
                this.this$0 = r1;
                super(r2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                this.result = r2;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        }

        public AnonymousClass2(FlowCollector r1, Function2 r2) {
            this.$this_unsafeFlow = r1;
            this.$transform$inlined = r2;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T r7, Continuation<? super Unit> r8) {
            if ((r8 instanceof AnonymousClass1) == false) goto L7;
            AnonymousClass1 r0 = (AnonymousClass1) r8;
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r9 = r0.result;
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L16;
            if (r2 == 1) goto L15;
            if (r2 != 2) goto L14;
            ResultKt.throwOnFailure(r9);
        L26:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            FlowCollector r6 = (FlowCollector) r0.L$0;
            ResultKt.throwOnFailure(r9);
            FlowCollector r10 = r6;
        L20:
            if (r9 == null) goto L26;
            r0.L$0 = null;
            r0.label = 2;
            if (r10.emit(r9, r0) != r1) goto L26;
            return r1;
        L16:
            ResultKt.throwOnFailure(r9);
            FlowCollector r11 = this.$this_unsafeFlow;
            Function2 r12 = this.$transform$inlined;
            r0.L$0 = r11;
            r0.label = 1;
            Object r13 = r12.invoke(r7, r0);
            if (r13 != r1) goto L19;
            return r1;
        L19:
            r9 = r13;
            r10 = r11;
        L7:
            r0 = new AnonymousClass1(this, r8);
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Object emit$$forInline(Object r2, Continuation r3) {
            InlineMarker.mark(4);
            new AnonymousClass1(this, r3);
            InlineMarker.mark(5);
            FlowCollector r0 = this.$this_unsafeFlow;
            Object r1 = this.$transform$inlined.invoke(r2, r3);
            if (r1 == null) goto L6;
            InlineMarker.mark(0);
            r0.emit(r1, r3);
            InlineMarker.mark(1);
        L6:
            return Unit.INSTANCE;
        }
    }

    public FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1(Flow r1, Function2 r2) {
        this.$this_unsafeTransform$inlined = r1;
        this.$transform$inlined$1 = r2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector r3, Continuation r4) {
        Object r2 = this.$this_unsafeTransform$inlined.collect(new AnonymousClass2(r3, this.$transform$inlined$1), r4);
        if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r2;
    L6:
        return Unit.INSTANCE;
    }

    public Object collect$$forInline(FlowCollector r3, final Continuation r4) {
        InlineMarker.mark(4);
        new AnonymousClass1(this, r4);
        InlineMarker.mark(5);
        Flow r0 = this.$this_unsafeTransform$inlined;
        AnonymousClass2 r1 = new AnonymousClass2(r3, this.$transform$inlined$1);
        InlineMarker.mark(0);
        r0.collect(r1, r4);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
