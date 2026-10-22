package com.android.settings.revone;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import com.android.settings.Constants;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class StylusKeyOperation {
    public static final int OPERATION_COUNT_DOUBLE_CLICK = 6;
    public static final int OPERATION_COUNT_LONG_CLICK = 8;
    public static final int OPERATION_COUNT_SINGLE_CLICK = 6;
    public static final String[] OPERATION_KEY = null;
    public static final int[] OPERATION_NAME = null;

    public StylusKeyOperation() {
    }

    static {
        OPERATION_KEY = new String[]{Constants.STYLUS_KEY_NONE, Constants.STYLUS_KEY_NEW_NOTE, Constants.STYLUS_KEY_LAUNCH_WHITEBOARD, Constants.STYLUS_KEY_SCREENSHOT_COPY, Constants.STYLUS_KEY_LAUNCH_SPECIFIED_APP, Constants.STYLUS_KEY_PRESENTATION_PAGE, Constants.STYLUS_KEY_IDEA_PILLS_BETA, Constants.STYLUS_KEY_ACTIVATE_VOICE_INPUT};
        OPERATION_NAME = new int[]{R.string.stylus_none, R.string.new_a_note, R.string.launch_white_board, R.string.screenshot_copy, R.string.launch_specified_app, R.string.presentation_next_page, R.string.idea_pills_voice_input, R.string.text_voice_input};
    }

    public static void setStylusOperation(Context r1, String r2, int r3) {
        Settings.Global.putString(r1.getContentResolver(), r2, OPERATION_KEY[r3]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public static String getOperationByType(Context r4, StylusClickType r5) {
        String r0 = Settings.Global.getString(r4.getContentResolver(), r5.getSettingsId());
        int r2 = 0;
        if (Constants.STYLUS_KEY_LAUNCH_SPECIFIED_APP.equals(r0) == true) goto L22;
        int r6 = 0;
    L13:
        String[] r1 = OPERATION_KEY;
        if (r2 >= r1.length) goto L27;
        if (TextUtils.equals(r1[r2], r0) == false) goto L18;
        r6 = r2;
    L18:
        r2 = r2 + 1;
        goto L13
    L27:
        return r4.getString(OPERATION_NAME[r6]);
    L22:
        ApplicationInfo r7 = r4.getPackageManager().getApplicationInfo(r5.getSpecifiedApp(r4), 0);     // Catch: PackageManager.NameNotFoundException -> L10
        if (r7 == null) goto L8;
        r4 = r4.getString(R.string.open_app) + r7.loadLabel(r4.getPackageManager()).toString();     // Catch: PackageManager.NameNotFoundException -> L10
    L21:
        return r4;
    L8:
        r4 = r4.getString(R.string.app_not_install);     // Catch: PackageManager.NameNotFoundException -> L10
    L10:
        e = move-exception;
        String r8 = r4.getString(R.string.app_not_install);
        e.printStackTrace();
        return r8;
    }

    public static int getCurrentIndex(String r4) {
        int r0 = 0;
        int r1 = 0;
    L3:
        String[] r2 = OPERATION_KEY;
        if (r0 >= r2.length) goto L9;
        if (TextUtils.equals(r4, r2[r0]) == false) goto L8;
        r1 = r0;
    L8:
        r0 = r0 + 1;
        goto L3
    L9:
        return r1;
    }
}
