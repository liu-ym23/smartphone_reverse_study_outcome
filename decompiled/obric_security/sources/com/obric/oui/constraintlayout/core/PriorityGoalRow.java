package com.obric.oui.constraintlayout.core;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-4f;
    static final int NOT_FOUND = -1;
    GoalVariableAccessor mAccessor;
    private SolverVariable[] mArrayGoals;
    Cache mCache;
    private int mNumGoals;
    private SolverVariable[] mSortArray;
    private int mTableSize;

    class GoalVariableAccessor {
        PriorityGoalRow mRow;
        SolverVariable mVariable;
        final /* synthetic */ PriorityGoalRow this$0;

        GoalVariableAccessor(PriorityGoalRow r1, PriorityGoalRow r2) {
            this.this$0 = r1;
            this.mRow = r2;
        }

        public void init(SolverVariable r1) {
            this.mVariable = r1;
        }

        public boolean addToGoal(SolverVariable r10, float r11) {
            boolean r4 = true;
            int r5 = 0;
            if (this.mVariable.inGoal == false) goto L14;
            int r0 = 0;
        L5:
            if (r0 >= 9) goto L11;
            float[] r6 = this.mVariable.mGoalStrengthVector;
            r6[r0] = r6[r0] + (r10.mGoalStrengthVector[r0] * r11);
            if (Math.abs(this.mVariable.mGoalStrengthVector[r0]) >= 1.0E-4f) goto L9;
            this.mVariable.mGoalStrengthVector[r0] = 0.0f;
        L10:
            r0 = r0 + 1;
            goto L5
        L9:
            r4 = false;
            goto L10
        L11:
            if (r4 == false) goto L13;
            PriorityGoalRow.access$000(this.this$0, this.mVariable);
        L13:
            return false;
        L14:
            if (r5 >= 9) goto L23;
            float r1 = r10.mGoalStrengthVector[r5];
            if (r1 == 0.0f) goto L21;
            float r2 = r1 * r11;
            if (Math.abs(r2) >= 1.0E-4f) goto L20;
            r2 = 0.0f;
        L20:
            this.mVariable.mGoalStrengthVector[r5] = r2;
        L22:
            r5 = r5 + 1;
            goto L14
        L21:
            this.mVariable.mGoalStrengthVector[r5] = 0.0f;
            goto L22
        L23:
            return true;
        }

        public void add(SolverVariable r5) {
            int r0 = 0;
        L4:
            if (r0 >= 9) goto L9;
            float[] r1 = this.mVariable.mGoalStrengthVector;
            r1[r0] = r1[r0] + r5.mGoalStrengthVector[r0];
            if (Math.abs(this.mVariable.mGoalStrengthVector[r0]) >= 1.0E-4f) goto L8;
            this.mVariable.mGoalStrengthVector[r0] = 0.0f;
        L8:
            r0 = r0 + 1;
            goto L4
        }

        public final boolean isNegative() {
            int r0 = 8;
        L4:
            if (r0 < 0) goto L13;
            float r2 = this.mVariable.mGoalStrengthVector[r0];
            if (r2 > 0.0f) goto L7;
            if (r2 < 0.0f) goto L10;
            r0 = r0 - 1;
            goto L4
        L10:
            return true;
        L7:
            return false;
        L13:
            return false;
        }

        public final boolean isSmallerThan(SolverVariable r6) {
            int r0 = 8;
        L4:
            if (r0 < 0) goto L15;
            float r2 = r6.mGoalStrengthVector[r0];
            float r3 = this.mVariable.mGoalStrengthVector[r0];
            if (r3 != r2) goto L9;
            r0 = r0 - 1;
            goto L4
        L9:
            if (r3 >= r2) goto L14;
            return true;
        L14:
            return false;
        L15:
            return false;
        }

        public final boolean isNull() {
            int r1 = 0;
        L4:
            if (r1 >= 9) goto L9;
            if (this.mVariable.mGoalStrengthVector[r1] != 0.0f) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return false;
        L9:
            return true;
        }

        public void reset() {
            Arrays.fill(this.mVariable.mGoalStrengthVector, 0.0f);
        }

        public String toString() {
            String r1 = "[ ";
            if (this.mVariable == null) goto L9;
            int r0 = 0;
        L6:
            if (r0 >= 9) goto L9;
            r1 = r1 + this.mVariable.mGoalStrengthVector[r0] + " ";
            r0 = r0 + 1;
        L9:
            return r1 + "] " + this.mVariable;
        }
    }

    static /* synthetic */ void access$000(PriorityGoalRow r0, SolverVariable r1) {
        r0.removeGoal(r1);
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow, com.obric.oui.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.mNumGoals = 0;
        this.mConstantValue = 0.0f;
    }

    public PriorityGoalRow(Cache r3) {
        super(r3);
        this.mTableSize = 128;
        this.mArrayGoals = new SolverVariable[128];
        this.mSortArray = new SolverVariable[128];
        this.mNumGoals = 0;
        this.mAccessor = new GoalVariableAccessor(this, this);
        this.mCache = r3;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow, com.obric.oui.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        if (this.mNumGoals != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow, com.obric.oui.constraintlayout.core.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem r5, boolean[] r6) {
        int r0 = 0;
        int r1 = -1;
    L4:
        if (r0 >= this.mNumGoals) goto L17;
        SolverVariable r2 = this.mArrayGoals[r0];
        if (r6[r2.id] == true) goto L16;
        this.mAccessor.init(r2);
        if (r1 != (-1)) goto L14;
        if (this.mAccessor.isNegative() == false) goto L16;
    L15:
        r1 = r0;
        goto L16
    L14:
        if (this.mAccessor.isSmallerThan(this.mArrayGoals[r1]) == true) goto L15;
    L16:
        r0 = r0 + 1;
        goto L4
    L17:
        if (r1 != (-1)) goto L21;
        return null;
    L21:
        return this.mArrayGoals[r1];
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow, com.obric.oui.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable r4) {
        this.mAccessor.init(r4);
        this.mAccessor.reset();
        r4.mGoalStrengthVector[r4.strength] = 1.0f;
        addToGoal(r4);
    }

    private void addToGoal(SolverVariable r6) {
        int r0 = this.mNumGoals + 1;
        SolverVariable[] r2 = this.mArrayGoals;
        if (r0 <= r2.length) goto L5;
        SolverVariable[] r1 = (SolverVariable[]) Arrays.copyOf(r2, r2.length * 2);
        this.mArrayGoals = r1;
        this.mSortArray = (SolverVariable[]) Arrays.copyOf(r1, r1.length * 2);
    L5:
        SolverVariable[] r3 = this.mArrayGoals;
        int r4 = this.mNumGoals;
        r3[r4] = r6;
        int r5 = r4 + 1;
        this.mNumGoals = r5;
        if (r5 > 1) goto L8;
    L17:
        r6.inGoal = true;
        r6.addToRow(this);
        return;
    L8:
        if (r3[r5 - 1].id <= r6.id) goto L17;
        int r7 = 0;
        int r8 = 0;
    L10:
        int r9 = this.mNumGoals;
        if (r8 >= r9) goto L13;
        this.mSortArray[r8] = this.mArrayGoals[r8];
        r8 = r8 + 1;
        goto L10
    L13:
        Arrays.sort(this.mSortArray, 0, r9, new AnonymousClass1(this));
    L15:
        if (r7 >= this.mNumGoals) goto L17;
        this.mArrayGoals[r7] = this.mSortArray[r7];
        r7 = r7 + 1;
        goto L15
    }

    private void removeGoal(SolverVariable r6) {
        int r1 = 0;
    L4:
        if (r1 >= this.mNumGoals) goto L13;
        if (this.mArrayGoals[r1] == r6) goto L7;
        r1 = r1 + 1;
    L7:
        int r2 = this.mNumGoals;
        if (r1 >= (r2 - 1)) goto L10;
        SolverVariable[] r3 = this.mArrayGoals;
        int r4 = r1 + 1;
        r3[r1] = r3[r4];
        r1 = r4;
        goto L7
    L10:
        this.mNumGoals = r2 - 1;
        r6.inGoal = false;
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow, com.obric.oui.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem r6, ArrayRow r7, boolean r8) {
        SolverVariable r9 = r7.mVariable;
        if (r9 != null) goto L5;
        return;
    L5:
        ArrayRow.ArrayRowVariables r10 = r7.variables;
        int r0 = r10.getCurrentSize();
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        SolverVariable r2 = r10.getVariable(r1);
        float r3 = r10.getVariableValue(r1);
        this.mAccessor.init(r2);
        if (this.mAccessor.addToGoal(r9, r3) == false) goto L10;
        addToGoal(r2);
    L10:
        this.mConstantValue += r7.mConstantValue * r3;
        r1 = r1 + 1;
        goto L6
    L11:
        removeGoal(r9);
    }

    @Override // com.obric.oui.constraintlayout.core.ArrayRow
    public String toString() {
        String r0 = " goal -> (" + this.mConstantValue + ") : ";
        int r1 = 0;
    L4:
        if (r1 >= this.mNumGoals) goto L6;
        this.mAccessor.init(this.mArrayGoals[r1]);
        r0 = r0 + this.mAccessor + " ";
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }
}
