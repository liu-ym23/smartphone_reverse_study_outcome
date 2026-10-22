package com.android.settingslib;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.UserHandle;
import android.permission.flags.Flags;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.android.settingslib.utils.BuildCompatUtils;

/* JADX INFO: loaded from: classes.dex */
public class RestrictedPreferenceHelper {
    private static final String TAG = "RestrictedPreferenceHelper";
    private String mAttrUserRestriction;
    private final Context mContext;
    private boolean mDisabledByAdmin;
    private boolean mDisabledByEcm;
    private Intent mDisabledByEcmIntent;
    private boolean mDisabledSummary;
    RestrictedLockUtils.EnforcedAdmin mEnforcedAdmin;
    private final Preference mPreference;
    String packageName;
    int uid;

    public RestrictedPreferenceHelper(Context r3, Preference r4, AttributeSet r5, String r6, int r7) {
        this.mAttrUserRestriction = null;
        boolean r1 = false;
        this.mDisabledSummary = false;
        this.mDisabledByEcmIntent = null;
        this.mContext = r3;
        this.mPreference = r4;
        this.packageName = r6;
        this.uid = r7;
        if (r5 == null) goto L29;
        TypedArray r8 = r3.obtainStyledAttributes(r5, R.styleable.RestrictedPreference);
        TypedValue r9 = r8.peekValue(R.styleable.RestrictedPreference_userRestriction);
        if (r9 != null) goto L7;
    L12:
        CharSequence r10 = null;
    L13:
        if (r10 != null) goto L15;
        String r11 = null;
    L16:
        this.mAttrUserRestriction = r11;
        if (RestrictedLockUtilsInternal.hasBaseUserRestriction(r3, r11, UserHandle.myUserId()) == false) goto L20;
        this.mAttrUserRestriction = null;
        return;
    L20:
        TypedValue r12 = r8.peekValue(R.styleable.RestrictedPreference_useAdminDisabledSummary);
        if (r12 != null) goto L23;
        return;
    L23:
        if (r12.type == 18) goto L25;
    L27:
        this.mDisabledSummary = r1;
        return;
    L25:
        if (r12.data == 0) goto L27;
        r1 = true;
        goto L27
    L15:
        r11 = r10.toString();
        goto L16
    L7:
        if (r9.type != 3) goto L12;
        if (r9.resourceId == 0) goto L11;
        r10 = r3.getText(r9.resourceId);
        goto L13
    L11:
        r10 = r9.string;
        goto L13
    }

    public RestrictedPreferenceHelper(Context r7, Preference r8, AttributeSet r9) {
        this(r7, r8, r9, null, -1);
    }

    public void onBindViewHolder(PreferenceViewHolder r3) {
        if (this.mDisabledByAdmin == false) goto L5;
    L6:
        r3.itemView.setEnabled(true);
    L8:
        if (this.mDisabledSummary == false) goto L25;
        TextView r4 = (TextView) r3.findViewById(android.R.id.summary);
        if (r4 != null) goto L12;
        return;
    L12:
        if (BuildCompatUtils.isAtLeastT() == false) goto L14;
        String r0 = getDisabledByAdminUpdatableString();
    L16:
        if (this.mDisabledByAdmin == false) goto L19;
        r4.setText(r0);
        return;
    L19:
        if (this.mDisabledByEcm == false) goto L22;
        r4.setText(R.string.disabled_by_app_ops_text);
        return;
    L22:
        if (TextUtils.equals(r0, r4.getText()) == false) goto L29;
        r4.setText(null);
        return;
    L29:
        return;
    L14:
        r0 = this.mContext.getString(R.string.disabled_by_admin_summary_text);
        goto L16
    L25:
        return;
    L5:
        if (this.mDisabledByEcm == false) goto L8;
        goto L6
    }

    private String getDisabledByAdminUpdatableString() {
        return ((DevicePolicyManager) this.mContext.getSystemService(DevicePolicyManager.class)).getResources().getString("Settings.CONTROLLED_BY_ADMIN_SUMMARY", new RestrictedPreferenceHelper$$ExternalSyntheticLambda0(this));
    }

    /* JADX INFO: renamed from: lambda$getDisabledByAdminUpdatableString$0$com-android-settingslib-RestrictedPreferenceHelper, reason: not valid java name */
    /* synthetic */ String m735xdbabbded() {
        return this.mContext.getString(R.string.disabled_by_admin_summary_text);
    }

    public void useAdminDisabledSummary(boolean r1) {
        this.mDisabledSummary = r1;
    }

    public boolean performClick() {
        if (this.mDisabledByAdmin == false) goto L7;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this.mContext, this.mEnforcedAdmin);
        return true;
    L7:
        if (this.mDisabledByEcm == true) goto L9;
        return false;
    L9:
        if (Flags.enhancedConfirmationModeApisEnabled() == true) goto L11;
    L14:
        RestrictedLockUtilsInternal.sendShowRestrictedSettingDialogIntent(this.mContext, this.packageName, this.uid);
        return true;
    L11:
        if (android.security.Flags.extendEcmToAllSettings() == false) goto L14;
        this.mContext.startActivity(this.mDisabledByEcmIntent);
        return true;
    }

    public void onAttachedToHierarchy() {
        String r0 = this.mAttrUserRestriction;
        if (r0 == null) goto L6;
        checkRestrictionAndSetDisabled(r0, UserHandle.myUserId());
        return;
    }

    public void checkRestrictionAndSetDisabled(String r2, int r3) {
        setDisabledByAdmin(RestrictedLockUtilsInternal.checkIfRestrictionEnforced(this.mContext, r2, r3));
    }

    public void checkEcmRestrictionAndSetDisabled(String r2, String r3) {
        updatePackageDetails(r3, -1);
        setDisabledByEcm(RestrictedLockUtilsInternal.checkIfRequiresEnhancedConfirmation(this.mContext, r2, r3));
    }

    public RestrictedLockUtils.EnforcedAdmin checkRestrictionEnforced() {
        String r0 = this.mAttrUserRestriction;
        if (r0 != null) goto L7;
        return null;
    L7:
        return RestrictedLockUtilsInternal.checkIfRestrictionEnforced(this.mContext, r0, UserHandle.myUserId());
    }

    public boolean setDisabledByAdmin(RestrictedLockUtils.EnforcedAdmin r4) {
        this.mEnforcedAdmin = null;
        if (r4 == null) goto L5;
        this.mEnforcedAdmin = new RestrictedLockUtils.EnforcedAdmin(r4);
        boolean r5 = true;
    L7:
        if (this.mDisabledByAdmin == r5) goto L10;
        this.mDisabledByAdmin = r5;
        updateDisabledState();
        return true;
    L10:
        return false;
    L5:
        r5 = false;
        goto L7
    }

    public boolean setDisabledByEcm(Intent r5) {
        if (r5 == null) goto L5;
        boolean r2 = true;
    L7:
        if (this.mDisabledByEcm == r2) goto L10;
        this.mDisabledByEcmIntent = r5;
        this.mDisabledByEcm = r2;
        updateDisabledState();
        return true;
    L10:
        return false;
    L5:
        r2 = false;
        goto L7
    }

    public boolean isDisabledByAdmin() {
        return this.mDisabledByAdmin;
    }

    public boolean isDisabledByEcm() {
        return this.mDisabledByEcm;
    }

    public void updatePackageDetails(String r1, int r2) {
        this.packageName = r1;
        this.uid = r2;
    }

    private void updateDisabledState() {
        if (this.mDisabledByAdmin == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Preference r1 = this.mPreference;
        if ((r1 instanceof RestrictedTopLevelPreference) == true) goto L11;
        r1.setEnabled(r0);
    L11:
        Preference r2 = this.mPreference;
        if ((r2 instanceof PrimarySwitchPreference) == false) goto L14;
        ((PrimarySwitchPreference) r2).setSwitchEnabled(r0);
    L14:
        if (r0 == false) goto L16;
        return;
    L16:
        if (this.mDisabledByEcm == false) goto L20;
        this.mPreference.setSummary(R.string.disabled_by_app_ops_text);
        return;
    L20:
        return;
    L5:
        if (this.mDisabledByEcm == true) goto L7;
        r0 = true;
        goto L8
    }

    @Deprecated
    public boolean setDisabledByAppOps(boolean r2) {
        if (this.mDisabledByEcm == r2) goto L5;
        this.mDisabledByEcm = r2;
        updateDisabledState();
        return true;
    L5:
        return false;
    }
}
