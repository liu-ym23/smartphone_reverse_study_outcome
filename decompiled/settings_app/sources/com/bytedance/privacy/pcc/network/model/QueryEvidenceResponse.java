package com.bytedance.privacy.pcc.network.model;

import android.util.Base64;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.constant.ReportProtocal;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class QueryEvidenceResponse {
    private final String logId;
    private final Payload payload;
    private final String payloadBase64;
    private final String responseId;
    private final String signature;

    public static class Payload {

        @SerializedName("service_pod_evidence_info")
        private List<ServicePodEvidenceInfo> servicePodEvidenceInfo;

        public Payload() {
        }

        public List<ServicePodEvidenceInfo> getServicePodEvidenceInfo() {
            return this.servicePodEvidenceInfo;
        }
    }

    public static class ServicePodEvidenceInfo {

        @SerializedName("service_pod_desc")
        private String servicePodDesc;

        @SerializedName("service_pod_evidence")
        private String servicePodEvidence;

        @SerializedName("service_pod_evidence_time")
        private long servicePodEvidenceTime;

        @SerializedName("service_pod_id")
        private String servicePodId;

        @SerializedName("service_pod_tlog")
        private JsonObject servicePodTlog;

        public ServicePodEvidenceInfo() {
        }

        public String getServicePodId() {
            return this.servicePodId;
        }

        public String getServicePodDesc() {
            return this.servicePodDesc;
        }

        public String getServicePodEvidence() {
            return this.servicePodEvidence;
        }

        public JsonObject getServicePodTlog() {
            return this.servicePodTlog;
        }

        public long getServicePodEvidenceTime() {
            return this.servicePodEvidenceTime;
        }
    }

    private QueryEvidenceResponse(String r1, Payload r2, String r3, String r4, String r5) {
        this.logId = r1;
        this.payload = r2;
        this.payloadBase64 = r3;
        this.responseId = r4;
        this.signature = r5;
    }

    public static QueryEvidenceResponse parse(String r7, String r8) throws Exception {
        JsonObject r9 = JsonParser.parseString(r7).getAsJsonObject();
        int r0 = r9.get(AlogMonitor.ALOG_RESULT_CODE).getAsInt();
        if (r0 != 0) goto L11;
        if (r9.has(ReportProtocal.KEY_LOG_ID) == false) goto L7;
        String r1 = r9.get(ReportProtocal.KEY_LOG_ID).getAsString();
    L8:
        String r2 = r1;
        JsonObject r10 = r9.getAsJsonObject("data");
        String r4 = r10.get("payload").getAsString();
        return new QueryEvidenceResponse(r2, (Payload) new Gson().fromJson(new String(Base64.decode(r4, 0), StandardCharsets.UTF_8), Payload.class), r4, r8, r10.get("signature").getAsString());
    L7:
        r1 = "";
        goto L8
    L11:
        throw new Exception("unexpected server code=" + r0);
    }

    public String getLogId() {
        return this.logId;
    }

    public List<ServicePodEvidenceInfo> getServicePodEvidenceInfo() {
        Payload r0 = this.payload;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getServicePodEvidenceInfo();
    }

    public String getPayloadBase64() {
        return this.payloadBase64;
    }

    public String getResponseId() {
        return this.responseId;
    }

    public String getSignature() {
        return this.signature;
    }
}
