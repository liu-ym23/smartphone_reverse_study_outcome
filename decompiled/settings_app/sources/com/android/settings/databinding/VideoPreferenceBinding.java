package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class VideoPreferenceBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final VideoView video;
    public final ImageView videoBackground;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private VideoPreferenceBinding(RelativeLayout r1, VideoView r2, ImageView r3) {
        this.rootView = r1;
        this.video = r2;
        this.videoBackground = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VideoPreferenceBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static VideoPreferenceBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.video_preference, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static VideoPreferenceBinding bind(View r3) {
        int r0 = R.id.video;
        VideoView r1 = (VideoView) ViewBindings.findChildViewById(r3, R.id.video);
        if (r1 == null) goto L9;
        r0 = R.id.video_background;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r3, R.id.video_background);
        if (r2 == null) goto L9;
        return new VideoPreferenceBinding((RelativeLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
