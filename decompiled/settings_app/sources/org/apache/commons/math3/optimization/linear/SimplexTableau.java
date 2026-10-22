package org.apache.commons.math3.optimization.linear;

import android.icu.text.DateFormat;
import androidx.exifinterface.media.ExifInterface;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optimization.GoalType;
import org.apache.commons.math3.optimization.PointValuePair;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
class SimplexTableau implements Serializable {
    private static final double CUTOFF_THRESHOLD = 1.0E-12d;
    private static final int DEFAULT_ULPS = 10;
    private static final String NEGATIVE_VAR_COLUMN_LABEL = "x-";
    private static final long serialVersionUID = -1369660067587938365L;
    private final List<String> columnLabels;
    private final List<LinearConstraint> constraints;
    private final double epsilon;
    private final LinearObjectiveFunction f;
    private final int maxUlps;
    private int numArtificialVariables;
    private final int numDecisionVariables;
    private final int numSlackVariables;
    private final boolean restrictToNonNegative;
    private transient RealMatrix tableau;

    SimplexTableau(LinearObjectiveFunction r9, Collection<LinearConstraint> r10, GoalType r11, boolean r12, double r13) {
        this(r9, r10, r11, r12, r13, 10);
    }

    SimplexTableau(LinearObjectiveFunction r2, Collection<LinearConstraint> r3, GoalType r4, boolean r5, double r6, int r8) {
        this.columnLabels = new ArrayList();
        this.f = r2;
        this.constraints = normalizeConstraints(r3);
        this.restrictToNonNegative = r5;
        this.epsilon = r6;
        this.maxUlps = r8;
        boolean r7 = true;
        this.numDecisionVariables = r2.getCoefficients().getDimension() + (!r5 ? 1 : 0);
        this.numSlackVariables = getConstraintTypeCounts(Relationship.LEQ) + getConstraintTypeCounts(Relationship.GEQ);
        this.numArtificialVariables = getConstraintTypeCounts(Relationship.EQ) + getConstraintTypeCounts(Relationship.GEQ);
        if (r4 == GoalType.MAXIMIZE) goto L6;
        r7 = false;
    L6:
        this.tableau = createTableau(r7);
        initializeColumnLabels();
    }

    protected void initializeColumnLabels() {
        if (getNumObjectiveFunctions() != 2) goto L5;
        this.columnLabels.add(ExifInterface.LONGITUDE_WEST);
    L5:
        this.columnLabels.add("Z");
        int r0 = 0;
        int r1 = 0;
    L7:
        if (r1 >= getOriginalNumDecisionVariables()) goto L10;
        this.columnLabels.add(MaterialConfigFormatNames.X + r1);
        r1 = r1 + 1;
        goto L7
    L10:
        if (this.restrictToNonNegative == true) goto L12;
        this.columnLabels.add(NEGATIVE_VAR_COLUMN_LABEL);
    L12:
        int r2 = 0;
    L14:
        if (r2 >= getNumSlackVariables()) goto L17;
        this.columnLabels.add(DateFormat.SECOND + r2);
        r2 = r2 + 1;
    L17:
        if (r0 >= getNumArtificialVariables()) goto L19;
        this.columnLabels.add("a" + r0);
        r0 = r0 + 1;
        goto L17
    L19:
        this.columnLabels.add("RHS");
    }

    protected RealMatrix createTableau(boolean r17) {
        int r2 = 1;
        int r1 = (((this.numDecisionVariables + this.numSlackVariables) + this.numArtificialVariables) + getNumObjectiveFunctions()) + 1;
        Array2DRowRealMatrix r4 = new Array2DRowRealMatrix(this.constraints.size() + getNumObjectiveFunctions(), r1);
        if (getNumObjectiveFunctions() != 2) goto L6;
        r4.setEntry(0, 0, -1.0d);
    L6:
        if (getNumObjectiveFunctions() != 1) goto L8;
        int r3 = 0;
    L10:
        if (r17 == false) goto L12;
        double r11 = 1.0d;
    L13:
        r4.setEntry(r3, r3, r11);
        RealVector r5 = this.f.getCoefficients();
        if (r17 == false) goto L16;
        r5 = r5.mapMultiply(-1.0d);
    L16:
        copyArray(r5.toArray(), r4.getDataRef()[r3]);
        int r6 = r1 - 1;
        double r12 = this.f.getConstantTerm();
        if (r17 == true) goto L20;
        r12 = r12 * (-1.0d);
    L20:
        r4.setEntry(r3, r6, r12);
        if (this.restrictToNonNegative == true) goto L23;
        r4.setEntry(r3, getSlackVariableOffset() - 1, getInvertedCoefficientSum(r5));
    L23:
        int r7 = 0;
        int r8 = 0;
        int r13 = 0;
    L25:
        if (r7 >= this.constraints.size()) goto L43;
        LinearConstraint r14 = this.constraints.get(r7);
        int r15 = getNumObjectiveFunctions() + r7;
        copyArray(r14.getCoefficients().toArray(), r4.getDataRef()[r15]);
        if (this.restrictToNonNegative == true) goto L30;
        r4.setEntry(r15, getSlackVariableOffset() - r2, getInvertedCoefficientSum(r14.getCoefficients()));
    L30:
        r4.setEntry(r15, r6, r14.getValue());
        if (r14.getRelationship() != Relationship.LEQ) goto L35;
        int r9 = r8 + 1;
        r4.setEntry(r15, getSlackVariableOffset() + r8, 1.0d);
    L33:
        r8 = r9;
    L38:
        if (r14.getRelationship() != Relationship.EQ) goto L40;
    L41:
        r4.setEntry(0, getArtificialVariableOffset() + r13, 1.0d);
        r4.setEntry(r15, getArtificialVariableOffset() + r13, 1.0d);
        r4.setRowVector(0, r4.getRowVector(0).subtract(r4.getRowVector(r15)));
        r13 = r13 + 1;
    L42:
        r7 = r7 + 1;
        r2 = 1;
        goto L25
    L40:
        if (r14.getRelationship() != Relationship.GEQ) goto L42;
    L35:
        if (r14.getRelationship() != Relationship.GEQ) goto L38;
        r9 = r8 + 1;
        r4.setEntry(r15, getSlackVariableOffset() + r8, -1.0d);
        goto L33
    L43:
        return r4;
    L12:
        r11 = -1.0d;
        goto L13
    L8:
        r3 = 1;
        goto L10
    }

    public List<LinearConstraint> normalizeConstraints(Collection<LinearConstraint> r3) {
        ArrayList r0 = new ArrayList(r3.size());
        Iterator<LinearConstraint> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(normalize(r4.next()));
        goto L4
    L6:
        return r0;
    }

    private LinearConstraint normalize(LinearConstraint r7) {
        if (r7.getValue() >= 0.0d) goto L7;
        return new LinearConstraint(r7.getCoefficients().mapMultiply(-1.0d), r7.getRelationship().oppositeRelationship(), r7.getValue() * (-1.0d));
    L7:
        return new LinearConstraint(r7.getCoefficients(), r7.getRelationship(), r7.getValue());
    }

    protected final int getNumObjectiveFunctions() {
        if (this.numArtificialVariables <= 0) goto L5;
        return 2;
    L5:
        return 1;
    }

    private int getConstraintTypeCounts(Relationship r3) {
        Iterator<LinearConstraint> r2 = this.constraints.iterator();
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L8;
        if (r2.next().getRelationship() != r3) goto L4;
        r0 = r0 + 1;
        goto L4
    L8:
        return r0;
    }

    protected static double getInvertedCoefficientSum(RealVector r6) {
        double[] r7 = r6.toArray();
        int r0 = r7.length;
        double r1 = 0.0d;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1 = r1 - r7[r3];
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    protected Integer getBasicRow(int r9) {
        int r1 = 0;
        Integer r2 = null;
    L4:
        if (r1 >= getHeight()) goto L13;
        double r3 = getEntry(r1, r9);
        if (Precision.equals(r3, 1.0d, this.maxUlps) == false) goto L10;
        if (r2 != null) goto L10;
        r2 = Integer.valueOf(r1);
    L12:
        r1 = r1 + 1;
    L10:
        if (Precision.equals(r3, 0.0d, this.maxUlps) == true) goto L12;
        return null;
    L13:
        return r2;
    }

    protected void dropPhase1Objective() {
        if (getNumObjectiveFunctions() != 1) goto L5;
        return;
    L5:
        TreeSet r0 = new TreeSet();
        r0.add(0);
        int r3 = getNumObjectiveFunctions();
    L7:
        if (r3 >= getArtificialVariableOffset()) goto L12;
        if (Precision.compareTo(this.tableau.getEntry(0, r3), 0.0d, this.epsilon) <= 0) goto L11;
        r0.add(Integer.valueOf(r3));
    L11:
        r3 = r3 + 1;
        goto L7
    L12:
        int r4 = 0;
    L14:
        if (r4 >= getNumArtificialVariables()) goto L19;
        int r5 = getArtificialVariableOffset() + r4;
        if (getBasicRow(r5) != null) goto L18;
        r0.add(Integer.valueOf(r5));
    L18:
        r4 = r4 + 1;
        goto L14
    L19:
        double[][] r6 = (double[][]) Array.newInstance(Double.TYPE, new int[]{getHeight() - 1, getWidth() - r0.size()});
        int r7 = 1;
    L21:
        if (r7 >= getHeight()) goto L30;
        int r8 = 0;
        int r9 = 0;
    L24:
        if (r8 >= getWidth()) goto L29;
        if (r0.contains(Integer.valueOf(r8)) == true) goto L28;
        r6[r7 - 1][r9] = this.tableau.getEntry(r7, r8);
        r9 = r9 + 1;
    L28:
        r8 = r8 + 1;
        goto L24
    L29:
        r7 = r7 + 1;
        goto L21
    L30:
        Integer[] r1 = (Integer[]) r0.toArray(new Integer[r0.size()]);
        int r10 = r1.length - 1;
    L31:
        if (r10 < 0) goto L33;
        this.columnLabels.remove(r1[r10].intValue());
        r10 = r10 - 1;
        goto L31
    L33:
        this.tableau = new Array2DRowRealMatrix(r6);
        this.numArtificialVariables = 0;
    }

    private void copyArray(double[] r3, double[] r4) {
        System.arraycopy(r3, 0, r4, getNumObjectiveFunctions(), r3.length);
    }

    boolean isOptimal() {
        int r0 = getNumObjectiveFunctions();
    L4:
        if (r0 >= (getWidth() - 1)) goto L9;
        if (Precision.compareTo(this.tableau.getEntry(0, r0), 0.0d, this.epsilon) < 0) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    protected PointValuePair getSolution() {
        int r0 = this.columnLabels.indexOf(NEGATIVE_VAR_COLUMN_LABEL);
        if (r0 <= 0) goto L5;
        Integer r1 = getBasicRow(r0);
    L7:
        if (r1 != null) goto L9;
        double r3 = 0.0d;
    L10:
        HashSet r2 = new HashSet();
        int r5 = getOriginalNumDecisionVariables();
        double[] r6 = new double[r5];
        int r7 = 0;
    L11:
        if (r7 >= r5) goto L38;
        int r8 = this.columnLabels.indexOf(MaterialConfigFormatNames.X + r7);
        if (r8 >= 0) goto L15;
        r6[r7] = 0.0d;
    L36:
        r7 = r7 + 1;
        goto L11
    L15:
        Integer r9 = getBasicRow(r8);
        if (r9 == null) goto L21;
        if (r9.intValue() != 0) goto L21;
        r6[r7] = 0.0d;
    L21:
        if (r2.contains(r9) == true) goto L23;
        r2.add(r9);
        if (r9 != null) goto L30;
        double r10 = 0.0d;
    L32:
        if (this.restrictToNonNegative == false) goto L34;
        double r11 = 0.0d;
    L35:
        r6[r7] = r10 - r11;
        goto L36
    L34:
        r11 = r3;
        goto L35
    L30:
        r10 = getEntry(r9.intValue(), getRhsOffset());
        goto L32
    L23:
        if (this.restrictToNonNegative == false) goto L25;
        double r12 = 0.0d;
    L26:
        r6[r7] = 0.0d - r12;
        goto L36
    L25:
        r12 = r3;
        goto L26
    L38:
        return new PointValuePair(r6, this.f.getValue(r6));
    L9:
        r3 = getEntry(r1.intValue(), getRhsOffset());
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    protected void divideRow(int r5, double r6) {
        int r0 = 0;
    L4:
        if (r0 >= getWidth()) goto L6;
        RealMatrix r1 = this.tableau;
        r1.setEntry(r5, r0, r1.getEntry(r5, r0) / r6);
        r0 = r0 + 1;
        goto L4
    }

    protected void subtractRow(int r8, int r9, double r10) {
        int r0 = 0;
    L4:
        if (r0 >= getWidth()) goto L9;
        double r1 = this.tableau.getEntry(r8, r0) - (this.tableau.getEntry(r9, r0) * r10);
        if (FastMath.abs(r1) >= 1.0E-12d) goto L8;
        r1 = 0.0d;
    L8:
        this.tableau.setEntry(r8, r0, r1);
        r0 = r0 + 1;
        goto L4
    }

    protected final int getWidth() {
        return this.tableau.getColumnDimension();
    }

    protected final int getHeight() {
        return this.tableau.getRowDimension();
    }

    protected final double getEntry(int r1, int r2) {
        return this.tableau.getEntry(r1, r2);
    }

    protected final void setEntry(int r1, int r2, double r3) {
        this.tableau.setEntry(r1, r2, r3);
    }

    protected final int getSlackVariableOffset() {
        return getNumObjectiveFunctions() + this.numDecisionVariables;
    }

    protected final int getArtificialVariableOffset() {
        return (getNumObjectiveFunctions() + this.numDecisionVariables) + this.numSlackVariables;
    }

    protected final int getRhsOffset() {
        return getWidth() - 1;
    }

    protected final int getNumDecisionVariables() {
        return this.numDecisionVariables;
    }

    protected final int getOriginalNumDecisionVariables() {
        return this.f.getCoefficients().getDimension();
    }

    protected final int getNumSlackVariables() {
        return this.numSlackVariables;
    }

    protected final int getNumArtificialVariables() {
        return this.numArtificialVariables;
    }

    protected final double[][] getData() {
        return this.tableau.getData();
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SimplexTableau) == false) goto L28;
        SimplexTableau r9 = (SimplexTableau) r8;
        if (this.restrictToNonNegative != r9.restrictToNonNegative) goto L27;
        if (this.numDecisionVariables != r9.numDecisionVariables) goto L27;
        if (this.numSlackVariables != r9.numSlackVariables) goto L27;
        if (this.numArtificialVariables != r9.numArtificialVariables) goto L27;
        if (this.epsilon != r9.epsilon) goto L27;
        if (this.maxUlps != r9.maxUlps) goto L27;
        if (this.f.equals(r9.f) == false) goto L27;
        if (this.constraints.equals(r9.constraints) == false) goto L27;
        if (this.tableau.equals(r9.tableau) == false) goto L27;
        return true;
    L27:
        return false;
    L28:
        return false;
    }

    public int hashCode() {
        int r0 = ((((((Boolean.valueOf(this.restrictToNonNegative).hashCode() ^ this.numDecisionVariables) ^ this.numSlackVariables) ^ this.numArtificialVariables) ^ Double.valueOf(this.epsilon).hashCode()) ^ this.maxUlps) ^ this.f.hashCode()) ^ this.constraints.hashCode();
        return this.tableau.hashCode() ^ r0;
    }

    private void writeObject(ObjectOutputStream r1) throws IOException {
        r1.defaultWriteObject();
        MatrixUtils.serializeRealMatrix(this.tableau, r1);
    }

    private void readObject(ObjectInputStream r2) throws ClassNotFoundException, IOException {
        r2.defaultReadObject();
        MatrixUtils.deserializeRealMatrix(this, "tableau", r2);
    }
}
