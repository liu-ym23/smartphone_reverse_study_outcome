package com.android.settings.search;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class IndexDatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_INDEX_TABLE = "CREATE VIRTUAL TABLE prefs_index USING fts4(locale, data_rank, data_title, data_title_normalized, data_summary_on, data_summary_on_normalized, data_summary_off, data_summary_off_normalized, data_entries, data_keywords, screen_title, class_name, icon, intent_action, intent_target_package, intent_target_class, enabled, data_key_reference, user_id);";
    private static final String CREATE_META_TABLE = "CREATE TABLE meta_index(build VARCHAR(32) NOT NULL)";
    private static final String CREATE_SAVED_QUERIES_TABLE = "CREATE TABLE saved_queries(query VARCHAR(64) NOT NULL, timestamp INTEGER)";
    private static final String DATABASE_NAME = "search_index.db";
    private static final int DATABASE_VERSION = 115;
    private static final String INDEX = "index";
    private static final String INSERT_BUILD_VERSION = null;
    private static final String SELECT_BUILD_VERSION = "SELECT build FROM meta_index LIMIT 1;";
    private static final String TAG = "IndexDatabaseHelper";
    private static IndexDatabaseHelper sSingleton;
    private final Context mContext;

    public interface IndexColumns {
        public static final String CLASS_NAME = "class_name";
        public static final String DATA_ENTRIES = "data_entries";
        public static final String DATA_KEYWORDS = "data_keywords";
        public static final String DATA_KEY_REF = "data_key_reference";
        public static final String DATA_RANK = "data_rank";
        public static final String DATA_SUMMARY_OFF = "data_summary_off";
        public static final String DATA_SUMMARY_OFF_NORMALIZED = "data_summary_off_normalized";
        public static final String DATA_SUMMARY_ON = "data_summary_on";
        public static final String DATA_SUMMARY_ON_NORMALIZED = "data_summary_on_normalized";
        public static final String DATA_TITLE = "data_title";
        public static final String DATA_TITLE_NORMALIZED = "data_title_normalized";
        public static final String DOCID = "docid";
        public static final String ENABLED = "enabled";
        public static final String ICON = "icon";
        public static final String INTENT_ACTION = "intent_action";
        public static final String INTENT_TARGET_CLASS = "intent_target_class";
        public static final String INTENT_TARGET_PACKAGE = "intent_target_package";
        public static final String LOCALE = "locale";
        public static final String SCREEN_TITLE = "screen_title";
        public static final String USER_ID = "user_id";
    }

    public interface MetaColumns {
        public static final String BUILD = "build";
    }

    public interface SavedQueriesColums {
        public static final String QUERY = "query";
        public static final String TIME_STAMP = "timestamp";
    }

    public interface Tables {
        public static final String TABLE_META_INDEX = "meta_index";
        public static final String TABLE_PREFS_INDEX = "prefs_index";
        public static final String TABLE_SAVED_QUERIES = "saved_queries";
    }

    static {
        INSERT_BUILD_VERSION = "INSERT INTO meta_index VALUES ('" + Build.VERSION.INCREMENTAL + "');";
    }

    public static synchronized IndexDatabaseHelper getInstance(Context r2) {
        monitor-enter(IndexDatabaseHelper.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sSingleton != null) goto L7;
        sSingleton = new IndexDatabaseHelper(r2);     // Catch: Throwable -> L10
    L7:
        IndexDatabaseHelper r3 = sSingleton;     // Catch: Throwable -> L10
        monitor-exit(IndexDatabaseHelper.class);
        return r3;
    }

    public IndexDatabaseHelper(Context r4) {
        super(r4, DATABASE_NAME, null, 115);
        this.mContext = r4;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
        bootstrapDB(r1);
    }

    private void bootstrapDB(SQLiteDatabase r1) {
        r1.execSQL(CREATE_INDEX_TABLE);
        r1.execSQL(CREATE_META_TABLE);
        r1.execSQL(CREATE_SAVED_QUERIES_TABLE);
        r1.execSQL(INSERT_BUILD_VERSION);
        OLog.i(TAG, "Bootstrapped database");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase r4) {
        super.onOpen(r4);
        OLog.i(TAG, "Using schema version: " + r4.getVersion());
        if (Build.VERSION.INCREMENTAL.equals(getBuildVersion(r4)) == true) goto L5;
        OLog.w(TAG, "Index needs to be rebuilt as build-version is not the same");
        reconstruct(r4);
        return;
    L5:
        OLog.i(TAG, "Index is fine");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r3, int r4, int r5) {
        if (r4 >= 115) goto L6;
        OLog.w(TAG, "Detected schema version '" + r4 + "'. Index needs to be rebuilt for schema version '" + r5 + "'.");
        reconstruct(r3);
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase r3, int r4, int r5) {
        OLog.w(TAG, "Detected schema version '" + r4 + "'. Index needs to be rebuilt for schema version '" + r5 + "'.");
        reconstruct(r3);
    }

    private void reconstruct(SQLiteDatabase r1) {
        dropTables(r1);
        bootstrapDB(r1);
    }

    private String getBuildVersion(SQLiteDatabase r4) {
        String r3 = null;
        Cursor r5 = r4.rawQuery(SELECT_BUILD_VERSION, null);     // Catch: Throwable -> L9 Exception -> L11
    L16:
        Throwable th = th;
    L17:
        if (r5 == null) goto L19;
        r5.close();
    L19:
        throw th;
    L5:
        if (r5.moveToFirst() == false) goto L7;
        r3 = r5.getString(0);     // Catch: Exception -> L20 Throwable -> L16
    L7:
        if (r5 == null) goto L15;
    L8:
        r5.close();
    L15:
        return r3;
    L12:
        OLog.e(TAG, "Cannot get build version from Index metadata");     // Catch: Throwable -> L16
        if (r5 == null) goto L15;
    L11:
        r5 = null;
    L9:
        th = move-exception;
        r5 = null;
        th = th;
        goto L17
    }

    public static void clearLocalesIndexed(Context r2) {
        r2.getSharedPreferences(INDEX, 0).edit().clear().apply();
    }

    public static void setLocaleIndexed(Context r2, String r3) {
        r2.getSharedPreferences(INDEX, 0).edit().putBoolean(r3, true).apply();
    }

    public static boolean isLocaleAlreadyIndexed(Context r2, String r3) {
        return r2.getSharedPreferences(INDEX, 0).getBoolean(r3, false);
    }

    private void dropTables(SQLiteDatabase r1) {
        clearLocalesIndexed(this.mContext);
        r1.execSQL("DROP TABLE IF EXISTS meta_index");
        r1.execSQL("DROP TABLE IF EXISTS prefs_index");
        r1.execSQL("DROP TABLE IF EXISTS saved_queries");
    }
}
