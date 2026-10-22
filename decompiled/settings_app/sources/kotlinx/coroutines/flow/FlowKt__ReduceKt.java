package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;
import kotlinx.coroutines.flow.internal.FlowExceptions_commonKt;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* JADX INFO: compiled from: Reduce.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a!\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001aE\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001a#\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001aG\u0010\n\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001ay\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\r\u001a\u0002H\f2H\b\u0004\u0010\u000e\u001aB\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a!\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a#\u0010\u0016\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001as\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u0018\"\b\b\u0001\u0010\u0001*\u0002H\u0018*\b\u0012\u0004\u0012\u0002H\u00010\u00022F\u0010\u000e\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a!\u0010\u001b\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u001a#\u0010\u001c\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"first", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "firstOrNull", "fold", "R", "initial", "operation", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "acc", "value", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastOrNull", "reduce", ExifInterface.LATITUDE_SOUTH, "accumulator", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "single", "singleOrNull", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__ReduceKt {

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$1, reason: invalid class name */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "first", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.first(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$first$3, reason: invalid class name */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0, 0}, l = {183}, m = "first", n = {"predicate", "result", "collector$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass3<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.first(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "firstOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    static final class C04191<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C04191(Continuation<? super C04191> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.firstOrNull(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "firstOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    static final class C04203<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C04203(Continuation<? super C04203> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.firstOrNull(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {44}, m = "fold", n = {"accumulator"}, s = {"L$0"})
    static final class C04211<T, R> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04211(Continuation<? super C04211> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__ReduceKt.fold(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$fold$2, reason: invalid class name */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass2<T> implements FlowCollector {
        final /* synthetic */ Ref.ObjectRef<R> $accumulator;
        final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> $operation;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Ref.ObjectRef<R> r1, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r2) {
            this.$accumulator = r1;
            this.$operation = r2;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T r6, Continuation<? super Unit> r7) {
            if ((r7 instanceof FlowKt__ReduceKt$fold$2$emit$1) == false) goto L7;
            FlowKt__ReduceKt$fold$2$emit$1 r0 = (FlowKt__ReduceKt$fold$2$emit$1) r7;
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r8 = r0.result;
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            Ref.ObjectRef r5 = (Ref.ObjectRef) r0.L$0;
            ResultKt.throwOnFailure(r8);
        L18:
            r5.element = (T) r8;
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r8);
            Ref.ObjectRef r9 = this.$accumulator;
            Function3<R, T, Continuation<? super R>, Object> r10 = this.$operation;
            T r3 = r9.element;
            r0.L$0 = r9;
            r0.label = 1;
            Object r11 = r10.invoke((R) r3, r6, r0);
            if (r11 != r1) goto L17;
            return r1;
        L17:
            r8 = (T) r11;
            r5 = r9;
        L7:
            r0 = new FlowKt__ReduceKt$fold$2$emit$1(this, r7);
            goto L8
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object emit$$forInline(T r3, Continuation<? super Unit> r4) {
            InlineMarker.mark(4);
            new FlowKt__ReduceKt$fold$2$emit$1(this, r4);
            InlineMarker.mark(5);
            Ref.ObjectRef<R> r0 = this.$accumulator;
            r0.element = (T) this.$operation.invoke((R) r0.element, r3, (Continuation<? super R>) r4);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$last$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {155}, m = "last", n = {"result"}, s = {"L$0"})
    static final class C04221<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04221(Continuation<? super C04221> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.last(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$lastOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {167}, m = "lastOrNull", n = {"result"}, s = {"L$0"})
    static final class C04241<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04241(Continuation<? super C04241> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.lastOrNull(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {22}, m = "reduce", n = {"accumulator"}, s = {"L$0"})
    static final class C04261<S, T extends S> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04261(Continuation<? super C04261> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.reduce(null, null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$reduce$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u00022\u0006\u0010\u0004\u001a\u0002H\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C04272<T> implements FlowCollector {
        final /* synthetic */ Ref.ObjectRef<Object> $accumulator;
        final /* synthetic */ Function3<S, T, Continuation<? super S>, Object> $operation;

        /* JADX WARN: Multi-variable type inference failed */
        C04272(Ref.ObjectRef<Object> r1, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> r2) {
            this.$accumulator = r1;
            this.$operation = r2;
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
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(T r6, Continuation<? super Unit> r7) {
            if ((r7 instanceof FlowKt__ReduceKt$reduce$2$emit$1) == false) goto L7;
            FlowKt__ReduceKt$reduce$2$emit$1 r0 = (FlowKt__ReduceKt$reduce$2$emit$1) r7;
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r8 = r0.result;
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            Ref.ObjectRef<Object> r5 = (Ref.ObjectRef) r0.L$0;
            ResultKt.throwOnFailure(r8);
            Object r9 = (T) r8;
        L20:
            Ref.ObjectRef<Object> r10 = r5;
            Object r11 = r9;
        L21:
            r10.element = (T) r11;
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r8);
            r10 = this.$accumulator;
            r11 = r6;
            if (r10.element == NullSurrogateKt.NULL) goto L21;
            Function3<S, T, Continuation<? super S>, Object> r3 = this.$operation;
            Object r12 = this.$accumulator.element;
            r0.L$0 = r10;
            r0.label = 1;
            Object r13 = r3.invoke((S) r12, r6, r0);
            if (r13 != r1) goto L19;
            return r1;
        L19:
            r9 = r13;
            r5 = r10;
        L7:
            r0 = new FlowKt__ReduceKt$reduce$2$emit$1(this, r7);
            goto L8
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$single$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0}, l = {57}, m = "single", n = {"result"}, s = {"L$0"})
    static final class C04281<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C04281(Continuation<? super C04281> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.single(null, this);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__ReduceKt$singleOrNull$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Reduce.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", i = {0, 0}, l = {183}, m = "singleOrNull", n = {"result", "collector$iv"}, s = {"L$0", "L$1"})
    static final class C04301<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C04301(Continuation<? super C04301> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return FlowKt.singleOrNull(null, this);
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.internal.Symbol] */
    public static final <S, T extends S> Object reduce(Flow<? extends T> r4, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> r5, Continuation<? super S> r6) {
        if ((r6 instanceof C04261) == false) goto L7;
        C04261 r0 = (C04261) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Ref.ObjectRef r8 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L19:
        if (r8.element == NullSurrogateKt.NULL) goto L23;
        return r8.element;
    L23:
        throw new NoSuchElementException("Empty flow can't be reduced");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = NullSurrogateKt.NULL;
        FlowCollector<? super Object> r3 = new C04272(r9, r5);
        r0.L$0 = r9;
        r0.label = 1;
        if (r4.collect(r3, r0) != r1) goto L17;
        return r1;
    L17:
        r8 = r9;
    L7:
        r0 = new C04261(r6);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> Object fold(Flow<? extends T> r4, R r5, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r6, Continuation<? super R> r7) {
        if ((r7 instanceof C04211) == false) goto L7;
        C04211 r0 = (C04211) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Ref.ObjectRef r9 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L19:
        return r9.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = r5;
        FlowCollector<? super Object> r11 = new AnonymousClass2(r10, r6);
        r0.L$0 = r10;
        r0.label = 1;
        if (r4.collect(r11, r0) != r1) goto L17;
        return r1;
    L17:
        r9 = r10;
    L7:
        r0 = new C04211(r7);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T, R> Object fold$$forInline(Flow<? extends T> r1, R r2, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> r3, Continuation<? super R> r4) {
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = r2;
        AnonymousClass2 r5 = new AnonymousClass2(r0, r3);
        InlineMarker.mark(0);
        r1.collect(r5, r4);
        InlineMarker.mark(1);
        return r0.element;
    }

    public static final <T> Object single(Flow<? extends T> r4, Continuation<? super T> r5) {
        if ((r5 instanceof C04281) == false) goto L7;
        C04281 r0 = (C04281) r5;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Ref.ObjectRef r7 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r6);
    L19:
        if (r7.element == NullSurrogateKt.NULL) goto L23;
        return r7.element;
    L23:
        throw new NoSuchElementException("Flow is empty");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = (T) NullSurrogateKt.NULL;
        FlowCollector<? super Object> r3 = new C04292(r8);
        r0.L$0 = r8;
        r0.label = 1;
        if (r4.collect(r3, r0) != r1) goto L17;
        return r1;
    L17:
        r7 = r8;
    L7:
        r0 = new C04281(r5);
        goto L8
    }

    public static final <T> Object singleOrNull(Flow<? extends T> r5, Continuation<? super T> r6) {
        if ((r6 instanceof C04301) == false) goto L7;
        C04301 r0 = (C04301) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        FlowCollector<T> r8 = (FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1) r0.L$1;
        Ref.ObjectRef r3 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: AbortFlowException -> L14
    L27:
        if (r3.element != NullSurrogateKt.NULL) goto L30;
        return null;
    L30:
        return r3.element;
    L14:
        AbortFlowException e = e;
    L25:
        FlowExceptions_commonKt.checkOwnership(e, r8);
        goto L27
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r7);
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = (T) NullSurrogateKt.NULL;
        FlowCollector<T> r4 = new FlowKt__ReduceKt$singleOrNull$$inlined$collectWhile$1(r9);
        r0.L$0 = r9;     // Catch: AbortFlowException -> L23
        r0.L$1 = r4;     // Catch: AbortFlowException -> L23
        r0.label = 1;     // Catch: AbortFlowException -> L23
        if (r5.collect(r4, r0) != r1) goto L22;
        return r1;
    L22:
        r3 = r9;
    L23:
        e = move-exception;
        r3 = r9;
        e = e;
        r8 = r4;
    L7:
        r0 = new C04301(r6);
        goto L8
    }

    public static final <T> Object first(Flow<? extends T> r5, Continuation<? super T> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        FlowCollector<T> r8 = (FlowKt__ReduceKt$first$$inlined$collectWhile$1) r0.L$1;
        Ref.ObjectRef r3 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: AbortFlowException -> L14
    L27:
        if (r3.element == NullSurrogateKt.NULL) goto L31;
        return r3.element;
    L31:
        throw new NoSuchElementException("Expected at least one element");
    L14:
        AbortFlowException e = e;
    L25:
        FlowExceptions_commonKt.checkOwnership(e, r8);
        goto L27
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r7);
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = (T) NullSurrogateKt.NULL;
        FlowCollector<T> r4 = new FlowKt__ReduceKt$first$$inlined$collectWhile$1(r9);
        r0.L$0 = r9;     // Catch: AbortFlowException -> L23
        r0.L$1 = r4;     // Catch: AbortFlowException -> L23
        r0.label = 1;     // Catch: AbortFlowException -> L23
        if (r5.collect(r4, r0) != r1) goto L22;
        return r1;
    L22:
        r3 = r9;
    L23:
        e = move-exception;
        r3 = r9;
        e = e;
        r8 = r4;
    L7:
        r0 = new AnonymousClass1(r6);
        goto L8
    }

    public static final <T> Object first(Flow<? extends T> r5, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r6, Continuation<? super T> r7) {
        if ((r7 instanceof AnonymousClass3) == false) goto L7;
        AnonymousClass3 r0 = (AnonymousClass3) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        FlowCollector<? super Object> r9 = (FlowKt__ReduceKt$first$$inlined$collectWhile$2) r0.L$2;
        Ref.ObjectRef r10 = (Ref.ObjectRef) r0.L$1;
        Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r3 = (Function2) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: AbortFlowException -> L14
    L27:
        if (r10.element == NullSurrogateKt.NULL) goto L31;
        return r10.element;
    L31:
        throw new NoSuchElementException("Expected at least one element matching the predicate " + r3);
    L14:
        AbortFlowException e = e;
    L25:
        FlowExceptions_commonKt.checkOwnership(e, r9);
        goto L27
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r8);
        Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.element = (T) NullSurrogateKt.NULL;
        FlowCollector<? super Object> r4 = new FlowKt__ReduceKt$first$$inlined$collectWhile$2(r6, r11);
        r0.L$0 = r6;     // Catch: AbortFlowException -> L23
        r0.L$1 = r11;     // Catch: AbortFlowException -> L23
        r0.L$2 = r4;     // Catch: AbortFlowException -> L23
        r0.label = 1;     // Catch: AbortFlowException -> L23
        if (r5.collect(r4, r0) != r1) goto L22;
        return r1;
    L22:
        r3 = r6;
        r10 = r11;
    L23:
        e = move-exception;
        r3 = r6;
        r10 = r11;
        e = e;
        r9 = r4;
    L7:
        r0 = new AnonymousClass3(r7);
        goto L8
    }

    public static final <T> Object firstOrNull(Flow<? extends T> r5, Continuation<? super T> r6) {
        if ((r6 instanceof C04191) == false) goto L7;
        C04191 r0 = (C04191) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        FlowCollector<T> r8 = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1) r0.L$1;
        Ref.ObjectRef r3 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: AbortFlowException -> L14
    L27:
        return r3.element;
    L14:
        AbortFlowException e = e;
    L25:
        FlowExceptions_commonKt.checkOwnership(e, r8);
        goto L27
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r7);
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        FlowCollector<T> r4 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$1(r9);
        r0.L$0 = r9;     // Catch: AbortFlowException -> L23
        r0.L$1 = r4;     // Catch: AbortFlowException -> L23
        r0.label = 1;     // Catch: AbortFlowException -> L23
        if (r5.collect(r4, r0) != r1) goto L22;
        return r1;
    L22:
        r3 = r9;
    L23:
        e = move-exception;
        r3 = r9;
        e = e;
        r8 = r4;
    L7:
        r0 = new C04191(r6);
        goto L8
    }

    public static final <T> Object firstOrNull(Flow<? extends T> r4, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> r5, Continuation<? super T> r6) {
        if ((r6 instanceof C04203) == false) goto L7;
        C04203 r0 = (C04203) r6;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        FlowCollector<? super Object> r8 = (FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2) r0.L$1;
        Ref.ObjectRef r9 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: AbortFlowException -> L14
    L27:
        return r9.element;
    L14:
        AbortFlowException e = e;
    L25:
        FlowExceptions_commonKt.checkOwnership(e, r8);
        goto L27
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r7);
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        FlowCollector<? super Object> r3 = new FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2(r5, r10);
        r0.L$0 = r10;     // Catch: AbortFlowException -> L23
        r0.L$1 = r3;     // Catch: AbortFlowException -> L23
        r0.label = 1;     // Catch: AbortFlowException -> L23
        if (r4.collect(r3, r0) != r1) goto L22;
        return r1;
    L22:
        r9 = r10;
    L23:
        e = move-exception;
        r9 = r10;
        e = e;
        r8 = r3;
    L7:
        r0 = new C04203(r6);
        goto L8
    }

    public static final <T> Object last(Flow<? extends T> r4, Continuation<? super T> r5) {
        if ((r5 instanceof C04221) == false) goto L7;
        C04221 r0 = (C04221) r5;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Ref.ObjectRef r7 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r6);
    L19:
        if (r7.element == NullSurrogateKt.NULL) goto L23;
        return r7.element;
    L23:
        throw new NoSuchElementException("Expected at least one element");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        r8.element = (T) NullSurrogateKt.NULL;
        FlowCollector<? super Object> r3 = new C04232(r8);
        r0.L$0 = r8;
        r0.label = 1;
        if (r4.collect(r3, r0) != r1) goto L17;
        return r1;
    L17:
        r7 = r8;
    L7:
        r0 = new C04221(r5);
        goto L8
    }

    public static final <T> Object lastOrNull(Flow<? extends T> r4, Continuation<? super T> r5) {
        if ((r5 instanceof C04241) == false) goto L7;
        C04241 r0 = (C04241) r5;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Ref.ObjectRef r7 = (Ref.ObjectRef) r0.L$0;
        ResultKt.throwOnFailure(r6);
    L19:
        return r7.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        FlowCollector<? super Object> r3 = new C04252(r8);
        r0.L$0 = r8;
        r0.label = 1;
        if (r4.collect(r3, r0) != r1) goto L17;
        return r1;
    L17:
        r7 = r8;
    L7:
        r0 = new C04241(r5);
        goto L8
    }
}
