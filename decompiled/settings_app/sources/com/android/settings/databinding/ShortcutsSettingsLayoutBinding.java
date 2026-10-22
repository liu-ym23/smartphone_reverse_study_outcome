package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class ShortcutsSettingsLayoutBinding implements ViewBinding {
    public final ViewStub homeKeyLongPressSettings;
    public final ViewStub menuBackKeySettings;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final SettingItemSwitch powerKeyFunction;
    private final RelativeLayout rootView;
    public final ViewStub sidekeySettingsContainer;
    public final ViewStub smartKeySettings;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ShortcutsSettingsLayoutBinding(RelativeLayout r1, ViewStub r2, ViewStub r3, LinearLayout r4, OScrollView r5, SettingItemSwitch r6, ViewStub r7, ViewStub r8, OFloatingTitleBar r9) {
        this.rootView = r1;
        this.homeKeyLongPressSettings = r2;
        this.menuBackKeySettings = r3;
        this.pageContainer = r4;
        this.pageScrollview = r5;
        this.powerKeyFunction = r6;
        this.sidekeySettingsContainer = r7;
        this.smartKeySettings = r8;
        this.viewTitle = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ShortcutsSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ShortcutsSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.shortcuts_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ShortcutsSettingsLayoutBinding bind(View r12) {
        int r0 = R.id.home_key_long_press_settings;
        ViewStub r4 = (ViewStub) ViewBindings.findChildViewById(r12, R.id.home_key_long_press_settings);
        if (r4 == null) goto L21;
        r0 = R.id.menu_back_key_settings;
        ViewStub r5 = (ViewStub) ViewBindings.findChildViewById(r12, R.id.menu_back_key_settings);
        if (r5 == null) goto L21;
        r0 = R.id.page_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r12, R.id.page_container);
        if (r6 == null) goto L21;
        r0 = R.id.page_scrollview;
        OScrollView r7 = (OScrollView) ViewBindings.findChildViewById(r12, R.id.page_scrollview);
        if (r7 == null) goto L21;
        r0 = R.id.power_key_function;
        SettingItemSwitch r8 = (SettingItemSwitch) ViewBindings.findChildViewById(r12, R.id.power_key_function);
        if (r8 == null) goto L21;
        r0 = R.id.sidekey_settings_container;
        ViewStub r9 = (ViewStub) ViewBindings.findChildViewById(r12, R.id.sidekey_settings_container);
        if (r9 == null) goto L21;
        r0 = R.id.smart_key_settings;
        ViewStub r10 = (ViewStub) ViewBindings.findChildViewById(r12, R.id.smart_key_settings);
        if (r10 == null) goto L21;
        r0 = R.id.view_title;
        OFloatingTitleBar r11 = (OFloatingTitleBar) ViewBindings.findChildViewById(r12, R.id.view_title);
        if (r11 == null) goto L21;
        return new ShortcutsSettingsLayoutBinding((RelativeLayout) r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
