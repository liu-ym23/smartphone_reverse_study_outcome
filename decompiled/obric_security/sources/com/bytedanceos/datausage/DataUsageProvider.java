package com.bytedanceos.datausage;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedanceos.utils.Constants;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class DataUsageProvider extends ContentProvider {
    public static final String AUTHORITY = "com.bytedanceos.tencent";
    public static final Uri CONTENT_URI_SIMINFO = null;
    private static final String DATABASE_NAME = "datausage.db";
    private static final int DATABASE_VERSION = 1;
    static final String PARAMETER_NOTIFY = "notify";
    public static final String TABLE_SIMINFO = "siminfo";
    private static final String TAG = "DataUsageProvider";
    private SQLiteDatabase mDatabase;
    private DatabaseHelper mOpenHelper;

    private static class DatabaseHelper extends SQLiteOpenHelper {
        Context mContext;

        DatabaseHelper(Context context) {
            super(context, DataUsageProvider.DATABASE_NAME, null, 1);
            this.mContext = context;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase db) {
            OLog.d(DataUsageProvider.TAG, "creating new database");
            db.execSQL("CREATE TABLE siminfo (_id INTEGER PRIMARY KEY,card_imsi TEXT,provinceId TEXT,cityId TEXT,carryId TEXT,brandId TEXT)");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            OLog.d(DataUsageProvider.TAG, "onUpgrade triggered: " + oldVersion);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            OLog.d(DataUsageProvider.TAG, "onDowngrade triggered: " + oldVersion);
        }
    }

    static class SqlArguments {
        public final String[] args;
        public final String table;
        public final String where;

        SqlArguments(Uri url, String where, String[] args) {
            if (url.getPathSegments().size() != 1) goto L6;
            this.table = url.getPathSegments().get(0);
            this.where = where;
            this.args = args;
            return;
        L6:
            if (url.getPathSegments().size() != 2) goto L14;
            if (TextUtils.isEmpty(where) == false) goto L12;
            this.table = url.getPathSegments().get(0);
            this.where = "_id=" + ContentUris.parseId(url);
            this.args = null;
            return;
        L12:
            throw new UnsupportedOperationException("WHERE clause not supported: " + url);
        L14:
            throw new IllegalArgumentException("Invalid URI: " + url);
        }

        SqlArguments(Uri url) {
            if (url.getPathSegments().size() != 1) goto L7;
            this.table = url.getPathSegments().get(0);
            this.where = null;
            this.args = null;
            return;
        L7:
            throw new IllegalArgumentException("Invalid URI: " + url);
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "";
    }

    public DataUsageProvider() {
    }

    static {
        CONTENT_URI_SIMINFO = Uri.parse("content://com.bytedanceos.tencent/siminfo");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mOpenHelper = new DatabaseHelper(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SqlArguments r0 = new SqlArguments(uri, selection, selectionArgs);
        SQLiteQueryBuilder r1 = new SQLiteQueryBuilder();
        r1.setTables(r0.table);
        Cursor r11 = r1.query(this.mOpenHelper.getWritableDatabase(), projection, r0.where, r0.args, null, null, sortOrder);
        r11.setNotificationUri(getContext().getContentResolver(), uri);
        return r11;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues initialValues) {
        SqlArguments r0 = new SqlArguments(uri);
        SQLiteDatabase r1 = this.mOpenHelper.getWritableDatabase();
        long r2 = dbInsertAndCheck(this.mOpenHelper, r1, r0.table, null, initialValues);
        if (r2 > 0) goto L5;
        return null;
    L5:
        Uri r7 = ContentUris.withAppendedId(uri, r2);
        sendNotify(r7);
        return r7;
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] values) {
        SqlArguments r0 = new SqlArguments(uri);
        SQLiteDatabase r1 = this.mOpenHelper.getWritableDatabase();
        r1.beginTransaction();     // Catch: Throwable -> L13 Exception -> L15
        int r2 = values.length;     // Catch: Throwable -> L13 Exception -> L15
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L11;
        if (dbInsertAndCheck(this.mOpenHelper, r1, r0.table, null, values[r4]) < 0) goto L8;
        r4 = r4 + 1;
        goto L4
    L8:
        r1.endTransaction();
        return 0;
    L11:
        r1.setTransactionSuccessful();     // Catch: Throwable -> L13 Exception -> L15
    L12:
        r1.endTransaction();
        sendNotify(uri);
        return values.length;
    L13:
        th = move-exception;
        r1.endTransaction();
        throw th;
    L15:
        e = move-exception;
        OLog.e(TAG, " bulk insert fail , the reason is " + e.getMessage());     // Catch: Throwable -> L13
        goto L12
    }

    private void sendNotify(Uri uri) {
        String r0 = uri.getQueryParameter(PARAMETER_NOTIFY);
        if (r0 != null) goto L5;
    L6:
        getContext().getContentResolver().notifyChange(uri, null);
        return;
    L5:
        if (Constants.IS_SET.equals(r0) == true) goto L6;
    }

    private static long dbInsertAndCheck(DatabaseHelper helper, SQLiteDatabase db, String table, String nullColumnHack, ContentValues values) {
        return db.insert(table, nullColumnHack, values);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SqlArguments r0 = new SqlArguments(uri, selection, selectionArgs);
        int r4 = this.mOpenHelper.getWritableDatabase().delete(r0.table, r0.where, r0.args);
        if (r4 <= 0) goto L5;
        sendNotify(uri);
    L5:
        return r4;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SqlArguments r0 = new SqlArguments(uri, selection, selectionArgs);
        int r4 = this.mOpenHelper.getWritableDatabase().update(r0.table, values, r0.where, r0.args);
        if (r4 <= 0) goto L5;
        sendNotify(uri);
    L5:
        return r4;
    }
}
