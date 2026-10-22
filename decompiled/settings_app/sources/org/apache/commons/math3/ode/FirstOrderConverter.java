package org.apache.commons.math3.ode;

/* JADX INFO: loaded from: classes6.dex */
public class FirstOrderConverter implements FirstOrderDifferentialEquations {
    private final int dimension;
    private final SecondOrderDifferentialEquations equations;
    private final double[] z;
    private final double[] zDDot;
    private final double[] zDot;

    public FirstOrderConverter(SecondOrderDifferentialEquations r2) {
        this.equations = r2;
        int r3 = r2.getDimension();
        this.dimension = r3;
        this.z = new double[r3];
        this.zDot = new double[r3];
        this.zDDot = new double[r3];
    }

    @Override // org.apache.commons.math3.ode.FirstOrderDifferentialEquations
    public int getDimension() {
        return this.dimension * 2;
    }

    @Override // org.apache.commons.math3.ode.FirstOrderDifferentialEquations
    public void computeDerivatives(double r10, double[] r12, double[] r13) {
        System.arraycopy(r12, 0, this.z, 0, this.dimension);
        int r0 = this.dimension;
        System.arraycopy(r12, r0, this.zDot, 0, r0);
        this.equations.computeSecondDerivatives(r10, this.z, this.zDot, this.zDDot);
        System.arraycopy(this.zDot, 0, r13, 0, this.dimension);
        double[] r11 = this.zDDot;
        int r9 = this.dimension;
        System.arraycopy(r11, 0, r13, r9, r9);
    }
}
