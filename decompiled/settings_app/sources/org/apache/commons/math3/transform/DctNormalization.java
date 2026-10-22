package org.apache.commons.math3.transform;

/* JADX INFO: loaded from: classes6.dex */
public final enum DctNormalization extends Enum<DctNormalization> {
    private static final /* synthetic */ DctNormalization[] $VALUES = null;
    public static final DctNormalization ORTHOGONAL_DCT_I = null;
    public static final DctNormalization STANDARD_DCT_I = null;

    private DctNormalization(String r1, int r2) {
        super(r1, r2);
    }

    public static DctNormalization valueOf(String r1) {
        return (DctNormalization) Enum.valueOf(DctNormalization.class, r1);
    }

    public static DctNormalization[] values() {
        return (DctNormalization[]) $VALUES.clone();
    }

    static {
        DctNormalization r0 = new DctNormalization("STANDARD_DCT_I", 0);
        STANDARD_DCT_I = r0;
        DctNormalization r1 = new DctNormalization("ORTHOGONAL_DCT_I", 1);
        ORTHOGONAL_DCT_I = r1;
        $VALUES = new DctNormalization[]{r0, r1};
    }
}
