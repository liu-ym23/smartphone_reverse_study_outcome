package com.obric.common.oea.foundation.animation.engine;

import android.view.View;
import com.obric.common.oea.foundation.animation.engine.DynamicAnimation;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DynamicAnimation<T extends DynamicAnimation<T>> implements AnimationHandler.AnimationFrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f117a;
    public long b;

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.engine.DynamicAnimation$1, reason: invalid class name */
    public static class AnonymousClass1 extends ViewProperty {
    }

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.engine.DynamicAnimation$10, reason: invalid class name */
    public static class AnonymousClass10 extends ViewProperty {
    }

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.engine.DynamicAnimation$11, reason: invalid class name */
    public static class AnonymousClass11 extends ViewProperty {
    }

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.engine.DynamicAnimation$12, reason: invalid class name */
    public static class AnonymousClass12 extends ViewProperty {
    }

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.engine.DynamicAnimation$13, reason: invalid class name */
    public static class AnonymousClass13 extends ViewProperty {
    }

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.engine.DynamicAnimation$14, reason: invalid class name */
    public static class AnonymousClass14 extends ViewProperty {
    }

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.engine.DynamicAnimation$15, reason: invalid class name */
    class AnonymousClass15 extends FloatPropertyCompat {
    }

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.engine.DynamicAnimation$2, reason: invalid class name */
    public static class AnonymousClass2 extends ViewProperty {
    }

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.engine.DynamicAnimation$3, reason: invalid class name */
    public static class AnonymousClass3 extends ViewProperty {
    }

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.engine.DynamicAnimation$4, reason: invalid class name */
    public static class AnonymousClass4 extends ViewProperty {
    }

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.engine.DynamicAnimation$5, reason: invalid class name */
    public static class AnonymousClass5 extends ViewProperty {
    }

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.engine.DynamicAnimation$6, reason: invalid class name */
    public static class AnonymousClass6 extends ViewProperty {
    }

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.engine.DynamicAnimation$7, reason: invalid class name */
    public static class AnonymousClass7 extends ViewProperty {
    }

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.engine.DynamicAnimation$8, reason: invalid class name */
    public static class AnonymousClass8 extends ViewProperty {
    }

    /* JADX INFO: renamed from: com.obric.common.oea.foundation.animation.engine.DynamicAnimation$9, reason: invalid class name */
    public static class AnonymousClass9 extends ViewProperty {
    }

    public static class MassState {
    }

    public interface OnAnimationEndListener {
    }

    public interface OnAnimationUpdateListener {
    }

    public static abstract class ViewProperty extends FloatPropertyCompat<View> {
    }

    @Override // com.obric.common.oea.foundation.animation.engine.AnimationHandler.AnimationFrameCallback
    public final boolean a(long r5) {
        long r0 = this.b;
        if (r0 != 0) goto L6;
        this.b = r5;
        throw null;
    L6:
        this.b = r5;
        b(r5 - r0);
        float r6 = Math.min(this.f117a, 0.0f);
        this.f117a = r6;
        this.f117a = Math.max(r6, 0.0f);
        throw null;
    }

    public abstract boolean b(long r1);
}
