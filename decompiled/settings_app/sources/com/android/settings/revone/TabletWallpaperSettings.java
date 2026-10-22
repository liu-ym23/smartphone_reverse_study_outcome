package com.android.settings.revone;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.SettingItemTextVertical;
import com.android.settings.SettingsTracker;
import com.android.settings.TrackerConstants;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class TabletWallpaperSettings extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private SettingItemTextVertical mDesktopWallpaperView;
    private SettingItemTextVertical mHistoryWallpaperView;
    private SettingItemSwitch mSlideSwitchWallpaper;

    public void com_android_settings_revone_TabletWallpaperSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_TabletWallpaperSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_TabletWallpaperSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_TabletWallpaperSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public TabletWallpaperSettings() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.tablet_wallpaper_settings, r3, false);
        SettingItemTextVertical r5 = (SettingItemTextVertical) findViewByIdNullable(R.id.item_id_origin_launcher_wp);
        this.mDesktopWallpaperView = r5;
        r5.setOnClickListener(this);
        SettingItemTextVertical r6 = (SettingItemTextVertical) findViewByIdNullable(R.id.item_id_history_wallpaper);
        this.mHistoryWallpaperView = r6;
        r6.setOnClickListener(this);
        this.mSlideSwitchWallpaper = (SettingItemSwitch) findViewByIdNullable(R.id.switch_wallpaper);
        Bundle r7 = getArguments();
        if (r7 == null) goto L10;
        int r8 = r7.getInt("title_id", -1);
        if (r8 <= 0) goto L10;
        OFloatingTitleBar r9 = (OFloatingTitleBar) this.mRootView.findViewById(R.id.view_title);     // Catch: Exception -> L11
        if (r9 == null) goto L10;
        r9.setCenterTitle(r8);     // Catch: Exception -> L11
    L10:
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mSlideSwitchWallpaper.setOnCheckedChangeListener(this);
    }

    public void updateViews() {
        if (Settings.Global.getInt(getContentResolver(), "finger_slide_switch_wallpaper", 1) != 1) goto L5;
        boolean r0 = true;
    L6:
        this.mSlideSwitchWallpaper.setChecked(r0);
        this.mDesktopWallpaperView.setSelected(true);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mSlideSwitchWallpaper.getSwitch()) goto L6;
        Settings.Global.putInt(getContentResolver(), "finger_slide_switch_wallpaper", r3 ? 1 : 0);
        SettingsTracker.onSwitchStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.FIVE_POINT_SWIPE_FOR_WALLPAPER, r3);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        Intent r0 = new Intent();
        r0.putExtra("back_text", getString(R.string.launcher_wallpaper_setting_text));
        if (r4 != this.mDesktopWallpaperView) goto L6;
        r0.setClassName(Constants.PKG_WALLPAPER_PROVIDER, "com.obric.wallpaper.revone.TabletWallpapersActivity");
    L9:
        if ((r4 instanceof SettingItemTextVertical) == false) goto L11;
        r0.putExtra("title", ((SettingItemTextVertical) r4).getTitle());
    L11:
        Utils.startActivity(this._mActivity, r0);
        return;
    L6:
        if (r4 != this.mHistoryWallpaperView) goto L13;
        r0.setClassName(Constants.PKG_WALLPAPER_PROVIDER, "com.obric.wallpaper.revone.TabletHistoryWallpaperActivity");
        goto L9
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_TabletWallpaperSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TabletWallpaperSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TabletWallpaperSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TabletWallpaperSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TabletWallpaperSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_TabletWallpaperSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TabletWallpaperSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TabletWallpaperSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TabletWallpaperSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
