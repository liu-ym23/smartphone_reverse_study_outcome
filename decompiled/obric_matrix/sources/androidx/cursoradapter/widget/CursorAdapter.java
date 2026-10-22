package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {

    @Deprecated
    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean mAutoRequery;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected ChangeObserver mChangeObserver;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Context mContext;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Cursor mCursor;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected CursorFilter mCursorFilter;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected DataSetObserver mDataSetObserver;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean mDataValid;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected FilterQueryProvider mFilterQueryProvider;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected int mRowIDColumn;

    private class ChangeObserver extends ContentObserver {
        final /* synthetic */ CursorAdapter this$0;

        ChangeObserver(CursorAdapter r1) {
            this.this$0 = r1;
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1) {
            this.this$0.onContentChanged();
        }
    }

    private class MyDataSetObserver extends DataSetObserver {
        final /* synthetic */ CursorAdapter this$0;

        MyDataSetObserver(CursorAdapter r1) {
            this.this$0 = r1;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CursorAdapter r1 = this.this$0;
            r1.mDataValid = true;
            r1.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            CursorAdapter r1 = this.this$0;
            r1.mDataValid = false;
            r1.notifyDataSetInvalidated();
        }
    }

    @Deprecated
    public CursorAdapter(Context r2, Cursor r3) {
        init(r2, r3, 1);
    }

    public CursorAdapter(Context r1, Cursor r2, int r3) {
        init(r1, r2, r3);
    }

    public CursorAdapter(Context r1, Cursor r2, boolean r3) {
        if (r3 == false) goto L5;
        int r4 = 1;
    L6:
        init(r1, r2, r4);
        return;
    L5:
        r4 = 2;
        goto L6
    }

    public abstract void bindView(View r1, Context r2, Cursor r3);

    public void changeCursor(Cursor r1) {
        Cursor r0 = swapCursor(r1);
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    public CharSequence convertToString(Cursor r1) {
        if (r1 != null) goto L5;
        return "";
    L5:
        return r1.toString();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mDataValid == false) goto L8;
        Cursor r1 = this.mCursor;
        if (r1 != null) goto L7;
        return 0;
    L7:
        return r1.getCount();
    L8:
        return 0;
    }

    @Override // androidx.cursoradapter.widget.CursorFilter.CursorFilterClient
    public Cursor getCursor() {
        return this.mCursor;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int r2, View r3, ViewGroup r4) {
        if (this.mDataValid == false) goto L9;
        this.mCursor.moveToPosition(r2);
        if (r3 != null) goto L7;
        r3 = newDropDownView(this.mContext, this.mCursor, r4);
    L7:
        bindView(r3, this.mContext, this.mCursor);
        return r3;
    L9:
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.mCursorFilter != null) goto L6;
        this.mCursorFilter = new CursorFilter(this);
    L6:
        return this.mCursorFilter;
    }

    public FilterQueryProvider getFilterQueryProvider() {
        return this.mFilterQueryProvider;
    }

    @Override // android.widget.Adapter
    public Object getItem(int r2) {
        if (this.mDataValid == false) goto L8;
        Cursor r0 = this.mCursor;
        if (r0 == null) goto L10;
        r0.moveToPosition(r2);
        return this.mCursor;
    L10:
        return null;
    L8:
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int r4) {
        if (this.mDataValid == false) goto L10;
        Cursor r0 = this.mCursor;
        if (r0 == null) goto L10;
        if (r0.moveToPosition(r4) == false) goto L10;
        return this.mCursor.getLong(this.mRowIDColumn);
    L10:
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int r2, View r3, ViewGroup r4) {
        if (this.mDataValid == false) goto L13;
        if (this.mCursor.moveToPosition(r2) == false) goto L11;
        if (r3 != null) goto L8;
        r3 = newView(this.mContext, this.mCursor, r4);
    L8:
        bindView(r3, this.mContext, this.mCursor);
        return r3;
    L11:
        throw new IllegalStateException("couldn't move cursor to position " + r2);
    L13:
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    void init(Context r4, Cursor r5, int r6) {
        boolean r1 = false;
        if ((r6 & 1) != 1) goto L5;
        r6 = r6 | 2;
        this.mAutoRequery = true;
    L6:
        if (r5 == null) goto L8;
        r1 = true;
    L8:
        this.mCursor = r5;
        this.mDataValid = r1;
        this.mContext = r4;
        if (r1 == false) goto L11;
        int r7 = r5.getColumnIndexOrThrow("_id");
    L12:
        this.mRowIDColumn = r7;
        if ((r6 & 2) != 2) goto L15;
        this.mChangeObserver = new ChangeObserver(this);
        MyDataSetObserver r8 = new MyDataSetObserver(this);
    L16:
        this.mDataSetObserver = r8;
        if (r1 == false) goto L25;
        ChangeObserver r9 = this.mChangeObserver;
        if (r9 == null) goto L21;
        r5.registerContentObserver(r9);
    L21:
        DataSetObserver r3 = this.mDataSetObserver;
        if (r3 == null) goto L26;
        r5.registerDataSetObserver(r3);
        return;
    L26:
        return;
    L25:
        return;
    L15:
        r8 = null;
        this.mChangeObserver = null;
        goto L16
    L11:
        r7 = -1;
        goto L12
    L5:
        this.mAutoRequery = false;
        goto L6
    }

    @Deprecated
    protected void init(Context r1, Cursor r2, boolean r3) {
        if (r3 == false) goto L4;
        int r4 = 1;
    L5:
        init(r1, r2, r4);
        return;
    L4:
        r4 = 2;
        goto L5
    }

    public View newDropDownView(Context r1, Cursor r2, ViewGroup r3) {
        return newView(r1, r2, r3);
    }

    public abstract View newView(Context r1, Cursor r2, ViewGroup r3);

    protected void onContentChanged() {
        if (this.mAutoRequery == false) goto L10;
        Cursor r0 = this.mCursor;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isClosed() == true) goto L12;
        this.mDataValid = this.mCursor.requery();
        return;
    L12:
        return;
    }

    public Cursor runQueryOnBackgroundThread(CharSequence r2) {
        FilterQueryProvider r0 = this.mFilterQueryProvider;
        if (r0 == null) goto L7;
        return r0.runQuery(r2);
    L7:
        return this.mCursor;
    }

    public void setFilterQueryProvider(FilterQueryProvider r1) {
        this.mFilterQueryProvider = r1;
    }

    public Cursor swapCursor(Cursor r3) {
        Cursor r0 = this.mCursor;
        if (r3 != r0) goto L6;
        return null;
    L6:
        if (r0 == null) goto L13;
        ChangeObserver r1 = this.mChangeObserver;
        if (r1 == null) goto L10;
        r0.unregisterContentObserver(r1);
    L10:
        DataSetObserver r2 = this.mDataSetObserver;
        if (r2 == null) goto L13;
        r0.unregisterDataSetObserver(r2);
    L13:
        this.mCursor = r3;
        if (r3 == null) goto L22;
        ChangeObserver r4 = this.mChangeObserver;
        if (r4 == null) goto L18;
        r3.registerContentObserver(r4);
    L18:
        DataSetObserver r5 = this.mDataSetObserver;
        if (r5 == null) goto L21;
        r3.registerDataSetObserver(r5);
    L21:
        this.mRowIDColumn = r3.getColumnIndexOrThrow("_id");
        this.mDataValid = true;
        notifyDataSetChanged();
    L23:
        return r0;
    L22:
        this.mRowIDColumn = -1;
        this.mDataValid = false;
        notifyDataSetInvalidated();
        goto L23
    }
}
