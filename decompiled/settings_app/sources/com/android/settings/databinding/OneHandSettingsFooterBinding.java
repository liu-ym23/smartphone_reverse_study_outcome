package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.VerticalOptionsCheckView;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class OneHandSettingsFooterBinding implements ViewBinding {
    public final VerticalOptionsCheckView idLauncherDockerView;
    public final VerticalOptionsCheckView idNavigationLayoutOneHandMode;
    public final FrameLayout idThumbDropdown;
    public final TextView idThumbPullScreenDownTitle;
    public final TextView idThumbTriggerSwitchTips;
    public final SettingItemSwitch itemIdPulldownWallpaperEnable;
    private final LinearLayout rootView;
    public final SettingItemSwitch thumbPushDownSwitch;
    public final LinearLayout thumbTriggerAreaLayout;
    public final SettingItemText thumbTriggerAreaOptions;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OneHandSettingsFooterBinding(LinearLayout r1, VerticalOptionsCheckView r2, VerticalOptionsCheckView r3, FrameLayout r4, TextView r5, TextView r6, SettingItemSwitch r7, SettingItemSwitch r8, LinearLayout r9, SettingItemText r10) {
        this.rootView = r1;
        this.idLauncherDockerView = r2;
        this.idNavigationLayoutOneHandMode = r3;
        this.idThumbDropdown = r4;
        this.idThumbPullScreenDownTitle = r5;
        this.idThumbTriggerSwitchTips = r6;
        this.itemIdPulldownWallpaperEnable = r7;
        this.thumbPushDownSwitch = r8;
        this.thumbTriggerAreaLayout = r9;
        this.thumbTriggerAreaOptions = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static OneHandSettingsFooterBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OneHandSettingsFooterBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.one_hand_settings_footer, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OneHandSettingsFooterBinding bind(View r13) {
        int r0 = R.id.id_launcher_docker_view;
        VerticalOptionsCheckView r4 = (VerticalOptionsCheckView) ViewBindings.findChildViewById(r13, R.id.id_launcher_docker_view);
        if (r4 == null) goto L23;
        r0 = R.id.id_navigation_layout_one_hand_mode;
        VerticalOptionsCheckView r5 = (VerticalOptionsCheckView) ViewBindings.findChildViewById(r13, R.id.id_navigation_layout_one_hand_mode);
        if (r5 == null) goto L23;
        r0 = R.id.id_thumb_dropdown;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r13, R.id.id_thumb_dropdown);
        if (r6 == null) goto L23;
        r0 = R.id.id_thumb_pull_screen_down_title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r13, R.id.id_thumb_pull_screen_down_title);
        if (r7 == null) goto L23;
        r0 = R.id.id_thumb_trigger_switch_tips;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r13, R.id.id_thumb_trigger_switch_tips);
        if (r8 == null) goto L23;
        r0 = R.id.item_id_pulldown_wallpaper_enable;
        SettingItemSwitch r9 = (SettingItemSwitch) ViewBindings.findChildViewById(r13, R.id.item_id_pulldown_wallpaper_enable);
        if (r9 == null) goto L23;
        r0 = R.id.thumb_push_down_switch;
        SettingItemSwitch r10 = (SettingItemSwitch) ViewBindings.findChildViewById(r13, R.id.thumb_push_down_switch);
        if (r10 == null) goto L23;
        r0 = R.id.thumb_trigger_area_layout;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.thumb_trigger_area_layout);
        if (r11 == null) goto L23;
        r0 = R.id.thumb_trigger_area_options;
        SettingItemText r12 = (SettingItemText) ViewBindings.findChildViewById(r13, R.id.thumb_trigger_area_options);
        if (r12 == null) goto L23;
        return new OneHandSettingsFooterBinding((LinearLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
