package com.bytedanceos.securitycenter.appBatteryUseOptimization;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import bytedanceos.util.LogTag;
import com.obric.security.health.score.HealthModuleIds;

/* JADX INFO: loaded from: classes2.dex */
public class AppUseBatteryOptimizationProvider extends ContentProvider {
    private static final int DIR_TYPE = 1;
    private static final int ITEM_TYPE = 2;
    private static final String TAG = "AppUseBatteryOptimizationProvider";
    private Context mContext;
    private SQLiteOpenHelper mHelper;
    private UriMatcher mUriMatcher;

    static {
    }

    public AppUseBatteryOptimizationProvider() {
        UriMatcher r0 = new UriMatcher(-1);
        this.mUriMatcher = r0;
        r0.addURI("com.bytedanceos.security.appUseBatteryOptimization", AppUseBatteryOptimizationDataHelper.TABLE_NAME, 1);
        this.mUriMatcher.addURI("com.bytedanceos.security.appUseBatteryOptimization", "appUseBatteryOptimization/#", 2);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mContext = getContext();
        this.mHelper = new AppUseBatteryOptimizationDataHelper(this.mContext);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String r9 = TAG;
        LogTag.d(r9, "query");
        Cursor r8 = this.mHelper.getReadableDatabase().query(AppUseBatteryOptimizationDataHelper.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
        LogTag.d(r9, "query 2");
        return r8;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        int r2 = this.mUriMatcher.match(uri);
        if (r2 != 1) goto L5;
        return "vnd.android.cursor.dir/vnd.com.bytedanceos.security.appUseBatteryOptimization";
    L5:
        if (r2 != 2) goto L9;
        return "vnd.android.cursor.item/vnd.com.bytedanceos.security.appUseBatteryOptimization";
    L9:
        throw new IllegalArgumentException("unknown uri:" + uri);
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] values) {
        LogTag.d(TAG, "bulkInsert");
        SQLiteDatabase r0 = this.mHelper.getWritableDatabase();
        r0.beginTransaction();
        int r1 = values.length;     // Catch: Throwable -> L12
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r1) goto L9;
        if (r0.insert(AppUseBatteryOptimizationDataHelper.TABLE_NAME, null, values[r2]) == (-1)) goto L8;
        r3 = r3 + 1;     // Catch: Throwable -> L12
    L8:
        r2 = r2 + 1;     // Catch: Throwable -> L12
        goto L4
    L9:
        r0.setTransactionSuccessful();     // Catch: Throwable -> L12
        r0.endTransaction();
        notifyChange(uri);
        LogTag.d(TAG, "bulkInsert 2");
        return r3;
    L12:
        th = move-exception;
        r0.endTransaction();
        throw th;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        String r5 = TAG;
        LogTag.d(r5, "insert");
        long r0 = this.mHelper.getWritableDatabase().insert(AppUseBatteryOptimizationDataHelper.TABLE_NAME, null, values);
        if (r0 == (-1)) goto L7;
        Uri r6 = ContentUris.withAppendedId(AppUseBatteryOptimizationDataHelper.CONTENT_ID_URI_BASE, r0);
        notifyChange(r6);
        LogTag.d(r5, "insert 2");
        return r6;
    L7:
        throw new SQLException();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        String r0 = TAG;
        LogTag.d(r0, "delete");
        SQLiteDatabase r1 = this.mHelper.getWritableDatabase();
        int r2 = this.mUriMatcher.match(uri);
        if (r2 != 1) goto L5;
        int r8 = r1.delete(AppUseBatteryOptimizationDataHelper.TABLE_NAME, selection, selectionArgs);
    L13:
        if (r8 <= 0) goto L15;
        notifyChange(uri);
    L15:
        LogTag.d(r0, "delete 2");
        return r8;
    L5:
        if (r2 == 2) goto L7;
        r8 = 0;
        goto L13
    L7:
        StringBuilder r3 = new StringBuilder("_id=").append(uri.getPathSegments().get(1));
        if (TextUtils.isEmpty(selection) == false) goto L10;
        String r9 = "";
    L11:
        r8 = r1.delete(AppUseBatteryOptimizationDataHelper.TABLE_NAME, r3.append(r9).toString(), selectionArgs);
        goto L13
    L10:
        r9 = " AND " + selection;
        goto L11
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        String r0 = TAG;
        LogTag.d(r0, HealthModuleIds.UPDATE);
        SQLiteDatabase r1 = this.mHelper.getWritableDatabase();
        int r2 = this.mUriMatcher.match(uri);
        if (r2 != 1) goto L5;
        int r8 = r1.update(AppUseBatteryOptimizationDataHelper.TABLE_NAME, values, selection, selectionArgs);
    L13:
        if (r8 <= 0) goto L15;
        notifyChange(uri);
    L15:
        LogTag.d(r0, "update 2");
        return r8;
    L5:
        if (r2 == 2) goto L7;
        r8 = 0;
        goto L13
    L7:
        StringBuilder r3 = new StringBuilder("_id=").append(uri.getPathSegments().get(1));
        if (TextUtils.isEmpty(selection) == false) goto L10;
        String r9 = "";
    L11:
        r8 = r1.update(AppUseBatteryOptimizationDataHelper.TABLE_NAME, values, r3.append(r9).toString(), selectionArgs);
        goto L13
    L10:
        r9 = " AND " + selection;
        goto L11
    }

    private void notifyChange(Uri uri) {
        this.mContext.getContentResolver().notifyChange(uri, null);
    }
}
