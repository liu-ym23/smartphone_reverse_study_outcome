package com.bytedance.securityserver.policy;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class RobotsPolicyData {

    @SerializedName(alternate = {"ENABLED_BRANDS"}, value = "enabled_brands")
    public String[] enabledBrands;

    @SerializedName(alternate = {"ENABLED_DEVICES"}, value = "enabled_devices")
    public String[] enabledDevices;

    public RobotsPolicyData() {
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    public RobotsPolicyData(String[] r1, String[] r2) {
        this.enabledBrands = r1;
        this.enabledDevices = r2;
    }
}
