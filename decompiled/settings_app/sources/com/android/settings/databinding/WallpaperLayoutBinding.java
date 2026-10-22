package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.SettingItemTextVertical;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class WallpaperLayoutBinding implements ViewBinding {
    public final SettingItemTextVertical itemIdDeviceTheme;
    public final SettingItemTextVertical itemIdIcons;
    public final SettingItemTextVertical itemIdLockscreenWallpaper;
    public final LauncherSettingsThemeBinding laucherThemeViewstub;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WallpaperLayoutBinding(RelativeLayout r1, SettingItemTextVertical r2, SettingItemTextVertical r3, SettingItemTextVertical r4, LauncherSettingsThemeBinding r5, LinearLayout r6, OScrollView r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.itemIdDeviceTheme = r2;
        this.itemIdIcons = r3;
        this.itemIdLockscreenWallpaper = r4;
        this.laucherThemeViewstub = r5;
        this.pageContainer = r6;
        this.pageScrollview = r7;
        this.viewTitle = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WallpaperLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WallpaperLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wallpaper_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WallpaperLayoutBinding bind(View r11) {
        int r0 = R.id.item_id_device_theme;
        SettingItemTextVertical r4 = (SettingItemTextVertical) ViewBindings.findChildViewById(r11, R.id.item_id_device_theme);
        if (r4 == null) goto L19;
        r0 = R.id.item_id_icons;
        SettingItemTextVertical r5 = (SettingItemTextVertical) ViewBindings.findChildViewById(r11, R.id.item_id_icons);
        if (r5 == null) goto L19;
        r0 = R.id.item_id_lockscreen_wallpaper;
        SettingItemTextVertical r6 = (SettingItemTextVertical) ViewBindings.findChildViewById(r11, R.id.item_id_lockscreen_wallpaper);
        if (r6 == null) goto L19;
        r0 = R.id.laucher_theme_viewstub;
        View r1 = ViewBindings.findChildViewById(r11, R.id.laucher_theme_viewstub);
        if (r1 == null) goto L19;
        LauncherSettingsThemeBinding r7 = LauncherSettingsThemeBinding.bind(r1);
        r0 = R.id.page_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.page_container);
        if (r8 == null) goto L19;
        r0 = R.id.page_scrollview;
        OScrollView r9 = (OScrollView) ViewBindings.findChildViewById(r11, R.id.page_scrollview);
        if (r9 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r10 == null) goto L19;
        return new WallpaperLayoutBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
