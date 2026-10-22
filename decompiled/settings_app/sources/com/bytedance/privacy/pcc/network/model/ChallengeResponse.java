package com.bytedance.privacy.pcc.network.model;

import android.util.Base64;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.privacy.utils.LogUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public class ChallengeResponse {
    private static final String TAG = "ChallengeResponse";
    private final String nonce;
    private final int type;

    static {
    }

    private ChallengeResponse(String r1, int r2) {
        this.nonce = r1;
        this.type = r2;
    }

    public String getNonce() {
        return this.nonce;
    }

    public int getType() {
        return this.type;
    }

    public static ChallengeResponse parse(String r3) throws Exception {
        JsonObject r4 = JsonParser.parseString(r3).getAsJsonObject();
        int r0 = r4.get(AlogMonitor.ALOG_RESULT_CODE).getAsInt();
        if (r0 != 0) goto L11;
        JsonObject r5 = JsonParser.parseString(new String(Base64.decode(r4.getAsJsonObject("data").get("payload").getAsString(), 8), StandardCharsets.UTF_8)).getAsJsonObject();
        String r1 = r5.get("nonce").getAsString();
        if (r5.has("type") == false) goto L7;
        int r6 = r5.get("type").getAsInt();
    L8:
        LogUtils.i(TAG, "ChallengeResponse parsed");
        return new ChallengeResponse(r1, r6);
    L7:
        r6 = 1;
        goto L8
    L11:
        throw new Exception("unexpected server code=" + r0);
    }
}
