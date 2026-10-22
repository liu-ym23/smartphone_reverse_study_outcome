package com.obric.oui.panel.anim;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimController.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u0011J&\u0010\u0013\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0011J$\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r0\u0011H\u0002J&\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0011H\u0002J\u0006\u0010\u0016\u001a\u00020\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/panel/anim/AnimController;", "", "()V", "enterAnimProcessType", "Lcom/obric/oui/panel/anim/AnimController$AnimProcessType;", "getEnterAnimProcessType", "()Lcom/obric/oui/panel/anim/AnimController$AnimProcessType;", "setEnterAnimProcessType", "(Lcom/obric/oui/panel/anim/AnimController$AnimProcessType;)V", "exitAnimProcessType", "getExitAnimProcessType", "setExitAnimProcessType", "doEnterAnim", "", "anim", "Landroid/animation/ObjectAnimator;", "animProgressListener", "Lkotlin/Function1;", "", "doExitAnim", "getContainerEnterAnim", "getContainerExitAnim", "refresh", "AnimProcessType", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnimController {
    private AnimProcessType enterAnimProcessType;
    private AnimProcessType exitAnimProcessType;

    /* JADX INFO: compiled from: AnimController.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/panel/anim/AnimController$AnimProcessType;", "", "(Ljava/lang/String;I)V", "NONE", "DOING", "DONE", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum AnimProcessType extends Enum<AnimProcessType> {
        private static final /* synthetic */ AnimProcessType[] $VALUES = null;
        public static final AnimProcessType DOING = null;
        public static final AnimProcessType DONE = null;
        public static final AnimProcessType NONE = null;

        private static final /* synthetic */ AnimProcessType[] $values() {
            return new AnimProcessType[]{NONE, DOING, DONE};
        }

        public static AnimProcessType valueOf(String r1) {
            return (AnimProcessType) Enum.valueOf(AnimProcessType.class, r1);
        }

        public static AnimProcessType[] values() {
            return (AnimProcessType[]) $VALUES.clone();
        }

        private AnimProcessType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            NONE = new AnimProcessType("NONE", 0);
            DOING = new AnimProcessType("DOING", 1);
            DONE = new AnimProcessType("DONE", 2);
            $VALUES = $values();
        }
    }

    public static /* synthetic */ void $r8$lambda$cYNsj5ZvZLvovRoH2N5mxdWCKqc(Function1 r0, ValueAnimator r1) {
        m1265getContainerEnterAnim$lambda1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$edI7UcoZhePqKCVfEseD_OB_6AE(Function1 r0, ValueAnimator r1) {
        m1266getContainerExitAnim$lambda3(r0, r1);
    }

    public AnimController() {
        this.enterAnimProcessType = AnimProcessType.NONE;
        this.exitAnimProcessType = AnimProcessType.NONE;
    }

    public final AnimProcessType getEnterAnimProcessType() {
        return this.enterAnimProcessType;
    }

    public final void setEnterAnimProcessType(AnimProcessType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.enterAnimProcessType = r2;
    }

    public final AnimProcessType getExitAnimProcessType() {
        return this.exitAnimProcessType;
    }

    public final void setExitAnimProcessType(AnimProcessType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.exitAnimProcessType = r2;
    }

    public final void refresh() {
        this.enterAnimProcessType = AnimProcessType.NONE;
        this.exitAnimProcessType = AnimProcessType.NONE;
    }

    public final void doEnterAnim(ObjectAnimator r3, Function1<? super Float, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "animProgressListener");
        if (this.enterAnimProcessType == AnimProcessType.NONE) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        getContainerEnterAnim(r3, r4).start();
    }

    private final ObjectAnimator getContainerEnterAnim(ObjectAnimator r2, final Function1<? super Float, Unit> r3) {
        r2.addListener(new AnonymousClass1(this));
        r2.addUpdateListener(new AnimController$$ExternalSyntheticLambda0(r3));
        return r2;
    }

    /* JADX INFO: renamed from: getContainerEnterAnim$lambda-1, reason: not valid java name */
    private static final void m1265getContainerEnterAnim$lambda1(Function1 r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "$animProgressListener");
        Intrinsics.checkNotNullParameter(r2, "animation");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r1.invoke(Float.valueOf(r2.getAnimatedFraction()));     // Catch: Throwable -> L5
        Result.m1508constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.m1508constructorimpl(ResultKt.createFailure(th));
    }

    public final void doExitAnim(ObjectAnimator r3, Function1<? super Float, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "animProgressListener");
        if (this.exitAnimProcessType == AnimProcessType.NONE) goto L5;
        return;
    L5:
        if (r3 != null) goto L7;
        return;
    L7:
        getContainerExitAnim(r3, r4).start();
    }

    private final ObjectAnimator getContainerExitAnim(ObjectAnimator r2, final Function1<? super Float, Unit> r3) {
        r2.addListener(new C02971(this));
        r2.addUpdateListener(new AnimController$$ExternalSyntheticLambda1(r3));
        return r2;
    }

    /* JADX INFO: renamed from: getContainerExitAnim$lambda-3, reason: not valid java name */
    private static final void m1266getContainerExitAnim$lambda3(Function1 r1, ValueAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "$animProgressListener");
        Intrinsics.checkNotNullParameter(r2, "animation");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Result.m1508constructorimpl((Unit) r1.invoke(Float.valueOf(r2.getAnimatedFraction())));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.m1508constructorimpl(ResultKt.createFailure(th));
    }
}
