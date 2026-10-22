package com.android.settings.search;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import bytedanceos.app.settings.search.SearchResultItem;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public class SearchHistoryImpl implements ISearchHistory {
    private static final String DB_NAME = "search-history.db";
    private static final int DB_VERSION = 4;
    private static final String GET_ALL_ITEMS_QUERY = "SELECT * FROM search_history";
    private static final String GET_INTENT_QUERY = null;
    private static final String GET_TEXT_QUERY = null;
    private static final int MAX_ITEM_NUMBER = 21;
    private static final String TAG = "SearchHistoryImpl";
    private static final String WHERE_STATEMENT_BY_INTENT = null;
    private static final String WHERE_STATEMENT_BY_SHORTCUT_ID = null;
    private static final String WHERE_STATEMENT_BY_TEXT = null;
    private Context mContext;
    private Executor mExecutor;
    private DbOpenHelper mOpenHelper;
    private SQLiteDatabase mSQLiteDatabase;
    ThreadFactory mThreadFactory;

    private static class DbOpenHelper extends SQLiteOpenHelper {
        private final String CREATE_TABLE_CLAUSE;

        public DbOpenHelper(Context r1, String r2, SQLiteDatabase.CursorFactory r3, int r4) {
            super(r1, r2, r3, r4);
            this.CREATE_TABLE_CLAUSE = "CREATE TABLE IF NOT EXISTS search_history (" + SearchHistory.intent.name() + " TEXT NOT NULL, " + SearchHistory.text.name() + " TEXT NOT NULL COLLATE UNICODE PRIMARY KEY, " + SearchHistory.shortcut_id.name() + " TEXT NOT NULL, " + SearchHistory.is_switch.name() + " TEXT, " + SearchHistory.switch_table.name() + " TEXT, " + SearchHistory.switch_key.name() + " TEXT, " + SearchHistory.special_key.name() + " TEXT, " + SearchHistory.default_value.name() + " TEXT, " + SearchHistory.id.name() + " INTEGER, " + SearchHistory.icon_id.name() + " INTEGER, " + SearchHistory.path1.name() + " TEXT, " + SearchHistory.path2.name() + " TEXT);";
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r3) {
            OLog.d(SearchHistoryImpl.TAG, "onCreate ");
            r3.execSQL(this.CREATE_TABLE_CLAUSE);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r3, int r4, int r5) {
            OLog.d(SearchHistoryImpl.TAG, "onUpgrade from " + r4 + " to " + r5);
            if (r5 != 2) goto L6;
            reCreate(r3);
        L6:
            if (r5 != 3) goto L9;
            reCreate(r3);
        L9:
            if (r5 != 4) goto L12;
            reCreate(r3);
            return;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r3, int r4, int r5) {
            OLog.d(SearchHistoryImpl.TAG, "onDowngrade from " + r4 + " to " + r5);
            reCreate(r3);
        }

        private void reCreate(SQLiteDatabase r3) {
            OLog.d(SearchHistoryImpl.TAG, "reCreate ");
            r3.execSQL("drop table if exists search_history");
            r3.execSQL(this.CREATE_TABLE_CLAUSE);
        }
    }

    static final enum SearchHistory extends Enum<SearchHistory> {
        private static final /* synthetic */ SearchHistory[] $VALUES = null;
        static final String TABLE_NAME = "search_history";
        public static final SearchHistory default_value = null;
        public static final SearchHistory icon_id = null;
        public static final SearchHistory id = null;
        public static final SearchHistory intent = null;
        public static final SearchHistory is_switch = null;
        public static final SearchHistory path1 = null;
        public static final SearchHistory path2 = null;
        public static final SearchHistory shortcut_id = null;
        public static final SearchHistory special_key = null;
        public static final SearchHistory switch_key = null;
        public static final SearchHistory switch_table = null;
        public static final SearchHistory text = null;
        public final String fullName;

        private static /* synthetic */ SearchHistory[] $values() {
            return new SearchHistory[]{intent, text, shortcut_id, is_switch, switch_table, switch_key, special_key, default_value, id, icon_id, path1, path2};
        }

        public static SearchHistory valueOf(String r1) {
            return (SearchHistory) Enum.valueOf(SearchHistory.class, r1);
        }

        public static SearchHistory[] values() {
            return (SearchHistory[]) $VALUES.clone();
        }

        static {
            intent = new SearchHistory("intent", 0);
            text = new SearchHistory("text", 1);
            shortcut_id = new SearchHistory("shortcut_id", 2);
            is_switch = new SearchHistory("is_switch", 3);
            switch_table = new SearchHistory("switch_table", 4);
            switch_key = new SearchHistory("switch_key", 5);
            special_key = new SearchHistory("special_key", 6);
            default_value = new SearchHistory("default_value", 7);
            id = new SearchHistory("id", 8);
            icon_id = new SearchHistory(DatabaseHelper.ItemsRecord.ICON_ID, 9);
            path1 = new SearchHistory("path1", 10);
            path2 = new SearchHistory("path2", 11);
            $VALUES = $values();
        }

        private SearchHistory(String r1, int r2) {
            super(r1, r2);
            this.fullName = "search_history." + name();
        }
    }

    static /* synthetic */ List access$000(SearchHistoryImpl r0, SQLiteDatabase r1) {
        return r0.getAllItems(r1);
    }

    static /* synthetic */ String access$100() {
        return WHERE_STATEMENT_BY_SHORTCUT_ID;
    }

    static /* synthetic */ boolean access$200(SearchHistoryImpl r0, SearchResultItem r1, SQLiteDatabase r2) {
        return r0.isItemExist(r1, r2);
    }

    static /* synthetic */ boolean access$300(SearchHistoryImpl r0, SQLiteDatabase r1) {
        return r0.reachedMaxSize(r1);
    }

    static /* synthetic */ void access$400(SearchHistoryImpl r0) {
        r0.removeFirstItemAsync();
    }

    static /* synthetic */ void access$500(SearchHistoryImpl r0, ContentValues r1) {
        r0.addItem(r1);
    }

    static /* synthetic */ ContentValues access$600(SearchHistoryImpl r0, SearchResultItem r1) {
        return r0.makeCVofSearchResult(r1);
    }

    static /* synthetic */ void access$700(SearchHistoryImpl r0, SQLiteDatabase r1) {
        r0.removeFirstItem(r1);
    }

    static /* synthetic */ SQLiteDatabase access$800(SearchHistoryImpl r0) {
        return r0.mSQLiteDatabase;
    }

    static {
        GET_INTENT_QUERY = "SELECT " + SearchHistory.intent.name() + " FROM search_history";
        GET_TEXT_QUERY = "SELECT " + SearchHistory.text.name() + " FROM search_history";
        WHERE_STATEMENT_BY_INTENT = SearchHistory.intent.name() + " =?";
        WHERE_STATEMENT_BY_TEXT = SearchHistory.text.name() + " =?";
        WHERE_STATEMENT_BY_SHORTCUT_ID = SearchHistory.shortcut_id.name() + " =?";
    }

    public SearchHistoryImpl(Context r5) {
        ThreadFactory r0 = new ThreadFactoryBuilder().setNameFormat("ShortcutRepository #%d").setThreadFactory(new PriorityThreadFactory(10)).build();
        this.mThreadFactory = r0;
        this.mExecutor = Executors.newSingleThreadExecutor(r0);
        OLog.d(TAG, "SearchHistoryImpl ");
        this.mContext = r5;
        DbOpenHelper r6 = new DbOpenHelper(this.mContext, DB_NAME, null, 4);
        this.mOpenHelper = r6;
        this.mSQLiteDatabase = r6.getWritableDatabase();     // Catch: SQLiteCantOpenDatabaseException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.android.settings.search.ISearchHistory
    public void getAllItems(Consumer<List<SearchResultItem>> r2) {
        runQueryAsync(new AnonymousClass1(this), r2);
    }

    private void addItem(final ContentValues r2) {
        runTransactionAsync(new AnonymousClass2(this, r2));
    }

    @Override // com.android.settings.search.ISearchHistory
    public void removeItem(final String r2) {
        runTransactionAsync(new AnonymousClass3(this, r2));
    }

    @Override // com.android.settings.search.ISearchHistory
    public void isItemExist(final SearchResultItem r2, Consumer<Boolean> r3) {
        runQueryAsync(new AnonymousClass4(this, r2), r3);
    }

    public void reachedMaxSize(Consumer<Boolean> r2) {
        runQueryAsync(new AnonymousClass5(this), r2);
    }

    private boolean reachedMaxSize(SQLiteDatabase r2) {
        Cursor r1 = null;
        r1 = r2.rawQuery(GET_ALL_ITEMS_QUERY, null);     // Catch: Throwable -> L13
        if (r1 == null) goto L9;
        if (r1.getCount() < 21) goto L9;
        boolean r3 = true;
    L10:
        if (r1 == null) goto L12;
        r1.close();
    L12:
        return r3;
    L9:
        r3 = false;
    L13:
        th = move-exception;
        if (r1 == null) goto L16;
        r1.close();
    L16:
        throw th;
    }

    @Override // com.android.settings.search.ISearchHistory
    public void clearAllItems() {
        runTransactionAsync(new AnonymousClass6(this));
    }

    @Override // com.android.settings.search.ISearchHistory
    public void addItem(SearchResultItem r3) {
        final ContentValues r0 = makeCVofSearchResult(r3);
        isItemExist(r3, new AnonymousClass7(this, r0));
    }

    @Override // com.android.settings.search.ISearchHistory
    public void updateItem(final SearchResultItem r2) {
        runTransactionAsync(new AnonymousClass8(this, r2));
    }

    private ContentValues makeCVofSearchResult(SearchResultItem r3) {
        ContentValues r2 = new ContentValues();
        r2.put(SearchHistory.intent.name(), r3.mIntent);
        r2.put(SearchHistory.text.name(), r3.mText);
        r2.put(SearchHistory.shortcut_id.name(), r3.mShortcutId);
        r2.put(SearchHistory.is_switch.name(), r3.mIsSwitch);
        r2.put(SearchHistory.switch_table.name(), r3.mSwitchTable);
        r2.put(SearchHistory.switch_key.name(), r3.mSwitchKey);
        r2.put(SearchHistory.special_key.name(), r3.mSpecailKey);
        r2.put(SearchHistory.default_value.name(), r3.mDefaultValue);
        r2.put(SearchHistory.id.name(), Integer.valueOf(r3.mId));
        r2.put(SearchHistory.icon_id.name(), Integer.valueOf(r3.mIconId));
        r2.put(SearchHistory.path1.name(), r3.mPath1);
        r2.put(SearchHistory.path2.name(), r3.mPath2);
        return r2;
    }

    private void removeFirstItem(SQLiteDatabase r3) {
        Cursor r0 = null;
        r0 = r3.rawQuery(GET_ALL_ITEMS_QUERY, null);     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
    L10:
        if (r0 == null) goto L19;
        r0.close();
        return;
    L19:
        return;
    L6:
        if (r0.getCount() <= 0) goto L10;
        if (r0.moveToFirst() == false) goto L10;
        removeItem(r0.getString(r0.getColumnIndex(SearchHistory.shortcut_id.name())));     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        if (r0 == null) goto L16;
        r0.close();
    L16:
        throw th;
    }

    private void removeFirstItemAsync() {
        runTransactionAsync(new AnonymousClass9(this));
    }

    private List<SearchResultItem> getAllItems(SQLiteDatabase r3) {
        Cursor r0 = null;
        DatabaseHelper.getInstance(this.mContext).ensureSearchDataReadyForQuery();     // Catch: Throwable -> L7
        r0 = r3.rawQuery(GET_ALL_ITEMS_QUERY, null);     // Catch: Throwable -> L7
        List<SearchResultItem> r2 = getItemsFromCursor(r0);     // Catch: Throwable -> L7
        if (r0 == null) goto L6;
        r0.close();
    L6:
        return r2;
    L7:
        th = move-exception;
        if (r0 == null) goto L10;
        r0.close();
    L10:
        throw th;
    }

    private SearchResultItem getHistory(SearchResultItem r10) {
        Uri r0 = Uri.parse("content://com.android.settings.SearchSuggestionProvider/search_suggest_shortcut");
        SearchResultItem r1 = null;
        DatabaseHelper.getInstance(this.mContext).ensureSearchDataReadyForQuery();     // Catch: Throwable -> L14
        SearchResultItem r2 = this.mContext.getContentResolver().query(Uri.withAppendedPath(r0, r10.mShortcutId), null, null, null, null);     // Catch: Throwable -> L14
        if (r2 != null) goto L18;
    L11:
        if (r2 == null) goto L13;
        r2.close();
    L13:
        return r1;
    L18:
    L9:
        th = th;
        r1 = r2;
    L15:
        if (r1 == null) goto L17;
        r1.close();
    L17:
        throw th;
    L6:
        if (r2.moveToFirst() == false) goto L11;
        r1 = makeSearchResultItem(r10.mId, r2);     // Catch: Throwable -> L9
    L14:
        th = th;
        goto L15
    }

    private SearchResultItem makeSearchResultItem(int r26, Cursor r27) {
        int r1 = r27.getColumnIndex("suggest_intent_data");
        int r2 = r27.getColumnIndex("suggest_text_1");
        int r3 = r27.getColumnIndex("suggest_shortcut_id");
        int r4 = r27.getColumnIndex("is_switch");
        int r5 = r27.getColumnIndex("switch_table");
        int r6 = r27.getColumnIndex("switch_key");
        int r7 = r27.getColumnIndex("special_key");
        int r8 = r27.getColumnIndex("def_value");
        int r9 = r27.getColumnIndex(DatabaseHelper.ItemsRecord.ICON_ID);
        int r10 = r27.getColumnIndex(DatabaseHelper.ItemsRecord.ITEM_PATH_1);
        int r11 = r27.getColumnIndex(DatabaseHelper.ItemsRecord.ITEM_PATH_2);
        return new SearchResultItem(r26, r27.getString(r1), r27.getString(r2), r27.getString(r3), r27.getString(r4), r27.getString(r5), r27.getString(r6), r27.getString(r7), r27.getString(r8), r27.getInt(r9), r27.getString(r10), r27.getString(r11));
    }

    private boolean isItemExist(SearchResultItem r5, SQLiteDatabase r6) {
        Cursor r4 = null;
        boolean r1 = true;
        r4 = r6.rawQuery(GET_TEXT_QUERY + " WHERE " + WHERE_STATEMENT_BY_SHORTCUT_ID, new String[]{r5.mShortcutId});     // Catch: Throwable -> L12
        if (r4 == null) goto L8;
        if (r4.getCount() <= 0) goto L8;
    L9:
        if (r4 == null) goto L11;
        r4.close();
    L11:
        return r1;
    L8:
        r1 = false;
    L12:
        th = move-exception;
        if (r4 == null) goto L15;
        r4.close();
    L15:
        throw th;
    }

    private <A> void runQueryAsync(final SQLiteAsyncQuery<A> r3, final Consumer<A> r4) {
        this.mExecutor.execute(new AnonymousClass10(this, r3, r4));
    }

    private void runTransactionAsync(final SQLiteTransaction r3) {
        this.mExecutor.execute(new AnonymousClass11(this, r3));
    }

    public List<SearchResultItem> getItemsFromCursor(Cursor r18) {
        if (r18 != null) goto L25;
    L21:
        if (r18 == null) goto L29;
        r18.close();
        return null;
    L29:
        return null;
    L25:
    L17:
        th = move-exception;
        if (r18 == null) goto L20;
        r18.close();
    L20:
        throw th;
    L5:
        if (r18.getCount() <= 0) goto L21;
        OLog.d(TAG, "cursor count is " + r18.getCount());     // Catch: Throwable -> L17
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L17
        if (r18.moveToFirst() == false) goto L13;
    L8:
        SearchResultItem r3 = getHistory(new SearchResultItem(r18.getInt(r18.getColumnIndex(SearchHistory.id.name())), r18.getString(r18.getColumnIndex(SearchHistory.intent.name())), r18.getString(r18.getColumnIndex(SearchHistory.text.name())), r18.getString(r18.getColumnIndex(SearchHistory.shortcut_id.name())), r18.getString(r18.getColumnIndex(SearchHistory.is_switch.name())), r18.getString(r18.getColumnIndex(SearchHistory.switch_table.name())), r18.getString(r18.getColumnIndex(SearchHistory.switch_key.name())), r18.getString(r18.getColumnIndex(SearchHistory.special_key.name())), r18.getString(r18.getColumnIndex(SearchHistory.default_value.name())), r18.getInt(r18.getColumnIndex(SearchHistory.icon_id.name())), r18.getString(r18.getColumnIndex(SearchHistory.path1.name())), r18.getString(r18.getColumnIndex(SearchHistory.path2.name()))));     // Catch: Throwable -> L17
        if (r3 == null) goto L12;
        handleItemIfContains(r2, r3);     // Catch: Throwable -> L17
        r2.add(r3);     // Catch: Throwable -> L17
    L12:
        if (r18.moveToNext() == true) goto L8;
    L13:
        Collections.reverse(r2);     // Catch: Throwable -> L17
        if (r18 == null) goto L16;
        r18.close();
    L16:
        return r2;
    }

    private void handleItemIfContains(List<SearchResultItem> r2, SearchResultItem r3) {
        if (r3.mIntent.contains("OptionsActivity/extra_index") == true) goto L5;
        return;
    L5:
        Iterator<SearchResultItem> r1 = r2.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        if (r1.next().mShortcutId.equals(r3.mShortcutId) == false) goto L7;
        r1.remove();
        goto L7
    }

    public void closeSQLiteDatabase() {
        SQLiteDatabase r0 = this.mSQLiteDatabase;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }
}
