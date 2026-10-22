package com.bytedance.apm.util;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class SpPair implements Parcelable {
    public static final Parcelable.Creator<SpPair> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2027f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f2028g;

    static class a implements Parcelable.Creator<SpPair> {
        a() {
        }

        public SpPair a(Parcel r1) {
            return new SpPair(r1);
        }

        public SpPair[] b(int r1) {
            return new SpPair[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SpPair createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SpPair[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    protected SpPair(Parcel r2) {
        this.f2027f = r2.readString();
        this.f2028g = r2.readValue(getClass().getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.f2027f);
        r1.writeValue(this.f2028g);
    }
}
