package com.bytedance.badger.f;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class g implements Parcelable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Parcelable.Creator f2562d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2563f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f2564g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2565h;

    static {
        f2562d = new f();
    }

    public g() {
    }

    public g(Parcel r2) {
        this.f2563f = r2.readInt();
        this.f2564g = r2.createByteArray();
        this.f2565h = r2.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.f2563f);
        r1.writeByteArray(this.f2564g);
        r1.writeInt(this.f2565h);
    }
}
