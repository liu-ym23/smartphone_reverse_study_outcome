package org.apache.commons.math3.ode.sampling;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class NordsieckStepInterpolator extends AbstractStepInterpolator {
    private static final long serialVersionUID = -7179861704951334960L;
    private Array2DRowRealMatrix nordsieck;
    private double referenceTime;
    private double[] scaled;
    private double scalingH;
    protected double[] stateVariation;

    public NordsieckStepInterpolator() {
    }

    public NordsieckStepInterpolator(NordsieckStepInterpolator r4) {
        super(r4);
        this.scalingH = r4.scalingH;
        this.referenceTime = r4.referenceTime;
        double[] r0 = r4.scaled;
        if (r0 == null) goto L6;
        this.scaled = (double[]) r0.clone();
    L6:
        if (r4.nordsieck == null) goto L8;
        this.nordsieck = new Array2DRowRealMatrix(r4.nordsieck.getDataRef(), true);
    L8:
        double[] r5 = r4.stateVariation;
        if (r5 == null) goto L12;
        this.stateVariation = (double[]) r5.clone();
        return;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    protected StepInterpolator doCopy() {
        return new NordsieckStepInterpolator(this);
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void reinitialize(double[] r1, boolean r2, EquationsMapper r3, EquationsMapper[] r4) {
        super.reinitialize(r1, r2, r3, r4);
        this.stateVariation = new double[r1.length];
    }

    public void reinitialize(double r1, double r3, double[] r5, Array2DRowRealMatrix r6) {
        this.referenceTime = r1;
        this.scalingH = r3;
        this.scaled = r5;
        this.nordsieck = r6;
        setInterpolatedTime(getInterpolatedTime());
    }

    public void rescale(double r12) {
        double r0 = r12 / this.scalingH;
        int r3 = 0;
    L3:
        double[] r4 = this.scaled;
        if (r3 >= r4.length) goto L6;
        r4[r3] = r4[r3] * r0;
        r3 = r3 + 1;
        goto L3
    L6:
        double[][] r5 = this.nordsieck.getDataRef();
        double r6 = r0;
        int r7 = 0;
    L8:
        if (r7 >= r5.length) goto L14;
        r6 = r6 * r0;
        double[] r8 = r5[r7];
        int r9 = 0;
    L11:
        if (r9 >= r8.length) goto L13;
        r8[r9] = r8[r9] * r6;
        r9 = r9 + 1;
        goto L11
    L13:
        r7 = r7 + 1;
        goto L8
    L14:
        this.scalingH = r12;
    }

    public double[] getInterpolatedStateVariation() throws MaxCountExceededException {
        getInterpolatedState();
        return this.stateVariation;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    protected void computeInterpolatedStateAndDerivatives(double r18, double r20) {
        double r1 = this.interpolatedTime - this.referenceTime;
        double r3 = r1 / this.scalingH;
        Arrays.fill(this.stateVariation, 0.0d);
        Arrays.fill(this.interpolatedDerivatives, 0.0d);
        double[][] r5 = this.nordsieck.getDataRef();
        int r6 = r5.length;
    L3:
        r6 = r6 - 1;
        int r7 = 0;
        if (r6 < 0) goto L11;
        int r8 = r6 + 2;
        double[] r9 = r5[r6];
        double r10 = FastMath.pow(r3, r8);
    L7:
        if (r7 >= r9.length) goto L3;
        double r12 = r9[r7] * r10;
        double[] r14 = this.stateVariation;
        r14[r7] = r14[r7] + r12;
        double[] r15 = this.interpolatedDerivatives;
        r15[r7] = r15[r7] + (((double) r8) * r12);
        r7 = r7 + 1;
        r9 = r9;
        r10 = r10;
    L11:
        if (r7 >= this.currentState.length) goto L13;
        double[] r11 = this.stateVariation;
        r11[r7] = r11[r7] + (this.scaled[r7] * r3);
        this.interpolatedState[r7] = this.currentState[r7] + this.stateVariation[r7];
        this.interpolatedDerivatives[r7] = (this.interpolatedDerivatives[r7] + (this.scaled[r7] * r3)) / r1;
        r7 = r7 + 1;
        goto L11
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void writeExternal(ObjectOutput r7) throws IOException {
        writeBaseExternal(r7);
        r7.writeDouble(this.scalingH);
        r7.writeDouble(this.referenceTime);
        if (this.currentState != null) goto L5;
        int r0 = -1;
    L7:
        if (this.scaled != null) goto L9;
        r7.writeBoolean(false);
    L13:
        if (this.nordsieck != null) goto L15;
        r7.writeBoolean(false);
        return;
    L15:
        r7.writeBoolean(true);
        r7.writeObject(this.nordsieck);
        return;
    L9:
        r7.writeBoolean(true);
        int r1 = 0;
    L10:
        if (r1 >= r0) goto L13;
        r7.writeDouble(this.scaled[r1]);
        r1 = r1 + 1;
        goto L10
    L5:
        r0 = this.currentState.length;
        goto L7
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void readExternal(ObjectInput r10) throws IOException, ClassNotFoundException {
        double r0 = readBaseExternal(r10);
        this.scalingH = r10.readDouble();
        this.referenceTime = r10.readDouble();
        if (this.currentState != null) goto L5;
        int r2 = -1;
    L6:
        boolean r3 = r10.readBoolean();
        if (r3 == false) goto L11;
        this.scaled = new double[r2];
        int r5 = 0;
    L9:
        if (r5 >= r2) goto L12;
        this.scaled[r5] = r10.readDouble();
        r5 = r5 + 1;
    L12:
        boolean r6 = r10.readBoolean();
        if (r6 == false) goto L15;
        this.nordsieck = (Array2DRowRealMatrix) r10.readObject();
    L16:
        if (r3 == false) goto L19;
        if (r6 == false) goto L19;
        this.stateVariation = new double[r2];
        setInterpolatedTime(r0);
        return;
    L19:
        this.stateVariation = null;
        return;
    L15:
        this.nordsieck = null;
        goto L16
    L11:
        this.scaled = null;
        goto L12
    L5:
        r2 = this.currentState.length;
        goto L6
    }
}
