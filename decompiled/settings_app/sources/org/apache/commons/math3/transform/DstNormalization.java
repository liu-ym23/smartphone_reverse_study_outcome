package org.apache.commons.math3.transform;

/* JADX INFO: loaded from: classes6.dex */
public final enum DstNormalization extends Enum<DstNormalization> {
    private static final /* synthetic */ DstNormalization[] $VALUES = null;
    public static final DstNormalization ORTHOGONAL_DST_I = null;
    public static final DstNormalization STANDARD_DST_I = null;

    private DstNormalization(String r1, int r2) {
        super(r1, r2);
    }

    public static DstNormalization valueOf(String r1) {
        return (DstNormalization) Enum.valueOf(DstNormalization.class, r1);
    }

    public static DstNormalization[] values() {
        return (DstNormalization[]) $VALUES.clone();
    }

    static {
        DstNormalization r0 = new DstNormalization("STANDARD_DST_I", 0);
        STANDARD_DST_I = r0;
        DstNormalization r1 = new DstNormalization("ORTHOGONAL_DST_I", 1);
        ORTHOGONAL_DST_I = r1;
        $VALUES = new DstNormalization[]{r0, r1};
    }
}
