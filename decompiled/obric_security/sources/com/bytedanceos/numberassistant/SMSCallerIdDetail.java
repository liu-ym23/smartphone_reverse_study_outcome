package com.bytedanceos.numberassistant;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class SMSCallerIdDetail implements Parcelable {
    public static final Parcelable.Creator<SMSCallerIdDetail> CREATOR = null;
    private String mLogoName;
    private String mLogoPath;
    private String mName;
    private String mNumber;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getNumber() {
        return this.mNumber;
    }

    public String getName() {
        return this.mName;
    }

    public String getLogoPath() {
        return this.mLogoPath;
    }

    public String getLogoName() {
        return this.mLogoName;
    }

    public SMSCallerIdDetail(String number, String name, String logoPath, String logoName) {
        this.mNumber = number;
        this.mName = name;
        this.mLogoPath = logoPath;
        this.mLogoName = logoName;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("number:");
        r0.append(this.mNumber).append(", name:").append(this.mName).append(", logoPath:").append(this.mLogoPath).append(", logoName:").append(this.mLogoName);
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mNumber);
        dest.writeString(this.mName);
        dest.writeString(this.mLogoPath);
        dest.writeString(this.mLogoName);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
