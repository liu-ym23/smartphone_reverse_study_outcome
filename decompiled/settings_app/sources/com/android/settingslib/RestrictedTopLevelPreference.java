package com.android.settingslib;

import android.content.Context;
import android.os.UserHandle;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceViewHolder;

/* JADX INFO: loaded from: classes.dex */
public class RestrictedTopLevelPreference extends Preference {
    private RestrictedPreferenceHelper mHelper;

    public RestrictedTopLevelPreference(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.mHelper = new RestrictedPreferenceHelper(r1, this, r2);
    }

    public RestrictedTopLevelPreference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public RestrictedTopLevelPreference(Context r3, AttributeSet r4) {
        this(r3, r4, TypedArrayUtils.getAttr(r3, R.attr.preferenceStyle, android.R.attr.preferenceStyle));
    }

    public RestrictedTopLevelPreference(Context r2) {
        this(r2, null);
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r1) {
        super.onBindViewHolder(r1);
        this.mHelper.onBindViewHolder(r1);
    }

    @Override // androidx.preference.Preference
    public void performClick() {
        if (this.mHelper.performClick() == true) goto L6;
        super.performClick();
        return;
    }

    @Override // androidx.preference.Preference
    protected void onAttachedToHierarchy(PreferenceManager r2) {
        this.mHelper.onAttachedToHierarchy();
        super.onAttachedToHierarchy(r2);
    }

    public void checkRestrictionAndSetDisabled(String r2) {
        this.mHelper.checkRestrictionAndSetDisabled(r2, UserHandle.myUserId());
    }

    public void checkRestrictionAndSetDisabled(String r1, int r2) {
        this.mHelper.checkRestrictionAndSetDisabled(r1, r2);
    }

    @Override // androidx.preference.Preference
    public void setEnabled(boolean r2) {
        if (r2 == true) goto L4;
    L7:
        super.setEnabled(r2);
        return;
    L4:
        if (isDisabledByAdmin() == false) goto L7;
        this.mHelper.setDisabledByAdmin(null);
    }

    public boolean isDisabledByAdmin() {
        return this.mHelper.isDisabledByAdmin();
    }

    public void setDisabledByAdmin(RestrictedLockUtils.EnforcedAdmin r2) {
        if (this.mHelper.setDisabledByAdmin(r2) == false) goto L6;
        notifyChanged();
        return;
    }
}
