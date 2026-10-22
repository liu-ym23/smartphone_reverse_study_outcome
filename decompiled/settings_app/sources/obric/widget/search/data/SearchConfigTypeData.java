package obric.widget.search.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import obric.widget.R;

/* JADX INFO: loaded from: classes5.dex */
public class SearchConfigTypeData implements Parcelable {
    private static final Map<String, Integer> BOOM_ICON_MAPS = null;
    public static final Parcelable.Creator<SearchConfigTypeData> CREATOR = null;
    public static final int DEFAULT_BOOM_ICON = 0;
    private static final Map<String, Integer> ICON_MAPS = null;
    public static final String KEY_CLICK_URL = "clickUrl";
    public static final String KEY_DEFAULT = "default";
    public static final String KEY_ENNAME = "enName";
    public static final String KEY_IDENTIFIER = "identifier";
    public static final String KEY_IMG_URL = "imgUrl";
    public static final String KEY_NAME = "name";
    public static final String KEY_ORDER = "order";
    public static final String KEY_TWNAME = "twName";
    private static final String ROOT_PATH = null;
    public static final String SEARCH_TYPE = "search_type";
    private static final Uri SETTINGS_CONFIGS_URI = null;
    private static final String TAG = "SearchConfigTypeData";
    public static final String TYPE_BAIKE_BAIDU = "baike_baidu";
    public static final String TYPE_BAIKE_HUDONG = "baike_hudong";
    public static final String TYPE_BAIKE_WIKI_CN = "baike_wikiCN";
    public static final String TYPE_BAIKE_WIKI_EN = "baike_wikiEN";
    public static final String TYPE_DICT_BING = "dictionary_bing";
    public static final String TYPE_DICT_GOOGLE = "dictionary_google";
    public static final String TYPE_DICT_KINGSOFT = "dictionary_iciba";
    public static final String TYPE_DICT_YOUDAO = "dictionary_youdao";
    public static final String TYPE_SEARCH_360SO = "search_360so";
    public static final String TYPE_SEARCH_BAIDU = "search_baidu";
    public static final String TYPE_SEARCH_BING = "search_bing";
    public static final String TYPE_SEARCH_GOOGLE = "search_google";
    public static final String TYPE_SEARCH_SOUGOU = "search_sogou";
    public static final String TYPE_SEARCH_TOUTIAO = "search_toutiao";
    public static final String TYPE_THIRD_WECHAT = "third_sogou";
    public static final String TYPE_THIRD_WEIBO = "third_weibo";
    public static final String TYPE_THIRD_ZHIHU = "third_zhihu";
    private boolean isDefault;
    private String mClickUrl;
    private String mEnName;
    private String mIdentifier;
    private String mImgUrl;
    private String mName;
    private int mOrder;
    private String mTwName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ SearchConfigTypeData(Parcel r1, AnonymousClass1 r2) {
        this(r1);
    }

    static {
        ROOT_PATH = Environment.getExternalStorageDirectory() + "/smartisan/settings";
        DEFAULT_BOOM_ICON = R.drawable.boom_win_search_toutiao;
        SETTINGS_CONFIGS_URI = Uri.parse("content://com.smartisanos.gloable.searchconfig.provider");
        HashMap r0 = new HashMap();
        ICON_MAPS = r0;
        HashMap r1 = new HashMap();
        BOOM_ICON_MAPS = r1;
        r0.put("search_sogou", Integer.valueOf(R.drawable.gloable_search_sogou));
        r0.put("search_baidu", Integer.valueOf(R.drawable.gloable_search_baidu));
        r0.put("search_google", Integer.valueOf(R.drawable.gloable_search_google));
        r0.put("search_bing", Integer.valueOf(R.drawable.gloable_search_bing));
        r0.put("search_360so", Integer.valueOf(R.drawable.gloable_search_360so));
        r0.put("dictionary_youdao", Integer.valueOf(R.drawable.gloable_search_youdao));
        r0.put("dictionary_bing", Integer.valueOf(R.drawable.gloable_search_bingdict));
        r0.put("dictionary_iciba", Integer.valueOf(R.drawable.gloable_search_kingsoft));
        r0.put("dictionary_google", Integer.valueOf(R.drawable.gloable_search_googletrans));
        r0.put("baike_baidu", Integer.valueOf(R.drawable.gloable_search_baike));
        r0.put("baike_hudong", Integer.valueOf(R.drawable.gloable_search_hudongdict));
        r0.put("baike_wikiEN", Integer.valueOf(R.drawable.gloable_search_wiki_en));
        r0.put("baike_wikiCN", Integer.valueOf(R.drawable.gloable_search_wiki_cn));
        r0.put("third_sogou", Integer.valueOf(R.drawable.gloable_search_weixin));
        r0.put("third_weibo", Integer.valueOf(R.drawable.gloable_search_weibo));
        r0.put("third_zhihu", Integer.valueOf(R.drawable.gloable_search_zhihu));
        r1.put("search_sogou", Integer.valueOf(R.drawable.boom_win_search_sogou));
        r1.put("search_baidu", Integer.valueOf(R.drawable.boom_win_search_baidu));
        r1.put("search_google", Integer.valueOf(R.drawable.boom_win_search_google));
        r1.put("search_bing", Integer.valueOf(R.drawable.boom_win_search_bing));
        r1.put("search_360so", Integer.valueOf(R.drawable.boom_win_search_360so));
        r1.put("search_toutiao", Integer.valueOf(R.drawable.boom_win_search_toutiao));
        r1.put("dictionary_youdao", Integer.valueOf(R.drawable.boom_win_search_youdao));
        r1.put("dictionary_bing", Integer.valueOf(R.drawable.boom_win_search_bingdict));
        r1.put("dictionary_iciba", Integer.valueOf(R.drawable.boom_win_search_kingsoft));
        r1.put("dictionary_google", Integer.valueOf(R.drawable.boom_win_search_googletrans));
        r1.put("baike_baidu", Integer.valueOf(R.drawable.boom_win_search_baike));
        r1.put("baike_hudong", Integer.valueOf(R.drawable.boom_win_search_hudongdict));
        r1.put("baike_wikiEN", Integer.valueOf(R.drawable.boom_win_search_wiki_en));
        r1.put("baike_wikiCN", Integer.valueOf(R.drawable.boom_win_search_wiki_cn));
        r1.put("third_sogou", Integer.valueOf(R.drawable.boom_win_search_weixin));
        r1.put("third_weibo", Integer.valueOf(R.drawable.boom_win_search_weibo));
        r1.put("third_zhihu", Integer.valueOf(R.drawable.boom_win_search_zhihu));
        CREATOR = new AnonymousClass1();
    }

    public SearchConfigTypeData() {
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public void setIdentifier(String identifier) {
        this.mIdentifier = identifier;
    }

    public int getIconId() {
        Map<String, Integer> r0 = ICON_MAPS;
        if (r0.containsKey(this.mIdentifier) == true) goto L7;
        return 0;
    L7:
        return r0.get(this.mIdentifier).intValue();
    }

    public int getBoomIconId() {
        Map<String, Integer> r0 = BOOM_ICON_MAPS;
        if (r0.containsKey(this.mIdentifier) == true) goto L7;
        return DEFAULT_BOOM_ICON;
    L7:
        return r0.get(this.mIdentifier).intValue();
    }

    public String getTwName() {
        return this.mTwName;
    }

    public void setTwName(String name) {
        this.mTwName = name;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getEnName() {
        return this.mEnName;
    }

    public void setEnName(String enName) {
        this.mEnName = enName;
    }

    public int getOrder() {
        return this.mOrder;
    }

    public void setOrder(int order) {
        this.mOrder = order;
    }

    public String getClickUrl() {
        return this.mClickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.mClickUrl = clickUrl;
    }

    public String getImgUrl() {
        return this.mImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.mImgUrl = imgUrl;
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public Bitmap getIconBitmapBySettings(Context context) {
        return getUrlBitmapBySettings(context, getRealImgUrlByIndex(0));
    }

    public Bitmap getIconBitmap() {
        return getUrlBitmap(getRealImgUrlByIndex(0));
    }

    private Bitmap getUrlBitmap(String url) {
        if (TextUtils.isEmpty(url) == false) goto L6;
        return null;
    L6:
        Uri r4 = Uri.parse(url);     // Catch: Exception -> L14
        if (r4 != null) goto L9;
        return null;
    L9:
        String r5 = ROOT_PATH + LibrarianImpl.Constants.SEPARATOR + r4.getLastPathSegment().replaceAll("\\.", "");     // Catch: Exception -> L14
        if (new File(r5).exists() == true) goto L12;
        return null;
    L12:
        return BitmapFactory.decodeFile(r5);
    L17:
        return null;
    }

    public Bitmap getBoomIconBitmapBySettings(Context context) {
        return getUrlBitmapBySettings(context, getRealImgUrlByIndex(1));
    }

    public String getRealImgUrlByIndex(int index) {
        if (index >= 0) goto L5;
    L14:
        return null;
    L5:
        if (TextUtils.isEmpty(this.mImgUrl) == true) goto L14;
        String[] r2 = this.mImgUrl.split("\\|\\|");
        if (r2 == null) goto L14;
        if (index >= r2.length) goto L14;
        return r2[index];
    }

    private Bitmap getUrlBitmapBySettings(Context context, String url) {
        if (context != null) goto L15;
    L14:
        return null;
    L15:
    L12:
        e = move-exception;
        Log.d(TAG, "getUrlBitmapBySettings exception ex=" + e);
        goto L14
    L5:
        if (TextUtils.isEmpty(url) == true) goto L14;
        Bundle r0 = new Bundle();     // Catch: Exception -> L12
        r0.putString("url", url);     // Catch: Exception -> L12
        Bundle r3 = context.getContentResolver().call(SETTINGS_CONFIGS_URI, "getIcon", null, r0);     // Catch: Exception -> L12
        if (r3 != null) goto L10;
        return null;
    L10:
        return (Bitmap) r3.getParcelable("icon");
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String toString() {
        Object[] r0 = new Object[7];
        r0[0] = this.mIdentifier;
        r0[1] = this.mName;
        r0[2] = this.mEnName;
        r0[3] = Integer.valueOf(this.mOrder);
        r0[4] = this.mClickUrl;
        r0[5] = this.mImgUrl;
        if (this.isDefault == false) goto L5;
        String r3 = "true";
    L6:
        r0[6] = r3;
        return String.format("{mIdentifier:%s,mName:%s,mEnName:%s,mOrder:%d,mClickUrl:%s,mImgUrl:%s,isDefault:%s}\n", r0);
    L5:
        r3 = "false";
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.mIdentifier);
        r1.writeString(this.mName);
        r1.writeString(this.mEnName);
        r1.writeString(this.mTwName);
        r1.writeInt(this.mOrder);
        r1.writeString(this.mClickUrl);
        r1.writeString(this.mImgUrl);
        r1.writeInt(this.isDefault ? 1 : 0);
    }

    private SearchConfigTypeData(Parcel in) {
        this.mIdentifier = in.readString();
        this.mName = in.readString();
        this.mEnName = in.readString();
        this.mTwName = in.readString();
        this.mOrder = in.readInt();
        this.mClickUrl = in.readString();
        this.mImgUrl = in.readString();
        boolean r0 = true;
        if (in.readInt() == 1) goto L6;
        r0 = false;
    L6:
        this.isDefault = r0;
    }
}
