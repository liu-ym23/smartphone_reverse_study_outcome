package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class MathInternalError extends MathIllegalStateException {
    private static final String REPORT_URL = "https://issues.apache.org/jira/browse/MATH";
    private static final long serialVersionUID = -6276776513966934846L;

    public MathInternalError() {
        getContext().addMessage(LocalizedFormats.INTERNAL_ERROR, new Object[]{REPORT_URL});
    }

    public MathInternalError(Throwable r5) {
        super(r5, LocalizedFormats.INTERNAL_ERROR, new Object[]{REPORT_URL});
    }

    public MathInternalError(Localizable r1, Object... r2) {
        super(r1, r2);
    }
}
