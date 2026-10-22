package androidx.lifecycle;

import com.bytedance.common.wschannel.WsConstants;
import h.a.b1;
import h.a.i2;
import h.a.m0;
import h.a.n0;
import h.a.o;
import h.a.x1;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.d;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.h;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.d0;
import kotlin.w;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042'\u0010\u0005\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\b\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"repeatOnLifecycle", "", "Landroidx/lifecycle/Lifecycle;", WsConstants.KEY_CONNECTION_STATE, "Landroidx/lifecycle/Lifecycle$State;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RepeatOnLifecycleKt {

    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3, reason: invalid class name */
    @f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {84}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass3 extends l implements p<m0, d<? super f0>, Object> {
        final /* synthetic */ p<m0, d<? super f0>, Object> $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
        @f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {166}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
        static final class AnonymousClass1 extends l implements p<m0, d<? super f0>, Object> {
            final /* synthetic */ m0 $$this$coroutineScope;
            final /* synthetic */ p<m0, d<? super f0>, Object> $block;
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
            AnonymousClass1(Lifecycle r1, Lifecycle.State r2, m0 r3, p<? super m0, ? super d<? super f0>, ? extends Object> r4, d<? super AnonymousClass1> r5) {
                this.$this_repeatOnLifecycle = r1;
                this.$state = r2;
                this.$$this$coroutineScope = r3;
                this.$block = r4;
                super(2, r5);
            }

            @Override // kotlin.k0.j.a.a
            public final d<f0> create(Object r7, d<?> r8) {
                return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, r8);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(m0 r1, d<? super f0> r2) {
                return ((AnonymousClass1) create(r1, r2)).invokeSuspend(f0.f18324a);
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ Object invoke(m0 r1, d<? super f0> r2) {
                return invoke2(r1, r2);
            }

            /* JADX WARN: Type inference failed for: r10v0, types: [T, androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1] */
            @Override // kotlin.k0.j.a.a
            public final Object invokeSuspend(Object r17) {
                Object r0 = kotlin.k0.i.b.c();
                int r2 = this.label;
                if (r2 == 0) goto L12;
                if (r2 != 1) goto L11;
                p r1 = (p) this.L$5;
                m0 r3 = (m0) this.L$4;
                Lifecycle r4 = (Lifecycle) this.L$3;
                Lifecycle.State r5 = (Lifecycle.State) this.L$2;
                d0 r6 = (d0) this.L$1;
                d0 r7 = (d0) this.L$0;
                w.b(r17);     // Catch: Throwable -> L8
            L23:
                x1 r8 = (x1) r7.f18431f;
                if (r8 == null) goto L26;
                x1.a.a(r8, null, 1, null);
            L26:
                LifecycleEventObserver r9 = (LifecycleEventObserver) r6.f18431f;
                if (r9 == null) goto L30;
                this.$this_repeatOnLifecycle.removeObserver(r9);
            L30:
                return f0.f18324a;
            L8:
                th = th;
            L33:
                x1 r10 = (x1) r7.f18431f;
                if (r10 == null) goto L36;
                x1.a.a(r10, null, 1, null);
            L36:
                LifecycleEventObserver r11 = (LifecycleEventObserver) r6.f18431f;
                if (r11 == null) goto L39;
                this.$this_repeatOnLifecycle.removeObserver(r11);
            L39:
                throw th;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L12:
                w.b(r17);
                if (this.$this_repeatOnLifecycle.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
                final d0 r12 = new d0();
                d0 r13 = new d0();
                Lifecycle.State r14 = this.$state;     // Catch: Throwable -> L31
                Lifecycle r15 = this.$this_repeatOnLifecycle;     // Catch: Throwable -> L31
                final m0 r16 = this.$$this$coroutineScope;     // Catch: Throwable -> L31
                final p<m0, d<? super f0>, Object> r18 = this.$block;     // Catch: Throwable -> L31
                this.L$0 = r12;     // Catch: Throwable -> L31
                this.L$1 = r13;     // Catch: Throwable -> L31
                this.L$2 = r14;     // Catch: Throwable -> L31
                this.L$3 = r15;     // Catch: Throwable -> L31
                this.L$4 = r16;     // Catch: Throwable -> L31
                this.L$5 = r18;     // Catch: Throwable -> L31
                this.label = 1;     // Catch: Throwable -> L31
                final o r19 = new o(kotlin.k0.i.b.b(this), 1);     // Catch: Throwable -> L31
                r19.A();     // Catch: Throwable -> L31
                final Lifecycle.Event r20 = Lifecycle.Event.upTo(r14);     // Catch: Throwable -> L31
                final Lifecycle.Event r21 = Lifecycle.Event.downFrom(r14);     // Catch: Throwable -> L31
                final h.a.j3.b r110 = h.a.j3.d.b(false, 1, null);     // Catch: Throwable -> L31
                ?? r111 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1(r20, r12, r16, r21, r19, r110, r18);     // Catch: Throwable -> L31
                r13.f18431f = r111;     // Catch: Throwable -> L31
                r15.addObserver((LifecycleEventObserver) r111);     // Catch: Throwable -> L31
                Object r22 = r19.x();     // Catch: Throwable -> L31
                if (r22 != kotlin.k0.i.b.c()) goto L20;
                h.c(this);     // Catch: Throwable -> L31
            L20:
                if (r22 != r0) goto L22;
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
                return f0.f18324a;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Lifecycle r1, Lifecycle.State r2, p<? super m0, ? super d<? super f0>, ? extends Object> r3, d<? super AnonymousClass3> r4) {
            this.$this_repeatOnLifecycle = r1;
            this.$state = r2;
            this.$block = r3;
            super(2, r4);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r4, d<?> r5) {
            AnonymousClass3 r0 = new AnonymousClass3(this.$this_repeatOnLifecycle, this.$state, this.$block, r5);
            r0.L$0 = r4;
            return r0;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(m0 r1, d<? super f0> r2) {
            return ((AnonymousClass3) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(m0 r1, d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            w.b(r10);
        L12:
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            w.b(r10);
            m0 r6 = (m0) this.L$0;
            i2 r11 = b1.c().h0();
            AnonymousClass1 r2 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, r6, this.$block, null);
            this.label = 1;
            if (h.a.h.e(r11, r2, this) != r0) goto L12;
            return r0;
        }
    }

    public static final Object repeatOnLifecycle(Lifecycle r2, Lifecycle.State r3, p<? super m0, ? super d<? super f0>, ? extends Object> r4, d<? super f0> r5) {
        if (r3 == Lifecycle.State.INITIALIZED) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L17;
        if (r2.getCurrentState() == Lifecycle.State.DESTROYED) goto L10;
        Object r6 = n0.e(new AnonymousClass3(r2, r3, r4, null), r5);
        if (r6 != kotlin.k0.i.b.c()) goto L15;
        return r6;
    L15:
        return f0.f18324a;
    L10:
        return f0.f18324a;
    L17:
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final Object repeatOnLifecycle(LifecycleOwner r1, Lifecycle.State r2, p<? super m0, ? super d<? super f0>, ? extends Object> r3, d<? super f0> r4) {
        Lifecycle r5 = r1.getLifecycle();
        kotlin.n0.d.o.e(r5, "lifecycle");
        Object r6 = repeatOnLifecycle(r5, r2, r3, r4);
        if (r6 != kotlin.k0.i.b.c()) goto L6;
        return r6;
    L6:
        return f0.f18324a;
    }
}
