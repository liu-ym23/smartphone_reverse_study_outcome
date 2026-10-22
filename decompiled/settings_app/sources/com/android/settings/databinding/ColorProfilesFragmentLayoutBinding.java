package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingItemButton;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ListContentItemCustom;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class ColorProfilesFragmentLayoutBinding implements ViewBinding {
    public final SeekBar calibrationBar;
    public final TextView colorProfilesCold;
    public final TextView colorProfilesWarm;
    public final ListContentItemCustom idColorProfileOverview;
    public final TextView idColorProfilesEyeProtection;
    public final TextView idTipsColorProfiles;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final SettingItemButton resetBtn;
    private final RelativeLayout rootView;
    public final SettingItemSwitch switchAutoColorProfile;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ColorProfilesFragmentLayoutBinding(RelativeLayout r1, SeekBar r2, TextView r3, TextView r4, ListContentItemCustom r5, TextView r6, TextView r7, LinearLayout r8, OScrollView r9, SettingItemButton r10, SettingItemSwitch r11, OFloatingTitleBar r12) {
        this.rootView = r1;
        this.calibrationBar = r2;
        this.colorProfilesCold = r3;
        this.colorProfilesWarm = r4;
        this.idColorProfileOverview = r5;
        this.idColorProfilesEyeProtection = r6;
        this.idTipsColorProfiles = r7;
        this.pageContainer = r8;
        this.pageScrollview = r9;
        this.resetBtn = r10;
        this.switchAutoColorProfile = r11;
        this.viewTitle = r12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ColorProfilesFragmentLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ColorProfilesFragmentLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.color_profiles_fragment_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ColorProfilesFragmentLayoutBinding bind(View r15) {
        int r0 = R.id.calibration_bar;
        SeekBar r4 = (SeekBar) ViewBindings.findChildViewById(r15, R.id.calibration_bar);
        if (r4 == null) goto L27;
        r0 = R.id.color_profiles_cold;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r15, R.id.color_profiles_cold);
        if (r5 == null) goto L27;
        r0 = R.id.color_profiles_warm;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r15, R.id.color_profiles_warm);
        if (r6 == null) goto L27;
        r0 = R.id.id_color_profile_overview;
        ListContentItemCustom r7 = (ListContentItemCustom) ViewBindings.findChildViewById(r15, R.id.id_color_profile_overview);
        if (r7 == null) goto L27;
        r0 = R.id.id_color_profiles_eye_protection;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r15, R.id.id_color_profiles_eye_protection);
        if (r8 == null) goto L27;
        r0 = R.id.id_tips_color_profiles;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r15, R.id.id_tips_color_profiles);
        if (r9 == null) goto L27;
        r0 = R.id.page_container;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.page_container);
        if (r10 == null) goto L27;
        r0 = R.id.page_scrollview;
        OScrollView r11 = (OScrollView) ViewBindings.findChildViewById(r15, R.id.page_scrollview);
        if (r11 == null) goto L27;
        r0 = R.id.reset_btn;
        SettingItemButton r12 = (SettingItemButton) ViewBindings.findChildViewById(r15, R.id.reset_btn);
        if (r12 == null) goto L27;
        r0 = R.id.switch_auto_color_profile;
        SettingItemSwitch r13 = (SettingItemSwitch) ViewBindings.findChildViewById(r15, R.id.switch_auto_color_profile);
        if (r13 == null) goto L27;
        r0 = R.id.view_title;
        OFloatingTitleBar r14 = (OFloatingTitleBar) ViewBindings.findChildViewById(r15, R.id.view_title);
        if (r14 == null) goto L27;
        return new ColorProfilesFragmentLayoutBinding((RelativeLayout) r15, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    }
}
