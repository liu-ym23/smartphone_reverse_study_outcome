package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: compiled from: OkHttp3RequestLog.java */
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

    private LoadState(String r1, int r2) {
        super(r1, r2);
    }

    public static LoadState valueOf(String r1) {
        return (LoadState) Enum.valueOf(LoadState.class, r1);
    }

    public static LoadState[] values() {
        return (LoadState[]) $VALUES.clone();
    }

    static {
        LoadState r0 = new LoadState("IDLE", 0);
        IDLE = r0;
        LoadState r1 = new LoadState("WAITING_FOR_STALLED_SOCKET_POOL", 1);
        WAITING_FOR_STALLED_SOCKET_POOL = r1;
        LoadState r3 = new LoadState("WAITING_FOR_AVAILABLE_SOCKET", 2);
        WAITING_FOR_AVAILABLE_SOCKET = r3;
        LoadState r5 = new LoadState("WAITING_FOR_DELEGATE", 3);
        WAITING_FOR_DELEGATE = r5;
        LoadState r7 = new LoadState("WAITING_FOR_CACHE", 4);
        WAITING_FOR_CACHE = r7;
        LoadState r9 = new LoadState("WAITING_FOR_APPCACHE", 5);
        WAITING_FOR_APPCACHE = r9;
        LoadState r11 = new LoadState("DOWNLOADING_PAC_FILE", 6);
        DOWNLOADING_PAC_FILE = r11;
        LoadState r13 = new LoadState("RESOLVING_PROXY_FOR_URL", 7);
        RESOLVING_PROXY_FOR_URL = r13;
        LoadState r15 = new LoadState("RESOLVING_HOST_IN_PAC_FILE", 8);
        RESOLVING_HOST_IN_PAC_FILE = r15;
        LoadState r14 = new LoadState("ESTABLISHING_PROXY_TUNNEL", 9);
        ESTABLISHING_PROXY_TUNNEL = r14;
        LoadState r12 = new LoadState("RESOLVING_HOST", 10);
        RESOLVING_HOST = r12;
        LoadState r10 = new LoadState("CONNECTING", 11);
        CONNECTING = r10;
        LoadState r8 = new LoadState("SSL_HANDSHAKE", 12);
        SSL_HANDSHAKE = r8;
        LoadState r6 = new LoadState("SENDING_REQUEST", 13);
        SENDING_REQUEST = r6;
        LoadState r4 = new LoadState("WAITING_FOR_RESPONSE", 14);
        WAITING_FOR_RESPONSE = r4;
        LoadState r2 = new LoadState("READING_RESPONSE", 15);
        READING_RESPONSE = r2;
        $VALUES = new LoadState[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2};
    }
}
