package com.bytedanceos.security.permission;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NativePermissionGroup {
    public static final int BOOT = 1;
    public static final int CALENDAR = 5;
    public static final int CALL_CONTACT = 3;
    public static final int LOCATION = 2;
    public static final int MEDIA = 6;
    public static final int NET = 8;
    public static final int OTHER = 9;
    public static final int SMS_MMS = 4;
    public static final int STORAGE = 7;
    public static final int STORAGE_ALL = 10;
    private int mLabelRes;
    private List<AppNativePermission> mPermissions;
    private int mType;

    public NativePermissionGroup(int type, int labelRes) {
        this.mType = type;
        this.mLabelRes = labelRes;
        this.mPermissions = new ArrayList();
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int type) {
        this.mType = type;
    }

    public int getLabelRes() {
        return this.mLabelRes;
    }

    public void setLabelRes(int labelRes) {
        this.mLabelRes = labelRes;
    }

    public void addPermission(List<AppNativePermission> permissions) {
        if (permissions != null) goto L4;
        return;
    L4:
        if (permissions.size() < 1) goto L9;
        this.mPermissions.addAll(permissions);
        return;
    }

    public List<AppNativePermission> getAllPermissions() {
        return this.mPermissions;
    }
}
