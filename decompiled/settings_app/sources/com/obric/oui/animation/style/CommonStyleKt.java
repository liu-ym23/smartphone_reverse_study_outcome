package com.obric.oui.animation.style;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.PathInterpolator;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.animation.easy.ViewPropertySpringAnimatorExtKt;
import com.obric.oui.animation.engine.DynamicAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CommonStyle.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002\u001a(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002\u001a\"\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007\u001a0\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014*\u00020\u00102\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"TAG", "", "getAnimFraction", "", "currentValue", "startValue", "endValue", "updateWindowDimWithAnim", "", "window", "Landroid/view/Window;", "animFraction", "startDim", "endDim", "windowBottomHide", "Landroid/animation/ObjectAnimator;", "Landroid/view/View;", "withDimAnim", "", "windowBottomShow", "Lcom/obric/oui/animation/easy/ViewPropertySpringAnimator;", "targetDimAmount", "OUIAnimation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CommonStyleKt {
    private static final String TAG = "CommonAnimStyle";

    public static /* synthetic */ void $r8$lambda$7073aQ5RdBbQon3lWlFpfEZk6Ac(Window r0, float r1, float r2, ValueAnimator r3) {
        m1055windowBottomHide$lambda3(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$aOMnir0_xl-z-gQ09zNwpdnK7ik, reason: not valid java name */
    public static /* synthetic */ void m1054$r8$lambda$aOMnir0_xlzgQ09zNwpdnK7ik(Window r0, float r1, float r2, float r3, DynamicAnimation r4, float r5, float r6) {
        m1056windowBottomShow$lambda1$lambda0(r0, r1, r2, r3, r4, r5, r6);
    }

    private static final float getAnimFraction(float r0, float r1, float r2) {
        return (r0 - r1) / (r2 - r1);
    }

    public static /* synthetic */ ViewPropertySpringAnimator windowBottomShow$default(View r0, Window r1, boolean r2, float r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = true;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = 0.6f;
    L12:
        return windowBottomShow(r0, r1, r2, r3);
    }

    public static final ViewPropertySpringAnimator<View> windowBottomShow(View r4, final Window r5, boolean r6, final float r7) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        int r0 = Resources.getSystem().getDisplayMetrics().heightPixels;
        int r1 = r4.getHeight();
        final Ref.IntRef r2 = new Ref.IntRef();
        int r3 = r0 / 2;
        if (r1 >= r3) goto L5;
        r0 = r3;
    L5:
        r2.element = r0;
        r4.setAlpha(1.0f);
        final float r8 = 0.0f;
        ViewPropertySpringAnimator<View> r9 = ViewPropertySpringAnimatorExtKt.spring(r4).translationY(0.0f, new C02701(r2));
        if (r5 == null) goto L13;
        if (r6 == false) goto L13;
        r5.addFlags(2);     // Catch: Exception -> L11
        final float r10 = r2.element;     // Catch: Exception -> L11
        r9.setUpdateListener(new CommonStyleKt$$ExternalSyntheticLambda0(r5, r10, r8, r7));     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Log.w(TAG, Intrinsics.stringPlus("windowBottomShow, can't show dim anim: ", e.getMessage()));
    L13:
        return r9;
    }

    /* JADX INFO: renamed from: windowBottomShow$lambda-1$lambda-0, reason: not valid java name */
    private static final void m1056windowBottomShow$lambda1$lambda0(Window r0, float r1, float r2, float r3, DynamicAnimation r4, float r5, float r6) {
        updateWindowDimWithAnim(r0, getAnimFraction(r5, r1, r2), 0.0f, r3);
    }

    public static /* synthetic */ ObjectAnimator windowBottomHide$default(View r0, Window r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = true;
    L9:
        return windowBottomHide(r0, r1, r2);
    }

    public static final ObjectAnimator windowBottomHide(final View r7, final Window r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        int r0 = Resources.getSystem().getDisplayMetrics().heightPixels;
        int r2 = r0 / 2;
        if (r7.getHeight() >= r2) goto L5;
        r0 = r2;
    L5:
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r7, "alpha", new float[]{1.0f, 0.0f});
        r3.setDuration(150);
        r3.setInterpolator(new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f));
        final ViewPropertySpringAnimator r1 = ViewPropertySpringAnimatorExtKt.spring(r7).translationY(r0, CommonStyleKt$windowBottomHide$spring$1.INSTANCE);
        r3.addListener(new AnonymousClass1(r1, r7));
        if (r8 == null) goto L12;
        if (r9 == false) goto L12;
        r8.addFlags(2);     // Catch: Exception -> L10
        final float r10 = r8.getAttributes().dimAmount;     // Catch: Exception -> L10
        final float r4 = 0.0f;
        r3.addUpdateListener(new CommonStyleKt$$ExternalSyntheticLambda1(r8, r10, r4));     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.w(TAG, Intrinsics.stringPlus("windowBottomHide, can't show dim anim: ", e.getMessage()));
    L12:
        Intrinsics.checkNotNullExpressionValue(r3, "animator");
        return r3;
    }

    /* JADX INFO: renamed from: windowBottomHide$lambda-3, reason: not valid java name */
    private static final void m1055windowBottomHide$lambda3(Window r1, float r2, float r3, ValueAnimator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        updateWindowDimWithAnim(r1, r4.getAnimatedFraction(), r2, r3);
    }

    private static final void updateWindowDimWithAnim(Window r2, float r3, float r4, float r5) {
        float r6 = r5 - r4;     // Catch: Exception -> L5
        r2.setDimAmount(r4 + (r6 * RangesKt.coerceIn(r3, 0.0f, 1.0f)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w(TAG, Intrinsics.stringPlus("updateWindowDimWithAnim: ", e.getMessage()));
    }
}
