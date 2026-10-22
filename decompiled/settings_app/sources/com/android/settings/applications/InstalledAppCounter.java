package com.android.settings.applications;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.FeatureFlags;
import android.content.pm.FeatureFlagsImpl;
import android.content.pm.PackageManager;
import android.os.UserHandle;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InstalledAppCounter extends AppCounter {
    public static final int IGNORE_INSTALL_REASON = -1;
    private final int mInstallReason;

    public InstalledAppCounter(Context r2, int r3, PackageManager r4) {
        this(r2, r3, r4, new FeatureFlagsImpl());
    }

    InstalledAppCounter(Context r1, int r2, PackageManager r3, FeatureFlags r4) {
        super(r1, r3, r4);
        this.mInstallReason = r2;
    }

    @Override // com.android.settings.applications.AppCounter
    protected boolean includeInCount(ApplicationInfo r2) {
        return includeInCount(this.mInstallReason, this.mPm, r2);
    }

    public static boolean includeInCount(int r5, PackageManager r6, ApplicationInfo r7) {
        int r0 = UserHandle.getUserId(r7.uid);
        if (r5 == (-1)) goto L8;
        if (r6.getInstallReason(r7.packageName, new UserHandle(r0)) == r5) goto L8;
        return false;
    L8:
        if ((r7.flags & 128) == 0) goto L11;
        return true;
    L11:
        if ((r7.flags & 1) != 0) goto L13;
        return true;
    L13:
        List r8 = r6.queryIntentActivitiesAsUser(new Intent("android.intent.action.MAIN", null).addCategory("android.intent.category.LAUNCHER").setPackage(r7.packageName), 786944, r0);
        if (r8 != null) goto L16;
        return false;
    L16:
        if (r8.size() != 0) goto L18;
        return false;
    L18:
        return true;
    }
}
