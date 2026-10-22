package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.slider.OSlider;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class BrightnessSettingBinding implements ViewBinding {
    public final OUILinearLayout brightnessContainer;
    public final OSlider brightnessSeekbar;
    public final OCardListItem dcDimming;
    public final OCardListItem doubleTapToSleep;
    public final OCardListItem dozeMode;
    public final OCardListItem itemAutoLockScreenTime;
    public final OCardListItem itemDisplayMode;
    public final OCardListItem itemDisplaySize;
    public final OCardListItem itemFontScale;
    public final OListItemSettings itemLockScreenChargingAnimation;
    public final OCardListItem itemProtectEyes;
    public final OCardListItem itemScreenColorTemperature;
    public final OCardListItem itemScreenRefreshRate;
    public final OCardListItem itemScreenResolution;
    public final OCardListItem itemScreenSaver;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OCardListItem singleClickWakeScreen;
    public final OCardListItem switchAdaptiveSleep;
    public final OCardListItem switchAutoBrightness;
    public final OCardListItem switchAutoRotation;
    public final OCardListItem switchDozeModeWakeScreen;
    public final OCardListItem switchLightPickUp;
    public final OTextView tvContentTitle;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BrightnessSettingBinding(RelativeLayout r3, OUILinearLayout r4, OSlider r5, OCardListItem r6, OCardListItem r7, OCardListItem r8, OCardListItem r9, OCardListItem r10, OCardListItem r11, OCardListItem r12, OListItemSettings r13, OCardListItem r14, OCardListItem r15, OCardListItem r16, OCardListItem r17, OCardListItem r18, LinearLayout r19, OScrollView r20, OCardListItem r21, OCardListItem r22, OCardListItem r23, OCardListItem r24, OCardListItem r25, OCardListItem r26, OTextView r27, OFloatingTitleBar r28) {
        this.rootView = r3;
        this.brightnessContainer = r4;
        this.brightnessSeekbar = r5;
        this.dcDimming = r6;
        this.doubleTapToSleep = r7;
        this.dozeMode = r8;
        this.itemAutoLockScreenTime = r9;
        this.itemDisplayMode = r10;
        this.itemDisplaySize = r11;
        this.itemFontScale = r12;
        this.itemLockScreenChargingAnimation = r13;
        this.itemProtectEyes = r14;
        this.itemScreenColorTemperature = r15;
        this.itemScreenRefreshRate = r16;
        this.itemScreenResolution = r17;
        this.itemScreenSaver = r18;
        this.pageContainer = r19;
        this.pageScrollview = r20;
        this.singleClickWakeScreen = r21;
        this.switchAdaptiveSleep = r22;
        this.switchAutoBrightness = r23;
        this.switchAutoRotation = r24;
        this.switchDozeModeWakeScreen = r25;
        this.switchLightPickUp = r26;
        this.tvContentTitle = r27;
        this.viewTitle = r28;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BrightnessSettingBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BrightnessSettingBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.brightness_setting, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BrightnessSettingBinding bind(View r30) {
        int r1 = R.id.brightness_container;
        OUILinearLayout r5 = (OUILinearLayout) ViewBindings.findChildViewById(r30, R.id.brightness_container);
        if (r5 == null) goto L55;
        r1 = R.id.brightness_seekbar;
        OSlider r6 = (OSlider) ViewBindings.findChildViewById(r30, R.id.brightness_seekbar);
        if (r6 == null) goto L55;
        r1 = R.id.dc_dimming;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.dc_dimming);
        if (r7 == null) goto L55;
        r1 = R.id.double_tap_to_sleep;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.double_tap_to_sleep);
        if (r8 == null) goto L55;
        r1 = R.id.doze_mode;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.doze_mode);
        if (r9 == null) goto L55;
        r1 = R.id.item_auto_lock_screen_time;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.item_auto_lock_screen_time);
        if (r10 == null) goto L55;
        r1 = R.id.item_display_mode;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.item_display_mode);
        if (r11 == null) goto L55;
        r1 = R.id.item_display_size;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.item_display_size);
        if (r12 == null) goto L55;
        r1 = R.id.item_font_scale;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.item_font_scale);
        if (r13 == null) goto L55;
        r1 = R.id.item_lock_screen_charging_animation;
        OListItemSettings r14 = (OListItemSettings) ViewBindings.findChildViewById(r30, R.id.item_lock_screen_charging_animation);
        if (r14 == null) goto L55;
        r1 = R.id.item_protect_eyes;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.item_protect_eyes);
        if (r15 == null) goto L55;
        r1 = R.id.item_screen_color_temperature;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.item_screen_color_temperature);
        if (r16 == null) goto L55;
        r1 = R.id.item_screen_refresh_rate;
        OCardListItem r17 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.item_screen_refresh_rate);
        if (r17 == null) goto L55;
        r1 = R.id.item_screen_resolution;
        OCardListItem r18 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.item_screen_resolution);
        if (r18 == null) goto L55;
        r1 = R.id.item_screen_saver;
        OCardListItem r19 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.item_screen_saver);
        if (r19 == null) goto L55;
        r1 = R.id.page_container;
        LinearLayout r20 = (LinearLayout) ViewBindings.findChildViewById(r30, R.id.page_container);
        if (r20 == null) goto L55;
        r1 = R.id.page_scrollview;
        OScrollView r21 = (OScrollView) ViewBindings.findChildViewById(r30, R.id.page_scrollview);
        if (r21 == null) goto L55;
        r1 = R.id.single_click_wake_screen;
        OCardListItem r22 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.single_click_wake_screen);
        if (r22 == null) goto L55;
        r1 = R.id.switch_adaptive_sleep;
        OCardListItem r23 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.switch_adaptive_sleep);
        if (r23 == null) goto L55;
        r1 = R.id.switch_auto_brightness;
        OCardListItem r24 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.switch_auto_brightness);
        if (r24 == null) goto L55;
        r1 = R.id.switch_auto_rotation;
        OCardListItem r25 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.switch_auto_rotation);
        if (r25 == null) goto L55;
        r1 = R.id.switch_doze_mode_wake_screen;
        OCardListItem r26 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.switch_doze_mode_wake_screen);
        if (r26 == null) goto L55;
        r1 = R.id.switch_light_pick_up;
        OCardListItem r27 = (OCardListItem) ViewBindings.findChildViewById(r30, R.id.switch_light_pick_up);
        if (r27 == null) goto L55;
        r1 = R.id.tv_content_title;
        OTextView r28 = (OTextView) ViewBindings.findChildViewById(r30, R.id.tv_content_title);
        if (r28 == null) goto L55;
        r1 = R.id.view_title;
        OFloatingTitleBar r29 = (OFloatingTitleBar) ViewBindings.findChildViewById(r30, R.id.view_title);
        if (r29 == null) goto L55;
        return new BrightnessSettingBinding((RelativeLayout) r30, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29);
    L55:
        throw new NullPointerException("Missing required view with ID: ".concat(r30.getResources().getResourceName(r1)));
    }
}
