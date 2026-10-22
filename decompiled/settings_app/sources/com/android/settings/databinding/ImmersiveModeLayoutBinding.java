package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingItemImage;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemCheck;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class ImmersiveModeLayoutBinding implements ViewBinding {
    public final SettingItemText applicationStatusBarDisplayMode;
    public final View applicationStatusBarDisplayModeShadow;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final LinearLayout statusBarNotch;
    public final SettingItemCheck statusBarNotchTitleHideCamera;
    public final SettingItemImage statusBarNotchTitleHideCameraImage;
    public final SettingItemCheck statusBarNotchTitleShowCamera;
    public final SettingItemImage statusBarNotchTitleShowCameraImage;
    public final SettingItemSwitch switchColorStatusBar;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ImmersiveModeLayoutBinding(RelativeLayout r1, SettingItemText r2, View r3, LinearLayout r4, OScrollView r5, LinearLayout r6, SettingItemCheck r7, SettingItemImage r8, SettingItemCheck r9, SettingItemImage r10, SettingItemSwitch r11, OFloatingTitleBar r12) {
        this.rootView = r1;
        this.applicationStatusBarDisplayMode = r2;
        this.applicationStatusBarDisplayModeShadow = r3;
        this.pageContainer = r4;
        this.pageScrollview = r5;
        this.statusBarNotch = r6;
        this.statusBarNotchTitleHideCamera = r7;
        this.statusBarNotchTitleHideCameraImage = r8;
        this.statusBarNotchTitleShowCamera = r9;
        this.statusBarNotchTitleShowCameraImage = r10;
        this.switchColorStatusBar = r11;
        this.viewTitle = r12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ImmersiveModeLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ImmersiveModeLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.immersive_mode_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ImmersiveModeLayoutBinding bind(View r15) {
        int r0 = R.id.application_status_bar_display_mode;
        SettingItemText r4 = (SettingItemText) ViewBindings.findChildViewById(r15, R.id.application_status_bar_display_mode);
        if (r4 == null) goto L27;
        r0 = R.id.application_status_bar_display_mode_shadow;
        View r5 = ViewBindings.findChildViewById(r15, R.id.application_status_bar_display_mode_shadow);
        if (r5 == null) goto L27;
        r0 = R.id.page_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.page_container);
        if (r6 == null) goto L27;
        r0 = R.id.page_scrollview;
        OScrollView r7 = (OScrollView) ViewBindings.findChildViewById(r15, R.id.page_scrollview);
        if (r7 == null) goto L27;
        r0 = R.id.status_bar_notch;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.status_bar_notch);
        if (r8 == null) goto L27;
        r0 = R.id.status_bar_notch_title_hide_camera;
        SettingItemCheck r9 = (SettingItemCheck) ViewBindings.findChildViewById(r15, R.id.status_bar_notch_title_hide_camera);
        if (r9 == null) goto L27;
        r0 = R.id.status_bar_notch_title_hide_camera_image;
        SettingItemImage r10 = (SettingItemImage) ViewBindings.findChildViewById(r15, R.id.status_bar_notch_title_hide_camera_image);
        if (r10 == null) goto L27;
        r0 = R.id.status_bar_notch_title_show_camera;
        SettingItemCheck r11 = (SettingItemCheck) ViewBindings.findChildViewById(r15, R.id.status_bar_notch_title_show_camera);
        if (r11 == null) goto L27;
        r0 = R.id.status_bar_notch_title_show_camera_image;
        SettingItemImage r12 = (SettingItemImage) ViewBindings.findChildViewById(r15, R.id.status_bar_notch_title_show_camera_image);
        if (r12 == null) goto L27;
        r0 = R.id.switch_color_status_bar;
        SettingItemSwitch r13 = (SettingItemSwitch) ViewBindings.findChildViewById(r15, R.id.switch_color_status_bar);
        if (r13 == null) goto L27;
        r0 = R.id.view_title;
        OFloatingTitleBar r14 = (OFloatingTitleBar) ViewBindings.findChildViewById(r15, R.id.view_title);
        if (r14 == null) goto L27;
        return new ImmersiveModeLayoutBinding((RelativeLayout) r15, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    }
}
