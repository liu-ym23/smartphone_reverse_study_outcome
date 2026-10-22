package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.LauncherPreview;
import com.android.settings.widget.VerticalOptionsCheckView;
import com.obric.oui.bouncelayout.OScrollView;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class LauncherSettingsFragmentBinding implements ViewBinding {
    public final SettingItemText bytedanceDesktopEnable;
    public final TextView bytedanceLauncherModeTitle;
    public final View hideLableBottomGap;
    public final TextView iconIlluminationTips;
    public final LauncherPreview idLauncherPreview;
    public final VerticalOptionsCheckView idLauncherSettingDockerView;
    public final SettingItemSwitch itemIdHideLable;
    public final SettingItemSwitch itemIdIconIllumination;
    public final LauncherSettingsThemeBinding laucherThemeViewstub;
    public final LauncherSettingsSwitcherLayoutBinding launcherSettingsSwitcherViewstub;
    public final View launcherThemeBottomGap;
    public final LauncherMultiBlockOptionsBinding multiBlockViewstub;
    public final SettingItemSwitch originalLauncherBlurSwitch;
    private final LinearLayout rootView;
    public final OScrollView scrollView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LauncherSettingsFragmentBinding(LinearLayout r1, SettingItemText r2, TextView r3, View r4, TextView r5, LauncherPreview r6, VerticalOptionsCheckView r7, SettingItemSwitch r8, SettingItemSwitch r9, LauncherSettingsThemeBinding r10, LauncherSettingsSwitcherLayoutBinding r11, View r12, LauncherMultiBlockOptionsBinding r13, SettingItemSwitch r14, OScrollView r15) {
        this.rootView = r1;
        this.bytedanceDesktopEnable = r2;
        this.bytedanceLauncherModeTitle = r3;
        this.hideLableBottomGap = r4;
        this.iconIlluminationTips = r5;
        this.idLauncherPreview = r6;
        this.idLauncherSettingDockerView = r7;
        this.itemIdHideLable = r8;
        this.itemIdIconIllumination = r9;
        this.laucherThemeViewstub = r10;
        this.launcherSettingsSwitcherViewstub = r11;
        this.launcherThemeBottomGap = r12;
        this.multiBlockViewstub = r13;
        this.originalLauncherBlurSwitch = r14;
        this.scrollView = r15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LauncherSettingsFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LauncherSettingsFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.launcher_settings_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LauncherSettingsFragmentBinding bind(View r19) {
        int r1 = R.id.bytedance_desktop_enable;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r19, R.id.bytedance_desktop_enable);
        if (r5 == null) goto L33;
        r1 = R.id.bytedance_launcher_mode_title;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r19, R.id.bytedance_launcher_mode_title);
        if (r6 == null) goto L33;
        r1 = R.id.hide_lable_bottom_gap;
        View r7 = ViewBindings.findChildViewById(r19, R.id.hide_lable_bottom_gap);
        if (r7 == null) goto L33;
        r1 = R.id.icon_illumination_tips;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r19, R.id.icon_illumination_tips);
        if (r8 == null) goto L33;
        r1 = R.id.id_launcher_preview;
        LauncherPreview r9 = (LauncherPreview) ViewBindings.findChildViewById(r19, R.id.id_launcher_preview);
        if (r9 == null) goto L33;
        r1 = R.id.id_launcher_setting_docker_view;
        VerticalOptionsCheckView r10 = (VerticalOptionsCheckView) ViewBindings.findChildViewById(r19, R.id.id_launcher_setting_docker_view);
        if (r10 == null) goto L33;
        r1 = R.id.item_id_hide_lable;
        SettingItemSwitch r11 = (SettingItemSwitch) ViewBindings.findChildViewById(r19, R.id.item_id_hide_lable);
        if (r11 == null) goto L33;
        r1 = R.id.item_id_icon_illumination;
        SettingItemSwitch r12 = (SettingItemSwitch) ViewBindings.findChildViewById(r19, R.id.item_id_icon_illumination);
        if (r12 == null) goto L33;
        r1 = R.id.laucher_theme_viewstub;
        View r2 = ViewBindings.findChildViewById(r19, R.id.laucher_theme_viewstub);
        if (r2 == null) goto L33;
        LauncherSettingsThemeBinding r13 = LauncherSettingsThemeBinding.bind(r2);
        r1 = R.id.launcher_settings_switcher_viewstub;
        View r3 = ViewBindings.findChildViewById(r19, R.id.launcher_settings_switcher_viewstub);
        if (r3 == null) goto L33;
        LauncherSettingsSwitcherLayoutBinding r14 = LauncherSettingsSwitcherLayoutBinding.bind(r3);
        r1 = R.id.launcher_theme_bottom_gap;
        View r15 = ViewBindings.findChildViewById(r19, R.id.launcher_theme_bottom_gap);
        if (r15 == null) goto L33;
        r1 = R.id.multi_block_viewstub;
        View r4 = ViewBindings.findChildViewById(r19, R.id.multi_block_viewstub);
        if (r4 == null) goto L33;
        LauncherMultiBlockOptionsBinding r16 = LauncherMultiBlockOptionsBinding.bind(r4);
        r1 = R.id.original_launcher_blur_switch;
        SettingItemSwitch r17 = (SettingItemSwitch) ViewBindings.findChildViewById(r19, R.id.original_launcher_blur_switch);
        if (r17 == null) goto L33;
        r1 = R.id.scroll_view;
        OScrollView r18 = (OScrollView) ViewBindings.findChildViewById(r19, R.id.scroll_view);
        if (r18 == null) goto L33;
        return new LauncherSettingsFragmentBinding((LinearLayout) r19, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r19.getResources().getResourceName(r1)));
    }
}
