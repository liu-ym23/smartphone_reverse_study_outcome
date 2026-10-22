package org.apache.commons.math3.filter;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultMeasurementModel implements MeasurementModel {
    private RealMatrix measurementMatrix;
    private RealMatrix measurementNoise;

    public DefaultMeasurementModel(double[][] r2, double[][] r3) throws NullArgumentException, NoDataException, DimensionMismatchException {
        this(new Array2DRowRealMatrix(r2), new Array2DRowRealMatrix(r3));
    }

    public DefaultMeasurementModel(RealMatrix r1, RealMatrix r2) {
        this.measurementMatrix = r1;
        this.measurementNoise = r2;
    }

    @Override // org.apache.commons.math3.filter.MeasurementModel
    public RealMatrix getMeasurementMatrix() {
        return this.measurementMatrix;
    }

    @Override // org.apache.commons.math3.filter.MeasurementModel
    public RealMatrix getMeasurementNoise() {
        return this.measurementNoise;
    }
}
