package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class VideoPlayerLayoutBinding implements ViewBinding {
    public final ImageView phoneFrame;
    public final ImageView previewImage;
    private final View rootView;
    public final VideoView videoView;

    private VideoPlayerLayoutBinding(View r1, ImageView r2, ImageView r3, VideoView r4) {
        this.rootView = r1;
        this.phoneFrame = r2;
        this.previewImage = r3;
        this.videoView = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static VideoPlayerLayoutBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.video_player_layout, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static VideoPlayerLayoutBinding bind(View r4) {
        int r0 = R.id.phone_frame;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r4, R.id.phone_frame);
        if (r1 == null) goto L11;
        r0 = R.id.preview_image;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r4, R.id.preview_image);
        if (r2 == null) goto L11;
        r0 = R.id.video_view;
        VideoView r3 = (VideoView) ViewBindings.findChildViewById(r4, R.id.video_view);
        if (r3 == null) goto L11;
        return new VideoPlayerLayoutBinding(r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
