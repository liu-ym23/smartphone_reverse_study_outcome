package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.SettingItemTextVertical;

/* JADX INFO: loaded from: classes2.dex */
public final class LauncherSettingsThemeBinding implements ViewBinding {
    public final SettingItemTextVertical itemIdLauncherAnim;
    public final SettingItemTextVertical itemIdLauncherTheme;
    public final SettingItemTextVertical itemIdLauncherWallpaper;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LauncherSettingsThemeBinding(LinearLayout r1, SettingItemTextVertical r2, SettingItemTextVertical r3, SettingItemTextVertical r4) {
        this.rootView = r1;
        this.itemIdLauncherAnim = r2;
        this.itemIdLauncherTheme = r3;
        this.itemIdLauncherWallpaper = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LauncherSettingsThemeBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LauncherSettingsThemeBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.launcher_settings_theme, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LauncherSettingsThemeBinding bind(View r4) {
        int r0 = R.id.item_id_launcher_anim;
        SettingItemTextVertical r1 = (SettingItemTextVertical) ViewBindings.findChildViewById(r4, R.id.item_id_launcher_anim);
        if (r1 == null) goto L11;
        r0 = R.id.item_id_launcher_theme;
        SettingItemTextVertical r2 = (SettingItemTextVertical) ViewBindings.findChildViewById(r4, R.id.item_id_launcher_theme);
        if (r2 == null) goto L11;
        r0 = R.id.item_id_launcher_wallpaper;
        SettingItemTextVertical r3 = (SettingItemTextVertical) ViewBindings.findChildViewById(r4, R.id.item_id_launcher_wallpaper);
        if (r3 == null) goto L11;
        return new LauncherSettingsThemeBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
