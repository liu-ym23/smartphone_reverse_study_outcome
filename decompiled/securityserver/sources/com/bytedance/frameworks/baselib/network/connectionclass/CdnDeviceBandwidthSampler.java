package com.bytedance.frameworks.baselib.network.connectionclass;

/* JADX INFO: loaded from: classes.dex */
public class CdnDeviceBandwidthSampler extends DeviceBandwidthSampler {

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.connectionclass.CdnDeviceBandwidthSampler$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class CdnDeviceBandwidthSamplerHolder {
        public static final CdnDeviceBandwidthSampler instance = null;

        static {
            instance = new CdnDeviceBandwidthSampler(CdnConnectionClassManager.getInstance(), null);
        }

        private CdnDeviceBandwidthSamplerHolder() {
        }
    }

    public /* synthetic */ CdnDeviceBandwidthSampler(CdnConnectionClassManager r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static CdnDeviceBandwidthSampler getInstance() {
        return CdnDeviceBandwidthSamplerHolder.instance;
    }

    private CdnDeviceBandwidthSampler(CdnConnectionClassManager r1) {
        super(r1);
    }
}
