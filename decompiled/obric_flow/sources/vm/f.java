package vm;

import android.animation.Animator;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends h {
    public final /* synthetic */ LynxUI d;
    public final /* synthetic */ int e;
    public final /* synthetic */ float f;
    public final /* synthetic */ i g;

    public f(i r5, LynxBaseUI r10, int r11, LynxUI r12, int r13, float r14) {
        this.g = r5;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        super(r10, r11);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r5) {
        super.onAnimationCancel(r5);
        this.g.e = false;
    }

    @Override // vm.h, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        super.onAnimationEnd(r5);
        int r10 = this.e;
        LynxUI r11 = this.d;
        r11.setVisibilityForView(r10);
        r11.getView().setAlpha(this.f);
        this.g.f22603h.remove(128);
    }

    @Override // vm.h, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        super.onAnimationStart(r5);
        this.d.getView().setVisibility(0);
        this.g.e = false;
    }
}
