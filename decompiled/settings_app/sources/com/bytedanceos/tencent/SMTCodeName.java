package com.bytedanceos.tencent;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes3.dex */
public class SMTCodeName implements Parcelable {
    public static final Parcelable.Creator<SMTCodeName> CREATOR = null;
    private static final long serialVersionUID = 1;
    public String mCode;
    public String mName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SMTCodeName(String r1, String r2) {
        this.mCode = r1;
        this.mName = r2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.mCode);
        r1.writeString(this.mName);
    }

    public void readFromParcel(Parcel r2) {
        this.mCode = r2.readString();
        this.mName = r2.readString();
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    SMTCodeName(Parcel r1) {
        readFromParcel(r1);
    }
}
