package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.YieldKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: Combine.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001an\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012(\u0010\u0007\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u0090\u0001\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u00010\u00112\u0016\u0010\u0012\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0018\u00010\u00110\u001329\u0010\u0007\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\b\u0014H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u0015*\u001c\b\u0002\u0010\u0016\"\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00172\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"zipImpl", "Lkotlinx/coroutines/flow/Flow;", "R", "T1", "T2", "flow", "flow2", "transform", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "combineInternal", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "flows", "", "arrayFactory", "Lkotlin/Function0;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/FlowCollector;[Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Update", "Lkotlin/collections/IndexedValue;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CombineKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2, reason: invalid class name */
    /* JADX INFO: compiled from: Combine.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {57, 79, 82}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<T[]> $arrayFactory;
        final /* synthetic */ Flow<T>[] $flows;
        final /* synthetic */ FlowCollector<R> $this_combineInternal;
        final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> $transform;
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Combine.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Flow<T>[] $flows;
            final /* synthetic */ int $i;
            final /* synthetic */ AtomicInteger $nonClosed;
            final /* synthetic */ Channel<IndexedValue<Object>> $resultChannel;
            int label;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Combine.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            static final class C00851<T> implements FlowCollector {
                final /* synthetic */ int $i;
                final /* synthetic */ Channel<IndexedValue<Object>> $resultChannel;

                C00851(Channel<IndexedValue<Object>> r1, int r2) {
                    this.$resultChannel = r1;
                    this.$i = r2;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(T r6, Continuation<? super Unit> r7) {
                    if ((r7 instanceof CombineKt$combineInternal$2$1$1$emit$1) == false) goto L7;
                    CombineKt$combineInternal$2$1$1$emit$1 r0 = (CombineKt$combineInternal$2$1$1$emit$1) r7;
                    if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                    r0.label -= Integer.MIN_VALUE;
                L8:
                    Object r8 = r0.result;
                    Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r2 = r0.label;
                    if (r2 == 0) goto L16;
                    if (r2 == 1) goto L15;
                    if (r2 != 2) goto L14;
                    ResultKt.throwOnFailure(r8);
                L23:
                    return Unit.INSTANCE;
                L14:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L15:
                    ResultKt.throwOnFailure(r8);
                L19:
                    r0.label = 2;
                    if (YieldKt.yield(r0) != r1) goto L23;
                    return r1;
                L16:
                    ResultKt.throwOnFailure(r8);
                    Channel<IndexedValue<Object>> r9 = this.$resultChannel;
                    IndexedValue<Object> r3 = new IndexedValue(this.$i, r6);
                    r0.label = 1;
                    if (r9.send(r3, r0) != r1) goto L19;
                    return r1;
                L7:
                    r0 = new CombineKt$combineInternal$2$1$1$emit$1(this, r7);
                    goto L8
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Flow<? extends T>[] r1, int r2, AtomicInteger r3, Channel<IndexedValue<Object>> r4, Continuation<? super AnonymousClass1> r5) {
                this.$flows = r1;
                this.$i = r2;
                this.$nonClosed = r3;
                this.$resultChannel = r4;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, r8);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return invoke2(r1, r2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r7) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L11;
                if (r1 != 1) goto L10;
                ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L7
            L15:
                if (this.$nonClosed.decrementAndGet() != 0) goto L19;
                SendChannel.DefaultImpls.close$default(this.$resultChannel, null, 1, null);
            L19:
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                ResultKt.throwOnFailure(r7);
                this.label = 1;     // Catch: Throwable -> L7
                if (this.$flows[this.$i].collect(new C00851(this.$resultChannel, this.$i), this) != r0) goto L15;
                return r0;
            L7:
                th = move-exception;
                if (this.$nonClosed.decrementAndGet() != 0) goto L23;
                SendChannel.DefaultImpls.close$default(this.$resultChannel, null, 1, null);
            L23:
                throw th;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Flow<? extends T>[] r1, Function0<T[]> r2, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> r3, FlowCollector<? super R> r4, Continuation<? super AnonymousClass2> r5) {
            this.$flows = r1;
            this.$arrayFactory = r2;
            this.$transform = r3;
            this.$this_combineInternal = r4;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass2 r6 = new AnonymousClass2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, r9);
            r6.L$0 = r8;
            return r6;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
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
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x013b -> B:45:0x013d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r24) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L12;
            if (r2 == 1) goto L11;
            if (r2 == 2) goto L10;
            if (r2 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r3 = this.I$1;
            int r6 = this.I$0;
            byte[] r7 = (byte[]) this.L$2;
            Channel r8 = (Channel) this.L$1;
            Object[] r9 = (Object[]) this.L$0;
            ResultKt.throwOnFailure(r24);
            int r21 = r3;
            byte[] r4 = r7;
            Channel r10 = r8;
        L45:
            Object[] r13 = r9;
        L20:
            int r11 = (byte) (r21 + 1);
            this.L$0 = r13;
            this.L$1 = r10;
            this.L$2 = r4;
            this.I$0 = r6;
            this.I$1 = r11;
            this.label = 1;
            Object r12 = r10.mo2279receiveCatchingJP2dKIU(this);
            if (r12 != r1) goto L23;
            return r1;
        L23:
            r9 = r13;
        L24:
            IndexedValue r14 = (IndexedValue) ChannelResult.m2291getOrNullimpl(r12);
            if (r14 == null) goto L27;
        L28:
            int r15 = r14.getIndex();
            Object r16 = r9[r15];
            r9[r15] = r14.getValue();
            if (r16 != NullSurrogateKt.UNINITIALIZED) goto L32;
            r6 = r6 - 1;
        L32:
            if (r4[r15] == r11) goto L35;
            r4[r15] = (byte) r11;
            r14 = (IndexedValue) ChannelResult.m2291getOrNullimpl(r10.mo2280tryReceivePtdJZtk());
            if (r14 != null) goto L28;
        L35:
            if (r6 != 0) goto L44;
            Object[] r17 = (Object[]) this.$arrayFactory.invoke();
            if (r17 != null) goto L41;
            Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> r18 = this.$transform;
            Object r19 = this.$this_combineInternal;
            this.L$0 = r9;
            this.L$1 = r10;
            this.L$2 = r4;
            this.I$0 = r6;
            this.I$1 = r11;
            this.label = 2;
            if (r18.invoke(r19, r9, this) != r1) goto L44;
            return r1;
        L41:
            ArraysKt.copyInto$default(r9, r17, 0, 0, 0, 14, null);
            Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> r110 = this.$transform;
            Object r111 = this.$this_combineInternal;
            this.L$0 = r9;
            this.L$1 = r10;
            this.L$2 = r4;
            this.I$0 = r6;
            this.I$1 = r11;
            this.label = 3;
            if (r110.invoke(r111, r17, this) != r1) goto L44;
            return r1;
        L44:
            r21 = r11;
            goto L45
        L27:
            return Unit.INSTANCE;
        L11:
            int r5 = this.I$1;
            r6 = this.I$0;
            byte[] r20 = (byte[]) this.L$2;
            Channel r22 = (Channel) this.L$1;
            r9 = (Object[]) this.L$0;
            ResultKt.throwOnFailure(r24);
            r12 = ((ChannelResult) r24).m2298unboximpl();
            r11 = r5;
            r4 = r20;
            r10 = r22;
            goto L24
        L12:
            ResultKt.throwOnFailure(r24);
            CoroutineScope r23 = (CoroutineScope) this.L$0;
            int r112 = this.$flows.length;
            if (r112 == 0) goto L15;
            r13 = new Object[r112];
            ArraysKt.fill$default(r13, NullSurrogateKt.UNINITIALIZED, 0, 0, 6, null);
            Channel r25 = ChannelKt.Channel$default(r112, null, null, 6, null);
            AtomicInteger r113 = new AtomicInteger(r112);
            r21 = 0;
            int r114 = 0;
        L17:
            if (r114 >= r112) goto L19;
            int r115 = r114;
            BuildersKt.launch$default(r23, null, null, new AnonymousClass1(this.$flows, r115, r113, r25, null), 3, null);
            r114 = r115 + 1;
            r113 = r113;
            goto L17
        L19:
            r4 = new byte[r112];
            r6 = r112;
            r10 = r25;
            goto L20
        L15:
            return Unit.INSTANCE;
        }
    }

    public static final <R, T> Object combineInternal(FlowCollector<? super R> r7, Flow<? extends T>[] r8, Function0<T[]> r9, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> r10, Continuation<? super Unit> r11) {
        Object r12 = FlowCoroutineKt.flowScope(new AnonymousClass2(r8, r9, r10, r7, null), r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }

    public static final <T1, T2, R> Flow<R> zipImpl(final Flow<? extends T1> r1, final Flow<? extends T2> r2, final Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r3) {
        return new CombineKt$zipImpl$$inlined$unsafeFlow$1(r2, r1, r3);
    }
}
