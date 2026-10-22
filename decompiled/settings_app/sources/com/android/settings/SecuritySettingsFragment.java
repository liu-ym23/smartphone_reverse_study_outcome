package com.android.settings;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.UserHandle;
import android.security.keystore2.AndroidKeyStoreLoadStoreParameter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.accounts.ManagedProfileQuietModeEnabler;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.XTSUtils;
import com.android.settings.base.BaseActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.security.CredentialStorage;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.DevicePolicyUtils;
import com.android.settings.utils.UIUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.core.lifecycle.Lifecycle;
import com.android.settingslib.utils.StringUtil;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.security.KeyStore;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SecuritySettingsFragment extends BaseFragment implements View.OnClickListener, LifecycleOwner {
    private static final int MY_USER_ID = 0;
    private static final Intent TRUST_AGENT_INTENT = null;
    private CryptKeeperHelper mCryptKeeperHelper;
    private boolean mIsEncrypted;
    private Lifecycle mLifecycle;
    private LockPatternUtils mLockPatternUtils;
    private OCardListItem mViewCertificate;
    private OCardListItem mViewClear;
    private OCardListItem mViewCryptKeeper;
    private OCardListItem mViewDeviceManager;
    private OCardListItem mViewInstall;
    private OCardListItem mViewSource;
    private OCardListItem mViewTrustAgent;
    private ManagedProfileQuietModeEnabler managedProfileQuietModeEnabler;

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_SecuritySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_SecuritySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SecuritySettingsFragment() {
        this.mLifecycle = new Lifecycle(this);
        this.managedProfileQuietModeEnabler = null;
    }

    static {
        MY_USER_ID = UserHandle.myUserId();
        TRUST_AGENT_INTENT = new Intent("android.service.trust.TrustAgentService");
    }

    public void com_android_settings_SecuritySettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_CREATE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r1) {
        super.onAttach(r1);
        this.mLifecycle.onAttach(r1);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    public void com_android_settings_SecuritySettingsFragment__onResume$___twin___() {
        super.onResume();
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_RESUME);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.managedProfileQuietModeEnabler = new ManagedProfileQuietModeEnabler(getContext(), null);
        int r0 = 0;
        this.mRootView = r3.inflate(R.layout.certificate_settings_layout, r4, false);
        this.mTitleResId = Integer.valueOf(R.string.security_advanced_options);
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.item_id_device_manager);
        this.mViewDeviceManager = r6;
        r6.setOnContentClickListener(this);
        OCardListItem r7 = (OCardListItem) findViewByIdNullable(R.id.item_id_trust_agent);
        this.mViewTrustAgent = r7;
        r7.setOnContentClickListener(this);
        OCardListItem r8 = (OCardListItem) findViewByIdNullable(R.id.item_id_certificate);
        this.mViewCertificate = r8;
        r8.setOnContentClickListener(this);
        this.mViewCryptKeeper = (OCardListItem) findViewByIdNullable(R.id.item_id_crypt_keeper_encrypt);
        findViewByIdNullable(R.id.item_id_crypt_keeper_encrypt_tips).setVisibility(8);
        findViewByIdNullable(R.id.item_id_encrypt_gap).setVisibility(8);
        this.mViewCryptKeeper.setVisibility(8);
        OCardListItem r9 = (OCardListItem) findViewByIdNullable(R.id.item_id_source);
        this.mViewSource = r9;
        r9.setOnContentClickListener(this);
        OCardListItem r10 = this.mViewSource;
        if (SettingsFeature.SUPPORT_UNKOWN_SOURCE_SETTINGS == false) goto L5;
        int r11 = 0;
    L6:
        r10.setVisibility(r11);
        View r12 = findViewByIdNullable(R.id.item_id_source_gap);
        if (SettingsFeature.SUPPORT_UNKOWN_SOURCE_SETTINGS == true) goto L10;
        r0 = 8;
    L10:
        r12.setVisibility(r0);
        OCardListItem r13 = (OCardListItem) findViewByIdNullable(R.id.item_id_install);
        this.mViewInstall = r13;
        r13.setOnContentClickListener(this);
        View r14 = this.mViewInstall.getCustomStartView();
        if (r14 == null) goto L15;
        TextView r15 = (TextView) r14.findViewById(R.id.settings_text);
        if (r15 == null) goto L15;
        r15.setTextColor(getActivity().getColor(R.color.oui_accent_7_fg));
        r15.setText(R.string.certificate_install_from_storage);
    L15:
        OCardListItem r16 = (OCardListItem) findViewByIdNullable(R.id.item_id_clear);
        this.mViewClear = r16;
        r16.setOnContentClickListener(this);
        View r17 = this.mViewClear.getCustomStartView();
        if (r17 == null) goto L20;
        TextView r18 = (TextView) r17.findViewById(R.id.settings_text);
        if (r18 == null) goto L20;
        r18.setTextColor(getActivity().getColor(R.color.oui_functional_red_6));
        r18.setText(R.string.credentials_reset);
    L20:
        this.mCryptKeeperHelper = new CryptKeeperHelper(this._mActivity);
        this.mLockPatternUtils = new LockPatternUtils(getActivity());
        UIUtils.setUpFakeStatusBarOnApplyWindowInsets(this.mRootView.findViewById(R.id.fake_status_bar));
        return this.mRootView;
    L5:
        r11 = 8;
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        UIUtils.fitMaskTitle(this, (ScrollView) this.mRootView.findViewById(R.id.page_scrollview), UIUtils.INSTANCE.dp2px(104));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    public void updateViews() {
        KeyStore r4 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Exception -> L14
        r4.load(null);     // Catch: Exception -> L14
        if (getContext().getUser().isSystem() == false) goto L6;
        KeyStore r0 = KeyStore.getInstance("AndroidKeyStore");     // Catch: Exception -> L14
        r0.load(new AndroidKeyStoreLoadStoreParameter(102));     // Catch: Exception -> L14
    L7:
        if (r4 != null) goto L9;
    L10:
        if (r0 == null) goto L16;
        if (r0.aliases().hasMoreElements() == false) goto L16;
    L13:
        boolean r1 = true;
    L17:
        View r5 = this.mViewClear.getCustomStartView();
        if (r5 == null) goto L24;
        TextView r6 = (TextView) r5.findViewById(R.id.settings_text);
        if (r6 == null) goto L24;
        if (r1 == false) goto L23;
        r6.setTextColor(getActivity().getColor(R.color.oui_functional_red_6));
        this.mViewClear.setOnContentClickListener(this);
        goto L24
    L23:
        r6.setTextColor(getActivity().getColor(R.color.oui_functional_red_3));
        this.mViewClear.setOnContentClickListener(null);
    L24:
        updateTrustAgentView();
        boolean r2 = this.mCryptKeeperHelper.isDeviceEncrypted();
        this.mIsEncrypted = r2;
        if (r2 == false) goto L27;
        OCardListItemUtils.setTrailingText(this.mViewCryptKeeper, getResources().getString(R.string.crypt_keeper_encrypted));
    L29:
        if (DevicePolicyUtils.hasUserRestriction(getActivity(), "no_config_credentials") == false) goto L34;
        OCardListItemUtils.setContentContainerEnabled(this.mViewInstall, false);
        this.mViewInstall.getContentContainer().setClickable(true);
        OCardListItemUtils.setContentContainerEnabled(this.mViewClear, false);
        this.mViewClear.getContentContainer().setClickable(true);
        return;
    L34:
        return;
    L27:
        OCardListItemUtils.setTrailingText(this.mViewCryptKeeper, getResources().getString(R.string.crypt_keeper_unencrypted));
    L16:
        r1 = false;
        goto L17
    L9:
        if (r4.aliases().hasMoreElements() == true) goto L13;
    L6:
        r0 = null;
    L14:
        e = move-exception;
        OLog.e(this.TAG, "KeyStore read failed:" + e);
        goto L16
    }

    private void updateTrustAgentView() {
        if (this.mViewTrustAgent != null) goto L5;
        return;
    L5:
        boolean r0 = XTSUtils.isInXtsMode();
        OCardListItem r1 = this.mViewTrustAgent;
        if (r0 == false) goto L8;
        int r3 = 0;
    L9:
        r1.setVisibility(r3);
        if (r0 == true) goto L13;
        return;
    L13:
        if (this.mLockPatternUtils.isSecure(MY_USER_ID) == true) goto L16;
        OCardListItemUtils.setSubTitleString(this.mViewTrustAgent, getString(R.string.disabled_because_no_backup_security));
        OCardListItemUtils.setContentContainerEnabled(this.mViewTrustAgent, false);
        this.mViewTrustAgent.setOnContentClickListener(null);
        return;
    L16:
        OCardListItemUtils.setContentContainerEnabled(this.mViewTrustAgent, true);
        this.mViewTrustAgent.setOnContentClickListener(this);
        int r2 = getActiveTrustAgentCount();
        OCardListItem r4 = this.mViewTrustAgent;
        if (r2 <= 0) goto L19;
        String r5 = StringUtil.getIcuPluralsString(this.mContext, r2, R.string.manage_trust_agents_summary_on);
    L20:
        OCardListItemUtils.setSubTitleString(r4, r5);
        return;
    L19:
        r5 = getString(R.string.manage_trust_agents_summary);
        goto L20
    L8:
        r3 = 8;
        goto L9
    }

    private int getActiveTrustAgentCount() {
        PackageManager r0 = this.mContext.getPackageManager();
        LockPatternUtils r1 = this.mLockPatternUtils;
        int r2 = MY_USER_ID;
        List r3 = r1.getEnabledTrustAgents(r2);
        int r4 = 0;
        if (r3 != null) goto L5;
    L27:
        return r4;
    L5:
        if (r3.isEmpty() == true) goto L27;
        List<ResolveInfo> r5 = r0.queryIntentServices(TRUST_AGENT_INTENT, 128);
        if (r5 == null) goto L27;
        if (r5.isEmpty() == true) goto L27;
        DevicePolicyManager r6 = (DevicePolicyManager) this.mContext.getSystemService(DevicePolicyManager.class);
        RestrictedLockUtils.EnforcedAdmin r7 = MultiSDKAdapterNew.checkIfKeyguardFeaturesDisabled(this.mContext, 16, r2);
        Iterator<ResolveInfo> r8 = r5.iterator();
    L14:
        if (r8.hasNext() == false) goto L27;
        ResolveInfo r9 = r8.next();
        if (r9.serviceInfo == null) goto L14;
        if (TrustAgentUtils.checkProvidePermission(r9, r0) == false) goto L14;
        ComponentName r10 = TrustAgentUtils.getComponentName(r9);
        if (r3.contains(r10) == false) goto L14;
        if (TrustAgentUtils.isDisabledByAdmin(r6, r7, r10) == true) goto L14;
        r4 = r4 + 1;
        goto L14
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r12) {
        Intent r0 = new Intent();
        if (this.mTitleResId == null) goto L5;
        r0.putExtra("back_text_id", this.mTitleResId);
    L5:
        r0.putExtra("password_confirmed", true);
        if (this.mFromSecurityCenter == false) goto L44;
        r0.putExtra(BaseActivity.EXTRA_FROM_SECURITY, this.mFromSecurityCenter);
    L44:
    L41:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        if (OCardListItemUtils.getContentView(this.mViewDeviceManager) != r12) goto L12;
        start(DeviceManagerFragment.class);     // Catch: ActivityNotFoundException -> L41
        return;
    L12:
        if (OCardListItemUtils.getContentView(this.mViewTrustAgent) != r12) goto L15;
        Fragment r11 = (Fragment) null;     // Catch: ActivityNotFoundException -> L41
        Utils.startWithFragment(getActivity(), TrustAgentSettings.class.getName(), null, null, 0, R.string.manage_trust_agents, null);     // Catch: ActivityNotFoundException -> L41
        return;
    L15:
        if (OCardListItemUtils.getContentView(this.mViewCertificate) != r12) goto L19;
        start(TrustedCredentialsSettings.class);     // Catch: ActivityNotFoundException -> L41
        return;
    L19:
        if (OCardListItemUtils.getContentView(this.mViewInstall) != r12) goto L25;
        if (DevicePolicyUtils.trySendShowAdminSupportDetailsIntent(this._mActivity, "no_config_credentials") == false) goto L23;
        return;
    L23:
        r0.setAction("android.credentials.INSTALL");     // Catch: ActivityNotFoundException -> L41
        r0.setComponent(new ComponentName("com.android.certinstaller", "com.android.certinstaller.CertInstallerMain"));     // Catch: ActivityNotFoundException -> L41
        r0.putExtra("from", getPackageName());     // Catch: ActivityNotFoundException -> L41
        r0.putExtra(AdaptConstants.EXTRA_CERTIFICATE_USAGE, AdaptConstants.CERTIFICATE_USAGE_CA);     // Catch: ActivityNotFoundException -> L41
        Utils.startActivity(this._mActivity, r0);     // Catch: ActivityNotFoundException -> L41
        return;
    L25:
        if (OCardListItemUtils.getContentView(this.mViewClear) != r12) goto L32;
        if (DevicePolicyUtils.trySendShowAdminSupportDetailsIntent(this._mActivity, "no_config_credentials") == false) goto L29;
        return;
    L29:
        r0.setAction(CredentialStorage.ACTION_RESET);     // Catch: ActivityNotFoundException -> L41
        r0.setClass(this._mActivity, CredentialStorage.class);     // Catch: ActivityNotFoundException -> L41
        r0.removeExtra(BaseActivity.EXTRA_FROM_SECURITY);     // Catch: ActivityNotFoundException -> L41
        Utils.startActivity(this._mActivity, r0, 1);     // Catch: ActivityNotFoundException -> L41
        return;
    L32:
        if (OCardListItemUtils.getContentView(this.mViewCryptKeeper) != r12) goto L38;
        r0.putExtra("title_id", R.string.crypt_keeper_encrypt_title);     // Catch: ActivityNotFoundException -> L41
        if (this.mIsEncrypted == true) goto L36;
        start(CryptKeeperSettings.class);     // Catch: ActivityNotFoundException -> L41
        return;
    L36:
        Bundle r13 = new Bundle();     // Catch: ActivityNotFoundException -> L41
        r13.putBoolean("master_clear_for_crypt_keeper", true);     // Catch: ActivityNotFoundException -> L41
        start(new MasterClear(), r13);     // Catch: ActivityNotFoundException -> L41
        return;
    L38:
        if (OCardListItemUtils.getContentView(this.mViewSource) != r12) goto L51;
        start(PackageInstallerSettingsFragment.class);     // Catch: ActivityNotFoundException -> L41
        return;
    }

    private boolean isInWorkProfile() {
        ManagedProfileQuietModeEnabler r0 = this.managedProfileQuietModeEnabler;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isQuietModeEnabled();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_START);
        this.managedProfileQuietModeEnabler.onStart(this);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_PAUSE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_DESTROY);
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.LifecycleOwner
    public androidx.lifecycle.Lifecycle getLifecycle() {
        return this.mLifecycle;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_SecuritySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SecuritySettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SecuritySettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SecuritySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SecuritySettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_SecuritySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SecuritySettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SecuritySettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SecuritySettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
