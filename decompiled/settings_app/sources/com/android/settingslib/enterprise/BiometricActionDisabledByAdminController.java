package com.android.settingslib.enterprise;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.GlobalProxyLancet;
import com.android.settingslib.RestrictedLockUtils;

/* JADX INFO: loaded from: classes.dex */
public class BiometricActionDisabledByAdminController extends BaseActionDisabledByAdminController {
    private static final String TAG = "BiometricActionDisabledByAdminController";

    @Override // com.android.settingslib.enterprise.ActionDisabledByAdminController
    public void setupLearnMoreButton(Context r1) {
    }

    BiometricActionDisabledByAdminController(DeviceAdminStringProvider r1) {
        super(r1);
    }

    @Override // com.android.settingslib.enterprise.ActionDisabledByAdminController
    public String getAdminSupportTitle(String r1) {
        return this.mStringProvider.getDisabledBiometricsParentConsentTitle();
    }

    @Override // com.android.settingslib.enterprise.ActionDisabledByAdminController
    public CharSequence getAdminSupportContentString(Context r1, CharSequence r2) {
        return this.mStringProvider.getDisabledBiometricsParentConsentContent();
    }

    @Override // com.android.settingslib.enterprise.ActionDisabledByAdminController
    public DialogInterface.OnClickListener getPositiveButtonListener(final Context r1, final RestrictedLockUtils.EnforcedAdmin r2) {
        return new BiometricActionDisabledByAdminController$$ExternalSyntheticLambda0(r2, r1);
    }

    static /* synthetic */ void lambda$getPositiveButtonListener$0(RestrictedLockUtils.EnforcedAdmin r1, Context r2, DialogInterface r3, int r4) {
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Positive button clicked, component: " + r1.component);
        r2.startActivity(new Intent("android.settings.MANAGE_SUPERVISOR_RESTRICTED_SETTING").putExtra("android.provider.extra.SUPERVISOR_RESTRICTED_SETTING_KEY", 1).addFlags(268435456).setData(new Uri.Builder().scheme("policy").appendPath("biometric").build()).setPackage(r1.component.getPackageName()));
    }
}
