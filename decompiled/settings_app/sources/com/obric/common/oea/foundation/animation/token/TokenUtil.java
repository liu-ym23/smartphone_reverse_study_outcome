package com.obric.common.oea.foundation.animation.token;

import android.animation.TimeInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TokenUtil.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004¨\u0006\u001c"}, d2 = {"Lcom/obric/common/oea/foundation/animation/token/TokenUtil;", "", "()V", "bounceToDampingRatio", "", "bounce", "dampingRatioToBounce", "dampingRatio", "durationToStiffness", "duration", "getBounceByToken", "bounceEnum", "Lcom/obric/common/oea/foundation/animation/token/Token$Bounce;", "getDampingRatioByToken", "getDelayByToken", "", "delay", "Lcom/obric/common/oea/foundation/animation/token/Token$Delay;", "getDurationByToken", "durationEnum", "Lcom/obric/common/oea/foundation/animation/token/Token$Duration;", "getInterpolator", "Landroid/animation/TimeInterpolator;", "easing", "Lcom/obric/common/oea/foundation/animation/token/Token$Easing;", "getStiffnessByToken", "stiffnessToDuration", "stiffness", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class TokenUtil {
    public static final TokenUtil INSTANCE = null;

    static {
        INSTANCE = new TokenUtil();
    }

    private TokenUtil() {
    }

    public final float durationToStiffness(float r3) {
        if (r3 == 0.0f) goto L7;
        return (float) Math.pow(6.2831855f / r3, 2.0f);
    L7:
        throw new IllegalArgumentException("Duration cannot be zero.");
    }

    public final float stiffnessToDuration(float r1) {
        if (r1 < 0.0f) goto L7;
        return 6.2831855f / ((float) Math.sqrt(r1));
    L7:
        throw new IllegalArgumentException("Stiffness cannot be negative.");
    }

    public final float bounceToDampingRatio(float r3) {
        if (r3 < 0.0f) goto L8;
        if (r3 > 1.0f) goto L8;
        return 1.0f - r3;
    L8:
        if (r3 < (-1.0f)) goto L14;
        if (r3 > 0.0f) goto L14;
        return 1.0f / (r3 + 1.0f);
    L14:
        throw new IllegalArgumentException("Invalid bounce value. Bounce should be in the range (-1, 1].");
    }

    public final float dampingRatioToBounce(float r2) {
        if (r2 < 0.0f) goto L8;
        if (r2 > 1.0f) goto L8;
        return 1.0f - r2;
    L8:
        if (r2 <= 1.0f) goto L12;
        return (1.0f / r2) - 1.0f;
    L12:
        throw new IllegalArgumentException("Invalid dampingRatio value. DampingRatio should be greater than 0.");
    }

    public final TimeInterpolator getInterpolator(Token.Easing r5) {
        Intrinsics.checkNotNullParameter(r5, "easing");
        if (r5 != Token.Easing.OUI_ANIMATION_EASING_LINEAR) goto L7;
        return new LinearInterpolator();
    L7:
        return new PathInterpolator(r5.getValues()[0], r5.getValues()[1], r5.getValues()[2], r5.getValues()[3]);
    }

    public final int getDurationByToken(Token.Duration r1) {
        Intrinsics.checkNotNullParameter(r1, "durationEnum");
        return r1.getDuration();
    }

    public final int getStiffnessByToken(Token.Duration r1) {
        Intrinsics.checkNotNullParameter(r1, "durationEnum");
        return r1.getStiffness();
    }

    public final int getDelayByToken(Token.Delay r1) {
        Intrinsics.checkNotNullParameter(r1, "delay");
        return r1.getValue();
    }

    public final float getBounceByToken(Token.Bounce r1) {
        Intrinsics.checkNotNullParameter(r1, "bounceEnum");
        return r1.getBounce();
    }

    public final float getDampingRatioByToken(Token.Bounce r1) {
        Intrinsics.checkNotNullParameter(r1, "bounceEnum");
        return r1.getDampingRatio();
    }
}
