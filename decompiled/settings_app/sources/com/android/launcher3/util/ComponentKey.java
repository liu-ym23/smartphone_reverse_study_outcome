package com.android.launcher3.util;

import android.content.ComponentName;
import android.os.UserHandle;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ComponentKey {
    public final ComponentName componentName;
    private final int mHashCode;
    public final UserHandle user;

    public ComponentKey(ComponentName r3, UserHandle r4) {
        if (r3 == null) goto L8;
        if (r4 == null) goto L8;
        this.componentName = r3;
        this.user = r4;
        this.mHashCode = Arrays.hashCode(new Object[]{r3, r4});
        return;
    L8:
        throw null;
    }

    public int hashCode() {
        return this.mHashCode;
    }

    public boolean equals(Object r3) {
        ComponentKey r4 = (ComponentKey) r3;
        if (r4.componentName.equals(this.componentName) == true) goto L5;
    L7:
        return false;
    L5:
        if (r4.user.equals(this.user) == false) goto L7;
        return true;
    }

    public String toString() {
        return this.componentName.flattenToString() + "#" + this.user.hashCode();
    }

    public static ComponentKey fromString(String r4) {
        int r0 = r4.indexOf(35);
        if (r0 < 0) goto L12;
        int r2 = r0 + 1;
        if (r2 >= r4.length()) goto L12;
        ComponentName r1 = ComponentName.unflattenFromString(r4.substring(0, r0));
        if (r1 != null) goto L14;
        return null;
    L14:
        return new ComponentKey(r1, UserHandle.getUserHandleForUid(Integer.parseInt(r4.substring(r2))));
    L12:
        return null;
    }
}
