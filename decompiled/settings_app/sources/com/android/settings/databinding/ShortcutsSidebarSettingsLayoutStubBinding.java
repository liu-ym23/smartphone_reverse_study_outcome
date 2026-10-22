package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class ShortcutsSidebarSettingsLayoutStubBinding implements ViewBinding {
    public final SettingItemSwitch oneStepSwitcher;
    public final TextView oneStepTips;
    public final ImageView oppositeImage;
    public final SettingItemText oppositeKey;
    private final LinearLayout rootView;
    public final TextView sideKeyHeaderView;
    public final LinearLayout sidekeySettingsContainer;
    public final ImageView squeezingImage;
    public final SettingItemText squeezingKey;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ShortcutsSidebarSettingsLayoutStubBinding(LinearLayout r1, SettingItemSwitch r2, TextView r3, ImageView r4, SettingItemText r5, TextView r6, LinearLayout r7, ImageView r8, SettingItemText r9) {
        this.rootView = r1;
        this.oneStepSwitcher = r2;
        this.oneStepTips = r3;
        this.oppositeImage = r4;
        this.oppositeKey = r5;
        this.sideKeyHeaderView = r6;
        this.sidekeySettingsContainer = r7;
        this.squeezingImage = r8;
        this.squeezingKey = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ShortcutsSidebarSettingsLayoutStubBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ShortcutsSidebarSettingsLayoutStubBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.shortcuts_sidebar_settings_layout_stub, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ShortcutsSidebarSettingsLayoutStubBinding bind(View r12) {
        int r0 = R.id.one_step_switcher;
        SettingItemSwitch r4 = (SettingItemSwitch) ViewBindings.findChildViewById(r12, R.id.one_step_switcher);
        if (r4 == null) goto L19;
        r0 = R.id.one_step_tips;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r12, R.id.one_step_tips);
        if (r5 == null) goto L19;
        r0 = R.id.opposite_image;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r12, R.id.opposite_image);
        if (r6 == null) goto L19;
        r0 = R.id.opposite_key;
        SettingItemText r7 = (SettingItemText) ViewBindings.findChildViewById(r12, R.id.opposite_key);
        if (r7 == null) goto L19;
        r0 = R.id.side_key_header_view;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r12, R.id.side_key_header_view);
        if (r8 == null) goto L19;
        LinearLayout r9 = (LinearLayout) r12;
        r0 = R.id.squeezing_image;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r12, R.id.squeezing_image);
        if (r10 == null) goto L19;
        r0 = R.id.squeezing_key;
        SettingItemText r11 = (SettingItemText) ViewBindings.findChildViewById(r12, R.id.squeezing_key);
        if (r11 == null) goto L19;
        return new ShortcutsSidebarSettingsLayoutStubBinding(r9, r4, r5, r6, r7, r8, r9, r10, r11);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
