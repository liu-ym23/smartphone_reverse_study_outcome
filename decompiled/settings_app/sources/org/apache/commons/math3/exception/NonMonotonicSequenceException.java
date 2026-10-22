package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class NonMonotonicSequenceException extends MathIllegalNumberException {
    private static final long serialVersionUID = 3596849179428944575L;
    private final MathArrays.OrderDirection direction;
    private final int index;
    private final Number previous;
    private final boolean strict;

    public NonMonotonicSequenceException(Number r7, Number r8, int r9) {
        this(r7, r8, r9, MathArrays.OrderDirection.INCREASING, true);
    }

    public NonMonotonicSequenceException(Number r5, Number r6, int r7, MathArrays.OrderDirection r8, boolean r9) {
        if (r8 != MathArrays.OrderDirection.INCREASING) goto L7;
        if (r9 == false) goto L6;
        LocalizedFormats r0 = LocalizedFormats.NOT_STRICTLY_INCREASING_SEQUENCE;
    L10:
        super(r0, r5, new Object[]{r6, Integer.valueOf(r7), Integer.valueOf(r7 - 1)});
        this.direction = r8;
        this.strict = r9;
        this.index = r7;
        this.previous = r6;
        return;
    L6:
        r0 = LocalizedFormats.NOT_INCREASING_SEQUENCE;
        goto L10
    L7:
        if (r9 == false) goto L9;
        r0 = LocalizedFormats.NOT_STRICTLY_DECREASING_SEQUENCE;
        goto L10
    L9:
        r0 = LocalizedFormats.NOT_DECREASING_SEQUENCE;
        goto L10
    }

    public MathArrays.OrderDirection getDirection() {
        return this.direction;
    }

    public boolean getStrict() {
        return this.strict;
    }

    public int getIndex() {
        return this.index;
    }

    public Number getPrevious() {
        return this.previous;
    }
}
