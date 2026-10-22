package com.obric.common.oea.style.scene.alpha.alphaplayer.player;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbsPlayer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/AbsPlayer;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "completionListener", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnCompletionListener;", "getCompletionListener", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnCompletionListener;", "setCompletionListener", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnCompletionListener;)V", "errorListener", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnErrorListener;", "getErrorListener", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnErrorListener;", "setErrorListener", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnErrorListener;)V", "firstFrameListener", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnFirstFrameListener;", "getFirstFrameListener", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnFirstFrameListener;", "setFirstFrameListener", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnFirstFrameListener;)V", "preparedListener", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnPreparedListener;", "getPreparedListener", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnPreparedListener;", "setPreparedListener", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer$OnPreparedListener;)V", "setOnCompletionListener", "", "setOnErrorListener", "setOnFirstFrameListener", "setOnPreparedListener", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsPlayer implements IMediaPlayer {
    private IMediaPlayer.OnCompletionListener completionListener;
    private IMediaPlayer.OnErrorListener errorListener;
    private IMediaPlayer.OnFirstFrameListener firstFrameListener;
    private IMediaPlayer.OnPreparedListener preparedListener;

    /* JADX WARN: Multi-variable type inference failed */
    public AbsPlayer() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public AbsPlayer(Context r1) {
    }

    public /* synthetic */ AbsPlayer(Context r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
        Context r4 = (Context) null;
    L5:
        this(r1);
    }

    public final IMediaPlayer.OnCompletionListener getCompletionListener() {
        return this.completionListener;
    }

    public final void setCompletionListener(IMediaPlayer.OnCompletionListener r1) {
        this.completionListener = r1;
    }

    public final IMediaPlayer.OnPreparedListener getPreparedListener() {
        return this.preparedListener;
    }

    public final void setPreparedListener(IMediaPlayer.OnPreparedListener r1) {
        this.preparedListener = r1;
    }

    public final IMediaPlayer.OnErrorListener getErrorListener() {
        return this.errorListener;
    }

    public final void setErrorListener(IMediaPlayer.OnErrorListener r1) {
        this.errorListener = r1;
    }

    public final IMediaPlayer.OnFirstFrameListener getFirstFrameListener() {
        return this.firstFrameListener;
    }

    public final void setFirstFrameListener(IMediaPlayer.OnFirstFrameListener r1) {
        this.firstFrameListener = r1;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener r2) {
        Intrinsics.checkNotNullParameter(r2, "completionListener");
        this.completionListener = r2;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener r2) {
        Intrinsics.checkNotNullParameter(r2, "preparedListener");
        this.preparedListener = r2;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void setOnErrorListener(IMediaPlayer.OnErrorListener r2) {
        Intrinsics.checkNotNullParameter(r2, "errorListener");
        this.errorListener = r2;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer
    public void setOnFirstFrameListener(IMediaPlayer.OnFirstFrameListener r2) {
        Intrinsics.checkNotNullParameter(r2, "firstFrameListener");
        this.firstFrameListener = r2;
    }
}
