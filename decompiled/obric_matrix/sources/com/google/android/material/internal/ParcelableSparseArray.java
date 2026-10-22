package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseArray> CREATOR = null;

    static {
        CREATOR = new AnonymousClass1();
    }

    public ParcelableSparseArray() {
    }

    public ParcelableSparseArray(@NonNull Parcel r5, @Nullable ClassLoader r6) {
        int r0 = r5.readInt();
        int[] r1 = new int[r0];
        r5.readIntArray(r1);
        Parcelable[] r7 = r5.readParcelableArray(r6);
        int r8 = 0;
    L3:
        if (r8 >= r0) goto L5;
        put(r1[r8], r7[r8]);
        r8 = r8 + 1;
        goto L3
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r6, int r7) {
        int r0 = size();
        int[] r1 = new int[r0];
        Parcelable[] r2 = new Parcelable[r0];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = keyAt(r3);
        r2[r3] = valueAt(r3);
        r3 = r3 + 1;
        goto L3
    L5:
        r6.writeInt(r0);
        r6.writeIntArray(r1);
        r6.writeParcelableArray(r2, r7);
    }
}
