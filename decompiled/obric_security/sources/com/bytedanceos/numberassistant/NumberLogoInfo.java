package com.bytedanceos.numberassistant;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class NumberLogoInfo implements Parcelable {
    public static final Parcelable.Creator<NumberLogoInfo> CREATOR = null;
    private byte[] mLogoByte;
    private String mLogoUrl;
    private String mNumber;

    public static class Builder {
        private NumberLogoInfo numberLogoInfo;

        public Builder() {
            this.numberLogoInfo = new NumberLogoInfo();
        }

        public Builder(String number) {
            this.numberLogoInfo = new NumberLogoInfo(number);
        }

        public NumberLogoInfo build() {
            return this.numberLogoInfo;
        }

        public Builder setNumber(String number) {
            NumberLogoInfo.access$002(this.numberLogoInfo, number);
            return this;
        }

        public Builder setLogoUrl(String logoUrl) {
            NumberLogoInfo.access$102(this.numberLogoInfo, logoUrl);
            return this;
        }

        public Builder setLogoByte(byte[] logoByte) {
            NumberLogoInfo.access$202(this.numberLogoInfo, logoByte);
            return this;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static /* synthetic */ String access$002(NumberLogoInfo r0, String r1) {
        r0.mNumber = r1;
        return r1;
    }

    static /* synthetic */ String access$102(NumberLogoInfo r0, String r1) {
        r0.mLogoUrl = r1;
        return r1;
    }

    static /* synthetic */ byte[] access$202(NumberLogoInfo r0, byte[] r1) {
        r0.mLogoByte = r1;
        return r1;
    }

    public NumberLogoInfo() {
        this("", "", null);
    }

    public NumberLogoInfo(String number) {
        this(number, "", null);
    }

    public NumberLogoInfo(String number, String markType, byte[] logoByte) {
        this.mNumber = number;
        this.mLogoUrl = markType;
        this.mLogoByte = logoByte;
    }

    public NumberLogoInfo(Parcel parcel) {
        this.mNumber = parcel.readString();
        this.mLogoUrl = parcel.readString();
        byte[] r0 = new byte[parcel.readInt()];
        this.mLogoByte = r0;
        parcel.readByteArray(r0);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("[number=");
        StringBuilder r1 = r0.append(this.mNumber).append(", logoUrl=").append(this.mLogoUrl).append(", logoByte.length=");
        byte[] r3 = this.mLogoByte;
        if (r3 != null) goto L5;
        int r4 = 0;
    L6:
        r1.append(r4).append("]");
        return r0.toString();
    L5:
        r4 = r3.length;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mNumber);
        dest.writeString(this.mLogoUrl);
        dest.writeInt(getLogoByteLength());
        dest.writeByteArray(this.mLogoByte);
    }

    private int getLogoByteLength() {
        byte[] r0 = this.mLogoByte;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length;
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

    public byte[] getLogoByte() {
        return this.mLogoByte;
    }

    public void setLogoByte(byte[] logoByte) {
        this.mLogoByte = logoByte;
    }
}
