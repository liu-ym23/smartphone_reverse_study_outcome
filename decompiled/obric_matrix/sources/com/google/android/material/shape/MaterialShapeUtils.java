package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialShapeUtils {
    private MaterialShapeUtils() {
    }

    @NonNull
    static CornerTreatment createCornerTreatment(int r1) {
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L8;
        return createDefaultCornerTreatment();
    L8:
        return new CutCornerTreatment();
    L10:
        return new RoundedCornerTreatment();
    }

    @NonNull
    static CornerTreatment createDefaultCornerTreatment() {
        return new RoundedCornerTreatment();
    }

    @NonNull
    static EdgeTreatment createDefaultEdgeTreatment() {
        return new EdgeTreatment();
    }

    public static void setElevation(@NonNull View r1, float r2) {
        Drawable r3 = r1.getBackground();
        if ((r3 instanceof MaterialShapeDrawable) == false) goto L6;
        ((MaterialShapeDrawable) r3).setElevation(r2);
        return;
    }

    public static void setParentAbsoluteElevation(@NonNull View r2) {
        Drawable r0 = r2.getBackground();
        if ((r0 instanceof MaterialShapeDrawable) == false) goto L6;
        setParentAbsoluteElevation(r2, (MaterialShapeDrawable) r0);
        return;
    }

    public static void setParentAbsoluteElevation(@NonNull View r1, @NonNull MaterialShapeDrawable r2) {
        if (r2.isElevationOverlayEnabled() == false) goto L6;
        r2.setParentAbsoluteElevation(ViewUtils.getParentAbsoluteElevation(r1));
        return;
    }
}
