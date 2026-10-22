package com.obric.common.oea.foundation.animation.easy;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.obric.common.oea.foundation.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewPropertySpringAnimatorExt.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"spring", "Lcom/obric/common/oea/foundation/animation/easy/ViewPropertySpringAnimator;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "(Landroid/view/View;)Lcom/obric/common/oea/foundation/animation/easy/ViewPropertySpringAnimator;", "foundation_standardRelease"}, k = 2, mv = {1, 4, 3})
public final class ViewPropertySpringAnimatorExtKt {
    public static final <T extends View> ViewPropertySpringAnimator<T> spring(T r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$spring");
        Object r0 = r2.getTag(R.id.view_property_spring_animator_key);
        if ((r0 instanceof ViewPropertySpringAnimator) == true) goto L5;
        r0 = null;
    L5:
        ViewPropertySpringAnimator<T> r1 = (ViewPropertySpringAnimator) r0;
        if (r1 != null) goto L9;
        ViewPropertySpringAnimator<T> r3 = new ViewPropertySpringAnimator(r2);
        r2.setTag(R.id.view_property_spring_animator_key, r3);
        return r3;
    L9:
        return r1;
    }
}
