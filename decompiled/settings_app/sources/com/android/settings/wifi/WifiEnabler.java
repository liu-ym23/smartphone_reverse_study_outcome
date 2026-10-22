package com.android.settings.wifi;

import android.app.AlertDialog;
import android.casthal.CasthalManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.GlobalProxyLancet;
import com.android.settings.HandInHandProcessor;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.SettingsTracker;
import com.android.settings.SystemAlertDialog;
import com.android.settings.ToastUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.teaevent.TrackerEvent;
import com.android.settings.utils.SmtTntUtil;
import com.android.settingslib.WirelessUtils;
import com.bytedance.sremlib.LibUtil;
import com.obric.oui.oswitch.OSwitch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class WifiEnabler implements CompoundButton.OnCheckedChangeListener {
    private static final String EVENT_DATA_IS_WIFI_ON = "is_wifi_on";
    public static final String KEY_TURN_OFF_WIFI_SHOW_AGAIN = "TurnOffWifiShowAgain";
    public static final String MY_PREF_FILE = "MY_PERFS";
    private static CheckBox mNotShowAgainCheckbox;
    private SystemAlertDialog mAlertDialog;
    private final AtomicBoolean mConnected;
    private Context mContext;
    private final Handler mHandler;
    private final IntentFilter mIntentFilter;
    private boolean mListeningToOnSwitchChange;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
    private boolean mPendingEnabled;
    private HandInHandProcessor mProcessor;
    private final BroadcastReceiver mReceiver;
    private boolean mStateMachineEvent;
    private OSwitch mSwitch;
    private final Runnable mSwitchStateRunnable;
    private WifiManager mWifiManager;
    private boolean mWifiStaSapConcurrency;
    private boolean mWifiStaSapConcurrencyInit;
    private Intent registeredIntent;
    private final Runnable updateSwitcherCheckedRunnable;
    private Runnable updateWifiStateRunnable;

    static /* synthetic */ void access$000(WifiEnabler r0, int r1) {
        r0.handleWifiStateChanged(r1);
    }

    static /* synthetic */ void access$100(WifiEnabler r0) {
        r0.applySwitchState();
    }

    static /* synthetic */ CheckBox access$200() {
        return mNotShowAgainCheckbox;
    }

    static /* synthetic */ Context access$300(WifiEnabler r0) {
        return r0.mContext;
    }

    static /* synthetic */ WifiManager access$400(WifiEnabler r0) {
        return r0.mWifiManager;
    }

    static /* synthetic */ OSwitch access$500(WifiEnabler r0) {
        return r0.mSwitch;
    }

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$600(WifiEnabler r0) {
        return r0.mOnCheckedChangeListener;
    }

    static /* synthetic */ void access$700(WifiEnabler r0, CompoundButton r1, boolean r2) {
        r0.closeOfOpen(r1, r2);
    }

    public WifiEnabler(Context r3, OSwitch r4, Runnable r5) {
        this.mListeningToOnSwitchChange = false;
        this.mConnected = new AtomicBoolean(false);
        this.mWifiManager = null;
        this.mProcessor = new HandInHandProcessor();
        this.mReceiver = new AnonymousClass1(this);
        this.registeredIntent = null;
        this.updateWifiStateRunnable = null;
        this.updateSwitcherCheckedRunnable = new WifiEnabler$$ExternalSyntheticLambda0(this);
        this.mPendingEnabled = true;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mSwitchStateRunnable = new AnonymousClass2(this);
        this.mContext = r3;
        this.mSwitch = r4;
        this.mWifiManager = (WifiManager) r3.getSystemService("wifi");
        IntentFilter r6 = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
        this.mIntentFilter = r6;
        r6.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        r6.addAction("android.net.wifi.STATE_CHANGE");
        setupSwitchBar();
        this.updateWifiStateRunnable = r5;
    }

    public void setupSwitchBar() {
        handleWifiStateChanged(this.mWifiManager.getWifiState());
        if (this.mListeningToOnSwitchChange == true) goto L6;
        this.mSwitch.setOnCheckedChangeListener(this);
        this.mListeningToOnSwitchChange = true;
        return;
    }

    public void teardownSwitchBar() {
        if (this.mListeningToOnSwitchChange == false) goto L6;
        this.mSwitch.setOnCheckedChangeListener(null);
        this.mListeningToOnSwitchChange = false;
        return;
    }

    public void resume(Context r4) {
        this.mContext = r4;
        this.registeredIntent = GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r4, this.mReceiver, this.mIntentFilter, 2);
        if (this.mListeningToOnSwitchChange == true) goto L6;
        this.mSwitch.setOnCheckedChangeListener(this);
        this.mListeningToOnSwitchChange = true;
        return;
    }

    public void pause() {
        if (this.registeredIntent == null) goto L9;
        this.mContext.unregisterReceiver(this.mReceiver);
        if (this.mListeningToOnSwitchChange == false) goto L7;
        this.mSwitch.setOnCheckedChangeListener(null);
        this.mListeningToOnSwitchChange = false;
    L7:
        this.registeredIntent = null;
        return;
    }

    /* JADX INFO: renamed from: lambda$new$0$com-android-settings-wifi-WifiEnabler, reason: not valid java name */
    /* synthetic */ void m694lambda$new$0$comandroidsettingswifiWifiEnabler() {
        boolean r0 = this.mSwitch.isChecked();
        int r1 = this.mWifiManager.getWifiState();
        if (r1 != 3) goto L5;
        r0 = true;
    L5:
        if (r1 != 1) goto L7;
        r0 = false;
    L7:
        setSwitchBarChecked(r0);
    }

    private void setSwitchBarCheckedDebounced() {
        this.mHandler.removeCallbacks(this.updateSwitcherCheckedRunnable);
        this.mHandler.postDelayed(this.updateSwitcherCheckedRunnable, 200);
    }

    private void handleWifiStateChanged(int r4) {
        if (r4 == 0) goto L18;
        if (r4 != 1) goto L6;
        setSwitchBarCheckedDebounced();
        SystemAlertDialog r5 = this.mAlertDialog;
        if (r5 != null) goto L15;
    L17:
        setSwitchEnabledDebounced(true);
    L20:
        if (this.mWifiStaSapConcurrencyInit == false) goto L22;
        return;
    L22:
        if (mayDisableTethering(!this.mSwitch.isChecked()) == true) goto L24;
        return;
    L24:
        if (MultiSDKAdapterNew.hasBaseUserRestriction(this.mContext, "no_config_tethering", UserHandle.myUserId()) == false) goto L26;
        this.mSwitch.setEnabled(false);
        return;
    L26:
        MultiSDKAdapterNew.checkIfRestrictionEnforced(this.mContext, "no_config_tethering", UserHandle.myUserId());
        return;
    L15:
        if (r5.isShowing() == false) goto L17;
        this.mAlertDialog.dismiss();
        goto L17
    L6:
        if (r4 != 2) goto L8;
        setSwitchEnabledDebounced(false);
        goto L20
    L8:
        if (r4 == 3) goto L10;
        setSwitchBarCheckedDebounced();
        setSwitchEnabledDebounced(true);
        goto L20
    L10:
        setSwitchBarCheckedDebounced();
        setSwitchEnabledDebounced(true);
        goto L20
    L18:
        setSwitchEnabledDebounced(false);
        goto L20
    }

    private void setSwitchBarChecked(boolean r2) {
        if (r2 == this.mSwitch.isChecked()) goto L7;
        this.mStateMachineEvent = true;
        this.mSwitch.setChecked(r2);
        this.mStateMachineEvent = false;
        CompoundButton.OnCheckedChangeListener r1 = this.mOnCheckedChangeListener;
        if (r1 == null) goto L7;
        r1.onCheckedChanged(null, r2);
    L7:
        AppMetricsUtils.INSTANCE.swapSceneEnd(LibUtil.PREFERENCE_WIFI_SWITCH);
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r1) {
        this.mOnCheckedChangeListener = r1;
    }

    private void setSwitchEnabledDebounced(boolean r3) {
        this.mPendingEnabled = true;
        this.mHandler.removeCallbacks(this.mSwitchStateRunnable);
        this.mHandler.postDelayed(this.mSwitchStateRunnable, 200);
    }

    private void applySwitchState() {
        this.mSwitch.setEnabled(this.mPendingEnabled);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r8, boolean r9) {
        if (com.android.settings.Utils.isMonkeyRunning() == false) goto L5;
        return;
    L5:
        r8.sendAccessibilityEvent(1);
        if (this.mStateMachineEvent == false) goto L9;
        return;
    L9:
        if (r9 == false) goto L15;
        if (WirelessUtils.isRadioAllowed(this.mContext, "wifi") == true) goto L15;
        ToastUtils.show(this.mContext, R.string.wifi_in_airplane_mode);
        r8.setChecked(false);
        return;
    L15:
        if (this.mWifiStaSapConcurrencyInit == true) goto L18;
        this.mWifiStaSapConcurrencyInit = true;
        this.mWifiStaSapConcurrency = MultiSDKAdapter.getWifiStaSapConcurrency(this.mWifiManager);
    L18:
        if (this.mWifiStaSapConcurrency == false) goto L20;
    L34:
        setSwitchEnabledDebounced(false);
        AppMetricsUtils.INSTANCE.swapSceneStart(LibUtil.PREFERENCE_WIFI_SWITCH, r9);
        if (r9 == false) goto L38;
        AppMetricsUtils.INSTANCE.durationEventStart("wifi_switch_on");
    L38:
        if (r8 != this.mSwitch) goto L45;
        if (r9 == true) goto L45;
        if (this.mProcessor.isHandInHandle(this.mContext) == false) goto L45;
        if (com.android.settings.Utils.isWifiConnected(this.mContext) == false) goto L45;
        showDialog(r8);
    L46:
        SettingsTracker.onSwitcherClick(201, r9);
        TrackerEvent.switchEvent("wifi", r9);
        return;
    L45:
        closeOfOpen(r8, r9);
        goto L46
    L20:
        if (mayDisableTethering(r9) == false) goto L34;
        if (this.mContext.getResources().getBoolean(R.bool.config_show_dialog_open_wifi_when_tethering_open) == false) goto L30;
        View r10 = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.not_show_again, null);
        mNotShowAgainCheckbox = (CheckBox) r10.findViewById(R.id.check);
        final SharedPreferences r4 = this.mContext.getSharedPreferences(MY_PREF_FILE, 0);
        if (r4.getBoolean(KEY_TURN_OFF_WIFI_SHOW_AGAIN, true) == true) goto L29;
        MultiSDKAdapter.setWifiApEnabled(this.mWifiManager, null, false);
        if (this.mWifiManager.setWifiEnabled(r9) == true) goto L48;
        this.mSwitch.setEnabled(true);
        ToastUtils.show(this.mContext, R.string.wifi_error);
        return;
    L48:
        return;
    L29:
        AlertDialog.Builder r11 = new AlertDialog.Builder(this.mContext).setTitle(R.string.turn_on_wifi_dialog_title).setMessage(R.string.turn_on_wifi_dialog_text).setView(r10).setPositiveButton(R.string.okay, new AnonymousClass3(this, r4));
        r11.setCancelable(false);
        r11.show();
    L30:
        MultiSDKAdapter.setWifiApEnabled(this.mWifiManager, null, false);
        if (this.mWifiManager.setWifiEnabled(r9) == true) goto L49;
        this.mSwitch.setEnabled(true);
        ToastUtils.show(this.mContext, R.string.wifi_error);
        return;
    }

    private void closeOfOpen(final CompoundButton r7, final boolean r8) {
        if (r8 == true) goto L10;
        if (SmtTntUtil.isMiracastWirelessConnect(this.mContext) == false) goto L10;
        if (CasthalManager.getInstance(this.mContext).isBostonConnected() == true) goto L10;
        SystemAlertDialog r1 = new SystemAlertDialog(this.mContext);
        this.mAlertDialog = r1;
        r1.setTitle(R.string.dlg_title_notice);
        SystemAlertDialog r2 = this.mAlertDialog;
        Context r3 = this.mContext;
        r2.setMessage(r3.getString(R.string.close_some_switch_dialog_content, new Object[]{r3.getString(R.string.wifi_settings_title)}));
        this.mAlertDialog.setCancelable(true);
        this.mAlertDialog.setPositiveButton(R.string.notification_warning_dialog_ok_btn, new AnonymousClass4(this, r8, r7));
        this.mAlertDialog.setNegativeButton(R.string.hand_in_hand_dialog_cancel_button_text, new AnonymousClass5(this));
        this.mAlertDialog.setOnCancelListener(new AnonymousClass6(this));
        this.mAlertDialog.getWindow().setType(2020);
        this.mAlertDialog.show();
        return;
    L10:
        if (this.mWifiManager.setWifiEnabled(r8) == true) goto L12;
        setSwitchEnabledDebounced(true);
        ToastUtils.show(this.mContext, R.string.wifi_error);
    L14:
        if (r7.isChecked() != r8) goto L23;
        CompoundButton.OnCheckedChangeListener r0 = this.mOnCheckedChangeListener;
        if (r0 == null) goto L18;
        r0.onCheckedChanged(r7, r8);
    L18:
        Runnable r6 = this.updateWifiStateRunnable;
        if (r6 == null) goto L24;
        r6.run();
        return;
    L24:
        return;
    L23:
        return;
    L12:
        setSwitchEnabledDebounced(true);
        goto L14
    }

    private boolean mayDisableTethering(boolean r1) {
        int r0 = this.mWifiManager.getWifiApState();
        if (r1 == true) goto L5;
    L9:
        return false;
    L5:
        if (r0 != 12) goto L7;
    L8:
        return true;
    L7:
        if (r0 != 13) goto L9;
        goto L8
    }

    private void showDialog(final CompoundButton r7) {
        this.mProcessor.showDialog(this.mContext, 1, new AnonymousClass7(this, r7), new AnonymousClass8(this, r7), new AnonymousClass9(this, r7));
    }

    public boolean isChecked() {
        return this.mSwitch.isChecked();
    }
}
