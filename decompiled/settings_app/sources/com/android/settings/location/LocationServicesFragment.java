package com.android.settings.location;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Flags;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.ArraySet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.preference.Preference;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.RestrictedAppPreference;
import com.android.settingslib.core.lifecycle.Lifecycle;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class LocationServicesFragment extends BaseFragment implements View.OnClickListener, LocationEnabler.LocationModeChangeListener {
    static final IntentFilter INTENT_FILTER_INJECTED_SETTING_CHANGED = null;
    private BroadcastReceiver mInjectedSettingsReceiver;
    private com.android.settingslib.location.SettingsInjector mInjector;
    protected Lifecycle mLifecycle;
    protected LocationEnabler mLocationEnabler;
    private ViewGroup mPageContainer;
    protected UserManager mUserManager;

    public void com_android_settings_location_LocationServicesFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_location_LocationServicesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_location_LocationServicesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public LocationServicesFragment() {
    }

    static /* synthetic */ com.android.settingslib.location.SettingsInjector access$000(LocationServicesFragment r0) {
        return r0.mInjector;
    }

    static {
        INTENT_FILTER_INJECTED_SETTING_CHANGED = new IntentFilter("android.location.InjectedSettingChanged");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.location_service_layout, r3, false);
        this.mPageContainer = (ViewGroup) this.mRootView.findViewById(R.id.page_container);
        this.mUserManager = (UserManager) this.mContext.getSystemService(PickApplicationActivity.EXTRA_USER);
        this.mLocationEnabler = new LocationEnabler(this.mContext, this, this.mLifecycle);
        this.mInjector = new AppSettingsInjector(this.mContext, 1868);
        return this.mRootView;
    }

    public void com_android_settings_location_LocationServicesFragment__onResume$___twin___() {
        super.onResume();
        if (this.mInjectedSettingsReceiver != null) goto L5;
        this.mInjectedSettingsReceiver = new AnonymousClass1(this);
    L5:
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mInjectedSettingsReceiver, INTENT_FILTER_INJECTED_SETTING_CHANGED, 2);
        this.mPageContainer.removeAllViews();
        injectLocationServices();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mContext.unregisterReceiver(this.mInjectedSettingsReceiver);
    }

    @Override // com.android.settings.location.LocationEnabler.LocationModeChangeListener
    public void onLocationModeChanged(int r1, boolean r2) {
        this.mInjector.reloadStatusMessages();
    }

    protected void injectLocationServices() {
        Iterator<Map.Entry<Integer, List<Preference>>> r0 = getLocationServices().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        Map.Entry<Integer, List<Preference>> r1 = r0.next();
        Iterator<Preference> r2 = r1.getValue().iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        Preference r3 = r2.next();
        if ((r3 instanceof RestrictedAppPreference) == false) goto L7;
        ((RestrictedAppPreference) r3).checkRestrictionAndSetDisabled();
        goto L7
    L12:
        if (r1.getKey().intValue() != UserHandle.myUserId()) goto L4;
        createAndAddPreferences(LocationSettings.sortPreferencesSorted(r1.getValue()));
        goto L4
    }

    private void createAndAddPreferences(List<Preference> r8) {
        int r0 = r8.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        final Preference r2 = r8.get(r1);
        CharSequence r3 = r2.getTitle();
        CharSequence r4 = r2.getSummary();
        OCardListItem r5 = new OCardListItem(this._mActivity);
        r5.setTitle(r3);
        if (r4 == null) goto L9;
        if (r4.toString().isEmpty() == true) goto L9;
        r5.showSubTitle(true);
        r5.setSubTitle(r4);
    L9:
        r5.setCardPosition(getCardPosition(r1, r0));
        r5.setOnContentClickListener(new AnonymousClass2(this, r2));
        this.mPageContainer.addView(r5);
        r1 = r1 + 1;
        goto L3
    }

    protected Map<Integer, List<Preference>> getLocationServices() {
        ArraySet r0 = new ArraySet();
        r0.add(UserHandle.of(UserHandle.myUserId()));
        int r1 = Utils.getManagedProfileId(this.mUserManager, UserHandle.myUserId());
        if (r1 == (-10000)) goto L8;
        if (this.mLocationEnabler.getShareLocationEnforcedAdmin(r1) != null) goto L8;
        r0.add(UserHandle.of(r1));
    L8:
        if (Flags.allowPrivateProfile() == false) goto L19;
        if (android.multiuser.Flags.enablePrivateSpaceFeatures() == false) goto L19;
        if (android.multiuser.Flags.handleInterleavedSettingsForPrivateSpace() == false) goto L19;
        UserHandle r2 = Utils.getProfileOfType(this.mUserManager, 4);
        if (r2 == null) goto L19;
        if (this.mLocationEnabler.getShareLocationEnforcedAdmin(r2.getIdentifier()) != null) goto L19;
        r0.add(r2);
    L19:
        return this.mInjector.getInjectedSettings(this.mContext, r0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_location_LocationServicesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(LocationServicesFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_location_LocationServicesFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_location_LocationServicesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(LocationServicesFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_location_LocationServicesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_location_LocationServicesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(LocationServicesFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_location_LocationServicesFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
