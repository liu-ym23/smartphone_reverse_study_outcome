package com.bytedance.framwork.core.sdklib.model;

/* JADX INFO: loaded from: classes.dex */
public class LocalLog {
    public String aid;
    public long createTime;
    public String data;
    public long id;
    public String type;
    public String type2;

    public LocalLog() {
    }

    public static LocalLog newLocalLog(String r1) {
        return new LocalLog().setType(r1);
    }

    public LocalLog setAid(String r1) {
        this.aid = r1;
        return this;
    }

    public LocalLog setData(String r1) {
        this.data = r1;
        return this;
    }

    public LocalLog setId(long r1) {
        this.id = r1;
        return this;
    }

    public LocalLog setTimestamp(long r1) {
        this.createTime = r1;
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

    public String toString() {
        return "LocalLog{id=" + this.id + ", aid=" + this.aid + ", type='" + this.type + "', type2='" + this.type2 + "', data='" + this.data + "', createTime=" + this.createTime + '}';
    }

    public LocalLog(long r1, String r3) {
        this.id = r1;
        this.data = r3;
    }

    public LocalLog(long r1, String r3, String r4) {
        this.id = r1;
        this.aid = r3;
        this.data = r4;
    }

    public LocalLog(String r1, String r2, String r3, String r4, long r5) {
        this.aid = r1;
        this.type = r2;
        this.type2 = r3;
        this.data = r4;
        this.createTime = r5;
    }
}
