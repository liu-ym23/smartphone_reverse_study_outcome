package com.android.settings.settingitemsprovider;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.olog.OLog;
import com.obric.search.api.OSearchEngine;
import com.obric.search.api.query.impl.FullTextSearchQuery;
import com.obric.search.api.remove.impl.FullTextSearchRemoveSpec;
import com.obric.search.api.schema.impl.FullTextSearchSchema;
import com.obric.search.api.schema.impl.bean.DocumentTokenPosition;
import com.obric.search.api.search.impl.FullTextSearchSpec;
import com.obric.search.sdk.embedding.EmbeddingSearchPlugin;
import com.obric.search.sdk.embedding.EmbeddingSearchPluginConfig;
import com.obric.search.sdk.embedding.query.EmbeddingSearchQuery;
import com.obric.search.sdk.embedding.remove.EmbeddingSearchRemoveSpec;
import com.obric.search.sdk.embedding.search.EmbeddingSearchSpec;
import com.obric.search.sdk.embedding.search.PCMemoryModelInnerProductFilter;
import com.obric.search.sdk.embedding.shema.EmbeddingSearchSchema;
import com.obric.search.sdk.jieba.utils.JiebaUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: classes2.dex */
public class SearchEngine {
    public static final String DB_NAME = "setting_items_engine.db";
    private static final int DB_VERSION = 1;
    private static final double DISTANCE_THRESHOLD = 0.6d;
    public static final String EMBEDDING_SCHEMA_NAME = "embedding_settings_item";
    public static final String SCHEMA_NAME = "settings_item";
    private static final int SPLIT_PINYIN_MAX_LEN = 50;
    public static final String TAG = "SearchEngine";
    private static volatile SearchEngine mSearchEngine;
    private final OSearchEngine mOSearchEngine;

    interface SearchResultListener {
        void onSearchResult(ArrayList<SettingItemsDocument> r1);
    }

    public SearchEngine(Context r3) {
        OLog.d(TAG, "SearchEngine init");
        this.mOSearchEngine = new OSearchEngine();
        initSearchEngine(r3);
    }

    public void initSearchEngine(Context r13) {
        if (this.mOSearchEngine != null) goto L6;
        OLog.d(TAG, "mOSearchEngine is null");
        return;
    L6:
        initAIKernel(r13);
        this.mOSearchEngine.addPlugin(new EmbeddingSearchPlugin(), new EmbeddingSearchPluginConfig());
        List r0 = Arrays.asList(new String[]{"name"});
        ArrayList r5 = new ArrayList();
        r5.add(new FullTextSearchSchema(SCHEMA_NAME, r0, FullTextSearchSchema.TOKENIZER.O_TOKENIZER_2, true));
        r5.add(new EmbeddingSearchSchema(EMBEDDING_SCHEMA_NAME, EmbeddingSearchSchema.EMBEDDING_MODEL.MEMORY_TEXT_EMBEDDING_V2, EmbeddingSearchSchema.INDEX_METRIC_TYPE.INNER_PRODUCT, 1, 1));
        Uri.Builder r1 = new Uri.Builder();
        r1.scheme("android.resource");
        r1.authority(r13.getPackageName());
        r1.path("raw/settings_synonyms_dictionary");
        Uri r6 = r1.build();
        this.mOSearchEngine.init(r13, DB_NAME, 1, r5, r6, null, null, null);
    }

    private void initAIKernel(Context r3) {
        OLog.d(TAG, "initAIKernel");
        AIKernelConfig r2 = new AIKernelConfig.Builder(r3).appId(1234).packageName(r3.getPackageName()).build();
        AIKernelManager.INSTANCE.init(r2);
    }

    public static SearchEngine getInstance(Context r2) {
        if (mSearchEngine != null) goto L15;
        monitor-enter(SearchEngine.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mSearchEngine != null) goto L9;
        mSearchEngine = new SearchEngine(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(SearchEngine.class);     // Catch: Throwable -> L11
    L15:
        return mSearchEngine;
    }

    public static boolean isSearchEngineInit() {
        if (mSearchEngine == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void setSearchEngineCallback(OSearchEngine.CallBack r3) {
        if (this.mOSearchEngine == null) goto L6;
        OLog.d(TAG, "setSearchEngineCallback");
        this.mOSearchEngine.setCallBack(r3);
        return;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public boolean buildIndex(SQLiteDatabase r19) {
        OLog.d(TAG, "buildIndex");
        if (r19 != null) goto L5;
        return false;
    L5:
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        this.mOSearchEngine.removeDocuments(new FullTextSearchRemoveSpec(SCHEMA_NAME, r11, true));
        this.mOSearchEngine.removeDocuments(new EmbeddingSearchRemoveSpec(EMBEDDING_SCHEMA_NAME, Collections.emptyList(), true));
        Cursor r9 = null;
    L49:
        th = th;
    L50:
        if (r9 == null) goto L52;
        r9.close();
    L52:
        throw th;
    L56:
        Cursor r10 = r19.query("settingitems", new String[]{"_id", "name", "alias", "description"}, null, null, null, null, null);     // Catch: Throwable -> L36 Exception -> L38
        if (r10 != null) goto L54;
    L24:
        if (r10 == null) goto L26;
        r10.close();
    L26:
        OLog.d(TAG, "documents size: " + r11.size());
        if (this.mOSearchEngine.putDocuments(r11) == false) goto L34;
        OLog.d(TAG, "build index success");
        OLog.d(TAG, "embedding documents size: " + r11.size());
        if (this.mOSearchEngine.putDocuments(r12) == false) goto L32;
        OLog.d(TAG, "build embedding index success");
        return true;
    L32:
        OLog.e(TAG, "build embedding index failed");
        return false;
    L34:
        OLog.e(TAG, "build index failed");
        return false;
    L54:
    L22:
        e = e;
    L44:
        e.printStackTrace();     // Catch: Throwable -> L49
        if (r10 == null) goto L65;
        r10.close();
        return false;
    L65:
        return false;
    L11:
        if (r10.getCount() <= 0) goto L20;
        int r3 = r10.getColumnIndex("_id");     // Catch: Exception -> L22 Throwable -> L49
        int r4 = r10.getColumnIndex("name");     // Catch: Exception -> L22 Throwable -> L49
        int r5 = r10.getColumnIndex("description");     // Catch: Exception -> L22 Throwable -> L49
    L14:
        if (r10.moveToNext() == false) goto L20;
        r11.add(new SettingItemsDocument(r10.getLong(r3), r10.getString(r4), null));     // Catch: Exception -> L22 Throwable -> L49
        String r6 = r10.getString(r5);     // Catch: Exception -> L22 Throwable -> L49
        if (r6 == null) goto L14;
        if (r6.trim().isEmpty() == true) goto L14;
        r12.add(new SettingsItemsEmbeddingDocument(r10.getLong(r3), r6));     // Catch: Exception -> L22 Throwable -> L49
    L20:
        r10.close();     // Catch: Exception -> L22 Throwable -> L49
        goto L24
    L38:
        e = e;
        r10 = null;
    L36:
        th = th;
        r9 = null;
        goto L50
    }

    public List<DocumentTokenPosition> search(String r12) {
        List<DocumentTokenPosition> r11 = this.mOSearchEngine.getDocumentsIdAndTokenPosition(new FullTextSearchSpec(SCHEMA_NAME, FullTextSearchQuery.Companion.buildPinyinQuery(r12, 50).or(FullTextSearchQuery.Companion.buildPhraseQuery(JiebaUtil.INSTANCE.tokenizeQuery(r12, true), FullTextSearchQuery.Operator.AND, true)), FullTextSearchSpec.RankMethod.BM25, 0, 0, Collections.emptyList()));
        Iterator<DocumentTokenPosition> r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        DocumentTokenPosition r0 = r13.next();
        OLog.d(TAG, "search id: " + r0.getId());
        OLog.d(TAG, "search id: " + r0.getColumnsTokenPosition());
        goto L4
    L6:
        return r11;
    }

    public List<DocumentTokenPosition> smartSearch(String r12) {
        List<DocumentTokenPosition> r0 = this.mOSearchEngine.getDocumentsIdAndTokenPosition(new FullTextSearchSpec(SCHEMA_NAME, FullTextSearchQuery.Companion.buildSynonymPhraseQuery(r12, false), FullTextSearchSpec.RankMethod.None, 0, 0, Collections.emptyList()));
        ArrayList r1 = new ArrayList();
        Iterator<DocumentTokenPosition> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        DocumentTokenPosition r3 = r2.next();
        r1.add(Long.valueOf(r3.getId()));
        OLog.d(TAG, "search id: " + r3.getId());
        OLog.d(TAG, "search id: " + r3.getColumnsTokenPosition());
        goto L4
    L6:
        Iterator<Pair<Long, Double>> r11 = SearchEngineHelp.Companion.getInstance().getDocumentsIdAndDistanceAndStatus(new EmbeddingSearchSpec(EMBEDDING_SCHEMA_NAME, EmbeddingSearchQuery.Companion.createTextEmbeddingSearchQuery(r12), 5, new PCMemoryModelInnerProductFilter()), this.mOSearchEngine).iterator();
    L8:
        if (r11.hasNext() == false) goto L12;
        Pair<Long, Double> r13 = r11.next();
        OLog.d(TAG, "embedding search id: " + r13.getFirst());
        OLog.d(TAG, "embedding search distance: " + r13.getSecond());
        if (r1.contains(r13.getFirst()) == true) goto L8;
        r0.add(new DocumentTokenPosition(r13.getFirst().longValue(), new ArrayList()));
        goto L8
    L12:
        return r0;
    }

    public static void loadSegmentationDict() {
        JiebaUtil.INSTANCE.loadDict();
    }

    public static void unloadSegmentationDict() {
        JiebaUtil.INSTANCE.unloadDict();
    }
}
