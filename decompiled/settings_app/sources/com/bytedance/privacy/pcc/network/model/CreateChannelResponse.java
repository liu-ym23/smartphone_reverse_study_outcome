package com.bytedance.privacy.pcc.network.model;

import android.util.Base64;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.privacy.utils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public class CreateChannelResponse {
    private static final String TAG = "CreateChannelResponse";
    private final Payload payload;
    private final String payloadBase64;
    private final int protocolVersion;
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

        static /* synthetic */ EvidenceInfo access$200(Payload r0) {
            return r0.evidenceInfo;
        }

        static /* synthetic */ String access$300(Payload r0) {
            return r0.accessToken;
        }

        static /* synthetic */ String access$400(Payload r0) {
            return r0.channelId;
        }

        static /* synthetic */ String access$500(Payload r0) {
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

        @SerializedName("app_svc_key_info")
        private SvcKeyInfo appSvcKeyInfo;

        public ServiceInfo() {
        }

        static /* synthetic */ SvcKeyInfo access$100(ServiceInfo r0) {
            return r0.appSvcKeyInfo;
        }

        public String getAppId() {
            return this.appId;
        }

        public String getAppSvcId() {
            return this.appSvcId;
        }

        public SvcKeyInfo getAppSvcKeyInfo() {
            return this.appSvcKeyInfo;
        }

        public String toJsonString() {
            return new Gson().toJson(this);
        }

        public static ServiceInfo fromJsonString(String r2) {
            return (ServiceInfo) new Gson().fromJson(r2, ServiceInfo.class);
        }
    }

    public static class SvcKeyInfo {

        @SerializedName("svc_key_id")
        private String svcKeyId;

        @SerializedName("svc_key_type")
        private String svcKeyType;

        @SerializedName("svc_key_version")
        private String svcKeyVersion;

        @SerializedName("svc_pub_key")
        private String svcPubKey;

        public SvcKeyInfo() {
        }

        public String getSvcKeyType() {
            return this.svcKeyType;
        }

        public String getSvcKeyId() {
            return this.svcKeyId;
        }

        public String getSvcKeyVersion() {
            return this.svcKeyVersion;
        }

        public String getSvcPubKey() {
            return this.svcPubKey;
        }
    }

    static {
    }

    private CreateChannelResponse(Payload r1, String r2, String r3, String r4, int r5) {
        this.payload = r1;
        this.payloadBase64 = r2;
        this.responseId = r3;
        this.signature = r4;
        this.protocolVersion = r5;
    }

    public static CreateChannelResponse parse(String r7, String r8) throws Exception {
        JsonObject r9 = JsonParser.parseString(r7).getAsJsonObject();
        int r0 = r9.get(AlogMonitor.ALOG_RESULT_CODE).getAsInt();
        if (r0 != 0) goto L12;
        JsonObject r10 = r9.getAsJsonObject("data");
        String r3 = r10.get("payload").getAsString();
        Payload r2 = (Payload) new Gson().fromJson(new String(Base64.decode(r3, 0), StandardCharsets.UTF_8), Payload.class);
        if (Payload.access$000(r2) != null) goto L7;
    L8:
        LogUtils.w(TAG, "CreateChannelResponse: serviceInfo or appSvcKeyInfo is null");
    L10:
        return new CreateChannelResponse(r2, r3, r8, r10.get("signature").getAsString(), 2);
    L7:
        if (ServiceInfo.access$100(Payload.access$000(r2)) != null) goto L10;
    L12:
        throw new Exception("unexpected server code=" + r0);
    }

    public static CreateChannelResponse fromDb(String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, int r19) {
        EvidenceInfo r0 = null;
        if (r11 != null) goto L5;
    L7:
        ServiceInfo r3 = null;
    L8:
        if (r12 == null) goto L13;
        if (r12.isEmpty() == true) goto L13;
        r0 = EvidenceInfo.fromJsonString(r12);
    L13:
        return new CreateChannelResponse(new Payload(r3, r0, r13, r14, r15), r16, r17, r18, r19);
    L5:
        if (r11.isEmpty() == true) goto L7;
        r3 = ServiceInfo.fromJsonString(r11);
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
        return Payload.access$200(r0);
    }

    public String getAccessToken() {
        Payload r0 = this.payload;
        if (r0 != null) goto L7;
        return "";
    L7:
        return Payload.access$300(r0);
    }

    public String getChannelId() {
        Payload r0 = this.payload;
        if (r0 != null) goto L7;
        return "";
    L7:
        return Payload.access$400(r0);
    }

    public String getChannelExpiryTime() {
        Payload r0 = this.payload;
        if (r0 != null) goto L7;
        return "";
    L7:
        return Payload.access$500(r0);
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

    public int getProtocolVersion() {
        return this.protocolVersion;
    }
}
