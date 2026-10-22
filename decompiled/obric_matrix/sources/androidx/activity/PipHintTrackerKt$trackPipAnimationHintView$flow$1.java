package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.ttnet.org.chromium.base.BaseSwitches;
import h.a.d3.r;
import h.a.d3.t;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.w;

/* JADX INFO: loaded from: classes.dex */
@kotlin.k0.j.a.f(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", l = {87}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroid/graphics/Rect;"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends l implements p<t<? super Rect>, kotlin.k0.d<? super f0>, Object> {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class AnonymousClass1 extends q implements kotlin.n0.c.a<f0> {
        final /* synthetic */ PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 $attachStateChangeListener;
        final /* synthetic */ View.OnLayoutChangeListener $layoutChangeListener;
        final /* synthetic */ ViewTreeObserver.OnScrollChangedListener $scrollChangeListener;
        final /* synthetic */ View $view;

        AnonymousClass1(View r1, ViewTreeObserver.OnScrollChangedListener r2, View.OnLayoutChangeListener r3, PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1 r4) {
            this.$view = r1;
            this.$scrollChangeListener = r2;
            this.$layoutChangeListener = r3;
            this.$attachStateChangeListener = r4;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$view.getViewTreeObserver().removeOnScrollChangedListener(this.$scrollChangeListener);
            this.$view.removeOnLayoutChangeListener(this.$layoutChangeListener);
            this.$view.removeOnAttachStateChangeListener(this.$attachStateChangeListener);
        }
    }

    PipHintTrackerKt$trackPipAnimationHintView$flow$1(View r1, kotlin.k0.d<? super PipHintTrackerKt$trackPipAnimationHintView$flow$1> r2) {
        this.$view = r1;
        super(2, r2);
    }

    public static /* synthetic */ void b(t r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        m1invokeSuspend$lambda0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void d(t r0, View r1) {
        m2invokeSuspend$lambda1(r0, r1);
    }

    /* JADX INFO: renamed from: invokeSuspend$lambda-0, reason: not valid java name */
    private static final void m1invokeSuspend$lambda0(t r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (r2 != r6) goto L6;
        if (r4 != r8) goto L6;
        if (r3 != r7) goto L6;
        if (r5 != r9) goto L6;
        return;
    L6:
        o.e(r1, BaseSwitches.V);
        r0.i(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(r1));
    }

    /* JADX INFO: renamed from: invokeSuspend$lambda-1, reason: not valid java name */
    private static final void m2invokeSuspend$lambda1(t r0, View r1) {
        r0.i(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(r1));
    }

    @Override // kotlin.k0.j.a.a
    public final kotlin.k0.d<f0> create(Object r2, kotlin.k0.d<?> r3) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 r0 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, r3);
        r0.L$0 = r2;
        return r0;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(t<? super Rect> r1, kotlin.k0.d<? super f0> r2) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) create(r1, r2)).invokeSuspend(f0.f18324a);
    }

    @Override // kotlin.n0.c.p
    public /* bridge */ /* synthetic */ Object invoke(t<? super Rect> r1, kotlin.k0.d<? super f0> r2) {
        return invoke2(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View$OnAttachStateChangeListener, androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1] */
    @Override // kotlin.k0.j.a.a
    public final Object invokeSuspend(Object r8) {
        Object r0 = kotlin.k0.i.b.c();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        w.b(r8);
    L15:
        return f0.f18324a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        w.b(r8);
        final t r9 = (t) this.L$0;
        final View.OnLayoutChangeListener r2 = new h(r9);
        final View r3 = this.$view;
        final ViewTreeObserver.OnScrollChangedListener r4 = new i(r9, r3);
        ?? r5 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1(r9, r3, r4, r2);
        if (Api19Impl.INSTANCE.isAttachedToWindow(this.$view) == false) goto L11;
        r9.i(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(this.$view));
        this.$view.getViewTreeObserver().addOnScrollChangedListener(r4);
        this.$view.addOnLayoutChangeListener(r2);
    L11:
        this.$view.addOnAttachStateChangeListener(r5);
        AnonymousClass1 r6 = new AnonymousClass1(this.$view, r4, r2, r5);
        this.label = 1;
        if (r.a(r9, r6, this) != r0) goto L15;
        return r0;
    }
}
