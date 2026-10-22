package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingItemImage;
import obric.widget.SettingItemCheck;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class ImmersiveSettingsHeaderViewBinding implements ViewBinding {
    public final SettingItemText applicationStatusBarDisplayMode;
    public final View applicationStatusBarDisplayModeShadow;
    private final LinearLayout rootView;
    public final LinearLayout statusBarHeaderContainer;
    public final LinearLayout statusBarNotch;
    public final SettingItemCheck statusBarNotchTitleHideCamera;
    public final SettingItemImage statusBarNotchTitleHideCameraImage;
    public final SettingItemCheck statusBarNotchTitleShowCamera;
    public final SettingItemImage statusBarNotchTitleShowCameraImage;
    public final SettingItemCheck statusBarStyleAdaptive;
    public final SettingItemCheck statusBarStyleClassic;
    public final SettingItemSwitch switchColorStatusBar;
    public final LinearLayout switchImmersiveSystemAppsContainer;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ImmersiveSettingsHeaderViewBinding(LinearLayout r1, SettingItemText r2, View r3, LinearLayout r4, LinearLayout r5, SettingItemCheck r6, SettingItemImage r7, SettingItemCheck r8, SettingItemImage r9, SettingItemCheck r10, SettingItemCheck r11, SettingItemSwitch r12, LinearLayout r13) {
        this.rootView = r1;
        this.applicationStatusBarDisplayMode = r2;
        this.applicationStatusBarDisplayModeShadow = r3;
        this.statusBarHeaderContainer = r4;
        this.statusBarNotch = r5;
        this.statusBarNotchTitleHideCamera = r6;
        this.statusBarNotchTitleHideCameraImage = r7;
        this.statusBarNotchTitleShowCamera = r8;
        this.statusBarNotchTitleShowCameraImage = r9;
        this.statusBarStyleAdaptive = r10;
        this.statusBarStyleClassic = r11;
        this.switchColorStatusBar = r12;
        this.switchImmersiveSystemAppsContainer = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ImmersiveSettingsHeaderViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ImmersiveSettingsHeaderViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.immersive_settings_header_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ImmersiveSettingsHeaderViewBinding bind(View r17) {
        int r1 = R.id.application_status_bar_display_mode;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r17, R.id.application_status_bar_display_mode);
        if (r5 == null) goto L29;
        r1 = R.id.application_status_bar_display_mode_shadow;
        View r6 = ViewBindings.findChildViewById(r17, R.id.application_status_bar_display_mode_shadow);
        if (r6 == null) goto L29;
        r1 = R.id.status_bar_header_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.status_bar_header_container);
        if (r7 == null) goto L29;
        r1 = R.id.status_bar_notch;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.status_bar_notch);
        if (r8 == null) goto L29;
        r1 = R.id.status_bar_notch_title_hide_camera;
        SettingItemCheck r9 = (SettingItemCheck) ViewBindings.findChildViewById(r17, R.id.status_bar_notch_title_hide_camera);
        if (r9 == null) goto L29;
        r1 = R.id.status_bar_notch_title_hide_camera_image;
        SettingItemImage r10 = (SettingItemImage) ViewBindings.findChildViewById(r17, R.id.status_bar_notch_title_hide_camera_image);
        if (r10 == null) goto L29;
        r1 = R.id.status_bar_notch_title_show_camera;
        SettingItemCheck r11 = (SettingItemCheck) ViewBindings.findChildViewById(r17, R.id.status_bar_notch_title_show_camera);
        if (r11 == null) goto L29;
        r1 = R.id.status_bar_notch_title_show_camera_image;
        SettingItemImage r12 = (SettingItemImage) ViewBindings.findChildViewById(r17, R.id.status_bar_notch_title_show_camera_image);
        if (r12 == null) goto L29;
        r1 = R.id.status_bar_style_adaptive;
        SettingItemCheck r13 = (SettingItemCheck) ViewBindings.findChildViewById(r17, R.id.status_bar_style_adaptive);
        if (r13 == null) goto L29;
        r1 = R.id.status_bar_style_classic;
        SettingItemCheck r14 = (SettingItemCheck) ViewBindings.findChildViewById(r17, R.id.status_bar_style_classic);
        if (r14 == null) goto L29;
        r1 = R.id.switch_color_status_bar;
        SettingItemSwitch r15 = (SettingItemSwitch) ViewBindings.findChildViewById(r17, R.id.switch_color_status_bar);
        if (r15 == null) goto L29;
        r1 = R.id.switch_immersive_system_apps_container;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.switch_immersive_system_apps_container);
        if (r16 == null) goto L29;
        return new ImmersiveSettingsHeaderViewBinding((LinearLayout) r17, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r1)));
    }
}
