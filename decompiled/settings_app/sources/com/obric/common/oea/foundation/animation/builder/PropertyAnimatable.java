package com.obric.common.oea.foundation.animation.builder;

import android.view.View;
import com.android.settings.search.IndexDatabaseHelper;
import com.bytedance.apm.trace.fps.RealFpsTracer;
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
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.obric.common.oea.foundation.animation.token.OEasingKt;
import com.obric.common.oea.foundation.util.OEALogger;
import com.obric.oui.material.MaterialConfigFormatNames;
import defpackage.ViewUtilKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: PropertyAnimatable.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB{\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b\u0012\"\b\u0002\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\u001e\b\u0002\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007R\u000e\u0010\u0013\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable;", "", "view", "Landroid/view/View;", "animationSpeed", "", "targetFps", "animationCommands", "", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", "onUpdateCallback", "Lkotlin/Function3;", "", "", "onEndCallback", "Lkotlin/Function2;", "", "", "(Landroid/view/View;FFLjava/util/List;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;)V", "TAG", "start", "Lcom/obric/common/oea/foundation/animation/manager/AnimationManager;", "mode", "Lcom/obric/common/oea/foundation/animation/constants/RunMode;", "repeatMode", "Lcom/obric/common/oea/foundation/animation/constants/RepeatMode;", "Builder", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class PropertyAnimatable {
    private final String TAG;
    private final List<AnimationCommand<?>> animationCommands;
    private float animationSpeed;
    private Function2<? super Boolean, ? super Throwable, Unit> onEndCallback;
    private Function3<? super String, Object, Object, Unit> onUpdateCallback;
    private float targetFps;
    private final View view;

    /* JADX INFO: compiled from: PropertyAnimatable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0003J5\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\"J5\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\"J?\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\t2\u0006\u0010*\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010+J?\u0010,\u001a\u00020\u00002\u0006\u0010'\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020/2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020/0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u00101J?\u00102\u001a\u00020\u00002\u0006\u0010'\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020/2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020/0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u00101JK\u00102\u001a\u00020\u00002\u0006\u0010'\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020/2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020/0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\b\u0002\u00103\u001a\u00020\fH\u0002¢\u0006\u0002\u00104J\"\u00105\u001a\u00020\u00002\u001a\u00106\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e0\u000bJS\u00107\u001a\u00020\u00002K\u00106\u001aG\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u000e0\u0010J-\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0018J-\u0010=\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0018J5\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\"J5\u0010A\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\"R\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u001c\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "animationCommands", "", "Lcom/obric/common/oea/foundation/animation/command/AnimationCommand;", "animationSpeed", "", "onEndCallback", "Lkotlin/Function2;", "", "", "", "onUpdateCallback", "Lkotlin/Function3;", "", "targetFps", "alphaBy", "deltaAlpha", "spec", "Lcom/obric/common/oea/foundation/animation/spec/AnimationSpec;", "initialVelocity", "(FLcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "alphaTo", "alpha", "animator", IndexDatabaseHelper.MetaColumns.BUILD, "Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable;", "getView", "moveBy", "dx", "dy", "(FFLcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "moveTo", MaterialConfigFormatNames.X, "y", "of", "property", "Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$FloatProperty;", "initialValue", "targetValue", "(Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$FloatProperty;Ljava/lang/Float;FLcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "ofColor", "Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$IntProperty;", "initialInt", "", "targetInt", "(Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$IntProperty;Ljava/lang/Integer;ILcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "ofInt", "isColor", "(Lcom/obric/common/oea/foundation/animation/token/AnimationProperty$IntProperty;Ljava/lang/Integer;ILcom/obric/common/oea/foundation/animation/spec/AnimationSpec;Ljava/lang/Float;Z)Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "onEnd", "callback", "onUpdate", "Lkotlin/ParameterName;", "name", RealFpsTracer.SCROLL_VELOCITY, "rotateBy", "rotation", "rotateTo", "scaleBy", "scaleX", "scaleY", "scaleTo", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Builder {
        private final List<AnimationCommand<?>> animationCommands;
        private float animationSpeed;
        private Function2<? super Boolean, ? super Throwable, Unit> onEndCallback;
        private Function3<? super String, Object, Object, Unit> onUpdateCallback;
        private float targetFps;
        private final View view;

        public Builder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            this.view = r2;
            this.animationSpeed = 1.0f;
            this.targetFps = 60.0f;
            this.animationCommands = new ArrayList();
        }

        public final View getView() {
            return this.view;
        }

        public static /* synthetic */ Builder animator$default(Builder r1, float r2, float r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = 1.0f;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r3 = 1.0f;
        L9:
            return r1.animator(r2, r3);
        }

        public final Builder animator(float r2, float r3) {
            if (r2 > 0) goto L5;
            OEasingKt.throwIllegalArgumentException("animationSpeed必须大于 0");
        L5:
            this.animationSpeed = r2;
            this.targetFps = r3;
            return this;
        }

        public static /* synthetic */ Builder ofInt$default(Builder r6, AnimationProperty.IntProperty r7, Integer r8, int r9, AnimationSpec r10, Float r11, int r12, Object r13) {
            if ((r12 & 16) == 0) goto L6;
            r11 = null;
            Float r14 = (Float) null;
        L6:
            return r6.ofInt(r7, r8, r9, r10, r11);
        }

        public final Builder ofInt(AnimationProperty.IntProperty r9, Integer r10, int r11, AnimationSpec<Integer> r12, Float r13) {
            Intrinsics.checkNotNullParameter(r9, "property");
            Intrinsics.checkNotNullParameter(r12, "spec");
            return ofInt(r9, r10, r11, r12, r13, false);
        }

        public static /* synthetic */ Builder ofColor$default(Builder r6, AnimationProperty.IntProperty r7, Integer r8, int r9, AnimationSpec r10, Float r11, int r12, Object r13) {
            if ((r12 & 16) == 0) goto L6;
            r11 = null;
            Float r14 = (Float) null;
        L6:
            return r6.ofColor(r7, r8, r9, r10, r11);
        }

        public final Builder ofColor(AnimationProperty.IntProperty r9, Integer r10, int r11, AnimationSpec<Integer> r12, Float r13) {
            Intrinsics.checkNotNullParameter(r9, "property");
            Intrinsics.checkNotNullParameter(r12, "spec");
            return ofInt(r9, r10, r11, r12, r13, true);
        }

        static /* synthetic */ Builder ofInt$default(Builder r7, AnimationProperty.IntProperty r8, Integer r9, int r10, AnimationSpec r11, Float r12, boolean r13, int r14, Object r15) {
            if ((r14 & 16) == 0) goto L5;
            r12 = null;
            Float r16 = (Float) null;
        L5:
            Float r5 = r12;
            if ((r14 & 32) == 0) goto L9;
            r13 = false;
        L9:
            return r7.ofInt(r8, r9, r10, r11, r5, r13);
        }

        private final Builder ofInt(AnimationProperty.IntProperty r9, Integer r10, int r11, AnimationSpec<Integer> r12, Float r13, boolean r14) {
            if (r10 == null) goto L29;
            int r15 = r10.intValue();
        L15:
            if ((r12 instanceof IntTweenSpec) == false) goto L21;
            if (r12 == null) goto L19;
            ((IntTweenSpec) r12).setColor(r14);
            AnimationCommand.SpringAnimationCommand r16 = new AnimationCommand.TweenAnimationCommand(r9.getPropertyName(), Integer.valueOf(r15), Integer.valueOf(r11), Reflection.getOrCreateKotlinClass(Integer.TYPE), r12, r13);
        L23:
            this.animationCommands.add(r16);
            return this;
        L19:
            throw new NullPointerException("null cannot be cast to non-null type com.obric.common.oea.foundation.animation.spec.tween.IntTweenSpec");
        L21:
            if ((r12 instanceof IntSpringSpec) == false) goto L26;
            r16 = new AnimationCommand.SpringAnimationCommand(r9.getPropertyName(), Integer.valueOf(r15), Integer.valueOf(r11), Reflection.getOrCreateKotlinClass(Integer.TYPE), r12, r13);
            goto L23
        L26:
            throw new IllegalStateException("不支持的 spec 类型: " + r12.getClass().getSimpleName());
        L29:
            Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L9
            Builder r18 = this;     // Catch: Throwable -> L9
            Object r19 = ViewUtilKt.getPropertyValue(this.view, r9.getPropertyName());     // Catch: Throwable -> L9
            if (r19 == null) goto L8;
            Object r110 = Result.m1508constructorimpl(Integer.valueOf(((Integer) r19).intValue()));     // Catch: Throwable -> L9
        L11:
            Throwable r0 = Result.m1511exceptionOrNullimpl(r110);
            if (r0 != null) goto L28;
            r15 = ((Number) r110).intValue();
            goto L15
        L28:
            throw new IllegalArgumentException("获取属性 " + r9.getPropertyName() + " 的初始值时出错，请检查", r0);
        L8:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            r110 = Result.m1508constructorimpl(ResultKt.createFailure(th));
            goto L11
        }

        public static /* synthetic */ Builder moveTo$default(Builder r0, float r1, float r2, AnimationSpec r3, Float r4, int r5, Object r6) {
            if ((r5 & 8) == 0) goto L6;
            r4 = null;
            Float r7 = (Float) null;
        L6:
            return r0.moveTo(r1, r2, r3, r4);
        }

        public final Builder moveTo(float r11, float r12, AnimationSpec<Float> r13, Float r14) {
            Intrinsics.checkNotNullParameter(r13, "spec");
            of(AnimationProperty.FloatProperty.X, null, r11, r13, r14);
            of(AnimationProperty.FloatProperty.Y, null, r12, r13, r14);
            return this;
        }

        public static /* synthetic */ Builder moveBy$default(Builder r0, float r1, float r2, AnimationSpec r3, Float r4, int r5, Object r6) {
            if ((r5 & 8) == 0) goto L6;
            r4 = null;
            Float r7 = (Float) null;
        L6:
            return r0.moveBy(r1, r2, r3, r4);
        }

        public final Builder moveBy(float r8, float r9, AnimationSpec<Float> r10, Float r11) {
            Intrinsics.checkNotNullParameter(r10, "spec");
            float r0 = this.view.getX();
            float r6 = this.view.getY();
            of(AnimationProperty.FloatProperty.X, null, r0 + r8, r10, r11);
            of(AnimationProperty.FloatProperty.Y, null, r6 + r9, r10, r11);
            return this;
        }

        public static /* synthetic */ Builder scaleTo$default(Builder r0, float r1, float r2, AnimationSpec r3, Float r4, int r5, Object r6) {
            if ((r5 & 8) == 0) goto L6;
            r4 = null;
            Float r7 = (Float) null;
        L6:
            return r0.scaleTo(r1, r2, r3, r4);
        }

        public final Builder scaleTo(float r11, float r12, AnimationSpec<Float> r13, Float r14) {
            Intrinsics.checkNotNullParameter(r13, "spec");
            of(AnimationProperty.FloatProperty.SCALE_X, null, r11, r13, r14);
            of(AnimationProperty.FloatProperty.SCALE_Y, null, r12, r13, r14);
            return this;
        }

        public static /* synthetic */ Builder scaleBy$default(Builder r0, float r1, float r2, AnimationSpec r3, Float r4, int r5, Object r6) {
            if ((r5 & 8) == 0) goto L6;
            r4 = null;
            Float r7 = (Float) null;
        L6:
            return r0.scaleBy(r1, r2, r3, r4);
        }

        public final Builder scaleBy(float r8, float r9, AnimationSpec<Float> r10, Float r11) {
            Intrinsics.checkNotNullParameter(r10, "spec");
            float r0 = this.view.getScaleX();
            float r6 = this.view.getScaleY();
            of(AnimationProperty.FloatProperty.SCALE_X, null, r0 * r8, r10, r11);
            of(AnimationProperty.FloatProperty.SCALE_Y, null, r6 * r9, r10, r11);
            return this;
        }

        public static /* synthetic */ Builder rotateTo$default(Builder r0, float r1, AnimationSpec r2, Float r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = null;
            Float r6 = (Float) null;
        L6:
            return r0.rotateTo(r1, r2, r3);
        }

        public final Builder rotateTo(float r8, AnimationSpec<Float> r9, Float r10) {
            Intrinsics.checkNotNullParameter(r9, "spec");
            of(AnimationProperty.FloatProperty.ROTATION, null, r8, r9, r10);
            return this;
        }

        public static /* synthetic */ Builder rotateBy$default(Builder r0, float r1, AnimationSpec r2, Float r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = null;
            Float r6 = (Float) null;
        L6:
            return r0.rotateBy(r1, r2, r3);
        }

        public final Builder rotateBy(float r8, AnimationSpec<Float> r9, Float r10) {
            Intrinsics.checkNotNullParameter(r9, "spec");
            float r0 = this.view.getRotation();
            of(AnimationProperty.FloatProperty.ROTATION, null, r0 + r8, r9, r10);
            return this;
        }

        public static /* synthetic */ Builder alphaTo$default(Builder r0, float r1, AnimationSpec r2, Float r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = null;
            Float r6 = (Float) null;
        L6:
            return r0.alphaTo(r1, r2, r3);
        }

        public final Builder alphaTo(float r8, AnimationSpec<Float> r9, Float r10) {
            Intrinsics.checkNotNullParameter(r9, "spec");
            of(AnimationProperty.FloatProperty.ALPHA, null, r8, r9, r10);
            return this;
        }

        public static /* synthetic */ Builder alphaBy$default(Builder r0, float r1, AnimationSpec r2, Float r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = null;
            Float r6 = (Float) null;
        L6:
            return r0.alphaBy(r1, r2, r3);
        }

        public final Builder alphaBy(float r8, AnimationSpec<Float> r9, Float r10) {
            Intrinsics.checkNotNullParameter(r9, "spec");
            float r0 = this.view.getAlpha();
            of(AnimationProperty.FloatProperty.ALPHA, null, r0 + r8, r9, r10);
            return this;
        }

        public static /* synthetic */ Builder of$default(Builder r6, AnimationProperty.FloatProperty r7, Float r8, float r9, AnimationSpec r10, Float r11, int r12, Object r13) {
            if ((r12 & 16) == 0) goto L6;
            r11 = null;
            Float r14 = (Float) null;
        L6:
            return r6.of(r7, r8, r9, r10, r11);
        }

        public final Builder of(AnimationProperty.FloatProperty r9, Float r10, float r11, AnimationSpec<Float> r12, Float r13) {
            Intrinsics.checkNotNullParameter(r9, "property");
            Intrinsics.checkNotNullParameter(r12, "spec");
            if (r10 == null) goto L27;
            float r14 = r10.floatValue();
        L16:
            if ((r12 instanceof FloatTweenSpec) == false) goto L19;
            AnimationCommand.SpringAnimationCommand r0 = new AnimationCommand.TweenAnimationCommand(r9.getPropertyName(), Float.valueOf(r14), Float.valueOf(r11), Reflection.getOrCreateKotlinClass(Float.TYPE), r12, r13);
        L21:
            this.animationCommands.add(r0);
            return this;
        L19:
            if ((r12 instanceof FloatSpringSpec) == false) goto L24;
            r0 = new AnimationCommand.SpringAnimationCommand(r9.getPropertyName(), Float.valueOf(r14), Float.valueOf(r11), Reflection.getOrCreateKotlinClass(Float.TYPE), r12, r13);
            goto L21
        L24:
            throw new IllegalStateException("不支持的 spec 类型: " + r12.getClass().getSimpleName());
        L27:
            Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L10
            Builder r16 = this;     // Catch: Throwable -> L10
            Object r17 = ViewUtilKt.getPropertyValue(this.view, r9.getPropertyName());     // Catch: Throwable -> L10
            if (r17 == null) goto L9;
            Object r18 = Result.m1508constructorimpl(Float.valueOf(((Float) r17).floatValue()));     // Catch: Throwable -> L10
        L12:
            Throwable r1 = Result.m1511exceptionOrNullimpl(r18);
            if (r1 != null) goto L26;
            r14 = ((Number) r18).floatValue();
            goto L16
        L26:
            throw new IllegalArgumentException("获取属性 " + r9.getPropertyName() + " 的初始值时出错，请检查", r1);
        L9:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            Result.Companion r2 = Result.Companion;
            r18 = Result.m1508constructorimpl(ResultKt.createFailure(th));
            goto L12
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

        public final PropertyAnimatable build() {
            List<AnimationCommand<?>> r0 = this.animationCommands;
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == false) goto L12;
            OEasingKt.throwIllegalArgumentException("必须先调用方法ofXXX方法指定添加动画");
        L12:
            return new PropertyAnimatable(this.view, this.animationSpeed, this.targetFps, this.animationCommands, this.onUpdateCallback, this.onEndCallback, null);
        L5:
            if (r0.isEmpty() == true) goto L8;
            r1 = false;
            goto L9
        }
    }

    private PropertyAnimatable(View r1, float r2, float r3, List<AnimationCommand<?>> r4, Function3<? super String, Object, Object, Unit> r5, Function2<? super Boolean, ? super Throwable, Unit> r6) {
        this.view = r1;
        this.animationSpeed = r2;
        this.targetFps = r3;
        this.animationCommands = r4;
        this.onUpdateCallback = r5;
        this.onEndCallback = r6;
        this.TAG = "PropertyAnimatable";
    }

    public /* synthetic */ PropertyAnimatable(View r1, float r2, float r3, List r4, Function3 r5, Function2 r6, DefaultConstructorMarker r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

    /* synthetic */ PropertyAnimatable(View r8, float r9, float r10, ArrayList r11, Function3 r12, Function2 r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        r9 = 1.0f;
    L5:
        float r2 = r9;
        if ((r14 & 4) == 0) goto L8;
        r10 = 60.0f;
    L8:
        float r3 = r10;
        if ((r14 & 8) == 0) goto L11;
        r11 = new ArrayList();
    L11:
        List r4 = r11;
        if ((r14 & 16) == 0) goto L14;
        Function3 r16 = (Function3) null;
        Function3 r5 = null;
    L16:
        if ((r14 & 32) == 0) goto L18;
        Function2 r17 = (Function2) null;
        Function2 r6 = null;
    L19:
        this(r8, r2, r3, r4, r5, r6);
        return;
    L18:
        r6 = r13;
        goto L19
    L14:
        r5 = r12;
        goto L16
    }

    public static /* synthetic */ AnimationManager start$default(PropertyAnimatable r0, RunMode r1, RepeatMode r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = RunMode.PARALLEL;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = RepeatMode.NORMAL;
    L9:
        return r0.start(r1, r2);
    }

    public final AnimationManager start(RunMode r13, RepeatMode r14) {
        Intrinsics.checkNotNullParameter(r13, "mode");
        Intrinsics.checkNotNullParameter(r14, "repeatMode");
        OEALogger.INSTANCE.d(this.TAG, "执行start ");
        AnimatableSubmitter r3 = AnimatableSubmitter.INSTANCE;
        float r4 = this.targetFps;
        View r5 = this.view;
        float r7 = this.animationSpeed;
        List<AnimationCommand<?>> r9 = this.animationCommands;
        if (r9 == null) goto L7;
        return r3.parseAndExecute(r4, r5, r13, r7, r14, r9, this.onUpdateCallback, this.onEndCallback);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.obric.common.oea.foundation.animation.command.AnimationCommand<kotlin.Any>>");
    }
}
