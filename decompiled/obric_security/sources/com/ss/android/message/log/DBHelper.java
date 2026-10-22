package com.ss.android.message.log;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class DBHelper {
    static final String COL_CATEGORY = "category";
    static final String COL_EXT_JSON = "ext_json";
    static final String COL_EXT_VALUE = "ext_value";
    static final String COL_ID = "_id";
    static final String COL_LABEL = "label";
    static final String COL_TAG = "tag";
    static final String COL_VALUE = "value";
    static final String DB_NAME = "ss_push_log.db";
    static final int DB_VERSION = 1;
    static final String[] EVENT_COLS = null;
    private static final String LOG_TAG = "PushLog";
    static final String TABLE_EVENT = "event";
    private static DBHelper mInstance = null;
    private static final Object mLock = null;
    private static final String whereId = "_id = ?";
    private SQLiteDatabase mDb;

    private static class OpenHelper extends SQLiteOpenHelper {
        static final String createTableEvent = "CREATE TABLE event ( _id INTEGER PRIMARY KEY AUTOINCREMENT, category VARCHAR, tag VARCHAR, label VARCHAR, value INTEGER, ext_value INTEGER, ext_json TEXT )";

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
        }

        public OpenHelper(Context r4) {
            super(r4, DBHelper.DB_NAME, null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r2) {
            r2.execSQL(createTableEvent);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            Logger.e(DBHelper.LOG_TAG, "create db exception " + e);
        }
    }

    static {
        EVENT_COLS = new String[]{"_id", "category", "tag", "label", "value", "ext_value", "ext_json"};
        mLock = new Object();
    }

    public static DBHelper getInstance(Context r2) {
        Object r0 = mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (mInstance != null) goto L7;
        mInstance = new DBHelper(r2.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return mInstance;
    }

    public static void closeDB() {
        Object r0 = mLock;
        monitor-enter(r0);
        DBHelper r1 = mInstance;     // Catch: Throwable -> L10
        if (r1 == null) goto L7;
        r1.closeDatabase();     // Catch: Throwable -> L10
    L7:
        mInstance = null;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    protected static void safeCloseCursor(Cursor r1) {
        if (r1 == null) goto L10;
        if (r1.isClosed() == true) goto L11;
        r1.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    protected static void safeCloseCursorAndEndTX(Cursor r0, SQLiteDatabase r1) {
        safeCloseCursor(r0);
        if (r1 == null) goto L11;
        if (r1.inTransaction() == false) goto L12;
        r1.endTransaction();     // Catch: Exception -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    private DBHelper(Context r2) {
        this.mDb = new OpenHelper(r2).getWritableDatabase();
    }

    private synchronized void closeDatabase() {
        monitor-enter(this);
        SQLiteDatabase r1 = this.mDb;     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
    L12:
        monitor-exit(this);
        return;
    L7:
        if (r1.isOpen() == false) goto L12;
        this.mDb.close();     // Catch: Throwable -> L10
        this.mDb = null;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Logger.w(LOG_TAG, "closeDatabase error: " + th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized long insertEvent(LogEvent r5) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.mDb;     // Catch: Throwable -> L21
        if (r0 != null) goto L6;
    L17:
        Logger.w(LOG_TAG, "db not establish and open");     // Catch: Throwable -> L21
        monitor-exit(this);
        return -1;
    L6:
        if (r0.isOpen() == false) goto L17;
        ContentValues r1 = new ContentValues();     // Catch: Throwable -> L21
        r1.put("category", r5.category);     // Catch: Throwable -> L21
        r1.put("tag", r5.tag);     // Catch: Throwable -> L21
        if (StringUtils.isEmpty(r5.label) == true) goto L11;
        r1.put("label", r5.label);     // Catch: Throwable -> L21
    L11:
        r1.put("value", Long.valueOf(r5.value));     // Catch: Throwable -> L21
        r1.put("ext_value", Long.valueOf(r5.ext_value));     // Catch: Throwable -> L21
        if (StringUtils.isEmpty(r5.ext_json) == true) goto L14;
        r1.put("ext_json", r5.ext_json);     // Catch: Throwable -> L21
    L14:
        long r2 = this.mDb.insert("event", null, r1);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r2;
    L21:
        th = move-exception;
        throw th;
    }

    public synchronized boolean deleteEvent(long r5) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.mDb;     // Catch: Throwable -> L16
        boolean r1 = false;
        if (r0 != null) goto L6;
    L13:
        Logger.w(LOG_TAG, "db not establish and open");     // Catch: Throwable -> L16
        monitor-exit(this);
        return false;
    L6:
        if (r0.isOpen() == false) goto L13;
        if (this.mDb.delete("event", whereId, new String[]{String.valueOf(r5)}) <= 0) goto L11;
        r1 = true;
    L11:
        monitor-exit(this);
        return r1;
    L16:
        th = move-exception;
        throw th;
    }

    public synchronized JSONArray getEvents(long r21, int r23) {
        monitor-enter(this);
        String r10 = "" + r23;     // Catch: Throwable -> L74
        int r0 = 1;
        int r11 = 0;
        String[] r6 = {String.valueOf(r21)};     // Catch: Throwable -> L74
        JSONArray r12 = new JSONArray();     // Catch: Throwable -> L74
        Cursor r2 = this.mDb.query("event", EVENT_COLS, "_id > ? ", r6, null, null, "_id ASC", r10);     // Catch: Throwable -> L59
        int r5 = 0;
        long r7 = 0;
    L84:
    L56:
        th = th;
        JSONArray r3 = r12;
    L58:
        int r13 = r5;
    L77:
        th.printStackTrace();     // Catch: Throwable -> L70
        safeCloseCursor(r2);     // Catch: Throwable -> L74
        r5 = r13;
    L64:
        if (r5 <= 0) goto L67;
        monitor-exit(this);
        return r3;
    L67:
        monitor-exit(this);
        return null;
    L70:
        th = move-exception;
        safeCloseCursor(r2);     // Catch: Throwable -> L74
        throw th;     // Catch: Throwable -> L74
    L8:
        if (r2.moveToNext() == false) goto L53;
        long r8 = r2.getLong(r11);     // Catch: Throwable -> L56
        String r14 = r2.getString(r0);     // Catch: Throwable -> L56
        String r15 = r2.getString(2);     // Catch: Throwable -> L56
        if (r2.isNull(3) == false) goto L81;
        String r16 = null;
    L17:
        if (r2.isNull(4) == false) goto L20;
        long r17 = 0;
    L79:
        if (r2.isNull(5) == true) goto L26;
        long r18 = r2.getLong(5);     // Catch: Throwable -> L51
    L28:
        if (r2.isNull(6) == true) goto L30;
        String r1 = r2.getString(6);     // Catch: Throwable -> L51
    L32:
        if (r7 >= r8) goto L34;
        r7 = r8;
    L34:
        JSONObject r19 = new JSONObject();     // Catch: Throwable -> L51
        r19.put("_id", r8);     // Catch: Throwable -> L51
        if (StringUtils.isEmpty(r1) == true) goto L37;
        r19.put("ext_json", r1);     // Catch: Throwable -> L51
    L37:
        r19.put("category", r14);     // Catch: Throwable -> L51
        r19.put("tag", r15);     // Catch: Throwable -> L51
        if (StringUtils.isEmpty(r16) == true) goto L41;
        r19.put("label", r16);     // Catch: Throwable -> L51
    L41:
        if (r17 == 0) goto L43;
        r19.put("value", r17);     // Catch: Throwable -> L51
    L43:
        long r4 = r18;
        if (r4 == 0) goto L46;
        r19.put("ext_value", r4);     // Catch: Throwable -> L51
    L46:
        r3 = r12;
        r3.put(r19);     // Catch: Throwable -> L49
        r5 = r5 + 1;
        r12 = r3;
        r0 = 1;
        r11 = 0;
    L49:
        th = th;
        goto L58
    L30:
        r1 = null;
        goto L32
    L26:
        r18 = 0;
    L51:
        th = th;
        r3 = r12;
        goto L58
    L20:
        r17 = r2.getLong(4);     // Catch: Throwable -> L13
        goto L79
    L81:
        r16 = r2.getString(3);     // Catch: Throwable -> L13
    L13:
        th = th;
        r13 = r5;
        r3 = r12;
        goto L77
    L53:
        r3 = r12;
        safeCloseCursor(r2);     // Catch: Throwable -> L74
    L59:
        th = th;
        r3 = r12;
        r2 = null;
        r13 = 0;
    L74:
        th = move-exception;
        throw th;
    }
}
