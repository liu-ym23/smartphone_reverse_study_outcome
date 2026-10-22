package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import h.a.b1;
import h.a.b2;
import h.a.h;
import h.a.m0;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.d;
import kotlin.k0.g;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\rR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Landroidx/lifecycle/LifecycleCoroutineScopeImpl;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/LifecycleEventObserver;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/CoroutineContext;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "getLifecycle$lifecycle_runtime_ktx_release", "()Landroidx/lifecycle/Lifecycle;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "register", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    private final g coroutineContext;
    private final Lifecycle lifecycle;

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1, reason: invalid class name */
    @f(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass1 extends l implements p<m0, d<? super f0>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ LifecycleCoroutineScopeImpl this$0;

        AnonymousClass1(LifecycleCoroutineScopeImpl r1, d<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r2, d<?> r3) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r3);
            r0.L$0 = r2;
            return r0;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, d<? super f0> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r3) {
            kotlin.k0.i.b.c();
            if (this.label != 0) goto L11;
            w.b(r3);
            m0 r4 = (m0) this.L$0;
            if (this.this$0.getLifecycle$lifecycle_runtime_ktx_release().getCurrentState().compareTo(Lifecycle.State.INITIALIZED) < 0) goto L7;
            this.this$0.getLifecycle$lifecycle_runtime_ktx_release().addObserver(this.this$0);
        L9:
            return f0.f18324a;
        L7:
            b2.d(r4.getCoroutineContext(), null, 1, null);
            goto L9
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public LifecycleCoroutineScopeImpl(Lifecycle r2, g r3) {
        o.f(r2, "lifecycle");
        o.f(r3, "coroutineContext");
        this.lifecycle = r2;
        this.coroutineContext = r3;
        if (getLifecycle$lifecycle_runtime_ktx_release().getCurrentState() != Lifecycle.State.DESTROYED) goto L6;
        b2.d(getCoroutineContext(), null, 1, null);
        return;
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope, h.a.m0
    public g getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    public Lifecycle getLifecycle$lifecycle_runtime_ktx_release() {
        return this.lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        o.f(r2, "source");
        o.f(r3, NotificationCompat.CATEGORY_EVENT);
        if (getLifecycle$lifecycle_runtime_ktx_release().getCurrentState().compareTo(Lifecycle.State.DESTROYED) > 0) goto L6;
        getLifecycle$lifecycle_runtime_ktx_release().removeObserver(this);
        b2.d(getCoroutineContext(), null, 1, null);
        return;
    }

    public final void register() {
        h.b(this, b1.c().h0(), null, new AnonymousClass1(this, null), 2, null);
    }
}
