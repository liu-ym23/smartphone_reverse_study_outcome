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
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class SideDialDetailsSettingLayoutBinding implements ViewBinding {
    public final SettingItemSwitch carModeAlwaysOnScreen;
    public final SettingItemSwitch carModeBluetooth;
    public final SettingItemText carModeNavigation;
    public final SettingItemSwitch carModeScreenRotation;
    private final RelativeLayout rootView;
    public final LinearLayout sideDialCarModeContainer;
    public final LinearLayout sideDialDetailsContainer;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SideDialDetailsSettingLayoutBinding(RelativeLayout r1, SettingItemSwitch r2, SettingItemSwitch r3, SettingItemText r4, SettingItemSwitch r5, LinearLayout r6, LinearLayout r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.carModeAlwaysOnScreen = r2;
        this.carModeBluetooth = r3;
        this.carModeNavigation = r4;
        this.carModeScreenRotation = r5;
        this.sideDialCarModeContainer = r6;
        this.sideDialDetailsContainer = r7;
        this.viewTitle = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SideDialDetailsSettingLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SideDialDetailsSettingLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.side_dial_details_setting_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SideDialDetailsSettingLayoutBinding bind(View r11) {
        int r0 = R.id.car_mode_always_on_screen;
        SettingItemSwitch r4 = (SettingItemSwitch) ViewBindings.findChildViewById(r11, R.id.car_mode_always_on_screen);
        if (r4 == null) goto L19;
        r0 = R.id.car_mode_bluetooth;
        SettingItemSwitch r5 = (SettingItemSwitch) ViewBindings.findChildViewById(r11, R.id.car_mode_bluetooth);
        if (r5 == null) goto L19;
        r0 = R.id.car_mode_navigation;
        SettingItemText r6 = (SettingItemText) ViewBindings.findChildViewById(r11, R.id.car_mode_navigation);
        if (r6 == null) goto L19;
        r0 = R.id.car_mode_screen_rotation;
        SettingItemSwitch r7 = (SettingItemSwitch) ViewBindings.findChildViewById(r11, R.id.car_mode_screen_rotation);
        if (r7 == null) goto L19;
        r0 = R.id.side_dial_car_mode_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.side_dial_car_mode_container);
        if (r8 == null) goto L19;
        r0 = R.id.side_dial_details_container;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.side_dial_details_container);
        if (r9 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r10 == null) goto L19;
        return new SideDialDetailsSettingLayoutBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
