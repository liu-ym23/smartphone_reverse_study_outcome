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
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class DevelopingSettingsLayoutBinding implements ViewBinding {
    public final SettingItemSwitch allowDragWindows;
    public final SettingItemSwitch allowMoveTaskDirectly;
    public final SettingItemText bigBangOcrSettings;
    public final SettingItemText bigBangTextSettings;
    public final SettingItemText devApp;
    public final SettingItemSwitch dpLane;
    public final SettingItemText fontSize;
    public final SettingItemText forceTouchSettings;
    public final SettingItemText idNavigationBarVibrationStrength;
    public final SettingItemSwitch leakCanary;
    public final SettingItemSwitch mmSendByEnterFeature;
    public final SettingItemText mmSendByEnterSelection;
    public final TextView multiBlockTips;
    public final SettingItemText multiUser;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final SettingItemSwitch phoneVoiceWaterDrop;
    private final RelativeLayout rootView;
    public final SettingItemText screenScale;
    public final SettingItemText statusBarMode;
    public final SettingItemSwitch swapFeature;
    public final SettingItemText tabletSettings;
    public final OFloatingTitleBar viewTitle;
    public final SettingItemSwitch zoomMode;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DevelopingSettingsLayoutBinding(RelativeLayout r3, SettingItemSwitch r4, SettingItemSwitch r5, SettingItemText r6, SettingItemText r7, SettingItemText r8, SettingItemSwitch r9, SettingItemText r10, SettingItemText r11, SettingItemText r12, SettingItemSwitch r13, SettingItemSwitch r14, SettingItemText r15, TextView r16, SettingItemText r17, LinearLayout r18, OScrollView r19, SettingItemSwitch r20, SettingItemText r21, SettingItemText r22, SettingItemSwitch r23, SettingItemText r24, OFloatingTitleBar r25, SettingItemSwitch r26) {
        this.rootView = r3;
        this.allowDragWindows = r4;
        this.allowMoveTaskDirectly = r5;
        this.bigBangOcrSettings = r6;
        this.bigBangTextSettings = r7;
        this.devApp = r8;
        this.dpLane = r9;
        this.fontSize = r10;
        this.forceTouchSettings = r11;
        this.idNavigationBarVibrationStrength = r12;
        this.leakCanary = r13;
        this.mmSendByEnterFeature = r14;
        this.mmSendByEnterSelection = r15;
        this.multiBlockTips = r16;
        this.multiUser = r17;
        this.pageContainer = r18;
        this.pageScrollview = r19;
        this.phoneVoiceWaterDrop = r20;
        this.screenScale = r21;
        this.statusBarMode = r22;
        this.swapFeature = r23;
        this.tabletSettings = r24;
        this.viewTitle = r25;
        this.zoomMode = r26;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DevelopingSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DevelopingSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.developing_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DevelopingSettingsLayoutBinding bind(View r28) {
        int r1 = R.id.allow_drag_windows;
        SettingItemSwitch r5 = (SettingItemSwitch) ViewBindings.findChildViewById(r28, R.id.allow_drag_windows);
        if (r5 == null) goto L51;
        r1 = R.id.allow_move_task_directly;
        SettingItemSwitch r6 = (SettingItemSwitch) ViewBindings.findChildViewById(r28, R.id.allow_move_task_directly);
        if (r6 == null) goto L51;
        r1 = R.id.big_bang_ocr_settings;
        SettingItemText r7 = (SettingItemText) ViewBindings.findChildViewById(r28, R.id.big_bang_ocr_settings);
        if (r7 == null) goto L51;
        r1 = R.id.big_bang_text_settings;
        SettingItemText r8 = (SettingItemText) ViewBindings.findChildViewById(r28, R.id.big_bang_text_settings);
        if (r8 == null) goto L51;
        r1 = R.id.dev_app;
        SettingItemText r9 = (SettingItemText) ViewBindings.findChildViewById(r28, R.id.dev_app);
        if (r9 == null) goto L51;
        r1 = R.id.dp_lane;
        SettingItemSwitch r10 = (SettingItemSwitch) ViewBindings.findChildViewById(r28, R.id.dp_lane);
        if (r10 == null) goto L51;
        r1 = R.id.font_size;
        SettingItemText r11 = (SettingItemText) ViewBindings.findChildViewById(r28, R.id.font_size);
        if (r11 == null) goto L51;
        r1 = R.id.force_touch_settings;
        SettingItemText r12 = (SettingItemText) ViewBindings.findChildViewById(r28, R.id.force_touch_settings);
        if (r12 == null) goto L51;
        r1 = R.id.id_navigation_bar_vibration_strength;
        SettingItemText r13 = (SettingItemText) ViewBindings.findChildViewById(r28, R.id.id_navigation_bar_vibration_strength);
        if (r13 == null) goto L51;
        r1 = R.id.leak_canary;
        SettingItemSwitch r14 = (SettingItemSwitch) ViewBindings.findChildViewById(r28, R.id.leak_canary);
        if (r14 == null) goto L51;
        r1 = R.id.mm_send_by_enter_feature;
        SettingItemSwitch r15 = (SettingItemSwitch) ViewBindings.findChildViewById(r28, R.id.mm_send_by_enter_feature);
        if (r15 == null) goto L51;
        r1 = R.id.mm_send_by_enter_selection;
        SettingItemText r16 = (SettingItemText) ViewBindings.findChildViewById(r28, R.id.mm_send_by_enter_selection);
        if (r16 == null) goto L51;
        r1 = R.id.multi_block_tips;
        TextView r17 = (TextView) ViewBindings.findChildViewById(r28, R.id.multi_block_tips);
        if (r17 == null) goto L51;
        r1 = R.id.multi_user;
        SettingItemText r18 = (SettingItemText) ViewBindings.findChildViewById(r28, R.id.multi_user);
        if (r18 == null) goto L51;
        r1 = R.id.page_container;
        LinearLayout r19 = (LinearLayout) ViewBindings.findChildViewById(r28, R.id.page_container);
        if (r19 == null) goto L51;
        r1 = R.id.page_scrollview;
        OScrollView r20 = (OScrollView) ViewBindings.findChildViewById(r28, R.id.page_scrollview);
        if (r20 == null) goto L51;
        r1 = R.id.phone_voice_water_drop;
        SettingItemSwitch r21 = (SettingItemSwitch) ViewBindings.findChildViewById(r28, R.id.phone_voice_water_drop);
        if (r21 == null) goto L51;
        r1 = R.id.screen_scale;
        SettingItemText r22 = (SettingItemText) ViewBindings.findChildViewById(r28, R.id.screen_scale);
        if (r22 == null) goto L51;
        r1 = R.id.status_bar_mode;
        SettingItemText r23 = (SettingItemText) ViewBindings.findChildViewById(r28, R.id.status_bar_mode);
        if (r23 == null) goto L51;
        r1 = R.id.swap_feature;
        SettingItemSwitch r24 = (SettingItemSwitch) ViewBindings.findChildViewById(r28, R.id.swap_feature);
        if (r24 == null) goto L51;
        r1 = R.id.tablet_settings;
        SettingItemText r25 = (SettingItemText) ViewBindings.findChildViewById(r28, R.id.tablet_settings);
        if (r25 == null) goto L51;
        r1 = R.id.view_title;
        OFloatingTitleBar r26 = (OFloatingTitleBar) ViewBindings.findChildViewById(r28, R.id.view_title);
        if (r26 == null) goto L51;
        r1 = R.id.zoom_mode;
        SettingItemSwitch r27 = (SettingItemSwitch) ViewBindings.findChildViewById(r28, R.id.zoom_mode);
        if (r27 == null) goto L51;
        return new DevelopingSettingsLayoutBinding((RelativeLayout) r28, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27);
    L51:
        throw new NullPointerException("Missing required view with ID: ".concat(r28.getResources().getResourceName(r1)));
    }
}
