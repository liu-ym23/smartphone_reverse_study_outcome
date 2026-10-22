package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ListContentItemCustom;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class HourlyChimeFragmentBinding implements ViewBinding {
    public final SettingItemText idAccessibilityHourlyChimeEnd;
    public final ListContentItemCustom idAccessibilityHourlyChimeInRing;
    public final RadioButton idAccessibilityHourlyChimeInRingRadio;
    public final ImageView idAccessibilityHourlyChimeInRingSetting;
    public final ListContentItemCustom idAccessibilityHourlyChimeInVibration;
    public final RadioButton idAccessibilityHourlyChimeInVibrationRadio;
    public final ListContentItemCustom idAccessibilityHourlyChimeInVoice;
    public final RadioButton idAccessibilityHourlyChimeInVoiceRadio;
    public final SettingItemText idAccessibilityHourlyChimeReportFrequency;
    public final SettingItemText idAccessibilityHourlyChimeStart;
    public final SettingItemSwitch idAccessibilityHourlyChimeSwitch;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final TextView title;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private HourlyChimeFragmentBinding(RelativeLayout r3, SettingItemText r4, ListContentItemCustom r5, RadioButton r6, ImageView r7, ListContentItemCustom r8, RadioButton r9, ListContentItemCustom r10, RadioButton r11, SettingItemText r12, SettingItemText r13, SettingItemSwitch r14, LinearLayout r15, OScrollView r16, TextView r17, OFloatingTitleBar r18) {
        this.rootView = r3;
        this.idAccessibilityHourlyChimeEnd = r4;
        this.idAccessibilityHourlyChimeInRing = r5;
        this.idAccessibilityHourlyChimeInRingRadio = r6;
        this.idAccessibilityHourlyChimeInRingSetting = r7;
        this.idAccessibilityHourlyChimeInVibration = r8;
        this.idAccessibilityHourlyChimeInVibrationRadio = r9;
        this.idAccessibilityHourlyChimeInVoice = r10;
        this.idAccessibilityHourlyChimeInVoiceRadio = r11;
        this.idAccessibilityHourlyChimeReportFrequency = r12;
        this.idAccessibilityHourlyChimeStart = r13;
        this.idAccessibilityHourlyChimeSwitch = r14;
        this.pageContainer = r15;
        this.pageScrollview = r16;
        this.title = r17;
        this.viewTitle = r18;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static HourlyChimeFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static HourlyChimeFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.hourly_chime_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static HourlyChimeFragmentBinding bind(View r20) {
        int r1 = R.id.id_accessibility_hourly_chime_end;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r20, R.id.id_accessibility_hourly_chime_end);
        if (r5 == null) goto L35;
        r1 = R.id.id_accessibility_hourly_chime_in_ring;
        ListContentItemCustom r6 = (ListContentItemCustom) ViewBindings.findChildViewById(r20, R.id.id_accessibility_hourly_chime_in_ring);
        if (r6 == null) goto L35;
        r1 = R.id.id_accessibility_hourly_chime_in_ring_radio;
        RadioButton r7 = (RadioButton) ViewBindings.findChildViewById(r20, R.id.id_accessibility_hourly_chime_in_ring_radio);
        if (r7 == null) goto L35;
        r1 = R.id.id_accessibility_hourly_chime_in_ring_setting;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r20, R.id.id_accessibility_hourly_chime_in_ring_setting);
        if (r8 == null) goto L35;
        r1 = R.id.id_accessibility_hourly_chime_in_vibration;
        ListContentItemCustom r9 = (ListContentItemCustom) ViewBindings.findChildViewById(r20, R.id.id_accessibility_hourly_chime_in_vibration);
        if (r9 == null) goto L35;
        r1 = R.id.id_accessibility_hourly_chime_in_vibration_radio;
        RadioButton r10 = (RadioButton) ViewBindings.findChildViewById(r20, R.id.id_accessibility_hourly_chime_in_vibration_radio);
        if (r10 == null) goto L35;
        r1 = R.id.id_accessibility_hourly_chime_in_voice;
        ListContentItemCustom r11 = (ListContentItemCustom) ViewBindings.findChildViewById(r20, R.id.id_accessibility_hourly_chime_in_voice);
        if (r11 == null) goto L35;
        r1 = R.id.id_accessibility_hourly_chime_in_voice_radio;
        RadioButton r12 = (RadioButton) ViewBindings.findChildViewById(r20, R.id.id_accessibility_hourly_chime_in_voice_radio);
        if (r12 == null) goto L35;
        r1 = R.id.id_accessibility_hourly_chime_report_frequency;
        SettingItemText r13 = (SettingItemText) ViewBindings.findChildViewById(r20, R.id.id_accessibility_hourly_chime_report_frequency);
        if (r13 == null) goto L35;
        r1 = R.id.id_accessibility_hourly_chime_start;
        SettingItemText r14 = (SettingItemText) ViewBindings.findChildViewById(r20, R.id.id_accessibility_hourly_chime_start);
        if (r14 == null) goto L35;
        r1 = R.id.id_accessibility_hourly_chime_switch;
        SettingItemSwitch r15 = (SettingItemSwitch) ViewBindings.findChildViewById(r20, R.id.id_accessibility_hourly_chime_switch);
        if (r15 == null) goto L35;
        r1 = R.id.page_container;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r20, R.id.page_container);
        if (r16 == null) goto L35;
        r1 = R.id.page_scrollview;
        OScrollView r17 = (OScrollView) ViewBindings.findChildViewById(r20, R.id.page_scrollview);
        if (r17 == null) goto L35;
        r1 = android.R.id.title;
        TextView r18 = (TextView) ViewBindings.findChildViewById(r20, android.R.id.title);
        if (r18 == null) goto L35;
        r1 = R.id.view_title;
        OFloatingTitleBar r19 = (OFloatingTitleBar) ViewBindings.findChildViewById(r20, R.id.view_title);
        if (r19 == null) goto L35;
        return new HourlyChimeFragmentBinding((RelativeLayout) r20, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r20.getResources().getResourceName(r1)));
    }
}
