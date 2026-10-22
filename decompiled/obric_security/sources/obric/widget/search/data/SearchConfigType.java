package obric.widget.search.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes5.dex */
public class SearchConfigType implements Parcelable {
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
    private boolean isChecked;
    private List<SearchConfigTypeData> mDatas;
    private int mMode;
    private int mOrder;
    private String mType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ SearchConfigType(Parcel r1, AnonymousClass1 r2) {
        this(r1);
    }

    public SearchConfigType() {
        this.isChecked = false;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String type) {
        this.mType = type;
    }

    public int getOrder() {
        return this.mOrder;
    }

    public void setOrder(int order) {
        this.mOrder = order;
    }

    public List<SearchConfigTypeData> getDatas() {
        return this.mDatas;
    }

    public SearchConfigTypeData getDefaultData() {
        List<SearchConfigTypeData> r0 = this.mDatas;
        if (r0 != null) goto L6;
        return null;
    L6:
        Iterator<SearchConfigTypeData> r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        SearchConfigTypeData r2 = r1.next();
        if (r2.isDefault() == false) goto L8;
        return r2;
    L12:
        Log.e(TAG, "not find default value for type=" + this.mType);
        return this.mDatas.get(0);
    }

    public int updateDefaultData(String dataId) {
        SearchConfigTypeData r4 = getByIdentifier(dataId);
        if (r4 != null) goto L5;
        return 0;
    L5:
        Iterator<SearchConfigTypeData> r3 = this.mDatas.iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        SearchConfigTypeData r1 = r3.next();
        if (r1 != r4) goto L10;
        r1.setDefault(true);
        goto L7
    L10:
        r1.setDefault(false);
        goto L7
    L12:
        return 0;
    }

    public SearchConfigTypeData getByIdentifier(String identifier) {
        List<SearchConfigTypeData> r3 = this.mDatas;
        if (r3 == null) goto L12;
        if (identifier == null) goto L12;
        Iterator<SearchConfigTypeData> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        SearchConfigTypeData r1 = r4.next();
        if (TextUtils.equals(identifier, r1.getIdentifier()) == false) goto L8;
        return r1;
    L12:
        return null;
    }

    public boolean hasDatas() {
        List<SearchConfigTypeData> r1 = this.mDatas;
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.size() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public void setDatas(List<SearchConfigTypeData> datas) {
        this.mDatas = datas;
        if (datas == null) goto L6;
        Collections.sort(datas, new AnonymousClass1(this));
        return;
    }

    public int getMode() {
        return this.mMode;
    }

    public void setMode(int mode) {
        this.mMode = mode;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        if (this.mDatas == null) goto L9;
        Iterator<SearchConfigTypeData> r1 = getDatas().iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        r0.append(r1.next().toString() + IOUtils.LINE_SEPARATOR_UNIX);
    L9:
        return String.format("{mType:%s,mOrder:%d,mMode:%d,mdatas:[%s]}\n", new Object[]{this.mType, Integer.valueOf(this.mOrder), Integer.valueOf(this.mMode), r0});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.mType);
        out.writeInt(this.mOrder);
        out.writeInt(this.mMode);
        out.writeTypedList(this.mDatas);
    }

    private SearchConfigType(Parcel in) {
        this.isChecked = false;
        this.mType = in.readString();
        this.mOrder = in.readInt();
        this.mMode = in.readInt();
        if (this.mDatas != null) goto L5;
        this.mDatas = new ArrayList();
    L5:
        in.readTypedList(this.mDatas, SearchConfigTypeData.CREATOR);
    }

    static {
        CREATOR = new AnonymousClass2();
    }
}
