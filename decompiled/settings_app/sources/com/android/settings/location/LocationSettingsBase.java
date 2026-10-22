package com.android.settings.location;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.UserManager;
import android.provider.Settings;
import android.util.Log;
import com.GlobalProxyLancet;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.applications.PickApplicationActivity;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LocationSettingsBase extends SettingsPreferenceFragment {
    private static final String CURRENT_MODE_KEY = "CURRENT_MODE";
    private static final String MODE_CHANGING_ACTION = "com.android.settings.location.MODE_CHANGING";
    private static final String NEW_MODE_KEY = "NEW_MODE";
    private static final String TAG = "LocationSettingsBase";
    private boolean mActive;
    private int mCurrentMode;
    private BroadcastReceiver mReceiver;

    public abstract void onModeChanged(int r1, boolean r2);

    public LocationSettingsBase() {
        this.mActive = false;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.mReceiver = new AnonymousClass1(this);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mActive = true;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.location.MODE_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getActivity(), this.mReceiver, r0, 2);
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        unregisterReceiver(this.mReceiver);
        super.onPause();
        this.mActive = false;
    }

    private boolean isRestricted() {
        return ((UserManager) getActivity().getSystemService(PickApplicationActivity.EXTRA_USER)).hasUserRestriction("no_share_location");
    }

    public void setLocationMode(int r5) {
        if (isRestricted() == true) goto L5;
        Intent r0 = new Intent(MODE_CHANGING_ACTION);
        r0.putExtra(CURRENT_MODE_KEY, this.mCurrentMode);
        r0.putExtra(NEW_MODE_KEY, r5);
        getActivity().sendBroadcast(r0, "android.permission.WRITE_SECURE_SETTINGS");
        Settings.Secure.putInt(getContentResolver(), "location_mode", r5);
        refreshLocationMode();
        return;
    L5:
        if (Log.isLoggable(TAG, 4) == false) goto L7;
        OLog.i(TAG, "Restricted user, not setting location mode");
    L7:
        int r6 = Settings.Secure.getInt(getContentResolver(), "location_mode", 0);
        if (this.mActive == false) goto L13;
        onModeChanged(r6, true);
        return;
    }

    public void refreshLocationMode() {
        if (this.mActive == false) goto L9;
        int r0 = Settings.Secure.getInt(getContentResolver(), "location_mode", 0);
        this.mCurrentMode = r0;
        if (Log.isLoggable(TAG, 4) == false) goto L7;
        OLog.i(TAG, "Location mode has been changed");
    L7:
        onModeChanged(r0, isRestricted());
        return;
    }
}
