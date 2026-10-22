package com.bytedance.apm.config;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class EventConfig {
    private JSONObject category;
    private JSONObject extraLog;
    private boolean isUploadImmediate;
    private JSONObject metric;
    private String serviceName;
    private int status;

    /* JADX INFO: renamed from: com.bytedance.apm.config.EventConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private JSONObject category;
        private JSONObject extraLog;
        private boolean isUploadImmediate;
        private JSONObject metric;
        private String serviceName;
        private int status;

        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public static /* synthetic */ String access$100(Builder r0) {
            return r0.serviceName;
        }

        public static /* synthetic */ int access$200(Builder r0) {
            return r0.status;
        }

        public static /* synthetic */ JSONObject access$300(Builder r0) {
            return r0.category;
        }

        public static /* synthetic */ JSONObject access$400(Builder r0) {
            return r0.metric;
        }

        public static /* synthetic */ JSONObject access$500(Builder r0) {
            return r0.extraLog;
        }

        public static /* synthetic */ boolean access$600(Builder r0) {
            return r0.isUploadImmediate;
        }

        public EventConfig build() {
            return new EventConfig(this);
        }

        public Builder isUploadImmediate(boolean r1) {
            this.isUploadImmediate = r1;
            return this;
        }

        public Builder setCategory(JSONObject r1) {
            this.category = r1;
            return this;
        }

        public Builder setExtraLog(JSONObject r1) {
            this.extraLog = r1;
            return this;
        }

        public Builder setMetric(JSONObject r1) {
            this.metric = r1;
            return this;
        }

        public Builder setServiceName(String r1) {
            this.serviceName = r1;
            return this;
        }

        public Builder setStatus(int r1) {
            this.status = r1;
            return this;
        }

        private Builder() {
        }
    }

    public EventConfig(Builder r2) {
        this.serviceName = Builder.access$100(r2);
        this.status = Builder.access$200(r2);
        this.category = Builder.access$300(r2);
        this.metric = Builder.access$400(r2);
        this.extraLog = Builder.access$500(r2);
        this.isUploadImmediate = Builder.access$600(r2);
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public JSONObject getCategory() {
        return this.category;
    }

    public JSONObject getExtraLog() {
        return this.extraLog;
    }

    public JSONObject getMetric() {
        return this.metric;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public int getStatus() {
        return this.status;
    }

    public boolean isUploadImmediate() {
        return this.isUploadImmediate;
    }
}
