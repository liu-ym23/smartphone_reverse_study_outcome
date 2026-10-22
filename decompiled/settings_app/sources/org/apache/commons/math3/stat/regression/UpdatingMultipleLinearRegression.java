package org.apache.commons.math3.stat.regression;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NoDataException;

/* JADX INFO: loaded from: classes6.dex */
public interface UpdatingMultipleLinearRegression {
    void addObservation(double[] r1, double r2) throws ModelSpecificationException;

    void addObservations(double[][] r1, double[] r2) throws ModelSpecificationException;

    void clear();

    long getN();

    boolean hasIntercept();

    RegressionResults regress() throws ModelSpecificationException, NoDataException;

    RegressionResults regress(int[] r1) throws ModelSpecificationException, MathIllegalArgumentException;
}
