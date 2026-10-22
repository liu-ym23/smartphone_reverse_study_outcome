package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class ShortcutsMenuBackSettingLayoutStubBinding implements ViewBinding {
    public final TextView bottomKeyHeaderView;
    public final SettingItemText itemMenuDown;
    public final SettingItemSwitch menu;
    public final TextView multiBlockTips;
    private final LinearLayout rootView;
    public final SettingItemSwitch torchSettings;
    public final LinearLayout voiceSettings;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ShortcutsMenuBackSettingLayoutStubBinding(LinearLayout r1, TextView r2, SettingItemText r3, SettingItemSwitch r4, TextView r5, SettingItemSwitch r6, LinearLayout r7) {
        this.rootView = r1;
        this.bottomKeyHeaderView = r2;
        this.itemMenuDown = r3;
        this.menu = r4;
        this.multiBlockTips = r5;
        this.torchSettings = r6;
        this.voiceSettings = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ShortcutsMenuBackSettingLayoutStubBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ShortcutsMenuBackSettingLayoutStubBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.shortcuts_menu_back_setting_layout_stub, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ShortcutsMenuBackSettingLayoutStubBinding bind(View r10) {
        int r0 = R.id.bottom_key_header_view;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, R.id.bottom_key_header_view);
        if (r4 == null) goto L17;
        r0 = R.id.item_menu_down;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r10, R.id.item_menu_down);
        if (r5 == null) goto L17;
        r0 = R.id.menu;
        SettingItemSwitch r6 = (SettingItemSwitch) ViewBindings.findChildViewById(r10, R.id.menu);
        if (r6 == null) goto L17;
        r0 = R.id.multi_block_tips;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r10, R.id.multi_block_tips);
        if (r7 == null) goto L17;
        r0 = R.id.torch_settings;
        SettingItemSwitch r8 = (SettingItemSwitch) ViewBindings.findChildViewById(r10, R.id.torch_settings);
        if (r8 == null) goto L17;
        r0 = R.id.voice_settings;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.voice_settings);
        if (r9 == null) goto L17;
        return new ShortcutsMenuBackSettingLayoutStubBinding((LinearLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
