package com.bytedanceos.security.reflect;

/* JADX INFO: loaded from: classes2.dex */
public class VirtualAppOps {
    private String mPermissionName;
    private int mRealCode;
    private int mVirtualCode;

    public VirtualAppOps(String name, int vcode, int rcode) {
        this.mPermissionName = name;
        this.mVirtualCode = vcode;
        this.mRealCode = rcode;
    }

    public String getPermissionName() {
        return this.mPermissionName;
    }

    public void setPermissionName(String permissionName) {
        this.mPermissionName = permissionName;
    }

    public int getVirtualCode() {
        return this.mVirtualCode;
    }

    public void setVirtualCode(int virtualCode) {
        this.mVirtualCode = virtualCode;
    }

    public int getRealCode() {
        return this.mRealCode;
    }

    public void setRealCode(int realCode) {
        this.mRealCode = realCode;
    }
}
