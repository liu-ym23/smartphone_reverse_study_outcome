package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Delay.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "Lkotlinx/coroutines/channels/ChannelResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1", f = "Delay.kt", i = {0}, l = {394}, m = "invokeSuspend", n = {"$this$onSuccess_u2dWpGqRn0$iv"}, s = {"L$0"})
final class FlowKt__DelayKt$timeoutInternal$1$1$1<T> extends SuspendLambda implements Function2<ChannelResult<? extends T>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ FlowCollector<T> $downStream;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__DelayKt$timeoutInternal$1$1$1(FlowCollector<? super T> r1, Continuation<? super FlowKt__DelayKt$timeoutInternal$1$1$1> r2) {
        this.$downStream = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        FlowKt__DelayKt$timeoutInternal$1$1$1 r0 = new FlowKt__DelayKt$timeoutInternal$1$1$1(this.$downStream, r3);
        r0.L$0 = r2;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Boolean> r2) {
        return m3051invokeWpGqRn0(((ChannelResult) r1).m3034unboximpl(), r2);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m3051invokeWpGqRn0(Object r1, Continuation<? super Boolean> r2) {
        return ((FlowKt__DelayKt$timeoutInternal$1$1$1) create(ChannelResult.m3022boximpl(r1), r2)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1<T> for r4v10 'this'  kotlin.coroutines.Continuation
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r4.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        java.lang.Object r4 = r4.L$0;
        kotlin.ResultKt.throwOnFailure(r5);
    L14:
        java.lang.Object r5 = r4;
    L15:
        boolean r4 = r5 instanceof kotlinx.coroutines.channels.ChannelResult.Closed;
        if (r4 == false) goto L19;
        kotlinx.coroutines.channels.ChannelResult.m3026exceptionOrNullimpl(r5);
        java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false);
        return r4;
    L19:
        java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true);
        return r4;
    L6:
        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r4;
    L8:
        kotlin.ResultKt.throwOnFailure(r5);
        java.lang.Object r5 = r4.L$0;
        kotlinx.coroutines.channels.ChannelResult r5 = (kotlinx.coroutines.channels.ChannelResult) r5;
        r5 = r5.m3034unboximpl();
        kotlinx.coroutines.flow.FlowCollector<T> r1 = r4.$downStream;
        boolean r3 = r5 instanceof kotlinx.coroutines.channels.ChannelResult.Failed;
        if (r3 == true) goto L15;
        r4.L$0 = r5;
        r4.label = 1;
        T r5 = (T) r5;
        kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r4;
        java.lang.Object r4 = r1.emit(r5, r4);
        if (r4 != r0) goto L13;
        return r0;
    L13:
        r4 = r5;
        goto L14
    }
}
