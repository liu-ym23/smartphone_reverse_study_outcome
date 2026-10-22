package com.android.settings.slices;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.text.TextUtils;
import android.util.Pair;
import com.android.settings.overlay.FeatureFactory;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SlicesDatabaseAccessor {
    public static final String[] SELECT_COLUMNS_ALL = null;
    private final Context mContext;
    private final SlicesDatabaseHelper mHelper;

    private String buildKeyMatchWhereClause() {
        return "key = ?";
    }

    static {
        SELECT_COLUMNS_ALL = new String[]{"key", "title", "summary", SlicesDatabaseHelper.IndexColumns.SCREENTITLE, "keywords", "icon", "fragment", "controller", SlicesDatabaseHelper.IndexColumns.SLICE_TYPE, "unavailable_slice_subtitle", SlicesDatabaseHelper.IndexColumns.HIGHLIGHT_MENU_RESOURCE, SlicesDatabaseHelper.IndexColumns.USER_RESTRICTION};
    }

    public SlicesDatabaseAccessor(Context r1) {
        this.mContext = r1;
        this.mHelper = SlicesDatabaseHelper.getInstance(r1);
    }

    public SliceData getSliceDataFromUri(Uri r3) {
        Pair<Boolean, String> r0 = SliceBuilderUtils.getPathData(r3);
        if (r0 == null) goto L17;
        Cursor r2 = getIndexedSliceData((String) r0.second);
        SliceData r4 = buildSliceData(r2, r3, ((Boolean) r0.first).booleanValue());     // Catch: Throwable -> L9
        if (r2 == null) goto L8;
        r2.close();
    L8:
        return r4;
    L9:
        th = move-exception;
        if (r2 != null) goto L20;
    L15:
        throw th;
    L20:
        r2.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    L17:
        throw new IllegalStateException("Invalid Slices uri: " + r3);
    }

    public SliceData getSliceDataFromKey(String r2) {
        Cursor r1 = getIndexedSliceData(r2);
        SliceData r3 = buildSliceData(r1, null, false);     // Catch: Throwable -> L7
        if (r1 == null) goto L6;
        r1.close();
    L6:
        return r3;
    L7:
        th = move-exception;
        if (r1 != null) goto L16;
    L13:
        throw th;
    L16:
        r1.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public List<Uri> getSliceUris(String r11, boolean r12) {
        verifyIndexing();
        ArrayList r0 = new ArrayList();
        if (r12 == false) goto L5;
        String r13 = "=1";
    L6:
        String r5 = SlicesDatabaseHelper.IndexColumns.PUBLIC_SLICE.concat(r13);
        Cursor r10 = this.mHelper.getReadableDatabase().query(SlicesDatabaseHelper.Tables.TABLE_SLICES_INDEX, new String[]{"slice_uri"}, r5, null, null, null, null);
    L23:
        th = move-exception;
        if (r10 != null) goto L32;
    L29:
        throw th;
    L32:
        r10.close();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.addSuppressed(th);
        goto L29
    L8:
        if (r10.moveToFirst() == true) goto L13;
        if (r10 == null) goto L11;
        r10.close();
    L11:
        return r0;
    L13:
        Uri r14 = Uri.parse(r10.getString(0));     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r11) == false) goto L16;
    L17:
        r0.add(r14);     // Catch: Throwable -> L23
    L19:
        if (r10.moveToNext() == true) goto L13;
        if (r10 == null) goto L22;
        r10.close();
    L22:
        return r0;
    L16:
        if (TextUtils.equals(r11, r14.getAuthority()) == false) goto L19;
    L5:
        r13 = "=0";
        goto L6
    }

    private Cursor getIndexedSliceData(String r9) {
        verifyIndexing();
        Cursor r0 = this.mHelper.getReadableDatabase().query(SlicesDatabaseHelper.Tables.TABLE_SLICES_INDEX, SELECT_COLUMNS_ALL, buildKeyMatchWhereClause(), new String[]{r9}, null, null, null);
        int r1 = r0.getCount();
        if (r1 == 0) goto L9;
        if (r1 > 1) goto L7;
        r0.moveToFirst();
        return r0;
    L7:
        r0.close();
        throw new IllegalStateException("Should not match more than 1 slice with path: " + r9);
    L9:
        r0.close();
        throw new IllegalStateException("Invalid Slices key from path: " + r9);
    }

    private static SliceData buildSliceData(Cursor r12, Uri r13, boolean r14) {
        String r0 = r12.getString(r12.getColumnIndex("key"));
        String r1 = r12.getString(r12.getColumnIndex("title"));
        String r2 = r12.getString(r12.getColumnIndex("summary"));
        String r3 = r12.getString(r12.getColumnIndex(SlicesDatabaseHelper.IndexColumns.SCREENTITLE));
        String r4 = r12.getString(r12.getColumnIndex("keywords"));
        int r5 = r12.getInt(r12.getColumnIndex("icon"));
        String r6 = r12.getString(r12.getColumnIndex("fragment"));
        String r7 = r12.getString(r12.getColumnIndex("controller"));
        int r8 = r12.getInt(r12.getColumnIndex(SlicesDatabaseHelper.IndexColumns.SLICE_TYPE));
        String r9 = r12.getString(r12.getColumnIndex("unavailable_slice_subtitle"));
        int r10 = r12.getInt(r12.getColumnIndex(SlicesDatabaseHelper.IndexColumns.HIGHLIGHT_MENU_RESOURCE));
        String r15 = r12.getString(r12.getColumnIndex(SlicesDatabaseHelper.IndexColumns.USER_RESTRICTION));
        if (r14 == false) goto L6;
        r8 = 0;
    L6:
        return new SliceData.Builder().setKey(r0).setTitle(r1).setSummary(r2).setScreenTitle(r3).setKeywords(r4).setIcon(r5).setFragmentName(r6).setPreferenceControllerClassName(r7).setUri(r13).setSliceType(r8).setUnavailableSliceSubtitle(r9).setHighlightMenuRes(r10).setUserRestriction(r15).build();
    }

    private void verifyIndexing() {
        long r0 = Binder.clearCallingIdentity();
        FeatureFactory.getFeatureFactory().getSlicesFeatureProvider().indexSliceData(this.mContext);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(r0);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(r0);
        throw th;
    }
}
