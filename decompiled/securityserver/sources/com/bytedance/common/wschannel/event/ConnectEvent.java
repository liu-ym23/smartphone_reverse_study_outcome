package com.bytedance.common.wschannel.event;

import a.a;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class ConnectEvent {
    public final ConnectionState connectionState;
    public final int errorCode;
    public final int mChannelId;
    public final ChannelType mType;

    public ConnectEvent(@NonNull ConnectionState r1, ChannelType r2, int r3, int r4) {
        this.connectionState = r1;
        this.mType = r2;
        this.mChannelId = r3;
        this.errorCode = r4;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("ConnectEvent{mType=");
        r0.append(this.mType);
        r0.append(", connectionState=");
        r0.append(this.connectionState);
        r0.append(", mChannelId=");
        r0.append(this.mChannelId);
        r0.append(", errorCode=");
        return a.l(r0, this.errorCode, '}');
    }
}
