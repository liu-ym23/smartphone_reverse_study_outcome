package com.android.settingslib.enterprise;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class FinancedDeviceActionDisabledByAdminController extends BaseActionDisabledByAdminController {
    @Override // com.android.settingslib.enterprise.ActionDisabledByAdminController
    public CharSequence getAdminSupportContentString(Context r1, CharSequence r2) {
        return r2;
    }

    FinancedDeviceActionDisabledByAdminController(DeviceAdminStringProvider r1) {
        super(r1);
    }

    @Override // com.android.settingslib.enterprise.ActionDisabledByAdminController
    public void setupLearnMoreButton(Context r3) {
        assertInitialized();
        this.mLauncher.setupLearnMoreButtonToShowAdminPolicies(r3, this.mEnforcementAdminUserId, this.mEnforcedAdmin);
    }

    @Override // com.android.settingslib.enterprise.ActionDisabledByAdminController
    public String getAdminSupportTitle(String r1) {
        return this.mStringProvider.getDisabledByPolicyTitleForFinancedDevice();
    }
}
