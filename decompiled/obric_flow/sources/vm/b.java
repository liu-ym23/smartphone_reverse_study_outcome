package vm;

import android.animation.Animator;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends h {
    public final /* synthetic */ LynxBaseUI d;
    public final /* synthetic */ int e;
    public final /* synthetic */ i f;

    public b(i r5, LynxBaseUI r10, int r11, LynxBaseUI r12, int r13) {
        this.f = r5;
        this.d = r12;
        this.e = r13;
        super(r10, r11);
    }

    @Override // vm.h, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        super.onAnimationEnd(r5);
        LynxBaseUI r10 = this.d;
        com.lynx.tasm.behavior.ui.utils.g r11 = r10.getLynxBackground();
        int r12 = this.e;
        r11.e = r12;
        if (r12 == 0) goto L5;
    L7:
        ((BackgroundDrawable) r11.d()).setColor(r12);
    L8:
        r10.invalidate();
        this.f.f22603h.remove(64);
        return;
    L5:
        if (r11.f10750b != null) goto L7;
        goto L7
    }
}
