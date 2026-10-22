package com.android.settings.specialaccess;

import android.app.admin.DeviceAdminInfo;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settings.SettingsActivity;
import com.android.settings.Utils;
import com.android.settings.applications.manageapplications.AppFilterRegistry;
import com.android.settings.applications.manageapplications.ManageApplications;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.PackageService;
import com.android.settings.applications.utils.PackageUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.specialaccess.datausage.DataSaverActivity;
import com.android.settings.specialaccess.fromSpa.MediaRoutingControlActivity;
import com.android.settings.specialaccess.fromSpa.UseFullScreenIntentActivity;
import com.android.settings.specialaccess.notificationaccess.NotificationAccessSettingsActivity;
import com.android.settings.specialaccess.pictureinpicture.PictureInPictureSettingsActivity;
import com.android.settings.specialaccess.premiumsms.PremiumSmsAccessActivity;
import com.android.settings.specialaccess.vrlistener.VrListenersSettingsActivity;
import com.android.settings.specialaccess.zenaccess.ZenAccessSettingsActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SpecialAccessSettingsFragment extends BaseFragment implements View.OnClickListener, LifecycleOwner {
    private final String TAG;
    private final LifecycleRegistry mLifecycleRegistry;
    private List<PackageService> mPackageServices;

    public void com_android_settings_specialaccess_SpecialAccessSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_specialaccess_SpecialAccessSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_specialaccess_SpecialAccessSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SpecialAccessSettingsFragment() {
        this.TAG = "SpecialAccessSettingsFragment";
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mPackageServices = new ArrayList();
    }

    static /* synthetic */ void access$000(SpecialAccessSettingsFragment r0, OCardListItem r1, int r2) {
        r0.setTrailingText(r1, r2);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.special_access_settings_layout, r3, false);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        UIUtils.fitMaskTitle(this);
        initViews();
    }

    private void initViews() {
        LinearLayout r0 = (LinearLayout) findViewByIdNullable(R.id.permission_list);
        View r1 = findViewByIdNullable(R.id.interact_across_profiles);
        if (r1 != null) goto L5;
    L7:
        OCardListItemUtils.updateGroupContainer(r0);
        int r2 = r0.getChildCount();
        OLog.i(this.TAG, "initViews permissionCount=" + r2);
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L13;
        View r4 = r0.getChildAt(r3);
        if ((r4 instanceof OCardListItem) == false) goto L12;
        ((OCardListItem) r4).setOnContentClickListener(this);
    L12:
        r3 = r3 + 1;
        goto L8
    L13:
        return;
    L5:
        if (Utils.getManagedProfile(Utils.getUserManager(getContext())) != null) goto L7;
        r1.setVisibility(8);
        goto L7
    }

    private void initTailingView(final OCardListItem r12) {
        int r1 = 0;
        switch(r12.getId()) {
            case 2131427554: goto L32;
            case 2131428029: goto L31;
            case 2131428030: goto L30;
            case 2131428284: goto L29;
            case 2131428373: goto L24;
            case 2131428566: goto L23;
            case 2131429231: goto L22;
            case 2131429844: goto L21;
            case 2131429845: goto L20;
            case 2131429883: goto L19;
            case 2131429887: goto L18;
            case 2131430117: goto L17;
            case 2131430316: goto L16;
            case 2131430392: goto L15;
            case 2131430991: goto L14;
            case 2131431232: goto L13;
            case 2131431467: goto L12;
            case 2131431590: goto L11;
            case 2131431791: goto L10;
            case 2131431802: goto L5;
            default: goto L33;
        };
    L5:
        List<ApplicationInfo> r0 = PackageUtils.INSTANCE.getZenAppList(getActivity());
        if (r0 == null) goto L9;
        r1 = r0.size();
    L9:
        setTrailingText(r12, r1);
        goto L33
    L10:
        int r2 = 7;
    L34:
        int r7 = r2;
    L35:
        if (r7 == 11) goto L37;
        if (r7 == 6) goto L37;
        return;
    L37:
        this.mPackageServices.add(PackageUtils.INSTANCE.getTypeAppList(this, getActivity(), r7, AppFilterRegistry.getInstance().get(AppFilterRegistry.getInstance().getDefaultFilterType(r7)).getFilter(), null, new AnonymousClass7(this, r12)));
        return;
    L11:
        PackageUtils.INSTANCE.getFullScreenAppList(this, getActivity(), new AnonymousClass6(this, r12));
        goto L33
    L12:
        r2 = 19;
        goto L34
    L13:
        r7 = 6;
        goto L35
    L14:
        r2 = 4;
        goto L34
    L15:
        PackageUtils.INSTANCE.getSmsAppList(this, getActivity(), new AnonymousClass3(this, r12));
        goto L33
    L16:
        setTrailingText(r12, PackageUtils.INSTANCE.getPicInPicAppList(getActivity()).size());
        goto L33
    L17:
        PackageUtils.INSTANCE.getNotificationAppList(getContext(), new AnonymousClass1(this, r12));
        goto L33
    L18:
        PackageUtils.INSTANCE.getMediaRoutingAppList(this, getActivity(), new AnonymousClass2(this, r12));
        goto L33
    L19:
        r2 = 13;
        goto L34
    L20:
        r7 = 11;
        goto L35
    L21:
        r2 = 8;
        goto L34
    L22:
        r2 = 21;
        goto L34
    L23:
        PackageUtils.INSTANCE.getVRAppList(getActivity(), new AnonymousClass5(this, r12));
        goto L33
    L24:
        List<DeviceAdminInfo> r3 = PackageUtils.INSTANCE.getDeviceList(getActivity());
        if (r3 == null) goto L28;
        r1 = r3.size();
    L28:
        setTrailingText(r12, r1);
        goto L33
    L29:
        PackageUtils.INSTANCE.getDataSaverAppList(this, getActivity(), new AnonymousClass4(this, r12));
        goto L33
    L30:
        r2 = 10;
        goto L34
    L31:
        r2 = 18;
        goto L34
    L32:
        r2 = 12;
    L33:
        r2 = -1;
        goto L34
    }

    private void setTrailingText(OCardListItem r3, int r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (r4 != 0) goto L8;
        r3.showCustomEnd(false);
        return;
    L8:
        r3.showCustomEnd(true);
        OCardListItemUtils.setTrailingText(r3, getString(R.string.app_count, new Object[]{Integer.valueOf(r4)}));
    }

    private OCardListItem findCardParent(View r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        ViewParent r3 = r2.getParent();
    L6:
        if (r3 == null) goto L12;
        if ((r3 instanceof OCardListItem) == true) goto L10;
        r3 = r3.getParent();
        goto L6
    L10:
        return (OCardListItem) r3;
    L12:
        return null;
    }

    public void com_android_settings_specialaccess_SpecialAccessSettingsFragment__onResume$___twin___() {
        super.onResume();
        Iterator<PackageService> r1 = this.mPackageServices.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().resume();
        goto L4
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Iterator<PackageService> r1 = this.mPackageServices.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().pause();
        goto L4
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Iterator<PackageService> r1 = this.mPackageServices.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onClear();
        goto L4
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r6) {
        OCardListItem r7 = findCardParent(r6);
        if (r7 != null) goto L5;
        return;
    L5:
        int r8 = r7.getId();
        OLog.i(this.TAG, "onClick viewId=" + r8);
        switch(r8) {
            case 2131427554: goto L36;
            case 2131428029: goto L35;
            case 2131428030: goto L34;
            case 2131428284: goto L32;
            case 2131428373: goto L30;
            case 2131428566: goto L28;
            case 2131429231: goto L27;
            case 2131429844: goto L26;
            case 2131429845: goto L25;
            case 2131429883: goto L24;
            case 2131429887: goto L22;
            case 2131430117: goto L20;
            case 2131430316: goto L18;
            case 2131430392: goto L16;
            case 2131430991: goto L15;
            case 2131431232: goto L14;
            case 2131431467: goto L13;
            case 2131431590: goto L11;
            case 2131431791: goto L10;
            case 2131431802: goto L8;
            default: goto L7;
        };
    L7:
        int r9 = -1;
        int r1 = -1;
        int r2 = -1;
    L37:
        Bundle r3 = new Bundle();
        if (r9 <= 0) goto L40;
        r3.putInt(SettingsActivity.EXTRA_SHOW_FRAGMENT_TITLE_RESID, r9);
    L40:
        if (r1 <= 0) goto L42;
        r3.putInt(SettingsActivity.EXTRA_SHOW_FRAGMENT_SUBTITLE_RESID, r1);
    L42:
        if (r2 < 0) goto L44;
        r3.putInt(ManageApplications.EXTRA_LIST_TYPE, r2);
    L44:
        if (r2 == (-1)) goto L47;
        Intent r10 = new Intent();
        r10.setClass(this.mContext, Settings.SpecialAccessAppListActivity.class);
        r10.putExtras(r3);
        Utils.startActivity(this._mActivity, r10);
        return;
    L47:
        return;
    L8:
        Utils.startActivity(this._mActivity, new Intent(this._mActivity, ZenAccessSettingsActivity.class));
        return;
    L10:
        r9 = R.string.write_settings_title;
        r1 = R.string.write_settings_description;
        r2 = 7;
        goto L37
    L11:
        Utils.startActivity(this._mActivity, new Intent(this._mActivity, UseFullScreenIntentActivity.class));
        return;
    L13:
        r9 = R.string.turn_screen_on_title;
        r1 = R.string.allow_turn_screen_on_description;
        r2 = 19;
        goto L37
    L14:
        r9 = R.string.system_alert_window_settings;
        r1 = R.string.allow_overlay_description;
        r2 = 6;
        goto L37
    L15:
        r9 = R.string.usage_access;
        r1 = R.string.usage_access_description;
        r2 = 4;
        goto L37
    L16:
        Utils.startActivity(this._mActivity, new Intent(this._mActivity, PremiumSmsAccessActivity.class));
        return;
    L18:
        Utils.startActivity(this._mActivity, new Intent(this._mActivity, PictureInPictureSettingsActivity.class));
        return;
    L20:
        Utils.startActivity(this._mActivity, new Intent(this._mActivity, NotificationAccessSettingsActivity.class));
        return;
    L22:
        Utils.startActivity(this._mActivity, new Intent(this._mActivity, MediaRoutingControlActivity.class));
        return;
    L24:
        r9 = R.string.media_management_apps_title;
        r1 = R.string.media_management_apps_description;
        r2 = 13;
        goto L37
    L25:
        r9 = R.string.manage_external_storage_title;
        r1 = R.string.allow_manage_external_storage_description;
        r2 = 11;
        goto L37
    L26:
        r9 = R.string.install_other_apps;
        r1 = R.string.install_unknown_applications;
        r2 = 8;
        goto L37
    L27:
        r9 = R.string.interact_across_profiles_title;
        r2 = 21;
        r1 = R.string.interact_across_profiles_title;
        goto L37
    L28:
        Utils.startActivity(this._mActivity, new Intent(this._mActivity, VrListenersSettingsActivity.class));
        return;
    L30:
        Utils.startActivity(this._mActivity, new Intent(this._mActivity, Settings.DeviceManagerActivity.class));
        return;
    L32:
        Utils.startActivity(this._mActivity, new Intent(this._mActivity, DataSaverActivity.class));
        return;
    L34:
        r9 = R.string.change_wifi_state_title;
        r1 = R.string.change_wifi_state_app_detail_switch;
        r2 = 10;
        goto L37
    L35:
        r9 = R.string.change_nfc_tag_apps_title;
        r1 = R.string.change_nfc_tag_apps_detail_switch;
        r2 = 18;
        goto L37
    L36:
        r9 = R.string.alarms_and_reminders_title;
        r1 = R.string.alarms_and_reminders_switch_title;
        r2 = 12;
        goto L37
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_specialaccess_SpecialAccessSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SpecialAccessSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_specialaccess_SpecialAccessSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_SpecialAccessSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SpecialAccessSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_specialaccess_SpecialAccessSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_SpecialAccessSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SpecialAccessSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_specialaccess_SpecialAccessSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
