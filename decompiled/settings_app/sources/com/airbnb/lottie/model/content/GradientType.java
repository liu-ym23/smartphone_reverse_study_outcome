package com.airbnb.lottie.model.content;

/* JADX INFO: loaded from: classes.dex */
public final enum GradientType extends Enum<GradientType> {
    private static final /* synthetic */ GradientType[] $VALUES = null;
    public static final GradientType LINEAR = null;
    public static final GradientType RADIAL = null;

    private GradientType(String r1, int r2) {
        super(r1, r2);
    }

    public static GradientType valueOf(String r1) {
        return (GradientType) Enum.valueOf(GradientType.class, r1);
    }

    public static GradientType[] values() {
        return (GradientType[]) $VALUES.clone();
    }

    static {
        GradientType r0 = new GradientType("LINEAR", 0);
        LINEAR = r0;
        GradientType r1 = new GradientType("RADIAL", 1);
        RADIAL = r1;
        $VALUES = new GradientType[]{r0, r1};
    }
}
