package com.bytedance.common.wschannel.model;

import a.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class ServiceConnectEvent implements Parcelable {
    public static final Parcelable.Creator<ServiceConnectEvent> CREATOR = null;
    private final int mChannelId;
    private final boolean mConnected;
    private final String mLogInfo;
    private final int mServiceId;

    static {
        CREATOR = new AnonymousClass1();
    }

    public ServiceConnectEvent(int r1, int r2, boolean r3, String r4) {
        this.mChannelId = r1;
        this.mServiceId = r2;
        this.mConnected = r3;
        this.mLogInfo = r4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getChannelId() {
        return this.mChannelId;
    }

    @Nullable
    public String getLogInfo() {
        return this.mLogInfo;
    }

    public int getServiceId() {
        return this.mServiceId;
    }

    public boolean isServiceConnected() {
        return this.mConnected;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("ServiceConnectEvent{mChannelId=");
        r0.append(this.mChannelId);
        r0.append(", mServiceId=");
        r0.append(this.mServiceId);
        r0.append(", mConnected=");
        r0.append(this.mConnected);
        r0.append(", mLogInfo='");
        return a.o(r0, this.mLogInfo, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.mChannelId);
        r1.writeInt(this.mServiceId);
        r1.writeByte(this.mConnected ? 1 : 0);
        r1.writeString(this.mLogInfo);
    }
}
