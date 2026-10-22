package com.bytedance.privacy.pcc.network.model;

import android.util.Base64;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class ChallengeResponse {
    private final String nonce;

    private ChallengeResponse(String r1) {
        this.nonce = r1;
    }

    public String getNonce() {
        return this.nonce;
    }

    public static ChallengeResponse parse(String r3) throws Exception {
        JsonObject r4 = JsonParser.parseString(r3).getAsJsonObject();
        int r0 = r4.get(AlogMonitor.ALOG_RESULT_CODE).getAsInt();
        if (r0 != 0) goto L7;
        return new ChallengeResponse(JsonParser.parseString(new String(Base64.decode(r4.getAsJsonObject("data").get(WsConstants.KEY_PAYLOAD).getAsString(), 8), StandardCharsets.UTF_8)).getAsJsonObject().get("nonce").getAsString());
    L7:
        throw new Exception("unexpected server code=" + r0);
    }
}
