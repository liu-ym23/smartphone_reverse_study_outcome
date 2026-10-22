package com.bytedanceos.numberassistant;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NumberQueryParams implements Parcelable {
    public static final Parcelable.Creator<NumberQueryParams> CREATOR = null;
    public static final int QUERY_LOGO_HEIGHT_DEFAULT = 200;
    public static final String QUERY_LOGO_HEIGHT_KEY = "logo_height";
    public static final String QUERY_LOGO_URL_KEY = "query_logo_url";
    public static final int QUERY_LOGO_WIDTH_DEFAULT = 200;
    public static final String QUERY_LOGO_WIDTH_KEY = "logo_width";
    public static final int QUERY_NUMBER_LIMIT = 50;
    public static final int QUERY_NUMBER_WITH_LOGO_LIMIT = 5;
    public static final int QUERY_STRATEGY_LOCAL_OR_ONLINE = 1;
    public static final int QUERY_STRATEGY_ONLINE_OR_LOCAL = 2;
    public static final int QUERY_TYPE_ALL = 7;
    public static final int QUERY_TYPE_BASE = 1;
    public static final int QUERY_TYPE_LOGO = 4;
    public static final int QUERY_TYPE_MARK = 2;
    public static final int QUERY_TYPE_YELLOW_PAGE = 1024;
    public static final String QUERY_YELLOW_PAGE_TEXT_KEY = "query_yellow_page_text";
    private Bundle mExtend;
    private List<String> mNumberList;
    private int mQueryStrategy;
    private int mQueryType;

    public static class Builder {
        private NumberQueryParams queryParams;

        public Builder() {
            this.queryParams = new NumberQueryParams();
        }

        public Builder(String number) {
            this.queryParams = new NumberQueryParams(number);
        }

        public NumberQueryParams build() {
            return this.queryParams;
        }

        public Builder append(int queryType) {
            this.queryParams.addQueryType(queryType);
            return this;
        }

        public Builder setQueryType(int queryType) {
            this.queryParams.setQueryType(queryType);
            return this;
        }

        public Builder setQueryStrategy(int queryStrategy) {
            this.queryParams.setQueryStrategy(queryStrategy);
            return this;
        }

        public Builder setQueryText(int text) {
            this.queryParams.setQueryStrategy(text);
            return this;
        }

        public Builder setExtension(Bundle extend) {
            this.queryParams.setExtend(extend);
            return this;
        }

        public Builder append(String number) {
            this.queryParams.addNumber(number);
            return this;
        }

        public Builder setNumber(String number) {
            this.queryParams.setNumber(number);
            return this;
        }

        public Builder setNumberList(List<String> numberList) {
            this.queryParams.setNumberList(numberList);
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public NumberQueryParams() {
        this("");
    }

    public NumberQueryParams(String number) {
        this.mNumberList = new ArrayList(1);
        if (TextUtils.isEmpty(number) == true) goto L6;
        this.mNumberList.add(number);
        return;
    }

    public NumberQueryParams(Parcel parcel) {
        ArrayList r0 = new ArrayList(1);
        this.mNumberList = r0;
        parcel.readStringList(r0);
        this.mQueryType = parcel.readInt();
        this.mQueryStrategy = parcel.readInt();
        this.mExtend = parcel.readBundle();
    }

    private boolean isEmptyNumberList() {
        List<String> r0 = this.mNumberList;
        if (r0 != null) goto L5;
    L8:
        return true;
    L5:
        if (r0.size() == 0) goto L8;
        return false;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("{number=");
        if (isEmptyNumberList() == false) goto L5;
        Object r1 = "null";
    L6:
        r0.append(r1).append(", queryType=").append(this.mQueryType).append(", queryStrategy=").append(this.mQueryStrategy).append(", extend=").append(this.mExtend).append("}");
        return r0.toString();
    L5:
        r1 = this.mNumberList;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(this.mNumberList);
        dest.writeInt(this.mQueryType);
        dest.writeInt(this.mQueryStrategy);
        dest.writeBundle(this.mExtend);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public String getFirstNumber() {
        if (this.mNumberList.size() > 0) goto L5;
        return "";
    L5:
        return this.mNumberList.get(0);
    }

    public void setNumber(String number) {
        this.mNumberList.clear();
        this.mNumberList.add(number);
    }

    public void addNumber(String number) {
        this.mNumberList.add(number);
        checkLimited();
    }

    public List<String> getNumberList() {
        return this.mNumberList;
    }

    public void setNumberList(List<String> numberList) {
        this.mNumberList.clear();
        this.mNumberList.addAll(numberList);
        checkLimited();
    }

    public int getQueryType() {
        return this.mQueryType;
    }

    public void setQueryType(int queryType) {
        this.mQueryType = queryType;
        checkLimited();
    }

    public void addQueryType(int queryType) {
        this.mQueryType = queryType | this.mQueryType;
        checkLimited();
    }

    public int getQueryStrategy() {
        return this.mQueryStrategy;
    }

    public void setQueryStrategy(int queryStrategy) {
        this.mQueryStrategy = queryStrategy;
    }

    public Bundle getExtend() {
        return this.mExtend;
    }

    public void setExtend(Bundle extend) {
        this.mExtend = extend;
    }

    public boolean isQueryBase() {
        if ((this.mQueryType & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isQueryMark() {
        if ((this.mQueryType & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isQueryLogo() {
        if ((this.mQueryType & 4) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isQueryYellowPage() {
        if ((this.mQueryType & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void checkLimited() {
        int r0 = this.mNumberList.size();
        boolean r1 = true;
        if ((this.mQueryType & 4) == 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L11;
        if (r0 > 5) goto L14;
    L13:
        r1 = false;
    L14:
        if (r1 == true) goto L16;
        return;
    L16:
        StringBuilder r2 = new StringBuilder("The number list size is overflow! queryWithLogo=");
        r2.append(r4);
        r2.append(", size=").append(r0);
        throw new AndroidRuntimeException(r2.toString());
    L11:
        if (r0 <= 50) goto L13;
    L5:
        r4 = false;
        goto L6
    }
}
