package com.android.settings.bluetooth;

import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothPairingRequest extends BroadcastReceiver {
    private static final String FLAG_RECORDING_STATUS_FOR_ALARM_CLOCK = "isRecording";
    private static final String INTENT_RECORDING_STATUS_FOR_ALARM_CLOCK = "com.android.camera.videoRecord";
    private static final int NOTIFICATION_ID = 17301632;
    private static final int NOTIFY_CANCEL = 1;
    private static boolean mIsRecording = false;
    private Handler mHandler;
    private NotificationManager mNotificationMgr;

    static {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_bluetooth_BluetoothPairingRequest_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public BluetoothPairingRequest() {
        this.mNotificationMgr = null;
        this.mHandler = new AnonymousClass1(this);
    }

    static /* synthetic */ NotificationManager access$000(BluetoothPairingRequest r0) {
        return r0.mNotificationMgr;
    }

    public void com_android_settings_bluetooth_BluetoothPairingRequest__onReceive$___twin___(Context r9, Intent r10) {
        Intent r8 = com.android.settings.Utils.checkIntentVulnerability(r10);
        String r11 = r8.getAction();
        if ("android.bluetooth.device.action.PAIRING_REQUEST".equals(r11) == false) goto L13;
        BluetoothDevice r1 = (BluetoothDevice) r8.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        int r5 = r8.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", Integer.MIN_VALUE);
        Intent r6 = new Intent();
        r6.setClass(r9, BluetoothPairingDialog.class);
        r6.putExtra("android.bluetooth.device.extra.DEVICE", r1);
        r6.putExtra("android.bluetooth.device.extra.PAIRING_VARIANT", r5);
        if (r5 != 2) goto L7;
    L10:
        r6.putExtra("android.bluetooth.device.extra.PAIRING_KEY", r8.getIntExtra("android.bluetooth.device.extra.PAIRING_KEY", Integer.MIN_VALUE));
    L11:
        r6.setAction("android.bluetooth.device.action.PAIRING_REQUEST");
        r6.setFlags(268435456);
        r9.startActivity(r6);
        return;
    L7:
        if (r5 == 4) goto L10;
        if (r5 != 5) goto L11;
    L13:
        if ("android.bluetooth.device.action.PAIRING_CANCEL".equals(r11) == false) goto L19;
        Intent r12 = new Intent();
        r12.setClass(r9, BluetoothPairingDialog.class);
        r12.setAction("android.bluetooth.device.action.PAIRING_REQUEST");
        r12.setFlags(268435456);
        PendingIntent r13 = PendingIntent.getActivity(r9, 0, r12, 603979776);
        if (r13 == null) goto L17;
        r13.cancel();
    L17:
        MultiSDKAdapter.getNotificationManager(r9, 1).cancel(17301632);
        return;
    L19:
        if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(r11) == false) goto L26;
        int r14 = r8.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
        if (r8.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", Integer.MIN_VALUE) == 11) goto L23;
        return;
    L23:
        if (r14 != 10) goto L32;
        ((NotificationManager) r9.getSystemService("notification")).cancel(17301632);
        return;
    L32:
        return;
    L26:
        if (INTENT_RECORDING_STATUS_FOR_ALARM_CLOCK.equals(r11) == false) goto L34;
        mIsRecording = r8.getBooleanExtra(FLAG_RECORDING_STATUS_FOR_ALARM_CLOCK, false);
        return;
    }

    @Insert("onReceive")
    public static void com_android_settings_bluetooth_BluetoothPairingRequest_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(BluetoothPairingRequest r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        BluetoothPairingRequest r1 = r7;
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
        r7.com_android_settings_bluetooth_BluetoothPairingRequest__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_bluetooth_BluetoothPairingRequest__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_bluetooth_BluetoothPairingRequest__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_bluetooth_BluetoothPairingRequest__onReceive$___twin___(r8, r9);
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
