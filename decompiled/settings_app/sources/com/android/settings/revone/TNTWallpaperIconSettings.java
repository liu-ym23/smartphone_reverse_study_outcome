package com.android.settings.revone;

import android.os.Bundle;
import android.view.View;
import com.android.settings.AppIconsSettingsFragment;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class TNTWallpaperIconSettings extends BaseFragment implements View.OnClickListener {
    public static final String TITLE_ID_TAG = "title_id";
    private int mTitleIdOfWallPaper;

    public void com_android_settings_revone_TNTWallpaperIconSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_TNTWallpaperIconSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_TNTWallpaperIconSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_TNTWallpaperIconSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public TNTWallpaperIconSettings() {
        super(R.layout.tablet_wallpaper_icon_settings_layout);
        this.mTitleIdOfWallPaper = -1;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.mTitleIdOfWallPaper = R.string.tnt_wallpaper_label;
        findViewByIdNullable(R.id.id_tnt_wallpaper).setOnClickListener(this);
        findViewByIdNullable(R.id.id_launcher_icon).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        int r4 = r3.getId();
        if (r4 != R.id.id_launcher_icon) goto L5;
        start(AppIconsSettingsFragment.class);
        return;
    L5:
        if (r4 != R.id.id_tnt_wallpaper) goto L14;
        Bundle r5 = new Bundle();
        int r0 = this.mTitleIdOfWallPaper;
        if (r0 == (-1)) goto L10;
        r5.putInt("title_id", r0);
    L10:
        start(TabletWallpaperSettings.class, r5);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_TNTWallpaperIconSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TNTWallpaperIconSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TNTWallpaperIconSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TNTWallpaperIconSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TNTWallpaperIconSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_TNTWallpaperIconSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TNTWallpaperIconSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TNTWallpaperIconSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TNTWallpaperIconSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
