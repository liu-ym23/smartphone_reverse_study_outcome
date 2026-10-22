package com.android.settings.accessibility;

import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AccessibilityScreenMagnificationSettingsFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    private OCardListItem mEnable;
    private OSwitch mEnableSwitch;

    public void com_android_settings_accessibility_AccessibilityScreenMagnificationSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_accessibility_AccessibilityScreenMagnificationSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accessibility_AccessibilityScreenMagnificationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accessibility_AccessibilityScreenMagnificationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AccessibilityScreenMagnificationSettingsFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mTitleResId = Integer.valueOf(R.string.accessibility_screen_magnification);
        this.mRootView = r2.inflate(R.layout.accessibility_screen_magnification_fragment, r3, false);
        ((FrameLayout) findViewById(R.id.banner)).addView(UIUtils.buildNoScaledView(this._mActivity, R.layout.view_banner_zoom_gestures_tips));
        OCardListItem r5 = (OCardListItem) findViewById(R.id.accessibility_screen_magnification_enable);
        this.mEnable = r5;
        r5.setDefaultCustomEndView(1);
        this.mEnable.showCustomEnd(true);
        this.mEnableSwitch = (OSwitch) this.mEnable.getCustomEndView();
        ((OSectionSupportiveText) this.mRootView.findViewById(R.id.accessibility_screen_magnification_tips_view)).setSectionDes(getString(R.string.accessibility_screen_magnification_tips_android_r));
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        this.mEnableSwitch.setOnCheckedChangeListener(this);
        this.mEnableSwitch.setChecked(isScreenMagnificationEnable());
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        this.mEnableSwitch.setChecked(isScreenMagnificationEnable());
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mEnableSwitch) goto L6;
        setMagnificationEnabled(r3);
        return;
    }

    private boolean isScreenMagnificationEnable() {
        if (Settings.Secure.getInt(getContentResolver(), "accessibility_display_magnification_enabled", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void setMagnificationEnabled(boolean r2) {
        Settings.Secure.putInt(getContentResolver(), "accessibility_display_magnification_enabled", r2 ? 1 : 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accessibility_AccessibilityScreenMagnificationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AccessibilityScreenMagnificationSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_AccessibilityScreenMagnificationSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_AccessibilityScreenMagnificationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AccessibilityScreenMagnificationSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accessibility_AccessibilityScreenMagnificationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_AccessibilityScreenMagnificationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AccessibilityScreenMagnificationSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_AccessibilityScreenMagnificationSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
