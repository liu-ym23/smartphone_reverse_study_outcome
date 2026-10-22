package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ChannelType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SocketState implements Parcelable {
    public static final Parcelable.Creator<SocketState> CREATOR = null;
    public int channelId;
    public int channelType;
    public int connectionState;
    public int connectionType;
    public String connectionUrl;
    public String error;
    public int errorCode;
    private boolean privateProtocolEnabled;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SocketState() {
    }

    public static SocketState fromJson(JSONObject r3) {
        SocketState r0 = new SocketState();
        r0.channelId = r3.optInt(WsConstants.KEY_CHANNEL_ID, Integer.MIN_VALUE);
        r0.connectionType = r3.optInt("type", -1);
        r0.connectionState = r3.optInt("state", -1);
        r0.connectionUrl = r3.optString("url", "");
        r0.channelType = r3.optInt(WsConstants.KEY_CHANNEL_TYPE);
        r0.error = r3.optString("error", "");
        r0.errorCode = r3.optInt("error_code");
        boolean r2 = false;
        if (r3.optInt(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 0) <= 0) goto L5;
        r2 = true;
    L5:
        r0.privateProtocolEnabled = r2;
        return r0;
    }

    public String toString() {
        return "SocketState{connectionType=" + this.connectionType + ", connectionState=" + this.connectionState + ", connectionUrl='" + this.connectionUrl + "', channelId=" + this.channelId + ", channelType=" + this.channelType + ", error='" + this.error + "', privateProtocol=" + this.privateProtocolEnabled + "'}";
    }

    public int getConnectionType() {
        return this.connectionType;
    }

    public void setConnectionType(int r1) {
        this.connectionType = r1;
    }

    public int getConnectionState() {
        return this.connectionState;
    }

    public void setConnectionState(int r1) {
        this.connectionState = r1;
    }

    public String getConnectionUrl() {
        return this.connectionUrl;
    }

    public void setConnectionUrl(String r1) {
        this.connectionUrl = r1;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public void setChannelId(int r1) {
        this.channelId = r1;
    }

    public boolean isPrivateProtocolEnabled() {
        return this.privateProtocolEnabled;
    }

    public JSONObject toJson() {
        JSONObject r0 = new JSONObject();
        r0.put(WsConstants.KEY_CHANNEL_ID, this.channelId);     // Catch: JSONException -> L9
        r0.put("type", this.connectionType);     // Catch: JSONException -> L9
        r0.put("state", this.connectionState);     // Catch: JSONException -> L9
        r0.put("url", this.connectionUrl);     // Catch: JSONException -> L9
        r0.put(WsConstants.KEY_CHANNEL_TYPE, this.channelType);     // Catch: JSONException -> L9
        r0.put("error", this.error);     // Catch: JSONException -> L9
        r0.put("error_code", this.errorCode);     // Catch: JSONException -> L9
        if (this.privateProtocolEnabled == false) goto L6;
        int r3 = 1;
    L7:
        r0.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, r3);     // Catch: JSONException -> L9
    L11:
        return r0;
    L6:
        r3 = 0;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int r1) {
        this.errorCode = r1;
    }

    public ChannelType getChannelType() {
        return ChannelType.of(this.channelType);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.connectionType);
        r1.writeInt(this.connectionState);
        r1.writeString(this.connectionUrl);
        r1.writeInt(this.channelId);
        r1.writeInt(this.channelType);
        r1.writeString(this.error);
        r1.writeInt(this.errorCode);
        r1.writeInt(this.privateProtocolEnabled ? 1 : 0);
    }

    protected SocketState(Parcel r2) {
        this.connectionType = r2.readInt();
        this.connectionState = r2.readInt();
        this.connectionUrl = r2.readString();
        this.channelId = r2.readInt();
        this.channelType = r2.readInt();
        this.error = r2.readString();
        this.errorCode = r2.readInt();
        if (r2.readInt() <= 0) goto L5;
        boolean r3 = true;
    L6:
        this.privateProtocolEnabled = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
