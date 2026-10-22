package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes2.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    private float trackLength;

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return -1;
    }

    public LinearDrawingDelegate(LinearProgressIndicatorSpec r1) {
        super(r1);
        this.trackLength = 300.0f;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(Canvas r8, float r9) {
        Rect r0 = r8.getClipBounds();
        this.trackLength = r0.width();
        float r1 = ((LinearProgressIndicatorSpec) this.spec).trackThickness;
        r8.translate(r0.width() / 2.0f, (r0.height() / 2.0f) + Math.max(0.0f, (r0.height() - ((LinearProgressIndicatorSpec) this.spec).trackThickness) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse == false) goto L6;
        r8.scale(-1.0f, 1.0f);
    L6:
        if (this.drawable.isShowing() == false) goto L10;
        if (((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior != 1) goto L10;
    L13:
        r8.scale(1.0f, -1.0f);
    L15:
        if (this.drawable.isShowing() == false) goto L17;
    L18:
        r8.translate(0.0f, (((LinearProgressIndicatorSpec) this.spec).trackThickness * (r9 - 1.0f)) / 2.0f);
    L19:
        float r2 = this.trackLength;
        r8.clipRect((-r2) / 2.0f, (-r1) / 2.0f, r2 / 2.0f, r1 / 2.0f);
        this.displayedTrackThickness = ((LinearProgressIndicatorSpec) this.spec).trackThickness * r9;
        this.displayedCornerRadius = ((LinearProgressIndicatorSpec) this.spec).trackCornerRadius * r9;
        return;
    L17:
        if (this.drawable.isHiding() == false) goto L19;
    L10:
        if (this.drawable.isHiding() == false) goto L15;
        if (((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 2) goto L15;
        goto L13
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(Canvas r12, Paint r13, float r14, float r15, int r16) {
        if (r14 != r15) goto L5;
        return;
    L5:
        float r1 = this.trackLength;
        float r4 = this.displayedCornerRadius;
        float r7 = (((-r1) / 2.0f) + r4) + ((r1 - (r4 * 2.0f)) * r14);
        float r9 = (((-r1) / 2.0f) + r4) + ((r1 - (r4 * 2.0f)) * r15);
        r13.setStyle(Paint.Style.FILL);
        r13.setAntiAlias(true);
        r13.setColor(r16);
        float r2 = this.displayedTrackThickness;
        r12.drawRect(r7, (-r2) / 2.0f, r9, r2 / 2.0f, r13);
        float r3 = this.displayedCornerRadius;
        RectF r10 = new RectF(-r3, -r3, r3, r3);
        drawRoundedEnd(r12, r13, this.displayedTrackThickness, this.displayedCornerRadius, r7, true, r10);
        drawRoundedEnd(r12, r13, this.displayedTrackThickness, this.displayedCornerRadius, r9, false, r10);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillTrack(Canvas r13, Paint r14) {
        int r0 = MaterialColors.compositeARGBWithAlpha(((LinearProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        float r1 = ((-this.trackLength) / 2.0f) + this.displayedCornerRadius;
        float r11 = -r1;
        r14.setStyle(Paint.Style.FILL);
        r14.setAntiAlias(true);
        r14.setColor(r0);
        float r2 = this.displayedTrackThickness;
        r13.drawRect(r1, (-r2) / 2.0f, r11, r2 / 2.0f, r14);
        float r3 = this.displayedCornerRadius;
        RectF r4 = new RectF(-r3, -r3, r3, r3);
        drawRoundedEnd(r13, r14, this.displayedTrackThickness, this.displayedCornerRadius, r1, true, r4);
        drawRoundedEnd(r13, r14, this.displayedTrackThickness, this.displayedCornerRadius, r11, false, r4);
    }

    private static void drawRoundedEnd(Canvas r10, Paint r11, float r12, float r13, float r14, boolean r15, RectF r16) {
        r10.save();
        r10.translate(r14, 0.0f);
        if (r15 == true) goto L5;
        r10.rotate(180.0f);
    L5:
        float r8 = ((-r12) / 2.0f) + r13;
        float r9 = (r12 / 2.0f) - r13;
        r10.drawRect(-r13, r8, 0.0f, r9, r11);
        r10.save();
        r10.translate(0.0f, r8);
        r10.drawArc(r16, 180.0f, 90.0f, true, r11);
        r10.restore();
        r10.translate(0.0f, r9);
        r10.drawArc(r16, 180.0f, -90.0f, true, r11);
        r10.restore();
    }
}
