package com.android.settings.bluetooth;

import android.app.AlertDialog;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public final class Utils {
    public static final String ABS_FEATURE_CODE = "INTEROP_DISABLE_ABSOLUTE_VOLUME";
    public static final String ACTION_DISCONNECT_DEVICE = "com.android.settings.bluetooth.intent.DISCONNECT_DEVICE";
    public static final String ACTION_RESET_TIMER = "com.android.settings.bluetooth.intent.action.RESET_TIMER";
    public static final String ACTION_SET_TIMER = "com.android.settings.bluetooth.intent.action.SET_TIMER";
    public static final String CONNECTION_END_TIME = "connection_end_time";
    public static final String CONNECTION_END_TIME_DELAY_TIME_VALUE = "connection_end_time_delay_time_value";
    public static final short DEVICE_NEED_HIDE_RSSI = -70;
    public static final String EXTRA_DEVICE = "device";
    public static final String EXTRA_TIMER_BUNDLE = "com.android.settings.bluetooth.intent.action.TIMER_BUNDLE";
    public static final String EXTRA_TIMER_DELAY = "com.android.settings.bluetooth.intent.action.TIMER_DELAY";
    public static final String EXTRA_TIMER_DEVICE = "com.android.settings.bluetooth.intent.action.TIMER_DEVICE";
    public static final String EXTRA_TIMER_PREFERENCE = "com.android.settings.bluetooth.intent.action.TIMER_PREFERENCE";
    public static final String EXTRA_TIMER_SERIAL = "com.android.settings.bluetooth.intent.action.TIMER_SERIAL";
    public static final String NEED_RECONNECT = "auto_reconnect";
    private static final String TAG = "Utils";
    public static final String TAG_DEVICE_LIST_GROUP_PBAPCLIENT = "TAG_DEVICE_LIST_GROUP_PBAPCLIENT";
    public static final String TAG_DEVICE_LIST_GROUP_PICKER = "TAG_DEVICE_LIST_GROUP_PICKER";
    public static final String TAG_DEVICE_LIST_GROUP_SETTING = "TAG_DEVICE_LIST_GROUP_SETTING";
    public static final String TAG_SHARED_PREFERENCE = "tag_shared_preference";
    private static final com.android.settingslib.bluetooth.BluetoothUtils.ErrorListener mErrorListener = null;
    private static final com.android.settingslib.bluetooth.LocalBluetoothManager.BluetoothManagerCallback mOnInitCallback = null;

    public static int getConnectionStateSummary(int r1) {
        if (r1 != 0) goto L4;
        return R.string.bluetooth_disconnected;
    L4:
        if (r1 != 1) goto L6;
        return R.string.bluetooth_connecting;
    L6:
        if (r1 != 2) goto L8;
        return R.string.bluetooth_connected;
    L8:
        if (r1 == 3) goto L11;
        return 0;
    L11:
        return R.string.bluetooth_disconnecting;
    }

    public static void updateSearchIndex(Context r0, String r1, String r2, String r3, int r4, boolean r5) {
    }

    static /* synthetic */ com.android.settingslib.bluetooth.BluetoothUtils.ErrorListener access$000() {
        return mErrorListener;
    }

    private Utils() {
    }

    static AlertDialog showDisconnectDialog(Context r1, AlertDialog r2, DialogInterface.OnClickListener r3, DialogInterface.OnClickListener r4, CharSequence r5, CharSequence r6) {
        if (r2 != null) goto L6;
        r2 = new AlertDialog.Builder(r1).setPositiveButton(android.R.string.ok, r3).setNegativeButton(android.R.string.cancel, r4).create();
    L9:
        r2.setTitle(r5);
        r2.setMessage(r6);
        r2.show();
        return r2;
    L6:
        if (r2.isShowing() == false) goto L8;
        r2.dismiss();
    L8:
        r2.setButton(-1, r1.getText(android.R.string.ok), r3);
        goto L9
    }

    static OAlertDialog showDisconnectDialog(Context r1, DialogInterface.OnClickListener r2, DialogInterface.OnClickListener r3, CharSequence r4, CharSequence r5, DialogInterface.OnShowListener r6, DialogInterface.OnDismissListener r7) {
        OAlertDialogBuilder r8 = new OAlertDialogBuilder(r1).autoDismiss(false).horizontalButton().title(r4, false).message(r5).positiveButton(android.R.string.ok, r2).negativeButton(android.R.string.cancel, r3);
        r8.onShow(r6);
        r8.onDismiss(r7);
        OAlertDialog r9 = r8.build();
        r9.show();
        return r9;
    }

    static AlertDialog showMultiContextDisconnectDialog(Context r3, AlertDialog r4, DialogInterface.OnClickListener r5, DialogInterface.OnClickListener r6, CharSequence r7, CharSequence r8) {
        View r0 = LayoutInflater.from(r3).inflate(R.layout.bluetooth_confirm_dialog, null);
        TextView r1 = (TextView) NullSafe.nonNull(r0.findViewById(R.id.content));
        if (r4 != null) goto L5;
    L7:
        AlertDialog r9 = new AlertDialog.Builder(r3).setView(r0).setPositiveButton(android.R.string.ok, r5).setNegativeButton(android.R.string.cancel, r6).create();
        r9.setTitle(r7);
        r1.setText(r8);
        r9.show();
        return r9;
    L5:
        if (r4.isShowing() == false) goto L7;
        r4.dismiss();
        goto L7
    }

    static void showSpecialError(Context r2, String r3, int r4) {
        String r5 = r2.getString(r4, new Object[]{r3});
        LocalBluetoothManager r6 = LocalBluetoothManager.getInstance(r2);
        Context r7 = r6.getForegroundActivity();
        if (r6.isForegroundActivity() == false) goto L6;
        new AlertDialog.Builder(r7).setIconAttribute(android.R.attr.alertDialogIcon).setTitle(R.string.bluetooth_error_title).setMessage(r5).setPositiveButton(android.R.string.ok, null).show();
        return;
    }

    public static void StartTiming(Context r2, CachedBluetoothDevice r3, long r4) {
        OLog.d(TAG, "StartTiming");
        long r5 = SetEndTime(r2, r4);
        Intent r0 = new Intent();
        r0.setAction(ACTION_SET_TIMER);
        r0.putExtra(EXTRA_TIMER_DEVICE, r3.getDevice());
        r0.putExtra(EXTRA_TIMER_DELAY, r5);
        r2.sendBroadcast(r0);
    }

    public static void StopTiming(Context r2) {
        OLog.d(TAG, "StopTiming");
        SetEndTime(r2, 0);
        Intent r0 = new Intent();
        r0.setAction(ACTION_RESET_TIMER);
        r2.sendBroadcast(r0);
    }

    public static SharedPreferences getSharedPreference(Context r2) {
        return r2.getSharedPreferences(TAG_SHARED_PREFERENCE, 0);
    }

    public static long getEndTime(Context r3) {
        return getSharedPreference(r3).getLong(CONNECTION_END_TIME, -1);
    }

    public static long SetEndTime(Context r4, long r5) {
        OLog.d(TAG, "SetEndTime " + r5);
        long r2 = SystemClock.elapsedRealtime() + r5;
        SharedPreferences.Editor r6 = getSharedPreference(r4).edit();     // Catch: Exception -> L5
        r6.putLong(CONNECTION_END_TIME, r2);     // Catch: Exception -> L5
        r6.putLong(CONNECTION_END_TIME_DELAY_TIME_VALUE, r5);     // Catch: Exception -> L5
        r6.apply();     // Catch: Exception -> L5
    L7:
        return r2;
    L5:
        e = move-exception;
        OLog.e(TAG, e.toString());
        goto L7
    }

    public static long getRemainingTime(Context r5) {
        long r0 = getEndTime(r5);
        long r2 = SystemClock.elapsedRealtime();
        OLog.d(TAG, "endTime = " + r0 + "; currentTimeMillis = " + r2);
        long r1 = r0 - r2;
        if (r1 <= 0) goto L5;
        return r1;
    L5:
        return -1;
    }

    public static long getDelayTimeValue(Context r3) {
        return getSharedPreference(r3).getLong(CONNECTION_END_TIME_DELAY_TIME_VALUE, -1);
    }

    public static boolean shouldDiscardDevice(CachedBluetoothDevice r8) {
        if (r8 != null) goto L5;
    L27:
        return false;
    L5:
        if (r8.getBtClass() == null) goto L27;
        if (r8.getBtClass().getMajorDeviceClass() != 7936) goto L18;
        if (r8.getName() == null) goto L14;
        if (r8.getName().equals(r8.getDevice().getAddress()) == false) goto L18;
    L14:
        if (r8.getBondState() == 12) goto L18;
        OLog.d(TAG, "device : " + r8 + " is discarded, deviceName is null or deviceName equals deviceAddress");
        return true;
    L18:
        if (2 != r8.getDevice().getType()) goto L27;
        if (r8.getBtClass().getMajorDeviceClass() != 7936) goto L27;
        if (r8.mRssi >= (-70)) goto L27;
        if (r8.getBondState() == 12) goto L27;
        OLog.d(TAG, "device : " + r8 + " is discarded, rssi < -70");
        return true;
    }

    static androidx.appcompat.app.AlertDialog showDisconnectDialog(Context r2, androidx.appcompat.app.AlertDialog r3, DialogInterface.OnClickListener r4, CharSequence r5, CharSequence r6) {
        if (r3 != null) goto L6;
        r3 = new androidx.appcompat.app.AlertDialog.Builder(r2).setPositiveButton(android.R.string.ok, r4).setNegativeButton(android.R.string.cancel, null).create();
    L9:
        r3.setTitle(r5);
        r3.setMessage(r6);
        r3.show();
        return r3;
    L6:
        if (r3.isShowing() == false) goto L8;
        r3.dismiss();
    L8:
        r3.setButton(-1, r2.getText(android.R.string.ok), r4);
        goto L9
    }

    static void showConnectingError(Context r1, String r2, com.android.settingslib.bluetooth.LocalBluetoothManager r3) {
        showError(r1, r2, R.string.bluetooth_connecting_error_message, r3);
    }

    static void showError(Context r1, String r2, int r3) {
        showError(r1, r2, r3, getLocalBtManager(r1));
    }

    private static void showError(Context r2, String r3, int r4, com.android.settingslib.bluetooth.LocalBluetoothManager r5) {
        String r6 = r2.getString(r4, new Object[]{r3});
        Context r7 = r5.getForegroundActivity();
        if (r5.isForegroundActivity() == true) goto L10;
        ToastUtils.show(r2, r6);
        return;
    L10:
        new androidx.appcompat.app.AlertDialog.Builder(r7).setTitle(R.string.bluetooth_error_title).setMessage(r6).setPositiveButton(android.R.string.ok, null).show();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        OLog.e(TAG, "Cannot show error dialog.", e);
    }

    public static com.android.settingslib.bluetooth.LocalBluetoothManager getLocalBtManager(Context r1) {
        return com.android.settingslib.bluetooth.LocalBluetoothManager.getInstance(r1, mOnInitCallback);
    }

    public static com.android.settingslib.bluetooth.LocalBluetoothManager getLocalBluetoothManager(final Context r2) {
        FutureTask r0 = new FutureTask(new Utils$$ExternalSyntheticLambda1(r2));
        r0.run();     // Catch: Throwable -> L5
        return (com.android.settingslib.bluetooth.LocalBluetoothManager) r0.get();
    L5:
        e = move-exception;
        OLog.w(TAG, "Error getting LocalBluetoothManager.", e);
        return null;
    }

    static /* synthetic */ com.android.settingslib.bluetooth.LocalBluetoothManager lambda$getLocalBluetoothManager$0(Context r0) throws Exception {
        return getLocalBtManager(r0);
    }

    public static String createRemoteName(Context r0, BluetoothDevice r1) {
        if (r1 == null) goto L4;
        String r2 = r1.getAlias();
    L5:
        if (r2 == null) goto L7;
        return r2;
    L7:
        return r0.getString(R.string.unknown);
    L4:
        r2 = null;
        goto L5
    }

    static {
        mErrorListener = new AnonymousClass1();
        mOnInitCallback = new AnonymousClass2();
    }

    public static boolean isBluetoothScanningEnabled(Context r2) {
        if (Settings.Global.getInt(r2.getContentResolver(), "ble_scan_always_enabled", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    public static String findBluetoothPackageName(Context r11) throws PackageManager.NameNotFoundException {
        PackageManager r12 = r11.createContextAsUser(UserHandle.SYSTEM, 0).getPackageManager();
        String[] r0 = r12.getPackagesForUid(1002);
        int r2 = r0.length;
        String r3 = null;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L21;
        String r5 = r0[r4];
        PackageInfo r6 = r12.getPackageInfo(r5, 4203009);     // Catch: PackageManager.NameNotFoundException -> L19
        if (r6.activities == null) goto L18;
        ActivityInfo[] r7 = r6.activities;
        int r8 = r7.length;
        int r9 = 0;
    L10:
        if (r9 >= r8) goto L18;
        if ("com.android.bluetooth.opp.BluetoothOppLauncherActivity".equals(r7[r9].name) == false) goto L17;
        if (r3 != null) goto L16;
        r3 = r5;
        goto L17
    L16:
        throw new PackageManager.NameNotFoundException("multiple main bluetooth packages found");
    L17:
        r9 = r9 + 1;
    L18:
        r4 = r4 + 1;
    L19:
        e = move-exception;
        throw e;
    L21:
        if (r3 == null) goto L24;
        return r3;
    L24:
        throw new PackageManager.NameNotFoundException("Could not find main bluetooth package");
    }

    public static List<com.android.settingslib.bluetooth.CachedBluetoothDevice> getAllOfCachedBluetoothDevices(com.android.settingslib.bluetooth.LocalBluetoothManager r5, com.android.settingslib.bluetooth.CachedBluetoothDevice r6) {
        ArrayList r0 = new ArrayList();
        if (r6 != null) goto L6;
        OLog.e(TAG, "getAllOfCachedBluetoothDevices: no cachedBluetoothDevice");
        return r0;
    L6:
        final int r2 = r6.getGroupId();
        if (r2 != (-1)) goto L10;
        r0.add(r6);
        return r0;
    L10:
        if (r5 != null) goto L13;
        OLog.e(TAG, "getAllOfCachedBluetoothDevices: no LocalBluetoothManager");
        return r0;
    L13:
        com.android.settingslib.bluetooth.CachedBluetoothDevice r7 = r5.getCachedDeviceManager().getCachedDevicesCopy().stream().filter(new Utils$$ExternalSyntheticLambda0(r2)).findFirst().orElse(null);
        if (r7 != null) goto L17;
        OLog.e(TAG, "getAllOfCachedBluetoothDevices: groupId = " + r2 + ", no main device.");
        return r0;
    L17:
        r0.add(r7);
        Iterator<com.android.settingslib.bluetooth.CachedBluetoothDevice> r3 = r7.getMemberDevice().iterator();
    L19:
        if (r3.hasNext() == false) goto L21;
        r0.add(r3.next());
        goto L19
    L21:
        OLog.d(TAG, "getAllOfCachedBluetoothDevices: groupId = " + r2 + " , cachedBluetoothDevice = " + r7 + " , deviceList = " + r0);
        return r0;
    }

    static /* synthetic */ boolean lambda$getAllOfCachedBluetoothDevices$1(int r0, com.android.settingslib.bluetooth.CachedBluetoothDevice r1) {
        if (r1.getGroupId() != r0) goto L5;
        return true;
    L5:
        return false;
    }
}
