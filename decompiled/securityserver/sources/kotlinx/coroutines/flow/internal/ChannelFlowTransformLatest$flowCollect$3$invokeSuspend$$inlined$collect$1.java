package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 implements FlowCollector<Object> {
    public final /* synthetic */ ChannelFlowTransformLatest$flowCollect$3 b;
    public final /* synthetic */ CoroutineScope c;
    public final /* synthetic */ Ref.ObjectRef e;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1", f = "Merge.kt", l = {135}, m = "emit")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 j;
        public ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 k;
        public Object l;
        public Object m;
        public Job n;
        public Job o;

        public AnonymousClass1(ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 r1, Continuation r2) {
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

    public ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1(ChannelFlowTransformLatest$flowCollect$3 r1, CoroutineScope r2, Ref.ObjectRef r3) {
        this.b = r1;
        this.c = r2;
        this.e = r3;
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
        r5 = r0.m;
        ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1 this = r0.k;
        ResultKt.b(r7);
    L19:
        Ref.ObjectRef r8 = this.e;
        CoroutineStart r4 = CoroutineStart.f;
        ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1 r9 = new ChannelFlowTransformLatest$flowCollect$3$invokeSuspend$$inlined$collect$1$lambda$1(r5, null, this);
        r8.b = BuildersKt.a(this.c, r4, r9, 1);
        return Unit.f330a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.b(r7);
        Job r10 = (Job) this.e.b;
        if (r10 == null) goto L19;
        r10.a(new ChildCancelledException());
        r0.k = this;
        r0.l = r5;
        r0.getClass();
        r0.m = r5;
        r0.n = r10;
        r0.o = r10;
        r0.i = 1;
        if (r10.o(r0) != r2) goto L19;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }
}
