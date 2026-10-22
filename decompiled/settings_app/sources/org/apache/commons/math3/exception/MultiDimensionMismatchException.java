package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class MultiDimensionMismatchException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -8415396756375798143L;
    private final Integer[] expected;
    private final Integer[] wrong;

    public MultiDimensionMismatchException(Integer[] r2, Integer[] r3) {
        this(LocalizedFormats.DIMENSIONS_MISMATCH, r2, r3);
    }

    public MultiDimensionMismatchException(Localizable r3, Integer[] r4, Integer[] r5) {
        super(r3, new Object[]{r4, r5});
        this.wrong = (Integer[]) r4.clone();
        this.expected = (Integer[]) r5.clone();
    }

    public Integer[] getWrongDimensions() {
        return (Integer[]) this.wrong.clone();
    }

    public Integer[] getExpectedDimensions() {
        return (Integer[]) this.expected.clone();
    }

    public int getWrongDimension(int r1) {
        return this.wrong[r1].intValue();
    }

    public int getExpectedDimension(int r1) {
        return this.expected[r1].intValue();
    }
}
