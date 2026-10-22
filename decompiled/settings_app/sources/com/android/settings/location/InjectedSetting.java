package com.android.settings.location;

import android.content.Intent;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.util.Preconditions;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
class InjectedSetting {
    public final String className;
    public final int iconId;
    public final UserHandle mUserHandle;
    public final String packageName;
    public final String settingsActivity;
    public final String title;

    private InjectedSetting(String r2, String r3, String r4, int r5, UserHandle r6, String r7) {
        this.packageName = (String) Preconditions.checkNotNull(r2, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        this.className = (String) Preconditions.checkNotNull(r3, "className");
        this.title = (String) Preconditions.checkNotNull(r4, "title");
        this.iconId = r5;
        this.mUserHandle = r6;
        this.settingsActivity = (String) Preconditions.checkNotNull(r7);
    }

    public static InjectedSetting newInstance(String r8, String r9, String r10, int r11, UserHandle r12, String r13) {
        if (r8 == null) goto L12;
        if (r9 == null) goto L12;
        if (TextUtils.isEmpty(r10) == true) goto L12;
        if (TextUtils.isEmpty(r13) == true) goto L12;
        return new InjectedSetting(r8, r9, r10, r11, r12, r13);
    L12:
        if (Log.isLoggable("SettingsInjector", 5) == false) goto L16;
        OLog.w("SettingsInjector", "Illegal setting specification: package=" + r8 + ", class=" + r9 + ", title=" + r10 + ", settingsActivity=" + r13);
        return null;
    L16:
        return null;
    }

    public String toString() {
        return "InjectedSetting{mPackageName='" + this.packageName + "', mClassName='" + this.className + "', label=" + this.title + ", iconId=" + this.iconId + ", userId=" + this.mUserHandle.getIdentifier() + ", settingsActivity='" + this.settingsActivity + "'}";
    }

    public Intent getServiceIntent() {
        Intent r0 = new Intent();
        r0.setClassName(this.packageName, this.className);
        return r0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof InjectedSetting) == true) goto L8;
        return false;
    L8:
        InjectedSetting r6 = (InjectedSetting) r5;
        if (this.packageName.equals(r6.packageName) == false) goto L22;
        if (this.className.equals(r6.className) == false) goto L22;
        if (this.title.equals(r6.title) == false) goto L22;
        if (this.iconId != r6.iconId) goto L22;
        if (this.mUserHandle.equals(r6.mUserHandle) == false) goto L22;
        if (this.settingsActivity.equals(r6.settingsActivity) == false) goto L22;
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        return (((((((((this.packageName.hashCode() * 31) + this.className.hashCode()) * 31) + this.title.hashCode()) * 31) + this.iconId) * 31) + this.mUserHandle.hashCode()) * 31) + this.settingsActivity.hashCode();
    }
}
