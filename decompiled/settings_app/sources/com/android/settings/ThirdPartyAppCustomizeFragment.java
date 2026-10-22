package com.android.settings;

import android.os.Bundle;
import android.view.View;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class ThirdPartyAppCustomizeFragment extends BaseFragment {
    public static final String MM_ENTER_TO_SEND = "mm_enter_to_send_key";
    private SettingItemSwitch mMmSendByEnterFeature;
    private SettingItemText mMmSendByEnterSelection;

    public void com_android_settings_ThirdPartyAppCustomizeFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_ThirdPartyAppCustomizeFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ThirdPartyAppCustomizeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ThirdPartyAppCustomizeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ThirdPartyAppCustomizeFragment() {
        super(R.layout.third_party_customize_layout);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.mMmSendByEnterFeature = (SettingItemSwitch) findViewByIdNullable(R.id.mm_send_by_enter_feature);
        SettingItemText r3 = (SettingItemText) findViewByIdNullable(R.id.mm_send_by_enter_selection);
        this.mMmSendByEnterSelection = r3;
        r3.setOnClickListener(new AnonymousClass1(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r4) {
        super.onViewStateRestored(r4);
        SettingItemSwitch r5 = this.mMmSendByEnterFeature;
        boolean r2 = true;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "mm_enter_to_send_key", 1) == 1) goto L6;
        r2 = false;
    L6:
        r5.setChecked(r2);
        this.mMmSendByEnterFeature.setOnCheckedChangeListener(new AnonymousClass2(this));
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ThirdPartyAppCustomizeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ThirdPartyAppCustomizeFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ThirdPartyAppCustomizeFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ThirdPartyAppCustomizeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ThirdPartyAppCustomizeFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ThirdPartyAppCustomizeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ThirdPartyAppCustomizeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ThirdPartyAppCustomizeFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ThirdPartyAppCustomizeFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
