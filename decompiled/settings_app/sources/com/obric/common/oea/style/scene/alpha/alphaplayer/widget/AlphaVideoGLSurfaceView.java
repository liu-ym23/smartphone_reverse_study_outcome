package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerControllerExt;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlphaVideoGLSurfaceView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001'\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u0002032\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020\u001bH\u0016J\b\u00108\u001a\u000209H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020*H\u0016J\b\u0010=\u001a\u000203H\u0016J\b\u0010>\u001a\u000203H\u0016J\u0018\u0010?\u001a\u0002032\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\tH\u0014J\b\u0010B\u001a\u000203H\u0016J\u0010\u0010C\u001a\u0002032\u0006\u00105\u001a\u000206H\u0016J\u0010\u0010D\u001a\u0002032\u0006\u0010E\u001a\u00020\u000fH\u0016J\u0010\u0010F\u001a\u0002032\u0006\u0010G\u001a\u00020\u001bH\u0016J\u0010\u0010H\u001a\u0002032\u0006\u0010I\u001a\u00020\u0015H\u0016R\u0014\u0010\b\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.¨\u0006J"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLSurfaceView;", "Landroid/opengl/GLSurfaceView;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/IAlphaVideoView;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "GL_CONTEXT_VERSION", "", "getGL_CONTEXT_VERSION", "()I", "isSurfaceCreated", "", "mPlayerController", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;", "getMPlayerController", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;", "setMPlayerController", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;)V", "mRenderer", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;", "getMRenderer", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;", "setMRenderer", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;)V", "mScaleType", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "getMScaleType", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "setMScaleType", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;)V", "mSurface", "Landroid/view/Surface;", "getMSurface", "()Landroid/view/Surface;", "setMSurface", "(Landroid/view/Surface;)V", "mSurfaceListener", "com/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLSurfaceView$mSurfaceListener$1", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLSurfaceView$mSurfaceListener$1;", "mVideoHeight", "", "getMVideoHeight", "()F", "setMVideoHeight", "(F)V", "mVideoWidth", "getMVideoWidth", "setMVideoWidth", "addOnSurfacePreparedListener", "", "addParentView", "parentView", "Landroid/view/ViewGroup;", "getScaleType", "getView", "Landroid/view/View;", "measureInternal", "videoWidth", "videoHeight", "onCompletion", "onFirstFrame", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "release", "removeParentView", "setPlayerController", "playerController", "setScaleType", "scaleType", "setVideoRenderer", "renderer", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaVideoGLSurfaceView extends GLSurfaceView implements IAlphaVideoView {
    private final int GL_CONTEXT_VERSION;
    private volatile boolean isSurfaceCreated;
    private IPlayerControllerExt mPlayerController;
    private IRender mRenderer;
    private ScaleType mScaleType;
    private Surface mSurface;
    private final AlphaVideoGLSurfaceView$mSurfaceListener$1 mSurfaceListener;
    private float mVideoHeight;
    private float mVideoWidth;

    /* JADX WARN: Multi-variable type inference failed */
    public AlphaVideoGLSurfaceView(Context r3) {
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ AlphaVideoGLSurfaceView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
        AttributeSet r5 = (AttributeSet) null;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ boolean access$isSurfaceCreated$p(AlphaVideoGLSurfaceView r0) {
        return r0.isSurfaceCreated;
    }

    public static final /* synthetic */ void access$setSurfaceCreated$p(AlphaVideoGLSurfaceView r0, boolean r1) {
        r0.isSurfaceCreated = r1;
    }

    public AlphaVideoGLSurfaceView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9);
        this.GL_CONTEXT_VERSION = 2;
        this.mScaleType = ScaleType.ScaleAspectFill;
        this.mSurfaceListener = new AlphaVideoGLSurfaceView$mSurfaceListener$1(this);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        getHolder().setFormat(-3);
        addOnSurfacePreparedListener();
        setZOrderOnTop(true);
        setPreserveEGLContextOnPause(true);
    }

    public final int getGL_CONTEXT_VERSION() {
        return this.GL_CONTEXT_VERSION;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public boolean isSurfaceCreated() {
        return this.isSurfaceCreated;
    }

    public final float getMVideoWidth() {
        return this.mVideoWidth;
    }

    public final void setMVideoWidth(float r1) {
        this.mVideoWidth = r1;
    }

    public final float getMVideoHeight() {
        return this.mVideoHeight;
    }

    public final void setMVideoHeight(float r1) {
        this.mVideoHeight = r1;
    }

    public final ScaleType getMScaleType() {
        return this.mScaleType;
    }

    public final void setMScaleType(ScaleType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mScaleType = r2;
    }

    public final IRender getMRenderer() {
        return this.mRenderer;
    }

    public final void setMRenderer(IRender r1) {
        this.mRenderer = r1;
    }

    public final IPlayerControllerExt getMPlayerController() {
        return this.mPlayerController;
    }

    public final void setMPlayerController(IPlayerControllerExt r1) {
        this.mPlayerController = r1;
    }

    public final Surface getMSurface() {
        return this.mSurface;
    }

    public final void setMSurface(Surface r1) {
        this.mSurface = r1;
    }

    public final void addOnSurfacePreparedListener() {
        IRender r0 = this.mRenderer;
        if (r0 == null) goto L6;
        r0.setSurfaceListener(this.mSurfaceListener);
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void addParentView(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        AlphaVideoGLSurfaceView r0 = this;
        if (r4.indexOfChild(r0) != (-1)) goto L12;
        ViewParent r3 = getParent();
        if (r3 == null) goto L10;
        if (r3 == null) goto L9;
        ((ViewGroup) r3).removeView(r0);
        goto L10
    L9:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L10:
        r4.addView(r0);
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void removeParentView(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        r2.removeView(this);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public View getView() {
        return this;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void setPlayerController(IPlayerControllerExt r2) {
        Intrinsics.checkNotNullParameter(r2, "playerController");
        this.mPlayerController = r2;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void setVideoRenderer(IRender r2) {
        Intrinsics.checkNotNullParameter(r2, "renderer");
        this.mRenderer = r2;
        setRenderer(r2);
        addOnSurfacePreparedListener();
        setRenderMode(0);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void setScaleType(ScaleType r2) {
        Intrinsics.checkNotNullParameter(r2, "scaleType");
        this.mScaleType = r2;
        IRender r1 = this.mRenderer;
        if (r1 == null) goto L6;
        r1.setScaleType(r2);
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void measureInternal(float r3, float r4) {
        float r0 = 0;
        if (r3 > r0) goto L5;
    L7:
        final IRender r5 = this.mRenderer;
        if (r5 == null) goto L11;
        final int r6 = getMeasuredWidth();
        final int r1 = getMeasuredHeight();
        queueEvent(new AlphaVideoGLSurfaceView$measureInternal$$inlined$let$lambda$1(r5, r6, r1, this));
        return;
    L11:
        return;
    L5:
        if (r4 <= r0) goto L7;
        this.mVideoWidth = r3;
        this.mVideoHeight = r4;
        goto L7
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void onFirstFrame() {
        IRender r0 = this.mRenderer;
        if (r0 == null) goto L6;
        r0.onFirstFrame();
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void onCompletion() {
        IRender r0 = this.mRenderer;
        if (r0 == null) goto L6;
        r0.onCompletion();
        return;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        measureInternal(this.mVideoWidth, this.mVideoHeight);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void release() {
        this.mSurfaceListener.onSurfaceDestroyed();
    }
}
