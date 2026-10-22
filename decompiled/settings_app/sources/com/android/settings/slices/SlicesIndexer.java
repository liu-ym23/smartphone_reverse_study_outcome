package com.android.settings.slices;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.android.settings.overlay.FeatureFactory;
import com.obric.olog.OLog;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class SlicesIndexer implements Runnable {
    private static final String TAG = "SlicesIndexer";
    private Context mContext;
    private SlicesDatabaseHelper mHelper;

    public SlicesIndexer(Context r1) {
        this.mContext = r1;
        this.mHelper = SlicesDatabaseHelper.getInstance(r1);
    }

    @Override // java.lang.Runnable
    public void run() {
        indexSliceData();
    }

    protected void indexSliceData() {
        if (this.mHelper.isSliceDataIndexed() == false) goto L6;
        OLog.d(TAG, "Slices already indexed - returning.");
        return;
    L6:
        SQLiteDatabase r1 = this.mHelper.getWritableDatabase();
        long r3 = System.currentTimeMillis();
        r1.beginTransaction();
        this.mHelper.reconstruct(r1);     // Catch: Throwable -> L10
        insertSliceData(r1, getSliceData());     // Catch: Throwable -> L10
        this.mHelper.setIndexedState();     // Catch: Throwable -> L10
        OLog.d(TAG, "Indexing slices database took: " + (System.currentTimeMillis() - r3));     // Catch: Throwable -> L10
        r1.setTransactionSuccessful();     // Catch: Throwable -> L10
        r1.endTransaction();
        return;
    L10:
        th = move-exception;
        r1.endTransaction();
        throw th;
    }

    List<SliceData> getSliceData() {
        return FeatureFactory.getFeatureFactory().getSlicesFeatureProvider().getSliceDataConverter(this.mContext).getSliceData();
    }

    void insertSliceData(SQLiteDatabase r4, List<SliceData> r5) {
        Iterator<SliceData> r3 = r5.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        SliceData r6 = r3.next();
        ContentValues r0 = new ContentValues();
        r0.put("key", r6.getKey());
        r0.put("slice_uri", r6.getUri().toString());
        r0.put("title", r6.getTitle());
        r0.put("summary", r6.getSummary());
        CharSequence r1 = r6.getScreenTitle();
        if (r1 == null) goto L8;
        r0.put(SlicesDatabaseHelper.IndexColumns.SCREENTITLE, r1.toString());
    L8:
        r0.put("keywords", r6.getKeywords());
        r0.put("icon", Integer.valueOf(r6.getIconResource()));
        r0.put("fragment", r6.getFragmentClassName());
        r0.put("controller", r6.getPreferenceController());
        r0.put(SlicesDatabaseHelper.IndexColumns.SLICE_TYPE, Integer.valueOf(r6.getSliceType()));
        r0.put("unavailable_slice_subtitle", r6.getUnavailableSliceSubtitle());
        r0.put(SlicesDatabaseHelper.IndexColumns.PUBLIC_SLICE, Boolean.valueOf(r6.isPublicSlice()));
        r0.put(SlicesDatabaseHelper.IndexColumns.HIGHLIGHT_MENU_RESOURCE, Integer.valueOf(r6.getHighlightMenuRes()));
        r0.put(SlicesDatabaseHelper.IndexColumns.USER_RESTRICTION, r6.getUserRestriction());
        r4.replaceOrThrow(SlicesDatabaseHelper.Tables.TABLE_SLICES_INDEX, null, r0);
        goto L4
    }
}
