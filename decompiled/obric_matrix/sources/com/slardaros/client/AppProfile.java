package com.slardaros.client;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class AppProfile implements Parcelable {
    public static final Parcelable.Creator<AppProfile> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f11650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f11651g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f11652h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f11653i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f11654j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f11655k;

    class a implements Parcelable.Creator<AppProfile> {
        a() {
        }

        public AppProfile a(Parcel r1) {
            return new AppProfile(r1);
        }

        public AppProfile[] b(int r1) {
            return new AppProfile[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppProfile createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppProfile[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public AppProfile(Parcel r2) {
        this.f11650f = r2.readString();
        this.f11651g = r2.readString();
        this.f11652h = r2.readString();
        this.f11653i = r2.readString();
        this.f11654j = r2.readString();
        if (r2.readByte() == 0) goto L5;
        boolean r3 = true;
    L6:
        this.f11655k = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "AppProfile{packageName='" + this.f11650f + "', versionName='" + this.f11651g + "', versionCode='" + this.f11652h + "', filePath='" + this.f11653i + "', type='" + this.f11654j + "', isQuery=" + this.f11655k + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.f11650f);
        r1.writeString(this.f11651g);
        r1.writeString(this.f11652h);
        r1.writeString(this.f11653i);
        r1.writeString(this.f11654j);
        r1.writeByte(this.f11655k ? 1 : 0);
    }
}
