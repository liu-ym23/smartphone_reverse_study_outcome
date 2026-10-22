package org.apache.commons.math3.ode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;

/* JADX INFO: loaded from: classes6.dex */
public class ExpandableStatefulODE {
    private List<SecondaryComponent> components;
    private final FirstOrderDifferentialEquations primary;
    private final EquationsMapper primaryMapper;
    private final double[] primaryState;
    private final double[] primaryStateDot;
    private double time;

    private static class SecondaryComponent {
        private final SecondaryEquations equation;
        private final EquationsMapper mapper;
        private final double[] state;
        private final double[] stateDot;

        static /* synthetic */ EquationsMapper access$000(SecondaryComponent r0) {
            return r0.mapper;
        }

        static /* synthetic */ double[] access$100(SecondaryComponent r0) {
            return r0.state;
        }

        static /* synthetic */ double[] access$200(SecondaryComponent r0) {
            return r0.stateDot;
        }

        static /* synthetic */ SecondaryEquations access$300(SecondaryComponent r0) {
            return r0.equation;
        }

        SecondaryComponent(SecondaryEquations r2, int r3) {
            int r0 = r2.getDimension();
            this.equation = r2;
            this.mapper = new EquationsMapper(r3, r0);
            this.state = new double[r0];
            this.stateDot = new double[r0];
        }
    }

    public ExpandableStatefulODE(FirstOrderDifferentialEquations r4) {
        int r0 = r4.getDimension();
        this.primary = r4;
        this.primaryMapper = new EquationsMapper(0, r0);
        this.time = Double.NaN;
        this.primaryState = new double[r0];
        this.primaryStateDot = new double[r0];
        this.components = new ArrayList();
    }

    public FirstOrderDifferentialEquations getPrimary() {
        return this.primary;
    }

    public int getTotalDimension() {
        if (this.components.isEmpty() == true) goto L5;
        List<SecondaryComponent> r1 = this.components;
        EquationsMapper r2 = SecondaryComponent.access$000(r1.get(r1.size() - 1));
        return r2.getFirstIndex() + r2.getDimension();
    L5:
        return this.primaryMapper.getDimension();
    }

    public void computeDerivatives(double r12, double[] r14, double[] r15) throws MaxCountExceededException, DimensionMismatchException {
        this.primaryMapper.extractEquationData(r14, this.primaryState);
        this.primary.computeDerivatives(r12, this.primaryState, this.primaryStateDot);
        Iterator<SecondaryComponent> r0 = this.components.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        SecondaryComponent r1 = r0.next();
        SecondaryComponent.access$000(r1).extractEquationData(r14, SecondaryComponent.access$100(r1));
        SecondaryComponent.access$300(r1).computeDerivatives(r12, this.primaryState, this.primaryStateDot, SecondaryComponent.access$100(r1), SecondaryComponent.access$200(r1));
        SecondaryComponent.access$000(r1).insertEquationData(SecondaryComponent.access$200(r1), r15);
        goto L4
    L6:
        this.primaryMapper.insertEquationData(this.primaryStateDot, r15);
    }

    public int addSecondaryEquations(SecondaryEquations r4) {
        if (this.components.isEmpty() == false) goto L5;
        this.components = new ArrayList();
        int r0 = this.primary.getDimension();
    L6:
        this.components.add(new SecondaryComponent(r4, r0));
        return this.components.size() - 1;
    L5:
        List<SecondaryComponent> r1 = this.components;
        SecondaryComponent r2 = r1.get(r1.size() - 1);
        r0 = SecondaryComponent.access$000(r2).getDimension() + SecondaryComponent.access$000(r2).getFirstIndex();
        goto L6
    }

    public EquationsMapper getPrimaryMapper() {
        return this.primaryMapper;
    }

    public EquationsMapper[] getSecondaryMappers() {
        int r0 = this.components.size();
        EquationsMapper[] r1 = new EquationsMapper[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = SecondaryComponent.access$000(this.components.get(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public void setTime(double r1) {
        this.time = r1;
    }

    public double getTime() {
        return this.time;
    }

    public void setPrimaryState(double[] r4) throws DimensionMismatchException {
        int r0 = r4.length;
        double[] r1 = this.primaryState;
        if (r0 != r1.length) goto L7;
        System.arraycopy(r4, 0, r1, 0, r4.length);
        return;
    L7:
        throw new DimensionMismatchException(r4.length, this.primaryState.length);
    }

    public double[] getPrimaryState() {
        return (double[]) this.primaryState.clone();
    }

    public double[] getPrimaryStateDot() {
        return (double[]) this.primaryStateDot.clone();
    }

    public void setSecondaryState(int r2, double[] r3) throws DimensionMismatchException {
        double[] r1 = SecondaryComponent.access$100(this.components.get(r2));
        if (r3.length != r1.length) goto L7;
        System.arraycopy(r3, 0, r1, 0, r3.length);
        return;
    L7:
        throw new DimensionMismatchException(r3.length, r1.length);
    }

    public double[] getSecondaryState(int r1) {
        return (double[]) SecondaryComponent.access$100(this.components.get(r1)).clone();
    }

    public double[] getSecondaryStateDot(int r1) {
        return (double[]) SecondaryComponent.access$200(this.components.get(r1)).clone();
    }

    public void setCompleteState(double[] r3) throws DimensionMismatchException {
        if (r3.length != getTotalDimension()) goto L10;
        this.primaryMapper.extractEquationData(r3, this.primaryState);
        Iterator<SecondaryComponent> r2 = this.components.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        SecondaryComponent r0 = r2.next();
        SecondaryComponent.access$000(r0).extractEquationData(r3, SecondaryComponent.access$100(r0));
        goto L6
    L8:
        return;
    L10:
        throw new DimensionMismatchException(r3.length, getTotalDimension());
    }

    public double[] getCompleteState() throws DimensionMismatchException {
        double[] r0 = new double[getTotalDimension()];
        this.primaryMapper.insertEquationData(this.primaryState, r0);
        Iterator<SecondaryComponent> r3 = this.components.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        SecondaryComponent r1 = r3.next();
        SecondaryComponent.access$000(r1).insertEquationData(SecondaryComponent.access$100(r1), r0);
        goto L4
    L6:
        return r0;
    }
}
