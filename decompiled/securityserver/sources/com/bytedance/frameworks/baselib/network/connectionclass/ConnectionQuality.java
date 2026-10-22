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

    static {
        ConnectionQuality r0 = new ConnectionQuality("POOR", 0);
        POOR = r0;
        ConnectionQuality r1 = new ConnectionQuality("MODERATE", 1);
        MODERATE = r1;
        ConnectionQuality r2 = new ConnectionQuality("GOOD", 2);
        GOOD = r2;
        ConnectionQuality r3 = new ConnectionQuality("EXCELLENT", 3);
        EXCELLENT = r3;
        ConnectionQuality r4 = new ConnectionQuality(NetworkStackConstant.UNKNOWN_TYPE, 4);
        UNKNOWN = r4;
        $VALUES = new ConnectionQuality[]{r0, r1, r2, r3, r4};
    }

    private ConnectionQuality(String r1, int r2) {
        super(r1, r2);
    }

    public static ConnectionQuality valueOf(String r1) {
        return (ConnectionQuality) Enum.valueOf(ConnectionQuality.class, r1);
    }

    public static ConnectionQuality[] values() {
        return (ConnectionQuality[]) $VALUES.clone();
    }
}
