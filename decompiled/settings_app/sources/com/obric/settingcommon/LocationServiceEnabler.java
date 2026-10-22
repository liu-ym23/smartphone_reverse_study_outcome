package com.obric.settingcommon;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.util.Log;
import android.widget.CompoundButton;
import com.GlobalProxyLancet;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settingslib.Utils;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class LocationServiceEnabler extends SettingsEnabler {
    public static final String TAG = "LocationServiceEnabler";
    private BroadcastReceiver mLocationModeChangedReceiver;

    public LocationServiceEnabler(Context r2, OSwitch r3) {
        super(r2, r3);
        this.mLocationModeChangedReceiver = new AnonymousClass1(this);
        updateView();
        IntentFilter r4 = new IntentFilter();
        r4.addAction("android.location.MODE_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mLocationModeChangedReceiver, r4, 2);
    }

    @Override // com.obric.settingcommon.SettingsEnabler
    protected void updateView() {
        this.mSwitch.setChecked(getLocationEnabled());
        this.mSwitch.setOnCheckedChangeListener(this);
    }

    @Override // com.obric.settingcommon.SettingsEnabler, android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        super.onCheckedChanged(r1, r2);
        setLocationEnabled(r2);
    }

    private boolean getLocationEnabled() {
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), "location_mode", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void setLocationEnabled(boolean r3) {
        if (((UserManager) this.mContext.getSystemService(PickApplicationActivity.EXTRA_USER)).hasUserRestriction("no_share_location") == false) goto L6;
        Log.i(TAG, "User is restricted, skipping location change.");
        return;
    L6:
        Utils.updateLocationEnabled(this.mContext, r3, UserHandle.myUserId(), 1);
        TrackerEventUpload.switchEvent("location", r3);
    }
}
