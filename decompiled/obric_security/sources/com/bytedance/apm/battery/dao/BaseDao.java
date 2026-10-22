package com.bytedance.apm.battery.dao;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.logging.DebugLogger;
import com.bytedance.apm.logging.Logger;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseDao<T> {
    protected static final int SINGLE_BATCH_SIZE = 50;
    private final String mAuthority;
    private final HashMap<String, Integer> mColumnIndex;
    private final Context mContext;
    private String mSqlGetTotalCountClause;
    private Uri mUri;

    /* JADX INFO: renamed from: com.bytedance.apm.battery.dao.BaseDao$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface CursorGetter<T> {
        T get(CursorWrapper r1);
    }

    public static class CursorWrapper {
        private final HashMap<String, Integer> mColumnIndex;
        Cursor mCursor;

        /* synthetic */ CursorWrapper(Cursor r1, HashMap r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private CursorWrapper(Cursor r1, HashMap<String, Integer> r2) {
            this.mCursor = r1;
            this.mColumnIndex = r2;
        }

        public long getLong(String r2) {
            return this.mCursor.getLong(getIndex(r2));
        L4:
            return -1;
        }

        public int getInt(String r2) {
            return this.mCursor.getInt(getIndex(r2));
        L4:
            return -1;
        }

        public String getString(String r2) {
            return this.mCursor.getString(getIndex(r2));
        L4:
            return "";
        }

        public double getDouble(String r2) {
            return this.mCursor.getDouble(getIndex(r2));
        L4:
            return -1.0d;
        }

        public float getFloat(String r2) {
            return this.mCursor.getFloat(getIndex(r2));
        L4:
            return -1.0f;
        }

        public short getShort(String r2) {
            return this.mCursor.getShort(getIndex(r2));
        L4:
            return -1;
        }

        public byte[] getBlob(String r2) {
            return this.mCursor.getBlob(getIndex(r2));
        L5:
            return new byte[0];
        }

        private int getIndex(String r2) {
            Integer r0 = this.mColumnIndex.get(r2);
            if (r0 != null) goto L9;
            r0 = Integer.valueOf(this.mCursor.getColumnIndex(r2));     // Catch: Throwable -> L6
        L7:
            this.mColumnIndex.put(r2, r0);
        L6:
            r0 = -1;
        L9:
            return r0.intValue();
        }
    }

    public abstract String[] getColumns();

    public abstract ContentValues getContentValues(T r1);

    public String getDbName() {
        return DBHelper.DB_NAME;
    }

    public abstract String getTableName();

    public boolean isWeedTakenOver() {
        return true;
    }

    protected BaseDao() {
        this.mColumnIndex = new HashMap();
        Context r0 = ApmContext.getContext();
        this.mContext = r0;
        this.mAuthority = r0.getPackageName() + ".apm";
    }

    protected String getDbPath() {
        return ApmContext.getContext().getDatabasePath(getDbName()).getAbsolutePath();
    }

    public Uri getUri() {
        if (this.mUri != null) goto L6;
        this.mUri = Uri.parse("content://" + this.mAuthority + LibrarianImpl.Constants.SEPARATOR + getDbName() + LibrarianImpl.Constants.SEPARATOR + getTableName());
    L6:
        return this.mUri;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<T> query(String r9, String[] r10, String r11, CursorGetter<T> r12) {
        Cursor r0 = null;
        Object[] r1 = 0;
        Cursor r13 = this.mContext.getContentResolver().query(getUri(), getColumns(), r9, r10, r11);     // Catch: Throwable -> L31
        if (r13 != null) goto L32;
    L25:
        List<T> r8 = Collections.emptyList();     // Catch: Throwable -> L28
        safeCloseCursor(r13);
        return r8;
    L32:
    L28:
        r0 = r13;
        goto L29
    L6:
        if (r13.getCount() <= 0) goto L25;
        if (TextUtils.isEmpty(r11) == true) goto L16;
        int r14 = r11.indexOf("LIMIT");     // Catch: Throwable -> L28
        if (r14 <= 0) goto L16;
        int r2 = r11.indexOf("OFF");     // Catch: Throwable -> L28
        if (r2 <= 0) goto L15;
        int r15 = Integer.valueOf(r11.substring(r14 + 5, r2).trim()).intValue();     // Catch: Throwable -> L28
    L17:
        LinkedList r16 = new LinkedList();     // Catch: Throwable -> L28
        int r3 = 0;
    L19:
        if (r13.moveToNext() == false) goto L23;
        if (r3 >= r15) goto L23;
        r16.add(r12.get(new CursorWrapper(r13, this.mColumnIndex, r1 == true ? 1 : 0)));     // Catch: Throwable -> L28
        r3 = r3 + 1;
    L23:
        safeCloseCursor(r13);
        return r16;
    L15:
        r15 = Integer.valueOf(r11.substring(r14 + 5).trim()).intValue();     // Catch: Throwable -> L28
    L16:
        r15 = Integer.MAX_VALUE;
    L29:
        safeCloseCursor(r0);
        return Collections.emptyList();
    }

    public int update(ContentValues r3, String r4, String[] r5) {
        if (r3 != null) goto L8;
        return -1;
    L8:
        return ApmContext.getContext().getContentResolver().update(getUri(), r3, r4, r5);
    L7:
        return -1;
    }

    public synchronized <I extends T> long insert(ContentValues r5) {
        monitor-enter(this);
        if (r5 != null) goto L22;
        monitor-exit(this);
        return -1;
    L22:
        Uri r6 = ApmContext.getContext().getContentResolver().insert(getUri(), r5);     // Catch: Throwable -> L17 Exception -> L20
        if (r6 != null) goto L25;
        monitor-exit(this);
        return -1;
    L25:
        long r0 = Long.parseLong(r6.getLastPathSegment());     // Catch: Exception -> L14 Throwable -> L17
        monitor-exit(this);
        return r0;
    L15:
        return 1;
    L17:
        th = move-exception;
        throw th;
    L21:
        return -1;
    }

    public synchronized void insertBatch(List<ContentValues> r11) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (ListUtils.isEmpty(r11) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        int r0 = r11.size();     // Catch: Throwable -> L23
        int r2 = 0;
    L8:
        if (r2 >= r0) goto L21;
        ArrayList<ContentProviderOperation> r3 = new ArrayList(8);     // Catch: Throwable -> L23
        int r4 = 0;
    L11:
        if (r4 >= 50) goto L29;
        if (r2 >= r0) goto L29;
        ContentProviderOperation.Builder r5 = ContentProviderOperation.newInsert(getUri());     // Catch: Throwable -> L23
        r5.withValues(r11.get(r2));     // Catch: Throwable -> L23
        r3.add(r5.build());     // Catch: Throwable -> L23
        r2 = r2 + 1;
        r4 = r4 + 1;
    L29:
        ContentProviderResult[] r6 = ApmContext.getContext().getContentResolver().applyBatch(this.mAuthority, r3);     // Catch: Throwable -> L26
        if (ApmContext.isDebugMode() == false) goto L8;
        int r7 = r6.length;     // Catch: Throwable -> L26
        int r8 = 0;
    L18:
        if (r8 >= r7) goto L8;
        Logger.i(DebugLogger.TAG_STORE, new String[]{"insertBatch ret: ", r6[r8].uri.toString()});     // Catch: Throwable -> L26
        r8 = r8 + 1;
        goto L18
    L21:
        monitor-exit(this);
    }

    public int delete(String r2, String[] r3) {
        return this.mContext.getContentResolver().delete(getUri(), r2, r3);
    L4:
        return -1;
    }

    public long getTotalRowCount() {
        return getCount(null, null);
    }

    private String getSqlTotalCountClause() {
        if (this.mSqlGetTotalCountClause != null) goto L6;
        this.mSqlGetTotalCountClause = "SELECT count(*) FROM " + getTableName();
    L6:
        return this.mSqlGetTotalCountClause;
    }

    public long getCount(String r7, String[] r8) {
        long r0 = -1;
        Cursor r2 = null;
        Context r3 = ApmContext.getContext();     // Catch: Throwable -> L14 Exception -> L17
        Uri r4 = getUri();     // Catch: Throwable -> L14 Exception -> L17
        if (r7 != null) goto L6;
        String r6 = getSqlTotalCountClause();     // Catch: Throwable -> L14 Exception -> L17
    L7:
        r2 = MonitorContentProvider.rawQueryForResolver(r3, r4, r6, r8);     // Catch: Throwable -> L14 Exception -> L17
        if (r2 != null) goto L10;
    L12:
        safeCloseCursor(r2);
        return r0;
    L10:
        if (r2.moveToNext() == false) goto L12;
        r0 = r2.getLong(0);     // Catch: Throwable -> L14 Exception -> L17
    L6:
        r6 = getSqlTotalCountClause() + " where " + r7;     // Catch: Throwable -> L14 Exception -> L17
    L17:
        safeCloseCursor(r2);
        return -1;
    L14:
        th = move-exception;
        safeCloseCursor(r2);
        throw th;
    }

    public void execSql(String r2) {
        MonitorContentProvider.execSQLForResolver(this.mContext, getUri(), r2);
    }

    private static void safeCloseCursor(Cursor r1) {
        if (r1 == null) goto L10;
        if (r1.isClosed() == true) goto L11;
        r1.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }
}
