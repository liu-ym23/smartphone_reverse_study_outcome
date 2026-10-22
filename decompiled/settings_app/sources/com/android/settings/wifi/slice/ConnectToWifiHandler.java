package com.android.settings.wifi.slice;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.ToastUtils;
import com.android.settings.slices.SliceBackgroundWorker;
import com.android.settings.wifi.WifiDialogActivity;
import com.android.wifitrackerlib.WifiEntry;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(forRemoval = true)
public class ConnectToWifiHandler extends BroadcastReceiver {
    static final String KEY_CHOSEN_WIFIENTRY_KEY = "key_chosen_wifientry_key";
    static final String KEY_WIFI_SLICE_URI = "key_wifi_slice_uri";

    static class WifiEntryConnectCallback implements WifiEntry.ConnectCallback {
        final Context mContext;
        final WifiEntry mWifiEntry;

        WifiEntryConnectCallback(Context r1, WifiEntry r2) {
            this.mContext = r1;
            this.mWifiEntry = r2;
        }

        @Override // com.android.wifitrackerlib.WifiEntry.ConnectCallback
        public void onConnectResult(int r3) {
            if (r3 != 1) goto L6;
            Intent r4 = new Intent(this.mContext, WifiDialogActivity.class).putExtra("key_chosen_wifientry_key", this.mWifiEntry.getKey());
            r4.addFlags(268435456);
            this.mContext.startActivity(r4);
            return;
        L6:
            if (r3 != 2) goto L10;
            ToastUtils.show(this.mContext, R.string.wifi_failed_connect_message);
            return;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_wifi_slice_ConnectToWifiHandler_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public ConnectToWifiHandler() {
    }

    public void com_android_settings_wifi_slice_ConnectToWifiHandler__onReceive$___twin___(Context r3, Intent r4) {
        if (r3 == null) goto L19;
        if (r4 == null) goto L20;
        String r0 = r4.getStringExtra("key_chosen_wifientry_key");
        if (TextUtils.isEmpty(r0) == false) goto L9;
        return;
    L9:
        if (r4.getParcelableExtra(KEY_WIFI_SLICE_URI) != null) goto L11;
        return;
    L11:
        WifiScanWorker r2 = getWifiScanWorker(r4);
        if (r2 != null) goto L14;
        return;
    L14:
        WifiEntry r5 = r2.getWifiEntry(r0);
        if (r5 != null) goto L17;
        return;
    L17:
        r5.connect(new WifiEntryConnectCallback(r3, r5));
        return;
    L20:
        return;
    }

    WifiScanWorker getWifiScanWorker(Intent r1) {
        return (WifiScanWorker) SliceBackgroundWorker.getInstance((Uri) r1.getParcelableExtra(KEY_WIFI_SLICE_URI));
    }

    @Insert("onReceive")
    public static void com_android_settings_wifi_slice_ConnectToWifiHandler_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(ConnectToWifiHandler r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        ConnectToWifiHandler r1 = r7;
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
        r7.com_android_settings_wifi_slice_ConnectToWifiHandler__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_wifi_slice_ConnectToWifiHandler__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_wifi_slice_ConnectToWifiHandler__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_wifi_slice_ConnectToWifiHandler__onReceive$___twin___(r8, r9);
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
