package androidx.core.view;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class MarginLayoutParamsCompat {

    static class Api17Impl {
        private Api17Impl() {
        }

        static int getMarginStart(ViewGroup.MarginLayoutParams r0) {
            return r0.getMarginStart();
        }

        static int getMarginEnd(ViewGroup.MarginLayoutParams r0) {
            return r0.getMarginEnd();
        }

        static void setMarginStart(ViewGroup.MarginLayoutParams r0, int r1) {
            r0.setMarginStart(r1);
        }

        static void setMarginEnd(ViewGroup.MarginLayoutParams r0, int r1) {
            r0.setMarginEnd(r1);
        }

        static boolean isMarginRelative(ViewGroup.MarginLayoutParams r0) {
            return r0.isMarginRelative();
        }

        static int getLayoutDirection(ViewGroup.MarginLayoutParams r0) {
            return r0.getLayoutDirection();
        }

        static void setLayoutDirection(ViewGroup.MarginLayoutParams r0, int r1) {
            r0.setLayoutDirection(r1);
        }

        static void resolveLayoutDirection(ViewGroup.MarginLayoutParams r0, int r1) {
            r0.resolveLayoutDirection(r1);
        }
    }

    public static int getMarginStart(ViewGroup.MarginLayoutParams r0) {
        return Api17Impl.getMarginStart(r0);
    }

    public static int getMarginEnd(ViewGroup.MarginLayoutParams r0) {
        return Api17Impl.getMarginEnd(r0);
    }

    public static void setMarginStart(ViewGroup.MarginLayoutParams r0, int r1) {
        Api17Impl.setMarginStart(r0, r1);
    }

    public static void setMarginEnd(ViewGroup.MarginLayoutParams r0, int r1) {
        Api17Impl.setMarginEnd(r0, r1);
    }

    public static boolean isMarginRelative(ViewGroup.MarginLayoutParams r0) {
        return Api17Impl.isMarginRelative(r0);
    }

    public static int getLayoutDirection(ViewGroup.MarginLayoutParams r1) {
        int r2 = Api17Impl.getLayoutDirection(r1);
        if (r2 != 0) goto L5;
        return r2;
    L5:
        if (r2 == 1) goto L9;
        return 0;
    L9:
        return r2;
    }

    public static void setLayoutDirection(ViewGroup.MarginLayoutParams r0, int r1) {
        Api17Impl.setLayoutDirection(r0, r1);
    }

    public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams r0, int r1) {
        Api17Impl.resolveLayoutDirection(r0, r1);
    }

    private MarginLayoutParamsCompat() {
    }
}
