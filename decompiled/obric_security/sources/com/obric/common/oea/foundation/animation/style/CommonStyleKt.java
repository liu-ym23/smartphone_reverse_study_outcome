package com.obric.common.oea.foundation.animation.style;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.obric.common.oea.foundation.animation.easy.ViewPropertySpringAnimator;
import com.obric.common.oea.foundation.animation.easy.ViewPropertySpringAnimatorExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: CommonStyle.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004*\u00020\u0002¨\u0006\u0005"}, d2 = {"windowBottomHide", "Landroid/animation/ObjectAnimator;", "Landroid/view/View;", "windowBottomShow", "Lcom/obric/common/oea/foundation/animation/easy/ViewPropertySpringAnimator;", "foundation_standardRelease"}, k = 2, mv = {1, 4, 3})
public final class CommonStyleKt {
    public static final ViewPropertySpringAnimator<View> windowBottomShow(View r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$windowBottomShow");
        Resources r0 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r0, "Resources.getSystem()");
        int r1 = r0.getDisplayMetrics().heightPixels;
        int r2 = r4.getHeight();
        final Ref.IntRef r3 = new Ref.IntRef();
        int r5 = r1 / 2;
        if (r2 >= r5) goto L5;
        r1 = r5;
    L5:
        r3.element = r1;
        r4.setAlpha(1.0f);
        return ViewPropertySpringAnimatorExtKt.spring(r4).translationY(0.0f, new C02121(r3));
    }

    public static final ObjectAnimator windowBottomHide(final View r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$windowBottomHide");
        Resources r0 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r0, "Resources.getSystem()");
        int r1 = r0.getDisplayMetrics().heightPixels;
        int r2 = r1 / 2;
        if (r6.getHeight() >= r2) goto L5;
        r1 = r2;
    L5:
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r6, "alpha", new float[]{1.0f, 0.0f});
        r3.setDuration(150);
        r3.setInterpolator(new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f));
        final ViewPropertySpringAnimator r4 = ViewPropertySpringAnimatorExtKt.spring(r6).translationY(r1, CommonStyleKt$windowBottomHide$spring$1.INSTANCE);
        r3.addListener(new AnonymousClass1(r6, r4));
        Intrinsics.checkNotNullExpressionValue(r3, "animator");
        return r3;
    }
}
