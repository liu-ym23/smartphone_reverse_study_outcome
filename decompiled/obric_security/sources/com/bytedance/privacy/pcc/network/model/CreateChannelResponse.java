package com.bytedance.privacy.pcc.network.model;

import android.util.Base64;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CreateChannelResponse {
    private final Payload payload;
    private final String payloadBase64;
    private final String responseId;
    private final String signature;

    public static class EvidenceInfo {

        @SerializedName("evidence_detail")
        private String evidenceDetail;

        @SerializedName("evidence_extra")
        private String evidenceExtra;

        @SerializedName("evidence_token")
        private String evidenceToken;

        @SerializedName("evidence_version")
        private String evidenceVersion;

        public EvidenceInfo() {
        }

        public String getEvidenceVersion() {
            return this.evidenceVersion;
        }

        public String getEvidenceToken() {
            return this.evidenceToken;
        }

        public String getEvidenceDetail() {
            return this.evidenceDetail;
        }

        public String getEvidenceExtra() {
            return this.evidenceExtra;
        }

        public String toJsonString() {
            return new Gson().toJson(this);
        }

        public static EvidenceInfo fromJsonString(String r2) {
            return (EvidenceInfo) new Gson().fromJson(r2, EvidenceInfo.class);
        }
    }

    public static class Payload {

        @SerializedName("access_token")
        private String accessToken;

        @SerializedName("channel_expiry_time")
        private String channelExpiryTime;

        @SerializedName(WsConstants.KEY_CHANNEL_ID)
        private String channelId;

        @SerializedName("evidence_info")
        private EvidenceInfo evidenceInfo;

        @SerializedName("service_info")
        private ServiceInfo serviceInfo;

        static /* synthetic */ ServiceInfo access$000(Payload r0) {
            return r0.serviceInfo;
        }

        static /* synthetic */ EvidenceInfo access$100(Payload r0) {
            return r0.evidenceInfo;
        }

        static /* synthetic */ String access$200(Payload r0) {
            return r0.accessToken;
        }

        static /* synthetic */ String access$300(Payload r0) {
            return r0.channelId;
        }

        static /* synthetic */ String access$400(Payload r0) {
            return r0.channelExpiryTime;
        }

        Payload(ServiceInfo r1, EvidenceInfo r2, String r3, String r4, String r5) {
            this.serviceInfo = r1;
            this.evidenceInfo = r2;
            this.accessToken = r3;
            this.channelId = r4;
            this.channelExpiryTime = r5;
        }
    }

    public static class ServiceInfo {

        @SerializedName("app_id")
        private String appId;

        @SerializedName("app_svc_id")
        private String appSvcId;

        @SerializedName("app_svc_pod_list")
        private List<SvcPod> appSvcPodList;

        public ServiceInfo() {
        }

        public String getAppId() {
            return this.appId;
        }

        public String getAppSvcId() {
            return this.appSvcId;
        }

        public List<SvcPod> getAppSvcPodList() {
            return this.appSvcPodList;
        }

        public String toJsonString() {
            return new Gson().toJson(this);
        }

        public static ServiceInfo fromJsonString(String r2) {
            return (ServiceInfo) new Gson().fromJson(r2, ServiceInfo.class);
        }
    }

    public static class SvcPod {

        @SerializedName("svc_pod_id")
        private String svcPodId;

        @SerializedName("svc_pod_index")
        private int svcPodIndex;

        @SerializedName("svc_pod_key_type")
        private String svcPodKeyType;

        @SerializedName("svc_pod_key_version")
        private String svcPodKeyVersion;

        @SerializedName("svc_pod_pub_key")
        private String svcPodPubKey;

        public SvcPod() {
        }

        public String getSvcPodId() {
            return this.svcPodId;
        }

        public String getSvcPodKeyType() {
            return this.svcPodKeyType;
        }

        public String getSvcPodKeyVersion() {
            return this.svcPodKeyVersion;
        }

        public String getSvcPodPubKey() {
            return this.svcPodPubKey;
        }

        public int getSvcPodIndex() {
            return this.svcPodIndex;
        }
    }

    private CreateChannelResponse(Payload r1, String r2, String r3, String r4) {
        this.payload = r1;
        this.payloadBase64 = r2;
        this.responseId = r3;
        this.signature = r4;
    }

    public static CreateChannelResponse parse(String r4, String r5) throws Exception {
        JsonObject r6 = JsonParser.parseString(r4).getAsJsonObject();
        int r0 = r6.get(AlogMonitor.ALOG_RESULT_CODE).getAsInt();
        if (r0 != 0) goto L7;
        JsonObject r7 = r6.getAsJsonObject("data");
        String r1 = r7.get(WsConstants.KEY_PAYLOAD).getAsString();
        return new CreateChannelResponse((Payload) new Gson().fromJson(new String(Base64.decode(r1, 0), StandardCharsets.UTF_8), Payload.class), r1, r5, r7.get("signature").getAsString());
    L7:
        throw new Exception("unexpected server code=" + r0);
    }

    public static CreateChannelResponse fromDb(String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14) {
        EvidenceInfo r0 = null;
        if (r7 != null) goto L5;
    L7:
        ServiceInfo r2 = null;
    L8:
        if (r8 == null) goto L13;
        if (r8.isEmpty() == true) goto L13;
        r0 = EvidenceInfo.fromJsonString(r8);
    L13:
        return new CreateChannelResponse(new Payload(r2, r0, r9, r10, r11), r12, r13, r14);
    L5:
        if (r7.isEmpty() == true) goto L7;
        r2 = ServiceInfo.fromJsonString(r7);
        goto L8
    }

    public ServiceInfo getServiceInfo() {
        Payload r0 = this.payload;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Payload.access$000(r0);
    }

    public EvidenceInfo getEvidenceInfo() {
        Payload r0 = this.payload;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Payload.access$100(r0);
    }

    public String getAccessToken() {
        Payload r0 = this.payload;
        if (r0 != null) goto L7;
        return "";
    L7:
        return Payload.access$200(r0);
    }

    public String getChannelId() {
        Payload r0 = this.payload;
        if (r0 != null) goto L7;
        return "";
    L7:
        return Payload.access$300(r0);
    }

    public String getChannelExpiryTime() {
        Payload r0 = this.payload;
        if (r0 != null) goto L7;
        return "";
    L7:
        return Payload.access$400(r0);
    }

    public String getPayloadJson() {
        return this.payloadBase64;
    }

    public String getResponseId() {
        return this.responseId;
    }

    public String getSignature() {
        return this.signature;
    }
}
