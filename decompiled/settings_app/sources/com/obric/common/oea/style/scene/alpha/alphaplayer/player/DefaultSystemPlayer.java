package com.obric.common.oea.style.scene.alpha.alphaplayer.player;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.Surface;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.VideoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DefaultSystemPlayer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\u0017H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/DefaultSystemPlayer;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/AbsPlayer;", "()V", "dataPath", "", "getDataPath", "()Ljava/lang/String;", "setDataPath", "(Ljava/lang/String;)V", "mediaPlayer", "Landroid/media/MediaPlayer;", "getMediaPlayer", "()Landroid/media/MediaPlayer;", "setMediaPlayer", "(Landroid/media/MediaPlayer;)V", "retriever", "Landroid/media/MediaMetadataRetriever;", "getRetriever", "()Landroid/media/MediaMetadataRetriever;", "getPlayerType", "getVideoInfo", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/VideoInfo;", "initMediaPlayer", "", "pause", "prepareAsync", "release", "reset", "setDataSource", "setLooping", "looping", "", "setScreenOnWhilePlaying", "onWhilePlaying", "setSurface", "surface", "Landroid/view/Surface;", "start", "stop", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class DefaultSystemPlayer extends AbsPlayer {
    public String dataPath;
    public MediaPlayer mediaPlayer;
    private final MediaMetadataRetriever retriever;

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public String getPlayerType() {
        return "DefaultSystemPlayer";
    }

    public DefaultSystemPlayer() {
        super(null, 1, null);
        this.retriever = new MediaMetadataRetriever();
    }

    public final MediaPlayer getMediaPlayer() {
        MediaPlayer r1 = this.mediaPlayer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        return r1;
    }

    public final void setMediaPlayer(MediaPlayer r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mediaPlayer = r2;
    }

    public final MediaMetadataRetriever getRetriever() {
        return this.retriever;
    }

    public final String getDataPath() {
        String r1 = this.dataPath;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dataPath");
    L5:
        return r1;
    }

    public final void setDataPath(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.dataPath = r2;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void initMediaPlayer() {
        MediaPlayer r0 = new MediaPlayer();
        this.mediaPlayer = r0;
        r0.setOnCompletionListener(new AnonymousClass1(this));
        MediaPlayer r1 = this.mediaPlayer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.setOnPreparedListener(new AnonymousClass2(this));
        MediaPlayer r2 = this.mediaPlayer;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L8:
        r2.setOnErrorListener(new AnonymousClass3(this));
        MediaPlayer r3 = this.mediaPlayer;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L11:
        r3.setOnInfoListener(new AnonymousClass4(this));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void setSurface(Surface r2) {
        Intrinsics.checkNotNullParameter(r2, "surface");
        MediaPlayer r1 = this.mediaPlayer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.setSurface(r2);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void setDataSource(String r2) {
        Intrinsics.checkNotNullParameter(r2, "dataPath");
        this.dataPath = r2;
        MediaPlayer r1 = this.mediaPlayer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.setDataSource(r2);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void prepareAsync() {
        MediaPlayer r1 = this.mediaPlayer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.prepareAsync();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void start() {
        MediaPlayer r1 = this.mediaPlayer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.start();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void pause() {
        MediaPlayer r1 = this.mediaPlayer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.pause();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void stop() {
        MediaPlayer r1 = this.mediaPlayer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.stop();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void reset() {
        MediaPlayer r0 = this.mediaPlayer;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r0.reset();
        this.dataPath = "";
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void release() {
        MediaPlayer r0 = this.mediaPlayer;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r0.release();
        this.dataPath = "";
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void setLooping(boolean r2) {
        MediaPlayer r1 = this.mediaPlayer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.setLooping(r2);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean r2) {
        MediaPlayer r1 = this.mediaPlayer;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mediaPlayer");
    L5:
        r1.setScreenOnWhilePlaying(r2);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public VideoInfo getVideoInfo() {
        String r0 = this.dataPath;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dataPath");
    L6:
        if (TextUtils.isEmpty(r0) == true) goto L19;
        MediaMetadataRetriever r1 = this.retriever;
        String r2 = this.dataPath;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("dataPath");
    L10:
        r1.setDataSource(r2);
        String r3 = this.retriever.extractMetadata(18);
        String r4 = this.retriever.extractMetadata(19);
        if (TextUtils.isEmpty(r3) == true) goto L17;
        if (TextUtils.isEmpty(r4) == true) goto L17;
        String r5 = this.retriever.extractMetadata(18);
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNullExpressionValue(r5, "retriever.extractMetadat…TADATA_KEY_VIDEO_WIDTH)!!");
        int r6 = Integer.parseInt(r5);
        String r7 = this.retriever.extractMetadata(19);
        Intrinsics.checkNotNull(r7);
        Intrinsics.checkNotNullExpressionValue(r7, "retriever.extractMetadat…ADATA_KEY_VIDEO_HEIGHT)!!");
        return new VideoInfo(r6, Integer.parseInt(r7));
    L17:
        throw new Exception("DefaultSystemPlayer get metadata failure!");
    L19:
        throw new Exception("dataPath is null, please set setDataSource firstly!");
    }
}
