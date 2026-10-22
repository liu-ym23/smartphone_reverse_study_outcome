package com.obric.server.security.audit;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.android.server.wm.ObricActivityTaskManagerServiceImpl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AuditRepository {
    private static final int DIR_TRIM_BATCH_ROWS = 5000;
    private static final int DIR_TRIM_MAX_BATCHES = 10;
    private static final String KEY_PAYLOAD_ENCRYPTED = "payload_encrypted";
    private static final String TAG = "AuditRepository";
    private final AuditDbHelper mDbHelper;
    private volatile MerkleIntegrityManager mIntegrityManager;

    public AuditRepository(AuditDbHelper dbHelper, Handler workerHandler) {
        ensureDbDirExists();
        this.mDbHelper = dbHelper;
    }

    public void setIntegrityManager(MerkleIntegrityManager manager) {
        this.mIntegrityManager = manager;
    }

    private void ensureDbDirExists() {
        File dir = new File("/data/system/security_audit/agent_robots");
        if (dir.exists() == false) goto L5;
        return;
    L5:
        if (dir.mkdirs() == true) goto L9;
        Log.e(TAG, "ensureDbDirExists: failed to create directory /data/system/security_audit/agent_robots");
        return;
    }

    private boolean shouldDegradeForLowStorage(String operation) {
        File path = new File("/data/system/security_audit/agent_robots");     // Catch: RuntimeException -> L16
    L4:
        if (path == null) goto L8;
        if (path.exists() == true) goto L8;
        path = path.getParentFile();     // Catch: RuntimeException -> L16
    L8:
        if (path != null) goto L10;
        path = new File("/data");     // Catch: RuntimeException -> L16
    L10:
        long usableBytes = path.getUsableSpace();     // Catch: RuntimeException -> L16
        if (usableBytes >= 10485760) goto L24;
        Log.w(TAG, operation + ": skip audit db operation for low storage, usableBytes=" + usableBytes);     // Catch: RuntimeException -> L16
        appendDbErrorLog(operation, usableBytes);     // Catch: RuntimeException -> L16
        return true;
    L24:
        return false;
    L16:
        e = move-exception;
        Log.w(TAG, operation + ": failed to check usable storage", e);
        return false;
    }

    private void appendDbErrorLog(String operation, long usableBytes) {
        File errorLog = new File("/data/system/security_audit/db_error.log");
        File parent = errorLog.getParentFile();     // Catch: Exception -> L21
        if (parent != null) goto L6;
    L11:
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(errorLog, true), StandardCharsets.UTF_8));     // Catch: Exception -> L21
        writer.write(System.currentTimeMillis() + " operation=" + operation + " usableBytes=" + usableBytes + " thresholdBytes=10485760 message=low storage, pause audit database operation");     // Catch: Throwable -> L15
        writer.newLine();     // Catch: Throwable -> L15
        writer.close();     // Catch: Exception -> L21
        return;
    L15:
        th = move-exception;
        writer.close();     // Catch: Throwable -> L18
    L20:
        throw th;     // Catch: Exception -> L21
    L18:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L21
        goto L20
    L6:
        if (parent.exists() == true) goto L11;
        if (parent.mkdirs() == true) goto L11;
        Log.w(TAG, "appendDbErrorLog: failed to create directory " + parent);     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        Log.w(TAG, "appendDbErrorLog failed", e);
    }

    public List<String> queryRawJson(long startTimeMs, long endTimeMs, String callerPackage, String targetIntent, String targetActivity) {
        List<String> result = new ArrayList();
        if (TextUtils.isEmpty(callerPackage) == false) goto L6;
        Log.w(TAG, "queryRawJson: empty callerPackage");
        return result;
    L6:
        StringBuilder selection = new StringBuilder();
        List<String> args = new ArrayList();
        if (startTimeMs <= 0) goto L12;
        if (endTimeMs <= 0) goto L12;
        selection.append("ts BETWEEN ? AND ?");
        args.add(String.valueOf(startTimeMs));
        args.add(String.valueOf(endTimeMs));
    L18:
        if (selection.length() <= 0) goto L20;
        selection.append(" AND ");
    L20:
        selection.append("target_package = ?");
        args.add(callerPackage);
        if (TextUtils.isEmpty(targetIntent) == true) goto L25;
        selection.append(" AND intent_type = ?");
        args.add(targetIntent);
    L25:
        if (TextUtils.isEmpty(targetActivity) == true) goto L29;
        selection.append(" AND target_activity = ?");
        args.add(targetActivity);
    L29:
        if (shouldDegradeForLowStorage("queryRawJson") == false) goto L31;
        return result;
    L31:
        SQLiteDatabase db = null;
        Cursor c = null;
        SQLiteDatabase db2 = this.mDbHelper.getReadableDatabase();     // Catch: Throwable -> L52 Exception -> L54
        c = db2.query(AuditDbHelper.TABLE_AUDIT_LOGS, new String[]{"payload_raw"}, selection.toString(), (String[]) args.toArray(new String[0]), null, null, "ts DESC", "1000");     // Catch: Throwable -> L48 Exception -> L50
    L36:
        if (c.moveToNext() == false) goto L46;
        byte[] blob = c.getBlob(0);     // Catch: Throwable -> L48 Exception -> L50
        if (blob == null) goto L36;
        String json = new String(blob, StandardCharsets.UTF_8);     // Catch: Throwable -> L43
        result.add(json);     // Catch: Throwable -> L43
    L43:
        e = move-exception;
        Log.w(TAG, "queryRawJson: failed to decode payload_raw", e);     // Catch: Throwable -> L48 Exception -> L50
    L46:
        if (c == null) goto L59;
        c.close();
    L59:
        return result;
    L50:
        e = e;
        db = db2;
    L55:
        Log.e(TAG, "queryRawJson failed", e);     // Catch: Throwable -> L52
        if (c == null) goto L59;
        c.close();
    L48:
        th = th;
    L60:
        if (c == null) goto L62;
        c.close();
    L62:
        throw th;
    L54:
        e = e;
    L52:
        th = th;
    L12:
        if (startTimeMs <= 0) goto L15;
        selection.append("ts >= ?");
        args.add(String.valueOf(startTimeMs));
        goto L18
    L15:
        if (endTimeMs <= 0) goto L18;
        selection.append("ts <= ?");
        args.add(String.valueOf(endTimeMs));
        goto L18
    }

    public void exportAllAsNdjson(File outFile, long startTimeMs, long endTimeMs, int pageSize, boolean gzip) {
        long r3 = startTimeMs;
        if (outFile != null) goto L6;
        Log.w(TAG, "exportAllAsNdjson: outFile is null");
        return;
    L6:
        if (pageSize <= 0) goto L8;
        int r0 = pageSize;
    L9:
        int effectivePageSize = r0;
        Log.i(TAG, "exportAllAsNdjson: path=" + outFile.getAbsolutePath() + ", startTimeMs=" + r3 + ", endTimeMs=" + endTimeMs + ", pageSize=" + effectivePageSize + ", gzip=" + gzip);
        if (shouldDegradeForLowStorage("exportAllAsNdjson") == false) goto L12;
        return;
    L12:
        SQLiteDatabase db = null;
        Cursor c = null;
        OutputStream os = new FileOutputStream(outFile);     // Catch: Throwable -> L76 Exception -> L78
        if (gzip == true) goto L103;
        OutputStream r1 = os;
    L20:
        OutputStream finalOs = r1;
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(finalOs, StandardCharsets.UTF_8));     // Catch: Throwable -> L17
        SQLiteDatabase db2 = this.mDbHelper.getReadableDatabase();     // Catch: Throwable -> L17
        String[] r10 = AuditDbHelper.getAllLogTableNames();     // Catch: Throwable -> L69
        int r2 = r10.length;     // Catch: Throwable -> L69
        int r4 = 0;
    L23:
        if (r4 >= r2) goto L110;
        String tableName = r10[r4];     // Catch: Throwable -> L69
        long lastId = 0;
    L25:
        int r26 = r2;
        StringBuilder selection = new StringBuilder("id > ?");     // Catch: Throwable -> L69
        int r28 = r4;
        List<String> args = new ArrayList();     // Catch: Throwable -> L69
        args.add(String.valueOf(lastId));     // Catch: Throwable -> L69
        if (r3 <= 0) goto L31;
        if (endTimeMs <= 0) goto L31;
        selection.append(" AND ts BETWEEN ? AND ?");     // Catch: Throwable -> L69
        args.add(String.valueOf(r3));     // Catch: Throwable -> L69
        args.add(String.valueOf(endTimeMs));     // Catch: Throwable -> L69
    L36:
        if (c == null) goto L38;
        c.close();     // Catch: Throwable -> L69
    L38:
        c = db2.query(tableName, new String[]{"id", "payload_raw"}, selection.toString(), (String[]) args.toArray(new String[0]), null, null, "id ASC", Integer.toString(effectivePageSize));     // Catch: Throwable -> L69
        if (c.moveToFirst() == false) goto L40;
    L41:
        long id = c.getLong(0);     // Catch: Throwable -> L69
        byte[] blob = c.getBlob(1);     // Catch: Throwable -> L69
        lastId = id;
        if (blob != null) goto L93;
        List<String> args2 = args;
    L55:
        if (c.moveToNext() == false) goto L56;
        args = args2;
        goto L41
    L56:
        writer.flush();     // Catch: Throwable -> L69
        r3 = startTimeMs;
        r2 = r26;
        r4 = r28;
        goto L25
    L93:
        args2 = args;
        byte[] blob2 = blob;
        String json = new String(blob2, StandardCharsets.UTF_8);     // Catch: Exception -> L49 Throwable -> L69
        writer.write(json);     // Catch: Exception -> L49 Throwable -> L69
        writer.newLine();     // Catch: Exception -> L49 Throwable -> L69
    L49:
        t = e;
    L53:
        Log.w(TAG, "exportAllAsNdjson: failed to write row id=" + id, t);     // Catch: Throwable -> L69
    L51:
        t = e;
        args2 = args;
        blob2 = blob;
        goto L53
    L40:
        r4 = r28 + 1;     // Catch: Throwable -> L69
        r2 = r26;
    L31:
        if (r3 <= 0) goto L34;
        selection.append(" AND ts >= ?");     // Catch: Throwable -> L69
        args.add(String.valueOf(r3));     // Catch: Throwable -> L69
        goto L36
    L34:
        if (endTimeMs <= 0) goto L36;
        selection.append(" AND ts <= ?");     // Catch: Throwable -> L69
        args.add(String.valueOf(endTimeMs));     // Catch: Throwable -> L69
        goto L36
    L110:
        os.close();     // Catch: Throwable -> L65 Exception -> L67
        if (c == null) goto L115;
        c.close();     // Catch: Exception -> L63
        return;
    L117:
        return;
    L115:
        return;
    L67:
        e = e;
        db = db2;
    L79:
        Log.e(TAG, "exportAllAsNdjson failed", e);     // Catch: Throwable -> L76
        if (c == null) goto L86;
        c.close();     // Catch: Exception -> L83
    L86:
        return;
    L65:
        th = move-exception;
        Throwable r5 = th;
    L87:
        if (c == null) goto L118;
        c.close();     // Catch: Exception -> L90
        throw r5;
    L91:
        throw r5;
    L118:
        throw r5;
    L69:
        th = move-exception;
        Throwable r6 = th;
        db = db2;
    L105:
        os.close();     // Catch: Throwable -> L73
        throw r6;     // Catch: Throwable -> L76 Exception -> L78
    L73:
        th = move-exception;
        r6.addSuppressed(th);     // Catch: Throwable -> L76 Exception -> L78
        throw r6;     // Catch: Throwable -> L76 Exception -> L78
    L17:
        th = move-exception;
        r6 = th;
        goto L105
    L103:
        r1 = new GZIPOutputStream(os);     // Catch: Throwable -> L17
    L76:
        th = move-exception;
        r5 = th;
    L78:
        e = e;
        goto L79
    L8:
        r0 = 2000;
        goto L9
    }

    public int getPendingUploadCount() {
        if (shouldDegradeForLowStorage("getPendingUploadCount") == false) goto L5;
        return 0;
    L5:
        Cursor c = null;
        SQLiteDatabase db = this.mDbHelper.getReadableDatabase();     // Catch: Throwable -> L14 Exception -> L16
        c = db.rawQuery("SELECT COUNT(*) FROM upload_queue WHERE status = ?", new String[]{String.valueOf(0)});     // Catch: Throwable -> L14 Exception -> L16
        if (c.moveToFirst() == false) goto L12;
        int r1 = c.getInt(0);     // Catch: Throwable -> L14 Exception -> L16
        if (c == null) goto L11;
        c.close();
    L11:
        return r1;
    L12:
        if (c == null) goto L20;
    L13:
        c.close();
    L20:
        return 0;
    L16:
        e = move-exception;
        Log.e(TAG, "getPendingUploadCount failed", e);     // Catch: Throwable -> L14
        if (c == null) goto L20;
    L14:
        th = move-exception;
        if (c == null) goto L23;
        c.close();
    L23:
        throw th;
    }

    public void cleanupExpired(long keepMs) {
        long now = System.currentTimeMillis();
        long threshold = now - keepMs;
        if (shouldDegradeForLowStorage("cleanupExpired") == false) goto L5;
        return;
    L5:
        SQLiteDatabase db = null;
        db = this.mDbHelper.getWritableDatabase();     // Catch: Throwable -> L12 Exception -> L14
        db.beginTransaction();     // Catch: Throwable -> L12 Exception -> L14
        db.execSQL("DELETE FROM upload_queue WHERE log_id IN (  SELECT id FROM audit_logs WHERE ts < ?)", new Object[]{Long.valueOf(threshold)});     // Catch: Throwable -> L12 Exception -> L14
        db.execSQL("DELETE FROM audit_logs WHERE ts < ?", new Object[]{Long.valueOf(threshold)});     // Catch: Throwable -> L12 Exception -> L14
        db.setTransactionSuccessful();     // Catch: Throwable -> L12 Exception -> L14
        if (db == null) goto L19;
        db.endTransaction();     // Catch: Exception -> L10
    L32:
    L19:
        capRowsIfNeeded();
        capDirSizeIfNeeded();
        return;
    L12:
        th = move-exception;
        if (db != null) goto L30;
    L26:
        throw th;
    L30:
        db.endTransaction();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        Log.w(TAG, "cleanupExpired: endTransaction failed", e);
    L14:
        e = move-exception;
        Log.e(TAG, "cleanupExpired failed", e);     // Catch: Throwable -> L12
        if (db == null) goto L19;
        db.endTransaction();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.w(TAG, "cleanupExpired: endTransaction failed", e);
        goto L19
    }

    private void capRowsIfNeeded() {
        SQLiteDatabase db = null;
        Cursor c = null;
        SQLiteDatabase db2 = this.mDbHelper.getWritableDatabase();     // Catch: Throwable -> L49 Exception -> L51
        db2.beginTransaction();     // Catch: Throwable -> L49 Exception -> L51
        Cursor c2 = db2.rawQuery("SELECT COUNT(*) AS total FROM audit_logs", null);     // Catch: Throwable -> L49 Exception -> L51
        if (c2.moveToFirst() == true) goto L15;
        db2.setTransactionSuccessful();     // Catch: Throwable -> L49 Exception -> L51
        if (c2 == null) goto L8;
        c2.close();
    L8:
        if (db2 == null) goto L77;
        db2.endTransaction();     // Catch: Exception -> L11
        return;
    L11:
        end = move-exception;
        Log.w(TAG, "capRowsIfNeeded: endTransaction failed", end);
        return;
    L77:
        return;
    L15:
        long total = c2.getLong(0);     // Catch: Throwable -> L49 Exception -> L51
        if (total > 100000) goto L26;
        db2.setTransactionSuccessful();     // Catch: Throwable -> L49 Exception -> L51
        if (c2 == null) goto L20;
        c2.close();
    L20:
        if (db2 == null) goto L79;
        db2.endTransaction();     // Catch: Exception -> L23
        return;
    L23:
        end = move-exception;
        Log.w(TAG, "capRowsIfNeeded: endTransaction failed", end);
        return;
    L79:
        return;
    L26:
        long overflow = total - 100000;
        if (overflow > 0) goto L38;
        db2.setTransactionSuccessful();     // Catch: Throwable -> L49 Exception -> L51
        if (c2 == null) goto L31;
        c2.close();
    L31:
        if (db2 == null) goto L81;
        db2.endTransaction();     // Catch: Exception -> L34
        return;
    L34:
        end = move-exception;
        Log.w(TAG, "capRowsIfNeeded: endTransaction failed", end);
        return;
    L81:
        return;
    L38:
        if (overflow <= 2147483647L) goto L40;
        int toDelete = Integer.MAX_VALUE;
    L41:
        deleteOldestRows(db2, toDelete);     // Catch: Throwable -> L49 Exception -> L51
        db2.setTransactionSuccessful();     // Catch: Throwable -> L49 Exception -> L51
        if (c2 == null) goto L44;
        c2.close();
    L44:
        if (db2 == null) goto L58;
        db2.endTransaction();     // Catch: Exception -> L47
        return;
    L58:
        return;
    L40:
        toDelete = (int) overflow;
    L51:
        e = move-exception;
        Log.e(TAG, "capRowsIfNeeded failed", e);     // Catch: Throwable -> L49
        if (0 == 0) goto L55;
        c.close();
    L55:
        if (0 == 0) goto L83;
        db.endTransaction();     // Catch: Exception -> L47
        return;
    L83:
        return;
    L49:
        th = move-exception;
        if (0 == 0) goto L61;
        c.close();
    L61:
        if (0 != 0) goto L68;
    L66:
        throw th;
    L68:
        db.endTransaction();     // Catch: Exception -> L64
    L64:
        end = move-exception;
        Log.w(TAG, "capRowsIfNeeded: endTransaction failed", end);
    L47:
        end = move-exception;
        Log.w(TAG, "capRowsIfNeeded: endTransaction failed", end);
    }

    private void capDirSizeIfNeeded() {
        int i = 0;
    L4:
        if (i >= DIR_TRIM_MAX_BATCHES) goto L32;
        long bytes = getDirectoryBytes();
        if (bytes <= 104857600) goto L7;
        SQLiteDatabase db = null;
        db = this.mDbHelper.getWritableDatabase();     // Catch: Throwable -> L16 Exception -> L18
        db.beginTransaction();     // Catch: Throwable -> L16 Exception -> L18
        deleteOldestRows(db, DIR_TRIM_BATCH_ROWS);     // Catch: Throwable -> L16 Exception -> L18
        db.setTransactionSuccessful();     // Catch: Throwable -> L16 Exception -> L18
        if (db == null) goto L15;
        db.endTransaction();     // Catch: Exception -> L13
    L13:
        end = move-exception;
        Log.w(TAG, "capDirSizeIfNeeded: endTransaction failed", end);
    L15:
        checkpointTruncate();
        i = i + 1;
        goto L4
    L18:
        e = move-exception;
        Log.e(TAG, "capDirSizeIfNeeded: batch delete failed", e);     // Catch: Throwable -> L16
        if (db == null) goto L47;
        db.endTransaction();     // Catch: Exception -> L23
        return;
    L23:
        end = move-exception;
        Log.w(TAG, "capDirSizeIfNeeded: endTransaction failed", end);
        return;
    L47:
        return;
    L16:
        th = move-exception;
        if (db != null) goto L40;
    L31:
        throw th;
    L40:
        db.endTransaction();     // Catch: Exception -> L29
    L29:
        end = move-exception;
        Log.w(TAG, "capDirSizeIfNeeded: endTransaction failed", end);
        goto L31
    L7:
        return;
    }

    private void deleteOldestRows(SQLiteDatabase db, int maxRows) {
        if (maxRows > 0) goto L4;
        return;
    L4:
        String limit = Integer.toString(maxRows);
        db.execSQL("DELETE FROM upload_queue WHERE log_id IN (  SELECT id FROM audit_logs  ORDER BY ts ASC LIMIT " + limit + ")");
        db.execSQL("DELETE FROM audit_logs WHERE id IN (SELECT id FROM audit_logs ORDER BY ts ASC LIMIT " + limit + ")");
    }

    private long getDirectoryBytes() {
        long total = 0;
        File dbFile = new File("/data/system/security_audit/agent_robots/audit.db");
        if (dbFile.exists() == false) goto L5;
        total = 0 + dbFile.length();
    L5:
        File walFile = new File("/data/system/security_audit/agent_robots/audit.db-wal");
        if (walFile.exists() == false) goto L8;
        total = total + walFile.length();
    L8:
        File shmFile = new File("/data/system/security_audit/agent_robots/audit.db-shm");
        if (shmFile.exists() == true) goto L11;
        return total;
    L11:
        return total + shmFile.length();
    }

    private void checkpointTruncate() {
        SQLiteDatabase db = this.mDbHelper.getWritableDatabase();     // Catch: Exception -> L5
        db.execSQL("PRAGMA wal_checkpoint(TRUNCATE)");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.w(TAG, "checkpointTruncate failed", e);
    }

    public int insertEntryWithResult(AuditLogEntry entry) {
        if (entry != null) goto L7;
        return 4;
    L7:
        if (entry.payloadRaw == null) goto L13;
        if (entry.payloadRaw.length <= 262144) goto L13;
        Log.w(TAG, "insertEntryWithResult: payload too large");
        return 9;
    L13:
        if (entry.payloadEncrypted == null) goto L19;
        if (entry.payloadEncrypted.length <= 262144) goto L19;
        Log.w(TAG, "insertEntryWithResult: encrypted payload too large");
        return 9;
    L19:
        if (shouldDegradeForLowStorage("insertEntryWithResult") == false) goto L21;
        return 6;
    L21:
        SQLiteDatabase db = null;
        SQLiteDatabase db2 = this.mDbHelper.getWritableDatabase();     // Catch: Throwable -> L51 Exception -> L53 SQLiteException -> L63 SQLiteCantOpenDatabaseException -> L72
        db2.beginTransaction();     // Catch: Throwable -> L51 Exception -> L53 SQLiteException -> L63 SQLiteCantOpenDatabaseException -> L72
        ContentValues logValues = entryToContentValues(entry);     // Catch: Throwable -> L51 Exception -> L53 SQLiteException -> L63 SQLiteCantOpenDatabaseException -> L72
        long logId = db2.insert(AuditDbHelper.TABLE_AUDIT_LOGS, null, logValues);     // Catch: Throwable -> L51 Exception -> L53 SQLiteException -> L63 SQLiteCantOpenDatabaseException -> L72
        if (logId != (-1)) goto L32;
        Log.w(TAG, "insertEntryWithResult: insert logs failed");     // Catch: Throwable -> L51 Exception -> L53 SQLiteException -> L63 SQLiteCantOpenDatabaseException -> L72
        if (db2 != null) goto L100;
    L30:
        return 6;
    L100:
        db2.endTransaction();     // Catch: Exception -> L28
    L28:
        end = move-exception;
        Log.w(TAG, "insertEntryWithResult: endTransaction failed", end);
        goto L30
    L32:
        if (entry.uploadEnabled == true) goto L34;
    L44:
        db2.setTransactionSuccessful();     // Catch: Throwable -> L51 Exception -> L53 SQLiteException -> L63 SQLiteCantOpenDatabaseException -> L72
        if (db2 != null) goto L98;
    L50:
        return 0;
    L98:
        db2.endTransaction();     // Catch: Exception -> L48
    L48:
        end = move-exception;
        Log.w(TAG, "insertEntryWithResult: endTransaction failed", end);
        goto L50
    L34:
        if (entry.payloadEncrypted == null) goto L44;
        ContentValues qValues = new ContentValues();     // Catch: Throwable -> L51 Exception -> L53 SQLiteException -> L63 SQLiteCantOpenDatabaseException -> L72
        qValues.put("log_id", Long.valueOf(logId));     // Catch: Throwable -> L51 Exception -> L53 SQLiteException -> L63 SQLiteCantOpenDatabaseException -> L72
        qValues.put("status", 0);     // Catch: Throwable -> L51 Exception -> L53 SQLiteException -> L63 SQLiteCantOpenDatabaseException -> L72
        qValues.put("retry_count", 0);     // Catch: Throwable -> L51 Exception -> L53 SQLiteException -> L63 SQLiteCantOpenDatabaseException -> L72
        qValues.put("added_ts", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L51 Exception -> L53 SQLiteException -> L63 SQLiteCantOpenDatabaseException -> L72
        long row = db2.insert(AuditDbHelper.TABLE_UPLOAD_QUEUE, null, qValues);     // Catch: Throwable -> L51 Exception -> L53 SQLiteException -> L63 SQLiteCantOpenDatabaseException -> L72
        if (row != (-1)) goto L44;
        Log.w(TAG, "insertEntryWithResult: insert queue failed");     // Catch: Throwable -> L51 Exception -> L53 SQLiteException -> L63 SQLiteCantOpenDatabaseException -> L72
        if (db2 != null) goto L96;
    L43:
        return 6;
    L96:
        db2.endTransaction();     // Catch: Exception -> L41
    L41:
        end = move-exception;
        Log.w(TAG, "insertEntryWithResult: endTransaction failed", end);
    L51:
        end = move-exception;
        if (0 == 0) goto L102;
        db.endTransaction();     // Catch: Exception -> L84
        throw end;
    L84:
        end = move-exception;
        Log.w(TAG, "insertEntryWithResult: endTransaction failed", end);
        throw end;
    L102:
        throw end;
    L63:
        e = move-exception;
        Log.e(TAG, "insertEntryWithResult: sqlite exception", e);     // Catch: Throwable -> L51
        if (0 != 0) goto L89;
    L71:
        return 6;
    L89:
        db.endTransaction();     // Catch: Exception -> L69
    L69:
        end = move-exception;
        Log.w(TAG, "insertEntryWithResult: endTransaction failed", end);
    L72:
        e = move-exception;
        Log.e(TAG, "insertEntryWithResult: cannot open database", e);     // Catch: Throwable -> L51
        if (0 != 0) goto L87;
    L80:
        return 6;
    L87:
        db.endTransaction();     // Catch: Exception -> L78
    L78:
        end = move-exception;
        Log.w(TAG, "insertEntryWithResult: endTransaction failed", end);
    L53:
        e = move-exception;
        Log.e(TAG, "insertEntryWithResult: unexpected exception", e);     // Catch: Throwable -> L51
        if (0 == 0) goto L104;
        db.endTransaction();     // Catch: Exception -> L59
        return 100;
    L59:
        end = move-exception;
        Log.w(TAG, "insertEntryWithResult: endTransaction failed", end);
        return 100;
    L104:
        return 100;
    }

    public int insertEntrySync(AuditLogEntry entry) {
        return insertEntryWithResult(entry);
    }

    public String buildPendingUploadReport(int maxCount, int maxBytes) {
        String r5 = null;
        if (shouldDegradeForLowStorage("buildPendingUploadReport") == false) goto L5;
        return null;
    L5:
        SQLiteDatabase db = null;
        Cursor c = null;
        db = this.mDbHelper.getWritableDatabase();     // Catch: Throwable -> L149 Exception -> L151
        db.beginTransaction();     // Catch: Throwable -> L145 Exception -> L147
        c = db.rawQuery("SELECT q.log_id, l.instruction_id, l.ts, l.device_id, l.uid, l.target_package, l.leaf_hash, l.payload_encrypted FROM upload_queue q JOIN audit_logs l ON q.log_id = l.id WHERE q.status = ? ORDER BY q.added_ts ASC LIMIT " + maxCount, new String[]{String.valueOf(0)});     // Catch: Throwable -> L145 Exception -> L147
        String batchId = UUID.randomUUID().toString();     // Catch: Throwable -> L140 Exception -> L142
        long reportTime = System.currentTimeMillis();     // Catch: Throwable -> L140 Exception -> L142
        JSONArray records = new JSONArray();     // Catch: Throwable -> L140 Exception -> L142
        List<String> leafHashes = new ArrayList();     // Catch: Throwable -> L140 Exception -> L142
        long totalBytes = 0;
        int count = 0;
    L11:
        String r18 = r5;
        if (c.moveToNext() == false) goto L61;
        byte[] enc = c.getBlob(7);     // Catch: Exception -> L58 Throwable -> L149
        if (enc == null) goto L19;
        byte[] enc2 = enc;
        int r0 = enc2.length;     // Catch: Exception -> L58 Throwable -> L149
    L20:
        int size = r0;
        if (maxBytes <= 0) goto L26;
        int size2 = size;
        if ((totalBytes + ((long) size2)) <= maxBytes) goto L198;
        if (count > 0) goto L61;
    L198:
        long itemTs = c.getLong(2);     // Catch: Exception -> L54 Throwable -> L149
        String itemInstructionId = c.getString(1);     // Catch: Exception -> L54 Throwable -> L149
        JSONObject item = new JSONObject();     // Catch: Exception -> L54 Throwable -> L149
        long reportTime2 = reportTime;
        int count2 = count;
        long reportTime3 = c.getLong(0);     // Catch: Exception -> L52 Throwable -> L149
        item.put("log_id", reportTime3);     // Catch: Exception -> L52 Throwable -> L149
        item.put("instruction_id", itemInstructionId);     // Catch: Exception -> L52 Throwable -> L149
        item.put("ts", itemTs);     // Catch: Exception -> L52 Throwable -> L149
        item.put("device_id", c.getString(3));     // Catch: Exception -> L52 Throwable -> L149
        item.put("uid", c.getString(4));     // Catch: Exception -> L52 Throwable -> L149
        item.put(ObricActivityTaskManagerServiceImpl.TARGET_PACKAGE, c.getString(5));     // Catch: Exception -> L52 Throwable -> L149
        if (enc2 != null) goto L33;
    L35:
        String leaf = c.getString(6);     // Catch: Exception -> L52 Throwable -> L149
        if (leaf != null) goto L38;
    L39:
        if (enc2 == null) goto L42;
        leaf = MerkleIntegrityManager.computeLeafHash(itemTs, itemInstructionId, enc2);     // Catch: Exception -> L52 Throwable -> L149
    L42:
        String r12 = "";
        if (leaf != null) goto L45;
        String r1 = "";
    L46:
        item.put("leaf_hash", r1);     // Catch: Exception -> L52 Throwable -> L149
        if (leaf == null) goto L50;
        r12 = leaf;
    L50:
        leafHashes.add(r12);     // Catch: Exception -> L52 Throwable -> L149
        records.put(item);     // Catch: Exception -> L52 Throwable -> L149
        totalBytes = totalBytes + ((long) size2);
        count = count2 + 1;
    L57:
        r5 = r18;
        reportTime = reportTime2;
        goto L11
    L45:
        r1 = leaf;
        goto L46
    L38:
        if (leaf.isEmpty() == false) goto L42;
    L33:
        if (enc2.length <= 0) goto L35;
        item.put(KEY_PAYLOAD_ENCRYPTED, new String(enc2, StandardCharsets.UTF_8));     // Catch: Exception -> L52 Throwable -> L149
    L52:
        e = e;
    L56:
        Log.w(TAG, "buildPendingUploadReport: build record failed", e);     // Catch: Exception -> L58 Throwable -> L149
        count = count2;
    L54:
        e = e;
        reportTime2 = reportTime;
        count2 = count;
        goto L56
    L26:
        size2 = size;
        goto L198
    L19:
        enc2 = enc;
        r0 = 0;
    L58:
        e = e;
    L154:
        Log.e(TAG, "buildPendingUploadReport failed", e);     // Catch: Throwable -> L149
        if (c == null) goto L157;
        c.close();
    L157:
        if (db != null) goto L171;
    L162:
        return r18;
    L171:
        db.endTransaction();     // Catch: Exception -> L160
    L160:
        e = move-exception;
        Log.w(TAG, "buildPendingUploadReport: endTransaction failed", e);
    L61:
        if (count != 0) goto L71;
        db.setTransactionSuccessful();     // Catch: Exception -> L58 Throwable -> L149
        if (c == null) goto L65;
        c.close();
    L65:
        if (db != null) goto L184;
    L70:
        return r18;
    L184:
        db.endTransaction();     // Catch: Exception -> L68
    L68:
        e = move-exception;
        Log.w(TAG, "buildPendingUploadReport: endTransaction failed", e);
        goto L70
    L71:
        int i = 0;
    L190:
    L138:
        e = e;
        goto L154
    L74:
        if (i >= records.length()) goto L85;
        long logId = records.getJSONObject(i).getLong("log_id");     // Catch: Exception -> L81 Throwable -> L149
        ContentValues cv = new ContentValues();     // Catch: Exception -> L81 Throwable -> L149
        cv.put("status", 1);     // Catch: Exception -> L79 Throwable -> L149
        cv.put("batch_id", batchId);     // Catch: Exception -> L79 Throwable -> L149
        db.update(AuditDbHelper.TABLE_UPLOAD_QUEUE, cv, "log_id=?", new String[]{String.valueOf(logId)});     // Catch: Exception -> L79 Throwable -> L149
    L84:
        i = i + 1;
    L79:
        e = e;
    L83:
        Log.w(TAG, "buildPendingUploadReport: update status failed", e);     // Catch: Exception -> L58 Throwable -> L149
    L81:
        e = e;
        goto L83
    L85:
        JSONObject report = new JSONObject();     // Catch: Exception -> L138 Throwable -> L140
        report.put("batch_id", batchId);     // Catch: Exception -> L138 Throwable -> L140
        report.put("report_time", reportTime);     // Catch: Exception -> L138 Throwable -> L140
        report.put("version", 4);     // Catch: Exception -> L138 Throwable -> L140
        MerkleIntegrityManager integrity = this.mIntegrityManager;     // Catch: Exception -> L138 Throwable -> L140
        if (integrity != null) goto L181;
        SQLiteDatabase db2 = db;
        Cursor c2 = c;
    L125:
        report.put("records", records);     // Catch: Throwable -> L134 Exception -> L136
        db2.setTransactionSuccessful();     // Catch: Throwable -> L134 Exception -> L136
        String r2 = report.toString();     // Catch: Throwable -> L134 Exception -> L136
        if (c2 == null) goto L128;
        c2.close();
    L128:
        if (db2 != null) goto L173;
    L133:
        return r2;
    L173:
        db2.endTransaction();     // Catch: Exception -> L131
    L131:
        e = move-exception;
        Log.w(TAG, "buildPendingUploadReport: endTransaction failed", e);
        goto L133
    L134:
        th = move-exception;
        Exception e = th;
        db = db2;
        c = c2;
    L163:
        if (c == null) goto L165;
        c.close();
    L165:
        if (db == null) goto L215;
        db.endTransaction();     // Catch: Exception -> L168
        throw e;
    L168:
        e = move-exception;
        Log.w(TAG, "buildPendingUploadReport: endTransaction failed", e);
        throw e;
    L215:
        throw e;
    L136:
        e = e;
        db = db2;
        c = c2;
        goto L154
    L181:
        MerkleIntegrityManager.SignedBlock signed = integrity.buildAndSign(db, leafHashes);     // Catch: Exception -> L121 Throwable -> L140
        if (signed != null) goto L91;
        db2 = db;
        c2 = c;
        goto L125
    L91:
        db2 = db;
        report.put("block_seq", signed.blockSeq);     // Catch: Throwable -> L115 Exception -> L117
        report.put("block_hash", signed.blockHash);     // Catch: Throwable -> L115 Exception -> L117
        report.put("prev_hash", signed.prevHash);     // Catch: Throwable -> L115 Exception -> L117
        report.put("merkle_root", signed.merkleRoot);     // Catch: Throwable -> L115 Exception -> L117
        if (signed.signature != null) goto L200;
    L100:
        String certChain = integrity.getCertChainBase64();     // Catch: Throwable -> L115 Exception -> L117
        if (certChain == null) goto L103;
        report.put("device_cert_chain", certChain);     // Catch: Throwable -> L96 Exception -> L98
    L98:
        e = e;
        c2 = c;
    L193:
        Log.w(TAG, "buildPendingUploadReport: integrity sign failed (degrade)", e);     // Catch: Throwable -> L134 Exception -> L136
    L96:
        th = move-exception;
        e = th;
        db = db2;
    L103:
        int i2 = 0;
    L105:
        if (i2 >= records.length()) goto L114;
        if (i2 >= signed.proofPaths.size()) goto L114;
        String certChain2 = certChain;
        c2 = c;
        records.getJSONObject(i2).put("proof_path", new JSONArray(signed.proofPaths.get(i2)));     // Catch: Exception -> L112 Throwable -> L134
        i2 = i2 + 1;
        certChain = certChain2;
        c = c2;
    L112:
        e = e;
        goto L193
    L114:
        c2 = c;
        goto L125
    L200:
        report.put("signature", Base64.encodeToString(signed.signature, 2));     // Catch: Throwable -> L96 Exception -> L98
    L117:
        e = e;
        c2 = c;
    L115:
        th = move-exception;
        e = th;
        db = db2;
        goto L163
    L121:
        e = e;
        db2 = db;
        c2 = c;
    L140:
        th = move-exception;
        e = th;
    L142:
        e = e;
        r18 = r5;
        goto L154
    L147:
        e = e;
        r18 = null;
    L145:
        th = move-exception;
        e = th;
    L151:
        e = e;
        r18 = null;
    L149:
        th = move-exception;
        e = th;
        goto L163
    }

    public int confirmUploadSuccess(String batchId) {
        if (TextUtils.isEmpty(batchId) == false) goto L7;
        return 4;
    L7:
        if (shouldDegradeForLowStorage("confirmUploadSuccess") == false) goto L9;
        return 6;
    L9:
        SQLiteDatabase db = null;
        db = this.mDbHelper.getWritableDatabase();     // Catch: Throwable -> L18 Exception -> L20
        db.beginTransaction();     // Catch: Throwable -> L18 Exception -> L20
        ContentValues cv = new ContentValues();     // Catch: Throwable -> L18 Exception -> L20
        cv.put("status", 2);     // Catch: Throwable -> L18 Exception -> L20
        db.update(AuditDbHelper.TABLE_UPLOAD_QUEUE, cv, "batch_id=? AND status=?", new String[]{batchId, String.valueOf(1)});     // Catch: Throwable -> L18 Exception -> L20
        db.setTransactionSuccessful();     // Catch: Throwable -> L18 Exception -> L20
        if (db == null) goto L42;
        db.endTransaction();     // Catch: Exception -> L14
        return 0;
    L14:
        e = move-exception;
        Log.w(TAG, "confirmUploadSuccess: endTransaction failed", e);
        return 0;
    L42:
        return 0;
    L18:
        th = move-exception;
        if (db != null) goto L37;
    L33:
        throw th;
    L37:
        db.endTransaction();     // Catch: Exception -> L31
    L31:
        e = move-exception;
        Log.w(TAG, "confirmUploadSuccess: endTransaction failed", e);
    L20:
        e = move-exception;
        Log.e(TAG, "confirmUploadSuccess failed", e);     // Catch: Throwable -> L18
        if (db != null) goto L35;
    L27:
        return 6;
    L35:
        db.endTransaction();     // Catch: Exception -> L25
    L25:
        e = move-exception;
        Log.w(TAG, "confirmUploadSuccess: endTransaction failed", e);
        goto L27
    }

    public int confirmUploadFailure(String batchId, int errorCode) {
        if (TextUtils.isEmpty(batchId) == false) goto L7;
        return 4;
    L7:
        if (shouldDegradeForLowStorage("confirmUploadFailure") == false) goto L9;
        return 6;
    L9:
        SQLiteDatabase db = null;
        db = this.mDbHelper.getWritableDatabase();     // Catch: Throwable -> L17 Exception -> L19
        db.beginTransaction();     // Catch: Throwable -> L17 Exception -> L19
        db.execSQL("UPDATE upload_queue SET status = ?, retry_count = retry_count + 1 WHERE batch_id = ? AND status = ? AND retry_count < ?", new Object[]{0, batchId, 1, 5});     // Catch: Throwable -> L17 Exception -> L19
        db.execSQL("UPDATE upload_queue SET status = ? WHERE batch_id = ? AND status = ? AND retry_count >= ?", new Object[]{3, batchId, 1, 5});     // Catch: Throwable -> L17 Exception -> L19
        db.setTransactionSuccessful();     // Catch: Throwable -> L17 Exception -> L19
        if (db != null) goto L37;
    L16:
        return 0;
    L37:
        db.endTransaction();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Log.w(TAG, "confirmUploadFailure: endTransaction failed", e);
        goto L16
    L19:
        e = move-exception;
        Log.e(TAG, "confirmUploadFailure failed", e);     // Catch: Throwable -> L17
        if (db != null) goto L35;
    L26:
        return 6;
    L35:
        db.endTransaction();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        Log.w(TAG, "confirmUploadFailure: endTransaction failed", e);
    L17:
        th = move-exception;
        if (db != null) goto L39;
    L32:
        throw th;
    L39:
        db.endTransaction();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        Log.w(TAG, "confirmUploadFailure: endTransaction failed", e);
        goto L32
    }

    private ContentValues entryToContentValues(AuditLogEntry entry) {
        ContentValues cv = new ContentValues();
        cv.put("ts", Long.valueOf(entry.ts));
        cv.put("payload_format", Integer.valueOf(entry.payloadFormat));
        cv.put("payload_raw", entry.payloadRaw);
        cv.put(KEY_PAYLOAD_ENCRYPTED, entry.payloadEncrypted);
        cv.put(ObricActivityTaskManagerServiceImpl.TARGET_PACKAGE, entry.targetPackage);
        cv.put("instruction_id", entry.instructionId);
        cv.put("device_id", entry.deviceId);
        cv.put("uid", entry.uid);
        cv.put("is_agent_related", Integer.valueOf(entry.isAgentRelated));
        cv.put(ObricActivityTaskManagerServiceImpl.LOG_SOURCE, entry.logSource);
        cv.put("timestamp_str", entry.timestampStr);
        cv.put(ObricActivityTaskManagerServiceImpl.TARGET_ACTIVITY, entry.targetActivity);
        cv.put("intent_type", entry.intentType);
        cv.put(ObricActivityTaskManagerServiceImpl.AGENT_NAME, entry.agentName);
        if (entry.payloadEncrypted == null) goto L5;
        byte[] leafSrc = entry.payloadEncrypted;
    L6:
        cv.put("leaf_hash", MerkleIntegrityManager.computeLeafHash(entry.ts, entry.instructionId, leafSrc));
        return cv;
    L5:
        leafSrc = entry.payloadRaw;
        goto L6
    }
}
