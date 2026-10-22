package com.bytedanceos.numberassistant;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NumberBaseInfo implements Parcelable {
    public static final Parcelable.Creator<NumberBaseInfo> CREATOR = null;
    private static String sAreaHongkong = "香港";
    private static String sAreaMacao = "澳门";
    private static String sAreaTaiwan = "台湾";
    private static String sCountryChina = "中国";
    private String mArea;
    private String mCountry;
    private String mLogoUrl;
    private String mNumber;
    private String mOperator;
    private String mOrganizationName;

    public static class Builder {
        private NumberBaseInfo numberBaseInfo;

        public Builder() {
            this.numberBaseInfo = new NumberBaseInfo();
        }

        public Builder(String number) {
            this.numberBaseInfo = new NumberBaseInfo(number);
        }

        public NumberBaseInfo build() {
            return this.numberBaseInfo;
        }

        public Builder setNumber(String number) {
            NumberBaseInfo.access$002(this.numberBaseInfo, number);
            return this;
        }

        public Builder setCountry(String country) {
            NumberBaseInfo.access$102(this.numberBaseInfo, country);
            return this;
        }

        public Builder setArea(String area) {
            NumberBaseInfo.access$202(this.numberBaseInfo, area);
            return this;
        }

        public Builder setOperator(String operator) {
            NumberBaseInfo.access$302(this.numberBaseInfo, operator);
            return this;
        }

        public Builder setOrganizationName(String organizationName) {
            NumberBaseInfo.access$402(this.numberBaseInfo, organizationName);
            return this;
        }

        public Builder setLogoUrl(String logoUrl) {
            NumberBaseInfo.access$502(this.numberBaseInfo, logoUrl);
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static /* synthetic */ String access$002(NumberBaseInfo r0, String r1) {
        r0.mNumber = r1;
        return r1;
    }

    static /* synthetic */ String access$102(NumberBaseInfo r0, String r1) {
        r0.mCountry = r1;
        return r1;
    }

    static /* synthetic */ String access$202(NumberBaseInfo r0, String r1) {
        r0.mArea = r1;
        return r1;
    }

    static /* synthetic */ String access$302(NumberBaseInfo r0, String r1) {
        r0.mOperator = r1;
        return r1;
    }

    static /* synthetic */ String access$402(NumberBaseInfo r0, String r1) {
        r0.mOrganizationName = r1;
        return r1;
    }

    static /* synthetic */ String access$502(NumberBaseInfo r0, String r1) {
        r0.mLogoUrl = r1;
        return r1;
    }

    public NumberBaseInfo() {
        this("");
    }

    public NumberBaseInfo(String number) {
        this.mNumber = number;
    }

    public NumberBaseInfo(Parcel parcel) {
        this.mNumber = parcel.readString();
        this.mCountry = parcel.readString();
        this.mArea = parcel.readString();
        this.mOperator = parcel.readString();
        this.mOrganizationName = parcel.readString();
        this.mLogoUrl = parcel.readString();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[number=");
        r0.append(this.mNumber).append(", country=").append(this.mCountry).append(", area=").append(this.mArea).append(", operator=").append(this.mOperator).append(", organizationName=").append(this.mOrganizationName).append(", logoUrl=").append(this.mLogoUrl).append("]");
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mNumber);
        dest.writeString(this.mCountry);
        dest.writeString(this.mArea);
        dest.writeString(this.mOperator);
        dest.writeString(this.mOrganizationName);
        dest.writeString(this.mLogoUrl);
    }

    static {
        CREATOR = new AnonymousClass1();
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

    public String getCountry() {
        String r0 = this.mCountry;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public void setCountry(String country) {
        this.mCountry = country;
    }

    public String getArea() {
        String r0 = this.mArea;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public void setArea(String area) {
        this.mArea = area;
    }

    public String getOperator() {
        String r0 = this.mOperator;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public void setOperator(String operator) {
        this.mOperator = operator;
    }

    public String getOrganizationName() {
        String r0 = this.mOrganizationName;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public void setOrganizationName(String organizationName) {
        this.mOrganizationName = organizationName;
    }

    public String getLogoUrl() {
        String r0 = this.mLogoUrl;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public void setLogoUrl(String logoUrl) {
        this.mLogoUrl = logoUrl;
    }

    public String getLocation() {
        String r1 = "";
        if (sAreaHongkong.equals(this.mArea) == false) goto L5;
    L13:
        String r0 = sCountryChina;
    L15:
        if (TextUtils.isEmpty(this.mArea) == false) goto L17;
        return r0;
    L17:
        if (TextUtils.isEmpty(r0) == true) goto L26;
        StringBuilder r2 = new StringBuilder().append(r0);
        if (sCountryChina.equals(r0) == true) goto L24;
        r1 = " ";
    L24:
        return r2.append(r1).append(getArea()).toString();
    L26:
        return getArea();
    L5:
        if (sAreaMacao.equals(this.mArea) == true) goto L13;
        if (sAreaTaiwan.equals(this.mArea) == true) goto L13;
        if (sCountryChina.equals(this.mCountry) == true) goto L12;
        r0 = getCountry();
        goto L15
    L12:
        r0 = "";
        goto L15
    }
}
