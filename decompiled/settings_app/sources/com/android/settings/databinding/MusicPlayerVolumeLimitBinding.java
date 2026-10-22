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
import com.obric.oui.slider.OSlider;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class MusicPlayerVolumeLimitBinding implements ViewBinding {
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OSlider seekbarLayout;
    public final OFloatingTitleBar viewTitle;
    public final TextView volumeLimitTips;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private MusicPlayerVolumeLimitBinding(RelativeLayout r1, LinearLayout r2, OScrollView r3, OSlider r4, OFloatingTitleBar r5, TextView r6) {
        this.rootView = r1;
        this.pageContainer = r2;
        this.pageScrollview = r3;
        this.seekbarLayout = r4;
        this.viewTitle = r5;
        this.volumeLimitTips = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MusicPlayerVolumeLimitBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MusicPlayerVolumeLimitBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.music_player_volume_limit, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static MusicPlayerVolumeLimitBinding bind(View r9) {
        int r0 = R.id.page_container;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.page_container);
        if (r4 == null) goto L15;
        r0 = R.id.page_scrollview;
        OScrollView r5 = (OScrollView) ViewBindings.findChildViewById(r9, R.id.page_scrollview);
        if (r5 == null) goto L15;
        r0 = R.id.seekbar_layout;
        OSlider r6 = (OSlider) ViewBindings.findChildViewById(r9, R.id.seekbar_layout);
        if (r6 == null) goto L15;
        r0 = R.id.view_title;
        OFloatingTitleBar r7 = (OFloatingTitleBar) ViewBindings.findChildViewById(r9, R.id.view_title);
        if (r7 == null) goto L15;
        r0 = R.id.volume_limit_tips;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r9, R.id.volume_limit_tips);
        if (r8 == null) goto L15;
        return new MusicPlayerVolumeLimitBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
