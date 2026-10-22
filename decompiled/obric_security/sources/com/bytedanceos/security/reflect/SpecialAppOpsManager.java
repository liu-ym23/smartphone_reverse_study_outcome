package com.bytedanceos.security.reflect;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SpecialAppOpsManager {
    private static final int PERMISSION_INVAILED_VIRTUAL_CODE = -1;
    private static final int PERMISSION_SYSTEM_ALERT_WINDOW_VIRTUAL_CODE = -10001;
    private static final int PERMISSION_WRITE_SETTING_VIRTUAL_CODE = -10000;
    private static List<VirtualAppOps> SPECIAL_VIRTUAL;

    public SpecialAppOpsManager() {
    }

    static {
        ArrayList r0 = new ArrayList();
        SPECIAL_VIRTUAL = r0;
        r0.add(new VirtualAppOps("android.permission.WRITE_SETTINGS", -10000, OpsManagerHelper.get_OP_WRITE_SETTINGS()));
        SPECIAL_VIRTUAL.add(new VirtualAppOps("android.permission.SYSTEM_ALERT_WINDOW", PERMISSION_SYSTEM_ALERT_WINDOW_VIRTUAL_CODE, OpsManagerHelper.get_OP_SYSTEM_ALERT_WINDOW()));
    }

    public static boolean isSpecialAppOps(int virtualCode) {
        if (getByVirtualCode(virtualCode) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static int getRealCodeByVirtualCode(int virtualCode) {
        VirtualAppOps r0 = getByVirtualCode(virtualCode);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getRealCode();
    }

    public static VirtualAppOps getByVirtualCode(int virtualCode) {
        Iterator<VirtualAppOps> r0 = SPECIAL_VIRTUAL.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        VirtualAppOps r1 = r0.next();
        if (r1.getVirtualCode() != virtualCode) goto L4;
        return r1;
    L8:
        return null;
    }

    public static int getWriteSettingsVirtualCode() {
        return getVirtualCodeByPermission("android.permission.WRITE_SETTINGS");
    }

    public static int getSystemAlertWindowVirtualCode() {
        return getVirtualCodeByPermission("android.permission.SYSTEM_ALERT_WINDOW");
    }

    public static int getVirtualCodeByPermission(String permission) {
        if (TextUtils.isEmpty(permission) == false) goto L5;
        return -1;
    L5:
        VirtualAppOps r2 = getByPermission(permission);
        if (r2 != null) goto L9;
        return -1;
    L9:
        return r2.getVirtualCode();
    }

    public static VirtualAppOps getByPermission(String permission) {
        if (TextUtils.isEmpty(permission) == false) goto L5;
        return null;
    L5:
        Iterator<VirtualAppOps> r0 = SPECIAL_VIRTUAL.iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        VirtualAppOps r2 = r0.next();
        if (TextUtils.equals(permission, r2.getPermissionName()) == false) goto L7;
        return r2;
    L11:
        return null;
    }
}
