package androidx.lifecycle;

import h.a.d3.t;
import h.a.d3.z;
import h.a.e3.e;
import h.a.e3.g;
import h.a.m0;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.d;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"flowWithLifecycle", "Lkotlinx/coroutines/flow/Flow;", "T", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "minActiveState", "Landroidx/lifecycle/Lifecycle$State;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FlowExtKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1, reason: invalid class name */
    @f(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", l = {91}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass1<T> extends l implements p<t<? super T>, d<? super f0>, Object> {
        final /* synthetic */ Lifecycle $lifecycle;
        final /* synthetic */ Lifecycle.State $minActiveState;
        final /* synthetic */ e<T> $this_flowWithLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1, reason: invalid class name and collision with other inner class name */
        @f(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", l = {92}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class C00171 extends l implements p<m0, d<? super f0>, Object> {
            final /* synthetic */ t<T> $$this$callbackFlow;
            final /* synthetic */ e<T> $this_flowWithLifecycle;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            C00171(e<? extends T> r1, t<? super T> r2, d<? super C00171> r3) {
                this.$this_flowWithLifecycle = r1;
                this.$$this$callbackFlow = r2;
                super(2, r3);
            }

            @Override // kotlin.k0.j.a.a
            public final d<f0> create(Object r2, d<?> r3) {
                return new C00171(this.$this_flowWithLifecycle, this.$$this$callbackFlow, r3);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(m0 r1, d<? super f0> r2) {
                return ((C00171) create(r1, r2)).invokeSuspend(f0.f18324a);
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ Object invoke(m0 r1, d<? super f0> r2) {
                return invoke2(r1, r2);
            }

            @Override // kotlin.k0.j.a.a
            public final Object invokeSuspend(Object r5) {
                Object r0 = kotlin.k0.i.b.c();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                w.b(r5);
            L12:
                return f0.f18324a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                w.b(r5);
                e<T> r6 = this.$this_flowWithLifecycle;
                final t<T> r3 = this.$$this$callbackFlow;
                h.a.e3.f<? super T> r2 = new C00181(r3);
                this.label = 1;
                if (r6.collect(r2, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Lifecycle r1, Lifecycle.State r2, e<? extends T> r3, d<? super AnonymousClass1> r4) {
            this.$lifecycle = r1;
            this.$minActiveState = r2;
            this.$this_flowWithLifecycle = r3;
            super(2, r4);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r4, d<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$lifecycle, this.$minActiveState, this.$this_flowWithLifecycle, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(t<? super T> r1, d<? super f0> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(Object r1, d<? super f0> r2) {
            return invoke((t) r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            t r7 = (t) this.L$0;
            w.b(r8);
        L12:
            z.a.a(r7, null, 1, null);
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            w.b(r8);
            t r9 = (t) this.L$0;
            Lifecycle r2 = this.$lifecycle;
            Lifecycle.State r4 = this.$minActiveState;
            C00171 r5 = new C00171(this.$this_flowWithLifecycle, r9, null);
            this.L$0 = r9;
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r2, r4, r5, this) != r0) goto L11;
            return r0;
        L11:
            r7 = r9;
            goto L12
        }
    }

    public static final <T> e<T> flowWithLifecycle(e<? extends T> r2, Lifecycle r3, Lifecycle.State r4) {
        o.f(r2, "<this>");
        o.f(r3, "lifecycle");
        o.f(r4, "minActiveState");
        return g.c(new AnonymousClass1(r3, r4, r2, null));
    }

    public static /* synthetic */ e flowWithLifecycle$default(e r0, Lifecycle r1, Lifecycle.State r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = Lifecycle.State.STARTED;
    L6:
        return flowWithLifecycle(r0, r1, r2);
    }
}
