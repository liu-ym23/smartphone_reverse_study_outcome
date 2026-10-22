package com.android.settings.applications;

import android.content.pm.ApplicationInfo;
import android.content.pm.UserInfo;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class UserAppInfo {
    public final ApplicationInfo appInfo;
    public final UserInfo userInfo;

    public UserAppInfo(UserInfo r1, ApplicationInfo r2) {
        this.userInfo = r1;
        this.appInfo = r2;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        UserAppInfo r6 = (UserAppInfo) r5;
        if (r6.userInfo.id != this.userInfo.id) goto L16;
        if (TextUtils.equals(r6.appInfo.packageName, this.appInfo.packageName) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.userInfo.id), this.appInfo.packageName});
    }
}
