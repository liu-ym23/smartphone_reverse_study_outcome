package obric.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes5.dex */
public class DisplayHelper {
    public static final float DENSITY = 0.0f;
    private static final String TAG = "QMUIDisplayHelper";

    public DisplayHelper() {
    }

    static {
        DENSITY = Resources.getSystem().getDisplayMetrics().density;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static int dpToPx(int dpValue) {
        return (int) ((dpValue * DENSITY) + 0.5f);
    }

    public static int pxToDp(float pxValue) {
        return (int) ((pxValue / DENSITY) + 0.5f);
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static float getFontDensity(Context context) {
        return context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static int getScreenWidth(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    public static int dp2px(Context context, int dp) {
        return (int) (((double) (getDensity(context) * dp)) + 0.5d);
    }

    public static int sp2px(Context context, int sp) {
        return (int) (((double) (getFontDensity(context) * sp)) + 0.5d);
    }

    public static int px2dp(Context context, int px) {
        return (int) (((double) (px / getDensity(context))) + 0.5d);
    }

    public static int px2sp(Context context, int px) {
        return (int) (((double) (px / getFontDensity(context))) + 0.5d);
    }

    public static boolean hasStatusBar(Context context) {
        if ((context instanceof Activity) == true) goto L5;
        return true;
    L5:
        if ((((Activity) context).getWindow().getAttributes().flags & 1024) != 1024) goto L10;
        return false;
    L10:
        return true;
    }
}
