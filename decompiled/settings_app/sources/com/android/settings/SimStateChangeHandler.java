package com.android.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SimStateChangeHandler {
    private static final String ACTION_UICC_MANUAL_PROVISION_STATUS_CHANGED = "org.codeaurora.intent.action.ACTION_UICC_MANUAL_PROVISION_STATUS_CHANGED";
    private Context mContext;
    private final BroadcastReceiver mSimStateChangedReceiver;

    public abstract void onReceive(Context r1, Intent r2);

    private IntentFilter getSimStateChangedFilter() {
        IntentFilter r1 = new IntentFilter("android.intent.action.SIM_STATE_CHANGED");
        r1.addAction("android.intent.action.ACTION_DEFAULT_DATA_SUBSCRIPTION_CHANGED");
        r1.addAction("android.intent.action.ACTION_DEFAULT_VOICE_SUBSCRIPTION_CHANGED");
        r1.addAction("android.telephony.action.DEFAULT_SMS_SUBSCRIPTION_CHANGED");
        r1.addAction(ACTION_UICC_MANUAL_PROVISION_STATUS_CHANGED);
        return r1;
    }

    public SimStateChangeHandler(Context r2) {
        this.mSimStateChangedReceiver = new AnonymousClass1(this);
        this.mContext = r2;
    }

    public void register() {
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mSimStateChangedReceiver, getSimStateChangedFilter(), 2);
    }

    public void unregister() {
        this.mContext.unregisterReceiver(this.mSimStateChangedReceiver);
    }
}
