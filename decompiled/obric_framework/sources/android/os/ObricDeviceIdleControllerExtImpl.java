package android.os;

import android.util.Log;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ObricDeviceIdleControllerExtImpl implements IObricDeviceIdleControllerExt {
    private static final long MAX_TEMP_APP_ALLOWLIST_DURATION_MS = 3600000;
    private static final long MIN_TEMP_APP_ALLOWLIST_DURATION_MS = 60000;
    private static final String TAG = "ObricDeviceIdleControllerExtImpl";
    private static IDeviceIdleController mDeviceIdleController;

    public ObricDeviceIdleControllerExtImpl() {
    }

    private static IDeviceIdleController getService() {
        if (mDeviceIdleController != null) goto L6;
        mDeviceIdleController = IDeviceIdleController.Stub.asInterface(ServiceManager.getService("deviceidle"));
    L6:
        return mDeviceIdleController;
    }

    public boolean addToTemporaryAllowList(String[] pkgList, long timeout, String reason) {
        Log.i(TAG, "try to add " + Arrays.toString(pkgList) + " to temp white list. reason:" + reason + ", timeout:" + timeout);
        if (pkgList == null) goto L29;
        if (pkgList.length == 0) goto L29;
        if (reason != null) goto L10;
        Log.w(TAG, "reason is illegal! return.");
        return false;
    L10:
        IDeviceIdleController service = getService();
        if (service != null) goto L14;
        Log.w(TAG, "mDeviceIdleController is null! return.");
        return false;
    L14:
        long timeout2 = Math.max(Math.min(timeout, MAX_TEMP_APP_ALLOWLIST_DURATION_MS), MIN_TEMP_APP_ALLOWLIST_DURATION_MS);
        boolean isSuccess = true;
        int r14 = pkgList.length;
        int r10 = 0;
    L15:
        if (r10 >= r14) goto L27;
        String pkg = pkgList[r10];
        Log.i(TAG, "add " + pkg + " to temp white list. reason: " + reason + ", timeout:" + timeout2);     // Catch: RemoteException -> L23
        String reason2 = reason;
        service.addPowerSaveTempWhitelistApp(pkg, timeout2, 0, 0, reason2);     // Catch: RemoteException -> L21
    L26:
        r10 = r10 + 1;
        reason = reason2;
    L21:
        e = move-exception;
        RemoteException e = e;
    L25:
        Log.w(TAG, "add tempAllowList error. pkg: " + pkg, e);
        isSuccess = false;
    L23:
        e = move-exception;
        reason2 = reason;
        e = e;
        goto L25
    L27:
        return isSuccess;
    L29:
        Log.w(TAG, "pkgList is illegal! return.");
        return false;
    }

    public boolean removeFromTemporaryAllowList(String[] pkgList, String reason) {
        Log.i(TAG, "try to remove " + Arrays.toString(pkgList) + " from temp white list. reason:" + reason);
        if (pkgList != null) goto L5;
    L20:
        Log.w(TAG, "pkgList is illegal! return.");
        return false;
    L5:
        if (pkgList.length == 0) goto L20;
        IDeviceIdleController service = getService();
        if (service != null) goto L11;
        Log.w(TAG, "mDeviceIdleController is null! return.");
        return false;
    L11:
        boolean isSuccess = true;
        int r4 = pkgList.length;
        int r5 = 0;
    L12:
        if (r5 >= r4) goto L19;
        String pkg = pkgList[r5];
        service.removePowerSaveTempWhitelistApp(pkg, 0);     // Catch: RemoteException -> L16
    L18:
        r5 = r5 + 1;
    L16:
        e = move-exception;
        Log.w(TAG, "remove from tempAllowList error. pkg: " + pkg, e);
        isSuccess = false;
        goto L18
    L19:
        return isSuccess;
    }
}
