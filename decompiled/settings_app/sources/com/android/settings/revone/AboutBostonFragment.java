package com.android.settings.revone;

import android.casthal.CasthalManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.android.settings.AboutStaticItem;
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
public class AboutBostonFragment extends BaseFragment {
    private static final String BOSTON_RESOLUTION = "2160*1440 ";
    private ImageView mAboutLogo;
    private AboutStaticItem mCompileInfo;
    private AboutStaticItem mItemSerialNumber;
    private AboutStaticItem mResolutionDisplay;
    private AboutStaticItem mViewDeviceModel;
    private AboutStaticItem mViewModVersion;

    public void com_android_settings_revone_AboutBostonFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_AboutBostonFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_AboutBostonFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_AboutBostonFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AboutBostonFragment() {
        super(R.layout.revone_fragment_about_boston);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        this.mViewDeviceModel = (AboutStaticItem) findViewByIdNullable(R.id.device_model);
        this.mItemSerialNumber = (AboutStaticItem) findViewByIdNullable(R.id.serial_number);
        this.mResolutionDisplay = (AboutStaticItem) findViewByIdNullable(R.id.resolution_display);
        this.mViewModVersion = (AboutStaticItem) findViewByIdNullable(R.id.mod_version);
        this.mCompileInfo = (AboutStaticItem) findViewByIdNullable(R.id.compile_info);
        this.mAboutLogo = (ImageView) findViewByIdNullable(R.id.about_logo);
        if (this.mViewDeviceModel == null) goto L8;
        if (CasthalManager.getInstance(this.mContext) == null) goto L8;
        this.mViewDeviceModel.setSummary(CasthalManager.getInstance(this.mContext).getBostonName());
    L8:
        if (this.mItemSerialNumber != null) goto L10;
    L12:
        AboutStaticItem r6 = this.mResolutionDisplay;
        if (r6 == null) goto L16;
        r6.setSummary(BOSTON_RESOLUTION + getString(R.string.pixel));
    L16:
        if (CasthalManager.getInstance(this.mContext) != null) goto L18;
        return;
    L18:
        if (CasthalManager.getInstance(this.mContext).hasWirelessCapabilitie() == true) goto L20;
        return;
    L20:
        if (CasthalManager.getInstance(this.mContext).getBostonVersionInfo() != null) goto L22;
        return;
    L22:
        if (CasthalManager.getInstance(this.mContext).getBostonVersionInfo().getAmlogicVersion() == null) goto L40;
        String r7 = CasthalManager.getInstance(this.mContext).getBostonVersionInfo().getAmlogicVersion();
        if (r7 != null) goto L26;
        return;
    L26:
        int r8 = r7.indexOf(45);
        if (this.mViewDeviceModel == null) goto L31;
        this.mViewModVersion.setVisibility(0);
        if (r8 < 0) goto L31;
        this.mViewModVersion.setSummary(r7.substring(0, r8));
    L31:
        AboutStaticItem r0 = this.mCompileInfo;
        if (r0 == null) goto L41;
        r0.setVisibility(0);
        if (r8 < 0) goto L42;
        this.mCompileInfo.setSummary(r7.substring(r8 + 1, r7.length()));
        return;
    L42:
        return;
    L41:
        return;
    L40:
        return;
    L10:
        if (CasthalManager.getInstance(this.mContext) == null) goto L12;
        this.mItemSerialNumber.setSummary(CasthalManager.getInstance(this.mContext).getBostonSid());
        goto L12
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_AboutBostonFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AboutBostonFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_AboutBostonFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_AboutBostonFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AboutBostonFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_AboutBostonFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_AboutBostonFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AboutBostonFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_AboutBostonFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
