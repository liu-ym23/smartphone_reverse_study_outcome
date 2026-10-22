package com.android.settings.nfc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.os.UserHandle;
import androidx.preference.Preference;
import androidx.preference.SwitchPreference;
import com.GlobalProxyLancet;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settingslib.RestrictedPreference;

/* JADX INFO: loaded from: classes2.dex */
public class NfcEnabler implements Preference.OnPreferenceChangeListener {
    private final RestrictedPreference mAndroidBeam;
    private boolean mBeamDisallowedBySystem;
    private final Context mContext;
    private final IntentFilter mIntentFilter;
    private final NfcAdapter mNfcAdapter;
    private final BroadcastReceiver mReceiver;
    private final SwitchPreference mSwitch;

    static /* synthetic */ void access$000(NfcEnabler r0, int r1) {
        r0.handleNfcStateChanged(r1);
    }

    public NfcEnabler(Context r4, SwitchPreference r5, RestrictedPreference r6) {
        this.mReceiver = new AnonymousClass1(this);
        this.mContext = r4;
        this.mSwitch = r5;
        this.mAndroidBeam = r6;
        NfcAdapter r0 = NfcAdapter.getDefaultAdapter(r4);
        this.mNfcAdapter = r0;
        boolean r7 = MultiSDKAdapterNew.hasBaseUserRestriction(r4, "no_outgoing_beam", UserHandle.myUserId());
        this.mBeamDisallowedBySystem = r7;
        if (r0 != null) goto L6;
        r5.setEnabled(false);
        r6.setEnabled(false);
        this.mIntentFilter = null;
        return;
    L6:
        if (r7 == false) goto L8;
        r6.setEnabled(false);
    L8:
        this.mIntentFilter = new IntentFilter("android.nfc.action.ADAPTER_STATE_CHANGED");
    }

    public void resume() {
        NfcAdapter r0 = this.mNfcAdapter;
        if (r0 != null) goto L5;
        return;
    L5:
        handleNfcStateChanged(r0.getAdapterState());
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mReceiver, this.mIntentFilter, 2);
        this.mSwitch.setOnPreferenceChangeListener(this);
    }

    public void pause() {
        if (this.mNfcAdapter != null) goto L5;
        return;
    L5:
        this.mContext.unregisterReceiver(this.mReceiver);
        this.mSwitch.setOnPreferenceChangeListener(null);
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r2, Object r3) {
        boolean r4 = ((Boolean) r3).booleanValue();
        this.mSwitch.setEnabled(false);
        if (r4 == false) goto L5;
        this.mNfcAdapter.enable();
    L6:
        return false;
    L5:
        this.mNfcAdapter.disable();
        goto L6
    }

    private void handleNfcStateChanged(int r4) {
        if (r4 != 1) goto L5;
        this.mSwitch.setChecked(false);
        this.mSwitch.setEnabled(true);
        this.mAndroidBeam.setEnabled(false);
        this.mAndroidBeam.setSummary(R.string.android_beam_disabled_summary);
        return;
    L5:
        if (r4 != 2) goto L7;
        this.mSwitch.setChecked(true);
        this.mSwitch.setEnabled(false);
        this.mAndroidBeam.setEnabled(false);
        return;
    L7:
        if (r4 != 3) goto L9;
        this.mSwitch.setChecked(true);
        this.mSwitch.setEnabled(true);
        if (this.mBeamDisallowedBySystem == false) goto L15;
        this.mAndroidBeam.setDisabledByAdmin(null);
        this.mAndroidBeam.setEnabled(false);
    L17:
        if (this.mNfcAdapter.isNdefPushEnabled() == true) goto L19;
    L21:
        this.mAndroidBeam.setSummary(R.string.android_beam_off_summary);
        return;
    L19:
        if (this.mAndroidBeam.isEnabled() == false) goto L21;
        this.mAndroidBeam.setSummary(R.string.android_beam_on_summary);
        return;
    L15:
        this.mAndroidBeam.checkRestrictionAndSetDisabled("no_outgoing_beam");
        goto L17
    L9:
        if (r4 != 4) goto L29;
        this.mSwitch.setChecked(false);
        this.mSwitch.setEnabled(false);
        this.mAndroidBeam.setEnabled(false);
        return;
    }
}
