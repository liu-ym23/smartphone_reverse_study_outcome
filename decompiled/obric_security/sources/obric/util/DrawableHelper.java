package obric.util;

import android.graphics.drawable.GradientDrawable;

/* JADX INFO: loaded from: classes5.dex */
public class DrawableHelper {
    public DrawableHelper() {
    }

    public static GradientDrawable createColorWithCornerRadiusDrawable(int color, float topLeftRadius, float topRightRadius, float bottomLeftRadius, float bottomRightRadius) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setColor(color);
        r0.setCornerRadii(new float[]{topLeftRadius, topLeftRadius, topRightRadius, topRightRadius, bottomLeftRadius, bottomLeftRadius, bottomRightRadius, bottomRightRadius});
        return r0;
    }
}
