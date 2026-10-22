package org.apache.commons.math3.optim.linear;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optim.OptimizationData;

/* JADX INFO: loaded from: classes6.dex */
public class LinearObjectiveFunction implements MultivariateFunction, OptimizationData, Serializable {
    private static final long serialVersionUID = -4531815507568396090L;
    private final transient RealVector coefficients;
    private final double constantTerm;

    public LinearObjectiveFunction(double[] r2, double r3) {
        this(new ArrayRealVector(r2), r3);
    }

    public LinearObjectiveFunction(RealVector r1, double r2) {
        this.coefficients = r1;
        this.constantTerm = r2;
    }

    public RealVector getCoefficients() {
        return this.coefficients;
    }

    public double getConstantTerm() {
        return this.constantTerm;
    }

    @Override // org.apache.commons.math3.analysis.MultivariateFunction
    public double value(double[] r3) {
        return value(new ArrayRealVector(r3, false));
    }

    public double value(RealVector r3) {
        return this.coefficients.dotProduct(r3) + this.constantTerm;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof LinearObjectiveFunction) == false) goto L14;
        LinearObjectiveFunction r9 = (LinearObjectiveFunction) r8;
        if (this.constantTerm != r9.constantTerm) goto L13;
        if (this.coefficients.equals(r9.coefficients) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = Double.valueOf(this.constantTerm).hashCode();
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
