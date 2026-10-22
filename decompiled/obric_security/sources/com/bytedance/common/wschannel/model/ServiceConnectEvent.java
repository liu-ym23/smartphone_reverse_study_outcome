package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ServiceConnectEvent implements Parcelable {
    public static final Parcelable.Creator<ServiceConnectEvent> CREATOR = null;
    private final int mChannelId;
    private final boolean mConnected;
    private final String mLogInfo;
    private final int mServiceId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ServiceConnectEvent(int r1, int r2, boolean r3, String r4) {
        this.mChannelId = r1;
        this.mServiceId = r2;
        this.mConnected = r3;
        this.mLogInfo = r4;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int getChannelId() {
        return this.mChannelId;
    }

    public int getServiceId() {
        return this.mServiceId;
    }

    public boolean isServiceConnected() {
        return this.mConnected;
    }

    public String getLogInfo() {
        return this.mLogInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.mChannelId);
        r1.writeInt(this.mServiceId);
        r1.writeByte(this.mConnected ? 1 : 0);
        r1.writeString(this.mLogInfo);
    }

    public String toString() {
        return "ServiceConnectEvent{mChannelId=" + this.mChannelId + ", mServiceId=" + this.mServiceId + ", mConnected=" + this.mConnected + ", mLogInfo='" + this.mLogInfo + "'}";
    }
}
