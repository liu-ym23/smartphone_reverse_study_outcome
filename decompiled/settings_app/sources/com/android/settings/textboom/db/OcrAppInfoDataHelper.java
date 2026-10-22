package com.android.settings.textboom.db;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.android.settings.Utils;
import com.android.settings.textboom.AppInfoDataLoader;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class OcrAppInfoDataHelper {
    public static final int APP_BOOM_DISABLE = 0;
    public static final int APP_BOOM_ENABLE = 1;
    public static final int APP_NOT_IN_DB = -1;
    public static final String PKG_CONTACTS = "com.android.contacts";
    public static final String PKG_INCALL_UI = "com.android.incallui";
    private static final String TAG = "OcrAppInfoDataHelper";

    public OcrAppInfoDataHelper() {
    }

    public static int insertAppInfo(Context r5, AppInfoDataLoader.AppInfoEntry r6) {
        OLog.d(TAG, "insertAppInfo pkg " + r6.appInfo.packageName);
        ContentValues r0 = new ContentValues();
        r0.put("package_name", r6.appInfo.packageName);
        r0.put(OcrAppInfoColumn.ItemsRecord.COLUMN_CAN_BOOM, Integer.valueOf(r6.canBoom ? 1 : 0));
        int r3 = 1;
        r0.put(OcrAppInfoColumn.ItemsRecord.COLUMN_DIRTY, 1);
        Uri r1 = r5.getContentResolver().insert(OcrAppInfoColumn.CONTENT_URI, r0);
        OLog.d(TAG, "insertAppInfo insert Uri " + r1);
        if (r1 != null) goto L7;
        r3 = -1;
    L7:
        if (TextUtils.equals(r6.appInfo.packageName, "com.android.contacts") == false) goto L9;
        insertOrUpdateInCallUi(r5, r6.canBoom);
    L9:
        return r3;
    }

    public static int updateAppInfo(Context r4, AppInfoDataLoader.AppInfoEntry r5) {
        OLog.d(TAG, "updateAppInfo pkg " + r5.appInfo.packageName);
        ContentValues r0 = new ContentValues();
        r0.put("package_name", r5.appInfo.packageName);
        r0.put(OcrAppInfoColumn.ItemsRecord.COLUMN_CAN_BOOM, Integer.valueOf(r5.canBoom ? 1 : 0));
        r0.put(OcrAppInfoColumn.ItemsRecord.COLUMN_DIRTY, 1);
        Uri r6 = OcrAppInfoColumn.CONTENT_URI.buildUpon().appendPath(r5.appInfo.packageName).build();
        OLog.d(TAG, "updateAppInfo update Uri " + r6);
        return r4.getContentResolver().update(r6, r0, null, null);
    }

    public static void insertOrUpdateInCallUi(Context r4, boolean r5) {
        int r1 = boomStatus(r4, "com.android.incallui");
        ContentValues r2 = new ContentValues();
        r2.put("package_name", "com.android.incallui");
        r2.put(OcrAppInfoColumn.ItemsRecord.COLUMN_CAN_BOOM, Integer.valueOf(r5 ? 1 : 0));
        r2.put(OcrAppInfoColumn.ItemsRecord.COLUMN_DIRTY, 1);
        OLog.d(TAG, "insertOrUpdateInCallUi boomStatus " + r1);
        if (r1 != (-1)) goto L5;
        r4.getContentResolver().insert(OcrAppInfoColumn.CONTENT_URI, r2);
        return;
    L5:
        r4.getContentResolver().update(OcrAppInfoColumn.CONTENT_URI.buildUpon().appendPath("com.android.incallui").build(), r2, null, null);
    }

    public static void updateAppInfoList(Context r6, List<AppInfoDataLoader.AppInfoEntry> r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.size() == 0) goto L21;
        OLog.d(TAG, "updateAppInfoList size " + r7.size());
        ArrayList<ContentProviderOperation> r0 = new ArrayList();
        Iterator<AppInfoDataLoader.AppInfoEntry> r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L18;
        AppInfoDataLoader.AppInfoEntry r2 = r8.next();
        OLog.d(TAG, "updateAppInfoList " + r2.appInfo.packageName + " canBoom " + r2.canBoom);
        ContentValues r3 = new ContentValues();
        r3.put("package_name", r2.appInfo.packageName);
        r3.put(OcrAppInfoColumn.ItemsRecord.COLUMN_CAN_BOOM, Integer.valueOf(r2.canBoom ? 1 : 0));
        r3.put(OcrAppInfoColumn.ItemsRecord.COLUMN_DIRTY, 1);
        r0.add(ContentProviderOperation.newUpdate(OcrAppInfoColumn.CONTENT_URI.buildUpon().appendPath(r2.appInfo.packageName).build()).withValues(r3).build());
        goto L8
    L18:
        r6.getContentResolver().applyBatch(OcrAppInfoColumn.AUTHORITY, r0);     // Catch: RemoteException -> L12 OperationApplicationException -> L14
    L16:
        Utils.sendIntentToAndroid(r6);
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public static int boomStatus(Context r8, String r9) {
        Uri r2 = OcrAppInfoColumn.CONTENT_URI.buildUpon().appendPath(r9).build();
        OLog.d(TAG, "appExist uri " + r2);
        Cursor r10 = r8.getContentResolver().query(r2, null, null, null, null);
        int r11 = -1;
        if (r10 != null) goto L22;
    L19:
        if (r10 != null) goto L15;
    L21:
        return r11;
    L15:
        r10.close();
        goto L21
    L22:
        OLog.d(TAG, "appExist result " + r10.getCount());     // Catch: Throwable -> L10 Exception -> L12
        if (r10.getCount() == 0) goto L19;
        if (r10.moveToFirst() == false) goto L19;
        r11 = r10.getInt(r10.getColumnIndex(OcrAppInfoColumn.ItemsRecord.COLUMN_CAN_BOOM));     // Catch: Throwable -> L10 Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
        if (r10 == null) goto L21;
    L10:
        th = move-exception;
        if (r10 == null) goto L18;
        r10.close();
    L18:
        throw th;
    }

    public static List<String> getAllOcrApps(Context r7) {
        Cursor r8 = r7.getContentResolver().query(OcrAppInfoColumn.CONTENT_URI, null, "can_boom = 1", null, null);
        if (r8 != null) goto L27;
        if (r8 == null) goto L6;
        r8.close();
    L6:
        return null;
    L27:
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L16 Exception -> L18
    L29:
    L14:
        Exception e = e;
    L20:
        e.printStackTrace();     // Catch: Throwable -> L16
        if (r8 != null) goto L13;
    L23:
        return r1;
    L13:
        r8.close();
        goto L23
    L9:
        if (r8.moveToNext() == false) goto L12;
        r1.add(r8.getString(r8.getColumnIndex("package_name")));     // Catch: Exception -> L14 Throwable -> L16
        goto L29
    L12:
        if (r8 == null) goto L23;
    L18:
        e = move-exception;
        r1 = null;
        e = e;
    L16:
        th = move-exception;
        if (r8 == null) goto L26;
        r8.close();
    L26:
        throw th;
    }
}
