package org.apache.commons.math3.optimization.general;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public final enum ConjugateGradientFormula extends Enum<ConjugateGradientFormula> {
    private static final /* synthetic */ ConjugateGradientFormula[] $VALUES = null;
    public static final ConjugateGradientFormula FLETCHER_REEVES = null;
    public static final ConjugateGradientFormula POLAK_RIBIERE = null;

    public static ConjugateGradientFormula valueOf(String r1) {
        return (ConjugateGradientFormula) Enum.valueOf(ConjugateGradientFormula.class, r1);
    }

    public static ConjugateGradientFormula[] values() {
        return (ConjugateGradientFormula[]) $VALUES.clone();
    }

    private ConjugateGradientFormula(String r1, int r2) {
        super(r1, r2);
    }

    static {
        ConjugateGradientFormula r0 = new ConjugateGradientFormula("FLETCHER_REEVES", 0);
        FLETCHER_REEVES = r0;
        ConjugateGradientFormula r1 = new ConjugateGradientFormula("POLAK_RIBIERE", 1);
        POLAK_RIBIERE = r1;
        $VALUES = new ConjugateGradientFormula[]{r0, r1};
    }
}
