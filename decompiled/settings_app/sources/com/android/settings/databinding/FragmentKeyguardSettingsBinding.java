package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.PreviewSettingItemView;
import com.android.settings.R;
import com.android.settings.SettingItemTextVertical;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ListContentItemText;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentKeyguardSettingsBinding implements ViewBinding {
    public final SettingItemSwitch displayWhenScreenOff;
    public final SettingItemSwitch itemIdDisplayLargeBattery;
    public final PreviewSettingItemView itemPreviewLeft;
    public final PreviewSettingItemView itemPreviewRight;
    public final SettingItemText lockScreenShortcut;
    public final TextView lockScreenShortcutTips;
    public final SettingItemTextVertical lockScreenWallpaper;
    public final ListContentItemText nutsClockTheme;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final View shadowAboveDisplayWhenScreenOff;
    public final GroupListItemVerticalGapLayoutBinding shadowAboveNutsClockTheme;
    public final TextView textItemTitle;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FragmentKeyguardSettingsBinding(RelativeLayout r1, SettingItemSwitch r2, SettingItemSwitch r3, PreviewSettingItemView r4, PreviewSettingItemView r5, SettingItemText r6, TextView r7, SettingItemTextVertical r8, ListContentItemText r9, LinearLayout r10, OScrollView r11, View r12, GroupListItemVerticalGapLayoutBinding r13, TextView r14, OFloatingTitleBar r15) {
        this.rootView = r1;
        this.displayWhenScreenOff = r2;
        this.itemIdDisplayLargeBattery = r3;
        this.itemPreviewLeft = r4;
        this.itemPreviewRight = r5;
        this.lockScreenShortcut = r6;
        this.lockScreenShortcutTips = r7;
        this.lockScreenWallpaper = r8;
        this.nutsClockTheme = r9;
        this.pageContainer = r10;
        this.pageScrollview = r11;
        this.shadowAboveDisplayWhenScreenOff = r12;
        this.shadowAboveNutsClockTheme = r13;
        this.textItemTitle = r14;
        this.viewTitle = r15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentKeyguardSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentKeyguardSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fragment_keyguard_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FragmentKeyguardSettingsBinding bind(View r19) {
        int r1 = R.id.display_when_screen_off;
        SettingItemSwitch r5 = (SettingItemSwitch) ViewBindings.findChildViewById(r19, R.id.display_when_screen_off);
        if (r5 == null) goto L33;
        r1 = R.id.item_id_display_large_battery;
        SettingItemSwitch r6 = (SettingItemSwitch) ViewBindings.findChildViewById(r19, R.id.item_id_display_large_battery);
        if (r6 == null) goto L33;
        r1 = R.id.item_preview_left;
        PreviewSettingItemView r7 = (PreviewSettingItemView) ViewBindings.findChildViewById(r19, R.id.item_preview_left);
        if (r7 == null) goto L33;
        r1 = R.id.item_preview_right;
        PreviewSettingItemView r8 = (PreviewSettingItemView) ViewBindings.findChildViewById(r19, R.id.item_preview_right);
        if (r8 == null) goto L33;
        r1 = R.id.lock_screen_shortcut;
        SettingItemText r9 = (SettingItemText) ViewBindings.findChildViewById(r19, R.id.lock_screen_shortcut);
        if (r9 == null) goto L33;
        r1 = R.id.lock_screen_shortcut_tips;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r19, R.id.lock_screen_shortcut_tips);
        if (r10 == null) goto L33;
        r1 = R.id.lock_screen_wallpaper;
        SettingItemTextVertical r11 = (SettingItemTextVertical) ViewBindings.findChildViewById(r19, R.id.lock_screen_wallpaper);
        if (r11 == null) goto L33;
        r1 = R.id.nuts_clock_theme;
        ListContentItemText r12 = (ListContentItemText) ViewBindings.findChildViewById(r19, R.id.nuts_clock_theme);
        if (r12 == null) goto L33;
        r1 = R.id.page_container;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.page_container);
        if (r13 == null) goto L33;
        r1 = R.id.page_scrollview;
        OScrollView r14 = (OScrollView) ViewBindings.findChildViewById(r19, R.id.page_scrollview);
        if (r14 == null) goto L33;
        r1 = R.id.shadow_above_display_when_screen_off;
        View r15 = ViewBindings.findChildViewById(r19, R.id.shadow_above_display_when_screen_off);
        if (r15 == null) goto L33;
        r1 = R.id.shadow_above_nuts_clock_theme;
        View r2 = ViewBindings.findChildViewById(r19, R.id.shadow_above_nuts_clock_theme);
        if (r2 == null) goto L33;
        GroupListItemVerticalGapLayoutBinding r16 = GroupListItemVerticalGapLayoutBinding.bind(r2);
        r1 = R.id.text_item_title;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r19, R.id.text_item_title);
        if (r17 == null) goto L33;
        r1 = R.id.view_title;
        OFloatingTitleBar r18 = (OFloatingTitleBar) ViewBindings.findChildViewById(r19, R.id.view_title);
        if (r18 == null) goto L33;
        return new FragmentKeyguardSettingsBinding((RelativeLayout) r19, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r19.getResources().getResourceName(r1)));
    }
}
