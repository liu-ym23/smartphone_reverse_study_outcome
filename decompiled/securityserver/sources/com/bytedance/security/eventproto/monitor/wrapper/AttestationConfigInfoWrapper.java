package com.bytedance.security.eventproto.monitor.wrapper;

/* JADX INFO: loaded from: classes.dex */
public class AttestationConfigInfoWrapper {
    private Boolean addCustomInfo;
    private Boolean devHealthStatusRequired;
    private Boolean reqRpdid;
    private Boolean reqRpuid;
    private Boolean reqUdid;

    /* JADX INFO: renamed from: com.bytedance.security.eventproto.monitor.wrapper.AttestationConfigInfoWrapper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private final AttestationConfigInfoWrapper wrap;

        public Builder() {
            this.wrap = new AttestationConfigInfoWrapper(null);
        }

        public AttestationConfigInfoWrapper build() {
            return this.wrap;
        }

        public Builder setAddCustomInfo(boolean r2) {
            AttestationConfigInfoWrapper.access$402(this.wrap, Boolean.valueOf(r2));
            return this;
        }

        public Builder setDevHealthStatusRequired(boolean r2) {
            AttestationConfigInfoWrapper.access$502(this.wrap, Boolean.valueOf(r2));
            return this;
        }

        public Builder setReqRpdid(boolean r2) {
            AttestationConfigInfoWrapper.access$202(this.wrap, Boolean.valueOf(r2));
            return this;
        }

        public Builder setReqRpuid(boolean r2) {
            AttestationConfigInfoWrapper.access$302(this.wrap, Boolean.valueOf(r2));
            return this;
        }

        public Builder setReqUdid(boolean r2) {
            AttestationConfigInfoWrapper.access$102(this.wrap, Boolean.valueOf(r2));
            return this;
        }
    }

    private AttestationConfigInfoWrapper() {
    }

    public static /* synthetic */ Boolean access$102(AttestationConfigInfoWrapper r0, Boolean r1) {
        r0.reqUdid = r1;
        return r1;
    }

    public static /* synthetic */ Boolean access$202(AttestationConfigInfoWrapper r0, Boolean r1) {
        r0.reqRpdid = r1;
        return r1;
    }

    public static /* synthetic */ Boolean access$302(AttestationConfigInfoWrapper r0, Boolean r1) {
        r0.reqRpuid = r1;
        return r1;
    }

    public static /* synthetic */ Boolean access$402(AttestationConfigInfoWrapper r0, Boolean r1) {
        r0.addCustomInfo = r1;
        return r1;
    }

    public static /* synthetic */ Boolean access$502(AttestationConfigInfoWrapper r0, Boolean r1) {
        r0.devHealthStatusRequired = r1;
        return r1;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Boolean getAddCustomInfo() {
        return this.addCustomInfo;
    }

    public Boolean getDevHealthStatusRequired() {
        return this.devHealthStatusRequired;
    }

    public Boolean getReqRpdid() {
        return this.reqRpdid;
    }

    public Boolean getReqRpuid() {
        return this.reqRpuid;
    }

    public Boolean getReqUdid() {
        return this.reqUdid;
    }

    public /* synthetic */ AttestationConfigInfoWrapper(AnonymousClass1 r1) {
        this();
    }
}
