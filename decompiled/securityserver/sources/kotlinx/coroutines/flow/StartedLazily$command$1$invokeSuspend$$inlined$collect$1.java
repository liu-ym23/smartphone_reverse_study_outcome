package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class StartedLazily$command$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Integer> {
    public final /* synthetic */ FlowCollector b;
    public final /* synthetic */ Ref.BooleanRef c;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1$invokeSuspend$$inlined$collect$1", f = "SharingStarted.kt", l = {135}, m = "emit")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ StartedLazily$command$1$invokeSuspend$$inlined$collect$1 j;
        public Object k;

        public AnonymousClass1(StartedLazily$command$1$invokeSuspend$$inlined$collect$1 r1, Continuation r2) {
            this.j = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r2) {
            this.f = r2;
            this.i |= Integer.MIN_VALUE;
            return this.j.d(null, this);
        }
    }

    public StartedLazily$command$1$invokeSuspend$$inlined$collect$1(FlowCollector r1, Ref.BooleanRef r2) {
        this.b = r1;
        this.c = r2;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r5, Continuation r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = r0.i;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.b(r7);
    L22:
        return Unit.f330a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.b(r7);
        if (((Number) r5).intValue() <= 0) goto L22;
        Ref.BooleanRef r8 = this.c;
        if (r8.b == true) goto L22;
        r8.b = true;
        SharingCommand r9 = SharingCommand.b;
        r0.getClass();
        r0.k = r5;
        r0.getClass();
        r0.i = 1;
        if (this.b.d(r9, r0) != r2) goto L22;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }
}
