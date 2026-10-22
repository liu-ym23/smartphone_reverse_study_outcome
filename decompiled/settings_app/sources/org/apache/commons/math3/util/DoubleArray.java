package org.apache.commons.math3.util;

/* JADX INFO: loaded from: classes6.dex */
public interface DoubleArray {
    void addElement(double r1);

    double addElementRolling(double r1);

    void addElements(double[] r1);

    void clear();

    double getElement(int r1);

    double[] getElements();

    int getNumElements();

    void setElement(int r1, double r2);
}
