package com.bytedanceos.numberassistant;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class YellowPageResult implements Parcelable {
    public static final Parcelable.Creator<YellowPageResult> CREATOR = null;
    public String matchName;
    public String name;
    public String number;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public YellowPageResult(String name, String number, String matchName) {
        this.name = name;
        this.number = number;
        this.matchName = matchName;
    }

    public YellowPageResult(String name, String number) {
        this.name = name;
        this.number = number;
    }

    private YellowPageResult(Parcel in) {
        this.name = in.readString();
        this.number = in.readString();
        this.matchName = in.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.number);
        dest.writeString(this.matchName);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
