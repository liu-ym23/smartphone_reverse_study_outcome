package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class WsApi implements Parcelable {
    public static final Parcelable.Creator<WsApi> CREATOR = null;
    int method;
    int service;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WsApi() {
    }

    public int getService() {
        return this.service;
    }

    public void setService(int r1) {
        this.service = r1;
    }

    public int getMethod() {
        return this.method;
    }

    public void setMethod(int r1) {
        this.method = r1;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject r0 = new JSONObject();
        r0.put("service", this.service);
        r0.put("method", this.method);
        return r0;
    }

    public void parseFromJson(JSONObject r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.service = r2.optInt("service");
        this.method = r2.optInt("method");
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.service);
        r1.writeInt(this.method);
    }
}
