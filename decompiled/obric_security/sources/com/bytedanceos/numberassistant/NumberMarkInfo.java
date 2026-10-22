package com.bytedanceos.numberassistant;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import com.obric.security.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class NumberMarkInfo implements Parcelable {
    public static final Parcelable.Creator<NumberMarkInfo> CREATOR = null;
    public static final int MARK_CLASSIFY_AD_SALES = 2;
    public static final int MARK_CLASSIFY_CAR_SERVICE = 256;
    public static final int MARK_CLASSIFY_CRANK = 8;
    public static final int MARK_CLASSIFY_CRIME = 1;
    public static final int MARK_CLASSIFY_CUSTOMER_SERVICE = 32;
    public static final int MARK_CLASSIFY_CUSTOMIZE = 1073741824;
    public static final int MARK_CLASSIFY_CUSTOMIZE_KEY = 2;
    public static final int MARK_CLASSIFY_CUSTOMIZE_TEXT = 1;
    public static final int MARK_CLASSIFY_DEFAULT = 15;
    public static final int MARK_CLASSIFY_EDUCATION = 64;
    public static final int MARK_CLASSIFY_ENTERPRISE = 16;
    public static final int MARK_CLASSIFY_EXPRESS = 1024;
    public static final int MARK_CLASSIFY_FRAUD = 4;
    public static final int MARK_CLASSIFY_HEADHUNTING = 128;
    public static final int MARK_CLASSIFY_HOUSE_AGENT = 2048;
    public static final int MARK_CLASSIFY_INSURANCE = 512;
    public static final int MARK_CLASSIFY_MEAL_DELIVERY = 524288;
    public static final int MARK_CLASSIFY_NONE = 0;
    public static final int MARK_CLASSIFY_ONE_RING = 4096;
    public static final int MARK_CLASSIFY_ON_SITE_PICK_UP = 131072;
    public static final int MARK_CLASSIFY_ORDER_TRACKING = 1048576;
    public static final int MARK_CLASSIFY_PACKAGE_DELIVERY = 65536;
    public static final int MARK_CLASSIFY_PICK_UP_NOTICE = 2097152;
    public static final int MARK_CLASSIFY_TAXI_BOOKING = 262144;
    public static final int MARK_COUNT_THRESHOLD = 100;
    public static final int MARK_SOURCE_CUSTOMIZE = 3;
    public static final int MARK_SOURCE_LOCAL = 2;
    public static final int MARK_SOURCE_ONLINE = 1;
    public static final int MARK_SOURCE_SMS_PARSER = 4;
    private static Map<String, Integer> sMarkClassifyMap;
    private String mCustomizeMarkString;
    private int mMarkClassifies;
    private Map<Integer, Integer> mMarkClassifyCountMap;
    private int mMarkSource;
    private String mNumber;

    public static class Builder {
        private NumberMarkInfo numberMarkInfo;

        public Builder() {
            this.numberMarkInfo = new NumberMarkInfo();
        }

        public Builder(String number) {
            this.numberMarkInfo = new NumberMarkInfo(number);
        }

        public NumberMarkInfo build() {
            return this.numberMarkInfo;
        }

        public Builder setNumber(String number) {
            NumberMarkInfo.access$002(this.numberMarkInfo, number);
            return this;
        }

        public Builder setMarkClassifies(int markClassifies) {
            NumberMarkInfo.access$102(this.numberMarkInfo, markClassifies);
            return this;
        }

        public Builder addMarkClassify(int markClassify) {
            NumberMarkInfo.access$176(this.numberMarkInfo, markClassify);
            return this;
        }

        public Builder setCustomizeMarkString(String customizeMarkString) {
            NumberMarkInfo.access$202(this.numberMarkInfo, customizeMarkString);
            return this;
        }

        public Builder setMarkSource(int markSource) {
            NumberMarkInfo.access$302(this.numberMarkInfo, markSource);
            return this;
        }

        public Builder setMarkClassifyCount(int markClassify, int markClassifyCount) {
            this.numberMarkInfo.setMarkClassifyCount(markClassify, markClassifyCount);
            return this;
        }
    }

    private String getMarkSourceString(int markSource) {
        if (markSource != 1) goto L5;
        return "ONLINE";
    L5:
        if (markSource != 2) goto L7;
        return "LOCAL";
    L7:
        if (markSource != 3) goto L9;
        return "CUSTOMIZE";
    L9:
        if (markSource == 4) goto L11;
        return NetworkStackConstant.UNKNOWN_TYPE;
    L11:
        return "SMS_PARSER";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static /* synthetic */ String access$002(NumberMarkInfo r0, String r1) {
        r0.mNumber = r1;
        return r1;
    }

    static /* synthetic */ int access$102(NumberMarkInfo r0, int r1) {
        r0.mMarkClassifies = r1;
        return r1;
    }

    static /* synthetic */ int access$176(NumberMarkInfo r1, int r2) {
        int r3 = r2 | r1.mMarkClassifies;
        r1.mMarkClassifies = r3;
        return r3;
    }

    static /* synthetic */ String access$202(NumberMarkInfo r0, String r1) {
        r0.mCustomizeMarkString = r1;
        return r1;
    }

    static /* synthetic */ int access$302(NumberMarkInfo r0, int r1) {
        r0.mMarkSource = r1;
        return r1;
    }

    static {
        HashMap r0 = new HashMap(8);
        sMarkClassifyMap = r0;
        r0.put("违法犯罪", 1);
        sMarkClassifyMap.put("广告推销", 2);
        sMarkClassifyMap.put("疑似诈骗", 4);
        sMarkClassifyMap.put("骚扰电话", 8);
        sMarkClassifyMap.put("企业电话", 16);
        sMarkClassifyMap.put("客服电话", 32);
        sMarkClassifyMap.put("教育培训", 64);
        sMarkClassifyMap.put("招聘猎头", 128);
        sMarkClassifyMap.put("出租车", 256);
        sMarkClassifyMap.put("保险理财", 512);
        sMarkClassifyMap.put("快递送餐", 1024);
        sMarkClassifyMap.put("房产中介", 2048);
        sMarkClassifyMap.put("响一声", 4096);
        CREATOR = new AnonymousClass1();
    }

    public static int convertMarkClassify2Int(String markClassifyString) {
        if (TextUtils.isEmpty(markClassifyString) == false) goto L7;
        return 0;
    L7:
        if (sMarkClassifyMap.containsKey(markClassifyString) == true) goto L9;
        return 1073741824;
    L9:
        return sMarkClassifyMap.get(markClassifyString).intValue();
    }

    public static String getMarkClassifyChineseString(NumberMarkInfo numberMarkInfo) {
        if (numberMarkInfo != null) goto L5;
    L18:
        return "";
    L5:
        if (numberMarkInfo.mMarkClassifies <= 0) goto L18;
        Iterator<Map.Entry<String, Integer>> r1 = sMarkClassifyMap.entrySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L15;
        Map.Entry<String, Integer> r2 = r1.next();
        if (r2.getValue().intValue() != numberMarkInfo.getMainMarkClassify()) goto L9;
        return r2.getKey();
    L15:
        if (1073741824 != numberMarkInfo.getMainMarkClassify()) goto L18;
        return numberMarkInfo.getCustomizeMarkString();
    }

    public static String getMarkClassifyText(Context context, NumberMarkInfo numberMarkInfo) {
        if (context == null) goto L9;
        if (numberMarkInfo != null) goto L5;
        return "";
    L5:
        if (numberMarkInfo.mMarkClassifies > 0) goto L8;
        return "";
    L8:
        return getMarkClassifyString(context, numberMarkInfo.getMainMarkClassify(), numberMarkInfo.getCustomizeMarkString(), 1);
    L9:
        return "";
    }

    public static String getMarkClassifyTypeString(Context context, int markClassify) {
        return getMarkClassifyString(context, markClassify, null, 2);
    }

    private static String getMarkClassifyString(Context context, int markClassify, String markClassifyText, int customizeKeyOrValue) {
        if (1073741824 != markClassify) goto L12;
        if (customizeKeyOrValue != 1) goto L10;
        if (markClassifyText != null) goto L13;
        return "";
    L13:
        return markClassifyText;
    L10:
        return context.getString(R.string.number_mark_classify_customize);
    L12:
        return getFixedMarkClassifyString(context, markClassify);
    }

    private static String getFixedMarkClassifyString(Context context, int markClassify) {
        if (markClassify != 1) goto L5;
        int r2 = R.string.number_mark_classify_crime;
    L27:
        if (r2 != 0) goto L31;
        return "";
    L31:
        return context.getString(r2);
    L5:
        if (markClassify == 2) goto L25;
        switch(markClassify) {
            case 4: goto L24;
            case 8: goto L23;
            case 16: goto L22;
            case 32: goto L21;
            case 64: goto L20;
            case 128: goto L19;
            case 256: goto L18;
            case 512: goto L17;
            case 1024: goto L16;
            case 2048: goto L15;
            case 4096: goto L14;
            case 65536: goto L13;
            case 131072: goto L12;
            case 262144: goto L11;
            case 524288: goto L10;
            case 1048576: goto L9;
            case 2097152: goto L8;
            default: goto L7;
        };
    L7:
        r2 = 0;
        goto L27
    L8:
        r2 = R.string.number_mark_classify_2_pick_up_notice;
        goto L27
    L9:
        r2 = R.string.number_mark_classify_2_order_tracking;
        goto L27
    L10:
        r2 = R.string.number_mark_classify_2_meal_delivery;
        goto L27
    L11:
        r2 = R.string.number_mark_classify_2_taxi_booking;
        goto L27
    L12:
        r2 = R.string.number_mark_classify_2_on_site_pick_up;
        goto L27
    L13:
        r2 = R.string.number_mark_classify_2_package_delivery;
        goto L27
    L14:
        r2 = R.string.number_mark_classify_one_ring;
        goto L27
    L15:
        r2 = R.string.number_mark_classify_house_agent;
        goto L27
    L16:
        r2 = R.string.number_mark_classify_express;
        goto L27
    L17:
        r2 = R.string.number_mark_classify_insurance;
        goto L27
    L18:
        r2 = R.string.number_mark_classify_car_service;
        goto L27
    L19:
        r2 = R.string.number_mark_classify_headhunting;
        goto L27
    L20:
        r2 = R.string.number_mark_classify_education;
        goto L27
    L21:
        r2 = R.string.number_mark_classify_customer_service;
        goto L27
    L22:
        r2 = R.string.number_mark_classify_enterprise;
        goto L27
    L23:
        r2 = R.string.number_mark_classify_crank;
        goto L27
    L24:
        r2 = R.string.number_mark_classify_fraud;
        goto L27
    L25:
        r2 = R.string.number_mark_classify_ad_sales;
        goto L27
    }

    public static String getMarkClassifySourceString(Context context, int markClassify) {
        if (context == null) goto L26;
        if (markClassify <= 0) goto L26;
        if (markClassify != 65536) goto L9;
    L21:
        int r3 = R.string.order_source_package;
    L22:
        if (r3 != 0) goto L25;
        return "";
    L25:
        return context.getString(r3);
    L9:
        if (markClassify == 131072) goto L21;
        if (markClassify != 262144) goto L13;
        r3 = R.string.order_source_taxi;
        goto L22
    L13:
        if (markClassify != 524288) goto L15;
        r3 = R.string.order_source_meal;
        goto L22
    L15:
        if (markClassify == 1048576) goto L21;
        if (markClassify == 2097152) goto L21;
        r3 = 0;
    L26:
        return "";
    }

    public NumberMarkInfo() {
        this("");
    }

    public NumberMarkInfo(String number) {
        this(number, 0, "", 0, null);
    }

    public NumberMarkInfo(String number, int markClassifies, String customizeMarkString, int markSource, Map<Integer, Integer> typeCountMap) {
        this.mNumber = number;
        this.mMarkClassifies = markClassifies;
        this.mCustomizeMarkString = customizeMarkString;
        this.mMarkSource = markSource;
        if (typeCountMap != null) goto L6;
        typeCountMap = new HashMap(1);
    L6:
        this.mMarkClassifyCountMap = typeCountMap;
    }

    public NumberMarkInfo(Parcel parcel) {
        this.mNumber = parcel.readString();
        this.mMarkClassifies = parcel.readInt();
        this.mCustomizeMarkString = parcel.readString();
        this.mMarkSource = parcel.readInt();
        this.mMarkClassifyCountMap = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("markInfo=[number=");
        r0.append(this.mNumber).append(", markClassifies=0x").append(Integer.toHexString(this.mMarkClassifies)).append(", customizeMarkString=").append(this.mCustomizeMarkString);
        Map<Integer, Integer> r1 = this.mMarkClassifyCountMap;
        if (r1 != null) goto L5;
    L14:
        r0.append("]");
        r0.append(", markSource=" + getMarkSourceString(this.mMarkSource));
        return r0.toString();
    L5:
        if (r1.size() <= 0) goto L14;
        r0.append(", markClassifyCount=(");
        Iterator<Map.Entry<Integer, Integer>> r2 = this.mMarkClassifyCountMap.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        Map.Entry<Integer, Integer> r3 = r2.next();
        if (r3 == null) goto L8;
        r0.append("<").append(r3.toString()).append(">");
        goto L8
    L13:
        r0.append(")");
        goto L14
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mNumber);
        dest.writeInt(this.mMarkClassifies);
        dest.writeString(this.mCustomizeMarkString);
        dest.writeInt(this.mMarkSource);
        dest.writeMap(this.mMarkClassifyCountMap);
    }

    public String getNumber() {
        String r0 = this.mNumber;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public void setNumber(String number) {
        this.mNumber = number;
    }

    public int getMarkClassifies() {
        return this.mMarkClassifies;
    }

    public int getMainMarkClassify() {
        Iterator<Map.Entry<Integer, Integer>> r5 = this.mMarkClassifyCountMap.entrySet().iterator();
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r5.hasNext() == false) goto L8;
        Map.Entry<Integer, Integer> r2 = r5.next();
        if (r1 >= r2.getValue().intValue()) goto L4;
        int r3 = r2.getValue().intValue();
        r1 = r3;
        r0 = r2.getKey().intValue();
        goto L4
    L8:
        return r0;
    }

    public void setMarkClassifies(int markClassifies) {
        this.mMarkClassifies = markClassifies;
    }

    public void addMarkClassify(int markClassify) {
        this.mMarkClassifies = markClassify | this.mMarkClassifies;
    }

    public boolean isContainMarkClassify(int markClassify) {
        if ((this.mMarkClassifies & markClassify) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void setCustomizeMarkString(String customizeMarkString) {
        this.mCustomizeMarkString = customizeMarkString;
    }

    public String getCustomizeMarkString() {
        String r0 = this.mCustomizeMarkString;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public void setMarkSource(int markSource) {
        this.mMarkSource = markSource;
    }

    public int getMarkSource() {
        return this.mMarkSource;
    }

    public int getMarkClassifyCount(int markClassify) {
        return this.mMarkClassifyCountMap.get(Integer.valueOf(markClassify)).intValue();
    }

    public void setMarkClassifyCount(int markClassify, int markClassifyCount) {
        if (this.mMarkClassifyCountMap.containsKey(Integer.valueOf(markClassify)) == false) goto L5;
        this.mMarkClassifyCountMap.replace(Integer.valueOf(markClassify), Integer.valueOf(markClassifyCount));
        return;
    L5:
        this.mMarkClassifyCountMap.put(Integer.valueOf(markClassify), Integer.valueOf(markClassifyCount));
    }
}
