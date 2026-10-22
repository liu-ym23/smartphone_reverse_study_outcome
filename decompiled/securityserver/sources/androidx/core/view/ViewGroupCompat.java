package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    private ViewGroupCompat() {
    }

    public static int getLayoutMode(@NonNull ViewGroup r0) {
        return r0.getLayoutMode();
    }

    public static int getNestedScrollAxes(@NonNull ViewGroup r0) {
        return r0.getNestedScrollAxes();
    }

    public static boolean isTransitionGroup(@NonNull ViewGroup r0) {
        return r0.isTransitionGroup();
    }

    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup r0, View r1, AccessibilityEvent r2) {
        return r0.onRequestSendAccessibilityEvent(r1, r2);
    }

    public static void setLayoutMode(@NonNull ViewGroup r0, int r1) {
        r0.setLayoutMode(r1);
    }

    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup r0, boolean r1) {
        r0.setMotionEventSplittingEnabled(r1);
    }

    public static void setTransitionGroup(@NonNull ViewGroup r0, boolean r1) {
        r0.setTransitionGroup(r1);
    }
}
