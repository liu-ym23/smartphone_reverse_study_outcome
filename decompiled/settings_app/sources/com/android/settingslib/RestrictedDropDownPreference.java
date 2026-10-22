package com.android.settingslib;

import android.content.Context;
import androidx.preference.DropDownPreference;
import androidx.preference.PreferenceViewHolder;

/* JADX INFO: loaded from: classes.dex */
public class RestrictedDropDownPreference extends DropDownPreference {
    RestrictedPreferenceHelper mHelper;

    public RestrictedDropDownPreference(Context r3) {
        super(r3);
        this.mHelper = new RestrictedPreferenceHelper(r3, this, null);
    }

    public void checkEcmRestrictionAndSetDisabled(String r1, String r2) {
        this.mHelper.checkEcmRestrictionAndSetDisabled(r1, r2);
    }

    @Override // androidx.preference.DropDownPreference, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r1) {
        super.onBindViewHolder(r1);
        this.mHelper.onBindViewHolder(r1);
    }

    @Override // androidx.preference.Preference
    public void setEnabled(boolean r2) {
        if (r2 == true) goto L4;
    L7:
        super.setEnabled(r2);
        return;
    L4:
        if (isDisabledByEcm() == false) goto L7;
        this.mHelper.setDisabledByEcm(null);
    }

    @Override // androidx.preference.Preference
    public void performClick() {
        if (this.mHelper.performClick() == true) goto L6;
        super.performClick();
        return;
    }

    public boolean isDisabledByEcm() {
        return this.mHelper.isDisabledByEcm();
    }
}
