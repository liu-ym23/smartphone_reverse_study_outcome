package com.obric.common.oea.style.scene.alpha.alphaplayer.controller;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.obric.common.oea.style.scene.alpha.alphaplayer.IMonitor;
import com.obric.common.oea.style.scene.alpha.alphaplayer.IPlayerAction;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.Configuration;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.DataSource;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.VideoInfo;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.DefaultSystemPlayer;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.IMediaPlayer;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;
import com.obric.common.oea.style.scene.alpha.alphaplayer.render.VideoRenderer;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLSurfaceView;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.AlphaVideoGLTextureView;
import com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayerController.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\u0015\u001c\b\u0016\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\\B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB'\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020(H\u0002J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0002J\b\u00103\u001a\u000204H\u0016J\u0006\u00105\u001a\u00020#J\b\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020.H\u0016J\b\u0010:\u001a\u00020(H\u0003J\b\u0010;\u001a\u00020(H\u0002J\u0010\u0010;\u001a\u00020(2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010<\u001a\u00020(H\u0002J\b\u0010=\u001a\u00020(H\u0002J\b\u0010>\u001a\u00020(H\u0003J,\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020\u00132\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u0010A\u001a\u0002002\u0006\u0010B\u001a\u000204H\u0002J\b\u0010C\u001a\u00020(H\u0007J\b\u0010D\u001a\u00020(H\u0007J\b\u0010E\u001a\u00020(H\u0007J\b\u0010F\u001a\u00020(H\u0007J\b\u0010G\u001a\u00020(H\u0003J\b\u0010H\u001a\u00020(H\u0016J\b\u0010I\u001a\u00020(H\u0003J\b\u0010J\u001a\u00020(H\u0016J\b\u0010K\u001a\u00020(H\u0016J\b\u0010L\u001a\u00020(H\u0016J\u0010\u0010M\u001a\u00020(2\u0006\u00109\u001a\u00020.H\u0002J\u0010\u0010N\u001a\u00020(2\u0006\u0010O\u001a\u00020%H\u0003J\u0010\u0010P\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0018H\u0016J\u0010\u0010Q\u001a\u00020(2\u0006\u0010R\u001a\u00020\u001aH\u0016J\u0010\u0010S\u001a\u00020(2\u0006\u0010O\u001a\u00020%H\u0003J\u0010\u0010T\u001a\u00020(2\u0006\u0010U\u001a\u000200H\u0016J\u0010\u0010V\u001a\u00020(2\u0006\u0010O\u001a\u00020%H\u0016J\b\u0010W\u001a\u00020(H\u0003J\b\u0010X\u001a\u00020(H\u0016J\u0010\u0010Y\u001a\u00020(2\u0006\u0010Z\u001a\u00020[H\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006]"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/os/Handler$Callback;", "configuration", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/Configuration;", "mediaPlayer", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer;", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/Configuration;Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer;)V", "context", "Landroid/content/Context;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "alphaVideoViewType", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/AlphaVideoViewType;", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/AlphaVideoViewType;Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/IMediaPlayer;)V", "alphaVideoView", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/IAlphaVideoView;", "isPlaying", "", "mErrorListener", "com/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController$mErrorListener$1", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController$mErrorListener$1;", "mMonitor", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/IMonitor;", "mPlayerAction", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/IPlayerAction;", "mPreparedListener", "com/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController$mPreparedListener$1", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController$mPreparedListener$1;", "mainHandler", "Landroid/os/Handler;", "playThread", "Landroid/os/HandlerThread;", "playerState", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/player/PlayerState;", "suspendDataSource", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/DataSource;", "workHandler", "attachAlphaView", "", "parentView", "Landroid/view/ViewGroup;", "detachAlphaView", "emitEndSignal", "getMessage", "Landroid/os/Message;", "what", "", "obj", "", "getPlayerType", "", "getStatus", "getView", "Landroid/view/View;", "handleMessage", NotificationCompat.CATEGORY_MESSAGE, "handleSuspendedEvent", "init", "initAlphaView", "initMediaPlayer", "initPlayer", "monitor", "state", "extra", "errorInfo", "onDestroy", "onPause", "onResume", "onStop", "parseVideoSize", "pause", "prepareAsync", "release", "reset", "resume", "sendMessage", "setDataSource", "dataSource", "setMonitor", "setPlayerAction", "playerAction", "setVideoFromFile", "setVisibility", "visibility", "start", "startPlay", "stop", "surfacePrepared", "surface", "Landroid/view/Surface;", "Companion", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public class PlayerController implements IPlayerControllerExt, LifecycleObserver, Handler.Callback {
    public static final Companion Companion = null;
    public static final int DESTROY = 7;
    public static final int INIT_MEDIA_PLAYER = 1;
    public static final int PAUSE = 4;
    public static final int RESET = 9;
    public static final int RESUME = 5;
    public static final int SET_DATA_SOURCE = 2;
    public static final int START = 3;
    public static final int STOP = 6;
    public static final int SURFACE_PREPARED = 8;
    public static final String TAG = "PlayerController";
    private IAlphaVideoView alphaVideoView;
    private AlphaVideoViewType alphaVideoViewType;
    private Context context;
    private boolean isPlaying;
    private final PlayerController$mErrorListener$1 mErrorListener;
    private IMonitor mMonitor;
    private IPlayerAction mPlayerAction;
    private final PlayerController$mPreparedListener$1 mPreparedListener;
    private final Handler mainHandler;
    private IMediaPlayer mediaPlayer;
    private LifecycleOwner owner;
    private HandlerThread playThread;
    private PlayerState playerState;
    private DataSource suspendDataSource;
    private Handler workHandler;

    /* JADX INFO: compiled from: PlayerController.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/PlayerController$Companion;", "", "()V", "DESTROY", "", "INIT_MEDIA_PLAYER", "PAUSE", "RESET", "RESUME", "SET_DATA_SOURCE", "START", "STOP", "SURFACE_PREPARED", "TAG", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = null;

        static {
            int[] r0 = new int[AlphaVideoViewType.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[AlphaVideoViewType.GL_SURFACE_VIEW.ordinal()] = 1;
            r0[AlphaVideoViewType.GL_TEXTURE_VIEW.ordinal()] = 2;
            int[] r1 = new int[PlayerState.values().length];
            $EnumSwitchMapping$1 = r1;
            r1[PlayerState.PREPARED.ordinal()] = 1;
            r1[PlayerState.PAUSED.ordinal()] = 2;
            r1[PlayerState.NOT_PREPARED.ordinal()] = 3;
            r1[PlayerState.STOPPED.ordinal()] = 4;
            int[] r2 = new int[PlayerState.values().length];
            $EnumSwitchMapping$2 = r2;
            r2[PlayerState.STARTED.ordinal()] = 1;
            int[] r3 = new int[PlayerState.values().length];
            $EnumSwitchMapping$3 = r3;
            r3[PlayerState.STARTED.ordinal()] = 1;
            r3[PlayerState.PAUSED.ordinal()] = 2;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ void access$emitEndSignal(PlayerController r0) {
        r0.emitEndSignal();
    }

    public static final /* synthetic */ IAlphaVideoView access$getAlphaVideoView$p(PlayerController r1) {
        IAlphaVideoView r2 = r1.alphaVideoView;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        return r2;
    }

    public static final /* synthetic */ IPlayerAction access$getMPlayerAction$p(PlayerController r0) {
        return r0.mPlayerAction;
    }

    public static final /* synthetic */ Message access$getMessage(PlayerController r0, int r1, Object r2) {
        return r0.getMessage(r1, r2);
    }

    public static final /* synthetic */ PlayerState access$getPlayerState$p(PlayerController r0) {
        return r0.playerState;
    }

    public static final /* synthetic */ void access$monitor(PlayerController r0, boolean r1, int r2, int r3, String r4) {
        r0.monitor(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void access$sendMessage(PlayerController r0, Message r1) {
        r0.sendMessage(r1);
    }

    public static final /* synthetic */ void access$setAlphaVideoView$p(PlayerController r0, IAlphaVideoView r1) {
        r0.alphaVideoView = r1;
    }

    public static final /* synthetic */ void access$setMPlayerAction$p(PlayerController r0, IPlayerAction r1) {
        r0.mPlayerAction = r1;
    }

    public static final /* synthetic */ void access$setPlayerState$p(PlayerController r0, PlayerState r1) {
        r0.playerState = r1;
    }

    public /* synthetic */ PlayerController(Configuration r1, IMediaPlayer r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
        IMediaPlayer r5 = (IMediaPlayer) null;
    L5:
        this(r1, r2);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController$mPreparedListener$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController$mErrorListener$1] */
    public PlayerController(Configuration r3, DefaultSystemPlayer r4) {
        Intrinsics.checkNotNullParameter(r3, "configuration");
        this.playerState = PlayerState.NOT_PREPARED;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.mPreparedListener = new PlayerController$mPreparedListener$1(this);
        this.mErrorListener = new PlayerController$mErrorListener$1(this);
        this.context = r3.getContext();
        this.owner = r3.getLifecycleOwner();
        this.alphaVideoViewType = r3.getAlphaVideoViewType();
        if (r4 != null) goto L6;
        r4 = new DefaultSystemPlayer();
    L6:
        this.mediaPlayer = r4;
        init();
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController$mPreparedListener$1] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.obric.common.oea.style.scene.alpha.alphaplayer.controller.PlayerController$mErrorListener$1] */
    public PlayerController(Context r3, LifecycleOwner r4, AlphaVideoViewType r5, IMediaPlayer r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "owner");
        Intrinsics.checkNotNullParameter(r5, "alphaVideoViewType");
        Intrinsics.checkNotNullParameter(r6, "mediaPlayer");
        this.playerState = PlayerState.NOT_PREPARED;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.mPreparedListener = new PlayerController$mPreparedListener$1(this);
        this.mErrorListener = new PlayerController$mErrorListener$1(this);
        this.context = r3;
        this.owner = r4;
        this.alphaVideoViewType = r5;
        this.mediaPlayer = r6;
        init();
    }

    private final void init() {
        init(this.owner);
        initAlphaView();
        initMediaPlayer();
    }

    private final void init(LifecycleOwner r3) {
        r3.getLifecycle().addObserver(this);
        HandlerThread r4 = new HandlerThread("alpha-play-thread", 10);
        this.playThread = r4;
        Intrinsics.checkNotNull(r4);
        r4.start();
        HandlerThread r0 = this.playThread;
        Intrinsics.checkNotNull(r0);
        this.workHandler = new Handler(r0.getLooper(), this);
    }

    private final void initAlphaView() {
        AlphaVideoViewType r0 = this.alphaVideoViewType;
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L5;
        AlphaVideoGLSurfaceView r2 = new AlphaVideoGLSurfaceView(this.context, null);
    L10:
        this.alphaVideoView = r2;
        r2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r2.setPlayerController(this);
        r2.setVideoRenderer(new VideoRenderer(r2));
        return;
    L5:
        if (r1 != 2) goto L8;
        r2 = new AlphaVideoGLTextureView(this.context, null);
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }

    private final void initMediaPlayer() {
        sendMessage(getMessage(1, null));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void setPlayerAction(IPlayerAction r2) {
        Intrinsics.checkNotNullParameter(r2, "playerAction");
        this.mPlayerAction = r2;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void setMonitor(IMonitor r2) {
        Intrinsics.checkNotNullParameter(r2, "monitor");
        this.mMonitor = r2;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void setVisibility(int r3) {
        IAlphaVideoView r0 = this.alphaVideoView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        r0.setVisibility(r3);
        if (r3 != 0) goto L12;
        IAlphaVideoView r2 = this.alphaVideoView;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L10:
        r2.bringToFront();
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void attachAlphaView(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        IAlphaVideoView r1 = this.alphaVideoView;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        r1.addParentView(r2);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void detachAlphaView(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        IAlphaVideoView r1 = this.alphaVideoView;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        r1.removeParentView(r2);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        pause();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        resume();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        stop();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        release();
    }

    private final void sendMessage(Message r4) {
        HandlerThread r0 = this.playThread;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isAlive() == true) goto L7;
        return;
    L7:
        if (r0.isInterrupted() == false) goto L9;
        return;
    L9:
        if (this.workHandler != null) goto L11;
        this.workHandler = new Handler(r0.getLooper(), this);
    L11:
        Handler r3 = this.workHandler;
        Intrinsics.checkNotNull(r3);
        r3.sendMessageDelayed(r4, 0);
    }

    private final Message getMessage(int r1, Object r2) {
        Message r0 = Message.obtain();
        r0.what = r1;
        r0.obj = r2;
        Intrinsics.checkNotNullExpressionValue(r0, "message");
        return r0;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerControllerExt
    public void surfacePrepared(Surface r2) {
        Intrinsics.checkNotNullParameter(r2, "surface");
        sendMessage(getMessage(8, r2));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void start(DataSource r8) {
        Intrinsics.checkNotNullParameter(r8, "dataSource");
        if (r8.isValid() == false) goto L5;
        setVisibility(0);
        sendMessage(getMessage(2, r8));
        return;
    L5:
        emitEndSignal();
        monitor$default(this, false, 0, 0, "dataSource is invalid!", 6, null);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void pause() {
        sendMessage(getMessage(4, null));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void resume() {
        sendMessage(getMessage(5, null));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void stop() {
        sendMessage(getMessage(6, null));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void reset() {
        sendMessage(getMessage(9, null));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public void release() {
        sendMessage(getMessage(7, null));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public View getView() {
        IAlphaVideoView r1 = this.alphaVideoView;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L6:
        return r1.getView();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerController
    public String getPlayerType() {
        return this.mediaPlayer.getPlayerType();
    }

    public final PlayerState getStatus() {
        return this.playerState;
    }

    private final void initPlayer() {
        this.mediaPlayer.initMediaPlayer();     // Catch: Exception -> L4
    L6:
        this.mediaPlayer.setScreenOnWhilePlaying(true);
        this.mediaPlayer.setLooping(false);
        this.mediaPlayer.setOnFirstFrameListener(new C02161(this));
        this.mediaPlayer.setOnCompletionListener(new AnonymousClass2(this));
        return;
    L4:
        e = move-exception;
        DefaultSystemPlayer r1 = new DefaultSystemPlayer();
        this.mediaPlayer = r1;
        r1.initMediaPlayer();
        Log.e(TAG, "initPlayer failed " + e.getMessage());
        goto L6
    }

    private final void setDataSource(DataSource r8) {
        setVideoFromFile(r8);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        monitor$default(this, false, 0, 0, "alphaVideoView set dataSource failure: " + Log.getStackTraceString(e), 6, null);
        emitEndSignal();
    }

    private final void setVideoFromFile(DataSource r9) {
        this.mediaPlayer.reset();
        this.playerState = PlayerState.NOT_PREPARED;
        Resources r0 = this.context.getResources();
        Intrinsics.checkNotNullExpressionValue(r0, "context.resources");
        int r1 = r0.getConfiguration().orientation;
        String r2 = r9.getPath(r1);
        ScaleType r3 = r9.getScaleType(r1);
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L21:
        monitor$default(this, false, 0, 0, "dataPath is empty or File is not exists. path = " + r2, 6, null);
        emitEndSignal();
        return;
    L5:
        if (new File(r2).exists() == false) goto L21;
        if (r3 == null) goto L13;
        IAlphaVideoView r4 = this.alphaVideoView;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L12:
        r4.setScaleType(r3);
    L13:
        this.mediaPlayer.setLooping(r9.isLooping());
        this.mediaPlayer.setDataSource(r2);
        IAlphaVideoView r5 = this.alphaVideoView;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L17:
        if (r5.isSurfaceCreated() == false) goto L19;
        prepareAsync();
        return;
    L19:
        this.suspendDataSource = r9;
    }

    private final void handleSuspendedEvent() {
        DataSource r0 = this.suspendDataSource;
        if (r0 == null) goto L5;
        setVideoFromFile(r0);
    L5:
        DataSource r1 = (DataSource) null;
        this.suspendDataSource = null;
    }

    private final void prepareAsync() {
        IMediaPlayer r0 = this.mediaPlayer;
        if (this.playerState != PlayerState.NOT_PREPARED) goto L5;
    L6:
        r0.setOnPreparedListener(this.mPreparedListener);
        r0.setOnErrorListener(this.mErrorListener);
        r0.prepareAsync();
        return;
    L5:
        if (this.playerState == PlayerState.STOPPED) goto L6;
    }

    private final void startPlay() {
        PlayerState r0 = this.playerState;
        int r1 = WhenMappings.$EnumSwitchMapping$1[r0.ordinal()];
        if (r1 != 1) goto L5;
        this.mediaPlayer.start();
        this.isPlaying = true;
        this.playerState = PlayerState.STARTED;
        this.mainHandler.post(new RunnableC02181(this));
        return;
    L5:
        if (r1 != 2) goto L7;
        this.mediaPlayer.start();
        this.playerState = PlayerState.STARTED;
        return;
    L7:
        if (r1 != 3) goto L9;
    L18:
        prepareAsync();     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        monitor$default(this, false, 0, 0, "prepare and start MediaPlayer failure!", 6, null);
        emitEndSignal();
        return;
    L9:
        if (r1 == 4) goto L18;
    }

    private final void parseVideoSize() {
        final VideoInfo r0 = this.mediaPlayer.getVideoInfo();
        IAlphaVideoView r1 = this.alphaVideoView;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L5:
        r1.measureInternal(r0.getVideoWidth() / 2, r0.getVideoHeight());
        IAlphaVideoView r2 = this.alphaVideoView;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L8:
        final ScaleType r3 = r2.getScaleType();
        this.mainHandler.post(new RunnableC02171(this, r0, r3));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
        switch(r10.what) {
            case 1: goto L48;
            case 2: goto L43;
            case 3: goto L50;
            case 4: goto L36;
            case 5: goto L33;
            case 6: goto L26;
            case 7: goto L11;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L49;
        };
    L5:
        this.mediaPlayer.reset();
        this.playerState = PlayerState.NOT_PREPARED;
        this.isPlaying = false;
        goto L49
    L6:
        Object r11 = r10.obj;
        if (r11 == null) goto L10;
        this.mediaPlayer.setSurface((Surface) r11);
        handleSuspendedEvent();
        goto L49
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.Surface");
    L11:
        IAlphaVideoView r12 = this.alphaVideoView;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L14:
        r12.onPause();
        if (this.playerState != PlayerState.STARTED) goto L18;
        this.mediaPlayer.pause();
        this.playerState = PlayerState.PAUSED;
    L18:
        if (this.playerState != PlayerState.PAUSED) goto L20;
        this.mediaPlayer.stop();
        this.playerState = PlayerState.STOPPED;
    L20:
        this.mediaPlayer.release();
        IAlphaVideoView r13 = this.alphaVideoView;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("alphaVideoView");
    L23:
        r13.release();
        this.playerState = PlayerState.RELEASE;
        HandlerThread r9 = this.playThread;
        if (r9 == null) goto L49;
        r9.quit();
        r9.interrupt();
        goto L49
    L26:
        int r14 = WhenMappings.$EnumSwitchMapping$3[this.playerState.ordinal()];
        if (r14 != 1) goto L29;
    L31:
        this.mediaPlayer.pause();
        this.playerState = PlayerState.PAUSED;
        goto L49
    L29:
        if (r14 == 2) goto L31;
    L43:
        Object r15 = r10.obj;
        if (r15 == null) goto L47;
        setDataSource((DataSource) r15);
        goto L49
    L47:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.style.scene.alpha.alphaplayer.model.DataSource");
    L48:
        initPlayer();
    L49:
        return true;
    L50:
        parseVideoSize();     // Catch: Exception -> L41
        this.playerState = PlayerState.PREPARED;     // Catch: Exception -> L41
        startPlay();     // Catch: Exception -> L41
        Unit r16 = Unit.INSTANCE;     // Catch: Exception -> L41
    L41:
        e = move-exception;
        monitor$default(this, false, 0, 0, "start video failure: " + Log.getStackTraceString(e), 6, null);
        emitEndSignal();
        Unit r17 = Unit.INSTANCE;
        goto L49
    L33:
        if (this.isPlaying == false) goto L49;
        startPlay();
        goto L49
    L36:
        if (WhenMappings.$EnumSwitchMapping$2[this.playerState.ordinal()] != 1) goto L49;
        this.mediaPlayer.pause();
        this.playerState = PlayerState.PAUSED;
        goto L49
    }

    private final void emitEndSignal() {
        this.isPlaying = false;
        this.mainHandler.post(new AnonymousClass1(this));
    }

    static /* synthetic */ void monitor$default(PlayerController r1, boolean r2, int r3, int r4, String r5, int r6, Object r7) {
        if (r7 != null) goto L12;
        if ((r6 & 2) == 0) goto L7;
        r3 = 0;
    L7:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        r1.monitor(r2, r3, r4, r5);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: monitor");
    }

    private final void monitor(boolean r7, int r8, int r9, String r10) {
        IMonitor r0 = this.mMonitor;
        if (r0 == null) goto L6;
        r0.monitor(r7, getPlayerType(), r8, r9, r10);
        return;
    }
}
