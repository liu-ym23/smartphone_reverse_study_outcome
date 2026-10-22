package com.obric.server.security.audit;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class AuditDbHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 7;
    private static final String LOG_TABLE_COLUMNS = "id INTEGER PRIMARY KEY AUTOINCREMENT,ts INTEGER,payload_format INTEGER,payload_raw BLOB,trace_id TEXT,log_source TEXT,timestamp_str TEXT,target_package TEXT,target_activity TEXT,intent_type TEXT,agent_name TEXT,instruction_id TEXT,uid TEXT,device_id TEXT,is_agent_related INTEGER DEFAULT 1,payload_encrypted BLOB,leaf_hash TEXT";
    public static final String TABLE_AUDIT_LOGS = "audit_logs";
    public static final String TABLE_UPLOAD_QUEUE = "upload_queue";
    private static final String TAG = "AuditDbHelper";

    public AuditDbHelper(Context context) {
        super(context, "/data/system/security_audit/agent_robots/audit.db", null, DB_VERSION);
    }

    public static String[] getAllLogTableNames() {
        return new String[]{TABLE_AUDIT_LOGS};
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.enableWriteAheadLogging();     // Catch: Throwable -> L5
        return;
    L5:
        t = move-exception;
        Log.w(TAG, "enableWriteAheadLogging failed", t);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        createLogTable(db, TABLE_AUDIT_LOGS);
        createUploadQueueTable(db);
        createAuditBlocksTable(db);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "onUpgrade oldVersion=" + oldVersion + ", newVersion=" + newVersion);
        if (db != null) goto L5;
        return;
    L5:
        db.beginTransaction();
        if (oldVersion < newVersion) goto L25;
    L8:
        db.setTransactionSuccessful();     // Catch: Throwable -> L13 Exception -> L15
        db.endTransaction();     // Catch: Exception -> L11
        return;
    L15:
        e = move-exception;
        Log.e(TAG, "onUpgrade: migration failed", e);     // Catch: Throwable -> L13
        db.endTransaction();     // Catch: Exception -> L11
        return;
    L13:
        th = move-exception;
        db.endTransaction();     // Catch: Exception -> L22
    L24:
        throw th;
    L22:
        e = move-exception;
        Log.w(TAG, "endTransaction failed", e);
    L11:
        e = move-exception;
        Log.w(TAG, "endTransaction failed", e);
        return;
    L25:
        migrateToCurrentSchema(db);     // Catch: Throwable -> L13 Exception -> L15
        goto L8
    }

    private static void migrateToCurrentSchema(SQLiteDatabase db) {
        Log.i(TAG, "migrateToCurrentSchema: starting");
        ensureColumn(db, TABLE_AUDIT_LOGS, "instruction_id", "TEXT");
        ensureColumn(db, TABLE_AUDIT_LOGS, "uid", "TEXT");
        ensureColumn(db, TABLE_AUDIT_LOGS, "device_id", "TEXT");
        ensureColumn(db, TABLE_AUDIT_LOGS, "is_agent_related", "INTEGER DEFAULT 1");
        ensureColumn(db, TABLE_AUDIT_LOGS, "payload_encrypted", "BLOB");
        ensureColumn(db, TABLE_AUDIT_LOGS, "leaf_hash", "TEXT");
        db.execSQL("CREATE INDEX IF NOT EXISTS idx_audit_logs_instruction_id ON audit_logs(instruction_id);");
        ensureColumn(db, TABLE_UPLOAD_QUEUE, "batch_id", "TEXT");
        createAuditBlocksTable(db);
        Log.i(TAG, "migrateToCurrentSchema: completed");
    }

    private static void createUploadQueueTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS upload_queue (log_id INTEGER PRIMARY KEY,status INTEGER,retry_count INTEGER,added_ts INTEGER,batch_id TEXT);");
        db.execSQL("CREATE INDEX IF NOT EXISTS idx_upload_queue_status ON upload_queue(status);");
        db.execSQL("CREATE INDEX IF NOT EXISTS idx_upload_queue_added_ts ON upload_queue(added_ts);");
    }

    private static void createAuditBlocksTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS audit_blocks (block_seq INTEGER PRIMARY KEY,block_hash TEXT,prev_hash TEXT,merkle_root TEXT,signature BLOB,record_count INTEGER,created_ts INTEGER);");
    }

    private static void createLogTable(SQLiteDatabase db, String tableName) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + tableName + " (" + LOG_TABLE_COLUMNS + ");");
        String prefix = "idx_" + tableName;
        db.execSQL("CREATE INDEX IF NOT EXISTS " + prefix + "_ts ON " + tableName + "(ts);");
        db.execSQL("CREATE INDEX IF NOT EXISTS " + prefix + "_target_pkg ON " + tableName + "(target_package);");
        db.execSQL("CREATE INDEX IF NOT EXISTS " + prefix + "_target_activity ON " + tableName + "(target_activity);");
        db.execSQL("CREATE INDEX IF NOT EXISTS " + prefix + "_intent_type ON " + tableName + "(intent_type);");
        db.execSQL("CREATE INDEX IF NOT EXISTS " + prefix + "_instruction_id ON " + tableName + "(instruction_id);");
    }

    private static void ensureColumn(SQLiteDatabase db, String table, String column, String type) {
        if (hasColumn(db, table, column) == false) goto L5;
        return;
    L5:
        String sql = "ALTER TABLE " + table + " ADD COLUMN " + column + " " + type;
        db.execSQL(sql);
        Log.i(TAG, "ensureColumn: add " + table + "." + column + " " + type);
    }

    private static boolean hasColumn(SQLiteDatabase db, String table, String column) {
        Cursor c = null;
        c = db.rawQuery("PRAGMA table_info(" + table + ")", null);     // Catch: Throwable -> L19
    L5:
        if (c.moveToNext() == false) goto L14;
        String name = c.getString(1);     // Catch: Throwable -> L19
        if (column.equalsIgnoreCase(name) == false) goto L5;
        if (c != null) goto L36;
    L12:
        return true;
    L36:
        c.close();     // Catch: Throwable -> L11
        goto L12
        goto L45
    L14:
        if (c == null) goto L24;
        c.close();     // Catch: Throwable -> L17
        return false;
    L24:
        return false;
    L19:
        t = move-exception;
        Log.w(TAG, "hasColumn failed for table=" + table + ", column=" + column, t);     // Catch: Throwable -> L26
        if (c == null) goto L43;
        c.close();     // Catch: Throwable -> L17
        return false;
    L43:
        return false;
    L26:
        th = move-exception;
        if (c != null) goto L34;
    L31:
        throw th;
    L34:
        c.close();     // Catch: Throwable -> L30
    L45:
        return false;
    }
}
