package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.p;
import kotlin.w;

/* JADX INFO: loaded from: classes.dex */
@kotlin.k0.j.a.f(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {414, TypedValues.CycleType.TYPE_PATH_ROTATE}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroid/view/View;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ViewKt$allViews$1 extends kotlin.k0.j.a.k implements p<kotlin.t0.j<? super View>, kotlin.k0.d<? super f0>, Object> {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    ViewKt$allViews$1(View r1, kotlin.k0.d<? super ViewKt$allViews$1> r2) {
        this.$this_allViews = r1;
        super(2, r2);
    }

    @Override // kotlin.k0.j.a.a
    public final kotlin.k0.d<f0> create(Object r2, kotlin.k0.d<?> r3) {
        ViewKt$allViews$1 r0 = new ViewKt$allViews$1(this.$this_allViews, r3);
        r0.L$0 = r2;
        return r0;
    }

    @Override // kotlin.n0.c.p
    public /* bridge */ /* synthetic */ Object invoke(kotlin.t0.j<? super View> r1, kotlin.k0.d<? super f0> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlin.t0.j<? super View> r1, kotlin.k0.d<? super f0> r2) {
        return ((ViewKt$allViews$1) create(r1, r2)).invokeSuspend(f0.f18324a);
    }

    @Override // kotlin.k0.j.a.a
    public final Object invokeSuspend(Object r5) {
        Object r0 = kotlin.k0.i.b.c();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        w.b(r5);
    L19:
        return f0.f18324a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        kotlin.t0.j r2 = (kotlin.t0.j) this.L$0;
        w.b(r5);
    L13:
        View r6 = this.$this_allViews;
        if ((r6 instanceof ViewGroup) == false) goto L19;
        kotlin.t0.h<View> r7 = ViewGroupKt.getDescendants((ViewGroup) r6);
        this.L$0 = null;
        this.label = 2;
        if (r2.f(r7, this) != r0) goto L19;
        return r0;
    L10:
        w.b(r5);
        r2 = (kotlin.t0.j) this.L$0;
        View r8 = this.$this_allViews;
        this.L$0 = r2;
        this.label = 1;
        if (r2.b(r8, this) != r0) goto L13;
        return r0;
    }
}
