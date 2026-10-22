package com.obric.settingcommon;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.widget.CompoundButton;
import com.obric.oui.oswitch.OSwitch;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes5.dex */
public final class NfcEnablerSearch extends SettingsEnabler {
    private NfcAdapter mNfcAdapter;

    public NfcEnablerSearch(Context r1, OSwitch r2) {
        super(r1, r2);
        NfcAdapter r3 = NfcAdapter.getDefaultAdapter(r1);
        this.mNfcAdapter = r3;
        if (r3 != null) goto L6;
        this.mSwitch.setEnabled(false);
        this.mSwitch.setOnCheckedChangeListener(null);
        return;
    L6:
        updateView();
    }

    private void handleNfcStateChanged(int r4) {
        this.mSwitch.setOnCheckedChangeListener(null);
        if (r4 != 1) goto L5;
        this.mSwitch.setChecked(false);
        this.mSwitch.setEnabled(true);
    L15:
        this.mSwitch.setOnCheckedChangeListener(this);
        return;
    L5:
        if (r4 != 2) goto L7;
        this.mSwitch.setChecked(true);
        this.mSwitch.setEnabled(false);
        goto L15
    L7:
        if (r4 != 3) goto L9;
        this.mSwitch.setChecked(true);
        this.mSwitch.setEnabled(true);
        goto L15
    L9:
        if (r4 != 4) goto L15;
        this.mSwitch.setChecked(false);
        this.mSwitch.setEnabled(false);
        goto L15
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        handleNfcStateChanged(this.mNfcAdapter.getAdapterState());
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        super.onCheckedChanged(r2, r3);
        this.mSwitch.setEnabled(false);
        if (r3 == false) goto L5;
        this.mNfcAdapter.enable();
    L6:
        TrackerEventUpload.switchEvent(SettingsSwitchKeyUtil.NFC, r3);
        return;
    L5:
        this.mNfcAdapter.disable();
        goto L6
    }
}
