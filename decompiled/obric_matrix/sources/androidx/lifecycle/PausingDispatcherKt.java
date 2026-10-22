package androidx.lifecycle;

import h.a.b1;
import h.a.h;
import h.a.m0;
import h.a.x1;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.d;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aD\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001aD\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\n2'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aD\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001aD\u0010\f\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\n2'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aD\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\t\u001aD\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\n2'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aL\u0010\u000e\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102'\u0010\u0003\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"whenCreated", "T", "Landroidx/lifecycle/Lifecycle;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "whenResumed", "whenStarted", "whenStateAtLeast", "minState", "Landroidx/lifecycle/Lifecycle$State;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PausingDispatcherKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2, reason: invalid class name */
    @f(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", l = {162}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass2<T> extends l implements p<m0, d<? super T>, Object> {
        final /* synthetic */ p<m0, d<? super T>, Object> $block;
        final /* synthetic */ Lifecycle.State $minState;
        final /* synthetic */ Lifecycle $this_whenStateAtLeast;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Lifecycle r1, Lifecycle.State r2, p<? super m0, ? super d<? super T>, ? extends Object> r3, d<? super AnonymousClass2> r4) {
            this.$this_whenStateAtLeast = r1;
            this.$minState = r2;
            this.$block = r3;
            super(2, r4);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r4, d<?> r5) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$this_whenStateAtLeast, this.$minState, this.$block, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(m0 r1, d<? super T> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, Object r2) {
            return invoke(r1, (d) r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 != 1) goto L11;
            LifecycleController r7 = (LifecycleController) this.L$0;
            w.b(r8);     // Catch: Throwable -> L8
        L19:
            r7.finish();
            return r8;
        L8:
            th = th;
        L23:
            r7.finish();
            throw th;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            w.b(r8);
            x1 r9 = (x1) ((m0) this.L$0).getCoroutineContext().get(x1.f17584d);
            if (r9 == null) goto L26;
            PausingDispatcher r2 = new PausingDispatcher();
            LifecycleController r3 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, r2.dispatchQueue, r9);
            p<m0, d<? super T>, Object> r10 = this.$block;     // Catch: Throwable -> L21
            this.L$0 = r3;     // Catch: Throwable -> L21
            this.label = 1;     // Catch: Throwable -> L21
            r8 = h.e(r2, r10, this);     // Catch: Throwable -> L21
            if (r8 != r0) goto L18;
            return r0;
        L18:
            r7 = r3;
        L21:
            th = th;
            r7 = r3;
            goto L23
        L26:
            throw new IllegalStateException("when[State] methods should have a parent job".toString());
        }
    }

    public static final <T> Object whenCreated(Lifecycle r1, p<? super m0, ? super d<? super T>, ? extends Object> r2, d<? super T> r3) {
        return whenStateAtLeast(r1, Lifecycle.State.CREATED, r2, r3);
    }

    public static final <T> Object whenCreated(LifecycleOwner r1, p<? super m0, ? super d<? super T>, ? extends Object> r2, d<? super T> r3) {
        Lifecycle r4 = r1.getLifecycle();
        o.e(r4, "lifecycle");
        return whenCreated(r4, r2, r3);
    }

    public static final <T> Object whenResumed(Lifecycle r1, p<? super m0, ? super d<? super T>, ? extends Object> r2, d<? super T> r3) {
        return whenStateAtLeast(r1, Lifecycle.State.RESUMED, r2, r3);
    }

    public static final <T> Object whenResumed(LifecycleOwner r1, p<? super m0, ? super d<? super T>, ? extends Object> r2, d<? super T> r3) {
        Lifecycle r4 = r1.getLifecycle();
        o.e(r4, "lifecycle");
        return whenResumed(r4, r2, r3);
    }

    public static final <T> Object whenStarted(Lifecycle r1, p<? super m0, ? super d<? super T>, ? extends Object> r2, d<? super T> r3) {
        return whenStateAtLeast(r1, Lifecycle.State.STARTED, r2, r3);
    }

    public static final <T> Object whenStarted(LifecycleOwner r1, p<? super m0, ? super d<? super T>, ? extends Object> r2, d<? super T> r3) {
        Lifecycle r4 = r1.getLifecycle();
        o.e(r4, "lifecycle");
        return whenStarted(r4, r2, r3);
    }

    public static final <T> Object whenStateAtLeast(Lifecycle r3, Lifecycle.State r4, p<? super m0, ? super d<? super T>, ? extends Object> r5, d<? super T> r6) {
        return h.e(b1.c().h0(), new AnonymousClass2(r3, r4, r5, null), r6);
    }
}
