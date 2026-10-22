package com.android.settings.location;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.GlobalProxyLancet;
import com.android.settings.GoogleHelp;
import com.android.settings.PermissionControllerHelp;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settings.Utils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.inputmethod.LanguageOption;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.SLog;
import com.android.settings.utils.UIUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class LocationServiceSettingsFragment extends BaseFragment {
    private static final IntentFilter INTENT_FILTER_LOCATION_MODE_CHANGED = null;
    private static final String TAG = "LocationServiceSettings";
    private OCardListItem locationGeneral;
    private BroadcastReceiver locationModeReceiver;
    private OCardListItem locationServices;
    private OCardListItem locationSwitch;
    private LocationManager mLocationManager;
    private OCardListItem mProfileLocation;
    private UserManager userManager;

    public void com_android_settings_location_LocationServiceSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_location_LocationServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_location_LocationServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public LocationServiceSettingsFragment() {
    }

    static /* synthetic */ void access$000(LocationServiceSettingsFragment r0) {
        r0.startManageLocationPermissionsActivity();
    }

    static /* synthetic */ boolean access$100(LocationServiceSettingsFragment r0) {
        return r0.isRestricted();
    }

    static /* synthetic */ OCardListItem access$200(LocationServiceSettingsFragment r0) {
        return r0.locationSwitch;
    }

    static /* synthetic */ void access$300(LocationServiceSettingsFragment r0, boolean r1) {
        r0.setLocationEnabled(r1);
    }

    static /* synthetic */ void access$400(LocationServiceSettingsFragment r0) {
        r0.refreshLocationMode();
    }

    static {
        INTENT_FILTER_LOCATION_MODE_CHANGED = new IntentFilter("android.location.MODE_CHANGED");
    }

    @Override // com.android.settings.base.BaseFragment
    public int getTitleResId() {
        if (GoogleHelp.INSTANCE.isShowLocationServices() == true) goto L5;
        return R.string.location_settings_title;
    L5:
        if (LanguageOption.isEnglish() == false) goto L10;
        return R.string.gadget_location;
    L10:
        return R.string.location_settings_title;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.location_service_settings_layout, r3, false);
        ((ViewGroup) this.mRootView).setClipChildren(false);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        UIUtils.fitMaskTitleInCommon((ViewGroup) this.mRootView, findViewByIdNullable(R.id.list_item_location_switch));
        this.userManager = (UserManager) this.mContext.getSystemService(PickApplicationActivity.EXTRA_USER);
        this.mLocationManager = (LocationManager) this.mContext.getSystemService("location");
        initViews();
        initProfileViews();
        registerReceiver();
    }

    public void com_android_settings_location_LocationServiceSettingsFragment__onResume$___twin___() {
        super.onResume();
        refreshLocationMode();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver();
    }

    private void initViews() {
        this.locationSwitch = (OCardListItem) findViewByIdNullable(R.id.list_item_location_switch);
        this.locationGeneral = (OCardListItem) findViewByIdNullable(R.id.OListItemSettings_goto_location_app);
        this.mProfileLocation = (OCardListItem) findViewById(R.id.managed_profile_location_switch);
        this.locationGeneral.setOnContentClickListener(new AnonymousClass1(this));
        if (this.locationSwitch == null) goto L12;
        if (GoogleHelp.INSTANCE.isShowLocationServices() == true) goto L7;
    L9:
        OCardListItemUtils.setTitle(this.locationSwitch, getString(R.string.location_settings_title));
    L10:
        this.locationSwitch.setVisibility(0);
        OCardListItemUtils.setOnCheckedChangeListener(this.locationSwitch, new AnonymousClass2(this));
        goto L12
    L7:
        if (LanguageOption.isEnglish() == false) goto L9;
        OCardListItemUtils.setTitle(this.locationSwitch, getString(R.string.location_settings_primary_switch_title));
    L12:
        if (GoogleHelp.INSTANCE.isShowLocationServices() == false) goto L15;
        OCardListItem r0 = (OCardListItem) findViewById(R.id.item_location_service);
        this.locationServices = r0;
        r0.setVisibility(0);
        this.locationServices.setOnContentClickListener(new LocationServiceSettingsFragment$$ExternalSyntheticLambda0(this));
        return;
    }

    /* JADX INFO: renamed from: lambda$initViews$0$com-android-settings-location-LocationServiceSettingsFragment, reason: not valid java name */
    /* synthetic */ void m515xa2c49084(View r3) {
        startActivity(new Intent(this.mContext, Settings.LocationServicesActivity.class));
    }

    private void startManageLocationPermissionsActivity() {
        PermissionControllerHelp.INSTANCE.startManageLocationPermissionsActivity(getActivity());
    }

    private void initProfileViews() {
        final UserHandle r0 = Utils.getManagedProfile(this.userManager);
        if (r0 != null) goto L5;
        return;
    L5:
        OCardListItem r1 = this.mProfileLocation;
        if (r1 != null) goto L8;
        return;
    L8:
        if (this.locationGeneral == null) goto L16;
        r1.setVisibility(8);
        this.locationGeneral.setCardPosition(0);
        this.mProfileLocation.setVisibility(0);
        this.locationGeneral.setCardPosition(3);
        OSwitch r2 = this.mProfileLocation.getEndSwitch();
        OCardListItem r3 = this.mProfileLocation;
        if (r3 == null) goto L13;
        OCardListItemUtils.setChecked(r3, isProfileLocationEnable(r0));
    L13:
        r2.setOnCheckedChangeListener(new LocationServiceSettingsFragment$$ExternalSyntheticLambda1(this, r0));
        return;
    }

    /* JADX INFO: renamed from: lambda$initProfileViews$1$com-android-settings-location-LocationServiceSettingsFragment, reason: not valid java name */
    /* synthetic */ void m514xcd81cd6(UserHandle r3, CompoundButton r4, boolean r5) {
        RestrictedLockUtils.EnforcedAdmin r0 = getShareLocationEnforcedAdmin(r3.getIdentifier());
        if (r0 == null) goto L6;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this.mContext, r0);
        r4.setChecked(!r5);
        return;
    L6:
        this.userManager.setUserRestriction("no_share_location", !r5, r3);
        this.mLocationManager.setLocationEnabledForUser(r5, r3);
    }

    private boolean isProfileLocationEnable(UserHandle r3) {
        boolean r0 = this.mLocationManager.isLocationEnabledForUser(r3);
        boolean r2 = this.userManager.hasUserRestrictionForUser("no_share_location", r3);
        if (r0 == false) goto L6;
        if (r2 == true) goto L6;
        return true;
    L6:
        return false;
    }

    private void registerReceiver() {
        if (this.locationModeReceiver != null) goto L5;
        this.locationModeReceiver = new AnonymousClass3(this);
    L5:
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.locationModeReceiver, INTENT_FILTER_LOCATION_MODE_CHANGED);
    }

    private void unregisterReceiver() {
        if (this.locationModeReceiver == null) goto L6;
        this.mContext.unregisterReceiver(this.locationModeReceiver);
        return;
    }

    private void refreshLocationMode() {
        boolean r2 = false;
        int r0 = android.provider.Settings.Secure.getInt(this.mContext.getContentResolver(), "location_mode", 0);
        if (getShareLocationEnforcedAdmin(UserHandle.myUserId()) == null) goto L5;
        boolean r1 = true;
    L6:
        if (r0 == 0) goto L9;
        if (r1 == true) goto L9;
        r2 = true;
    L9:
        OCardListItem r3 = this.locationSwitch;
        if (r3 == null) goto L12;
        OCardListItemUtils.setChecked(r3, r2);
    L12:
        updateLocationGeneral(r2);
        return;
    L5:
        r1 = false;
        goto L6
    }

    private void setLocationEnabled(boolean r4) {
        RestrictedLockUtils.EnforcedAdmin r0 = getShareLocationEnforcedAdmin(UserHandle.myUserId());
        if (r0 == null) goto L6;
        OLog.i(TAG, "User is restricted, skipping location change.");
        refreshLocationMode();
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this.mContext, r0);
        return;
    L6:
        com.android.settingslib.Utils.updateLocationEnabled(this.mContext, r4, UserHandle.myUserId(), 1);
        refreshLocationMode();
    }

    private boolean isRestricted() {
        if (this.userManager.hasUserRestriction("no_share_location") == false) goto L5;
    L8:
        return true;
    L5:
        if (this.userManager.hasUserRestriction("no_config_location") == true) goto L8;
        return false;
    }

    private void updateLocationGeneral(boolean r5) {
        OCardListItem r0 = this.locationGeneral;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r5 == false) goto L7;
        int r6 = getAllowedLocationAppCount();
        int r1 = getTotalInstalledAppCount();
        OCardListItemUtils.setSubTitleString(this.locationGeneral, this.mContext.getString(R.string.location_summary, new Object[]{Integer.valueOf(r6), Integer.valueOf(r1)}));
        this.locationGeneral.setVisibility(0);
        initProfileViews();
        return;
    L7:
        r0.setVisibility(8);
        OCardListItem r4 = this.mProfileLocation;
        if (r4 == null) goto L12;
        r4.setVisibility(8);
        return;
    }

    private int getAllowedLocationAppCount() {
        Iterator r0 = ((UserManager) this.mContext.getSystemService(PickApplicationActivity.EXTRA_USER)).getUserHandles(true).iterator();
        int r3 = 0;
    L4:
        if (r0.hasNext() == false) goto L21;
        PackageManager r4 = this.mContext.createPackageContextAsUser(this.mContext.getPackageName(), 0, (UserHandle) r0.next()).getPackageManager();     // Catch: Exception -> L22
        Iterator<ApplicationInfo> r5 = r4.getInstalledApplications(128).iterator();     // Catch: Exception -> L22
    L8:
        if (r5.hasNext() == false) goto L4;
        ApplicationInfo r6 = r5.next();     // Catch: Exception -> L22
        if ((r6.flags & 1) != 0) goto L8;
        if (r4.checkPermission("android.permission.ACCESS_FINE_LOCATION", r6.packageName) == 0) goto L18;
        if (r4.checkPermission("android.permission.ACCESS_COARSE_LOCATION", r6.packageName) == 0) goto L18;
        boolean r7 = false;
    L19:
        if (r7 == false) goto L8;
        r3 = r3 + 1;
    L18:
        r7 = true;
        goto L19
    L21:
        return r3;
    }

    private int getTotalInstalledAppCount() {
        PackageManager r6 = this.mContext.getPackageManager();
        Iterator<ApplicationInfo> r0 = r6.getInstalledApplications(128).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L8;
        ApplicationInfo r2 = r0.next();
        if ((r2.flags & 1) != 0) goto L4;
        r1 = r1 + 1;
        String r3 = r2.packageName;
        SLog.d(TAG, "Installed app: " + r6.getApplicationLabel(r2).toString() + " (" + r3 + ")");
        goto L4
    L8:
        return r1;
    }

    private RestrictedLockUtils.EnforcedAdmin getShareLocationEnforcedAdmin(int r3) {
        RestrictedLockUtils.EnforcedAdmin r0 = RestrictedLockUtilsInternal.checkIfRestrictionEnforced(this.mContext, "no_share_location", r3);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return RestrictedLockUtilsInternal.checkIfRestrictionEnforced(this.mContext, "no_config_location", r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_location_LocationServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(LocationServiceSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_location_LocationServiceSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_location_LocationServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(LocationServiceSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_location_LocationServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_location_LocationServiceSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(LocationServiceSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_location_LocationServiceSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
