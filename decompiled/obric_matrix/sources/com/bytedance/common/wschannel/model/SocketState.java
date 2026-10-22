package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SocketState implements Parcelable {
    public static final Parcelable.Creator<SocketState> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f3583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3584i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3585j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f3586k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f3587l;
    public int m;

    static class a implements Parcelable.Creator<SocketState> {
        a() {
        }

        public SocketState a(Parcel r1) {
            return new SocketState(r1);
        }

        public SocketState[] b(int r1) {
            return new SocketState[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SocketState createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SocketState[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public SocketState() {
    }

    protected SocketState(Parcel r2) {
        this.f3581f = r2.readInt();
        this.f3582g = r2.readInt();
        this.f3583h = r2.readString();
        this.f3584i = r2.readInt();
        this.f3585j = r2.readInt();
        this.f3586k = r2.readString();
        this.m = r2.readInt();
        if (r2.readInt() <= 0) goto L5;
        boolean r3 = true;
    L6:
        this.f3587l = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    public static SocketState b(JSONObject r3) {
        SocketState r0 = new SocketState();
        r0.f3584i = r3.optInt(WsConstants.KEY_CHANNEL_ID, Integer.MIN_VALUE);
        r0.f3581f = r3.optInt(WsConstants.KEY_CONNECTION_TYPE, -1);
        r0.f3582g = r3.optInt(WsConstants.KEY_CONNECTION_STATE, -1);
        r0.f3583h = r3.optString(WsConstants.KEY_CONNECTION_URL, "");
        r0.f3585j = r3.optInt(WsConstants.KEY_CHANNEL_TYPE);
        r0.f3586k = r3.optString(WsConstants.KEY_CONNECTION_ERROR, "");
        r0.m = r3.optInt(WsConstants.ERROR_CODE);
        boolean r2 = false;
        if (r3.optInt(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 0) <= 0) goto L5;
        r2 = true;
    L5:
        r0.f3587l = r2;
        return r0;
    }

    public int c() {
        return this.f3584i;
    }

    public com.bytedance.common.wschannel.r.a d() {
        return com.bytedance.common.wschannel.r.a.b(this.f3585j);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f3582g;
    }

    public int f() {
        return this.m;
    }

    public boolean g() {
        return this.f3587l;
    }

    public JSONObject m() {
        JSONObject r0 = new JSONObject();
        r0.put(WsConstants.KEY_CHANNEL_ID, this.f3584i);     // Catch: JSONException -> L9
        r0.put(WsConstants.KEY_CONNECTION_TYPE, this.f3581f);     // Catch: JSONException -> L9
        r0.put(WsConstants.KEY_CONNECTION_STATE, this.f3582g);     // Catch: JSONException -> L9
        r0.put(WsConstants.KEY_CONNECTION_URL, this.f3583h);     // Catch: JSONException -> L9
        r0.put(WsConstants.KEY_CHANNEL_TYPE, this.f3585j);     // Catch: JSONException -> L9
        r0.put(WsConstants.KEY_CONNECTION_ERROR, this.f3586k);     // Catch: JSONException -> L9
        r0.put(WsConstants.ERROR_CODE, this.m);     // Catch: JSONException -> L9
        if (this.f3587l == false) goto L6;
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

    public String toString() {
        return "SocketState{connectionType=" + this.f3581f + ", connectionState=" + this.f3582g + ", connectionUrl='" + this.f3583h + "', channelId=" + this.f3584i + ", channelType=" + this.f3585j + ", error='" + this.f3586k + "', privateProtocol=" + this.f3587l + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.f3581f);
        r1.writeInt(this.f3582g);
        r1.writeString(this.f3583h);
        r1.writeInt(this.f3584i);
        r1.writeInt(this.f3585j);
        r1.writeString(this.f3586k);
        r1.writeInt(this.m);
        r1.writeInt(this.f3587l ? 1 : 0);
    }
}
