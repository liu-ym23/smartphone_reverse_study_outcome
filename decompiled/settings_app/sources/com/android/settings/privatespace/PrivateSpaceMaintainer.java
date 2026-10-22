package com.android.settings.privatespace;

import android.app.ActivityManager;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.UserInfo;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.util.ArraySet;
import com.GlobalProxyLancet;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class PrivateSpaceMaintainer {
    public static final int HIDE_PRIVATE_SPACE_ENTRY_POINT_DISABLED_VAL = 0;
    public static final int HIDE_PRIVATE_SPACE_ENTRY_POINT_ENABLED_VAL = 1;
    public static final int HIDE_PRIVATE_SPACE_SENSITIVE_NOTIFICATIONS_DISABLED_VAL = 0;
    public static final int PRIVATE_SPACE_AUTO_LOCK_DEFAULT_VAL = 0;
    public static final int PRIVATE_SPACE_CREATE_AUTO_LOCK_VAL = 2;
    private static final String TAG = "PrivateSpaceMaintainer";
    private static PrivateSpaceMaintainer sPrivateSpaceMaintainer;
    private final ActivityManager mActivityManager;
    private final Context mContext;
    private int mErrorCode;
    private final KeyguardManager mKeyguardManager;
    private ProfileBroadcastReceiver mProfileBroadcastReceiver;
    private UserHandle mUserHandle;
    private final UserManager mUserManager;

    /* JADX INFO: renamed from: com.android.settings.privatespace.PrivateSpaceMaintainer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final enum ErrorDeletingPrivateSpace extends Enum<ErrorDeletingPrivateSpace> {
        private static final /* synthetic */ ErrorDeletingPrivateSpace[] $VALUES = null;
        public static final ErrorDeletingPrivateSpace DELETE_PS_ERROR_INTERNAL = null;
        public static final ErrorDeletingPrivateSpace DELETE_PS_ERROR_NONE = null;
        public static final ErrorDeletingPrivateSpace DELETE_PS_ERROR_NO_PRIVATE_SPACE = null;

        private static /* synthetic */ ErrorDeletingPrivateSpace[] $values() {
            return new ErrorDeletingPrivateSpace[]{DELETE_PS_ERROR_NONE, DELETE_PS_ERROR_NO_PRIVATE_SPACE, DELETE_PS_ERROR_INTERNAL};
        }

        private ErrorDeletingPrivateSpace(String r1, int r2) {
            super(r1, r2);
        }

        public static ErrorDeletingPrivateSpace valueOf(String r1) {
            return (ErrorDeletingPrivateSpace) Enum.valueOf(ErrorDeletingPrivateSpace.class, r1);
        }

        public static ErrorDeletingPrivateSpace[] values() {
            return (ErrorDeletingPrivateSpace[]) $VALUES.clone();
        }

        static {
            DELETE_PS_ERROR_NONE = new ErrorDeletingPrivateSpace("DELETE_PS_ERROR_NONE", 0);
            DELETE_PS_ERROR_NO_PRIVATE_SPACE = new ErrorDeletingPrivateSpace("DELETE_PS_ERROR_NO_PRIVATE_SPACE", 1);
            DELETE_PS_ERROR_INTERNAL = new ErrorDeletingPrivateSpace("DELETE_PS_ERROR_INTERNAL", 2);
            $VALUES = $values();
        }
    }

    private final class ProfileBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ PrivateSpaceMaintainer this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_privatespace_PrivateSpaceMaintainer$ProfileBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private ProfileBroadcastReceiver(PrivateSpaceMaintainer r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ProfileBroadcastReceiver(PrivateSpaceMaintainer r1, AnonymousClass1 r2) {
            this(r1);
        }

        void register() {
            IntentFilter r0 = new IntentFilter();
            r0.addAction("android.intent.action.PROFILE_UNAVAILABLE");
            r0.addAction("android.intent.action.PROFILE_REMOVED");
            GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(PrivateSpaceMaintainer.access$000(this.this$0), this, r0, 4);
        }

        void unregister() {
            OLog.d(PrivateSpaceMaintainer.TAG, "Unregistering the receiver");
            PrivateSpaceMaintainer.access$000(this.this$0).unregisterReceiver(this);
        }

        public void com_android_settings_privatespace_PrivateSpaceMaintainer$ProfileBroadcastReceiver__onReceive$___twin___(Context r2, Intent r3) {
            UserHandle r4 = (UserHandle) r3.getParcelableExtra("android.intent.extra.USER", UserHandle.class);
            if (r3.getAction().equals("android.intent.action.PROFILE_REMOVED") == false) goto L10;
            if (r4.equals(this.this$0.getPrivateProfileHandle()) == false) goto L7;
            PrivateSpaceMaintainer.access$102(this.this$0, null);
        L7:
            PrivateSpaceMaintainer.access$200(this.this$0);
            PrivateSpaceMaintainer.access$300(this.this$0);
            return;
        L10:
            if (r4.equals(this.this$0.getPrivateProfileHandle()) == true) goto L13;
            OLog.d(PrivateSpaceMaintainer.TAG, "Ignoring intent for non-private profile with user id " + r4.getIdentifier());
            return;
        L13:
            OLog.i(PrivateSpaceMaintainer.TAG, "Removing all Settings tasks.");
            PrivateSpaceMaintainer.access$200(this.this$0);
        }

        @Insert("onReceive")
        public static void com_android_settings_privatespace_PrivateSpaceMaintainer$ProfileBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(ProfileBroadcastReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            ProfileBroadcastReceiver r1 = r7;
            String r2 = r1.getClass().getName();
            String r3 = r1.getClass().getSimpleName();
            boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
            String r5 = null;
            if (r9 == null) goto L5;
            String r6 = r9.getAction();
        L7:
            if (ArraysKt.contains(r0, r6) == false) goto L13;
            StringBuilder r10 = new StringBuilder("onReceive allowList ");
            if (r9 == null) goto L11;
            r5 = r9.getAction();
        L11:
            OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
            r7.com_android_settings_privatespace_PrivateSpaceMaintainer$ProfileBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_privatespace_PrivateSpaceMaintainer$ProfileBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_privatespace_PrivateSpaceMaintainer$ProfileBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_privatespace_PrivateSpaceMaintainer$ProfileBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L19:
            if (r13.length() == 0) goto L22;
            r14 = false;
            goto L23
        L5:
            r6 = null;
            goto L7
        }
    }

    static /* synthetic */ Context access$000(PrivateSpaceMaintainer r0) {
        return r0.mContext;
    }

    static /* synthetic */ UserHandle access$102(PrivateSpaceMaintainer r0, UserHandle r1) {
        r0.mUserHandle = r1;
        return r1;
    }

    static /* synthetic */ void access$200(PrivateSpaceMaintainer r0) {
        r0.removeSettingsAllTasks();
    }

    static /* synthetic */ void access$300(PrivateSpaceMaintainer r0) {
        r0.unregisterBroadcastReceiver();
    }

    public final synchronized boolean createPrivateSpace() {
        monitor-enter(this);
    L29:
        th = move-exception;
        throw th;
    L6:
        if (doesPrivateSpaceExist() == false) goto L10;
        monitor-exit(this);
        return true;
    L10:
        if (this.mUserHandle == null) goto L32;
    L27:
        monitor-exit(this);
        return true;
    L32:
        UserHandle r3 = this.mUserManager.createProfile("Private space", "android.os.usertype.profile.PRIVATE", new ArraySet());     // Catch: Exception -> L23 Throwable -> L29
        this.mUserHandle = r3;     // Catch: Exception -> L23 Throwable -> L29
        if (r3 != null) goto L17;
        OLog.e(TAG, "Failed to create private space");     // Catch: Throwable -> L29
        monitor-exit(this);
        return false;
    L17:
        registerBroadcastReceiver();     // Catch: Throwable -> L29
        if (startProfile() == true) goto L22;
        OLog.e(TAG, "profile not started, created profile is deleted");     // Catch: Throwable -> L29
        deletePrivateSpace();     // Catch: Throwable -> L29
        monitor-exit(this);
        return false;
    L22:
        OLog.i(TAG, "Private space created with id: " + this.mUserHandle.getIdentifier());     // Catch: Throwable -> L29
        resetPrivateSpaceSettings();     // Catch: Throwable -> L29
        setUserSetupComplete();     // Catch: Throwable -> L29
        setSkipFirstUseHints();     // Catch: Throwable -> L29
        disableComponentsToHidePrivateSpaceSettings();     // Catch: Throwable -> L29
        goto L27
    L23:
        e = move-exception;
        OLog.e(TAG, "Error creating private space", e);     // Catch: Throwable -> L29
        this.mErrorCode = ((UserManager.UserOperationException) e).getUserOperationResult();     // Catch: Throwable -> L29
        return false;
    }

    public synchronized ErrorDeletingPrivateSpace deletePrivateSpace() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (doesPrivateSpaceExist() == true) goto L25;
        ErrorDeletingPrivateSpace r0 = ErrorDeletingPrivateSpace.DELETE_PS_ERROR_NO_PRIVATE_SPACE;     // Catch: Throwable -> L21
        monitor-exit(this);
        return r0;
    L25:
        OLog.i(TAG, "Deleting Private space with id: " + this.mUserHandle.getIdentifier());     // Catch: Exception -> L16 Throwable -> L21
        if (this.mUserManager.removeUser(this.mUserHandle) == false) goto L14;
        OLog.i(TAG, "Private space deleted");     // Catch: Exception -> L16 Throwable -> L21
        this.mUserHandle = null;     // Catch: Exception -> L16 Throwable -> L21
        ErrorDeletingPrivateSpace r1 = ErrorDeletingPrivateSpace.DELETE_PS_ERROR_NONE;     // Catch: Exception -> L16 Throwable -> L21
        monitor-exit(this);
        return r1;
    L14:
        OLog.e(TAG, "Failed to delete private space");     // Catch: Exception -> L16 Throwable -> L21
    L18:
        ErrorDeletingPrivateSpace r2 = ErrorDeletingPrivateSpace.DELETE_PS_ERROR_INTERNAL;     // Catch: Throwable -> L21
        monitor-exit(this);
        return r2;
    L16:
        e = move-exception;
        OLog.e(TAG, "Error deleting private space", e);     // Catch: Throwable -> L21
        goto L18
    }

    public synchronized boolean doesPrivateSpaceExist() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.mUserHandle == null) goto L8;
        monitor-exit(this);
        return true;
    L8:
        Iterator r0 = this.mUserManager.getProfiles(this.mContext.getUserId()).iterator();     // Catch: Throwable -> L21
    L10:
        if (r0.hasNext() == false) goto L18;
        UserInfo r2 = (UserInfo) r0.next();     // Catch: Throwable -> L21
        if (r2.isPrivateProfile() == false) goto L10;
        if (r2.isEnabled() == false) goto L10;
        this.mUserHandle = r2.getUserHandle();     // Catch: Throwable -> L21
        registerBroadcastReceiver();     // Catch: Throwable -> L21
        monitor-exit(this);
        return true;
    L18:
        monitor-exit(this);
        return false;
    }

    public synchronized boolean isPrivateSpaceLocked() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (doesPrivateSpaceExist() == true) goto L8;
        monitor-exit(this);
        return true;
    L8:
        boolean r0 = this.mUserManager.isQuietModeEnabled(this.mUserHandle);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    }

    public synchronized Intent getPrivateProfileLockCredentialIntent() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isPrivateProfileLockSet() == false) goto L8;
        Intent r0 = this.mKeyguardManager.createConfirmDeviceCredentialIntent(null, null, this.mUserHandle.getIdentifier());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L8:
        Intent r1 = this.mKeyguardManager.createConfirmDeviceCredentialIntent(null, null);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    }

    public synchronized UserHandle getPrivateProfileHandle() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (doesPrivateSpaceExist() == false) goto L8;
        UserHandle r0 = this.mUserHandle;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L8:
        monitor-exit(this);
        return null;
    }

    public static synchronized PrivateSpaceMaintainer getInstance(Context r2) {
        monitor-enter(PrivateSpaceMaintainer.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sPrivateSpaceMaintainer != null) goto L7;
        sPrivateSpaceMaintainer = new PrivateSpaceMaintainer(r2);     // Catch: Throwable -> L10
    L7:
        PrivateSpaceMaintainer r3 = sPrivateSpaceMaintainer;     // Catch: Throwable -> L10
        monitor-exit(PrivateSpaceMaintainer.class);
        return r3;
    }

    private PrivateSpaceMaintainer(Context r2) {
        Context r3 = r2.getApplicationContext();
        this.mContext = r3;
        this.mUserManager = (UserManager) r3.getSystemService(UserManager.class);
        this.mKeyguardManager = (KeyguardManager) r3.getSystemService(KeyguardManager.class);
        this.mActivityManager = (ActivityManager) r3.getSystemService(ActivityManager.class);
    }

    private boolean isPrivateProfileLockSet() {
        if (doesPrivateSpaceExist() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mKeyguardManager.isDeviceSecure(this.mUserHandle.getIdentifier()) == false) goto L7;
        return true;
    }

    public void setHidePrivateSpaceEntryPointSetting(int r3) {
        OLog.d(TAG, "Setting HIDE_PRIVATE_SPACE_ENTRY_POINT = " + r3);
        Settings.Secure.putInt(this.mContext.getContentResolver(), "hide_privatespace_entry_point", r3);
    }

    public void setPrivateSpaceAutoLockSetting(int r2) {
        Settings.Secure.putInt(this.mContext.getContentResolver(), "private_space_auto_lock", r2);
    }

    public int getHidePrivateSpaceEntryPointSetting() {
        return Settings.Secure.getInt(this.mContext.getContentResolver(), "hide_privatespace_entry_point", 0);
    }

    public int getPrivateSpaceAutoLockSetting() {
        return Settings.Secure.getInt(this.mContext.getContentResolver(), "private_space_auto_lock", 0);
    }

    public synchronized boolean lockPrivateSpace() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isPrivateProfileRunning() == false) goto L8;
        OLog.d(TAG, "Calling requestQuietModeEnabled to enableQuietMode");     // Catch: Throwable -> L11
        boolean r0 = this.mUserManager.requestQuietModeEnabled(true, this.mUserHandle);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L8:
        monitor-exit(this);
        return false;
    }

    public synchronized void unlockPrivateSpace(IntentSender r4) {
        monitor-enter(this);
        UserHandle r0 = this.mUserHandle;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        this.mUserManager.requestQuietModeEnabled(false, r0, r4);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean isPrivateSpaceEntryPointEnabled() {
        if (this.mUserManager.canAddPrivateProfile() == false) goto L5;
    L8:
        return true;
    L5:
        if (doesPrivateSpaceExist() == true) goto L8;
        return false;
    }

    public int getPrivateSpaceCreateError() {
        return this.mErrorCode;
    }

    synchronized boolean isPrivateProfileRunning() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (doesPrivateSpaceExist() == false) goto L10;
        UserHandle r0 = this.mUserHandle;     // Catch: Throwable -> L13
        if (r0 == null) goto L10;
        boolean r1 = this.mUserManager.isUserRunning(r0);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r1;
    L10:
        monitor-exit(this);
        return false;
    }

    private boolean startProfile() {
        return this.mActivityManager.startProfile(this.mUserHandle);
    L4:
        OLog.e(TAG, "Unexpected that " + this.mUserHandle.getIdentifier() + " is not a profile");
        return false;
    }

    private void resetPrivateSpaceSettings() {
        setHidePrivateSpaceEntryPointSetting(0);
        setPrivateSpaceAutoLockSetting(2);
        setPrivateSpaceSensitiveNotificationsDefaultValue();
    }

    private void setPrivateSpaceSensitiveNotificationsDefaultValue() {
        Settings.Secure.putIntForUser(this.mContext.getContentResolver(), "lock_screen_allow_private_notifications", 0, this.mUserHandle.getIdentifier());
    }

    private void setUserSetupComplete() {
        OLog.d(TAG, "setting USER_SETUP_COMPLETE = 1 for private profile");
        Settings.Secure.putIntForUser(this.mContext.getContentResolver(), "user_setup_complete", 1, this.mUserHandle.getIdentifier());
    }

    private void disableComponentsToHidePrivateSpaceSettings() {
        UserHandle r0 = this.mUserHandle;
        if (r0 != null) goto L6;
        OLog.e(TAG, "User handle null while hiding settings icon");
        return;
    L6:
        this.mContext.createContextAsUser(r0, 0).getPackageManager();
        OLog.d(TAG, "Hiding settings app launcher icon for " + this.mUserHandle);
    }

    private void setSkipFirstUseHints() {
        OLog.d(TAG, "setting SKIP_FIRST_USE_HINTS = 1 for private profile");
        Settings.Secure.putIntForUser(this.mContext.getContentResolver(), "skip_first_use_hints", 1, this.mUserHandle.getIdentifier());
    }

    private synchronized void registerBroadcastReceiver() {
        monitor-enter(this);
        ProfileBroadcastReceiver r0 = getProfileBroadcastReceiver();     // Catch: Throwable -> L10
        if (r0 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        r0.register();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private synchronized void unregisterBroadcastReceiver() {
        monitor-enter(this);
        ProfileBroadcastReceiver r0 = this.mProfileBroadcastReceiver;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        OLog.w(TAG, "Requested to unregister when there is no receiver.");     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L8:
        r0.unregister();     // Catch: Throwable -> L11
        this.mProfileBroadcastReceiver = null;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    synchronized ProfileBroadcastReceiver getProfileBroadcastReceiver() {
        monitor-enter(this);
        AnonymousClass1 r1 = null;
        if (doesPrivateSpaceExist() == true) goto L9;
        OLog.e(TAG, "Cannot return a broadcast receiver when private space doesn't exist");     // Catch: Throwable -> L14
        monitor-exit(this);
        return null;
    L9:
        if (this.mProfileBroadcastReceiver != null) goto L11;
        this.mProfileBroadcastReceiver = new ProfileBroadcastReceiver(this, r1);     // Catch: Throwable -> L14
    L11:
        ProfileBroadcastReceiver r0 = this.mProfileBroadcastReceiver;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }

    synchronized void resetBroadcastReceiver() {
        monitor-enter(this);
        this.mProfileBroadcastReceiver = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void removeSettingsAllTasks() {
        Iterator<ActivityManager.AppTask> r2 = this.mActivityManager.getAppTasks().iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        ActivityManager.AppTask r0 = r2.next();
        if (r0.getTaskInfo().isVisible() == true) goto L4;
        if (r0.getTaskInfo().isFocused == true) goto L4;
        r0.finishAndRemoveTask();
        goto L4
    }
}
