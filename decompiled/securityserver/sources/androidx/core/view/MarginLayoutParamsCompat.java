package androidx.core.view;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class MarginLayoutParamsCompat {
    private MarginLayoutParamsCompat() {
    }

    public static int getLayoutDirection(ViewGroup.MarginLayoutParams r1) {
        int r2 = r1.getLayoutDirection();
        if (r2 != 0) goto L5;
        return r2;
    L5:
        if (r2 == 1) goto L9;
        return 0;
    L9:
        return r2;
    }

    public static int getMarginEnd(ViewGroup.MarginLayoutParams r0) {
        return r0.getMarginEnd();
    }

    public static int getMarginStart(ViewGroup.MarginLayoutParams r0) {
        return r0.getMarginStart();
    }

    public static boolean isMarginRelative(ViewGroup.MarginLayoutParams r0) {
        return r0.isMarginRelative();
    }

    public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams r0, int r1) {
        r0.resolveLayoutDirection(r1);
    }

    public static void setLayoutDirection(ViewGroup.MarginLayoutParams r0, int r1) {
        r0.setLayoutDirection(r1);
    }

    public static void setMarginEnd(ViewGroup.MarginLayoutParams r0, int r1) {
        r0.setMarginEnd(r1);
    }

    public static void setMarginStart(ViewGroup.MarginLayoutParams r0, int r1) {
        r0.setMarginStart(r1);
    }
}
