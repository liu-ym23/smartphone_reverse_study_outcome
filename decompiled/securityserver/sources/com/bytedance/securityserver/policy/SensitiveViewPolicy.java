package com.bytedance.securityserver.policy;

import androidx.annotation.Keep;
import com.bytedance.securityserver.robotspolicy.RobotsPolicyContract;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class SensitiveViewPolicy {

    @SerializedName(alternate = {"sensitive_view", "PAYMENT"}, value = "payment")
    public PaymentPolicy payment;

    @SerializedName(RobotsPolicyContract.COL_VERSION)
    public String version;

    public SensitiveViewPolicy() {
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    public SensitiveViewPolicy(String r1, PaymentPolicy r2) {
        this.version = r1;
        this.payment = r2;
    }
}
