package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class SideDialCustomSettingLayoutBinding implements ViewBinding {
    public final SettingItemSwitch customModeAlwaysOnScreen;
    public final SettingItemSwitch customModeAutoBrightness;
    public final SettingItemSwitch customModeFeedbackVibration;
    public final SettingItemSwitch customModeGlobalVibrate;
    public final SettingItemSwitch customModeMute;
    public final SettingItemSwitch customModeProtectEyes;
    public final SettingItemSwitch customModeReadMode;
    public final SettingItemSwitch customModeScreenRotation;
    public final SettingItemSwitch customModeTelephonyVibrate;
    private final RelativeLayout rootView;
    public final LinearLayout sideDialCustomModeContainer;
    public final LinearLayout sideDialDetailsContainer;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SideDialCustomSettingLayoutBinding(RelativeLayout r1, SettingItemSwitch r2, SettingItemSwitch r3, SettingItemSwitch r4, SettingItemSwitch r5, SettingItemSwitch r6, SettingItemSwitch r7, SettingItemSwitch r8, SettingItemSwitch r9, SettingItemSwitch r10, LinearLayout r11, LinearLayout r12, OFloatingTitleBar r13) {
        this.rootView = r1;
        this.customModeAlwaysOnScreen = r2;
        this.customModeAutoBrightness = r3;
        this.customModeFeedbackVibration = r4;
        this.customModeGlobalVibrate = r5;
        this.customModeMute = r6;
        this.customModeProtectEyes = r7;
        this.customModeReadMode = r8;
        this.customModeScreenRotation = r9;
        this.customModeTelephonyVibrate = r10;
        this.sideDialCustomModeContainer = r11;
        this.sideDialDetailsContainer = r12;
        this.viewTitle = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SideDialCustomSettingLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SideDialCustomSettingLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.side_dial_custom_setting_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SideDialCustomSettingLayoutBinding bind(View r17) {
        int r1 = R.id.custom_mode_always_on_screen;
        SettingItemSwitch r5 = (SettingItemSwitch) ViewBindings.findChildViewById(r17, R.id.custom_mode_always_on_screen);
        if (r5 == null) goto L29;
        r1 = R.id.custom_mode_auto_brightness;
        SettingItemSwitch r6 = (SettingItemSwitch) ViewBindings.findChildViewById(r17, R.id.custom_mode_auto_brightness);
        if (r6 == null) goto L29;
        r1 = R.id.custom_mode_feedback_vibration;
        SettingItemSwitch r7 = (SettingItemSwitch) ViewBindings.findChildViewById(r17, R.id.custom_mode_feedback_vibration);
        if (r7 == null) goto L29;
        r1 = R.id.custom_mode_global_vibrate;
        SettingItemSwitch r8 = (SettingItemSwitch) ViewBindings.findChildViewById(r17, R.id.custom_mode_global_vibrate);
        if (r8 == null) goto L29;
        r1 = R.id.custom_mode_mute;
        SettingItemSwitch r9 = (SettingItemSwitch) ViewBindings.findChildViewById(r17, R.id.custom_mode_mute);
        if (r9 == null) goto L29;
        r1 = R.id.custom_mode_protect_eyes;
        SettingItemSwitch r10 = (SettingItemSwitch) ViewBindings.findChildViewById(r17, R.id.custom_mode_protect_eyes);
        if (r10 == null) goto L29;
        r1 = R.id.custom_mode_read_mode;
        SettingItemSwitch r11 = (SettingItemSwitch) ViewBindings.findChildViewById(r17, R.id.custom_mode_read_mode);
        if (r11 == null) goto L29;
        r1 = R.id.custom_mode_screen_rotation;
        SettingItemSwitch r12 = (SettingItemSwitch) ViewBindings.findChildViewById(r17, R.id.custom_mode_screen_rotation);
        if (r12 == null) goto L29;
        r1 = R.id.custom_mode_telephony_vibrate;
        SettingItemSwitch r13 = (SettingItemSwitch) ViewBindings.findChildViewById(r17, R.id.custom_mode_telephony_vibrate);
        if (r13 == null) goto L29;
        r1 = R.id.side_dial_custom_mode_container;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.side_dial_custom_mode_container);
        if (r14 == null) goto L29;
        r1 = R.id.side_dial_details_container;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.side_dial_details_container);
        if (r15 == null) goto L29;
        r1 = R.id.view_title;
        OFloatingTitleBar r16 = (OFloatingTitleBar) ViewBindings.findChildViewById(r17, R.id.view_title);
        if (r16 == null) goto L29;
        return new SideDialCustomSettingLayoutBinding((RelativeLayout) r17, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r1)));
    }
}
