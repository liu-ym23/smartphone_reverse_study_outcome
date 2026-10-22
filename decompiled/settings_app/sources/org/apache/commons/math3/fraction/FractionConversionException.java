package org.apache.commons.math3.fraction;

import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class FractionConversionException extends ConvergenceException {
    private static final long serialVersionUID = -4661812640132576263L;

    public FractionConversionException(double r4, int r6) {
        super(LocalizedFormats.FAILED_FRACTION_CONVERSION, new Object[]{Double.valueOf(r4), Integer.valueOf(r6)});
    }

    public FractionConversionException(double r4, long r6, long r8) {
        super(LocalizedFormats.FRACTION_CONVERSION_OVERFLOW, new Object[]{Double.valueOf(r4), Long.valueOf(r6), Long.valueOf(r8)});
    }
}
