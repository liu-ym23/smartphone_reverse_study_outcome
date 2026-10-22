package com.android.settings.specialaccess.notificationaccess;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.permission.flags.Flags;
import android.widget.CompoundButton;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.utils.FlagsReflectionUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public class ApprovalPreferenceController {
    private static final String TAG = "ApprovalPrefController";
    private ComponentName mCn;
    private NotificationManager mNm;
    private NotificationAccessDetailsActivity mParent;
    private PackageInfo mPkgInfo;
    private PackageManager mPm;
    private String mSettingIdentifier;

    public ApprovalPreferenceController() {
    }

    public ApprovalPreferenceController setPkgInfo(PackageInfo r1) {
        this.mPkgInfo = r1;
        return this;
    }

    public ApprovalPreferenceController setCn(ComponentName r1) {
        this.mCn = r1;
        return this;
    }

    public ApprovalPreferenceController setParent(NotificationAccessDetailsActivity r1) {
        this.mParent = r1;
        return this;
    }

    public ApprovalPreferenceController setNm(NotificationManager r1) {
        this.mNm = r1;
        return this;
    }

    public ApprovalPreferenceController setPm(PackageManager r1) {
        this.mPm = r1;
        return this;
    }

    public ApprovalPreferenceController setSettingIdentifier(String r1) {
        this.mSettingIdentifier = r1;
        return this;
    }

    public void updateState(OCardListItem r6) {
        this.mPkgInfo.applicationInfo.loadLabel(this.mPm);
        if (this.mCn.flattenToShortString().length() > NotificationManager.MAX_SERVICE_COMPONENT_NAME_LENGTH) goto L5;
        boolean r0 = true;
    L6:
        boolean r1 = isServiceEnabled(this.mCn);
        OCardListItemUtils.setOnCheckedChangeListener(r6, null);
        OCardListItemUtils.setChecked(r6, r1);
        OCardListItemUtils.setOnCheckedChangeListener(r6, new ApprovalPreferenceController$$ExternalSyntheticLambda0(this));
        if (Flags.enhancedConfirmationModeApisEnabled() == true) goto L9;
        return;
    L9:
        if (FlagsReflectionUtils.extendEcmToAllSettings() == false) goto L17;
        if (r0 == true) goto L13;
        if (r1 == true) goto L13;
        OCardListItemUtils.setEnabled(r6, false);
        return;
    L13:
        if (r1 == false) goto L19;
        OCardListItemUtils.setEnabled(r6, true);
        return;
    L19:
        return;
    L17:
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$updateState$0$com-android-settings-specialaccess-notificationaccess-ApprovalPreferenceController, reason: not valid java name */
    /* synthetic */ void m612x8b02a935(CompoundButton r1, boolean r2) {
        if (Boolean.valueOf(r2).booleanValue() == true) goto L9;
        if (isServiceEnabled(this.mCn) == true) goto L7;
        return;
    L7:
        this.mParent.disable(this.mCn);
        return;
    L9:
        if (isServiceEnabled(this.mCn) == false) goto L11;
        return;
    L11:
        this.mParent.enable(this.mCn);
    }

    public void disable(ComponentName r4) {
        logSpecialPermissionChange(true, r4.getPackageName());
        this.mNm.setNotificationListenerAccessGranted(r4, false);
        if (this.mNm.isNotificationPolicyAccessGrantedForPackage(r4.getPackageName()) == false) goto L5;
        return;
    L5:
        if (android.app.Flags.modesApi() == false) goto L7;
        this.mNm.removeAutomaticZenRules(r4.getPackageName(), true);
        return;
    L7:
        this.mNm.removeAutomaticZenRules(r4.getPackageName());
    }

    protected void enable(ComponentName r3) {
        logSpecialPermissionChange(true, r3.getPackageName());
        this.mNm.setNotificationListenerAccessGranted(r3, true);
    }

    protected boolean isServiceEnabled(ComponentName r1) {
        return this.mNm.isNotificationListenerAccessGranted(r1);
    }

    void logSpecialPermissionChange(boolean r2, String r3) {
        if (r2 == false) goto L4;
        int r1 = 776;
    L5:
        OLog.i(TAG, "logSpecialPermissionChange: " + r1 + ", pkg: " + r3);
        return;
    L4:
        r1 = 777;
        goto L5
    }
}
