package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.sync.Semaphore;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ChannelFlowMerge$collectTo$$inlined$collect$1 implements FlowCollector<Flow<Object>> {
    public final /* synthetic */ Job b;
    public final /* synthetic */ Semaphore c;
    public final /* synthetic */ ProducerScope e;
    public final /* synthetic */ SendingCollector f;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1$1, reason: invalid class name */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$$inlined$collect$1", f = "Merge.kt", l = {134}, m = "emit")
    public final class AnonymousClass1 extends ContinuationImpl {
        public /* synthetic */ Object f;
        public int i;
        public final /* synthetic */ ChannelFlowMerge$collectTo$$inlined$collect$1 j;
        public ChannelFlowMerge$collectTo$$inlined$collect$1 k;
        public Object l;
        public Flow m;

        public AnonymousClass1(ChannelFlowMerge$collectTo$$inlined$collect$1 r1, Continuation r2) {
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

    public ChannelFlowMerge$collectTo$$inlined$collect$1(Job r1, Semaphore r2, ProducerScope r3, SendingCollector r4) {
        this.b = r1;
        this.c = r2;
        this.e = r3;
        this.f = r4;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object d(Object r6, Continuation r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
        int r1 = r0.i;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.i = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.f;
        CoroutineSingletons r2 = CoroutineSingletons.b;
        int r3 = r0.i;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Flow r5 = r0.m;
        ChannelFlowMerge$collectTo$$inlined$collect$1 r9 = r0.k;
        ResultKt.b(r8);
        Flow r10 = r5;
        ChannelFlowMerge$collectTo$$inlined$collect$1 this = r9;
    L24:
        BuildersKt.a(this.e, null, new ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1(r10, null, this), 3);
        return Unit.f330a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.b(r8);
        r10 = (Flow) r6;
        Job r4 = this.b;
        if (r4 != null) goto L17;
    L21:
        r0.k = this;
        r0.l = r6;
        r0.getClass();
        r0.m = r10;
        r0.i = 1;
        if (this.c.a(r0) != r2) goto L24;
        return r2;
    L17:
        if (r4.isActive() == true) goto L21;
        throw r4.q();
    L7:
        r0 = new AnonymousClass1(this, r7);
        goto L8
    }
}
