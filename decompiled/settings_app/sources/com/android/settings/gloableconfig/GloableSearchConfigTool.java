package com.android.settings.gloableconfig;

import android.content.Context;
import android.os.AsyncTask;
import bytedanceos.app.settings.search.GloableSearchConfig;
import bytedanceos.app.settings.search.SearchConfigType;
import bytedanceos.app.settings.search.SearchConfigTypeData;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GloableSearchConfigTool {
    private static final String PARAM_MD5 = "md5";
    private static final String TAG = "GloableSearchConfigTool";
    private static volatile GloableSearchConfigTool mTool;
    private GloableSearchConfig mCacheConfig;
    private Context mContext;
    private volatile boolean mQueryingConfig;
    private String uri;

    private static class ConfigResult {
        int id;
        String json;

        private ConfigResult() {
        }

        /* synthetic */ ConfigResult(AnonymousClass1 r1) {
            this();
        }
    }

    public static class GlobalSearchConfigEvent {
        public GlobalSearchConfigEvent() {
        }
    }

    static /* synthetic */ boolean access$000(GloableSearchConfigTool r0) {
        return r0.mQueryingConfig;
    }

    static /* synthetic */ boolean access$002(GloableSearchConfigTool r0, boolean r1) {
        r0.mQueryingConfig = r1;
        return r1;
    }

    static /* synthetic */ String access$100(GloableSearchConfigTool r0) {
        return r0.uri;
    }

    static /* synthetic */ GloableSearchConfig access$300(GloableSearchConfigTool r0) {
        return r0.mCacheConfig;
    }

    static /* synthetic */ GloableSearchConfig access$302(GloableSearchConfigTool r0, GloableSearchConfig r1) {
        r0.mCacheConfig = r1;
        return r1;
    }

    private GloableSearchConfigTool(Context r2) {
        this.uri = "content://com.bytedanceos.gloable.searchconfig.provider/searchconfig";
        this.mContext = r2;
        this.mQueryingConfig = false;
        initCacheConfigAsync(r2);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.android.settings.gloableconfig.GloableSearchConfigTool$1] */
    private void initCacheConfigAsync(Context r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (this.mQueryingConfig == true) goto L9;
        new AnonymousClass1(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Context[]{r6});
        this.mQueryingConfig = true;
        return;
    }

    public boolean hasChange(GloableSearchConfig r3) {
        GloableSearchConfig r0 = this.mCacheConfig;
        if (r0 != null) goto L7;
        initCacheConfigAsync(this.mContext);
        return false;
    L7:
        if (r0.getVersion() >= r3.getVersion()) goto L10;
        return true;
    L10:
        return false;
    }

    public GloableSearchConfig getCacheConfig() {
        if (this.mCacheConfig != null) goto L6;
        initCacheConfigAsync(this.mContext);
    L6:
        return this.mCacheConfig;
    }

    public void updateCacheConfig(GloableSearchConfig r2) {
        if (this.mCacheConfig != null) goto L5;
        initCacheConfigAsync(this.mContext);
    L5:
        r2.setId(this.mCacheConfig.getId());
        this.mCacheConfig = r2;
    }

    public static GloableSearchConfigTool getInstance(Context r2) {
        if (mTool != null) goto L15;
        monitor-enter(GloableSearchConfigTool.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mTool != null) goto L9;
        mTool = new GloableSearchConfigTool(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(GloableSearchConfigTool.class);     // Catch: Throwable -> L11
    L15:
        return mTool;
    }

    public static GloableSearchConfig getConfigByJson(String r4) {
        JSONObject r1 = new JSONObject(r4);     // Catch: Exception -> L8
        GloableSearchConfig r5 = new GloableSearchConfig();     // Catch: Exception -> L8
        r5.setVersion(r1.getInt("version"));     // Catch: Exception -> L6
        r5.setConfigTypes(parseConfigTypes(r1.getJSONArray("types")));     // Catch: Exception -> L6
    L11:
        return r5;
    L6:
        Exception e = e;
    L10:
        OLog.w(TAG, "parse config exception :" + e.getMessage());
    L8:
        e = move-exception;
        e = e;
        r5 = null;
        goto L10
    }

    private static List<SearchConfigType> parseConfigTypes(JSONArray r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        int r1 = r6.length();     // Catch: Exception -> L10
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        JSONObject r3 = r6.getJSONObject(r2);     // Catch: Exception -> L10
        SearchConfigType r4 = new SearchConfigType();     // Catch: Exception -> L10
        r4.setType(r3.getString("type"));     // Catch: Exception -> L10
        r4.setMode(r3.getInt("mode"));     // Catch: Exception -> L10
        r4.setOrder(r3.getInt("order"));     // Catch: Exception -> L10
        r4.setDatas(parseTypeDatas(r3.getJSONArray("datas")));     // Catch: Exception -> L10
        r0.add(r4);     // Catch: Exception -> L10
        r2 = r2 + 1;
    L12:
        return r0;
    L10:
        e = move-exception;
        OLog.w(TAG, "parse config type exception :" + e.getMessage());
        goto L12
    }

    private static List<SearchConfigTypeData> parseTypeDatas(JSONArray r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        int r1 = r6.length();     // Catch: Exception -> L10
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        JSONObject r3 = r6.getJSONObject(r2);     // Catch: Exception -> L10
        SearchConfigTypeData r4 = new SearchConfigTypeData();     // Catch: Exception -> L10
        r4.setIdentifier(r3.getString("identifier"));     // Catch: Exception -> L10
        r4.setName(r3.getString("name"));     // Catch: Exception -> L10
        r4.setEnName(r3.getString("enName"));     // Catch: Exception -> L10
        r4.setTwName(r3.getString("twName"));     // Catch: Exception -> L10
        r4.setClickUrl(r3.getString("clickUrl"));     // Catch: Exception -> L10
        r4.setImgUrl(r3.getString("imgUrl"));     // Catch: Exception -> L10
        r4.setOrder(r3.getInt("order"));     // Catch: Exception -> L10
        r4.setDefault(r3.getBoolean("default"));     // Catch: Exception -> L10
        r0.add(r4);     // Catch: Exception -> L10
        r2 = r2 + 1;
    L12:
        return r0;
    L10:
        e = move-exception;
        OLog.w(TAG, "parse config type data exception :" + e.getMessage());
        goto L12
    }
}
