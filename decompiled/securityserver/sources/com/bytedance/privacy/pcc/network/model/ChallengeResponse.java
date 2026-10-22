package com.bytedance.privacy.pcc.network.model;

import a.a;
import android.util.Base64;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.privacy.utils.LogUtils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class ChallengeResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17a;
    public final int b;

    public ChallengeResponse(String r1, int r2) {
        this.f17a = r1;
        this.b = r2;
    }

    public static ChallengeResponse a(String r4) {
        JsonObject r5 = JsonParser.parseString(r4).getAsJsonObject();
        int r0 = r5.get("code").getAsInt();
        if (r0 != 0) goto L11;
        JsonObject r6 = JsonParser.parseString(new String(Base64.decode(r5.getAsJsonObject("data").get(WsConstants.KEY_PAYLOAD).getAsString(), 8), StandardCharsets.UTF_8)).getAsJsonObject();
        LogUtils.d("ChallengeResponse", "ChallengeResponse payload JSON: " + r6);
        String r1 = r6.get("nonce").getAsString();
        if (r6.has("type") == false) goto L7;
        int r7 = r6.get("type").getAsInt();
    L8:
        LogUtils.d("ChallengeResponse", "ChallengeResponse parsed: nonce=" + r1 + ", type=" + r7);
        return new ChallengeResponse(r1, r7);
    L7:
        r7 = 1;
        goto L8
    L11:
        throw new Exception(a.e(r0, "unexpected server code="));
    }
}
