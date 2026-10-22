package com.google.android.material.shape;

/* JADX INFO: loaded from: classes2.dex */
public class CutCornerTreatment extends CornerTreatment {
    float size;

    public CutCornerTreatment() {
        this.size = -1.0f;
    }

    @Deprecated
    public CutCornerTreatment(float r1) {
        this.size = r1;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(ShapePath r5, float r6, float r7, float r8) {
        r5.reset(0.0f, r8 * r7, 180.0f, 180.0f - r6);
        double r2 = r8;
        double r9 = r7;
        r5.lineTo((float) ((Math.sin(Math.toRadians(r6)) * r2) * r9), (float) ((Math.sin(Math.toRadians(90.0f - r6)) * r2) * r9));
    }
}
