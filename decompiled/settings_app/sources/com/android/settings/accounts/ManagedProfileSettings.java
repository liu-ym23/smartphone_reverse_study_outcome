package com.android.settings.accounts;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.GlobalProxyLancet;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.Utils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ManagedProfileSettings extends BaseFragment {
    private static final String TAG = "ManagedProfileSettings";
    private OCardListItem mContactItem;
    private OSwitch mContactSwitch;
    private Context mContext;
    private ManagedProfileBroadcastReceiver mManagedProfileBroadcastReceiver;
    private UserHandle mManagedUser;
    private UserManager mUserManager;
    private OCardListItem mWorkModeItem;
    private OSwitch mWorkModeSwitch;

    /* JADX INFO: renamed from: com.android.settings.accounts.ManagedProfileSettings$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class ManagedProfileBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ ManagedProfileSettings this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_accounts_ManagedProfileSettings$ManagedProfileBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private ManagedProfileBroadcastReceiver(ManagedProfileSettings r1) {
            this.this$0 = r1;
        }

        /* synthetic */ ManagedProfileBroadcastReceiver(ManagedProfileSettings r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void com_android_settings_accounts_ManagedProfileSettings$ManagedProfileBroadcastReceiver__onReceive$___twin___(Context r5, Intent r6) {
            String r7 = r6.getAction();
            OLog.v(ManagedProfileSettings.TAG, "Received broadcast: " + r7);
            if (r7.equals("android.intent.action.MANAGED_PROFILE_REMOVED") == false) goto L9;
            if (r6.getIntExtra("android.intent.extra.user_handle", -10000) != ManagedProfileSettings.access$100(this.this$0).getIdentifier()) goto L21;
            this.this$0.getActivity().finish();
            return;
        L21:
            return;
        L9:
            if (r7.equals("android.intent.action.MANAGED_PROFILE_AVAILABLE") == true) goto L16;
            if (r7.equals("android.intent.action.MANAGED_PROFILE_UNAVAILABLE") == true) goto L16;
            OLog.w(ManagedProfileSettings.TAG, "Cannot handle received broadcast: " + r6.getAction());
            return;
        L16:
            if (r6.getIntExtra("android.intent.extra.user_handle", -10000) == ManagedProfileSettings.access$100(this.this$0).getIdentifier()) goto L18;
            return;
        L18:
            if (ManagedProfileSettings.access$200(this.this$0) == null) goto L23;
            ManagedProfileSettings.access$200(this.this$0).setChecked(!ManagedProfileSettings.access$300(this.this$0).isQuietModeEnabled(ManagedProfileSettings.access$100(this.this$0)));
            return;
        }

        public void register(Context r3) {
            IntentFilter r0 = new IntentFilter();
            r0.addAction("android.intent.action.MANAGED_PROFILE_REMOVED");
            r0.addAction("android.intent.action.MANAGED_PROFILE_AVAILABLE");
            r0.addAction("android.intent.action.MANAGED_PROFILE_UNAVAILABLE");
            GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3, this, r0, 2);
        }

        public void unregister(Context r1) {
            r1.unregisterReceiver(this);
        }

        @Insert("onReceive")
        public static void com_android_settings_accounts_ManagedProfileSettings$ManagedProfileBroadcastReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(ManagedProfileBroadcastReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            ManagedProfileBroadcastReceiver r1 = r7;
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
            r7.com_android_settings_accounts_ManagedProfileSettings$ManagedProfileBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_accounts_ManagedProfileSettings$ManagedProfileBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_accounts_ManagedProfileSettings$ManagedProfileBroadcastReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_accounts_ManagedProfileSettings$ManagedProfileBroadcastReceiver__onReceive$___twin___(r8, r9);
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

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accounts_ManagedProfileSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accounts_ManagedProfileSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ManagedProfileSettings() {
    }

    static /* synthetic */ UserHandle access$100(ManagedProfileSettings r0) {
        return r0.mManagedUser;
    }

    static /* synthetic */ OSwitch access$200(ManagedProfileSettings r0) {
        return r0.mWorkModeSwitch;
    }

    static /* synthetic */ UserManager access$300(ManagedProfileSettings r0) {
        return r0.mUserManager;
    }

    public void com_android_settings_accounts_ManagedProfileSettings__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        this.mContext = getActivity().getApplicationContext();
        this.mUserManager = (UserManager) getSystemService(PickApplicationActivity.EXTRA_USER);
        UserHandle r3 = getManagedUserFromArgument();
        this.mManagedUser = r3;
        if (r3 != null) goto L5;
        getActivity().finish();
    L5:
        ManagedProfileBroadcastReceiver r4 = new ManagedProfileBroadcastReceiver(this, null);
        this.mManagedProfileBroadcastReceiver = r4;
        r4.register(getActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.managed_profile_settings_oui, r3, false);
        this.mWorkModeItem = (OCardListItem) this.mRootView.findViewById(R.id.work_mode);
        this.mContactItem = (OCardListItem) this.mRootView.findViewById(R.id.contacts_search);
        if ((this.mWorkModeItem.getCustomEndView() instanceof OSwitch) == false) goto L6;
        OSwitch r5 = (OSwitch) this.mWorkModeItem.getCustomEndView();
        this.mWorkModeSwitch = r5;
        r5.setOnClickListener(new ManagedProfileSettings$$ExternalSyntheticLambda1(this));
    L6:
        if ((this.mContactItem.getCustomEndView() instanceof OSwitch) == false) goto L9;
        OSwitch r6 = (OSwitch) this.mContactItem.getCustomEndView();
        this.mContactSwitch = r6;
        r6.setOnCheckedChangeListener(new ManagedProfileSettings$$ExternalSyntheticLambda2(this));
    L9:
        return this.mRootView;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-accounts-ManagedProfileSettings, reason: not valid java name */
    /* synthetic */ void m274x4b9a35af(View r3) {
        OSwitch r4 = this.mWorkModeSwitch;
        r4.setChecked(!r4.isChecked());
        MultiSDKAdapter.setUserQuietModeEnabled(this.mUserManager, this.mManagedUser, null, this.mWorkModeSwitch.isChecked());
    }

    /* JADX INFO: renamed from: lambda$onCreateView$1$com-android-settings-accounts-ManagedProfileSettings, reason: not valid java name */
    /* synthetic */ void m275x65b5b44e(CompoundButton r2, boolean r3) {
        ContentResolver r4 = getContentResolver();
        int r1 = this.mManagedUser.getIdentifier();
        Settings.Secure.putIntForUser(r4, "managed_profile_contact_remote_search", r3 ? 1 : 0, r1);
    }

    public void com_android_settings_accounts_ManagedProfileSettings__onResume$___twin___() {
        super.onResume();
        loadDataAndPopulateUi();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mManagedProfileBroadcastReceiver.unregister(getActivity());
    }

    private UserHandle getManagedUserFromArgument() {
        Bundle r0 = getArguments();
        if (r0 == null) goto L10;
        UserHandle r1 = (UserHandle) r0.getParcelable("android.intent.extra.USER");
        if (r1 == null) goto L10;
        if (this.mUserManager.isManagedProfile(r1.getIdentifier()) == false) goto L10;
        return r1;
    L10:
        return Utils.getManagedProfile(this.mUserManager);
    }

    private void loadDataAndPopulateUi() {
        OSwitch r0 = this.mWorkModeSwitch;
        if (r0 == null) goto L6;
        r0.setChecked(!this.mUserManager.isQuietModeEnabled(this.mManagedUser));
    L6:
        if (this.mContactSwitch == null) goto L16;
        int r1 = Settings.Secure.getIntForUser(getContentResolver(), "managed_profile_contact_remote_search", 0, this.mManagedUser.getIdentifier());
        OSwitch r2 = this.mContactSwitch;
        if (r1 == 0) goto L10;
        boolean r3 = true;
    L11:
        r2.setChecked(r3);
        final RestrictedLockUtils.EnforcedAdmin r4 = MultiSDKAdapterNew.checkIfRemoteContactSearchDisallowed(this.mContext, this.mManagedUser.getIdentifier());
        if (r4 == null) goto L14;
        this.mContactItem.setEnabled(false);
        this.mContactSwitch.setEnabled(false);
        this.mContactItem.setOnContentClickListener(new ManagedProfileSettings$$ExternalSyntheticLambda0(this, r4));
        return;
    L14:
        this.mContactItem.setEnabled(true);
        this.mContactSwitch.setEnabled(true);
        this.mContactItem.setOnContentClickListener(null);
        return;
    L10:
        r3 = false;
        goto L11
    }

    /* JADX INFO: renamed from: lambda$loadDataAndPopulateUi$2$com-android-settings-accounts-ManagedProfileSettings, reason: not valid java name */
    /* synthetic */ void m273xb6399fe2(RestrictedLockUtils.EnforcedAdmin r1, View r2) {
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(getActivity(), r1);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accounts_ManagedProfileSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ManagedProfileSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accounts_ManagedProfileSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accounts_ManagedProfileSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ManagedProfileSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accounts_ManagedProfileSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accounts_ManagedProfileSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ManagedProfileSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accounts_ManagedProfileSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
