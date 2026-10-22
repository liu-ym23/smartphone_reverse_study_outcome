package com.ttnet.org.chromium.net.impl;

/* JADX INFO: loaded from: classes2.dex */
public class TTServiceInfo {
    public boolean connected;
    public int identity;
    public boolean lazy;
    public CronetFrontierClient.IServiceMessageReceiver listener;
    public ServicePriority priority;
    public boolean sequence;

    public static final enum ServicePriority extends Enum<ServicePriority> {
        private static final /* synthetic */ ServicePriority[] $VALUES = null;
        public static final ServicePriority High = null;
        public static final ServicePriority Low = null;
        public static final ServicePriority Medium = null;
        final int priority;

        static {
            ServicePriority r0 = new ServicePriority("Low", 0, 0);
            Low = r0;
            ServicePriority r1 = new ServicePriority("Medium", 1, 1);
            Medium = r1;
            ServicePriority r2 = new ServicePriority("High", 2, 2);
            High = r2;
            $VALUES = new ServicePriority[]{r0, r1, r2};
        }

        private ServicePriority(String r1, int r2, int r3) {
            super(r1, r2);
            this.priority = r3;
        }

        public static ServicePriority valueOf(String r1) {
            return (ServicePriority) Enum.valueOf(ServicePriority.class, r1);
        }

        public static ServicePriority[] values() {
            return (ServicePriority[]) $VALUES.clone();
        }

        public int getValue() {
            return this.priority;
        }
    }

    public TTServiceInfo(int r2, CronetFrontierClient.IServiceMessageReceiver r3) {
        this.sequence = true;
        this.priority = ServicePriority.Low;
        if (r2 <= 0) goto L10;
        if (r3 == null) goto L8;
        this.identity = r2;
        this.listener = r3;
        return;
    L8:
        throw new IllegalArgumentException("Service listener must not be null.");
    L10:
        throw new IllegalArgumentException("Service identity must be set greater than 0.");
    }
}
