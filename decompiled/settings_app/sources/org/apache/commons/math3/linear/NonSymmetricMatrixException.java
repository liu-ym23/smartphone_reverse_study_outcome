package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class NonSymmetricMatrixException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -7518495577824189882L;
    private final int column;
    private final int row;
    private final double threshold;

    public NonSymmetricMatrixException(int r5, int r6, double r7) {
        super(LocalizedFormats.NON_SYMMETRIC_MATRIX, new Object[]{Integer.valueOf(r5), Integer.valueOf(r6), Double.valueOf(r7)});
        this.row = r5;
        this.column = r6;
        this.threshold = r7;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public double getThreshold() {
        return this.threshold;
    }
}
