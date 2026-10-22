package com.bytedance.securityserver.policy;

import com.bytedance.securityserver.robotspolicy.RobotsPolicyContract;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class RobotsPolicy {

    @SerializedName(alternate = {"ROBOTS_POLICY"}, value = "robots_policy")
    public RobotsPolicyData robotsPolicy;

    @SerializedName(RobotsPolicyContract.COL_VERSION)
    public String version;

    public RobotsPolicy() {
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    public RobotsPolicy(String r1, RobotsPolicyData r2) {
        this.version = r1;
        this.robotsPolicy = r2;
    }
}
