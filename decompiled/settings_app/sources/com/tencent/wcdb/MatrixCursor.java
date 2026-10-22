package com.tencent.wcdb;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class MatrixCursor extends AbstractCursor {
    private final int columnCount;
    private final String[] columnNames;
    private Object[] data;
    private int rowCount;

    public class RowBuilder {
        private final int endIndex;
        private int index;
        final /* synthetic */ MatrixCursor this$0;

        RowBuilder(MatrixCursor r1, int r2, int r3) {
            this.this$0 = r1;
            this.index = r2;
            this.endIndex = r3;
        }

        public RowBuilder add(Object r4) {
            if (this.index == this.endIndex) goto L7;
            Object[] r0 = MatrixCursor.access$000(this.this$0);
            int r1 = this.index;
            this.index = r1 + 1;
            r0[r1] = r4;
            return this;
        L7:
            throw new CursorIndexOutOfBoundsException("No more columns left.");
        }
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void copyStringToBuffer(int r1, CharArrayBuffer r2) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void registerContentObserver(ContentObserver r1) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver r1) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void unregisterContentObserver(ContentObserver r1) {
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver r1) {
    }

    static /* synthetic */ Object[] access$000(MatrixCursor r0) {
        return r0.data;
    }

    public MatrixCursor(String[] r2, int r3) {
        this.rowCount = 0;
        this.columnNames = r2;
        int r4 = r2.length;
        this.columnCount = r4;
        if (r3 >= 1) goto L5;
        r3 = 1;
    L5:
        this.data = new Object[r4 * r3];
    }

    public MatrixCursor(String[] r2) {
        this(r2, 16);
    }

    private Object get(int r4) {
        if (r4 < 0) goto L16;
        if (r4 >= this.columnCount) goto L16;
        if (this.mPos < 0) goto L14;
        if (this.mPos >= this.rowCount) goto L12;
        return this.data[(this.mPos * this.columnCount) + r4];
    L12:
        throw new CursorIndexOutOfBoundsException("After last row.");
    L14:
        throw new CursorIndexOutOfBoundsException("Before first row.");
    L16:
        throw new CursorIndexOutOfBoundsException("Requested column: " + r4 + ", # of columns: " + this.columnCount);
    }

    public RowBuilder newRow() {
        int r0 = this.rowCount + 1;
        this.rowCount = r0;
        int r1 = r0 * this.columnCount;
        ensureCapacity(r1);
        return new RowBuilder(this, r1 - this.columnCount, r1);
    }

    public void addRow(Object[] r4) {
        int r0 = r4.length;
        int r1 = this.columnCount;
        if (r0 != r1) goto L7;
        int r2 = this.rowCount;
        this.rowCount = r2 + 1;
        int r3 = r2 * r1;
        ensureCapacity(r1 + r3);
        System.arraycopy(r4, 0, this.data, r3, this.columnCount);
        return;
    L7:
        throw new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.length = " + r4.length);
    }

    public void addRow(Iterable<?> r6) {
        int r0 = this.rowCount;
        int r1 = this.columnCount;
        int r2 = r0 * r1;
        int r3 = r1 + r2;
        ensureCapacity(r3);
        if ((r6 instanceof ArrayList) == false) goto L6;
        addRow((ArrayList) r6, r2);
        return;
    L6:
        Object[] r4 = this.data;
        Iterator<?> r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L14;
        Object r5 = r7.next();
        if (r2 == r3) goto L13;
        r4[r2] = r5;
        r2 = r2 + 1;
        goto L8
    L13:
        throw new IllegalArgumentException("columnValues.size() > columnNames.length");
    L14:
        if (r2 != r3) goto L18;
        this.rowCount++;
        return;
    L18:
        throw new IllegalArgumentException("columnValues.size() < columnNames.length");
    }

    private void addRow(ArrayList<?> r5, int r6) {
        int r0 = r5.size();
        if (r0 != this.columnCount) goto L9;
        this.rowCount++;
        Object[] r4 = this.data;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        r4[r6 + r1] = r5.get(r1);
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new IllegalArgumentException("columnNames.length = " + this.columnCount + ", columnValues.size() = " + r0);
    }

    private void ensureCapacity(int r3) {
        Object[] r0 = this.data;
        if (r3 <= r0.length) goto L10;
        int r1 = r0.length * 2;
        if (r1 < r3) goto L8;
        r3 = r1;
    L8:
        Object[] r4 = new Object[r3];
        this.data = r4;
        System.arraycopy(r0, 0, r4, 0, r0.length);
        return;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public int getCount() {
        return this.rowCount;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.columnNames;
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public String getString(int r1) {
        Object r0 = get(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public short getShort(int r1) {
        Object r0 = get(r1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        if ((r0 instanceof Number) == false) goto L11;
        return ((Number) r0).shortValue();
    L11:
        return Short.parseShort(r0.toString());
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public int getInt(int r1) {
        Object r0 = get(r1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        if ((r0 instanceof Number) == false) goto L11;
        return ((Number) r0).intValue();
    L11:
        return Integer.parseInt(r0.toString());
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public long getLong(int r1) {
        Object r0 = get(r1);
        if (r0 != null) goto L7;
        return 0;
    L7:
        if ((r0 instanceof Number) == false) goto L11;
        return ((Number) r0).longValue();
    L11:
        return Long.parseLong(r0.toString());
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public float getFloat(int r1) {
        Object r0 = get(r1);
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        if ((r0 instanceof Number) == false) goto L11;
        return ((Number) r0).floatValue();
    L11:
        return Float.parseFloat(r0.toString());
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public double getDouble(int r1) {
        Object r0 = get(r1);
        if (r0 != null) goto L7;
        return 0.0d;
    L7:
        if ((r0 instanceof Number) == false) goto L11;
        return ((Number) r0).doubleValue();
    L11:
        return Double.parseDouble(r0.toString());
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public byte[] getBlob(int r1) {
        return (byte[]) get(r1);
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public int getType(int r1) {
        return DatabaseUtils.getTypeOfObject(get(r1));
    }

    @Override // com.tencent.wcdb.AbstractCursor, com.tencent.wcdb.Cursor, android.database.Cursor
    public boolean isNull(int r1) {
        if (get(r1) != null) goto L5;
        return true;
    L5:
        return false;
    }
}
