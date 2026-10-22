package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.SettingItemTextVertical;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class ChooseWallpaperTypeLayoutBinding implements ViewBinding {
    public final SettingItemSwitch itemFourFingersChangeLockscreen;
    public final TextView itemFourFingersChangeLockscreenTips;
    public final SettingItemSwitch itemIdAutoSwitchLockScreenWallpaper;
    public final TextView itemIdAutoSwitchLockScreenWallpaperTips;
    public final LinearLayout itemIdAutoSwitchWallpaperFrequencyContainer;
    public final SettingItemTextVertical itemIdHistoryWallpaper;
    public final SettingItemTextVertical itemIdOnlineWallpaper;
    public final SettingItemTextVertical itemIdSystemWallpaper;
    public final SettingItemSwitch originalLauncherWallpaperBlur;
    public final View originalLauncherWallpaperBlurShadow;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final TiktokOnKeyguardBinding tiktokOnKeyguard;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ChooseWallpaperTypeLayoutBinding(RelativeLayout r1, SettingItemSwitch r2, TextView r3, SettingItemSwitch r4, TextView r5, LinearLayout r6, SettingItemTextVertical r7, SettingItemTextVertical r8, SettingItemTextVertical r9, SettingItemSwitch r10, View r11, LinearLayout r12, OScrollView r13, TiktokOnKeyguardBinding r14, OFloatingTitleBar r15) {
        this.rootView = r1;
        this.itemFourFingersChangeLockscreen = r2;
        this.itemFourFingersChangeLockscreenTips = r3;
        this.itemIdAutoSwitchLockScreenWallpaper = r4;
        this.itemIdAutoSwitchLockScreenWallpaperTips = r5;
        this.itemIdAutoSwitchWallpaperFrequencyContainer = r6;
        this.itemIdHistoryWallpaper = r7;
        this.itemIdOnlineWallpaper = r8;
        this.itemIdSystemWallpaper = r9;
        this.originalLauncherWallpaperBlur = r10;
        this.originalLauncherWallpaperBlurShadow = r11;
        this.pageContainer = r12;
        this.pageScrollview = r13;
        this.tiktokOnKeyguard = r14;
        this.viewTitle = r15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ChooseWallpaperTypeLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ChooseWallpaperTypeLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.choose_wallpaper_type_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ChooseWallpaperTypeLayoutBinding bind(View r19) {
        int r1 = R.id.item_four_fingers_change_lockscreen;
        SettingItemSwitch r5 = (SettingItemSwitch) ViewBindings.findChildViewById(r19, R.id.item_four_fingers_change_lockscreen);
        if (r5 == null) goto L33;
        r1 = R.id.item_four_fingers_change_lockscreen_tips;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r19, R.id.item_four_fingers_change_lockscreen_tips);
        if (r6 == null) goto L33;
        r1 = R.id.item_id_auto_switch_lock_screen_wallpaper;
        SettingItemSwitch r7 = (SettingItemSwitch) ViewBindings.findChildViewById(r19, R.id.item_id_auto_switch_lock_screen_wallpaper);
        if (r7 == null) goto L33;
        r1 = R.id.item_id_auto_switch_lock_screen_wallpaper_tips;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r19, R.id.item_id_auto_switch_lock_screen_wallpaper_tips);
        if (r8 == null) goto L33;
        r1 = R.id.item_id_auto_switch_wallpaper_frequency_container;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.item_id_auto_switch_wallpaper_frequency_container);
        if (r9 == null) goto L33;
        r1 = R.id.item_id_history_wallpaper;
        SettingItemTextVertical r10 = (SettingItemTextVertical) ViewBindings.findChildViewById(r19, R.id.item_id_history_wallpaper);
        if (r10 == null) goto L33;
        r1 = R.id.item_id_online_wallpaper;
        SettingItemTextVertical r11 = (SettingItemTextVertical) ViewBindings.findChildViewById(r19, R.id.item_id_online_wallpaper);
        if (r11 == null) goto L33;
        r1 = R.id.item_id_system_wallpaper;
        SettingItemTextVertical r12 = (SettingItemTextVertical) ViewBindings.findChildViewById(r19, R.id.item_id_system_wallpaper);
        if (r12 == null) goto L33;
        r1 = R.id.original_launcher_wallpaper_blur;
        SettingItemSwitch r13 = (SettingItemSwitch) ViewBindings.findChildViewById(r19, R.id.original_launcher_wallpaper_blur);
        if (r13 == null) goto L33;
        r1 = R.id.original_launcher_wallpaper_blur_shadow;
        View r14 = ViewBindings.findChildViewById(r19, R.id.original_launcher_wallpaper_blur_shadow);
        if (r14 == null) goto L33;
        r1 = R.id.page_container;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.page_container);
        if (r15 == null) goto L33;
        r1 = R.id.page_scrollview;
        OScrollView r16 = (OScrollView) ViewBindings.findChildViewById(r19, R.id.page_scrollview);
        if (r16 == null) goto L33;
        r1 = R.id.tiktok_on_keyguard;
        View r2 = ViewBindings.findChildViewById(r19, R.id.tiktok_on_keyguard);
        if (r2 == null) goto L33;
        TiktokOnKeyguardBinding r17 = TiktokOnKeyguardBinding.bind(r2);
        r1 = R.id.view_title;
        OFloatingTitleBar r18 = (OFloatingTitleBar) ViewBindings.findChildViewById(r19, R.id.view_title);
        if (r18 == null) goto L33;
        return new ChooseWallpaperTypeLayoutBinding((RelativeLayout) r19, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r19.getResources().getResourceName(r1)));
    }
}
