package com.obric.netdetect.Modules.IpProbe;

import com.obric.netdetect.Utils.CodeConverter;

/* JADX INFO: loaded from: classes3.dex */
public class IpProbeResult {
    public static final int RESULT_IP_DETECT_AVAILABLE = 2;
    public static final int RESULT_IP_DETECT_CONFLICT = 3;
    public static final int RESULT_IP_DETECT_FAIL = 1;
    public String ip;
    public String mac;
    public int networkType;
    public int result;

    public IpProbeResult(int r1, int r2, String r3, String r4) {
        this.networkType = r1;
        this.result = r2;
        this.ip = r3;
        this.mac = r4;
    }

    public String toString() {
        return "IpProbeResult = {\n    NetworkType: " + CodeConverter.convertNetDetectType(this.networkType) + "\n    ProbeResult: " + CodeConverter.convertIpProbeResult(this.result) + "\n    ProbeIp: " + this.ip + "\n    ConflictMac: " + this.mac + "\n}";
    }
}
