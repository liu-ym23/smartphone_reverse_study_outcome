package com.android.settings.fingerprint;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintLocationAnimationVideoView extends TextureView implements FingerprintFindSensorAnimation {
    protected float mAspect;
    protected MediaPlayer mMediaPlayer;

    static /* synthetic */ Context access$000(FingerprintLocationAnimationVideoView r0) {
        return r0.mContext;
    }

    static /* synthetic */ Uri access$100(Context r0, int r1) {
        return resourceEntryToUri(r0, r1);
    }

    static /* synthetic */ Context access$200(FingerprintLocationAnimationVideoView r0) {
        return r0.mContext;
    }

    public FingerprintLocationAnimationVideoView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mAspect = 1.0f;
    }

    @Override // android.view.View
    protected void onMeasure(int r2, int r3) {
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(Math.round(this.mAspect * View.MeasureSpec.getSize(r2)), 1073741824));
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setSurfaceTextureListener(new AnonymousClass1(this));
    }

    private static Uri resourceEntryToUri(Context r3, int r4) {
        Resources r5 = r3.getResources();
        return Uri.parse("android.resource://" + r5.getResourcePackageName(r4) + IOUtils.DIR_SEPARATOR_UNIX + r5.getResourceTypeName(r4) + IOUtils.DIR_SEPARATOR_UNIX + r5.getResourceEntryName(r4));
    }

    @Override // com.android.settings.fingerprint.FingerprintFindSensorAnimation
    public void startAnimation() {
        MediaPlayer r0 = this.mMediaPlayer;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isPlaying() == true) goto L9;
        this.mMediaPlayer.start();
        return;
    }

    @Override // com.android.settings.fingerprint.FingerprintFindSensorAnimation
    public void stopAnimation() {
        MediaPlayer r0 = this.mMediaPlayer;
        if (r0 == null) goto L6;
        r0.stop();
        this.mMediaPlayer.release();
        this.mMediaPlayer = null;
        return;
    }

    @Override // com.android.settings.fingerprint.FingerprintFindSensorAnimation
    public void pauseAnimation() {
        MediaPlayer r0 = this.mMediaPlayer;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isPlaying() == false) goto L9;
        this.mMediaPlayer.pause();
        return;
    }
}
