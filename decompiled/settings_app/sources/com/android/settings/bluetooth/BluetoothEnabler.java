package com.android.settings.bluetooth;

import android.casthal.CasthalManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.widget.CompoundButton;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.SettingsTracker;
import com.android.settings.SystemAlertDialog;
import com.android.settings.ToastUtils;
import com.android.settings.WirelessSettings;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.teaevent.TrackerEvent;
import com.android.settings.utils.SmtTntUtil;
import com.obric.olog.OLog;
import com.obric.oui.oswitch.OSwitch;
import obric.bluetooth.SmartBluetoothBinderClient;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothEnabler implements CompoundButton.OnCheckedChangeListener {
    private Boolean isShowDowning;
    private SystemAlertDialog mAlertDialog;
    private final Context mContext;
    private final IntentFilter mIntentFilter;
    private final LocalBluetoothAdapter mLocalAdapter;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
    private OnUpdateViewListener mOnUpdateViewListener;
    private final BroadcastReceiver mReceiver;
    private boolean mReleased;
    private SmartBluetoothBinderClient mSmartBluetoothBinderClient;
    private OSwitch mSwitch;
    private boolean mValidListener;

    public interface OnUpdateViewListener {
        void onUpdateView(boolean r1);
    }

    static /* synthetic */ Boolean access$000(BluetoothEnabler r0) {
        return r0.isShowDowning;
    }

    static /* synthetic */ Boolean access$002(BluetoothEnabler r0, Boolean r1) {
        r0.isShowDowning = r1;
        return r1;
    }

    static /* synthetic */ LocalBluetoothAdapter access$100(BluetoothEnabler r0) {
        return r0.mLocalAdapter;
    }

    static /* synthetic */ boolean access$202(BluetoothEnabler r0, boolean r1) {
        r0.mReleased = r1;
        return r1;
    }

    static /* synthetic */ OSwitch access$300(BluetoothEnabler r0) {
        return r0.mSwitch;
    }

    static /* synthetic */ CompoundButton.OnCheckedChangeListener access$400(BluetoothEnabler r0) {
        return r0.mOnCheckedChangeListener;
    }

    public BluetoothEnabler(Context r3, OSwitch r4, SmartBluetoothBinderClient r5) {
        this.mValidListener = false;
        this.mReleased = true;
        this.isShowDowning = false;
        this.mReceiver = new AnonymousClass1(this);
        this.mContext = r3;
        this.mSwitch = r4;
        this.mValidListener = false;
        this.mSmartBluetoothBinderClient = r5;
        LocalBluetoothManager r6 = LocalBluetoothManager.getInstance(r3);
        if (r6 != null) goto L5;
        this.mLocalAdapter = null;
        this.mSwitch.setEnabled(false);
    L6:
        IntentFilter r7 = new IntentFilter();
        this.mIntentFilter = r7;
        r7.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        r7.addAction("android.intent.action.ACTION_SHUTDOWN");
        r7.setPriority(1000);
        return;
    L5:
        this.mLocalAdapter = r6.getBluetoothAdapter();
        goto L6
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener r1) {
        this.mOnCheckedChangeListener = r1;
    }

    public void resume() {
        LocalBluetoothAdapter r0 = this.mLocalAdapter;
        if (r0 != null) goto L6;
        this.mSwitch.setEnabled(false);
        return;
    L6:
        handleStateChanged(r0.getBluetoothState());
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mReceiver, this.mIntentFilter, 2);
        this.mSwitch.setOnCheckedChangeListener(this);
        this.mValidListener = true;
    }

    public void pause() {
        if (this.mLocalAdapter != null) goto L11;
        return;
    L11:
        this.mContext.unregisterReceiver(this.mReceiver);     // Catch: Exception -> L7
    L9:
        this.mSwitch.setOnCheckedChangeListener(null);
        this.mValidListener = false;
        return;
    L7:
        e = move-exception;
        OLog.e("BluetoothEnabler", "unregister receiver failed", e);
        goto L9
    }

    public void setSwitch(OSwitch r5) {
        OSwitch r0 = this.mSwitch;
        if (r0 != r5) goto L5;
        return;
    L5:
        CompoundButton.OnCheckedChangeListener r1 = null;
        r0.setOnCheckedChangeListener(null);
        this.mSwitch = r5;
        if (this.mValidListener == false) goto L8;
        r1 = this;
    L8:
        r5.setOnCheckedChangeListener(r1);
        LocalBluetoothAdapter r6 = this.mLocalAdapter;
        if (r6 == null) goto L11;
        int r7 = r6.getBluetoothState();
    L12:
        boolean r2 = true;
        if (r7 != 12) goto L15;
        boolean r3 = true;
    L16:
        if (r7 != 10) goto L18;
        boolean r8 = true;
    L19:
        this.mSwitch.setChecked(r3);
        OSwitch r4 = this.mSwitch;
        if (r3 == true) goto L24;
        if (r8 == true) goto L24;
        r2 = false;
    L24:
        r4.setEnabled(r2);
        return;
    L18:
        r8 = false;
        goto L19
    L15:
        r3 = false;
        goto L16
    L11:
        r7 = 10;
        goto L12
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(final CompoundButton r5, final boolean r6) {
        if (r6 == true) goto L5;
    L7:
        if (r6 == true) goto L14;
        if (SmtTntUtil.isSmtDisplayVirtualMode(this.mContext) == false) goto L14;
        if (CasthalManager.getInstance(this.mContext).isBostonConnected() == false) goto L14;
        SystemAlertDialog r1 = new SystemAlertDialog(this.mContext);
        this.mAlertDialog = r1;
        r1.setTitle(R.string.dlg_title_notice);
        this.mAlertDialog.setMessage(this.mContext.getString(R.string.close_bluetooth_switch_dialog_content));
        this.mAlertDialog.setCancelable(true);
        this.mAlertDialog.setPositiveButton(R.string.notification_warning_dialog_ok_btn, new AnonymousClass2(this, r6, r5));
        this.mAlertDialog.setNegativeButton(R.string.hand_in_hand_dialog_cancel_button_text, new AnonymousClass3(this));
        this.mAlertDialog.setOnCancelListener(new AnonymousClass4(this));
        this.mAlertDialog.getWindow().setType(2020);
        this.mAlertDialog.show();
    L24:
        SettingsTracker.onSwitcherClick(501, r6);
        TrackerEvent.switchEvent("bluetooth", r6);
        return;
    L14:
        if (this.mReleased == true) goto L16;
        return;
    L16:
        this.mReleased = false;
        this.mSwitch.setEnabled(false);
        AppMetricsUtils.INSTANCE.swapSceneStart("bluetooth_switch", r6);
        LocalBluetoothAdapter r2 = this.mLocalAdapter;
        if (r2 == null) goto L20;
        r2.setBluetoothEnabled(r6);
    L20:
        if (r5.isChecked() != r6) goto L24;
        CompoundButton.OnCheckedChangeListener r4 = this.mOnCheckedChangeListener;
        if (r4 == null) goto L24;
        r4.onCheckedChanged(r5, r6);
        goto L24
    L5:
        if (WirelessSettings.isRadioAllowed(this.mContext, "bluetooth") == true) goto L7;
        ToastUtils.show(this.mContext, R.string.wifi_in_airplane_mode);
        r5.setChecked(false);
        goto L7
    }

    void handleStateChanged(int r4) {
        switch(r4) {
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L6;
            case 13: goto L5;
            default: goto L4;
        };
    L4:
        this.mSwitch.setChecked(false);
        this.mSwitch.setEnabled(true);
        AppMetricsUtils.INSTANCE.swapSceneEnd("bluetooth_switch");
        return;
    L5:
        this.mSwitch.setEnabled(false);
        return;
    L6:
        this.mSwitch.setChecked(true);
        this.mSwitch.setEnabled(true);
        this.mReleased = true;
        OnUpdateViewListener r5 = this.mOnUpdateViewListener;
        if (r5 == null) goto L9;
        r5.onUpdateView(true);
    L9:
        SmartBluetoothBinderClient r3 = this.mSmartBluetoothBinderClient;
        if (r3 == null) goto L12;
        r3.doBind();
    L12:
        AppMetricsUtils.INSTANCE.swapSceneEnd("bluetooth_switch");
        return;
    L13:
        this.mSwitch.setEnabled(false);
        return;
    L14:
        this.mSwitch.setChecked(false);
        this.mSwitch.setEnabled(true);
        this.mReleased = true;
        OnUpdateViewListener r6 = this.mOnUpdateViewListener;
        if (r6 == null) goto L17;
        r6.onUpdateView(false);
    L17:
        SystemAlertDialog r7 = this.mAlertDialog;
        if (r7 != null) goto L20;
    L22:
        SmartBluetoothBinderClient r8 = this.mSmartBluetoothBinderClient;
        if (r8 == null) goto L25;
        r8.close();
    L25:
        AppMetricsUtils.INSTANCE.swapSceneEnd("bluetooth_switch");
        return;
    L20:
        if (r7.isShowing() == false) goto L22;
        this.mAlertDialog.dismiss();
        goto L22
    }

    public void setOnUpdateViewListener(OnUpdateViewListener r1) {
        this.mOnUpdateViewListener = r1;
    }
}
