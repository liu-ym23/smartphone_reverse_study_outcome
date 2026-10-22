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
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class TabletWallpaperSettingsBinding implements ViewBinding {
    public final SettingItemTextVertical itemIdHistoryWallpaper;
    public final SettingItemTextVertical itemIdOriginLauncherWp;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final SettingItemSwitch switchWallpaper;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TabletWallpaperSettingsBinding(RelativeLayout r1, SettingItemTextVertical r2, SettingItemTextVertical r3, LinearLayout r4, OScrollView r5, SettingItemSwitch r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.itemIdHistoryWallpaper = r2;
        this.itemIdOriginLauncherWp = r3;
        this.pageContainer = r4;
        this.pageScrollview = r5;
        this.switchWallpaper = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TabletWallpaperSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TabletWallpaperSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.tablet_wallpaper_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TabletWallpaperSettingsBinding bind(View r10) {
        int r0 = R.id.item_id_history_wallpaper;
        SettingItemTextVertical r4 = (SettingItemTextVertical) ViewBindings.findChildViewById(r10, R.id.item_id_history_wallpaper);
        if (r4 == null) goto L17;
        r0 = R.id.item_id_origin_launcher_wp;
        SettingItemTextVertical r5 = (SettingItemTextVertical) ViewBindings.findChildViewById(r10, R.id.item_id_origin_launcher_wp);
        if (r5 == null) goto L17;
        r0 = R.id.page_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.page_container);
        if (r6 == null) goto L17;
        r0 = R.id.page_scrollview;
        OScrollView r7 = (OScrollView) ViewBindings.findChildViewById(r10, R.id.page_scrollview);
        if (r7 == null) goto L17;
        r0 = R.id.switch_wallpaper;
        SettingItemSwitch r8 = (SettingItemSwitch) ViewBindings.findChildViewById(r10, R.id.switch_wallpaper);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new TabletWallpaperSettingsBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
