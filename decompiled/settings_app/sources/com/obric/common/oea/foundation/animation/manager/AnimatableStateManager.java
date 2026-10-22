package com.obric.common.oea.foundation.animation.manager;

import android.view.View;
import com.obric.common.oea.foundation.animation.AnimationInfo;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimatableStateManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020\u0004J\u0010\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006J\u0006\u0010#\u001a\u00020\tJ\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0015J\u0006\u0010'\u001a\u00020\u0017J\u0006\u0010(\u001a\u00020\u0013J\u0006\u0010)\u001a\u00020\u0004J\b\u0010*\u001a\u0004\u0018\u00010\u001dJ\u0006\u0010+\u001a\u00020\u000bJ\u0006\u0010,\u001a\u00020\u000bJ\u0006\u0010-\u001a\u00020\u001fJ\u0006\u0010.\u001a\u00020\u001fJ\u000e\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0004J\u0018\u00101\u001a\u00020\u001f2\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006J\u000e\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\tJ\u000e\u00104\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0004J\u000e\u00106\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u00107\u001a\u00020\u001f2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u00108\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u0013J\u000e\u00109\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0004J\u000e\u0010:\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u0013J\u0010\u0010;\u001a\u00020\u001f2\b\u0010<\u001a\u0004\u0018\u00010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/obric/common/oea/foundation/animation/manager/AnimatableStateManager;", "", "()V", "accumulatedPausedTimeNanos", "", "animationInfos", "", "Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "curRunningSequenceAnimIndex", "", "isPausedFlag", "", "isViewAnimation", "()Z", "setViewAnimation", "(Z)V", "lastFrameTimeNanos", "pausedTimeNanos", "refreshRate", "", "repeatMode", "Lcom/obric/common/oea/foundation/animation/constants/RepeatMode;", "runMode", "Lcom/obric/common/oea/foundation/animation/constants/RunMode;", "speed", "startTimeNanos", "targetFps", "viewWeakReference", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "cancelAnimation", "", "clearVelocity", "getAccumulatedPausedTimeNanos", "getAnimationInfos", "getCurRunningSequenceAnimIndex", "getLastFrameTimeNanos", "getPausedTimeNanos", "getRepeatMode", "getRunMode", "getSpeed", "getStartTimeNanos", "getView", "hasAnimationNeedToRunning", "isPaused", "pause", "resume", "setAccumulatedPausedTimeNanos", "timeNanos", "setAnimationInfos", "setCurRunningSequenceAnimIndex", "index", "setLastFrameTimeNanos", "setPausedTimeNanos", "setRepeatMode", "setRunMode", "setSpeed", "setStartTimeNanos", "setTargetFps", "setView", "view", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AnimatableStateManager {
    private long accumulatedPausedTimeNanos;
    private List<? extends AnimationInfo<?>> animationInfos;
    private int curRunningSequenceAnimIndex;
    private boolean isPausedFlag;
    private boolean isViewAnimation;
    private long lastFrameTimeNanos;
    private long pausedTimeNanos;
    private float refreshRate;
    private RepeatMode repeatMode;
    private RunMode runMode;
    private float speed;
    private long startTimeNanos;
    private float targetFps;
    private WeakReference<View> viewWeakReference;

    public AnimatableStateManager() {
        this.targetFps = 60.0f;
        this.runMode = RunMode.PARALLEL;
        this.repeatMode = RepeatMode.NORMAL;
        this.animationInfos = CollectionsKt.emptyList();
        this.curRunningSequenceAnimIndex = -1;
        this.speed = 1.0f;
        this.isViewAnimation = true;
    }

    public final boolean isViewAnimation() {
        return this.isViewAnimation;
    }

    public final void setViewAnimation(boolean r1) {
        this.isViewAnimation = r1;
    }

    public final void setTargetFps(float r1) {
        this.targetFps = r1;
    }

    public final void setRunMode(RunMode r2) {
        Intrinsics.checkNotNullParameter(r2, "runMode");
        this.runMode = r2;
    }

    public final void setRepeatMode(RepeatMode r2) {
        Intrinsics.checkNotNullParameter(r2, "repeatMode");
        this.repeatMode = r2;
    }

    public final void setAnimationInfos(List<? extends AnimationInfo<?>> r2) {
        Intrinsics.checkNotNullParameter(r2, "animationInfos");
        this.animationInfos = r2;
    }

    public final void setView(View r2) {
        if (r2 == null) goto L4;
        boolean r0 = true;
    L5:
        this.isViewAnimation = r0;
        this.viewWeakReference = new WeakReference(r2);
        return;
    L4:
        r0 = false;
        goto L5
    }

    public final void setSpeed(float r1) {
        this.speed = r1;
    }

    public final boolean isPaused() {
        return this.isPausedFlag;
    }

    public final void pause() {
        this.isPausedFlag = true;
    }

    public final void resume() {
        if (this.isPausedFlag == false) goto L6;
        this.isPausedFlag = false;
        return;
    }

    public static /* synthetic */ void cancelAnimation$default(AnimatableStateManager r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.cancelAnimation(r1);
    }

    public final void cancelAnimation(boolean r4) {
        WeakReference<View> r0 = this.viewWeakReference;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        Iterator<T> r1 = this.animationInfos.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((AnimationInfo) r1.next()).reset(false, false, r4);
        goto L7
    L9:
        this.startTimeNanos = 0;
        this.curRunningSequenceAnimIndex = -1;
        this.speed = 1.0f;
        this.isPausedFlag = false;
        this.pausedTimeNanos = 0;
        this.accumulatedPausedTimeNanos = 0;
    }

    public final boolean hasAnimationNeedToRunning() {
        List<? extends AnimationInfo<?>> r2 = this.animationInfos;
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L18;
        if (((AnimationInfo) r3.next()).isRunning() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r2.isEmpty() == false) goto L7;
        return false;
    }

    public final View getView() {
        WeakReference<View> r0 = this.viewWeakReference;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    public final RunMode getRunMode() {
        return this.runMode;
    }

    public final RepeatMode getRepeatMode() {
        return this.repeatMode;
    }

    public final List<AnimationInfo<?>> getAnimationInfos() {
        return this.animationInfos;
    }

    public final float getSpeed() {
        return this.speed;
    }

    public final long getStartTimeNanos() {
        return this.startTimeNanos;
    }

    public final void setStartTimeNanos(long r1) {
        this.startTimeNanos = r1;
    }

    public final long getLastFrameTimeNanos() {
        return this.lastFrameTimeNanos;
    }

    public final void setLastFrameTimeNanos(long r1) {
        this.lastFrameTimeNanos = r1;
    }

    public final long getPausedTimeNanos() {
        return this.pausedTimeNanos;
    }

    public final void setPausedTimeNanos(long r1) {
        this.pausedTimeNanos = r1;
    }

    public final long getAccumulatedPausedTimeNanos() {
        return this.accumulatedPausedTimeNanos;
    }

    public final void setAccumulatedPausedTimeNanos(long r1) {
        this.accumulatedPausedTimeNanos = r1;
    }

    public final int getCurRunningSequenceAnimIndex() {
        return this.curRunningSequenceAnimIndex;
    }

    public final void setCurRunningSequenceAnimIndex(int r1) {
        this.curRunningSequenceAnimIndex = r1;
    }
}
