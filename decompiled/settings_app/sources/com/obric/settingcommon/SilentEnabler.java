package com.obric.settingcommon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.widget.CompoundButton;
import com.GlobalProxyLancet;
import com.obric.oui.oswitch.OSwitch;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes5.dex */
public final class SilentEnabler extends SettingsEnabler {
    private AudioManager audioManager;
    private BroadcastReceiver mRingerModeReceiver;

    static /* synthetic */ boolean access$000(SilentEnabler r0) {
        return r0.isSilentMode();
    }

    public SilentEnabler(Context r2, OSwitch r3) {
        super(r2, r3);
        this.mRingerModeReceiver = new AnonymousClass1(this);
        AudioManager r4 = (AudioManager) r2.getSystemService("audio");
        this.audioManager = r4;
        if (r4 != null) goto L6;
        this.mSwitch.setEnabled(false);
        this.mSwitch.setOnCheckedChangeListener(null);
        return;
    L6:
        updateView();
        IntentFilter r5 = new IntentFilter();
        r5.addAction("android.media.RINGER_MODE_CHANGED");
        r5.addAction("android.media.INTERNAL_RINGER_MODE_CHANGED_ACTION");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r2, this.mRingerModeReceiver, r5, 2);
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        this.mSwitch.setChecked(isSilentMode());
        this.mSwitch.setOnCheckedChangeListener(this);
    }

    private boolean isSilentMode() {
        if (this.audioManager.getRingerModeInternal() == 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        super.onCheckedChanged(r1, r2);
        this.mSwitch.setChecked(r2);
        AudioManager r0 = this.audioManager;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setRingerModeInternal(r3);
        TrackerEventUpload.switchEvent(SettingsSwitchKeyUtil.SILENT_MODE, r2);
        return;
    L5:
        r3 = 2;
        goto L6
    }
}
