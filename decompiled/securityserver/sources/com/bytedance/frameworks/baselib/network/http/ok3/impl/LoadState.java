package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: loaded from: classes.dex */
final enum LoadState extends Enum<LoadState> {
    private static final /* synthetic */ LoadState[] $VALUES = null;
    public static final LoadState CONNECTING = null;
    public static final LoadState DOWNLOADING_PAC_FILE = null;
    public static final LoadState ESTABLISHING_PROXY_TUNNEL = null;
    public static final LoadState IDLE = null;
    public static final LoadState READING_RESPONSE = null;
    public static final LoadState RESOLVING_HOST = null;
    public static final LoadState RESOLVING_HOST_IN_PAC_FILE = null;
    public static final LoadState RESOLVING_PROXY_FOR_URL = null;
    public static final LoadState SENDING_REQUEST = null;
    public static final LoadState SSL_HANDSHAKE = null;
    public static final LoadState WAITING_FOR_APPCACHE = null;
    public static final LoadState WAITING_FOR_AVAILABLE_SOCKET = null;
    public static final LoadState WAITING_FOR_CACHE = null;
    public static final LoadState WAITING_FOR_DELEGATE = null;
    public static final LoadState WAITING_FOR_RESPONSE = null;
    public static final LoadState WAITING_FOR_STALLED_SOCKET_POOL = null;

    static {
        LoadState r0 = new LoadState("IDLE", 0);
        IDLE = r0;
        LoadState r1 = new LoadState("WAITING_FOR_STALLED_SOCKET_POOL", 1);
        WAITING_FOR_STALLED_SOCKET_POOL = r1;
        LoadState r2 = new LoadState("WAITING_FOR_AVAILABLE_SOCKET", 2);
        WAITING_FOR_AVAILABLE_SOCKET = r2;
        LoadState r3 = new LoadState("WAITING_FOR_DELEGATE", 3);
        WAITING_FOR_DELEGATE = r3;
        LoadState r4 = new LoadState("WAITING_FOR_CACHE", 4);
        WAITING_FOR_CACHE = r4;
        LoadState r5 = new LoadState("WAITING_FOR_APPCACHE", 5);
        WAITING_FOR_APPCACHE = r5;
        LoadState r6 = new LoadState("DOWNLOADING_PAC_FILE", 6);
        DOWNLOADING_PAC_FILE = r6;
        LoadState r7 = new LoadState("RESOLVING_PROXY_FOR_URL", 7);
        RESOLVING_PROXY_FOR_URL = r7;
        LoadState r8 = new LoadState("RESOLVING_HOST_IN_PAC_FILE", 8);
        RESOLVING_HOST_IN_PAC_FILE = r8;
        LoadState r9 = new LoadState("ESTABLISHING_PROXY_TUNNEL", 9);
        ESTABLISHING_PROXY_TUNNEL = r9;
        LoadState r10 = new LoadState("RESOLVING_HOST", 10);
        RESOLVING_HOST = r10;
        LoadState r11 = new LoadState("CONNECTING", 11);
        CONNECTING = r11;
        LoadState r12 = new LoadState("SSL_HANDSHAKE", 12);
        SSL_HANDSHAKE = r12;
        LoadState r13 = new LoadState("SENDING_REQUEST", 13);
        SENDING_REQUEST = r13;
        LoadState r14 = new LoadState("WAITING_FOR_RESPONSE", 14);
        WAITING_FOR_RESPONSE = r14;
        LoadState r15 = new LoadState("READING_RESPONSE", 15);
        READING_RESPONSE = r15;
        $VALUES = new LoadState[]{r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15};
    }

    private LoadState(String r1, int r2) {
        super(r1, r2);
    }

    public static LoadState valueOf(String r1) {
        return (LoadState) Enum.valueOf(LoadState.class, r1);
    }

    public static LoadState[] values() {
        return (LoadState[]) $VALUES.clone();
    }
}
