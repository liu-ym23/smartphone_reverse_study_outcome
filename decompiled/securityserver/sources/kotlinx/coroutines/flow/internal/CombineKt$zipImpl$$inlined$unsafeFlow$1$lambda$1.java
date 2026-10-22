package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerCoroutine;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public CoroutineScope i;
    public CoroutineScope j;
    public ProducerCoroutine k;
    public CoroutineContext l;
    public Object m;
    public int n;
    public final /* synthetic */ FlowCollector o;
    public final /* synthetic */ CombineKt$zipImpl$$inlined$unsafeFlow$1 p;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1, reason: invalid class name */
    @Metadata
    final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object> {
        public ProducerScope i;
        public ProducerScope j;
        public int k;
        public final /* synthetic */ CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 l;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata
        public final class C00151 implements FlowCollector<Object> {
            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object d(Object r1, Continuation r2) {
                throw null;
            }
        }

        public AnonymousClass1(CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r1, Continuation r2) {
            this.l = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation f(Object r2, Continuation r3) {
            AnonymousClass1 r0 = new AnonymousClass1(this.l, r3);
            r0.i = (ProducerScope) r2;
            return r0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r3) {
            int r0 = this.k;
            if (r0 == 0) goto L9;
            if (r0 != 1) goto L8;
            ResultKt.b(r3);
            return Unit.f330a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.b(r3);
            ProducerScope r4 = this.i;
            this.l.p.getClass();
            this.j = r4;
            this.k = 1;
            throw null;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo7invoke(Object r1, Object r2) {
            AnonymousClass1 r0 = (AnonymousClass1) f(r1, (Continuation) r2);
            Unit r3 = Unit.f330a;
            r0.i(r3);
            return r3;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3, reason: invalid class name */
    @Metadata
    final class AnonymousClass3 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        public Unit i;
        public int j;
        public final /* synthetic */ CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 k;
        public final /* synthetic */ CoroutineContext l;
        public final /* synthetic */ Object m;
        public final /* synthetic */ ReceiveChannel n;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3$1, reason: invalid class name */
        @Metadata
        public final class AnonymousClass1 implements FlowCollector<Object> {

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3$1$1, reason: invalid class name and collision with other inner class name */
            @Metadata
            final class C00161 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
                public Unit i;
                public Object j;
                public int k;
                public final /* synthetic */ Object l;
                public final /* synthetic */ AnonymousClass1 m;

                public C00161(Object r1, Continuation r2, AnonymousClass1 r3) {
                    this.l = r1;
                    this.m = r3;
                    super(2, r2);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation f(Object r3, Continuation r4) {
                    Unit r5 = (Unit) r3;
                    return new C00161(this.l, r4, this.m);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object i(Object r4) {
                    int r0 = this.k;
                    if (r0 != 0) goto L5;
                    ResultKt.b(r4);
                    throw null;
                L5:
                    if (r0 != 1) goto L7;
                    ResultKt.b(r4);
                    if (r4 == null) goto L19;
                    throw null;
                L19:
                    throw null;
                L7:
                    if (r0 == 2) goto L13;
                    if (r0 != 3) goto L12;
                    ResultKt.b(r4);
                    return Unit.f330a;
                L12:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L13:
                    Object r1 = this.j;
                    Unit r2 = this.i;
                    ResultKt.b(r4);
                    this.i = r2;
                    this.j = r1;
                    this.k = 3;
                    throw null;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: invoke */
                public final Object mo7invoke(Object r1, Object r2) {
                    return ((C00161) f(r1, (Continuation) r2)).i(Unit.f330a);
                }
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object d(Object r1, Continuation r2) {
                throw null;
            }
        }

        public AnonymousClass3(CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r1, CoroutineContext r2, Object r3, ProducerCoroutine r4, Continuation r5) {
            this.k = r1;
            this.l = r2;
            this.m = r3;
            this.n = r4;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation f(Object r8, Continuation r9) {
            CoroutineContext r2 = this.l;
            ProducerCoroutine r4 = (ProducerCoroutine) this.n;
            AnonymousClass3 r6 = new AnonymousClass3(this.k, r2, this.m, r4, r9);
            r6.i = (Unit) r8;
            return r6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object i(Object r3) {
            int r0 = this.j;
            if (r0 == 0) goto L9;
            if (r0 != 1) goto L8;
            ResultKt.b(r3);
            return Unit.f330a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.b(r3);
            this.k.p.getClass();
            this.j = 1;
            throw null;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo7invoke(Object r1, Object r2) {
            AnonymousClass3 r0 = (AnonymousClass3) f(r1, (Continuation) r2);
            Unit r3 = Unit.f330a;
            r0.i(r3);
            return r3;
        }
    }

    public CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(FlowCollector r1, Continuation r2, CombineKt$zipImpl$$inlined$unsafeFlow$1 r3) {
        this.o = r1;
        this.p = r3;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation f(Object r3, Continuation r4) {
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r0 = new CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(this.o, r4, this.p);
        r0.i = (CoroutineScope) r3;
        return r0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r18) {
        CoroutineSingletons r0 = CoroutineSingletons.b;
        int r1 = this.n;
        Unit r8 = Unit.f330a;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        ProducerCoroutine r2 = this.k;
        ResultKt.b(r18);     // Catch: Throwable -> L8 AbortFlowException -> L10
        CancellationException r3 = null;
    L19:
        r2.a(r3);
        return r8;
    L10:
        e = e;
    L36:
    L32:
        th = th;
    L21:
        CancellationException r4 = null;
    L34:
        r2.a(r4);
        throw th;
    L28:
        if (e.b != this.o) goto L31;
    L29:
        r3 = null;
        goto L19
    L31:
        throw e;     // Catch: Throwable -> L32
    L8:
        th = th;
        r4 = null;
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.b(r18);
        CoroutineScope r11 = this.i;
        ProducerCoroutine r12 = ProduceKt.a(r11, 0, new AnonymousClass1(this, null), 3);
        final JobImpl r5 = new JobImpl(null);
        r12.E(new AnonymousClass2(this, r5));
        CoroutineContext r13 = r11.A();     // Catch: Throwable -> L23 AbortFlowException -> L25
        Object r14 = ThreadContextKt.b(r13);     // Catch: Throwable -> L23 AbortFlowException -> L25
        CoroutineContext r15 = r11.A().i(r5);     // Catch: Throwable -> L23 AbortFlowException -> L25
        AnonymousClass3 r6 = new AnonymousClass3(this, r13, r14, r12, null);     // Catch: Throwable -> L23 AbortFlowException -> L25
        this.j = r11;     // Catch: Throwable -> L23 AbortFlowException -> L25
        this.k = r12;     // Catch: Throwable -> L23 AbortFlowException -> L25
        this.l = r13;     // Catch: Throwable -> L23 AbortFlowException -> L25
        this.m = r14;     // Catch: Throwable -> L23 AbortFlowException -> L25
        this.n = 1;     // Catch: Throwable -> L23 AbortFlowException -> L25
        if (ChannelFlowKt.a(r15, r8, ThreadContextKt.b(r15), r6, this) != r0) goto L18;
        return r0;
    L18:
        r2 = r12;
        goto L29
    L25:
        e = e;
        r2 = r12;
    L23:
        th = th;
        r2 = r12;
        goto L21
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return ((CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) f(r1, (Continuation) r2)).i(Unit.f330a);
    }
}
