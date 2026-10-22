package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.view.View;
import android.view.ViewGroup;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerControllerExt;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender;
import kotlin.Metadata;

/* JADX INFO: compiled from: IAlphaVideoView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0019\u001a\u00020\u0003H&J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u000bH&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020$H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\bH&¨\u0006'"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/IAlphaVideoView;", "", "addParentView", "", "parentView", "Landroid/view/ViewGroup;", "bringToFront", "getMeasuredHeight", "", "getMeasuredWidth", "getScaleType", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "getView", "Landroid/view/View;", "isSurfaceCreated", "", "measureInternal", "videoWidth", "", "videoHeight", "onCompletion", "onFirstFrame", "onPause", "release", "removeParentView", "requestRender", "setLayoutParams", "params", "Landroid/view/ViewGroup$LayoutParams;", "setPlayerController", "playerController", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;", "setScaleType", "scaleType", "setVideoRenderer", "renderer", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;", "setVisibility", "visibility", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public interface IAlphaVideoView {
    void addParentView(ViewGroup r1);

    void bringToFront();

    int getMeasuredHeight();

    int getMeasuredWidth();

    ScaleType getScaleType();

    View getView();

    boolean isSurfaceCreated();

    void measureInternal(float r1, float r2);

    void onCompletion();

    void onFirstFrame();

    void onPause();

    void release();

    void removeParentView(ViewGroup r1);

    void requestRender();

    void setLayoutParams(ViewGroup.LayoutParams r1);

    void setPlayerController(IPlayerControllerExt r1);

    void setScaleType(ScaleType r1);

    void setVideoRenderer(IRender r1);

    void setVisibility(int r1);
}
