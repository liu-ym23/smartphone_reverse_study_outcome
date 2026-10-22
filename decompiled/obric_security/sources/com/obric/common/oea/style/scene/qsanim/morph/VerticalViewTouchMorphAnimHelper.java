package com.obric.common.oea.style.scene.qsanim.morph;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewTouchMorphAnimHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/VerticalViewTouchMorphAnimHelper;", "Lcom/obric/common/oea/style/scene/qsanim/morph/ViewTouchMorphAnimHelper;", "view", "Landroid/view/View;", "morphFactorY", "", "upMorphStartPoint", "", "downMorphStartPoint", "(Landroid/view/View;FII)V", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class VerticalViewTouchMorphAnimHelper extends ViewTouchMorphAnimHelper {
    public /* synthetic */ VerticalViewTouchMorphAnimHelper(View r2, float r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = 0;
    L8:
        this(r2, r3, r4, r5);
    }

    public VerticalViewTouchMorphAnimHelper(View r10, float r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super(r10, 0.0f, r11, Integer.MAX_VALUE, Integer.MAX_VALUE, r12, r13);
    }
}
