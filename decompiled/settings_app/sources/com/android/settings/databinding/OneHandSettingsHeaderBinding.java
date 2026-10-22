package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.SettingItemCheck;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class OneHandSettingsHeaderBinding implements ViewBinding {
    public final SettingItemCheck itemIdPreferLeft;
    public final SettingItemCheck itemIdPreferRight;
    public final SettingItemText itemMenuDown;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OneHandSettingsHeaderBinding(LinearLayout r1, SettingItemCheck r2, SettingItemCheck r3, SettingItemText r4) {
        this.rootView = r1;
        this.itemIdPreferLeft = r2;
        this.itemIdPreferRight = r3;
        this.itemMenuDown = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static OneHandSettingsHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OneHandSettingsHeaderBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.one_hand_settings_header, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OneHandSettingsHeaderBinding bind(View r4) {
        int r0 = R.id.item_id_prefer_left;
        SettingItemCheck r1 = (SettingItemCheck) ViewBindings.findChildViewById(r4, R.id.item_id_prefer_left);
        if (r1 == null) goto L11;
        r0 = R.id.item_id_prefer_right;
        SettingItemCheck r2 = (SettingItemCheck) ViewBindings.findChildViewById(r4, R.id.item_id_prefer_right);
        if (r2 == null) goto L11;
        r0 = R.id.item_menu_down;
        SettingItemText r3 = (SettingItemText) ViewBindings.findChildViewById(r4, R.id.item_menu_down);
        if (r3 == null) goto L11;
        return new OneHandSettingsHeaderBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
