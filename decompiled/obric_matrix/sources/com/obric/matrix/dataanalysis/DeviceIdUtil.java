package com.obric.matrix.dataanalysis;

import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/obric/matrix/dataanalysis/DeviceIdUtil;", "", "()V", "deviceId", "", "getDeviceId", "()Ljava/lang/String;", "setDeviceId", "(Ljava/lang/String;)V", "installId", "getInstallId", "setInstallId", "dataanalysis_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeviceIdUtil {
    public static final DeviceIdUtil INSTANCE = null;
    private static String deviceId;
    private static String installId;

    static {
        INSTANCE = new DeviceIdUtil();
        deviceId = "";
        installId = "";
    }

    private DeviceIdUtil() {
    }

    public final String getDeviceId() {
        return deviceId;
    }

    public final String getInstallId() {
        return installId;
    }

    public final void setDeviceId(String r1) {
        o.f(r1, "<set-?>");
        deviceId = r1;
    }

    public final void setInstallId(String r1) {
        o.f(r1, "<set-?>");
        installId = r1;
    }
}
