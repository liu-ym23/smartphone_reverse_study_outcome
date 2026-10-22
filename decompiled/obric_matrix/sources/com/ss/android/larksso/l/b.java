package com.ss.android.larksso.l;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f12048g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f12049h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b f12050i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b f12051j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ b[] f12052k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f12053f;

    static {
        b r0 = new b(WsConstants.KEY_CONNECTION_ERROR, 0, "ERROR");
        f12048g = r0;
        b r1 = new b("warn", 1, "WARN");
        f12049h = r1;
        b r3 = new b(LocationMonitorConst.INFO, 2, "INFO");
        f12050i = r3;
        b r5 = new b("debug", 3, "DEBUG");
        f12051j = r5;
        f12052k = new b[]{r0, r1, r3, r5};
    }

    private b(String r1, int r2, String r3) {
        super(r1, r2);
        this.f12053f = r3;
    }

    public static b valueOf(String r1) {
        return (b) Enum.valueOf(b.class, r1);
    }

    public static b[] values() {
        return (b[]) f12052k.clone();
    }

    public String a() {
        return this.f12053f;
    }
}
