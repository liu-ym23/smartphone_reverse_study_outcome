package com.obric.settingcommon;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.widget.CompoundButton;
import com.GlobalProxyLancet;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class BluetoothSettingsEnabler extends SettingsEnabler {
    private BroadcastReceiver mBluetoothReceiver;
    AsyncTask<Void, Void, Void> mTask;

    public BluetoothSettingsEnabler(Context r1, OSwitch r2) {
        super(r1, r2);
        this.mBluetoothReceiver = new AnonymousClass1(this);
        updateView();
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        this.mSwitch.setOnCheckedChangeListener(null);
        BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();
        if (r0 != null) goto L6;
        this.mSwitch.setEnabled(false);
        this.mSwitch.setChecked(false);
    L12:
        this.mSwitch.setOnCheckedChangeListener(this);
        return;
    L6:
        switch(r0.getState()) {
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            default: goto L12;
        };
    L8:
        this.mSwitch.setEnabled(false);
        this.mSwitch.setChecked(false);
        goto L12
    L9:
        this.mSwitch.setEnabled(true);
        this.mSwitch.setChecked(true);
        goto L12
    L10:
        this.mSwitch.setEnabled(false);
        this.mSwitch.setChecked(true);
        goto L12
    L11:
        this.mSwitch.setEnabled(true);
        this.mSwitch.setChecked(false);
        goto L12
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, final boolean r3) {
        super.onCheckedChanged(r2, r3);
        this.mSwitch.setEnabled(false);
        this.mTask = new AnonymousClass2(this, r3);
        if (r3 == false) goto L5;
    L7:
        this.mTask.execute(new Void[0]);
        return;
    L5:
        if (isWirelessBostonOn() == false) goto L7;
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    public void doConfirm(boolean r1) {
        super.doConfirm(r1);
        this.mTask.execute(new Void[0]);
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    public void onTntConfirmDialogDismiss() {
        super.onTntConfirmDialogDismiss();
        this.mContext.unregisterReceiver(this.mBluetoothReceiver);
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    public void onTntConfirmDialogShow() {
        super.onTntConfirmDialogShow();
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mBluetoothReceiver, r0, 2);
    }
}
