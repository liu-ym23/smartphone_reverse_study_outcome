package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.ExceptionContextProvider;
import org.apache.commons.math3.exception.util.Localizable;

/* JADX INFO: loaded from: classes6.dex */
public class MathRuntimeException extends RuntimeException implements ExceptionContextProvider {
    private static final long serialVersionUID = 20120926;
    private final ExceptionContext context;

    public MathRuntimeException(Localizable r2, Object... r3) {
        ExceptionContext r0 = new ExceptionContext(this);
        this.context = r0;
        r0.addMessage(r2, r3);
    }

    @Override // org.apache.commons.math3.exception.util.ExceptionContextProvider
    public ExceptionContext getContext() {
        return this.context;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.context.getMessage();
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return this.context.getLocalizedMessage();
    }
}
