package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableSparseBooleanArray extends SparseBooleanArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseBooleanArray> CREATOR = null;

    static {
        CREATOR = new AnonymousClass1();
    }

    public ParcelableSparseBooleanArray() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r4, int r5) {
        int[] r6 = new int[size()];
        boolean[] r0 = new boolean[size()];
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
        r4.writeBooleanArray(r0);
    }

    public ParcelableSparseBooleanArray(int r1) {
        super(r1);
    }

    public ParcelableSparseBooleanArray(@NonNull SparseBooleanArray r4) {
        super(r4.size());
        int r0 = 0;
    L4:
        if (r0 >= r4.size()) goto L6;
        put(r4.keyAt(r0), r4.valueAt(r0));
        r0 = r0 + 1;
        goto L4
    }
}
