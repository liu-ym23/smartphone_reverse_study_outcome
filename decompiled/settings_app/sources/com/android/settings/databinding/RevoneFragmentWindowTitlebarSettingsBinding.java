package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ListContentItemCheck;
import obric.widget.ListContentItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneFragmentWindowTitlebarSettingsBinding implements ViewBinding {
    public final TextView idModeAutoTipsView;
    public final ListContentItemCheck idStyleBottom;
    public final ListContentItemCheck idStyleTop;
    public final ListContentItemSwitch idWindowTitleBarModeAuto;
    public final TextView idWindowTitleBarModeManual;
    public final TextView idWindowTitleBarVideoIntro;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final View videoBackground;
    public final ImageView videoDefault;
    public final FrameLayout videoLayout;
    public final VideoView videoView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneFragmentWindowTitlebarSettingsBinding(RelativeLayout r1, TextView r2, ListContentItemCheck r3, ListContentItemCheck r4, ListContentItemSwitch r5, TextView r6, TextView r7, LinearLayout r8, OScrollView r9, View r10, ImageView r11, FrameLayout r12, VideoView r13, OFloatingTitleBar r14) {
        this.rootView = r1;
        this.idModeAutoTipsView = r2;
        this.idStyleBottom = r3;
        this.idStyleTop = r4;
        this.idWindowTitleBarModeAuto = r5;
        this.idWindowTitleBarModeManual = r6;
        this.idWindowTitleBarVideoIntro = r7;
        this.pageContainer = r8;
        this.pageScrollview = r9;
        this.videoBackground = r10;
        this.videoDefault = r11;
        this.videoLayout = r12;
        this.videoView = r13;
        this.viewTitle = r14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RevoneFragmentWindowTitlebarSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneFragmentWindowTitlebarSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_fragment_window_titlebar_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneFragmentWindowTitlebarSettingsBinding bind(View r18) {
        int r1 = R.id.id_mode_auto_tips_view;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r18, R.id.id_mode_auto_tips_view);
        if (r5 == null) goto L31;
        r1 = R.id.id_style_bottom;
        ListContentItemCheck r6 = (ListContentItemCheck) ViewBindings.findChildViewById(r18, R.id.id_style_bottom);
        if (r6 == null) goto L31;
        r1 = R.id.id_style_top;
        ListContentItemCheck r7 = (ListContentItemCheck) ViewBindings.findChildViewById(r18, R.id.id_style_top);
        if (r7 == null) goto L31;
        r1 = R.id.id_window_title_bar_mode_auto;
        ListContentItemSwitch r8 = (ListContentItemSwitch) ViewBindings.findChildViewById(r18, R.id.id_window_title_bar_mode_auto);
        if (r8 == null) goto L31;
        r1 = R.id.id_window_title_bar_mode_manual;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r18, R.id.id_window_title_bar_mode_manual);
        if (r9 == null) goto L31;
        r1 = R.id.id_window_title_bar_video_intro;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r18, R.id.id_window_title_bar_video_intro);
        if (r10 == null) goto L31;
        r1 = R.id.page_container;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.page_container);
        if (r11 == null) goto L31;
        r1 = R.id.page_scrollview;
        OScrollView r12 = (OScrollView) ViewBindings.findChildViewById(r18, R.id.page_scrollview);
        if (r12 == null) goto L31;
        r1 = R.id.video_background;
        View r13 = ViewBindings.findChildViewById(r18, R.id.video_background);
        if (r13 == null) goto L31;
        r1 = R.id.video_default;
        ImageView r14 = (ImageView) ViewBindings.findChildViewById(r18, R.id.video_default);
        if (r14 == null) goto L31;
        r1 = R.id.video_layout;
        FrameLayout r15 = (FrameLayout) ViewBindings.findChildViewById(r18, R.id.video_layout);
        if (r15 == null) goto L31;
        r1 = R.id.video_view;
        VideoView r16 = (VideoView) ViewBindings.findChildViewById(r18, R.id.video_view);
        if (r16 == null) goto L31;
        r1 = R.id.view_title;
        OFloatingTitleBar r17 = (OFloatingTitleBar) ViewBindings.findChildViewById(r18, R.id.view_title);
        if (r17 == null) goto L31;
        return new RevoneFragmentWindowTitlebarSettingsBinding((RelativeLayout) r18, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r1)));
    }
}
