package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.DimensionMismatchException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class RealLinearOperator {
    public abstract int getColumnDimension();

    public abstract int getRowDimension();

    public boolean isTransposable() {
        return false;
    }

    public abstract RealVector operate(RealVector r1) throws DimensionMismatchException;

    public RealLinearOperator() {
    }

    public RealVector operateTranspose(RealVector r1) throws DimensionMismatchException, UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
