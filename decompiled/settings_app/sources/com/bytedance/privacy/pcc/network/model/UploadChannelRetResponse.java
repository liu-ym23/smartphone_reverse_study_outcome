package com.bytedance.privacy.pcc.network.model;

import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.constant.ReportProtocal;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/* JADX INFO: loaded from: classes3.dex */
public class UploadChannelRetResponse {
    private final String logId;

    private UploadChannelRetResponse(String r1) {
        this.logId = r1;
    }

    public String getLogId() {
        return this.logId;
    }

    public static UploadChannelRetResponse parse(String r3) throws Exception {
        JsonObject r4 = JsonParser.parseString(r3).getAsJsonObject();
        int r0 = r4.get(AlogMonitor.ALOG_RESULT_CODE).getAsInt();
        if (r0 != 0) goto L11;
        if (r4.has(ReportProtocal.KEY_LOG_ID) == false) goto L7;
        String r5 = r4.get(ReportProtocal.KEY_LOG_ID).getAsString();
    L9:
        return new UploadChannelRetResponse(r5);
    L7:
        r5 = "";
        goto L9
    L11:
        throw new Exception("unexpected server code=" + r0);
    }
}
