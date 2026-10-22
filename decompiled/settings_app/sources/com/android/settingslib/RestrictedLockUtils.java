package com.android.settingslib;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import android.os.UserManager;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class RestrictedLockUtils {

    public static class EnforcedAdmin {
        public static final EnforcedAdmin MULTIPLE_ENFORCED_ADMIN = null;
        public ComponentName component;
        public String enforcedRestriction;
        public UserHandle user;

        static {
            MULTIPLE_ENFORCED_ADMIN = new EnforcedAdmin();
        }

        public static EnforcedAdmin createDefaultEnforcedAdminWithRestriction(String r1) {
            EnforcedAdmin r0 = new EnforcedAdmin();
            r0.enforcedRestriction = r1;
            return r0;
        }

        public EnforcedAdmin(ComponentName r2, UserHandle r3) {
            this.enforcedRestriction = null;
            this.component = r2;
            this.user = r3;
        }

        public EnforcedAdmin(ComponentName r1, String r2, UserHandle r3) {
            this.component = r1;
            this.enforcedRestriction = r2;
            this.user = r3;
        }

        public EnforcedAdmin(EnforcedAdmin r2) {
            this.component = null;
            this.enforcedRestriction = null;
            this.user = null;
            if (r2 == null) goto L7;
            this.component = r2.component;
            this.enforcedRestriction = r2.enforcedRestriction;
            this.user = r2.user;
            return;
        L7:
            throw new IllegalArgumentException();
        }

        public EnforcedAdmin() {
            this.component = null;
            this.enforcedRestriction = null;
            this.user = null;
        }

        public static EnforcedAdmin combine(EnforcedAdmin r1, EnforcedAdmin r2) {
            if (r1 != null) goto L4;
            return r2;
        L4:
            if (r2 != null) goto L7;
            return r1;
        L7:
            if (r1.equals(r2) == false) goto L10;
            return r1;
        L10:
            if (r1.enforcedRestriction.equals(r2.enforcedRestriction) == false) goto L14;
            return MULTIPLE_ENFORCED_ADMIN;
        L14:
            throw new IllegalArgumentException("Admins with different restriction cannot be combined");
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L19:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L19;
            EnforcedAdmin r6 = (EnforcedAdmin) r5;
            if (Objects.equals(this.user, r6.user) == false) goto L18;
            if (Objects.equals(this.component, r6.component) == false) goto L18;
            if (Objects.equals(this.enforcedRestriction, r6.enforcedRestriction) == false) goto L18;
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.component, this.enforcedRestriction, this.user});
        }

        public String toString() {
            return "EnforcedAdmin{component=" + this.component + ", enforcedRestriction='" + this.enforcedRestriction + ", user=" + this.user + '}';
        }
    }

    public RestrictedLockUtils() {
    }

    public static EnforcedAdmin getProfileOrDeviceOwner(Context r1, UserHandle r2) {
        return getProfileOrDeviceOwner(r1, null, r2);
    }

    public static EnforcedAdmin getProfileOrDeviceOwner(Context r4, String r5, UserHandle r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        DevicePolicyManager r1 = (DevicePolicyManager) r4.getSystemService("device_policy");
        if (r1 != null) goto L22;
        return null;
    L22:
        ComponentName r7 = ((DevicePolicyManager) r4.createPackageContextAsUser(r4.getPackageName(), 0, r6).getSystemService(DevicePolicyManager.class)).getProfileOwner();
        if (r7 == null) goto L14;
        return new EnforcedAdmin(r7, r5, r6);
    L14:
        if (Objects.equals(r1.getDeviceOwnerUser(), r6) == false) goto L24;
        ComponentName r8 = r1.getDeviceOwnerComponentOnAnyUser();
        if (r8 != null) goto L18;
        return null;
    L18:
        return new EnforcedAdmin(r8, r5, r6);
    L24:
        return null;
    L19:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static void sendShowAdminSupportDetailsIntent(Context r3, EnforcedAdmin r4) {
        Intent r0 = getShowAdminSupportDetailsIntent(r4);
        int r1 = UserHandle.myUserId();
        if (r4 != null) goto L5;
    L10:
        r3.startActivityAsUser(r0, UserHandle.of(r1));
        return;
    L5:
        if (r4.user != null) goto L7;
    L9:
        r0.putExtra("android.app.extra.RESTRICTION", r4.enforcedRestriction);
        goto L10
    L7:
        if (isCurrentUserOrProfile(r3, r4.user.getIdentifier()) == false) goto L9;
        r1 = r4.user.getIdentifier();
        goto L9
    }

    public static Intent getShowAdminSupportDetailsIntent(Context r0, EnforcedAdmin r1) {
        return getShowAdminSupportDetailsIntent(r1);
    }

    public static Intent getShowAdminSupportDetailsIntent(EnforcedAdmin r3) {
        Intent r0 = new Intent("android.settings.SHOW_ADMIN_SUPPORT_DETAILS");
        if (r3 != null) goto L5;
    L8:
        return r0;
    L5:
        if (r3.component == null) goto L7;
        r0.putExtra("android.app.extra.DEVICE_ADMIN", r3.component);
    L7:
        r0.putExtra("android.intent.extra.USER", r3.user);
        goto L8
    }

    public static boolean isCurrentUserOrProfile(Context r1, int r2) {
        return ((UserManager) r1.getSystemService(UserManager.class)).getUserProfiles().contains(UserHandle.of(r2));
    }

    @Deprecated
    public static void sendShowRestrictedSettingDialogIntent(Context r0, String r1, int r2) {
        r0.startActivity(getShowRestrictedSettingsIntent(r1, r2));
    }

    @Deprecated
    private static Intent getShowRestrictedSettingsIntent(String r2, int r3) {
        Intent r0 = new Intent("android.settings.SHOW_RESTRICTED_SETTING_DIALOG");
        r0.putExtra("android.intent.extra.PACKAGE_NAME", r2);
        r0.putExtra("android.intent.extra.UID", r3);
        return r0;
    }
}
