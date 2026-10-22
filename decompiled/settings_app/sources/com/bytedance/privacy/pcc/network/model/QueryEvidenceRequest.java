package com.bytedance.privacy.pcc.network.model;

import com.bytedance.privacy.pcc.AppInfo;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class QueryEvidenceRequest {

    @SerializedName("att_cert_chain")
    private final String attCertChain;

    @SerializedName("payload")
    private final String payload;

    @SerializedName("signature")
    private final String signature;

    public static class Payload {

        @SerializedName("app_info")
        private final AppInfoPayload appInfo;

        @SerializedName("client_version")
        private final String clientVersion;

        @SerializedName("time_begin")
        private final long timeBegin;

        @SerializedName("time_end")
        private final long timeEnd;

        private static class AppInfoPayload {

            @SerializedName("app_id")
            private final String appId;

            @SerializedName("app_svc_id")
            private final String appSvcId;

            AppInfoPayload(String r1, String r2) {
                this.appId = r1;
                this.appSvcId = r2;
            }
        }

        public Payload(String r2, AppInfo r3, long r4, long r6) {
            this.clientVersion = r2;
            this.appInfo = new AppInfoPayload(r3.appId, r3.appSvcId);
            this.timeBegin = r4;
            this.timeEnd = r6;
        }

        public String toJsonString() {
            return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
        }

        public String toString() {
            return toJsonString();
        }
    }

    public QueryEvidenceRequest(String r1, String r2, String r3) {
        this.attCertChain = r1;
        this.payload = r2;
        this.signature = r3;
    }

    public String toJsonString() {
        return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
    }

    public String toString() {
        return toJsonString();
    }
}
