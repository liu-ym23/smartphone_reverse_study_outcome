package com.android.launcher3.util;

import android.os.UserHandle;

/* JADX INFO: loaded from: classes.dex */
public class UserIconInfo {
    public static final int TYPE_CLONED = 2;
    public static final int TYPE_MAIN = 0;
    public static final int TYPE_PRIVATE = 3;
    public static final int TYPE_WORK = 1;
    public final int type;
    public final UserHandle user;
    public final long userSerial;

    public @interface UserType {
    }

    public UserIconInfo(UserHandle r3, int r4) {
        if (r3 == null) goto L4;
        long r0 = r3.hashCode();
    L5:
        this(r3, r4, r0);
        return;
    L4:
        r0 = 0;
        goto L5
    }

    public UserIconInfo(UserHandle r1, int r2, long r3) {
        this.user = r1;
        this.type = r2;
        this.userSerial = r3;
    }

    public boolean isMain() {
        if (this.type != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isWork() {
        if (this.type == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isCloned() {
        if (this.type != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPrivate() {
        if (this.type != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public FlagOp applyBitmapInfoFlags(FlagOp r3) {
        return r3.setFlag(1, isWork()).setFlag(4, isCloned()).setFlag(8, isPrivate());
    }
}
