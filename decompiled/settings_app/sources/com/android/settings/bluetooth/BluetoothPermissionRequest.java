package com.android.settings.bluetooth;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.os.PowerManager;
import com.android.settings.AdaptBluetoothDevice;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.utils.NullSafe;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothPermissionRequest extends BroadcastReceiver {
    private static final int NOTIFICATION_ID = 17301632;
    private static final String NOTIFICATION_TAG_MAP = "Message Access";
    private static final String NOTIFICATION_TAG_PBAP = "Phonebook Access";
    private static final String NOTIFICATION_TAG_SAP = "SIM Access";
    private static final String TAG = "BluetoothPermissionRequest";
    Context mContext;
    BluetoothDevice mDevice;
    int mRequestType;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_bluetooth_BluetoothPermissionRequest_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public BluetoothPermissionRequest() {
    }

    public void com_android_settings_bluetooth_BluetoothPermissionRequest__onReceive$___twin___(Context r10, Intent r11) {
        this.mContext = r10;
        String r0 = r11.getAction();
        OLog.d(TAG, "onReceive" + r0);
        if (r0.equals("android.bluetooth.device.action.CONNECTION_ACCESS_REQUEST") == false) goto L32;
        Parcelable r7 = r11.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (r7 == null) goto L7;
        this.mDevice = (BluetoothDevice) r7;
    L7:
        NullSafe.nonNull(this.mDevice);
        this.mRequestType = r11.getIntExtra("android.bluetooth.device.extra.ACCESS_REQUEST_TYPE", 1);
        OLog.d(TAG, "onReceive request type: " + this.mRequestType);
        if (checkUserChoice() == false) goto L10;
        return;
    L10:
        Intent r12 = new Intent(r0);
        r12.setClass(r10, BluetoothPermissionActivity.class);
        r12.setFlags(402653184);
        r12.setType(Integer.toString(this.mRequestType));
        r12.putExtra("android.bluetooth.device.extra.ACCESS_REQUEST_TYPE", this.mRequestType);
        r12.putExtra("android.bluetooth.device.extra.DEVICE", this.mDevice);
        BluetoothDevice r1 = this.mDevice;
        if (r1 == null) goto L14;
        r1.getAddress();
    L14:
        if (((PowerManager) r10.getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK)).isScreenOn() == false) goto L16;
        r10.startActivity(r12);
        return;
    L16:
        Intent r2 = new Intent("android.bluetooth.device.action.CONNECTION_ACCESS_REPLY");
        r2.setPackage("com.android.bluetooth");
        r2.putExtra("android.bluetooth.device.extra.DEVICE", this.mDevice);
        r2.putExtra("android.bluetooth.device.extra.CONNECTION_ACCESS_RESULT", 2);
        r2.putExtra("android.bluetooth.device.extra.ACCESS_REQUEST_TYPE", this.mRequestType);
        BluetoothDevice r3 = this.mDevice;
        if (r3 == null) goto L19;
        String r4 = AdaptBluetoothDevice.getDeviceAliasName(r3);
    L20:
        int r5 = this.mRequestType;
        if (r5 != 2) goto L23;
        String r6 = r10.getString(R.string.bluetooth_phonebook_request);
        String r8 = r10.getString(R.string.bluetooth_pb_acceptance_dialog_text, new Object[]{r4, r4});
    L30:
        Notification r13 = new Notification.Builder(r10).setContentTitle(r6).setTicker(r8).setContentText(r8).setSmallIcon(17301632).setAutoCancel(true).setPriority(2).setOnlyAlertOnce(false).setDefaults(-1).setContentIntent(PendingIntent.getActivity(r10, 0, r12, 201326592)).setDeleteIntent(PendingIntent.getBroadcast(r10, 0, r2, 201326592)).build();
        r13.flags |= 32;
        ((NotificationManager) r10.getSystemService("notification")).notify(getNotificationTag(this.mRequestType), 17301632, r13);
        return;
    L23:
        if (r5 != 3) goto L25;
        r6 = r10.getString(R.string.bluetooth_map_request);
        r8 = r10.getString(R.string.bluetooth_map_acceptance_dialog_text, new Object[]{r4, r4});
        goto L30
    L25:
        if (r5 == 4) goto L27;
        r6 = r10.getString(R.string.bluetooth_connection_permission_request);
        r8 = r10.getString(R.string.bluetooth_connection_dialog_text, new Object[]{r4, r4});
        goto L30
    L27:
        r6 = r10.getString(R.string.bluetooth_sap_request);
        r8 = r10.getString(R.string.bluetooth_sap_acceptance_dialog_text, new Object[]{r4, r4});
        goto L30
    L19:
        r4 = null;
        goto L20
    L32:
        if (r0.equals("android.bluetooth.device.action.CONNECTION_ACCESS_CANCEL") == false) goto L37;
        NotificationManager r14 = (NotificationManager) r10.getSystemService("notification");
        int r15 = r11.getIntExtra("android.bluetooth.device.extra.ACCESS_REQUEST_TYPE", 2);
        this.mRequestType = r15;
        r14.cancel(getNotificationTag(r15), 17301632);
        return;
    }

    private String getNotificationTag(int r2) {
        if (r2 != 2) goto L6;
        return NOTIFICATION_TAG_PBAP;
    L6:
        int r1 = this.mRequestType;
        if (r1 != 3) goto L11;
        return NOTIFICATION_TAG_MAP;
    L11:
        if (r1 != 4) goto L14;
        return NOTIFICATION_TAG_SAP;
    L14:
        return null;
    }

    private boolean checkUserChoice() {
        int r0 = this.mRequestType;
        boolean r3 = false;
        if (r0 == 2) goto L9;
        if (r0 == 3) goto L9;
        if (r0 == 4) goto L9;
        OLog.d(TAG, "checkUserChoice(): Unknown RequestType " + this.mRequestType);
        return false;
    L9:
        LocalBluetoothManager r1 = LocalBluetoothManager.getInstance(this.mContext);
        CachedBluetoothDeviceManager r5 = r1.getCachedDeviceManager();
        CachedBluetoothDevice r6 = r5.findDevice(this.mDevice);
        if (r6 != null) goto L12;
        r6 = r5.addDevice(r1.getBluetoothAdapter(), r1.getProfileManager(), this.mDevice);
    L12:
        int r2 = this.mRequestType;
        if (r2 != 2) goto L23;
        int r4 = r6.getPhonebookPermissionChoice();
        if (r4 != 0) goto L17;
        return false;
    L17:
        if (r4 != 1) goto L20;
        sendIntentToReceiver("android.bluetooth.device.action.CONNECTION_ACCESS_REPLY", true, "android.bluetooth.device.extra.ALWAYS_ALLOWED", true);
    L19:
        r3 = true;
    L32:
        OLog.d(TAG, "checkUserChoice(): returning " + r3);
        return r3;
    L20:
        if (r4 != 2) goto L22;
        sendIntentToReceiver("android.bluetooth.device.action.CONNECTION_ACCESS_REPLY", false, null, false);
        goto L19
    L22:
        OLog.e(TAG, "Bad phonebookPermission: " + r4);
        goto L32
    L23:
        if (r2 != 3) goto L32;
        int r7 = r6.getMessagePermissionChoice();
        if (r7 != 0) goto L27;
        return false;
    L27:
        if (r7 != 1) goto L29;
        sendIntentToReceiver("android.bluetooth.device.action.CONNECTION_ACCESS_REPLY", true, "android.bluetooth.device.extra.ALWAYS_ALLOWED", true);
        goto L19
    L29:
        if (r7 != 2) goto L31;
        sendIntentToReceiver("android.bluetooth.device.action.CONNECTION_ACCESS_REPLY", false, null, false);
        goto L19
    L31:
        OLog.e(TAG, "Bad messagePermission: " + r7);
        goto L32
    }

    private void sendIntentToReceiver(String r2, boolean r3, String r4, boolean r5) {
        Intent r0 = new Intent(r2);
        if (r3 == false) goto L5;
        int r6 = 1;
    L6:
        r0.putExtra("android.bluetooth.device.extra.CONNECTION_ACCESS_RESULT", r6);
        if (r4 == null) goto L9;
        r0.putExtra(r4, r5);
    L9:
        r0.putExtra("android.bluetooth.device.extra.DEVICE", this.mDevice);
        r0.putExtra("android.bluetooth.device.extra.ACCESS_REQUEST_TYPE", this.mRequestType);
        this.mContext.sendBroadcast(r0, "android.permission.BLUETOOTH_ADMIN");
        return;
    L5:
        r6 = 2;
        goto L6
    }

    @Insert("onReceive")
    public static void com_android_settings_bluetooth_BluetoothPermissionRequest_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(BluetoothPermissionRequest r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        BluetoothPermissionRequest r1 = r7;
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
        r7.com_android_settings_bluetooth_BluetoothPermissionRequest__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_bluetooth_BluetoothPermissionRequest__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_bluetooth_BluetoothPermissionRequest__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_bluetooth_BluetoothPermissionRequest__onReceive$___twin___(r8, r9);
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
