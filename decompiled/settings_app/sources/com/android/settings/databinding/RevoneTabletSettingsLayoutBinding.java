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
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;
import obric.widget.SliderWithIcons;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneTabletSettingsLayoutBinding implements ViewBinding {
    public final SliderWithIcons brightnessSeekbar;
    public final SettingItemSwitch cursorWaterDrop;
    public final SettingItemText customKeyboard;
    public final SettingItemText displaySettings;
    public final SettingItemText idRecognizeLang;
    public final SettingItemText itemAutoLockScreenTime;
    public final SettingItemText itemProtectEyes;
    public final SettingItemText mouseKeyMode;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final SettingItemText shortcutBtn;
    public final SettingItemText sightTracking;
    public final SettingItemSwitch switchAutoBrightness;
    public final OFloatingTitleBar viewTitle;
    public final SettingItemSwitch voiceWaterDrop;
    public final SettingItemText wallpaperSettings;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneTabletSettingsLayoutBinding(RelativeLayout r3, SliderWithIcons r4, SettingItemSwitch r5, SettingItemText r6, SettingItemText r7, SettingItemText r8, SettingItemText r9, SettingItemText r10, SettingItemText r11, LinearLayout r12, OScrollView r13, SettingItemText r14, SettingItemText r15, SettingItemSwitch r16, OFloatingTitleBar r17, SettingItemSwitch r18, SettingItemText r19) {
        this.rootView = r3;
        this.brightnessSeekbar = r4;
        this.cursorWaterDrop = r5;
        this.customKeyboard = r6;
        this.displaySettings = r7;
        this.idRecognizeLang = r8;
        this.itemAutoLockScreenTime = r9;
        this.itemProtectEyes = r10;
        this.mouseKeyMode = r11;
        this.pageContainer = r12;
        this.pageScrollview = r13;
        this.shortcutBtn = r14;
        this.sightTracking = r15;
        this.switchAutoBrightness = r16;
        this.viewTitle = r17;
        this.voiceWaterDrop = r18;
        this.wallpaperSettings = r19;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RevoneTabletSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneTabletSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_tablet_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneTabletSettingsLayoutBinding bind(View r21) {
        int r1 = R.id.brightness_seekbar;
        SliderWithIcons r5 = (SliderWithIcons) ViewBindings.findChildViewById(r21, R.id.brightness_seekbar);
        if (r5 == null) goto L37;
        r1 = R.id.cursor_water_drop;
        SettingItemSwitch r6 = (SettingItemSwitch) ViewBindings.findChildViewById(r21, R.id.cursor_water_drop);
        if (r6 == null) goto L37;
        r1 = R.id.custom_keyboard;
        SettingItemText r7 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.custom_keyboard);
        if (r7 == null) goto L37;
        r1 = R.id.display_settings;
        SettingItemText r8 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.display_settings);
        if (r8 == null) goto L37;
        r1 = R.id.id_recognize_lang;
        SettingItemText r9 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.id_recognize_lang);
        if (r9 == null) goto L37;
        r1 = R.id.item_auto_lock_screen_time;
        SettingItemText r10 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.item_auto_lock_screen_time);
        if (r10 == null) goto L37;
        r1 = R.id.item_protect_eyes;
        SettingItemText r11 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.item_protect_eyes);
        if (r11 == null) goto L37;
        r1 = R.id.mouse_key_mode;
        SettingItemText r12 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.mouse_key_mode);
        if (r12 == null) goto L37;
        r1 = R.id.page_container;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r21, R.id.page_container);
        if (r13 == null) goto L37;
        r1 = R.id.page_scrollview;
        OScrollView r14 = (OScrollView) ViewBindings.findChildViewById(r21, R.id.page_scrollview);
        if (r14 == null) goto L37;
        r1 = R.id.shortcut_btn;
        SettingItemText r15 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.shortcut_btn);
        if (r15 == null) goto L37;
        r1 = R.id.sight_tracking;
        SettingItemText r16 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.sight_tracking);
        if (r16 == null) goto L37;
        r1 = R.id.switch_auto_brightness;
        SettingItemSwitch r17 = (SettingItemSwitch) ViewBindings.findChildViewById(r21, R.id.switch_auto_brightness);
        if (r17 == null) goto L37;
        r1 = R.id.view_title;
        OFloatingTitleBar r18 = (OFloatingTitleBar) ViewBindings.findChildViewById(r21, R.id.view_title);
        if (r18 == null) goto L37;
        r1 = R.id.voice_water_drop;
        SettingItemSwitch r19 = (SettingItemSwitch) ViewBindings.findChildViewById(r21, R.id.voice_water_drop);
        if (r19 == null) goto L37;
        r1 = R.id.wallpaper_settings;
        SettingItemText r20 = (SettingItemText) ViewBindings.findChildViewById(r21, R.id.wallpaper_settings);
        if (r20 == null) goto L37;
        return new RevoneTabletSettingsLayoutBinding((RelativeLayout) r21, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r21.getResources().getResourceName(r1)));
    }
}
