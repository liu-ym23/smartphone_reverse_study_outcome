package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;

/* JADX INFO: loaded from: classes6.dex */
public class NotPositiveException extends NumberIsTooSmallException {
    private static final long serialVersionUID = -2250556892093726375L;

    public NotPositiveException(Number r3) {
        super(r3, INTEGER_ZERO, true);
    }

    public NotPositiveException(Localizable r3, Number r4) {
        super(r3, r4, INTEGER_ZERO, true);
    }
}
