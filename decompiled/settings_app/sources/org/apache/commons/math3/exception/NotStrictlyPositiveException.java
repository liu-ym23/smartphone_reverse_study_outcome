package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;

/* JADX INFO: loaded from: classes6.dex */
public class NotStrictlyPositiveException extends NumberIsTooSmallException {
    private static final long serialVersionUID = -7824848630829852237L;

    public NotStrictlyPositiveException(Number r3) {
        super(r3, INTEGER_ZERO, false);
    }

    public NotStrictlyPositiveException(Localizable r3, Number r4) {
        super(r3, r4, INTEGER_ZERO, false);
    }
}
