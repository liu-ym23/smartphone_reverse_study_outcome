package com.android.settings;

import android.content.Context;
import android.net.ConnectivityManager;
import android.telephony.PhoneStateListener;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0;
import com.android.settings.utils.DevicePolicyUtils;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public final class CellularEnabler {
    private TelephonyCallback cellularCallback;
    private ConnectivityManager mConnService;
    private Context mContext;
    private TelephonyManager mPhoneManager;
    private PhoneStateListener mPhoneStateListener;
    private MainSettingsFragment.SettingItem mSettingItem;

    private void setMobileDataEnabled(boolean r1) {
    }

    public CellularEnabler(Context r2, MainSettingsFragment.SettingItem r3, TelephonyCallback r4) {
        this.mPhoneStateListener = new AnonymousClass1(this);
        this.mSettingItem = r3;
        init(r2);
        this.cellularCallback = r4;
    }

    private void init(Context r2) {
        this.mContext = r2;
        this.mConnService = (ConnectivityManager) r2.getSystemService("connectivity");
        this.mPhoneManager = (TelephonyManager) r2.getSystemService(MultiSimAdapter.PHONE_KEY);
    }

    private void registePhoneStateListener() {
        this.mPhoneManager.listen(this.mPhoneStateListener, 64);
    }

    private void unregistePhoneStateListener() {
        this.mPhoneManager.listen(this.mPhoneStateListener, 0);
    }

    private void registeMobileDataChangeObserver() {
        getDdsTm().registerTelephonyCallback(new ProfileInstallReceiver$$ExternalSyntheticLambda0(), this.cellularCallback);
    }

    private void unregisteMobileDataChangeObserver() {
        getDdsTm().unregisterTelephonyCallback(this.cellularCallback);
    }

    private TelephonyManager getDdsTm() {
        int r0 = SubscriptionManager.getDefaultDataSubscriptionId();
        return TelephonyManager.from(this.mContext).createForSubscriptionId(r0);
    }

    protected void updateSettingItemState() {
        if (this.mSettingItem == null) goto L27;
        boolean r0 = DevicePolicyUtils.hasUserRestriction(this.mContext, "no_config_mobile_networks");
        boolean r1 = AirplaneModeEnablerEx.isAirplaneModeOn(this.mContext);
        boolean r2 = Utils.isSimExists();
        boolean r3 = false;
        if (r0 == false) goto L7;
        this.mSettingItem.mSubTitle = this.mContext.getString(R.string.disabled_by_admin_summary_text);
    L21:
        MainSettingsFragment.SettingItem r6 = this.mSettingItem;
        if (r1 == true) goto L25;
        if (r0 == true) goto L25;
        r3 = true;
    L25:
        r6.mEnable = r3;
        return;
    L7:
        if (r1 == false) goto L9;
        this.mSettingItem.mSubTitle = this.mContext.getString(R.string.airplane_mode_header_title);
        goto L21
    L9:
        if (r2 == true) goto L12;
        this.mSettingItem.mSubTitle = this.mContext.getString(R.string.sim_not_found);
        goto L21
    L12:
        if (isMobileDataEnabled() == true) goto L14;
        this.mSettingItem.mSubTitle = this.mContext.getString(R.string.cellular_state_off);
        goto L21
    L14:
        if (Utils.hasMultiSimInDevice() == false) goto L19;
        int r4 = SubscriptionManager.getPhoneId(SubscriptionManager.getDefaultDataSubscriptionId());
        if (SubscriptionManager.isValidPhoneId(r4) == true) goto L18;
        OLog.e("CellularEnabler", "invalid PhoneId : " + r4);
        r4 = 0;
    L18:
        this.mSettingItem.mSubTitle = MultiSimUtil.getSimName(this.mContext, r4);
        goto L21
    L19:
        this.mSettingItem.mSubTitle = this.mContext.getString(R.string.cellular_state_on);
        goto L21
    }

    public void resume() {
        updateSettingItemState();
        registeMobileDataChangeObserver();
    }

    public void pause() {
        unregisteMobileDataChangeObserver();
    }

    private boolean isMobileDataEnabled() {
        return this.mConnService.getMobileDataEnabled();
    L4:
        e = move-exception;
        OLog.e("CellularEnabler", "isMobileDataEnabled: " + e);
        return false;
    }
}
