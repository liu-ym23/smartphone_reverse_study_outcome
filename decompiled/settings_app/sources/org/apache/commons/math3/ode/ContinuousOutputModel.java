package org.apache.commons.math3.ode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class ContinuousOutputModel implements StepHandler, Serializable {
    private static final long serialVersionUID = -1417964919405031606L;
    private double finalTime;
    private boolean forward;
    private int index;
    private double initialTime;
    private List<StepInterpolator> steps;

    public ContinuousOutputModel() {
        this.steps = new ArrayList();
        this.initialTime = Double.NaN;
        this.finalTime = Double.NaN;
        this.forward = true;
        this.index = 0;
    }

    public void append(ContinuousOutputModel r12) throws MathIllegalArgumentException, MaxCountExceededException {
        if (r12.steps.size() != 0) goto L6;
        return;
    L6:
        if (this.steps.size() != 0) goto L9;
        this.initialTime = r12.initialTime;
        this.forward = r12.forward;
    L14:
        Iterator<StepInterpolator> r13 = r12.steps.iterator();
    L16:
        if (r13.hasNext() == false) goto L18;
        this.steps.add(r13.next().copy());
        goto L16
    L18:
        int r14 = this.steps.size() - 1;
        this.index = r14;
        this.finalTime = this.steps.get(r14).getCurrentTime();
        return;
    L9:
        if (getInterpolatedState().length != r12.getInterpolatedState().length) goto L25;
        if ((this.forward ^ r12.forward) == true) goto L23;
        StepInterpolator r0 = this.steps.get(this.index);
        double r3 = r0.getCurrentTime();
        double r5 = r3 - r0.getPreviousTime();
        double r7 = r12.getInitialTime() - r3;
        if (FastMath.abs(r7) <= (FastMath.abs(r5) * 0.001d)) goto L14;
        throw new MathIllegalArgumentException(LocalizedFormats.HOLE_BETWEEN_MODELS_TIME_RANGES, new Object[]{Double.valueOf(FastMath.abs(r7))});
    L23:
        throw new MathIllegalArgumentException(LocalizedFormats.PROPAGATION_DIRECTION_MISMATCH, new Object[0]);
    L25:
        throw new DimensionMismatchException(r12.getInterpolatedState().length, getInterpolatedState().length);
    }

    @Override // org.apache.commons.math3.ode.sampling.StepHandler
    public void init(double r1, double[] r3, double r4) {
        this.initialTime = Double.NaN;
        this.finalTime = Double.NaN;
        this.forward = true;
        this.index = 0;
        this.steps.clear();
    }

    @Override // org.apache.commons.math3.ode.sampling.StepHandler
    public void handleStep(StepInterpolator r3, boolean r4) throws MaxCountExceededException {
        if (this.steps.size() != 0) goto L5;
        this.initialTime = r3.getPreviousTime();
        this.forward = r3.isForward();
    L5:
        this.steps.add(r3.copy());
        if (r4 == false) goto L9;
        this.finalTime = r3.getCurrentTime();
        this.index = this.steps.size() - 1;
        return;
    }

    public double getInitialTime() {
        return this.initialTime;
    }

    public double getFinalTime() {
        return this.finalTime;
    }

    public double getInterpolatedTime() {
        return this.steps.get(this.index).getInterpolatedTime();
    }

    public void setInterpolatedTime(double r28) {
        int r4 = 0;
        StepInterpolator r3 = this.steps.get(0);
        double r7 = 0.5d;
        double r5 = (r3.getPreviousTime() + r3.getCurrentTime()) * 0.5d;
        int r9 = this.steps.size() - 1;
        StepInterpolator r10 = this.steps.get(r9);
        double r11 = (r10.getPreviousTime() + r10.getCurrentTime()) * 0.5d;
        if (locatePoint(r28, r3) > 0) goto L7;
        this.index = 0;
        r3.setInterpolatedTime(r28);
        return;
    L7:
        if (locatePoint(r28, r10) < 0) goto L11;
        this.index = r9;
        r10.setInterpolatedTime(r28);
        return;
    L11:
        if ((r9 - r4) <= 5) goto L32;
        StepInterpolator r6 = this.steps.get(this.index);
        int r12 = locatePoint(r28, r6);
        if (r12 >= 0) goto L15;
        r9 = this.index;
        r11 = (r6.getPreviousTime() + r6.getCurrentTime()) * r7;
    L17:
        int r8 = (r4 + r9) / 2;
        StepInterpolator r13 = this.steps.get(r8);
        double r14 = (r13.getPreviousTime() + r13.getCurrentTime()) * r7;
        double r15 = r14 - r5;
        if (FastMath.abs(r15) < 1.0E-6d) goto L23;
        double r17 = r11 - r14;
        if (FastMath.abs(r17) < 1.0E-6d) goto L23;
        double r19 = r11 - r5;
        double r21 = r28 - r11;
        double r16 = r28 - r14;
        double r23 = r28 - r5;
        this.index = (int) FastMath.rint((((((r16 * r23) * r15) * ((double) r9)) - (((r23 * r21) * r19) * ((double) r8))) + (((r21 * r16) * r17) * ((double) r4))) / ((r17 * r15) * r19));
    L24:
        int r18 = FastMath.max(r4 + 1, ((r4 * 9) + r9) / 10);
        int r20 = FastMath.min(r9 - 1, ((r9 * 9) + r4) / 10);
        int r22 = this.index;
        if (r22 >= r18) goto L27;
        this.index = r18;
    L29:
        r7 = 0.5d;
        goto L11
    L27:
        if (r22 <= r20) goto L29;
        this.index = r20;
    L23:
        this.index = r8;
        goto L24
    L15:
        if (r12 <= 0) goto L30;
        r4 = this.index;
        r5 = (r6.getPreviousTime() + r6.getCurrentTime()) * r7;
        goto L17
    L30:
        r6.setInterpolatedTime(r28);
        return;
    L32:
        this.index = r4;
    L33:
        int r24 = this.index;
        if (r24 > r9) goto L38;
        if (locatePoint(r28, this.steps.get(r24)) <= 0) goto L38;
        this.index++;
    L38:
        this.steps.get(this.index).setInterpolatedTime(r28);
    }

    public double[] getInterpolatedState() throws MaxCountExceededException {
        return this.steps.get(this.index).getInterpolatedState();
    }

    public double[] getInterpolatedDerivatives() throws MaxCountExceededException {
        return this.steps.get(this.index).getInterpolatedDerivatives();
    }

    public double[] getInterpolatedSecondaryState(int r2) throws MaxCountExceededException {
        return this.steps.get(this.index).getInterpolatedSecondaryState(r2);
    }

    public double[] getInterpolatedSecondaryDerivatives(int r2) throws MaxCountExceededException {
        return this.steps.get(this.index).getInterpolatedSecondaryDerivatives(r2);
    }

    private int locatePoint(double r6, StepInterpolator r8) {
        if (this.forward == false) goto L12;
        if (r6 >= r8.getPreviousTime()) goto L8;
        return -1;
    L8:
        if (r6 <= r8.getCurrentTime()) goto L10;
        return 1;
    L10:
        return 0;
    L12:
        if (r6 <= r8.getPreviousTime()) goto L15;
        return -1;
    L15:
        if (r6 >= r8.getCurrentTime()) goto L17;
        return 1;
    L17:
        return 0;
    }
}
