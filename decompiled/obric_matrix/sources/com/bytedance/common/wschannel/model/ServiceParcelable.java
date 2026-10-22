package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ServiceParcelable implements Parcelable {
    public static final Parcelable.Creator<ServiceParcelable> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f3579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f3580g;

    static class a implements Parcelable.Creator<ServiceParcelable> {
        a() {
        }

        public ServiceParcelable a(Parcel r2) {
            return new ServiceParcelable(r2.readInt(), r2.readInt());
        }

        public ServiceParcelable[] b(int r1) {
            return new ServiceParcelable[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ServiceParcelable createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ServiceParcelable[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public ServiceParcelable(int r1, int r2) {
        this.f3579f = r1;
        this.f3580g = r2;
    }

    public int b() {
        return this.f3580g;
    }

    public int c() {
        return this.f3579f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.f3579f);
        r1.writeInt(this.f3580g);
    }
}
