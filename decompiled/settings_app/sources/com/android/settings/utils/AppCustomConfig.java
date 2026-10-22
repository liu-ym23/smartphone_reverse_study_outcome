package com.android.settings.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public final class AppCustomConfig {
    public static final String ACTIVED = "actived";
    public static final String AUTHORITY_CONFIG = "com.bytedanceos.expandservice.appconfig/config";
    public static final Uri AUTHORITY_CONFIG_URI = null;
    public static final String CATEGORY = "category";
    public static final String DATA = "data";
    private static final int DEFAULT_USER_ID = 0;
    public static final String ID = "_id";
    public static final int OP_INT = 0;
    public static final int OP_STRING = 1;
    public static final String PACKAGE_NAME = "pkg";
    private static final String[] PROJECTION = null;
    private static final Integer TRUE = null;
    public static final String UID = "uid";
    public static final String UPDATE_TIME = "update_time";
    public static final String VERSION = "version";

    public AppCustomConfig() {
    }

    static {
        AUTHORITY_CONFIG_URI = Uri.parse("content://com.bytedanceos.expandservice.appconfig/config");
        PROJECTION = new String[]{"data"};
        OLog.i("AppCustomConfig", "AppCustomConfig start v2");
        TRUE = 1;
    }

    private static Uri getPackageCategory(String r2, int r3, String r4) {
        return Uri.withAppendedPath(AUTHORITY_CONFIG_URI, r2 + LibrarianImpl.Constants.SEPARATOR + r3 + LibrarianImpl.Constants.SEPARATOR + r4);
    }

    private static Uri getPackage(String r1) {
        return Uri.withAppendedPath(AUTHORITY_CONFIG_URI, r1);
    }

    private static Object getInternal(Context r7, String r8, String r9, int r10, int r11) {
        Uri r1 = getPackageCategory(r8, r10, r9);
        OLog.d("AppCustomConfig", "getInternal : " + r8 + " uri :" + r1);
        Object r12 = null;
        Cursor r13 = r7.getContentResolver().query(r1, PROJECTION, null, null, null);     // Catch: Throwable -> L30 Exception -> L32
        if (r13 != null) goto L45;
    L28:
        if (r13 == null) goto L54;
        r13.close();
        return r12;
    L54:
        return r12;
    L45:
        if (r13.moveToFirst() == false) goto L28;
        Object r14 = null;
    L43:
        String r15 = r13.getString(0);     // Catch: Exception -> L24 Throwable -> L39
        if (r11 != 0) goto L12;
        r14 = Integer.valueOf(Integer.parseInt(r15));     // Catch: Exception -> L19 Throwable -> L39
    L17:
        if (r13.moveToNext() == true) goto L43;
        r12 = r14;
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L24 Throwable -> L39
        if (r13 == null) goto L23;
        r13.close();
    L23:
        return null;
    L12:
        if (r11 != 1) goto L17;
        r14 = r15;
    L24:
        Exception e = e;
    L34:
        e.printStackTrace();     // Catch: Throwable -> L39
        if (r13 == null) goto L38;
        r13.close();
    L38:
        return r14;
    L39:
        Throwable th = th;
    L40:
        if (r13 == null) goto L42;
        r13.close();
    L42:
        throw th;
    L26:
        e = move-exception;
        r14 = null;
        e = e;
        goto L34
    L32:
        e = move-exception;
        r14 = null;
        e = e;
        r13 = null;
    L30:
        th = move-exception;
        th = th;
        r13 = null;
        goto L40
    }

    public static String getString(Context r1, String r2, int r3, String r4, String r5) {
        Object r6 = getInternal(r1, r2, r4, r3, 1);
        if (r6 != null) goto L5;
    L8:
        return r5;
    L5:
        if ((r6 instanceof String) == false) goto L8;
        return (String) r6;
    }

    public static int getInt(Context r1, String r2, int r3, String r4, int r5) {
        Object r6 = getInternal(r1, r2, r4, r3, 0);
        if (r6 != null) goto L5;
    L8:
        return r5;
    L5:
        if ((r6 instanceof Integer) == false) goto L8;
        return ((Integer) r6).intValue();
    }

    public static boolean getBoolean(Context r1, String r2, int r3, String r4, boolean r5) {
        Object r6 = getInternal(r1, r2, r4, r3, 0);
        if (r6 != null) goto L5;
    L10:
        return r5;
    L5:
        if ((r6 instanceof Integer) == false) goto L10;
        if (((Integer) r6).intValue() != TRUE.intValue()) goto L11;
        return true;
    L11:
        return false;
    }

    public static boolean setString(Context r1, String r2, int r3, String r4, String r5) {
        Object r0 = getInternal(r1, r2, r4, r3, 1);
        if (r0 == null) goto L9;
        if ((r0 instanceof String) == false) goto L9;
        return updateInternal(r1, r2, r3, r4, r5);
    L9:
        return insertInternal(r1, r2, r3, r4, r5);
    }

    public static boolean setInteger(Context r1, String r2, int r3, String r4, Integer r5) {
        Object r0 = getInternal(r1, r2, r4, r3, 0);
        if (r0 == null) goto L9;
        if ((r0 instanceof Integer) == false) goto L9;
        return updateInternal(r1, r2, r3, r4, r5);
    L9:
        return insertInternal(r1, r2, r3, r4, r5);
    }

    public static boolean setBoolean(Context r1, String r2, int r3, String r4, Boolean r5) {
        Object r0 = getInternal(r1, r2, r4, r3, 0);
        if (r0 == null) goto L9;
        if ((r0 instanceof Integer) == false) goto L9;
        return updateInternal(r1, r2, r3, r4, r5);
    L9:
        return insertInternal(r1, r2, r3, r4, r5);
    }

    public static String getString(Context r2, String r3, String r4, String r5) {
        Object r6 = getInternal(r2, r3, r4, 0, 1);
        if (r6 != null) goto L5;
    L8:
        return r5;
    L5:
        if ((r6 instanceof String) == false) goto L8;
        return (String) r6;
    }

    public static int getInt(Context r1, String r2, String r3, int r4) {
        Object r5 = getInternal(r1, r2, r3, 0, 0);
        if (r5 != null) goto L5;
    L8:
        return r4;
    L5:
        if ((r5 instanceof Integer) == false) goto L8;
        return ((Integer) r5).intValue();
    }

    public static boolean getBoolean(Context r1, String r2, String r3, boolean r4) {
        Object r5 = getInternal(r1, r2, r3, 0, 0);
        if (r5 != null) goto L5;
    L10:
        return r4;
    L5:
        if ((r5 instanceof Integer) == false) goto L10;
        if (((Integer) r5).intValue() != TRUE.intValue()) goto L11;
        return true;
    L11:
        return false;
    }

    public static boolean setString(Context r2, String r3, String r4, String r5) {
        Object r0 = getInternal(r2, r3, r4, 0, 1);
        if (r0 == null) goto L9;
        if ((r0 instanceof String) == false) goto L9;
        return updateInternal(r2, r3, 0, r4, r5);
    L9:
        return insertInternal(r2, r3, 0, r4, r5);
    }

    public static boolean setInteger(Context r2, String r3, String r4, Integer r5) {
        Object r1 = getInternal(r2, r3, r4, 0, 0);
        if (r1 == null) goto L9;
        if ((r1 instanceof Integer) == false) goto L9;
        return updateInternal(r2, r3, 0, r4, r5);
    L9:
        return insertInternal(r2, r3, 0, r4, r5);
    }

    public static boolean setBoolean(Context r2, String r3, String r4, Boolean r5) {
        Object r1 = getInternal(r2, r3, r4, 0, 0);
        if (r1 == null) goto L9;
        if ((r1 instanceof Integer) == false) goto L9;
        return updateInternal(r2, r3, 0, r4, r5);
    L9:
        return insertInternal(r2, r3, 0, r4, r5);
    }

    private static boolean updateInternal(Context r3, String r4, int r5, String r6, Object r7) {
        Uri r8 = getPackageCategory(r4, r5, r6);
        ContentValues r0 = new ContentValues();     // Catch: Exception -> L19
        if ((r7 instanceof String) == false) goto L8;
        r0.put("data", (String) r7);     // Catch: Exception -> L19
    L8:
        if ((r7 instanceof Integer) == false) goto L11;
        r0.put("data", String.valueOf(r7));     // Catch: Exception -> L19
    L11:
        if ((r7 instanceof Boolean) == true) goto L13;
    L17:
        int r9 = r3.getContentResolver().update(r8, r0, null, null);     // Catch: Exception -> L19
    L21:
        if (r9 <= 0) goto L24;
        return true;
    L24:
        return false;
    L13:
        if (((Boolean) r7).booleanValue() == false) goto L15;
        int r10 = 1;
    L16:
        r0.put("data", String.valueOf(r10));     // Catch: Exception -> L19
        goto L17
    L15:
        r10 = 0;
    L19:
        e = move-exception;
        e.printStackTrace();
        r9 = 0;
        goto L21
    }

    private static boolean insertInternal(Context r4, String r5, int r6, String r7, Object r8) {
        Uri r9 = getPackage(r5);
        ContentValues r2 = new ContentValues();     // Catch: Exception -> L19
        r2.put("category", r7);     // Catch: Exception -> L19
        r2.put("uid", Integer.valueOf(r6));     // Catch: Exception -> L19
        if ((r8 instanceof String) == false) goto L8;
        r2.put("data", (String) r8);     // Catch: Exception -> L19
    L8:
        if ((r8 instanceof Integer) == false) goto L11;
        r2.put("data", String.valueOf(r8));     // Catch: Exception -> L19
    L11:
        if ((r8 instanceof Boolean) == true) goto L13;
    L17:
        Uri r10 = r4.getContentResolver().insert(r9, r2);     // Catch: Exception -> L19
    L21:
        if (r10 == null) goto L24;
        return true;
    L24:
        return false;
    L13:
        if (((Boolean) r8).booleanValue() == false) goto L15;
        int r11 = 1;
    L16:
        r2.put("data", String.valueOf(r11));     // Catch: Exception -> L19
        goto L17
    L15:
        r11 = 0;
    L19:
        e = move-exception;
        e.printStackTrace();
        r10 = null;
        goto L21
    }
}
