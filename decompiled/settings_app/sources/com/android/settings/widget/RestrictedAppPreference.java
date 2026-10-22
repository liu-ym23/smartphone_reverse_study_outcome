package com.android.settings.widget;

import android.content.Context;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedPreferenceHelper;

/* JADX INFO: loaded from: classes.dex */
public class RestrictedAppPreference extends Preference {
    private RestrictedPreferenceHelper mHelper;
    private String userRestriction;

    public RestrictedAppPreference(Context r1) {
        super(r1);
        initialize(null, null);
    }

    public RestrictedAppPreference(Context r1, String r2) {
        super(r1);
        initialize(null, r2);
    }

    public RestrictedAppPreference(Context r1, AttributeSet r2, String r3) {
        super(r1, r2);
        initialize(r2, r3);
    }

    private void initialize(AttributeSet r3, String r4) {
        this.mHelper = new RestrictedPreferenceHelper(getContext(), this, r3);
        this.userRestriction = r4;
    }

    @Override // androidx.preference.Preference
    public void setEnabled(boolean r5) {
        boolean r0 = true;
        if (r5 == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r5 == true) goto L10;
    L12:
        r0 = r2;
    L13:
        if (r0 == true) goto L16;
        super.setEnabled(r5);
        return;
    L16:
        return;
    L10:
        if (isDisabledByEcm() == false) goto L12;
        this.mHelper.setDisabledByEcm(null);
        goto L13
    L5:
        if (isDisabledByAdmin() == false) goto L7;
        this.mHelper.setDisabledByAdmin(null);
        r2 = true;
        goto L8
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

    public void useAdminDisabledSummary(boolean r1) {
        this.mHelper.useAdminDisabledSummary(r1);
    }

    @Override // androidx.preference.Preference
    protected void onAttachedToHierarchy(PreferenceManager r2) {
        this.mHelper.onAttachedToHierarchy();
        super.onAttachedToHierarchy(r2);
    }

    public void checkRestrictionAndSetDisabled() {
        if (TextUtils.isEmpty(this.userRestriction) == false) goto L5;
        return;
    L5:
        this.mHelper.checkRestrictionAndSetDisabled(this.userRestriction, UserHandle.myUserId());
    }

    public void checkRestrictionAndSetDisabled(String r2) {
        this.mHelper.checkRestrictionAndSetDisabled(r2, UserHandle.myUserId());
    }

    public void checkRestrictionAndSetDisabled(String r1, int r2) {
        this.mHelper.checkRestrictionAndSetDisabled(r1, r2);
    }
}
