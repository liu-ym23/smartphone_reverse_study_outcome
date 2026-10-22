package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private final Object mInfo;

    @RequiresApi(21)
    private static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static void getBoundsInScreen(AccessibilityWindowInfo r0, Rect r1) {
            r0.getBoundsInScreen(r1);
        }

        @DoNotInline
        static AccessibilityWindowInfo getChild(AccessibilityWindowInfo r0, int r1) {
            return r0.getChild(r1);
        }

        @DoNotInline
        static int getChildCount(AccessibilityWindowInfo r0) {
            return r0.getChildCount();
        }

        @DoNotInline
        static int getId(AccessibilityWindowInfo r0) {
            return r0.getId();
        }

        @DoNotInline
        static int getLayer(AccessibilityWindowInfo r0) {
            return r0.getLayer();
        }

        @DoNotInline
        static AccessibilityWindowInfo getParent(AccessibilityWindowInfo r0) {
            return r0.getParent();
        }

        @DoNotInline
        static AccessibilityNodeInfo getRoot(AccessibilityWindowInfo r0) {
            return r0.getRoot();
        }

        @DoNotInline
        static int getType(AccessibilityWindowInfo r0) {
            return r0.getType();
        }

        @DoNotInline
        static boolean isAccessibilityFocused(AccessibilityWindowInfo r0) {
            return r0.isAccessibilityFocused();
        }

        @DoNotInline
        static boolean isActive(AccessibilityWindowInfo r0) {
            return r0.isActive();
        }

        @DoNotInline
        static boolean isFocused(AccessibilityWindowInfo r0) {
            return r0.isFocused();
        }

        @DoNotInline
        static AccessibilityWindowInfo obtain() {
            return AccessibilityWindowInfo.obtain();
        }

        @DoNotInline
        static AccessibilityWindowInfo obtain(AccessibilityWindowInfo r0) {
            return AccessibilityWindowInfo.obtain(r0);
        }

        @DoNotInline
        static void recycle(AccessibilityWindowInfo r0) {
            r0.recycle();
        }
    }

    @RequiresApi(24)
    private static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static AccessibilityNodeInfo getAnchor(AccessibilityWindowInfo r0) {
            return r0.getAnchor();
        }

        @DoNotInline
        static CharSequence getTitle(AccessibilityWindowInfo r0) {
            return r0.getTitle();
        }
    }

    @RequiresApi(33)
    private static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        static int getDisplayId(AccessibilityWindowInfo r0) {
            return r0.getDisplayId();
        }

        @DoNotInline
        static void getRegionInScreen(AccessibilityWindowInfo r0, Region r1) {
            r0.getRegionInScreen(r1);
        }

        @DoNotInline
        static boolean isInPictureInPictureMode(AccessibilityWindowInfo r0) {
            return r0.isInPictureInPictureMode();
        }
    }

    private AccessibilityWindowInfoCompat(Object r1) {
        this.mInfo = r1;
    }

    @Nullable
    public static AccessibilityWindowInfoCompat obtain() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(Api21Impl.obtain());
    }

    @Nullable
    public static AccessibilityWindowInfoCompat obtain(@Nullable AccessibilityWindowInfoCompat r3) {
        if (Build.VERSION.SDK_INT < 21) goto L8;
        if (r3 != null) goto L7;
        return null;
    L7:
        return wrapNonNullInstance(Api21Impl.obtain((AccessibilityWindowInfo) r3.mInfo));
    L8:
        return null;
    }

    private static String typeToString(int r1) {
        if (r1 != 1) goto L5;
        return "TYPE_APPLICATION";
    L5:
        if (r1 != 2) goto L7;
        return "TYPE_INPUT_METHOD";
    L7:
        if (r1 != 3) goto L9;
        return "TYPE_SYSTEM";
    L9:
        if (r1 == 4) goto L12;
        return "<UNKNOWN>";
    L12:
        return "TYPE_ACCESSIBILITY_OVERLAY";
    }

    static AccessibilityWindowInfoCompat wrapNonNullInstance(Object r1) {
        if (r1 != null) goto L4;
        return null;
    L4:
        return new AccessibilityWindowInfoCompat(r1);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L9;
        return false;
    L9:
        if ((r4 instanceof AccessibilityWindowInfoCompat) == true) goto L11;
        return false;
    L11:
        AccessibilityWindowInfoCompat r5 = (AccessibilityWindowInfoCompat) r4;
        Object r3 = this.mInfo;
        if (r3 != null) goto L19;
        if (r5.mInfo != null) goto L17;
        return true;
    L17:
        return false;
    L19:
        return r3.equals(r5.mInfo);
    }

    @Nullable
    public AccessibilityNodeInfoCompat getAnchor() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return null;
    L5:
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api24Impl.getAnchor((AccessibilityWindowInfo) this.mInfo));
    }

    public void getBoundsInScreen(@NonNull Rect r3) {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.getBoundsInScreen((AccessibilityWindowInfo) this.mInfo, r3);
        return;
    }

    @Nullable
    public AccessibilityWindowInfoCompat getChild(int r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(Api21Impl.getChild((AccessibilityWindowInfo) this.mInfo, r3));
    }

    public int getChildCount() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return 0;
    L5:
        return Api21Impl.getChildCount((AccessibilityWindowInfo) this.mInfo);
    }

    public int getDisplayId() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return 0;
    L5:
        return Api33Impl.getDisplayId((AccessibilityWindowInfo) this.mInfo);
    }

    public int getId() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return -1;
    L5:
        return Api21Impl.getId((AccessibilityWindowInfo) this.mInfo);
    }

    public int getLayer() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return -1;
    L5:
        return Api21Impl.getLayer((AccessibilityWindowInfo) this.mInfo);
    }

    @Nullable
    public AccessibilityWindowInfoCompat getParent() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(Api21Impl.getParent((AccessibilityWindowInfo) this.mInfo));
    }

    public void getRegionInScreen(@NonNull Region r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 33) goto L6;
        Api33Impl.getRegionInScreen((AccessibilityWindowInfo) this.mInfo, r3);
        return;
    L6:
        if (r0 < 21) goto L10;
        Rect r1 = new Rect();
        Api21Impl.getBoundsInScreen((AccessibilityWindowInfo) this.mInfo, r1);
        r3.set(r1);
        return;
    }

    @Nullable
    public AccessibilityNodeInfoCompat getRoot() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api21Impl.getRoot((AccessibilityWindowInfo) this.mInfo));
    }

    @Nullable
    public CharSequence getTitle() {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return null;
    L5:
        return Api24Impl.getTitle((AccessibilityWindowInfo) this.mInfo);
    }

    public int getType() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return -1;
    L5:
        return Api21Impl.getType((AccessibilityWindowInfo) this.mInfo);
    }

    public int hashCode() {
        Object r0 = this.mInfo;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public boolean isAccessibilityFocused() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return true;
    L5:
        return Api21Impl.isAccessibilityFocused((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isActive() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return true;
    L5:
        return Api21Impl.isActive((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isFocused() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return true;
    L5:
        return Api21Impl.isFocused((AccessibilityWindowInfo) this.mInfo);
    }

    public boolean isInPictureInPictureMode() {
        if (Build.VERSION.SDK_INT >= 33) goto L5;
        return false;
    L5:
        return Api33Impl.isInPictureInPictureMode((AccessibilityWindowInfo) this.mInfo);
    }

    public void recycle() {
        if (Build.VERSION.SDK_INT < 21) goto L6;
        Api21Impl.recycle((AccessibilityWindowInfo) this.mInfo);
        return;
    }

    @NonNull
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        Rect r1 = new Rect();
        getBoundsInScreen(r1);
        r0.append("AccessibilityWindowInfo[");
        r0.append("id=");
        r0.append(getId());
        r0.append(", type=");
        r0.append(typeToString(getType()));
        r0.append(", layer=");
        r0.append(getLayer());
        r0.append(", bounds=");
        r0.append(r1);
        r0.append(", focused=");
        r0.append(isFocused());
        r0.append(", active=");
        r0.append(isActive());
        r0.append(", hasParent=");
        boolean r2 = true;
        if (getParent() == null) goto L5;
        boolean r3 = true;
    L6:
        r0.append(r3);
        r0.append(", hasChildren=");
        if (getChildCount() > 0) goto L10;
        r2 = false;
    L10:
        r0.append(r2);
        r0.append(']');
        return r0.toString();
    L5:
        r3 = false;
        goto L6
    }

    @Nullable
    public AccessibilityWindowInfo unwrap() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return null;
    L5:
        return (AccessibilityWindowInfo) this.mInfo;
    }
}
