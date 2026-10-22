package com.obric.oui.utils;

import com.bytedance.apm.constant.TraceStatsConsts;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: AnimUtils.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0004H\u0007J \u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0007J \u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0007J0\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/utils/AnimUtils;", "", "()V", "evaluateColor", "", "fraction", "", "startColor", "endColor", "getAnimFraction", "currentValue", "startValue", "endValue", "lerp", "start", TraceStatsConsts.STATS_KEY_END, "normalize", "value", "stop", "remap", "inMin", "inMax", "outMin", "outMax", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnimUtils {
    public static final AnimUtils INSTANCE = null;

    static {
        INSTANCE = new AnimUtils();
    }

    @JvmStatic
    public static final int evaluateColor(float r7, int r8, int r9) {
        int r0 = (r8 >> 24) & 255;
        int r1 = (r8 >> 16) & 255;
        int r2 = (r8 >> 8) & 255;
        int r10 = r8 & 255;
        return ((int) (r10 + (r7 * ((r9 & 255) - r10)))) | (((((int) (r0 + ((((r9 >> 24) & 255) - r0) * r7))) << 24) | (((int) (r1 + ((((r9 >> 16) & 255) - r1) * r7))) << 16)) | (((int) (r2 + ((((r9 >> 8) & 255) - r2) * r7))) << 8));
    }

    @JvmStatic
    public static final float getAnimFraction(float r0, float r1, float r2) {
        return (r0 - r1) / (r2 - r1);
    }

    @JvmStatic
    public static final float lerp(float r0, float r1, float r2) {
        return r0 + ((r1 - r0) * r2);
    }

    @JvmStatic
    public static final float normalize(float r1, float r2, float r3) {
        if (r2 != r3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return 0.0f;
    L10:
        return (r1 - r2) / (r3 - r2);
    L5:
        r0 = false;
        goto L6
    }

    private AnimUtils() {
    }

    @JvmStatic
    public static final float remap(float r1, float r2, float r3, float r4, float r5) {
        if (r2 >= r3) goto L5;
        float r6 = RangesKt.coerceIn(r1, r2, r3);
    L7:
        return lerp(r4, r5, normalize(r6, r2, r3));
    L5:
        r6 = RangesKt.coerceIn(r1, r3, r2);
        goto L7
    }
}
