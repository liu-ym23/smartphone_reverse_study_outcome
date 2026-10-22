package com.bytedance.securityserver.policy;

import androidx.annotation.Keep;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.securityserver.robotspolicy.RobotsPolicyContract;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class EncryptedPolicy {

    @SerializedName("encrypt_type")
    public String encrypt_type;

    @SerializedName("name")
    public String name;

    @SerializedName(WsConstants.KEY_PLATFORM)
    public String platform;

    @SerializedName("public_key")
    public String public_key;

    @SerializedName(RobotsPolicyContract.COL_VERSION)
    public String version;

    @SerializedName("words_cipher")
    public String words_cipher;

    @SerializedName("words_key")
    public String words_key;

    public EncryptedPolicy() {
    }

    public String toString() {
        return new Gson().toJson(this);
    }

    public EncryptedPolicy(String r1, String r2, String r3, String r4, String r5, String r6, String r7) {
        this.version = r1;
        this.name = r2;
        this.encrypt_type = r3;
        this.platform = r4;
        this.public_key = r5;
        this.words_key = r6;
        this.words_cipher = r7;
    }
}
