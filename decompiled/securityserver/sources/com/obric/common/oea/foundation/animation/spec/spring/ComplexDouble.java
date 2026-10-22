package com.obric.common.oea.foundation.animation.spec.spring;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ComplexDouble {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f124a;
    public double b;

    public ComplexDouble(double r1, double r3) {
        this.f124a = r1;
        this.b = r3;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof ComplexDouble) == false) goto L10;
        ComplexDouble r6 = (ComplexDouble) r5;
        if (Double.compare(this.f124a, r6.f124a) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.b, r6.b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r0 = Double.hashCode(this.f124a) * 31;
        return Double.hashCode(this.b) + r0;
    }

    public final String toString() {
        return "ComplexDouble(_real=" + this.f124a + ", _imaginary=" + this.b + ")";
    }
}
