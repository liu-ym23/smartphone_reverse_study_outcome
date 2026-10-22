package org.apache.commons.math3.fraction;

import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public class FractionField implements Field<Fraction>, Serializable {
    private static final long serialVersionUID = -1257768487499119313L;

    /* JADX INFO: renamed from: org.apache.commons.math3.fraction.FractionField$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class LazyHolder {
        private static final FractionField INSTANCE = null;

        private LazyHolder() {
        }

        static /* synthetic */ FractionField access$000() {
            return INSTANCE;
        }

        static {
            INSTANCE = new FractionField(null);
        }
    }

    /* synthetic */ FractionField(AnonymousClass1 r1) {
        this();
    }

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ Fraction getOne() {
        return getOne2();
    }

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ Fraction getZero() {
        return getZero2();
    }

    private FractionField() {
    }

    public static FractionField getInstance() {
        return LazyHolder.access$000();
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getOne, reason: avoid collision after fix types in other method */
    public Fraction getOne2() {
        return Fraction.ONE;
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getZero, reason: avoid collision after fix types in other method */
    public Fraction getZero2() {
        return Fraction.ZERO;
    }

    @Override // org.apache.commons.math3.Field
    public Class<? extends FieldElement<Fraction>> getRuntimeClass() {
        return Fraction.class;
    }

    private Object readResolve() {
        return LazyHolder.access$000();
    }
}
