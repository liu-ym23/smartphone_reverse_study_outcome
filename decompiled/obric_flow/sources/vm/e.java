package vm;

import android.animation.Animator;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends h {
    public final /* synthetic */ LynxUI d;
    public final /* synthetic */ float e;
    public final /* synthetic */ i f;

    public e(i r5, LynxUI r10, int r11, LynxUI r12, float r13) {
        this.f = r5;
        this.d = r12;
        this.e = r13;
        super(r10, r11);
    }

    @Override // vm.h, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        super.onAnimationEnd(r5);
        LynxUI r10 = this.d;
        r10.getView().setAlpha(this.e);
        if ((r10.getParent() instanceof UIShadowProxy) == false) goto L5;
        UIShadowProxy r11 = (UIShadowProxy) r10.getParent();
        r11.invalidate();
        r11.e = true;
    L5:
        this.f.f22603h.remove(1);
    }
}
