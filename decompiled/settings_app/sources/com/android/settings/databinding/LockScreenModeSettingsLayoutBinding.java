package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class LockScreenModeSettingsLayoutBinding implements ViewBinding {
    public final SettingItemText itemModeNone;
    public final SettingItemText itemModePasswordEasy;
    public final SettingItemText itemModePasswordHard;
    public final SettingItemText itemModePattern;
    public final LinearLayout modeList;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LockScreenModeSettingsLayoutBinding(RelativeLayout r1, SettingItemText r2, SettingItemText r3, SettingItemText r4, SettingItemText r5, LinearLayout r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.itemModeNone = r2;
        this.itemModePasswordEasy = r3;
        this.itemModePasswordHard = r4;
        this.itemModePattern = r5;
        this.modeList = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LockScreenModeSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LockScreenModeSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.lock_screen_mode_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LockScreenModeSettingsLayoutBinding bind(View r10) {
        int r0 = R.id.item_mode_none;
        SettingItemText r4 = (SettingItemText) ViewBindings.findChildViewById(r10, R.id.item_mode_none);
        if (r4 == null) goto L17;
        r0 = R.id.item_mode_password_easy;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r10, R.id.item_mode_password_easy);
        if (r5 == null) goto L17;
        r0 = R.id.item_mode_password_hard;
        SettingItemText r6 = (SettingItemText) ViewBindings.findChildViewById(r10, R.id.item_mode_password_hard);
        if (r6 == null) goto L17;
        r0 = R.id.item_mode_pattern;
        SettingItemText r7 = (SettingItemText) ViewBindings.findChildViewById(r10, R.id.item_mode_pattern);
        if (r7 == null) goto L17;
        r0 = R.id.mode_list;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.mode_list);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new LockScreenModeSettingsLayoutBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
