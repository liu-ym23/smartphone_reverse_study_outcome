package com.android.settings;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
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
public class RejectCallSettingsFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private SettingItemText mAllowCall;
    private SettingItemSwitch mRejctCall;
    private SettingItemSwitch mRepeatedCall;

    public void com_android_settings_RejectCallSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_RejectCallSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_RejectCallSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_RejectCallSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public RejectCallSettingsFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.reject_call_settings, r3, false);
        initViews();
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    private void initViews() {
        this.mRejctCall = (SettingItemSwitch) findViewByIdNullable(R.id.reject_calls);
        this.mAllowCall = (SettingItemText) findViewByIdNullable(R.id.allow_calls);
        this.mRepeatedCall = (SettingItemSwitch) findViewByIdNullable(R.id.repeated_calls);
        this.mRejctCall.setOnCheckedChangeListener(this);
        this.mAllowCall.setOnClickListener(this);
        this.mRepeatedCall.setOnCheckedChangeListener(this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateViews() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        boolean r2 = false;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "reject_call", 0) != 1) goto L8;
        boolean r0 = true;
    L10:
        if (android.provider.Settings.Global.getInt(getContentResolver(), "repeated_call", 0) != 1) goto L12;
        r2 = true;
    L12:
        this.mRejctCall.setChecked(r0);
        this.mRepeatedCall.setChecked(r2);
        this.mAllowCall.setSubTitle(getAllowCallSubtitle());
        this.mAllowCall.setEnabled(r0);
        this.mRepeatedCall.setEnabled(r0);
        return;
    L8:
        r0 = false;
        goto L10
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mRejctCall.getSwitch()) goto L6;
        android.provider.Settings.Global.putInt(getContentResolver(), "reject_call", r3 ? 1 : 0);
        this.mAllowCall.setEnabled(r3);
        this.mRepeatedCall.setEnabled(r3);
        return;
    L6:
        if (r2 != this.mRepeatedCall.getSwitch()) goto L10;
        android.provider.Settings.Global.putInt(getContentResolver(), "repeated_call", r3 ? 1 : 0);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        if (r4.getId() != R.id.allow_calls) goto L7;
        Intent r5 = new Intent();
        ComponentName r0 = new ComponentName(Constants.PACKAGE_NAME_NODISTURB, Constants.CLASS_NAME_NODISTURB_SPECIFY);
        r5.putExtra("source", 1);
        r5.setComponent(r0);
        Utils.startActivity(this, r5, 2);
        return;
    }

    private String getAllowCallSubtitle() {
        String[] r0 = getResources().getStringArray(R.array.allow_calls_entries);
        int r2 = getAllowCallSettings();
        if (r2 < r0.length) goto L5;
        return null;
    L5:
        return r0[r2];
    }

    private int getAllowCallSettings() {
        return android.provider.Settings.Global.getInt(getContentResolver(), "allow_call", 4);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_RejectCallSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(RejectCallSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_RejectCallSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_RejectCallSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(RejectCallSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_RejectCallSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_RejectCallSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(RejectCallSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_RejectCallSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
