package com.android.settings.applications;

import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class CanBeOnSdCardChecker {
    public static final String APP_CHG = "chg";
    int mInstallLocation;
    final IPackageManager mPm;

    CanBeOnSdCardChecker() {
        this.mPm = IPackageManager.Stub.asInterface(ServiceManager.getService("package"));
    }

    void init() {
        this.mInstallLocation = this.mPm.getInstallLocation();     // Catch: RemoteException -> L4
        return;
    L4:
        OLog.e("CanBeOnSdCardChecker", "Is Package Manager running?");
    }

    boolean check(ApplicationInfo r3) {
        if ((r3.flags & 262144) == 0) goto L6;
        return true;
    L6:
        if ((r3.flags & 1) == 0) goto L8;
    L13:
        return false;
    L8:
        if (r3.installLocation != 2) goto L10;
        return true;
    L10:
        if (r3.installLocation == 0) goto L17;
        int r2 = r3.installLocation;
        goto L13
    L17:
        return true;
    }
}
