package com.android.settingslib.enterprise;

import android.content.Context;
import android.content.DialogInterface;
import com.android.settingslib.RestrictedLockUtils;

/* JADX INFO: loaded from: classes.dex */
public interface ActionDisabledByAdminController {
    CharSequence getAdminSupportContentString(Context r1, CharSequence r2);

    String getAdminSupportTitle(String r1);

    default DialogInterface.OnClickListener getPositiveButtonListener(Context r1, RestrictedLockUtils.EnforcedAdmin r2) {
        return null;
    }

    void initialize(ActionDisabledLearnMoreButtonLauncher r1);

    void setupLearnMoreButton(Context r1);

    void updateEnforcedAdmin(RestrictedLockUtils.EnforcedAdmin r1, int r2);
}
