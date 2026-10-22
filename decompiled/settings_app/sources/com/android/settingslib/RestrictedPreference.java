package com.android.settingslib;

import android.content.Context;
import android.os.UserHandle;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceViewHolder;
import com.android.settingslib.widget.TwoTargetPreference;

/* JADX INFO: loaded from: classes.dex */
public class RestrictedPreference extends TwoTargetPreference {
    RestrictedPreferenceHelper mHelper;

    public RestrictedPreference(Context r7, AttributeSet r8, int r9, int r10, String r11, int r12) {
        super(r7, r8, r9, r10);
        this.mHelper = new RestrictedPreferenceHelper(r7, this, r8, r11, r12);
    }

    public RestrictedPreference(Context r8, AttributeSet r9, int r10, int r11) {
        this(r8, r9, r10, r11, null, -1);
    }

    public RestrictedPreference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public RestrictedPreference(Context r3, AttributeSet r4) {
        this(r3, r4, TypedArrayUtils.getAttr(r3, R.attr.preferenceStyle, android.R.attr.preferenceStyle));
    }

    public RestrictedPreference(Context r2) {
        this(r2, null);
    }

    public RestrictedPreference(Context r8, String r9, int r10) {
        this(r8, null, TypedArrayUtils.getAttr(r8, R.attr.preferenceStyle, android.R.attr.preferenceStyle), 0, r9, r10);
    }

    @Override // com.android.settingslib.widget.TwoTargetPreference, androidx.preference.Preference
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

    public void useAdminDisabledSummary(boolean r1) {
        this.mHelper.useAdminDisabledSummary(r1);
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

    public void checkEcmRestrictionAndSetDisabled(String r1, String r2) {
        this.mHelper.checkEcmRestrictionAndSetDisabled(r1, r2);
    }

    @Override // androidx.preference.Preference
    public void setEnabled(boolean r3) {
        if (r3 == true) goto L5;
    L8:
        if (r3 == true) goto L10;
    L13:
        super.setEnabled(r3);
        return;
    L10:
        if (isDisabledByEcm() == false) goto L13;
        this.mHelper.setDisabledByEcm(null);
        return;
    L5:
        if (isDisabledByAdmin() == false) goto L8;
        this.mHelper.setDisabledByAdmin(null);
    }

    public void setDisabledByAdmin(RestrictedLockUtils.EnforcedAdmin r2) {
        if (this.mHelper.setDisabledByAdmin(r2) == false) goto L6;
        notifyChanged();
        return;
    }

    public boolean isDisabledByAdmin() {
        return this.mHelper.isDisabledByAdmin();
    }

    public boolean isDisabledByEcm() {
        return this.mHelper.isDisabledByEcm();
    }

    public int getUid() {
        RestrictedPreferenceHelper r0 = this.mHelper;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.uid;
    }

    public String getPackageName() {
        RestrictedPreferenceHelper r0 = this.mHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.packageName;
    }

    @Deprecated
    public void setDisabledByAppOps(boolean r2) {
        if (this.mHelper.setDisabledByAppOps(r2) == false) goto L6;
        notifyChanged();
        return;
    }
}
