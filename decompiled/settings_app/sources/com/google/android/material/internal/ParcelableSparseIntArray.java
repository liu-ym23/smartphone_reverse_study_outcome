package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes3.dex */
public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = null;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelableSparseIntArray() {
    }

    public ParcelableSparseIntArray(int r1) {
        super(r1);
    }

    public ParcelableSparseIntArray(SparseIntArray r4) {
        int r0 = 0;
    L4:
        if (r0 >= r4.size()) goto L6;
        put(r4.keyAt(r0), r4.valueAt(r0));
        r0 = r0 + 1;
        goto L4
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        int[] r6 = new int[size()];
        int[] r0 = new int[size()];
        int r1 = 0;
    L4:
        if (r1 >= size()) goto L6;
        r6[r1] = keyAt(r1);
        r0[r1] = valueAt(r1);
        r1 = r1 + 1;
        goto L4
    L6:
        r4.writeInt(size());
        r4.writeIntArray(r6);
        r4.writeIntArray(r0);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
