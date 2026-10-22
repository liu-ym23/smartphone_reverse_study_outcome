package com.obric.android.alog;

/* JADX INFO: loaded from: classes4.dex */
public class MsgInfo {
    public int level;
    public String msg;
    public String tag;

    public MsgInfo(int r1, String r2, String r3) {
        this.level = r1;
        this.tag = r2;
        this.msg = r3;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int r1) {
        this.level = r1;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String r1) {
        this.tag = r1;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String r1) {
        this.msg = r1;
    }
}
