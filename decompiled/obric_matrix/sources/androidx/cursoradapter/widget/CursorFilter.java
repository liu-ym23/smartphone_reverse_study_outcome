package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;

/* JADX INFO: loaded from: classes.dex */
class CursorFilter extends Filter {
    CursorFilterClient mClient;

    interface CursorFilterClient {
        void changeCursor(Cursor r1);

        CharSequence convertToString(Cursor r1);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence r1);
    }

    CursorFilter(CursorFilterClient r1) {
        this.mClient = r1;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object r1) {
        return this.mClient.convertToString((Cursor) r1);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence r2) {
        Cursor r1 = this.mClient.runQueryOnBackgroundThread(r2);
        Filter.FilterResults r3 = new Filter.FilterResults();
        if (r1 == null) goto L5;
        r3.count = r1.getCount();
    L6:
        r3.values = r1;
        return r3;
    L5:
        r3.count = 0;
        r1 = null;
        goto L6
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence r1, Filter.FilterResults r2) {
        Cursor r3 = this.mClient.getCursor();
        Object r4 = r2.values;
        if (r4 == null) goto L7;
        if (r4 == r3) goto L8;
        this.mClient.changeCursor((Cursor) r4);
        return;
    L8:
        return;
    }
}
