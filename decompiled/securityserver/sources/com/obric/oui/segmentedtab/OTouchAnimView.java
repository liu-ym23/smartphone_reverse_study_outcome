package com.obric.oui.segmentedtab;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class OTouchAnimView extends RelativeLayout {
    public float b;
    public ValueAnimator c;
    public ValueAnimator e;

    @Metadata
    public static final class Companion {
    }

    public abstract boolean a();

    public abstract void b(String r1, float r2);

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r6) {
        Intrinsics.f(r6, "event");
        int r3 = r6.getAction();
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L9;
        if (r3 == 3) goto L9;
    L35:
        return super.dispatchTouchEvent(r6);
    L9:
        if (a() == false) goto L35;
        ValueAnimator r4 = this.c;
        if (r4 == null) goto L14;
        r4.removeAllUpdateListeners();
    L14:
        ValueAnimator r5 = this.c;
        if (r5 == null) goto L17;
        r5.cancel();
    L17:
        ValueAnimator r7 = this.e;
        if (r7 == null) goto L20;
        r7.cancel();
    L20:
        ValueAnimator r0 = ValueAnimator.ofFloat(new float[]{this.b, 0.0f});
        r0.setDuration(200);
        r0.setInterpolator(new DecelerateInterpolator());
        r0.addUpdateListener(new OTouchAnimView$startReleaseAnim$$inlined$apply$lambda$1(this));
        r0.start();
        this.e = r0;
        goto L35
    L22:
        if (a() == false) goto L35;
        ValueAnimator r8 = this.e;
        if (r8 == null) goto L27;
        r8.removeAllUpdateListeners();
    L27:
        ValueAnimator r9 = this.e;
        if (r9 == null) goto L30;
        r9.cancel();
    L30:
        ValueAnimator r10 = this.c;
        if (r10 == null) goto L33;
        r10.cancel();
    L33:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{this.b, 1.0f});
        r1.setDuration(50);
        r1.setInterpolator(new DecelerateInterpolator());
        r1.addUpdateListener(new OTouchAnimView$startPressAnim$$inlined$apply$lambda$1(this));
        r1.start();
        this.c = r1;
        goto L35
    }
}
