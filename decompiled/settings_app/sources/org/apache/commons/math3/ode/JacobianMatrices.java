package org.apache.commons.math3.ode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class JacobianMatrices {
    private boolean dirtyParameter;
    private ExpandableStatefulODE efode;
    private int index;
    private List<ParameterJacobianProvider> jacobianProviders;
    private MainStateJacobianProvider jode;
    private double[] matricesData;
    private int paramDim;
    private ParameterizedODE pode;
    private ParameterConfiguration[] selectedParameters;
    private int stateDim;

    /* JADX INFO: renamed from: org.apache.commons.math3.ode.JacobianMatrices$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class JacobiansSecondaryEquations implements SecondaryEquations {
        final /* synthetic */ JacobianMatrices this$0;

        private JacobiansSecondaryEquations(JacobianMatrices r1) {
            this.this$0 = r1;
        }

        /* synthetic */ JacobiansSecondaryEquations(JacobianMatrices r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.apache.commons.math3.ode.SecondaryEquations
        public int getDimension() {
            return JacobianMatrices.access$200(this.this$0) * (JacobianMatrices.access$200(this.this$0) + JacobianMatrices.access$300(this.this$0));
        }

        @Override // org.apache.commons.math3.ode.SecondaryEquations
        public void computeDerivatives(double r26, double[] r28, double[] r29, double[] r30, double[] r31) throws MaxCountExceededException, DimensionMismatchException {
            if (JacobianMatrices.access$400(this.this$0) == true) goto L5;
        L7:
            double[][] r2 = (double[][]) Array.newInstance(Double.TYPE, new int[]{JacobianMatrices.access$200(this.this$0), JacobianMatrices.access$200(this.this$0)});
            JacobianMatrices.access$500(this.this$0).computeMainStateJacobian(r26, r28, r29, r2);
            int r4 = 0;
        L9:
            if (r4 >= JacobianMatrices.access$200(this.this$0)) goto L20;
            double[] r5 = r2[r4];
            int r9 = 0;
        L12:
            if (r9 >= JacobianMatrices.access$200(this.this$0)) goto L18;
            int r10 = 0;
            double r11 = 0.0d;
            int r13 = r9;
        L15:
            if (r10 >= JacobianMatrices.access$200(this.this$0)) goto L17;
            r11 = r11 + (r5[r10] * r30[r13]);
            r13 = r13 + JacobianMatrices.access$200(this.this$0);
            r10 = r10 + 1;
            goto L15
        L17:
            r31[(JacobianMatrices.access$200(this.this$0) * r4) + r9] = r11;
            r9 = r9 + 1;
            goto L12
        L18:
            r4 = r4 + 1;
            goto L9
        L20:
            if (JacobianMatrices.access$300(this.this$0) == 0) goto L44;
            double[] r6 = new double[JacobianMatrices.access$200(this.this$0)];
            int r7 = JacobianMatrices.access$200(this.this$0) * JacobianMatrices.access$200(this.this$0);
            ParameterConfiguration[] r15 = JacobianMatrices.access$700(this.this$0);
            int r14 = r15.length;
            int r16 = 0;
        L22:
            if (r16 >= r14) goto L57;
            ParameterConfiguration r17 = r15[r16];
            boolean r12 = false;
            int r18 = 0;
        L24:
            if (r12 == true) goto L40;
            if (r18 >= JacobianMatrices.access$800(this.this$0).size()) goto L40;
            ParameterJacobianProvider r19 = (ParameterJacobianProvider) JacobianMatrices.access$800(this.this$0).get(r18);
            if (r19.isSupported(r17.getParameterName()) == false) goto L39;
            r19.computeParameterJacobian(r26, r28, r29, r17.getParameterName(), r6);
            int r20 = 0;
        L31:
            if (r20 >= JacobianMatrices.access$200(this.this$0)) goto L37;
            double[] r110 = r2[r20];
            double r111 = r6[r20];
            int r112 = 0;
            int r113 = r7;
        L34:
            if (r112 >= JacobianMatrices.access$200(this.this$0)) goto L36;
            r111 = r111 + (r110[r112] * r30[r113]);
            r113 = r113 + 1;
            r112 = r112 + 1;
            goto L34
        L36:
            r31[r7 + r20] = r111;
            r20 = r20 + 1;
            goto L31
        L37:
            r12 = true;
        L39:
            r18 = r18 + 1;
            r15 = r15;
            r16 = r16;
            r14 = r14;
        L40:
            int r114 = r16;
            int r21 = r14;
            ParameterConfiguration[] r115 = r15;
            if (r12 == true) goto L43;
            Arrays.fill(r31, r7, JacobianMatrices.access$200(this.this$0) + r7, 0.0d);
        L43:
            r7 = r7 + JacobianMatrices.access$200(this.this$0);
            r16 = r114 + 1;
            r15 = r115;
            r14 = r21;
            goto L22
        L57:
            return;
        L44:
            return;
        L5:
            if (JacobianMatrices.access$300(this.this$0) == 0) goto L7;
            JacobianMatrices.access$800(this.this$0).add(new ParameterJacobianWrapper(JacobianMatrices.access$500(this.this$0), JacobianMatrices.access$600(this.this$0), JacobianMatrices.access$700(this.this$0)));
            JacobianMatrices.access$402(this.this$0, false);
            goto L7
        }
    }

    private static class MainStateJacobianWrapper implements MainStateJacobianProvider {
        private final double[] hY;
        private final FirstOrderDifferentialEquations ode;

        static /* synthetic */ FirstOrderDifferentialEquations access$000(MainStateJacobianWrapper r0) {
            return r0.ode;
        }

        MainStateJacobianWrapper(FirstOrderDifferentialEquations r2, double[] r3) throws DimensionMismatchException {
            this.ode = r2;
            this.hY = (double[]) r3.clone();
            if (r3.length != r2.getDimension()) goto L6;
            return;
        L6:
            throw new DimensionMismatchException(r2.getDimension(), r3.length);
        }

        @Override // org.apache.commons.math3.ode.FirstOrderDifferentialEquations
        public int getDimension() {
            return this.ode.getDimension();
        }

        @Override // org.apache.commons.math3.ode.FirstOrderDifferentialEquations
        public void computeDerivatives(double r1, double[] r3, double[] r4) throws MaxCountExceededException, DimensionMismatchException {
            this.ode.computeDerivatives(r1, r3, r4);
        }

        @Override // org.apache.commons.math3.ode.MainStateJacobianProvider
        public void computeMainStateJacobian(double r17, double[] r19, double[] r20, double[][] r21) throws MaxCountExceededException, DimensionMismatchException {
            int r2 = this.ode.getDimension();
            double[] r3 = new double[r2];
            int r5 = 0;
        L3:
            if (r5 >= r2) goto L8;
            double r6 = r19[r5];
            r19[r5] = this.hY[r5] + r6;
            this.ode.computeDerivatives(r17, r19, r3);
            int r8 = 0;
        L5:
            if (r8 >= r2) goto L7;
            r21[r8][r5] = (r3[r8] - r20[r8]) / this.hY[r5];
            r8 = r8 + 1;
            goto L5
        L7:
            r19[r5] = r6;
            r5 = r5 + 1;
            goto L3
        }
    }

    public static class MismatchedEquations extends MathIllegalArgumentException {
        private static final long serialVersionUID = 20120902;

        public MismatchedEquations() {
            super(LocalizedFormats.UNMATCHED_ODE_IN_EXPANDED_SET, new Object[0]);
        }
    }

    static /* synthetic */ int access$200(JacobianMatrices r0) {
        return r0.stateDim;
    }

    static /* synthetic */ int access$300(JacobianMatrices r0) {
        return r0.paramDim;
    }

    static /* synthetic */ boolean access$400(JacobianMatrices r0) {
        return r0.dirtyParameter;
    }

    static /* synthetic */ boolean access$402(JacobianMatrices r0, boolean r1) {
        r0.dirtyParameter = r1;
        return r1;
    }

    static /* synthetic */ MainStateJacobianProvider access$500(JacobianMatrices r0) {
        return r0.jode;
    }

    static /* synthetic */ ParameterizedODE access$600(JacobianMatrices r0) {
        return r0.pode;
    }

    static /* synthetic */ ParameterConfiguration[] access$700(JacobianMatrices r0) {
        return r0.selectedParameters;
    }

    static /* synthetic */ List access$800(JacobianMatrices r0) {
        return r0.jacobianProviders;
    }

    public JacobianMatrices(FirstOrderDifferentialEquations r2, double[] r3, String... r4) throws DimensionMismatchException {
        this(new MainStateJacobianWrapper(r2, r3), r4);
    }

    public JacobianMatrices(MainStateJacobianProvider r7, String... r8) {
        this.efode = null;
        this.index = -1;
        this.jode = r7;
        this.pode = null;
        this.stateDim = r7.getDimension();
        int r9 = 0;
        if (r8 != null) goto L5;
        this.selectedParameters = null;
        this.paramDim = 0;
    L10:
        this.dirtyParameter = false;
        this.jacobianProviders = new ArrayList();
        int r10 = this.stateDim;
        this.matricesData = new double[(this.paramDim + r10) * r10];
    L11:
        int r11 = this.stateDim;
        if (r9 >= r11) goto L14;
        this.matricesData[(r11 + 1) * r9] = 1.0d;
        r9 = r9 + 1;
        goto L11
    L14:
        return;
    L5:
        this.selectedParameters = new ParameterConfiguration[r8.length];
        int r0 = 0;
    L7:
        if (r0 >= r8.length) goto L9;
        this.selectedParameters[r0] = new ParameterConfiguration(r8[r0], Double.NaN);
        r0 = r0 + 1;
        goto L7
    L9:
        this.paramDim = r8.length;
        goto L10
    }

    public void registerVariationalEquations(ExpandableStatefulODE r3) throws DimensionMismatchException, MismatchedEquations {
        FirstOrderDifferentialEquations r0 = this.jode;
        if ((r0 instanceof MainStateJacobianWrapper) == false) goto L6;
        r0 = MainStateJacobianWrapper.access$000((MainStateJacobianWrapper) r0);
    L6:
        if (r3.getPrimary() != r0) goto L10;
        this.efode = r3;
        int r4 = r3.addSecondaryEquations(new JacobiansSecondaryEquations(this, null));
        this.index = r4;
        this.efode.setSecondaryState(r4, this.matricesData);
        return;
    L10:
        throw new MismatchedEquations();
    }

    public void addParameterJacobianProvider(ParameterJacobianProvider r1) {
        this.jacobianProviders.add(r1);
    }

    public void setParameterizedODE(ParameterizedODE r1) {
        this.pode = r1;
        this.dirtyParameter = true;
    }

    public void setParameterStep(String r6, double r7) throws UnknownParameterException {
        ParameterConfiguration[] r0 = this.selectedParameters;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        ParameterConfiguration r3 = r0[r2];
        if (r6.equals(r3.getParameterName()) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        r3.setHP(r7);
        this.dirtyParameter = true;
        return;
    L10:
        throw new UnknownParameterException(r6);
    }

    public void setInitialMainStateJacobian(double[][] r8) throws DimensionMismatchException {
        checkDimension(this.stateDim, r8);
        checkDimension(this.stateDim, r8[0]);
        int r0 = r8.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        System.arraycopy(r8[r2], 0, this.matricesData, r3, this.stateDim);
        r3 = r3 + this.stateDim;
        r2 = r2 + 1;
        goto L3
    L5:
        ExpandableStatefulODE r9 = this.efode;
        if (r9 == null) goto L10;
        r9.setSecondaryState(this.index, this.matricesData);
        return;
    }

    public void setInitialParameterJacobian(String r7, double[] r8) throws UnknownParameterException, DimensionMismatchException {
        checkDimension(this.stateDim, r8);
        int r0 = this.stateDim;
        int r1 = r0 * r0;
        ParameterConfiguration[] r2 = this.selectedParameters;
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L12;
        if (r7.equals(r2[r4].getParameterName()) == true) goto L6;
        r1 = r1 + this.stateDim;
        r4 = r4 + 1;
        goto L3
    L6:
        System.arraycopy(r8, 0, this.matricesData, r1, this.stateDim);
        ExpandableStatefulODE r9 = this.efode;
        if (r9 == null) goto L15;
        r9.setSecondaryState(this.index, this.matricesData);
        return;
    L15:
        return;
    L12:
        throw new UnknownParameterException(r7);
    }

    public void getCurrentMainSetJacobian(double[][] r7) {
        double[] r0 = this.efode.getSecondaryState(this.index);
        int r2 = 0;
        int r3 = 0;
    L3:
        int r4 = this.stateDim;
        if (r2 >= r4) goto L6;
        System.arraycopy(r0, r3, r7[r2], 0, r4);
        r3 = r3 + this.stateDim;
        r2 = r2 + 1;
        goto L3
    }

    public void getCurrentParameterJacobian(String r8, double[] r9) {
        double[] r0 = this.efode.getSecondaryState(this.index);
        int r1 = this.stateDim;
        int r2 = r1 * r1;
        ParameterConfiguration[] r3 = this.selectedParameters;
        int r4 = r3.length;
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L9;
        if (r3[r5].getParameterName().equals(r8) == true) goto L6;
        r2 = r2 + this.stateDim;
        r5 = r5 + 1;
        goto L3
    L6:
        System.arraycopy(r0, r2, r9, 0, this.stateDim);
        return;
    }

    private void checkDimension(int r1, Object r2) throws DimensionMismatchException {
        if (r2 != null) goto L4;
        int r0 = 0;
    L5:
        if (r0 != r1) goto L8;
        return;
    L8:
        throw new DimensionMismatchException(r0, r1);
    L4:
        r0 = Array.getLength(r2);
        goto L5
    }
}
