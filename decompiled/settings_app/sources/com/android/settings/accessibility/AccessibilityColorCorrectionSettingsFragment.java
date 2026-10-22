package com.android.settings.accessibility;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.OptionsInfo;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.v2.OPopover;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class AccessibilityColorCorrectionSettingsFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private OCardListItem mCorrectionMode;
    private OPopover mCorrectionModePopover;
    private OCardListItem mEnable;
    private OSwitch mEnableSwitch;

    private static class SelectionListener implements OptionsInfo.OnSelectListener {
        private String[] mValues;

        SelectionListener(String[] r1) {
            this.mValues = r1;
        }

        @Override // com.android.settings.OptionsInfo.OnSelectListener
        public boolean onSelect(int r2) {
            AccessibilityColorCorrectionSettingsFragment.access$000(SettingsApplication.getContext(), Integer.parseInt(this.mValues[r2]));
            return true;
        }
    }

    public void com_android_settings_accessibility_AccessibilityColorCorrectionSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_accessibility_AccessibilityColorCorrectionSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accessibility_AccessibilityColorCorrectionSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accessibility_AccessibilityColorCorrectionSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public AccessibilityColorCorrectionSettingsFragment() {
    }

    static /* synthetic */ void access$000(Context r0, int r1) {
        setColorCorrectionMode(r0, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mTitleResId = Integer.valueOf(R.string.accessibility_color_correction);
        this.mRootView = r2.inflate(R.layout.accessibility_color_correction_fragment, r3, false);
        OCardListItem r5 = (OCardListItem) findViewByIdNullable(R.id.accessibility_color_correction_enable);
        this.mEnable = r5;
        r5.setDefaultCustomEndView(1);
        this.mEnable.showCustomEnd(true);
        this.mEnableSwitch = (OSwitch) this.mEnable.getCustomEndView();
        OCardListItem r6 = (OCardListItem) findViewByIdNullable(R.id.accessibility_color_correction_mode);
        this.mCorrectionMode = r6;
        r6.setOnContentClickListener(new AccessibilityColorCorrectionSettingsFragment$$ExternalSyntheticLambda1(this));
        this.mCorrectionMode.setDefaultCustomEndView(3);
        this.mCorrectionMode.showCustomEnd(true);
        return this.mRootView;
    }

    /* JADX INFO: renamed from: lambda$onCreateView$0$com-android-settings-accessibility-AccessibilityColorCorrectionSettingsFragment, reason: not valid java name */
    /* synthetic */ void m235xdc9eee8a(View r1) {
        onClick(this.mCorrectionMode);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mEnableSwitch.setOnCheckedChangeListener(this);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateViews() {
        boolean r0 = isColorCorrectionEnable();
        this.mEnableSwitch.setChecked(r0);
        OCardListItem r1 = this.mCorrectionMode;
        if (r0 == false) goto L5;
        int r2 = 0;
    L6:
        r1.setVisibility(r2);
        this.mCorrectionMode.setEndDetailText(getColorCorrectionModeEntry());
        return;
    L5:
        r2 = 4;
        goto L6
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mEnableSwitch) goto L10;
        setColorCorrectionEnable(r3);
        OCardListItem r1 = this.mCorrectionMode;
        if (r3 == false) goto L7;
        int r4 = 0;
    L8:
        r1.setVisibility(r4);
        return;
    L7:
        r4 = 4;
        goto L8
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mCorrectionMode) goto L6;
        startCorrectionMode();
        return;
    }

    private void startCorrectionMode() {
        final String[] r0 = getAllModeEntries();
        String[] r1 = getAllModeSubEntries();
        final String[] r2 = getAllModeValues();
        ArrayList r3 = new ArrayList();
        String r4 = getColorCorrectionModeEntry();
        int r5 = 0;
    L4:
        if (r5 >= r0.length) goto L6;
        String r7 = r0[r5];
        r3.add(new Item(r7, TextUtils.equals(r7, r4), r1[r5]));
        r5 = r5 + 1;
        goto L4
    L6:
        this.mCorrectionModePopover = OPopoverHelper.showPopoverList(this._mActivity, this.mCorrectionMode, r3, new AccessibilityColorCorrectionSettingsFragment$$ExternalSyntheticLambda0(this, r2, r0), true);
    }

    /* JADX INFO: renamed from: lambda$startCorrectionMode$1$com-android-settings-accessibility-AccessibilityColorCorrectionSettingsFragment, reason: not valid java name */
    /* synthetic */ void m236x50f7e454(String[] r1, String[] r2, View r3, int r4) {
        setColorCorrectionMode(SettingsApplication.getContext(), Integer.parseInt(r1[r4]));
        this.mCorrectionMode.setEndDetailText(r2[r4]);
        this.mCorrectionModePopover.dismiss();
    }

    private String[] getAllModeEntries() {
        return getResources().getStringArray(R.array.daltonizer_type_entries_2);
    }

    private String[] getAllModeSubEntries() {
        return getResources().getStringArray(R.array.daltonizer_type_entries_2_1);
    }

    private String[] getAllModeValues() {
        return getResources().getStringArray(R.array.daltonizer_type_values);
    }

    private boolean isColorCorrectionEnable() {
        if (Settings.Secure.getInt(getContentResolver(), "accessibility_display_daltonizer_enabled", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void setColorCorrectionEnable(boolean r2) {
        Settings.Secure.putInt(getContentResolver(), "accessibility_display_daltonizer_enabled", r2 ? 1 : 0);
    }

    private static void setColorCorrectionMode(Context r1, int r2) {
        Settings.Secure.putInt(r1.getContentResolver(), "accessibility_display_daltonizer", r2);
    }

    private int getColorCorrectionMode() {
        return Settings.Secure.getInt(getContentResolver(), "accessibility_display_daltonizer", 12);
    }

    private String getColorCorrectionModeEntry() {
        int r0 = indexOfValue(getAllModeValues(), String.valueOf(getColorCorrectionMode()));
        if (r0 >= 0) goto L5;
    L6:
        r0 = indexOfValue(getAllModeValues(), String.valueOf(12));
    L8:
        return getAllModeEntries()[r0];
    L5:
        if (r0 < getAllModeEntries().length) goto L8;
        goto L6
    }

    private int indexOfValue(String[] r2, String r3) {
        int r1 = 0;
    L4:
        if (r1 >= r2.length) goto L9;
        if (TextUtils.equals(r3, r2[r1]) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return r1;
    L9:
        return -1;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accessibility_AccessibilityColorCorrectionSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(AccessibilityColorCorrectionSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_AccessibilityColorCorrectionSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_AccessibilityColorCorrectionSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(AccessibilityColorCorrectionSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accessibility_AccessibilityColorCorrectionSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_AccessibilityColorCorrectionSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(AccessibilityColorCorrectionSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_AccessibilityColorCorrectionSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
