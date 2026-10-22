package com.bytedanceos.security.permission;

/* JADX INFO: loaded from: classes2.dex */
public final class Permission {
    private final String mAppOp;
    private boolean mAppOpAllowed;
    private int mFlags;
    private boolean mGranted;
    private boolean mIsEphemeral;
    private boolean mIsRuntimeOnly;
    private final String mName;

    public Permission(String name, boolean granted, String appOp, boolean appOpAllowed, int flags, int protectionLevel) {
        this.mName = name;
        this.mGranted = granted;
        this.mAppOp = appOp;
        this.mAppOpAllowed = appOpAllowed;
        this.mFlags = flags;
        boolean r2 = true;
        if ((protectionLevel & 4096) == 0) goto L5;
        boolean r1 = true;
    L6:
        this.mIsEphemeral = r1;
        if ((protectionLevel & 8192) != 0) goto L10;
        r2 = false;
    L10:
        this.mIsRuntimeOnly = r2;
        return;
    L5:
        r1 = false;
        goto L6
    }

    public String getName() {
        return this.mName;
    }

    public String getAppOp() {
        return this.mAppOp;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public boolean hasAppOp() {
        if (this.mAppOp == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isGranted() {
        return this.mGranted;
    }

    public boolean isReviewRequired() {
        if ((this.mFlags & 64) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void resetReviewRequired() {
        this.mFlags &= -65;
    }

    public void setGranted(boolean mGranted) {
        this.mGranted = mGranted;
    }

    public boolean isAppOpAllowed() {
        return this.mAppOpAllowed;
    }

    public boolean isUserFixed() {
        if ((this.mFlags & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setUserFixed(boolean userFixed) {
        if (userFixed == false) goto L4;
        this.mFlags |= 2;
        return;
    L4:
        this.mFlags &= -3;
    }

    public boolean isSystemFixed() {
        if ((this.mFlags & 16) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isUserSet() {
        if ((this.mFlags & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public void setUserSet(boolean userSet) {
        if (userSet == false) goto L4;
        this.mFlags |= 1;
        return;
    L4:
        this.mFlags &= -2;
    }

    public boolean shouldRevokeOnUpgrade() {
        if ((this.mFlags & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setRevokeOnUpgrade(boolean revokeOnUpgrade) {
        if (revokeOnUpgrade == false) goto L4;
        this.mFlags |= 8;
        return;
    L4:
        this.mFlags &= -9;
    }

    public void setAppOpAllowed(boolean mAppOpAllowed) {
        this.mAppOpAllowed = mAppOpAllowed;
    }

    public boolean isEphemeral() {
        return this.mIsEphemeral;
    }

    public boolean isRuntimeOnly() {
        return this.mIsRuntimeOnly;
    }

    public boolean isGrantingAllowed(boolean isEphemeralApp, boolean supportsRuntimePermissions) {
        if (isEphemeralApp == true) goto L4;
    L5:
        if (supportsRuntimePermissions == false) goto L7;
    L10:
        return true;
    L7:
        if (isRuntimeOnly() == false) goto L10;
    L9:
        return false;
    L4:
        if (isEphemeral() == false) goto L9;
        goto L5
    }
}
