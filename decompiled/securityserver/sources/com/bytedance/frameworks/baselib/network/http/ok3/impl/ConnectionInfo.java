package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: loaded from: classes.dex */
final enum ConnectionInfo extends Enum<ConnectionInfo> {
    private static final /* synthetic */ ConnectionInfo[] $VALUES = null;
    public static final ConnectionInfo CONNECTION_INFO_DEPRECATED_SPDY3 = null;
    public static final ConnectionInfo CONNECTION_INFO_HTTP1_0 = null;
    public static final ConnectionInfo CONNECTION_INFO_HTTP1_1 = null;
    public static final ConnectionInfo CONNECTION_INFO_HTTP2 = null;
    public static final ConnectionInfo CONNECTION_INFO_QUIC_UNKNOWN_VERSION = null;
    public static final ConnectionInfo CONNECTION_INFO_UNKNOWN = null;
    final int mValue;

    static {
        ConnectionInfo r0 = new ConnectionInfo("CONNECTION_INFO_UNKNOWN", 0, 0);
        CONNECTION_INFO_UNKNOWN = r0;
        ConnectionInfo r1 = new ConnectionInfo("CONNECTION_INFO_HTTP1_1", 1, 1);
        CONNECTION_INFO_HTTP1_1 = r1;
        ConnectionInfo r2 = new ConnectionInfo("CONNECTION_INFO_DEPRECATED_SPDY3", 2, 3);
        CONNECTION_INFO_DEPRECATED_SPDY3 = r2;
        ConnectionInfo r3 = new ConnectionInfo("CONNECTION_INFO_HTTP2", 3, 4);
        CONNECTION_INFO_HTTP2 = r3;
        ConnectionInfo r4 = new ConnectionInfo("CONNECTION_INFO_QUIC_UNKNOWN_VERSION", 4, 5);
        CONNECTION_INFO_QUIC_UNKNOWN_VERSION = r4;
        ConnectionInfo r5 = new ConnectionInfo("CONNECTION_INFO_HTTP1_0", 5, 9);
        CONNECTION_INFO_HTTP1_0 = r5;
        $VALUES = new ConnectionInfo[]{r0, r1, r2, r3, r4, r5};
    }

    private ConnectionInfo(String r1, int r2, int r3) {
        super(r1, r2);
        this.mValue = r3;
    }

    public static ConnectionInfo valueOf(String r1) {
        return (ConnectionInfo) Enum.valueOf(ConnectionInfo.class, r1);
    }

    public static ConnectionInfo[] values() {
        return (ConnectionInfo[]) $VALUES.clone();
    }
}
