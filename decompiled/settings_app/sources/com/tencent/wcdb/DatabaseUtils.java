package com.tencent.wcdb;

import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.wcdb.database.SQLiteAbortException;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteConstraintException;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDiskIOException;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteFullException;
import com.tencent.wcdb.database.SQLiteProgram;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.OperationCanceledException;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes5.dex */
public final class DatabaseUtils {
    private static final boolean DEBUG = false;
    private static final char[] DIGITS = null;
    private static final int EX_HAS_REPLY_HEADER = -128;
    public static final int STATEMENT_ABORT = 6;
    public static final int STATEMENT_ATTACH = 3;
    public static final int STATEMENT_BEGIN = 4;
    public static final int STATEMENT_COMMIT = 5;
    public static final int STATEMENT_DDL = 8;
    public static final int STATEMENT_OTHER = 99;
    public static final int STATEMENT_PRAGMA = 7;
    public static final int STATEMENT_SELECT = 1;
    public static final int STATEMENT_UNPREPARED = 9;
    public static final int STATEMENT_UPDATE = 2;
    private static final String TAG = "WCDB.DatabaseUtils";
    private static Collator mColl;

    @Deprecated
    public static class InsertHelper {
        public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
        private HashMap<String, Integer> mColumns;
        private final SQLiteDatabase mDb;
        private String mInsertSQL;
        private SQLiteStatement mInsertStatement;
        private SQLiteStatement mPreparedStatement;
        private SQLiteStatement mReplaceStatement;
        private final String mTableName;

        public InsertHelper(SQLiteDatabase r2, String r3) {
            this.mInsertSQL = null;
            this.mInsertStatement = null;
            this.mReplaceStatement = null;
            this.mPreparedStatement = null;
            this.mDb = r2;
            this.mTableName = r3;
        }

        private void buildSQL() throws SQLException {
            StringBuilder r3 = new StringBuilder(128);
            r3.append("INSERT INTO ");
            r3.append(this.mTableName);
            r3.append(" (");
            StringBuilder r5 = new StringBuilder(128);
            r5.append("VALUES (");
            Cursor r4 = null;
            r4 = this.mDb.rawQuery("PRAGMA table_info(" + this.mTableName + ")", null);     // Catch: Throwable -> L24
            this.mColumns = new HashMap(r4.getCount());     // Catch: Throwable -> L24
            int r6 = 1;
        L4:
            if (r4.moveToNext() == false) goto L20;
            String r7 = r4.getString(1);     // Catch: Throwable -> L24
            String r8 = r4.getString(4);     // Catch: Throwable -> L24
            this.mColumns.put(r7, Integer.valueOf(r6));     // Catch: Throwable -> L24
            r3.append("'");     // Catch: Throwable -> L24
            r3.append(r7);     // Catch: Throwable -> L24
            r3.append("'");     // Catch: Throwable -> L24
            if (r8 != null) goto L9;
            r5.append("?");     // Catch: Throwable -> L24
        L11:
            String r9 = ", ";
            if (r6 != r4.getCount()) goto L14;
            String r10 = ") ";
        L15:
            r3.append(r10);     // Catch: Throwable -> L24
            if (r6 != r4.getCount()) goto L18;
            r9 = ");";
        L18:
            r5.append(r9);     // Catch: Throwable -> L24
            r6 = r6 + 1;
            goto L4
        L14:
            r10 = ", ";
            goto L15
        L9:
            r5.append("COALESCE(?, ");     // Catch: Throwable -> L24
            r5.append(r8);     // Catch: Throwable -> L24
            r5.append(")");     // Catch: Throwable -> L24
            goto L11
        L20:
            if (r4 == null) goto L22;
            r4.close();
        L22:
            r3.append(r5);
            this.mInsertSQL = r3.toString();
            return;
        L24:
            th = move-exception;
            if (r4 == null) goto L27;
            r4.close();
        L27:
            throw th;
        }

        private SQLiteStatement getStatement(boolean r3) throws SQLException {
            if (r3 == false) goto L12;
            if (this.mReplaceStatement != null) goto L10;
            if (this.mInsertSQL != null) goto L8;
            buildSQL();
        L8:
            this.mReplaceStatement = this.mDb.compileStatement("INSERT OR REPLACE" + this.mInsertSQL.substring(6));
        L10:
            return this.mReplaceStatement;
        L12:
            if (this.mInsertStatement != null) goto L18;
            if (this.mInsertSQL != null) goto L16;
            buildSQL();
        L16:
            this.mInsertStatement = this.mDb.compileStatement(this.mInsertSQL);
        L18:
            return this.mInsertStatement;
        }

        private long insertInternal(ContentValues r4, boolean r5) {
            this.mDb.beginTransactionNonExclusive();
            SQLiteStatement r6 = getStatement(r5);     // Catch: Throwable -> L10 SQLException -> L12
            r6.clearBindings();     // Catch: Throwable -> L10 SQLException -> L12
            Iterator<Map.Entry<String, Object>> r0 = r4.valueSet().iterator();     // Catch: Throwable -> L10 SQLException -> L12
        L5:
            if (r0.hasNext() == false) goto L7;
            Map.Entry<String, Object> r1 = r0.next();     // Catch: Throwable -> L10 SQLException -> L12
            DatabaseUtils.bindObjectToProgram(r6, getColumnIndex(r1.getKey()), r1.getValue());     // Catch: Throwable -> L10 SQLException -> L12
            goto L5
        L7:
            long r2 = r6.executeInsert();     // Catch: Throwable -> L10 SQLException -> L12
            this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L10 SQLException -> L12
            this.mDb.endTransaction();
            return r2;
        L10:
            th = move-exception;
            this.mDb.endTransaction();
            throw th;
        L12:
            e = move-exception;
            Log.e(DatabaseUtils.TAG, "Error inserting " + r4 + " into table  " + this.mTableName, new Object[]{e});     // Catch: Throwable -> L10
            this.mDb.endTransaction();
            return -1;
        }

        public int getColumnIndex(String r3) {
            getStatement(false);
            Integer r2 = this.mColumns.get(r3);
            if (r2 == null) goto L7;
            return r2.intValue();
        L7:
            throw new IllegalArgumentException("column '" + r3 + "' is invalid");
        }

        public void bind(int r1, double r2) {
            this.mPreparedStatement.bindDouble(r1, r2);
        }

        public void bind(int r3, float r4) {
            this.mPreparedStatement.bindDouble(r3, r4);
        }

        public void bind(int r1, long r2) {
            this.mPreparedStatement.bindLong(r1, r2);
        }

        public void bind(int r3, int r4) {
            this.mPreparedStatement.bindLong(r3, r4);
        }

        public void bind(int r3, boolean r4) {
            SQLiteStatement r2 = this.mPreparedStatement;
            if (r4 == false) goto L5;
            long r0 = 1;
        L6:
            r2.bindLong(r3, r0);
            return;
        L5:
            r0 = 0;
            goto L6
        }

        public void bindNull(int r1) {
            this.mPreparedStatement.bindNull(r1);
        }

        public void bind(int r1, byte[] r2) {
            if (r2 != null) goto L4;
            this.mPreparedStatement.bindNull(r1);
            return;
        L4:
            this.mPreparedStatement.bindBlob(r1, r2);
        }

        public void bind(int r1, String r2) {
            if (r2 != null) goto L4;
            this.mPreparedStatement.bindNull(r1);
            return;
        L4:
            this.mPreparedStatement.bindString(r1, r2);
        }

        public long insert(ContentValues r2) {
            return insertInternal(r2, false);
        }

        public long execute() {
            SQLiteStatement r1 = this.mPreparedStatement;
            if (r1 == null) goto L17;
            long r0 = r1.executeInsert();     // Catch: Throwable -> L8 SQLException -> L10
            this.mPreparedStatement = null;
            return r0;
        L10:
            e = move-exception;
            Log.e(DatabaseUtils.TAG, "Error executing InsertHelper with table " + this.mTableName, new Object[]{e});     // Catch: Throwable -> L8
            this.mPreparedStatement = null;
            return -1;
        L8:
            th = move-exception;
            this.mPreparedStatement = null;
            throw th;
        L17:
            throw new IllegalStateException("you must prepare this inserter before calling execute");
        }

        public void prepareForInsert() {
            SQLiteStatement r0 = getStatement(false);
            this.mPreparedStatement = r0;
            r0.clearBindings();
        }

        public void prepareForReplace() {
            SQLiteStatement r0 = getStatement(true);
            this.mPreparedStatement = r0;
            r0.clearBindings();
        }

        public long replace(ContentValues r2) {
            return insertInternal(r2, true);
        }

        public void close() {
            SQLiteStatement r0 = this.mInsertStatement;
            if (r0 == null) goto L5;
            r0.close();
            this.mInsertStatement = null;
        L5:
            SQLiteStatement r1 = this.mReplaceStatement;
            if (r1 == null) goto L8;
            r1.close();
            this.mReplaceStatement = null;
        L8:
            this.mInsertSQL = null;
            this.mColumns = null;
        }
    }

    public DatabaseUtils() {
    }

    public static boolean objectEquals(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    public static final void writeExceptionToParcel(Parcel r6, Exception r7) {
        if ((r7 instanceof FileNotFoundException) == false) goto L6;
        boolean r5 = false;
        int r0 = 1;
    L36:
        r6.writeInt(r0);
        r6.writeString(r7.getMessage());
        if (r5 == false) goto L42;
        Log.e(TAG, "Writing exception to parcel", new Object[]{r7});
        return;
    L42:
        return;
    L6:
        if ((r7 instanceof IllegalArgumentException) == false) goto L10;
        r0 = 2;
    L8:
        r5 = true;
        goto L36
    L10:
        if ((r7 instanceof UnsupportedOperationException) == false) goto L13;
        r0 = 3;
        goto L8
    L13:
        if ((r7 instanceof SQLiteAbortException) == false) goto L16;
        r0 = 4;
        goto L8
    L16:
        if ((r7 instanceof SQLiteConstraintException) == false) goto L19;
        r0 = 5;
        goto L8
    L19:
        if ((r7 instanceof SQLiteDatabaseCorruptException) == false) goto L22;
        r0 = 6;
        goto L8
    L22:
        if ((r7 instanceof SQLiteFullException) == false) goto L25;
        r0 = 7;
        goto L8
    L25:
        if ((r7 instanceof SQLiteDiskIOException) == false) goto L28;
        r0 = 8;
        goto L8
    L28:
        if ((r7 instanceof SQLiteException) == false) goto L31;
        r0 = 9;
        goto L8
    L31:
        if ((r7 instanceof OperationApplicationException) == false) goto L34;
        r0 = 10;
        goto L8
    L34:
        if ((r7 instanceof OperationCanceledException) == false) goto L40;
        r0 = 11;
        r5 = false;
        goto L36
    L40:
        r6.writeException(r7);
        Log.e(TAG, "Writing exception to parcel", new Object[]{r7});
    }

    private static final int readExceptionCode(Parcel r2) {
        int r0 = r2.readInt();
        if (r0 == EX_HAS_REPLY_HEADER) goto L5;
        return r0;
    L5:
        if (r2.readInt() != 0) goto L10;
        Log.e(TAG, "Unexpected zero-sized Parcel reply header.");
        return 0;
    L10:
        return 0;
    }

    public static final void readExceptionFromParcel(Parcel r2) {
        int r0 = readExceptionCode(r2);
        if (r0 != 0) goto L5;
        return;
    L5:
        readExceptionFromParcel(r2, r2.readString(), r0);
    }

    public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel r3) throws FileNotFoundException {
        int r0 = readExceptionCode(r3);
        if (r0 != 0) goto L5;
        return;
    L5:
        String r1 = r3.readString();
        if (r0 == 1) goto L10;
        readExceptionFromParcel(r3, r1, r0);
        return;
    L10:
        throw new FileNotFoundException(r1);
    }

    public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel r3) throws OperationApplicationException {
        int r0 = readExceptionCode(r3);
        if (r0 != 0) goto L5;
        return;
    L5:
        String r1 = r3.readString();
        if (r0 == 10) goto L10;
        readExceptionFromParcel(r3, r1, r0);
        return;
    L10:
        throw new OperationApplicationException(r1);
    }

    private static final void readExceptionFromParcel(Parcel r0, String r1, int r2) {
        switch(r2) {
            case 2: goto L22;
            case 3: goto L20;
            case 4: goto L18;
            case 5: goto L16;
            case 6: goto L14;
            case 7: goto L12;
            case 8: goto L10;
            case 9: goto L8;
            case 10: goto L3;
            case 11: goto L6;
            default: goto L3;
        };
    L3:
        r0.readException(r2, r1);
        return;
    L6:
        throw new OperationCanceledException(r1);
    L8:
        throw new SQLiteException(r1);
    L10:
        throw new SQLiteDiskIOException(r1);
    L12:
        throw new SQLiteFullException(r1);
    L14:
        throw new SQLiteDatabaseCorruptException(r1);
    L16:
        throw new SQLiteConstraintException(r1);
    L18:
        throw new SQLiteAbortException(r1);
    L20:
        throw new UnsupportedOperationException(r1);
    L22:
        throw new IllegalArgumentException(r1);
    }

    public static void bindObjectToProgram(SQLiteProgram r2, int r3, Object r4) {
        if (r4 != null) goto L5;
        r2.bindNull(r3);
        return;
    L5:
        if ((r4 instanceof Double) == false) goto L7;
    L22:
        r2.bindDouble(r3, ((Number) r4).doubleValue());
        return;
    L7:
        if ((r4 instanceof Float) == true) goto L22;
        if ((r4 instanceof Number) == false) goto L13;
        r2.bindLong(r3, ((Number) r4).longValue());
        return;
    L13:
        if ((r4 instanceof Boolean) == false) goto L19;
        if (((Boolean) r4).booleanValue() == false) goto L17;
        r2.bindLong(r3, 1);
        return;
    L17:
        r2.bindLong(r3, 0);
        return;
    L19:
        if ((r4 instanceof byte[]) == false) goto L21;
        r2.bindBlob(r3, (byte[]) r4);
        return;
    L21:
        r2.bindString(r3, r4.toString());
    }

    public static int getTypeOfObject(Object r1) {
        if (r1 != null) goto L6;
        return 0;
    L6:
        if ((r1 instanceof byte[]) == false) goto L10;
        return 4;
    L10:
        if ((r1 instanceof Float) == false) goto L12;
        return 2;
    L12:
        if ((r1 instanceof Double) == false) goto L15;
        return 2;
    L15:
        if ((r1 instanceof Long) == false) goto L17;
        return 1;
    L17:
        if ((r1 instanceof Integer) == false) goto L19;
        return 1;
    L19:
        if ((r1 instanceof Short) == false) goto L21;
        return 1;
    L21:
        if ((r1 instanceof Byte) == true) goto L31;
        return 3;
    L31:
        return 1;
    }

    public static void cursorFillWindow(Cursor r5, int r6, CursorWindow r7) {
        if (r6 >= 0) goto L4;
        return;
    L4:
        if (r6 >= r5.getCount()) goto L45;
        int r0 = r5.getPosition();
        int r1 = r5.getColumnCount();
        r7.clear();
        r7.setStartPosition(r6);
        r7.setNumColumns(r1);
        if (r5.moveToPosition(r6) == true) goto L9;
    L37:
        r5.moveToPosition(r0);
        return;
    L9:
        if (r7.allocRow() == false) goto L37;
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L35;
        int r3 = r5.getType(r2);
        if (r3 != 0) goto L16;
        boolean r4 = r7.putNull(r6, r2);
    L32:
        if (r4 == false) goto L33;
        r2 = r2 + 1;
        goto L12
    L33:
        r7.freeLastRow();
        goto L35
    L16:
        if (r3 != 1) goto L18;
        r4 = r7.putLong(r5.getLong(r2), r6, r2);
        goto L32
    L18:
        if (r3 != 2) goto L20;
        r4 = r7.putDouble(r5.getDouble(r2), r6, r2);
        goto L32
    L20:
        if (r3 == 4) goto L25;
        String r8 = r5.getString(r2);
        if (r8 == null) goto L24;
        r4 = r7.putString(r8, r6, r2);
        goto L32
    L24:
        r4 = r7.putNull(r6, r2);
        goto L32
    L25:
        byte[] r9 = r5.getBlob(r2);
        if (r9 == null) goto L28;
        r4 = r7.putBlob(r9, r6, r2);
        goto L32
    L28:
        r4 = r7.putNull(r6, r2);
    L35:
        r6 = r6 + 1;
        if (r5.moveToNext() == true) goto L9;
    }

    public static void appendEscapedSQLString(StringBuilder r4, String r5) {
        r4.append('\'');
        if (r5.indexOf(39) == (-1)) goto L10;
        int r1 = r5.length();
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L11;
        char r3 = r5.charAt(r2);
        if (r3 != '\'') goto L9;
        r4.append('\'');
    L9:
        r4.append(r3);
        r2 = r2 + 1;
    L11:
        r4.append('\'');
        return;
    L10:
        r4.append(r5);
        goto L11
    }

    public static String sqlEscapeString(String r1) {
        StringBuilder r0 = new StringBuilder();
        appendEscapedSQLString(r0, r1);
        return r0.toString();
    }

    public static final void appendValueToSql(StringBuilder r1, Object r2) {
        if (r2 != null) goto L5;
        r1.append("NULL");
        return;
    L5:
        if ((r2 instanceof Boolean) == true) goto L7;
        appendEscapedSQLString(r1, r2.toString());
        return;
    L7:
        if (((Boolean) r2).booleanValue() == false) goto L9;
        r1.append('1');
        return;
    L9:
        r1.append('0');
    }

    public static String concatenateWhere(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return r3;
    L6:
        if (TextUtils.isEmpty(r3) == false) goto L9;
        return r2;
    L9:
        return "(" + r2 + ") AND (" + r3 + ")";
    }

    public static String getCollationKey(String r4) {
        byte[] r5 = getCollationKeyInBytes(r4);
        return new String(r5, 0, getKeyLen(r5), "ISO8859_1");
    L5:
        return "";
    }

    static {
        DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        mColl = null;
    }

    private static char[] encodeHex(byte[] r8) {
        int r0 = r8.length;
        char[] r1 = new char[r0 << 1];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        int r4 = r3 + 1;
        char[] r5 = DIGITS;
        byte r6 = r8[r2];
        r1[r3] = r5[(r6 & 240) >>> 4];
        r3 = r4 + 1;
        r1[r4] = r5[r6 & 15];
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public static String getHexCollationKey(String r3) {
        byte[] r4 = getCollationKeyInBytes(r3);
        return new String(encodeHex(r4), 0, getKeyLen(r4) * 2);
    }

    private static int getKeyLen(byte[] r1) {
        if (r1[r1.length - 1] == 0) goto L7;
        return r1.length;
    L7:
        return r1.length - 1;
    }

    private static byte[] getCollationKeyInBytes(String r2) {
        if (mColl != null) goto L6;
        Collator r0 = Collator.getInstance();
        mColl = r0;
        r0.setStrength(0);
    L6:
        return mColl.getCollationKey(r2).toByteArray();
    }

    public static void dumpCursor(Cursor r1) {
        dumpCursor(r1, System.out);
    }

    public static void dumpCursor(Cursor r2, PrintStream r3) {
        r3.println(">>>>> Dumping cursor " + r2);
        if (r2 == null) goto L9;
        int r0 = r2.getPosition();
        r2.moveToPosition(-1);
    L6:
        if (r2.moveToNext() == false) goto L8;
        dumpCurrentRow(r2, r3);
        goto L6
    L8:
        r2.moveToPosition(r0);
    L9:
        r3.println("<<<<<");
    }

    public static void dumpCursor(Cursor r2, StringBuilder r3) {
        r3.append(">>>>> Dumping cursor " + r2 + "\n");
        if (r2 == null) goto L9;
        int r0 = r2.getPosition();
        r2.moveToPosition(-1);
    L6:
        if (r2.moveToNext() == false) goto L8;
        dumpCurrentRow(r2, r3);
        goto L6
    L8:
        r2.moveToPosition(r0);
    L9:
        r3.append("<<<<<\n");
    }

    public static String dumpCursorToString(Cursor r1) {
        StringBuilder r0 = new StringBuilder();
        dumpCursor(r1, r0);
        return r0.toString();
    }

    public static void dumpCurrentRow(Cursor r1) {
        dumpCurrentRow(r1, System.out);
    }

    public static void dumpCurrentRow(Cursor r6, PrintStream r7) {
        String[] r0 = r6.getColumnNames();
        r7.println("" + r6.getPosition() + " {");
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        String r3 = r6.getString(r2);     // Catch: SQLiteException -> L6
    L7:
        r7.println("   " + r0[r2] + '=' + r3);
        r2 = r2 + 1;
    L6:
        r3 = "<unprintable>";
        goto L7
    L8:
        r7.println(VectorFormat.DEFAULT_SUFFIX);
    }

    public static void dumpCurrentRow(Cursor r6, StringBuilder r7) {
        String[] r0 = r6.getColumnNames();
        r7.append("" + r6.getPosition() + " {\n");
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        String r3 = r6.getString(r2);     // Catch: SQLiteException -> L6
    L7:
        r7.append("   " + r0[r2] + '=' + r3 + "\n");
        r2 = r2 + 1;
    L6:
        r3 = "<unprintable>";
        goto L7
    L8:
        r7.append("}\n");
    }

    public static String dumpCurrentRowToString(Cursor r1) {
        StringBuilder r0 = new StringBuilder();
        dumpCurrentRow(r1, r0);
        return r0.toString();
    }

    public static void cursorStringToContentValues(Cursor r0, String r1, ContentValues r2) {
        cursorStringToContentValues(r0, r1, r2, r1);
    }

    public static void cursorStringToInsertHelper(Cursor r0, String r1, InsertHelper r2, int r3) {
        r2.bind(r3, r0.getString(r0.getColumnIndexOrThrow(r1)));
    }

    public static void cursorStringToContentValues(Cursor r0, String r1, ContentValues r2, String r3) {
        r2.put(r3, r0.getString(r0.getColumnIndexOrThrow(r1)));
    }

    public static void cursorIntToContentValues(Cursor r0, String r1, ContentValues r2) {
        cursorIntToContentValues(r0, r1, r2, r1);
    }

    public static void cursorIntToContentValues(Cursor r1, String r2, ContentValues r3, String r4) {
        int r5 = r1.getColumnIndex(r2);
        if (r1.isNull(r5) == true) goto L5;
        r3.put(r4, Integer.valueOf(r1.getInt(r5)));
        return;
    L5:
        Integer r6 = (Integer) null;
        r3.put(r4, null);
    }

    public static void cursorLongToContentValues(Cursor r0, String r1, ContentValues r2) {
        cursorLongToContentValues(r0, r1, r2, r1);
    }

    public static void cursorLongToContentValues(Cursor r1, String r2, ContentValues r3, String r4) {
        int r5 = r1.getColumnIndex(r2);
        if (r1.isNull(r5) == true) goto L5;
        r3.put(r4, Long.valueOf(r1.getLong(r5)));
        return;
    L5:
        Long r6 = (Long) null;
        r3.put(r4, null);
    }

    public static void cursorDoubleToCursorValues(Cursor r0, String r1, ContentValues r2) {
        cursorDoubleToContentValues(r0, r1, r2, r1);
    }

    public static void cursorDoubleToContentValues(Cursor r1, String r2, ContentValues r3, String r4) {
        int r5 = r1.getColumnIndex(r2);
        if (r1.isNull(r5) == true) goto L5;
        r3.put(r4, Double.valueOf(r1.getDouble(r5)));
        return;
    L5:
        Double r6 = (Double) null;
        r3.put(r4, null);
    }

    public static void cursorRowToContentValues(Cursor r6, ContentValues r7) {
        if ((r6 instanceof AbstractWindowedCursor) == false) goto L5;
        AbstractWindowedCursor r0 = (AbstractWindowedCursor) r6;
    L6:
        String[] r1 = r6.getColumnNames();
        int r2 = r1.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L14;
        if (r0 != null) goto L10;
    L12:
        r7.put(r1[r3], r6.getString(r3));
    L13:
        r3 = r3 + 1;
        goto L7
    L10:
        if (r0.isBlob(r3) == false) goto L12;
        r7.put(r1[r3], r6.getBlob(r3));
        goto L13
    L14:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static int cursorPickFillWindowStartPosition(int r0, int r1) {
        return Math.max(r0 - (r1 / 3), 0);
    }

    public static long queryNumEntries(SQLiteDatabase r1, String r2) {
        return queryNumEntries(r1, r2, null, null);
    }

    public static long queryNumEntries(SQLiteDatabase r1, String r2, String r3) {
        return queryNumEntries(r1, r2, r3, null);
    }

    public static long queryNumEntries(SQLiteDatabase r2, String r3, String r4, String[] r5) {
        if (TextUtils.isEmpty(r4) == true) goto L5;
        String r6 = " where " + r4;
    L7:
        return longForQuery(r2, "select count(*) from " + r3 + r6, r5);
    L5:
        r6 = "";
        goto L7
    }

    public static boolean queryIsEmpty(SQLiteDatabase r2, String r3) {
        if (longForQuery(r2, "select exists(select 1 from " + r3 + ")", null) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static long longForQuery(SQLiteDatabase r0, String r1, String[] r2) {
        SQLiteStatement r3 = r0.compileStatement(r1);
        long r4 = longForQuery(r3, r2);     // Catch: Throwable -> L6
        r3.close();
        return r4;
    L6:
        th = move-exception;
        r3.close();
        throw th;
    }

    public static long longForQuery(SQLiteStatement r0, String[] r1) {
        r0.bindAllArgsAsStrings(r1);
        return r0.simpleQueryForLong();
    }

    public static String stringForQuery(SQLiteDatabase r0, String r1, String[] r2) {
        SQLiteStatement r3 = r0.compileStatement(r1);
        String r4 = stringForQuery(r3, r2);     // Catch: Throwable -> L6
        r3.close();
        return r4;
    L6:
        th = move-exception;
        r3.close();
        throw th;
    }

    public static String stringForQuery(SQLiteStatement r0, String[] r1) {
        r0.bindAllArgsAsStrings(r1);
        return r0.simpleQueryForString();
    }

    public static void cursorStringToContentValuesIfPresent(Cursor r2, ContentValues r3, String r4) {
        int r0 = r2.getColumnIndex(r4);
        if (r0 != (-1)) goto L5;
        return;
    L5:
        if (r2.isNull(r0) == true) goto L9;
        r3.put(r4, r2.getString(r0));
        return;
    }

    public static void cursorLongToContentValuesIfPresent(Cursor r2, ContentValues r3, String r4) {
        int r0 = r2.getColumnIndex(r4);
        if (r0 != (-1)) goto L5;
        return;
    L5:
        if (r2.isNull(r0) == true) goto L9;
        r3.put(r4, Long.valueOf(r2.getLong(r0)));
        return;
    }

    public static void cursorShortToContentValuesIfPresent(Cursor r2, ContentValues r3, String r4) {
        int r0 = r2.getColumnIndex(r4);
        if (r0 != (-1)) goto L5;
        return;
    L5:
        if (r2.isNull(r0) == true) goto L9;
        r3.put(r4, Short.valueOf(r2.getShort(r0)));
        return;
    }

    public static void cursorIntToContentValuesIfPresent(Cursor r2, ContentValues r3, String r4) {
        int r0 = r2.getColumnIndex(r4);
        if (r0 != (-1)) goto L5;
        return;
    L5:
        if (r2.isNull(r0) == true) goto L9;
        r3.put(r4, Integer.valueOf(r2.getInt(r0)));
        return;
    }

    public static void cursorFloatToContentValuesIfPresent(Cursor r2, ContentValues r3, String r4) {
        int r0 = r2.getColumnIndex(r4);
        if (r0 != (-1)) goto L5;
        return;
    L5:
        if (r2.isNull(r0) == true) goto L9;
        r3.put(r4, Float.valueOf(r2.getFloat(r0)));
        return;
    }

    public static void cursorDoubleToContentValuesIfPresent(Cursor r2, ContentValues r3, String r4) {
        int r0 = r2.getColumnIndex(r4);
        if (r0 != (-1)) goto L5;
        return;
    L5:
        if (r2.isNull(r0) == true) goto L9;
        r3.put(r4, Double.valueOf(r2.getDouble(r0)));
        return;
    }

    public static void createDbFromSqlStatements(Context r6, String r7, byte[] r8, SQLiteCipherSpec r9, int r10, String r11) {
        SQLiteDatabase r12 = com.tencent.wcdb.support.Context.openOrCreateDatabase(r6, r7, r8, r9, 0, null);
        String[] r13 = TextUtils.split(r11, ";\n");
        int r14 = r13.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L9;
        String r16 = r13[r15];
        if (TextUtils.isEmpty(r16) == true) goto L8;
        r12.execSQL(r16);
    L8:
        r15 = r15 + 1;
        goto L3
    L9:
        r12.setVersion(r10);
        r12.close();
    }

    public static void createDbFromSqlStatements(Context r6, String r7, int r8, String r9) {
        createDbFromSqlStatements(r6, r7, null, null, r8, r9);
    }

    private static int extractSqlCode(String r5) {
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= 3) goto L14;
        int r3 = r5.charAt(r1);
        if (r3 < 97) goto L11;
        if (r3 > 122) goto L11;
        r3 = (r3 - 97) + 65;
    L13:
        r2 = r2 | ((r3 & 127) << (r1 * 8));
        r1 = r1 + 1;
    L11:
        if (r3 < 128) goto L13;
        return 0;
    L14:
        return r2;
    }

    public static int getSqlStatementType(String r3) {
        String r4 = r3.trim();
        if (r4.length() >= 3) goto L6;
        return 99;
    L6:
        switch(extractSqlCode(r4)) {
            case 4279873: goto L23;
            case 4280912: goto L21;
            case 4476485: goto L19;
            case 4477013: goto L17;
            case 4543043: goto L15;
            case 4670786: goto L13;
            case 4998468: goto L17;
            case 4998483: goto L11;
            case 5001042: goto L9;
            case 5066563: goto L19;
            case 5198404: goto L15;
            case 5260626: goto L17;
            case 5459529: goto L17;
            case 5522756: goto L23;
            case 5524545: goto L15;
            case 5526593: goto L8;
            default: goto L7;
        };
    L7:
        return 99;
    L8:
        return 3;
    L9:
        return 6;
    L11:
        return 1;
    L13:
        return 4;
    L15:
        return 8;
    L17:
        return 2;
    L19:
        return 5;
    L21:
        return 7;
    L23:
        return 9;
    }

    public static String[] appendSelectionArgs(String[] r3, String[] r4) {
        if (r3 != null) goto L4;
    L8:
        return r4;
    L4:
        if (r3.length == 0) goto L8;
        String[] r0 = new String[r3.length + r4.length];
        System.arraycopy(r3, 0, r0, 0, r3.length);
        System.arraycopy(r4, 0, r0, r3.length, r4.length);
        return r0;
    }

    public static int findRowIdColumnIndex(String[] r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r4[r1].equals("_id") == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }
}
