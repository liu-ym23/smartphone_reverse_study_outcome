package com.bytedance.apm.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class SpPair implements Parcelable {
    public static final Parcelable.Creator<SpPair> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f1471g;

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
        this.f1470f = r2.readString();
        this.f1471g = r2.readValue(getClass().getClassLoader());
    }

    public SpPair(String r1, Object r2) {
        this.f1470f = r1;
        this.f1471g = r2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.f1470f);
        r1.writeValue(this.f1471g);
    }
}
