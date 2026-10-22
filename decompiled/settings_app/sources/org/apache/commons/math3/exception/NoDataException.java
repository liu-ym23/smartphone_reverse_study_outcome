package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class NoDataException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -3629324471511904459L;

    public NoDataException() {
        this(LocalizedFormats.NO_DATA);
    }

    public NoDataException(Localizable r2) {
        super(r2, new Object[0]);
    }
}
