package com.obric.safecheck.riskcontrol.api.model;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: RiskControlFlags.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/safecheck/riskcontrol/api/model/RiskControlFlags;", "", "()V", "ACCESSIBILITY", "", "DEFAULT_CONTROL_FLAGS", "INSTALL_PACKAGES", "NETWORK", "NETWORK_MOBILE", "NETWORK_WIFI", "NONE", "NOTIFICATION", "PERMISSION_CONTACTS", "PERMISSION_SMS", "SENSITIVE_PERMISSION", "hasControlledItem", "", "controlFlags", "hasFlag", "flag", "hasReleasedControl", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RiskControlFlags {
    public static final int ACCESSIBILITY = 32;
    public static final int DEFAULT_CONTROL_FLAGS = 127;
    public static final int INSTALL_PACKAGES = 16;
    public static final RiskControlFlags INSTANCE = null;
    public static final int NETWORK = 3;
    public static final int NETWORK_MOBILE = 2;
    public static final int NETWORK_WIFI = 1;
    public static final int NONE = 0;
    public static final int NOTIFICATION = 64;
    public static final int PERMISSION_CONTACTS = 4;
    public static final int PERMISSION_SMS = 8;
    public static final int SENSITIVE_PERMISSION = 28;

    @JvmStatic
    public static final boolean hasControlledItem(int r0) {
        if (r0 == 0) goto L4;
        return true;
    L4:
        return false;
    }

    @JvmStatic
    public static final boolean hasFlag(int r0, int r1) {
        if ((r0 & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean hasReleasedControl(int r0) {
        if (r0 != 0) goto L4;
        return true;
    L4:
        return false;
    }

    static {
        INSTANCE = new RiskControlFlags();
    }

    private RiskControlFlags() {
    }
}
