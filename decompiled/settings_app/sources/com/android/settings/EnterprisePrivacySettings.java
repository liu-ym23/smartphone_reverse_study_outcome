package com.android.settings;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.VpnManager;
import android.os.Bundle;
import android.os.UserHandle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.android.settings.applications.ApplicationFeatureProvider;
import com.android.settings.applications.EnterpriseDefaultApps;
import com.android.settings.base.BaseFragment;
import com.android.settings.enterprise.ApplicationListFragment;
import com.android.settings.enterprise.EnterprisePrivacyFeatureProvider;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.users.UserFeatureProvider;
import com.android.settings.vpn2.VpnUtils;
import com.android.settingslib.utils.StringUtil;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class EnterprisePrivacySettings extends BaseFragment {
    private ArrayList<OCardListItem> canChangesItems;
    private ArrayList<OCardListItem> canSeeMessageItems;
    private ArrayList<OCardListItem> deviceItems;
    private ApplicationFeatureProvider mApplicationFeatureProvider;
    private ConnectivityManager mConnectivityManager;
    private EnterprisePrivacyFeatureProvider mFeatureProvider;
    private LinearLayout mPageContainer;
    private UserFeatureProvider mUserFeatureProvider;
    private VpnManager mVpnManager;

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_EnterprisePrivacySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_EnterprisePrivacySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public EnterprisePrivacySettings() {
        this.canSeeMessageItems = new ArrayList();
        this.canChangesItems = new ArrayList();
        this.deviceItems = new ArrayList();
    }

    public void com_android_settings_EnterprisePrivacySettings__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        com.android.settings.overlay.FeatureFactory r3 = com.android.settings.overlay.FeatureFactory.getFeatureFactory();
        this.mFeatureProvider = r3.getEnterprisePrivacyFeatureProvider();
        this.mApplicationFeatureProvider = r3.getApplicationFeatureProvider();
        this.mUserFeatureProvider = r3.getUserFeatureProvider();
        this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);
        this.mVpnManager = (VpnManager) this.mContext.getSystemService(VpnManager.class);
        this.mTitleResId = Integer.valueOf(R.string.enterprise_privacy_settings);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        this.mRootView = r4.inflate(R.layout.enterprise_privacy_settings_layout, r5, false);
        this.canSeeMessageItems.add((OCardListItem) findViewById(R.id.item_exposure_category));
        this.canSeeMessageItems.add((OCardListItem) findViewById(R.id.item_apps));
        this.canSeeMessageItems.add((OCardListItem) findViewById(R.id.item_usage_stats));
        this.canSeeMessageItems.add((OCardListItem) findViewById(R.id.item_network_logs));
        this.canSeeMessageItems.add((OCardListItem) findViewById(R.id.item_bug_reports));
        this.canSeeMessageItems.add((OCardListItem) findViewById(R.id.item_security_logs));
        this.canChangesItems.add((OCardListItem) findViewById(R.id.item_installed_packages));
        this.canChangesItems.add((OCardListItem) findViewById(R.id.item_location_access));
        this.canChangesItems.add((OCardListItem) findViewById(R.id.item_microphone_access));
        this.canChangesItems.add((OCardListItem) findViewById(R.id.item_camera_access));
        this.canChangesItems.add((OCardListItem) findViewById(R.id.item_set_default_apps));
        this.canChangesItems.add((OCardListItem) findViewById(R.id.item_vpn_always_on_personal));
        this.canChangesItems.add((OCardListItem) findViewById(R.id.item_vpn_always_on_work));
        this.canChangesItems.add((OCardListItem) findViewById(R.id.item_input_method));
        this.canChangesItems.add((OCardListItem) findViewById(R.id.item_global_http_proxy));
        this.canChangesItems.add((OCardListItem) findViewById(R.id.item_ca_certs_personal));
        this.canChangesItems.add((OCardListItem) findViewById(R.id.item_ca_certs_work));
        this.deviceItems.add((OCardListItem) findViewById(R.id.item_lock_device));
        this.deviceItems.add((OCardListItem) findViewById(R.id.item_wipe_device));
        this.deviceItems.add((OCardListItem) findViewById(R.id.item_failed_password_wipe_device));
        this.deviceItems.add((OCardListItem) findViewById(R.id.item_failed_password_wipe_work));
        this.mPageContainer = (LinearLayout) this.mRootView.findViewById(R.id.page_container);
        setupClickListener(R.id.item_installed_packages, ApplicationListFragment.EnterpriseInstalledPackages.class);
        setupClickListener(R.id.item_location_access, ApplicationListFragment.AdminGrantedPermissionLocation.class);
        setupClickListener(R.id.item_microphone_access, ApplicationListFragment.AdminGrantedPermissionMicrophone.class);
        setupClickListener(R.id.item_camera_access, ApplicationListFragment.AdminGrantedPermissionCamera.class);
        return this.mRootView;
    }

    private void setupClickListener(int r2, final Class<? extends BaseFragment> r3) {
        ((OCardListItem) findViewById(r2)).setOnContentClickListener(new EnterprisePrivacySettings$$ExternalSyntheticLambda4(this, r3));
    }

    /* JADX INFO: renamed from: lambda$setupClickListener$0$com-android-settings-EnterprisePrivacySettings, reason: not valid java name */
    /* synthetic */ void m138x58873c86(Class r1, View r2) {
        start(r1);
    }

    public void com_android_settings_EnterprisePrivacySettings__onResume$___twin___() {
        super.onResume();
        refreshUi();
    }

    private void refreshUi() {
        addExposureCategory();
        addChangesCategory();
        addDeviceAccessCategory();
    }

    private OCardListItem createCardItem(int r3, String r4) {
        OCardListItem r0 = new OCardListItem(this._mActivity);
        r0.setTitle(getString(r3));
        if (r4 != null) goto L5;
    L7:
        return r0;
    L5:
        if (r4.isEmpty() == true) goto L7;
        r0.setSubTitle(r4);
        r0.showSubTitle(true);
        goto L7
    }

    private void refreshCanSeeMessageItems() {
        if (this.canSeeMessageItems.size() != 0) goto L6;
        findViewById(R.id.see_messages_section_title).setVisibility(8);
        return;
    L6:
        refreshItems(this.canSeeMessageItems);
    }

    private void refreshItems(ArrayList<OCardListItem> r5) {
        int r4 = r5.size();
        int r0 = 0;
        if (r4 != 1) goto L6;
        r5.get(0).setCardPosition(0);
        return;
    L6:
        if (r0 >= r4) goto L14;
        if (r0 != 0) goto L10;
        r5.get(r0).setCardPosition(1);
    L13:
        r0 = r0 + 1;
        goto L6
    L10:
        if (r0 >= (r4 - 1)) goto L12;
        r5.get(r0).setCardPosition(2);
        goto L13
    L12:
        r5.get(r0).setCardPosition(3);
        goto L13
    }

    private void refreshCanChangesItems() {
        if (this.canChangesItems.size() != 0) goto L6;
        findViewById(R.id.exposure_changes_section_title).setVisibility(8);
        return;
    L6:
        refreshItems(this.canChangesItems);
    }

    private void refreshDeviceItems() {
        if (this.deviceItems.size() != 0) goto L6;
        findViewById(R.id.device_access_section_title).setVisibility(8);
        return;
    L6:
        refreshItems(this.deviceItems);
    }

    private void addExposureCategory() {
        setSubTitle((OCardListItem) findViewById(R.id.item_bug_reports), this.mFeatureProvider.getLastBugReportRequestTime());
        OCardListItem r0 = (OCardListItem) findViewById(R.id.item_network_logs);
        boolean r2 = true;
        if (this.mFeatureProvider.isNetworkLoggingEnabled() == false) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        setSubTitle(r0, this.mFeatureProvider.getLastNetworkLogRetrievalTime());
        r0.setVisibility(0);
    L13:
        OCardListItem r3 = (OCardListItem) findViewById(R.id.item_security_logs);
        if (this.mFeatureProvider.isSecurityLoggingEnabled() == false) goto L16;
    L19:
        if (r2 == false) goto L21;
        setSubTitle(r3, this.mFeatureProvider.getLastSecurityLogRetrievalTime());
        r3.setVisibility(0);
    L22:
        refreshCanSeeMessageItems();
        return;
    L21:
        this.canSeeMessageItems.remove(r3);
        r3.setVisibility(8);
        goto L22
    L16:
        if (this.mFeatureProvider.getLastSecurityLogRetrievalTime() != null) goto L19;
        r2 = false;
        goto L19
    L12:
        r0.setVisibility(8);
        this.canSeeMessageItems.remove(r0);
        goto L13
    L5:
        if (this.mFeatureProvider.getLastNetworkLogRetrievalTime() != null) goto L8;
        r1 = false;
        goto L10
    }

    private void setSubTitle(OCardListItem r3, Date r4) {
        if (r4 != null) goto L4;
        String r2 = getString(R.string.enterprise_privacy_none);
    L5:
        r3.setSubTitle(r2);
        r3.showSubTitle(true);
        return;
    L4:
        r2 = DateUtils.formatDateTime(this.mContext, r4.getTime(), 17);
        goto L5
    }

    private OCardListItem createSimpleCardItem(int r3) {
        OCardListItem r0 = new OCardListItem(this._mActivity);
        r0.setTitle(getString(r3));
        r0.showSubTitle(false);
        return r0;
    }

    private void addChangesCategory() {
        final OCardListItem r0 = (OCardListItem) findViewById(R.id.item_installed_packages);
        this.mApplicationFeatureProvider.calculateNumberOfPolicyInstalledApps(true, new EnterprisePrivacySettings$$ExternalSyntheticLambda0(this, r0));
        final OCardListItem r1 = (OCardListItem) findViewById(R.id.item_location_access);
        this.mApplicationFeatureProvider.calculateNumberOfAppsWithAdminGrantedPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}, true, new EnterprisePrivacySettings$$ExternalSyntheticLambda1(this, r1));
        final OCardListItem r2 = (OCardListItem) findViewById(R.id.item_microphone_access);
        this.mApplicationFeatureProvider.calculateNumberOfAppsWithAdminGrantedPermissions(new String[]{"android.permission.RECORD_AUDIO"}, true, new EnterprisePrivacySettings$$ExternalSyntheticLambda2(this, r2));
        final OCardListItem r3 = (OCardListItem) findViewById(R.id.item_camera_access);
        this.mApplicationFeatureProvider.calculateNumberOfAppsWithAdminGrantedPermissions(new String[]{"android.permission.CAMERA"}, true, new EnterprisePrivacySettings$$ExternalSyntheticLambda3(this, r3));
        OCardListItem r4 = (OCardListItem) findViewById(R.id.item_set_default_apps);
        int r5 = getNumberOfEnterpriseSetDefaultApps();
        if (r5 <= 0) goto L5;
        r4.setSubTitle(StringUtil.getIcuPluralsString(this.mContext, r5, R.string.enterprise_privacy_number_packages));
        r4.showSubTitle(true);
    L5:
        int r6 = 8;
        if (r5 <= 0) goto L8;
        int r7 = 0;
    L9:
        r4.setVisibility(r7);
        if (r5 > 0) goto L12;
        this.canChangesItems.remove(r4);
    L12:
        boolean r8 = VpnUtils.isAlwaysOnVpnSet(this.mVpnManager, UserHandle.myUserId());
        OCardListItem r9 = (OCardListItem) findViewById(R.id.item_vpn_always_on_personal);
        if (r8 == false) goto L15;
        int r10 = 0;
    L16:
        r9.setVisibility(r10);
        if (r8 == true) goto L19;
        this.canChangesItems.remove(r9);
    L19:
        boolean r11 = this.mFeatureProvider.isAlwaysOnVpnSetInManagedProfile();
        OCardListItem r12 = (OCardListItem) findViewById(R.id.item_vpn_always_on_work);
        if (r11 == false) goto L22;
        int r13 = 0;
    L23:
        r12.setVisibility(r13);
        if (r11 == true) goto L26;
        this.canChangesItems.remove(r12);
    L26:
        OCardListItem r14 = (OCardListItem) findViewById(R.id.item_input_method);
        String r15 = this.mFeatureProvider.getImeLabelIfOwnerSet();
        if (r15 == null) goto L29;
        r14.setSubTitle(getString(R.string.enterprise_privacy_input_method_name, new Object[]{r15}));
        r14.showSubTitle(true);
    L29:
        if (r15 == null) goto L31;
        int r16 = 0;
    L32:
        r14.setVisibility(r16);
        if (r15 != null) goto L35;
        this.canChangesItems.remove(r14);
    L35:
        OCardListItem r17 = (OCardListItem) findViewById(R.id.item_global_http_proxy);
        if (this.mConnectivityManager.getGlobalProxy() == null) goto L38;
        int r18 = 0;
    L39:
        r17.setVisibility(r18);
        if (this.mConnectivityManager.getGlobalProxy() != null) goto L42;
        this.canChangesItems.remove(r17);
    L42:
        OCardListItem r19 = (OCardListItem) findViewById(R.id.item_ca_certs_personal);
        int r20 = this.mFeatureProvider.getNumberOfOwnerInstalledCaCertsForCurrentUser();
        if (r20 <= 0) goto L45;
        r19.setSubTitle(StringUtil.getIcuPluralsString(this.mContext, r20, R.string.enterprise_privacy_number_ca_certs));
        r19.showSubTitle(true);
    L45:
        if (r20 <= 0) goto L47;
        int r21 = 0;
    L48:
        r19.setVisibility(r21);
        if (r20 > 0) goto L51;
        this.canChangesItems.remove(r19);
    L51:
        OCardListItem r22 = (OCardListItem) findViewById(R.id.item_ca_certs_work);
        int r23 = this.mFeatureProvider.getNumberOfOwnerInstalledCaCertsForManagedProfile();
        if (r23 <= 0) goto L54;
        r22.setSubTitle(StringUtil.getIcuPluralsString(this.mContext, r23, R.string.enterprise_privacy_number_ca_certs));
        r22.showSubTitle(true);
    L54:
        if (r23 <= 0) goto L56;
        r6 = 0;
    L56:
        r22.setVisibility(r6);
        if (r23 > 0) goto L59;
        this.canChangesItems.remove(r22);
    L59:
        refreshCanChangesItems();
        return;
    L47:
        r21 = 8;
        goto L48
    L38:
        r18 = 8;
        goto L39
    L31:
        r16 = 8;
        goto L32
    L22:
        r13 = 8;
        goto L23
    L15:
        r10 = 8;
        goto L16
    L8:
        r7 = 8;
        goto L9
    }

    /* JADX INFO: renamed from: lambda$addChangesCategory$1$com-android-settings-EnterprisePrivacySettings, reason: not valid java name */
    /* synthetic */ void m134x75fd5d64(OCardListItem r4, int r5) {
        int r0 = 0;
        if (r5 != 0) goto L5;
        boolean r6 = false;
    L6:
        if (r6 == true) goto L9;
        r0 = 8;
    L9:
        r4.setVisibility(r0);
        if (r6 == true) goto L13;
        this.canChangesItems.remove(r4);
        refreshCanChangesItems();
        return;
    L13:
        return;
    L5:
        r4.setSubTitle(StringUtil.getIcuPluralsString(this.mContext, r5, R.string.enterprise_privacy_number_packages_lower_bound));
        r6 = true;
        r4.showSubTitle(true);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$addChangesCategory$2$com-android-settings-EnterprisePrivacySettings, reason: not valid java name */
    /* synthetic */ void m135xafc7ff43(OCardListItem r4, int r5) {
        int r0 = 0;
        if (r5 != 0) goto L5;
        boolean r6 = false;
    L6:
        if (r6 == true) goto L9;
        r0 = 8;
    L9:
        r4.setVisibility(r0);
        if (r6 == true) goto L13;
        this.canChangesItems.remove(r4);
        refreshCanChangesItems();
        return;
    L13:
        return;
    L5:
        r4.setSubTitle(StringUtil.getIcuPluralsString(this.mContext, r5, R.string.enterprise_privacy_number_packages_lower_bound));
        r6 = true;
        r4.showSubTitle(true);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$addChangesCategory$3$com-android-settings-EnterprisePrivacySettings, reason: not valid java name */
    /* synthetic */ void m136xe992a122(OCardListItem r4, int r5) {
        int r0 = 0;
        if (r5 != 0) goto L5;
        boolean r6 = false;
    L6:
        if (r6 == true) goto L9;
        r0 = 8;
    L9:
        r4.setVisibility(r0);
        if (r6 == true) goto L13;
        this.canChangesItems.remove(r4);
        refreshCanChangesItems();
        return;
    L13:
        return;
    L5:
        r4.setSubTitle(StringUtil.getIcuPluralsString(this.mContext, r5, R.string.enterprise_privacy_number_packages_lower_bound));
        r6 = true;
        r4.showSubTitle(true);
        goto L6
    }

    /* JADX INFO: renamed from: lambda$addChangesCategory$4$com-android-settings-EnterprisePrivacySettings, reason: not valid java name */
    /* synthetic */ void m137x235d4301(OCardListItem r4, int r5) {
        int r0 = 0;
        if (r5 != 0) goto L5;
        boolean r6 = false;
    L6:
        if (r6 == true) goto L9;
        r0 = 8;
    L9:
        r4.setVisibility(r0);
        if (r6 == true) goto L13;
        this.canChangesItems.remove(r4);
        refreshCanChangesItems();
        return;
    L13:
        return;
    L5:
        r4.setSubTitle(StringUtil.getIcuPluralsString(this.mContext, r5, R.string.enterprise_privacy_number_packages_lower_bound));
        r6 = true;
        r4.showSubTitle(true);
        goto L6
    }

    private int getNumberOfEnterpriseSetDefaultApps() {
        Iterator<UserHandle> r0 = this.mUserFeatureProvider.getUserProfiles().iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L8;
        UserHandle r3 = r0.next();
        EnterpriseDefaultApps[] r4 = EnterpriseDefaultApps.values();
        int r5 = r4.length;
        int r6 = 0;
    L6:
        if (r6 >= r5) goto L4;
        r2 = r2 + this.mApplicationFeatureProvider.findPersistentPreferredActivities(r3.getIdentifier(), r4[r6].getIntents()).size();
        r6 = r6 + 1;
        goto L6
    L8:
        return r2;
    }

    private void addDeviceAccessCategory() {
        OCardListItem r0 = (OCardListItem) findViewById(R.id.item_failed_password_wipe_device);
        int r1 = this.mFeatureProvider.getMaximumFailedPasswordsBeforeWipeInCurrentUser();
        if (r1 <= 0) goto L5;
        r0.setSubTitle(StringUtil.getIcuPluralsString(this.mContext, r1, R.string.enterprise_privacy_number_failed_password_wipe));
        r0.showSubTitle(true);
    L5:
        int r4 = 0;
        if (r1 <= 0) goto L8;
        int r6 = 0;
    L9:
        r0.setVisibility(r6);
        if (r1 > 0) goto L12;
        this.deviceItems.remove(r0);
    L12:
        OCardListItem r2 = (OCardListItem) findViewById(R.id.item_failed_password_wipe_work);
        int r3 = this.mFeatureProvider.getMaximumFailedPasswordsBeforeWipeInManagedProfile();
        if (r3 <= 0) goto L15;
        r2.setSubTitle(StringUtil.getIcuPluralsString(this.mContext, r3, R.string.enterprise_privacy_number_failed_password_wipe));
        r2.showSubTitle(true);
    L15:
        if (r3 > 0) goto L18;
        r4 = 8;
    L18:
        r2.setVisibility(r4);
        if (r3 > 0) goto L21;
        this.deviceItems.remove(r2);
    L21:
        refreshDeviceItems();
        return;
    L8:
        r6 = 8;
        goto L9
    }

    public static boolean isPageEnabled(Context r0) {
        return com.android.settings.overlay.FeatureFactory.getFeatureFactory().getEnterprisePrivacyFeatureProvider().hasDeviceOwner();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_EnterprisePrivacySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(EnterprisePrivacySettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_EnterprisePrivacySettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_EnterprisePrivacySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(EnterprisePrivacySettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_EnterprisePrivacySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_EnterprisePrivacySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(EnterprisePrivacySettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_EnterprisePrivacySettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
