package com.obric.common.oea.foundation.animation.builder;

import com.obric.common.oea.foundation.animation.command.AnimationCommand;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.animation.parser.AnimatableSubmitter;
import com.obric.common.oea.foundation.animation.spec.AnimationSpec;
import com.obric.common.oea.foundation.animation.spec.spring.FloatSpringSpec;
import com.obric.common.oea.foundation.animation.spec.spring.IntSpringSpec;
import com.obric.common.oea.foundation.animation.spec.tween.FloatTweenSpec;
import com.obric.common.oea.foundation.animation.spec.tween.IntTweenSpec;
import com.obric.common.oea.foundation.animation.token.OEasingKt;
import com.obric.common.oea.foundation.util.OEALogger;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ValueAnimatable.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001cBk\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\"\b\u0002\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u0012\u001e\b\u0002\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\u0002\u0010\u000fJ\b\u0010\u001a\u001a\u00020\u001bH\u0007R\u000e\u0010\u0010\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R'\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\n\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R+\u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0015\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/obric/common/oea/foundation/animation/builder/ValueAnimatable;", "", "animationSpeed", "", "targetFps", "valueAnimationCommand", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", "onUpdateCallback", "Lkotlin/Function3;", "", "", "onEndCallback", "Lkotlin/Function2;", "", "", "(FFLcom/obric/common/oea/foundation/animation/command/AnimationCommand;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;)V", "TAG", "getAnimationSpeed", "()F", "getOnEndCallback", "()Lkotlin/jvm/functions/Function2;", "getOnUpdateCallback", "()Lkotlin/jvm/functions/Function3;", "getTargetFps", "getValueAnimationCommand", "()Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", "start", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "Builder", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class ValueAnimatable {
    private final String TAG;
    private final float animationSpeed;
    private final Function2<Boolean, Throwable, Unit> onEndCallback;
    private final Function3<String, Object, Object, Unit> onUpdateCallback;
    private final float targetFps;
    private final AnimationCommand<?> valueAnimationCommand;

    /* JADX INFO: compiled from: ValueAnimatable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0011J5\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0018J5\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u001dJ\"\u0010\u001e\u001a\u00020\u00002\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0006J&\u0010 \u001a\u00020\u00002\u001e\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/common/oea/foundation/animation/builder/ValueAnimatable$Builder;", "", "()V", "animationSpeed", "", "onEndCallback", "Lkotlin/Function2;", "", "", "", "onUpdateCallback", "Lkotlin/Function3;", "", "valueAnimationCommand", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", "animator", "build", "Lcom/obric/common/oea/foundation/animation/builder/ValueAnimatable;", "of", "initialValue", "targetValue", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "initialVelocity", "(FFLcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)Lcom/obric/common/oea/foundation/animation/builder/ValueAnimatable$Builder;", "ofInt", "initialInt", "", "targetInt", "(IILcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)Lcom/obric/common/oea/foundation/animation/builder/ValueAnimatable$Builder;", "onEnd", "callback", "onUpdate", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Builder {
        private float animationSpeed;
        private Function2<? super Boolean, ? super Throwable, Unit> onEndCallback;
        private Function3<? super String, Object, Object, Unit> onUpdateCallback;
        private AnimationCommand<?> valueAnimationCommand;

        public Builder() {
            this.animationSpeed = 1.0f;
        }

        public static final /* synthetic */ AnimationCommand access$getValueAnimationCommand$p(Builder r1) {
            AnimationCommand<?> r2 = r1.valueAnimationCommand;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("valueAnimationCommand");
        L5:
            return r2;
        }

        public static final /* synthetic */ void access$setValueAnimationCommand$p(Builder r0, AnimationCommand r1) {
            r0.valueAnimationCommand = r1;
        }

        public static /* synthetic */ Builder ofInt$default(Builder r0, int r1, int r2, AnimationSpec r3, Float r4, int r5, Object r6) {
            if ((r5 & 8) == 0) goto L6;
            r4 = null;
            Float r7 = (Float) null;
        L6:
            return r0.ofInt(r1, r2, r3, r4);
        }

        public final Builder ofInt(int r9, int r10, AnimationSpec<Integer> r11, Float r12) {
            Intrinsics.checkNotNullParameter(r11, "spec");
            if ((r11 instanceof IntTweenSpec) == false) goto L6;
            AnimationCommand.SpringAnimationCommand r0 = new AnimationCommand.TweenAnimationCommand("valueAnimationPlaceholder", Integer.valueOf(r9), Integer.valueOf(r10), Reflection.getOrCreateKotlinClass(Integer.TYPE), r11, r12);
        L8:
            this.valueAnimationCommand = r0;
            return this;
        L6:
            if ((r11 instanceof IntSpringSpec) == false) goto L11;
            r0 = new AnimationCommand.SpringAnimationCommand("valueAnimationPlaceholder", Integer.valueOf(r9), Integer.valueOf(r10), Reflection.getOrCreateKotlinClass(Integer.TYPE), r11, r12);
            goto L8
        L11:
            throw new IllegalStateException("不支持的 spec 类型: " + r11.getClass().getSimpleName());
        }

        public static /* synthetic */ Builder of$default(Builder r0, float r1, float r2, AnimationSpec r3, Float r4, int r5, Object r6) {
            if ((r5 & 8) == 0) goto L6;
            r4 = null;
            Float r7 = (Float) null;
        L6:
            return r0.of(r1, r2, r3, r4);
        }

        public final Builder of(float r9, float r10, AnimationSpec<Float> r11, Float r12) {
            Intrinsics.checkNotNullParameter(r11, "spec");
            if ((r11 instanceof FloatTweenSpec) == false) goto L6;
            AnimationCommand.SpringAnimationCommand r0 = new AnimationCommand.TweenAnimationCommand("valueAnimationPlaceholder", Float.valueOf(r9), Float.valueOf(r10), Reflection.getOrCreateKotlinClass(Float.TYPE), r11, r12);
        L8:
            this.valueAnimationCommand = r0;
            return this;
        L6:
            if ((r11 instanceof FloatSpringSpec) == false) goto L11;
            r0 = new AnimationCommand.SpringAnimationCommand("valueAnimationPlaceholder", Float.valueOf(r9), Float.valueOf(r10), Reflection.getOrCreateKotlinClass(Float.TYPE), r11, r12);
            goto L8
        L11:
            throw new IllegalStateException("不支持的 spec 类型: " + r11.getClass().getSimpleName());
        }

        public final Builder onUpdate(Function3<? super String, Object, Object, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            this.onUpdateCallback = r2;
            return this;
        }

        public final Builder onEnd(Function2<? super Boolean, ? super Throwable, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            this.onEndCallback = r2;
            return this;
        }

        public static /* synthetic */ Builder animator$default(Builder r0, float r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = 1.0f;
        L6:
            return r0.animator(r1);
        }

        public final Builder animator(float r1) {
            this.animationSpeed = r1;
            return this;
        }

        public final ValueAnimatable build() {
            if (this.valueAnimationCommand != null) goto L5;
            OEasingKt.throwIllegalArgumentException("必须先调用方法ofXXX方法指定动画初始和目标值");
        L5:
            float r2 = this.animationSpeed;
            float r3 = 60.0f;
            AnimationCommand<?> r4 = this.valueAnimationCommand;
            if (r4 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("valueAnimationCommand");
        L9:
            return new ValueAnimatable(r2, r3, r4, this.onUpdateCallback, this.onEndCallback, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ValueAnimatable(float r1, float r2, AnimationCommand<?> r3, Function3<? super String, Object, Object, Unit> r4, Function2<? super Boolean, ? super Throwable, Unit> r5) {
        this.animationSpeed = r1;
        this.targetFps = r2;
        this.valueAnimationCommand = r3;
        this.onUpdateCallback = r4;
        this.onEndCallback = r5;
        this.TAG = "ValueAnimatable";
    }

    public /* synthetic */ ValueAnimatable(float r1, float r2, AnimationCommand r3, Function3 r4, Function2 r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r4, r5);
    }

    public final float getAnimationSpeed() {
        return this.animationSpeed;
    }

    public final float getTargetFps() {
        return this.targetFps;
    }

    public final AnimationCommand<?> getValueAnimationCommand() {
        return this.valueAnimationCommand;
    }

    /* synthetic */ ValueAnimatable(float r7, float r8, AnimationCommand r9, Function3 r10, Function2 r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = 1.0f;
    L5:
        float r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = 60.0f;
    L8:
        float r2 = r8;
        if ((r12 & 8) == 0) goto L11;
        Function3 r14 = (Function3) null;
        Function3 r4 = null;
    L13:
        if ((r12 & 16) == 0) goto L15;
        Function2 r15 = (Function2) null;
        Function2 r5 = null;
    L16:
        this(r1, r2, r9, r4, r5);
        return;
    L15:
        r5 = r11;
        goto L16
    L11:
        r4 = r10;
        goto L13
    }

    public final Function3<String, Object, Object, Unit> getOnUpdateCallback() {
        return this.onUpdateCallback;
    }

    public final Function2<Boolean, Throwable, Unit> getOnEndCallback() {
        return this.onEndCallback;
    }

    public final AnimationManager start() {
        OEALogger.INSTANCE.d(this.TAG, "执行start ");
        AnimatableSubmitter r3 = AnimatableSubmitter.INSTANCE;
        float r4 = this.targetFps;
        RunMode r6 = RunMode.PARALLEL;
        float r7 = this.animationSpeed;
        RepeatMode r8 = RepeatMode.NORMAL;
        ArrayList r9 = new ArrayList();
        r9.add(this.valueAnimationCommand);
        Unit r0 = Unit.INSTANCE;
        return r3.parseAndExecute(r4, null, r6, r7, r8, r9, this.onUpdateCallback, this.onEndCallback);
    }
}
