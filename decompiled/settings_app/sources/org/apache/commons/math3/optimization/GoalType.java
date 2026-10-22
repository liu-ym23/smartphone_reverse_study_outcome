package org.apache.commons.math3.optimization;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public final enum GoalType extends Enum<GoalType> implements Serializable {
    private static final /* synthetic */ GoalType[] $VALUES = null;
    public static final GoalType MAXIMIZE = null;
    public static final GoalType MINIMIZE = null;

    public static GoalType valueOf(String r1) {
        return (GoalType) Enum.valueOf(GoalType.class, r1);
    }

    public static GoalType[] values() {
        return (GoalType[]) $VALUES.clone();
    }

    private GoalType(String r1, int r2) {
        super(r1, r2);
    }

    static {
        GoalType r0 = new GoalType("MAXIMIZE", 0);
        MAXIMIZE = r0;
        GoalType r1 = new GoalType("MINIMIZE", 1);
        MINIMIZE = r1;
        $VALUES = new GoalType[]{r0, r1};
    }
}
