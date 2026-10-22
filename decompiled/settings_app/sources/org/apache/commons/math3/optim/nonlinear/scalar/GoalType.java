package org.apache.commons.math3.optim.nonlinear.scalar;

import org.apache.commons.math3.optim.OptimizationData;

/* JADX INFO: loaded from: classes6.dex */
public final enum GoalType extends Enum<GoalType> implements OptimizationData {
    private static final /* synthetic */ GoalType[] $VALUES = null;
    public static final GoalType MAXIMIZE = null;
    public static final GoalType MINIMIZE = null;

    private GoalType(String r1, int r2) {
        super(r1, r2);
    }

    public static GoalType valueOf(String r1) {
        return (GoalType) Enum.valueOf(GoalType.class, r1);
    }

    public static GoalType[] values() {
        return (GoalType[]) $VALUES.clone();
    }

    static {
        GoalType r0 = new GoalType("MAXIMIZE", 0);
        MAXIMIZE = r0;
        GoalType r1 = new GoalType("MINIMIZE", 1);
        MINIMIZE = r1;
        $VALUES = new GoalType[]{r0, r1};
    }
}
