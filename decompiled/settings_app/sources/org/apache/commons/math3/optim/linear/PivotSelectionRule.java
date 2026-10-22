package org.apache.commons.math3.optim.linear;

import org.apache.commons.math3.optim.OptimizationData;

/* JADX INFO: loaded from: classes6.dex */
public final enum PivotSelectionRule extends Enum<PivotSelectionRule> implements OptimizationData {
    private static final /* synthetic */ PivotSelectionRule[] $VALUES = null;
    public static final PivotSelectionRule BLAND = null;
    public static final PivotSelectionRule DANTZIG = null;

    private PivotSelectionRule(String r1, int r2) {
        super(r1, r2);
    }

    public static PivotSelectionRule valueOf(String r1) {
        return (PivotSelectionRule) Enum.valueOf(PivotSelectionRule.class, r1);
    }

    public static PivotSelectionRule[] values() {
        return (PivotSelectionRule[]) $VALUES.clone();
    }

    static {
        PivotSelectionRule r0 = new PivotSelectionRule("DANTZIG", 0);
        DANTZIG = r0;
        PivotSelectionRule r1 = new PivotSelectionRule("BLAND", 1);
        BLAND = r1;
        $VALUES = new PivotSelectionRule[]{r0, r1};
    }
}
