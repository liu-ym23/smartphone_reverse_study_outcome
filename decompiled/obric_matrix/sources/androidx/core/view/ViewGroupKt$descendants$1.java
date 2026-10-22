package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: loaded from: classes.dex */
@kotlin.k0.j.a.f(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", l = {119, 121}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Landroid/view/View;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class ViewGroupKt$descendants$1 extends kotlin.k0.j.a.k implements p<kotlin.t0.j<? super View>, kotlin.k0.d<? super f0>, Object> {
    final /* synthetic */ ViewGroup $this_descendants;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    ViewGroupKt$descendants$1(ViewGroup r1, kotlin.k0.d<? super ViewGroupKt$descendants$1> r2) {
        this.$this_descendants = r1;
        super(2, r2);
    }

    @Override // kotlin.k0.j.a.a
    public final kotlin.k0.d<f0> create(Object r2, kotlin.k0.d<?> r3) {
        ViewGroupKt$descendants$1 r0 = new ViewGroupKt$descendants$1(this.$this_descendants, r3);
        r0.L$0 = r2;
        return r0;
    }

    @Override // kotlin.n0.c.p
    public /* bridge */ /* synthetic */ Object invoke(kotlin.t0.j<? super View> r1, kotlin.k0.d<? super f0> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlin.t0.j<? super View> r1, kotlin.k0.d<? super f0> r2) {
        return ((ViewGroupKt$descendants$1) create(r1, r2)).invokeSuspend(f0.f18324a);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008a -> B:22:0x008c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0091 -> B:24:0x0093). Please report as a decompilation issue!!! */
    @Override // kotlin.k0.j.a.a
    public final Object invokeSuspend(Object r10) {
        Object r0 = kotlin.k0.i.b.c();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        int r2 = this.I$1;
        int r4 = this.I$0;
        ViewGroup r5 = (ViewGroup) this.L$1;
        kotlin.t0.j r6 = (kotlin.t0.j) this.L$0;
        w.b(r10);
    L22:
        kotlin.t0.j r11 = r6;
        ViewGroup r8 = r5;
        int r7 = r2;
        ViewGroup r3 = r8;
    L24:
        r4 = r4 + 1;
    L11:
        if (r4 >= r7) goto L26;
        View r9 = r3.getChildAt(r4);
        o.e(r9, "getChildAt(index)");
        this.L$0 = r11;
        this.L$1 = r3;
        this.L$2 = r9;
        this.I$0 = r4;
        this.I$1 = r7;
        this.label = 1;
        if (r11.b(r9, this) != r0) goto L15;
        return r0;
    L15:
        ViewGroup r12 = r3;
        r2 = r7;
        View r13 = r9;
    L17:
        if ((r13 instanceof ViewGroup) == false) goto L23;
        kotlin.t0.h<View> r14 = ViewGroupKt.getDescendants((ViewGroup) r13);
        this.L$0 = r11;
        this.L$1 = r12;
        this.L$2 = null;
        this.I$0 = r4;
        this.I$1 = r2;
        this.label = 2;
        if (r11.f(r14, this) != r0) goto L21;
        return r0;
    L21:
        r5 = r12;
        r6 = r11;
        goto L22
    L23:
        r7 = r2;
        r3 = r12;
        goto L24
    L26:
        return f0.f18324a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r2 = this.I$1;
        r4 = this.I$0;
        r13 = (View) this.L$2;
        r12 = (ViewGroup) this.L$1;
        kotlin.t0.j r15 = (kotlin.t0.j) this.L$0;
        w.b(r10);
        r11 = r15;
        goto L17
    L10:
        w.b(r10);
        r11 = (kotlin.t0.j) this.L$0;
        r3 = this.$this_descendants;
        r4 = 0;
        r7 = r3.getChildCount();
        goto L11
    }
}
