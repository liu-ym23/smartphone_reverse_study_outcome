package com.android.settings.permission;

/* JADX INFO: loaded from: classes2.dex */
public class VirtualAppOps {
    private String mPermissionName;
    private int mRealCode;
    private int mVirtualCode;

    public VirtualAppOps(String r1, int r2, int r3) {
        this.mPermissionName = r1;
        this.mVirtualCode = r2;
        this.mRealCode = r3;
    }

    public String getPermissionName() {
        return this.mPermissionName;
    }

    public void setPermissionName(String r1) {
        this.mPermissionName = r1;
    }

    public int getVirtualCode() {
        return this.mVirtualCode;
    }

    public void setVirtualCode(int r1) {
        this.mVirtualCode = r1;
    }

    public int getRealCode() {
        return this.mRealCode;
    }

    public void setRealCode(int r1) {
        this.mRealCode = r1;
    }
}
