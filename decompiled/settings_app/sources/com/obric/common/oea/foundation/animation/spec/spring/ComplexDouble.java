package com.obric.common.oea.foundation.animation.spec.spring;

import android.icu.text.PluralRules;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FloatSpringSpec.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0011\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0086\nJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0011\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0086\nJ\u0011\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0086\nJ\u0011\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0086\nJ\u0011\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0086\nJ\u0011\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\u0086\nJ\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0000H\u0086\nR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/obric/common/oea/foundation/animation/spec/spring/ComplexDouble;", "", "_real", "", "_imaginary", "(DD)V", "imaginary", "getImaginary", "()D", "real", "getReal", "component1", "component2", "copy", "div", PluralRules.KEYWORD_OTHER, "equals", "", "hashCode", "", "minus", "plus", "times", "toString", "", "unaryMinus", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class ComplexDouble {
    private double _imaginary;
    private double _real;

    private final double component1() {
        return this._real;
    }

    private final double component2() {
        return this._imaginary;
    }

    public static /* synthetic */ ComplexDouble copy$default(ComplexDouble r0, double r1, double r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0._real;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0._imaginary;
    L9:
        return r0.copy(r1, r3);
    }

    public final ComplexDouble copy(double r1, double r3) {
        return new ComplexDouble(r1, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L4;
        return true;
    L4:
        if ((r5 instanceof ComplexDouble) == false) goto L10;
        ComplexDouble r6 = (ComplexDouble) r5;
        if (Double.compare(this._real, r6._real) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this._imaginary, r6._imaginary) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        return (Double.hashCode(this._real) * 31) + Double.hashCode(this._imaginary);
    }

    public String toString() {
        return "ComplexDouble(_real=" + this._real + ", _imaginary=" + this._imaginary + ")";
    }

    public ComplexDouble(double r1, double r3) {
        this._real = r1;
        this._imaginary = r3;
    }

    public static final /* synthetic */ double access$get_imaginary$p(ComplexDouble r2) {
        return r2._imaginary;
    }

    public static final /* synthetic */ double access$get_real$p(ComplexDouble r2) {
        return r2._real;
    }

    public static final /* synthetic */ void access$set_imaginary$p(ComplexDouble r0, double r1) {
        r0._imaginary = r1;
    }

    public static final /* synthetic */ void access$set_real$p(ComplexDouble r0, double r1) {
        r0._real = r1;
    }

    public final double getReal() {
        return this._real;
    }

    public final double getImaginary() {
        return this._imaginary;
    }

    public final ComplexDouble plus(double r3) {
        access$set_real$p(this, access$get_real$p(this) + r3);
        return this;
    }

    public final ComplexDouble plus(ComplexDouble r5) {
        Intrinsics.checkNotNullParameter(r5, PluralRules.KEYWORD_OTHER);
        access$set_real$p(this, access$get_real$p(this) + r5.getReal());
        access$set_imaginary$p(this, access$get_imaginary$p(this) + r5.getImaginary());
        return this;
    }

    public final ComplexDouble times(double r3) {
        access$set_real$p(this, access$get_real$p(this) * r3);
        access$set_imaginary$p(this, access$get_imaginary$p(this) * r3);
        return this;
    }

    public final ComplexDouble times(ComplexDouble r7) {
        Intrinsics.checkNotNullParameter(r7, PluralRules.KEYWORD_OTHER);
        access$set_real$p(this, (getReal() * r7.getReal()) - (getImaginary() * r7.getImaginary()));
        access$set_imaginary$p(this, (getReal() * r7.getImaginary()) + (r7.getReal() * getImaginary()));
        return this;
    }

    public final ComplexDouble unaryMinus() {
        double r2 = -1;
        access$set_real$p(this, access$get_real$p(this) * r2);
        access$set_imaginary$p(this, access$get_imaginary$p(this) * r2);
        return this;
    }

    public final ComplexDouble div(double r3) {
        access$set_real$p(this, access$get_real$p(this) / r3);
        access$set_imaginary$p(this, access$get_imaginary$p(this) / r3);
        return this;
    }

    public final ComplexDouble minus(double r3) {
        double r0 = access$get_real$p(this);
        access$set_real$p(this, r0 + (-r3));
        return this;
    }

    public final ComplexDouble minus(ComplexDouble r5) {
        Intrinsics.checkNotNullParameter(r5, PluralRules.KEYWORD_OTHER);
        double r2 = -1;
        access$set_real$p(r5, access$get_real$p(r5) * r2);
        access$set_imaginary$p(r5, access$get_imaginary$p(r5) * r2);
        access$set_real$p(this, access$get_real$p(this) + r5.getReal());
        access$set_imaginary$p(this, access$get_imaginary$p(this) + r5.getImaginary());
        return this;
    }
}
