package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class WsApi implements Parcelable {
    public static final Parcelable.Creator<WsApi> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f3607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f3608g;

    static class a implements Parcelable.Creator<WsApi> {
        a() {
        }

        public WsApi a(Parcel r2) {
            WsApi r1 = new WsApi();
            r1.f3607f = r2.readInt();
            r1.f3608g = r2.readInt();
            return r1;
        }

        public WsApi[] b(int r1) {
            return new WsApi[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WsApi createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WsApi[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public WsApi() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.f3607f);
        r1.writeInt(this.f3608g);
    }
}
