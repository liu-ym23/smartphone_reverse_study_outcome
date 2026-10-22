package com.bytedance.apm.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class SpPair implements Parcelable {
    public static final Parcelable.Creator<SpPair> CREATOR = null;
    public String mKey;
    public Object mValue;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SpPair(String r1, Object r2) {
        this.mKey = r1;
        this.mValue = r2;
    }

    protected SpPair(Parcel r2) {
        this.mKey = r2.readString();
        this.mValue = r2.readValue(getClass().getClassLoader());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.mKey);
        r1.writeValue(this.mValue);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
