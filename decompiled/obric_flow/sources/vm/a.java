package vm;

import android.animation.ValueAnimator;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LynxUI f22590b;

    public /* synthetic */ a(LynxUI r5, int r10) {
        this.f22589a = r10;
        this.f22590b = r5;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r5) {
        switch(this.f22589a) {
            case 0: goto L32;
            case 1: goto L26;
            case 2: goto L20;
            case 3: goto L14;
            case 4: goto L10;
            default: goto L4;
        };
    L4:
        Object r10 = r5.getAnimatedValue();
        if (r10 == null) goto L38;
        int r11 = ((Integer) r10).intValue();
        LynxUI r12 = this.f22590b;
        r12.setLeft(r11);
        if ((r12.getParent() instanceof UIShadowProxy) == false) goto L39;
        UIShadowProxy r13 = (UIShadowProxy) r12.getParent();
        r13.invalidate();
        r13.e = true;
        return;
    L39:
        return;
    L38:
        return;
    L10:
        Object r14 = r5.getAnimatedValue();
        if (r14 == null) goto L40;
        this.f22590b.getView().setAlpha(((Float) r14).floatValue());
        return;
    L40:
        return;
    L14:
        Object r15 = r5.getAnimatedValue();
        if (r15 == null) goto L41;
        float r16 = ((Float) r15).floatValue();
        LynxUI r17 = this.f22590b;
        r17.getView().setAlpha(r16);
        if ((r17.getParent() instanceof UIShadowProxy) == false) goto L42;
        UIShadowProxy r18 = (UIShadowProxy) r17.getParent();
        r18.invalidate();
        r18.e = true;
        return;
    L42:
        return;
    L41:
        return;
    L20:
        Object r19 = r5.getAnimatedValue();
        if (r19 == null) goto L43;
        int r20 = ((Integer) r19).intValue();
        LynxUI r21 = this.f22590b;
        r21.setHeight(r20);
        if ((r21.getParent() instanceof UIShadowProxy) == false) goto L44;
        UIShadowProxy r22 = (UIShadowProxy) r21.getParent();
        r22.invalidate();
        r22.e = true;
        return;
    L44:
        return;
    L43:
        return;
    L26:
        Object r23 = r5.getAnimatedValue();
        if (r23 == null) goto L45;
        int r24 = ((Integer) r23).intValue();
        LynxUI r25 = this.f22590b;
        r25.setWidth(r24);
        if ((r25.getParent() instanceof UIShadowProxy) == false) goto L46;
        UIShadowProxy r26 = (UIShadowProxy) r25.getParent();
        r26.invalidate();
        r26.e = true;
        return;
    L46:
        return;
    L45:
        return;
    L32:
        Object r27 = r5.getAnimatedValue();
        if (r27 == null) goto L47;
        int r28 = ((Integer) r27).intValue();
        LynxUI r29 = this.f22590b;
        r29.setTop(r28);
        if ((r29.getParent() instanceof UIShadowProxy) == false) goto L48;
        UIShadowProxy r30 = (UIShadowProxy) r29.getParent();
        r30.invalidate();
        r30.e = true;
        return;
    L48:
        return;
    }
}
