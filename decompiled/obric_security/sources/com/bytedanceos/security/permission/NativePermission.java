package com.bytedanceos.security.permission;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NativePermission {
    private String mBackgroundPermission;
    private String mDangerousGroup;
    private int mGroupType;
    private int mIndex;
    private int mOpcode;
    private int mPermissionGroupLabelRes;
    private String mPermissionName;
    private int mPermissionType;
    private String[] mPermissions;
    private int mShowMode;

    public static final class PERMISSION_TYPE {
        public static final int DANGEROUS = 2;
        public static final int NORMAL = 1;
        public static final int SPECIAL = 3;

        public PERMISSION_TYPE() {
        }
    }

    public static final class SHOW_MODE {
        public static final int ASK_MODE = 3;
        public static final int INUSE_MODE = 2;
        public static final int SWITCH_MODE = 1;

        public SHOW_MODE() {
        }
    }

    public NativePermission(int groupType, int permissionType, String permissionname, int grouplabelRes, String dangerousGroup, int opcode, int showmode, int index, String[] permissions) {
        this(groupType, permissionType, permissionname, grouplabelRes, dangerousGroup, opcode, showmode, index, permissions, null);
    }

    public NativePermission(int groupType, int permissionType, String permissionname, int grouplabelRes, String dangerousGroup, int opcode, int showmode, int index, String[] permissions, String backgroudPermission) {
        this.mPermissionName = permissionname;
        this.mGroupType = groupType;
        this.mIndex = index;
        this.mPermissionGroupLabelRes = grouplabelRes;
        this.mPermissionType = permissionType;
        this.mPermissions = permissions;
        this.mDangerousGroup = dangerousGroup;
        this.mOpcode = opcode;
        this.mShowMode = showmode;
        this.mBackgroundPermission = backgroudPermission;
    }

    public void setBackgroundPermission(String permission) {
        this.mBackgroundPermission = permission;
    }

    public String getBackgroundPermission() {
        return this.mBackgroundPermission;
    }

    public boolean hasBackgroundPermission() {
        return !TextUtils.isEmpty(this.mBackgroundPermission);
    }

    public String[] getPermissions() {
        return this.mPermissions;
    }

    public boolean isDangerous() {
        if (this.mPermissionType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSpecial() {
        if (this.mPermissionType != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public int getGroupType() {
        return this.mGroupType;
    }

    public int getPermissionType() {
        return this.mPermissionType;
    }

    public String getPermissionName() {
        return this.mPermissionName;
    }

    public int getLabelRes() {
        return this.mPermissionGroupLabelRes;
    }

    public String getDangerousGroupName() {
        if (isDangerous() == true) goto L10;
        if (isSpecial() == true) goto L10;
        return null;
    L10:
        return this.mDangerousGroup;
    }

    public int getOpCode() {
        return this.mOpcode;
    }

    public boolean isSepicalPermission() {
        if (isDangerous() == true) goto L8;
        if (this.mPermissions != null) goto L8;
        return true;
    L8:
        if (TextUtils.equals(this.mPermissionName, NativePermissionManager.PERMISSION_NFC) == false) goto L10;
        return true;
    L10:
        return false;
    }

    public int getShowMode() {
        return this.mShowMode;
    }

    public void setShowMode(int mode) {
        this.mShowMode = mode;
    }

    public boolean isSwitchMode() {
        if (this.mShowMode == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isInUseMode() {
        if (this.mShowMode != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLocationPermission() {
        return TextUtils.equals(this.mPermissionName, NativePermissionManager.PERMISSION_LOCATION);
    }
}
