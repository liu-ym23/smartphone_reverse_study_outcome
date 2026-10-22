package vm;

import ai.j0;
import android.animation.ValueAnimator;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.behavior.ui.utils.n;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f22591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f22592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LynxUI f22593c;
    public final /* synthetic */ float d;
    public final /* synthetic */ float e;
    public final /* synthetic */ float f;
    public final /* synthetic */ float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ float f22594h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ float f22595i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ float f22596j;

    public d(float r5, n r10, LynxUI r11, float r12, float r13, float r14, float r15, float r16, float r17, float r18) {
        this.f22591a = r5;
        this.f22592b = r10;
        this.f22593c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
        this.g = r15;
        this.f22594h = r16;
        this.f22595i = r17;
        this.f22596j = r18;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r10) {
        float r11 = r10.getAnimatedFraction();
        n r5 = this.f22592b;
        Float r12 = (Float) ((LinkedHashMap) r5.f10761a).get("translateX");
        float r13 = 0.0f;
        if (r12 == null) goto L5;
        float r14 = r12.floatValue();
    L6:
        float r15 = this.f22591a;
        float r16 = j0.b(r14, r15, r11, r15);
        LynxUI r17 = this.f22593c;
        r17.getView().setTranslationX(r16);
        Float r18 = (Float) ((LinkedHashMap) r5.f10761a).get("translateY");
        if (r18 == null) goto L9;
        r13 = r18.floatValue();
    L9:
        float r19 = this.d;
        r17.getView().setTranslationY(j0.b(r13, r19, r11, r19));
        float r20 = r5.w();
        float r21 = this.e;
        r17.getView().setTranslationZ(j0.b(r20, r21, r11, r21));
        float r22 = r5.f();
        float r23 = this.f;
        r17.getView().setRotation(j0.b(r22, r23, r11, r23));
        float r24 = r5.s();
        float r25 = this.g;
        r17.getView().setRotationX(j0.b(r24, r25, r11, r25));
        float r26 = r5.t();
        float r27 = this.f22594h;
        r17.getView().setRotationY(j0.b(r26, r27, r11, r27));
        float r28 = r5.u();
        float r29 = this.f22595i;
        r17.getView().setScaleX(j0.b(r28, r29, r11, r29));
        float r30 = r5.v();
        float r31 = this.f22596j;
        r17.getView().setScaleY(j0.b(r30, r31, r11, r31));
        if ((r17.getParent() instanceof UIShadowProxy) == false) goto L13;
        UIShadowProxy r32 = (UIShadowProxy) r17.getParent();
        r32.invalidate();
        r32.e = true;
        return;
    L13:
        return;
    L5:
        r14 = 0.0f;
        goto L6
    }
}
