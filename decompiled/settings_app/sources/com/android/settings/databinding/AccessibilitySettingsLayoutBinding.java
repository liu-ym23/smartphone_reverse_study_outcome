package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilitySettingsLayoutBinding implements ViewBinding {
    public final LinearLayout accessibilityServices;
    public final OCardListItem backcoverCaribrition;
    public final OCardListItem bytedanceDesktopLeftScreen;
    public final View bytedanceDesktopLeftScreenGap;
    public final View gap;
    public final OCardListItem headsetCaribrition;
    public final OCardListItem idAccessibilityExpertiseSettings;
    public final OCardListItem idEarthquakeWarning;
    public final OCardListItem idPocketMode;
    public final OCardListItem idScheduledPowerOnAndOff;
    public final OCardListItem itemFontScale;
    public final View itemFontScaleGapBelow;
    public final OSectionSupportiveText itemUeLicence;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final OCardListItem preventWrongTouch;
    public final TextView preventWrongTouchTips;
    private final RelativeLayout rootView;
    public final LinearLayout sensorSwitcherContainer;
    public final LinearLayout servicesContainer;
    public final View shadowBelowAccessibility;
    public final View shadowBelowColorMode;
    public final View shadowBelowHeadsetCaribrition;
    public final View shadowBelowSmartDenoise;
    public final View shadowBelowTriggerSmartScreenMode;
    public final OCardListItem smartDenoise;
    public final OCardListItem triggerSmartScreenMode;
    public final OCardListItem ttsSettings;
    public final OCardListItem ueSwitch;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AccessibilitySettingsLayoutBinding(RelativeLayout r3, LinearLayout r4, OCardListItem r5, OCardListItem r6, View r7, View r8, OCardListItem r9, OCardListItem r10, OCardListItem r11, OCardListItem r12, OCardListItem r13, OCardListItem r14, View r15, OSectionSupportiveText r16, LinearLayout r17, OScrollView r18, OCardListItem r19, TextView r20, LinearLayout r21, LinearLayout r22, View r23, View r24, View r25, View r26, View r27, OCardListItem r28, OCardListItem r29, OCardListItem r30, OCardListItem r31, OFloatingTitleBar r32) {
        this.rootView = r3;
        this.accessibilityServices = r4;
        this.backcoverCaribrition = r5;
        this.bytedanceDesktopLeftScreen = r6;
        this.bytedanceDesktopLeftScreenGap = r7;
        this.gap = r8;
        this.headsetCaribrition = r9;
        this.idAccessibilityExpertiseSettings = r10;
        this.idEarthquakeWarning = r11;
        this.idPocketMode = r12;
        this.idScheduledPowerOnAndOff = r13;
        this.itemFontScale = r14;
        this.itemFontScaleGapBelow = r15;
        this.itemUeLicence = r16;
        this.pageContainer = r17;
        this.pageScrollview = r18;
        this.preventWrongTouch = r19;
        this.preventWrongTouchTips = r20;
        this.sensorSwitcherContainer = r21;
        this.servicesContainer = r22;
        this.shadowBelowAccessibility = r23;
        this.shadowBelowColorMode = r24;
        this.shadowBelowHeadsetCaribrition = r25;
        this.shadowBelowSmartDenoise = r26;
        this.shadowBelowTriggerSmartScreenMode = r27;
        this.smartDenoise = r28;
        this.triggerSmartScreenMode = r29;
        this.ttsSettings = r30;
        this.ueSwitch = r31;
        this.viewTitle = r32;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AccessibilitySettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AccessibilitySettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.accessibility_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AccessibilitySettingsLayoutBinding bind(View r34) {
        int r1 = R.id.accessibility_services;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r34, R.id.accessibility_services);
        if (r5 == null) goto L63;
        r1 = R.id.backcover_caribrition;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.backcover_caribrition);
        if (r6 == null) goto L63;
        r1 = R.id.bytedance_desktop_left_screen;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.bytedance_desktop_left_screen);
        if (r7 == null) goto L63;
        r1 = R.id.bytedance_desktop_left_screen_gap;
        View r8 = ViewBindings.findChildViewById(r34, R.id.bytedance_desktop_left_screen_gap);
        if (r8 == null) goto L63;
        r1 = R.id.gap;
        View r9 = ViewBindings.findChildViewById(r34, R.id.gap);
        if (r9 == null) goto L63;
        r1 = R.id.headset_caribrition;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.headset_caribrition);
        if (r10 == null) goto L63;
        r1 = R.id.id_accessibility_expertise_settings;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.id_accessibility_expertise_settings);
        if (r11 == null) goto L63;
        r1 = R.id.id_earthquake_warning;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.id_earthquake_warning);
        if (r12 == null) goto L63;
        r1 = R.id.id_pocket_mode;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.id_pocket_mode);
        if (r13 == null) goto L63;
        r1 = R.id.id_scheduled_power_on_and_off;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.id_scheduled_power_on_and_off);
        if (r14 == null) goto L63;
        r1 = R.id.item_font_scale;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.item_font_scale);
        if (r15 == null) goto L63;
        r1 = R.id.item_font_scale_gap_below;
        View r16 = ViewBindings.findChildViewById(r34, R.id.item_font_scale_gap_below);
        if (r16 == null) goto L63;
        r1 = R.id.item_ue_licence;
        OSectionSupportiveText r17 = (OSectionSupportiveText) ViewBindings.findChildViewById(r34, R.id.item_ue_licence);
        if (r17 == null) goto L63;
        r1 = R.id.page_container;
        LinearLayout r18 = (LinearLayout) ViewBindings.findChildViewById(r34, R.id.page_container);
        if (r18 == null) goto L63;
        r1 = R.id.page_scrollview;
        OScrollView r19 = (OScrollView) ViewBindings.findChildViewById(r34, R.id.page_scrollview);
        if (r19 == null) goto L63;
        r1 = R.id.prevent_wrong_touch;
        OCardListItem r20 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.prevent_wrong_touch);
        if (r20 == null) goto L63;
        r1 = R.id.prevent_wrong_touch_tips;
        TextView r21 = (TextView) ViewBindings.findChildViewById(r34, R.id.prevent_wrong_touch_tips);
        if (r21 == null) goto L63;
        r1 = R.id.sensor_switcher_container;
        LinearLayout r22 = (LinearLayout) ViewBindings.findChildViewById(r34, R.id.sensor_switcher_container);
        if (r22 == null) goto L63;
        r1 = R.id.services_container;
        LinearLayout r23 = (LinearLayout) ViewBindings.findChildViewById(r34, R.id.services_container);
        if (r23 == null) goto L63;
        r1 = R.id.shadow_below_accessibility;
        View r24 = ViewBindings.findChildViewById(r34, R.id.shadow_below_accessibility);
        if (r24 == null) goto L63;
        r1 = R.id.shadow_below_color_mode;
        View r25 = ViewBindings.findChildViewById(r34, R.id.shadow_below_color_mode);
        if (r25 == null) goto L63;
        r1 = R.id.shadow_below_headset_caribrition;
        View r26 = ViewBindings.findChildViewById(r34, R.id.shadow_below_headset_caribrition);
        if (r26 == null) goto L63;
        r1 = R.id.shadow_below_smart_denoise;
        View r27 = ViewBindings.findChildViewById(r34, R.id.shadow_below_smart_denoise);
        if (r27 == null) goto L63;
        r1 = R.id.shadow_below_trigger_smart_screen_mode;
        View r28 = ViewBindings.findChildViewById(r34, R.id.shadow_below_trigger_smart_screen_mode);
        if (r28 == null) goto L63;
        r1 = R.id.smart_denoise;
        OCardListItem r29 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.smart_denoise);
        if (r29 == null) goto L63;
        r1 = R.id.trigger_smart_screen_mode;
        OCardListItem r30 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.trigger_smart_screen_mode);
        if (r30 == null) goto L63;
        r1 = R.id.tts_settings;
        OCardListItem r31 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.tts_settings);
        if (r31 == null) goto L63;
        r1 = R.id.ue_switch;
        OCardListItem r32 = (OCardListItem) ViewBindings.findChildViewById(r34, R.id.ue_switch);
        if (r32 == null) goto L63;
        r1 = R.id.view_title;
        OFloatingTitleBar r33 = (OFloatingTitleBar) ViewBindings.findChildViewById(r34, R.id.view_title);
        if (r33 == null) goto L63;
        return new AccessibilitySettingsLayoutBinding((RelativeLayout) r34, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33);
    L63:
        throw new NullPointerException("Missing required view with ID: ".concat(r34.getResources().getResourceName(r1)));
    }
}
