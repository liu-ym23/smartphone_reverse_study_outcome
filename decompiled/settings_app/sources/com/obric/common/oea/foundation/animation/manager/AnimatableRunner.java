package com.obric.common.oea.foundation.animation.manager;

import android.view.Choreographer;
import android.view.View;
import com.obric.common.oea.foundation.animation.AnimationInfo;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.util.OEALogger;
import defpackage.ViewUtilKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimatableRunner.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0013\u0018\u0000 &2\u00020\u0001:\u0001&Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012 \u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012:\u0010\t\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\n¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u000bJ\u0012\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u000bH\u0002J6\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001d2\u0006\u0010\u001e\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u000bH\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u000bH\u0002J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\u0018\u0010$\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\u0006\u0010%\u001a\u00020\bR\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014RB\u0010\t\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0004\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/common/oea/foundation/animation/manager/AnimatableRunner;", "", "stateManager", "Lcom/obric/common/oea/foundation/animation/manager/AnimatableStateManager;", "onUpdateCallback", "Lkotlin/Function3;", "", "", "", "onEndCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "finished", "", "e", "(Lcom/obric/common/oea/foundation/animation/manager/AnimatableStateManager;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;)V", "frameCallback", "com/obric/common/oea/foundation/animation/manager/AnimatableRunner$frameCallback$1", "Lcom/obric/common/oea/foundation/animation/manager/AnimatableRunner$frameCallback$1;", "cancelAnimation", "clearVelocity", "endAnimationInternal", "executeAnimation", "scene", "playTimeNanos", "", "animationInfo", "Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "frameTimeNanos", "notifyWhenFinished", "releaseCallbacks", "resetAnimation", "shouldReverse", "runParallelAnimations", "runSequentialAnimations", "startAnimation", "Companion", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AnimatableRunner {
    public static final Companion Companion = null;
    private static final String TAG = "AnimatableRunner";
    private final AnimatableRunner$frameCallback$1 frameCallback;
    private Function2<? super Boolean, ? super Throwable, Unit> onEndCallback;
    private Function3<? super String, Object, ? super Float, Unit> onUpdateCallback;
    private final AnimatableStateManager stateManager;

    /* JADX INFO: compiled from: AnimatableRunner.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/common/oea/foundation/animation/manager/AnimatableRunner$Companion;", "", "()V", "TAG", "", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
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

        static {
            int[] r0 = new int[RunMode.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[RunMode.PARALLEL.ordinal()] = 1;
            r0[RunMode.SERIAL.ordinal()] = 2;
            int[] r1 = new int[RepeatMode.values().length];
            $EnumSwitchMapping$1 = r1;
            r1[RepeatMode.LOOP.ordinal()] = 1;
            r1[RepeatMode.REVERSE.ordinal()] = 2;
            r1[RepeatMode.NORMAL.ordinal()] = 3;
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.common.oea.foundation.animation.manager.AnimatableRunner$frameCallback$1] */
    public AnimatableRunner(AnimatableStateManager r2, Function3<? super String, Object, ? super Float, Unit> r3, Function2<? super Boolean, ? super Throwable, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "stateManager");
        this.stateManager = r2;
        this.onUpdateCallback = r3;
        this.onEndCallback = r4;
        this.frameCallback = new AnimatableRunner$frameCallback$1(this);
    }

    public static final /* synthetic */ void access$endAnimationInternal(AnimatableRunner r0, boolean r1) {
        r0.endAnimationInternal(r1);
    }

    public static final /* synthetic */ AnimatableStateManager access$getStateManager$p(AnimatableRunner r0) {
        return r0.stateManager;
    }

    public static final /* synthetic */ void access$resetAnimation(AnimatableRunner r0, boolean r1) {
        r0.resetAnimation(r1);
    }

    public static final /* synthetic */ void access$runParallelAnimations(AnimatableRunner r0, long r1, long r3) {
        r0.runParallelAnimations(r1, r3);
    }

    public static final /* synthetic */ void access$runSequentialAnimations(AnimatableRunner r0, long r1, long r3) {
        r0.runSequentialAnimations(r1, r3);
    }

    private final void runParallelAnimations(long r16, long r18) {
        List<AnimationInfo<?>> r9 = this.stateManager.getAnimationInfos();
        int r1 = 0;
        if (r9.size() <= 1) goto L14;
        ArrayList r2 = new ArrayList();
        Iterator<T> r0 = r9.iterator();
    L6:
        if (r0.hasNext() == false) goto L11;
        Object r3 = r0.next();
        if (((AnimationInfo) r3).isRunning() == false) goto L6;
        r2.add(r3);
        goto L6
    L11:
        if (r2.size() == 1) goto L14;
        boolean r11 = false;
    L15:
        Iterator<T> r12 = r9.iterator();
        int r13 = 0;
    L17:
        if (r12.hasNext() == false) goto L27;
        Object r4 = r12.next();
        int r14 = r1 + 1;
        if (r1 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        AnimationInfo<?> r5 = (AnimationInfo) r4;
        if (r5.isRunning() == true) goto L24;
    L25:
        r13 = r13 + 1;
    L26:
        r1 = r14;
        goto L17
    L24:
        if (executeAnimation("runParallelAnimations", r16, r5, r18, r11) == false) goto L26;
    L27:
        if (r11 == false) goto L29;
        return;
    L29:
        if (r13 != r9.size()) goto L43;
        OEALogger.INSTANCE.d(TAG, "runParallelAnimations, all finished");
        Function2<? super Boolean, ? super Throwable, Unit> r6 = this.onEndCallback;
        if (r6 == null) goto L44;
        Unit r7 = r6.invoke(true, null);
        return;
    L44:
        return;
    L43:
        return;
    L14:
        r11 = true;
        goto L15
    }

    private final void runSequentialAnimations(long r12, long r14) {
        if (this.stateManager.getCurRunningSequenceAnimIndex() != (-1)) goto L6;
        this.stateManager.setCurRunningSequenceAnimIndex(0);
    L6:
        if (this.stateManager.getCurRunningSequenceAnimIndex() < this.stateManager.getAnimationInfos().size()) goto L9;
        OEALogger.INSTANCE.d(TAG, "runSequentialAnimations, return case 1");
        return;
    L9:
        long r0 = (long) (r12 * this.stateManager.getSpeed());
        AnimationInfo<?> r4 = this.stateManager.getAnimationInfos().get(this.stateManager.getCurRunningSequenceAnimIndex());
        boolean r1 = r4.isFinishedFromNanos(r0);
        r4.setRunning(!r1);
        if (r1 == false) goto L18;
        executeAnimation("runSequentialAnimations 1", r12, r4, r14, false);
        AnimatableStateManager r2 = this.stateManager;
        r2.setCurRunningSequenceAnimIndex(r2.getCurRunningSequenceAnimIndex() + 1);
        if (this.stateManager.getCurRunningSequenceAnimIndex() < this.stateManager.getAnimationInfos().size()) goto L17;
        OEALogger.INSTANCE.d(TAG, "runSequentialAnimations, return case 2");
        Function2<? super Boolean, ? super Throwable, Unit> r3 = this.onEndCallback;
        if (r3 == null) goto L20;
        Unit r5 = r3.invoke(true, null);
        return;
    L20:
        return;
    L17:
        this.stateManager.setStartTimeNanos(0);
        this.stateManager.setPausedTimeNanos(0);
        this.stateManager.setAccumulatedPausedTimeNanos(0);
        this.stateManager.setLastFrameTimeNanos(0);
        executeAnimation$default(this, "runSequentialAnimations 2", 0, this.stateManager.getAnimationInfos().get(this.stateManager.getCurRunningSequenceAnimIndex()), r14, false, 16, null);
        return;
    L18:
        executeAnimation$default(this, "runSequentialAnimations 3", r12, r4, r14, false, 16, null);
    }

    static /* synthetic */ boolean executeAnimation$default(AnimatableRunner r9, String r10, long r11, AnimationInfo r13, long r14, boolean r16, int r17, Object r18) {
        if ((r17 & 16) == 0) goto L5;
        boolean r8 = true;
    L7:
        return r9.executeAnimation(r10, r11, r13, r14, r8);
    L5:
        r8 = r16;
        goto L7
    }

    private final boolean executeAnimation(String r7, long r8, AnimationInfo<?> r10, long r11, boolean r13) {
        long r9 = (long) (r8 * this.stateManager.getSpeed());
        Object r0 = r10.getValueFromNanos(r9);
        View r1 = this.stateManager.getView();
        if (r10.getFirstFrameTimeNanos() != (-1)) goto L5;
        r10.setFirstFrameTimeNanos(r11);
    L5:
        boolean r2 = r10.isFinishedFromNanos(r9);
        if (r1 == null) goto L12;
        String r3 = r10.getProperty();
        if (r2 == false) goto L10;
        Object r4 = r10.getTargetValue();
    L11:
        ViewUtilKt.setPropertyValue(r1, r3, r4);
        goto L12
    L10:
        r4 = r0;
    L12:
        r10.setLastFrameTimeNanos(r11);
        r10.setRunning(!r2);
        float r12 = r10.getVelocityVectorFromNanos(r9);
        if (r2 == true) goto L15;
        Function3<? super String, Object, ? super Float, Unit> r6 = this.onUpdateCallback;
        if (r6 == null) goto L23;
        Unit r14 = r6.invoke(r10.getProperty(), r0, Float.valueOf(r12));
    L23:
        return r2;
    L15:
        if (r13 == false) goto L19;
        OEALogger.INSTANCE.i(TAG, "executeAnimation, " + r7 + ", return case 1, property: " + r10.getProperty() + ", targetValue: " + r10.getTargetValue());
        Function2<? super Boolean, ? super Throwable, Unit> r15 = this.onEndCallback;
        if (r15 == null) goto L23;
        Unit r16 = r15.invoke(true, null);
        goto L23
    L19:
        OEALogger.INSTANCE.i(TAG, "executeAnimation, " + r7 + ", return case 2, property: " + r10.getProperty() + ", targetValue: " + r10.getTargetValue());
        goto L23
    }

    private final void resetAnimation(boolean r6) {
        View r0 = this.stateManager.getView();
        Iterator<T> r1 = this.stateManager.getAnimationInfos().iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        AnimationInfo r2 = (AnimationInfo) r1.next();
        if (r0 == null) goto L12;
        String r3 = r2.getProperty();
        if (r6 == false) goto L10;
        Object r4 = r2.getTargetValue();
    L11:
        ViewUtilKt.setPropertyValue(r0, r3, r4);
        goto L12
    L10:
        r4 = r2.getInitialValue();
    L12:
        r2.reset(true, r6, true);
        goto L4
    L13:
        this.stateManager.setStartTimeNanos(0);
        this.stateManager.setPausedTimeNanos(0);
        this.stateManager.setAccumulatedPausedTimeNanos(0);
        this.stateManager.setLastFrameTimeNanos(0);
        this.stateManager.setCurRunningSequenceAnimIndex(-1);
    }

    public final void startAnimation() {
        Choreographer.getInstance().postFrameCallback(this.frameCallback);
    }

    static /* synthetic */ void endAnimationInternal$default(AnimatableRunner r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.endAnimationInternal(r1);
    }

    private final void endAnimationInternal(boolean r4) {
        OEALogger.INSTANCE.i(TAG, "endAnimationInternal, clearVelocity: " + r4);
        Choreographer.getInstance().removeFrameCallback(this.frameCallback);
        this.stateManager.cancelAnimation(r4);
        releaseCallbacks("endAnimationInternal");
    }

    public static /* synthetic */ void cancelAnimation$default(AnimatableRunner r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.cancelAnimation(r1);
    }

    public final void cancelAnimation(boolean r4) {
        OEALogger.INSTANCE.i(TAG, "cancelAnimation, clearVelocity: " + r4);
        Choreographer.getInstance().removeFrameCallback(this.frameCallback);
        this.stateManager.cancelAnimation(r4);
        Function2<? super Boolean, ? super Throwable, Unit> r5 = this.onEndCallback;
        if (r5 == null) goto L5;
        Unit r6 = r5.invoke(false, null);
    L5:
        releaseCallbacks("cancelAnimation");
    }

    private final void releaseCallbacks(String r4) {
        OEALogger.INSTANCE.d(TAG, "releaseCallbacks, scene: " + r4);
        Function3 r0 = (Function3) null;
        this.onUpdateCallback = null;
        Function2 r1 = (Function2) null;
        this.onEndCallback = null;
    }
}
