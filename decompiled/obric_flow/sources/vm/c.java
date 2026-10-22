package vm;

import android.animation.Animator;
import android.view.View;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.utils.n;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends h {
    public final /* synthetic */ LynxUI d;
    public final /* synthetic */ n e;
    public final /* synthetic */ i f;

    public c(i r5, LynxUI r10, int r11, LynxUI r12, n r13) {
        this.f = r5;
        this.d = r12;
        this.e = r13;
        super(r10, r11);
    }

    @Override // vm.h, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r10) {
        super.onAnimationEnd(r10);
        LynxUI r11 = this.d;
        View r5 = r11.getView();
        n r12 = this.e;
        Float r13 = (Float) ((LinkedHashMap) r12.f10761a).get("translateX");
        float r14 = 0.0f;
        if (r13 == null) goto L5;
        float r15 = r13.floatValue();
    L6:
        r5.setTranslationX(r15);
        View r16 = r11.getView();
        Float r17 = (Float) ((LinkedHashMap) r12.f10761a).get("translateY");
        if (r17 == null) goto L9;
        r14 = r17.floatValue();
    L9:
        r16.setTranslationY(r14);
        r11.getView().setTranslationZ(r12.w());
        if ((r11.getParent() instanceof UIShadowProxy) == false) goto L12;
        UIShadowProxy r18 = (UIShadowProxy) r11.getParent();
        r18.invalidate();
        r18.e = true;
    L12:
        r11.getView().setRotation(r12.f());
        r11.getView().setRotationX(r12.s());
        r11.getView().setRotationY(r12.t());
        r11.getView().setScaleX(r12.u());
        r11.getView().setScaleY(r12.v());
        this.f.f22603h.remove(4096);
        return;
    L5:
        r15 = 0.0f;
        goto L6
    }
}
