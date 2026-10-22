package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: RepeatOnLifecycle.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"repeatOnLifecycle", "", "Landroidx/lifecycle/Lifecycle;", "state", "Landroidx/lifecycle/Lifecycle$State;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RepeatOnLifecycleKt {

    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3, reason: invalid class name */
    /* JADX INFO: compiled from: RepeatOnLifecycle.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: RepeatOnLifecycle.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
        @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {166}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ Lifecycle.State $state;
            final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Lifecycle r1, Lifecycle.State r2, CoroutineScope r3, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r4, Continuation<? super AnonymousClass1> r5) {
                this.$this_repeatOnLifecycle = r1;
                this.$state = r2;
                this.$$this$coroutineScope = r3;
                this.$block = r4;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
                return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, r8);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return invoke2(r1, r2);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Type inference failed for: r7v1, types: [T, androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r17) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r2 = this.label;
                if (r2 == 0) goto L12;
                if (r2 != 1) goto L11;
                Function2 r1 = (Function2) this.L$5;
                CoroutineScope r3 = (CoroutineScope) this.L$4;
                Lifecycle r4 = (Lifecycle) this.L$3;
                Lifecycle.State r5 = (Lifecycle.State) this.L$2;
                Ref.ObjectRef r6 = (Ref.ObjectRef) this.L$1;
                Ref.ObjectRef r7 = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L8
            L23:
                Job r8 = (Job) r7.element;
                if (r8 == null) goto L26;
                Job.DefaultImpls.cancel$default(r8, null, 1, null);
            L26:
                LifecycleEventObserver r9 = (LifecycleEventObserver) r6.element;
                if (r9 == null) goto L30;
                this.$this_repeatOnLifecycle.removeObserver(r9);
            L30:
                return Unit.INSTANCE;
            L8:
                th = th;
            L33:
                Job r10 = (Job) r7.element;
                if (r10 == null) goto L36;
                Job.DefaultImpls.cancel$default(r10, null, 1, null);
            L36:
                LifecycleEventObserver r11 = (LifecycleEventObserver) r6.element;
                if (r11 == null) goto L39;
                this.$this_repeatOnLifecycle.removeObserver(r11);
            L39:
                throw th;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L12:
                ResultKt.throwOnFailure(r17);
                if (this.$this_repeatOnLifecycle.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
                final Ref.ObjectRef r12 = new Ref.ObjectRef();
                Ref.ObjectRef r13 = new Ref.ObjectRef();
                Lifecycle.State r14 = this.$state;     // Catch: Throwable -> L31
                Lifecycle r15 = this.$this_repeatOnLifecycle;     // Catch: Throwable -> L31
                final CoroutineScope r16 = this.$$this$coroutineScope;     // Catch: Throwable -> L31
                final Function2<CoroutineScope, Continuation<? super Unit>, Object> r18 = this.$block;     // Catch: Throwable -> L31
                this.L$0 = r12;     // Catch: Throwable -> L31
                this.L$1 = r13;     // Catch: Throwable -> L31
                this.L$2 = r14;     // Catch: Throwable -> L31
                this.L$3 = r15;     // Catch: Throwable -> L31
                this.L$4 = r16;     // Catch: Throwable -> L31
                this.L$5 = r18;     // Catch: Throwable -> L31
                this.label = 1;     // Catch: Throwable -> L31
                CancellableContinuationImpl r19 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);     // Catch: Throwable -> L31
                r19.initCancellability();     // Catch: Throwable -> L31
                final CancellableContinuationImpl r110 = r19;     // Catch: Throwable -> L31
                final Lifecycle.Event r20 = Lifecycle.Event.Companion.upTo(r14);     // Catch: Throwable -> L31
                final Lifecycle.Event r21 = Lifecycle.Event.Companion.downFrom(r14);     // Catch: Throwable -> L31
                final Mutex r111 = MutexKt.Mutex$default(false, 1, null);     // Catch: Throwable -> L31
                r13.element = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(r20, r12, r16, r21, r110, r111, r18);     // Catch: Throwable -> L31
                T r22 = r13.element;     // Catch: Throwable -> L31
                Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");     // Catch: Throwable -> L31
                r15.addObserver((LifecycleEventObserver) r22);     // Catch: Throwable -> L31
                Object r23 = r19.getResult();     // Catch: Throwable -> L31
                if (r23 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
                DebugProbesKt.probeCoroutineSuspended(this);     // Catch: Throwable -> L31
            L20:
                if (r23 != r0) goto L22;
                return r0;
            L22:
                r7 = r12;
                r6 = r13;
            L31:
                th = th;
                r7 = r12;
                r6 = r13;
                goto L33
            L15:
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Lifecycle r1, Lifecycle.State r2, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super AnonymousClass3> r4) {
            this.$this_repeatOnLifecycle = r1;
            this.$state = r2;
            this.$block = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass3 r0 = new AnonymousClass3(this.$this_repeatOnLifecycle, this.$state, this.$block, r5);
            r0.L$0 = r4;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass3) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

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
            CoroutineScope r6 = (CoroutineScope) this.L$0;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, r6, this.$block, null), this) != r0) goto L12;
            return r0;
        }
    }

    public static final Object repeatOnLifecycle(Lifecycle r2, Lifecycle.State r3, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r4, Continuation<? super Unit> r5) {
        if (r3 == Lifecycle.State.INITIALIZED) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L17;
        if (r2.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        Object r6 = CoroutineScopeKt.coroutineScope(new AnonymousClass3(r2, r3, r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r6;
    L15:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    L17:
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final Object repeatOnLifecycle(LifecycleOwner r0, Lifecycle.State r1, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super Unit> r3) {
        Object r4 = repeatOnLifecycle(r0.getLifecycle(), r1, r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }
}
