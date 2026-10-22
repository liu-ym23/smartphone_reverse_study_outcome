package com.bytedance.privacy.pcc.network.model;

import a.a;
import com.bytedance.apm.constant.ReportProtocal;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/* JADX INFO: loaded from: classes.dex */
public class UploadChannelRetResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22a;

    public UploadChannelRetResponse(String r1) {
        this.f22a = r1;
    }

    public static UploadChannelRetResponse a(String r2) {
        JsonObject r3 = JsonParser.parseString(r2).getAsJsonObject();
        int r0 = r3.get("code").getAsInt();
        if (r0 != 0) goto L11;
        if (r3.has(ReportProtocal.KEY_LOG_ID) == false) goto L7;
        String r4 = r3.get(ReportProtocal.KEY_LOG_ID).getAsString();
    L9:
        return new UploadChannelRetResponse(r4);
    L7:
        r4 = "";
        goto L9
    L11:
        throw new Exception(a.e(r0, "unexpected server code="));
    }
}
