package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class CommonSettingsItemTextLayoutBinding implements ViewBinding {
    public final SettingItemText itemIdWifiAdvancedSettings;
    private final SettingItemText rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private CommonSettingsItemTextLayoutBinding(SettingItemText r1, SettingItemText r2) {
        this.rootView = r1;
        this.itemIdWifiAdvancedSettings = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SettingItemText getRoot() {
        return this.rootView;
    }

    public static CommonSettingsItemTextLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static CommonSettingsItemTextLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.common_settings_item_text_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static CommonSettingsItemTextLayoutBinding bind(View r1) {
        if (r1 == null) goto L6;
        SettingItemText r2 = (SettingItemText) r1;
        return new CommonSettingsItemTextLayoutBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
