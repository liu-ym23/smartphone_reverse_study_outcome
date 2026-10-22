package com.slardaros.client;

import android.os.Parcel;
import android.os.Parcelable;
import obric.bluetooth.SmartBluetoothBinderClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class AppProfile implements Parcelable {
    public static final Parcelable.Creator<AppProfile> CREATOR = null;
    public String filePath;
    public boolean isQuery;
    public String packageName;
    public String type;
    public String versionCode;
    public String versionName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AppProfile(String r1, String r2, String r3, String r4, String r5, boolean r6) {
        this.packageName = r1;
        this.versionName = r2;
        this.versionCode = r3;
        this.filePath = r4;
        this.type = r5;
        this.isQuery = r6;
    }

    public AppProfile(Parcel r2) {
        this.packageName = r2.readString();
        this.versionName = r2.readString();
        this.versionCode = r2.readString();
        this.filePath = r2.readString();
        this.type = r2.readString();
        if (r2.readByte() == 0) goto L5;
        boolean r3 = true;
    L6:
        this.isQuery = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String r1) {
        this.packageName = r1;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setVersionName(String r1) {
        this.versionName = r1;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public void setVersionCode(String r1) {
        this.versionCode = r1;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String r1) {
        this.filePath = r1;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String r1) {
        this.type = r1;
    }

    public boolean isQuery() {
        return this.isQuery;
    }

    public void setQuery(boolean r1) {
        this.isQuery = r1;
    }

    public String toString() {
        return "AppProfile{packageName='" + this.packageName + "', versionName='" + this.versionName + "', versionCode='" + this.versionCode + "', filePath='" + this.filePath + "', type='" + this.type + "', isQuery=" + this.isQuery + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.packageName);
        r1.writeString(this.versionName);
        r1.writeString(this.versionCode);
        r1.writeString(this.filePath);
        r1.writeString(this.type);
        r1.writeByte(this.isQuery ? 1 : 0);
    }

    public JSONObject toJson(int r3) {
        JSONObject r0 = new JSONObject();
        r0.put(SmartBluetoothBinderClient.KEY_PRODUCT_ID, r3);     // Catch: JSONException -> L5
        r0.put("package_name", this.packageName);     // Catch: JSONException -> L5
        r0.put("version_name", this.versionName);     // Catch: JSONException -> L5
        r0.put("version_code", this.versionCode);     // Catch: JSONException -> L5
        r0.put("profile_type", this.type);     // Catch: JSONException -> L5
    L7:
        return r0;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
