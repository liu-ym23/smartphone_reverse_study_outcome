package vm;

import android.animation.Animator;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends h {
    public final WeakReference d;
    public final boolean e;

    public g(LynxUI r5, int r10, i r11, boolean r12) {
        super(r5, r10);
        this.e = true;
        this.d = new WeakReference(r11);
        this.e = r12;
    }

    @Override // vm.h, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r22) {
        if (this.e == false) goto L5;
        super.onAnimationEnd(r22);
    L5:
        i r5 = (i) this.d.get();
        LynxBaseUI r10 = (LynxBaseUI) this.f22598a.get();
        if (r10 == null) goto L30;
        if (r5 == null) goto L31;
        HashMap r11 = r5.f22603h;
        int r12 = this.f22599b;
        r11.remove(Integer.valueOf(r12));
        int r13 = r10.getOriginLeft();
        int r14 = r10.getOriginTop();
        int r15 = r10.getWidth();
        int r16 = r10.getHeight();
        if (r12 != 16) goto L12;
        int r17 = r16;
        int r18 = r5.f22602c;
    L23:
        int r19 = r13;
    L28:
        r10.updateLayout(r19, r14, r18, r17, r10.getPaddingLeft(), r10.getPaddingTop(), r10.getPaddingRight(), r10.getPaddingBottom(), r10.getMarginLeft(), r10.getMarginTop(), r10.getMarginRight(), r10.getMarginBottom(), r10.getBorderLeftWidth(), r10.getBorderTopWidth(), r10.getBorderRightWidth(), r10.getBorderBottomWidth(), r10.getBound());
        return;
    L12:
        if (r12 != 32) goto L14;
        r17 = r5.d;
    L22:
        r18 = r15;
        goto L23
    L14:
        if (r12 != 256) goto L16;
    L25:
        r17 = r16;
        r18 = r15;
        r14 = r14;
        r19 = r5.f22600a;
        goto L28
    L16:
        if (r12 != 512) goto L18;
    L24:
        r19 = r13;
        r17 = r16;
        r18 = r15;
        r14 = r5.f22601b;
        goto L28
    L18:
        if (r12 == 1024) goto L25;
        if (r12 == 2048) goto L24;
        r17 = r16;
        goto L22
    L31:
        return;
    }

    @Override // vm.h, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r5) {
        if (this.e == false) goto L6;
        super.onAnimationStart(r5);
        return;
    }
}
