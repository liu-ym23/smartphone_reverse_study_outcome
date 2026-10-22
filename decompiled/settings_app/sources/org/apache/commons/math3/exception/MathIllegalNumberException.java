package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;

/* JADX INFO: loaded from: classes6.dex */
public class MathIllegalNumberException extends MathIllegalArgumentException {
    protected static final Integer INTEGER_ZERO = null;
    private static final long serialVersionUID = -7447085893598031110L;
    private final Number argument;

    static {
        INTEGER_ZERO = 0;
    }

    protected MathIllegalNumberException(Localizable r3, Number r4, Object... r5) {
        super(r3, new Object[]{r4, r5});
        this.argument = r4;
    }

    public Number getArgument() {
        return this.argument;
    }
}
