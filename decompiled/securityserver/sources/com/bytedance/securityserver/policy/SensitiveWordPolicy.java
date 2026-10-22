package com.bytedance.securityserver.policy;

import androidx.annotation.Keep;
import com.bytedance.securityserver.robotspolicy.RobotsPolicyContract;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class SensitiveWordPolicy {

    @SerializedName("policies")
    public EncryptedPolicy[] policies;

    @SerializedName(RobotsPolicyContract.COL_VERSION)
    public String version;

    public SensitiveWordPolicy() {
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    public SensitiveWordPolicy(String r1, EncryptedPolicy[] r2) {
        this.version = r1;
        this.policies = r2;
    }
}
