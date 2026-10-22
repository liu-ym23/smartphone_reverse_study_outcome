package com.android.settings.quickphrases;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class QueryHandler extends AsyncQueryHandler {
    private ArrayList<QuickPhrase> mArrayPhrases;
    QueryCallback mCallback;

    interface QueryCallback {
        void asyncQuery();

        void onQueryComplete(ArrayList<QuickPhrase> r1);
    }

    public QueryHandler(ContentResolver r1) {
        super(r1);
        this.mArrayPhrases = new ArrayList();
    }

    public void setCallback(QueryCallback r1) {
        this.mCallback = r1;
    }

    @Override // android.content.AsyncQueryHandler
    protected void onQueryComplete(int r3, Object r4, Cursor r5) {
        super.onQueryComplete(r3, r4, r5);
        if (r5 == null) goto L11;
        this.mArrayPhrases.clear();
        if (r5.getCount() <= 0) goto L10;
        int r6 = r5.getColumnIndex("_id");
        int r7 = r5.getColumnIndex("phrase");
    L8:
        if (r5.moveToNext() == false) goto L10;
        QuickPhrase r0 = new QuickPhrase();
        r0.setId(r5.getInt(r6));
        r0.setDetail(r5.getString(r7));
        this.mArrayPhrases.add(r0);
    L10:
        r5.close();
    L11:
        QueryCallback r8 = this.mCallback;
        if (r8 == null) goto L16;
        r8.onQueryComplete(this.mArrayPhrases);
        return;
    }

    @Override // android.content.AsyncQueryHandler
    protected void onInsertComplete(int r1, Object r2, Uri r3) {
        super.onInsertComplete(r1, r2, r3);
        QueryCallback r0 = this.mCallback;
        if (r0 == null) goto L6;
        r0.asyncQuery();
        return;
    }
}
