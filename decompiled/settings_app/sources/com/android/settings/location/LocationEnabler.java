package com.android.settings.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.util.Log;
import com.GlobalProxyLancet;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.android.settingslib.Utils;
import com.android.settingslib.core.lifecycle.Lifecycle;
import com.android.settingslib.core.lifecycle.LifecycleObserver;
import com.android.settingslib.core.lifecycle.events.OnStart;
import com.android.settingslib.core.lifecycle.events.OnStop;

/* JADX INFO: loaded from: classes2.dex */
public class LocationEnabler implements LifecycleObserver, OnStart, OnStop {
    static final IntentFilter INTENT_FILTER_LOCATION_MODE_CHANGED = null;
    private static final String TAG = "LocationEnabler";
    private final Context mContext;
    private final LocationModeChangeListener mListener;
    BroadcastReceiver mReceiver;
    private final UserManager mUserManager;

    public interface LocationModeChangeListener {
        void onLocationModeChanged(int r1, boolean r2);
    }

    static {
        INTENT_FILTER_LOCATION_MODE_CHANGED = new IntentFilter("android.location.MODE_CHANGED");
    }

    public LocationEnabler(Context r1, LocationModeChangeListener r2, Lifecycle r3) {
        this.mContext = r1;
        this.mListener = r2;
        this.mUserManager = (UserManager) r1.getSystemService(PickApplicationActivity.EXTRA_USER);
        if (r3 == null) goto L6;
        r3.addObserver(this);
        return;
    }

    @Override // com.android.settingslib.core.lifecycle.events.OnStart
    public void onStart() {
        if (this.mReceiver != null) goto L5;
        this.mReceiver = new AnonymousClass1(this);
    L5:
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mReceiver, INTENT_FILTER_LOCATION_MODE_CHANGED);
        refreshLocationMode();
    }

    @Override // com.android.settingslib.core.lifecycle.events.OnStop
    public void onStop() {
        this.mContext.unregisterReceiver(this.mReceiver);
    }

    public void refreshLocationMode() {
        int r0 = Settings.Secure.getInt(this.mContext.getContentResolver(), "location_mode", 0);
        if (Log.isLoggable(TAG, 4) == false) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(TAG, "Location mode has been changed");
    L5:
        LocationModeChangeListener r1 = this.mListener;
        if (r1 == null) goto L9;
        r1.onLocationModeChanged(r0, isRestricted());
        return;
    }

    public void setLocationEnabled(boolean r4) {
        int r0 = Settings.Secure.getInt(this.mContext.getContentResolver(), "location_mode", 0);
        if (isRestricted() == true) goto L5;
        Utils.updateLocationEnabled(this.mContext, r4, UserHandle.myUserId(), 1);
        refreshLocationMode();
        return;
    L5:
        if (Log.isLoggable(TAG, 4) == false) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(TAG, "Restricted user, not setting location mode");
    L7:
        LocationModeChangeListener r3 = this.mListener;
        if (r3 == null) goto L13;
        r3.onLocationModeChanged(r0, true);
        return;
    }

    public boolean isEnabled(int r1) {
        if (r1 != 0) goto L4;
    L6:
        return false;
    L4:
        if (isRestricted() == true) goto L6;
        return true;
    }

    public boolean isManagedProfileRestrictedByBase() {
        UserHandle r0 = com.android.settings.Utils.getManagedProfile(this.mUserManager);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (hasShareLocationRestriction(r0.getIdentifier()) == false) goto L7;
        return true;
    }

    public RestrictedLockUtils.EnforcedAdmin getShareLocationEnforcedAdmin(int r3) {
        RestrictedLockUtils.EnforcedAdmin r0 = RestrictedLockUtilsInternal.checkIfRestrictionEnforced(this.mContext, "no_share_location", r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return RestrictedLockUtilsInternal.checkIfRestrictionEnforced(this.mContext, "no_config_location", r3);
    }

    public boolean hasShareLocationRestriction(int r2) {
        return RestrictedLockUtilsInternal.hasBaseUserRestriction(this.mContext, "no_share_location", r2);
    }

    private boolean isRestricted() {
        return this.mUserManager.hasUserRestriction("no_share_location");
    }
}
