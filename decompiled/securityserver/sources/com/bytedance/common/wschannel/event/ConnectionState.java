package com.bytedance.common.wschannel.event;

import a.a;

/* JADX INFO: loaded from: classes.dex */
public final enum ConnectionState extends Enum<ConnectionState> {
    private static final /* synthetic */ ConnectionState[] $VALUES = null;
    public static final ConnectionState CONNECTED = null;
    public static final ConnectionState CONNECTING = null;
    public static final ConnectionState CONNECTION_UNKNOWN = null;
    public static final ConnectionState CONNECT_CLOSED = null;
    public static final ConnectionState CONNECT_FAILED = null;
    final int mTypeValue;

    static {
        ConnectionState r0 = new ConnectionState("CONNECTION_UNKNOWN", 0, 1);
        CONNECTION_UNKNOWN = r0;
        ConnectionState r1 = new ConnectionState("CONNECTING", 1, 2);
        CONNECTING = r1;
        ConnectionState r2 = new ConnectionState("CONNECT_FAILED", 2, 4);
        CONNECT_FAILED = r2;
        ConnectionState r3 = new ConnectionState("CONNECT_CLOSED", 3, 8);
        CONNECT_CLOSED = r3;
        ConnectionState r4 = new ConnectionState("CONNECTED", 4, 16);
        CONNECTED = r4;
        $VALUES = new ConnectionState[]{r0, r1, r2, r3, r4};
    }

    private ConnectionState(String r1, int r2, int r3) {
        super(r1, r2);
        this.mTypeValue = r3;
    }

    public static ConnectionState valueOf(String r1) {
        return (ConnectionState) Enum.valueOf(ConnectionState.class, r1);
    }

    public static ConnectionState[] values() {
        return (ConnectionState[]) $VALUES.clone();
    }

    public int getTypeValue() {
        return this.mTypeValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        return a.l(new StringBuilder("ConnectionState{State="), this.mTypeValue, '}');
    }
}
