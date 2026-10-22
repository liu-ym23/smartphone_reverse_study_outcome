package com.bytedance.apm.entity;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LocalLog {
    public long createTime;
    public JSONObject data;
    public long id;
    public boolean isSampled;
    public String type;
    public String type2;
    public long versionId;

    public LocalLog() {
    }

    public LocalLog(long r1, String r3, long r4, JSONObject r6) {
        this.id = r1;
        this.type = r3;
        this.data = r6;
        this.versionId = r4;
    }

    public LocalLog(long r1, String r3, long r4, String r6) {
        this.id = r1;
        this.type = r3;
        this.data = new JSONObject(r6);     // Catch: Exception -> L6
    L4:
        this.versionId = r4;
    }

    public LocalLog setId(long r1) {
        this.id = r1;
        return this;
    }

    public LocalLog setType(String r1) {
        this.type = r1;
        return this;
    }

    public LocalLog setType2(String r1) {
        this.type2 = r1;
        return this;
    }

    public LocalLog setData(JSONObject r1) {
        this.data = r1;
        return this;
    }

    public LocalLog setIsSampled(boolean r1) {
        this.isSampled = r1;
        return this;
    }

    public LocalLog setVersionId(long r1) {
        this.versionId = r1;
        return this;
    }

    public LocalLog setTimestamp(long r1) {
        this.createTime = r1;
        return this;
    }

    public static LocalLog newLocalLog(String r1) {
        r1.hashCode();
        if (r1.equals("api_all") == true) goto L7;
        return new LocalLog().setType(r1);
    L7:
        return new ApiAllLocalLog().setType(r1);
    }

    public String toString() {
        return "LocalLog{id=" + this.id + ", type='" + this.type + "', type2='" + this.type2 + "', data='" + this.data + "', versionId=" + this.versionId + ", createTime=" + this.createTime + ", isSampled=" + this.isSampled + '}';
    }
}
