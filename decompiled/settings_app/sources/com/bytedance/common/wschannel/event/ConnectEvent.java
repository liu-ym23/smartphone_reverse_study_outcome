package com.bytedance.common.wschannel.event;

/* JADX INFO: loaded from: classes3.dex */
public class ConnectEvent {
    public final ConnectionState connectionState;
    public final int mChannelId;
    public final ChannelType mType;

    public ConnectEvent(ConnectionState r1, ChannelType r2, int r3) {
        this.connectionState = r1;
        this.mType = r2;
        this.mChannelId = r3;
    }

    public String toString() {
        return "ConnectEvent{mType=" + this.mType + ", connectionState=" + this.connectionState + ", mChannelId=" + this.mChannelId + '}';
    }
}
