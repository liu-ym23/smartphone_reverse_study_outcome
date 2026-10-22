package androidx.core.transition;

import android.transition.Transition;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"androidx/core/transition/TransitionKt$addListener$listener$1", "Landroid/transition/Transition$TransitionListener;", "onTransitionCancel", "", "transition", "Landroid/transition/Transition;", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 176)
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    final /* synthetic */ l<Transition, f0> $onCancel;
    final /* synthetic */ l<Transition, f0> $onEnd;
    final /* synthetic */ l<Transition, f0> $onPause;
    final /* synthetic */ l<Transition, f0> $onResume;
    final /* synthetic */ l<Transition, f0> $onStart;

    /* JADX WARN: Multi-variable type inference failed */
    public TransitionKt$addListener$listener$1(l<? super Transition, f0> r1, l<? super Transition, f0> r2, l<? super Transition, f0> r3, l<? super Transition, f0> r4, l<? super Transition, f0> r5) {
        this.$onEnd = r1;
        this.$onResume = r2;
        this.$onPause = r3;
        this.$onCancel = r4;
        this.$onStart = r5;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition r2) {
        o.f(r2, "transition");
        this.$onCancel.invoke(r2);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition r2) {
        o.f(r2, "transition");
        this.$onEnd.invoke(r2);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition r2) {
        o.f(r2, "transition");
        this.$onPause.invoke(r2);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition r2) {
        o.f(r2, "transition");
        this.$onResume.invoke(r2);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition r2) {
        o.f(r2, "transition");
        this.$onStart.invoke(r2);
    }
}
