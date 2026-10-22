package com.gyf.barlibrary;

/* JADX INFO: loaded from: classes2.dex */
public final enum BarHide extends Enum<BarHide> {
    private static final /* synthetic */ BarHide[] $VALUES = null;
    public static final BarHide FLAG_HIDE_BAR = null;
    public static final BarHide FLAG_HIDE_NAVIGATION_BAR = null;
    public static final BarHide FLAG_HIDE_STATUS_BAR = null;
    public static final BarHide FLAG_SHOW_BAR = null;

    private BarHide(String r1, int r2) {
        super(r1, r2);
    }

    public static BarHide valueOf(String r1) {
        return (BarHide) Enum.valueOf(BarHide.class, r1);
    }

    public static BarHide[] values() {
        return (BarHide[]) $VALUES.clone();
    }

    static {
        BarHide r0 = new BarHide("FLAG_HIDE_STATUS_BAR", 0);
        FLAG_HIDE_STATUS_BAR = r0;
        BarHide r1 = new BarHide("FLAG_HIDE_NAVIGATION_BAR", 1);
        FLAG_HIDE_NAVIGATION_BAR = r1;
        BarHide r3 = new BarHide("FLAG_HIDE_BAR", 2);
        FLAG_HIDE_BAR = r3;
        BarHide r5 = new BarHide("FLAG_SHOW_BAR", 3);
        FLAG_SHOW_BAR = r5;
        $VALUES = new BarHide[]{r0, r1, r3, r5};
    }
}
