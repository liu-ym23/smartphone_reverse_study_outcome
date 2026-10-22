package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectBuilderImpl;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Delay.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {222, 355}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue", "timeoutMillis"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
final class FlowKt__DelayKt$debounceInternal$1<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T> $this_debounceInternal;
    final /* synthetic */ Function1<T, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> r1, Flow<? extends T> r2, Continuation<? super FlowKt__DelayKt$debounceInternal$1> r3) {
        this.$timeoutMillisSelector = r1;
        this.$this_debounceInternal = r2;
        super(3, r3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Object r2, Continuation<? super Unit> r3) {
        return invoke(r1, (FlowCollector) r2, r3);
    }

    public final Object invoke(CoroutineScope r3, FlowCollector<? super T> r4, Continuation<? super Unit> r5) {
        FlowKt__DelayKt$debounceInternal$1 r0 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, r5);
        r0.L$0 = r3;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x013a -> B:62:0x013c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        FlowKt__DelayKt$debounceInternal$1<T> r0 = this;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        int r4 = 2;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        Ref.LongRef r3 = (Ref.LongRef) r0.L$3;
        Ref.ObjectRef r5 = (Ref.ObjectRef) r0.L$2;
        ReceiveChannel r9 = (ReceiveChannel) r0.L$1;
        FlowCollector r10 = (FlowCollector) r0.L$0;
        ResultKt.throwOnFailure(r18);
        FlowCollector r11 = r10;
        ReceiveChannel r12 = r9;
        Ref.ObjectRef r13 = r5;
    L62:
        r4 = 2;
    L12:
        if (r13.element == NullSurrogateKt.DONE) goto L64;
        Ref.LongRef r6 = new Ref.LongRef();
        if (r13.element == null) goto L32;
        Function1<T, Long> r14 = r0.$timeoutMillisSelector;
        Symbol r15 = NullSurrogateKt.NULL;
        T r16 = r13.element;
        if (r16 != r15) goto L18;
        r16 = null;
    L18:
        r6.element = r14.invoke(r16).longValue();
        if (r6.element < 0) goto L21;
        boolean r17 = true;
    L22:
        if (r17 == false) goto L34;
        if (r6.element != 0) goto L32;
        Symbol r19 = NullSurrogateKt.NULL;
        T r110 = r13.element;
        if (r110 != r19) goto L28;
        r110 = null;
    L28:
        r0.L$0 = r11;
        r0.L$1 = r12;
        r0.L$2 = r13;
        r0.L$3 = r6;
        r0.label = 1;
        if (r11.emit(r110, r0) != r1) goto L31;
        return r1;
    L31:
        r13.element = null;
        goto L32
    L34:
        throw new IllegalArgumentException("Debounce timeout should not be negative".toString());
    L21:
        r17 = false;
    L32:
        Object r111 = r1;
        FlowKt__DelayKt$debounceInternal$1<T> r7 = r0;
        Ref.LongRef r8 = r6;
        if (DebugKt.getASSERTIONS_ENABLED() == true) goto L38;
    L48:
        r7.L$0 = r11;
        r7.L$1 = r12;
        r7.L$2 = r13;
        r7.L$3 = r8;
        r7.label = r4;
        FlowKt__DelayKt$debounceInternal$1<T> r112 = r7;
        SelectBuilderImpl r113 = new SelectBuilderImpl(r112);
        SelectBuilderImpl r114 = r113;     // Catch: Throwable -> L54
        if (r13.element == null) goto L52;
        r114.onTimeout(r8.element, new FlowKt__DelayKt$debounceInternal$1$3$1(r11, r13, null));     // Catch: Throwable -> L54
    L52:
        r114.invoke(r12.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(r13, r11, null));     // Catch: Throwable -> L54
    L56:
        Object r20 = r113.getResult();
        if (r20 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L59;
        DebugProbesKt.probeCoroutineSuspended(r112);
    L59:
        if (r20 != r111) goto L61;
        return r111;
    L61:
        r0 = r7;
        r1 = r111;
    L54:
        th = move-exception;
        r113.handleBuilderException(th);
        goto L56
    L38:
        if (r13.element != null) goto L40;
    L43:
        boolean r115 = true;
    L44:
        if (r115 == true) goto L48;
        throw new AssertionError();
    L40:
        if (r8.element > 0) goto L43;
        r115 = false;
        goto L44
    L64:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r6 = (Ref.LongRef) r0.L$3;
        r13 = (Ref.ObjectRef) r0.L$2;
        r12 = (ReceiveChannel) r0.L$1;
        r11 = (FlowCollector) r0.L$0;
        ResultKt.throwOnFailure(r18);
        goto L31
    L10:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r21 = (CoroutineScope) r0.L$0;
        FlowCollector r22 = (FlowCollector) r0.L$1;
        r11 = r22;
        r12 = ProduceKt.produce$default(r21, null, 0, new FlowKt__DelayKt$debounceInternal$1$values$1(r0.$this_debounceInternal, null), 3, null);
        r13 = new Ref.ObjectRef();
        goto L12
    }
}
