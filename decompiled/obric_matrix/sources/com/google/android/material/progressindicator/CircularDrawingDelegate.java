package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes2.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private float adjustedRadius;
    private int arcDirectionFactor;
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    public CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec r1) {
        super(r1);
        this.arcDirectionFactor = 1;
    }

    private void drawRoundedEnd(Canvas r2, Paint r3, float r4, float r5, float r6) {
        r2.save();
        r2.rotate(r6);
        float r1 = this.adjustedRadius;
        float r7 = r4 / 2.0f;
        r2.drawRoundRect(new RectF(r1 - r7, r5, r1 + r7, -r5), r5, r5, r3);
        r2.restore();
    }

    private int getSize() {
        S r1 = this.spec;
        return ((CircularProgressIndicatorSpec) r1).indicatorSize + (((CircularProgressIndicatorSpec) r1).indicatorInset * 2);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas r5, @FloatRange(from = 0.0d, to = 1.0d) float r6) {
        S r0 = this.spec;
        float r1 = (((CircularProgressIndicatorSpec) r0).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) r0).indicatorInset;
        r5.translate(r1, r1);
        r5.rotate(-90.0f);
        float r2 = -r1;
        r5.clipRect(r2, r2, r1, r1);
        S r7 = this.spec;
        if (((CircularProgressIndicatorSpec) r7).indicatorDirection != 0) goto L5;
        int r3 = 1;
    L6:
        this.arcDirectionFactor = r3;
        this.displayedTrackThickness = ((CircularProgressIndicatorSpec) r7).trackThickness * r6;
        this.displayedCornerRadius = ((CircularProgressIndicatorSpec) r7).trackCornerRadius * r6;
        this.adjustedRadius = (((CircularProgressIndicatorSpec) r7).indicatorSize - ((CircularProgressIndicatorSpec) r7).trackThickness) / 2.0f;
        if (this.drawable.isShowing() == false) goto L11;
        if (((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior != 2) goto L11;
    L14:
        float r8 = this.adjustedRadius + (((1.0f - r6) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f);
    L15:
        this.adjustedRadius = r8;
        return;
    L11:
        if (this.drawable.isHiding() == false) goto L17;
        if (((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1) goto L14;
    L17:
        if (this.drawable.isShowing() == false) goto L21;
        if (((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior != 1) goto L21;
    L24:
        r8 = this.adjustedRadius - (((1.0f - r6) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f);
    L21:
        if (this.drawable.isHiding() == true) goto L23;
        return;
    L23:
        if (((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2) goto L24;
        return;
    L5:
        r3 = -1;
        goto L6
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillIndicator(@NonNull Canvas r12, @NonNull Paint r13, @FloatRange(from = 0.0d, to = 1.0d) float r14, @FloatRange(from = 0.0d, to = 1.0d) float r15, @ColorInt int r16) {
        if (r14 != r15) goto L5;
        return;
    L5:
        r13.setStyle(Paint.Style.STROKE);
        r13.setStrokeCap(Paint.Cap.BUTT);
        r13.setAntiAlias(true);
        r13.setColor(r16);
        r13.setStrokeWidth(this.displayedTrackThickness);
        int r1 = this.arcDirectionFactor;
        float r9 = (r14 * 360.0f) * r1;
        if (r15 < r14) goto L8;
        float r0 = r15 - r14;
    L9:
        float r2 = (r0 * 360.0f) * r1;
        float r3 = this.adjustedRadius;
        r12.drawArc(new RectF(-r3, -r3, r3, r3), r9, r2, false, r13);
        if (this.displayedCornerRadius > 0.0f) goto L12;
        return;
    L12:
        if (Math.abs(r2) >= 360.0f) goto L16;
        r13.setStyle(Paint.Style.FILL);
        drawRoundedEnd(r12, r13, this.displayedTrackThickness, this.displayedCornerRadius, r9);
        drawRoundedEnd(r12, r13, this.displayedTrackThickness, this.displayedCornerRadius, r9 + r2);
        return;
    L16:
        return;
    L8:
        r0 = (1.0f + r15) - r14;
        goto L9
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillTrack(@NonNull Canvas r8, @NonNull Paint r9) {
        int r0 = MaterialColors.compositeARGBWithAlpha(((CircularProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        r9.setStyle(Paint.Style.STROKE);
        r9.setStrokeCap(Paint.Cap.BUTT);
        r9.setAntiAlias(true);
        r9.setColor(r0);
        r9.setStrokeWidth(this.displayedTrackThickness);
        float r7 = this.adjustedRadius;
        r8.drawArc(new RectF(-r7, -r7, r7, r7), 0.0f, 360.0f, false, r9);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return getSize();
    }
}
