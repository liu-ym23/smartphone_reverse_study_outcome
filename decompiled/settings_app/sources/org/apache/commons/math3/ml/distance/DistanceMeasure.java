package org.apache.commons.math3.ml.distance;

import java.io.Serializable;
import org.apache.commons.math3.exception.DimensionMismatchException;

/* JADX INFO: loaded from: classes6.dex */
public interface DistanceMeasure extends Serializable {
    double compute(double[] r1, double[] r2) throws DimensionMismatchException;
}
