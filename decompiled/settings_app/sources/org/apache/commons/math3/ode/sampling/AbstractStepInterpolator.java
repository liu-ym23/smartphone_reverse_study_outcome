package org.apache.commons.math3.ode.sampling;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.ode.EquationsMapper;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractStepInterpolator implements StepInterpolator {
    protected double[] currentState;
    private boolean dirtyState;
    private boolean finalized;
    private boolean forward;
    private double globalCurrentTime;
    private double globalPreviousTime;
    protected double h;
    protected double[] interpolatedDerivatives;
    protected double[] interpolatedPrimaryDerivatives;
    protected double[] interpolatedPrimaryState;
    protected double[][] interpolatedSecondaryDerivatives;
    protected double[][] interpolatedSecondaryState;
    protected double[] interpolatedState;
    protected double interpolatedTime;
    private EquationsMapper primaryMapper;
    private EquationsMapper[] secondaryMappers;
    private double softCurrentTime;
    private double softPreviousTime;

    protected abstract void computeInterpolatedStateAndDerivatives(double r1, double r3) throws MaxCountExceededException;

    protected abstract StepInterpolator doCopy();

    protected void doFinalize() throws MaxCountExceededException {
    }

    @Override // java.io.Externalizable
    public abstract void readExternal(ObjectInput r1) throws IOException, ClassNotFoundException;

    @Override // java.io.Externalizable
    public abstract void writeExternal(ObjectOutput r1) throws IOException;

    protected AbstractStepInterpolator() {
        this.globalPreviousTime = Double.NaN;
        this.globalCurrentTime = Double.NaN;
        this.softPreviousTime = Double.NaN;
        this.softCurrentTime = Double.NaN;
        this.h = Double.NaN;
        this.interpolatedTime = Double.NaN;
        this.currentState = null;
        this.finalized = false;
        this.forward = true;
        this.dirtyState = true;
        this.primaryMapper = null;
        this.secondaryMappers = null;
        allocateInterpolatedArrays(-1);
    }

    protected AbstractStepInterpolator(double[] r3, boolean r4, EquationsMapper r5, EquationsMapper[] r6) {
        this.globalPreviousTime = Double.NaN;
        this.globalCurrentTime = Double.NaN;
        this.softPreviousTime = Double.NaN;
        this.softCurrentTime = Double.NaN;
        this.h = Double.NaN;
        this.interpolatedTime = Double.NaN;
        this.currentState = r3;
        this.finalized = false;
        this.forward = r4;
        this.dirtyState = true;
        this.primaryMapper = r5;
        if (r6 != null) goto L5;
        EquationsMapper[] r7 = null;
    L6:
        this.secondaryMappers = r7;
        allocateInterpolatedArrays(r3.length);
        return;
    L5:
        r7 = (EquationsMapper[]) r6.clone();
        goto L6
    }

    protected AbstractStepInterpolator(AbstractStepInterpolator r5) {
        this.globalPreviousTime = r5.globalPreviousTime;
        this.globalCurrentTime = r5.globalCurrentTime;
        this.softPreviousTime = r5.softPreviousTime;
        this.softCurrentTime = r5.softCurrentTime;
        this.h = r5.h;
        this.interpolatedTime = r5.interpolatedTime;
        double[] r0 = r5.currentState;
        EquationsMapper[] r1 = null;
        if (r0 != null) goto L5;
        this.currentState = null;
        this.primaryMapper = null;
        this.secondaryMappers = null;
        allocateInterpolatedArrays(-1);
    L9:
        this.finalized = r5.finalized;
        this.forward = r5.forward;
        this.dirtyState = r5.dirtyState;
        this.primaryMapper = r5.primaryMapper;
        EquationsMapper[] r6 = r5.secondaryMappers;
        if (r6 == null) goto L13;
        r1 = (EquationsMapper[]) r6.clone();
    L13:
        this.secondaryMappers = r1;
        return;
    L5:
        this.currentState = (double[]) r0.clone();
        this.interpolatedState = (double[]) r5.interpolatedState.clone();
        this.interpolatedDerivatives = (double[]) r5.interpolatedDerivatives.clone();
        this.interpolatedPrimaryState = (double[]) r5.interpolatedPrimaryState.clone();
        this.interpolatedPrimaryDerivatives = (double[]) r5.interpolatedPrimaryDerivatives.clone();
        this.interpolatedSecondaryState = new double[r5.interpolatedSecondaryState.length][];
        this.interpolatedSecondaryDerivatives = new double[r5.interpolatedSecondaryDerivatives.length][];
        int r2 = 0;
    L6:
        double[][] r3 = this.interpolatedSecondaryState;
        if (r2 >= r3.length) goto L9;
        r3[r2] = (double[]) r5.interpolatedSecondaryState[r2].clone();
        this.interpolatedSecondaryDerivatives[r2] = (double[]) r5.interpolatedSecondaryDerivatives[r2].clone();
        r2 = r2 + 1;
        goto L6
    }

    private void allocateInterpolatedArrays(int r3) {
        if (r3 >= 0) goto L5;
        this.interpolatedState = null;
        this.interpolatedDerivatives = null;
        this.interpolatedPrimaryState = null;
        this.interpolatedPrimaryDerivatives = null;
        double[][] r4 = (double[][]) null;
        this.interpolatedSecondaryState = null;
        this.interpolatedSecondaryDerivatives = null;
        return;
    L5:
        this.interpolatedState = new double[r3];
        this.interpolatedDerivatives = new double[r3];
        this.interpolatedPrimaryState = new double[this.primaryMapper.getDimension()];
        this.interpolatedPrimaryDerivatives = new double[this.primaryMapper.getDimension()];
        EquationsMapper[] r5 = this.secondaryMappers;
        if (r5 != null) goto L8;
        double[][] r6 = (double[][]) null;
        this.interpolatedSecondaryState = null;
        this.interpolatedSecondaryDerivatives = null;
        return;
    L8:
        this.interpolatedSecondaryState = new double[r5.length][];
        this.interpolatedSecondaryDerivatives = new double[r5.length][];
        int r7 = 0;
    L9:
        EquationsMapper[] r0 = this.secondaryMappers;
        if (r7 >= r0.length) goto L15;
        this.interpolatedSecondaryState[r7] = new double[r0[r7].getDimension()];
        this.interpolatedSecondaryDerivatives[r7] = new double[this.secondaryMappers[r7].getDimension()];
        r7 = r7 + 1;
        goto L9
    }

    protected void reinitialize(double[] r3, boolean r4, EquationsMapper r5, EquationsMapper[] r6) {
        this.globalPreviousTime = Double.NaN;
        this.globalCurrentTime = Double.NaN;
        this.softPreviousTime = Double.NaN;
        this.softCurrentTime = Double.NaN;
        this.h = Double.NaN;
        this.interpolatedTime = Double.NaN;
        this.currentState = r3;
        this.finalized = false;
        this.forward = r4;
        this.dirtyState = true;
        this.primaryMapper = r5;
        this.secondaryMappers = (EquationsMapper[]) r6.clone();
        allocateInterpolatedArrays(r3.length);
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public StepInterpolator copy() throws MaxCountExceededException {
        finalizeStep();
        return doCopy();
    }

    public void shift() {
        double r0 = this.globalCurrentTime;
        this.globalPreviousTime = r0;
        this.softPreviousTime = r0;
        this.softCurrentTime = r0;
    }

    public void storeTime(double r3) {
        this.globalCurrentTime = r3;
        this.softCurrentTime = r3;
        this.h = r3 - this.globalPreviousTime;
        setInterpolatedTime(r3);
        this.finalized = false;
    }

    public void setSoftPreviousTime(double r1) {
        this.softPreviousTime = r1;
    }

    public void setSoftCurrentTime(double r1) {
        this.softCurrentTime = r1;
    }

    public double getGlobalPreviousTime() {
        return this.globalPreviousTime;
    }

    public double getGlobalCurrentTime() {
        return this.globalCurrentTime;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double getPreviousTime() {
        return this.softPreviousTime;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double getCurrentTime() {
        return this.softCurrentTime;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double getInterpolatedTime() {
        return this.interpolatedTime;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public void setInterpolatedTime(double r1) {
        this.interpolatedTime = r1;
        this.dirtyState = true;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public boolean isForward() {
        return this.forward;
    }

    private void evaluateCompleteInterpolatedState() throws MaxCountExceededException {
        if (this.dirtyState == false) goto L10;
        double r0 = this.globalCurrentTime - this.interpolatedTime;
        double r2 = this.h;
        double r4 = 0.0d;
        if (r2 == 0.0d) goto L8;
        r4 = (r2 - r0) / r2;
    L8:
        computeInterpolatedStateAndDerivatives(r4, r0);
        this.dirtyState = false;
        return;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double[] getInterpolatedState() throws MaxCountExceededException {
        evaluateCompleteInterpolatedState();
        this.primaryMapper.extractEquationData(this.interpolatedState, this.interpolatedPrimaryState);
        return this.interpolatedPrimaryState;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double[] getInterpolatedDerivatives() throws MaxCountExceededException {
        evaluateCompleteInterpolatedState();
        this.primaryMapper.extractEquationData(this.interpolatedDerivatives, this.interpolatedPrimaryDerivatives);
        return this.interpolatedPrimaryDerivatives;
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double[] getInterpolatedSecondaryState(int r4) throws MaxCountExceededException {
        evaluateCompleteInterpolatedState();
        this.secondaryMappers[r4].extractEquationData(this.interpolatedState, this.interpolatedSecondaryState[r4]);
        return this.interpolatedSecondaryState[r4];
    }

    @Override // org.apache.commons.math3.ode.sampling.StepInterpolator
    public double[] getInterpolatedSecondaryDerivatives(int r4) throws MaxCountExceededException {
        evaluateCompleteInterpolatedState();
        this.secondaryMappers[r4].extractEquationData(this.interpolatedDerivatives, this.interpolatedSecondaryDerivatives[r4]);
        return this.interpolatedSecondaryDerivatives[r4];
    }

    public final void finalizeStep() throws MaxCountExceededException {
        if (this.finalized == true) goto L6;
        doFinalize();
        this.finalized = true;
        return;
    }

    protected void writeBaseExternal(ObjectOutput r6) throws IOException {
        double[] r0 = this.currentState;
        if (r0 != null) goto L5;
        r6.writeInt(-1);
    L6:
        r6.writeDouble(this.globalPreviousTime);
        r6.writeDouble(this.globalCurrentTime);
        r6.writeDouble(this.softPreviousTime);
        r6.writeDouble(this.softCurrentTime);
        r6.writeDouble(this.h);
        r6.writeBoolean(this.forward);
        r6.writeObject(this.primaryMapper);
        r6.write(this.secondaryMappers.length);
        EquationsMapper[] r1 = this.secondaryMappers;
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L10;
        r6.writeObject(r1[r4]);
        r4 = r4 + 1;
        goto L7
    L10:
        if (this.currentState == null) goto L14;
    L11:
        double[] r5 = this.currentState;
        if (r3 >= r5.length) goto L14;
        r6.writeDouble(r5[r3]);
        r3 = r3 + 1;
    L14:
        r6.writeDouble(this.interpolatedTime);
        finalizeStep();     // Catch: MaxCountExceededException -> L17
        return;
    L17:
        e = move-exception;
        IOException r7 = new IOException(e.getLocalizedMessage());
        r7.initCause(e);
        throw r7;
    L5:
        r6.writeInt(r0.length);
        goto L6
    }

    protected double readBaseExternal(ObjectInput r7) throws IOException, ClassNotFoundException {
        int r0 = r7.readInt();
        this.globalPreviousTime = r7.readDouble();
        this.globalCurrentTime = r7.readDouble();
        this.softPreviousTime = r7.readDouble();
        this.softCurrentTime = r7.readDouble();
        this.h = r7.readDouble();
        this.forward = r7.readBoolean();
        this.primaryMapper = (EquationsMapper) r7.readObject();
        this.secondaryMappers = new EquationsMapper[r7.read()];
        int r1 = 0;
        int r2 = 0;
    L3:
        EquationsMapper[] r3 = this.secondaryMappers;
        if (r2 >= r3.length) goto L6;
        r3[r2] = (EquationsMapper) r7.readObject();
        r2 = r2 + 1;
        goto L3
    L6:
        this.dirtyState = true;
        if (r0 >= 0) goto L9;
        this.currentState = null;
    L13:
        this.interpolatedTime = Double.NaN;
        allocateInterpolatedArrays(r0);
        this.finalized = true;
        return r7.readDouble();
    L9:
        this.currentState = new double[r0];
    L10:
        double[] r4 = this.currentState;
        if (r1 >= r4.length) goto L13;
        r4[r1] = r7.readDouble();
        r1 = r1 + 1;
        goto L10
    }
}
