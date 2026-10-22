package com.android.settings;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.UserHandle;
import com.android.internal.telephony.PhoneStateIntentReceiver;
import com.android.settings.teaevent.AppMetricsUtils;
import obric.widget.SwitchEx;

/* JADX INFO: loaded from: classes2.dex */
public class AirplaneModeEnablerEx {
    private static final int EVENT_SERVICE_STATE_CHANGED = 3;
    private ContentObserver mAirplaneModeObserver;
    private final Context mContext;
    private Handler mHandler;
    private final ContentObserver mObserver;
    private PhoneStateIntentReceiver mPhoneStateReceiver;
    private MainSettingsFragment.SettingItem mSettingItem;
    private SwitchEx mSwitchEx;

    static /* synthetic */ void access$000(AirplaneModeEnablerEx r0) {
        r0.onAirplaneModeChanged();
    }

    static /* synthetic */ ContentObserver access$100(AirplaneModeEnablerEx r0) {
        return r0.mAirplaneModeObserver;
    }

    public AirplaneModeEnablerEx(Context r3) {
        this.mHandler = new AnonymousClass1(this);
        final Handler r1 = new Handler();
        this.mObserver = new AnonymousClass2(this, r1);
        this.mContext = r3;
    }

    public AirplaneModeEnablerEx(Context r3, MainSettingsFragment.SettingItem r4, ContentObserver r5) {
        this.mHandler = new AnonymousClass1(this);
        final Handler r1 = new Handler();
        this.mObserver = new AnonymousClass2(this, r1);
        this.mContext = r3;
        this.mSettingItem = r4;
        this.mAirplaneModeObserver = r5;
    }

    public AirplaneModeEnablerEx(Context r3, SwitchEx r4, ContentObserver r5) {
        this.mHandler = new AnonymousClass1(this);
        final Handler r1 = new Handler();
        this.mObserver = new AnonymousClass2(this, r1);
        this.mContext = r3;
        this.mAirplaneModeObserver = r5;
        this.mSwitchEx = r4;
    }

    public void resume() {
        MainSettingsFragment.SettingItem r0 = this.mSettingItem;
        if (r0 == null) goto L5;
        r0.mChecked = isAirplaneModeOn(this.mContext);
    L5:
        SwitchEx r1 = this.mSwitchEx;
        if (r1 == null) goto L8;
        r1.setChecked(isAirplaneModeOn(this.mContext));
    L8:
        this.mContext.getContentResolver().registerContentObserver(android.provider.Settings.Global.getUriFor("airplane_mode_on"), true, this.mObserver);
    }

    public void pause() {
        this.mContext.getContentResolver().unregisterContentObserver(this.mObserver);
    }

    public static boolean isAirplaneModeOn(Context r2) {
        if (android.provider.Settings.Global.getInt(r2.getContentResolver(), "airplane_mode_on", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public void setAirplaneModeOn(boolean r3) {
        AppMetricsUtils.INSTANCE.swapSceneStart("airplane_mode", r3);
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), "airplane_mode_on", r3 ? 1 : 0);
        Intent r0 = new Intent("android.intent.action.AIRPLANE_MODE");
        r0.putExtra("state", r3);
        this.mContext.sendBroadcastAsUser(r0, UserHandle.ALL);
    }

    private void onAirplaneModeChanged() {
        MainSettingsFragment.SettingItem r0 = this.mSettingItem;
        if (r0 == null) goto L5;
        r0.mChecked = isAirplaneModeOn(this.mContext);
    L5:
        SwitchEx r1 = this.mSwitchEx;
        if (r1 == null) goto L8;
        r1.setChecked(isAirplaneModeOn(this.mContext));
    L8:
        AppMetricsUtils.INSTANCE.swapSceneEnd("airplane_mode");
    }
}
