package com.google.android.material.shape;

/* JADX INFO: loaded from: classes3.dex */
public class RoundedCornerTreatment extends CornerTreatment {
    float radius;

    public RoundedCornerTreatment() {
        this.radius = -1.0f;
    }

    @Deprecated
    public RoundedCornerTreatment(float r1) {
        this.radius = r1;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(ShapePath r11, float r12, float r13, float r14) {
        r11.reset(0.0f, r14 * r13, 180.0f, 180.0f - r12);
        float r7 = (r14 * 2.0f) * r13;
        r11.addArc(0.0f, 0.0f, r7, r7, 180.0f, r12);
    }
}
