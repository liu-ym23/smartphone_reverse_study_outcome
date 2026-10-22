package com.qualcomm.qti.internal.telephony.data;

import android.R;
import android.os.Looper;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.data.DataConfigManager;

/* JADX INFO: loaded from: classes4.dex */
public class QtiDataConfigManager extends DataConfigManager {
    private static final int EVENT_CARRIER_CONFIG_CHANGED = 1;
    protected String[] mApnsWithSameGID;
    protected boolean mIsApnFilteringRequired;

    public QtiDataConfigManager(Phone r1, Looper r2) {
        super(r1, r2);
        log("QtiDataConfigManager: constructor");
    }

    public void onCarrierConfigLoadedForEssentialRecords() {
        log("QtiDCM onCarrierConfigLoadedForEssentialRecords");
        sendEmptyMessage(1);
    }

    protected void updateOtherConfigs() {
        this.mApnsWithSameGID = this.mCarrierConfig.getStringArray("multi_apn_array_for_same_gid");
        this.mIsApnFilteringRequired = this.mCarrierConfig.getBoolean("require_apn_filtering_with_radio_capability_bool");
    }

    public boolean isApnFilteringWithRadioCapabilityRequired() {
        return this.mIsApnFilteringRequired;
    }

    public String[] getApnsWithSameGID() {
        return this.mApnsWithSameGID;
    }

    public boolean isPdpRejectConfigEnabled() {
        return this.mResources.getBoolean(R.bool.config_enableTimeoutToDockUserWhenDocked);
    }

    public long getPdpRejectRetryDelay() {
        return this.mResources.getInteger(R.integer.config_lowPowerStandbyNonInteractiveTimeout);
    }

    public String getPdpRejectDialogTitle() {
        return this.mResources.getString(R.string.config_pdp_reject_user_authentication_failed);
    }

    public String getPdpRejectCauseUserAuthentication() {
        return this.mResources.getString(R.string.config_pluginsProviderJarPath);
    }

    public String getPdpRejectCauseServiceNotSubscribed() {
        return this.mResources.getString(R.string.config_platformVpnConfirmDialogComponent);
    }

    public String getPdpRejectCauseSamePdnNotAllowed() {
        return this.mResources.getString(R.string.config_persistentDataPackageName);
    }
}
