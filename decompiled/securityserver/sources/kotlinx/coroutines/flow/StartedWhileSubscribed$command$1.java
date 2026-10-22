package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", l = {179, 181, 183, 184, 186}, m = "invokeSuspend")
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
    public FlowCollector i;
    public int j;
    public FlowCollector k;
    public int l;
    public int m;
    public final /* synthetic */ StartedWhileSubscribed n;

    public StartedWhileSubscribed$command$1(StartedWhileSubscribed r1, Continuation r2) {
        this.n = r1;
        super(3, r2);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object b(Object r2, Object r3, Object r4) {
        int r5 = ((Number) r3).intValue();
        StartedWhileSubscribed r1 = this.n;
        StartedWhileSubscribed$command$1 r0 = new StartedWhileSubscribed$command$1(r1, (Continuation) r4);
        r0.i = (FlowCollector) r2;
        r0.j = r5;
        return r0.i(Unit.f330a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r9) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.m;
        StartedWhileSubscribed r7 = this.n;
        if (r1 == 0) goto L20;
        if (r1 == 1) goto L19;
        if (r1 != 2) goto L7;
        int r2 = this.l;
        FlowCollector r3 = this.k;
        ResultKt.b(r9);
    L29:
        r7.getClass();
    L30:
        SharingCommand r10 = SharingCommand.c;
        this.k = r3;
        this.l = r2;
        this.m = 5;
        if (r3.d(r10, this) != r0) goto L34;
        return r0;
    L34:
        return Unit.f330a;
    L7:
        if (r1 == 3) goto L14;
        if (r1 == 4) goto L13;
        if (r1 == 5) goto L19;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        r2 = this.l;
        r3 = this.k;
        ResultKt.b(r9);
        goto L30
    L14:
        r2 = this.l;
        FlowCollector r5 = this.k;
        ResultKt.b(r9);
        r7.getClass();
        this.k = r5;
        this.l = r2;
        this.m = 4;
        if (DelayKt.a(0, this) != r0) goto L17;
        return r0;
    L17:
        r3 = r5;
    L19:
        ResultKt.b(r9);
        goto L34
    L20:
        ResultKt.b(r9);
        FlowCollector r11 = this.i;
        r2 = this.j;
        if (r2 <= 0) goto L25;
        SharingCommand r4 = SharingCommand.b;
        this.k = r11;
        this.l = r2;
        this.m = 1;
        if (r11.d(r4, this) != r0) goto L34;
        return r0;
    L25:
        r7.getClass();
        this.k = r11;
        this.l = r2;
        this.m = 2;
        if (DelayKt.a(0, this) != r0) goto L28;
        return r0;
    L28:
        r3 = r11;
        goto L29
    }
}
