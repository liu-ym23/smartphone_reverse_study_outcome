package com.bytedanceos.security.invokeHistory;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteDiskIOException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteReadOnlyDatabaseException;
import android.net.Uri;
import android.os.Binder;
import android.os.Process;
import bytedanceos.util.LogTag;
import com.obric.security.health.score.HealthModuleIds;

/* JADX INFO: loaded from: classes2.dex */
public class InvokeHistoryProvider extends ContentProvider {
    private static final int INVOKE_HISTORY = 0;
    private static final String INVOKE_PREFERENCES_NAME = "invoke_preferences";
    private static final int MAX_ROW_COUNT = 200000;
    private static final String TAG = "InvokeHistoryProvider";
    private Context mContext;
    private SQLiteOpenHelper mHelper;
    private boolean mInUse;
    private Object mLockObj;
    private UriMatcher mUriMatcher;

    static {
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    static /* synthetic */ Context access$000(InvokeHistoryProvider r0) {
        return r0.mContext;
    }

    static /* synthetic */ SQLiteOpenHelper access$100(InvokeHistoryProvider r0) {
        return r0.mHelper;
    }

    public InvokeHistoryProvider() {
        this.mLockObj = new Object();
        UriMatcher r0 = new UriMatcher(-1);
        this.mUriMatcher = r0;
        r0.addURI("com.bytedanceos.security.invokeHistory", InvokeHistoryDataHelp.TABLE_NAME, 0);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mContext = getContext();
        this.mHelper = new InvokeHistoryDataHelp(this.mContext);
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String r0 = TAG;     // Catch: Throwable -> L20 Exception -> L22
        LogTag.d(r0, "query");     // Catch: Throwable -> L20 Exception -> L22
        Object r1 = this.mLockObj;     // Catch: Throwable -> L20 Exception -> L22
        monitor-enter(r1);     // Catch: Throwable -> L20 Exception -> L22
        this.mInUse = true;     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        Cursor r12 = this.mHelper.getReadableDatabase().query(InvokeHistoryDataHelp.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);     // Catch: Throwable -> L20 Exception -> L22
        LogTag.d(r0, "query 2");
        Object r13 = this.mLockObj;
        monitor-enter(r13);
        this.mInUse = false;     // Catch: Throwable -> L14
        monitor-exit(r13);     // Catch: Throwable -> L14
        return r12;
    L14:
        th = move-exception;
        throw th;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20 Exception -> L22
    L20:
        th = move-exception;
        LogTag.d(TAG, "query 2");
        monitor-enter(this.mLockObj);
        this.mInUse = false;     // Catch: Throwable -> L38
        throw th;
    L38:
        th = move-exception;
        throw th;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
        LogTag.d(TAG, "query 2");
        monitor-enter(this.mLockObj);
        this.mInUse = false;     // Catch: Throwable -> L30
        return null;
    L30:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] values) {
        LogTag.d(TAG, "bulkInsert");
        int r1 = 0;
        SQLiteDatabase r2 = this.mHelper.getWritableDatabase();     // Catch: Throwable -> L25 Exception -> L27
        r2.beginTransaction();     // Catch: Throwable -> L25 Exception -> L27
        int r3 = values.length;     // Catch: Throwable -> L25 Exception -> L27
        int r4 = 0;
    L5:
        if (r1 >= r3) goto L10;
    L23:
        e = e;
        r1 = r4;
    L28:
        e.printStackTrace();     // Catch: Throwable -> L25
        Object r10 = this.mLockObj;
        monitor-enter(r10);
    L40:
        th = move-exception;
        throw th;
    L32:
        if (this.mInUse == false) goto L34;
    L36:
        monitor-exit(r10);     // Catch: Throwable -> L40
        r4 = r1;
    L38:
        LogTag.d(TAG, "bulkInsert 2");
        return r4;
    L34:
        if (Binder.getCallingUid() != 1000) goto L36;
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L40
        goto L36
    L7:
        if (r2.insert(InvokeHistoryDataHelp.TABLE_NAME, null, values[r1]) == (-1)) goto L9;
        r4 = r4 + 1;     // Catch: Exception -> L23 Throwable -> L25
    L9:
        r1 = r1 + 1;     // Catch: Exception -> L23 Throwable -> L25
        goto L5
    L10:
        r2.setTransactionSuccessful();     // Catch: Exception -> L23 Throwable -> L25
        r2.endTransaction();     // Catch: Exception -> L23 Throwable -> L25
        notifyChange(uri);     // Catch: Exception -> L23 Throwable -> L25
        deleteOldData();     // Catch: Exception -> L23 Throwable -> L25
        Object r11 = this.mLockObj;
        monitor-enter(r11);
    L20:
        th = move-exception;
        throw th;
    L14:
        if (this.mInUse == false) goto L16;
    L18:
        monitor-exit(r11);     // Catch: Throwable -> L20
        goto L38
    L16:
        if (Binder.getCallingUid() != 1000) goto L18;
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L20
    L25:
        th = move-exception;
        monitor-enter(this.mLockObj);
    L52:
        th = move-exception;
        throw th;
    L46:
        if (this.mInUse == false) goto L48;
    L50:
        throw th;
    L48:
        if (Binder.getCallingUid() != 1000) goto L50;
        Process.killProcess(Process.myPid());     // Catch: Throwable -> L52
    L27:
        e = e;
        goto L28
    }

    private void deleteOldData() {
        new Thread(new AnonymousClass1(this), "InvokeHistoryProvider-deleteOldData").start();
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        String r0 = TAG;
        LogTag.d(r0, "insert");
        long r2 = this.mHelper.getWritableDatabase().insert(InvokeHistoryDataHelp.TABLE_NAME, null, values);     // Catch: Throwable -> L10 SQLiteException -> L12 SQLiteDiskIOException -> L16 SQLiteDatabaseLockedException -> L18 SQLiteCantOpenDatabaseException -> L20 SQLiteReadOnlyDatabaseException -> L22
        if (r2 == (-1)) goto L9;
        Uri r8 = ContentUris.withAppendedId(InvokeHistoryDataHelp.CONTENT_ID_URI_BASE, r2);     // Catch: Throwable -> L10 SQLiteException -> L12 SQLiteDiskIOException -> L16 SQLiteDatabaseLockedException -> L18 SQLiteCantOpenDatabaseException -> L20 SQLiteReadOnlyDatabaseException -> L22
        notifyChange(r8);     // Catch: Throwable -> L10 SQLiteException -> L12 SQLiteDiskIOException -> L16 SQLiteDatabaseLockedException -> L18 SQLiteCantOpenDatabaseException -> L20 SQLiteReadOnlyDatabaseException -> L22
        LogTag.d(r0, "insert 2");
        return r8;
    L9:
        throw new SQLException();     // Catch: Throwable -> L10 SQLiteException -> L12 SQLiteDiskIOException -> L16 SQLiteDatabaseLockedException -> L18 SQLiteCantOpenDatabaseException -> L20 SQLiteReadOnlyDatabaseException -> L22
    L10:
        th = move-exception;
        LogTag.d(TAG, "insert 2");
        throw th;
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
    L14:
        LogTag.d(TAG, "insert 2");
        return null;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
        deleteDBFile();     // Catch: Throwable -> L10
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
        deleteDBFile();     // Catch: Throwable -> L10
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
        deleteDBFile();     // Catch: Throwable -> L10
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
        goto L14
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        String r1 = TAG;
        LogTag.d(r1, "delete");
        SQLiteDatabase r3 = this.mHelper.getWritableDatabase();     // Catch: Throwable -> L11 SQLiteException -> L13 SQLiteDiskIOException -> L17 SQLiteBlobTooBigException -> L19 SQLiteDatabaseLockedException -> L21 SQLiteCantOpenDatabaseException -> L23 SQLiteReadOnlyDatabaseException -> L25
        if (this.mUriMatcher.match(uri) == 0) goto L6;
        int r7 = 0;
    L7:
        if (r7 <= 0) goto L9;
        notifyChange(uri);     // Catch: Throwable -> L11 SQLiteException -> L13 SQLiteDiskIOException -> L17 SQLiteBlobTooBigException -> L19 SQLiteDatabaseLockedException -> L21 SQLiteCantOpenDatabaseException -> L23 SQLiteReadOnlyDatabaseException -> L25
    L9:
        LogTag.d(r1, "delete 2");
        return r7;
    L6:
        r7 = r3.delete(InvokeHistoryDataHelp.TABLE_NAME, selection, selectionArgs);     // Catch: Throwable -> L11 SQLiteException -> L13 SQLiteDiskIOException -> L17 SQLiteBlobTooBigException -> L19 SQLiteDatabaseLockedException -> L21 SQLiteCantOpenDatabaseException -> L23 SQLiteReadOnlyDatabaseException -> L25
    L11:
        th = move-exception;
        LogTag.d(TAG, "delete 2");
        throw th;
    L23:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
    L15:
        LogTag.d(TAG, "delete 2");
        return -1;
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        deleteDBFile();     // Catch: Throwable -> L11
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        deleteDBFile();     // Catch: Throwable -> L11
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        deleteDBFile();     // Catch: Throwable -> L11
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        deleteDBFile();     // Catch: Throwable -> L11
    L25:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        goto L15
    }

    private void deleteDBFile() {
        this.mContext.deleteDatabase("invoke_history.db");
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        String r0 = TAG;
        LogTag.d(r0, HealthModuleIds.UPDATE);
        SQLiteDatabase r1 = this.mHelper.getWritableDatabase();
        if (this.mUriMatcher.match(uri) == 0) goto L5;
        int r5 = 0;
    L6:
        if (r5 <= 0) goto L8;
        notifyChange(uri);
    L8:
        LogTag.d(r0, "update 2");
        return r5;
    L5:
        r5 = r1.update(InvokeHistoryDataHelp.TABLE_NAME, values, selection, selectionArgs);
        goto L6
    }

    private void notifyChange(Uri uri) {
        this.mContext.getContentResolver().notifyChange(uri, null);
    }
}
