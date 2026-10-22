package org.apache.commons.math3.stat.inference;

/* JADX INFO: loaded from: classes6.dex */
public final enum AlternativeHypothesis extends Enum<AlternativeHypothesis> {
    private static final /* synthetic */ AlternativeHypothesis[] $VALUES = null;
    public static final AlternativeHypothesis GREATER_THAN = null;
    public static final AlternativeHypothesis LESS_THAN = null;
    public static final AlternativeHypothesis TWO_SIDED = null;

    private AlternativeHypothesis(String r1, int r2) {
        super(r1, r2);
    }

    public static AlternativeHypothesis valueOf(String r1) {
        return (AlternativeHypothesis) Enum.valueOf(AlternativeHypothesis.class, r1);
    }

    public static AlternativeHypothesis[] values() {
        return (AlternativeHypothesis[]) $VALUES.clone();
    }

    static {
        AlternativeHypothesis r0 = new AlternativeHypothesis("TWO_SIDED", 0);
        TWO_SIDED = r0;
        AlternativeHypothesis r1 = new AlternativeHypothesis("GREATER_THAN", 1);
        GREATER_THAN = r1;
        AlternativeHypothesis r3 = new AlternativeHypothesis("LESS_THAN", 2);
        LESS_THAN = r3;
        $VALUES = new AlternativeHypothesis[]{r0, r1, r3};
    }
}
