package com.android.setupwizardlib.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Animatable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.android.setupwizardlib.R;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class IllustrationVideoView extends TextureView implements Animatable, TextureView.SurfaceTextureListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnInfoListener, MediaPlayer.OnErrorListener {
    private static final String TAG = "IllustrationVideoView";
    protected float mAspectRatio;
    protected MediaPlayer mMediaPlayer;
    private boolean prepared;
    Surface surface;
    private int videoResId;
    private String videoResPackageName;

    protected void onRenderingStart() {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture r1) {
    }

    protected boolean shouldLoop() {
        return true;
    }

    public IllustrationVideoView(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mAspectRatio = 1.0f;
        this.videoResId = 0;
        TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.SuwIllustrationVideoView);
        int r6 = r5.getResourceId(R.styleable.SuwIllustrationVideoView_suwVideo, 0);
        r5.recycle();
        setVideoResource(r6);
        setScaleX(0.9999999f);
        setScaleX(0.9999999f);
        setSurfaceTextureListener(this);
    }

    @Override // android.view.View
    protected void onMeasure(int r5, int r6) {
        int r7 = View.MeasureSpec.getSize(r5);
        int r8 = View.MeasureSpec.getSize(r6);
        float r0 = r8;
        float r1 = r7;
        float r2 = this.mAspectRatio;
        if (r0 >= (r1 * r2)) goto L5;
        r7 = (int) (r0 / r2);
    L6:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r7, 1073741824), View.MeasureSpec.makeMeasureSpec(r8, 1073741824));
        return;
    L5:
        r8 = (int) (r1 * r2);
        goto L6
    }

    public void setVideoResource(int r2, String r3) {
        if (r2 != this.videoResId) goto L7;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.equals(this.videoResPackageName) == false) goto L7;
        return;
    L7:
        this.videoResId = r2;
        this.videoResPackageName = r3;
        createMediaPlayer();
    }

    public void setVideoResource(int r2) {
        setVideoResource(r2, getContext().getPackageName());
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        if (r1 == false) goto L5;
        start();
        return;
    L5:
        stop();
    }

    protected void createMediaPlayer() {
        MediaPlayer r0 = this.mMediaPlayer;
        if (r0 == null) goto L6;
        r0.release();
    L6:
        if (this.surface != null) goto L8;
        return;
    L8:
        if (this.videoResId == 0) goto L13;
        MediaPlayer r1 = new MediaPlayer();
        this.mMediaPlayer = r1;
        r1.setSurface(this.surface);
        this.mMediaPlayer.setOnPreparedListener(this);
        this.mMediaPlayer.setOnSeekCompleteListener(this);
        this.mMediaPlayer.setOnInfoListener(this);
        this.mMediaPlayer.setOnErrorListener(this);
        setVideoResourceInternal(this.videoResId, this.videoResPackageName);
        return;
    }

    private void setVideoResourceInternal(int r3, String r4) {
        this.mMediaPlayer.setDataSource(getContext(), Uri.parse("android.resource://" + r4 + LibrarianImpl.Constants.SEPARATOR + r3), null);     // Catch: IOException -> L5
        this.mMediaPlayer.prepareAsync();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        Log.wtf(TAG, "Unable to set data source", e);
    }

    protected void createSurface() {
        Surface r0 = this.surface;
        if (r0 == null) goto L5;
        r0.release();
        this.surface = null;
    L5:
        SurfaceTexture r1 = getSurfaceTexture();
        if (r1 == null) goto L9;
        setVisibility(4);
        this.surface = new Surface(r1);
        return;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        if (r1 != 0) goto L5;
        reattach();
        return;
    L5:
        release();
    }

    public void release() {
        MediaPlayer r0 = this.mMediaPlayer;
        if (r0 == null) goto L5;
        r0.release();
        this.mMediaPlayer = null;
        this.prepared = false;
    L5:
        Surface r1 = this.surface;
        if (r1 == null) goto L9;
        r1.release();
        this.surface = null;
        return;
    }

    private void reattach() {
        if (this.surface != null) goto L6;
        initVideo();
        return;
    }

    private void initVideo() {
        if (getWindowVisibility() == 0) goto L5;
        return;
    L5:
        createSurface();
        if (this.surface == null) goto L8;
        createMediaPlayer();
        return;
    L8:
        Log.w(TAG, "Surface creation failed");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture r1, int r2, int r3) {
        setVisibility(4);
        initVideo();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture r1) {
        release();
        return true;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.prepared == false) goto L10;
        MediaPlayer r0 = this.mMediaPlayer;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isPlaying() == true) goto L12;
        this.mMediaPlayer.start();
        return;
    L12:
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.prepared == false) goto L8;
        MediaPlayer r1 = this.mMediaPlayer;
        if (r1 == null) goto L9;
        r1.pause();
        return;
    L9:
        return;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        MediaPlayer r0 = this.mMediaPlayer;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isPlaying() == false) goto L7;
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer r1, int r2, int r3) {
        if (r2 != 3) goto L5;
        setVisibility(0);
        onRenderingStart();
    L5:
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer r3) {
        this.prepared = true;
        r3.setLooping(shouldLoop());
        if (r3.getVideoWidth() > 0) goto L5;
    L7:
        Log.w(TAG, "Unexpected video size=" + r3.getVideoWidth() + MaterialConfigFormatNames.X + r3.getVideoHeight());
        float r0 = 0.0f;
    L9:
        if (Float.compare(this.mAspectRatio, r0) == 0) goto L12;
        this.mAspectRatio = r0;
        requestLayout();
    L12:
        if (getWindowVisibility() != 0) goto L15;
        start();
        return;
    L15:
        return;
    L5:
        if (r3.getVideoHeight() <= 0) goto L7;
        r0 = r3.getVideoHeight() / r3.getVideoWidth();
        goto L9
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer r1) {
        if (isPrepared() == false) goto L5;
        r1.start();
        return;
    L5:
        Log.wtf(TAG, "Seek complete but media player not prepared");
    }

    public int getCurrentPosition() {
        MediaPlayer r0 = this.mMediaPlayer;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.getCurrentPosition();
    }

    protected boolean isPrepared() {
        return this.prepared;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer r1, int r2, int r3) {
        Log.w(TAG, "MediaPlayer error. what=" + r2 + " extra=" + r3);
        return false;
    }
}
