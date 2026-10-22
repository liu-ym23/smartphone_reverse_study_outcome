package org.apache.commons.math3.util;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public class Decimal64Field implements Field<Decimal64> {
    private static final Decimal64Field INSTANCE = null;

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ Decimal64 getOne() {
        return getOne2();
    }

    @Override // org.apache.commons.math3.Field
    public /* bridge */ /* synthetic */ Decimal64 getZero() {
        return getZero2();
    }

    static {
        INSTANCE = new Decimal64Field();
    }

    private Decimal64Field() {
    }

    public static final Decimal64Field getInstance() {
        return INSTANCE;
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getZero, reason: avoid collision after fix types in other method */
    public Decimal64 getZero2() {
        return Decimal64.ZERO;
    }

    @Override // org.apache.commons.math3.Field
    /* JADX INFO: renamed from: getOne, reason: avoid collision after fix types in other method */
    public Decimal64 getOne2() {
        return Decimal64.ONE;
    }

    @Override // org.apache.commons.math3.Field
    public Class<? extends FieldElement<Decimal64>> getRuntimeClass() {
        return Decimal64.class;
    }
}
