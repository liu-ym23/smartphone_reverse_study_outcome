package com.obric.common.oea.foundation.animation.spec;

import com.obric.common.oea.foundation.animation.spec.spring.FloatSpringSpec;
import com.obric.common.oea.foundation.animation.spec.spring.IntSpringSpec;
import com.obric.common.oea.foundation.animation.spec.tween.FloatTweenSpec;
import com.obric.common.oea.foundation.animation.spec.tween.IntTweenSpec;
import com.obric.common.oea.foundation.animation.token.Token;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimationSpec.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\b\u001a$\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\b\u001a\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a \u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\b\u001a \u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\b\u001a \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u001a \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011¨\u0006\u0014"}, d2 = {"spring", "Lcom/obric/common/oea/foundation/animation/spec/spring/FloatSpringSpec;", "bounce", "Lcom/obric/common/oea/foundation/animation/token/Token$Bounce;", "duration", "Lcom/obric/common/oea/foundation/animation/token/Token$Duration;", "delay", "Lcom/obric/common/oea/foundation/animation/token/Token$Delay;", "", "dampingRatio", "", "stiffness", "springInt", "Lcom/obric/common/oea/foundation/animation/spec/spring/IntSpringSpec;", "tween", "Lcom/obric/common/oea/foundation/animation/spec/tween/FloatTweenSpec;", "easing", "Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "tweenInt", "Lcom/obric/common/oea/foundation/animation/spec/tween/IntTweenSpec;", "foundation_standardRelease"}, k = 2, mv = {1, 4, 3})
public final class AnimationSpecKt {
    public static /* synthetic */ FloatTweenSpec tween$default(Token.Duration r0, Token.Delay r1, Token.Easing r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = Token.Easing.OUI_ANIMATION_EASING_STANDARD;
    L6:
        return tween(r0, r1, r2);
    }

    public static final FloatTweenSpec tween(Token.Duration r1, Token.Delay r2, Token.Easing r3) {
        Intrinsics.checkNotNullParameter(r1, "duration");
        Intrinsics.checkNotNullParameter(r2, "delay");
        Intrinsics.checkNotNullParameter(r3, "easing");
        return new FloatTweenSpec(r1.getDuration(), r2.getValue(), r3);
    }

    public static /* synthetic */ FloatTweenSpec tween$default(int r0, int r1, Token.Easing r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = Token.Easing.OUI_ANIMATION_EASING_STANDARD;
    L6:
        return tween(r0, r1, r2);
    }

    public static final FloatTweenSpec tween(int r1, int r2, Token.Easing r3) {
        Intrinsics.checkNotNullParameter(r3, "easing");
        return new FloatTweenSpec(r1, r2, r3);
    }

    public static /* synthetic */ IntTweenSpec tweenInt$default(Token.Duration r0, Token.Delay r1, Token.Easing r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = Token.Easing.OUI_ANIMATION_EASING_STANDARD;
    L6:
        return tweenInt(r0, r1, r2);
    }

    public static final IntTweenSpec tweenInt(Token.Duration r8, Token.Delay r9, Token.Easing r10) {
        Intrinsics.checkNotNullParameter(r8, "duration");
        Intrinsics.checkNotNullParameter(r9, "delay");
        Intrinsics.checkNotNullParameter(r10, "easing");
        return new IntTweenSpec(r8.getDuration(), r9.getValue(), r10, false, 8, null);
    }

    public static /* synthetic */ IntTweenSpec tweenInt$default(int r0, int r1, Token.Easing r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = Token.Easing.OUI_ANIMATION_EASING_STANDARD;
    L6:
        return tweenInt(r0, r1, r2);
    }

    public static final IntTweenSpec tweenInt(int r8, int r9, Token.Easing r10) {
        Intrinsics.checkNotNullParameter(r10, "easing");
        return new IntTweenSpec(r8, r9, r10, false, 8, null);
    }

    public static /* synthetic */ FloatSpringSpec spring$default(float r0, float r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r0 = 1.0f;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r1 = 1500.0f;
    L9:
        if ((r3 & 4) == 0) goto L12;
        r2 = 0;
    L12:
        return spring(r0, r1, r2);
    }

    public static final FloatSpringSpec spring(float r8, float r9, int r10) {
        return new FloatSpringSpec(r8, r9, r10, 0.0f, 8, null);
    }

    public static final FloatSpringSpec spring(Token.Bounce r8, Token.Duration r9, Token.Delay r10) {
        Intrinsics.checkNotNullParameter(r8, "bounce");
        Intrinsics.checkNotNullParameter(r9, "duration");
        Intrinsics.checkNotNullParameter(r10, "delay");
        return new FloatSpringSpec(r8.getDampingRatio(), r9.getStiffness(), r10.getValue(), 0.0f, 8, null);
    }

    public static /* synthetic */ FloatSpringSpec spring$default(Token.Bounce r0, Token.Duration r1, int r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = 0;
    L6:
        return spring(r0, r1, r2);
    }

    public static final FloatSpringSpec spring(Token.Bounce r8, Token.Duration r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "bounce");
        Intrinsics.checkNotNullParameter(r9, "duration");
        return new FloatSpringSpec(r8.getDampingRatio(), r9.getStiffness(), r10, 0.0f, 8, null);
    }

    public static final IntSpringSpec springInt(Token.Bounce r9, Token.Duration r10, Token.Delay r11) {
        Intrinsics.checkNotNullParameter(r9, "bounce");
        Intrinsics.checkNotNullParameter(r10, "duration");
        Intrinsics.checkNotNullParameter(r11, "delay");
        return new IntSpringSpec(r9.getDampingRatio(), r10.getStiffness(), r11.getValue(), 0.0f, false, 24, null);
    }

    public static /* synthetic */ IntSpringSpec springInt$default(float r0, float r1, int r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = 0;
    L6:
        return springInt(r0, r1, r2);
    }

    public static final IntSpringSpec springInt(float r9, float r10, int r11) {
        return new IntSpringSpec(r9, r10, r11, 0.0f, false, 24, null);
    }

    public static /* synthetic */ IntSpringSpec springInt$default(Token.Bounce r0, Token.Duration r1, int r2, int r3, Object r4) {
        if ((r3 & 4) == 0) goto L6;
        r2 = 0;
    L6:
        return springInt(r0, r1, r2);
    }

    public static final IntSpringSpec springInt(Token.Bounce r9, Token.Duration r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "bounce");
        Intrinsics.checkNotNullParameter(r10, "duration");
        return new IntSpringSpec(r9.getDampingRatio(), r10.getStiffness(), r11, 0.0f, false, 24, null);
    }
}
