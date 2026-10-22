package com.android.settings;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.UserHandle;
import com.obric.oui.oswitch.OSwitch;
import obric.widget.SwitchEx;

/* JADX INFO: loaded from: classes2.dex */
public final class GpsEnabler {
    public static final int SDK_INT_29 = 29;
    private ContentResolver mContentResolver;
    private Context mContext;
    private final ContentObserver mGpsObserver;
    private MainSettingsFragment.SettingItem mSettingItem;
    private SwitchEx mSwitchEx;

    public void updateGpsSwitchState() {
        boolean r0 = isGpsOn();
        isNetworkLocationOn();
        MainSettingsFragment.SettingItem r1 = this.mSettingItem;
        if (r1 == null) goto L5;
        r1.mChecked = r0;
    L5:
        SwitchEx r2 = this.mSwitchEx;
        if (r2 == null) goto L9;
        r2.setChecked(r0);
        return;
    }

    public void updateOSwitch(OSwitch r1) {
        boolean r0 = isGpsOn();
        if (r1 == null) goto L6;
        r1.setChecked(r0);
        return;
    }

    public boolean getGpsSwitchState() {
        boolean r0 = isGpsOn();
        isNetworkLocationOn();
        MainSettingsFragment.SettingItem r1 = this.mSettingItem;
        if (r1 == null) goto L5;
        r1.mChecked = r0;
    L5:
        SwitchEx r2 = this.mSwitchEx;
        if (r2 == null) goto L8;
        r2.setChecked(r0);
    L8:
        return r0;
    }

    public GpsEnabler(Context r1, MainSettingsFragment.SettingItem r2, ContentObserver r3) {
        this.mContext = r1;
        this.mSettingItem = r2;
        this.mGpsObserver = r3;
        this.mContentResolver = r1.getContentResolver();
    }

    public GpsEnabler(Context r1, SwitchEx r2, ContentObserver r3) {
        this.mContext = r1;
        this.mSwitchEx = r2;
        this.mGpsObserver = r3;
        this.mContentResolver = r1.getContentResolver();
    }

    public GpsEnabler(Context r1, ContentObserver r2) {
        this.mContext = r1;
        this.mGpsObserver = r2;
        this.mContentResolver = r1.getContentResolver();
    }

    private boolean isGpsOn() {
        if (android.provider.Settings.Secure.getInt(this.mContext.getContentResolver(), "location_mode", 0) != 3) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isNetworkLocationOn() {
        return android.provider.Settings.Secure.isLocationProviderEnabled(this.mContentResolver, "network");
    }

    public void resume() {
        updateGpsSwitchState();
        this.mContentResolver.registerContentObserver(android.provider.Settings.Secure.getUriFor("location_mode"), true, this.mGpsObserver);
    }

    public void pause() {
        this.mContentResolver.unregisterContentObserver(this.mGpsObserver);
    }

    public void setLocationProviderEnabled(boolean r3) {
        com.android.settingslib.Utils.updateLocationEnabled(this.mContext, r3, UserHandle.myUserId(), 1);
    }
}
