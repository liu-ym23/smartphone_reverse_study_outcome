package com.obric.common.oea.style.scene.qsanim;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewPressAnimHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J&\u0010\u0015\u001a\u00020\u0010*\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u001e\u0010\u0016\u001a\u00020\u0010*\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/ViewPressAnimHelper;", "", "pressScale", "", "duration", "", "pressCancelDistance", "", "interpolator", "Landroid/view/animation/Interpolator;", "(FJILandroid/view/animation/Interpolator;)V", "animCanceled", "", "downPoint", "Landroid/graphics/PointF;", "handleTouchEvent", "", "view", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "animScaleDown", "animScaleUp", "Companion", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class ViewPressAnimHelper {
    public static final Companion Companion = null;
    private static final String TAG = "ViewPressAnimHelper";
    private static final AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = null;
    private boolean animCanceled;
    private PointF downPoint;
    private final long duration;
    private final Interpolator interpolator;
    private final int pressCancelDistance;
    private final float pressScale;

    /* JADX INFO: compiled from: ViewPressAnimHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/ViewPressAnimHelper$Companion;", "", "()V", "TAG", "", "accelerateDecelerateInterpolator", "Landroid/view/animation/AccelerateDecelerateInterpolator;", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    public ViewPressAnimHelper() {
        this(0.0f, 0, 0, null, 15, null);
    }

    public ViewPressAnimHelper(float r1, long r2, int r4, Interpolator r5) {
        this.pressScale = r1;
        this.duration = r2;
        this.pressCancelDistance = r4;
        this.interpolator = r5;
        this.downPoint = new PointF(0.0f, 0.0f);
    }

    public /* synthetic */ ViewPressAnimHelper(float r4, long r5, int r7, AccelerateDecelerateInterpolator r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = 0.95f;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = 150;
    L8:
        long r0 = r5;
        if ((r9 & 4) == 0) goto L11;
        r7 = 20;
    L11:
        int r11 = r7;
        if ((r9 & 8) == 0) goto L14;
        r8 = accelerateDecelerateInterpolator;
    L14:
        float r6 = r4;
        this(r6, r0, r11, r8);
    }

    public final void handleTouchEvent(View r9, MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        Intrinsics.checkNotNullParameter(r10, "event");
        int r0 = r10.getAction();
        if (r0 != 0) goto L5;
        this.downPoint = new PointF(r10.getX(), r10.getY());
        animScaleDown(r9, this.pressScale, this.duration, this.interpolator);
        this.animCanceled = false;
        return;
    L5:
        if (r0 == 1) goto L17;
        if (r0 != 2) goto L9;
        float r1 = r10.getX() - this.downPoint.x;
        float r11 = r10.getY() - this.downPoint.y;
        if (((float) Math.sqrt((r1 * r1) + (r11 * r11))) > this.pressCancelDistance) goto L14;
        return;
    L14:
        if (this.animCanceled == true) goto L22;
        animScaleUp(r9, this.duration, this.interpolator);
        this.animCanceled = true;
        return;
    L22:
        return;
    L9:
        if (r0 == 3) goto L17;
        return;
    L17:
        if (this.animCanceled == true) goto L24;
        animScaleUp(r9, this.duration, this.interpolator);
        return;
    }

    private final void animScaleDown(View r1, float r2, long r3, Interpolator r5) {
        r1.animate().scaleX(r2).scaleY(r2).setDuration(r3).setInterpolator(r5).start();
    }

    private final void animScaleUp(View r1, long r2, Interpolator r4) {
        r1.animate().scaleX(1.0f).scaleY(1.0f).setDuration(r2).setInterpolator(r4).start();
    }

    static {
        Companion = new Companion(null);
        accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
    }
}
