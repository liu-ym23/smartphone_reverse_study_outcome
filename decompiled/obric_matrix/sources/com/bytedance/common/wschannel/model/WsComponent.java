package com.bytedance.common.wschannel.model;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WsComponent implements Parcelable {
    public static final Parcelable.Creator<WsComponent> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ComponentName f3628f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    List<WsApi> f3629g;

    static class a implements Parcelable.Creator<WsComponent> {
        a() {
        }

        public WsComponent a(Parcel r2) {
            WsComponent r1 = new WsComponent();
            r1.f3628f = (ComponentName) r2.readParcelable(a.class.getClassLoader());
            r1.f3629g = r2.createTypedArrayList(WsApi.CREATOR);
            return r1;
        }

        public WsComponent[] b(int r1) {
            return new WsComponent[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WsComponent createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WsComponent[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public WsComponent() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeParcelable(this.f3628f, r3);
        r2.writeTypedList(this.f3629g);
    }
}
