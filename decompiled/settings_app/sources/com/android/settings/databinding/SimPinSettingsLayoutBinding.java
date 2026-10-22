package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class SimPinSettingsLayoutBinding implements ViewBinding {
    public final SettingItemSwitch itemEnablePin;
    public final SettingItemText itemModifyPin;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SimPinSettingsLayoutBinding(RelativeLayout r1, SettingItemSwitch r2, SettingItemText r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.itemEnablePin = r2;
        this.itemModifyPin = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SimPinSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SimPinSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.sim_pin_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SimPinSettingsLayoutBinding bind(View r4) {
        int r0 = R.id.item_enable_pin;
        SettingItemSwitch r1 = (SettingItemSwitch) ViewBindings.findChildViewById(r4, R.id.item_enable_pin);
        if (r1 == null) goto L11;
        r0 = R.id.item_modify_pin;
        SettingItemText r2 = (SettingItemText) ViewBindings.findChildViewById(r4, R.id.item_modify_pin);
        if (r2 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r3 == null) goto L11;
        return new SimPinSettingsLayoutBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
