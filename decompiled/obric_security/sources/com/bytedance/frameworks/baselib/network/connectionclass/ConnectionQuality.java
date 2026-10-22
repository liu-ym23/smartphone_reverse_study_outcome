package com.bytedance.frameworks.baselib.network.connectionclass;

import com.bytedance.networkstackapplib.NetworkStackConstant;

/* JADX INFO: loaded from: classes.dex */
public final enum ConnectionQuality extends Enum<ConnectionQuality> {
    private static final /* synthetic */ ConnectionQuality[] $VALUES = null;
    public static final ConnectionQuality EXCELLENT = null;
    public static final ConnectionQuality GOOD = null;
    public static final ConnectionQuality MODERATE = null;
    public static final ConnectionQuality POOR = null;
    public static final ConnectionQuality UNKNOWN = null;

    private ConnectionQuality(String r1, int r2) {
        super(r1, r2);
    }

    public static ConnectionQuality valueOf(String r1) {
        return (ConnectionQuality) Enum.valueOf(ConnectionQuality.class, r1);
    }

    public static ConnectionQuality[] values() {
        return (ConnectionQuality[]) $VALUES.clone();
    }

    static {
        ConnectionQuality r0 = new ConnectionQuality("POOR", 0);
        POOR = r0;
        ConnectionQuality r1 = new ConnectionQuality("MODERATE", 1);
        MODERATE = r1;
        ConnectionQuality r3 = new ConnectionQuality("GOOD", 2);
        GOOD = r3;
        ConnectionQuality r5 = new ConnectionQuality("EXCELLENT", 3);
        EXCELLENT = r5;
        ConnectionQuality r7 = new ConnectionQuality(NetworkStackConstant.UNKNOWN_TYPE, 4);
        UNKNOWN = r7;
        $VALUES = new ConnectionQuality[]{r0, r1, r3, r5, r7};
    }
}
