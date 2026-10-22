package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: WithLifecycleState.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001aA\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a+\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0010\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\u0010\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0011\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\u0011\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a3\u0010\u0012\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a3\u0010\u0012\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a3\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0081Hø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"suspendWithStateAtLeastUnchecked", "R", "Landroidx/lifecycle/Lifecycle;", "state", "Landroidx/lifecycle/Lifecycle$State;", "dispatchNeeded", "", "lifecycleDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "block", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;ZLkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withCreated", "(Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withResumed", "withStarted", "withStateAtLeast", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withStateAtLeastUnchecked", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class WithLifecycleStateKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.lifecycle.WithLifecycleStateKt$withStateAtLeastUnchecked$2, reason: invalid class name */
    /* JADX INFO: compiled from: WithLifecycleState.kt */
    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "R", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 176)
    public static final class AnonymousClass2<R> extends Lambda implements Function0<R> {
        final /* synthetic */ Function0<R> $block;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function0<? extends R> r1) {
            this.$block = r1;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final R invoke() {
            return this.$block.invoke();
        }
    }

    public static final <R> Object withStateAtLeast(Lifecycle r8, Lifecycle.State r9, Function0<? extends R> r10, Continuation<? super R> r11) {
        if (r9.compareTo(Lifecycle.State.CREATED) < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L19;
        MainCoroutineDispatcher r1 = Dispatchers.getMain().getImmediate();
        boolean r4 = r1.isDispatchNeeded(r11.getContext());
        if (r4 == true) goto L17;
        if (r8.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
        if (r8.getCurrentState().compareTo(r9) < 0) goto L17;
        return r10.invoke();
    L15:
        throw new LifecycleDestroyedException();
    L17:
        return suspendWithStateAtLeastUnchecked(r8, r9, r4, r1, new AnonymousClass2(r10), r11);
    L19:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r9).toString());
    L5:
        r0 = false;
        goto L6
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle r0, Lifecycle.State r1, Function0<? extends R> r2, Continuation<? super R> r3) {
        if (r1.compareTo(Lifecycle.State.CREATED) < 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation r5 = null;
        r5.getContext();
        throw null;
    L8:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r1).toString());
    L5:
        r4 = false;
        goto L6
    }

    public static final <R> Object withCreated(Lifecycle r6, Function0<? extends R> r7, Continuation<? super R> r8) {
        Lifecycle.State r1 = Lifecycle.State.CREATED;
        MainCoroutineDispatcher r0 = Dispatchers.getMain().getImmediate();
        boolean r2 = r0.isDispatchNeeded(r8.getContext());
        if (r2 == true) goto L12;
        if (r6.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r6.getCurrentState().compareTo(r1) < 0) goto L12;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r6, r1, r2, r0, new AnonymousClass2(r7), r8);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle r0, Function0<? extends R> r1, Continuation<? super R> r2) {
        Lifecycle.State r3 = Lifecycle.State.CREATED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation r4 = null;
        r4.getContext();
        throw null;
    }

    public static final <R> Object withStarted(Lifecycle r6, Function0<? extends R> r7, Continuation<? super R> r8) {
        Lifecycle.State r1 = Lifecycle.State.STARTED;
        MainCoroutineDispatcher r0 = Dispatchers.getMain().getImmediate();
        boolean r2 = r0.isDispatchNeeded(r8.getContext());
        if (r2 == true) goto L12;
        if (r6.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r6.getCurrentState().compareTo(r1) < 0) goto L12;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r6, r1, r2, r0, new AnonymousClass2(r7), r8);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle r0, Function0<? extends R> r1, Continuation<? super R> r2) {
        Lifecycle.State r3 = Lifecycle.State.STARTED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation r4 = null;
        r4.getContext();
        throw null;
    }

    public static final <R> Object withResumed(Lifecycle r6, Function0<? extends R> r7, Continuation<? super R> r8) {
        Lifecycle.State r1 = Lifecycle.State.RESUMED;
        MainCoroutineDispatcher r0 = Dispatchers.getMain().getImmediate();
        boolean r2 = r0.isDispatchNeeded(r8.getContext());
        if (r2 == true) goto L12;
        if (r6.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r6.getCurrentState().compareTo(r1) < 0) goto L12;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r6, r1, r2, r0, new AnonymousClass2(r7), r8);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle r0, Function0<? extends R> r1, Continuation<? super R> r2) {
        Lifecycle.State r3 = Lifecycle.State.RESUMED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation r4 = null;
        r4.getContext();
        throw null;
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner r6, Lifecycle.State r7, Function0<? extends R> r8, Continuation<? super R> r9) {
        Lifecycle r0 = r6.getLifecycle();
        if (r7.compareTo(Lifecycle.State.CREATED) < 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L19;
        MainCoroutineDispatcher r11 = Dispatchers.getMain().getImmediate();
        boolean r2 = r11.isDispatchNeeded(r9.getContext());
        if (r2 == true) goto L17;
        if (r0.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
        if (r0.getCurrentState().compareTo(r7) < 0) goto L17;
        return r8.invoke();
    L15:
        throw new LifecycleDestroyedException();
    L17:
        return suspendWithStateAtLeastUnchecked(r0, r7, r2, r11, new AnonymousClass2(r8), r9);
    L19:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r7).toString());
    L5:
        r10 = false;
        goto L6
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner r0, Lifecycle.State r1, Function0<? extends R> r2, Continuation<? super R> r3) {
        r0.getLifecycle();
        if (r1.compareTo(Lifecycle.State.CREATED) < 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L8;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation r5 = null;
        r5.getContext();
        throw null;
    L8:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r1).toString());
    L5:
        r4 = false;
        goto L6
    }

    public static final <R> Object withCreated(LifecycleOwner r6, Function0<? extends R> r7, Continuation<? super R> r8) {
        Lifecycle r0 = r6.getLifecycle();
        Lifecycle.State r1 = Lifecycle.State.CREATED;
        MainCoroutineDispatcher r9 = Dispatchers.getMain().getImmediate();
        boolean r2 = r9.isDispatchNeeded(r8.getContext());
        if (r2 == true) goto L12;
        if (r0.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r0.getCurrentState().compareTo(r1) < 0) goto L12;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r0, r1, r2, r9, new AnonymousClass2(r7), r8);
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner r0, Function0<? extends R> r1, Continuation<? super R> r2) {
        r0.getLifecycle();
        Lifecycle.State r3 = Lifecycle.State.CREATED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation r4 = null;
        r4.getContext();
        throw null;
    }

    public static final <R> Object withStarted(LifecycleOwner r6, Function0<? extends R> r7, Continuation<? super R> r8) {
        Lifecycle r0 = r6.getLifecycle();
        Lifecycle.State r1 = Lifecycle.State.STARTED;
        MainCoroutineDispatcher r9 = Dispatchers.getMain().getImmediate();
        boolean r2 = r9.isDispatchNeeded(r8.getContext());
        if (r2 == true) goto L12;
        if (r0.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r0.getCurrentState().compareTo(r1) < 0) goto L12;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r0, r1, r2, r9, new AnonymousClass2(r7), r8);
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner r0, Function0<? extends R> r1, Continuation<? super R> r2) {
        r0.getLifecycle();
        Lifecycle.State r3 = Lifecycle.State.STARTED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation r4 = null;
        r4.getContext();
        throw null;
    }

    public static final <R> Object withResumed(LifecycleOwner r6, Function0<? extends R> r7, Continuation<? super R> r8) {
        Lifecycle r0 = r6.getLifecycle();
        Lifecycle.State r1 = Lifecycle.State.RESUMED;
        MainCoroutineDispatcher r9 = Dispatchers.getMain().getImmediate();
        boolean r2 = r9.isDispatchNeeded(r8.getContext());
        if (r2 == true) goto L12;
        if (r0.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r0.getCurrentState().compareTo(r1) < 0) goto L12;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r0, r1, r2, r9, new AnonymousClass2(r7), r8);
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner r0, Function0<? extends R> r1, Continuation<? super R> r2) {
        r0.getLifecycle();
        Lifecycle.State r3 = Lifecycle.State.RESUMED;
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation r4 = null;
        r4.getContext();
        throw null;
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle r8, Lifecycle.State r9, Function0<? extends R> r10, Continuation<? super R> r11) {
        MainCoroutineDispatcher r0 = Dispatchers.getMain().getImmediate();
        boolean r4 = r0.isDispatchNeeded(r11.getContext());
        if (r4 == true) goto L13;
        if (r8.getCurrentState() == Lifecycle.State.DESTROYED) goto L11;
        if (r8.getCurrentState().compareTo(r9) < 0) goto L13;
        return r10.invoke();
    L11:
        throw new LifecycleDestroyedException();
    L13:
        return suspendWithStateAtLeastUnchecked(r8, r9, r4, r0, new AnonymousClass2(r10), r11);
    }

    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle r0, Lifecycle.State r1, Function0<? extends R> r2, Continuation<? super R> r3) {
        Dispatchers.getMain().getImmediate();
        InlineMarker.mark(3);
        Continuation r4 = null;
        r4.getContext();
        throw null;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1] */
    public static final <R> Object suspendWithStateAtLeastUnchecked(final Lifecycle r3, final Lifecycle.State r4, boolean r5, final CoroutineDispatcher r6, final Function0<? extends R> r7, Continuation<? super R> r8) {
        CancellableContinuationImpl r0 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r8), 1);
        r0.initCancellability();
        final CancellableContinuationImpl r1 = r0;
        final ?? r2 = new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(r4, r3, r1, r7);
        if (r5 == false) goto L5;
        r6.mo3067dispatch(EmptyCoroutineContext.INSTANCE, new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1(r3, r2));
    L6:
        r1.invokeOnCancellation(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(r6, r3, r2));
        Object r9 = r0.getResult();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r8);
    L9:
        return r9;
    L5:
        r3.addObserver((LifecycleObserver) r2);
        goto L6
    }
}
