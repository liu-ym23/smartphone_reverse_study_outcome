package androidx.slidingpanelayout.widget;

import android.app.Activity;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import h.a.e3.e;
import h.a.e3.g;
import h.a.h;
import h.a.m0;
import h.a.n0;
import h.a.p1;
import h.a.x1;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.k0.d;
import kotlin.k0.i.b;
import kotlin.k0.j.a.f;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/slidingpanelayout/widget/FoldingFeatureObserver;", "", "windowInfoTracker", "Landroidx/window/layout/WindowInfoTracker;", "executor", "Ljava/util/concurrent/Executor;", "(Landroidx/window/layout/WindowInfoTracker;Ljava/util/concurrent/Executor;)V", "job", "Lkotlinx/coroutines/Job;", "onFoldingFeatureChangeListener", "Landroidx/slidingpanelayout/widget/FoldingFeatureObserver$OnFoldingFeatureChangeListener;", "getFoldingFeature", "Landroidx/window/layout/FoldingFeature;", "windowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "registerLayoutStateChangeCallback", "", "activity", "Landroid/app/Activity;", "setOnFoldingFeatureChangeListener", "unregisterLayoutStateChangeCallback", "OnFoldingFeatureChangeListener", "slidingpanelayout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FoldingFeatureObserver {
    private final Executor executor;
    private x1 job;
    private OnFoldingFeatureChangeListener onFoldingFeatureChangeListener;
    private final WindowInfoTracker windowInfoTracker;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Landroidx/slidingpanelayout/widget/FoldingFeatureObserver$OnFoldingFeatureChangeListener;", "", "onFoldingFeatureChange", "", "foldingFeature", "Landroidx/window/layout/FoldingFeature;", "slidingpanelayout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnFoldingFeatureChangeListener {
        void onFoldingFeatureChange(FoldingFeature r1);
    }

    /* JADX INFO: renamed from: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1, reason: invalid class name */
    @f(c = "androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1", f = "FoldingFeatureObserver.kt", l = {97}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass1 extends l implements p<m0, d<? super f0>, Object> {
        final /* synthetic */ Activity $activity;
        int label;
        final /* synthetic */ FoldingFeatureObserver this$0;

        AnonymousClass1(FoldingFeatureObserver r1, Activity r2, d<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$activity = r2;
            super(2, r3);
        }

        @Override // kotlin.k0.j.a.a
        public final d<f0> create(Object r2, d<?> r3) {
            return new AnonymousClass1(this.this$0, this.$activity, r3);
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
        public final Object invokeSuspend(Object r5) {
            Object r0 = b.c();
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
            final e<WindowLayoutInfo> r6 = FoldingFeatureObserver.access$getWindowInfoTracker$p(this.this$0).windowLayoutInfo(this.$activity);
            final FoldingFeatureObserver r2 = this.this$0;
            e r7 = g.d(new FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1(r6, r2));
            final FoldingFeatureObserver r3 = this.this$0;
            h.a.e3.f<FoldingFeature> r4 = new FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1(r3);
            this.label = 1;
            if (r7.collect(r4, this) != r0) goto L12;
            return r0;
        }
    }

    public FoldingFeatureObserver(WindowInfoTracker r2, Executor r3) {
        o.f(r2, "windowInfoTracker");
        o.f(r3, "executor");
        this.windowInfoTracker = r2;
        this.executor = r3;
    }

    public static final /* synthetic */ FoldingFeature access$getFoldingFeature(FoldingFeatureObserver r0, WindowLayoutInfo r1) {
        return r0.getFoldingFeature(r1);
    }

    public static final /* synthetic */ OnFoldingFeatureChangeListener access$getOnFoldingFeatureChangeListener$p(FoldingFeatureObserver r0) {
        return r0.onFoldingFeatureChangeListener;
    }

    public static final /* synthetic */ WindowInfoTracker access$getWindowInfoTracker$p(FoldingFeatureObserver r0) {
        return r0.windowInfoTracker;
    }

    private final FoldingFeature getFoldingFeature(WindowLayoutInfo r3) {
        Iterator<T> r2 = r3.getDisplayFeatures().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r4 = r2.next();
        if ((((DisplayFeature) r4) instanceof FoldingFeature) == false) goto L4;
    L10:
        if ((r4 instanceof FoldingFeature) == true) goto L12;
        return null;
    L12:
        return (FoldingFeature) r4;
    L8:
        r4 = null;
        goto L10
    }

    public final void registerLayoutStateChangeCallback(Activity r9) {
        o.f(r9, "activity");
        x1 r0 = this.job;
        if (r0 == null) goto L6;
        x1.a.a(r0, null, 1, null);
    L6:
        this.job = h.b(n0.a(p1.a(this.executor)), null, null, new AnonymousClass1(this, r9, null), 3, null);
    }

    public final void setOnFoldingFeatureChangeListener(OnFoldingFeatureChangeListener r2) {
        o.f(r2, "onFoldingFeatureChangeListener");
        this.onFoldingFeatureChangeListener = r2;
    }

    public final void unregisterLayoutStateChangeCallback() {
        x1 r2 = this.job;
        if (r2 == null) goto L7;
        x1.a.a(r2, null, 1, null);
        return;
    }
}
