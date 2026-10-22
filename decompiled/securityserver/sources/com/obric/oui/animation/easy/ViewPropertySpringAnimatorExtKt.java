package com.obric.oui.animation.easy;

import android.view.View;
import com.bytedance.securityserver.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ViewPropertySpringAnimatorExtKt {
    public static final ViewPropertySpringAnimator a(View r3) {
        Intrinsics.f(r3, "$this$spring");
        Object r1 = r3.getTag(R.id.view_property_spring_animator_key);
        if ((r1 instanceof ViewPropertySpringAnimator) == true) goto L5;
        r1 = null;
    L5:
        ViewPropertySpringAnimator r2 = (ViewPropertySpringAnimator) r1;
        if (r2 != null) goto L9;
        ViewPropertySpringAnimator r4 = new ViewPropertySpringAnimator(r3);
        r3.setTag(R.id.view_property_spring_animator_key, r4);
        return r4;
    L9:
        return r2;
    }
}
