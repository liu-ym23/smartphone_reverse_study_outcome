package org.apache.commons.math3.fraction;

import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public class BigFractionField implements Field<BigFraction>, Serializable {
    private static final long serialVersionUID = -1699294557189741703L;

    /* JADX INFO: renamed from: org.apache.commons.math3.fraction.BigFractionField$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class LazyHolder {
        private static final BigFractionField INSTANCE = null;

        private LazyHolder() {
        }

        static /* synthetic */ BigFractionField access$000() {
            return INSTANCE;
        }

        static {
            INSTANCE = new BigFractionField(null);
        }
    }

    /* synthetic */ BigFractionField(AnonymousClass1 r1) {
        this();
    }

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ BigFraction getOne() {
        return getOne2();
    }

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ BigFraction getZero() {
        return getZero2();
    }

    private BigFractionField() {
    }

    public static BigFractionField getInstance() {
        return LazyHolder.access$000();
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getOne, reason: avoid collision after fix types in other method */
    public BigFraction getOne2() {
        return BigFraction.ONE;
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getZero, reason: avoid collision after fix types in other method */
    public BigFraction getZero2() {
        return BigFraction.ZERO;
    }

    @Override // org.apache.commons.math3.Field
    public Class<? extends FieldElement<BigFraction>> getRuntimeClass() {
        return BigFraction.class;
    }

    private Object readResolve() {
        return LazyHolder.access$000();
    }
}
