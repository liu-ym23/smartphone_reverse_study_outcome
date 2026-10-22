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
import com.android.settings.widget.ForceTouchGifAnimView;
import com.android.settings.widget.SettingPreviewSeekBar;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class ForceTouchSettingsLayoutBinding implements ViewBinding {
    public final ForceTouchGifAnimView gifView;
    public final SettingPreviewSeekBar idForceTouchPressure;
    public final TextView idPhoneCaseVideoIntroTips;
    public final SettingItemText itemImageShortcut;
    public final SettingItemText itemLockScreenShortcut;
    public final SettingItemSwitch itemQuickPushpinShortcut;
    public final SettingItemText itemTextShortcut;
    public final SettingItemText itemTrackBallShortcut;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ForceTouchSettingsLayoutBinding(RelativeLayout r1, ForceTouchGifAnimView r2, SettingPreviewSeekBar r3, TextView r4, SettingItemText r5, SettingItemText r6, SettingItemSwitch r7, SettingItemText r8, SettingItemText r9, LinearLayout r10, OScrollView r11, OFloatingTitleBar r12) {
        this.rootView = r1;
        this.gifView = r2;
        this.idForceTouchPressure = r3;
        this.idPhoneCaseVideoIntroTips = r4;
        this.itemImageShortcut = r5;
        this.itemLockScreenShortcut = r6;
        this.itemQuickPushpinShortcut = r7;
        this.itemTextShortcut = r8;
        this.itemTrackBallShortcut = r9;
        this.pageContainer = r10;
        this.pageScrollview = r11;
        this.viewTitle = r12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ForceTouchSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ForceTouchSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.force_touch_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ForceTouchSettingsLayoutBinding bind(View r15) {
        int r0 = R.id.gif_view;
        ForceTouchGifAnimView r4 = (ForceTouchGifAnimView) ViewBindings.findChildViewById(r15, R.id.gif_view);
        if (r4 == null) goto L27;
        r0 = R.id.id_force_touch_pressure;
        SettingPreviewSeekBar r5 = (SettingPreviewSeekBar) ViewBindings.findChildViewById(r15, R.id.id_force_touch_pressure);
        if (r5 == null) goto L27;
        r0 = R.id.id_phone_case_video_intro_tips;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r15, R.id.id_phone_case_video_intro_tips);
        if (r6 == null) goto L27;
        r0 = R.id.item_image_shortcut;
        SettingItemText r7 = (SettingItemText) ViewBindings.findChildViewById(r15, R.id.item_image_shortcut);
        if (r7 == null) goto L27;
        r0 = R.id.item_lock_screen_shortcut;
        SettingItemText r8 = (SettingItemText) ViewBindings.findChildViewById(r15, R.id.item_lock_screen_shortcut);
        if (r8 == null) goto L27;
        r0 = R.id.item_quick_pushpin_shortcut;
        SettingItemSwitch r9 = (SettingItemSwitch) ViewBindings.findChildViewById(r15, R.id.item_quick_pushpin_shortcut);
        if (r9 == null) goto L27;
        r0 = R.id.item_text_shortcut;
        SettingItemText r10 = (SettingItemText) ViewBindings.findChildViewById(r15, R.id.item_text_shortcut);
        if (r10 == null) goto L27;
        r0 = R.id.item_track_ball_shortcut;
        SettingItemText r11 = (SettingItemText) ViewBindings.findChildViewById(r15, R.id.item_track_ball_shortcut);
        if (r11 == null) goto L27;
        r0 = R.id.page_container;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.page_container);
        if (r12 == null) goto L27;
        r0 = R.id.page_scrollview;
        OScrollView r13 = (OScrollView) ViewBindings.findChildViewById(r15, R.id.page_scrollview);
        if (r13 == null) goto L27;
        r0 = R.id.view_title;
        OFloatingTitleBar r14 = (OFloatingTitleBar) ViewBindings.findChildViewById(r15, R.id.view_title);
        if (r14 == null) goto L27;
        return new ForceTouchSettingsLayoutBinding((RelativeLayout) r15, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    }
}
