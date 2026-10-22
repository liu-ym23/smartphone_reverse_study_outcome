package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.VideoPlayerView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ChargingAnimationLayoutBinding implements ViewBinding {
    public final View centerLine;
    public final ImageView ivCheckDefault;
    public final ImageView ivCheckMoon;
    public final ImageView ivDefault;
    public final ImageView ivMoon;
    public final RelativeLayout leftPanel;
    public final RelativeLayout rightPanel;
    private final RelativeLayout rootView;
    public final VideoPlayerView videoPlayerView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ChargingAnimationLayoutBinding(RelativeLayout r1, View r2, ImageView r3, ImageView r4, ImageView r5, ImageView r6, RelativeLayout r7, RelativeLayout r8, VideoPlayerView r9, OFloatingTitleBar r10) {
        this.rootView = r1;
        this.centerLine = r2;
        this.ivCheckDefault = r3;
        this.ivCheckMoon = r4;
        this.ivDefault = r5;
        this.ivMoon = r6;
        this.leftPanel = r7;
        this.rightPanel = r8;
        this.videoPlayerView = r9;
        this.viewTitle = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ChargingAnimationLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ChargingAnimationLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.charging_animation_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ChargingAnimationLayoutBinding bind(View r12) {
        int r0 = R.id.center_line;
        View r3 = ViewBindings.findChildViewById(r12, R.id.center_line);
        if (r3 == null) goto L23;
        r0 = R.id.iv_check_default;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r12, R.id.iv_check_default);
        if (r4 == null) goto L23;
        r0 = R.id.iv_check_moon;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r12, R.id.iv_check_moon);
        if (r5 == null) goto L23;
        r0 = R.id.iv_default;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r12, R.id.iv_default);
        if (r6 == null) goto L23;
        r0 = R.id.iv_moon;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r12, R.id.iv_moon);
        if (r7 == null) goto L23;
        r0 = R.id.left_panel;
        RelativeLayout r8 = (RelativeLayout) ViewBindings.findChildViewById(r12, R.id.left_panel);
        if (r8 == null) goto L23;
        r0 = R.id.right_panel;
        RelativeLayout r9 = (RelativeLayout) ViewBindings.findChildViewById(r12, R.id.right_panel);
        if (r9 == null) goto L23;
        r0 = R.id.video_player_view;
        VideoPlayerView r10 = (VideoPlayerView) ViewBindings.findChildViewById(r12, R.id.video_player_view);
        if (r10 == null) goto L23;
        r0 = R.id.view_title;
        OFloatingTitleBar r11 = (OFloatingTitleBar) ViewBindings.findChildViewById(r12, R.id.view_title);
        if (r11 == null) goto L23;
        return new ChargingAnimationLayoutBinding((RelativeLayout) r12, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
