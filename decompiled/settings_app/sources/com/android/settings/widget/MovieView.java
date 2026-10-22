package com.android.settings.widget;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.android.settings.R;
import com.obric.olog.OLog;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class MovieView extends FrameLayout {
    private static final String TAG = "MovieView";
    private ImageView mIvMask;
    private MediaPlayer mMediaPlayer;
    private int mSavedCurrentPosition;
    private int mVideoResourceId;

    static /* synthetic */ MediaPlayer access$000(MovieView r0) {
        return r0.mMediaPlayer;
    }

    static /* synthetic */ MediaPlayer access$002(MovieView r0, MediaPlayer r1) {
        r0.mMediaPlayer = r1;
        return r1;
    }

    static /* synthetic */ void access$100(MovieView r0, Surface r1) {
        r0.openVideo(r1);
    }

    static /* synthetic */ void access$200(MovieView r0) {
        r0.play();
    }

    static /* synthetic */ int access$300(MovieView r0) {
        return r0.mSavedCurrentPosition;
    }

    static /* synthetic */ int access$302(MovieView r0, int r1) {
        r0.mSavedCurrentPosition = r1;
        return r1;
    }

    static /* synthetic */ void access$400(MovieView r0) {
        r0.pause();
    }

    static /* synthetic */ ImageView access$500(MovieView r0) {
        return r0.mIvMask;
    }

    static /* synthetic */ void access$600(MovieView r0) {
        r0.hideMask();
    }

    public MovieView(Context r2) {
        this(r2, null);
    }

    public MovieView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public MovieView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        inflate(r4, R.layout.view_movie, this);
        TextureView r0 = (TextureView) findViewById(R.id.surface);
        this.mIvMask = (ImageView) findViewById(R.id.iv_mask);
        TypedArray r7 = r4.obtainStyledAttributes(r5, R.styleable.MovieView, r6, R.style.MovieView);
        setVideoResourceId(r7.getResourceId(0, 0));
        setMaskRes(r7.getResourceId(1, 0));
        r7.recycle();
        r0.setSurfaceTextureListener(new AnonymousClass1(this));
    }

    public void setMaskRes(int r1) {
        ImageView r0 = this.mIvMask;
        if (r0 == null) goto L6;
        r0.setImageResource(r1);
        return;
    }

    public void setVideoResourceId(int r1) {
        this.mVideoResourceId = r1;
    }

    public boolean isPlaying() {
        MediaPlayer r0 = this.mMediaPlayer;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isPlaying() == false) goto L7;
        return true;
    }

    private void play() {
        MediaPlayer r0 = this.mMediaPlayer;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.start();
        setKeepScreenOn(true);
    }

    private void pause() {
        MediaPlayer r0 = this.mMediaPlayer;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.pause();
        setKeepScreenOn(false);
    }

    private void openVideo(Surface r2) {
        if (this.mVideoResourceId != 0) goto L5;
        return;
    L5:
        MediaPlayer r0 = new MediaPlayer();
        this.mMediaPlayer = r0;
        r0.setSurface(r2);
    }

    private void startVideo() {
        this.mMediaPlayer.reset();
        this.mMediaPlayer.setOnInfoListener(new AnonymousClass2(this));
        this.mMediaPlayer.setLooping(true);
        AssetFileDescriptor r0 = getResources().openRawResourceFd(this.mVideoResourceId);     // Catch: IOException -> L15
        this.mMediaPlayer.setDataSource(r0.getFileDescriptor(), r0.getStartOffset(), r0.getLength());     // Catch: Throwable -> L8
        this.mMediaPlayer.setOnPreparedListener(new AnonymousClass3(this));     // Catch: Throwable -> L8
        this.mMediaPlayer.prepareAsync();     // Catch: Throwable -> L8
        if (r0 == null) goto L23;
        r0.close();     // Catch: IOException -> L15
        return;
    L23:
        return;
    L8:
        th = move-exception;
        if (r0 != null) goto L21;
    L14:
        throw th;     // Catch: IOException -> L15
    L21:
        r0.close();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L15
    L15:
        e = move-exception;
        OLog.e(TAG, "Failed to open video" + e);
    }

    public void releaseVideo() {
        MediaPlayer r0 = this.mMediaPlayer;
        if (r0 == null) goto L6;
        r0.release();
        this.mMediaPlayer = null;
        return;
    }

    private void hideMask() {
        ImageView r0 = this.mIvMask;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() == 8) goto L9;
        this.mIvMask.setVisibility(8);
        return;
    }

    public void playVideo() {
        if (this.mMediaPlayer != null) goto L5;
        return;
    L5:
        startVideo();
        this.mMediaPlayer.start();
    }

    public void pauseVideo() {
        MediaPlayer r0 = this.mMediaPlayer;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.pause();
    }
}
