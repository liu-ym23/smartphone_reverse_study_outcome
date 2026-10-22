package com.android.settings.settingitemsprovider;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.SystemProperties;
import com.android.settings.PreferenceMgr;
import com.android.settings.sidedial.SideDialHelper;
import com.android.settings.utils.SettingsProviderUtils;
import com.bytedance.sremlib.LibUtil;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsItemsService extends IntentService {
    private static final String TAG = "SettingsItemsService";

    public SettingsItemsService() {
        super(TAG);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Intent r6 = (Intent) r5.getParcelableExtra("source_intent");
        String r0 = r6.getAction();
        OLog.d(TAG, "intent " + r6);
        if ("android.intent.action.AIRPLANE_MODE".equals(r0) == false) goto L8;
        DatabaseHelper.getInstance(this).onAirPlaneModeChanged();
        return;
    L8:
        if ("android.intent.action.SIM_STATE_CHANGED".equals(r0) == false) goto L11;
        DatabaseHelper.getInstance(this).onSimStateChanged();
        return;
    L11:
        if ("android.intent.action.SERVICE_STATE".equals(r0) == false) goto L14;
        DatabaseHelper.getInstance(this).onServiceStateChanged();
        return;
    L14:
        if ("android.intent.action.ACTION_DEFAULT_DATA_SUBSCRIPTION_CHANGED".equals(r0) == false) goto L17;
        DatabaseHelper.getInstance(this).onDefaultDataSlotChanged();
        return;
    L17:
        if ("android.nfc.action.ADAPTER_STATE_CHANGED".equals(r0) == false) goto L22;
        NfcAdapter r7 = NfcAdapter.getDefaultAdapter(this);
        if (r7 == null) goto L49;
        DatabaseHelper.getInstance(this).handleNfcStateChanged(r7.getAdapterState());
        return;
    L49:
        return;
    L22:
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r0) == false) goto L25;
        OLog.d(TAG, "handle wifi state changed ");
        DatabaseHelper.getInstance(this).handleWifiStateChanged();
        return;
    L25:
        if ("android.net.wifi.WIFI_AP_STATE_CHANGED".equals(r0) == false) goto L28;
        DatabaseHelper.getInstance(this).handleWifiApStateChanged();
        return;
    L28:
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(r0) == false) goto L31;
        handleBluetoothStateChanged(r6);
        return;
    L31:
        if ("com.obric.account.LOGIN_STATE_CHANGE".equals(r0) == false) goto L34;
        DatabaseHelper.getInstance(this).handleAccountLoginStateChanged();
        return;
    L34:
        if ("android.intent.action.LOCALE_CHANGED".equals(r0) == false) goto L37;
        DatabaseHelper.getInstance(this).recreate();
        return;
    L37:
        if (LibUtil.ACTION_BOOT_COMPLETELY.equals(r0) == false) goto L56;
        String r8 = SystemProperties.get("ro.os.ota.version", "");
        String r1 = DatabaseHelper.getInstance(this).getRomVersion();
        OLog.d(TAG, "curRomVersion:" + r8 + " storeRomVersion:" + r1);
        if (r1 != null) goto L41;
    L43:
        DatabaseHelper.getInstance(this).setRomVersion(r8);
        return;
    L41:
        if (r1.equals(r8) == true) goto L43;
        DatabaseHelper.getInstance(this).recreate();
        goto L43
    }

    private void handleBluetoothStateChanged(Intent r5) {
        Context r4 = getApplicationContext();
        PreferenceMgr r0 = PreferenceMgr.getInstance(r4);
        int r6 = r5.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
        if (r6 != 10) goto L5;
    L7:
        int r2 = r0.getInt(com.android.settings.Constants.SIDE_DIAL_MODE_SWITCH_CURRENT_BLUETOOTH, -1);
        r0.putIntSync(com.android.settings.Constants.SIDE_DIAL_MODE_SWITCH_CURRENT_BLUETOOTH, -1);
        if (r2 != (-1)) goto L11;
        SideDialHelper.removeCurrentCarModeSwitch(r4, com.android.settings.Constants.SIDE_DIAL_CAR_MODE_BLUETOOTH);
        return;
    L11:
        boolean r3 = true;
        if (SettingsProviderUtils.isSideDialEnable(r4) == false) goto L17;
        if (r2 == 1) goto L16;
        r3 = false;
    L16:
        SideDialHelper.setBluetoothEnable(r4, r3);
        return;
    L17:
        SideDialHelper.setBluetoothEnable(r4, !r0.getString(com.android.settings.Constants.SIDE_DIAL_CAR_MODE_BLUETOOTH, "0").equals("1"));
        return;
    L5:
        if (r6 == 12) goto L7;
    }

    private void handleCasthalConnectionChanged(Intent r2) {
        r2.getIntExtra("", 0);
    }
}
