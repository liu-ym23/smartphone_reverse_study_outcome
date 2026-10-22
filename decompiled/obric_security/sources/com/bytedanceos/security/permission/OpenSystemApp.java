package com.bytedanceos.security.permission;

/* JADX INFO: loaded from: classes2.dex */
public class OpenSystemApp {
    private String[] mHiddenDangerousPermissions;
    private String mPackageName;
    private boolean mShowInNet;

    public OpenSystemApp(String pkg, String[] permissions, boolean showInNet) {
        this.mPackageName = pkg;
        this.mHiddenDangerousPermissions = permissions;
        this.mShowInNet = showInNet;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String[] getHiddenDangerousPermissions() {
        return this.mHiddenDangerousPermissions;
    }

    public boolean isShowInNet() {
        return this.mShowInNet;
    }
}
