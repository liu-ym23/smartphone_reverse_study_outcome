package com.android.settings.applications.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: OButtonUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/android/settings/applications/utils/OButtonUtils;", "", "()V", "createIconActionView", "Landroid/view/View;", "context", "Landroid/content/Context;", "iconRes", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OButtonUtils {
    public static final OButtonUtils INSTANCE = null;

    static {
        INSTANCE = new OButtonUtils();
    }

    private OButtonUtils() {
    }

    public final View createIconActionView(Context r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        OUIFrameLayout r7 = new OUIFrameLayout(r8, null, 0, null, 14, null);
        r7.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        float r0 = 7;
        r7.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics())));
        r7.setClickable(true);
        r7.setRadius(MathKt.roundToInt(TypedValue.applyDimension(1, 99, Resources.getSystem().getDisplayMetrics())));
        ImageView r1 = new ImageView(r8);
        r1.setImageResource(r9);
        float r10 = 22;
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, r10, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, r10, Resources.getSystem().getDisplayMetrics())));
        r11.gravity = 17;
        Unit r12 = Unit.INSTANCE;
        r7.addView(r1, r11);
        return r7;
    }
}
