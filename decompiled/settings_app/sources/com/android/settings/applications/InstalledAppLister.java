package com.android.settings.applications;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.UserManager;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InstalledAppLister extends AppLister {
    public InstalledAppLister(PackageManager r1, UserManager r2) {
        super(r1, r2);
    }

    @Override // com.android.settings.applications.AppLister
    protected boolean includeInCount(ApplicationInfo r2) {
        return InstalledAppCounter.includeInCount(1, this.mPm, r2);
    }
}
