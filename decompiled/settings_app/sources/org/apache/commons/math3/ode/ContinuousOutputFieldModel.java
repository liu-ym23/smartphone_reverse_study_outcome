package org.apache.commons.math3.ode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.ode.sampling.FieldStepHandler;
import org.apache.commons.math3.ode.sampling.FieldStepInterpolator;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class ContinuousOutputFieldModel<T extends RealFieldElement<T>> implements FieldStepHandler<T> {
    private T finalTime;
    private boolean forward;
    private int index;
    private T initialTime;
    private List<FieldStepInterpolator<T>> steps;

    public ContinuousOutputFieldModel() {
        this.steps = new ArrayList();
        this.initialTime = null;
        this.finalTime = null;
        this.forward = true;
        this.index = 0;
    }

    public void append(ContinuousOutputFieldModel<T> r9) throws MathIllegalArgumentException, MaxCountExceededException {
        if (r9.steps.size() != 0) goto L6;
        return;
    L6:
        if (this.steps.size() != 0) goto L8;
        this.initialTime = r9.initialTime;
        this.forward = r9.forward;
    L16:
        Iterator<FieldStepInterpolator<T>> r10 = r9.steps.iterator();
    L18:
        if (r10.hasNext() == false) goto L20;
        this.steps.add(r10.next());
        goto L18
    L20:
        int r11 = this.steps.size() - 1;
        this.index = r11;
        this.finalTime = this.steps.get(r11).getCurrentState().getTime();
        return;
    L8:
        FieldODEStateAndDerivative<T> r0 = this.steps.get(0).getPreviousState();
        FieldODEStateAndDerivative<T> r3 = r9.steps.get(0).getPreviousState();
        checkDimensionsEquality(r0.getStateDimension(), r3.getStateDimension());
        checkDimensionsEquality(r0.getNumberOfSecondaryStates(), r3.getNumberOfSecondaryStates());
        int r4 = 0;
    L10:
        if (r4 >= r0.getNumberOfSecondaryStates()) goto L13;
        checkDimensionsEquality(r0.getSecondaryStateDimension(r4), r3.getSecondaryStateDimension(r4));
        r4 = r4 + 1;
        goto L10
    L13:
        if ((this.forward ^ r9.forward) == true) goto L25;
        FieldStepInterpolator<T> r1 = this.steps.get(this.index);
        T r5 = r1.getCurrentState().getTime();
        RealFieldElement r2 = (RealFieldElement) r5.subtract(r1.getPreviousState().getTime());
        RealFieldElement r6 = (RealFieldElement) r9.getInitialTime().subtract(r5);
        if (((RealFieldElement) ((RealFieldElement) r6.abs()).subtract(((RealFieldElement) r2.abs()).multiply(0.001d))).getReal() <= 0.0d) goto L16;
        throw new MathIllegalArgumentException(LocalizedFormats.HOLE_BETWEEN_MODELS_TIME_RANGES, new Object[]{Double.valueOf(((RealFieldElement) r6.abs()).getReal())});
    L25:
        throw new MathIllegalArgumentException(LocalizedFormats.PROPAGATION_DIRECTION_MISMATCH, new Object[0]);
    }

    private void checkDimensionsEquality(int r1, int r2) throws DimensionMismatchException {
        if (r1 != r2) goto L5;
        return;
    L5:
        throw new DimensionMismatchException(r2, r1);
    }

    @Override // org.apache.commons.math3.ode.sampling.FieldStepHandler
    public void init(FieldODEStateAndDerivative<T> r1, T r2) {
        this.initialTime = r1.getTime();
        this.finalTime = r2;
        this.forward = true;
        this.index = 0;
        this.steps.clear();
    }

    @Override // org.apache.commons.math3.ode.sampling.FieldStepHandler
    public void handleStep(FieldStepInterpolator<T> r2, boolean r3) throws MaxCountExceededException {
        if (this.steps.size() != 0) goto L5;
        this.initialTime = r2.getPreviousState().getTime();
        this.forward = r2.isForward();
    L5:
        this.steps.add(r2);
        if (r3 == false) goto L9;
        this.finalTime = r2.getCurrentState().getTime();
        this.index = this.steps.size() - 1;
        return;
    }

    public T getInitialTime() {
        return this.initialTime;
    }

    public T getFinalTime() {
        return this.finalTime;
    }

    public FieldODEStateAndDerivative<T> getInterpolatedState(T r18) {
        int r3 = 0;
        FieldStepInterpolator<T> r2 = this.steps.get(0);
        RealFieldElement r4 = (RealFieldElement) ((RealFieldElement) r2.getPreviousState().getTime().add(r2.getCurrentState().getTime())).multiply(0.5d);
        int r7 = this.steps.size() - 1;
        FieldStepInterpolator<T> r8 = this.steps.get(r7);
        RealFieldElement r9 = (RealFieldElement) ((RealFieldElement) r8.getPreviousState().getTime().add(r8.getCurrentState().getTime())).multiply(0.5d);
        if (locatePoint(r18, r2) > 0) goto L7;
        this.index = 0;
        return r2.getInterpolatedState(r18);
    L7:
        if (locatePoint(r18, r8) < 0) goto L11;
        this.index = r7;
        return r8.getInterpolatedState(r18);
    L11:
        if ((r7 - r3) <= 5) goto L31;
        FieldStepInterpolator<T> r5 = this.steps.get(this.index);
        int r10 = locatePoint(r18, r5);
        if (r10 >= 0) goto L15;
        r7 = this.index;
        r9 = (RealFieldElement) ((RealFieldElement) r5.getPreviousState().getTime().add(r5.getCurrentState().getTime())).multiply(0.5d);
    L17:
        int r6 = (r3 + r7) / 2;
        FieldStepInterpolator<T> r11 = this.steps.get(r6);
        RealFieldElement r12 = (RealFieldElement) ((RealFieldElement) r11.getPreviousState().getTime().add(r11.getCurrentState().getTime())).multiply(0.5d);
        if (((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r12.subtract(r4)).abs()).subtract(1.0E-6d)).getReal() >= 0.0d) goto L20;
    L23:
        this.index = r6;
    L24:
        int r13 = FastMath.max(r3 + 1, ((r3 * 9) + r7) / 10);
        int r14 = FastMath.min(r7 - 1, ((r7 * 9) + r3) / 10);
        int r15 = this.index;
        if (r15 < r13) goto L26;
        if (r15 <= r14) goto L11;
        this.index = r14;
        goto L11
    L26:
        this.index = r13;
        goto L11
    L20:
        if (((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r9.subtract(r12)).abs()).subtract(1.0E-6d)).getReal() < 0.0d) goto L23;
        RealFieldElement r16 = (RealFieldElement) r9.subtract(r12);
        RealFieldElement r17 = (RealFieldElement) r12.subtract(r4);
        RealFieldElement r19 = (RealFieldElement) r9.subtract(r4);
        RealFieldElement r110 = (RealFieldElement) r18.subtract(r9);
        RealFieldElement r20 = (RealFieldElement) r18.subtract(r12);
        RealFieldElement r111 = (RealFieldElement) r18.subtract(r4);
        this.index = (int) FastMath.rint(((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) ((RealFieldElement) r20.multiply(r111)).multiply(r17)).multiply(r7)).subtract(((RealFieldElement) ((RealFieldElement) r110.multiply(r111)).multiply(r19)).multiply(r6))).add(((RealFieldElement) ((RealFieldElement) r110.multiply(r20)).multiply(r16)).multiply(r3))).divide(((RealFieldElement) r16.multiply(r17)).multiply(r19))).getReal());
        goto L24
    L15:
        if (r10 <= 0) goto L30;
        r3 = this.index;
        r4 = (RealFieldElement) ((RealFieldElement) r5.getPreviousState().getTime().add(r5.getCurrentState().getTime())).multiply(0.5d);
        goto L17
    L30:
        return r5.getInterpolatedState(r18);
    L31:
        this.index = r3;
    L32:
        int r21 = this.index;
        if (r21 > r7) goto L38;
        if (locatePoint(r18, this.steps.get(r21)) <= 0) goto L38;
        this.index++;
    L38:
        return this.steps.get(this.index).getInterpolatedState(r18);
    }

    private int locatePoint(T r8, FieldStepInterpolator<T> r9) {
        if (this.forward == false) goto L12;
        if (((RealFieldElement) r8.subtract(r9.getPreviousState().getTime())).getReal() >= 0.0d) goto L8;
        return -1;
    L8:
        if (((RealFieldElement) r8.subtract(r9.getCurrentState().getTime())).getReal() <= 0.0d) goto L10;
        return 1;
    L10:
        return 0;
    L12:
        if (((RealFieldElement) r8.subtract(r9.getPreviousState().getTime())).getReal() <= 0.0d) goto L15;
        return -1;
    L15:
        if (((RealFieldElement) r8.subtract(r9.getCurrentState().getTime())).getReal() >= 0.0d) goto L17;
        return 1;
    L17:
        return 0;
    }
}
