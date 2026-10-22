package com.bytedance.apm.data.pipeline;

import com.bytedance.networkstackapplib.NetworkStackConstant;

/* JADX INFO: loaded from: classes.dex */
public final enum NetSampleResult extends Enum<NetSampleResult> {
    private static final /* synthetic */ NetSampleResult[] $VALUES = null;
    public static final NetSampleResult HIT = null;
    public static final NetSampleResult NOT_HIT = null;
    public static final NetSampleResult UNKNOWN = null;

    static {
        NetSampleResult r0 = new NetSampleResult(NetworkStackConstant.UNKNOWN_TYPE, 0);
        UNKNOWN = r0;
        NetSampleResult r1 = new NetSampleResult("HIT", 1);
        HIT = r1;
        NetSampleResult r2 = new NetSampleResult("NOT_HIT", 2);
        NOT_HIT = r2;
        $VALUES = new NetSampleResult[]{r0, r1, r2};
    }

    private NetSampleResult(String r1, int r2) {
        super(r1, r2);
    }

    public static NetSampleResult valueOf(String r1) {
        return (NetSampleResult) Enum.valueOf(NetSampleResult.class, r1);
    }

    public static NetSampleResult[] values() {
        return (NetSampleResult[]) $VALUES.clone();
    }
}
