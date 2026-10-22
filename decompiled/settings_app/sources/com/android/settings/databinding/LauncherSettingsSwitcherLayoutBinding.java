package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class LauncherSettingsSwitcherLayoutBinding implements ViewBinding {
    public final SettingItemSwitch itemIdUnlockAnim;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LauncherSettingsSwitcherLayoutBinding(LinearLayout r1, SettingItemSwitch r2) {
        this.rootView = r1;
        this.itemIdUnlockAnim = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LauncherSettingsSwitcherLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LauncherSettingsSwitcherLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.launcher_settings_switcher_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LauncherSettingsSwitcherLayoutBinding bind(View r2) {
        SettingItemSwitch r1 = (SettingItemSwitch) ViewBindings.findChildViewById(r2, R.id.item_id_unlock_anim);
        if (r1 == null) goto L7;
        return new LauncherSettingsSwitcherLayoutBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.item_id_unlock_anim)));
    }
}
