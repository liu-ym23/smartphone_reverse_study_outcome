package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class TooManyIterationsException extends MaxCountExceededException {
    private static final long serialVersionUID = 20121211;

    public TooManyIterationsException(Number r2) {
        super(r2);
        getContext().addMessage(LocalizedFormats.ITERATIONS, new Object[0]);
    }
}
