package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.networkstackapplib.NetworkStackConstant;

/* JADX INFO: loaded from: classes.dex */
final enum Status extends Enum<Status> {
    private static final /* synthetic */ Status[] $VALUES = null;
    public static final Status CANCELED = null;
    public static final Status FAILED = null;
    public static final Status IO_PENDING = null;
    public static final Status SUCCESS = null;
    public static final Status UNKNOWN = null;

    static {
        Status r0 = new Status(NetworkStackConstant.UNKNOWN_TYPE, 0);
        UNKNOWN = r0;
        Status r1 = new Status("SUCCESS", 1);
        SUCCESS = r1;
        Status r2 = new Status("IO_PENDING", 2);
        IO_PENDING = r2;
        Status r3 = new Status("CANCELED", 3);
        CANCELED = r3;
        Status r4 = new Status("FAILED", 4);
        FAILED = r4;
        $VALUES = new Status[]{r0, r1, r2, r3, r4};
    }

    private Status(String r1, int r2) {
        super(r1, r2);
    }

    public static Status valueOf(String r1) {
        return (Status) Enum.valueOf(Status.class, r1);
    }

    public static Status[] values() {
        return (Status[]) $VALUES.clone();
    }
}
