package com.obric.common.oea.foundation.animation.builder;

import android.view.View;
import com.obric.common.oea.foundation.animation.command.AnimationCommand;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.animation.manager.AnimationManager;
import com.obric.common.oea.foundation.animation.parser.AnimatableSubmitter;
import com.obric.common.oea.foundation.animation.spec.spring.FloatSpringSpec;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.obric.common.oea.foundation.animation.token.OEasingKt;
import com.obric.common.oea.foundation.util.OEALogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PropertyAnimatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f102a;
    public final View b;
    public final float c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f103d;
    public final List e;
    public final Function3 f;
    public final Function2 g;

    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f104a;
        public float b;
        public final ArrayList c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Function3 f105d;
        public final View e;

        public Builder(View r2) {
            Intrinsics.f(r2, "view");
            this.e = r2;
            this.f104a = 1.0f;
            this.b = 60.0f;
            this.c = new ArrayList();
        }

        public final PropertyAnimatable a() {
            ArrayList r4 = this.c;
            if (r4 != null) goto L5;
        L8:
            int r8 = OEasingKt.f129a;
            throw new IllegalArgumentException("必须先调用方法ofXXX方法指定添加动画");
        L5:
            if (r4.isEmpty() == true) goto L8;
            float r2 = this.f104a;
            float r3 = this.b;
            Function3 r5 = this.f105d;
            return new PropertyAnimatable(this.e, r2, r3, r4, r5, null);
        }

        public final void b(AnimationProperty.FloatProperty r9, Float r10, float r11, FloatSpringSpec r12, Float r13) {
            Float r2 = Float.valueOf(r10.floatValue());
            Float r3 = Float.valueOf(r11);
            ClassReference r6 = Reflection.a(Float.TYPE);
            AnimationCommand.SpringAnimationCommand r7 = new AnimationCommand.SpringAnimationCommand(r12, r2, r3, r13, r9.b, r6);
            this.c.add(r7);
        }
    }

    public PropertyAnimatable(View r1, float r2, float r3, List r4, Function3 r5, Function2 r6) {
        this.b = r1;
        this.c = r2;
        this.f103d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.f102a = "PropertyAnimatable";
    }

    public static AnimationManager a(PropertyAnimatable r8) {
        RunMode r2 = RunMode.b;
        RepeatMode r4 = RepeatMode.b;
        OEALogger.a(r8.f102a, "执行start ");
        List r5 = r8.e;
        if (r5 == null) goto L7;
        float r3 = r8.c;
        float r0 = r8.f103d;
        Function3 r6 = r8.f;
        Function2 r7 = r8.g;
        return AnimatableSubmitter.a(r0, r8.b, r2, r3, r4, r5, r6, r7);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.obric.common.oea.foundation.animation.command.AnimationCommand<kotlin.Any>>");
    }
}
