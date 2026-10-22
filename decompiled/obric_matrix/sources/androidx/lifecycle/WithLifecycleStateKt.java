package androidx.lifecycle;

import com.bytedance.common.wschannel.WsConstants;
import h.a.b1;
import h.a.g0;
import h.a.i2;
import h.a.o;
import kotlin.Metadata;
import kotlin.k0.d;
import kotlin.k0.h;
import kotlin.n0.d.n;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001aA\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a+\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0010\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\u0010\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0011\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\r\u001a+\u0010\u0011\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a3\u0010\u0012\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a3\u0010\u0012\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a3\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0004\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\u0081Hø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"suspendWithStateAtLeastUnchecked", "R", "Landroidx/lifecycle/Lifecycle;", WsConstants.KEY_CONNECTION_STATE, "Landroidx/lifecycle/Lifecycle$State;", "dispatchNeeded", "", "lifecycleDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "block", "Lkotlin/Function0;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;ZLkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withCreated", "(Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withResumed", "withStarted", "withStateAtLeast", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withStateAtLeastUnchecked", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class WithLifecycleStateKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.lifecycle.WithLifecycleStateKt$withStateAtLeastUnchecked$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "R", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 176)
    public static final class AnonymousClass2<R> extends q implements kotlin.n0.c.a<R> {
        final /* synthetic */ kotlin.n0.c.a<R> $block;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(kotlin.n0.c.a<? extends R> r1) {
            this.$block = r1;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public final R invoke() {
            return this.$block.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.lifecycle.LifecycleObserver, androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1] */
    public static final <R> Object suspendWithStateAtLeastUnchecked(final Lifecycle r3, final Lifecycle.State r4, boolean r5, g0 r6, final kotlin.n0.c.a<? extends R> r7, d<? super R> r8) {
        final o r0 = new o(kotlin.k0.i.b.b(r8), 1);
        r0.A();
        final ?? r1 = new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(r4, r3, r0, r7);
        if (r5 == false) goto L5;
        r6.dispatch(h.f18399f, new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1(r3, r1));
    L6:
        r0.h(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(r6, r3, r1));
        Object r9 = r0.x();
        if (r9 != kotlin.k0.i.b.c()) goto L9;
        kotlin.k0.j.a.h.c(r8);
    L9:
        return r9;
    L5:
        r3.addObserver(r1);
        goto L6
    }

    public static final <R> Object withCreated(Lifecycle r6, kotlin.n0.c.a<? extends R> r7, d<? super R> r8) {
        Lifecycle.State r1 = Lifecycle.State.CREATED;
        i2 r3 = b1.c().h0();
        boolean r2 = r3.isDispatchNeeded(r8.getContext());
        if (r2 == true) goto L12;
        if (r6.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r6.getCurrentState().compareTo(r1) < 0) goto L12;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r6, r1, r2, r3, new AnonymousClass2(r7), r8);
    }

    public static final <R> Object withCreated(LifecycleOwner r6, kotlin.n0.c.a<? extends R> r7, d<? super R> r8) {
        Lifecycle r0 = r6.getLifecycle();
        kotlin.n0.d.o.e(r0, "lifecycle");
        Lifecycle.State r1 = Lifecycle.State.CREATED;
        i2 r3 = b1.c().h0();
        boolean r2 = r3.isDispatchNeeded(r8.getContext());
        if (r2 == true) goto L12;
        if (r0.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r0.getCurrentState().compareTo(r1) < 0) goto L12;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r0, r1, r2, r3, new AnonymousClass2(r7), r8);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle r6, kotlin.n0.c.a<? extends R> r7, d<? super R> r8) {
        Lifecycle.State r1 = Lifecycle.State.CREATED;
        i2 r3 = b1.c().h0();
        n.c(3);
        d r0 = null;
        boolean r2 = r3.isDispatchNeeded(r0.getContext());
        if (r2 == false) goto L5;
    L11:
        AnonymousClass2 r4 = new AnonymousClass2(r7);
        n.c(0);
        Object r9 = suspendWithStateAtLeastUnchecked(r6, r1, r2, r3, r4, r8);
        n.c(1);
        return r9;
    L5:
        if (r6.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r6.getCurrentState().compareTo(r1) < 0) goto L11;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner r6, kotlin.n0.c.a<? extends R> r7, d<? super R> r8) {
        Lifecycle r0 = r6.getLifecycle();
        kotlin.n0.d.o.e(r0, "lifecycle");
        Lifecycle.State r1 = Lifecycle.State.CREATED;
        i2 r3 = b1.c().h0();
        n.c(3);
        d r9 = null;
        boolean r2 = r3.isDispatchNeeded(r9.getContext());
        if (r2 == false) goto L5;
    L11:
        AnonymousClass2 r4 = new AnonymousClass2(r7);
        n.c(0);
        Object r10 = suspendWithStateAtLeastUnchecked(r0, r1, r2, r3, r4, r8);
        n.c(1);
        return r10;
    L5:
        if (r0.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r0.getCurrentState().compareTo(r1) < 0) goto L11;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    }

    public static final <R> Object withResumed(Lifecycle r6, kotlin.n0.c.a<? extends R> r7, d<? super R> r8) {
        Lifecycle.State r1 = Lifecycle.State.RESUMED;
        i2 r3 = b1.c().h0();
        boolean r2 = r3.isDispatchNeeded(r8.getContext());
        if (r2 == true) goto L12;
        if (r6.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r6.getCurrentState().compareTo(r1) < 0) goto L12;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r6, r1, r2, r3, new AnonymousClass2(r7), r8);
    }

    public static final <R> Object withResumed(LifecycleOwner r6, kotlin.n0.c.a<? extends R> r7, d<? super R> r8) {
        Lifecycle r0 = r6.getLifecycle();
        kotlin.n0.d.o.e(r0, "lifecycle");
        Lifecycle.State r1 = Lifecycle.State.RESUMED;
        i2 r3 = b1.c().h0();
        boolean r2 = r3.isDispatchNeeded(r8.getContext());
        if (r2 == true) goto L12;
        if (r0.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r0.getCurrentState().compareTo(r1) < 0) goto L12;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r0, r1, r2, r3, new AnonymousClass2(r7), r8);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle r6, kotlin.n0.c.a<? extends R> r7, d<? super R> r8) {
        Lifecycle.State r1 = Lifecycle.State.RESUMED;
        i2 r3 = b1.c().h0();
        n.c(3);
        d r0 = null;
        boolean r2 = r3.isDispatchNeeded(r0.getContext());
        if (r2 == false) goto L5;
    L11:
        AnonymousClass2 r4 = new AnonymousClass2(r7);
        n.c(0);
        Object r9 = suspendWithStateAtLeastUnchecked(r6, r1, r2, r3, r4, r8);
        n.c(1);
        return r9;
    L5:
        if (r6.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r6.getCurrentState().compareTo(r1) < 0) goto L11;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner r6, kotlin.n0.c.a<? extends R> r7, d<? super R> r8) {
        Lifecycle r0 = r6.getLifecycle();
        kotlin.n0.d.o.e(r0, "lifecycle");
        Lifecycle.State r1 = Lifecycle.State.RESUMED;
        i2 r3 = b1.c().h0();
        n.c(3);
        d r9 = null;
        boolean r2 = r3.isDispatchNeeded(r9.getContext());
        if (r2 == false) goto L5;
    L11:
        AnonymousClass2 r4 = new AnonymousClass2(r7);
        n.c(0);
        Object r10 = suspendWithStateAtLeastUnchecked(r0, r1, r2, r3, r4, r8);
        n.c(1);
        return r10;
    L5:
        if (r0.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r0.getCurrentState().compareTo(r1) < 0) goto L11;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    }

    public static final <R> Object withStarted(Lifecycle r6, kotlin.n0.c.a<? extends R> r7, d<? super R> r8) {
        Lifecycle.State r1 = Lifecycle.State.STARTED;
        i2 r3 = b1.c().h0();
        boolean r2 = r3.isDispatchNeeded(r8.getContext());
        if (r2 == true) goto L12;
        if (r6.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r6.getCurrentState().compareTo(r1) < 0) goto L12;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r6, r1, r2, r3, new AnonymousClass2(r7), r8);
    }

    public static final <R> Object withStarted(LifecycleOwner r6, kotlin.n0.c.a<? extends R> r7, d<? super R> r8) {
        Lifecycle r0 = r6.getLifecycle();
        kotlin.n0.d.o.e(r0, "lifecycle");
        Lifecycle.State r1 = Lifecycle.State.STARTED;
        i2 r3 = b1.c().h0();
        boolean r2 = r3.isDispatchNeeded(r8.getContext());
        if (r2 == true) goto L12;
        if (r0.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r0.getCurrentState().compareTo(r1) < 0) goto L12;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    L12:
        return suspendWithStateAtLeastUnchecked(r0, r1, r2, r3, new AnonymousClass2(r7), r8);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle r6, kotlin.n0.c.a<? extends R> r7, d<? super R> r8) {
        Lifecycle.State r1 = Lifecycle.State.STARTED;
        i2 r3 = b1.c().h0();
        n.c(3);
        d r0 = null;
        boolean r2 = r3.isDispatchNeeded(r0.getContext());
        if (r2 == false) goto L5;
    L11:
        AnonymousClass2 r4 = new AnonymousClass2(r7);
        n.c(0);
        Object r9 = suspendWithStateAtLeastUnchecked(r6, r1, r2, r3, r4, r8);
        n.c(1);
        return r9;
    L5:
        if (r6.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r6.getCurrentState().compareTo(r1) < 0) goto L11;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner r6, kotlin.n0.c.a<? extends R> r7, d<? super R> r8) {
        Lifecycle r0 = r6.getLifecycle();
        kotlin.n0.d.o.e(r0, "lifecycle");
        Lifecycle.State r1 = Lifecycle.State.STARTED;
        i2 r3 = b1.c().h0();
        n.c(3);
        d r9 = null;
        boolean r2 = r3.isDispatchNeeded(r9.getContext());
        if (r2 == false) goto L5;
    L11:
        AnonymousClass2 r4 = new AnonymousClass2(r7);
        n.c(0);
        Object r10 = suspendWithStateAtLeastUnchecked(r0, r1, r2, r3, r4, r8);
        n.c(1);
        return r10;
    L5:
        if (r0.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        if (r0.getCurrentState().compareTo(r1) < 0) goto L11;
        return r7.invoke();
    L10:
        throw new LifecycleDestroyedException();
    }

    public static final <R> Object withStateAtLeast(Lifecycle r7, Lifecycle.State r8, kotlin.n0.c.a<? extends R> r9, d<? super R> r10) {
        if (r8.compareTo(Lifecycle.State.CREATED) < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L19;
        i2 r4 = b1.c().h0();
        boolean r3 = r4.isDispatchNeeded(r10.getContext());
        if (r3 == true) goto L17;
        if (r7.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
        if (r7.getCurrentState().compareTo(r8) < 0) goto L17;
        return r9.invoke();
    L15:
        throw new LifecycleDestroyedException();
    L17:
        return suspendWithStateAtLeastUnchecked(r7, r8, r3, r4, new AnonymousClass2(r9), r10);
    L19:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r8).toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner r6, Lifecycle.State r7, kotlin.n0.c.a<? extends R> r8, d<? super R> r9) {
        Lifecycle r0 = r6.getLifecycle();
        kotlin.n0.d.o.e(r0, "lifecycle");
        if (r7.compareTo(Lifecycle.State.CREATED) < 0) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L19;
        i2 r3 = b1.c().h0();
        boolean r2 = r3.isDispatchNeeded(r9.getContext());
        if (r2 == true) goto L17;
        if (r0.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
        if (r0.getCurrentState().compareTo(r7) < 0) goto L17;
        return r8.invoke();
    L15:
        throw new LifecycleDestroyedException();
    L17:
        return suspendWithStateAtLeastUnchecked(r0, r7, r2, r3, new AnonymousClass2(r8), r9);
    L19:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r7).toString());
    L5:
        r10 = false;
        goto L6
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle r9, Lifecycle.State r10, kotlin.n0.c.a<? extends R> r11, d<? super R> r12) {
        if (r10.compareTo(Lifecycle.State.CREATED) < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L19;
        i2 r6 = b1.c().h0();
        n.c(3);
        d r1 = null;
        boolean r5 = r6.isDispatchNeeded(r1.getContext());
        if (r5 == false) goto L10;
    L16:
        AnonymousClass2 r7 = new AnonymousClass2(r11);
        n.c(0);
        Object r13 = suspendWithStateAtLeastUnchecked(r9, r10, r5, r6, r7, r12);
        n.c(1);
        return r13;
    L10:
        if (r9.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
        if (r9.getCurrentState().compareTo(r10) < 0) goto L16;
        return r11.invoke();
    L15:
        throw new LifecycleDestroyedException();
    L19:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r10).toString());
    L5:
        r0 = false;
        goto L6
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner r7, Lifecycle.State r8, kotlin.n0.c.a<? extends R> r9, d<? super R> r10) {
        Lifecycle r0 = r7.getLifecycle();
        kotlin.n0.d.o.e(r0, "lifecycle");
        if (r8.compareTo(Lifecycle.State.CREATED) < 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L19;
        i2 r3 = b1.c().h0();
        n.c(3);
        d r12 = null;
        boolean r2 = r3.isDispatchNeeded(r12.getContext());
        if (r2 == false) goto L10;
    L16:
        AnonymousClass2 r4 = new AnonymousClass2(r9);
        n.c(0);
        Object r13 = suspendWithStateAtLeastUnchecked(r0, r8, r2, r3, r4, r10);
        n.c(1);
        return r13;
    L10:
        if (r0.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
        if (r0.getCurrentState().compareTo(r8) < 0) goto L16;
        return r9.invoke();
    L15:
        throw new LifecycleDestroyedException();
    L19:
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + r8).toString());
    L5:
        r11 = false;
        goto L6
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle r7, Lifecycle.State r8, kotlin.n0.c.a<? extends R> r9, d<? super R> r10) {
        i2 r4 = b1.c().h0();
        boolean r3 = r4.isDispatchNeeded(r10.getContext());
        if (r3 == true) goto L13;
        if (r7.getCurrentState() == Lifecycle.State.DESTROYED) goto L11;
        if (r7.getCurrentState().compareTo(r8) < 0) goto L13;
        return r9.invoke();
    L11:
        throw new LifecycleDestroyedException();
    L13:
        return suspendWithStateAtLeastUnchecked(r7, r8, r3, r4, new AnonymousClass2(r9), r10);
    }

    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle r7, Lifecycle.State r8, kotlin.n0.c.a<? extends R> r9, d<? super R> r10) {
        i2 r4 = b1.c().h0();
        n.c(3);
        d r0 = null;
        boolean r3 = r4.isDispatchNeeded(r0.getContext());
        if (r3 == false) goto L5;
    L12:
        AnonymousClass2 r5 = new AnonymousClass2(r9);
        n.c(0);
        Object r11 = suspendWithStateAtLeastUnchecked(r7, r8, r3, r4, r5, r10);
        n.c(1);
        return r11;
    L5:
        if (r7.getCurrentState() == Lifecycle.State.DESTROYED) goto L11;
        if (r7.getCurrentState().compareTo(r8) < 0) goto L12;
        return r9.invoke();
    L11:
        throw new LifecycleDestroyedException();
    }
}
