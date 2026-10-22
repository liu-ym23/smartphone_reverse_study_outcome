package com.android.settings.applications;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.admin.DevicePolicyManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.usb.IUsbManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.SettingsActivity;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;
import com.android.settings.activityembedding.ActivityEmbeddingUtils;
import com.android.settings.password.PasswordUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppInfoBase extends SettingsPreferenceFragment implements com.android.settingslib.applications.ApplicationsState.Callbacks {
    public static final String ARG_PACKAGE_NAME = "package";
    public static final String ARG_PACKAGE_UID = "uid";
    protected static final int DLG_BASE = 0;
    protected static final String TAG = "AppInfoBase";
    protected static final boolean localLOGV = false;
    protected com.android.settingslib.applications.ApplicationsState.AppEntry mAppEntry;
    protected RestrictedLockUtils.EnforcedAdmin mAppsControlDisallowedAdmin;
    protected boolean mAppsControlDisallowedBySystem;
    protected DevicePolicyManager mDpm;
    protected boolean mFinishing;
    protected PackageInfo mPackageInfo;
    protected String mPackageName;
    protected PackageManager mPm;
    protected com.android.settingslib.applications.ApplicationsState.Session mSession;
    protected com.android.settingslib.applications.ApplicationsState mState;
    protected IUsbManager mUsbManager;
    protected int mUserId;
    protected UserManager mUserManager;

    public static class MyAlertDialogFragment extends DialogFragment {
        public void com_android_settings_applications_AppInfoBase$MyAlertDialogFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_applications_AppInfoBase$MyAlertDialogFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_applications_AppInfoBase$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_applications_AppInfoBase$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public MyAlertDialogFragment() {
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r3) {
            int r4 = getArguments().getInt("id");
            AlertDialog r2 = ((AppInfoBase) getTargetFragment()).createDialog(r4, getArguments().getInt("moveError"));
            if (r2 == null) goto L6;
            return r2;
        L6:
            throw new IllegalArgumentException("unknown id " + r4);
        }

        public static MyAlertDialogFragment newInstance(int r3, int r4) {
            MyAlertDialogFragment r0 = new MyAlertDialogFragment();
            Bundle r1 = new Bundle();
            r1.putInt("id", r3);
            r1.putInt("moveError", r4);
            r0.setArguments(r1);
            return r0;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_applications_AppInfoBase$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(MyAlertDialogFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_applications_AppInfoBase$MyAlertDialogFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_applications_AppInfoBase$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(MyAlertDialogFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_applications_AppInfoBase$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_applications_AppInfoBase$MyAlertDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(MyAlertDialogFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_applications_AppInfoBase$MyAlertDialogFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    static {
    }

    protected abstract AlertDialog createDialog(int r1, int r2);

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onAllSizesComputed() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onLauncherInfoChanged() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onLoadEntriesCompleted() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageIconChanged() {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageSizeChanged(String r1) {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onRebuildComplete(ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r1) {
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onRunningStateChanged(boolean r1) {
    }

    protected abstract boolean refreshUi();

    public AppInfoBase() {
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.mFinishing = false;
        com.android.settingslib.applications.ApplicationsState r3 = com.android.settingslib.applications.ApplicationsState.getInstance(getActivity().getApplication());
        this.mState = r3;
        this.mSession = r3.newSession(this);
        FragmentActivity r4 = getActivity();
        this.mDpm = (DevicePolicyManager) r4.getSystemService("device_policy");
        this.mUserManager = (UserManager) r4.getSystemService(PickApplicationActivity.EXTRA_USER);
        this.mPm = r4.getPackageManager();
        this.mUsbManager = IUsbManager.Stub.asInterface(ServiceManager.getService("usb"));
        retrieveAppEntry();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MultiSDKAdapter.resumeSession(this.mSession);
        this.mAppsControlDisallowedAdmin = MultiSDKAdapterNew.checkIfRestrictionEnforced(getActivity(), "no_control_apps", this.mUserId);
        this.mAppsControlDisallowedBySystem = MultiSDKAdapterNew.hasBaseUserRestriction(getActivity(), "no_control_apps", this.mUserId);
        if (refreshUi() == true) goto L6;
        setIntentAndFinish(true, true);
        return;
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        MultiSDKAdapter.pauseSession(this.mSession);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        MultiSDKAdapter.releaseSession(this.mSession);
        super.onDestroy();
    }

    protected String retrieveAppEntry() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        String r2 = r0.getString("package");
    L6:
        this.mPackageName = r2;
        if (r0 != null) goto L9;
        Intent r1 = getIntent();
    L11:
        if (this.mPackageName != null) goto L16;
        if (r1 == null) goto L16;
        if (r1.getData() == null) goto L16;
        this.mPackageName = r1.getData().getSchemeSpecificPart();
    L16:
        if (r1 != null) goto L18;
    L25:
        this.mUserId = UserHandle.myUserId();
    L26:
        com.android.settingslib.applications.ApplicationsState.AppEntry r3 = this.mState.getEntry(this.mPackageName, this.mUserId);
        this.mAppEntry = r3;
        if (r3 != null) goto L35;
        OLog.w(TAG, "Missing AppEntry; maybe reinstalling?");
        this.mPackageInfo = null;
    L34:
        return this.mPackageName;
    L35:
        this.mPackageInfo = this.mPm.getPackageInfoAsUser(r3.info.packageName, PackageManager.PackageInfoFlags.of(4429189632L), this.mUserId);     // Catch: PackageManager.NameNotFoundException -> L30
    L30:
        e = move-exception;
        OLog.e(TAG, "Exception when retrieving package:" + this.mAppEntry.info.packageName, e);
        goto L34
    L18:
        if (r1.hasExtra("android.intent.extra.user_handle") == false) goto L25;
        int r4 = ((UserHandle) r1.getParcelableExtra("android.intent.extra.user_handle")).getIdentifier();
        this.mUserId = r4;
        if (r4 == UserHandle.myUserId()) goto L26;
        if (hasInteractAcrossUsersPermission() == true) goto L26;
        OLog.w(TAG, "Intent not valid.");
        finish();
        return "";
    L9:
        r1 = (Intent) r0.getParcelable("intent");
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    protected boolean hasInteractAcrossUsersPermission() {
        FragmentActivity r2 = getActivity();
    L20:
        return false;
    L5:
        if (ActivityEmbeddingUtils.isEmbeddingActivityEnabled(r2) == false) goto L15;
        String r1 = PasswordUtils.getCallingAppPackageName(r2.getActivityToken());     // Catch: RemoteException -> L20
        if (TextUtils.isEmpty(r1) == false) goto L11;
        OLog.w(TAG, "Not able to get calling package name for permission check");     // Catch: RemoteException -> L20
        return false;
    L11:
        if (this.mPm.checkPermission("android.permission.INTERACT_ACROSS_USERS_FULL", r1) == 0) goto L14;
        OLog.w(TAG, "Package " + r1 + " does not have required permission android.permission.INTERACT_ACROSS_USERS_FULL");     // Catch: RemoteException -> L20
        return false;
    L14:
        return true;
    L15:
        int r8 = ActivityManager.getService().getLaunchedFromUid(r2.getActivityToken());     // Catch: RemoteException -> L20
        if (ActivityManager.checkUidPermission("android.permission.INTERACT_ACROSS_USERS_FULL", r8) == 0) goto L19;
        OLog.w(TAG, "Uid " + r8 + " does not have required permission android.permission.INTERACT_ACROSS_USERS_FULL");     // Catch: RemoteException -> L20
        return false;
    L19:
        return true;
    }

    protected void setIntentAndFinish(boolean r2, boolean r3) {
        Intent r4 = new Intent();
        r4.putExtra("chg", r3);
        ((SettingsActivity) getActivity()).finishPreferencePanel(this, -1, r4);
        this.mFinishing = true;
    }

    protected void showDialogInner(int r3, int r4) {
        MyAlertDialogFragment r5 = MyAlertDialogFragment.newInstance(r3, r4);
        r5.setTargetFragment(this, 0);
        r5.show(getFragmentManager(), "dialog " + r3);
    }

    @Override // com.android.settingslib.applications.ApplicationsState.Callbacks
    public void onPackageListChanged() {
        refreshUi();
    }

    public static void startAppInfoFragment(Class<?> r6, int r7, String r8, int r9, Fragment r10, int r11) {
        startAppInfoFragment(r6, r7, r8, r9, r10.getActivity(), r11);
    }

    @Deprecated
    public static void startAppInfoFragment(Class<?> r7, int r8, String r9, int r10, Activity r11, int r12) {
        Bundle r2 = new Bundle();
        r2.putString("package", r9);
        r2.putInt("uid", r10);
        r11.startActivityForResultAsUser(Utils.onBuildStartFragmentIntent(r11, r7.getName(), r2, null, r8, null, false), r12, new UserHandle(UserHandle.getUserId(r10)));
    }

    public static void startAppInfoActivity(Class<?> r2, String r3, int r4, Activity r5, int r6) {
        Bundle r0 = new Bundle();
        r0.putString("package", r3);
        r0.putInt("uid", r4);
        Intent r7 = new Intent(r5, r2);
        r7.putExtras(r0);
        r5.startActivityForResultAsUser(r7, r6, new UserHandle(UserHandle.getUserId(r4)));
    }
}
