package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class InsufficientDataException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -2629324471511903359L;

    public InsufficientDataException() {
        this(LocalizedFormats.INSUFFICIENT_DATA, new Object[0]);
    }

    public InsufficientDataException(Localizable r1, Object... r2) {
        super(r1, r2);
    }
}
