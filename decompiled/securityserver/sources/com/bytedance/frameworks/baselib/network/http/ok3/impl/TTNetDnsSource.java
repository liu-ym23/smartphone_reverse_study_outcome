package com.bytedance.frameworks.baselib.network.http.ok3.impl;

/* JADX INFO: loaded from: classes.dex */
final enum TTNetDnsSource extends Enum<TTNetDnsSource> {
    private static final /* synthetic */ TTNetDnsSource[] $VALUES = null;
    public static final TTNetDnsSource NOT_SET = null;
    public static final TTNetDnsSource SERVE_FROM_ASYNC_BATCH_PRELOAD = null;
    public static final TTNetDnsSource SERVE_FROM_BATCH_PRELOAD = null;
    public static final TTNetDnsSource SERVE_FROM_CACHE = null;
    public static final TTNetDnsSource SERVE_FROM_HARDCODE_HOSTS = null;
    public static final TTNetDnsSource SERVE_FROM_HTTP_DNS_JOB = null;
    public static final TTNetDnsSource SERVE_FROM_PREFER_ADDR = null;
    public static final TTNetDnsSource SERVE_FROM_PROC_DNS_JOB = null;
    final int mValue;

    static {
        TTNetDnsSource r0 = new TTNetDnsSource("NOT_SET", 0, 0);
        NOT_SET = r0;
        TTNetDnsSource r1 = new TTNetDnsSource("SERVE_FROM_CACHE", 1, 2);
        SERVE_FROM_CACHE = r1;
        TTNetDnsSource r2 = new TTNetDnsSource("SERVE_FROM_PREFER_ADDR", 2, 5);
        SERVE_FROM_PREFER_ADDR = r2;
        TTNetDnsSource r3 = new TTNetDnsSource("SERVE_FROM_HTTP_DNS_JOB", 3, 6);
        SERVE_FROM_HTTP_DNS_JOB = r3;
        TTNetDnsSource r4 = new TTNetDnsSource("SERVE_FROM_PROC_DNS_JOB", 4, 8);
        SERVE_FROM_PROC_DNS_JOB = r4;
        TTNetDnsSource r6 = new TTNetDnsSource("SERVE_FROM_HARDCODE_HOSTS", 5, 9);
        SERVE_FROM_HARDCODE_HOSTS = r6;
        TTNetDnsSource r8 = new TTNetDnsSource("SERVE_FROM_BATCH_PRELOAD", 6, 19);
        SERVE_FROM_BATCH_PRELOAD = r8;
        TTNetDnsSource r7 = new TTNetDnsSource("SERVE_FROM_ASYNC_BATCH_PRELOAD", 7, 20);
        SERVE_FROM_ASYNC_BATCH_PRELOAD = r7;
        $VALUES = new TTNetDnsSource[]{r0, r1, r2, r3, r4, r6, r8, r7};
    }

    private TTNetDnsSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.mValue = r3;
    }

    public static TTNetDnsSource valueOf(String r1) {
        return (TTNetDnsSource) Enum.valueOf(TTNetDnsSource.class, r1);
    }

    public static TTNetDnsSource[] values() {
        return (TTNetDnsSource[]) $VALUES.clone();
    }
}
