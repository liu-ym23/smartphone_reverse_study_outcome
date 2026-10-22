package org.apache.commons.math3.ode.nonstiff;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;

/* JADX INFO: loaded from: classes6.dex */
abstract class RungeKuttaStepInterpolator extends AbstractStepInterpolator {
    protected AbstractIntegrator integrator;
    protected double[] previousState;
    protected double[][] yDotK;

    protected RungeKuttaStepInterpolator() {
        this.previousState = null;
        double[][] r1 = (double[][]) null;
        this.yDotK = null;
        this.integrator = null;
    }

    RungeKuttaStepInterpolator(RungeKuttaStepInterpolator r5) {
        super(r5);
        if (r5.currentState == null) goto L8;
        this.previousState = (double[]) r5.previousState.clone();
        this.yDotK = new double[r5.yDotK.length][];
        int r0 = 0;
    L5:
        double[][] r2 = r5.yDotK;
        if (r0 >= r2.length) goto L9;
        this.yDotK[r0] = (double[]) r2[r0].clone();
        r0 = r0 + 1;
    L9:
        this.integrator = null;
        return;
    L8:
        this.previousState = null;
        double[][] r6 = (double[][]) null;
        this.yDotK = null;
        goto L9
    }

    public void reinitialize(AbstractIntegrator r1, double[] r2, double[][] r3, boolean r4, EquationsMapper r5, EquationsMapper[] r6) {
        reinitialize(r2, r4, r5, r6);
        this.previousState = null;
        this.yDotK = r3;
        this.integrator = r1;
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator
    public void shift() {
        this.previousState = (double[]) this.currentState.clone();
        super.shift();
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void writeExternal(ObjectOutput r8) throws IOException {
        writeBaseExternal(r8);
        int r1 = -1;
        if (this.currentState != null) goto L5;
        int r0 = -1;
    L6:
        int r3 = 0;
    L7:
        if (r3 >= r0) goto L9;
        r8.writeDouble(this.previousState[r3]);
        r3 = r3 + 1;
        goto L7
    L9:
        double[][] r4 = this.yDotK;
        if (r4 == null) goto L13;
        r1 = r4.length;
    L13:
        r8.writeInt(r1);
        int r5 = 0;
    L14:
        if (r5 >= r1) goto L19;
        int r6 = 0;
    L16:
        if (r6 >= r0) goto L18;
        r8.writeDouble(this.yDotK[r5][r6]);
        r6 = r6 + 1;
        goto L16
    L18:
        r5 = r5 + 1;
        goto L14
    L19:
        return;
    L5:
        r0 = this.currentState.length;
        goto L6
    }

    @Override // org.apache.commons.math3.ode.sampling.AbstractStepInterpolator, java.io.Externalizable
    public void readExternal(ObjectInput r12) throws IOException, ClassNotFoundException {
        double r0 = readBaseExternal(r12);
        if (this.currentState != null) goto L5;
        int r2 = -1;
    L7:
        if (r2 >= 0) goto L9;
        this.previousState = null;
    L12:
        int r5 = r12.readInt();
        if (r5 >= 0) goto L15;
        double[][] r6 = (double[][]) null;
        double[][] r7 = null;
    L16:
        this.yDotK = r7;
        int r8 = 0;
    L17:
        if (r8 >= r5) goto L26;
        double[][] r9 = this.yDotK;
        if (r2 >= 0) goto L21;
        double[] r10 = null;
    L22:
        r9[r8] = r10;
        int r11 = 0;
    L23:
        if (r11 >= r2) goto L25;
        this.yDotK[r8][r11] = r12.readDouble();
        r11 = r11 + 1;
        goto L23
    L25:
        r8 = r8 + 1;
        goto L17
    L21:
        r10 = new double[r2];
        goto L22
    L26:
        this.integrator = null;
        if (this.currentState == null) goto L29;
        setInterpolatedTime(r0);
        return;
    L29:
        this.interpolatedTime = r0;
        return;
    L15:
        r7 = new double[r5][];
        goto L16
    L9:
        this.previousState = new double[r2];
        int r13 = 0;
    L10:
        if (r13 >= r2) goto L12;
        this.previousState[r13] = r12.readDouble();
        r13 = r13 + 1;
        goto L10
    L5:
        r2 = this.currentState.length;
        goto L7
    }
}
