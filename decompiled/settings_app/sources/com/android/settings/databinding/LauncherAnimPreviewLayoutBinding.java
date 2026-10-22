package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SelectOptionsView;
import com.android.settings.widget.VideoPlayerView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class LauncherAnimPreviewLayoutBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final SelectOptionsView selectOptionsView;
    public final VideoPlayerView videoPlayerView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LauncherAnimPreviewLayoutBinding(RelativeLayout r1, SelectOptionsView r2, VideoPlayerView r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.selectOptionsView = r2;
        this.videoPlayerView = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LauncherAnimPreviewLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LauncherAnimPreviewLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.launcher_anim_preview_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LauncherAnimPreviewLayoutBinding bind(View r4) {
        int r0 = R.id.select_options_view;
        SelectOptionsView r1 = (SelectOptionsView) ViewBindings.findChildViewById(r4, R.id.select_options_view);
        if (r1 == null) goto L11;
        r0 = R.id.video_player_view;
        VideoPlayerView r2 = (VideoPlayerView) ViewBindings.findChildViewById(r4, R.id.video_player_view);
        if (r2 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r3 == null) goto L11;
        return new LauncherAnimPreviewLayoutBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
