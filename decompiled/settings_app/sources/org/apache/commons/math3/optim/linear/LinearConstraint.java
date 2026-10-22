package org.apache.commons.math3.optim.linear;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: loaded from: classes6.dex */
public class LinearConstraint implements Serializable {
    private static final long serialVersionUID = -764632794033034092L;
    private final transient RealVector coefficients;
    private final Relationship relationship;
    private final double value;

    public LinearConstraint(double[] r2, Relationship r3, double r4) {
        this(new ArrayRealVector(r2), r3, r4);
    }

    public LinearConstraint(RealVector r1, Relationship r2, double r3) {
        this.coefficients = r1;
        this.relationship = r2;
        this.value = r3;
    }

    public LinearConstraint(double[] r9, double r10, Relationship r12, double[] r13, double r14) {
        int r0 = r9.length;
        double[] r1 = new double[r0];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = r9[r3] - r13[r3];
        r3 = r3 + 1;
        goto L3
    L5:
        this.coefficients = new ArrayRealVector(r1, false);
        this.relationship = r12;
        this.value = r14 - r10;
    }

    public LinearConstraint(RealVector r1, double r2, Relationship r4, RealVector r5, double r6) {
        this.coefficients = r1.subtract(r5);
        this.relationship = r4;
        this.value = r6 - r2;
    }

    public RealVector getCoefficients() {
        return this.coefficients;
    }

    public Relationship getRelationship() {
        return this.relationship;
    }

    public double getValue() {
        return this.value;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof LinearConstraint) == false) goto L16;
        LinearConstraint r9 = (LinearConstraint) r8;
        if (this.relationship != r9.relationship) goto L15;
        if (this.value != r9.value) goto L15;
        if (this.coefficients.equals(r9.coefficients) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.relationship.hashCode() ^ Double.valueOf(this.value).hashCode();
        return this.coefficients.hashCode() ^ r0;
    }

    private void writeObject(ObjectOutputStream r1) throws IOException {
        r1.defaultWriteObject();
        MatrixUtils.serializeRealVector(this.coefficients, r1);
    }

    private void readObject(ObjectInputStream r2) throws ClassNotFoundException, IOException {
        r2.defaultReadObject();
        MatrixUtils.deserializeRealVector(this, "coefficients", r2);
    }
}
