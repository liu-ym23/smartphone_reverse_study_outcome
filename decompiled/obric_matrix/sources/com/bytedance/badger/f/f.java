package com.bytedance.badger.f;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
final class f implements Parcelable.Creator {
    f() {
    }

    @Override // android.os.Parcelable.Creator
    public Object createFromParcel(Parcel r1) {
        return new g(r1);
    }

    @Override // android.os.Parcelable.Creator
    public Object[] newArray(int r1) {
        return new g[r1];
    }
}
