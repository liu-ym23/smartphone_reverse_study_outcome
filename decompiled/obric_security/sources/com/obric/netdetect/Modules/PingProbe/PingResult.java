package com.obric.netdetect.Modules.PingProbe;

import com.obric.netdetect.Utils.CodeConverter;

/* JADX INFO: loaded from: classes3.dex */
public class PingResult {
    public static final int ERROR_CODE_HOST_IP_UNKNOWN = -8;
    public static final int ERROR_CODE_NETWORK_NOT_AVAILABLE = -6;
    public static final int ERROR_CODE_NOT_DEFAULT_NETWORK = -5;
    public static final int ERROR_CODE_NOT_SUPPORTED = -7;
    public static final int ERROR_CODE_RECV_FAIL = -3;
    public static final int ERROR_CODE_SEND_FAIL = -2;
    public static final int ERROR_CODE_SOCKET_FAIL = -1;
    public static final int ERROR_CODE_SUCCESS = 0;
    public static final int ERROR_CODE_TIMEOUT = -4;
    public static final int ERROR_CODE_UNKNOWN = -9;
    public static final int PING_RESULT_FAILED = 0;
    public static final int PING_RESULT_PARTIAL = 1;
    public static final int PING_RESULT_SUCCESS = 2;
    int avgRtt;
    int errorCode;
    String errorMsg;
    String hostIp;
    float lossRate;
    int maxRtt;
    int minRtt;
    int networkType;
    int pingResult;
    int receiveCount;
    int sendCount;

    public PingResult(int r1, String r2, int r3, int r4, int r5, float r6, int r7, int r8, int r9, int r10, String r11) {
        this.networkType = r1;
        this.hostIp = r2;
        this.pingResult = r3;
        this.sendCount = r4;
        this.receiveCount = r5;
        this.lossRate = r6;
        this.minRtt = r7;
        this.maxRtt = r8;
        this.avgRtt = r9;
        this.errorCode = r10;
        this.errorMsg = r11;
    }

    public static PingResult success(int r13, String r14, int r15, int r16, int r17, int r18, int r19) {
        return new PingResult(r13, r14, 2, r15, r16, 0.0f, r17, r18, r19, 0, null);
    }

    public static PingResult partial(int r13, String r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        return new PingResult(r13, r14, 1, r15, r16, (r15 - r16) / r15, r17, r18, r19, r20, CodeConverter.convertPingErrorCode(r20));
    }

    public static PingResult failed(int r13, String r14, int r15, int r16) {
        return new PingResult(r13, r14, 0, r15, 0, 100.0f, -1, -1, -1, r16, CodeConverter.convertPingErrorCode(r16));
    }

    public String toString() {
        return "PingResult = {\n    NetworkType: " + CodeConverter.convertNetDetectType(this.networkType) + "\n    PingResult: " + CodeConverter.convertPingResult(this.pingResult) + "\n    GatewayIp: " + this.hostIp + "\n    SendCount: " + this.sendCount + "\n    ReceiveCount: " + this.receiveCount + "\n    LossRate: " + this.lossRate + "\n    MinRtt: " + this.minRtt + "\n    MaxRtt: " + this.maxRtt + "\n    AvgRtt: " + this.avgRtt + "\n    ErrorCode: " + this.errorCode + "\n    ErrorMsg: " + this.errorMsg + "\n}";
    }
}
