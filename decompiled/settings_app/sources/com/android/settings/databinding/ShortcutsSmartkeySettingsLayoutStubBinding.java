package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemCustom;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class ShortcutsSmartkeySettingsLayoutStubBinding implements ViewBinding {
    public final SettingItemText functionKey;
    private final LinearLayout rootView;
    public final SettingItemText sideKey;
    public final ListContentItemCustom sideKeyImgLayout;
    public final LinearLayout smartKeySettings;
    public final SettingItemText smartKeyWithPower;
    public final SettingItemText smartKeyWithVolumeDown;
    public final SettingItemText smartKeyWithVolumeUp;
    public final LinearLayout smartKeyWithVolumeUpContainer;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ShortcutsSmartkeySettingsLayoutStubBinding(LinearLayout r1, SettingItemText r2, SettingItemText r3, ListContentItemCustom r4, LinearLayout r5, SettingItemText r6, SettingItemText r7, SettingItemText r8, LinearLayout r9) {
        this.rootView = r1;
        this.functionKey = r2;
        this.sideKey = r3;
        this.sideKeyImgLayout = r4;
        this.smartKeySettings = r5;
        this.smartKeyWithPower = r6;
        this.smartKeyWithVolumeDown = r7;
        this.smartKeyWithVolumeUp = r8;
        this.smartKeyWithVolumeUpContainer = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ShortcutsSmartkeySettingsLayoutStubBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ShortcutsSmartkeySettingsLayoutStubBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.shortcuts_smartkey_settings_layout_stub, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ShortcutsSmartkeySettingsLayoutStubBinding bind(View r12) {
        int r0 = R.id.function_key;
        SettingItemText r4 = (SettingItemText) ViewBindings.findChildViewById(r12, R.id.function_key);
        if (r4 == null) goto L19;
        r0 = R.id.side_key;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r12, R.id.side_key);
        if (r5 == null) goto L19;
        r0 = R.id.side_key_img_layout;
        ListContentItemCustom r6 = (ListContentItemCustom) ViewBindings.findChildViewById(r12, R.id.side_key_img_layout);
        if (r6 == null) goto L19;
        LinearLayout r7 = (LinearLayout) r12;
        r0 = R.id.smart_key_with_power;
        SettingItemText r8 = (SettingItemText) ViewBindings.findChildViewById(r12, R.id.smart_key_with_power);
        if (r8 == null) goto L19;
        r0 = R.id.smart_key_with_volume_down;
        SettingItemText r9 = (SettingItemText) ViewBindings.findChildViewById(r12, R.id.smart_key_with_volume_down);
        if (r9 == null) goto L19;
        r0 = R.id.smart_key_with_volume_up;
        SettingItemText r10 = (SettingItemText) ViewBindings.findChildViewById(r12, R.id.smart_key_with_volume_up);
        if (r10 == null) goto L19;
        r0 = R.id.smart_key_with_volume_up_container;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r12, R.id.smart_key_with_volume_up_container);
        if (r11 == null) goto L19;
        return new ShortcutsSmartkeySettingsLayoutStubBinding(r7, r4, r5, r6, r7, r8, r9, r10, r11);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
