package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private Object mInfo;

    private AccessibilityWindowInfoCompat(Object r1) {
        this.mInfo = r1;
    }

    public static AccessibilityWindowInfoCompat obtain() {
        return wrapNonNullInstance(AccessibilityWindowInfo.obtain());
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

    public static AccessibilityWindowInfoCompat wrapNonNullInstance(Object r1) {
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
        if (r3 != null) goto L17;
        if (r5.mInfo == null) goto L19;
        return false;
    L19:
        return true;
    L17:
        if (r3.equals(r5.mInfo) == true) goto L19;
        return false;
    }

    public AccessibilityNodeInfoCompat getAnchor() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo) this.mInfo).getAnchor());
    }

    public void getBoundsInScreen(Rect r1) {
        ((AccessibilityWindowInfo) this.mInfo).getBoundsInScreen(r1);
    }

    public AccessibilityWindowInfoCompat getChild(int r1) {
        return wrapNonNullInstance(((AccessibilityWindowInfo) this.mInfo).getChild(r1));
    }

    public int getChildCount() {
        return ((AccessibilityWindowInfo) this.mInfo).getChildCount();
    }

    public int getId() {
        return ((AccessibilityWindowInfo) this.mInfo).getId();
    }

    public int getLayer() {
        return ((AccessibilityWindowInfo) this.mInfo).getLayer();
    }

    public AccessibilityWindowInfoCompat getParent() {
        return wrapNonNullInstance(((AccessibilityWindowInfo) this.mInfo).getParent());
    }

    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo) this.mInfo).getRoot());
    }

    public CharSequence getTitle() {
        return ((AccessibilityWindowInfo) this.mInfo).getTitle();
    }

    public int getType() {
        return ((AccessibilityWindowInfo) this.mInfo).getType();
    }

    public int hashCode() {
        Object r0 = this.mInfo;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return ((AccessibilityWindowInfo) this.mInfo).isAccessibilityFocused();
    }

    public boolean isActive() {
        return ((AccessibilityWindowInfo) this.mInfo).isActive();
    }

    public boolean isFocused() {
        return ((AccessibilityWindowInfo) this.mInfo).isFocused();
    }

    public void recycle() {
        ((AccessibilityWindowInfo) this.mInfo).recycle();
    }

    @NonNull
    public String toString() {
        StringBuilder r0 = new StringBuilder("AccessibilityWindowInfo[id=");
        Rect r1 = new Rect();
        getBoundsInScreen(r1);
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
        boolean r2 = false;
        if (getParent() == null) goto L5;
        boolean r3 = true;
    L6:
        r0.append(r3);
        r0.append(", hasChildren=");
        if (getChildCount() <= 0) goto L9;
        r2 = true;
    L9:
        r0.append(r2);
        r0.append(']');
        return r0.toString();
    L5:
        r3 = false;
        goto L6
    }

    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat r0) {
        if (r0 != null) goto L5;
        return null;
    L5:
        return wrapNonNullInstance(AccessibilityWindowInfo.obtain((AccessibilityWindowInfo) r0.mInfo));
    }
}
