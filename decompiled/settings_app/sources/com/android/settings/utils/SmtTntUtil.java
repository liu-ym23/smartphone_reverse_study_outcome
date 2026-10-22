package com.android.settings.utils;

import android.app.SmtPCUtils;
import android.content.Context;
import android.content.Intent;
import android.media.MediaRouter;

/* JADX INFO: loaded from: classes2.dex */
public class SmtTntUtil {
    private static final String ACTION_PERMISSION = "com.bytedanceos.boston.permission.SETTING";
    private static final String ACTION_REBOOT_TNT = "com.bytedanceos.boston.action.REBOOT_TNT";
    private static final String ACTION_SHUTDOWN_TNT = "com.bytedanceos.boston.action.SHUTDOWN_TNT";
    private static final String KEY_DISPLAY_TYPE = "displayType";
    public static final int SMT_MODE_NONE = 0;
    public static final int SMT_MODE_VIRTUAL = 2;
    public static final int SMT_MODE_WIRED = 1;
    private static final String TARGET_PKG_NAME = "com.bytedanceos.boston.phone";
    private static final String VALUE_WIRED = "wired";
    private static final String VALUE_WIRELESS = "wifi";

    public SmtTntUtil() {
    }

    public static void gotoPowerOffTNT(Context r3) {
        int r0 = isSmtDisplayMode(r3);
        if (r0 != 0) goto L5;
        return;
    L5:
        Intent r1 = new Intent(ACTION_SHUTDOWN_TNT);
        r1.setPackage("com.bytedanceos.boston.phone");
        if (1 != r0) goto L8;
        String r2 = VALUE_WIRED;
    L9:
        r1.putExtra(KEY_DISPLAY_TYPE, r2);
        r3.sendBroadcast(r1, ACTION_PERMISSION);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        r2 = "wifi";
        goto L9
    }

    public static void gotoRebootTNT(Context r3) {
        int r0 = isSmtDisplayMode(r3);
        if (r0 != 0) goto L5;
        return;
    L5:
        Intent r1 = new Intent(ACTION_REBOOT_TNT);
        r1.setPackage("com.bytedanceos.boston.phone");
        if (1 != r0) goto L8;
        String r2 = VALUE_WIRED;
    L9:
        r1.putExtra(KEY_DISPLAY_TYPE, r2);
        r3.sendBroadcast(r1, ACTION_PERMISSION);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        r2 = "wifi";
        goto L9
    }

    public static int isSmtDisplayMode(Context r1) {
        Context r2 = SmtPCUtils.getDisplayContext(r1, SmtPCUtils.getExtDisplayId());
        if (r2 != null) goto L5;
        return 0;
    L5:
        if (r2.getDisplay().getType() != com.android.settings.DisplayUtils.type) goto L7;
        return 1;
    L7:
        return 2;
    }

    public static boolean isSmtDisplayVirtualMode(Context r2) {
        Context r3 = SmtPCUtils.getDisplayContext(r2, SmtPCUtils.getExtDisplayId());
        if (r3 == null) goto L10;
        int r4 = r3.getDisplay().getType();
        if (r4 != 3) goto L7;
    L8:
        return true;
    L7:
        if (r4 == 5) goto L8;
        return false;
    L10:
        return false;
    }

    public static boolean isMiracastWirelessConnect(Context r6) {
        Context r0 = SmtPCUtils.getDisplayContext(r6, SmtPCUtils.getExtDisplayId());
        if (r0 != null) goto L5;
    L18:
        return false;
    L5:
        if (r0.getDisplay().getType() != 3) goto L18;
        String r1 = r0.getDisplay().getName();
        MediaRouter r7 = (MediaRouter) r6.getSystemService("media_router");
        int r2 = r7.getRouteCount();
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L18;
        MediaRouter.RouteInfo r4 = r7.getRouteAt(r3);
        if (r4.matchesTypes(4) == false) goto L17;
        if (r1 == null) goto L17;
        if (r1.equals(r4.getName()) == false) goto L17;
        if (r4.getStatusCode() != 6) goto L24;
        return true;
    L24:
        return false;
    L17:
        r3 = r3 + 1;
        goto L7
    }

    public static boolean isSmtDisplayMiracastMode(Context r2) {
        Context r3 = SmtPCUtils.getDisplayContext(r2, SmtPCUtils.getExtDisplayId());
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.getDisplay().getType() != 3) goto L9;
        return true;
    L9:
        return false;
    }
}
