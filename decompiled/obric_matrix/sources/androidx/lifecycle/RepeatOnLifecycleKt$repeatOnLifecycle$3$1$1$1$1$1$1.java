package androidx.lifecycle;

import h.a.m0;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.d;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.w;

/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {111}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 extends l implements p<m0, d<? super f0>, Object> {
    final /* synthetic */ p<m0, d<? super f0>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(p<? super m0, ? super d<? super f0>, ? extends Object> r1, d<? super RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1> r2) {
        this.$block = r1;
        super(2, r2);
    }

    @Override // kotlin.k0.j.a.a
    public final d<f0> create(Object r2, d<?> r3) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 r0 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(this.$block, r3);
        r0.L$0 = r2;
        return r0;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(m0 r1, d<? super f0> r2) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1) create(r1, r2)).invokeSuspend(f0.f18324a);
    }

    @Override // kotlin.n0.c.p
    public /* bridge */ /* synthetic */ Object invoke(m0 r1, d<? super f0> r2) {
        return invoke2(r1, r2);
    }

    @Override // kotlin.k0.j.a.a
    public final Object invokeSuspend(Object r4) {
        Object r0 = kotlin.k0.i.b.c();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        w.b(r4);
    L12:
        return f0.f18324a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        w.b(r4);
        m0 r5 = (m0) this.L$0;
        p<m0, d<? super f0>, Object> r2 = this.$block;
        this.label = 1;
        if (r2.invoke(r5, this) != r0) goto L12;
        return r0;
    }
}
