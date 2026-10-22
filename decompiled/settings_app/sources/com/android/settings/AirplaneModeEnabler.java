package com.android.settings;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.SystemProperties;
import android.os.UserHandle;
import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;
import com.android.internal.telephony.PhoneStateIntentReceiver;
import com.android.settingslib.WirelessUtils;

/* JADX INFO: loaded from: classes2.dex */
public class AirplaneModeEnabler implements Preference.OnPreferenceChangeListener {
    private static final int EVENT_SERVICE_STATE_CHANGED = 3;
    private ContentObserver mAirplaneModeObserver;
    private final CheckBoxPreference mCheckBoxPref;
    private final Context mContext;
    private Handler mHandler;
    private PhoneStateIntentReceiver mPhoneStateReceiver;

    static /* synthetic */ void access$000(AirplaneModeEnabler r0) {
        r0.onAirplaneModeChanged();
    }

    public AirplaneModeEnabler(Context r3, CheckBoxPreference r4) {
        this.mHandler = new AnonymousClass1(this);
        final Handler r1 = new Handler();
        this.mAirplaneModeObserver = new AnonymousClass2(this, r1);
        this.mContext = r3;
        this.mCheckBoxPref = r4;
        r4.setPersistent(false);
        PhoneStateIntentReceiver r5 = new PhoneStateIntentReceiver(r3, this.mHandler);
        this.mPhoneStateReceiver = r5;
        r5.notifyServiceState(3);
    }

    public void resume() {
        this.mCheckBoxPref.setChecked(isAirplaneModeOn(this.mContext));
        this.mPhoneStateReceiver.registerIntent();
        this.mCheckBoxPref.setOnPreferenceChangeListener(this);
        this.mContext.getContentResolver().registerContentObserver(android.provider.Settings.Global.getUriFor("airplane_mode_on"), true, this.mAirplaneModeObserver);
    }

    public void pause() {
        this.mPhoneStateReceiver.unregisterIntent();
        this.mCheckBoxPref.setOnPreferenceChangeListener(null);
        this.mContext.getContentResolver().unregisterContentObserver(this.mAirplaneModeObserver);
    }

    public static boolean isAirplaneModeOn(Context r2) {
        if (android.provider.Settings.Global.getInt(r2.getContentResolver(), "airplane_mode_on", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void setAirplaneModeOn(boolean r3) {
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), "airplane_mode_on", r3 ? 1 : 0);
        this.mCheckBoxPref.setChecked(r3);
        Intent r0 = new Intent("android.intent.action.AIRPLANE_MODE");
        r0.putExtra("state", r3);
        this.mContext.sendBroadcastAsUser(r0, UserHandle.ALL);
    }

    private void onAirplaneModeChanged() {
        this.mCheckBoxPref.setChecked(WirelessUtils.isAirplaneModeOn(this.mContext));
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r1, Object r2) {
        if (Boolean.parseBoolean(SystemProperties.get("ril.cdma.inecmmode")) == true) goto L8;
        setAirplaneModeOn(((Boolean) r2).booleanValue());
        return true;
    L8:
        return true;
    }

    public void setAirplaneModeInECM(boolean r1, boolean r2) {
        if (r1 == false) goto L4;
        setAirplaneModeOn(r2);
        return;
    L4:
        onAirplaneModeChanged();
    }
}
