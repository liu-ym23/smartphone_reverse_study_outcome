package com.obric.oui.texteffects.render;

import android.graphics.BlurMaskFilter;
import android.util.SparseArray;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BlurMaskFilterCache.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u0003R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/oui/texteffects/render/BlurMaskFilterCache;", "", "maxRadiusPx", "", "granularityPx", "(FF)V", "cache", "Landroid/util/SparseArray;", "Landroid/graphics/BlurMaskFilter;", "clear", "", "get", "radiusPx", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BlurMaskFilterCache {
    private final SparseArray<BlurMaskFilter> cache;
    private final float granularityPx;
    private final float maxRadiusPx;

    public BlurMaskFilterCache(float r1, float r2) {
        this.maxRadiusPx = r1;
        this.granularityPx = r2;
        this.cache = new SparseArray();
    }

    public /* synthetic */ BlurMaskFilterCache(float r1, float r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0.5f;
    L5:
        this(r1, r2);
    }

    public final BlurMaskFilter get(float r5) {
        if (Float.isNaN(r5) == false) goto L5;
    L20:
        return null;
    L5:
        if (Float.isInfinite(r5) == true) goto L20;
        if (r5 <= 0.01f) goto L20;
        int r6 = RangesKt.coerceAtLeast(MathKt.roundToInt(RangesKt.coerceAtLeast(RangesKt.coerceAtMost(r5, this.maxRadiusPx), this.granularityPx) / this.granularityPx), 1);
        BlurMaskFilter r0 = this.cache.get(r6);
        if (r0 == null) goto L21;
        return r0;
    L21:
        BlurMaskFilter r2 = new BlurMaskFilter(r6 * this.granularityPx, BlurMaskFilter.Blur.NORMAL);     // Catch: RuntimeException -> L15
    L16:
        if (r2 != null) goto L18;
        return null;
    L18:
        this.cache.put(r6, r2);
        return r2;
    L15:
        BlurMaskFilter r1 = (BlurMaskFilter) null;
        r2 = null;
        goto L16
    }

    public final void clear() {
        this.cache.clear();
    }
}
