package com.android.settingslib;

import android.app.AppOpsManager;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.UserHandle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.SwitchPreferenceCompat;
import com.android.settingslib.utils.BuildCompatUtils;

/* JADX INFO: loaded from: classes.dex */
public class RestrictedSwitchPreference extends SwitchPreferenceCompat {
    AppOpsManager mAppOpsManager;
    RestrictedPreferenceHelper mHelper;
    private int mIconSize;
    CharSequence mRestrictedSwitchSummary;
    boolean mUseAdditionalSummary;

    public RestrictedSwitchPreference(Context r3, AttributeSet r4, int r5, int r6) {
        super(r3, r4, r5, r6);
        this.mUseAdditionalSummary = false;
        this.mHelper = new RestrictedPreferenceHelper(r3, this, r4);
        if (r4 == null) goto L22;
        TypedArray r7 = r3.obtainStyledAttributes(r4, R.styleable.RestrictedSwitchPreference);
        TypedValue r8 = r7.peekValue(R.styleable.RestrictedSwitchPreference_useAdditionalSummary);
        if (r8 != null) goto L7;
    L13:
        TypedValue r9 = r7.peekValue(R.styleable.RestrictedSwitchPreference_restrictedSwitchSummary);
        r7.recycle();
        if (r9 == null) goto L22;
        if (r9.type != 3) goto L22;
        if (r9.resourceId == 0) goto L20;
        this.mRestrictedSwitchSummary = r3.getText(r9.resourceId);
        goto L22
    L20:
        this.mRestrictedSwitchSummary = r9.string;
        goto L22
    L7:
        if (r8.type == 18) goto L9;
    L11:
        boolean r10 = false;
    L12:
        this.mUseAdditionalSummary = r10;
        goto L13
    L9:
        if (r8.data == 0) goto L11;
        r10 = true;
    L22:
        if (this.mUseAdditionalSummary == false) goto L25;
        setLayoutResource(R.layout.restricted_switch_preference);
        useAdminDisabledSummary(false);
        return;
    }

    public RestrictedSwitchPreference(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public RestrictedSwitchPreference(Context r2, AttributeSet r3) {
        this(r2, r3, androidx.preference.R.attr.switchPreferenceCompatStyle);
    }

    public RestrictedSwitchPreference(Context r2) {
        this(r2, null);
    }

    public void setAppOps(AppOpsManager r1) {
        this.mAppOpsManager = r1;
    }

    public void setIconSize(int r1) {
        this.mIconSize = r1;
    }

    @Override // androidx.preference.SwitchPreferenceCompat, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r5) {
        super.onBindViewHolder(r5);
        View r0 = r5.findViewById(androidx.preference.R.id.switchWidget);
        if (r0 == null) goto L5;
        r0.getRootView().setFilterTouchesWhenObscured(true);
    L5:
        this.mHelper.onBindViewHolder(r5);
        CharSequence r1 = this.mRestrictedSwitchSummary;
        if (r1 == null) goto L8;
    L11:
        ImageView r2 = (ImageView) r5.itemView.findViewById(android.R.id.icon);
        if (this.mIconSize <= 0) goto L15;
        int r3 = this.mIconSize;
        r2.setLayoutParams(new LinearLayout.LayoutParams(r3, r3));
    L15:
        if (this.mUseAdditionalSummary == false) goto L22;
        TextView r6 = (TextView) r5.findViewById(R.id.additional_summary);
        if (r6 != null) goto L19;
        return;
    L19:
        if (isDisabledByAdmin() == false) goto L21;
        r6.setText(r1);
        r6.setVisibility(0);
        return;
    L21:
        r6.setVisibility(8);
        return;
    L22:
        TextView r7 = (TextView) r5.findViewById(android.R.id.summary);
        if (r7 != null) goto L25;
        return;
    L25:
        if (isDisabledByAdmin() == false) goto L32;
        r7.setText(r1);
        r7.setVisibility(0);
        return;
    L32:
        return;
    L8:
        if (isChecked() == false) goto L10;
        r1 = getUpdatableEnterpriseString(getContext(), "Settings.ENABLED_BY_ADMIN_SWITCH_SUMMARY", R.string.enabled_by_admin);
        goto L11
    L10:
        r1 = getUpdatableEnterpriseString(getContext(), "Settings.DISABLED_BY_ADMIN_SWITCH_SUMMARY", R.string.disabled_by_admin);
        goto L11
    }

    private static String getUpdatableEnterpriseString(final Context r2, String r3, final int r4) {
        if (BuildCompatUtils.isAtLeastT() == true) goto L7;
        return r2.getString(r4);
    L7:
        return ((DevicePolicyManager) r2.getSystemService(DevicePolicyManager.class)).getResources().getString(r3, new RestrictedSwitchPreference$$ExternalSyntheticLambda0(r2, r4));
    }

    static /* synthetic */ String lambda$getUpdatableEnterpriseString$0(Context r0, int r1) {
        return r0.getString(r1);
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

    @Deprecated
    private void setDisabledByAppOps(boolean r2) {
        if (this.mHelper.setDisabledByAppOps(r2) == false) goto L6;
        notifyChanged();
        return;
    }

    @Deprecated
    public int getUid() {
        RestrictedPreferenceHelper r0 = this.mHelper;
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.uid;
    }

    @Deprecated
    public String getPackageName() {
        RestrictedPreferenceHelper r0 = this.mHelper;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.packageName;
    }

    @Deprecated
    public void updateState(String r3, int r4, boolean r5, boolean r6) {
        this.mHelper.updatePackageDetails(r3, r4);
        if (this.mAppOpsManager != null) goto L5;
        this.mAppOpsManager = (AppOpsManager) getContext().getSystemService(AppOpsManager.class);
    L5:
        int r7 = this.mAppOpsManager.noteOpNoThrow(119, r4, r3);
        if (getContext().getResources().getBoolean(android.R.bool.config_enableTimeZoneNotificationsTrackingSupported) == false) goto L12;
        if (r7 == 0) goto L12;
        if (r7 == 3) goto L12;
        boolean r8 = false;
    L13:
        if (r5 == true) goto L16;
        if (r6 == true) goto L16;
        setEnabled(false);
        return;
    L16:
        if (r6 == false) goto L18;
        setEnabled(true);
        return;
    L18:
        if (r8 == true) goto L20;
    L22:
        if (r8 == true) goto L28;
        setDisabledByAppOps(true);
        return;
    L28:
        return;
    L20:
        if (isDisabledByEcm() == false) goto L22;
        setEnabled(true);
        return;
    L12:
        r8 = true;
        goto L13
    }
}
