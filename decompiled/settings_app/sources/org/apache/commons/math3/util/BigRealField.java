package org.apache.commons.math3.util;

import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public class BigRealField implements Field<BigReal>, Serializable {
    private static final long serialVersionUID = 4756431066541037559L;

    /* JADX INFO: renamed from: org.apache.commons.math3.util.BigRealField$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class LazyHolder {
        private static final BigRealField INSTANCE = null;

        private LazyHolder() {
        }

        static /* synthetic */ BigRealField access$000() {
            return INSTANCE;
        }

        static {
            INSTANCE = new BigRealField(null);
        }
    }

    /* synthetic */ BigRealField(AnonymousClass1 r1) {
        this();
    }

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ BigReal getOne() {
        return getOne2();
    }

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ BigReal getZero() {
        return getZero2();
    }

    private BigRealField() {
    }

    public static BigRealField getInstance() {
        return LazyHolder.access$000();
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getOne, reason: avoid collision after fix types in other method */
    public BigReal getOne2() {
        return BigReal.ONE;
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getZero, reason: avoid collision after fix types in other method */
    public BigReal getZero2() {
        return BigReal.ZERO;
    }

    @Override // org.apache.commons.math3.Field
    public Class<? extends FieldElement<BigReal>> getRuntimeClass() {
        return BigReal.class;
    }

    private Object readResolve() {
        return LazyHolder.access$000();
    }
}
