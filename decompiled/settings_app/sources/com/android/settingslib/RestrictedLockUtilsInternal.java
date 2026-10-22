package com.android.settingslib;

import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.app.admin.DevicePolicyManager;
import android.app.admin.PackagePolicy;
import android.app.ecm.EnhancedConfirmationManager;
import android.app.role.RoleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.UserInfo;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import android.os.UserManager;
import android.permission.flags.Flags;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.utils.HanziToPinyin;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RestrictedLockUtilsInternal extends RestrictedLockUtils {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "RestrictedLockUtils";
    private static final String ROLE_DEVICE_LOCK_CONTROLLER = "android.app.role.SYSTEM_FINANCED_DEVICE_CONTROLLER";
    static Proxy sProxy;

    private interface LockSettingCheck {
        boolean isEnforcing(DevicePolicyManager r1, ComponentName r2, int r3);
    }

    static class Proxy {
        Proxy() {
        }

        public boolean isSeparateProfileChallengeEnabled(LockPatternUtils r1, int r2) {
            return r1.isSeparateProfileChallengeEnabled(r2);
        }

        public DevicePolicyManager getParentProfileInstance(DevicePolicyManager r1, UserInfo r2) {
            return r1.getParentProfileInstance(r2);
        }
    }

    public RestrictedLockUtilsInternal() {
    }

    static {
        DEBUG = Log.isLoggable(LOG_TAG, 3);
        sProxy = new Proxy();
    }

    public static Drawable getRestrictedPadlock(Context r5) {
        Drawable r0 = r5.getDrawable(android.R.drawable.ic_info);
        int r1 = r5.getResources().getDimensionPixelSize(android.R.dimen.config_restrictedIconSize);
        TypedArray r6 = r5.obtainStyledAttributes(new int[]{android.R.attr.colorAccent});
        int r2 = r6.getColor(0, 0);
        r6.recycle();
        r0.setTint(r2);
        r0.setBounds(0, 0, r1, r1);
        return r0;
    }

    public static Intent checkIfRequiresEnhancedConfirmation(Context r2, String r3, String r4) {
        if (Flags.enhancedConfirmationModeApisEnabled() == true) goto L5;
    L14:
        return null;
    L5:
        if (android.security.Flags.extendEcmToAllSettings() == false) goto L14;
        EnhancedConfirmationManager r5 = (EnhancedConfirmationManager) r2.getSystemService("ecm_enhanced_confirmation");
    L12:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(LOG_TAG, "package not found: " + r4, e);
        goto L14
    L9:
        if (r5.isRestricted(r4, r3) == false) goto L14;
        return r5.createRestrictedSettingDialogIntent(r4, r3);
    }

    public static boolean isEnhancedConfirmationRestricted(Context r3, String r4, String r5) {
        if (Flags.enhancedConfirmationModeApisEnabled() == true) goto L5;
    L24:
        if (r4.equals("android:bind_accessibility_service") == true) goto L14;
        return false;
    L14:
        int r6 = ((AppOpsManager) r3.getSystemService(AppOpsManager.class)).noteOpNoThrow(119, r3.getPackageManager().getPackageUid(r5, 0), r5);     // Catch: Exception -> L21
        if (r3.getResources().getBoolean(android.R.bool.config_enableTimeZoneNotificationsTrackingSupported) == false) goto L26;
        if (r6 != 0) goto L18;
        return false;
    L18:
        if (r6 == 3) goto L28;
        return true;
    L28:
        return false;
    L26:
        return false;
    L29:
        return false;
    L5:
        if (android.security.Flags.extendEcmToAllSettings() == false) goto L24;
        return ((EnhancedConfirmationManager) r3.getSystemService(EnhancedConfirmationManager.class)).isRestricted(r5, r4);
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(LOG_TAG, "Exception when retrieving package:" + r5, e);
        return false;
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfRestrictionEnforced(Context r4, String r5, int r6) {
        if (((DevicePolicyManager) r4.getSystemService("device_policy")) != null) goto L5;
        return null;
    L5:
        UserManager r0 = UserManager.get(r4);
        UserHandle r7 = UserHandle.of(r6);
        List r1 = r0.getUserRestrictionSources(r5, r7);
        if (r1.isEmpty() == false) goto L8;
        return null;
    L8:
        int r2 = r1.size();
        if (r2 <= 1) goto L14;
        RestrictedLockUtils.EnforcedAdmin r8 = RestrictedLockUtils.EnforcedAdmin.createDefaultEnforcedAdminWithRestriction(r5);
        r8.user = r7;
        if (DEBUG == false) goto L13;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(LOG_TAG, "Multiple (" + r2 + ") enforcing users for restriction '" + r5 + "' on user " + r7 + "; returning default admin (" + r8 + ")");
    L13:
        return r8;
    L14:
        UserManager.EnforcingUser r9 = (UserManager.EnforcingUser) r1.get(0);
        if (r9.getUserRestrictionSource() != 1) goto L17;
        return null;
    L17:
        RestrictedLockUtils.EnforcedAdmin r10 = getProfileOrDeviceOwner(r4, r5, r9.getUserHandle());
        if (r10 == null) goto L21;
        return r10;
    L21:
        return RestrictedLockUtils.EnforcedAdmin.createDefaultEnforcedAdminWithRestriction(r5);
    }

    public static boolean hasBaseUserRestriction(Context r1, String r2, int r3) {
        return ((UserManager) r1.getSystemService(PickApplicationActivity.EXTRA_USER)).hasBaseUserRestriction(r2, UserHandle.of(r3));
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfKeyguardFeaturesDisabled(Context r1, final int r2, final int r3) {
        LockSettingCheck r0 = new RestrictedLockUtilsInternal$$ExternalSyntheticLambda1(r3, r2);
        if (UserManager.get(r1).getUserInfo(r3).isManagedProfile() == false) goto L7;
        DevicePolicyManager r4 = (DevicePolicyManager) r1.getSystemService("device_policy");
        return findEnforcedAdmin(r4.getActiveAdminsAsUser(r3), r4, r3, r0);
    L7:
        return checkForLockSetting(r1, r3, r0);
    }

    static /* synthetic */ boolean lambda$checkIfKeyguardFeaturesDisabled$0(int r0, int r1, DevicePolicyManager r2, ComponentName r3, int r4) {
        int r5 = r2.getKeyguardDisabledFeatures(r3, r4);
        if (r4 == r0) goto L6;
        r5 = r5 & 951;
    L6:
        if ((r5 & r1) == 0) goto L8;
        return true;
    L8:
        return false;
    }

    private static UserHandle getUserHandleOf(int r1) {
        if (r1 != (-10000)) goto L7;
        return null;
    L7:
        return UserHandle.of(r1);
    }

    private static RestrictedLockUtils.EnforcedAdmin findEnforcedAdmin(List<ComponentName> r4, DevicePolicyManager r5, int r6, LockSettingCheck r7) {
        RestrictedLockUtils.EnforcedAdmin r0 = null;
        if (r4 != null) goto L5;
        return null;
    L5:
        UserHandle r1 = getUserHandleOf(r6);
        Iterator<ComponentName> r8 = r4.iterator();
    L7:
        if (r8.hasNext() == false) goto L14;
        ComponentName r2 = r8.next();
        if (r7.isEnforcing(r5, r2, r6) == false) goto L7;
        if (r0 != null) goto L13;
        r0 = new RestrictedLockUtils.EnforcedAdmin(r2, r1);
        goto L7
    L13:
        return RestrictedLockUtils.EnforcedAdmin.MULTIPLE_ENFORCED_ADMIN;
    L14:
        return r0;
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfUninstallBlocked(Context r1, String r2, int r3) {
        RestrictedLockUtils.EnforcedAdmin r0 = checkIfRestrictionEnforced(r1, "no_control_apps", r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        RestrictedLockUtils.EnforcedAdmin r4 = checkIfRestrictionEnforced(r1, "no_uninstall_apps", r3);
        if (r4 == null) goto L16;
        return r4;
    L16:
        if (AppGlobals.getPackageManager().getBlockUninstallForUser(r2, r3) == false) goto L13;
        return getProfileOrDeviceOwner(r1, getUserHandleOf(r3));
    L13:
        return null;
    L18:
        return null;
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfApplicationIsSuspended(Context r1, String r2, int r3) {
        if (AppGlobals.getPackageManager().isPackageSuspendedForUser(r2, r3) == false) goto L7;
        return getProfileOrDeviceOwner(r1, getUserHandleOf(r3));
    L7:
        return null;
    L12:
        return null;
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfInputMethodDisallowed(Context r7, String r8, int r9) {
        DevicePolicyManager r0 = (DevicePolicyManager) r7.getSystemService("device_policy");
        if (r0 != null) goto L5;
        return null;
    L5:
        RestrictedLockUtils.EnforcedAdmin r2 = getProfileOrDeviceOwner(r7, getUserHandleOf(r9));
        boolean r3 = true;
        if (r2 == null) goto L8;
        boolean r4 = r0.isInputMethodPermittedByAdmin(r2.component, r8, r9);
    L9:
        int r10 = getManagedProfileId(r7, r9);
        if (r10 == (-10000)) goto L16;
        RestrictedLockUtils.EnforcedAdmin r5 = getProfileOrDeviceOwner(r7, getUserHandleOf(r10));
        if (r5 != null) goto L14;
    L17:
        if (r4 == true) goto L21;
        if (r3 == true) goto L21;
        return RestrictedLockUtils.EnforcedAdmin.MULTIPLE_ENFORCED_ADMIN;
    L21:
        if (r4 == true) goto L23;
        return r2;
    L23:
        if (r3 == true) goto L25;
        return r5;
    L25:
        return null;
    L14:
        if (r0.isOrganizationOwnedDeviceWithManagedProfile() == false) goto L17;
        r3 = sProxy.getParentProfileInstance(r0, UserManager.get(r7).getUserInfo(r10)).isInputMethodPermittedByAdmin(r5.component, r8, r10);
        goto L17
    L16:
        r5 = null;
        goto L17
    L8:
        r4 = true;
        goto L9
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfRemoteContactSearchDisallowed(Context r3, int r4) {
        DevicePolicyManager r0 = (DevicePolicyManager) r3.getSystemService("device_policy");
        if (r0 != null) goto L5;
        return null;
    L5:
        RestrictedLockUtils.EnforcedAdmin r5 = getProfileOwner(r3, r4);
        if (r5 != null) goto L8;
        return null;
    L8:
        UserHandle r6 = UserHandle.of(r4);
        if (r0.getCrossProfileContactsSearchDisabled(r6) == true) goto L11;
    L13:
        return null;
    L11:
        if (r0.getCrossProfileCallerIdDisabled(r6) == false) goto L13;
        return r5;
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfAccessibilityServiceDisallowed(Context r6, String r7, int r8) {
        DevicePolicyManager r0 = (DevicePolicyManager) r6.getSystemService("device_policy");
        if (r0 != null) goto L5;
        return null;
    L5:
        RestrictedLockUtils.EnforcedAdmin r2 = getProfileOrDeviceOwner(r6, getUserHandleOf(r8));
        boolean r3 = true;
        if (r2 == null) goto L8;
        boolean r4 = r0.isAccessibilityServicePermittedByAdmin(r2.component, r7, r8);
    L9:
        int r9 = getManagedProfileId(r6, r8);
        RestrictedLockUtils.EnforcedAdmin r10 = getProfileOrDeviceOwner(r6, getUserHandleOf(r9));
        if (r10 == null) goto L12;
        r3 = r0.isAccessibilityServicePermittedByAdmin(r10.component, r7, r9);
    L12:
        if (r4 == true) goto L16;
        if (r3 == true) goto L16;
        return RestrictedLockUtils.EnforcedAdmin.MULTIPLE_ENFORCED_ADMIN;
    L16:
        if (r4 == true) goto L18;
        return r2;
    L18:
        if (r3 == true) goto L20;
        return r10;
    L20:
        return null;
    L8:
        r4 = true;
        goto L9
    }

    private static int getManagedProfileId(Context r2, int r3) {
        Iterator r4 = ((UserManager) r2.getSystemService(PickApplicationActivity.EXTRA_USER)).getProfiles(r3).iterator();
    L4:
        if (r4.hasNext() == false) goto L12;
        UserInfo r0 = (UserInfo) r4.next();
        if (r0.id == r3) goto L4;
        if (r0.isManagedProfile() == false) goto L4;
        return r0.id;
    L12:
        return -10000;
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfAccountManagementDisabled(Context r6, String r7, int r8) {
        if (r7 != null) goto L5;
        return null;
    L5:
        DevicePolicyManager r1 = (DevicePolicyManager) r6.getSystemService("device_policy");
        if (r6.getPackageManager().hasSystemFeature("android.software.device_admin") == false) goto L19;
        if (r1 == null) goto L19;
        String[] r2 = r1.getAccountTypesWithManagementDisabledAsUser(r8);
        int r3 = r2.length;
        boolean r4 = false;
        int r5 = 0;
    L10:
        if (r5 >= r3) goto L15;
        if (r7.equals(r2[r5]) == true) goto L13;
        r5 = r5 + 1;
        goto L10
    L13:
        r4 = true;
    L15:
        if (r4 == true) goto L18;
        return null;
    L18:
        return getProfileOrDeviceOwner(r6, getUserHandleOf(r8));
    L19:
        return null;
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfUsbDataSignalingIsDisabled(Context r2, int r3) {
        DevicePolicyManager r0 = (DevicePolicyManager) r2.getSystemService(DevicePolicyManager.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isUsbDataSignalingEnabled() == true) goto L17;
        RestrictedLockUtils.EnforcedAdmin r1 = getProfileOrDeviceOwner(r2, getUserHandleOf(r3));
        int r4 = getManagedProfileId(r2, r3);
        if (r1 == null) goto L10;
        return r1;
    L10:
        if (r4 != (-10000)) goto L12;
        return r1;
    L12:
        return getProfileOrDeviceOwner(r2, getUserHandleOf(r4));
    L17:
        return null;
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfMeteredDataUsageUserControlDisabled(Context r3, String r4, int r5) {
        RoleManager r0 = (RoleManager) r3.getSystemService(RoleManager.class);
        UserHandle r1 = getUserHandleOf(r5);
        if (r0.getRoleHoldersAsUser("android.app.role.FINANCED_DEVICE_KIOSK", r1).contains(r4) == true) goto L16;
        if (r0.getRoleHoldersAsUser(ROLE_DEVICE_LOCK_CONTROLLER, r1).contains(r4) == true) goto L16;
        RestrictedLockUtils.EnforcedAdmin r2 = getProfileOrDeviceOwner(r3, r1);
        if (r2 != null) goto L11;
        return null;
    L11:
        if (((DevicePolicyManager) r3.getSystemService("device_policy")).isMeteredDataDisabledPackageForUser(r2.component, r4, r5) == false) goto L14;
        return r2;
    L14:
        return null;
    L16:
        return new RestrictedLockUtils.EnforcedAdmin();
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfPasswordQualityIsSet(Context r6, int r7) {
        LockSettingCheck r0 = new RestrictedLockUtilsInternal$$ExternalSyntheticLambda2();
        DevicePolicyManager r1 = (DevicePolicyManager) r6.getSystemService("device_policy");
        RestrictedLockUtils.EnforcedAdmin r2 = null;
        if (r1 != null) goto L5;
        return null;
    L5:
        LockPatternUtils r3 = new LockPatternUtils(r6);
        int r4 = r1.getAggregatedPasswordComplexityForUser(r7);
        if (r4 <= 0) goto L21;
        UserHandle r5 = r1.getDeviceOwnerUser();
        if (r5 != null) goto L10;
        Iterator r8 = UserManager.get(r6).getProfiles(r7).iterator();
    L13:
        if (r8.hasNext() == false) goto L19;
        UserInfo r9 = (UserInfo) r8.next();
        ComponentName r10 = r1.getProfileOwnerAsUser(r9.id);
        if (r10 == null) goto L13;
        return new RestrictedLockUtils.EnforcedAdmin(r10, getUserHandleOf(r9.id));
    L19:
        throw new IllegalStateException(String.format("Could not find admin enforcing complexity %d for user %d", new Object[]{Integer.valueOf(r4), Integer.valueOf(r7)}));
    L10:
        return new RestrictedLockUtils.EnforcedAdmin(r1.getDeviceOwnerComponentOnAnyUser(), r5);
    L21:
        if (sProxy.isSeparateProfileChallengeEnabled(r3, r7) == false) goto L36;
        List r11 = r1.getActiveAdminsAsUser(r7);
        if (r11 != null) goto L25;
        return null;
    L25:
        UserHandle r12 = getUserHandleOf(r7);
        Iterator r13 = r11.iterator();
    L27:
        if (r13.hasNext() == false) goto L34;
        ComponentName r14 = (ComponentName) r13.next();
        if (r0.isEnforcing(r1, r14, r7) == false) goto L27;
        if (r2 != null) goto L33;
        r2 = new RestrictedLockUtils.EnforcedAdmin(r14, r12);
        goto L27
    L33:
        return RestrictedLockUtils.EnforcedAdmin.MULTIPLE_ENFORCED_ADMIN;
    L34:
        return r2;
    L36:
        return checkForLockSetting(r6, r7, r0);
    }

    static /* synthetic */ boolean lambda$checkIfPasswordQualityIsSet$1(DevicePolicyManager r0, ComponentName r1, int r2) {
        if (r0.getPasswordQuality(r1, r2) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfMaximumTimeToLockIsSet(Context r2) {
        return checkForLockSetting(r2, UserHandle.myUserId(), new RestrictedLockUtilsInternal$$ExternalSyntheticLambda0());
    }

    static /* synthetic */ boolean lambda$checkIfMaximumTimeToLockIsSet$2(DevicePolicyManager r2, ComponentName r3, int r4) {
        if (r2.getMaximumTimeToLock(r3, r4) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static RestrictedLockUtils.EnforcedAdmin checkForLockSetting(Context r9, int r10, LockSettingCheck r11) {
        DevicePolicyManager r0 = (DevicePolicyManager) r9.getSystemService("device_policy");
        RestrictedLockUtils.EnforcedAdmin r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        LockPatternUtils r2 = new LockPatternUtils(r9);
        Iterator r12 = UserManager.get(r9).getProfiles(r10).iterator();
    L7:
        if (r12.hasNext() == false) goto L30;
        UserInfo r13 = (UserInfo) r12.next();
        List r3 = r0.getActiveAdminsAsUser(r13.id);
        if (r3 == null) goto L7;
        UserHandle r4 = getUserHandleOf(r13.id);
        boolean r5 = sProxy.isSeparateProfileChallengeEnabled(r2, r13.id);
        Iterator r6 = r3.iterator();
    L13:
        if (r6.hasNext() == false) goto L7;
        ComponentName r7 = (ComponentName) r6.next();
        if (r5 == true) goto L23;
        if (r11.isEnforcing(r0, r7, r13.id) == false) goto L23;
        if (r1 != null) goto L21;
        r1 = new RestrictedLockUtils.EnforcedAdmin(r7, r4);
        goto L13
    L21:
        return RestrictedLockUtils.EnforcedAdmin.MULTIPLE_ENFORCED_ADMIN;
    L23:
        if (r13.isManagedProfile() == false) goto L13;
        if (r11.isEnforcing(sProxy.getParentProfileInstance(r0, r13), r7, r13.id) == false) goto L13;
        if (r1 != null) goto L29;
        r1 = new RestrictedLockUtils.EnforcedAdmin(r7, r4);
        goto L13
    L29:
        return RestrictedLockUtils.EnforcedAdmin.MULTIPLE_ENFORCED_ADMIN;
    L30:
        return r1;
    }

    public static RestrictedLockUtils.EnforcedAdmin getDeviceOwner(Context r1) {
        return getDeviceOwner(r1, null);
    }

    private static RestrictedLockUtils.EnforcedAdmin getDeviceOwner(Context r2, String r3) {
        DevicePolicyManager r4 = (DevicePolicyManager) r2.getSystemService("device_policy");
        if (r4 != null) goto L5;
        return null;
    L5:
        ComponentName r1 = r4.getDeviceOwnerComponentOnAnyUser();
        if (r1 != null) goto L8;
        return null;
    L8:
        return new RestrictedLockUtils.EnforcedAdmin(r1, r3, r4.getDeviceOwnerUser());
    }

    private static RestrictedLockUtils.EnforcedAdmin getProfileOwner(Context r1, int r2) {
        return getProfileOwner(r1, null, r2);
    }

    private static RestrictedLockUtils.EnforcedAdmin getProfileOwner(Context r2, String r3, int r4) {
        if (r4 != (-10000)) goto L5;
        return null;
    L5:
        DevicePolicyManager r5 = (DevicePolicyManager) r2.getSystemService("device_policy");
        if (r5 != null) goto L8;
        return null;
    L8:
        ComponentName r6 = r5.getProfileOwnerAsUser(r4);
        if (r6 != null) goto L11;
        return null;
    L11:
        return new RestrictedLockUtils.EnforcedAdmin(r6, r3, getUserHandleOf(r4));
    }

    public static void setMenuItemAsDisabledByAdmin(final Context r5, MenuItem r6, final RestrictedLockUtils.EnforcedAdmin r7) {
        SpannableStringBuilder r0 = new SpannableStringBuilder(r6.getTitle());
        removeExistingRestrictedSpans(r0);
        if (r7 == null) goto L5;
        r0.setSpan(new ForegroundColorSpan(Utils.getColorAttrDefaultColor(r5, android.R.attr.textColorHint)), 0, r0.length(), 33);
        r0.append(HanziToPinyin.Token.SEPARATOR, new RestrictedLockImageSpan(r5), 33);
        r6.setOnMenuItemClickListener(new AnonymousClass1(r5, r7));
    L6:
        r6.setTitle(r0);
        return;
    L5:
        r6.setOnMenuItemClickListener(null);
        goto L6
    }

    private static void removeExistingRestrictedSpans(SpannableStringBuilder r8) {
        int r0 = r8.length();
        RestrictedLockImageSpan[] r1 = (RestrictedLockImageSpan[]) r8.getSpans(r0 - 1, r0, RestrictedLockImageSpan.class);
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        RestrictedLockImageSpan r5 = r1[r4];
        int r6 = r8.getSpanStart(r5);
        int r7 = r8.getSpanEnd(r5);
        r8.removeSpan(r5);
        r8.delete(r6, r7);
        r4 = r4 + 1;
        goto L3
    L5:
        ForegroundColorSpan[] r9 = (ForegroundColorSpan[]) r8.getSpans(0, r0, ForegroundColorSpan.class);
        int r10 = r9.length;
    L6:
        if (r3 >= r10) goto L8;
        r8.removeSpan(r9[r3]);
        r3 = r3 + 1;
        goto L6
    }

    public static boolean isAdminInCurrentUserOrProfile(Context r2, ComponentName r3) {
        DevicePolicyManager r0 = (DevicePolicyManager) r2.getSystemService("device_policy");
        Iterator r4 = UserManager.get(r2).getProfiles(UserHandle.myUserId()).iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        if (r0.isAdminActiveAsUser(r3, ((UserInfo) r4.next()).id) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public static void setTextViewPadlock(Context r2, TextView r3, boolean r4) {
        SpannableStringBuilder r0 = new SpannableStringBuilder(r3.getText());
        removeExistingRestrictedSpans(r0);
        if (r4 == false) goto L5;
        r0.append(HanziToPinyin.Token.SEPARATOR, new RestrictedLockImageSpan(r2), 33);
    L5:
        r3.setText(r0);
    }

    public static void setTextViewAsDisabledByAdmin(Context r5, TextView r6, boolean r7) {
        SpannableStringBuilder r0 = new SpannableStringBuilder(r6.getText());
        removeExistingRestrictedSpans(r0);
        if (r7 == false) goto L5;
        r0.setSpan(new ForegroundColorSpan(Utils.getDisabled(r5, r6.getCurrentTextColor())), 0, r0.length(), 33);
        r6.setCompoundDrawables(null, null, getRestrictedPadlock(r5), null);
        r6.setCompoundDrawablePadding(r5.getResources().getDimensionPixelSize(R.dimen.restricted_icon_padding));
    L6:
        r6.setText(r0);
        return;
    L5:
        r6.setCompoundDrawables(null, null, null, null);
        goto L6
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfMteIsDisabled(Context r2) {
        if (((DevicePolicyManager) r2.getSystemService(DevicePolicyManager.class)).getMtePolicy() != 0) goto L6;
        return null;
    L6:
        RestrictedLockUtils.EnforcedAdmin r1 = RestrictedLockUtils.getProfileOrDeviceOwner(r2, UserHandle.of(0));
        if (r1 == null) goto L10;
        return r1;
    L10:
        return RestrictedLockUtils.getProfileOrDeviceOwner(r2, UserHandle.of(getManagedProfileId(r2, 0)));
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfApplicationCanBeCredentialManagerProvider(Context r2, String r3) {
        PackagePolicy r0 = ((DevicePolicyManager) r2.getSystemService(DevicePolicyManager.class)).getCredentialManagerPolicy();
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isPackageAllowed(r3, new HashSet()) == true) goto L14;
        RestrictedLockUtils.EnforcedAdmin r4 = getDeviceOwner(r2);
        if (r4 == null) goto L11;
        return r4;
    L11:
        return RestrictedLockUtils.getProfileOrDeviceOwner(r2, UserHandle.of(getManagedProfileId(r2, 0)));
    L14:
        return null;
    }
}
