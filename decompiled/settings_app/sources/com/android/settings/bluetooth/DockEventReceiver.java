package com.android.settings.bluetooth;

import android.app.Application;
import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.PowerManager;
import com.android.settings.AdaptBluetoothDevice;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public final class DockEventReceiver extends BroadcastReceiver {
    public static final String ACTION_DOCK_SHOW_UI = "com.android.settings.bluetooth.action.DOCK_SHOW_UI";
    private static final boolean DEBUG = false;
    private static final int EXTRA_INVALID = -1234;
    private static final String TAG = "DockEventReceiver";
    private static PowerManager.WakeLock sStartingService;
    private static final Object sStartingServiceSync = null;
    private Handler mH;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_bluetooth_DockEventReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public DockEventReceiver() {
        this.mH = new Handler();
    }

    static {
        DEBUG = DockService.DEBUG;
        sStartingServiceSync = new Object();
    }

    public void com_android_settings_bluetooth_DockEventReceiver__onReceive$___twin___(final Context r10, Intent r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r11.getAction() == null) goto L64;
        int r0 = r11.getIntExtra("android.intent.extra.DOCK_STATE", r11.getIntExtra("android.bluetooth.adapter.extra.STATE", EXTRA_INVALID));
        BluetoothDevice r2 = (BluetoothDevice) r11.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        boolean r3 = DEBUG;
        if (r3 == false) goto L14;
        StringBuilder r5 = new StringBuilder("Action: ").append(r11.getAction()).append(" State:").append(r0).append(" Device: ");
        if (r2 != null) goto L11;
        String r6 = "null";
    L12:
        OLog.d(TAG, r5.append(r6).toString());
        goto L14
    L11:
        r6 = AdaptBluetoothDevice.getDeviceAliasName(r2);
    L14:
        if ("android.intent.action.DOCK_EVENT".equals(r11.getAction()) == false) goto L16;
    L36:
        if (r2 == null) goto L38;
    L44:
        if (r0 != 0) goto L46;
    L52:
        Intent r9 = new Intent(r11);
        r9.setClass(r10, DockService.class);
        beginStartingService(r10, r9);
        return;
    L46:
        if (r0 == 1) goto L52;
        if (r0 == 2) goto L52;
        if (r0 == 3) goto L52;
        if (r0 == 4) goto L52;
        OLog.e(TAG, "Unknown state: " + r0);
        return;
    L38:
        if (ACTION_DOCK_SHOW_UI.endsWith(r11.getAction()) == true) goto L41;
        if (r0 == 0) goto L44;
        if (r0 == 3) goto L44;
    L41:
        if (r3 == false) goto L55;
        OLog.d(TAG, "Wrong state: " + r0 + " or intent: " + r11.toString() + " with null device");
        return;
    L55:
        return;
    L16:
        if (ACTION_DOCK_SHOW_UI.endsWith(r11.getAction()) == true) goto L36;
        if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(r11.getAction()) == false) goto L21;
    L28:
        int r12 = r11.getIntExtra("android.bluetooth.profile.extra.STATE", 2);
        int r1 = r11.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", 0);
        if (r2 != null) goto L33;
        if (r3 == false) goto L54;
        OLog.d(TAG, "Device is missing");
        return;
    L54:
        return;
    L33:
        if (r12 != 0) goto L60;
        if (r1 == 3) goto L61;
        Intent r13 = new Intent(r11);
        r13.setClass(r10, DockService.class);
        beginStartingService(r10, r13);
        return;
    L61:
        return;
    L60:
        return;
    L21:
        if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(r11.getAction()) == true) goto L28;
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(r11.getAction()) == true) goto L26;
        return;
    L26:
        if (r11.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 11) goto L58;
        final Intent r4 = new Intent(r11);
        r4.setClass(r10, DockService.class);
        this.mH.post(new DockEventReceiver$$ExternalSyntheticLambda0(r10, r4));
        return;
    L58:
        return;
    }

    static /* synthetic */ void lambda$onReceive$0(Context r0, Intent r1) {
        beginStartingService(r0, r1);
    }

    private static void beginStartingService(Context r4, Intent r5) {
        Object r0 = sStartingServiceSync;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sStartingService != null) goto L7;
        sStartingService = ((PowerManager) r4.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).newWakeLock(1, "StartingDockService");     // Catch: Throwable -> L12
    L7:
        sStartingService.acquire();     // Catch: Throwable -> L12
        if (r4.startService(r5) != null) goto L10;
        OLog.e(TAG, "Can't start DockService");     // Catch: Throwable -> L12
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public static void finishStartingService(Service r6, int r7) {
        Object r2 = sStartingServiceSync;
        monitor-enter(r2);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (sStartingService == null) goto L17;
        boolean r3 = DEBUG;     // Catch: Throwable -> L19
        if (r3 == false) goto L10;
        OLog.d(TAG, "stopSelf id = " + r7);     // Catch: Throwable -> L19
    L10:
        if (r6.stopSelfResult(r7) == false) goto L13;
        OLog.d(TAG, "finishStartingService: stopping service");     // Catch: Throwable -> L19
    L13:
        if (sStartingService.isHeld() == false) goto L17;
        if (r3 == false) goto L16;
        OLog.d(TAG, "unlock id = " + r7);     // Catch: Throwable -> L19
    L16:
        sStartingService.release();     // Catch: Throwable -> L19
    L17:
        monitor-exit(r2);     // Catch: Throwable -> L19
    }

    @Insert("onReceive")
    public static void com_android_settings_bluetooth_DockEventReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(DockEventReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        DockEventReceiver r1 = r7;
        String r2 = r1.getClass().getName();
        String r3 = r1.getClass().getSimpleName();
        boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
        String r5 = null;
        if (r9 == null) goto L5;
        String r6 = r9.getAction();
    L7:
        if (ArraysKt.contains(r0, r6) == false) goto L13;
        StringBuilder r10 = new StringBuilder("onReceive allowList ");
        if (r9 == null) goto L11;
        r5 = r9.getAction();
    L11:
        OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
        r7.com_android_settings_bluetooth_DockEventReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_bluetooth_DockEventReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_bluetooth_DockEventReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_bluetooth_DockEventReceiver__onReceive$___twin___(r8, r9);
        return;
    L19:
        if (r13.length() == 0) goto L22;
        r14 = false;
        goto L23
    L5:
        r6 = null;
        goto L7
    }
}
