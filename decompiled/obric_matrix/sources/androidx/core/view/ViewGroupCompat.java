package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.R;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    @RequiresApi(18)
    static class Api18Impl {
        private Api18Impl() {
        }

        @DoNotInline
        static int getLayoutMode(ViewGroup r0) {
            return r0.getLayoutMode();
        }

        @DoNotInline
        static void setLayoutMode(ViewGroup r0, int r1) {
            r0.setLayoutMode(r1);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static int getNestedScrollAxes(ViewGroup r0) {
            return r0.getNestedScrollAxes();
        }

        @DoNotInline
        static boolean isTransitionGroup(ViewGroup r0) {
            return r0.isTransitionGroup();
        }

        @DoNotInline
        static void setTransitionGroup(ViewGroup r0, boolean r1) {
            r0.setTransitionGroup(r1);
        }
    }

    private ViewGroupCompat() {
    }

    public static int getLayoutMode(@NonNull ViewGroup r2) {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        return 0;
    L5:
        return Api18Impl.getLayoutMode(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getNestedScrollAxes(@NonNull ViewGroup r2) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getNestedScrollAxes(r2);
    L7:
        if ((r2 instanceof NestedScrollingParent) == true) goto L9;
        return 0;
    L9:
        return ((NestedScrollingParent) r2).getNestedScrollAxes();
    }

    public static boolean isTransitionGroup(@NonNull ViewGroup r2) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        Boolean r0 = (Boolean) r2.getTag(R.id.tag_transition_group);
        if (r0 == null) goto L11;
        if (r0.booleanValue() == false) goto L11;
    L16:
        return true;
    L11:
        if (r2.getBackground() != null) goto L16;
        if (ViewCompat.getTransitionName(r2) != null) goto L16;
        return false;
    L5:
        return Api21Impl.isTransitionGroup(r2);
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup r0, View r1, AccessibilityEvent r2) {
        return r0.onRequestSendAccessibilityEvent(r1, r2);
    }

    public static void setLayoutMode(@NonNull ViewGroup r2, int r3) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        Api18Impl.setLayoutMode(r2, r3);
        return;
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup r0, boolean r1) {
        r0.setMotionEventSplittingEnabled(r1);
    }

    public static void setTransitionGroup(@NonNull ViewGroup r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Api21Impl.setTransitionGroup(r2, r3);
        return;
    L5:
        r2.setTag(R.id.tag_transition_group, Boolean.valueOf(r3));
    }
}
