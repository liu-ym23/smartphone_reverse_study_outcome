package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingItemCheckSimpleText;
import com.android.settings.widget.TickMarkView;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class TntKeyboardSettingsBinding implements ViewBinding {
    public final SettingItemText fFunctionalKeys;
    public final GroupListItemVerticalGapLayoutBinding fFunctionalKeysGapLayout;
    public final SettingItemText idKeyboardDialogDefaultLocationSetting;
    public final SettingItemText idKeyboardInputmethodBytedance;
    public final SettingItemSwitch idSecurityKeyboard;
    public final View idSecurityKeyboardGap;
    public final SettingItemCheckSimpleText itemCheckCloseScreen;
    public final SettingItemCheckSimpleText itemCheckNone;
    public final SettingItemCheckSimpleText itemCheckStartApp;
    public final SettingItemCheckSimpleText keyboardPreferenceMac;
    public final SettingItemCheckSimpleText keyboardPreferenceWindows;
    public final TickMarkView keyboardRepeatDelay;
    public final TickMarkView keyboardRepeatInterval;
    public final SettingItemText keyboardStyle;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final SettingItemText recognizeLanguage;
    private final RelativeLayout rootView;
    public final SettingItemSwitch traditionalChineseInput;
    public final OFloatingTitleBar viewTitle;
    public final SettingItemSwitch virtualKeyboardPopupSwitch;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TntKeyboardSettingsBinding(RelativeLayout r3, SettingItemText r4, GroupListItemVerticalGapLayoutBinding r5, SettingItemText r6, SettingItemText r7, SettingItemSwitch r8, View r9, SettingItemCheckSimpleText r10, SettingItemCheckSimpleText r11, SettingItemCheckSimpleText r12, SettingItemCheckSimpleText r13, SettingItemCheckSimpleText r14, TickMarkView r15, TickMarkView r16, SettingItemText r17, LinearLayout r18, OScrollView r19, SettingItemText r20, SettingItemSwitch r21, OFloatingTitleBar r22, SettingItemSwitch r23) {
        this.rootView = r3;
        this.fFunctionalKeys = r4;
        this.fFunctionalKeysGapLayout = r5;
        this.idKeyboardDialogDefaultLocationSetting = r6;
        this.idKeyboardInputmethodBytedance = r7;
        this.idSecurityKeyboard = r8;
        this.idSecurityKeyboardGap = r9;
        this.itemCheckCloseScreen = r10;
        this.itemCheckNone = r11;
        this.itemCheckStartApp = r12;
        this.keyboardPreferenceMac = r13;
        this.keyboardPreferenceWindows = r14;
        this.keyboardRepeatDelay = r15;
        this.keyboardRepeatInterval = r16;
        this.keyboardStyle = r17;
        this.pageContainer = r18;
        this.pageScrollview = r19;
        this.recognizeLanguage = r20;
        this.traditionalChineseInput = r21;
        this.viewTitle = r22;
        this.virtualKeyboardPopupSwitch = r23;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TntKeyboardSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TntKeyboardSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.tnt_keyboard_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TntKeyboardSettingsBinding bind(View r25) {
        int r1 = R.id.f_functional_keys;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r25, R.id.f_functional_keys);
        if (r5 == null) goto L45;
        r1 = R.id.f_functional_keys_gap_layout;
        View r2 = ViewBindings.findChildViewById(r25, R.id.f_functional_keys_gap_layout);
        if (r2 == null) goto L45;
        GroupListItemVerticalGapLayoutBinding r6 = GroupListItemVerticalGapLayoutBinding.bind(r2);
        r1 = R.id.id_keyboard_dialog_default_location_setting;
        SettingItemText r7 = (SettingItemText) ViewBindings.findChildViewById(r25, R.id.id_keyboard_dialog_default_location_setting);
        if (r7 == null) goto L45;
        r1 = R.id.id_keyboard_inputmethod_bytedance;
        SettingItemText r8 = (SettingItemText) ViewBindings.findChildViewById(r25, R.id.id_keyboard_inputmethod_bytedance);
        if (r8 == null) goto L45;
        r1 = R.id.id_security_keyboard;
        SettingItemSwitch r9 = (SettingItemSwitch) ViewBindings.findChildViewById(r25, R.id.id_security_keyboard);
        if (r9 == null) goto L45;
        r1 = R.id.id_security_keyboard_gap;
        View r10 = ViewBindings.findChildViewById(r25, R.id.id_security_keyboard_gap);
        if (r10 == null) goto L45;
        r1 = R.id.item_check_close_screen;
        SettingItemCheckSimpleText r11 = (SettingItemCheckSimpleText) ViewBindings.findChildViewById(r25, R.id.item_check_close_screen);
        if (r11 == null) goto L45;
        r1 = R.id.item_check_none;
        SettingItemCheckSimpleText r12 = (SettingItemCheckSimpleText) ViewBindings.findChildViewById(r25, R.id.item_check_none);
        if (r12 == null) goto L45;
        r1 = R.id.item_check_start_app;
        SettingItemCheckSimpleText r13 = (SettingItemCheckSimpleText) ViewBindings.findChildViewById(r25, R.id.item_check_start_app);
        if (r13 == null) goto L45;
        r1 = R.id.keyboard_preference_mac;
        SettingItemCheckSimpleText r14 = (SettingItemCheckSimpleText) ViewBindings.findChildViewById(r25, R.id.keyboard_preference_mac);
        if (r14 == null) goto L45;
        r1 = R.id.keyboard_preference_windows;
        SettingItemCheckSimpleText r15 = (SettingItemCheckSimpleText) ViewBindings.findChildViewById(r25, R.id.keyboard_preference_windows);
        if (r15 == null) goto L45;
        r1 = R.id.keyboard_repeat_delay;
        TickMarkView r16 = (TickMarkView) ViewBindings.findChildViewById(r25, R.id.keyboard_repeat_delay);
        if (r16 == null) goto L45;
        r1 = R.id.keyboard_repeat_interval;
        TickMarkView r17 = (TickMarkView) ViewBindings.findChildViewById(r25, R.id.keyboard_repeat_interval);
        if (r17 == null) goto L45;
        r1 = R.id.keyboard_style;
        SettingItemText r18 = (SettingItemText) ViewBindings.findChildViewById(r25, R.id.keyboard_style);
        if (r18 == null) goto L45;
        r1 = R.id.page_container;
        LinearLayout r19 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.page_container);
        if (r19 == null) goto L45;
        r1 = R.id.page_scrollview;
        OScrollView r20 = (OScrollView) ViewBindings.findChildViewById(r25, R.id.page_scrollview);
        if (r20 == null) goto L45;
        r1 = R.id.recognize_language;
        SettingItemText r21 = (SettingItemText) ViewBindings.findChildViewById(r25, R.id.recognize_language);
        if (r21 == null) goto L45;
        r1 = R.id.traditional_chinese_input;
        SettingItemSwitch r22 = (SettingItemSwitch) ViewBindings.findChildViewById(r25, R.id.traditional_chinese_input);
        if (r22 == null) goto L45;
        r1 = R.id.view_title;
        OFloatingTitleBar r23 = (OFloatingTitleBar) ViewBindings.findChildViewById(r25, R.id.view_title);
        if (r23 == null) goto L45;
        r1 = R.id.virtual_keyboard_popup_switch;
        SettingItemSwitch r24 = (SettingItemSwitch) ViewBindings.findChildViewById(r25, R.id.virtual_keyboard_popup_switch);
        if (r24 == null) goto L45;
        return new TntKeyboardSettingsBinding((RelativeLayout) r25, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    L45:
        throw new NullPointerException("Missing required view with ID: ".concat(r25.getResources().getResourceName(r1)));
    }
}
