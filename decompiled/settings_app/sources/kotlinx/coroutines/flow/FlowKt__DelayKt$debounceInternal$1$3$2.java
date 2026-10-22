package kotlinx.coroutines.flow;

import android.icu.lang.UCharacter;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: compiled from: Delay.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "Lkotlinx/coroutines/channels/ChannelResult;", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {0}, l = {UCharacter.UnicodeBlock.ORNAMENTAL_DINGBATS_ID}, m = "invokeSuspend", n = {"$this$onFailure_u2dWpGqRn0$iv"}, s = {"L$0"})
final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector<T> $downstream;
    final /* synthetic */ Ref.ObjectRef<Object> $lastValue;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__DelayKt$debounceInternal$1$3$2(Ref.ObjectRef<Object> r1, FlowCollector<? super T> r2, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$2> r3) {
        this.$lastValue = r1;
        this.$downstream = r2;
        super(2, r3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        FlowKt__DelayKt$debounceInternal$1$3$2 r0 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.$lastValue, this.$downstream, r4);
        r0.L$0 = r3;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ChannelResult<? extends Object> r1, Continuation<? super Unit> r2) {
        return m3049invokeWpGqRn0(r1.m3034unboximpl(), r2);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m3049invokeWpGqRn0(Object r1, Continuation<? super Unit> r2) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(ChannelResult.m3022boximpl(r1), r2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2 for r6v9 'this'  kotlin.coroutines.Continuation
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r6.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        java.lang.Object r6 = r6.L$1;
        kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6;
        kotlin.ResultKt.throwOnFailure(r7);
    L24:
        kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> r1 = r6;
    L25:
        kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.flow.internal.NullSurrogateKt.DONE;
        r1.element = r6;
    L27:
        kotlin.Unit r6 = kotlin.Unit.INSTANCE;
        return r6;
    L6:
        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r6;
    L8:
        kotlin.ResultKt.throwOnFailure(r7);
        java.lang.Object r7 = r6.L$0;
        kotlinx.coroutines.channels.ChannelResult r7 = (kotlinx.coroutines.channels.ChannelResult) r7;
        ?? r7 = r7.m3034unboximpl();
        kotlin.jvm.internal.Ref.ObjectRef<java.lang.Object> r1 = r6.$lastValue;
        boolean r3 = r7 instanceof kotlinx.coroutines.channels.ChannelResult.Failed;
        if (r3 == true) goto L11;
        r1.element = r7;
    L11:
        r1 = r6.$lastValue;
        kotlinx.coroutines.flow.FlowCollector<T> r4 = r6.$downstream;
        if (r3 == false) goto L27;
        java.lang.Throwable r3 = kotlinx.coroutines.channels.ChannelResult.m3026exceptionOrNullimpl(r7);
        if (r3 != null) goto L26;
        java.lang.Object r3 = r1.element;
        if (r3 == null) goto L25;
        kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL;
        java.lang.Object r5 = r1.element;
        if (r5 != r3) goto L20;
        r5 = null;
    L20:
        r6.L$0 = r7;
        r6.L$1 = r1;
        r6.label = 1;
        T r5 = (T) r5;
        kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r6;
        java.lang.Object r6 = r4.emit(r5, r6);
        if (r6 != r0) goto L23;
        return r0;
    L23:
        r6 = r1;
        goto L24
    L26:
        throw r3;
    }
}
