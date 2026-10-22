package org.apache.commons.math3.exception;

import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class NoBracketingException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -3629324471511904459L;
    private final double fHi;
    private final double fLo;
    private final double hi;
    private final double lo;

    public NoBracketingException(double r12, double r14, double r16, double r18) {
        this(LocalizedFormats.SAME_SIGN_AT_ENDPOINTS, r12, r14, r16, r18, new Object[0]);
    }

    public NoBracketingException(Localizable r4, double r5, double r7, double r9, double r11, Object... r13) {
        super(r4, new Object[]{Double.valueOf(r5), Double.valueOf(r7), Double.valueOf(r9), Double.valueOf(r11), r13});
        this.lo = r5;
        this.hi = r7;
        this.fLo = r9;
        this.fHi = r11;
    }

    public double getLo() {
        return this.lo;
    }

    public double getHi() {
        return this.hi;
    }

    public double getFLo() {
        return this.fLo;
    }

    public double getFHi() {
        return this.fHi;
    }
}
