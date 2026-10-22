package com.google.android.material.bottomappbar;

import a.a;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* JADX INFO: loaded from: classes.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private float cradleVerticalOffset;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float r1, float r2, float r3) {
        this.fabMargin = r1;
        this.roundedCornerRadius = r2;
        setCradleVerticalOffset(r3);
        this.horizontalOffset = 0.0f;
    }

    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float r20, float r21, float r22, @NonNull ShapePath r23) {
        float r3 = this.fabDiameter;
        if (r3 != 0.0f) goto L6;
        r23.lineTo(r20, 0.0f);
        return;
    L6:
        float r12 = ((this.fabMargin * 2.0f) + r3) / 2.0f;
        float r13 = r22 * this.roundedCornerRadius;
        float r14 = r21 + this.horizontalOffset;
        float r0 = a.a(1.0f, r22, r12, this.cradleVerticalOffset * r22);
        if ((r0 / r12) < 1.0f) goto L10;
        r23.lineTo(r20, 0.0f);
        return;
    L10:
        float r2 = r12 + r13;
        float r4 = r0 + r13;
        float r5 = (float) Math.sqrt((r2 * r2) - (r4 * r4));
        float r6 = r14 - r5;
        float r15 = r14 + r5;
        float r8 = (float) Math.toDegrees(Math.atan(r5 / r4));
        float r16 = 90.0f - r8;
        r23.lineTo(r6, 0.0f);
        float r17 = r13 * 2.0f;
        r23.addArc(r6 - r13, 0.0f, r6 + r13, r17, 270.0f, r8);
        r23.addArc(r14 - r12, (-r12) - r0, r14 + r12, r12 - r0, 180.0f - r16, (r16 * 2.0f) - 180.0f);
        r23.addArc(r15 - r13, 0.0f, r15 + r13, r17, 270.0f - r8, r8);
        r23.lineTo(r20, 0.0f);
    }

    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.fabDiameter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public void setCradleVerticalOffset(@FloatRange(from = 0.0d) float r2) {
        if (r2 < 0.0f) goto L7;
        this.cradleVerticalOffset = r2;
        return;
    L7:
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void setFabCradleMargin(float r1) {
        this.fabMargin = r1;
    }

    public void setFabCradleRoundedCornerRadius(float r1) {
        this.roundedCornerRadius = r1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float r1) {
        this.fabDiameter = r1;
    }

    public void setHorizontalOffset(float r1) {
        this.horizontalOffset = r1;
    }
}
