package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityEventCompat {
    public static final int CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION = 4;
    public static final int CONTENT_CHANGE_TYPE_DRAG_CANCELLED = 512;
    public static final int CONTENT_CHANGE_TYPE_DRAG_DROPPED = 256;
    public static final int CONTENT_CHANGE_TYPE_DRAG_STARTED = 128;
    public static final int CONTENT_CHANGE_TYPE_PANE_APPEARED = 16;
    public static final int CONTENT_CHANGE_TYPE_PANE_DISAPPEARED = 32;
    public static final int CONTENT_CHANGE_TYPE_PANE_TITLE = 8;
    public static final int CONTENT_CHANGE_TYPE_STATE_DESCRIPTION = 64;
    public static final int CONTENT_CHANGE_TYPE_SUBTREE = 1;
    public static final int CONTENT_CHANGE_TYPE_TEXT = 2;
    public static final int CONTENT_CHANGE_TYPE_UNDEFINED = 0;
    public static final int TYPES_ALL_MASK = -1;
    public static final int TYPE_ANNOUNCEMENT = 16384;
    public static final int TYPE_ASSIST_READING_CONTEXT = 16777216;
    public static final int TYPE_GESTURE_DETECTION_END = 524288;
    public static final int TYPE_GESTURE_DETECTION_START = 262144;

    @Deprecated
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;

    @Deprecated
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
    public static final int TYPE_TOUCH_INTERACTION_END = 2097152;
    public static final int TYPE_TOUCH_INTERACTION_START = 1048576;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
    public static final int TYPE_VIEW_CONTEXT_CLICKED = 8388608;

    @Deprecated
    public static final int TYPE_VIEW_HOVER_ENTER = 128;

    @Deprecated
    public static final int TYPE_VIEW_HOVER_EXIT = 256;

    @Deprecated
    public static final int TYPE_VIEW_SCROLLED = 4096;

    @Deprecated
    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
    public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
    public static final int TYPE_WINDOWS_CHANGED = 4194304;

    @Deprecated
    public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static int getAction(AccessibilityEvent r0) {
            return r0.getAction();
        }

        @DoNotInline
        static int getMovementGranularity(AccessibilityEvent r0) {
            return r0.getMovementGranularity();
        }

        @DoNotInline
        static void setAction(AccessibilityEvent r0, int r1) {
            r0.setAction(r1);
        }

        @DoNotInline
        static void setMovementGranularity(AccessibilityEvent r0, int r1) {
            r0.setMovementGranularity(r1);
        }
    }

    @RequiresApi(19)
    static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        static int getContentChangeTypes(AccessibilityEvent r0) {
            return r0.getContentChangeTypes();
        }

        @DoNotInline
        static void setContentChangeTypes(AccessibilityEvent r0, int r1) {
            r0.setContentChangeTypes(r1);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface ContentChangeType {
    }

    private AccessibilityEventCompat() {
    }

    @Deprecated
    public static void appendRecord(AccessibilityEvent r0, AccessibilityRecordCompat r1) {
        r0.appendRecord((AccessibilityRecord) r1.getImpl());
    }

    @Deprecated
    public static AccessibilityRecordCompat asRecord(AccessibilityEvent r1) {
        return new AccessibilityRecordCompat(r1);
    }

    public static int getAction(@NonNull AccessibilityEvent r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return 0;
    L5:
        return Api16Impl.getAction(r2);
    }

    public static int getContentChangeTypes(@NonNull AccessibilityEvent r2) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return 0;
    L5:
        return Api19Impl.getContentChangeTypes(r2);
    }

    public static int getMovementGranularity(@NonNull AccessibilityEvent r2) {
        if (Build.VERSION.SDK_INT >= 16) goto L5;
        return 0;
    L5:
        return Api16Impl.getMovementGranularity(r2);
    }

    @Deprecated
    public static AccessibilityRecordCompat getRecord(AccessibilityEvent r1, int r2) {
        return new AccessibilityRecordCompat(r1.getRecord(r2));
    }

    @Deprecated
    public static int getRecordCount(AccessibilityEvent r0) {
        return r0.getRecordCount();
    }

    public static void setAction(@NonNull AccessibilityEvent r2, int r3) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        Api16Impl.setAction(r2, r3);
        return;
    }

    public static void setContentChangeTypes(@NonNull AccessibilityEvent r2, int r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        Api19Impl.setContentChangeTypes(r2, r3);
        return;
    }

    public static void setMovementGranularity(@NonNull AccessibilityEvent r2, int r3) {
        if (Build.VERSION.SDK_INT < 16) goto L6;
        Api16Impl.setMovementGranularity(r2, r3);
        return;
    }
}
