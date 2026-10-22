package com.android.settings.search;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.MergeCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.SearchIndexableData;
import android.provider.SearchIndexableResource;
import android.provider.SearchIndexablesContract;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import com.android.internal.R;
import com.android.settings.ApnEditor;
import com.obric.olog.OLog;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class Index {
    private static final String BASE_AUTHORITY = "com.android.settings";
    public static final int COLUMN_INDEX_CLASS_NAME = 6;
    public static final int COLUMN_INDEX_ENABLED = 12;
    public static final int COLUMN_INDEX_ENTRIES = 4;
    public static final int COLUMN_INDEX_ICON = 8;
    public static final int COLUMN_INDEX_INTENT_ACTION = 9;
    public static final int COLUMN_INDEX_INTENT_ACTION_TARGET_CLASS = 11;
    public static final int COLUMN_INDEX_INTENT_ACTION_TARGET_PACKAGE = 10;
    public static final int COLUMN_INDEX_KEY = 13;
    public static final int COLUMN_INDEX_KEYWORDS = 5;
    public static final int COLUMN_INDEX_RANK = 0;
    public static final int COLUMN_INDEX_SCREEN_TITLE = 7;
    public static final int COLUMN_INDEX_SUMMARY_OFF = 3;
    public static final int COLUMN_INDEX_SUMMARY_ON = 2;
    public static final int COLUMN_INDEX_TITLE = 1;
    public static final int COLUMN_INDEX_USER_ID = 14;
    private static final String EMPTY = "";
    private static final List<String> EMPTY_LIST = null;
    public static final String ENTRIES_SEPARATOR = "|";
    private static final String FIELD_NAME_SEARCH_INDEX_DATA_PROVIDER = "SEARCH_INDEX_DATA_PROVIDER";
    private static final String HYPHEN = "-";
    private static final String LIST_DELIMITERS = "[,]\\s*";
    private static final String LOG_TAG = "Index";
    private static final String[] MATCH_COLUMNS_PRIMARY = null;
    private static final String[] MATCH_COLUMNS_SECONDARY = null;
    private static final int MAX_PROPOSED_SUGGESTIONS = 5;
    private static long MAX_SAVED_SEARCH_QUERY = 0;
    private static final String NODE_NAME_CHECK_BOX_PREFERENCE = "CheckBoxPreference";
    private static final String NODE_NAME_LIST_PREFERENCE = "ListPreference";
    private static final String NODE_NAME_PREFERENCE_SCREEN = "PreferenceScreen";
    private static final String NON_BREAKING_HYPHEN = "‑";
    private static final Pattern REMOVE_DIACRITICALS_PATTERN = null;
    private static final String[] SELECT_COLUMNS = null;
    private static final String SPACE = " ";
    private static Index sInstance;
    private final String mBaseAuthority;
    private Context mContext;
    private final UpdateData mDataToProcess;
    private final AtomicBoolean mIsAvailable;

    private class SaveSearchQueryTask extends AsyncTask<String, Void, Long> {
        final /* synthetic */ Index this$0;

        private SaveSearchQueryTask(Index r1) {
            this.this$0 = r1;
        }

        /* synthetic */ SaveSearchQueryTask(Index r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Long doInBackground(String[] r1) {
            return doInBackground2(r1);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Long doInBackground2(String... r14) {
            long r2 = new Date().getTime();
            ContentValues r4 = new ContentValues();
            r4.put(IndexDatabaseHelper.SavedQueriesColums.QUERY, r14[0]);
            r4.put("timestamp", Long.valueOf(r2));
            SQLiteDatabase r13 = Index.access$500(this.this$0);
            long r3 = -1;
            if (r13 != null) goto L14;
            OLog.e(Index.LOG_TAG, "Cannot save Search queries as I cannot get a writable database");
            return -1L;
        L14:
            r13.delete(IndexDatabaseHelper.Tables.TABLE_SAVED_QUERIES, "query = ?", new String[]{r14[0]});     // Catch: Exception -> L10
            r3 = r13.insertOrThrow(IndexDatabaseHelper.Tables.TABLE_SAVED_QUERIES, null, r4);     // Catch: Exception -> L10
            long r9 = r3 - Index.access$800();     // Catch: Exception -> L10
            if (r9 <= 0) goto L13;
            OLog.d(Index.LOG_TAG, "Deleted '" + r13.delete(IndexDatabaseHelper.Tables.TABLE_SAVED_QUERIES, "rowId <= ?", new String[]{Long.toString(r9)}) + "' saved Search query(ies)");     // Catch: Exception -> L10
        L13:
            return Long.valueOf(r3);
        L10:
            e = move-exception;
            OLog.d(Index.LOG_TAG, "Cannot update saved Search queries", e);
            goto L13
        }
    }

    private static class UpdateData {
        public List<SearchIndexableData> dataToDelete;
        public List<SearchIndexableData> dataToUpdate;
        public boolean forceUpdate;
        public boolean fullIndex;
        public Map<String, List<String>> nonIndexableKeys;

        public UpdateData() {
            this.forceUpdate = false;
            this.fullIndex = true;
            this.dataToUpdate = new ArrayList();
            this.dataToDelete = new ArrayList();
            this.nonIndexableKeys = new HashMap();
        }

        public UpdateData(UpdateData r3) {
            this.forceUpdate = false;
            this.fullIndex = true;
            this.dataToUpdate = new ArrayList(r3.dataToUpdate);
            this.dataToDelete = new ArrayList(r3.dataToDelete);
            this.nonIndexableKeys = new HashMap(r3.nonIndexableKeys);
            this.forceUpdate = r3.forceUpdate;
            this.fullIndex = r3.fullIndex;
        }

        public UpdateData copy() {
            return new UpdateData(this);
        }

        public void clear() {
            this.dataToUpdate.clear();
            this.dataToDelete.clear();
            this.nonIndexableKeys.clear();
            this.forceUpdate = false;
            this.fullIndex = false;
        }
    }

    private class UpdateIndexTask extends AsyncTask<UpdateData, Integer, Void> {
        final /* synthetic */ Index this$0;

        private UpdateIndexTask(Index r1) {
            this.this$0 = r1;
        }

        /* synthetic */ UpdateIndexTask(Index r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(UpdateData[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            Index.access$400(this.this$0).set(false);
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r1) {
            super.onPostExecute(r1);
            Index.access$400(this.this$0).set(true);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(UpdateData... r12) {
            List<SearchIndexableData> r7 = r12[0].dataToUpdate;     // Catch: SQLiteFullException -> L21
            List<SearchIndexableData> r3 = r12[0].dataToDelete;     // Catch: SQLiteFullException -> L21
            Map<String, List<String>> r8 = r12[0].nonIndexableKeys;     // Catch: SQLiteFullException -> L21
            boolean r9 = r12[0].forceUpdate;     // Catch: SQLiteFullException -> L21
            boolean r13 = r12[0].fullIndex;     // Catch: SQLiteFullException -> L21
            SQLiteDatabase r2 = Index.access$500(this.this$0);     // Catch: SQLiteFullException -> L21
            if (r2 != null) goto L7;
            OLog.e(Index.LOG_TAG, "Cannot update Index as I cannot get a writable database");     // Catch: SQLiteFullException -> L21
            return null;
        L7:
            String r10 = Locale.getDefault().toString();     // Catch: SQLiteFullException -> L21
            r2.beginTransaction();     // Catch: Throwable -> L18
            if (r3.size() <= 0) goto L12;
            processDataToDelete(r2, r10, r3);     // Catch: Throwable -> L18
        L12:
            if (r7.size() <= 0) goto L14;
            processDataToUpdate(r2, r10, r7, r8, r9);     // Catch: Throwable -> L18
        L14:
            r2.setTransactionSuccessful();     // Catch: Throwable -> L18
            r2.endTransaction();     // Catch: SQLiteFullException -> L21
            if (r13 == false) goto L23;
            IndexDatabaseHelper.setLocaleIndexed(Index.access$600(this.this$0), r10);     // Catch: SQLiteFullException -> L21
        L23:
            return null;
        L18:
            th = move-exception;
            r2.endTransaction();     // Catch: SQLiteFullException -> L21
            throw th;     // Catch: SQLiteFullException -> L21
        L21:
            e = move-exception;
            OLog.e(Index.LOG_TAG, "Unable to index search, out of space", e);
            goto L23
        }

        private boolean processDataToUpdate(SQLiteDatabase r10, String r11, List<SearchIndexableData> r12, Map<String, List<String>> r13, boolean r14) {
            if (r14 == false) goto L5;
        L8:
            long r1 = System.currentTimeMillis();
            int r15 = r12.size();
            int r4 = 0;
        L9:
            if (r4 >= r15) goto L19;
            String r5 = (SearchIndexableData) r12.get(r4);
            Index.access$700(this.this$0, r10, r11, r5, r13);     // Catch: Exception -> L13
        L18:
            r4 = r4 + 1;
        L13:
            e = move-exception;
            StringBuilder r7 = new StringBuilder("Cannot index: ");
            if (r5 == null) goto L17;
            r5 = ((SearchIndexableData) r5).className;
        L17:
            OLog.e(Index.LOG_TAG, r7.append(r5).append(" for locale: ").append(r11).toString(), e);
            goto L18
        L19:
            OLog.d(Index.LOG_TAG, "Indexing locale '" + r11 + "' took " + (System.currentTimeMillis() - r1) + " millis");
            return false;
        L5:
            if (IndexDatabaseHelper.isLocaleAlreadyIndexed(Index.access$600(this.this$0), r11) == false) goto L8;
            OLog.d(Index.LOG_TAG, "Locale '" + r11 + "' is already indexed");
            return true;
        }

        private boolean processDataToDelete(SQLiteDatabase r8, String r9, List<SearchIndexableData> r10) {
            long r0 = System.currentTimeMillis();
            int r2 = r10.size();
            int r4 = 0;
        L3:
            if (r4 >= r2) goto L16;
            SearchIndexableData r5 = r10.get(r4);
            if (r5 == null) goto L15;
            if (TextUtils.isEmpty(r5.className) == true) goto L11;
            delete(r8, IndexDatabaseHelper.IndexColumns.CLASS_NAME, r5.className);
            goto L15
        L11:
            if ((r5 instanceof SearchIndexableRaw) == false) goto L15;
            SearchIndexableRaw r6 = (SearchIndexableRaw) r5;
            if (TextUtils.isEmpty(r6.title) == true) goto L15;
            delete(r8, IndexDatabaseHelper.IndexColumns.DATA_TITLE, r6.title);
        L15:
            r4 = r4 + 1;
            goto L3
        L16:
            OLog.d(Index.LOG_TAG, "Deleting data for locale '" + r9 + "' took " + (System.currentTimeMillis() - r0) + " millis");
            return false;
        }

        private int delete(SQLiteDatabase r2, String r3, String r4) {
            return r2.delete(IndexDatabaseHelper.Tables.TABLE_PREFS_INDEX, r3 + "=?", new String[]{r4});
        }
    }

    static /* synthetic */ UpdateData access$100(Index r0) {
        return r0.mDataToProcess;
    }

    static /* synthetic */ void access$200(Index r0) {
        r0.updateInternal();
    }

    static /* synthetic */ AtomicBoolean access$400(Index r0) {
        return r0.mIsAvailable;
    }

    static /* synthetic */ SQLiteDatabase access$500(Index r0) {
        return r0.getWritableDatabase();
    }

    static /* synthetic */ Context access$600(Index r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$700(Index r0, SQLiteDatabase r1, String r2, SearchIndexableData r3, Map r4) {
        r0.indexOneSearchIndexableData(r1, r2, r3, r4);
    }

    static /* synthetic */ long access$800() {
        return MAX_SAVED_SEARCH_QUERY;
    }

    static {
        SELECT_COLUMNS = new String[]{IndexDatabaseHelper.IndexColumns.DATA_RANK, IndexDatabaseHelper.IndexColumns.DATA_TITLE, IndexDatabaseHelper.IndexColumns.DATA_SUMMARY_ON, IndexDatabaseHelper.IndexColumns.DATA_SUMMARY_OFF, IndexDatabaseHelper.IndexColumns.DATA_ENTRIES, IndexDatabaseHelper.IndexColumns.DATA_KEYWORDS, IndexDatabaseHelper.IndexColumns.CLASS_NAME, IndexDatabaseHelper.IndexColumns.SCREEN_TITLE, "icon", IndexDatabaseHelper.IndexColumns.INTENT_ACTION, IndexDatabaseHelper.IndexColumns.INTENT_TARGET_PACKAGE, IndexDatabaseHelper.IndexColumns.INTENT_TARGET_CLASS, IndexDatabaseHelper.IndexColumns.ENABLED, IndexDatabaseHelper.IndexColumns.DATA_KEY_REF};
        MATCH_COLUMNS_PRIMARY = new String[]{IndexDatabaseHelper.IndexColumns.DATA_TITLE, IndexDatabaseHelper.IndexColumns.DATA_TITLE_NORMALIZED, IndexDatabaseHelper.IndexColumns.DATA_KEYWORDS};
        MATCH_COLUMNS_SECONDARY = new String[]{IndexDatabaseHelper.IndexColumns.DATA_SUMMARY_ON, IndexDatabaseHelper.IndexColumns.DATA_SUMMARY_ON_NORMALIZED, IndexDatabaseHelper.IndexColumns.DATA_SUMMARY_OFF, IndexDatabaseHelper.IndexColumns.DATA_SUMMARY_OFF_NORMALIZED, IndexDatabaseHelper.IndexColumns.DATA_ENTRIES};
        MAX_SAVED_SEARCH_QUERY = 64;
        EMPTY_LIST = Collections.emptyList();
        REMOVE_DIACRITICALS_PATTERN = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    }

    public static Index getInstance(Context r2) {
        if (sInstance != null) goto L6;
        sInstance = new Index(r2.getApplicationContext(), "com.android.settings");
    L6:
        return sInstance;
    }

    public Index(Context r3, String r4) {
        this.mIsAvailable = new AtomicBoolean(false);
        this.mDataToProcess = new UpdateData();
        this.mContext = r3;
        this.mBaseAuthority = r4;
    }

    public void setContext(Context r1) {
        this.mContext = r1;
    }

    public boolean isAvailable() {
        return this.mIsAvailable.get();
    }

    public Cursor search(String r10) {
        SQLiteDatabase r0 = getReadableDatabase();
        String r2 = buildSearchSQL(r10, MATCH_COLUMNS_PRIMARY, true);
        OLog.d(LOG_TAG, "Search primary query: " + r2);
        String r9 = buildSearchSQL(r10, MATCH_COLUMNS_SECONDARY, false) + " EXCEPT " + r2;
        OLog.d(LOG_TAG, "Search secondary query: " + r9);
        return new MergeCursor(new Cursor[]{r0.rawQuery(r2, null), r0.rawQuery(r9, null)});
    }

    public Cursor getSuggestions(String r3) {
        String r4 = buildSuggestionsSQL(r3);
        OLog.d(LOG_TAG, "Suggestions query: " + r4);
        return getReadableDatabase().rawQuery(r4, null);
    }

    private String buildSuggestionsSQL(String r2) {
        StringBuilder r1 = new StringBuilder("SELECT query FROM saved_queries");
        if (TextUtils.isEmpty(r2) == false) goto L5;
        r1.append(" ORDER BY rowId DESC");
    L6:
        r1.append(" LIMIT 5");
        return r1.toString();
    L5:
        r1.append(" WHERE query LIKE '");
        r1.append(r2);
        r1.append("%'");
        goto L6
    }

    public long addSavedQuery(String r6) {
        SaveSearchQueryTask r2 = new SaveSearchQueryTask(this, null);
        r2.execute(new String[]{r6});
        return r2.get().longValue();
    L8:
        e = move-exception;
        OLog.e(LOG_TAG, "Cannot insert saved query: " + r6, e);
        return -1;
    L5:
        e = move-exception;
        OLog.e(LOG_TAG, "Cannot insert saved query: " + r6, e);
        return -1;
    }

    private boolean addIndexablesFromRemoteProvider(String r10, String r11) {
        int r7 = Ranking.getBaseRankForAuthority(r11);     // Catch: PackageManager.NameNotFoundException -> L10
        if (this.mBaseAuthority.equals(r11) == false) goto L6;
        Context r1 = this.mContext;     // Catch: PackageManager.NameNotFoundException -> L10
    L7:
        Context r8 = r1;
        addIndexablesForXmlResourceUri(r8, r10, buildUriForXmlResources(r11), SearchIndexablesContract.INDEXABLES_XML_RES_COLUMNS, r7);     // Catch: PackageManager.NameNotFoundException -> L10
        addIndexablesForRawDataUri(r8, r10, buildUriForRawData(r11), SearchIndexablesContract.INDEXABLES_RAW_COLUMNS, r7);     // Catch: PackageManager.NameNotFoundException -> L10
        return true;
    L6:
        r1 = this.mContext.createPackageContext(r10, 0);     // Catch: PackageManager.NameNotFoundException -> L10
    L10:
        e = move-exception;
        OLog.w(LOG_TAG, "Could not create context for " + r10 + ": " + Log.getStackTraceString(e));
        return false;
    }

    private void addNonIndexablesKeysFromRemoteProvider(String r1, String r2) {
        addNonIndexableKeys(r1, getNonIndexablesKeysFromRemoteProvider(r1, r2));
    }

    private List<String> getNonIndexablesKeysFromRemoteProvider(String r3, String r4) {
        return getNonIndexablesKeys(this.mContext.createPackageContext(r3, 0), buildUriForNonIndexableKeys(r4), SearchIndexablesContract.NON_INDEXABLES_KEYS_COLUMNS);
    L4:
        e = move-exception;
        OLog.w(LOG_TAG, "Could not create context for " + r3 + ": " + Log.getStackTraceString(e));
        return EMPTY_LIST;
    }

    private List<String> getNonIndexablesKeys(Context r7, Uri r8, String[] r9) {
        Cursor r6 = r7.getContentResolver().query(r8, r9, null, null, null);
        if (r6 != null) goto L6;
        OLog.w(LOG_TAG, "Cannot add index data for Uri: " + r8.toString());
        return EMPTY_LIST;
    L6:
        ArrayList r10 = new ArrayList();
    L15:
        th = move-exception;
        r6.close();
        throw th;
    L8:
        if (r6.getCount() > 0) goto L10;
    L13:
        r6.close();
        return r10;
    L10:
        if (r6.moveToNext() == false) goto L13;
        r10.add(r6.getString(0));     // Catch: Throwable -> L15
        goto L10
    }

    public void addIndexableData(SearchIndexableData r2) {
        UpdateData r0 = this.mDataToProcess;
        monitor-enter(r0);
        this.mDataToProcess.dataToUpdate.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addIndexableData(SearchIndexableResource[] r6) {
        UpdateData r0 = this.mDataToProcess;
        monitor-enter(r0);
        int r1 = r6.length;     // Catch: Throwable -> L9
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L7;
        this.mDataToProcess.dataToUpdate.add(r6[r2]);     // Catch: Throwable -> L9
        r2 = r2 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void deleteIndexableData(SearchIndexableData r2) {
        UpdateData r0 = this.mDataToProcess;
        monitor-enter(r0);
        this.mDataToProcess.dataToDelete.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addNonIndexableKeys(String r2, List<String> r3) {
        UpdateData r0 = this.mDataToProcess;
        monitor-enter(r0);
        this.mDataToProcess.nonIndexableKeys.put(r2, r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isWellKnownProvider(ResolveInfo r5) {
        String r0 = r5.providerInfo.authority;
        String r1 = r5.providerInfo.applicationInfo.packageName;
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r1) == true) goto L19;
        String r2 = r5.providerInfo.readPermission;
        String r6 = r5.providerInfo.writePermission;
        if (TextUtils.isEmpty(r2) == true) goto L19;
        if (TextUtils.isEmpty(r6) == true) goto L19;
        if ("android.permission.READ_SEARCH_INDEXABLES".equals(r2) == false) goto L19;
        if ("android.permission.READ_SEARCH_INDEXABLES".equals(r6) == false) goto L19;
        return isPrivilegedPackage(r1);
    }

    private boolean isPrivilegedPackage(String r2) {
        PackageInfo r1 = this.mContext.getPackageManager().getPackageInfo(r2, 0);     // Catch: PackageManager.NameNotFoundException -> L11
        if (r1 != null) goto L6;
        return false;
    L6:
        if ((r1.applicationInfo.privateFlags & 8) == 0) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    private void updateFromRemoteProvider(String r1, String r2) {
        if (addIndexablesFromRemoteProvider(r1, r2) == false) goto L6;
        updateInternal();
        return;
    }

    public void updateFromClassNameResource(String r2, final boolean r3, boolean r4) {
        if (r2 == null) goto L10;
        final SearchIndexableResource r0 = SearchIndexableResources.getResourceByName(r2);
        if (r0 != null) goto L7;
        OLog.e(LOG_TAG, "Cannot find SearchIndexableResources for class name: " + r2);
        return;
    L7:
        r0.context = this.mContext;
        r0.enabled = r4;
        AsyncTask.execute(new AnonymousClass1(this, r3, r0));
        return;
    L10:
        throw new IllegalArgumentException("class name cannot be null!");
    }

    public void updateFromSearchIndexableData(final SearchIndexableData r2) {
        AsyncTask.execute(new AnonymousClass2(this, r2));
    }

    private SQLiteDatabase getReadableDatabase() {
        return IndexDatabaseHelper.getInstance(this.mContext).getReadableDatabase();
    }

    private SQLiteDatabase getWritableDatabase() {
        return IndexDatabaseHelper.getInstance(this.mContext).getWritableDatabase();
    L4:
        e = move-exception;
        OLog.e(LOG_TAG, "Cannot open writable database", e);
        return null;
    }

    private static Uri buildUriForXmlResources(String r2) {
        return Uri.parse("content://" + r2 + "/settings/indexables_xml_res");
    }

    private static Uri buildUriForRawData(String r2) {
        return Uri.parse("content://" + r2 + "/settings/indexables_raw");
    }

    private static Uri buildUriForNonIndexableKeys(String r2) {
        return Uri.parse("content://" + r2 + "/settings/non_indexables_key");
    }

    private void updateInternal() {
        UpdateData r0 = this.mDataToProcess;
        monitor-enter(r0);
        new UpdateIndexTask(this, null).execute(new UpdateData[]{this.mDataToProcess.copy()});     // Catch: Throwable -> L7
        this.mDataToProcess.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void addIndexablesForXmlResourceUri(Context r8, String r9, Uri r10, String[] r11, int r12) {
        Cursor r13 = r8.getContentResolver().query(r10, r11, null, null, null);
        if (r13 != null) goto L21;
        OLog.w(LOG_TAG, "Cannot add index data for Uri: " + r10.toString());
        return;
    L21:
    L18:
        th = move-exception;
        r13.close();
        throw th;
    L7:
        if (r13.getCount() <= 0) goto L16;
    L8:
        if (r13.moveToNext() == false) goto L16;
        int r14 = r13.getInt(0);     // Catch: Throwable -> L18
        if (r14 <= 0) goto L13;
        int r15 = r14 + r12;     // Catch: Throwable -> L18
    L14:
        int r0 = r13.getInt(1);     // Catch: Throwable -> L18
        String r1 = r13.getString(2);     // Catch: Throwable -> L18
        int r2 = r13.getInt(3);     // Catch: Throwable -> L18
        String r3 = r13.getString(4);     // Catch: Throwable -> L18
        String r4 = r13.getString(5);     // Catch: Throwable -> L18
        String r5 = r13.getString(6);     // Catch: Throwable -> L18
        SearchIndexableResource r6 = new SearchIndexableResource(r8);     // Catch: Throwable -> L18
        r6.rank = r15;     // Catch: Throwable -> L18
        r6.xmlResId = r0;     // Catch: Throwable -> L18
        r6.className = r1;     // Catch: Throwable -> L18
        r6.packageName = r9;     // Catch: Throwable -> L18
        r6.iconResId = r2;     // Catch: Throwable -> L18
        r6.intentAction = r3;     // Catch: Throwable -> L18
        r6.intentTargetPackage = r4;     // Catch: Throwable -> L18
        r6.intentTargetClass = r5;     // Catch: Throwable -> L18
        addIndexableData(r6);     // Catch: Throwable -> L18
        goto L8
    L13:
        r15 = r12;
    L16:
        r13.close();
    }

    private void addIndexablesForRawDataUri(Context r17, String r18, Uri r19, String[] r20, int r21) {
        Cursor r1 = r17.getContentResolver().query(r19, r20, null, null, null);
        if (r1 != null) goto L26;
        OLog.w(LOG_TAG, "Cannot add index data for Uri: " + r19.toString());
        return;
    L26:
    L22:
        th = th;
        Cursor r22 = r1;
    L24:
        r22.close();
        throw th;
    L7:
        if (r1.getCount() <= 0) goto L20;
    L8:
        if (r1.moveToNext() == false) goto L20;
        int r0 = r1.getInt(0);     // Catch: Throwable -> L22
        if (r0 <= 0) goto L13;
        int r2 = r21 + r0;     // Catch: Throwable -> L22
    L14:
        String r3 = r1.getString(1);     // Catch: Throwable -> L22
        String r4 = r1.getString(2);     // Catch: Throwable -> L22
        String r5 = r1.getString(3);     // Catch: Throwable -> L22
        String r6 = r1.getString(4);     // Catch: Throwable -> L22
        String r7 = r1.getString(5);     // Catch: Throwable -> L22
        String r8 = r1.getString(6);     // Catch: Throwable -> L22
        String r9 = r1.getString(7);     // Catch: Throwable -> L22
        int r10 = r1.getInt(8);     // Catch: Throwable -> L22
        String r11 = r1.getString(9);     // Catch: Throwable -> L22
        String r12 = r1.getString(10);     // Catch: Throwable -> L22
        String r13 = r1.getString(11);     // Catch: Throwable -> L22
        String r14 = r1.getString(12);     // Catch: Throwable -> L22
        int r15 = r1.getInt(13);     // Catch: Throwable -> L22
        r22 = r1;
        SearchIndexableRaw r16 = new SearchIndexableRaw(r17);     // Catch: Throwable -> L18
        r16.rank = r2;     // Catch: Throwable -> L18
        r16.title = r3;     // Catch: Throwable -> L18
        r16.summaryOn = r4;     // Catch: Throwable -> L18
        r16.summaryOff = r5;     // Catch: Throwable -> L18
        r16.entries = r6;     // Catch: Throwable -> L18
        r16.keywords = r7;     // Catch: Throwable -> L18
        r16.screenTitle = r8;     // Catch: Throwable -> L18
        r16.className = r9;     // Catch: Throwable -> L18
        r16.packageName = r18;     // Catch: Throwable -> L18
        r16.iconResId = r10;     // Catch: Throwable -> L18
        r16.intentAction = r11;     // Catch: Throwable -> L18
        r16.intentTargetPackage = r12;     // Catch: Throwable -> L18
        r16.intentTargetClass = r13;     // Catch: Throwable -> L18
        r16.key = r14;     // Catch: Throwable -> L18
        r16.userId = r15;     // Catch: Throwable -> L18
        addIndexableData(r16);     // Catch: Throwable -> L18
        r1 = r22;
    L18:
        th = th;
        goto L24
    L13:
        r2 = r21;
    L20:
        r1.close();
    }

    private String buildSearchSQL(String r2, String[] r3, boolean r4) {
        StringBuilder r0 = new StringBuilder();
        r0.append(buildSearchSQLForColumn(r2, r3));
        if (r4 == false) goto L6;
        r0.append(" ORDER BY data_rank");
    L6:
        return r0.toString();
    }

    private String buildSearchSQLForColumn(String r5, String[] r6) {
        StringBuilder r0 = new StringBuilder("SELECT ");
        int r1 = 0;
    L3:
        String[] r2 = SELECT_COLUMNS;
        if (r1 >= r2.length) goto L9;
        r0.append(r2[r1]);
        if (r1 >= (r2.length - 1)) goto L8;
        r0.append(", ");
    L8:
        r1 = r1 + 1;
        goto L3
    L9:
        r0.append(" FROM prefs_index WHERE ");
        r0.append(buildSearchWhereStringForColumns(r5, r6));
        return r0.toString();
    }

    private String buildSearchWhereStringForColumns(String r3, String[] r4) {
        StringBuilder r0 = new StringBuilder(IndexDatabaseHelper.Tables.TABLE_PREFS_INDEX);
        r0.append(" MATCH ");
        DatabaseUtils.appendEscapedSQLString(r0, buildSearchMatchStringForColumns(r3, r4));
        r0.append(" AND ");
        r0.append("locale");
        r0.append(" = ");
        DatabaseUtils.appendEscapedSQLString(r0, Locale.getDefault().toString());
        r0.append(" AND ");
        r0.append(IndexDatabaseHelper.IndexColumns.ENABLED);
        r0.append(" = 1");
        return r0.toString();
    }

    private String buildSearchMatchStringForColumns(String r4, String[] r5) {
        String r3 = r4 + ApnEditor.APN_TYPE_ALL;
        StringBuilder r6 = new StringBuilder();
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        r6.append(r5[r1]);
        r6.append(":");
        r6.append(r3);
        if (r1 >= (r0 - 1)) goto L7;
        r6.append(" OR ");
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return r6.toString();
    }

    private void indexOneSearchIndexableData(SQLiteDatabase r2, String r3, SearchIndexableData r4, Map<String, List<String>> r5) {
        if ((r4 instanceof SearchIndexableResource) == false) goto L6;
        indexOneResource(r2, r3, (SearchIndexableResource) r4, r5);
        return;
    L6:
        if ((r4 instanceof SearchIndexableRaw) == false) goto L10;
        indexOneRaw(r2, r3, (SearchIndexableRaw) r4);
        return;
    }

    private void indexOneRaw(SQLiteDatabase r21, String r22, SearchIndexableRaw r23) {
        if (r23.locale.toString().equalsIgnoreCase(r22) == true) goto L5;
        return;
    L5:
        updateOneRowWithFilteredData(r21, r22, r23.title, r23.summaryOn, r23.summaryOff, r23.entries, r23.className, r23.screenTitle, r23.iconResId, r23.rank, r23.keywords, r23.intentAction, r23.intentTargetPackage, r23.intentTargetClass, r23.enabled, r23.key, r23.userId);
    }

    private static boolean isIndexableClass(Class<?> r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (Indexable.class.isAssignableFrom(r1) == false) goto L6;
        return true;
    }

    private static Class<?> getIndexableClass(String r3) {
        Class<?> r4 = Class.forName(r3);     // Catch: ClassNotFoundException -> L8
        if (isIndexableClass(r4) == true) goto L7;
        return null;
    L7:
        return r4;
    L8:
        OLog.d(LOG_TAG, "Cannot find class: " + r3);
        return null;
    }

    private void indexOneResource(SQLiteDatabase r13, String r14, SearchIndexableResource r15, Map<String, List<String>> r16) {
        if (r15 != null) goto L6;
        OLog.e(LOG_TAG, "Cannot index a null resource!");
        return;
    L6:
        ArrayList r11 = new ArrayList();
        if (r15.xmlResId <= SearchIndexableResources.NO_DATA_RES_ID) goto L15;
        List<String> r2 = r16.get(r15.packageName);
        if (r2 != null) goto L11;
    L13:
        indexFromResource(r15.context, r13, r14, r15.xmlResId, r15.className, r15.iconResId, r15.rank, r15.intentAction, r15.intentTargetPackage, r15.intentTargetClass, r11);
        return;
    L11:
        if (r2.size() <= 0) goto L13;
        r11.addAll(r2);
        goto L13
    L15:
        if (TextUtils.isEmpty(r15.className) == false) goto L18;
        OLog.w(LOG_TAG, "Cannot index an empty Search Provider name!");
        return;
    L18:
        Class<?> r3 = getIndexableClass(r15.className);
        if (r3 != null) goto L22;
        OLog.d(LOG_TAG, "SearchIndexableResource '" + r15.className + "' should implement the " + Indexable.class.getName() + " interface!");
        return;
    L22:
        Indexable.SearchIndexProvider r4 = getSearchIndexProvider(r3);
        if (r4 == null) goto L32;
        List<String> r5 = r4.getNonIndexableKeys(r15.context);
        if (r5 != null) goto L27;
    L29:
        indexFromProvider(this.mContext, r13, r14, r4, r15.className, r15.iconResId, r15.rank, r15.enabled, r11);
        return;
    L27:
        if (r5.size() <= 0) goto L29;
        r11.addAll(r5);
        goto L29
    }

    private Indexable.SearchIndexProvider getSearchIndexProvider(Class<?> r3) {
        return (Indexable.SearchIndexProvider) r3.getField(FIELD_NAME_SEARCH_INDEX_DATA_PROVIDER).get(null);
    L6:
        OLog.d(LOG_TAG, "Illegal access to field 'SEARCH_INDEX_DATA_PROVIDER'");
    L9:
        return null;
    L5:
        OLog.d(LOG_TAG, "Illegal argument when accessing field 'SEARCH_INDEX_DATA_PROVIDER'");
    L8:
        OLog.d(LOG_TAG, "Cannot find field 'SEARCH_INDEX_DATA_PROVIDER'");
    L7:
        OLog.d(LOG_TAG, "Security exception for field 'SEARCH_INDEX_DATA_PROVIDER'");
        goto L9
    }

    /* JADX WARN: Not initialized variable reg: 26, insn: 0x018e: MOVE (r2 I:??[OBJECT, ARRAY]) = (r26 I:??[OBJECT, ARRAY]), block:B:61:0x018c */
    private void indexFromResource(Context r29, SQLiteDatabase r30, String r31, int r32, String r33, int r34, int r35, String r36, String r37, String r38, List<String> r39) {
        XmlResourceParser r19 = null;
        XmlResourceParser r20 = r29.getResources().getXml(r32);     // Catch: Throwable -> L69 IOException -> L71 XmlPullParserException -> L75
        if (r20 != null) goto L83;
        if (r20 == null) goto L102;
        r20.close();
        return;
    L102:
        return;
    L83:
        int r1 = r20.next();     // Catch: Throwable -> L62 IOException -> L64 XmlPullParserException -> L67
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L83;
    L13:
        String r2 = r20.getName();     // Catch: Throwable -> L62 IOException -> L64 XmlPullParserException -> L67
        if ("PreferenceScreen".equals(r2) == false) goto L57;
        int r11 = r20.getDepth();     // Catch: Throwable -> L62 IOException -> L64 XmlPullParserException -> L67
        AttributeSet r10 = Xml.asAttributeSet(r20);     // Catch: Throwable -> L62 IOException -> L64 XmlPullParserException -> L67
        String r21 = getDataTitle(r29, r10);     // Catch: Throwable -> L62 IOException -> L64 XmlPullParserException -> L67
        String r9 = getDataKey(r29, r10);     // Catch: Throwable -> L62 IOException -> L64 XmlPullParserException -> L67
        if (r39.contains(r9) == true) goto L21;
    L19:
        updateOneRowWithFilteredData(r30, r31, getDataTitle(r29, r10), getDataSummary(r29, r10), null, null, r33, r21, r34, r35, getDataKeywords(r29, r10), r36, r37, r38, true, r9, -1);     // Catch: IOException -> L58 XmlPullParserException -> L60 Throwable -> L62
    L21:
        int r3 = r20.next();     // Catch: IOException -> L58 XmlPullParserException -> L60 Throwable -> L62
        if (r3 == 1) goto L52;
        if (r3 != 3) goto L28;
        int r14 = r11;
        if (r20.getDepth() <= r14) goto L52;
    L29:
        if (r3 == 3) goto L51;
        if (r3 == 4) goto L51;
        String r4 = r20.getName();     // Catch: IOException -> L58 XmlPullParserException -> L60 Throwable -> L62
        AttributeSet r12 = r10;
        String r13 = getDataKey(r29, r12);     // Catch: IOException -> L58 XmlPullParserException -> L60 Throwable -> L62
        if (r39.contains(r13) == true) goto L35;
        String r5 = getDataTitle(r29, r12);     // Catch: IOException -> L58 XmlPullParserException -> L60 Throwable -> L62
        String r17 = getDataKeywords(r29, r12);     // Catch: IOException -> L58 XmlPullParserException -> L60 Throwable -> L62
        if (r4.equals(NODE_NAME_CHECK_BOX_PREFERENCE) == false) goto L38;
        int r23 = r14;
        String r6 = getDataSummaryOn(r29, r12);     // Catch: IOException -> L58 XmlPullParserException -> L60 Throwable -> L62
        String r7 = getDataSummaryOff(r29, r12);     // Catch: IOException -> L58 XmlPullParserException -> L60 Throwable -> L62
        if (TextUtils.isEmpty(r6) == true) goto L46;
    L48:
        updateOneRowWithFilteredData(r30, r31, r5, r6, r7, null, r33, r21, r34, r35, r17, r36, r37, r38, true, r13, -1);     // Catch: IOException -> L58 XmlPullParserException -> L60 Throwable -> L62
        r11 = r23;
        r10 = r12;
        goto L21
    L46:
        if (TextUtils.isEmpty(r7) == false) goto L48;
        r6 = getDataSummary(r29, r12);     // Catch: IOException -> L58 XmlPullParserException -> L60 Throwable -> L62
        goto L48
    L38:
        String r8 = getDataSummary(r29, r12);     // Catch: IOException -> L58 XmlPullParserException -> L60 Throwable -> L62
        if (r4.endsWith(NODE_NAME_LIST_PREFERENCE) == false) goto L41;
        String r15 = getDataEntries(r29, r12);     // Catch: IOException -> L58 XmlPullParserException -> L60 Throwable -> L62
    L42:
        updateOneRowWithFilteredData(r30, r31, r5, r8, null, r15, r33, r21, r34, r35, r17, r36, r37, r38, true, r13, -1);     // Catch: IOException -> L58 XmlPullParserException -> L60 Throwable -> L62
        r11 = r14;
        r10 = r12;
        goto L21
    L41:
        r15 = null;
        goto L42
    L35:
        r10 = r12;
    L51:
        r11 = r14;
        goto L21
    L28:
        r14 = r11;
    L52:
        if (r20 == null) goto L103;
        r20.close();
        return;
    L103:
        return;
    L57:
        throw new RuntimeException("XML document must start with <PreferenceScreen> tag; found" + r2 + " at " + r20.getPositionDescription());     // Catch: IOException -> L58 XmlPullParserException -> L60 Throwable -> L62
    L58:
        e = e;
    L74:
        throw new RuntimeException("Error parsing PreferenceScreen", e);     // Catch: Throwable -> L69
    L60:
        e = e;
        String r16 = r26;
    L78:
        throw new RuntimeException(r16, e);     // Catch: Throwable -> L69
    L62:
        th = th;
        r19 = r20;
    L79:
        if (r19 == null) goto L81;
        r19.close();
    L81:
        throw th;
    L64:
        e = e;
    L67:
        e = e;
        r16 = "Error parsing PreferenceScreen";
        goto L78
    L69:
        th = th;
    L71:
        e = e;
    L75:
        e = e;
        r16 = "Error parsing PreferenceScreen";
        goto L78
    }

    private void indexFromProvider(Context r32, SQLiteDatabase r33, String r34, Indexable.SearchIndexProvider r35, String r36, int r37, int r38, boolean r39, List<String> r40) {
        String r11 = r34;
        if (r35 != null) goto L6;
        OLog.w(LOG_TAG, "Cannot find provider: " + r36);
        return;
    L6:
        List<SearchIndexableRaw> r2 = r35.getRawDataToIndex(r32, r39);
        if (r2 == null) goto L18;
        int r4 = r2.size();
        int r5 = 0;
    L9:
        if (r5 >= r4) goto L18;
        SearchIndexableRaw r6 = r2.get(r5);
        if (r6.locale.toString().equalsIgnoreCase(r11) == true) goto L14;
    L17:
        r5 = r5 + 1;
        goto L9
    L14:
        if (r40.contains(r6.key) == true) goto L17;
        updateOneRowWithFilteredData(r33, r34, r6.title, r6.summaryOn, r6.summaryOff, r6.entries, r36, r6.screenTitle, r37, r38, r6.keywords, r6.intentAction, r6.intentTargetPackage, r6.intentTargetClass, r6.enabled, r6.key, r6.userId);
    L18:
        List<SearchIndexableResource> r13 = r35.getXmlResourcesToIndex(r32, r39);
        if (r13 == null) goto L39;
        int r14 = r13.size();
        int r15 = 0;
    L21:
        if (r15 >= r14) goto L47;
        SearchIndexableResource r0 = r13.get(r15);
        if (r0.locale.toString().equalsIgnoreCase(r11) == false) goto L38;
        if (r0.iconResId != 0) goto L28;
        int r7 = r37;
    L30:
        if (r0.rank != 0) goto L32;
        int r8 = r38;
    L34:
        if (TextUtils.isEmpty(r0.className) == false) goto L36;
        String r9 = r36;
    L37:
        indexFromResource(r32, r33, r34, r0.xmlResId, r9, r7, r8, r0.intentAction, r0.intentTargetPackage, r0.intentTargetClass, r40);
        goto L38
    L36:
        r9 = r0.className;
        goto L37
    L32:
        r8 = r0.rank;
        goto L34
    L28:
        r7 = r0.iconResId;
    L38:
        r15 = r15 + 1;
        r11 = r34;
        goto L21
    L47:
        return;
    }

    private void updateOneRowWithFilteredData(SQLiteDatabase r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, int r30, int r31, String r32, String r33, String r34, String r35, boolean r36, String r37, int r38) {
        String r4 = normalizeHyphen(r24);
        String r6 = normalizeHyphen(r25);
        String r8 = normalizeHyphen(r26);
        updateOneRow(r22, r23, r4, normalizeString(r4), r6, normalizeString(r6), r8, normalizeString(r8), r27, r28, r29, r30, r31, normalizeKeywords(r32), r33, r34, r35, r36, r37, r38);
    }

    private static String normalizeHyphen(String r2) {
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2.replaceAll(NON_BREAKING_HYPHEN, HYPHEN);
    }

    private static String normalizeString(String r2) {
        if (r2 == null) goto L5;
        String r3 = r2.replaceAll(HYPHEN, "");
    L6:
        String r4 = Normalizer.normalize(r3, Normalizer.Form.NFD);
        return REMOVE_DIACRITICALS_PATTERN.matcher(r4).replaceAll("").toLowerCase();
    L5:
        r3 = "";
        goto L6
    }

    private static String normalizeKeywords(String r2) {
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2.replaceAll(LIST_DELIMITERS, " ");
    }

    private void updateOneRow(SQLiteDatabase r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, int r17, int r18, String r19, String r20, String r21, String r22, boolean r23, String r24, int r25) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        int r2 = (r8 + r16).hashCode();
        ContentValues r3 = new ContentValues();
        r3.put(IndexDatabaseHelper.IndexColumns.DOCID, Integer.valueOf(r2));
        r3.put("locale", r7);
        r3.put(IndexDatabaseHelper.IndexColumns.DATA_RANK, Integer.valueOf(r18));
        r3.put(IndexDatabaseHelper.IndexColumns.DATA_TITLE, r8);
        r3.put(IndexDatabaseHelper.IndexColumns.DATA_TITLE_NORMALIZED, r9);
        r3.put(IndexDatabaseHelper.IndexColumns.DATA_SUMMARY_ON, r10);
        r3.put(IndexDatabaseHelper.IndexColumns.DATA_SUMMARY_ON_NORMALIZED, r11);
        r3.put(IndexDatabaseHelper.IndexColumns.DATA_SUMMARY_OFF, r12);
        r3.put(IndexDatabaseHelper.IndexColumns.DATA_SUMMARY_OFF_NORMALIZED, r13);
        r3.put(IndexDatabaseHelper.IndexColumns.DATA_ENTRIES, r14);
        r3.put(IndexDatabaseHelper.IndexColumns.DATA_KEYWORDS, r19);
        r3.put(IndexDatabaseHelper.IndexColumns.CLASS_NAME, r15);
        r3.put(IndexDatabaseHelper.IndexColumns.SCREEN_TITLE, r16);
        r3.put(IndexDatabaseHelper.IndexColumns.INTENT_ACTION, r20);
        r3.put(IndexDatabaseHelper.IndexColumns.INTENT_TARGET_PACKAGE, r21);
        r3.put(IndexDatabaseHelper.IndexColumns.INTENT_TARGET_CLASS, r22);
        r3.put("icon", Integer.valueOf(r17));
        r3.put(IndexDatabaseHelper.IndexColumns.ENABLED, Boolean.valueOf(r23));
        r3.put(IndexDatabaseHelper.IndexColumns.DATA_KEY_REF, r24);
        r3.put("user_id", Integer.valueOf(r25));
        r6.replaceOrThrow(IndexDatabaseHelper.Tables.TABLE_PREFS_INDEX, null, r3);
    }

    private String getDataKey(Context r3, AttributeSet r4) {
        return getData(r3, r4, R.styleable.Preference, 6);
    }

    private String getDataTitle(Context r3, AttributeSet r4) {
        return getData(r3, r4, R.styleable.Preference, 4);
    }

    private String getDataSummary(Context r3, AttributeSet r4) {
        return getData(r3, r4, R.styleable.Preference, 7);
    }

    private String getDataSummaryOn(Context r3, AttributeSet r4) {
        return getData(r3, r4, R.styleable.CheckBoxPreference, 0);
    }

    private String getDataSummaryOff(Context r3, AttributeSet r4) {
        return getData(r3, r4, R.styleable.CheckBoxPreference, 1);
    }

    private String getDataEntries(Context r3, AttributeSet r4) {
        return getDataEntries(r3, r4, R.styleable.ListPreference, 0);
    }

    private String getDataKeywords(Context r3, AttributeSet r4) {
        return getData(r3, r4, com.android.settings.R.styleable.Preference, 27);
    }

    private String getData(Context r2, AttributeSet r3, int[] r4, int r5) {
        TypedArray r1 = r2.obtainStyledAttributes(r3, r4);
        TypedValue r6 = r1.peekValue(r5);
        if (r6 != null) goto L5;
    L10:
        CharSequence r7 = null;
    L11:
        r1.recycle();
        if (r7 != null) goto L14;
        return null;
    L14:
        return r7.toString();
    L5:
        if (r6.type != 3) goto L10;
        if (r6.resourceId == 0) goto L9;
        r7 = r2.getText(r6.resourceId);
        goto L11
    L9:
        r7 = r6.string;
        goto L11
    }

    private String getDataEntries(Context r2, AttributeSet r3, int[] r4, int r5) {
        TypedArray r1 = r2.obtainStyledAttributes(r3, r4);
        TypedValue r6 = r1.peekValue(r5);
        if (r6 != null) goto L5;
    L9:
        String[] r7 = null;
    L10:
        int r8 = 0;
        if (r7 != null) goto L13;
        int r9 = 0;
    L14:
        if (r9 != 0) goto L17;
        r1.recycle();
        return null;
    L17:
        StringBuilder r10 = new StringBuilder();
    L18:
        if (r8 >= r9) goto L20;
        r10.append(r7[r8]);
        r10.append(ENTRIES_SEPARATOR);
        r8 = r8 + 1;
        goto L18
    L20:
        r1.recycle();
        return r10.toString();
    L13:
        r9 = r7.length;
        goto L14
    L5:
        if (r6.type != 1) goto L9;
        if (r6.resourceId == 0) goto L9;
        r7 = r2.getResources().getStringArray(r6.resourceId);
        goto L10
    }

    private int getResId(Context r1, AttributeSet r2, int[] r3, int r4) {
        TypedArray r0 = r1.obtainStyledAttributes(r2, r3);
        TypedValue r5 = r0.peekValue(r4);
        r0.recycle();
        if (r5 != null) goto L5;
        return 0;
    L5:
        if (r5.type == 3) goto L7;
        return 0;
    L7:
        return r5.resourceId;
    }
}
