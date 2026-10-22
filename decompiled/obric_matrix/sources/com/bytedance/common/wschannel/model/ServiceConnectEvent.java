package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ServiceConnectEvent implements Parcelable {
    public static final Parcelable.Creator<ServiceConnectEvent> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f3575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f3576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f3577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f3578i;

    static class a implements Parcelable.Creator<ServiceConnectEvent> {
        a() {
        }

        public ServiceConnectEvent a(Parcel r4) {
            int r3 = r4.readInt();
            int r0 = r4.readInt();
            if (r4.readByte() == 0) goto L5;
            boolean r1 = true;
        L7:
            return new ServiceConnectEvent(r3, r0, r1, r4.readString());
        L5:
            r1 = false;
            goto L7
        }

        public ServiceConnectEvent[] b(int r1) {
            return new ServiceConnectEvent[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ServiceConnectEvent createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ServiceConnectEvent[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public ServiceConnectEvent(int r1, int r2, boolean r3, String r4) {
        this.f3575f = r1;
        this.f3576g = r2;
        this.f3577h = r3;
        this.f3578i = r4;
    }

    public int b() {
        return this.f3576g;
    }

    public int c() {
        return this.f3575f;
    }

    public boolean d() {
        return this.f3577h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ServiceConnectEvent{mChannelId=" + this.f3575f + ", mServiceId=" + this.f3576g + ", mConnected=" + this.f3577h + ", mLogInfo='" + this.f3578i + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.f3575f);
        r1.writeInt(this.f3576g);
        r1.writeByte(this.f3577h ? 1 : 0);
        r1.writeString(this.f3578i);
    }
}
