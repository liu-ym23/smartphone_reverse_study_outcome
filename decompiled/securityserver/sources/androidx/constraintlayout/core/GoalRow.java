package androidx.constraintlayout.core;

/* JADX INFO: loaded from: classes.dex */
public class GoalRow extends ArrayRow {
    public GoalRow(Cache r1) {
        super(r1);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable r1) {
        super.addError(r1);
        r1.usageInRowCount--;
    }
}
