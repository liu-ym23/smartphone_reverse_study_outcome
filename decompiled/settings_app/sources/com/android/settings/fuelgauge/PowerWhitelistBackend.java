package com.android.settings.fuelgauge;

import android.os.IDeviceIdleController;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.ArraySet;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class PowerWhitelistBackend {
    private static final String DEVICE_IDLE_SERVICE = "deviceidle";
    private static final PowerWhitelistBackend INSTANCE = null;
    private static final String TAG = "PowerWhitelistBackend";
    private final IDeviceIdleController mDeviceIdleService;
    private final ArraySet<String> mSysWhitelistedApps;
    private final ArraySet<String> mWhitelistedApps;

    static {
        INSTANCE = new PowerWhitelistBackend();
    }

    public PowerWhitelistBackend() {
        this.mWhitelistedApps = new ArraySet();
        this.mSysWhitelistedApps = new ArraySet();
        this.mDeviceIdleService = IDeviceIdleController.Stub.asInterface(ServiceManager.getService(DEVICE_IDLE_SERVICE));
        refreshList();
    }

    public int getWhitelistSize() {
        return this.mWhitelistedApps.size();
    }

    public boolean isSysWhitelisted(String r1) {
        return this.mSysWhitelistedApps.contains(r1);
    }

    public boolean isWhitelisted(String r1) {
        return this.mWhitelistedApps.contains(r1);
    }

    public void addApp(String r2) {
        this.mDeviceIdleService.addPowerSaveWhitelistApp(r2);     // Catch: RemoteException -> L4
        this.mWhitelistedApps.add(r2);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        OLog.w(TAG, "Unable to reach IDeviceIdleController", e);
    }

    public void removeApp(String r2) {
        this.mDeviceIdleService.removePowerSaveWhitelistApp(r2);     // Catch: RemoteException -> L4
        this.mWhitelistedApps.remove(r2);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        OLog.w(TAG, "Unable to reach IDeviceIdleController", e);
    }

    private void refreshList() {
        this.mSysWhitelistedApps.clear();
        this.mWhitelistedApps.clear();
        String[] r0 = this.mDeviceIdleService.getFullPowerWhitelist();     // Catch: RemoteException -> L10
        int r1 = r0.length;     // Catch: RemoteException -> L10
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L6;
        this.mWhitelistedApps.add(r0[r3]);     // Catch: RemoteException -> L10
        r3 = r3 + 1;     // Catch: RemoteException -> L10
        goto L4
    L6:
        String[] r4 = this.mDeviceIdleService.getSystemPowerWhitelist();     // Catch: RemoteException -> L10
        int r5 = r4.length;     // Catch: RemoteException -> L10
    L7:
        if (r2 >= r5) goto L17;
        this.mSysWhitelistedApps.add(r4[r2]);     // Catch: RemoteException -> L10
        r2 = r2 + 1;
        goto L7
    L17:
        return;
    L10:
        e = move-exception;
        OLog.w(TAG, "Unable to reach IDeviceIdleController", e);
    }

    public static PowerWhitelistBackend getInstance() {
        return INSTANCE;
    }
}
