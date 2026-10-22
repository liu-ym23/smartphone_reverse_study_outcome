package com.obric.settingcommon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.GlobalProxyLancet;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class SilentModeEnablerClient extends SettingsEnablerClient {
    private final BroadcastReceiver mRingerModeReceiver;

    public SilentModeEnablerClient(Context r1, OSwitch r2, String r3) {
        super(r1, r2, r3);
        this.mRingerModeReceiver = new AnonymousClass1(this);
        registerReceiver(r1);
    }

    private void registerReceiver(Context r3) {
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.media.RINGER_MODE_CHANGED");
        r0.addAction("android.media.INTERNAL_RINGER_MODE_CHANGED_ACTION");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3, this.mRingerModeReceiver, r0, 2);
    }
}
