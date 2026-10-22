package com.android.settings.widget;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.VideoView;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.Utils;

/* JADX INFO: loaded from: classes.dex */
public class VideoPlayerView extends FrameLayout {
    private static final int sInterval = 20;
    private Handler mHandler;
    private ImageView mPhoneFrameImage;
    private ImageView mPreviewImage;
    private VideoView mVideoView;

    static /* synthetic */ VideoView access$000(VideoPlayerView r0) {
        return r0.mVideoView;
    }

    static /* synthetic */ void access$100(VideoPlayerView r0) {
        r0.loopCheckVideoPosition();
    }

    static /* synthetic */ ImageView access$200(VideoPlayerView r0) {
        return r0.mPreviewImage;
    }

    public VideoPlayerView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public VideoPlayerView(Context r2, AttributeSet r3, int r4) {
        this(r2, r3, r4, 0);
    }

    public VideoPlayerView(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.mHandler = new AnonymousClass1(this);
        View r5 = LayoutInflater.from(r1).inflate(R.layout.video_player_layout, this, true);
        this.mPreviewImage = (ImageView) r5.findViewById(R.id.preview_image);
        this.mVideoView = (VideoView) r5.findViewById(R.id.video_view);
        ImageView r6 = (ImageView) r5.findViewById(R.id.phone_frame);
        this.mPhoneFrameImage = r6;
        r6.setImageResource(getPhoneFrameRes());
        this.mVideoView.setOnPreparedListener(new AnonymousClass2(this));
    }

    private int getPhoneFrameRes() {
        if (needProcessSpecially() == false) goto L7;
        return Utils.getSpecialPhoneFrameResId();
    L7:
        return Utils.getPhoneFrameResId();
    }

    private boolean needProcessSpecially() {
        if (Utils.isCameraInScreen() == false) goto L5;
    L8:
        return true;
    L5:
        if (SettingsFeature.isDiggingScreen() == true) goto L8;
        return false;
    }

    public void setVideoUri(Uri r1) {
        this.mVideoView.setVideoURI(r1);
    }

    public void start() {
        loopCheckVideoPosition();
        this.mVideoView.start();
    }

    public void stop() {
        this.mVideoView.stopPlayback();
        this.mPreviewImage.setVisibility(0);
    }

    public void hidePreview() {
        this.mPreviewImage.setVisibility(8);
    }

    private void loopCheckVideoPosition() {
        this.mHandler.sendEmptyMessageDelayed(0, 20);
    }
}
