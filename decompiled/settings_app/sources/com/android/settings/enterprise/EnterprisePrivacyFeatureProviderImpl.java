package com.android.settings.enterprise;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.VpnManager;
import android.os.Flags;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.text.SpannableStringBuilder;
import com.android.settings.R;
import com.android.settings.vpn2.VpnUtils;
import com.android.settingslib.supervision.SupervisionIntentProvider;
import com.android.settingslib.utils.WorkPolicyUtils;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class EnterprisePrivacyFeatureProviderImpl implements EnterprisePrivacyFeatureProvider {

    @Deprecated
    public static final String ACTION_PARENTAL_CONTROLS = "android.settings.SHOW_PARENTAL_CONTROLS";
    private static final int MY_USER_ID = 0;
    private final ConnectivityManager mCm;
    private final Context mContext;
    private final DevicePolicyManager mDpm;
    private final PackageManager mPm;
    private final Resources mResources;
    private final UserManager mUm;
    private final VpnManager mVm;
    private final WorkPolicyUtils mWorkPolicyUtils;

    static {
        MY_USER_ID = UserHandle.myUserId();
    }

    public EnterprisePrivacyFeatureProviderImpl(Context r1, DevicePolicyManager r2, PackageManager r3, UserManager r4, ConnectivityManager r5, VpnManager r6, Resources r7) {
        Context r8 = r1.getApplicationContext();
        this.mContext = r8;
        this.mDpm = r2;
        this.mPm = r3;
        this.mUm = r4;
        this.mCm = r5;
        this.mVm = r6;
        this.mResources = r7;
        this.mWorkPolicyUtils = new WorkPolicyUtils(r8);
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public boolean hasDeviceOwner() {
        if (getDeviceOwnerComponent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public boolean isInCompMode() {
        if (hasDeviceOwner() == true) goto L5;
    L7:
        return false;
    L5:
        if (getManagedProfileUserId() == (-10000)) goto L7;
        return true;
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public String getDeviceOwnerOrganizationName() {
        CharSequence r0 = this.mDpm.getDeviceOwnerOrganizationName();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public CharSequence getDeviceOwnerDisclosure() {
        if (hasDeviceOwner() == true) goto L6;
        return null;
    L6:
        SpannableStringBuilder r0 = new SpannableStringBuilder();
        final CharSequence r1 = this.mDpm.getDeviceOwnerOrganizationName();
        if (r1 == null) goto L9;
        r0.append(this.mDpm.getResources().getString("Settings.DEVICE_MANAGED_WITH_NAME", new EnterprisePrivacyFeatureProviderImpl$$ExternalSyntheticLambda0(this, r1), new Object[]{r1}));
    L10:
        return r0;
    L9:
        r0.append(this.mDpm.getResources().getString("Settings.DEVICE_MANAGED_WITHOUT_NAME", new EnterprisePrivacyFeatureProviderImpl$$ExternalSyntheticLambda1(this)));
        goto L10
    }

    /* JADX INFO: renamed from: lambda$getDeviceOwnerDisclosure$0$com-android-settings-enterprise-EnterprisePrivacyFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ String m459x8d18c6d3(CharSequence r3) {
        return this.mResources.getString(R.string.do_disclosure_with_name, new Object[]{r3});
    }

    /* JADX INFO: renamed from: lambda$getDeviceOwnerDisclosure$1$com-android-settings-enterprise-EnterprisePrivacyFeatureProviderImpl, reason: not valid java name */
    /* synthetic */ String m460xc5f92772() {
        return this.mResources.getString(R.string.do_disclosure_generic);
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public Date getLastSecurityLogRetrievalTime() {
        long r0 = this.mDpm.getLastSecurityLogRetrievalTime();
        if (r0 >= 0) goto L6;
        return null;
    L6:
        return new Date(r0);
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public Date getLastBugReportRequestTime() {
        long r0 = this.mDpm.getLastBugReportRequestTime();
        if (r0 >= 0) goto L6;
        return null;
    L6:
        return new Date(r0);
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public Date getLastNetworkLogRetrievalTime() {
        long r0 = this.mDpm.getLastNetworkLogRetrievalTime();
        if (r0 >= 0) goto L6;
        return null;
    L6:
        return new Date(r0);
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public boolean isSecurityLoggingEnabled() {
        return this.mDpm.isSecurityLoggingEnabled(null);
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public boolean isNetworkLoggingEnabled() {
        return this.mDpm.isNetworkLoggingEnabled(null);
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public boolean isAlwaysOnVpnSetInCurrentUser() {
        return VpnUtils.isAlwaysOnVpnSet(this.mVm, MY_USER_ID);
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public boolean isAlwaysOnVpnSetInManagedProfile() {
        int r0 = getManagedProfileUserId();
        if (r0 != (-10000)) goto L5;
    L7:
        return false;
    L5:
        if (VpnUtils.isAlwaysOnVpnSet(this.mVm, r0) == false) goto L7;
        return true;
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public int getMaximumFailedPasswordsBeforeWipeInCurrentUser() {
        ComponentName r0 = this.mDpm.getDeviceOwnerComponentOnCallingUser();
        if (r0 != null) goto L5;
        r0 = this.mDpm.getProfileOwnerAsUser(MY_USER_ID);
    L5:
        if (r0 != null) goto L9;
        return 0;
    L9:
        return this.mDpm.getMaximumFailedPasswordsForWipe(r0, MY_USER_ID);
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public int getMaximumFailedPasswordsBeforeWipeInManagedProfile() {
        int r0 = getManagedProfileUserId();
        if (r0 != (-10000)) goto L5;
        return 0;
    L5:
        ComponentName r1 = this.mDpm.getProfileOwnerAsUser(r0);
        if (r1 != null) goto L9;
        return 0;
    L9:
        return this.mDpm.getMaximumFailedPasswordsForWipe(r1, r0);
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public String getImeLabelIfOwnerSet() {
        if (this.mDpm.isCurrentInputMethodSetByOwner() == true) goto L5;
        return null;
    L5:
        ContentResolver r0 = this.mContext.getContentResolver();
        int r2 = MY_USER_ID;
        String r1 = Settings.Secure.getStringForUser(r0, "default_input_method", r2);
        if (r1 != null) goto L11;
        return null;
    L11:
        return this.mPm.getApplicationInfoAsUser(r1, 0, r2).loadLabel(this.mPm).toString();
    L10:
        return null;
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public int getNumberOfOwnerInstalledCaCertsForCurrentUser() {
        List r2 = this.mDpm.getOwnerInstalledCaCerts(new UserHandle(MY_USER_ID));
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.size();
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public int getNumberOfOwnerInstalledCaCertsForManagedProfile() {
        int r0 = getManagedProfileUserId();
        if (r0 != (-10000)) goto L5;
        return 0;
    L5:
        List r3 = this.mDpm.getOwnerInstalledCaCerts(new UserHandle(r0));
        if (r3 != null) goto L9;
        return 0;
    L9:
        return r3.size();
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public int getNumberOfActiveDeviceAdminsForCurrentUserAndManagedProfile() {
        Iterator r0 = this.mUm.getProfiles(MY_USER_ID).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L11;
        UserInfo r2 = (UserInfo) r0.next();
        if (shouldSkipProfile(r2) == true) goto L4;
        List r3 = this.mDpm.getActiveAdminsAsUser(r2.id);
        if (r3 == null) goto L4;
        r1 = r1 + r3.size();
        goto L4
    L11:
        return r1;
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public boolean hasWorkPolicyInfo() {
        return this.mWorkPolicyUtils.hasWorkPolicy();
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public boolean showWorkPolicyInfo(Context r1) {
        return this.mWorkPolicyUtils.showWorkPolicyInfo(r1);
    }

    @Override // com.android.settings.enterprise.EnterprisePrivacyFeatureProvider
    public boolean showParentalControls() {
        if (FlagsSupervisionRef.deprecateDpmSupervisionApis() == false) goto L5;
        Intent r0 = SupervisionIntentProvider.getSettingsIntent(this.mContext);
    L6:
        if (r0 == null) goto L9;
        this.mContext.startActivity(r0);
        return true;
    L9:
        return false;
    L5:
        r0 = getParentalControlsIntent();
        goto L6
    }

    private boolean shouldSkipProfile(UserInfo r2) {
        if (Flags.allowPrivateProfile() == true) goto L5;
    L13:
        return false;
    L5:
        if (android.multiuser.Flags.handleInterleavedSettingsForPrivateSpace() == false) goto L13;
        if (android.multiuser.Flags.enablePrivateSpaceFeatures() == false) goto L13;
        if (r2.isQuietModeEnabled() == false) goto L13;
        if (this.mUm.getUserProperties(r2.getUserHandle()).getShowInQuietMode() != 1) goto L13;
        return true;
    }

    @Deprecated
    private Intent getParentalControlsIntent() {
        DevicePolicyManager r0 = this.mDpm;
        int r2 = MY_USER_ID;
        ComponentName r1 = r0.getProfileOwnerOrDeviceOwnerSupervisionComponent(new UserHandle(r2));
        if (r1 != null) goto L5;
        return null;
    L5:
        Intent r3 = new Intent(ACTION_PARENTAL_CONTROLS).setPackage(r1.getPackageName()).addFlags(268435456);
        if (this.mPm.queryIntentActivitiesAsUser(r3, 0, r2).size() == 0) goto L8;
        return r3;
    L8:
        return null;
    }

    private ComponentName getDeviceOwnerComponent() {
        if (this.mPm.hasSystemFeature("android.software.device_admin") == true) goto L7;
        return null;
    L7:
        return this.mDpm.getDeviceOwnerComponentOnAnyUser();
    }

    private UserInfo getManagedProfileUserInfo() {
        Iterator r2 = this.mUm.getProfiles(MY_USER_ID).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        UserInfo r0 = (UserInfo) r2.next();
        if (r0.isManagedProfile() == false) goto L4;
        return r0;
    L8:
        return null;
    }

    private int getManagedProfileUserId() {
        UserInfo r0 = getManagedProfileUserInfo();
        if (r0 != null) goto L5;
        return -10000;
    L5:
        return r0.id;
    }
}
