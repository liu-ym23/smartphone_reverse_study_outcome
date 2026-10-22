package androidx.constraintlayout.core;

import a.a;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    static final int NOT_FOUND = -1;
    private static final float epsilon = 1.0E-4f;
    private int TABLE_SIZE;
    GoalVariableAccessor accessor;
    private SolverVariable[] arrayGoals;
    Cache mCache;
    private int numGoals;
    private SolverVariable[] sortArray;

    public class GoalVariableAccessor {
        PriorityGoalRow row;
        final /* synthetic */ PriorityGoalRow this$0;
        SolverVariable variable;

        public GoalVariableAccessor(PriorityGoalRow r1, PriorityGoalRow r2) {
            this.this$0 = r1;
            this.row = r2;
        }

        public void add(SolverVariable r5) {
            int r0 = 0;
        L4:
            if (r0 >= 9) goto L9;
            float[] r1 = this.variable.goalStrengthVector;
            float r2 = r1[r0] + r5.goalStrengthVector[r0];
            r1[r0] = r2;
            if (Math.abs(r2) >= 1.0E-4f) goto L8;
            this.variable.goalStrengthVector[r0] = 0.0f;
        L8:
            r0 = r0 + 1;
            goto L4
        }

        public boolean addToGoal(SolverVariable r10, float r11) {
            int r4 = 0;
            boolean r5 = true;
            if (this.variable.inGoal == false) goto L14;
            int r0 = 0;
        L5:
            if (r0 >= 9) goto L11;
            float[] r6 = this.variable.goalStrengthVector;
            float r8 = (r10.goalStrengthVector[r0] * r11) + r6[r0];
            r6[r0] = r8;
            if (Math.abs(r8) >= 1.0E-4f) goto L9;
            this.variable.goalStrengthVector[r0] = 0.0f;
        L10:
            r0 = r0 + 1;
            goto L5
        L9:
            r5 = false;
            goto L10
        L11:
            if (r5 == false) goto L13;
            PriorityGoalRow.access$000(this.this$0, this.variable);
        L13:
            return false;
        L14:
            if (r4 >= 9) goto L23;
            float r1 = r10.goalStrengthVector[r4];
            if (r1 == 0.0f) goto L21;
            float r2 = r1 * r11;
            if (Math.abs(r2) >= 1.0E-4f) goto L20;
            r2 = 0.0f;
        L20:
            this.variable.goalStrengthVector[r4] = r2;
        L22:
            r4 = r4 + 1;
            goto L14
        L21:
            this.variable.goalStrengthVector[r4] = 0.0f;
            goto L22
        L23:
            return true;
        }

        public void init(SolverVariable r1) {
            this.variable = r1;
        }

        public final boolean isNegative() {
            int r0 = 8;
        L4:
            if (r0 < 0) goto L13;
            float r2 = this.variable.goalStrengthVector[r0];
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

        public final boolean isNull() {
            int r1 = 0;
        L4:
            if (r1 >= 9) goto L9;
            if (this.variable.goalStrengthVector[r1] != 0.0f) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return false;
        L9:
            return true;
        }

        public final boolean isSmallerThan(SolverVariable r6) {
            int r0 = 8;
        L4:
            if (r0 < 0) goto L12;
            float r2 = r6.goalStrengthVector[r0];
            float r3 = this.variable.goalStrengthVector[r0];
            if (r3 != r2) goto L9;
            r0 = r0 - 1;
            goto L4
        L9:
            if (r3 >= r2) goto L12;
            return true;
        L12:
            return false;
        }

        public void reset() {
            Arrays.fill(this.variable.goalStrengthVector, 0.0f);
        }

        public String toString() {
            String r1 = "[ ";
            if (this.variable == null) goto L8;
            int r0 = 0;
        L6:
            if (r0 >= 9) goto L8;
            StringBuilder r2 = a.q(r1);
            r2.append(this.variable.goalStrengthVector[r0]);
            r2.append(" ");
            r1 = r2.toString();
            r0 = r0 + 1;
        L8:
            StringBuilder r3 = a.t(r1, "] ");
            r3.append(this.variable);
            return r3.toString();
        }
    }

    public PriorityGoalRow(Cache r3) {
        super(r3);
        this.TABLE_SIZE = 128;
        this.arrayGoals = new SolverVariable[128];
        this.sortArray = new SolverVariable[128];
        this.numGoals = 0;
        this.accessor = new GoalVariableAccessor(this, this);
        this.mCache = r3;
    }

    public static /* synthetic */ void access$000(PriorityGoalRow r0, SolverVariable r1) {
        r0.removeGoal(r1);
    }

    private final void addToGoal(SolverVariable r6) {
        int r0 = this.numGoals + 1;
        SolverVariable[] r2 = this.arrayGoals;
        if (r0 <= r2.length) goto L5;
        SolverVariable[] r1 = (SolverVariable[]) Arrays.copyOf(r2, r2.length * 2);
        this.arrayGoals = r1;
        this.sortArray = (SolverVariable[]) Arrays.copyOf(r1, r1.length * 2);
    L5:
        SolverVariable[] r3 = this.arrayGoals;
        int r4 = this.numGoals;
        r3[r4] = r6;
        int r5 = r4 + 1;
        this.numGoals = r5;
        if (r5 > 1) goto L8;
    L17:
        r6.inGoal = true;
        r6.addToRow(this);
        return;
    L8:
        if (r3[r4].id <= r6.id) goto L17;
        int r7 = 0;
        int r8 = 0;
    L10:
        int r9 = this.numGoals;
        if (r8 >= r9) goto L13;
        this.sortArray[r8] = this.arrayGoals[r8];
        r8 = r8 + 1;
        goto L10
    L13:
        Arrays.sort(this.sortArray, 0, r9, new AnonymousClass1(this));
    L15:
        if (r7 >= this.numGoals) goto L17;
        this.arrayGoals[r7] = this.sortArray[r7];
        r7 = r7 + 1;
        goto L15
    }

    private final void removeGoal(SolverVariable r6) {
        int r1 = 0;
    L4:
        if (r1 >= this.numGoals) goto L13;
        if (this.arrayGoals[r1] == r6) goto L7;
        r1 = r1 + 1;
    L7:
        int r2 = this.numGoals;
        if (r1 >= (r2 - 1)) goto L10;
        SolverVariable[] r3 = this.arrayGoals;
        int r4 = r1 + 1;
        r3[r1] = r3[r4];
        r1 = r4;
        goto L7
    L10:
        this.numGoals = r2 - 1;
        r6.inGoal = false;
        return;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable r4) {
        this.accessor.init(r4);
        this.accessor.reset();
        r4.goalStrengthVector[r4.strength] = 1.0f;
        addToGoal(r4);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.numGoals = 0;
        this.constantValue = 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem r5, boolean[] r6) {
        int r0 = 0;
        int r1 = -1;
    L4:
        if (r0 >= this.numGoals) goto L17;
        SolverVariable r2 = this.arrayGoals[r0];
        if (r6[r2.id] == true) goto L16;
        this.accessor.init(r2);
        if (r1 != (-1)) goto L14;
        if (this.accessor.isNegative() == false) goto L16;
    L15:
        r1 = r0;
        goto L16
    L14:
        if (this.accessor.isSmallerThan(this.arrayGoals[r1]) == true) goto L15;
    L16:
        r0 = r0 + 1;
        goto L4
    L17:
        if (r1 != (-1)) goto L21;
        return null;
    L21:
        return this.arrayGoals[r1];
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        if (this.numGoals != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public String toString() {
        String r0 = " goal -> (" + this.constantValue + ") : ";
        int r1 = 0;
    L4:
        if (r1 >= this.numGoals) goto L6;
        this.accessor.init(this.arrayGoals[r1]);
        StringBuilder r2 = a.q(r0);
        r2.append(this.accessor);
        r2.append(" ");
        r0 = r2.toString();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem r6, ArrayRow r7, boolean r8) {
        SolverVariable r9 = r7.variable;
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
        this.accessor.init(r2);
        if (this.accessor.addToGoal(r9, r3) == false) goto L10;
        addToGoal(r2);
    L10:
        float r4 = this.constantValue;
        this.constantValue = (r7.constantValue * r3) + r4;
        r1 = r1 + 1;
        goto L6
    L11:
        removeGoal(r9);
    }
}
