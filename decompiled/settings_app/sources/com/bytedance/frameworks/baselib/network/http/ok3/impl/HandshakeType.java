package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: compiled from: OkHttp3RequestLog.java */
/* JADX INFO: loaded from: classes3.dex */
final enum HandshakeType extends Enum<HandshakeType> {
    private static final /* synthetic */ HandshakeType[] $VALUES = null;
    public static final HandshakeType HANDSHAKE_FULL = null;
    public static final HandshakeType HANDSHAKE_RESUME = null;
    public static final HandshakeType HANDSHAKE_UNKNOWN = null;

    private HandshakeType(String r1, int r2) {
        super(r1, r2);
    }

    public static HandshakeType valueOf(String r1) {
        return (HandshakeType) Enum.valueOf(HandshakeType.class, r1);
    }

    public static HandshakeType[] values() {
        return (HandshakeType[]) $VALUES.clone();
    }

    static {
        HandshakeType r0 = new HandshakeType("HANDSHAKE_UNKNOWN", 0);
        HANDSHAKE_UNKNOWN = r0;
        HandshakeType r1 = new HandshakeType("HANDSHAKE_RESUME", 1);
        HANDSHAKE_RESUME = r1;
        HandshakeType r3 = new HandshakeType("HANDSHAKE_FULL", 2);
        HANDSHAKE_FULL = r3;
        $VALUES = new HandshakeType[]{r0, r1, r3};
    }
}
