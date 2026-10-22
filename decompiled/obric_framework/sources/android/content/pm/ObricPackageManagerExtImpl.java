package android.content.pm;

import android.app.ActivityManager;
import android.app.ActivityThread;

/* JADX INFO: loaded from: classes.dex */
public class ObricPackageManagerExtImpl implements IObricPackageManagerExt {
    private static final String TAG = "ObricPackageManagerExtImpl";

    public ObricPackageManagerExtImpl() {
    }

    public boolean recoveryRemovableSystemApp(String scanPath, String packageName) {
        return ActivityThread.getPackageManager().getIObricExt().recoveryRemovableSystemApp(scanPath, packageName);
    L5:
        return false;
    }

    public ParceledListSlice<PackageInfo> getDeletedSystemApp() {
        return ActivityThread.getPackageManager().getIObricExt().getDeletedSystemApp();
    L5:
        return null;
    }

    public boolean isRemovableSysApp(String packageName) {
        return ActivityThread.getPackageManager().getIObricExt().isRemovableSysApp(packageName);
    L5:
        return false;
    }

    public int adjustUserId(String packageName, int userId) {
        if (isRemovableSysApp(packageName) == true) goto L5;
        return userId;
    L5:
        int userId2 = ActivityManager.getCurrentUser();
        return userId2;
    }
}
