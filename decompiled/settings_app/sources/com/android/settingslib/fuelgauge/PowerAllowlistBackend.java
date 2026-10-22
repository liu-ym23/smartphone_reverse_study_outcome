package com.android.settingslib.fuelgauge;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.admin.DevicePolicyManager;
import android.app.admin.flags.Flags;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IDeviceIdleController;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.telecom.DefaultDialerManager;
import android.text.TextUtils;
import android.util.ArraySet;
import com.GlobalProxyLancet;
import com.android.internal.telephony.SmsApplication;
import com.android.internal.util.ArrayUtils;

/* JADX INFO: loaded from: classes.dex */
public class PowerAllowlistBackend {
    private static final boolean DEFAULT_SYSTEM_EXEMPT_POWER_RESTRICTIONS_ENABLED = true;
    private static final String DEVICE_IDLE_SERVICE = "deviceidle";
    private static final String SYSTEM_EXEMPT_POWER_RESTRICTIONS_ENABLED = "system_exempt_power_restrictions_enabled";
    private static final String TAG = "PowerAllowlistBackend";
    private static PowerAllowlistBackend sInstance;
    private final ArraySet<String> mAllowlistedApps;
    private final Object mAllowlistedAppsLock;
    private final Context mAppContext;
    private final ArraySet<String> mDefaultActiveApps;
    private final Object mDefaultActiveAppsLock;
    private final IDeviceIdleController mDeviceIdleService;
    private final ArraySet<String> mSysAllowlistedApps;
    private final Object mSysAllowlistedAppsLock;

    PowerAllowlistBackend(Context r2) {
        this(r2, IDeviceIdleController.Stub.asInterface(ServiceManager.getService(DEVICE_IDLE_SERVICE)));
    }

    PowerAllowlistBackend(Context r2, IDeviceIdleController r3) {
        this.mAllowlistedAppsLock = new Object();
        this.mSysAllowlistedAppsLock = new Object();
        this.mDefaultActiveAppsLock = new Object();
        this.mAllowlistedApps = new ArraySet();
        this.mSysAllowlistedApps = new ArraySet();
        this.mDefaultActiveApps = new ArraySet();
        this.mAppContext = r2.getApplicationContext();
        this.mDeviceIdleService = r3;
        refreshList();
    }

    public int getAllowlistSize() {
        Object r0 = this.mAllowlistedAppsLock;
        monitor-enter(r0);
        int r1 = this.mAllowlistedApps.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isSysAllowlisted(String r2) {
        Object r0 = this.mSysAllowlistedAppsLock;
        monitor-enter(r0);
        boolean r1 = this.mSysAllowlistedApps.contains(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isAllowlisted(String r4, int r5) {
        Object r0 = this.mAllowlistedAppsLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mAllowlistedApps.contains(r4) == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (isDefaultActiveApp(r4, r5) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean isDefaultActiveApp(String r4, int r5) {
        Object r0 = this.mDefaultActiveAppsLock;
        monitor-enter(r0);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.mDefaultActiveApps.contains(r4) == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L24
        return true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L24
        if (((DevicePolicyManager) this.mAppContext.getSystemService(DevicePolicyManager.class)).packageHasActiveAdmins(r4) == false) goto L12;
        return true;
    L12:
        AppOpsManager r1 = (AppOpsManager) this.mAppContext.getSystemService(AppOpsManager.class);
        if (isSystemExemptFlagEnabled() == false) goto L18;
        if (r1.checkOpNoThrow(128, r5, r4) != 0) goto L18;
        return true;
    L18:
        if (Flags.disallowUserControlBgUsageFix() == false) goto L22;
        int r6 = UserHandle.getUserId(r5);
        if (this.mAppContext.getPackageManager().isPackageStateProtected(r4, r6) == false) goto L28;
        return true;
    L28:
        return false;
    L22:
        return false;
    }

    private static boolean isSystemExemptFlagEnabled() {
        return DeviceConfig.getBoolean("activity_manager", SYSTEM_EXEMPT_POWER_RESTRICTIONS_ENABLED, true);
    }

    public boolean isAllowlistedExceptIdle(String r2) {
        return this.mDeviceIdleService.isPowerSaveWhitelistExceptIdleApp(r2);
    L4:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Unable to reach IDeviceIdleController", e);
        return true;
    }

    public boolean isAllowlisted(String[] r5, int r6) {
        if (ArrayUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        int r0 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L12;
        if (isAllowlisted(r5[r2], r6) == true) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public void addApp(String r2) {
        addApp(r2, -1);
    }

    public synchronized void addApp(String r11, int r12) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L21:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Unable to find package", e);     // Catch: Throwable -> L19
    L25:
        monitor-exit(this);
        return;
    L23:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Unable to reach IDeviceIdleController", e);     // Catch: Throwable -> L19
        goto L25
    L4:
        if (android.app.Flags.appRestrictionsApi() == true) goto L6;
    L11:
        this.mDeviceIdleService.addPowerSaveWhitelistApp(r11);     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21 RemoteException -> L23
        Object r13 = this.mAllowlistedAppsLock;     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21 RemoteException -> L23
        monitor-enter(r13);     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21 RemoteException -> L23
        this.mAllowlistedApps.add(r11);     // Catch: Throwable -> L16
        monitor-exit(r13);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21 RemoteException -> L23
    L6:
        if (r12 != (-1)) goto L8;
        r12 = ((PackageManager) this.mAppContext.getSystemService(PackageManager.class)).getPackageUid(r11, 0);     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21 RemoteException -> L23
    L8:
        int r2 = r12;
        if (isAllowlisted(r11, r2) == true) goto L11;
        ((ActivityManager) this.mAppContext.getSystemService(ActivityManager.class)).noteAppRestrictionEnabled(r11, r2, 20, true, 4, "settings", 1, 0);     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21 RemoteException -> L23
        goto L11
    }

    public void removeApp(String r2) {
        removeApp(r2, -1);
    }

    public synchronized void removeApp(String r11, int r12) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L21:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Unable to find package", e);     // Catch: Throwable -> L19
    L25:
        monitor-exit(this);
        return;
    L23:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "Unable to reach IDeviceIdleController", e);     // Catch: Throwable -> L19
        goto L25
    L4:
        if (android.app.Flags.appRestrictionsApi() == true) goto L6;
    L11:
        this.mDeviceIdleService.removePowerSaveWhitelistApp(r11);     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21 RemoteException -> L23
        Object r13 = this.mAllowlistedAppsLock;     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21 RemoteException -> L23
        monitor-enter(r13);     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21 RemoteException -> L23
        this.mAllowlistedApps.remove(r11);     // Catch: Throwable -> L16
        monitor-exit(r13);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21 RemoteException -> L23
    L6:
        if (r12 != (-1)) goto L8;
        r12 = ((PackageManager) this.mAppContext.getSystemService(PackageManager.class)).getPackageUid(r11, 0);     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21 RemoteException -> L23
    L8:
        int r2 = r12;
        if (isAllowlisted(r11, r2) == false) goto L11;
        ((ActivityManager) this.mAppContext.getSystemService(ActivityManager.class)).noteAppRestrictionEnabled(r11, r2, 20, false, 4, "settings", 1, 0);     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21 RemoteException -> L23
        goto L11
    }

    public synchronized void refreshList() {
        monitor-enter(this);
        Object r0 = this.mSysAllowlistedAppsLock;     // Catch: Throwable -> L71
        monitor-enter(r0);     // Catch: Throwable -> L71
        this.mSysAllowlistedApps.clear();     // Catch: Throwable -> L68
        monitor-exit(r0);     // Catch: Throwable -> L68
        Object r1 = this.mAllowlistedAppsLock;     // Catch: Throwable -> L71
        monitor-enter(r1);     // Catch: Throwable -> L71
        this.mAllowlistedApps.clear();     // Catch: Throwable -> L65
        monitor-exit(r1);     // Catch: Throwable -> L65
        Object r2 = this.mDefaultActiveAppsLock;     // Catch: Throwable -> L71
        monitor-enter(r2);     // Catch: Throwable -> L71
        this.mDefaultActiveApps.clear();     // Catch: Throwable -> L62
        monitor-exit(r2);     // Catch: Throwable -> L62
        IDeviceIdleController r3 = this.mDeviceIdleService;     // Catch: Throwable -> L71
        if (r3 != null) goto L84;
        monitor-exit(this);
        return;
    L84:
        String[] r4 = r3.getFullPowerWhitelist();     // Catch: Exception -> L58 Throwable -> L71
        Object r5 = this.mAllowlistedAppsLock;     // Catch: Exception -> L58 Throwable -> L71
        monitor-enter(r5);     // Catch: Exception -> L58 Throwable -> L71
        int r6 = r4.length;     // Catch: Throwable -> L55
        int r7 = 0;
        int r8 = 0;
    L22:
        if (r8 >= r6) goto L24;
        this.mAllowlistedApps.add(r4[r8]);     // Catch: Throwable -> L55
        r8 = r8 + 1;     // Catch: Throwable -> L55
        goto L22
    L24:
        monitor-exit(r5);     // Catch: Throwable -> L55
        String[] r9 = this.mDeviceIdleService.getSystemPowerWhitelist();     // Catch: Exception -> L58 Throwable -> L71
        Object r10 = this.mSysAllowlistedAppsLock;     // Catch: Exception -> L58 Throwable -> L71
        monitor-enter(r10);     // Catch: Exception -> L58 Throwable -> L71
        int r11 = r9.length;     // Catch: Throwable -> L52
    L28:
        if (r7 >= r11) goto L30;
        this.mSysAllowlistedApps.add(r9[r7]);     // Catch: Throwable -> L52
        r7 = r7 + 1;     // Catch: Throwable -> L52
        goto L28
    L30:
        monitor-exit(r10);     // Catch: Throwable -> L52
        boolean r12 = this.mAppContext.getPackageManager().hasSystemFeature("android.hardware.telephony");     // Catch: Exception -> L58 Throwable -> L71
        ComponentName r13 = SmsApplication.getDefaultSmsApplication(this.mAppContext, true);     // Catch: Exception -> L58 Throwable -> L71
        String r14 = DefaultDialerManager.getDefaultDialerApplication(this.mAppContext);     // Catch: Exception -> L58 Throwable -> L71
        if (r12 == false) goto L60;
        if (r13 == null) goto L43;
        Object r15 = this.mDefaultActiveAppsLock;     // Catch: Exception -> L58 Throwable -> L71
        monitor-enter(r15);     // Catch: Exception -> L58 Throwable -> L71
        this.mDefaultActiveApps.add(r13.getPackageName());     // Catch: Throwable -> L39
        monitor-exit(r15);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        throw th;     // Catch: Exception -> L58 Throwable -> L71
    L43:
        if (TextUtils.isEmpty(r14) == true) goto L60;
        Object r16 = this.mDefaultActiveAppsLock;     // Catch: Exception -> L58 Throwable -> L71
        monitor-enter(r16);     // Catch: Exception -> L58 Throwable -> L71
        this.mDefaultActiveApps.add(r14);     // Catch: Throwable -> L49
        monitor-exit(r16);     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;     // Catch: Exception -> L58 Throwable -> L71
    L60:
        monitor-exit(this);
        return;
    L52:
        th = move-exception;
        throw th;     // Catch: Exception -> L58 Throwable -> L71
    L55:
        th = move-exception;
        throw th;     // Catch: Exception -> L58 Throwable -> L71
    L58:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Failed to invoke refreshList()", e);     // Catch: Throwable -> L71
        goto L60
    L62:
        th = move-exception;
        throw th;     // Catch: Throwable -> L71
    L65:
        th = move-exception;
        throw th;     // Catch: Throwable -> L71
    L68:
        th = move-exception;
        throw th;     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        throw th;
    }

    public static PowerAllowlistBackend getInstance(Context r2) {
        monitor-enter(PowerAllowlistBackend.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new PowerAllowlistBackend(r2);     // Catch: Throwable -> L10
    L7:
        PowerAllowlistBackend r3 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(PowerAllowlistBackend.class);     // Catch: Throwable -> L10
        return r3;
    }
}
