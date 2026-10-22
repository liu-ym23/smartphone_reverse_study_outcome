package com.android.settings.users;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.pm.UserInfo;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;

/* JADX INFO: loaded from: classes2.dex */
public class UserCapabilities {
    boolean mCanAddGuest;
    boolean mCanAddRestrictedProfile;
    boolean mCanAddUser;
    boolean mDisallowAddUser;
    boolean mDisallowAddUserSetByAdmin;
    boolean mDisallowSwitchUser;
    boolean mEnabled;
    RestrictedLockUtils.EnforcedAdmin mEnforcedAdmin;
    boolean mIsAdmin;
    boolean mIsEphemeral;
    boolean mIsGuest;
    boolean mIsMain;
    boolean mUserSwitcherEnabled;
    boolean mUserSwitchingUiEnabled;

    private UserCapabilities() {
        this.mEnabled = true;
        this.mCanAddUser = true;
    }

    public static UserCapabilities create(Context r6) {
        UserManager r0 = (UserManager) r6.getSystemService(PickApplicationActivity.EXTRA_USER);
        UserCapabilities r1 = new UserCapabilities();
        boolean r3 = false;
        if (UserManager.supportsMultipleUsers() == true) goto L5;
    L16:
        r1.mEnabled = false;
        return r1;
    L5:
        if (Utils.isMonkeyRunning() == true) goto L16;
        UserInfo r2 = r0.getUserInfo(UserHandle.myUserId());
        r1.mIsGuest = r2.isGuest();
        r1.mIsAdmin = r2.isAdmin();
        r1.mIsMain = r2.isMain();
        r1.mIsEphemeral = r2.isEphemeral();
        DevicePolicyManager r4 = (DevicePolicyManager) r6.getSystemService("device_policy");
        if (r6.getResources().getBoolean(R.bool.config_offer_restricted_profiles) == true) goto L10;
    L14:
        r1.mCanAddRestrictedProfile = r3;
        r1.mUserSwitchingUiEnabled = r6.getResources().getBoolean(android.R.bool.config_allowChangeUserSwitcherEnabled);
        r1.updateAddUserCapabilities(r6);
        return r1;
    L10:
        if (r4.isDeviceManaged() == true) goto L14;
        if (r0.isUserTypeEnabled("android.os.usertype.full.RESTRICTED") == false) goto L14;
        r3 = true;
        goto L14
    }

    public void updateAddUserCapabilities(Context r7) {
        UserManager r0 = (UserManager) r7.getSystemService(PickApplicationActivity.EXTRA_USER);
        this.mIsAdmin = r0.getUserInfo(UserHandle.myUserId()).isAdmin();
        this.mEnforcedAdmin = RestrictedLockUtilsInternal.checkIfRestrictionEnforced(r7, "no_add_user", UserHandle.myUserId());
        boolean r1 = RestrictedLockUtilsInternal.hasBaseUserRestriction(r7, "no_add_user", UserHandle.myUserId());
        RestrictedLockUtils.EnforcedAdmin r2 = this.mEnforcedAdmin;
        boolean r3 = true;
        if (r2 == null) goto L6;
        if (r1 == true) goto L6;
        boolean r5 = true;
    L7:
        this.mDisallowAddUserSetByAdmin = r5;
        if (r2 != null) goto L12;
        if (r1 == true) goto L12;
        boolean r4 = false;
    L13:
        this.mDisallowAddUser = r4;
        this.mUserSwitcherEnabled = r0.isUserSwitcherEnabled();
        this.mCanAddUser = true;
        if (this.mIsAdmin == true) goto L16;
    L25:
        this.mCanAddUser = false;
    L27:
        if (this.mIsAdmin == false) goto L29;
    L32:
        boolean r8 = true;
    L34:
        if (this.mIsGuest == false) goto L36;
    L41:
        r3 = false;
    L42:
        this.mCanAddGuest = r3;
        this.mDisallowSwitchUser = r0.hasUserRestriction("no_user_switch");
        return;
    L36:
        if (this.mDisallowAddUser == true) goto L41;
        if (r8 == false) goto L41;
        if (r0.isUserTypeEnabled("android.os.usertype.full.GUEST") == false) goto L41;
    L29:
        if (Settings.Global.getInt(r7.getContentResolver(), "add_users_when_locked", 0) == 1) goto L32;
        r8 = false;
        goto L34
    L16:
        if (UserManager.getMaxSupportedUsers() < 2) goto L25;
        if (UserManager.supportsMultipleUsers() == false) goto L25;
        if (this.mDisallowAddUser == true) goto L25;
        if (r0.isUserTypeEnabled("android.os.usertype.full.SECONDARY") == true) goto L27;
        if (this.mCanAddRestrictedProfile == true) goto L27;
    L12:
        r4 = true;
    L6:
        r5 = false;
        goto L7
    }

    public boolean isAdmin() {
        return this.mIsAdmin;
    }

    public boolean disallowAddUser() {
        return this.mDisallowAddUser;
    }

    public boolean disallowAddUserSetByAdmin() {
        return this.mDisallowAddUserSetByAdmin;
    }

    public RestrictedLockUtils.EnforcedAdmin getEnforcedAdmin() {
        return this.mEnforcedAdmin;
    }

    public String toString() {
        return "UserCapabilities{mEnabled=" + this.mEnabled + ", mCanAddUser=" + this.mCanAddUser + ", mCanAddRestrictedProfile=" + this.mCanAddRestrictedProfile + ", mIsAdmin=" + this.mIsAdmin + ", mIsGuest=" + this.mIsGuest + ", mCanAddGuest=" + this.mCanAddGuest + ", mDisallowAddUser=" + this.mDisallowAddUser + ", mEnforcedAdmin=" + this.mEnforcedAdmin + ", mDisallowSwitchUser=" + this.mDisallowSwitchUser + ", mDisallowAddUserSetByAdmin=" + this.mDisallowAddUserSetByAdmin + ", mUserSwitchingUiEnabled=" + this.mUserSwitchingUiEnabled + ", mUserSwitcherEnabled=" + this.mUserSwitcherEnabled + '}';
    }
}
