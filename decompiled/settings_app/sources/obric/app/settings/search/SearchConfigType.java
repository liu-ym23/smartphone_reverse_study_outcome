package obric.app.settings.search;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SearchConfigType {
    public static final String CONFIG_BAIKE = "config_baike";
    public static final String CONFIG_DICT = "config_dictionary";
    public static final String CONFIG_SEARCH = "config_search";
    public static final String CONFIG_THIRD = "config_third_search";
    public static final Parcelable.Creator<SearchConfigType> CREATOR = null;
    public static final String KEY_DATAS = "datas";
    public static final String KEY_MODE = "mode";
    public static final String KEY_ORDER = "order";
    public static final String KEY_TYPE = "type";
    public static final int MODE_FORCE = 1;
    private static final String TAG = "SearchConfigType";
    private List<SearchConfigTypeData> mDatas;
    private int mMode;
    private int mOrder;
    private String mType;

    public int describeContents() {
        return 0;
    }

    public SearchConfigTypeData getByIdentifier(String r1) {
        return null;
    }

    public SearchConfigTypeData getDefaultData() {
        return null;
    }

    public void setDatas(List<SearchConfigTypeData> r1) {
    }

    public int updateDefaultData(String r1) {
        return 0;
    }

    public void writeToParcel(Parcel r1, int r2) {
    }

    /* synthetic */ SearchConfigType(Parcel r1, AnonymousClass1 r2) {
        this(r1);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public SearchConfigType() {
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String r1) {
        this.mType = r1;
    }

    public int getOrder() {
        return this.mOrder;
    }

    public void setOrder(int r1) {
        this.mOrder = r1;
    }

    public List<SearchConfigTypeData> getDatas() {
        return this.mDatas;
    }

    public int getMode() {
        return this.mMode;
    }

    public void setMode(int r1) {
        this.mMode = r1;
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        if (this.mDatas == null) goto L9;
        Iterator<SearchConfigTypeData> r1 = getDatas().iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        r0.append(r1.next().toString() + "\n");
    L9:
        return String.format("{mType:%s,mOrder:%d,mMode:%d,mdatas:[%s]}\n", new Object[]{this.mType, Integer.valueOf(this.mOrder), Integer.valueOf(this.mMode), r0});
    }

    private SearchConfigType(Parcel r1) {
    }
}
