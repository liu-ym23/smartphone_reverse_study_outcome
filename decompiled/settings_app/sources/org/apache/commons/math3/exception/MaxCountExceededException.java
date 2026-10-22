package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class MaxCountExceededException extends MathIllegalStateException {
    private static final long serialVersionUID = 4330003017885151975L;
    private final Number max;

    public MaxCountExceededException(Number r3) {
        this(LocalizedFormats.MAX_COUNT_EXCEEDED, r3, new Object[0]);
    }

    public MaxCountExceededException(Localizable r4, Number r5, Object... r6) {
        getContext().addMessage(r4, new Object[]{r5, r6});
        this.max = r5;
    }

    public Number getMax() {
        return this.max;
    }
}
