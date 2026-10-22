package com.bytedance.apm.entity;

import com.bytedance.framwork.core.sdklib.DBHelper;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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

    public long getAccumulation() {
        return this.accumulation;
    }

    public long getId() {
        return this.id;
    }

    public String getProcessName() {
        return this.processName;
    }

    public String getScene() {
        return this.scene;
    }

    public String getSource() {
        return this.source;
    }

    public String getStartUuid() {
        return this.startUuid;
    }

    public long getTime() {
        return this.time;
    }

    public String getType() {
        return this.type;
    }

    public long getVersionId() {
        return this.versionId;
    }

    public boolean isBack() {
        return !this.front;
    }

    public boolean isDeleteFlag() {
        return this.deleteFlag;
    }

    public boolean isFront() {
        return this.front;
    }

    public boolean isMainProcess() {
        return this.mainProcess;
    }

    public boolean isOff() {
        return !this.status;
    }

    public boolean isOn() {
        return this.status;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setAccumulation(long r1) {
        this.accumulation = r1;
    }

    public void setDeleteFlag(boolean r1) {
        this.deleteFlag = r1;
    }

    public void setId(long r1) {
        this.id = r1;
    }

    public void setMainProcess(boolean r1) {
        this.mainProcess = r1;
    }

    public void setProcessName(String r1) {
        this.processName = r1;
    }

    public void setScene(String r1) {
        this.scene = r1;
    }

    public void setStartUuid(String r1) {
        this.startUuid = r1;
    }

    public void setStatus(boolean r1) {
        this.status = r1;
    }

    public void setVersionId(long r1) {
        this.versionId = r1;
    }

    public JSONObject simpleJson() {
        JSONObject r0 = new JSONObject();
        r0.put("front", this.front);
        r0.put(DBHelper.COL_TIME, this.time);
        r0.put("type", this.type);
        r0.put("scene", this.scene);
        r0.put("processName", this.processName);
        return r0;
    }

    public String toString() {
        return "BatteryLogEntity{id=" + this.id + ", front=" + this.front + ", time=" + this.time + ", type='" + this.type + "', status=" + this.status + ", scene='" + this.scene + "', accumulation=" + this.accumulation + ", source='" + this.source + "', versionId=" + this.versionId + ", processName='" + this.processName + "', mainProcess=" + this.mainProcess + ", startUuid='" + this.startUuid + "', deleteFlag=" + this.deleteFlag + '}';
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
}
