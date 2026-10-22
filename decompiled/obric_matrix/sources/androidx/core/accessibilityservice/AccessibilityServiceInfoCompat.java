package androidx.core.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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

    private AccessibilityServiceInfoCompat() {
    }

    @NonNull
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
        return "UNKNOWN";
    L12:
        return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
    }

    @NonNull
    public static String feedbackTypeToString(int r4) {
        StringBuilder r0 = new StringBuilder();
        String r1 = "[";
    L3:
        r0.append(r1);
    L4:
        if (r4 <= 0) goto L23;
        int r2 = 1 << Integer.numberOfTrailingZeros(r4);
        r4 = r4 & (~r2);
        if (r0.length() <= 1) goto L8;
        r0.append(", ");
    L8:
        if (r2 == 1) goto L22;
        if (r2 == 2) goto L21;
        if (r2 == 4) goto L20;
        if (r2 == 8) goto L19;
        if (r2 != 16) goto L4;
        r1 = "FEEDBACK_GENERIC";
        goto L3
    L19:
        r1 = "FEEDBACK_VISUAL";
        goto L3
    L20:
        r1 = "FEEDBACK_AUDIBLE";
        goto L3
    L21:
        r1 = "FEEDBACK_HAPTIC";
        goto L3
    L22:
        r1 = "FEEDBACK_SPOKEN";
        goto L3
    L23:
        r0.append("]");
        return r0.toString();
    }

    @Nullable
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

    public static int getCapabilities(@NonNull AccessibilityServiceInfo r2) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return r2.getCapabilities();
    L7:
        if (r2.getCanRetrieveWindowContent() == false) goto L10;
        return 1;
    L10:
        return 0;
    }

    @Nullable
    public static String loadDescription(@NonNull AccessibilityServiceInfo r2, @NonNull PackageManager r3) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return r2.loadDescription(r3);
    L7:
        return r2.getDescription();
    }
}
