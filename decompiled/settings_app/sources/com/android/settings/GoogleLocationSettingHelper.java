package com.android.settings;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class GoogleLocationSettingHelper {
    private static final String ACTION_SET_USE_LOCATION_FOR_SERVICES = "com.google.android.gsf.action.SET_USE_LOCATION_FOR_SERVICES";
    public static final String EXTRA_DISABLE_USE_LOCATION_FOR_SERVICES = "disable";
    private static final String GOOGLE_SETTINGS_AUTHORITY = "com.google.settings";
    private static final Uri GOOGLE_SETTINGS_CONTENT_URI = null;
    private static final String NAME = "name";
    private static final String TAG = "GoogleLocationSettingHelper";
    private static final String USE_LOCATION_FOR_SERVICES = "use_location_for_services";
    public static final int USE_LOCATION_FOR_SERVICES_NOT_SET = 2;
    public static final int USE_LOCATION_FOR_SERVICES_OFF = 0;
    public static final int USE_LOCATION_FOR_SERVICES_ON = 1;
    private static final String VALUE = "value";

    public GoogleLocationSettingHelper() {
    }

    static {
        GOOGLE_SETTINGS_CONTENT_URI = Uri.parse("content://com.google.settings/partner");
    }

    public static boolean isAvailable(Context r2) {
        if (r2.getPackageManager().resolveActivity(getSetUseLocationIntent(), 65536) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static Intent getSetUseLocationIntent() {
        return new Intent(ACTION_SET_USE_LOCATION_FOR_SERVICES);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    public static int getUseLocationForServices(Context r7) {
        ?? r0 = r7.getContentResolver();
        String r8 = null;
        Cursor r1 = r0.query(GOOGLE_SETTINGS_CONTENT_URI, new String[]{"value"}, "name=?", new String[]{USE_LOCATION_FOR_SERVICES}, null);     // Catch: Throwable -> L13 RuntimeException -> L15
        if (r1 != null) goto L33;
    L11:
        if (r1 == null) goto L21;
    L12:
        r1.close();
    L21:
        if (r8 != null) goto L31;
        return 2;
    L31:
        return Integer.parseInt(r8);
    L36:
        return 2;
    L33:
    L9:
        e = e;
    L17:
        OLog.w(TAG, "Failed to get 'Use My Location' setting", e);     // Catch: Throwable -> L25
        if (r1 == null) goto L21;
    L6:
        if (r1.moveToNext() == false) goto L11;
        r8 = r1.getString(0);     // Catch: RuntimeException -> L9 Throwable -> L25
        goto L11
    L25:
        Throwable th = th;
    L26:
        if (r0 == 0) goto L28;
        r0.close();
    L28:
        throw th;
    L15:
        e = e;
        r1 = null;
    L13:
        th = move-exception;
        r0 = 0;
        th = th;
        goto L26
    }

    public static void setUseLocationForServices(Context r2, boolean r3) {
        Intent r0 = getSetUseLocationIntent();
        r0.setFlags(268435456);
        r0.putExtra("disable", !r3);
        r2.startActivity(r0);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        OLog.e(TAG, "Problem while starting GSF location activity");
    }
}
