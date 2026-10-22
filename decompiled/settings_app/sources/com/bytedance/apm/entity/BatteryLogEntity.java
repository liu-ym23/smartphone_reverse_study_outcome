package com.bytedance.apm.entity;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryLogEntity {
    private long accumulation;
    private boolean deleteFlag;
    private boolean front;
    private long id;
    private boolean mainProcess;
    private String processName;
    private String scene;
    private String source;
    private String startUuid;
    private boolean status;
    public long time;
    public String type;
    private long versionId;

    public BatteryLogEntity(boolean r1, long r2, String r4, boolean r5, long r6, String r8) {
        this.front = r1;
        this.time = r2;
        this.type = r4;
        this.status = r5;
        this.accumulation = r6;
        this.scene = r8;
    }

    public BatteryLogEntity(boolean r1, long r2, String r4, boolean r5, long r6, String r8, String r9) {
        this.front = r1;
        this.time = r2;
        this.type = r4;
        this.status = r5;
        this.accumulation = r6;
        this.scene = r8;
        this.source = r9;
    }

    public void setScene(String r1) {
        this.scene = r1;
    }

    public boolean isFront() {
        return this.front;
    }

    public boolean isBack() {
        return !this.front;
    }

    public boolean isOn() {
        return this.status;
    }

    public boolean isOff() {
        return !this.status;
    }

    public long getAccumulation() {
        return this.accumulation;
    }

    public long getTime() {
        return this.time;
    }

    public String getType() {
        return this.type;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean r1) {
        this.status = r1;
    }

    public String getScene() {
        return this.scene;
    }

    public String getSource() {
        return this.source;
    }

    public void setVersionId(long r1) {
        this.versionId = r1;
    }

    public long getVersionId() {
        return this.versionId;
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setProcessName(String r1) {
        this.processName = r1;
    }

    public boolean isMainProcess() {
        return this.mainProcess;
    }

    public void setMainProcess(boolean r1) {
        this.mainProcess = r1;
    }

    public String getStartUuid() {
        return this.startUuid;
    }

    public void setStartUuid(String r1) {
        this.startUuid = r1;
    }

    public boolean isDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteFlag(boolean r1) {
        this.deleteFlag = r1;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long r1) {
        this.id = r1;
    }

    public void setAccumulation(long r1) {
        this.accumulation = r1;
    }

    public String toString() {
        return "BatteryLogEntity{id=" + this.id + ", front=" + this.front + ", time=" + this.time + ", type='" + this.type + "', status=" + this.status + ", scene='" + this.scene + "', accumulation=" + this.accumulation + ", source='" + this.source + "', versionId=" + this.versionId + ", processName='" + this.processName + "', mainProcess=" + this.mainProcess + ", startUuid='" + this.startUuid + "', deleteFlag=" + this.deleteFlag + '}';
    }

    public JSONObject simpleJson() throws JSONException {
        JSONObject r0 = new JSONObject();
        r0.put("front", this.front);
        r0.put("time", this.time);
        r0.put("type", this.type);
        r0.put("scene", this.scene);
        r0.put("processName", this.processName);
        return r0;
    }
}
