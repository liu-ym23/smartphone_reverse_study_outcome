package com.obric.common.oea.foundation.animation.manager;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.obric.common.oea.foundation.animation.AnimationInfo;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.util.OEALogger;
import com.obric.common.oea.foundation.util.SdkInit;
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

/* JADX INFO: compiled from: AnimationManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u008a\u0001\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190\u00182\"\b\u0002\u0010\u001a\u001a\u001c\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u001b2\u001e\b\u0002\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020\n\u0018\u00010\u001eH\u0002J\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\nJ\u0088\u0001\u0010\"\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190\u00182\"\b\u0002\u0010\u001a\u001a\u001c\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u001b2\u001e\b\u0002\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020\n\u0018\u00010\u001eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "", "()V", "instanceId", "", "runner", "Lcom/obric/common/oea/foundation/animation/manager/AnimatableRunner;", "stateManager", "Lcom/obric/common/oea/foundation/animation/manager/AnimatableStateManager;", "cancelAnimation", "", "clearVelocity", "", "internalRunAnimation", "targetFps", "", "view", "Landroid/view/View;", "mode", "Lcom/obric/common/oea/foundation/animation/constants/RunMode;", "speed", "repeatMode", "Lcom/obric/common/oea/foundation/animation/constants/RepeatMode;", "animationInfos", "", "Lcom/obric/common/oea/foundation/animation/AnimationInfo;", "onUpdateCallback", "Lkotlin/Function3;", "", "onEndCallback", "Lkotlin/Function2;", "", "pause", "resume", "runAnimation", "Companion", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AnimationManager {
    public static final Companion Companion = null;
    private static final String TAG = "AnimationManager";
    private static int instanceCount;
    private static final SdkInit sdkInit = null;
    private final int instanceId;
    private AnimatableRunner runner;
    private final AnimatableStateManager stateManager;

    /* JADX INFO: compiled from: AnimationManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/common/oea/foundation/animation/manager/AnimationManager$Companion;", "", "()V", "TAG", "", "instanceCount", "", "sdkInit", "Lcom/obric/common/oea/foundation/util/SdkInit;", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    public AnimationManager() {
        this.stateManager = new AnimatableStateManager();
        int r0 = instanceCount;
        instanceCount = r0 + 1;
        this.instanceId = r0;
    }

    public static final /* synthetic */ void access$internalRunAnimation(AnimationManager r0, float r1, View r2, RunMode r3, float r4, RepeatMode r5, List r6, Function3 r7, Function2 r8) {
        r0.internalRunAnimation(r1, r2, r3, r4, r5, r6, r7, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void runAnimation$default(AnimationManager r11, float r12, View r13, RunMode r14, float r15, RepeatMode r16, List r17, Function3 r18, Function2 r19, int r20, Object r21) {
        if ((r20 & 8) == 0) goto L5;
        float r6 = 1.0f;
    L7:
        if ((r20 & 64) == 0) goto L9;
        Function3 r1 = (Function3) null;
        Function3 r9 = null;
    L11:
        if ((r20 & 128) == 0) goto L13;
        Function2 r0 = (Function2) null;
        Function2 r10 = null;
    L14:
        r11.runAnimation(r12, r13, r14, r6, r16, r17, r9, r10);
        return;
    L13:
        r10 = r19;
        goto L14
    L9:
        r9 = r18;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }

    public final void runAnimation(final float r13, final View r14, final RunMode r15, final float r16, final RepeatMode r17, final List<? extends AnimationInfo<?>> r18, final Function3<? super String, Object, ? super Float, Unit> r19, final Function2<? super Boolean, ? super Throwable, Unit> r20) {
        Intrinsics.checkNotNullParameter(r15, "mode");
        Intrinsics.checkNotNullParameter(r17, "repeatMode");
        Intrinsics.checkNotNullParameter(r18, "animationInfos");
        Looper r0 = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(r0, "Looper.getMainLooper()");
        if ((!Intrinsics.areEqual(r0.getThread(), Thread.currentThread())) == false) goto L5;
        new Handler(Looper.getMainLooper()).post(new AnonymousClass1(this, r13, r14, r15, r16, r17, r18, r19, r20));
        return;
    L5:
        internalRunAnimation(r13, r14, r15, r16, r17, r18, r19, r20);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void internalRunAnimation$default(AnimationManager r11, float r12, View r13, RunMode r14, float r15, RepeatMode r16, List r17, Function3 r18, Function2 r19, int r20, Object r21) {
        if ((r20 & 8) == 0) goto L5;
        float r6 = 1.0f;
    L7:
        if ((r20 & 64) == 0) goto L9;
        Function3 r1 = (Function3) null;
        Function3 r9 = null;
    L11:
        if ((r20 & 128) == 0) goto L13;
        Function2 r0 = (Function2) null;
        Function2 r10 = null;
    L14:
        r11.internalRunAnimation(r12, r13, r14, r6, r16, r17, r9, r10);
        return;
    L13:
        r10 = r19;
        goto L14
    L9:
        r9 = r18;
        goto L11
    L5:
        r6 = r15;
        goto L7
    }

    private final void internalRunAnimation(float r19, View r20, RunMode r21, float r22, RepeatMode r23, List<? extends AnimationInfo<?>> r24, Function3<? super String, Object, ? super Float, Unit> r25, Function2<? super Boolean, ? super Throwable, Unit> r26) {
        OEALogger r5 = OEALogger.INSTANCE;
        StringBuilder r6 = new StringBuilder("start, instanceId: [").append(this.instanceId).append("], runAnimation, mode: ").append(r21).append(", speed: ").append(r22).append(", repeatMode: ").append(r23).append(", animationInfos: ");
        List<? extends AnimationInfo<?>> r7 = r24;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r8.add(((AnimationInfo) r9.next()).dump());
        goto L4
    L6:
        r5.r(TAG, r6.append(CollectionsKt.joinToString$default(r8, "\n", null, null, 0, null, null, 62, null)).toString());
        this.stateManager.setTargetFps(r19);
        this.stateManager.setRunMode(r21);
        this.stateManager.setRepeatMode(r23);
        this.stateManager.setAnimationInfos(r24);
        this.stateManager.setView(r20);
        this.stateManager.setSpeed(r22);
        AnimatableRunner r1 = new AnimatableRunner(this.stateManager, r25, r26);
        this.runner = r1;
        r1.startAnimation();
    }

    public final void pause() {
        OEALogger.INSTANCE.r(TAG, "pause, instanceId: [" + this.instanceId + ']');
        this.stateManager.pause();
    }

    public final void resume() {
        OEALogger.INSTANCE.r(TAG, "resume, instanceId: [" + this.instanceId + ']');
        this.stateManager.resume();
        AnimatableRunner r3 = this.runner;
        if (r3 == null) goto L6;
        r3.startAnimation();
        return;
    }

    public static /* synthetic */ void cancelAnimation$default(AnimationManager r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.cancelAnimation(r1);
    }

    public final void cancelAnimation(boolean r4) {
        OEALogger.INSTANCE.r(TAG, "cancel, instanceId: [" + this.instanceId + "], clearVelocity: " + r4);
        AnimatableRunner r3 = this.runner;
        if (r3 == null) goto L6;
        r3.cancelAnimation(r4);
        return;
    }

    static {
        Companion = new Companion(null);
        sdkInit = new SdkInit();
    }
}
