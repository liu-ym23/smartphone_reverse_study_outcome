package org.apache.commons.math3.geometry;

import java.text.NumberFormat;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public interface Vector<S extends Space> extends Point<S> {
    Vector<S> add(double r1, Vector<S> r3);

    Vector<S> add(Vector<S> r1);

    double distance(Vector<S> r1);

    double distance1(Vector<S> r1);

    double distanceInf(Vector<S> r1);

    double distanceSq(Vector<S> r1);

    double dotProduct(Vector<S> r1);

    double getNorm();

    double getNorm1();

    double getNormInf();

    double getNormSq();

    Vector<S> getZero();

    boolean isInfinite();

    Vector<S> negate();

    Vector<S> normalize() throws MathArithmeticException;

    Vector<S> scalarMultiply(double r1);

    Vector<S> subtract(double r1, Vector<S> r3);

    Vector<S> subtract(Vector<S> r1);

    String toString(NumberFormat r1);
}
