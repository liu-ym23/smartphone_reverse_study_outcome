package com.obric.common.oea.style.scene.qsanim.common;

import android.view.View;
import android.view.ViewGroup;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0004J\n\u0010\u0015\u001a\u00020\u0016*\u00020\f¨\u0006\u0017"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/common/ViewUtils;", "", "()V", "clamp", "", BaseSwitches.V, "min", "max", "getRelativeLocation", "Lkotlin/Pair;", "", "view", "Landroid/view/View;", "viewGroup", "Landroid/view/ViewGroup;", "rubberBand", "dis", "dimension", "constant", "rubberBandIfOutOfBounds", "position", "idExt", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class ViewUtils {
    public static final ViewUtils INSTANCE = null;

    private final float rubberBand(float r1, float r2, float r3) {
        return (1.0f - (1.0f / (((r1 * r3) / r2) + 1.0f))) * r2;
    }

    static {
        INSTANCE = new ViewUtils();
    }

    private ViewUtils() {
    }

    public final String idExt(View r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$idExt");
        return "view_" + r2.hashCode();
    }

    public final Pair<Integer, Integer> getRelativeLocation(View r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "viewGroup");
        int r3 = 0;
        View r0 = r4;
        int r6 = 0;
    L3:
        if (r0 == null) goto L13;
        if ((!Intrinsics.areEqual(r0, r5)) == false) goto L13;
        r3 = r3 + r0.getLeft();
        r6 = r6 + r0.getTop();
        KtExt r1 = KtExt.INSTANCE;
        Object r2 = r0.getParent();
        if (r2 != null) goto L10;
    L8:
        r2 = null;
    L11:
        r0 = (View) r2;
        goto L3
    L10:
        if ((r2 instanceof View) == false) goto L8;
    L13:
        return new Pair(Integer.valueOf(r3), Integer.valueOf(r6));
    }

    public static /* synthetic */ float rubberBandIfOutOfBounds$default(ViewUtils r0, float r1, float r2, float r3, float r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = 0.55f;
    L6:
        return r0.rubberBandIfOutOfBounds(r1, r2, r3, r4);
    }

    public final float rubberBandIfOutOfBounds(float r2, float r3, float r4, float r5) {
        if (r5 != 0.0f) goto L6;
        return clamp(r2, r3, r4);
    L6:
        if (r2 >= r3) goto L9;
        return (-rubberBand(r3 - r2, r4 - r3, r5)) + r3;
    L9:
        if (r2 > r4) goto L11;
        return r2;
    L11:
        return rubberBand(r2 - r4, r4 - r3, r5) + r4;
    }

    private final float clamp(float r1, float r2, float r3) {
        return Math.max(r2, Math.min(r1, r3));
    }
}
