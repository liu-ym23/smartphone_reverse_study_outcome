package com.android.settings.gloableconfig;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import bytedanceos.app.settings.search.GloableSearchConfig;
import bytedanceos.app.settings.search.SearchConfigType;
import com.android.settings.PreferenceMgr;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class GloableSearchConfigProvider extends ContentProvider {
    public static final String AUTHORITY = "com.bytedanceos.gloable.searchconfig.provider";
    public static final String DB_NAME = "searchconfig.db";
    private static final int DB_VERSION = 1;
    public static final String DEFAULT_CONFIG = "{\"version\":\"1\",\"types\":[{\"type\":\"config_search\",\"order\":\"1\",\"mode\":\"0\",\"datas\":[{\"identifier\":\"search_sogou\",\"name\":\"搜狗搜索\",\"twName\":\"搜狗搜尋\",\"enName\":\"Sogou\",\"order\":\"1\",\"clickUrl\":\"http://wap.sogou.com/web/sl?keyword=%s&pid=sogou-mobp-ef48e3ef07e35900\",\"imgUrl\":\"\",\"default\":\"false\"},{\"identifier\":\"search_baidu\",\"name\":\"百度搜索\",\"twName\":\"百度搜尋\",\"enName\":\"Baidu\",\"order\":\"3\",\"clickUrl\":\"http://m.baidu.com/s?word=%s&from=1022741n\",\"imgUrl\":\"\",\"default\":\"true\"},{\"identifier\":\"search_google\",\"name\":\"谷歌搜索\",\"enName\":\"Google\",\"twName\":\"谷歌搜尋\",\"order\":\"4\",\"clickUrl\":\"https://www.google.com/search?q=%s\",\"imgUrl\":\"\",\"default\":\"false\"},{\"identifier\":\"search_toutiao\",\"name\":\"头条搜索\",\"enName\":\"Toutiao\",\"twName\":\"頭條搜尋\",\"order\":\"2\",\"clickUrl\":\"https://m.toutiao.com/search/?keyword=%s&traffic_source=CS1112&source=t_bigbang\",\"imgUrl\":\"\",\"default\":\"false\"}]},{\"type\":\"config_dictionary\",\"order\":\"2\",\"mode\":\"0\",\"datas\":[{\"identifier\":\"dictionary_youdao\",\"name\":\"有道词典\",\"twName\":\"有道詞典\",\"enName\":\"Youdao Dictionary\",\"order\":\"1\",\"clickUrl\":\"\",\"imgUrl\":\"\",\"default\":\"true\"},{\"identifier\":\"dictionary_bing\",\"name\":\"必应词典\",\"twName\":\"必應詞典\",\"enName\":\"Bing Dictionary\",\"order\":\"4\",\"clickUrl\":\"http://cn.bing.com/dict/?q=%s\",\"imgUrl\":\"\",\"default\":\"false\"},{\"identifier\":\"dictionary_iciba\",\"name\":\"金山词霸\",\"twName\":\"金山詞霸\",\"enName\":\"Iciba\",\"order\":\"3\",\"clickUrl\":\"http://www.iciba.com/%s\",\"imgUrl\":\"\",\"default\":\"false\"},{\"identifier\":\"dictionary_google\",\"name\":\"谷歌翻译\",\"twName\":\"谷歌翻译\",\"enName\":\"Google Translate\",\"order\":\"2\",\"clickUrl\":\"https://translate.google.cn/m/translate#auto/%s\",\"imgUrl\":\"\",\"default\":\"false\"}]},{\"type\":\"config_baike\",\"order\":\"3\",\"mode\":\"0\",\"datas\":[{\"identifier\":\"baike_baidu\",\"name\":\"百度百科\",\"twName\":\"百度百科\",\"enName\":\"Baidu Baike\",\"order\":\"1\",\"clickUrl\":\"http://wapbaike.baidu.com/search/word?word=%s\",\"imgUrl\":\"\",\"default\":\"true\"},{\"identifier\":\"baike_hudong\",\"name\":\"互动百科\",\"twName\":\"互動百科\",\"enName\":\"Hudong Baike\",\"order\":\"2\",\"clickUrl\":\"http://www.baike.com/gwiki/%s\",\"imgUrl\":\"\",\"default\":\"false\"},{\"identifier\":\"baike_wikiEN\",\"name\":\"英文维基百科\",\"twName\":\"英文維基百科\",\"enName\":\"Wikipedia English\",\"order\":\"3\",\"clickUrl\":\"https://en.m.wikipedia.org/wiki/%s\",\"imgUrl\":\"\",\"default\":\"false\"}]},{\"type\":\"config_third_search\",\"order\":\"4\",\"mode\":\"0\",\"datas\":[{\"identifier\":\"third_sogou\",\"name\":\"搜狗|微信搜索\",\"twName\":\"搜狗|微信搜索\",\"enName\":\"Sougou | WeChat Search\",\"order\":\"1\",\"clickUrl\":\"http://weixin.sogou.com/weixinwap?type=2&query=%s\",\"imgUrl\":\"\",\"default\":\"true\"},{\"identifier\":\"third_weibo\",\"name\":\"微博搜索\",\"twName\":\"微博搜索\",\"enName\":\"Weibo Search\",\"order\":\"2\",\"clickUrl\":\"http://s.weibo.com/weibo/%s\",\"imgUrl\":\"\",\"default\":\"false\"},{\"identifier\":\"third_zhihu\",\"name\":\"搜狗|知乎搜索\",\"twName\":\"搜狗|知乎搜索\",\"enName\":\"Sougou | Zhihu Search\",\"order\":\"3\",\"clickUrl\":\"http://zhihu.sogou.com/zhihuwap?query=%s\",\"imgUrl\":\"\",\"default\":\"false\"}]}]}";
    private static final int MATCH_CONFIG = 1;
    private static final String METHOD_GET_CONFIGS = "getConfig";
    private static final String METHOD_GET_ICON = "getIcon";
    public static final String TAG = "GloableSearchConfigProvider";
    private static final String TYPE_CONFIG = "searchconfig";
    private static final UriMatcher mUriMatcher = null;
    private SearchConfigDbHelper mDbHelper;

    private static class SearchConfigDbHelper extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
        }

        public SearchConfigDbHelper(Context r4) {
            super(r4, GloableSearchConfigProvider.DB_NAME, null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r2) {
            r2.execSQL(TableSearchConfig.DB_CREATE);
            initData(r2);
        }

        private void initData(SQLiteDatabase r3) {
            ContentValues r2 = new ContentValues();
            r2.put("version", 1);
            r2.put(TableSearchConfig.COLUMN_JSON, GloableSearchConfigProvider.DEFAULT_CONFIG);
            r3.insert("searchconfig", null, r2);
        }
    }

    public class TableSearchConfig {
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_JSON = "jsonData";
        public static final String COLUMN_VERSION = "version";
        public static final String DB_CREATE = "create table searchconfig (_id integer primary key autoincrement,version integer not null,jsonData integer not null);";
        public static final String TABLE_NAME = "searchconfig";
        final /* synthetic */ GloableSearchConfigProvider this$0;

        public TableSearchConfig(GloableSearchConfigProvider r1) {
            this.this$0 = r1;
        }
    }

    public void com_android_settings_gloableconfig_GloableSearchConfigProvider__onCreate$___twin___() {
        super.onCreate();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    public void onCreate() {
        com_android_settings_gloableconfig_GloableSearchConfigProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(this);
    }

    public GloableSearchConfigProvider() {
    }

    static {
        UriMatcher r0 = new UriMatcher(-1);
        mUriMatcher = r0;
        r0.addURI(AUTHORITY, "searchconfig", 1);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mDbHelper = new SearchConfigDbHelper(getContext());
        OLog.d(TAG, "create search config database.");
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r9, String[] r10, String r11, String[] r12, String r13) {
        checkUriValid(r9);
        return this.mDbHelper.getReadableDatabase().query("searchconfig", r10, r11, r12, null, null, r13);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r3, String r4, String[] r5) {
        checkUriValid(r3);
        int r6 = this.mDbHelper.getWritableDatabase().delete("searchconfig", r4, r5);
        if (r6 <= 0) goto L5;
        getContext().getContentResolver().notifyChange(r3, null);
    L5:
        return r6;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r6, ContentValues r7) {
        checkUriValid(r6);
        long r0 = this.mDbHelper.getWritableDatabase().insert("searchconfig", null, r7);
        if (r0 > 0) goto L6;
        OLog.w(TAG, "unable to insert " + r7 + " for " + r6);
        return null;
    L6:
        Uri r8 = ContentUris.withAppendedId(r6, r0);
        getContext().getContentResolver().notifyChange(r8, null);
        return r8;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r3, ContentValues r4, String r5, String[] r6) {
        checkUriValid(r3);
        int r7 = this.mDbHelper.getWritableDatabase().update("searchconfig", r4, r5, r6);
        if (r7 <= 0) goto L5;
        getContext().getContentResolver().notifyChange(r3, null);
    L5:
        return r7;
    }

    private void checkUriValid(Uri r3) {
        if (mUriMatcher.match(r3) != 1) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("unknown uri:" + r3);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r1, String r2, Bundle r3) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return null;
    L6:
        if (METHOD_GET_CONFIGS.equals(r1) == true) goto L8;
        METHOD_GET_ICON.equals(r1);
        return null;
    L8:
        return getConfig();
    }

    private Bundle getConfig() {
        Bundle r0 = new Bundle();
        Cursor r1 = null;
        Cursor r2 = this.mDbHelper.getReadableDatabase().query("searchconfig", new String[]{TableSearchConfig.COLUMN_JSON}, null, null, null, null, "version  desc");     // Catch: Throwable -> L24 Exception -> L26
    L22:
        e = e;
        r1 = r2;
    L27:
        OLog.e(TAG, "getConfig\u3000by call method exception:" + e.getMessage());     // Catch: Throwable -> L24
        if (r1 == null) goto L34;
        r1.close();
    L34:
        return r0;
    L20:
        th = th;
        r1 = r2;
    L31:
        if (r1 == null) goto L33;
        r1.close();
    L33:
        throw th;
    L5:
        if (r2.moveToNext() == false) goto L7;
        GloableSearchConfig r3 = GloableSearchConfigTool.getConfigByJson(r2.getString(0));     // Catch: Throwable -> L20 Exception -> L22
    L8:
        if (r3 == null) goto L18;
        List r4 = r3.getConfigTypes();     // Catch: Throwable -> L20 Exception -> L22
        if (r4 == null) goto L17;
        Iterator r5 = r4.iterator();     // Catch: Throwable -> L20 Exception -> L22
    L13:
        if (r5.hasNext() == false) goto L17;
        SearchConfigType r6 = (SearchConfigType) r5.next();     // Catch: Throwable -> L20 Exception -> L22
        String r7 = PreferenceMgr.getInstance(getContext()).getString(r6.getType(), null);     // Catch: Throwable -> L20 Exception -> L22
        if (r7 == null) goto L13;
        r6.updateDefaultData(r7);     // Catch: Throwable -> L20 Exception -> L22
    L17:
        r0.putParcelable("config", r3);     // Catch: Throwable -> L20 Exception -> L22
    L18:
        if (r2 == null) goto L34;
        r2.close();
        goto L34
    L7:
        r3 = null;
    L24:
        th = th;
    L26:
        e = e;
        goto L27
    }

    @TargetClass(scope = Scope.LEAF, value = "android.content.ContentProvider")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_gloableconfig_GloableSearchConfigProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(GloableSearchConfigProvider r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_gloableconfig_GloableSearchConfigProvider__onCreate$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportColdStartProvider(r0);
    L5:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }
}
