package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class IntegerParcelable implements Parcelable {
    public static final Parcelable.Creator<IntegerParcelable> CREATOR = null;
    private final int mData;

    static {
        CREATOR = new AnonymousClass1();
    }

    public IntegerParcelable(int r1) {
        this.mData = r1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getData() {
        return this.mData;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.mData);
    }

    public IntegerParcelable(Parcel r1) {
        this.mData = r1.readInt();
    }
}
