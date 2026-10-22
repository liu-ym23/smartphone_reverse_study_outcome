package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes2.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    private float trackLength;

    public LinearDrawingDelegate(@NonNull LinearProgressIndicatorSpec r1) {
        super(r1);
        this.trackLength = 300.0f;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas r8, @FloatRange(from = 0.0d, to = 1.0d) float r9) {
        Rect r0 = r8.getClipBounds();
        this.trackLength = r0.width();
        float r1 = ((LinearProgressIndicatorSpec) this.spec).trackThickness;
        r8.translate(r0.left + (r0.width() / 2.0f), (r0.top + (r0.height() / 2.0f)) + Math.max(0.0f, (r0.height() - ((LinearProgressIndicatorSpec) this.spec).trackThickness) / 2.0f));
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
        S r10 = this.spec;
        this.displayedTrackThickness = ((LinearProgressIndicatorSpec) r10).trackThickness * r9;
        this.displayedCornerRadius = ((LinearProgressIndicatorSpec) r10).trackCornerRadius * r9;
        return;
    L17:
        if (this.drawable.isHiding() == false) goto L19;
    L10:
        if (this.drawable.isHiding() == false) goto L15;
        if (((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 2) goto L15;
        goto L13
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@NonNull Canvas r6, @NonNull Paint r7, @FloatRange(from = 0.0d, to = 1.0d) float r8, @FloatRange(from = 0.0d, to = 1.0d) float r9, @ColorInt int r10) {
        if (r8 != r9) goto L5;
        return;
    L5:
        float r0 = this.trackLength;
        float r3 = this.displayedCornerRadius;
        float r1 = ((-r0) / 2.0f) + (r8 * (r0 - (r3 * 2.0f)));
        float r11 = (((-r0) / 2.0f) + (r9 * (r0 - (r3 * 2.0f)))) + (r3 * 2.0f);
        r7.setStyle(Paint.Style.FILL);
        r7.setAntiAlias(true);
        r7.setColor(r10);
        float r12 = this.displayedTrackThickness;
        RectF r13 = new RectF(r1, (-r12) / 2.0f, r11, r12 / 2.0f);
        float r5 = this.displayedCornerRadius;
        r6.drawRoundRect(r13, r5, r5, r7);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void fillTrack(@NonNull Canvas r7, @NonNull Paint r8) {
        int r0 = MaterialColors.compositeARGBWithAlpha(((LinearProgressIndicatorSpec) this.spec).trackColor, this.drawable.getAlpha());
        r8.setStyle(Paint.Style.FILL);
        r8.setAntiAlias(true);
        r8.setColor(r0);
        float r1 = this.trackLength;
        float r4 = this.displayedTrackThickness;
        RectF r2 = new RectF((-r1) / 2.0f, (-r4) / 2.0f, r1 / 2.0f, r4 / 2.0f);
        float r6 = this.displayedCornerRadius;
        r7.drawRoundRect(r2, r6, r6, r8);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return -1;
    }
}
