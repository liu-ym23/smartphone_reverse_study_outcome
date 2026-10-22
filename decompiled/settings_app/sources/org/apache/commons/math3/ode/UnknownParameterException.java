package org.apache.commons.math3.ode;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class UnknownParameterException extends MathIllegalArgumentException {
    private static final long serialVersionUID = 20120902;
    private final String name;

    public UnknownParameterException(String r4) {
        super(LocalizedFormats.UNKNOWN_PARAMETER, new Object[]{r4});
        this.name = r4;
    }

    public String getName() {
        return this.name;
    }
}
