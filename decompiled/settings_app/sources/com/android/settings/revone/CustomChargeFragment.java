package com.android.settings.revone;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SliderWithText;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class CustomChargeFragment extends BaseFragment {
    private SliderWithText mSeekBar;

    public void com_android_settings_revone_CustomChargeFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_CustomChargeFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_CustomChargeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_CustomChargeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ SliderWithText access$000(CustomChargeFragment r0) {
        return r0.mSeekBar;
    }

    public CustomChargeFragment() {
        super(R.layout.boston_custom_charge);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        SliderWithText r4 = (SliderWithText) findViewByIdNullable(R.id.seek_bar);
        this.mSeekBar = r4;
        r4.setMax(getResources().getInteger(R.integer.boston_charge_power_max));
        this.mSeekBar.setMin(getResources().getInteger(R.integer.boston_charge_power_min));
        View r5 = this.mSeekBar.getLeftTips();
        if (r5 == null) goto L5;
        r5.setVisibility(8);
    L5:
        this.mSeekBar.getSeekBar().setOnSeekBarChangeListener(new AnonymousClass1(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    private void updateViews() {
        int r0 = Settings.Global.getInt(getContentResolver(), "charge_up_max_power", 50);
        this.mSeekBar.setProgress(r0);
        this.mSeekBar.setRightTips(r0 + "%");
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_CustomChargeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(CustomChargeFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_CustomChargeFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_CustomChargeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(CustomChargeFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_CustomChargeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_CustomChargeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(CustomChargeFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_CustomChargeFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
