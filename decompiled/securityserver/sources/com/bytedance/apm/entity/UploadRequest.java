package com.bytedance.apm.entity;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class UploadRequest {
    private String aid;
    private List<String> alogFiles;
    private JSONObject commonParams;
    private String did;
    private String processName;

    public UploadRequest() {
    }

    public String getAid() {
        return this.aid;
    }

    public List<String> getAlogFiles() {
        return this.alogFiles;
    }

    public JSONObject getCommonParams() {
        return this.commonParams;
    }

    public String getDid() {
        return this.did;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setAid(String r1) {
        this.aid = r1;
    }

    public void setAlogFiles(List<String> r1) {
        this.alogFiles = r1;
    }

    public void setCommonParams(JSONObject r1) {
        this.commonParams = r1;
    }

    public void setDid(String r1) {
        this.did = r1;
    }

    public void setProcessName(String r1) {
        this.processName = r1;
    }
}
