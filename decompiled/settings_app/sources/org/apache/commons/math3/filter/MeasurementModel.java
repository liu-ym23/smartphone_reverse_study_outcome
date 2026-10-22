package org.apache.commons.math3.filter;

import org.apache.commons.math3.linear.RealMatrix;

/* JADX INFO: loaded from: classes6.dex */
public interface MeasurementModel {
    RealMatrix getMeasurementMatrix();

    RealMatrix getMeasurementNoise();
}
