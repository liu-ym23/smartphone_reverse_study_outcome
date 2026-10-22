package com.android.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.actionbar.v2.OBottomActionBarNormalVertical;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.utils.StyleUtil;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class BiometricsLicenseFragment extends BaseFragment implements View.OnClickListener {
    public static final int LICENSE_FACE = 1;
    public static final int LICENSE_FINGERPRINT = 0;
    public static final String LICENSE_TYPE = "license_type";
    private View mRootView;

    public void com_android_settings_BiometricsLicenseFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_BiometricsLicenseFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_BiometricsLicenseFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_BiometricsLicenseFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public BiometricsLicenseFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        View r5 = r2.inflate(R.layout.biometrics_license_layout, r3, false);
        this.mRootView = r5;
        return r5;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r5, Bundle r6) {
        super.onViewCreated(r5, r6);
        OFloatingTitleBar r7 = (OFloatingTitleBar) r5.findViewById(R.id.view_title);
        ViewStub r0 = (ViewStub) r5.findViewById(R.id.view_content);
        Bundle r1 = getArguments();
        if (r1 == null) goto L5;
        int r2 = r1.getInt(LICENSE_TYPE, 0);
    L7:
        if (r2 != 1) goto L9;
        r7.setCenterTitle(R.string.biometrics_face_license);
        r0.setLayoutResource(R.layout.biometrics_license_layout_face);
    L10:
        r0.inflate();
        OBottomActionBarNormalVertical r8 = (OBottomActionBarNormalVertical) r5.findViewById(R.id.bottom_action_bar_v);
        OButton r9 = (OButton) StyleUtil.createWidgetWithStyle(this._mActivity, 2132017994, new BiometricsLicenseFragment$$ExternalSyntheticLambda0());
        r9.setOnClickListener(new BiometricsLicenseFragment$$ExternalSyntheticLambda1(this));
        r8.showDivider(false);
        r8.addButton(r9);
        return;
    L9:
        r7.setCenterTitle(R.string.biometrics_fingerprint_license);
        r0.setLayoutResource(R.layout.biometrics_license_layout_fingerprint);
        goto L10
    L5:
        r2 = 0;
        goto L7
    }

    static /* synthetic */ OButton lambda$onViewCreated$0(Context r1, Integer r2, Integer r3) {
        OButton r4 = new OButton(r1, null);
        r4.setLayoutParams(new ViewGroup.LayoutParams(-1, r3.intValue()));
        r4.setText(R.string.dlg_ok);
        return r4;
    }

    /* JADX INFO: renamed from: lambda$onViewCreated$1$com-android-settings-BiometricsLicenseFragment, reason: not valid java name */
    /* synthetic */ void m104xdbdf74e6(View r1) {
        finish();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_BiometricsLicenseFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(BiometricsLicenseFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_BiometricsLicenseFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_BiometricsLicenseFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(BiometricsLicenseFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_BiometricsLicenseFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_BiometricsLicenseFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(BiometricsLicenseFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_BiometricsLicenseFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
