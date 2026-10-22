package androidx.core.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.PackageManager;
import com.bytedance.networkstackapplib.NetworkStackConstant;

/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityServiceInfoCompat {
    public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final int FEEDBACK_ALL_MASK = -1;
    public static final int FEEDBACK_BRAILLE = 32;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;

    public static String capabilityToString(int r1) {
        if (r1 != 1) goto L5;
        return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
    L5:
        if (r1 != 2) goto L7;
        return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
    L7:
        if (r1 != 4) goto L9;
        return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
    L9:
        if (r1 == 8) goto L12;
        return NetworkStackConstant.UNKNOWN_TYPE;
    L12:
        return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
    }

    public static String flagToString(int r1) {
        if (r1 != 1) goto L5;
        return "DEFAULT";
    L5:
        if (r1 != 2) goto L7;
        return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
    L7:
        if (r1 != 4) goto L9;
        return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
    L9:
        if (r1 != 8) goto L11;
        return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
    L11:
        if (r1 != 16) goto L13;
        return "FLAG_REPORT_VIEW_IDS";
    L13:
        if (r1 == 32) goto L16;
        return null;
    L16:
        return "FLAG_REQUEST_FILTER_KEY_EVENTS";
    }

    private AccessibilityServiceInfoCompat() {
    }

    public static String loadDescription(AccessibilityServiceInfo r0, PackageManager r1) {
        return r0.loadDescription(r1);
    }

    public static String feedbackTypeToString(int r4) {
        StringBuilder r0 = new StringBuilder();
        r0.append("[");
    L3:
        if (r4 <= 0) goto L22;
        int r1 = 1 << Integer.numberOfTrailingZeros(r4);
        r4 = r4 & (~r1);
        if (r0.length() <= 1) goto L7;
        r0.append(", ");
    L7:
        if (r1 != 1) goto L9;
        r0.append("FEEDBACK_SPOKEN");
        goto L3
    L9:
        if (r1 != 2) goto L11;
        r0.append("FEEDBACK_HAPTIC");
        goto L3
    L11:
        if (r1 != 4) goto L13;
        r0.append("FEEDBACK_AUDIBLE");
        goto L3
    L13:
        if (r1 != 8) goto L15;
        r0.append("FEEDBACK_VISUAL");
        goto L3
    L15:
        if (r1 != 16) goto L3;
        r0.append("FEEDBACK_GENERIC");
        goto L3
    L22:
        r0.append("]");
        return r0.toString();
    }

    public static int getCapabilities(AccessibilityServiceInfo r0) {
        return r0.getCapabilities();
    }
}
