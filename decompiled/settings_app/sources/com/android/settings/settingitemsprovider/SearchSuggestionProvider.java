package com.android.settings.settingitemsprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.android.settings.DataUsageFragment;
import com.android.settings.keva.AppSettingsKevaSp;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.search.api.schema.impl.bean.DocumentTokenPosition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SearchSuggestionProvider extends ContentProvider {
    public static final String AUTHORITY = "com.android.settings.SearchSuggestionProvider";
    public static final String METHOD_CHECK_HAS_SETTING = "searchAppContent";
    private static final int SEARCH_SUGGEST = 1;
    private static final int SEARCH_SUGGEST_IN_SETTINGS = 3;
    public static final String SETTING_ITEMS_PATH = "settingitems";
    private static final int SHORTCUT_REFRESH = 2;
    public static final String SUGGEST_URI_PATH_IN_SETTINGS = "search_suggest_settings";
    private static final String TAG = "SettingItems";
    private static final String[] mVirtualColumns = null;
    private static final UriMatcher sUriMatcher = null;
    private Context mContext;
    private Handler mHandler;

    class SettingItem {
        long _id;
        String component;
        int defValue;
        String extra;
        int iconId;
        int is_switch;
        String key;
        String name;
        String path1;
        String path2;
        String special_key;
        String table;
        final /* synthetic */ SearchSuggestionProvider this$0;

        SettingItem(SearchSuggestionProvider r1) {
            this.this$0 = r1;
        }
    }

    private String getSqlSelectionPrefix() {
        return "is_searchable = 1 ";
    }

    public void com_android_settings_settingitemsprovider_SearchSuggestionProvider__onCreate$___twin___() {
        super.onCreate();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public void onCreate() {
        com_android_settings_settingitemsprovider_SearchSuggestionProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(this);
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }

    static {
        UriMatcher r0 = new UriMatcher(-1);
        sUriMatcher = r0;
        r0.addURI(AUTHORITY, "search_suggest_query", 1);
        r0.addURI(AUTHORITY, "search_suggest_query/*", 1);
        r0.addURI(AUTHORITY, "search_suggest_shortcut", 2);
        r0.addURI(AUTHORITY, "search_suggest_shortcut/*", 2);
        r0.addURI(AUTHORITY, SUGGEST_URI_PATH_IN_SETTINGS, 3);
        r0.addURI(AUTHORITY, "search_suggest_settings/*", 3);
        mVirtualColumns = new String[]{"suggest_intent_data", "suggest_text_1", "suggest_shortcut_id", "is_switch", "switch_table", "switch_key", "special_key", "def_value", DatabaseHelper.ItemsRecord.ICON_ID, DatabaseHelper.ItemsRecord.ITEM_PATH_1, DatabaseHelper.ItemsRecord.ITEM_PATH_2};
    }

    public SearchSuggestionProvider() {
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mContext = getContext();
        return true;
    }

    private void updateDataIfNeeded() {
        if (AppSettingsKevaSp.getKevaFirstSearch().booleanValue() == false) goto L6;
        DatabaseHelper.getInstance(this.mContext).updateForFirstSearch();
        AppSettingsKevaSp.setKevaFirstSearch(false);
        return;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r3, String r4, Bundle r5) {
        Bundle r6 = new Bundle();
        if (METHOD_CHECK_HAS_SETTING.equals(r3) == false) goto L14;
        boolean r0 = false;
        if (TextUtils.isEmpty(r4) == true) goto L13;
        MatrixCursor r2 = getSuggestionSearchCursor(r4.replaceAll("_", "[_]").replaceAll("%", "[%]"));
        if (r2 != null) goto L9;
    L11:
        if (r2 == null) goto L13;
        r2.close();
        goto L13
    L9:
        if (r2.getCount() <= 0) goto L11;
        r0 = true;
    L13:
        r6.putBoolean("has_data", r0);
    L14:
        return r6;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        updateDataIfNeeded();
        int r6 = sUriMatcher.match(r1);
        if (r6 != 1) goto L5;
        String r7 = r4[0];
        r1.getQueryParameter(DataUsageFragment.INTENT_EXTRA_LIMIT);
        return getSuggestionSearchCursor(r7);
    L5:
        if (r6 != 2) goto L7;
        String r8 = r1.getLastPathSegment();
        OLog.d(TAG, "SHORTCUT_REFRESH id:" + r8);
        return getHistoryCursor(r8);
    L7:
        if (r6 == 3) goto L14;
        return null;
    L14:
        return getSuggestionSearchCursorById(r3);
    }

    private Cursor getHistoryCursor(String r11) {
        Cursor r2 = null;
        Cursor r12 = this.mContext.getContentResolver().query(SettingItemsProvider.CONTENT_URI, null, getSqlSelectionPrefix() + " and (_id=" + r11 + ")", null, null);     // Catch: Throwable -> L10 Exception -> L12
        MatrixCursor r10 = buildMatrixCursor(r12);     // Catch: Exception -> L8 Throwable -> L18
        if (r12 == null) goto L7;
        r12.close();
    L7:
        return r10;
    L8:
        e = e;
    L14:
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r12 == null) goto L17;
        r12.close();
    L17:
        return null;
    L18:
        th = th;
        r2 = r12;
    L20:
        if (r2 == null) goto L22;
        r2.close();
    L22:
        throw th;
    L12:
        e = e;
        r12 = null;
    L10:
        th = th;
        goto L20
    }

    private MatrixCursor getSuggestionSearchCursor(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return null;
    L5:
        if ("%".equals(r2) == false) goto L8;
        return null;
    L8:
        return mergeSuggestionCursors(getSuggestionSearchCursorByLike(r2), getSmartSuggestionSearchCursor(r2));
    }

    private MatrixCursor getSmartSuggestionSearchCursor(String r4) {
        LinkedHashSet<Long> r0 = new LinkedHashSet();
        ensureSearchIndexReady();     // Catch: Exception -> L5
        SearchEngine.loadSegmentationDict();     // Catch: Exception -> L5
        SearchEngine r1 = SearchEngine.getInstance(this.mContext);     // Catch: Exception -> L5
        addSearchResultIds(r0, r1.search(r4));     // Catch: Exception -> L5
        addSearchResultIds(r0, r1.smartSearch(r4));     // Catch: Exception -> L5
    L8:
        if (r0.isEmpty() == false) goto L12;
        return null;
    L12:
        return getSuggestionSearchCursorById("_id IN (" + TextUtils.join(",", r0) + ")");
    L5:
        e = move-exception;
        OLog.d(TAG, "smart search failed " + e.getMessage());
        goto L8
    }

    private void ensureSearchIndexReady() {
        DatabaseHelper r2 = DatabaseHelper.getInstance(this.mContext);
        r2.ensureSearchDataReadyForQuery();
        if (r2.isSearchIndexCreated() == true) goto L9;
        OLog.d(TAG, "ensureSearchIndexReady: rebuild search index");
        if (SearchEngine.isSearchEngineInit() == false) goto L7;
        r2.createSearchIndex();
        return;
    L7:
        r2.createSearchIndexWaitInitFinish();
        return;
    }

    private void addSearchResultIds(LinkedHashSet<Long> r3, List<DocumentTokenPosition> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Iterator<DocumentTokenPosition> r2 = r4.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        DocumentTokenPosition r5 = r2.next();
        if (r5 == null) goto L6;
        r3.add(Long.valueOf(r5.getId()));
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v2 */
    private MatrixCursor getSuggestionSearchCursorByLike(String r14) {
        ?? r4 = 0;
        Cursor r15 = this.mContext.getContentResolver().query(SettingItemsProvider.CONTENT_URI, null, getSqlSelectionPrefix() + " AND (REPLACE(name, ' ', '') LIKE '%" + r14.replace(HanziToPinyin.Token.SEPARATOR, "") + "%' OR REPLACE(alias, ' ', '') LIKE '%" + r14.replace(HanziToPinyin.Token.SEPARATOR, "") + "%')", null, null);     // Catch: Throwable -> L10 Exception -> L12
        MatrixCursor r13 = buildMatrixCursor(r15);     // Catch: Exception -> L8 Throwable -> L18
        if (r15 == null) goto L7;
        r15.close();
    L7:
        return r13;
    L8:
        e = e;
    L14:
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r15 == null) goto L17;
        r15.close();
    L17:
        return null;
    L18:
        th = th;
        r4 = r14;
    L20:
        if (r4 == 0) goto L22;
        r4.close();
    L22:
        throw th;
    L12:
        e = e;
        r15 = null;
    L10:
        th = th;
        goto L20
    }

    private MatrixCursor mergeSuggestionCursors(Cursor r4, Cursor r5) {
        if (r4 != null) goto L5;
    L6:
        if (r5 != null) goto L8;
    L14:
        closeCursor(r4);
        closeCursor(r5);
        return null;
    L8:
        if (r5.getCount() == 0) goto L14;
    L10:
        MatrixCursor r1 = new MatrixCursor(mVirtualColumns);
        LinkedHashSet<String> r2 = new LinkedHashSet();
        appendSuggestionRows(r1, r2, r4);
        appendSuggestionRows(r1, r2, r5);
        closeCursor(r4);
        closeCursor(r5);
        if (r1.getCount() > 0) goto L13;
        return null;
    L13:
        return r1;
    L5:
        if (r4.getCount() != 0) goto L10;
        goto L6
    }

    private void appendSuggestionRows(MatrixCursor r18, LinkedHashSet<String> r19, Cursor r20) {
        if (r20 != null) goto L5;
        return;
    L5:
        if (r20.getCount() == 0) goto L20;
        int r1 = r20.getColumnIndex("suggest_intent_data");
        int r2 = r20.getColumnIndex("suggest_text_1");
        int r3 = r20.getColumnIndex("suggest_shortcut_id");
        int r4 = r20.getColumnIndex("is_switch");
        int r5 = r20.getColumnIndex("switch_table");
        int r6 = r20.getColumnIndex("switch_key");
        int r7 = r20.getColumnIndex("special_key");
        int r8 = r20.getColumnIndex("def_value");
        int r9 = r20.getColumnIndex(DatabaseHelper.ItemsRecord.ICON_ID);
        int r10 = r20.getColumnIndex(DatabaseHelper.ItemsRecord.ITEM_PATH_1);
        int r11 = r20.getColumnIndex(DatabaseHelper.ItemsRecord.ITEM_PATH_2);
    L9:
        if (r20.moveToNext() == false) goto L21;
        String r12 = r20.getString(r3);
        if (r19.add(r12) == false) goto L9;
        r18.addRow(new Object[]{r20.getString(r1), r20.getString(r2), r12, r20.getString(r4), r20.getString(r5), r20.getString(r6), r20.getString(r7), r20.getString(r8), Integer.valueOf(r20.getInt(r9)), r20.getString(r10), r20.getString(r11)});
        goto L9
    L21:
        return;
    }

    private void closeCursor(Cursor r1) {
        if (r1 == null) goto L5;
        r1.close();
        return;
    }

    private MatrixCursor getSuggestionSearchCursorById(String r10) {
        Cursor r2 = null;
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L27:
        return null;
    L5:
        if ("%".equals(r10) == true) goto L27;
        Cursor r11 = this.mContext.getContentResolver().query(SettingItemsProvider.CONTENT_URI, null, r10 + " AND (is_searchable = 1 )", null, null);     // Catch: Throwable -> L14 Exception -> L16
        MatrixCursor r9 = buildMatrixCursor(r11);     // Catch: Exception -> L12 Throwable -> L22
        if (r11 == null) goto L11;
        r11.close();
    L11:
        return r9;
    L12:
        e = e;
    L18:
        e.printStackTrace();     // Catch: Throwable -> L22
        if (r11 == null) goto L21;
        r11.close();
    L21:
        return null;
    L22:
        th = th;
        r2 = r11;
    L24:
        if (r2 == null) goto L26;
        r2.close();
    L26:
        throw th;
    L16:
        e = e;
        r11 = null;
    L14:
        th = th;
        goto L24
    }

    private MatrixCursor buildMatrixCursor(Cursor r22) {
        if (r22 != null) goto L5;
        return null;
    L5:
        if (r22.getCount() == 0) goto L75;
        MatrixCursor r1 = new MatrixCursor(mVirtualColumns);
        ArrayList r2 = new ArrayList();
        int r3 = r22.getColumnIndex("_id");
        int r4 = r22.getColumnIndex("name");
        int r5 = r22.getColumnIndex("intent");
        int r6 = r22.getColumnIndex("extra");
        int r7 = r22.getColumnIndex("is_switch");
        int r8 = r22.getColumnIndex("switch_table");
        int r9 = r22.getColumnIndex("switch_key");
        int r10 = r22.getColumnIndex("special_key");
        int r11 = r22.getColumnIndex("def_value");
        int r12 = r22.getColumnIndex(DatabaseHelper.ItemsRecord.ICON_ID);
        int r13 = r22.getColumnIndex(DatabaseHelper.ItemsRecord.ITEM_PATH_1);
        int r14 = r22.getColumnIndex(DatabaseHelper.ItemsRecord.ITEM_PATH_2);
    L8:
        boolean r16 = false;
        MatrixCursor r17 = r1;
        if (r22.moveToNext() == false) goto L42;
        SettingItem r15 = new SettingItem(this);
        ArrayList r18 = r2;
        r15._id = r22.getLong(r3);
        r15.component = r22.getString(r5);
        r15.name = r22.getString(r4);
        r15.extra = r22.getString(r6);
        r15.is_switch = r22.getInt(r7);
        r15.table = r22.getString(r8);
        r15.key = r22.getString(r9);
        r15.special_key = r22.getString(r10);
        r15.defValue = r22.getInt(r11);
        r15.iconId = r22.getInt(r12);
        r15.path1 = r22.getString(r13);
        r15.path2 = r22.getString(r14);
        Iterator r19 = r18.iterator();
    L12:
        if (r19.hasNext() == false) goto L38;
        SettingItem r20 = (SettingItem) r19.next();
        Iterator r110 = r19;
        int r21 = r3;
        if (r15.is_switch != 1) goto L27;
        if (r20.is_switch != r15.is_switch) goto L37;
        if (TextUtils.equals(r15.name, r20.name) == false) goto L37;
        if (TextUtils.equals(r15.table, r20.table) == false) goto L37;
        if (TextUtils.equals(r15.key, r20.key) == false) goto L37;
        if (TextUtils.equals(r15.special_key, r20.special_key) == false) goto L37;
    L36:
        r16 = true;
    L37:
        r19 = r110;
        r3 = r21;
        goto L12
    L27:
        if (r20.is_switch != 0) goto L37;
        if (TextUtils.equals(r15.name, r20.name) == false) goto L37;
        if (TextUtils.equals(r15.component, r20.component) == false) goto L37;
        if (TextUtils.equals(r15.extra, r20.extra) == false) goto L37;
        if (TextUtils.equals(r15.path1, r20.path1) == false) goto L37;
    L38:
        int r23 = r3;
        if (r16 == true) goto L41;
        r18.add(r15);
    L41:
        r2 = r18;
        r1 = r17;
        r3 = r23;
        goto L8
    L42:
        ArrayList r24 = r2;
        if (r22 == null) goto L45;
        r22.close();
    L45:
        int r0 = 0;
    L47:
        if (r0 >= r24.size()) goto L54;
        SettingItem r25 = (SettingItem) r24.get(r0);
        Uri.Builder r26 = new Uri.Builder();
        r26.scheme("content");
        r26.encodedAuthority(AUTHORITY);
        r26.appendEncodedPath("settingitems");
        r26.appendEncodedPath(r25.component);
        if (r25.extra != null) goto L51;
        String r27 = "";
    L52:
        r26.appendEncodedPath(r27);
        r17.addRow(new Object[]{r26.build(), r25.name, Long.valueOf(r25._id), Integer.valueOf(r25.is_switch), r25.table, r25.key, r25.special_key, Integer.valueOf(r25.defValue), Integer.valueOf(r25.iconId), r25.path1, r25.path2});
        r0 = r0 + 1;
        goto L47
    L51:
        r27 = r25.extra;
        goto L52
    L54:
        return r17;
    L75:
        return null;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.content.ContentProvider")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_settingitemsprovider_SearchSuggestionProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(SearchSuggestionProvider r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_settingitemsprovider_SearchSuggestionProvider__onCreate$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportColdStartProvider(r0);
    L5:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }
}
