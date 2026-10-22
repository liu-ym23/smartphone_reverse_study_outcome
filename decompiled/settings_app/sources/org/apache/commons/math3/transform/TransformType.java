package org.apache.commons.math3.transform;

/* JADX INFO: loaded from: classes6.dex */
public final enum TransformType extends Enum<TransformType> {
    private static final /* synthetic */ TransformType[] $VALUES = null;
    public static final TransformType FORWARD = null;
    public static final TransformType INVERSE = null;

    private TransformType(String r1, int r2) {
        super(r1, r2);
    }

    public static TransformType valueOf(String r1) {
        return (TransformType) Enum.valueOf(TransformType.class, r1);
    }

    public static TransformType[] values() {
        return (TransformType[]) $VALUES.clone();
    }

    static {
        TransformType r0 = new TransformType("FORWARD", 0);
        FORWARD = r0;
        TransformType r1 = new TransformType("INVERSE", 1);
        INVERSE = r1;
        $VALUES = new TransformType[]{r0, r1};
    }
}
