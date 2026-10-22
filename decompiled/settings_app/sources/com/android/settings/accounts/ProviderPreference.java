package com.android.settings.accounts;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settingslib.RestrictedPreference;

/* JADX INFO: loaded from: classes2.dex */
public class ProviderPreference extends RestrictedPreference {
    private String mAccountType;

    public ProviderPreference(Context r1, String r2, Drawable r3, CharSequence r4) {
        super(r1);
        this.mAccountType = r2;
        setIcon(r3);
        setPersistent(false);
        setTitle(r4);
        useAdminDisabledSummary(true);
    }

    public String getAccountType() {
        return this.mAccountType;
    }

    public void checkAccountManagementAndSetDisabled(int r3) {
        setDisabledByAdmin(MultiSDKAdapterNew.checkIfAccountManagementDisabled(getContext(), getAccountType(), r3));
    }
}
