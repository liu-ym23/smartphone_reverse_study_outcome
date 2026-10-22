package com.bytedance.bdlocation.entity.bpea;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BPEACertCheckResult {
    private int code;
    private String msg;
    private JSONObject params;

    public BPEACertCheckResult() {
    }

    @Nullable
    public int getCode() {
        return this.code;
    }

    @Nullable
    public String getMsg() {
        return this.msg;
    }

    @Nullable
    public JSONObject getParams() {
        return this.params;
    }

    public void setCode(int r1) {
        this.code = r1;
    }

    public void setMsg(String r1) {
        this.msg = r1;
    }

    public void setParams(JSONObject r1) {
        this.params = r1;
    }
}
