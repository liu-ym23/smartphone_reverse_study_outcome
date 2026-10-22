package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class NotFiniteNumberException extends MathIllegalNumberException {
    private static final long serialVersionUID = -6100997100383932834L;

    public NotFiniteNumberException(Number r2, Object... r3) {
        this(LocalizedFormats.NOT_FINITE_NUMBER, r2, r3);
    }

    public NotFiniteNumberException(Localizable r1, Number r2, Object... r3) {
        super(r1, r2, r3);
    }
}
