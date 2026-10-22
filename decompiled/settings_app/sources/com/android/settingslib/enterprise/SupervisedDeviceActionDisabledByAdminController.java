package com.android.settingslib.enterprise;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.android.settingslib.RestrictedLockUtils;

/* JADX INFO: loaded from: classes.dex */
final class SupervisedDeviceActionDisabledByAdminController extends BaseActionDisabledByAdminController {
    private static final String TAG = "SupervisedDeviceActionDisabledByAdminController";
    private final String mRestriction;

    @Override // com.android.settingslib.enterprise.ActionDisabledByAdminController
    public void setupLearnMoreButton(Context r1) {
    }

    SupervisedDeviceActionDisabledByAdminController(DeviceAdminStringProvider r1, String r2) {
        super(r1);
        this.mRestriction = r2;
    }

    @Override // com.android.settingslib.enterprise.ActionDisabledByAdminController
    public String getAdminSupportTitle(String r1) {
        return this.mStringProvider.getDisabledBiometricsParentConsentTitle();
    }

    @Override // com.android.settingslib.enterprise.ActionDisabledByAdminController
    public CharSequence getAdminSupportContentString(Context r1, CharSequence r2) {
        return this.mStringProvider.getDisabledByParentContent();
    }

    @Override // com.android.settingslib.enterprise.ActionDisabledByAdminController
    public DialogInterface.OnClickListener getPositiveButtonListener(final Context r5, RestrictedLockUtils.EnforcedAdmin r6) {
        if (r6.component != null) goto L5;
    L12:
        return null;
    L5:
        if (TextUtils.isEmpty(r6.component.getPackageName()) == true) goto L12;
        final Intent r4 = new Intent("android.settings.MANAGE_SUPERVISOR_RESTRICTED_SETTING").setData(new Uri.Builder().scheme("policy").appendPath("user_restrictions").appendPath(this.mRestriction).build()).setPackage(r6.component.getPackageName());
        if (r4.resolveActivity(r5.getPackageManager()) != null) goto L11;
        return null;
    L11:
        return new SupervisedDeviceActionDisabledByAdminController$$ExternalSyntheticLambda0(r5, r4);
    }

    static /* synthetic */ void lambda$getPositiveButtonListener$0(Context r0, Intent r1, DialogInterface r2, int r3) {
        r0.startActivity(r1);
    }
}
