package com.obric.common.oea.style.scene.qsanim.common;

import android.animation.TimeInterpolator;
import kotlin.Metadata;

/* JADX INFO: compiled from: PropertyAnimUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/common/CubicEaseOutInterpolator;", "Landroid/animation/TimeInterpolator;", "()V", "getInterpolation", "", "t", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class CubicEaseOutInterpolator implements TimeInterpolator {
    public CubicEaseOutInterpolator() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r5) {
        float r4 = 1;
        return ((float) Math.pow(r5 - r4, 3)) + r4;
    }
}
