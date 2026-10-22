package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: compiled from: Combine.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1", f = "Combine.kt", i = {0}, l = {129}, m = "invokeSuspend", n = {"second"}, s = {"L$0"})
final class CombineKt$zipImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T1> $flow;
    final /* synthetic */ Flow<T2> $flow2;
    final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: Combine.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "it"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2", f = "Combine.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $cnt;
        final /* synthetic */ Flow<T1> $flow;
        final /* synthetic */ CoroutineContext $scopeContext;
        final /* synthetic */ ReceiveChannel<Object> $second;
        final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
        final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Combine.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ Object $cnt;
            final /* synthetic */ CoroutineContext $scopeContext;
            final /* synthetic */ ReceiveChannel<Object> $second;
            final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
            final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Combine.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "it"}, k = 3, mv = {1, 6, 0}, xi = 48)
            @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$2$1$1", f = "Combine.kt", i = {}, l = {132, 135, 135}, m = "invokeSuspend", n = {}, s = {})
            static final class C00861 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
                final /* synthetic */ ReceiveChannel<Object> $second;
                final /* synthetic */ FlowCollector<R> $this_unsafeFlow;
                final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
                final /* synthetic */ T1 $value;
                Object L$0;
                int label;

                /* JADX WARN: Multi-variable type inference failed */
                C00861(ReceiveChannel<? extends Object> r1, FlowCollector<? super R> r2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r3, T1 r4, Continuation<? super C00861> r5) {
                    this.$second = r1;
                    this.$this_unsafeFlow = r2;
                    this.$transform = r3;
                    this.$value = r4;
                    super(2, r5);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                    return new C00861(this.$second, this.$this_unsafeFlow, this.$transform, this.$value, r8);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Unit r1, Continuation<? super Unit> r2) {
                    return invoke2(r1, r2);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(Unit r1, Continuation<? super Unit> r2) {
                    return ((C00861) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r9) {
                    Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r1 = this.label;
                    if (r1 == 0) goto L12;
                    if (r1 == 1) goto L11;
                    if (r1 == 2) goto L10;
                    if (r1 != 3) goto L9;
                    ResultKt.throwOnFailure(r9);
                L31:
                    return Unit.INSTANCE;
                L9:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L10:
                    FlowCollector r2 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(r9);
                    FlowCollector r3 = r2;
                L27:
                    this.L$0 = null;
                    this.label = 3;
                    if (r3.emit(r9, this) != r0) goto L31;
                    return r0;
                L11:
                    ResultKt.throwOnFailure(r9);
                    Object r10 = ((ChannelResult) r9).m2298unboximpl();
                L15:
                    FlowCollector r4 = this.$this_unsafeFlow;
                    if ((r10 instanceof ChannelResult.Failed) == false) goto L21;
                    Throwable r8 = ChannelResult.m2290exceptionOrNullimpl(r10);
                    if (r8 == null) goto L20;
                    throw r8;
                L20:
                    throw new AbortFlowException(r4);
                L21:
                    Function3<T1, T2, Continuation<? super R>, Object> r5 = this.$transform;
                    T1 r6 = this.$value;
                    if (r10 != NullSurrogateKt.NULL) goto L24;
                    r10 = null;
                L24:
                    this.L$0 = r4;
                    this.label = 2;
                    r9 = r5.invoke(r6, r10, this);
                    r3 = r4;
                    if (r9 != r0) goto L27;
                    return r0;
                L12:
                    ResultKt.throwOnFailure(r9);
                    this.label = 1;
                    r10 = this.$second.mo2279receiveCatchingJP2dKIU(this);
                    if (r10 != r0) goto L15;
                    return r0;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(CoroutineContext r1, Object r2, ReceiveChannel<? extends Object> r3, FlowCollector<? super R> r4, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r5) {
                this.$scopeContext = r1;
                this.$cnt = r2;
                this.$second = r3;
                this.$this_unsafeFlow = r4;
                this.$transform = r5;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(T1 r13, Continuation<? super Unit> r14) {
                if ((r14 instanceof CombineKt$zipImpl$1$1$2$1$emit$1) == false) goto L7;
                CombineKt$zipImpl$1$1$2$1$emit$1 r0 = (CombineKt$zipImpl$1$1$2$1$emit$1) r14;
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r15 = r0.result;
                Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r2 = r0.label;
                if (r2 == 0) goto L14;
                if (r2 != 1) goto L13;
                ResultKt.throwOnFailure(r15);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r15);
                CoroutineContext r16 = this.$scopeContext;
                Unit r3 = Unit.INSTANCE;
                Object r4 = this.$cnt;
                C00861 r11 = new C00861(this.$second, this.$this_unsafeFlow, this.$transform, r13, null);
                r0.label = 1;
                if (ChannelFlowKt.withContextUndispatched(r16, r3, r4, r11, r0) != r1) goto L18;
                return r1;
            L7:
                r0 = new CombineKt$zipImpl$1$1$2$1$emit$1(this, r14);
                goto L8
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Flow<? extends T1> r1, CoroutineContext r2, Object r3, ReceiveChannel<? extends Object> r4, FlowCollector<? super R> r5, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r6, Continuation<? super AnonymousClass2> r7) {
            this.$flow = r1;
            this.$scopeContext = r2;
            this.$cnt = r3;
            this.$second = r4;
            this.$this_unsafeFlow = r5;
            this.$transform = r6;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            return new AnonymousClass2(this.$flow, this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Unit r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Unit r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            Flow<T1> r11 = this.$flow;
            AnonymousClass1 r2 = new AnonymousClass1(this.$scopeContext, this.$cnt, this.$second, this.$this_unsafeFlow, this.$transform);
            this.label = 1;
            if (r11.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    CombineKt$zipImpl$1$1(FlowCollector<? super R> r1, Flow<? extends T2> r2, Flow<? extends T1> r3, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r4, Continuation<? super CombineKt$zipImpl$1$1> r5) {
        this.$this_unsafeFlow = r1;
        this.$flow2 = r2;
        this.$flow = r3;
        this.$transform = r4;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        CombineKt$zipImpl$1$1 r6 = new CombineKt$zipImpl$1$1(this.$this_unsafeFlow, this.$flow2, this.$flow, this.$transform, r9);
        r6.L$0 = r8;
        return r6;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
        return ((CombineKt$zipImpl$1$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r23) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = this.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ReceiveChannel r3 = (ReceiveChannel) this.L$0;
        ResultKt.throwOnFailure(r23);     // Catch: Throwable -> L8 AbortFlowException -> L10
        r2 = r3;
    L30:
    L19:
        ReceiveChannel.DefaultImpls.cancel$default(r2, null, 1, null);
        return Unit.INSTANCE;
    L10:
        e = e;
    L24:
        FlowExceptions_commonKt.checkOwnership(e, this.$this_unsafeFlow);     // Catch: Throwable -> L8
        r2 = r3;
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r23);
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ReceiveChannel r5 = ProduceKt.produce$default(r4, null, 0, new CombineKt$zipImpl$1$1$second$1(this.$flow2, null), 3, null);
        final CompletableJob r6 = JobKt.Job$default(null, 1, null);
        final FlowCollector r9 = this.$this_unsafeFlow;
        ((SendChannel) r5).invokeOnClose(new AnonymousClass1(r6, r9));
        CoroutineContext r13 = r4.getCoroutineContext();     // Catch: Throwable -> L20 AbortFlowException -> L22
        Object r14 = ThreadContextKt.threadContextElements(r13);     // Catch: Throwable -> L20 AbortFlowException -> L22
        this.L$0 = r5;     // Catch: Throwable -> L20 AbortFlowException -> L22
        this.label = 1;     // Catch: Throwable -> L20 AbortFlowException -> L22
        if (ChannelFlowKt.withContextUndispatched$default(r4.getCoroutineContext().plus(r6), Unit.INSTANCE, null, new AnonymousClass2(this.$flow, r13, r14, r5, this.$this_unsafeFlow, this.$transform, null), this, 4, null) != r0) goto L18;
        return r0;
    L18:
        r2 = r5;
        goto L19
    L22:
        e = e;
        r3 = r5;
    L20:
        th = th;
        r2 = r5;
    L28:
        ReceiveChannel.DefaultImpls.cancel$default(r2, null, 1, null);
        throw th;
    L8:
        th = th;
        goto L28
    }
}
