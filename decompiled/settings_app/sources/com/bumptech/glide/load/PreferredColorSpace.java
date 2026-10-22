package com.bumptech.glide.load;

/* JADX INFO: loaded from: classes3.dex */
public final enum PreferredColorSpace extends Enum<PreferredColorSpace> {
    private static final /* synthetic */ PreferredColorSpace[] $VALUES = null;
    public static final PreferredColorSpace DISPLAY_P3 = null;
    public static final PreferredColorSpace SRGB = null;

    private static /* synthetic */ PreferredColorSpace[] $values() {
        return new PreferredColorSpace[]{SRGB, DISPLAY_P3};
    }

    private PreferredColorSpace(String r1, int r2) {
        super(r1, r2);
    }

    public static PreferredColorSpace valueOf(String r1) {
        return (PreferredColorSpace) Enum.valueOf(PreferredColorSpace.class, r1);
    }

    public static PreferredColorSpace[] values() {
        return (PreferredColorSpace[]) $VALUES.clone();
    }

    static {
        SRGB = new PreferredColorSpace("SRGB", 0);
        DISPLAY_P3 = new PreferredColorSpace("DISPLAY_P3", 1);
        $VALUES = $values();
    }
}
