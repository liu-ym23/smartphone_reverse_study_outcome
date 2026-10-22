package com.android.settings.enterprise;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import com.android.settings.R;
import com.android.settingslib.enterprise.DeviceAdminStringProvider;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class DeviceAdminStringProviderImpl implements DeviceAdminStringProvider {
    private final Context mContext;
    private final DevicePolicyManager mDevicePolicyManager;

    DeviceAdminStringProviderImpl(Context r2) {
        Context r3 = (Context) Objects.requireNonNull(r2);
        this.mContext = r3;
        this.mDevicePolicyManager = (DevicePolicyManager) r3.getSystemService(DevicePolicyManager.class);
    }

    @Override // com.android.settingslib.enterprise.DeviceAdminStringProvider
    public String getDefaultDisabledByPolicyTitle() {
        return this.mDevicePolicyManager.getResources().getString("Settings.DISABLED_BY_IT_ADMIN_TITLE", new DeviceAdminStringProviderImpl$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: lambda$getDefaultDisabledByPolicyTitle$0$com-android-settings-enterprise-DeviceAdminStringProviderImpl, reason: not valid java name */
    /* synthetic */ String m457xcf0966a2() {
        return this.mContext.getString(R.string.disabled_by_policy_title);
    }

    @Override // com.android.settingslib.enterprise.DeviceAdminStringProvider
    public String getDisallowAdjustVolumeTitle() {
        return this.mContext.getString(R.string.disabled_by_policy_title_adjust_volume);
    }

    @Override // com.android.settingslib.enterprise.DeviceAdminStringProvider
    public String getDisallowOutgoingCallsTitle() {
        return this.mContext.getString(R.string.disabled_by_policy_title_outgoing_calls);
    }

    @Override // com.android.settingslib.enterprise.DeviceAdminStringProvider
    public String getDisallowSmsTitle() {
        return this.mContext.getString(R.string.disabled_by_policy_title_sms);
    }

    @Override // com.android.settingslib.enterprise.DeviceAdminStringProvider
    public String getDisableCameraTitle() {
        return this.mContext.getString(R.string.disabled_by_policy_title_camera);
    }

    @Override // com.android.settingslib.enterprise.DeviceAdminStringProvider
    public String getDisableScreenCaptureTitle() {
        return this.mContext.getString(R.string.disabled_by_policy_title_screen_capture);
    }

    @Override // com.android.settingslib.enterprise.DeviceAdminStringProvider
    public String getSuspendPackagesTitle() {
        return this.mContext.getString(R.string.disabled_by_policy_title_suspend_packages);
    }

    @Override // com.android.settingslib.enterprise.DeviceAdminStringProvider
    public String getDefaultDisabledByPolicyContent() {
        return this.mDevicePolicyManager.getResources().getString("Settings.CONTACT_YOUR_IT_ADMIN", new DeviceAdminStringProviderImpl$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$getDefaultDisabledByPolicyContent$1$com-android-settings-enterprise-DeviceAdminStringProviderImpl, reason: not valid java name */
    /* synthetic */ String m456xc9b84c44() {
        return this.mContext.getString(R.string.default_admin_support_msg);
    }

    @Override // com.android.settingslib.enterprise.DeviceAdminStringProvider
    public String getLearnMoreHelpPageUrl() {
        return this.mDevicePolicyManager.getResources().getString("Settings.IT_ADMIN_POLICY_DISABLING_INFO_URL", new DeviceAdminStringProviderImpl$$ExternalSyntheticLambda2(this));
    }

    /* JADX INFO: renamed from: lambda$getLearnMoreHelpPageUrl$2$com-android-settings-enterprise-DeviceAdminStringProviderImpl, reason: not valid java name */
    /* synthetic */ String m458x565eb9f8() {
        return this.mContext.getString(R.string.help_url_action_disabled_by_it_admin);
    }

    @Override // com.android.settingslib.enterprise.DeviceAdminStringProvider
    public String getDisabledByPolicyTitleForFinancedDevice() {
        return this.mContext.getString(R.string.disabled_by_policy_title_financed_device);
    }

    @Override // com.android.settingslib.enterprise.DeviceAdminStringProvider
    public String getDisabledBiometricsParentConsentTitle() {
        return this.mContext.getString(R.string.disabled_by_policy_title_biometric_parental_consent);
    }

    @Override // com.android.settingslib.enterprise.DeviceAdminStringProvider
    public String getDisabledByParentContent() {
        return this.mContext.getString(R.string.disabled_by_policy_parental_consent);
    }

    @Override // com.android.settingslib.enterprise.DeviceAdminStringProvider
    public String getDisabledBiometricsParentConsentContent() {
        return this.mContext.getString(R.string.disabled_by_policy_content_biometric_parental_consent);
    }
}
