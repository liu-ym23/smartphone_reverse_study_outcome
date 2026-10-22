package com.google.android.material.bottomappbar;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* JADX INFO: loaded from: classes2.dex */
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

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float r20, float r21, float r22, ShapePath r23) {
        float r2 = this.fabDiameter;
        if (r2 != 0.0f) goto L6;
        r23.lineTo(r20, 0.0f);
        return;
    L6:
        float r12 = ((this.fabMargin * 2.0f) + r2) / 2.0f;
        float r13 = r22 * this.roundedCornerRadius;
        float r14 = r21 + this.horizontalOffset;
        float r0 = (this.cradleVerticalOffset * r22) + ((1.0f - r22) * r12);
        if ((r0 / r12) < 1.0f) goto L10;
        r23.lineTo(r20, 0.0f);
        return;
    L10:
        float r3 = r12 + r13;
        float r4 = r0 + r13;
        float r5 = (float) Math.sqrt((r3 * r3) - (r4 * r4));
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

    public float getFabDiameter() {
        return this.fabDiameter;
    }

    public void setFabDiameter(float r1) {
        this.fabDiameter = r1;
    }

    void setHorizontalOffset(float r1) {
        this.horizontalOffset = r1;
    }

    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    void setCradleVerticalOffset(float r2) {
        if (r2 < 0.0f) goto L7;
        this.cradleVerticalOffset = r2;
        return;
    L7:
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    float getFabCradleMargin() {
        return this.fabMargin;
    }

    void setFabCradleMargin(float r1) {
        this.fabMargin = r1;
    }

    float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    void setFabCradleRoundedCornerRadius(float r1) {
        this.roundedCornerRadius = r1;
    }
}
