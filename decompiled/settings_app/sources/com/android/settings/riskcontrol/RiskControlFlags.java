package com.android.settings.riskcontrol;

/* JADX INFO: loaded from: classes2.dex */
public final class RiskControlFlags {
    public static final int ACCESSIBILITY = 32;
    public static final int INSTALL_PACKAGES = 16;
    public static final int NETWORK = 3;
    public static final int NETWORK_MOBILE = 2;
    public static final int NETWORK_WIFI = 1;
    public static final int NONE = 0;
    public static final int NOTIFICATION = 64;
    public static final int PERMISSION_CONTACTS = 4;
    public static final int PERMISSION_SMS = 8;
    public static final int SENSITIVE_PERMISSION = 28;

    public static boolean hasControlledItem(int r0) {
        if (r0 == 0) goto L4;
        return true;
    L4:
        return false;
    }

    public static boolean hasFlag(int r0, int r1) {
        if ((r0 & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean hasReleasedControl(int r0) {
        if (r0 != 0) goto L4;
        return true;
    L4:
        return false;
    }

    private RiskControlFlags() {
    }
}
