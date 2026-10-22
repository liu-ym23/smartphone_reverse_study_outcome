package com.android.settings.wifi;

import android.casthal.CasthalManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.widget.CompoundButton;
import com.GlobalProxyLancet;
import com.android.settings.AdaptWifi;
import com.android.settings.HandInHandProcessor;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.R;
import com.android.settings.SettingsTracker;
import com.android.settings.SystemAlertDialog;
import com.android.settings.teaevent.TrackerEvent;
import com.android.settings.utils.SmtTntUtil;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes.dex */
public class WifiApEnablerEx implements CompoundButton.OnCheckedChangeListener {
    private SystemAlertDialog mAlertDialog;
    ConnectivityManager mCm;
    private final Context mContext;
    private final IntentFilter mIntentFilter;
    private Object mLock;
    private final BroadcastReceiver mReceiver;
    private final OSwitch mSwitchItem;
    private boolean mWaitForWifiStateChange;
    private WifiManager mWifiManager;
    private String[] mWifiRegexs;

    static /* synthetic */ void access$000(WifiApEnablerEx r0, int r1) {
        r0.handleWifiApStateChanged(r1);
    }

    static /* synthetic */ boolean access$100(WifiApEnablerEx r0) {
        return r0.mWaitForWifiStateChange;
    }

    static /* synthetic */ void access$200(WifiApEnablerEx r0, int r1) {
        r0.handleWifiStateChanged(r1);
    }

    static /* synthetic */ void access$300(WifiApEnablerEx r0, Object[] r1, Object[] r2, Object[] r3) {
        r0.updateTetherState(r1, r2, r3);
    }

    static /* synthetic */ Context access$400(WifiApEnablerEx r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$500(WifiApEnablerEx r0, CompoundButton r1, boolean r2) {
        r0.showApDialog(r1, r2);
    }

    public WifiApEnablerEx(Context r3, OSwitch r4) {
        this.mWaitForWifiStateChange = false;
        this.mLock = new Object();
        this.mReceiver = new AnonymousClass1(this);
        this.mContext = r3;
        this.mSwitchItem = r4;
        this.mWaitForWifiStateChange = false;
        this.mWifiManager = (WifiManager) r3.getApplicationContext().getSystemService("wifi");
        ConnectivityManager r5 = (ConnectivityManager) r3.getApplicationContext().getSystemService("connectivity");
        this.mCm = r5;
        this.mWifiRegexs = r5.getTetherableWifiRegexs();
        IntentFilter r6 = new IntentFilter("android.net.wifi.WIFI_AP_STATE_CHANGED");
        this.mIntentFilter = r6;
        r6.addAction("android.net.conn.TETHER_STATE_CHANGED");
        r6.addAction("android.intent.action.AIRPLANE_MODE");
        r6.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    }

    public void resume() {
        this.mSwitchItem.setChecked(this.mWifiManager.isWifiApEnabled());
        this.mSwitchItem.setOnCheckedChangeListener(this);
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mReceiver, this.mIntentFilter, 2);
    }

    public void pause() {
        this.mSwitchItem.setOnCheckedChangeListener(null);
        this.mContext.unregisterReceiver(this.mReceiver);
    }

    public void setSoftapEnabled(boolean r4) {
        ContentResolver r0 = this.mContext.getContentResolver();
        int r1 = this.mWifiManager.getWifiApState();
        if (r4 == true) goto L5;
    L9:
        if (r4 == true) goto L14;
        if (r1 == 13) goto L14;
        return;
    L14:
        if (MultiSDKAdapter.getWifiStaSapConcurrency(this.mWifiManager) == true) goto L23;
        if (r4 == true) goto L23;
        int r2 = Settings.Global.getInt(r0, AdaptWifi.WIFI_SAVED_STATE);     // Catch: Settings.SettingNotFoundException -> L18
    L20:
        if (r2 != 1) goto L23;
        this.mWaitForWifiStateChange = true;
    L18:
        r2 = 0;
    L23:
        if (MultiSDKAdapter.setWifiApEnabled(this.mWifiManager, null, r4) == false) goto L28;
        this.mSwitchItem.setEnabled(false);
        return;
    L28:
        return;
    L5:
        if (r1 == 11) goto L9;
        if (r1 == 14) goto L9;
    }

    private void showApDialog(final CompoundButton r10, final boolean r11) {
        if (r11 == false) goto L5;
    L9:
        if (r11 == true) goto L11;
    L13:
        setSoftapEnabled(r11);
        return;
    L11:
        if (SmtTntUtil.isMiracastWirelessConnect(this.mContext) == false) goto L13;
        SystemAlertDialog r7 = new SystemAlertDialog(this.mContext);
        this.mAlertDialog = r7;
        r7.setTitle(R.string.dlg_title_notice);
        SystemAlertDialog r5 = this.mAlertDialog;
        Context r8 = this.mContext;
        r5.setMessage(r8.getString(R.string.open_some_switch_dialog_content, new Object[]{r8.getString(R.string.wifi_ap_switch)}));
        this.mAlertDialog.setCancelable(true);
        this.mAlertDialog.setPositiveButton(R.string.notification_warning_dialog_ok_btn, new AnonymousClass5(this, r11));
        this.mAlertDialog.setNegativeButton(R.string.hand_in_hand_dialog_cancel_button_text, new AnonymousClass6(this, r10));
        this.mAlertDialog.setOnCancelListener(new AnonymousClass7(this, r10));
        this.mAlertDialog.getWindow().setType(2020);
        this.mAlertDialog.show();
        return;
    L5:
        if (CasthalManager.getInstance(this.mContext).isVuartConnected() == true) goto L9;
        if (CasthalManager.getInstance(this.mContext).isBostonConnected() == false) goto L9;
        SystemAlertDialog r9 = new SystemAlertDialog(this.mContext);
        this.mAlertDialog = r9;
        r9.setTitle(R.string.dlg_title_notice);
        SystemAlertDialog r6 = this.mAlertDialog;
        Context r12 = this.mContext;
        r6.setMessage(r12.getString(R.string.close_some_switch_dialog_content, new Object[]{r12.getString(R.string.wifi_ap_switch)}));
        this.mAlertDialog.setCancelable(true);
        this.mAlertDialog.setPositiveButton(R.string.notification_warning_dialog_ok_btn, new AnonymousClass2(this, r11));
        this.mAlertDialog.setNegativeButton(R.string.hand_in_hand_dialog_cancel_button_text, new AnonymousClass3(this, r10));
        this.mAlertDialog.setOnCancelListener(new AnonymousClass4(this, r10));
        this.mAlertDialog.getWindow().setType(2020);
        this.mAlertDialog.show();
    }

    public void updateConfigSummary(WifiConfiguration r1) {
        AdaptWifi.getWifiTetherConfigureSSIDDefault(this.mContext);
    }

    private void updateTetherState(Object[] r9, Object[] r10, Object[] r11) {
        int r12 = r10.length;
        int r1 = 0;
        boolean r2 = false;
    L3:
        if (r1 >= r12) goto L11;
        String r3 = (String) r10[r1];
        String[] r4 = this.mWifiRegexs;
        int r5 = r4.length;
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L10;
        if (r3.matches(r4[r6]) == false) goto L9;
        r2 = true;
    L9:
        r6 = r6 + 1;
        goto L5
    L10:
        r1 = r1 + 1;
        goto L3
    L11:
        int r13 = r11.length;
        int r14 = 0;
    L12:
        if (r14 >= r13) goto L17;
        String r7 = (String) r11[r14];
        String[] r8 = this.mWifiRegexs;
        int r15 = r8.length;
        int r16 = 0;
    L14:
        if (r16 >= r15) goto L16;
        r7.matches(r8[r16]);
        r16 = r16 + 1;
        goto L14
    L16:
        r14 = r14 + 1;
        goto L12
    L17:
        if (r2 == false) goto L26;
        updateConfigSummary(this.mWifiManager.getWifiApConfiguration());
        return;
    }

    private void handleWifiApStateChanged(int r3) {
        this.mSwitchItem.setOnCheckedChangeListener(null);
        switch(r3) {
            case 10: goto L16;
            case 11: goto L11;
            case 12: goto L10;
            case 13: goto L5;
            default: goto L4;
        };
    L4:
        this.mSwitchItem.setChecked(false);
    L17:
        this.mSwitchItem.setOnCheckedChangeListener(this);
        return;
    L5:
        this.mSwitchItem.setChecked(true);
        this.mSwitchItem.setEnabled(true);
        SystemAlertDialog r4 = this.mAlertDialog;
        if (r4 == null) goto L17;
        if (r4.isShowing() == false) goto L17;
        this.mAlertDialog.dismiss();
        goto L17
    L10:
        this.mSwitchItem.setEnabled(false);
        goto L17
    L11:
        this.mSwitchItem.setChecked(false);
        this.mSwitchItem.setEnabled(true);
        SystemAlertDialog r5 = this.mAlertDialog;
        if (r5 == null) goto L17;
        if (r5.isShowing() == false) goto L17;
        this.mAlertDialog.dismiss();
        goto L17
    L16:
        this.mSwitchItem.setEnabled(false);
        goto L17
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(final CompoundButton r8, boolean r9) {
        if (com.android.settings.Utils.isMonkeyRunning() == false) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        HandInHandProcessor r1 = new HandInHandProcessor();     // Catch: Throwable -> L18
        if (r9 == true) goto L10;
    L14:
        showApDialog(r8, r9);     // Catch: Throwable -> L18
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L18
        SettingsTracker.onSwitcherClick(70101, r9);
        TrackerEvent.switchEvent("wifi_ap", r9);
        return;
    L10:
        if (r1.isHandInHandle(this.mContext) == false) goto L14;
        if (com.android.settings.Utils.isWifiConnected(this.mContext) == false) goto L14;
        r1.showDialog(this.mContext, 4, new AnonymousClass8(this, r8), new AnonymousClass9(this, r8), new AnonymousClass10(this, r8));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private void handleWifiStateChanged(int r2) {
        if (r2 != 3) goto L5;
    L7:
        this.mWaitForWifiStateChange = false;
        return;
    L5:
        if (r2 == 4) goto L7;
    }
}
