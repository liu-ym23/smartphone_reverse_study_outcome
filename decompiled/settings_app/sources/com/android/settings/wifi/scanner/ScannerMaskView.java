package com.android.settings.wifi.scanner;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import com.android.settings.R;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScannerMaskView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u00013B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001dJ\b\u0010+\u001a\u00020)H\u0014J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0017J\u0016\u0010/\u001a\u00020)2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nJ\u000e\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\u001aJ\u000e\u00102\u001a\u00020)2\u0006\u0010\u001f\u001a\u00020\u0018R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR\u000e\u0010%\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/android/settings/wifi/scanner/ScannerMaskView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animator", "Landroid/animation/ValueAnimator;", "captureRect", "Landroid/graphics/Rect;", "getCaptureRect", "()Landroid/graphics/Rect;", "setCaptureRect", "(Landroid/graphics/Rect;)V", "captureSize", "Landroid/util/Size;", "getCaptureSize", "()Landroid/util/Size;", "setCaptureSize", "(Landroid/util/Size;)V", "edgePaint", "Landroid/graphics/Paint;", "laserColor", "", "laserVisibility", "", "lastPossibleResultPoints", "", "Lcom/google/zxing/ResultPoint;", "linePaint", "maskColor", "paint", "possibleResultPoints", "realCaptureRect", "getRealCaptureRect", "setRealCaptureRect", "resultPointColor", "scanLineOffset", "", "addPossibleResultPoint", "", "point", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setCaptureRects", "setLaserVisibility", "visible", "setMaskColor", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScannerMaskView extends View {
    private static final long ANIMATION_DELAY = 80;
    private static final int CURRENT_POINT_OPACITY = 160;
    public static final Companion Companion = null;
    private static final int MAX_RESULT_POINTS = 20;
    private static final int POINT_SIZE = 6;
    private static final String TAG = null;
    private final ValueAnimator animator;
    private Rect captureRect;
    private Size captureSize;
    private final Paint edgePaint;
    private final int laserColor;
    private boolean laserVisibility;
    private List<ResultPoint> lastPossibleResultPoints;
    private final Paint linePaint;
    private int maskColor;
    private final Paint paint;
    private List<ResultPoint> possibleResultPoints;
    private Rect realCaptureRect;
    private final int resultPointColor;
    private float scanLineOffset;

    /* JADX INFO: compiled from: ScannerMaskView.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/settings/wifi/scanner/ScannerMaskView$Companion;", "", "()V", "ANIMATION_DELAY", "", "CURRENT_POINT_OPACITY", "", "MAX_RESULT_POINTS", "POINT_SIZE", "TAG", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$MJni7CitdDermgMG_QLwzeQ35sE(ScannerMaskView r0, ValueAnimator r1) {
        animator$lambda$1$lambda$0(r0, r1);
    }

    public ScannerMaskView(Context r11, AttributeSet r12) {
        super(r11, r12);
        this.paint = new Paint(1);
        this.linePaint = new Paint(1);
        this.edgePaint = new Paint(1);
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.setDuration(2000);
        r1.setRepeatCount(-1);
        r1.addUpdateListener(new ScannerMaskView$$ExternalSyntheticLambda0(this));
        r1.start();
        Intrinsics.checkNotNullExpressionValue(r1, "apply(...)");
        this.animator = r1;
        Resources r2 = getResources();
        TypedArray r13 = getContext().obtainStyledAttributes(r12, R.styleable.ScannerMaskView);
        Intrinsics.checkNotNullExpressionValue(r13, "obtainStyledAttributes(...)");
        this.maskColor = r13.getColor(10, r2.getColor(R.color.scanner_mask, null));
        this.laserColor = r13.getColor(8, r2.getColor(R.color.scanner_laser, null));
        this.resultPointColor = r13.getColor(11, r2.getColor(R.color.scanner_possible_result_points, null));
        this.laserVisibility = r13.getBoolean(9, true);
        int r14 = (int) r13.getDimension(2, 0.0f);
        int r0 = (int) r13.getDimension(1, 0.0f);
        int r3 = (int) r13.getDimension(3, 0.0f);
        int r4 = (int) r13.getDimension(0, 0.0f);
        int r5 = (int) r13.getDimension(6, 0.0f);
        int r6 = (int) r13.getDimension(5, 0.0f);
        int r7 = (int) r13.getDimension(7, 0.0f);
        int r8 = (int) r13.getDimension(4, 0.0f);
        this.captureRect = new Rect(r0, r14, r0 + r3, r14 + r4);
        this.captureSize = new Size(r3, r4);
        this.realCaptureRect = new Rect(r6, r5, r7 + r6, r8 + r5);
        r13.recycle();
        this.possibleResultPoints = new ArrayList(20);
        this.lastPossibleResultPoints = new ArrayList(20);
    }

    static {
        Companion = new Companion(null);
        Intrinsics.checkNotNullExpressionValue("ScannerMaskView", "getSimpleName(...)");
        TAG = "ScannerMaskView";
    }

    private static final void animator$lambda$1$lambda$0(ScannerMaskView r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "it");
        r1.invalidate();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.animator.cancel();
    }

    public final Rect getCaptureRect() {
        return this.captureRect;
    }

    public final void setCaptureRect(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.captureRect = r2;
    }

    public final Size getCaptureSize() {
        return this.captureSize;
    }

    public final void setCaptureSize(Size r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.captureSize = r2;
    }

    public final Rect getRealCaptureRect() {
        return this.realCaptureRect;
    }

    public final void setRealCaptureRect(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.realCaptureRect = r2;
    }

    public final void setCaptureRects(Rect r3, Rect r4) {
        Intrinsics.checkNotNullParameter(r3, "captureRect");
        Intrinsics.checkNotNullParameter(r4, "realCaptureRect");
        this.captureRect = r3;
        this.captureSize = new Size(r3.width(), r3.height());
        this.realCaptureRect = r4;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas r22) {
        Intrinsics.checkNotNullParameter(r22, "canvas");
        Rect r8 = this.captureRect;
        Size r9 = this.captureSize;
        int r1 = getWidth();
        int r10 = getHeight();
        this.paint.setColor(this.maskColor);
        float r11 = r1;
        r22.drawRect(0.0f, 0.0f, r11, r8.top, this.paint);
        r22.drawRect(0.0f, r8.top, r8.left, r8.bottom + 1, this.paint);
        r22.drawRect(r8.right + 1, r8.top, r11, r8.bottom + 1, this.paint);
        r22.drawRect(0.0f, r8.bottom + 1, r11, r10, this.paint);
        if (this.laserVisibility == false) goto L5;
        Object r2 = this.animator.getAnimatedValue();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.Float");
        this.scanLineOffset = ((Float) r2).floatValue() * this.captureSize.getHeight();
        float r14 = r8.left + 2;
        float r15 = (r8.top - 3) + this.scanLineOffset;
        float r3 = r8.right - 1;
        float r17 = (r8.top + 3) + this.scanLineOffset;
        int r12 = this.laserColor;
        this.linePaint.setShader(new LinearGradient(r14, r15, r3, r17, new int[]{0, r12, r12, 0}, new float[]{0.0f, 0.2f, 0.8f, 1.0f}, Shader.TileMode.CLAMP));
        r22.drawRect(r8.left + 2, this.scanLineOffset + (r8.top - 3), r8.right - 1, this.scanLineOffset + (r8.top + 3), this.linePaint);
    L5:
        this.edgePaint.setColor(-1);
        r22.drawRect(r8.left - 3, r8.top - 3, r8.left + 51, r8.top + 3, this.edgePaint);
        r22.drawRect(r8.left - 3, r8.top - 3, r8.left + 3, r8.top + 51, this.edgePaint);
        r22.drawRect(r8.right - 51, r8.top - 3, r8.right + 3, r8.top + 3, this.edgePaint);
        r22.drawRect(r8.right - 3, r8.top - 3, r8.right + 3, r8.top + 51, this.edgePaint);
        r22.drawRect(r8.left - 3, r8.bottom - 51, r8.left + 3, r8.bottom + 3, this.edgePaint);
        r22.drawRect(r8.left - 3, r8.bottom - 3, r8.left + 51, r8.bottom + 3, this.edgePaint);
        r22.drawRect(r8.right - 51, r8.bottom - 3, r8.right + 3, r8.bottom + 3, this.edgePaint);
        r22.drawRect(r8.right - 3, r8.bottom - 51, r8.right + 3, r8.bottom + 3, this.edgePaint);
        float r4 = getWidth() / r9.getWidth();
        float r5 = getHeight() / r9.getHeight();
        if ((!this.lastPossibleResultPoints.isEmpty()) == false) goto L13;
        this.paint.setAlpha(80);
        this.paint.setColor(this.resultPointColor);
        Iterator<ResultPoint> r6 = this.lastPossibleResultPoints.iterator();
    L9:
        if (r6.hasNext() == false) goto L11;
        ResultPoint r7 = r6.next();
        r22.drawCircle((int) (r7.getX() * r4), (int) (r7.getY() * r5), 3.0f, this.paint);
        goto L9
    L11:
        this.lastPossibleResultPoints.clear();
    L13:
        if ((!this.possibleResultPoints.isEmpty()) == false) goto L19;
        this.paint.setAlpha(160);
        this.paint.setColor(this.resultPointColor);
        Iterator<ResultPoint> r13 = this.possibleResultPoints.iterator();
    L16:
        if (r13.hasNext() == false) goto L18;
        ResultPoint r16 = r13.next();
        r22.drawCircle((int) (r16.getX() * r4), (int) (r16.getY() * r5), 6.0f, this.paint);
        goto L16
    L18:
        List<ResultPoint> r18 = this.possibleResultPoints;
        List<ResultPoint> r19 = this.lastPossibleResultPoints;
        this.possibleResultPoints = r19;
        this.lastPossibleResultPoints = r18;
        r19.clear();
    L19:
        postInvalidateDelayed(ANIMATION_DELAY, r8.left - 6, r8.top - 6, r8.right + 6, r8.bottom + 6);
    }

    public final void addPossibleResultPoint(ResultPoint r3) {
        Intrinsics.checkNotNullParameter(r3, "point");
        if (this.possibleResultPoints.size() >= 20) goto L6;
        this.possibleResultPoints.add(r3);
        return;
    }

    public final void setMaskColor(int r1) {
        this.maskColor = r1;
    }

    public final void setLaserVisibility(boolean r1) {
        this.laserVisibility = r1;
    }
}
