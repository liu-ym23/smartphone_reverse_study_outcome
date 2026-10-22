package kotlinx.coroutines.channels;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF}, m = "invokeSuspend")
final class BroadcastKt$broadcast$2 extends SuspendLambda implements Function2<ProducerScope<Object>, Continuation<? super Unit>, Object> {
    public ProducerScope i;
    public Object j;
    public ChannelIterator k;
    public int l;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r1, Continuation r2) {
        throw null;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003d -> B:16:0x0040). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r6) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.l;
        if (r1 != 0) goto L5;
        ResultKt.b(r6);
        throw null;
    L5:
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ChannelIterator r2 = this.k;
        ProducerScope r4 = this.i;
        ResultKt.b(r6);
    L16:
        this.i = r4;
        this.j = r2;
        this.l = 1;
        r6 = r2.a(this);
        if (r6 != r0) goto L12;
        return r0;
    L12:
        if (((Boolean) r6).booleanValue() == false) goto L20;
        Object r7 = r2.next();
        this.i = r4;
        this.j = r7;
        this.k = r2;
        this.l = 2;
        if (r4.I(r7, this) != r0) goto L16;
        return r0;
    L20:
        return Unit.f330a;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r2 = (ChannelIterator) this.j;
        r4 = this.i;
        ResultKt.b(r6);
        goto L12
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((BroadcastKt$broadcast$2) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}
