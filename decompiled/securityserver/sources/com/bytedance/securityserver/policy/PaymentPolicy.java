package com.bytedance.securityserver.policy;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class PaymentPolicy {

    @SerializedName(alternate = {"FREE_PAYMENT"}, value = "free_payment")
    public String[] free_payment;

    @SerializedName(alternate = {"MAYBE_FREE_PAYMENT"}, value = "maybe_free_payment")
    public String[] maybe_free_payment;

    public PaymentPolicy() {
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    public PaymentPolicy(String[] r1, String[] r2) {
        this.free_payment = r1;
        this.maybe_free_payment = r2;
    }
}
