package com.airbnb.lottie;

/* JADX INFO: loaded from: classes.dex */
public final enum RenderMode extends Enum<RenderMode> {
    private static final /* synthetic */ RenderMode[] $VALUES = null;
    public static final RenderMode AUTOMATIC = null;
    public static final RenderMode HARDWARE = null;
    public static final RenderMode SOFTWARE = null;

    private RenderMode(String r1, int r2) {
        super(r1, r2);
    }

    public static RenderMode valueOf(String r1) {
        return (RenderMode) Enum.valueOf(RenderMode.class, r1);
    }

    public static RenderMode[] values() {
        return (RenderMode[]) $VALUES.clone();
    }

    static {
        RenderMode r0 = new RenderMode("AUTOMATIC", 0);
        AUTOMATIC = r0;
        RenderMode r1 = new RenderMode("HARDWARE", 1);
        HARDWARE = r1;
        RenderMode r3 = new RenderMode("SOFTWARE", 2);
        SOFTWARE = r3;
        $VALUES = new RenderMode[]{r0, r1, r3};
    }
}
