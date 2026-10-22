package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class InterpolatingMicrosphere2D extends InterpolatingMicrosphere {
    private static final int DIMENSION = 2;

    @Override // org.apache.commons.math3.analysis.interpolation.InterpolatingMicrosphere
    public /* bridge */ /* synthetic */ InterpolatingMicrosphere copy() {
        return copy();
    }

    public InterpolatingMicrosphere2D(int r11, double r12, double r14, double r16) {
        super(2, r11, r12, r14, r16);
        int r1 = 0;
    L3:
        if (r1 >= r11) goto L5;
        double r2 = (((double) r1) * 6.283185307179586d) / ((double) r11);
        add(new double[]{FastMath.cos(r2), FastMath.sin(r2)}, false);
        r1 = r1 + 1;
        goto L3
    }

    protected InterpolatingMicrosphere2D(InterpolatingMicrosphere2D r1) {
        super(r1);
    }

    @Override // org.apache.commons.math3.analysis.interpolation.InterpolatingMicrosphere
    public InterpolatingMicrosphere2D copy() {
        return new InterpolatingMicrosphere2D(this);
    }
}
