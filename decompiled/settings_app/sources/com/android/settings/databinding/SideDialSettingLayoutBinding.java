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
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class SideDialSettingLayoutBinding implements ViewBinding {
    public final SettingItemCheckSimpleText idSideCustom;
    public final SettingItemCheckSimpleText idSideDialCarMode;
    public final SettingItemCheckSimpleText idSideDialCleanMode;
    public final SettingItemCheckSimpleText idSideDialCreativeCapsule;
    public final SettingItemCheckSimpleText idSideDialMute;
    public final SettingItemCheckSimpleText idSideDialWirelessMode;
    private final RelativeLayout rootView;
    public final LinearLayout sideDialContainer;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SideDialSettingLayoutBinding(RelativeLayout r1, SettingItemCheckSimpleText r2, SettingItemCheckSimpleText r3, SettingItemCheckSimpleText r4, SettingItemCheckSimpleText r5, SettingItemCheckSimpleText r6, SettingItemCheckSimpleText r7, LinearLayout r8, OFloatingTitleBar r9) {
        this.rootView = r1;
        this.idSideCustom = r2;
        this.idSideDialCarMode = r3;
        this.idSideDialCleanMode = r4;
        this.idSideDialCreativeCapsule = r5;
        this.idSideDialMute = r6;
        this.idSideDialWirelessMode = r7;
        this.sideDialContainer = r8;
        this.viewTitle = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SideDialSettingLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SideDialSettingLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.side_dial_setting_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SideDialSettingLayoutBinding bind(View r12) {
        int r0 = R.id.id_side_custom;
        SettingItemCheckSimpleText r4 = (SettingItemCheckSimpleText) ViewBindings.findChildViewById(r12, R.id.id_side_custom);
        if (r4 == null) goto L21;
        r0 = R.id.id_side_dial_car_mode;
        SettingItemCheckSimpleText r5 = (SettingItemCheckSimpleText) ViewBindings.findChildViewById(r12, R.id.id_side_dial_car_mode);
        if (r5 == null) goto L21;
        r0 = R.id.id_side_dial_clean_mode;
        SettingItemCheckSimpleText r6 = (SettingItemCheckSimpleText) ViewBindings.findChildViewById(r12, R.id.id_side_dial_clean_mode);
        if (r6 == null) goto L21;
        r0 = R.id.id_side_dial_creative_capsule;
        SettingItemCheckSimpleText r7 = (SettingItemCheckSimpleText) ViewBindings.findChildViewById(r12, R.id.id_side_dial_creative_capsule);
        if (r7 == null) goto L21;
        r0 = R.id.id_side_dial_mute;
        SettingItemCheckSimpleText r8 = (SettingItemCheckSimpleText) ViewBindings.findChildViewById(r12, R.id.id_side_dial_mute);
        if (r8 == null) goto L21;
        r0 = R.id.id_side_dial_wireless_mode;
        SettingItemCheckSimpleText r9 = (SettingItemCheckSimpleText) ViewBindings.findChildViewById(r12, R.id.id_side_dial_wireless_mode);
        if (r9 == null) goto L21;
        r0 = R.id.side_dial_container;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r12, R.id.side_dial_container);
        if (r10 == null) goto L21;
        r0 = R.id.view_title;
        OFloatingTitleBar r11 = (OFloatingTitleBar) ViewBindings.findChildViewById(r12, R.id.view_title);
        if (r11 == null) goto L21;
        return new SideDialSettingLayoutBinding((RelativeLayout) r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
