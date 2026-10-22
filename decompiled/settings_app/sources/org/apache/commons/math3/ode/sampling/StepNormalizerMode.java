package org.apache.commons.math3.ode.sampling;

/* JADX INFO: loaded from: classes6.dex */
public final enum StepNormalizerMode extends Enum<StepNormalizerMode> {
    private static final /* synthetic */ StepNormalizerMode[] $VALUES = null;
    public static final StepNormalizerMode INCREMENT = null;
    public static final StepNormalizerMode MULTIPLES = null;

    private StepNormalizerMode(String r1, int r2) {
        super(r1, r2);
    }

    public static StepNormalizerMode valueOf(String r1) {
        return (StepNormalizerMode) Enum.valueOf(StepNormalizerMode.class, r1);
    }

    public static StepNormalizerMode[] values() {
        return (StepNormalizerMode[]) $VALUES.clone();
    }

    static {
        StepNormalizerMode r0 = new StepNormalizerMode("INCREMENT", 0);
        INCREMENT = r0;
        StepNormalizerMode r1 = new StepNormalizerMode("MULTIPLES", 1);
        MULTIPLES = r1;
        $VALUES = new StepNormalizerMode[]{r0, r1};
    }
}
