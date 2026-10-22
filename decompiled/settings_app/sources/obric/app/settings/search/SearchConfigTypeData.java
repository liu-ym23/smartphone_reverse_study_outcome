package obric.app.settings.search;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.olog.OLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class SearchConfigTypeData {
    private static final Map<String, Integer> BOOM_ICON_MAPS = null;
    public static final Parcelable.Creator<SearchConfigTypeData> CREATOR = null;
    public static final int DEFAULT_BOOM_ICON = 33685773;
    public static final int DEFAULT_ICON = 33686102;
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

    public int describeContents() {
        return 0;
    }

    /* synthetic */ SearchConfigTypeData(Parcel r1, AnonymousClass1 r2) {
        this(r1);
    }

    static {
        ROOT_PATH = Environment.getExternalStorageDirectory() + "/bytedance/settings";
        SETTINGS_CONFIGS_URI = Uri.parse("content://com.bytedanceos.gloable.searchconfig.provider");
        HashMap r0 = new HashMap();
        ICON_MAPS = r0;
        HashMap r1 = new HashMap();
        BOOM_ICON_MAPS = r1;
        r0.put("search_sogou", 33686101);
        r0.put("search_baidu", 33686092);
        r0.put("search_google", 33686096);
        r0.put("search_bing", 33686094);
        r0.put("search_360so", 33686091);
        r0.put("search_toutiao", Integer.valueOf(DEFAULT_ICON));
        r0.put("dictionary_youdao", 33686107);
        r0.put("dictionary_bing", 33686095);
        r0.put("dictionary_iciba", 33686099);
        r0.put("dictionary_google", 33686097);
        r0.put("baike_baidu", 33686093);
        r0.put("baike_hudong", 33686098);
        r0.put("baike_wikiEN", 33686106);
        r0.put("baike_wikiCN", 33686105);
        r0.put("third_sogou", 33686104);
        r0.put("third_weibo", 33686103);
        r0.put("third_zhihu", 33686108);
        r1.put("search_sogou", 33685772);
        r1.put("search_baidu", 33685751);
        r1.put("search_google", 33685755);
        r1.put("search_bing", 33685753);
        r1.put("search_360so", 33685750);
        r1.put("search_toutiao", Integer.valueOf(DEFAULT_BOOM_ICON));
        r1.put("dictionary_youdao", 33685788);
        r1.put("dictionary_bing", 33685754);
        r1.put("dictionary_iciba", 33685758);
        r1.put("dictionary_google", 33685756);
        r1.put("baike_baidu", 33685752);
        r1.put("baike_hudong", 33685757);
        r1.put("baike_wikiEN", 33685787);
        r1.put("baike_wikiCN", 33685786);
        r1.put("third_sogou", 33685775);
        r1.put("third_weibo", 33685774);
        r1.put("third_zhihu", 33685789);
        CREATOR = new AnonymousClass1();
    }

    public SearchConfigTypeData() {
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public void setIdentifier(String r1) {
        this.mIdentifier = r1;
    }

    public int getIconId() {
        Map<String, Integer> r0 = ICON_MAPS;
        if (r0.containsKey(this.mIdentifier) == true) goto L6;
        return DEFAULT_ICON;
    L6:
        return r0.get(this.mIdentifier).intValue();
    }

    public int getBoomIconId() {
        Map<String, Integer> r0 = BOOM_ICON_MAPS;
        if (r0.containsKey(this.mIdentifier) == true) goto L6;
        return DEFAULT_BOOM_ICON;
    L6:
        return r0.get(this.mIdentifier).intValue();
    }

    public boolean hasBoomIconId() {
        return BOOM_ICON_MAPS.containsKey(this.mIdentifier);
    }

    public String getTwName() {
        return this.mTwName;
    }

    public void setTwName(String r1) {
        this.mTwName = r1;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String r1) {
        this.mName = r1;
    }

    public String getEnName() {
        return this.mEnName;
    }

    public void setEnName(String r1) {
        this.mEnName = r1;
    }

    public int getOrder() {
        return this.mOrder;
    }

    public void setOrder(int r1) {
        this.mOrder = r1;
    }

    public String getClickUrl() {
        return this.mClickUrl;
    }

    public void setClickUrl(String r1) {
        this.mClickUrl = r1;
    }

    public String getImgUrl() {
        return this.mImgUrl;
    }

    public void setImgUrl(String r1) {
        this.mImgUrl = r1;
    }

    public String getRealImgUrlByIndex(int r3) {
        if (r3 >= 0) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(this.mImgUrl) == true) goto L13;
        String[] r2 = this.mImgUrl.split("\\|\\|");
        if (r2 != null) goto L9;
        return null;
    L9:
        if (r3 < r2.length) goto L11;
        return null;
    L11:
        return r2[r3];
    L13:
        return null;
    }

    public Bitmap getIconBitmap() {
        return getUrlBitmap(getRealImgUrlByIndex(0));
    }

    public Bitmap getBoomIconBitmap() {
        return getUrlBitmap(getRealImgUrlByIndex(1));
    }

    public Bitmap getIconBitmapBySettings(Context r2) {
        return getUrlBitmapBySettings(r2, getRealImgUrlByIndex(0));
    }

    public Bitmap getBoomIconBitmapBySettings(Context r2) {
        return getUrlBitmapBySettings(r2, getRealImgUrlByIndex(1));
    }

    private Bitmap getUrlBitmap(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return null;
    L6:
        Uri r5 = Uri.parse(r4);     // Catch: Exception -> L14
        if (r5 != null) goto L9;
        return null;
    L9:
        String r6 = ROOT_PATH + LibrarianImpl.Constants.SEPARATOR + r5.getLastPathSegment().replaceAll("\\.", "");     // Catch: Exception -> L14
        if (new File(r6).exists() == false) goto L17;
        return BitmapFactory.decodeFile(r6);
    L17:
        return null;
    L18:
        return null;
    }

    private Bitmap getUrlBitmapBySettings(Context r4, String r5) {
        if (r4 != null) goto L15;
    L14:
        return null;
    L15:
    L12:
        e = move-exception;
        OLog.d(TAG, "getUrlBitmapBySettings exception ex=" + e);
        goto L14
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L14;
        Bundle r0 = new Bundle();     // Catch: Exception -> L12
        r0.putString("url", r5);     // Catch: Exception -> L12
        String r2 = (String) null;     // Catch: Exception -> L12
        Bundle r6 = r4.getContentResolver().call(SETTINGS_CONFIGS_URI, "getIcon", null, r0);     // Catch: Exception -> L12
        if (r6 == null) goto L17;
        return (Bitmap) r6.getParcelable("icon");
    L17:
        return null;
    }

    public boolean isDefault() {
        return this.isDefault;
    }

    public void setDefault(boolean r1) {
        this.isDefault = r1;
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

    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.mIdentifier);
        r1.writeString(this.mName);
        r1.writeString(this.mEnName);
        r1.writeString(this.mTwName);
        r1.writeInt(this.mOrder);
        r1.writeString(this.mClickUrl);
        r1.writeString(this.mImgUrl);
        r1.writeBoolean(this.isDefault);
    }

    private SearchConfigTypeData(Parcel r2) {
        this.mIdentifier = r2.readString();
        this.mName = r2.readString();
        this.mEnName = r2.readString();
        this.mTwName = r2.readString();
        this.mOrder = r2.readInt();
        this.mClickUrl = r2.readString();
        this.mImgUrl = r2.readString();
        this.isDefault = r2.readBoolean();
    }
}
